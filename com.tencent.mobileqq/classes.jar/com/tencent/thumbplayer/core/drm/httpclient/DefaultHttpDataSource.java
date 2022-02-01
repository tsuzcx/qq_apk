package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
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
        Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
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
    Log.e("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
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
        break label250;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Inconsistent headers [");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] [");
      ((StringBuilder)localObject2).append(paramHttpURLConnection);
      ((StringBuilder)localObject2).append("]");
      Log.w("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
      l2 = Math.max(l1, l2);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label207:
      break label207;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected Content-Range [");
    ((StringBuilder)localObject1).append(paramHttpURLConnection);
    ((StringBuilder)localObject1).append("]");
    Log.e("DefaultHttpDataSource", ((StringBuilder)localObject1).toString());
    label250:
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
        if (paramLong != -1L) {
          continue;
        }
        if (paramHttpURLConnection.read() == -1) {
          return;
        }
        Object localObject = paramHttpURLConnection.getClass().getName();
        if (("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) || ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject)))
        {
          localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
      }
      return;
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
    //   0: new 549	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier
    //   3: dup
    //   4: invokespecial 550	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier:<init>	()V
    //   7: astore 7
    //   9: new 552	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory
    //   12: dup
    //   13: invokespecial 553	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory:<init>	()V
    //   16: invokestatic 559	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   19: goto +10 -> 29
    //   22: astore 8
    //   24: aload 8
    //   26: invokevirtual 560	java/lang/Throwable:printStackTrace	()V
    //   29: aload 7
    //   31: invokestatic 564	javax/net/ssl/HttpsURLConnection:setDefaultHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 514	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;
    //   39: lconst_0
    //   40: lstore 5
    //   42: aload_0
    //   43: lconst_0
    //   44: putfield 451	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesRead	J
    //   47: aload_0
    //   48: lconst_0
    //   49: putfield 467	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesSkipped	J
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 568	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferInitializing	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   57: aload_0
    //   58: aload_0
    //   59: aload_1
    //   60: invokespecial 570	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:makeConnection	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)Ljava/net/HttpURLConnection;
    //   63: putfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   66: aload_0
    //   67: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   70: invokevirtual 283	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore_2
    //   74: aload_0
    //   75: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   78: invokevirtual 573	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   81: astore 7
    //   83: iload_2
    //   84: sipush 200
    //   87: if_icmplt +219 -> 306
    //   90: iload_2
    //   91: sipush 299
    //   94: if_icmple +6 -> 100
    //   97: goto +209 -> 306
    //   100: aload_0
    //   101: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   104: invokevirtual 576	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   107: astore 7
    //   109: aload_0
    //   110: getfield 99	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/thumbplayer/core/drm/httpclient/Predicate;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnull +33 -> 150
    //   120: aload 8
    //   122: aload 7
    //   124: invokeinterface 581 2 0
    //   129: ifeq +6 -> 135
    //   132: goto +18 -> 150
    //   135: aload_0
    //   136: invokespecial 519	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   139: new 583	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException
    //   142: dup
    //   143: aload 7
    //   145: aload_1
    //   146: invokespecial 586	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   149: athrow
    //   150: lload 5
    //   152: lstore_3
    //   153: iload_2
    //   154: sipush 200
    //   157: if_icmpne +20 -> 177
    //   160: lload 5
    //   162: lstore_3
    //   163: aload_1
    //   164: getfield 269	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifeq +8 -> 177
    //   172: aload_1
    //   173: getfield 269	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   176: lstore_3
    //   177: aload_0
    //   178: lload_3
    //   179: putfield 469	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   182: aload_1
    //   183: iconst_1
    //   184: invokevirtual 276	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:isFlagSet	(I)Z
    //   187: ifne +67 -> 254
    //   190: aload_1
    //   191: getfield 272	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   194: lstore 5
    //   196: ldc2_w 187
    //   199: lstore_3
    //   200: lload 5
    //   202: ldc2_w 187
    //   205: lcmp
    //   206: ifeq +14 -> 220
    //   209: aload_0
    //   210: aload_1
    //   211: getfield 272	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   214: putfield 449	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   217: goto +45 -> 262
    //   220: aload_0
    //   221: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   224: invokestatic 588	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   227: lstore 5
    //   229: lload 5
    //   231: ldc2_w 187
    //   234: lcmp
    //   235: ifeq +11 -> 246
    //   238: lload 5
    //   240: aload_0
    //   241: getfield 469	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   244: lsub
    //   245: lstore_3
    //   246: aload_0
    //   247: lload_3
    //   248: putfield 449	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   251: goto +11 -> 262
    //   254: aload_0
    //   255: aload_1
    //   256: getfield 272	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   259: putfield 449	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   267: invokevirtual 404	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   270: putfield 456	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   273: aload_0
    //   274: iconst_1
    //   275: putfield 521	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 591	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferStarted	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   283: aload_0
    //   284: getfield 449	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   287: lreturn
    //   288: astore 7
    //   290: aload_0
    //   291: invokespecial 519	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   294: new 512	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   297: dup
    //   298: aload 7
    //   300: aload_1
    //   301: iconst_1
    //   302: invokespecial 517	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   305: athrow
    //   306: aload_0
    //   307: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   310: invokevirtual 531	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   313: astore 8
    //   315: aload_0
    //   316: invokespecial 519	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   319: new 593	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException
    //   322: dup
    //   323: iload_2
    //   324: aload 7
    //   326: aload 8
    //   328: aload_1
    //   329: invokespecial 596	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/lang/String;Ljava/util/Map;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   332: astore_1
    //   333: iload_2
    //   334: sipush 416
    //   337: if_icmpne +16 -> 353
    //   340: aload_1
    //   341: new 598	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException
    //   344: dup
    //   345: iconst_0
    //   346: invokespecial 600	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException:<init>	(I)V
    //   349: invokevirtual 604	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   352: pop
    //   353: aload_1
    //   354: athrow
    //   355: astore 7
    //   357: aload_0
    //   358: invokespecial 519	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   361: new 170	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   368: astore 8
    //   370: aload 8
    //   372: ldc_w 606
    //   375: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 8
    //   381: aload_1
    //   382: getfield 255	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   385: invokevirtual 258	android/net/Uri:toString	()Ljava/lang/String;
    //   388: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: new 512	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   395: dup
    //   396: aload 8
    //   398: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: aload 7
    //   403: aload_1
    //   404: iconst_1
    //   405: invokespecial 609	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   408: athrow
    //   409: astore 7
    //   411: new 170	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   418: astore 8
    //   420: aload 8
    //   422: ldc_w 606
    //   425: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 8
    //   431: aload_1
    //   432: getfield 255	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   435: invokevirtual 258	android/net/Uri:toString	()Ljava/lang/String;
    //   438: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: new 512	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   445: dup
    //   446: aload 8
    //   448: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: aload 7
    //   453: aload_1
    //   454: iconst_1
    //   455: invokespecial 609	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   458: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	DefaultHttpDataSource
    //   0	459	1	paramDataSpec	DataSpec
    //   73	265	2	i	int
    //   152	96	3	l1	long
    //   40	199	5	l2	long
    //   7	137	7	localObject1	Object
    //   288	37	7	localIOException1	IOException
    //   355	47	7	localIOException2	IOException
    //   409	43	7	localIOException3	IOException
    //   22	3	8	localThrowable	java.lang.Throwable
    //   113	334	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	22	java/lang/Throwable
    //   262	273	288	java/io/IOException
    //   66	83	355	java/io/IOException
    //   57	66	409	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */