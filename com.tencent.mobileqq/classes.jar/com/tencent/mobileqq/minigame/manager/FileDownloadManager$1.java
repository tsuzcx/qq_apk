package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import bkoh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;

final class FileDownloadManager$1
  implements Callback
{
  private long beginEnqueue = SystemClock.uptimeMillis();
  private volatile boolean canceled;
  
  FileDownloadManager$1(String paramString1, DownloaderProxy.DownloadListener paramDownloadListener, String paramString2, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("FileDownloadManager", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$listener.onDownloadFailed(-5, "abort");
    }
    for (;;)
    {
      FileDownloadManager.access$000().remove(this.val$url);
      return;
      this.val$listener.onDownloadFailed(bkoh.a(paramIOException, -1), "request error:network");
    }
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:canceled	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokevirtual 114	okhttp3/Response:code	()I
    //   12: istore 5
    //   14: aload_2
    //   15: invokevirtual 118	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   18: invokevirtual 124	okhttp3/Headers:toMultimap	()Ljava/util/Map;
    //   21: astore 12
    //   23: aload_0
    //   24: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   27: iload 5
    //   29: aload 12
    //   31: invokeinterface 128 3 0
    //   36: new 130	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield 24	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$filePath	Ljava/lang/String;
    //   44: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore_1
    //   51: aload 10
    //   53: invokevirtual 137	java/io/File:exists	()Z
    //   56: ifeq +9 -> 65
    //   59: aload 10
    //   61: invokevirtual 140	java/io/File:delete	()Z
    //   64: pop
    //   65: aload 10
    //   67: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   70: invokevirtual 137	java/io/File:exists	()Z
    //   73: ifne +12 -> 85
    //   76: aload 10
    //   78: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   81: invokevirtual 147	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: aload 10
    //   87: invokevirtual 150	java/io/File:createNewFile	()Z
    //   90: pop
    //   91: invokestatic 35	android/os/SystemClock:uptimeMillis	()J
    //   94: lstore 6
    //   96: aload_2
    //   97: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   100: invokevirtual 160	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   103: astore 11
    //   105: aload_2
    //   106: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   109: invokevirtual 163	okhttp3/ResponseBody:contentLength	()J
    //   112: lstore 8
    //   114: new 165	java/io/FileOutputStream
    //   117: dup
    //   118: aload 10
    //   120: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   123: astore 10
    //   125: sipush 4096
    //   128: newarray byte
    //   130: astore_1
    //   131: iconst_0
    //   132: istore_3
    //   133: aload 11
    //   135: aload_1
    //   136: invokevirtual 174	java/io/InputStream:read	([B)I
    //   139: istore 4
    //   141: iload 4
    //   143: iconst_m1
    //   144: if_icmpeq +139 -> 283
    //   147: aload 10
    //   149: aload_1
    //   150: iconst_0
    //   151: iload 4
    //   153: invokevirtual 180	java/io/OutputStream:write	([BII)V
    //   156: iload_3
    //   157: iload 4
    //   159: iadd
    //   160: istore 4
    //   162: iload 4
    //   164: istore_3
    //   165: lload 8
    //   167: lconst_0
    //   168: lcmp
    //   169: ifle -36 -> 133
    //   172: aload_0
    //   173: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   176: iload 4
    //   178: i2f
    //   179: fconst_1
    //   180: fmul
    //   181: lload 8
    //   183: l2f
    //   184: fdiv
    //   185: iload 4
    //   187: i2l
    //   188: lload 8
    //   190: invokeinterface 184 6 0
    //   195: iload 4
    //   197: istore_3
    //   198: goto -65 -> 133
    //   201: astore_1
    //   202: aload 10
    //   204: astore_1
    //   205: aload_0
    //   206: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   209: iconst_2
    //   210: ldc 186
    //   212: invokeinterface 84 3 0
    //   217: invokestatic 90	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   220: aload_0
    //   221: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   224: invokevirtual 96	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload 11
    //   230: ifnull +8 -> 238
    //   233: aload 11
    //   235: invokevirtual 189	java/io/InputStream:close	()V
    //   238: aload_1
    //   239: ifnull -232 -> 7
    //   242: aload_1
    //   243: invokevirtual 190	java/io/OutputStream:close	()V
    //   246: return
    //   247: astore_1
    //   248: ldc 42
    //   250: iconst_1
    //   251: ldc 192
    //   253: aload_1
    //   254: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   263: iconst_2
    //   264: ldc 186
    //   266: invokeinterface 84 3 0
    //   271: invokestatic 90	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   274: aload_0
    //   275: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   278: invokevirtual 96	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: return
    //   283: aload 11
    //   285: ifnull +8 -> 293
    //   288: aload 11
    //   290: invokevirtual 189	java/io/InputStream:close	()V
    //   293: aload 10
    //   295: ifnull +8 -> 303
    //   298: aload 10
    //   300: invokevirtual 190	java/io/OutputStream:close	()V
    //   303: invokestatic 35	android/os/SystemClock:uptimeMillis	()J
    //   306: lstore 8
    //   308: aload_0
    //   309: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   312: ldc 193
    //   314: iload_3
    //   315: i2l
    //   316: iload_3
    //   317: i2l
    //   318: invokeinterface 184 6 0
    //   323: new 195	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult
    //   326: dup
    //   327: aload_2
    //   328: invokevirtual 199	okhttp3/Response:request	()Lokhttp3/Request;
    //   331: invokevirtual 205	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   334: invokevirtual 208	okhttp3/HttpUrl:toString	()Ljava/lang/String;
    //   337: iload 5
    //   339: i2l
    //   340: aload_2
    //   341: invokevirtual 211	okhttp3/Response:isSuccessful	()Z
    //   344: aload_2
    //   345: invokevirtual 214	okhttp3/Response:message	()Ljava/lang/String;
    //   348: iconst_0
    //   349: lconst_0
    //   350: lconst_0
    //   351: lconst_0
    //   352: lconst_0
    //   353: invokestatic 35	android/os/SystemClock:uptimeMillis	()J
    //   356: aload_0
    //   357: getfield 26	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$startTime	J
    //   360: lsub
    //   361: aload_2
    //   362: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   365: invokevirtual 163	okhttp3/ResponseBody:contentLength	()J
    //   368: aload 12
    //   370: invokespecial 217	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:<init>	(Ljava/lang/String;JZLjava/lang/String;ZJJJJJJLjava/util/Map;)V
    //   373: astore_1
    //   374: aload_0
    //   375: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   378: iload 5
    //   380: aload_0
    //   381: getfield 24	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$filePath	Ljava/lang/String;
    //   384: aload_1
    //   385: invokeinterface 221 4 0
    //   390: invokestatic 90	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   393: aload_0
    //   394: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   397: invokevirtual 96	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: ldc 42
    //   403: iconst_1
    //   404: new 44	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   411: ldc 223
    //   413: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokestatic 35	android/os/SystemClock:uptimeMillis	()J
    //   419: aload_0
    //   420: getfield 37	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:beginEnqueue	J
    //   423: lsub
    //   424: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: ldc 228
    //   429: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: lload 8
    //   434: lload 6
    //   436: lsub
    //   437: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   440: ldc 230
    //   442: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   449: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 232
    //   454: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 235	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: return
    //   464: astore_1
    //   465: ldc 42
    //   467: iconst_1
    //   468: ldc 192
    //   470: aload_1
    //   471: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: goto -181 -> 293
    //   477: astore_1
    //   478: ldc 42
    //   480: iconst_1
    //   481: ldc 192
    //   483: aload_1
    //   484: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   487: goto -184 -> 303
    //   490: astore_2
    //   491: ldc 42
    //   493: iconst_1
    //   494: ldc 192
    //   496: aload_2
    //   497: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   500: goto -262 -> 238
    //   503: astore_1
    //   504: aconst_null
    //   505: astore_2
    //   506: aload 11
    //   508: ifnull +8 -> 516
    //   511: aload 11
    //   513: invokevirtual 189	java/io/InputStream:close	()V
    //   516: aload_2
    //   517: ifnull +7 -> 524
    //   520: aload_2
    //   521: invokevirtual 190	java/io/OutputStream:close	()V
    //   524: aload_1
    //   525: athrow
    //   526: astore 10
    //   528: ldc 42
    //   530: iconst_1
    //   531: ldc 192
    //   533: aload 10
    //   535: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   538: goto -22 -> 516
    //   541: astore_2
    //   542: ldc 42
    //   544: iconst_1
    //   545: ldc 192
    //   547: aload_2
    //   548: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   551: goto -27 -> 524
    //   554: astore_1
    //   555: aload 10
    //   557: astore_2
    //   558: goto -52 -> 506
    //   561: astore 10
    //   563: aload_1
    //   564: astore_2
    //   565: aload 10
    //   567: astore_1
    //   568: goto -62 -> 506
    //   571: astore_2
    //   572: goto -367 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	1
    //   0	575	1	paramCall	Call
    //   0	575	2	paramResponse	okhttp3.Response
    //   132	185	3	i	int
    //   139	57	4	j	int
    //   12	367	5	k	int
    //   94	341	6	l1	long
    //   112	321	8	l2	long
    //   47	252	10	localObject1	Object
    //   526	30	10	localThrowable	java.lang.Throwable
    //   561	5	10	localObject2	Object
    //   103	409	11	localInputStream	java.io.InputStream
    //   21	348	12	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   125	131	201	java/io/IOException
    //   133	141	201	java/io/IOException
    //   147	156	201	java/io/IOException
    //   172	195	201	java/io/IOException
    //   242	246	247	java/lang/Throwable
    //   65	85	258	java/io/IOException
    //   85	91	258	java/io/IOException
    //   288	293	464	java/lang/Throwable
    //   298	303	477	java/lang/Throwable
    //   233	238	490	java/lang/Throwable
    //   114	125	503	finally
    //   511	516	526	java/lang/Throwable
    //   520	524	541	java/lang/Throwable
    //   125	131	554	finally
    //   133	141	554	finally
    //   147	156	554	finally
    //   172	195	554	finally
    //   205	228	561	finally
    //   114	125	571	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */