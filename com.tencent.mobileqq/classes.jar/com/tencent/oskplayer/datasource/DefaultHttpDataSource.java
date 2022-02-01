package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class DefaultHttpDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 30000;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 12000;
  private static final int MAX_REDIRECTS = 20;
  private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference();
  protected String TAG = "DefaultHttpDataSource";
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  private HttpURLConnection connection;
  private long contentLength = -1L;
  private String contentType;
  private final Fixer<Map<String, List<String>>> contentTypeFixer;
  private final Predicate<String> contentTypePredicate;
  private DataSpec dataSpec;
  protected String extraLogTag = "";
  private InputStream inputStream;
  private final TransferListener listener;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HashMap<String, String> requestProperties;
  private long totalLength = -1L;
  private final String userAgent;
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, int paramInt1, int paramInt2, Fixer<Map<String, List<String>>> paramFixer)
  {
    this(paramString, paramPredicate, paramTransferListener, paramInt1, paramInt2, false, paramFixer);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean, Fixer<Map<String, List<String>>> paramFixer)
  {
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.listener = paramTransferListener;
    this.requestProperties = new HashMap();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.contentTypeFixer = paramFixer;
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, Fixer<Map<String, List<String>>> paramFixer)
  {
    this(paramString, paramPredicate, paramTransferListener, 30000, 12000, paramFixer);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, Fixer<Map<String, List<String>>> paramFixer)
  {
    this(paramString, paramPredicate, null, paramFixer);
  }
  
  private void closeConnection()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection != null)
    {
      localHttpURLConnection.disconnect();
      this.connection = null;
    }
  }
  
  private HttpURLConnection configureConnection(URL paramURL, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramURL.getProtocol().startsWith("https"))
    {
      if (PlayerUtils.shouldByPassProxySetting(paramURL)) {
        localObject1 = (HttpsURLConnection)paramURL.openConnection(Proxy.NO_PROXY);
      } else {
        localObject1 = (HttpsURLConnection)paramURL.openConnection();
      }
    }
    else if (PlayerUtils.shouldByPassProxySetting(paramURL)) {
      localObject1 = (HttpURLConnection)paramURL.openConnection(Proxy.NO_PROXY);
    } else {
      localObject1 = (HttpURLConnection)paramURL.openConnection();
    }
    ((HttpURLConnection)localObject1).setConnectTimeout(this.connectTimeoutMillis);
    ((HttpURLConnection)localObject1).setReadTimeout(this.readTimeoutMillis);
    ((HttpURLConnection)localObject1).setDoOutput(false);
    synchronized (this.requestProperties)
    {
      Object localObject3 = this.requestProperties.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((HttpURLConnection)localObject1).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if ((paramLong1 != 0L) || (paramLong2 != -1L))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("bytes=");
        ((StringBuilder)???).append(paramLong1);
        ((StringBuilder)???).append("-");
        localObject3 = ((StringBuilder)???).toString();
        ??? = localObject3;
        if (paramLong2 != -1L)
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append((String)localObject3);
          ((StringBuilder)???).append(paramLong1 + paramLong2 - 1L);
          ??? = ((StringBuilder)???).toString();
        }
        ((HttpURLConnection)localObject1).setRequestProperty("Range", (String)???);
      }
      ((HttpURLConnection)localObject1).setRequestProperty("User-Agent", this.userAgent);
      if (!paramBoolean) {
        ((HttpURLConnection)localObject1).setRequestProperty("Accept-Encoding", "identity");
      }
      ??? = getLogTag();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("send upstream request: \r\n");
      ((StringBuilder)localObject3).append(((HttpURLConnection)localObject1).getRequestMethod());
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(paramURL);
      ((StringBuilder)localObject3).append("\r\n");
      ((StringBuilder)localObject3).append(HttpParser.getHeaders(((HttpURLConnection)localObject1).getRequestProperties()));
      PlayerUtils.log(4, (String)???, PlayerUtils.removeLineBreaks(((StringBuilder)localObject3).toString(), null));
      return localObject1;
    }
    for (;;)
    {
      throw paramURL;
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    Object localObject1 = paramHttpURLConnection.getHeaderField("Content-Length");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      l1 = Long.parseLong((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      long l1;
      label26:
      Object localObject2;
      break label26;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Unexpected Content-Length [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    PlayerUtils.log(6, paramString, ((StringBuilder)localObject2).toString());
    l1 = -1L;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      localObject2 = CONTENT_RANGE_HEADER.matcher(paramHttpURLConnection);
      if (!((Matcher)localObject2).find()) {}
    }
    try
    {
      long l2 = Long.parseLong(((Matcher)localObject2).group(2)) - Long.parseLong(((Matcher)localObject2).group(1)) + 1L;
      if (l1 < 0L) {
        return l2;
      }
      if (l1 == l2) {
        break label264;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Inconsistent headers [");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] [");
      ((StringBuilder)localObject2).append(paramHttpURLConnection);
      ((StringBuilder)localObject2).append("]");
      PlayerUtils.log(5, paramString, ((StringBuilder)localObject2).toString());
      l2 = Math.max(l1, l2);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label219:
      break label219;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected Content-Range [");
    ((StringBuilder)localObject1).append(paramHttpURLConnection);
    ((StringBuilder)localObject1).append("]");
    PlayerUtils.log(6, paramString, ((StringBuilder)localObject1).toString());
    label264:
    return l1;
  }
  
  private static long getTotalLength(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    Object localObject = paramHttpURLConnection.getHeaderField("Content-Length");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    long l3 = -1L;
    if (!bool) {}
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      long l2;
      label34:
      StringBuilder localStringBuilder;
      long l1;
      break label34;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected Content-Length [");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    PlayerUtils.log(6, paramString, localStringBuilder.toString());
    l2 = -1L;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
    l1 = l2;
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      localObject = CONTENT_RANGE_HEADER.matcher(paramHttpURLConnection);
      l1 = l3;
      if (!((Matcher)localObject).find()) {}
    }
    try
    {
      long l4 = Long.parseLong(((Matcher)localObject).group(3));
      if (l2 < 0L)
      {
        l1 = l4;
      }
      else
      {
        l1 = l3;
        if (l2 != -1L) {
          l1 = Math.max(l2, l4);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label170:
      break label170;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected Content-Range [");
    ((StringBuilder)localObject).append(paramHttpURLConnection);
    ((StringBuilder)localObject).append("]");
    PlayerUtils.log(6, paramString, ((StringBuilder)localObject).toString());
    l1 = l3;
    return l1;
  }
  
  public static URL handleRedirect(URL paramURL, String paramString)
  {
    if (paramString != null)
    {
      if (URLUtil.isNetworkUrl(paramString)) {
        paramURL = new URL(paramString);
      } else {
        paramURL = new URL(paramURL, paramString);
      }
      paramString = paramURL.getProtocol();
      if (!"https".equals(paramString))
      {
        if ("http".equals(paramString)) {
          return paramURL;
        }
        paramURL = new StringBuilder();
        paramURL.append("Unsupported protocol redirect: ");
        paramURL.append(paramString);
        throw new ProtocolException(paramURL.toString());
      }
      return paramURL;
    }
    throw new ProtocolException("Null location redirect");
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    localObject1 = new URL(paramDataSpec.uri.toString());
    long l2 = paramDataSpec.position;
    long l3 = paramDataSpec.length;
    boolean bool;
    if ((paramDataSpec.flags & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!this.allowCrossProtocolRedirects) {
      return configureConnection((URL)localObject1, l2, l3, bool);
    }
    PlayerUtils.getVideoUuidFromVideoUrl(((URL)localObject1).toExternalForm());
    long l1 = System.currentTimeMillis();
    localObject2 = new ArrayList();
    int j = 0;
    int i = 0;
    for (;;)
    {
      k = j + 1;
      if (j > 20) {
        break label771;
      }
      Object localObject3 = configureConnection((URL)localObject1, l2, l3, bool);
      ((HttpURLConnection)localObject3).setInstanceFollowRedirects(false);
      ((HttpURLConnection)localObject3).connect();
      try
      {
        localObject4 = ThreadUtils.submitTask(new DefaultHttpDataSource.GetResponseCodeCallable((HttpURLConnection)localObject3), this.readTimeoutMillis, true, "GetResponseCodeCallable", getLogTag());
        if (localObject4 != null)
        {
          j = ((Integer)localObject4).intValue();
          if ((j != 300) && (j != 301) && (j != 302) && (j != 303) && (j != 307) && (j != 308))
          {
            if ((i > 0) && (PlayerConfig.g().getVideoReporter() != null))
            {
              l2 = System.currentTimeMillis();
              PlayerConfig.g().getVideoReporter().urlRedirectOccurred(paramDataSpec.uuid, PlayerUtils.join((List)localObject2), l2 - l1, i);
            }
            try
            {
              if ((PlayerConfig.g().isServerIPWithGetByName()) && (PlayerConfig.g().getVideoReporter() != null) && (paramDataSpec.priority == 90))
              {
                localObject1 = ((URL)localObject1).getHost();
                localObject2 = InetAddress.getByName((String)localObject1).getHostAddress();
                PlayerConfig.g().getVideoReporter().downloadServerIp(paramDataSpec.uuid, (String)localObject2);
                paramDataSpec = getLogTag();
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("host:");
                ((StringBuilder)localObject4).append((String)localObject1);
                ((StringBuilder)localObject4).append(",ip:");
                ((StringBuilder)localObject4).append((String)localObject2);
                PlayerUtils.log(4, paramDataSpec, ((StringBuilder)localObject4).toString());
                return localObject3;
              }
            }
            catch (Exception paramDataSpec)
            {
              PlayerUtils.log(5, getLogTag(), "getIpError", paramDataSpec);
            }
            return localObject3;
          }
          i += 1;
          localObject4 = ((HttpURLConnection)localObject3).getHeaderField("Location");
        }
      }
      catch (ExecutionException paramDataSpec)
      {
        Object localObject4;
        Object localObject5;
        StringBuilder localStringBuilder;
        localObject1 = getLogTag();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetResponseCodeCallable ExecutionException ");
        ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(paramDataSpec));
        PlayerUtils.log(5, (String)localObject1, ((StringBuilder)localObject2).toString());
        throw new HttpDataSource.InterruptConnectServerException("Failed To Execute GetResponseCodeCallable", getDataSpec());
        Thread.currentThread().interrupt();
        PlayerUtils.log(4, getLogTag(), "GetResponseCodeCallable Interrupted");
        throw new HttpDataSource.InterruptConnectServerException("GetResponseCodeCallable interrupted", getDataSpec());
        paramDataSpec = new StringBuilder();
        paramDataSpec.append("Too many redirects: ");
        paramDataSpec.append(k);
        paramDataSpec = new NoRouteToHostException(paramDataSpec.toString());
        for (;;)
        {
          throw paramDataSpec;
        }
      }
      catch (InterruptedException paramDataSpec)
      {
        label436:
        break label739;
      }
      try
      {
        localObject5 = new URL((String)localObject4).getHost();
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        break label436;
      }
      try
      {
        ((ArrayList)localObject2).add(localObject5);
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        break label436;
      }
      localObject5 = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MalformedURLException url=");
      localStringBuilder.append((String)localObject4);
      PlayerUtils.log(5, (String)localObject5, localStringBuilder.toString());
      ((HttpURLConnection)localObject3).disconnect();
      localObject3 = handleRedirect((URL)localObject1, (String)localObject4);
      localObject4 = getLogTag();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("redirect to url=");
      ((StringBuilder)localObject5).append(((URL)localObject3).toString());
      ((StringBuilder)localObject5).append(", fromUrl=");
      ((StringBuilder)localObject5).append(localObject1);
      PlayerUtils.log(2, (String)localObject4, ((StringBuilder)localObject5).toString());
      j = k;
      localObject1 = localObject3;
    }
    closeConnection();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getResponseCode TimeoutException Unable to connect to ");
    ((StringBuilder)localObject1).append(paramDataSpec.uri.toString());
    ((StringBuilder)localObject1).append(" within ");
    ((StringBuilder)localObject1).append(this.readTimeoutMillis);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getResponseCode Timeout ");
    ((StringBuilder)localObject2).append(this.readTimeoutMillis);
    throw new HttpDataSource.UnableConnectServerException((String)localObject1, new IOException(((StringBuilder)localObject2).toString()), paramDataSpec);
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.bytesToRead;
    if (l != -1L) {
      paramInt2 = (int)Math.min(paramInt2, l - this.bytesRead);
    }
    if (paramInt2 == 0) {
      return -1;
    }
    paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1)
    {
      l = this.bytesToRead;
      if (l != -1L)
      {
        if (l == this.bytesRead) {
          return -1;
        }
        throw new EOFException();
      }
      return -1;
    }
    this.bytesRead += paramInt1;
    paramArrayOfByte = this.listener;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.onBytesTransferred(paramInt1);
    }
    return paramInt1;
  }
  
  private void skipInternal()
  {
    if (this.bytesSkipped == this.bytesToSkip) {
      return;
    }
    Object localObject2 = (byte[])skipBufferReference.getAndSet(null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4096];
    }
    localObject2 = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes skipped ");
    localStringBuilder.append(this.bytesSkipped);
    localStringBuilder.append(", bytesToSkip ");
    localStringBuilder.append(this.bytesToSkip);
    Log.d((String)localObject2, localStringBuilder.toString());
    for (;;)
    {
      long l1 = this.bytesSkipped;
      long l2 = this.bytesToSkip;
      if (l1 == l2) {
        break label317;
      }
      int i = (int)Math.min(l2 - l1, localObject1.length);
      localObject2 = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("request skip ");
      localStringBuilder.append(i);
      localStringBuilder.append(" bytes");
      Log.d((String)localObject2, localStringBuilder.toString());
      i = this.inputStream.read((byte[])localObject1, 0, i);
      localObject2 = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("actual skip ");
      localStringBuilder.append(i);
      localStringBuilder.append(" bytes");
      Log.d((String)localObject2, localStringBuilder.toString());
      if (Thread.interrupted()) {
        break label302;
      }
      if (i == -1) {
        break;
      }
      this.bytesSkipped += i;
      localObject2 = this.listener;
      if (localObject2 != null) {
        ((TransferListener)localObject2).onBytesTransferred(i);
      }
    }
    throw new EOFException();
    label302:
    throw new HttpDataSource.InterruptReadException("skipInternal interrupted", getDataSpec());
    label317:
    skipBufferReference.set(localObject1);
  }
  
  public long available()
  {
    return this.contentLength;
  }
  
  protected final long bytesRead()
  {
    return this.bytesRead;
  }
  
  protected final long bytesRemaining()
  {
    long l = this.bytesToRead;
    if (l == -1L) {
      return l;
    }
    return l - this.bytesRead;
  }
  
  protected final long bytesSkipped()
  {
    return this.bytesSkipped;
  }
  
  public void clearAllRequestProperties()
  {
    synchronized (this.requestProperties)
    {
      this.requestProperties.clear();
      return;
    }
  }
  
  public void clearRequestProperty(String paramString)
  {
    Assertions.checkNotNull(paramString);
    synchronized (this.requestProperties)
    {
      this.requestProperties.remove(paramString);
      return;
    }
  }
  
  public void close()
  {
    try
    {
      if (this.inputStream != null)
      {
        Util.maybeTerminateInputStream(this.connection, bytesRemaining());
        try
        {
          this.inputStream.close();
          this.inputStream = null;
        }
        catch (IOException localIOException)
        {
          throw new HttpDataSource.HttpDataSourceException(localIOException, this.dataSpec);
        }
      }
      TransferListener localTransferListener1;
      return;
    }
    finally
    {
      if (this.opened)
      {
        this.opened = false;
        TransferListener localTransferListener2 = this.listener;
        if (localTransferListener2 != null) {
          localTransferListener2.onTransferEnd();
        }
      }
      closeConnection();
    }
  }
  
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public Predicate<String> getContentPredicator()
  {
    return this.contentTypePredicate;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public DataSpec getDataSpec()
  {
    return this.dataSpec;
  }
  
  public FileType getFileType()
  {
    return FileType.getFileType(getContentType());
  }
  
  public String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append(this.TAG);
    return localStringBuilder.toString();
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    Object localObject1 = this.connection;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((HttpURLConnection)localObject1).getHeaderFields();
    }
    Fixer localFixer = this.contentTypeFixer;
    Object localObject2 = localObject1;
    if (localFixer != null) {
      localObject2 = (Map)localFixer.fix(localObject1);
    }
    return localObject2;
  }
  
  public long getTotalLength()
  {
    return this.totalLength;
  }
  
  public String getUri()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection == null) {
      return null;
    }
    return localHttpURLConnection.getURL().toString();
  }
  
  public long open(DataSpec paramDataSpec)
  {
    return open(paramDataSpec, null);
  }
  
  /* Error */
  public long open(DataSpec paramDataSpec, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 634	com/tencent/oskplayer/datasource/DefaultHttpDataSource:dataSpec	Lcom/tencent/oskplayer/datasource/DataSpec;
    //   5: lconst_0
    //   6: lstore 6
    //   8: aload_0
    //   9: lconst_0
    //   10: putfield 549	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesRead	J
    //   13: aload_0
    //   14: lconst_0
    //   15: putfield 570	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesSkipped	J
    //   18: aload_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 695	com/tencent/oskplayer/datasource/DefaultHttpDataSource:makeConnection	(Lcom/tencent/oskplayer/datasource/DataSpec;)Ljava/net/HttpURLConnection;
    //   24: putfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   27: aload_2
    //   28: ifnull +173 -> 201
    //   31: aload_0
    //   32: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   35: aload_2
    //   36: invokevirtual 698	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: goto +162 -> 201
    //   42: astore_2
    //   43: aload_0
    //   44: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   47: astore 8
    //   49: new 217	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   56: astore 9
    //   58: aload 9
    //   60: ldc_w 700
    //   63: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: aload_1
    //   70: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   73: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   76: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: bipush 6
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aload_2
    //   90: invokestatic 475	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: goto +108 -> 201
    //   96: astore_2
    //   97: aload_0
    //   98: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   101: astore 8
    //   103: new 217	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   110: astore 9
    //   112: aload 9
    //   114: ldc_w 702
    //   117: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 9
    //   123: aload_1
    //   124: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   127: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   130: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: bipush 6
    //   136: aload 8
    //   138: aload 9
    //   140: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aload_2
    //   144: invokestatic 475	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: goto +54 -> 201
    //   150: astore_2
    //   151: aload_0
    //   152: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   155: astore 8
    //   157: new 217	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   164: astore 9
    //   166: aload 9
    //   168: ldc_w 704
    //   171: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 9
    //   177: aload_1
    //   178: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   181: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   184: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: bipush 6
    //   190: aload 8
    //   192: aload 9
    //   194: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload_2
    //   198: invokestatic 475	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   205: invokevirtual 707	java/net/HttpURLConnection:getResponseCode	()I
    //   208: istore_3
    //   209: aload_0
    //   210: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   213: astore_2
    //   214: new 217	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   221: astore 8
    //   223: aload 8
    //   225: ldc_w 709
    //   228: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 8
    //   234: aload_1
    //   235: invokevirtual 710	com/tencent/oskplayer/datasource/DataSpec:toString	()Ljava/lang/String;
    //   238: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 8
    //   244: ldc_w 712
    //   247: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 8
    //   253: aload_0
    //   254: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   257: invokevirtual 663	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   260: invokestatic 265	com/tencent/oskplayer/util/HttpParser:getHeaders	(Ljava/util/Map;)Ljava/lang/String;
    //   263: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: iconst_4
    //   268: aload_2
    //   269: aload 8
    //   271: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aconst_null
    //   275: invokestatic 269	com/tencent/oskplayer/util/PlayerUtils:removeLineBreaks	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   281: iload_3
    //   282: sipush 200
    //   285: if_icmplt +306 -> 591
    //   288: iload_3
    //   289: sipush 299
    //   292: if_icmpgt +299 -> 591
    //   295: aload_0
    //   296: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   299: invokevirtual 713	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   302: astore_2
    //   303: aload_0
    //   304: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   307: invokevirtual 663	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   310: astore 8
    //   312: aload_0
    //   313: getfield 103	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/oskplayer/util/Predicate;
    //   316: astore 9
    //   318: aload 9
    //   320: ifnull +33 -> 353
    //   323: aload 9
    //   325: aload_2
    //   326: invokeinterface 718 2 0
    //   331: ifeq +6 -> 337
    //   334: goto +19 -> 353
    //   337: aload_0
    //   338: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   341: new 720	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException
    //   344: dup
    //   345: aload_2
    //   346: aload 8
    //   348: aload_1
    //   349: invokespecial 723	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Ljava/util/Map;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   352: athrow
    //   353: aload_0
    //   354: aload_2
    //   355: putfield 650	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentType	Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 118	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentTypeFixer	Lcom/tencent/oskplayer/util/Fixer;
    //   362: astore_2
    //   363: aload_2
    //   364: ifnull +18 -> 382
    //   367: aload_0
    //   368: aload_2
    //   369: checkcast 725	com/tencent/oskplayer/util/ContentTypeFixer
    //   372: aload_0
    //   373: getfield 650	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentType	Ljava/lang/String;
    //   376: invokevirtual 727	com/tencent/oskplayer/util/ContentTypeFixer:fix	(Ljava/lang/String;)Ljava/lang/String;
    //   379: putfield 650	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentType	Ljava/lang/String;
    //   382: lload 6
    //   384: lstore 4
    //   386: iload_3
    //   387: sipush 200
    //   390: if_icmpne +22 -> 412
    //   393: lload 6
    //   395: lstore 4
    //   397: aload_1
    //   398: getfield 374	com/tencent/oskplayer/datasource/DataSpec:position	J
    //   401: lconst_0
    //   402: lcmp
    //   403: ifeq +9 -> 412
    //   406: aload_1
    //   407: getfield 374	com/tencent/oskplayer/datasource/DataSpec:position	J
    //   410: lstore 4
    //   412: aload_0
    //   413: lload 4
    //   415: putfield 572	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesToSkip	J
    //   418: aload_1
    //   419: getfield 380	com/tencent/oskplayer/datasource/DataSpec:flags	I
    //   422: istore_3
    //   423: ldc2_w 84
    //   426: lstore 4
    //   428: iload_3
    //   429: iconst_1
    //   430: iand
    //   431: ifne +86 -> 517
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   439: aload_0
    //   440: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   443: invokestatic 729	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;Ljava/lang/String;)J
    //   446: putfield 87	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentLength	J
    //   449: aload_0
    //   450: aload_0
    //   451: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   454: aload_0
    //   455: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   458: invokestatic 731	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getTotalLength	(Ljava/net/HttpURLConnection;Ljava/lang/String;)J
    //   461: putfield 89	com/tencent/oskplayer/datasource/DefaultHttpDataSource:totalLength	J
    //   464: aload_1
    //   465: getfield 377	com/tencent/oskplayer/datasource/DataSpec:length	J
    //   468: ldc2_w 84
    //   471: lcmp
    //   472: ifeq +12 -> 484
    //   475: aload_1
    //   476: getfield 377	com/tencent/oskplayer/datasource/DataSpec:length	J
    //   479: lstore 4
    //   481: goto +27 -> 508
    //   484: aload_0
    //   485: getfield 87	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentLength	J
    //   488: lstore 6
    //   490: lload 6
    //   492: ldc2_w 84
    //   495: lcmp
    //   496: ifeq +12 -> 508
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 572	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesToSkip	J
    //   505: lsub
    //   506: lstore 4
    //   508: aload_0
    //   509: lload 4
    //   511: putfield 547	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesToRead	J
    //   514: goto +26 -> 540
    //   517: aload_0
    //   518: aload_1
    //   519: getfield 377	com/tencent/oskplayer/datasource/DataSpec:length	J
    //   522: putfield 547	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesToRead	J
    //   525: aload_0
    //   526: aload_1
    //   527: getfield 377	com/tencent/oskplayer/datasource/DataSpec:length	J
    //   530: putfield 87	com/tencent/oskplayer/datasource/DefaultHttpDataSource:contentLength	J
    //   533: aload_0
    //   534: ldc2_w 84
    //   537: putfield 89	com/tencent/oskplayer/datasource/DefaultHttpDataSource:totalLength	J
    //   540: aload_0
    //   541: aload_0
    //   542: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   545: invokevirtual 735	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   548: putfield 554	com/tencent/oskplayer/datasource/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   551: aload_0
    //   552: iconst_1
    //   553: putfield 639	com/tencent/oskplayer/datasource/DefaultHttpDataSource:opened	Z
    //   556: aload_0
    //   557: getfield 105	com/tencent/oskplayer/datasource/DefaultHttpDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   560: astore_1
    //   561: aload_1
    //   562: ifnull +9 -> 571
    //   565: aload_1
    //   566: invokeinterface 738 1 0
    //   571: aload_0
    //   572: getfield 547	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesToRead	J
    //   575: lreturn
    //   576: astore_2
    //   577: aload_0
    //   578: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   581: new 632	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   584: dup
    //   585: aload_2
    //   586: aload_1
    //   587: invokespecial 637	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   590: athrow
    //   591: aload_0
    //   592: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   595: invokevirtual 663	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   598: astore_2
    //   599: aload_0
    //   600: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   603: new 740	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException
    //   606: dup
    //   607: iload_3
    //   608: aload_2
    //   609: aload_1
    //   610: invokespecial 743	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/util/Map;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   613: athrow
    //   614: astore_2
    //   615: aload_0
    //   616: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   619: bipush 6
    //   621: aload_0
    //   622: invokevirtual 243	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getLogTag	()Ljava/lang/String;
    //   625: aload_2
    //   626: invokestatic 514	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   629: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   632: new 217	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   639: astore_2
    //   640: aload_2
    //   641: ldc_w 745
    //   644: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_2
    //   649: aload_1
    //   650: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   653: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   656: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: new 747	com/tencent/oskplayer/datasource/HttpDataSource$MalformedResponseException
    //   663: dup
    //   664: aload_2
    //   665: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: aload_1
    //   669: invokespecial 748	com/tencent/oskplayer/datasource/HttpDataSource$MalformedResponseException:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   672: athrow
    //   673: astore_2
    //   674: aload_0
    //   675: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   678: new 217	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   685: astore 8
    //   687: aload 8
    //   689: ldc_w 750
    //   692: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 8
    //   698: aload_1
    //   699: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   702: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   705: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: new 502	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException
    //   712: dup
    //   713: aload 8
    //   715: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: aload_2
    //   719: aload_1
    //   720: invokespecial 508	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   723: athrow
    //   724: astore_2
    //   725: aload_0
    //   726: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   729: new 217	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   736: astore 8
    //   738: aload 8
    //   740: ldc_w 752
    //   743: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 8
    //   749: aload_1
    //   750: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   753: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   756: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: new 516	com/tencent/oskplayer/datasource/HttpDataSource$InterruptConnectServerException
    //   763: dup
    //   764: aload 8
    //   766: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: aload_2
    //   770: aload_1
    //   771: invokespecial 753	com/tencent/oskplayer/datasource/HttpDataSource$InterruptConnectServerException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   774: athrow
    //   775: astore_2
    //   776: aload_0
    //   777: invokespecial 491	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   780: new 217	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   787: astore 8
    //   789: aload 8
    //   791: ldc_w 755
    //   794: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 8
    //   800: aload_1
    //   801: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   804: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   807: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: new 502	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException
    //   814: dup
    //   815: aload 8
    //   817: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: aload_2
    //   821: aload_1
    //   822: invokespecial 508	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   825: athrow
    //   826: astore_2
    //   827: new 217	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   834: astore 8
    //   836: aload 8
    //   838: ldc_w 757
    //   841: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 8
    //   847: aload_1
    //   848: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   851: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   854: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: new 502	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException
    //   861: dup
    //   862: aload 8
    //   864: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: aload_2
    //   868: aload_1
    //   869: invokespecial 508	com/tencent/oskplayer/datasource/HttpDataSource$UnableConnectServerException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   872: athrow
    //   873: astore_2
    //   874: new 217	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   881: astore 8
    //   883: aload 8
    //   885: ldc_w 759
    //   888: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 8
    //   894: aload_1
    //   895: getfield 368	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   898: invokevirtual 371	android/net/Uri:toString	()Ljava/lang/String;
    //   901: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: new 516	com/tencent/oskplayer/datasource/HttpDataSource$InterruptConnectServerException
    //   908: dup
    //   909: aload 8
    //   911: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: aload_2
    //   915: aload_1
    //   916: invokespecial 753	com/tencent/oskplayer/datasource/HttpDataSource$InterruptConnectServerException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   919: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	this	DefaultHttpDataSource
    //   0	920	1	paramDataSpec	DataSpec
    //   0	920	2	paramString	String
    //   208	400	3	i	int
    //   384	126	4	l1	long
    //   6	494	6	l2	long
    //   47	863	8	localObject1	Object
    //   56	268	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	42	java/security/NoSuchProviderException
    //   31	39	42	java/security/NoSuchProviderException
    //   18	27	96	java/security/KeyManagementException
    //   31	39	96	java/security/KeyManagementException
    //   18	27	150	java/security/NoSuchAlgorithmException
    //   31	39	150	java/security/NoSuchAlgorithmException
    //   540	551	576	java/io/IOException
    //   201	209	614	java/lang/ArrayIndexOutOfBoundsException
    //   201	209	673	java/io/IOException
    //   201	209	724	java/io/InterruptedIOException
    //   201	209	775	java/net/SocketTimeoutException
    //   18	27	826	java/io/IOException
    //   31	39	826	java/io/IOException
    //   18	27	873	java/io/InterruptedIOException
    //   31	39	873	java/io/InterruptedIOException
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      skipInternal();
      paramInt1 = readInternal(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec);
    }
  }
  
  @Deprecated
  public int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    try
    {
      this.bytesToSkip = paramLong;
      skipInternal();
      paramInt = readInternal(paramArrayOfByte, 0, paramInt);
      this.bytesSkipped += paramInt;
      return paramInt;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec);
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    synchronized (this.requestProperties)
    {
      this.requestProperties.put(paramString1, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */