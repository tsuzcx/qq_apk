package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.ContentTypeFixer;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import com.tencent.oskplayer.util.ThreadUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
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
    if (this.connection != null)
    {
      this.connection.disconnect();
      this.connection = null;
    }
  }
  
  private HttpURLConnection configureConnection(URL paramURL, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramURL.getProtocol().startsWith("https")) {
      if (PlayerUtils.shouldByPassProxySetting(paramURL)) {
        localObject1 = (HttpsURLConnection)paramURL.openConnection(Proxy.NO_PROXY);
      }
    }
    Object localObject3;
    for (;;)
    {
      ((HttpURLConnection)localObject1).setConnectTimeout(this.connectTimeoutMillis);
      ((HttpURLConnection)localObject1).setReadTimeout(this.readTimeoutMillis);
      ((HttpURLConnection)localObject1).setDoOutput(false);
      synchronized (this.requestProperties)
      {
        localObject3 = this.requestProperties.entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((HttpURLConnection)localObject1).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localObject1 = (HttpsURLConnection)paramURL.openConnection();
      continue;
      if (PlayerUtils.shouldByPassProxySetting(paramURL)) {
        localObject1 = (HttpURLConnection)paramURL.openConnection(Proxy.NO_PROXY);
      } else {
        localObject1 = (HttpURLConnection)paramURL.openConnection();
      }
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject3 = "bytes=" + paramLong1 + "-";
      ??? = localObject3;
      if (paramLong2 != -1L) {
        ??? = (String)localObject3 + (paramLong1 + paramLong2 - 1L);
      }
      ((HttpURLConnection)localObject1).setRequestProperty("Range", (String)???);
    }
    ((HttpURLConnection)localObject1).setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean) {
      ((HttpURLConnection)localObject1).setRequestProperty("Accept-Encoding", "identity");
    }
    PlayerUtils.log(4, getLogTag(), PlayerUtils.removeLineBreaks("send upstream request: \r\n" + ((HttpURLConnection)localObject1).getRequestMethod() + " " + paramURL + "\r\n" + HttpParser.getHeaders(((HttpURLConnection)localObject1).getRequestProperties()), null));
    return localObject1;
  }
  
  /* Error */
  private static long getContentLength(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 84
    //   3: lstore 4
    //   5: aload_0
    //   6: ldc_w 279
    //   9: invokevirtual 282	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 8
    //   14: lload 4
    //   16: lstore_2
    //   17: aload 8
    //   19: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +9 -> 31
    //   25: aload 8
    //   27: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: lstore_2
    //   31: aload_0
    //   32: ldc_w 296
    //   35: invokevirtual 282	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: lload_2
    //   40: lstore 4
    //   42: aload_0
    //   43: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +64 -> 110
    //   49: getstatic 64	com/tencent/oskplayer/datasource/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
    //   52: aload_0
    //   53: invokevirtual 300	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   56: astore 9
    //   58: lload_2
    //   59: lstore 4
    //   61: aload 9
    //   63: invokevirtual 305	java/util/regex/Matcher:find	()Z
    //   66: ifeq +44 -> 110
    //   69: aload 9
    //   71: iconst_2
    //   72: invokevirtual 309	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   75: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: lstore 4
    //   80: aload 9
    //   82: iconst_1
    //   83: invokevirtual 309	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   86: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: lstore 6
    //   91: lload 4
    //   93: lload 6
    //   95: lsub
    //   96: lconst_1
    //   97: ladd
    //   98: lstore 6
    //   100: lload_2
    //   101: lconst_0
    //   102: lcmp
    //   103: ifge +51 -> 154
    //   106: lload 6
    //   108: lstore 4
    //   110: lload 4
    //   112: lreturn
    //   113: astore 9
    //   115: bipush 6
    //   117: aload_1
    //   118: new 217	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 311
    //   128: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 8
    //   133: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 313
    //   139: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   148: lload 4
    //   150: lstore_2
    //   151: goto -120 -> 31
    //   154: lload_2
    //   155: lstore 4
    //   157: lload_2
    //   158: lload 6
    //   160: lcmp
    //   161: ifeq -51 -> 110
    //   164: iconst_5
    //   165: aload_1
    //   166: new 217	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 315
    //   176: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 8
    //   181: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 317
    //   187: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 313
    //   197: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   206: lload_2
    //   207: lload 6
    //   209: invokestatic 323	java/lang/Math:max	(JJ)J
    //   212: lstore 4
    //   214: lload 4
    //   216: lreturn
    //   217: astore 8
    //   219: bipush 6
    //   221: aload_1
    //   222: new 217	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 325
    //   232: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 313
    //   242: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   251: lload_2
    //   252: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramHttpURLConnection	HttpURLConnection
    //   0	253	1	paramString	String
    //   16	236	2	l1	long
    //   3	212	4	l2	long
    //   89	119	6	l3	long
    //   12	168	8	str	String
    //   217	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   56	25	9	localMatcher	java.util.regex.Matcher
    //   113	1	9	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   25	31	113	java/lang/NumberFormatException
    //   69	91	217	java/lang/NumberFormatException
    //   164	214	217	java/lang/NumberFormatException
  }
  
  /* Error */
  private static long getTotalLength(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 84
    //   3: lstore 6
    //   5: aload_0
    //   6: ldc_w 279
    //   9: invokevirtual 282	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 10
    //   14: aload 10
    //   16: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +104 -> 123
    //   22: aload 10
    //   24: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore_2
    //   28: aload_0
    //   29: ldc_w 296
    //   32: invokevirtual 282	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +149 -> 189
    //   43: getstatic 64	com/tencent/oskplayer/datasource/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
    //   46: aload_0
    //   47: invokevirtual 300	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   50: astore 10
    //   52: lload 6
    //   54: lstore 4
    //   56: aload 10
    //   58: invokevirtual 305	java/util/regex/Matcher:find	()Z
    //   61: ifeq +24 -> 85
    //   64: aload 10
    //   66: iconst_3
    //   67: invokevirtual 309	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   70: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   73: lstore 8
    //   75: lload_2
    //   76: lconst_0
    //   77: lcmp
    //   78: ifge +52 -> 130
    //   81: lload 8
    //   83: lstore 4
    //   85: lload 4
    //   87: lreturn
    //   88: astore 11
    //   90: bipush 6
    //   92: aload_1
    //   93: new 217	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 311
    //   103: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 10
    //   108: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 313
    //   114: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   123: ldc2_w 84
    //   126: lstore_2
    //   127: goto -99 -> 28
    //   130: lload 6
    //   132: lstore 4
    //   134: lload_2
    //   135: ldc2_w 84
    //   138: lcmp
    //   139: ifeq -54 -> 85
    //   142: lload_2
    //   143: lload 8
    //   145: invokestatic 323	java/lang/Math:max	(JJ)J
    //   148: lstore_2
    //   149: lload_2
    //   150: lreturn
    //   151: astore 10
    //   153: bipush 6
    //   155: aload_1
    //   156: new 217	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 325
    //   166: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 313
    //   176: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 273	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   185: ldc2_w 84
    //   188: lreturn
    //   189: lload_2
    //   190: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramHttpURLConnection	HttpURLConnection
    //   0	191	1	paramString	String
    //   27	163	2	l1	long
    //   54	79	4	l2	long
    //   3	128	6	l3	long
    //   73	71	8	l4	long
    //   12	95	10	localObject	Object
    //   151	1	10	localNumberFormatException1	java.lang.NumberFormatException
    //   88	1	11	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	88	java/lang/NumberFormatException
    //   64	75	151	java/lang/NumberFormatException
    //   142	149	151	java/lang/NumberFormatException
  }
  
  public static URL handleRedirect(URL paramURL, String paramString)
  {
    if (paramString == null) {
      throw new ProtocolException("Null location redirect");
    }
    if (URLUtil.isNetworkUrl(paramString)) {}
    for (paramURL = new URL(paramString);; paramURL = new URL(paramURL, paramString))
    {
      paramString = paramURL.getProtocol();
      if (("https".equals(paramString)) || ("http".equals(paramString))) {
        break;
      }
      throw new ProtocolException("Unsupported protocol redirect: " + paramString);
    }
    return paramURL;
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    Object localObject1 = new URL(paramDataSpec.uri.toString());
    long l2 = paramDataSpec.position;
    long l3 = paramDataSpec.length;
    if ((paramDataSpec.flags & 0x1) != 0) {}
    for (boolean bool = true; !this.allowCrossProtocolRedirects; bool = false) {
      return configureConnection((URL)localObject1, l2, l3, bool);
    }
    PlayerUtils.getVideoUuidFromVideoUrl(((URL)localObject1).toExternalForm());
    long l1 = System.currentTimeMillis();
    int j = 0;
    Object localObject3 = new ArrayList();
    int i = 0;
    int k;
    Object localObject2;
    for (;;)
    {
      k = j + 1;
      if (j > 20) {
        break label671;
      }
      localObject2 = configureConnection((URL)localObject1, l2, l3, bool);
      ((HttpURLConnection)localObject2).setInstanceFollowRedirects(false);
      ((HttpURLConnection)localObject2).connect();
      Object localObject4;
      try
      {
        localObject4 = ThreadUtils.submitTask(new DefaultHttpDataSource.GetResponseCodeCallable((HttpURLConnection)localObject2), this.readTimeoutMillis, true, "GetResponseCodeCallable", getLogTag());
        if (localObject4 == null)
        {
          closeConnection();
          throw new HttpDataSource.UnableConnectServerException("getResponseCode TimeoutException Unable to connect to " + paramDataSpec.uri.toString() + " within " + this.readTimeoutMillis, new IOException("getResponseCode Timeout " + this.readTimeoutMillis), paramDataSpec);
        }
      }
      catch (InterruptedException paramDataSpec)
      {
        Thread.currentThread().interrupt();
        PlayerUtils.log(4, getLogTag(), "GetResponseCodeCallable Interrupted");
        throw new HttpDataSource.InterruptConnectServerException("GetResponseCodeCallable interrupted", getDataSpec());
      }
      catch (ExecutionException paramDataSpec)
      {
        PlayerUtils.log(5, getLogTag(), "GetResponseCodeCallable ExecutionException " + PlayerUtils.getPrintableStackTrace(paramDataSpec));
        throw new HttpDataSource.InterruptConnectServerException("Failed To Execute GetResponseCodeCallable", getDataSpec());
      }
      j = ((Integer)localObject4).intValue();
      if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307) || (j == 308))
      {
        localObject4 = ((HttpURLConnection)localObject2).getHeaderField("Location");
        try
        {
          ((ArrayList)localObject3).add(new URL((String)localObject4).getHost());
          ((HttpURLConnection)localObject2).disconnect();
          localObject2 = handleRedirect((URL)localObject1, (String)localObject4);
          PlayerUtils.log(2, getLogTag(), "redirect to url=" + ((URL)localObject2).toString() + ", fromUrl=" + localObject1);
          localObject1 = localObject2;
          i += 1;
          j = k;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            PlayerUtils.log(5, getLogTag(), "MalformedURLException url=" + (String)localObject4);
          }
        }
      }
    }
    if ((i > 0) && (PlayerConfig.g().getVideoReporter() != null))
    {
      l2 = System.currentTimeMillis();
      PlayerConfig.g().getVideoReporter().urlRedirectOccurred(paramDataSpec.uuid, PlayerUtils.join((List)localObject3), l2 - l1, i);
    }
    try
    {
      if ((PlayerConfig.g().isServerIPWithGetByName()) && (PlayerConfig.g().getVideoReporter() != null) && (paramDataSpec.priority == 90))
      {
        localObject1 = ((URL)localObject1).getHost();
        localObject3 = InetAddress.getByName((String)localObject1).getHostAddress();
        PlayerConfig.g().getVideoReporter().downloadServerIp(paramDataSpec.uuid, (String)localObject3);
        PlayerUtils.log(4, getLogTag(), "host:" + (String)localObject1 + ",ip:" + (String)localObject3);
      }
      return localObject2;
    }
    catch (Exception paramDataSpec)
    {
      for (;;)
      {
        PlayerUtils.log(5, getLogTag(), "getIpError", paramDataSpec);
      }
    }
    label671:
    throw new NoRouteToHostException("Too many redirects: " + k);
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.bytesToRead == -1L) {
      if (paramInt2 != 0) {
        break label36;
      }
    }
    label36:
    do
    {
      return -1;
      paramInt2 = (int)Math.min(paramInt2, this.bytesToRead - this.bytesRead);
      break;
      paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break label83;
      }
    } while ((this.bytesToRead == -1L) || (this.bytesToRead == this.bytesRead));
    throw new EOFException();
    label83:
    this.bytesRead += paramInt1;
    if (this.listener != null) {
      this.listener.onBytesTransferred(paramInt1);
    }
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
    Log.d(getLogTag(), "bytes skipped " + this.bytesSkipped + ", bytesToSkip " + this.bytesToSkip);
    while (this.bytesSkipped != this.bytesToSkip)
    {
      int i = (int)Math.min(this.bytesToSkip - this.bytesSkipped, arrayOfByte1.length);
      Log.d(getLogTag(), "request skip " + i + " bytes");
      i = this.inputStream.read(arrayOfByte1, 0, i);
      Log.d(getLogTag(), "actual skip " + i + " bytes");
      if (Thread.interrupted()) {
        throw new HttpDataSource.InterruptReadException("skipInternal interrupted", getDataSpec());
      }
      if (i == -1) {
        throw new EOFException();
      }
      this.bytesSkipped += i;
      if (this.listener != null) {
        this.listener.onBytesTransferred(i);
      }
    }
    skipBufferReference.set(arrayOfByte1);
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
    if (this.bytesToRead == -1L) {
      return this.bytesToRead;
    }
    return this.bytesToRead - this.bytesRead;
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
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 554	com/tencent/oskplayer/datasource/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   4: ifnull +26 -> 30
    //   7: aload_0
    //   8: getfield 130	com/tencent/oskplayer/datasource/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   11: aload_0
    //   12: invokevirtual 622	com/tencent/oskplayer/datasource/DefaultHttpDataSource:bytesRemaining	()J
    //   15: invokestatic 628	com/tencent/oskplayer/util/Util:maybeTerminateInputStream	(Ljava/net/HttpURLConnection;J)V
    //   18: aload_0
    //   19: getfield 554	com/tencent/oskplayer/datasource/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   22: invokevirtual 630	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 554	com/tencent/oskplayer/datasource/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   30: aload_0
    //   31: getfield 632	com/tencent/oskplayer/datasource/DefaultHttpDataSource:opened	Z
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 632	com/tencent/oskplayer/datasource/DefaultHttpDataSource:opened	Z
    //   42: aload_0
    //   43: getfield 105	com/tencent/oskplayer/datasource/DefaultHttpDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   46: ifnull +12 -> 58
    //   49: aload_0
    //   50: getfield 105	com/tencent/oskplayer/datasource/DefaultHttpDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   53: invokeinterface 635 1 0
    //   58: aload_0
    //   59: invokespecial 418	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   62: return
    //   63: astore_1
    //   64: new 637	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   67: dup
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 639	com/tencent/oskplayer/datasource/DefaultHttpDataSource:dataSpec	Lcom/tencent/oskplayer/datasource/DataSpec;
    //   73: invokespecial 642	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 632	com/tencent/oskplayer/datasource/DefaultHttpDataSource:opened	Z
    //   82: ifeq +24 -> 106
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 632	com/tencent/oskplayer/datasource/DefaultHttpDataSource:opened	Z
    //   90: aload_0
    //   91: getfield 105	com/tencent/oskplayer/datasource/DefaultHttpDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   94: ifnull +12 -> 106
    //   97: aload_0
    //   98: getfield 105	com/tencent/oskplayer/datasource/DefaultHttpDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   101: invokeinterface 635 1 0
    //   106: aload_0
    //   107: invokespecial 418	com/tencent/oskplayer/datasource/DefaultHttpDataSource:closeConnection	()V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	DefaultHttpDataSource
    //   63	6	1	localIOException	IOException
    //   77	34	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	63	java/io/IOException
    //   0	18	77	finally
    //   18	25	77	finally
    //   25	30	77	finally
    //   64	77	77	finally
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
    return this.extraLogTag + this.TAG;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    if (this.connection == null) {}
    for (Object localObject1 = null;; localObject1 = this.connection.getHeaderFields())
    {
      Object localObject2 = localObject1;
      if (this.contentTypeFixer != null) {
        localObject2 = (Map)this.contentTypeFixer.fix(localObject1);
      }
      return localObject2;
    }
  }
  
  public long getTotalLength()
  {
    return this.totalLength;
  }
  
  public String getUri()
  {
    if (this.connection == null) {
      return null;
    }
    return this.connection.getURL().toString();
  }
  
  public long open(DataSpec paramDataSpec)
  {
    return open(paramDataSpec, null);
  }
  
  public long open(DataSpec paramDataSpec, String paramString)
  {
    this.dataSpec = paramDataSpec;
    this.bytesRead = 0L;
    this.bytesSkipped = 0L;
    int i;
    try
    {
      this.connection = makeConnection(paramDataSpec);
      if (paramString != null) {
        this.connection.setRequestMethod(paramString);
      }
      paramString = this.connection.getContentType();
    }
    catch (InterruptedIOException paramString)
    {
      try
      {
        i = this.connection.getResponseCode();
        PlayerUtils.log(4, getLogTag(), PlayerUtils.removeLineBreaks("uri=" + paramDataSpec.toString() + ", response header: \r\n" + HttpParser.getHeaders(this.connection.getHeaderFields()), null));
        if ((i >= 200) && (i <= 299)) {
          break label505;
        }
        paramString = this.connection.getHeaderFields();
        closeConnection();
        throw new HttpDataSource.InvalidResponseCodeException(i, paramString, paramDataSpec);
      }
      catch (SocketTimeoutException paramString)
      {
        closeConnection();
        throw new HttpDataSource.UnableConnectServerException("getResponseCode SocketTimeoutException Unable to connect to " + paramDataSpec.uri.toString(), paramString, paramDataSpec);
      }
      catch (InterruptedIOException paramString)
      {
        closeConnection();
        throw new HttpDataSource.InterruptConnectServerException("getResponseCode InterruptedIOException Interrupt connection to " + paramDataSpec.uri.toString(), paramString, paramDataSpec);
      }
      catch (IOException paramString)
      {
        closeConnection();
        throw new HttpDataSource.UnableConnectServerException("getResponseCode IOException Unable to connect to " + paramDataSpec.uri.toString(), paramString, paramDataSpec);
      }
      catch (ArrayIndexOutOfBoundsException paramString)
      {
        closeConnection();
        PlayerUtils.log(6, getLogTag(), PlayerUtils.getPrintableStackTrace(paramString));
        throw new HttpDataSource.MalformedResponseException("getResponseCode Got malformed response when connect to " + paramDataSpec.uri.toString(), paramDataSpec);
      }
      paramString = paramString;
      throw new HttpDataSource.InterruptConnectServerException("makeConnection InterruptedIOException Interrupt connection to " + paramDataSpec.uri.toString(), paramString, paramDataSpec);
    }
    catch (IOException paramString)
    {
      throw new HttpDataSource.UnableConnectServerException("makeConnection IOException Unable to connect to " + paramDataSpec.uri.toString(), paramString, paramDataSpec);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        PlayerUtils.log(6, getLogTag(), "makeConnection NoSuchAlgorithmException Unable to connect to" + paramDataSpec.uri.toString(), paramString);
      }
    }
    catch (KeyManagementException paramString)
    {
      for (;;)
      {
        PlayerUtils.log(6, getLogTag(), "makeConnection KeyManagementException Unable to connect to" + paramDataSpec.uri.toString(), paramString);
      }
    }
    catch (NoSuchProviderException paramString)
    {
      for (;;)
      {
        PlayerUtils.log(6, getLogTag(), "makeConnection NoSuchProviderException Unable to connect to" + paramDataSpec.uri.toString(), paramString);
      }
    }
    label505:
    Map localMap = this.connection.getHeaderFields();
    if ((this.contentTypePredicate != null) && (!this.contentTypePredicate.evaluate(paramString)))
    {
      closeConnection();
      throw new HttpDataSource.InvalidContentTypeException(paramString, localMap, paramDataSpec);
    }
    this.contentType = paramString;
    if (this.contentTypeFixer != null) {
      this.contentType = ((ContentTypeFixer)this.contentTypeFixer).fix(this.contentType);
    }
    long l;
    if ((i == 200) && (paramDataSpec.position != 0L))
    {
      l = paramDataSpec.position;
      this.bytesToSkip = l;
      if ((paramDataSpec.flags & 0x1) != 0) {
        break label754;
      }
      this.contentLength = getContentLength(this.connection, getLogTag());
      this.totalLength = getTotalLength(this.connection, getLogTag());
      if (paramDataSpec.length == -1L) {
        break label721;
      }
      l = paramDataSpec.length;
      label672:
      this.bytesToRead = l;
    }
    for (;;)
    {
      try
      {
        this.inputStream = this.connection.getInputStream();
        this.opened = true;
        if (this.listener != null) {
          this.listener.onTransferStart();
        }
        return this.bytesToRead;
      }
      catch (IOException paramString)
      {
        label721:
        label754:
        closeConnection();
        throw new HttpDataSource.HttpDataSourceException(paramString, paramDataSpec);
      }
      l = 0L;
      break;
      if (this.contentLength != -1L)
      {
        l = this.contentLength - this.bytesToSkip;
        break label672;
      }
      l = -1L;
      break label672;
      this.bytesToRead = paramDataSpec.length;
      this.contentLength = paramDataSpec.length;
      this.totalLength = -1L;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */