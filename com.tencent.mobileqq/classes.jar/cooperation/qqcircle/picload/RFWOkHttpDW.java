package cooperation.qqcircle.picload;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.cooperation.config.QCircleUrlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
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

public class RFWOkHttpDW
  extends RFWAbsPicDW
{
  private static final String TAG = "QCircleOkHttpDW";
  private static final OkHttpClient sClient = RFWPicDownloadOkHttpFactory.createOkHttpClient(10, 128, 10, sTimeOut);
  private static final RFWPicOKHttpDynamicTimeout sTimeOut = new RFWPicOKHttpDynamicTimeout();
  
  private void closeStream(FileOutputStream paramFileOutputStream, InputStream paramInputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      if (paramInputStream == null) {
        break label58;
      }
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      label20:
      break label20;
    }
    paramInputStream.printStackTrace();
    paramFileOutputStream = new StringBuilder();
    paramFileOutputStream.append("closeStream exception");
    paramFileOutputStream.append(paramInputStream.getMessage());
    QLog.d("QCircleOkHttpDW", 1, paramFileOutputStream.toString());
    label58:
  }
  
  private void handleException(Option paramOption, File paramFile1, File paramFile2, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    if ((paramFile1 != null) && (paramFile1.exists())) {
      paramFile1.delete();
    }
    if ((paramFile2 != null) && (paramFile2.exists())) {
      paramFile2.delete();
    }
    handleRetry(paramOption, paramICallBackListener);
  }
  
  private void handleNext(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (getNextDw() != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("okHttp（） use httpUrlConnection");
      QLog.i("QCircleOkHttpDW", 1, localStringBuilder.toString());
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
  
  private void handleRetry(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    paramOption.updateRetryCount();
    boolean bool = paramOption.continueRetry();
    if (bool) {
      okHttpDownload(paramOption, paramICallBackListener);
    } else {
      handleNext(paramOption, paramICallBackListener);
    }
    paramICallBackListener = new StringBuilder();
    paramICallBackListener.append("seq = ");
    paramICallBackListener.append(paramOption.getSeq());
    paramICallBackListener.append(" continue try:");
    paramICallBackListener.append(bool);
    paramICallBackListener.append(" retry currentTimes:");
    paramICallBackListener.append(paramOption.getRetryCount());
    QLog.i("QCircleOkHttpDW", 1, paramICallBackListener.toString());
  }
  
  private void okHttpDownload(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (!URLUtil.e(paramOption.getUrl()))
    {
      paramICallBackListener = new StringBuilder();
      paramICallBackListener.append(paramOption.getSeq());
      paramICallBackListener.append(" url is unValid:");
      paramICallBackListener.append(paramOption.getUrl());
      QLog.i("QCircleOkHttpDW", 1, paramICallBackListener.toString());
      return;
    }
    Object localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramOption.getUrl());
    String str1 = QCircleUrlUtil.a((String)localObject1);
    String str2 = QCircleUrlUtil.a("PhotoSvrList", "DownloadPhotoHttps", (String)localObject1, str1);
    boolean bool = ((String)localObject1).equals(str2) ^ true;
    Request localRequest = new Request.Builder().addHeader("Connection", "close").url((String)localObject1).get().build();
    if (bool)
    {
      localRequest = new Request.Builder().url(str2).get().build();
      Object localObject2 = localRequest.url().newBuilder().host(str1).build();
      localRequest = localRequest.newBuilder().addHeader("Connection", "close").url((HttpUrl)localObject2).build();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("seq = ");
      ((StringBuilder)localObject2).append(paramOption.getSeq());
      ((StringBuilder)localObject2).append("okHttp（）hasConvert:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("\nafter convert :origin:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\nconvert:");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("\nhost:");
      ((StringBuilder)localObject2).append(str1);
      QLog.i("QCircleOkHttpDW", 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = sClient;
    if (localObject1 != null) {
      ((OkHttpClient)localObject1).newCall(localRequest).enqueue(new RFWOkHttpDW.1(this, paramOption, paramICallBackListener));
    }
  }
  
  public static void release()
  {
    Object localObject1 = sClient;
    if (localObject1 != null) {
      try
      {
        localObject1 = ((OkHttpClient)localObject1).dispatcher().queuedCalls();
        Object localObject2 = ((List)localObject1).iterator();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release okHttpDW queue size:");
        localStringBuilder.append(((List)localObject1).size());
        QLog.d("QCircleOkHttpDW", 1, localStringBuilder.toString());
        while (((Iterator)localObject2).hasNext()) {
          ((Call)((Iterator)localObject2).next()).cancel();
        }
        localObject1 = sClient.dispatcher().runningCalls();
        localObject2 = ((List)localObject1).iterator();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("release okHttpDW running size:");
        localStringBuilder.append(((List)localObject1).size());
        QLog.d("QCircleOkHttpDW", 1, localStringBuilder.toString());
        while (((Iterator)localObject2).hasNext()) {
          ((Call)((Iterator)localObject2).next()).cancel();
        }
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("release exception");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("QCircleOkHttpDW", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void upDateTimeOut(Option paramOption, boolean paramBoolean)
  {
    sTimeOut.upDateTimeOut(paramBoolean, paramOption.getSeq());
  }
  
  /* Error */
  private void writeToFile(Option paramOption, okhttp3.Response paramResponse, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +964 -> 965
    //   4: aload_2
    //   5: ifnull +960 -> 965
    //   8: aload_3
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aconst_null
    //   14: astore 13
    //   16: aconst_null
    //   17: astore 10
    //   19: aload_2
    //   20: invokevirtual 299	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   23: invokevirtual 305	okhttp3/ResponseBody:contentLength	()J
    //   26: lstore 5
    //   28: invokestatic 310	cooperation/qqcircle/picload/RFWHttpUrlDW:getSDCardAvailableCount	()J
    //   31: lstore 7
    //   33: lload 7
    //   35: lload 5
    //   37: lcmp
    //   38: ifge +123 -> 161
    //   41: new 60	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   48: astore_2
    //   49: aload_2
    //   50: ldc 98
    //   52: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: aload_1
    //   58: invokevirtual 104	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   61: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc_w 312
    //   69: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: aload_1
    //   75: invokevirtual 315	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   78: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: ldc_w 317
    //   86: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 140	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   95: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc_w 319
    //   103: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 8
    //   109: iconst_1
    //   110: aload_2
    //   111: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_3
    //   118: aload_1
    //   119: iconst_0
    //   120: iconst_1
    //   121: invokeinterface 325 4 0
    //   126: aload_0
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokespecial 327	cooperation/qqcircle/picload/RFWOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   132: return
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: goto +819 -> 957
    //   141: astore 11
    //   143: aconst_null
    //   144: astore_2
    //   145: goto +525 -> 670
    //   148: astore 12
    //   150: aconst_null
    //   151: astore 11
    //   153: aconst_null
    //   154: astore 10
    //   156: aconst_null
    //   157: astore_2
    //   158: goto +620 -> 778
    //   161: aload_1
    //   162: invokevirtual 330	com/tencent/mobileqq/qcircle/api/data/Option:getLocalPath	()Ljava/lang/String;
    //   165: astore 12
    //   167: new 60	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   174: astore 11
    //   176: aload 11
    //   178: aload 12
    //   180: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 11
    //   186: ldc_w 332
    //   189: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: new 84	java/io/File
    //   196: dup
    //   197: aload 11
    //   199: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 11
    //   207: aload 11
    //   209: invokevirtual 338	java/io/File:getParent	()Ljava/lang/String;
    //   212: astore 14
    //   214: aload 14
    //   216: ifnull +31 -> 247
    //   219: aload 11
    //   221: invokevirtual 342	java/io/File:getParentFile	()Ljava/io/File;
    //   224: invokevirtual 88	java/io/File:exists	()Z
    //   227: ifne +20 -> 247
    //   230: aload 11
    //   232: invokevirtual 342	java/io/File:getParentFile	()Ljava/io/File;
    //   235: invokevirtual 345	java/io/File:mkdirs	()Z
    //   238: pop
    //   239: goto +8 -> 247
    //   242: astore 12
    //   244: goto -91 -> 153
    //   247: aload 11
    //   249: invokevirtual 88	java/io/File:exists	()Z
    //   252: istore 9
    //   254: iload 9
    //   256: ifeq +9 -> 265
    //   259: aload 11
    //   261: invokevirtual 91	java/io/File:delete	()Z
    //   264: pop
    //   265: aload 11
    //   267: invokevirtual 348	java/io/File:createNewFile	()Z
    //   270: pop
    //   271: new 60	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   278: astore 10
    //   280: aload 10
    //   282: aload 12
    //   284: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 10
    //   290: ldc_w 332
    //   293: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: new 49	java/io/FileOutputStream
    //   300: dup
    //   301: aload 10
    //   303: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: iconst_1
    //   307: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   310: astore 10
    //   312: aload_2
    //   313: invokevirtual 299	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   316: invokevirtual 355	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   319: astore_2
    //   320: aload 10
    //   322: astore 14
    //   324: aload_2
    //   325: astore 15
    //   327: sipush 8192
    //   330: newarray byte
    //   332: astore 13
    //   334: aload 10
    //   336: astore 14
    //   338: aload_2
    //   339: astore 15
    //   341: aload_2
    //   342: aload 13
    //   344: iconst_0
    //   345: sipush 8192
    //   348: invokevirtual 359	java/io/InputStream:read	([BII)I
    //   351: istore 4
    //   353: iload 4
    //   355: ifle +23 -> 378
    //   358: aload 10
    //   360: astore 14
    //   362: aload_2
    //   363: astore 15
    //   365: aload 10
    //   367: aload 13
    //   369: iconst_0
    //   370: iload 4
    //   372: invokevirtual 363	java/io/FileOutputStream:write	([BII)V
    //   375: goto -41 -> 334
    //   378: aload 10
    //   380: astore 14
    //   382: aload_2
    //   383: astore 15
    //   385: aload 10
    //   387: invokevirtual 366	java/io/FileOutputStream:flush	()V
    //   390: aload 10
    //   392: astore 14
    //   394: aload_2
    //   395: astore 15
    //   397: new 84	java/io/File
    //   400: dup
    //   401: aload 12
    //   403: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   406: astore 13
    //   408: aload 10
    //   410: astore 14
    //   412: aload_2
    //   413: astore 15
    //   415: aload 13
    //   417: invokevirtual 88	java/io/File:exists	()Z
    //   420: ifeq +16 -> 436
    //   423: aload 10
    //   425: astore 14
    //   427: aload_2
    //   428: astore 15
    //   430: aload 13
    //   432: invokevirtual 91	java/io/File:delete	()Z
    //   435: pop
    //   436: aload 10
    //   438: astore 14
    //   440: aload_2
    //   441: astore 15
    //   443: aload 11
    //   445: aload 13
    //   447: invokevirtual 370	java/io/File:renameTo	(Ljava/io/File;)Z
    //   450: pop
    //   451: aload 10
    //   453: astore 14
    //   455: aload_2
    //   456: astore 15
    //   458: new 60	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   465: astore 12
    //   467: aload 10
    //   469: astore 14
    //   471: aload_2
    //   472: astore 15
    //   474: aload 12
    //   476: ldc 98
    //   478: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 10
    //   484: astore 14
    //   486: aload_2
    //   487: astore 15
    //   489: aload 12
    //   491: aload_1
    //   492: invokevirtual 104	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   495: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload 10
    //   501: astore 14
    //   503: aload_2
    //   504: astore 15
    //   506: aload 12
    //   508: ldc_w 372
    //   511: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 10
    //   517: astore 14
    //   519: aload_2
    //   520: astore 15
    //   522: aload 12
    //   524: aload_1
    //   525: invokevirtual 315	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   528: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 10
    //   534: astore 14
    //   536: aload_2
    //   537: astore 15
    //   539: aload 12
    //   541: ldc_w 317
    //   544: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 10
    //   550: astore 14
    //   552: aload_2
    //   553: astore 15
    //   555: aload 12
    //   557: aload_1
    //   558: invokevirtual 140	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   561: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 10
    //   567: astore 14
    //   569: aload_2
    //   570: astore 15
    //   572: ldc 8
    //   574: iconst_1
    //   575: aload 12
    //   577: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: aload 10
    //   585: astore 14
    //   587: aload_2
    //   588: astore 15
    //   590: aload_3
    //   591: aload_1
    //   592: iconst_1
    //   593: iconst_0
    //   594: invokeinterface 325 4 0
    //   599: aload 10
    //   601: astore 14
    //   603: aload_2
    //   604: astore 15
    //   606: aload_0
    //   607: aload_1
    //   608: iconst_0
    //   609: invokespecial 374	cooperation/qqcircle/picload/RFWOkHttpDW:upDateTimeOut	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Z)V
    //   612: goto +330 -> 942
    //   615: astore 12
    //   617: goto +161 -> 778
    //   620: astore 11
    //   622: goto +48 -> 670
    //   625: astore 12
    //   627: aconst_null
    //   628: astore 13
    //   630: goto +148 -> 778
    //   633: astore_1
    //   634: aload 10
    //   636: astore_3
    //   637: goto +21 -> 658
    //   640: astore 11
    //   642: goto +26 -> 668
    //   645: astore 12
    //   647: goto +126 -> 773
    //   650: astore 12
    //   652: goto +118 -> 770
    //   655: astore_1
    //   656: aconst_null
    //   657: astore_3
    //   658: aconst_null
    //   659: astore_2
    //   660: goto +297 -> 957
    //   663: astore 11
    //   665: aconst_null
    //   666: astore 10
    //   668: aconst_null
    //   669: astore_2
    //   670: new 60	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   677: astore 12
    //   679: aload 12
    //   681: ldc 98
    //   683: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 12
    //   689: aload_1
    //   690: invokevirtual 104	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   693: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 12
    //   699: ldc_w 376
    //   702: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 12
    //   708: aload_1
    //   709: invokevirtual 315	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   712: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 12
    //   718: ldc_w 378
    //   721: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 12
    //   727: aload 11
    //   729: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc 8
    //   735: iconst_1
    //   736: aload 12
    //   738: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload_0
    //   745: aload_1
    //   746: aload_3
    //   747: invokespecial 37	cooperation/qqcircle/picload/RFWOkHttpDW:handleRetry	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Lcooperation/qqcircle/picload/RFWAbsPicDW$ICallBackListener;)V
    //   750: aload_0
    //   751: aload 10
    //   753: aload_2
    //   754: invokespecial 327	cooperation/qqcircle/picload/RFWOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   757: return
    //   758: astore_1
    //   759: aload 10
    //   761: astore_3
    //   762: goto +195 -> 957
    //   765: astore 12
    //   767: aconst_null
    //   768: astore 11
    //   770: aconst_null
    //   771: astore 10
    //   773: aconst_null
    //   774: astore 13
    //   776: aconst_null
    //   777: astore_2
    //   778: aload 10
    //   780: astore 14
    //   782: aload_2
    //   783: astore 15
    //   785: new 60	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   792: astore 16
    //   794: aload 10
    //   796: astore 14
    //   798: aload_2
    //   799: astore 15
    //   801: aload 16
    //   803: ldc 98
    //   805: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload 10
    //   811: astore 14
    //   813: aload_2
    //   814: astore 15
    //   816: aload 16
    //   818: aload_1
    //   819: invokevirtual 104	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   822: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 10
    //   828: astore 14
    //   830: aload_2
    //   831: astore 15
    //   833: aload 16
    //   835: ldc_w 376
    //   838: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 10
    //   844: astore 14
    //   846: aload_2
    //   847: astore 15
    //   849: aload 16
    //   851: aload_1
    //   852: invokevirtual 315	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   855: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 10
    //   861: astore 14
    //   863: aload_2
    //   864: astore 15
    //   866: aload 16
    //   868: ldc_w 385
    //   871: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 10
    //   877: astore 14
    //   879: aload_2
    //   880: astore 15
    //   882: aload 16
    //   884: aload 12
    //   886: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 10
    //   892: astore 14
    //   894: aload_2
    //   895: astore 15
    //   897: ldc 8
    //   899: iconst_1
    //   900: aload 16
    //   902: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload 10
    //   910: astore 14
    //   912: aload_2
    //   913: astore 15
    //   915: aload_0
    //   916: aload_1
    //   917: aload 12
    //   919: instanceof 387
    //   922: invokespecial 374	cooperation/qqcircle/picload/RFWOkHttpDW:upDateTimeOut	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Z)V
    //   925: aload 10
    //   927: astore 14
    //   929: aload_2
    //   930: astore 15
    //   932: aload_0
    //   933: aload_1
    //   934: aload 11
    //   936: aload 13
    //   938: aload_3
    //   939: invokespecial 389	cooperation/qqcircle/picload/RFWOkHttpDW:handleException	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Ljava/io/File;Ljava/io/File;Lcooperation/qqcircle/picload/RFWAbsPicDW$ICallBackListener;)V
    //   942: aload_0
    //   943: aload 10
    //   945: aload_2
    //   946: invokespecial 327	cooperation/qqcircle/picload/RFWOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   949: return
    //   950: astore_1
    //   951: aload 15
    //   953: astore_2
    //   954: aload 14
    //   956: astore_3
    //   957: aload_0
    //   958: aload_3
    //   959: aload_2
    //   960: invokespecial 327	cooperation/qqcircle/picload/RFWOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   963: aload_1
    //   964: athrow
    //   965: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	966	0	this	RFWOkHttpDW
    //   0	966	1	paramOption	Option
    //   0	966	2	paramResponse	okhttp3.Response
    //   0	966	3	paramICallBackListener	RFWAbsPicDW.ICallBackListener
    //   351	20	4	i	int
    //   26	10	5	l1	long
    //   31	3	7	l2	long
    //   252	3	9	bool	boolean
    //   17	927	10	localObject1	Object
    //   141	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   151	293	11	localObject2	Object
    //   620	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   640	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   663	65	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   768	167	11	localFile	File
    //   148	1	12	localException1	Exception
    //   165	14	12	str	String
    //   242	160	12	localException2	Exception
    //   465	111	12	localStringBuilder1	StringBuilder
    //   615	1	12	localException3	Exception
    //   625	1	12	localException4	Exception
    //   645	1	12	localException5	Exception
    //   650	1	12	localException6	Exception
    //   677	60	12	localStringBuilder2	StringBuilder
    //   765	153	12	localException7	Exception
    //   14	923	13	localObject3	Object
    //   212	743	14	localObject4	Object
    //   325	627	15	localResponse	okhttp3.Response
    //   792	109	16	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	126	133	finally
    //   219	239	133	finally
    //   259	265	133	finally
    //   41	126	141	java/lang/OutOfMemoryError
    //   219	239	141	java/lang/OutOfMemoryError
    //   259	265	141	java/lang/OutOfMemoryError
    //   41	126	148	java/lang/Exception
    //   219	239	242	java/lang/Exception
    //   259	265	242	java/lang/Exception
    //   415	423	615	java/lang/Exception
    //   430	436	615	java/lang/Exception
    //   443	451	615	java/lang/Exception
    //   458	467	615	java/lang/Exception
    //   474	482	615	java/lang/Exception
    //   489	499	615	java/lang/Exception
    //   506	515	615	java/lang/Exception
    //   522	532	615	java/lang/Exception
    //   539	548	615	java/lang/Exception
    //   555	565	615	java/lang/Exception
    //   572	583	615	java/lang/Exception
    //   590	599	615	java/lang/Exception
    //   606	612	615	java/lang/Exception
    //   327	334	620	java/lang/OutOfMemoryError
    //   341	353	620	java/lang/OutOfMemoryError
    //   365	375	620	java/lang/OutOfMemoryError
    //   385	390	620	java/lang/OutOfMemoryError
    //   397	408	620	java/lang/OutOfMemoryError
    //   415	423	620	java/lang/OutOfMemoryError
    //   430	436	620	java/lang/OutOfMemoryError
    //   443	451	620	java/lang/OutOfMemoryError
    //   458	467	620	java/lang/OutOfMemoryError
    //   474	482	620	java/lang/OutOfMemoryError
    //   489	499	620	java/lang/OutOfMemoryError
    //   506	515	620	java/lang/OutOfMemoryError
    //   522	532	620	java/lang/OutOfMemoryError
    //   539	548	620	java/lang/OutOfMemoryError
    //   555	565	620	java/lang/OutOfMemoryError
    //   572	583	620	java/lang/OutOfMemoryError
    //   590	599	620	java/lang/OutOfMemoryError
    //   606	612	620	java/lang/OutOfMemoryError
    //   327	334	625	java/lang/Exception
    //   341	353	625	java/lang/Exception
    //   365	375	625	java/lang/Exception
    //   385	390	625	java/lang/Exception
    //   397	408	625	java/lang/Exception
    //   312	320	633	finally
    //   312	320	640	java/lang/OutOfMemoryError
    //   312	320	645	java/lang/Exception
    //   207	214	650	java/lang/Exception
    //   247	254	650	java/lang/Exception
    //   265	312	650	java/lang/Exception
    //   19	33	655	finally
    //   161	207	655	finally
    //   207	214	655	finally
    //   247	254	655	finally
    //   265	312	655	finally
    //   19	33	663	java/lang/OutOfMemoryError
    //   161	207	663	java/lang/OutOfMemoryError
    //   207	214	663	java/lang/OutOfMemoryError
    //   247	254	663	java/lang/OutOfMemoryError
    //   265	312	663	java/lang/OutOfMemoryError
    //   670	750	758	finally
    //   19	33	765	java/lang/Exception
    //   161	207	765	java/lang/Exception
    //   327	334	950	finally
    //   341	353	950	finally
    //   365	375	950	finally
    //   385	390	950	finally
    //   397	408	950	finally
    //   415	423	950	finally
    //   430	436	950	finally
    //   443	451	950	finally
    //   458	467	950	finally
    //   474	482	950	finally
    //   489	499	950	finally
    //   506	515	950	finally
    //   522	532	950	finally
    //   539	548	950	finally
    //   555	565	950	finally
    //   572	583	950	finally
    //   590	599	950	finally
    //   606	612	950	finally
    //   785	794	950	finally
    //   801	809	950	finally
    //   816	826	950	finally
    //   833	842	950	finally
    //   849	859	950	finally
    //   866	875	950	finally
    //   882	890	950	finally
    //   897	908	950	finally
    //   915	925	950	finally
    //   932	942	950	finally
  }
  
  public void handlerDownLoad(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (RFWPicLoadConfig.useOkHttpDownLoadPic())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("okHttp（） use OkHttp");
      QLog.i("QCircleOkHttpDW", 1, localStringBuilder.toString());
      okHttpDownload(paramOption, paramICallBackListener);
      return;
    }
    handleNext(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWOkHttpDW
 * JD-Core Version:    0.7.0.1
 */