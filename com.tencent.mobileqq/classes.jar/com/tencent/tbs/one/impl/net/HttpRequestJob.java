package com.tencent.tbs.one.impl.net;

import android.content.Context;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class HttpRequestJob
  extends CancellableJob<Integer>
{
  private static final int DEFAULT_BUFFER_SIZE = 204800;
  private static final int DEFAULT_CONNECT_TIMEOUT = 20000;
  private static final int MAX_REDIRECTS = 5;
  private boolean mAllowWifiOnly;
  private HttpRequestJob.Client mClient;
  private Context mContext;
  private Map<String, String> mHeaders;
  private String mMethod;
  private byte[] mPostData;
  private int mRedirectionCount;
  private String mUrl;
  
  public HttpRequestJob(Context paramContext, String paramString)
  {
    this(paramContext, paramString, "GET");
  }
  
  public HttpRequestJob(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, null);
  }
  
  public HttpRequestJob(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this(paramContext, paramString1, paramString2, paramMap, null);
  }
  
  public HttpRequestJob(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.mContext = paramContext;
    this.mUrl = paramString1;
    this.mMethod = paramString2;
    this.mHeaders = paramMap;
    this.mPostData = paramArrayOfByte;
  }
  
  private boolean ensureNotCancelled()
  {
    if (isCancelled())
    {
      fail(104, "Aborted", null);
      return false;
    }
    return true;
  }
  
  private HttpURLConnection initializeConnection(String paramString)
  {
    setProgress(5);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setRequestProperty("Connection", "close");
      return localHttpURLConnection;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      fail(202, "Failed to parse url " + paramString, localMalformedURLException);
      return null;
    }
    catch (IOException localIOException)
    {
      fail(203, "Failed to open connection, url: " + paramString, localIOException);
    }
    return null;
  }
  
  private void readResponse(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    localObject = null;
    setProgress(50);
    int i;
    Map localMap;
    try
    {
      i = paramHttpURLConnection.getResponseCode();
      localMap = paramHttpURLConnection.getHeaderFields();
      if ((i != 300) && (i != 301) && (i != 302) && (i != 303)) {
        break label180;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      int j = this.mRedirectionCount + 1;
      this.mRedirectionCount = j;
      if (j > 5)
      {
        fail(207, "Too many redirects, url:  " + paramString + ", statusCode: " + i + ", location: " + paramHttpURLConnection, null);
        return;
      }
    }
    catch (IOException paramHttpURLConnection)
    {
      fail(206, "Failed to read response code, url:  " + paramString, paramHttpURLConnection);
      return;
    }
    Logging.i("Redirecting from %s to %s", new Object[] { paramString, paramHttpURLConnection });
    ThreadUtils.postOnBackgroundThread(new HttpRequestJob.2(this, paramHttpURLConnection));
    return;
    label180:
    if (i < 400) {}
    for (;;)
    {
      try
      {
        localObject = paramHttpURLConnection.getInputStream();
        if (localObject == null) {
          continue;
        }
        try
        {
          paramHttpURLConnection = paramHttpURLConnection.getContentEncoding();
          if ((paramHttpURLConnection != null) && (paramHttpURLConnection.equalsIgnoreCase("gzip")))
          {
            paramHttpURLConnection = new GZIPInputStream((InputStream)localObject);
            localObject = paramHttpURLConnection;
            if (this.mClient != null) {
              this.mClient.onResponseReceived(i, localMap, (InputStream)localObject);
            }
            FileUtils.close((Closeable)localObject);
            finish(Integer.valueOf(i));
            return;
          }
          if ((paramHttpURLConnection == null) || (!paramHttpURLConnection.equalsIgnoreCase("deflate"))) {
            continue;
          }
          paramHttpURLConnection = new InflaterInputStream((InputStream)localObject, new Inflater(true));
          localObject = paramHttpURLConnection;
          continue;
          FileUtils.close((Closeable)localObject);
        }
        catch (IOException paramHttpURLConnection) {}
      }
      catch (IOException paramHttpURLConnection)
      {
        localObject = null;
        continue;
      }
      fail(208, "Failed to read response data, url:  " + paramString + ", statusCode: " + i, paramHttpURLConnection);
      return;
      Logging.i("No response stream from %s, statusCode: %d", new Object[] { paramString, Integer.valueOf(i) });
    }
  }
  
  private void run(String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    if ((this.mAllowWifiOnly) && (!GlobalUtils.isWifiConnected(this.mContext))) {
      fail(201, "Network unavailable, current network is not wifi", null);
    }
    HttpURLConnection localHttpURLConnection;
    do
    {
      return;
      localHttpURLConnection = initializeConnection(paramString1);
    } while ((localHttpURLConnection == null) || (!ensureNotCancelled()) || (!sendRequest(localHttpURLConnection, paramString1, paramString2, paramMap, paramArrayOfByte)) || (!ensureNotCancelled()));
    readResponse(localHttpURLConnection, paramString1);
  }
  
  /* Error */
  private boolean sendRequest(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 10
    //   3: invokevirtual 91	com/tencent/tbs/one/impl/net/HttpRequestJob:setProgress	(I)V
    //   6: aload 4
    //   8: ifnull +66 -> 74
    //   11: aload 4
    //   13: invokeinterface 274 1 0
    //   18: invokeinterface 280 1 0
    //   23: astore 6
    //   25: aload 6
    //   27: invokeinterface 285 1 0
    //   32: ifeq +42 -> 74
    //   35: aload 6
    //   37: invokeinterface 289 1 0
    //   42: checkcast 291	java/util/Map$Entry
    //   45: astore 7
    //   47: aload_1
    //   48: aload 7
    //   50: invokeinterface 294 1 0
    //   55: checkcast 196	java/lang/String
    //   58: aload 7
    //   60: invokeinterface 297 1 0
    //   65: checkcast 196	java/lang/String
    //   68: invokevirtual 120	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -46 -> 25
    //   74: aconst_null
    //   75: astore 7
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual 300	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   82: aload 7
    //   84: astore 6
    //   86: aload_3
    //   87: ldc_w 302
    //   90: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +102 -> 195
    //   96: aload 7
    //   98: astore 6
    //   100: aload 5
    //   102: ifnull +93 -> 195
    //   105: aload_1
    //   106: invokevirtual 310	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   109: astore_1
    //   110: aload 4
    //   112: ifnull +224 -> 336
    //   115: aload_1
    //   116: astore 6
    //   118: aload 4
    //   120: ldc_w 312
    //   123: invokeinterface 316 2 0
    //   128: checkcast 196	java/lang/String
    //   131: astore 4
    //   133: aload_1
    //   134: astore 6
    //   136: aload 4
    //   138: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +195 -> 336
    //   144: aload_1
    //   145: astore 6
    //   147: aload 4
    //   149: ldc 194
    //   151: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +182 -> 336
    //   157: aload_1
    //   158: astore 6
    //   160: new 324	java/util/zip/GZIPOutputStream
    //   163: dup
    //   164: new 326	java/io/BufferedOutputStream
    //   167: dup
    //   168: aload_1
    //   169: ldc 8
    //   171: invokespecial 329	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   174: invokespecial 332	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   177: astore 4
    //   179: aload 4
    //   181: astore_1
    //   182: aload_1
    //   183: aload 5
    //   185: invokevirtual 338	java/io/OutputStream:write	([B)V
    //   188: aload_1
    //   189: invokevirtual 341	java/io/OutputStream:flush	()V
    //   192: aload_1
    //   193: astore 6
    //   195: aload 6
    //   197: invokestatic 218	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: astore 6
    //   209: aload_0
    //   210: sipush 204
    //   213: new 122	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 343
    //   223: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_3
    //   227: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 345
    //   233: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: aload 4
    //   245: invokevirtual 81	com/tencent/tbs/one/impl/net/HttpRequestJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_1
    //   249: invokestatic 218	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: astore 6
    //   260: aload_0
    //   261: sipush 205
    //   264: new 122	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 347
    //   274: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aload_3
    //   285: invokevirtual 81	com/tencent/tbs/one/impl/net/HttpRequestJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_1
    //   289: invokestatic 218	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: astore_1
    //   295: aconst_null
    //   296: astore 6
    //   298: aload 6
    //   300: invokestatic 218	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: goto -8 -> 298
    //   309: astore_2
    //   310: aload_1
    //   311: astore 6
    //   313: aload_2
    //   314: astore_1
    //   315: goto -17 -> 298
    //   318: astore_3
    //   319: goto -62 -> 257
    //   322: astore_3
    //   323: goto -66 -> 257
    //   326: astore 4
    //   328: goto -122 -> 206
    //   331: astore 4
    //   333: goto -127 -> 206
    //   336: goto -154 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	HttpRequestJob
    //   0	339	1	paramHttpURLConnection	HttpURLConnection
    //   0	339	2	paramString1	String
    //   0	339	3	paramString2	String
    //   0	339	4	paramMap	Map<String, String>
    //   0	339	5	paramArrayOfByte	byte[]
    //   23	289	6	localObject	Object
    //   45	52	7	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   77	82	202	java/net/ProtocolException
    //   86	96	202	java/net/ProtocolException
    //   105	110	202	java/net/ProtocolException
    //   77	82	254	java/lang/Exception
    //   86	96	254	java/lang/Exception
    //   105	110	254	java/lang/Exception
    //   77	82	294	finally
    //   86	96	294	finally
    //   105	110	294	finally
    //   118	133	305	finally
    //   136	144	305	finally
    //   147	157	305	finally
    //   160	179	305	finally
    //   209	248	305	finally
    //   260	288	305	finally
    //   182	192	309	finally
    //   118	133	318	java/lang/Exception
    //   136	144	318	java/lang/Exception
    //   147	157	318	java/lang/Exception
    //   160	179	318	java/lang/Exception
    //   182	192	322	java/lang/Exception
    //   118	133	326	java/net/ProtocolException
    //   136	144	326	java/net/ProtocolException
    //   147	157	326	java/net/ProtocolException
    //   160	179	326	java/net/ProtocolException
    //   182	192	331	java/net/ProtocolException
  }
  
  public void run()
  {
    ThreadUtils.postOnBackgroundThread(new HttpRequestJob.1(this));
  }
  
  public void setAllowWifiOnly(boolean paramBoolean)
  {
    this.mAllowWifiOnly = paramBoolean;
  }
  
  public void setClient(HttpRequestJob.Client paramClient)
  {
    this.mClient = paramClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.net.HttpRequestJob
 * JD-Core Version:    0.7.0.1
 */