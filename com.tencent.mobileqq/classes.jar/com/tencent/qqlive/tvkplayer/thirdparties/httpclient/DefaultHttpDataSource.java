package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultHttpDataSource
  extends BaseDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
  private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
  private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
  private static final long MAX_BYTES_TO_DRAIN = 2048L;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "DefaultHttpDataSource";
  private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference();
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  @Nullable
  private HttpURLConnection connection;
  @Nullable
  private final Predicate<String> contentTypePredicate;
  @Nullable
  private DataSpec dataSpec;
  @Nullable
  private final HttpDataSource.RequestProperties defaultRequestProperties;
  @Nullable
  private InputStream inputStream;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HttpDataSource.RequestProperties requestProperties;
  private final String userAgent;
  
  public DefaultHttpDataSource(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate)
  {
    this(paramString, paramPredicate, 8000, 8000);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, false, null);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable HttpDataSource.RequestProperties paramRequestProperties)
  {
    super(true);
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.requestProperties = new HttpDataSource.RequestProperties();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.defaultRequestProperties = paramRequestProperties;
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener)
  {
    this(paramString, paramPredicate, paramTransferListener, 8000, 8000);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramTransferListener, paramInt1, paramInt2, false, null);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable HttpDataSource.RequestProperties paramRequestProperties)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, paramBoolean, paramRequestProperties);
    if (paramTransferListener != null) {
      addTransferListener(paramTransferListener);
    }
  }
  
  private void closeConnectionQuietly()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection != null)
    {
      try
      {
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        TVKLogUtil.e("DefaultHttpDataSource", localException, "Unexpected error while disconnecting");
      }
      this.connection = null;
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
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
      label25:
      Object localObject2;
      break label25;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Unexpected Content-Length [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    TVKLogUtil.e("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
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
        break label247;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Inconsistent headers [");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] [");
      ((StringBuilder)localObject2).append(paramHttpURLConnection);
      ((StringBuilder)localObject2).append("]");
      TVKLogUtil.w("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
      l2 = Math.max(l1, l2);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label205:
      break label205;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected Content-Range [");
    ((StringBuilder)localObject1).append(paramHttpURLConnection);
    ((StringBuilder)localObject1).append("]");
    TVKLogUtil.e("DefaultHttpDataSource", ((StringBuilder)localObject1).toString());
    label247:
    return l1;
  }
  
  private static URL handleRedirect(URL paramURL, String paramString)
  {
    if (paramString != null)
    {
      paramString = new URL(paramURL, paramString);
      paramURL = paramString.getProtocol();
      if (!"https".equals(paramURL))
      {
        if ("http".equals(paramURL)) {
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("Unsupported protocol redirect: ");
        paramString.append(paramURL);
        throw new ProtocolException(paramString.toString());
      }
      return paramString;
    }
    throw new ProtocolException("Null location redirect");
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    Object localObject1 = new URL(paramDataSpec.uri.toString());
    int i = paramDataSpec.httpMethod;
    Object localObject2 = paramDataSpec.httpBody;
    long l1 = paramDataSpec.position;
    long l2 = paramDataSpec.length;
    boolean bool1 = paramDataSpec.isFlagSet(1);
    boolean bool2 = paramDataSpec.isFlagSet(2);
    if (!this.allowCrossProtocolRedirects) {
      return makeConnection((URL)localObject1, i, (byte[])localObject2, l1, l2, bool1, bool2, true);
    }
    int j = 0;
    int k;
    for (paramDataSpec = (DataSpec)localObject2;; paramDataSpec = (DataSpec)localObject2)
    {
      k = j + 1;
      if (j > 20) {
        break;
      }
      localObject2 = makeConnection((URL)localObject1, i, paramDataSpec, l1, l2, bool1, bool2, false);
      j = ((HttpURLConnection)localObject2).getResponseCode();
      String str = ((HttpURLConnection)localObject2).getHeaderField("Location");
      if ((i != 1) && (i != 3)) {}
      for (;;)
      {
        break;
        if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307)) {
          break label248;
        }
        if (j == 308) {
          break label248;
        }
      }
      if ((i == 2) && ((j == 300) || (j == 301) || (j == 302) || (j == 303)))
      {
        ((HttpURLConnection)localObject2).disconnect();
        paramDataSpec = handleRedirect((URL)localObject1, str);
        localObject2 = null;
        i = 1;
      }
      else
      {
        return localObject2;
        label248:
        ((HttpURLConnection)localObject2).disconnect();
        localObject1 = handleRedirect((URL)localObject1, str);
        localObject2 = paramDataSpec;
        paramDataSpec = (DataSpec)localObject1;
      }
      j = k;
      localObject1 = paramDataSpec;
    }
    paramDataSpec = new StringBuilder();
    paramDataSpec.append("Too many redirects: ");
    paramDataSpec.append(k);
    paramDataSpec = new NoRouteToHostException(paramDataSpec.toString());
    for (;;)
    {
      throw paramDataSpec;
    }
  }
  
  private HttpURLConnection makeConnection(URL paramURL, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(this.readTimeoutMillis);
    paramURL = this.defaultRequestProperties;
    Object localObject;
    if (paramURL != null)
    {
      paramURL = paramURL.getSnapshot().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.requestProperties.getSnapshot().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      paramURL = new StringBuilder();
      paramURL.append("bytes=");
      paramURL.append(paramLong1);
      paramURL.append("-");
      localObject = paramURL.toString();
      paramURL = (URL)localObject;
      if (paramLong2 != -1L)
      {
        paramURL = new StringBuilder();
        paramURL.append((String)localObject);
        paramURL.append(paramLong1 + paramLong2 - 1L);
        paramURL = paramURL.toString();
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    if (paramBoolean2) {
      localHttpURLConnection.setRequestProperty("Icy-MetaData", "1");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean3);
    if (paramArrayOfByte != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    localHttpURLConnection.setDoOutput(paramBoolean1);
    localHttpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(paramInt));
    if (paramArrayOfByte != null)
    {
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  private static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20)) {
      return;
    }
    do
    {
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (paramHttpURLConnection.read() == -1) {
            return;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if (("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) || ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject)))
          {
            localObject = paramHttpURLConnection.getClass().getSuperclass();
            if (localObject != null)
            {
              localObject = ((Class)localObject).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
              ((Method)localObject).setAccessible(true);
              ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
            }
          }
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        return;
      }
    } while (paramLong > 2048L);
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l = this.bytesToRead;
    int i = paramInt2;
    if (l != -1L)
    {
      l -= this.bytesRead;
      if (l == 0L) {
        return -1;
      }
      i = (int)Math.min(paramInt2, l);
    }
    paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 == -1)
    {
      if (this.bytesToRead == -1L) {
        return -1;
      }
      throw new EOFException();
    }
    this.bytesRead += paramInt1;
    bytesTransferred(paramInt1);
    return paramInt1;
  }
  
  private void skipInternal()
  {
    if (this.bytesSkipped == this.bytesToSkip) {
      return;
    }
    byte[] arrayOfByte2 = (byte[])skipBufferReference.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4096];
    }
    for (;;)
    {
      long l1 = this.bytesSkipped;
      long l2 = this.bytesToSkip;
      if (l1 == l2) {
        break label133;
      }
      int i = (int)Math.min(l2 - l1, arrayOfByte1.length);
      i = this.inputStream.read(arrayOfByte1, 0, i);
      if (Thread.currentThread().isInterrupted()) {
        break label125;
      }
      if (i == -1) {
        break;
      }
      this.bytesSkipped += i;
      bytesTransferred(i);
    }
    throw new EOFException();
    label125:
    throw new InterruptedIOException();
    label133:
    skipBufferReference.set(arrayOfByte1);
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
    this.requestProperties.clear();
  }
  
  public void clearRequestProperty(String paramString)
  {
    Assertions.checkNotNull(paramString);
    this.requestProperties.remove(paramString);
  }
  
  public void close()
  {
    try
    {
      if (this.inputStream != null)
      {
        maybeTerminateInputStream(this.connection, bytesRemaining());
        try
        {
          this.inputStream.close();
        }
        catch (IOException localIOException)
        {
          throw new HttpDataSource.HttpDataSourceException(localIOException, this.dataSpec, 3);
        }
      }
      return;
    }
    finally
    {
      this.inputStream = null;
      closeConnectionQuietly();
      if (this.opened)
      {
        this.opened = false;
        transferEnded();
      }
    }
  }
  
  @Nullable
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection == null) {
      return null;
    }
    return localHttpURLConnection.getHeaderFields();
  }
  
  @Nullable
  public Uri getUri()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection == null) {
      return null;
    }
    return Uri.parse(localHttpURLConnection.getURL().toString());
  }
  
  /* Error */
  public long open(DataSpec paramDataSpec)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 510	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;
    //   5: lconst_0
    //   6: lstore 5
    //   8: aload_0
    //   9: lconst_0
    //   10: putfield 447	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesRead	J
    //   13: aload_0
    //   14: lconst_0
    //   15: putfield 463	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesSkipped	J
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 545	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:transferInitializing	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   23: aload_0
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 547	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:makeConnection	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)Ljava/net/HttpURLConnection;
    //   29: putfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   32: aload_0
    //   33: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   36: invokevirtual 283	java/net/HttpURLConnection:getResponseCode	()I
    //   39: istore_2
    //   40: aload_0
    //   41: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   44: invokevirtual 550	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   47: astore 7
    //   49: iload_2
    //   50: sipush 200
    //   53: if_icmplt +219 -> 272
    //   56: iload_2
    //   57: sipush 299
    //   60: if_icmple +6 -> 66
    //   63: goto +209 -> 272
    //   66: aload_0
    //   67: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   70: invokevirtual 553	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   73: astore 7
    //   75: aload_0
    //   76: getfield 99	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/Predicate;
    //   79: astore 8
    //   81: aload 8
    //   83: ifnull +33 -> 116
    //   86: aload 8
    //   88: aload 7
    //   90: invokeinterface 558 2 0
    //   95: ifeq +6 -> 101
    //   98: goto +18 -> 116
    //   101: aload_0
    //   102: invokespecial 515	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   105: new 560	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidContentTypeException
    //   108: dup
    //   109: aload 7
    //   111: aload_1
    //   112: invokespecial 563	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   115: athrow
    //   116: lload 5
    //   118: lstore_3
    //   119: iload_2
    //   120: sipush 200
    //   123: if_icmpne +20 -> 143
    //   126: lload 5
    //   128: lstore_3
    //   129: aload_1
    //   130: getfield 269	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:position	J
    //   133: lconst_0
    //   134: lcmp
    //   135: ifeq +8 -> 143
    //   138: aload_1
    //   139: getfield 269	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:position	J
    //   142: lstore_3
    //   143: aload_0
    //   144: lload_3
    //   145: putfield 465	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   148: aload_1
    //   149: iconst_1
    //   150: invokevirtual 276	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:isFlagSet	(I)Z
    //   153: ifne +67 -> 220
    //   156: aload_1
    //   157: getfield 272	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:length	J
    //   160: lstore 5
    //   162: ldc2_w 187
    //   165: lstore_3
    //   166: lload 5
    //   168: ldc2_w 187
    //   171: lcmp
    //   172: ifeq +14 -> 186
    //   175: aload_0
    //   176: aload_1
    //   177: getfield 272	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:length	J
    //   180: putfield 445	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   183: goto +45 -> 228
    //   186: aload_0
    //   187: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   190: invokestatic 565	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   193: lstore 5
    //   195: lload 5
    //   197: ldc2_w 187
    //   200: lcmp
    //   201: ifeq +11 -> 212
    //   204: lload 5
    //   206: aload_0
    //   207: getfield 465	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   210: lsub
    //   211: lstore_3
    //   212: aload_0
    //   213: lload_3
    //   214: putfield 445	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   217: goto +11 -> 228
    //   220: aload_0
    //   221: aload_1
    //   222: getfield 272	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:length	J
    //   225: putfield 445	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   233: invokevirtual 403	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   236: putfield 452	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   239: aload_0
    //   240: iconst_1
    //   241: putfield 517	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:opened	Z
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 568	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:transferStarted	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   249: aload_0
    //   250: getfield 445	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   253: lreturn
    //   254: astore 7
    //   256: aload_0
    //   257: invokespecial 515	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   260: new 508	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException
    //   263: dup
    //   264: aload 7
    //   266: aload_1
    //   267: iconst_1
    //   268: invokespecial 513	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;I)V
    //   271: athrow
    //   272: aload_0
    //   273: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   276: invokevirtual 527	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   279: astore 8
    //   281: aload_0
    //   282: invokespecial 515	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   285: new 570	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
    //   288: dup
    //   289: iload_2
    //   290: aload 7
    //   292: aload 8
    //   294: aload_1
    //   295: invokespecial 573	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/lang/String;Ljava/util/Map;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   298: astore_1
    //   299: iload_2
    //   300: sipush 416
    //   303: if_icmpne +16 -> 319
    //   306: aload_1
    //   307: new 575	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceException
    //   310: dup
    //   311: iconst_0
    //   312: invokespecial 577	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceException:<init>	(I)V
    //   315: invokevirtual 581	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   318: pop
    //   319: aload_1
    //   320: athrow
    //   321: aload_0
    //   322: invokespecial 515	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   325: new 170	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   332: astore 7
    //   334: aload 7
    //   336: ldc_w 583
    //   339: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 7
    //   345: aload_1
    //   346: getfield 255	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   349: invokevirtual 258	android/net/Uri:toString	()Ljava/lang/String;
    //   352: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: new 508	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException
    //   359: dup
    //   360: aload 7
    //   362: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: aload_1
    //   366: iconst_1
    //   367: invokespecial 586	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;I)V
    //   370: athrow
    //   371: astore 7
    //   373: aload_0
    //   374: invokespecial 515	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   377: new 170	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   384: astore 8
    //   386: aload 8
    //   388: ldc_w 583
    //   391: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 8
    //   397: aload_1
    //   398: getfield 255	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   401: invokevirtual 258	android/net/Uri:toString	()Ljava/lang/String;
    //   404: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: new 508	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException
    //   411: dup
    //   412: aload 8
    //   414: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: aload 7
    //   419: aload_1
    //   420: iconst_1
    //   421: invokespecial 589	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;I)V
    //   424: athrow
    //   425: astore 7
    //   427: new 170	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   434: astore 8
    //   436: aload 8
    //   438: ldc_w 583
    //   441: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 8
    //   447: aload_1
    //   448: getfield 255	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   451: invokevirtual 258	android/net/Uri:toString	()Ljava/lang/String;
    //   454: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: new 508	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException
    //   461: dup
    //   462: aload 8
    //   464: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: aload 7
    //   469: aload_1
    //   470: iconst_1
    //   471: invokespecial 589	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;I)V
    //   474: athrow
    //   475: astore 7
    //   477: goto -156 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	DefaultHttpDataSource
    //   0	480	1	paramDataSpec	DataSpec
    //   39	265	2	i	int
    //   118	96	3	l1	long
    //   6	199	5	l2	long
    //   47	63	7	str	String
    //   254	37	7	localIOException1	IOException
    //   332	29	7	localStringBuilder	StringBuilder
    //   371	47	7	localIOException2	IOException
    //   425	43	7	localIOException3	IOException
    //   475	1	7	localException	Exception
    //   79	384	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   228	239	254	java/io/IOException
    //   32	49	371	java/io/IOException
    //   23	32	425	java/io/IOException
    //   32	49	475	java/lang/Exception
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
      throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec, 2);
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    this.requestProperties.set(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */