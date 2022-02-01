package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DownloaderProxyDefault$DownloadTask
  implements Runnable
{
  public volatile boolean mAbort;
  public String mFilePath;
  public Map<String, String> mHeader;
  public DownloaderProxy.DownloadListener mListener;
  public int mTaskId;
  public int mTimeout;
  public String mUrl;
  private int redirectCount = 0;
  
  public DownloaderProxyDefault$DownloadTask(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    this.mTaskId = paramString1;
    this.mUrl = paramMap;
    this.mHeader = paramString2;
    this.mFilePath = paramInt2;
    this.mTimeout = paramDownloadListener;
    Object localObject;
    this.mListener = localObject;
    this.mAbort = false;
  }
  
  private HttpURLConnection getRealConnection(String paramString)
  {
    HttpURLConnection localHttpURLConnection;
    int i;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
      localHttpURLConnection.setConnectTimeout(this.mTimeout * 1000);
      localHttpURLConnection.setRequestMethod("GET");
      if (this.mHeader != null)
      {
        paramString = this.mHeader.keySet().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localHttpURLConnection.setRequestProperty(str, (String)this.mHeader.get(str));
        }
      }
      if (i == 302) {
        break label210;
      }
    }
    catch (MalformedURLException paramString)
    {
      throw new DownloadException(-1, paramString.getMessage());
      i = localHttpURLConnection.getResponseCode();
      if (this.mAbort)
      {
        QMLog.i("DefaultDownloader", this.mUrl + " aborted");
        throw new DownloadException(-3, "aborted by outside");
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("DefaultDownloader", "unknown err", paramString);
      throw new DownloadException(-100, paramString.getMessage());
    }
    paramString = localHttpURLConnection;
    if (i == 301)
    {
      label210:
      this.redirectCount += 1;
      localHttpURLConnection.disconnect();
      if (this.redirectCount > 30)
      {
        QMLog.e("DefaultDownloader", "url: " + this.mUrl + "server redirects connection to many times");
        throw new DownloadException(-4, "url: " + this.mUrl + "server redirects connection to many times");
      }
      paramString = getRealConnection(localHttpURLConnection.getHeaderField("Location"));
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 173	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 39	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mFilePath	Ljava/lang/String;
    //   8: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: invokevirtual 177	java/io/File:exists	()Z
    //   18: ifeq +9 -> 27
    //   21: aload 7
    //   23: invokevirtual 180	java/io/File:delete	()Z
    //   26: pop
    //   27: aload 7
    //   29: invokevirtual 184	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 177	java/io/File:exists	()Z
    //   35: ifne +12 -> 47
    //   38: aload 7
    //   40: invokevirtual 184	java/io/File:getParentFile	()Ljava/io/File;
    //   43: invokevirtual 187	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload 7
    //   49: invokevirtual 190	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 35	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mUrl	Ljava/lang/String;
    //   58: invokespecial 168	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:getRealConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   61: astore 5
    //   63: aload 5
    //   65: ifnonnull +14 -> 79
    //   68: return
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   76: goto -23 -> 53
    //   79: aload 5
    //   81: invokevirtual 123	java/net/HttpURLConnection:getResponseCode	()I
    //   84: istore_1
    //   85: iload_1
    //   86: sipush 200
    //   89: if_icmplt +184 -> 273
    //   92: iload_1
    //   93: sipush 300
    //   96: if_icmpge +177 -> 273
    //   99: new 195	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream
    //   102: dup
    //   103: aload_0
    //   104: aload 5
    //   106: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   109: invokespecial 202	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:<init>	(Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask;Ljava/io/InputStream;)V
    //   112: astore 4
    //   114: aload 4
    //   116: checkcast 195	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream
    //   119: astore 6
    //   121: aload_0
    //   122: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   125: iload_1
    //   126: aload 5
    //   128: invokevirtual 206	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   131: invokeinterface 212 3 0
    //   136: aload 5
    //   138: invokevirtual 215	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   141: astore 8
    //   143: aload 8
    //   145: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +319 -> 467
    //   151: aload 8
    //   153: ldc 223
    //   155: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   158: ifeq +309 -> 467
    //   161: new 228	java/util/zip/GZIPInputStream
    //   164: dup
    //   165: aload 6
    //   167: invokespecial 231	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   170: astore 4
    //   172: aload 5
    //   174: invokevirtual 234	java/net/HttpURLConnection:getContentLength	()I
    //   177: istore_2
    //   178: new 236	java/io/FileOutputStream
    //   181: dup
    //   182: aload 7
    //   184: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   187: astore 7
    //   189: sipush 4096
    //   192: newarray byte
    //   194: astore 8
    //   196: aload 4
    //   198: aload 8
    //   200: invokevirtual 245	java/io/InputStream:read	([B)I
    //   203: istore_3
    //   204: iload_3
    //   205: iconst_m1
    //   206: if_icmpeq +184 -> 390
    //   209: aload_0
    //   210: getfield 45	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mAbort	Z
    //   213: ifeq +112 -> 325
    //   216: aload 4
    //   218: invokevirtual 248	java/io/InputStream:close	()V
    //   221: aload 7
    //   223: invokevirtual 251	java/io/OutputStream:close	()V
    //   226: return
    //   227: astore 4
    //   229: ldc 125
    //   231: ldc 253
    //   233: aload 4
    //   235: invokestatic 150	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload_0
    //   239: getfield 26	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
    //   242: getfield 259	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   245: aload_0
    //   246: getfield 33	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
    //   249: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   255: pop
    //   256: aload_0
    //   257: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   260: bipush 254
    //   262: aload 4
    //   264: invokevirtual 271	java/io/IOException:getMessage	()Ljava/lang/String;
    //   267: invokeinterface 274 3 0
    //   272: return
    //   273: new 112	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   276: dup
    //   277: iload_1
    //   278: ldc_w 276
    //   281: invokespecial 119	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:<init>	(ILjava/lang/String;)V
    //   284: athrow
    //   285: astore 4
    //   287: aload_0
    //   288: getfield 26	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
    //   291: getfield 259	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   294: aload_0
    //   295: getfield 33	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
    //   298: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: aload_0
    //   306: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   309: aload 4
    //   311: invokevirtual 279	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:getCode	()I
    //   314: aload 4
    //   316: invokevirtual 280	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:getMessage	()Ljava/lang/String;
    //   319: invokeinterface 274 3 0
    //   324: return
    //   325: aload 7
    //   327: aload 8
    //   329: iconst_0
    //   330: iload_3
    //   331: invokevirtual 284	java/io/OutputStream:write	([BII)V
    //   334: iload_2
    //   335: iconst_m1
    //   336: if_icmpeq +34 -> 370
    //   339: aload_0
    //   340: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   343: aload 6
    //   345: invokevirtual 287	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
    //   348: i2f
    //   349: fconst_1
    //   350: fmul
    //   351: iload_2
    //   352: i2f
    //   353: fdiv
    //   354: aload 6
    //   356: invokevirtual 287	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
    //   359: i2l
    //   360: iload_2
    //   361: i2l
    //   362: invokeinterface 291 6 0
    //   367: goto -171 -> 196
    //   370: aload_0
    //   371: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   374: fconst_0
    //   375: aload 6
    //   377: invokevirtual 287	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
    //   380: i2l
    //   381: lconst_0
    //   382: invokeinterface 291 6 0
    //   387: goto -191 -> 196
    //   390: aload 4
    //   392: invokevirtual 248	java/io/InputStream:close	()V
    //   395: aload 7
    //   397: invokevirtual 251	java/io/OutputStream:close	()V
    //   400: aload 5
    //   402: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   405: aload_0
    //   406: getfield 26	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
    //   409: getfield 259	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   412: aload_0
    //   413: getfield 33	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
    //   416: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: aload_0
    //   424: getfield 43	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   427: iload_1
    //   428: aload_0
    //   429: getfield 39	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mFilePath	Ljava/lang/String;
    //   432: new 293	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult
    //   435: dup
    //   436: ldc_w 295
    //   439: ldc2_w 296
    //   442: iconst_1
    //   443: ldc_w 295
    //   446: iconst_1
    //   447: lconst_0
    //   448: lconst_0
    //   449: lconst_0
    //   450: lconst_0
    //   451: lconst_0
    //   452: lconst_0
    //   453: aload 5
    //   455: invokevirtual 206	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   458: invokespecial 300	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:<init>	(Ljava/lang/String;JZLjava/lang/String;ZJJJJJJLjava/util/Map;)V
    //   461: invokeinterface 304 4 0
    //   466: return
    //   467: goto -295 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	DownloadTask
    //   84	344	1	i	int
    //   177	184	2	j	int
    //   203	128	3	k	int
    //   69	3	4	localIOException1	java.io.IOException
    //   112	105	4	localObject1	Object
    //   227	36	4	localIOException2	java.io.IOException
    //   285	106	4	localDownloadException	DownloadException
    //   61	393	5	localHttpURLConnection	HttpURLConnection
    //   119	257	6	localPositionFixedInputStream	DownloaderProxyDefault.DownloadTask.PositionFixedInputStream
    //   11	385	7	localObject2	Object
    //   141	187	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	47	69	java/io/IOException
    //   47	53	69	java/io/IOException
    //   53	63	227	java/io/IOException
    //   79	85	227	java/io/IOException
    //   99	172	227	java/io/IOException
    //   172	196	227	java/io/IOException
    //   196	204	227	java/io/IOException
    //   209	226	227	java/io/IOException
    //   273	285	227	java/io/IOException
    //   325	334	227	java/io/IOException
    //   339	367	227	java/io/IOException
    //   370	387	227	java/io/IOException
    //   390	466	227	java/io/IOException
    //   53	63	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   79	85	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   99	172	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   172	196	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   196	204	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   209	226	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   273	285	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   325	334	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   339	367	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   370	387	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    //   390	466	285	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault.DownloadTask
 * JD-Core Version:    0.7.0.1
 */