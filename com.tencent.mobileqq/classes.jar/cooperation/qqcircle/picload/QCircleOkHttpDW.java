package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.util.URLUtil;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class QCircleOkHttpDW
  extends AbsPicDW
{
  private static final String TAG = "QCircleOkHttpDW";
  private static OkHttpClient sClient = QCircleOkHttpFactory.createOkHttpClient(10, 128, 10);
  
  private void closeStream(FileOutputStream paramFileOutputStream, InputStream paramInputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      if (paramInputStream != null) {
        paramInputStream.close();
      }
      return;
    }
    catch (Exception paramFileOutputStream)
    {
      paramFileOutputStream.printStackTrace();
      RFLog.d("QCircleOkHttpDW", RFLog.USR, "closeStream exception" + paramFileOutputStream.getMessage());
    }
  }
  
  private void handleException(Option paramOption, File paramFile1, File paramFile2, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if ((paramFile1 != null) && (paramFile1.exists())) {
      paramFile1.delete();
    }
    if ((paramFile2 != null) && (paramFile2.exists())) {
      paramFile2.delete();
    }
    handleNext(paramOption, paramICallBackListener);
  }
  
  private void handleNext(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (getNextDw() != null)
    {
      RFLog.i("QCircleOkHttpDW", RFLog.USR, "seq = " + paramOption.getSeq() + "okHttp（） use httpUrlConnection");
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
  
  private void okHttpDownload(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (!URLUtil.a(paramOption.getUrl()))
    {
      RFLog.i("QCircleOkHttpDW", RFLog.USR, paramOption.getSeq() + " url is unValid:" + paramOption.getUrl());
      return;
    }
    String str1 = MsfSdkUtils.insertMtype("yingyongbao", paramOption.getUrl());
    String str2 = QCircleCommonUtil.getUrlHost(str1);
    String str3 = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", str1, str2);
    if (!str1.equals(str3)) {}
    for (boolean bool = true;; bool = false)
    {
      Request localRequest = new Request.Builder().url(str1).get().build();
      if (bool)
      {
        localRequest = new Request.Builder().url(str3).get().build();
        HttpUrl localHttpUrl = localRequest.url().newBuilder().host(str2).build();
        localRequest = localRequest.newBuilder().url(localHttpUrl).build();
        RFLog.i("QCircleOkHttpDW", RFLog.USR, "seq = " + paramOption.getSeq() + "okHttp（）hasConvert:" + bool + "\nafter convert :origin:" + str1 + "\nconvert:" + str3 + "\nhost:" + str2);
      }
      if (sClient == null) {
        break;
      }
      sClient.newCall(localRequest).enqueue(new QCircleOkHttpDW.1(this, paramOption, paramICallBackListener));
      return;
    }
  }
  
  public static void release()
  {
    Iterator localIterator;
    if (sClient != null) {
      try
      {
        List localList1 = sClient.dispatcher().queuedCalls();
        localIterator = localList1.iterator();
        RFLog.d("QCircleOkHttpDW", RFLog.USR, "release okHttpDW queue size:" + localList1.size());
        while (localIterator.hasNext())
        {
          ((Call)localIterator.next()).cancel();
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        RFLog.d("QCircleOkHttpDW", RFLog.USR, "release exception" + localException.getMessage());
      }
    }
    for (;;)
    {
      List localList2 = sClient.dispatcher().runningCalls();
      localIterator = localList2.iterator();
      RFLog.d("QCircleOkHttpDW", RFLog.USR, "release okHttpDW running size:" + localList2.size());
      while (localIterator.hasNext()) {
        ((Call)localIterator.next()).cancel();
      }
    }
  }
  
  /* Error */
  private void writeToFile(Option paramOption, okhttp3.Response paramResponse, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aload_1
    //   10: ifnull +11 -> 21
    //   13: aload_2
    //   14: ifnull +7 -> 21
    //   17: aload_3
    //   18: ifnonnull +4 -> 22
    //   21: return
    //   22: aload_2
    //   23: invokevirtual 266	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   26: invokevirtual 272	okhttp3/ResponseBody:contentLength	()J
    //   29: lstore 5
    //   31: invokestatic 277	cooperation/qqcircle/picload/QCircleHttpUrlDW:getSDCardAvailableCount	()J
    //   34: lload 5
    //   36: lcmp
    //   37: ifge +81 -> 118
    //   40: ldc 8
    //   42: getstatic 57	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   45: new 59	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   52: ldc 94
    //   54: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 100	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   61: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 279
    //   67: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 282	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 284
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 115	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   87: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 286
    //   93: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 108	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_3
    //   103: aload_1
    //   104: iconst_0
    //   105: iconst_1
    //   106: invokeinterface 292 4 0
    //   111: aload_0
    //   112: aconst_null
    //   113: aconst_null
    //   114: invokespecial 294	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   117: return
    //   118: aload_1
    //   119: invokevirtual 297	com/tencent/mobileqq/qcircle/api/data/Option:getLocalPath	()Ljava/lang/String;
    //   122: astore 12
    //   124: new 81	java/io/File
    //   127: dup
    //   128: new 59	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   135: aload 12
    //   137: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 299
    //   143: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore 8
    //   154: aload 8
    //   156: invokevirtual 305	java/io/File:getParent	()Ljava/lang/String;
    //   159: ifnull +23 -> 182
    //   162: aload 8
    //   164: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   167: invokevirtual 85	java/io/File:exists	()Z
    //   170: ifne +12 -> 182
    //   173: aload 8
    //   175: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   178: invokevirtual 312	java/io/File:mkdirs	()Z
    //   181: pop
    //   182: aload 8
    //   184: invokevirtual 85	java/io/File:exists	()Z
    //   187: ifeq +9 -> 196
    //   190: aload 8
    //   192: invokevirtual 88	java/io/File:delete	()Z
    //   195: pop
    //   196: aload 8
    //   198: invokevirtual 315	java/io/File:createNewFile	()Z
    //   201: pop
    //   202: new 42	java/io/FileOutputStream
    //   205: dup
    //   206: new 59	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   213: aload 12
    //   215: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 299
    //   221: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: iconst_1
    //   228: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   231: astore 7
    //   233: aload_2
    //   234: invokevirtual 266	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   237: invokevirtual 322	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   240: astore_2
    //   241: sipush 8192
    //   244: newarray byte
    //   246: astore 9
    //   248: aload_2
    //   249: aload 9
    //   251: iconst_0
    //   252: sipush 8192
    //   255: invokevirtual 326	java/io/InputStream:read	([BII)I
    //   258: istore 4
    //   260: iload 4
    //   262: ifle +108 -> 370
    //   265: aload 7
    //   267: aload 9
    //   269: iconst_0
    //   270: iload 4
    //   272: invokevirtual 330	java/io/FileOutputStream:write	([BII)V
    //   275: goto -27 -> 248
    //   278: astore 11
    //   280: aload 7
    //   282: astore 9
    //   284: aload_2
    //   285: astore 7
    //   287: aload 9
    //   289: astore_2
    //   290: aload 8
    //   292: astore 9
    //   294: aload 11
    //   296: astore 8
    //   298: aload_0
    //   299: aload_1
    //   300: aload 9
    //   302: aload 10
    //   304: aload_3
    //   305: invokespecial 332	cooperation/qqcircle/picload/QCircleOkHttpDW:handleException	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Ljava/io/File;Ljava/io/File;Lcooperation/qqcircle/picload/AbsPicDW$ICallBackListener;)V
    //   308: ldc 8
    //   310: getstatic 57	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   313: new 59	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   320: ldc 94
    //   322: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 100	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   329: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 334
    //   335: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 282	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   342: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 336
    //   348: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 8
    //   353: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 342	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: aload_2
    //   364: aload 7
    //   366: invokespecial 294	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   369: return
    //   370: aload 7
    //   372: invokevirtual 345	java/io/FileOutputStream:flush	()V
    //   375: new 81	java/io/File
    //   378: dup
    //   379: aload 12
    //   381: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: astore 9
    //   386: aload 9
    //   388: invokevirtual 85	java/io/File:exists	()Z
    //   391: ifeq +9 -> 400
    //   394: aload 9
    //   396: invokevirtual 88	java/io/File:delete	()Z
    //   399: pop
    //   400: aload 8
    //   402: aload 9
    //   404: invokevirtual 349	java/io/File:renameTo	(Ljava/io/File;)Z
    //   407: pop
    //   408: ldc 8
    //   410: getstatic 57	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   413: new 59	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   420: ldc 94
    //   422: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_1
    //   426: invokevirtual 100	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   429: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 351
    //   435: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 282	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   442: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 284
    //   448: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_1
    //   452: invokevirtual 115	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   455: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 108	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_3
    //   465: aload_1
    //   466: iconst_1
    //   467: iconst_0
    //   468: invokeinterface 292 4 0
    //   473: aload_0
    //   474: aload 7
    //   476: aload_2
    //   477: invokespecial 294	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   480: return
    //   481: astore 8
    //   483: aconst_null
    //   484: astore_2
    //   485: aload 9
    //   487: astore 7
    //   489: ldc 8
    //   491: getstatic 57	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   494: new 59	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   501: ldc 94
    //   503: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_1
    //   507: invokevirtual 100	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   510: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: ldc_w 334
    //   516: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_1
    //   520: invokevirtual 282	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   523: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc_w 353
    //   529: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 8
    //   534: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 342	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: aload_0
    //   544: aload_1
    //   545: aload_3
    //   546: invokespecial 30	cooperation/qqcircle/picload/QCircleOkHttpDW:handleNext	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Lcooperation/qqcircle/picload/AbsPicDW$ICallBackListener;)V
    //   549: aload_0
    //   550: aload 7
    //   552: aload_2
    //   553: invokespecial 294	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   556: return
    //   557: astore_1
    //   558: aconst_null
    //   559: astore_2
    //   560: aload 11
    //   562: astore_3
    //   563: aload_0
    //   564: aload_3
    //   565: aload_2
    //   566: invokespecial 294	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   569: aload_1
    //   570: athrow
    //   571: astore_1
    //   572: aconst_null
    //   573: astore_2
    //   574: aload 7
    //   576: astore_3
    //   577: goto -14 -> 563
    //   580: astore_1
    //   581: aload 7
    //   583: astore_3
    //   584: goto -21 -> 563
    //   587: astore_1
    //   588: aload_2
    //   589: astore_3
    //   590: aload 7
    //   592: astore_2
    //   593: goto -30 -> 563
    //   596: astore_1
    //   597: aload 7
    //   599: astore_3
    //   600: goto -37 -> 563
    //   603: astore 8
    //   605: aconst_null
    //   606: astore_2
    //   607: goto -118 -> 489
    //   610: astore 8
    //   612: goto -123 -> 489
    //   615: astore 8
    //   617: aconst_null
    //   618: astore 9
    //   620: aconst_null
    //   621: astore_2
    //   622: aconst_null
    //   623: astore 7
    //   625: goto -327 -> 298
    //   628: astore 11
    //   630: aload 8
    //   632: astore 9
    //   634: aconst_null
    //   635: astore 7
    //   637: aconst_null
    //   638: astore_2
    //   639: aload 11
    //   641: astore 8
    //   643: goto -345 -> 298
    //   646: astore 11
    //   648: aload 8
    //   650: astore 9
    //   652: aload 7
    //   654: astore_2
    //   655: aconst_null
    //   656: astore 7
    //   658: aload 11
    //   660: astore 8
    //   662: goto -364 -> 298
    //   665: astore 12
    //   667: aload 9
    //   669: astore 10
    //   671: aload 8
    //   673: astore 9
    //   675: aload_2
    //   676: astore 11
    //   678: aload 12
    //   680: astore 8
    //   682: aload 7
    //   684: astore_2
    //   685: aload 11
    //   687: astore 7
    //   689: goto -391 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	this	QCircleOkHttpDW
    //   0	692	1	paramOption	Option
    //   0	692	2	paramResponse	okhttp3.Response
    //   0	692	3	paramICallBackListener	AbsPicDW.ICallBackListener
    //   258	13	4	i	int
    //   29	6	5	l	long
    //   231	457	7	localObject1	java.lang.Object
    //   152	249	8	localObject2	java.lang.Object
    //   481	52	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   603	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   610	1	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   615	16	8	localException1	Exception
    //   641	40	8	localException2	Exception
    //   1	673	9	localObject3	java.lang.Object
    //   7	663	10	localObject4	java.lang.Object
    //   4	1	11	localObject5	java.lang.Object
    //   278	283	11	localException3	Exception
    //   628	12	11	localException4	Exception
    //   646	13	11	localException5	Exception
    //   676	10	11	localResponse	okhttp3.Response
    //   122	258	12	str	String
    //   665	14	12	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   241	248	278	java/lang/Exception
    //   248	260	278	java/lang/Exception
    //   265	275	278	java/lang/Exception
    //   370	386	278	java/lang/Exception
    //   22	111	481	java/lang/OutOfMemoryError
    //   118	154	481	java/lang/OutOfMemoryError
    //   154	182	481	java/lang/OutOfMemoryError
    //   182	196	481	java/lang/OutOfMemoryError
    //   196	233	481	java/lang/OutOfMemoryError
    //   22	111	557	finally
    //   118	154	557	finally
    //   154	182	557	finally
    //   182	196	557	finally
    //   196	233	557	finally
    //   233	241	571	finally
    //   241	248	580	finally
    //   248	260	580	finally
    //   265	275	580	finally
    //   370	386	580	finally
    //   386	400	580	finally
    //   400	473	580	finally
    //   298	362	587	finally
    //   489	549	596	finally
    //   233	241	603	java/lang/OutOfMemoryError
    //   241	248	610	java/lang/OutOfMemoryError
    //   248	260	610	java/lang/OutOfMemoryError
    //   265	275	610	java/lang/OutOfMemoryError
    //   370	386	610	java/lang/OutOfMemoryError
    //   386	400	610	java/lang/OutOfMemoryError
    //   400	473	610	java/lang/OutOfMemoryError
    //   22	111	615	java/lang/Exception
    //   118	154	615	java/lang/Exception
    //   154	182	628	java/lang/Exception
    //   182	196	628	java/lang/Exception
    //   196	233	628	java/lang/Exception
    //   233	241	646	java/lang/Exception
    //   386	400	665	java/lang/Exception
    //   400	473	665	java/lang/Exception
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (QCircleConfig.useOkHttpDownLoadPic())
    {
      RFLog.i("QCircleOkHttpDW", RFLog.USR, "seq = " + paramOption.getSeq() + "okHttp（） use OkHttp");
      okHttpDownload(paramOption, paramICallBackListener);
      return;
    }
    handleNext(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW
 * JD-Core Version:    0.7.0.1
 */