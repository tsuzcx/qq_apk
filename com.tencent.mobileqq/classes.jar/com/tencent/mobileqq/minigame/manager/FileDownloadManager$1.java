package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.HttpUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;

final class FileDownloadManager$1
  implements Callback
{
  private long beginEnqueue = SystemClock.uptimeMillis();
  private volatile boolean canceled = false;
  
  FileDownloadManager$1(String paramString1, DownloaderProxy.DownloadListener paramDownloadListener, String paramString2, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.val$url);
    QLog.e("FileDownloadManager", 1, paramCall.toString(), paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$listener.onDownloadFailed(-5, "abort");
    }
    else
    {
      this.val$listener.onDownloadFailed(HttpUtil.a(paramIOException, -1), "request error:network");
    }
    FileDownloadManager.access$000().remove(this.val$url);
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:canceled	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokevirtual 114	okhttp3/Response:code	()I
    //   12: istore 5
    //   14: aload_2
    //   15: invokevirtual 118	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   18: invokevirtual 124	okhttp3/Headers:toMultimap	()Ljava/util/Map;
    //   21: astore 17
    //   23: aload_0
    //   24: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   27: iload 5
    //   29: aload 17
    //   31: invokeinterface 128 3 0
    //   36: new 130	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield 24	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$filePath	Ljava/lang/String;
    //   44: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: aconst_null
    //   49: astore 14
    //   51: aconst_null
    //   52: astore 13
    //   54: aload_1
    //   55: invokevirtual 137	java/io/File:exists	()Z
    //   58: ifeq +8 -> 66
    //   61: aload_1
    //   62: invokevirtual 140	java/io/File:delete	()Z
    //   65: pop
    //   66: aload_1
    //   67: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   70: invokevirtual 137	java/io/File:exists	()Z
    //   73: ifne +11 -> 84
    //   76: aload_1
    //   77: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   80: invokevirtual 147	java/io/File:mkdirs	()Z
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 150	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   92: lstore 9
    //   94: aload_2
    //   95: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   98: invokevirtual 160	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   101: astore 16
    //   103: aload_2
    //   104: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   107: invokevirtual 163	okhttp3/ResponseBody:contentLength	()J
    //   110: lstore 7
    //   112: new 165	java/io/FileOutputStream
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_1
    //   121: aload_1
    //   122: astore 13
    //   124: aload_1
    //   125: astore 14
    //   127: sipush 4096
    //   130: newarray byte
    //   132: astore 15
    //   134: iconst_0
    //   135: istore 4
    //   137: aload_1
    //   138: astore 13
    //   140: aload_1
    //   141: astore 14
    //   143: aload 16
    //   145: aload 15
    //   147: invokevirtual 174	java/io/InputStream:read	([B)I
    //   150: istore 6
    //   152: iload 6
    //   154: iconst_m1
    //   155: if_icmpeq +86 -> 241
    //   158: aload_1
    //   159: aload 15
    //   161: iconst_0
    //   162: iload 6
    //   164: invokevirtual 180	java/io/OutputStream:write	([BII)V
    //   167: iload 4
    //   169: iload 6
    //   171: iadd
    //   172: istore 4
    //   174: lload 7
    //   176: lconst_0
    //   177: lcmp
    //   178: ifle +43 -> 221
    //   181: aload_0
    //   182: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   185: astore 13
    //   187: iload 4
    //   189: i2f
    //   190: fconst_1
    //   191: fmul
    //   192: lload 7
    //   194: l2f
    //   195: fdiv
    //   196: fstore_3
    //   197: iload 4
    //   199: i2l
    //   200: lstore 11
    //   202: aload 13
    //   204: fload_3
    //   205: lload 11
    //   207: lload 7
    //   209: invokeinterface 184 6 0
    //   214: goto +7 -> 221
    //   217: astore_2
    //   218: goto +7 -> 225
    //   221: goto -84 -> 137
    //   224: astore_2
    //   225: aload_1
    //   226: astore 13
    //   228: aload_2
    //   229: astore_1
    //   230: aload 13
    //   232: astore_2
    //   233: goto +324 -> 557
    //   236: aload_1
    //   237: astore_2
    //   238: goto +249 -> 487
    //   241: aload 16
    //   243: ifnull +23 -> 266
    //   246: aload 16
    //   248: invokevirtual 187	java/io/InputStream:close	()V
    //   251: goto +15 -> 266
    //   254: astore 13
    //   256: ldc 53
    //   258: iconst_1
    //   259: ldc 189
    //   261: aload 13
    //   263: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_1
    //   267: invokevirtual 190	java/io/OutputStream:close	()V
    //   270: goto +13 -> 283
    //   273: astore_1
    //   274: ldc 53
    //   276: iconst_1
    //   277: ldc 189
    //   279: aload_1
    //   280: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   286: lstore 7
    //   288: aload_0
    //   289: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   292: astore_1
    //   293: iload 4
    //   295: i2l
    //   296: lstore 11
    //   298: aload_1
    //   299: ldc 191
    //   301: lload 11
    //   303: lload 11
    //   305: invokeinterface 184 6 0
    //   310: new 193	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult
    //   313: dup
    //   314: aload_2
    //   315: invokevirtual 197	okhttp3/Response:request	()Lokhttp3/Request;
    //   318: invokevirtual 203	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   321: invokevirtual 206	okhttp3/HttpUrl:toString	()Ljava/lang/String;
    //   324: iload 5
    //   326: i2l
    //   327: aload_2
    //   328: invokevirtual 209	okhttp3/Response:isSuccessful	()Z
    //   331: aload_2
    //   332: invokevirtual 212	okhttp3/Response:message	()Ljava/lang/String;
    //   335: iconst_0
    //   336: lconst_0
    //   337: lconst_0
    //   338: lconst_0
    //   339: lconst_0
    //   340: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   343: aload_0
    //   344: getfield 26	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$startTime	J
    //   347: lsub
    //   348: aload_2
    //   349: invokevirtual 154	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   352: invokevirtual 163	okhttp3/ResponseBody:contentLength	()J
    //   355: aload 17
    //   357: invokespecial 215	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:<init>	(Ljava/lang/String;JZLjava/lang/String;ZJJJJJJLjava/util/Map;)V
    //   360: astore_1
    //   361: aload_0
    //   362: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   365: iload 5
    //   367: aload_0
    //   368: getfield 24	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$filePath	Ljava/lang/String;
    //   371: aload_1
    //   372: invokeinterface 219 4 0
    //   377: invokestatic 98	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   380: aload_0
    //   381: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   384: invokevirtual 104	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   387: pop
    //   388: new 44	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   395: astore_1
    //   396: aload_1
    //   397: ldc 221
    //   399: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_1
    //   404: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   407: aload_0
    //   408: getfield 39	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:beginEnqueue	J
    //   411: lsub
    //   412: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_1
    //   417: ldc 226
    //   419: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_1
    //   424: lload 7
    //   426: lload 9
    //   428: lsub
    //   429: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_1
    //   434: ldc 228
    //   436: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_1
    //   441: aload_0
    //   442: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   445: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: ldc 230
    //   452: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc 53
    //   458: iconst_1
    //   459: aload_1
    //   460: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: return
    //   467: astore_1
    //   468: aload 13
    //   470: astore_2
    //   471: goto +86 -> 557
    //   474: aload 14
    //   476: astore_2
    //   477: goto +10 -> 487
    //   480: astore_1
    //   481: aload 13
    //   483: astore_2
    //   484: goto +73 -> 557
    //   487: aload_0
    //   488: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   491: iconst_2
    //   492: ldc 235
    //   494: invokeinterface 84 3 0
    //   499: invokestatic 98	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   502: aload_0
    //   503: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   506: invokevirtual 104	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   509: pop
    //   510: aload 16
    //   512: ifnull +21 -> 533
    //   515: aload 16
    //   517: invokevirtual 187	java/io/InputStream:close	()V
    //   520: goto +13 -> 533
    //   523: astore_1
    //   524: ldc 53
    //   526: iconst_1
    //   527: ldc 189
    //   529: aload_1
    //   530: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload_2
    //   534: ifnull +18 -> 552
    //   537: aload_2
    //   538: invokevirtual 190	java/io/OutputStream:close	()V
    //   541: return
    //   542: astore_1
    //   543: ldc 53
    //   545: iconst_1
    //   546: ldc 189
    //   548: aload_1
    //   549: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: return
    //   553: astore_1
    //   554: goto -70 -> 484
    //   557: aload 16
    //   559: ifnull +23 -> 582
    //   562: aload 16
    //   564: invokevirtual 187	java/io/InputStream:close	()V
    //   567: goto +15 -> 582
    //   570: astore 13
    //   572: ldc 53
    //   574: iconst_1
    //   575: ldc 189
    //   577: aload 13
    //   579: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   582: aload_2
    //   583: ifnull +20 -> 603
    //   586: aload_2
    //   587: invokevirtual 190	java/io/OutputStream:close	()V
    //   590: goto +13 -> 603
    //   593: astore_2
    //   594: ldc 53
    //   596: iconst_1
    //   597: ldc 189
    //   599: aload_2
    //   600: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   603: aload_1
    //   604: athrow
    //   605: aload_0
    //   606: getfield 22	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$listener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
    //   609: iconst_2
    //   610: ldc 235
    //   612: invokeinterface 84 3 0
    //   617: invokestatic 98	com/tencent/mobileqq/minigame/manager/FileDownloadManager:access$000	()Ljava/util/concurrent/ConcurrentHashMap;
    //   620: aload_0
    //   621: getfield 20	com/tencent/mobileqq/minigame/manager/FileDownloadManager$1:val$url	Ljava/lang/String;
    //   624: invokevirtual 104	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: return
    //   629: astore_1
    //   630: goto -25 -> 605
    //   633: astore_1
    //   634: aload 14
    //   636: astore_2
    //   637: goto -150 -> 487
    //   640: astore_1
    //   641: goto -167 -> 474
    //   644: astore_2
    //   645: goto -409 -> 236
    //   648: astore_2
    //   649: goto -413 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	1
    //   0	652	1	paramCall	Call
    //   0	652	2	paramResponse	okhttp3.Response
    //   196	9	3	f	float
    //   135	159	4	i	int
    //   12	354	5	j	int
    //   150	22	6	k	int
    //   110	315	7	l1	long
    //   92	335	9	l2	long
    //   200	104	11	l3	long
    //   52	179	13	localObject	Object
    //   254	228	13	localThrowable1	java.lang.Throwable
    //   570	8	13	localThrowable2	java.lang.Throwable
    //   49	586	14	localCall	Call
    //   132	28	15	arrayOfByte	byte[]
    //   101	462	16	localInputStream	java.io.InputStream
    //   21	335	17	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   202	214	217	finally
    //   158	167	224	finally
    //   181	187	224	finally
    //   246	251	254	java/lang/Throwable
    //   266	270	273	java/lang/Throwable
    //   127	134	467	finally
    //   143	152	467	finally
    //   112	121	480	finally
    //   515	520	523	java/lang/Throwable
    //   537	541	542	java/lang/Throwable
    //   487	510	553	finally
    //   562	567	570	java/lang/Throwable
    //   586	590	593	java/lang/Throwable
    //   66	84	629	java/io/IOException
    //   84	89	629	java/io/IOException
    //   112	121	633	java/io/IOException
    //   127	134	640	java/io/IOException
    //   143	152	640	java/io/IOException
    //   158	167	644	java/io/IOException
    //   181	187	644	java/io/IOException
    //   202	214	648	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */