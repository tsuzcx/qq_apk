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
  private static final OkHttpClient sClient = QCircleOkHttpFactory.createOkHttpClient(10, 128, 10, sTimeOut);
  private static final QCircleOKHttpDynamicTimeout sTimeOut = new QCircleOKHttpDynamicTimeout();
  
  private void closeStream(FileOutputStream paramFileOutputStream, InputStream paramInputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      if (paramInputStream == null) {
        break label62;
      }
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      label20:
      int i;
      break label20;
    }
    paramInputStream.printStackTrace();
    i = RFLog.USR;
    paramFileOutputStream = new StringBuilder();
    paramFileOutputStream.append("closeStream exception");
    paramFileOutputStream.append(paramInputStream.getMessage());
    RFLog.d("QCircleOkHttpDW", i, paramFileOutputStream.toString());
    label62:
  }
  
  private void handleException(Option paramOption, File paramFile1, File paramFile2, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if ((paramFile1 != null) && (paramFile1.exists())) {
      paramFile1.delete();
    }
    if ((paramFile2 != null) && (paramFile2.exists())) {
      paramFile2.delete();
    }
    handleRetry(paramOption, paramICallBackListener);
  }
  
  private void handleNext(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (getNextDw() != null)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("okHttp（） use httpUrlConnection");
      RFLog.i("QCircleOkHttpDW", i, localStringBuilder.toString());
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
  
  private void handleRetry(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    paramOption.updateRetryCount();
    boolean bool = paramOption.continueRetry();
    if (bool) {
      okHttpDownload(paramOption, paramICallBackListener);
    } else {
      handleNext(paramOption, paramICallBackListener);
    }
    int i = RFLog.USR;
    paramICallBackListener = new StringBuilder();
    paramICallBackListener.append("seq = ");
    paramICallBackListener.append(paramOption.getSeq());
    paramICallBackListener.append(" continue try:");
    paramICallBackListener.append(bool);
    paramICallBackListener.append(" retry currentTimes:");
    paramICallBackListener.append(paramOption.getRetryCount());
    RFLog.i("QCircleOkHttpDW", i, paramICallBackListener.toString());
  }
  
  private void okHttpDownload(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    int i;
    if (!URLUtil.a(paramOption.getUrl()))
    {
      i = RFLog.USR;
      paramICallBackListener = new StringBuilder();
      paramICallBackListener.append(paramOption.getSeq());
      paramICallBackListener.append(" url is unValid:");
      paramICallBackListener.append(paramOption.getUrl());
      RFLog.i("QCircleOkHttpDW", i, paramICallBackListener.toString());
      return;
    }
    Object localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramOption.getUrl());
    String str1 = QCircleCommonUtil.getUrlHost((String)localObject1);
    String str2 = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", (String)localObject1, str1);
    boolean bool = ((String)localObject1).equals(str2) ^ true;
    Request localRequest = new Request.Builder().addHeader("Connection", "close").url((String)localObject1).get().build();
    if (bool)
    {
      localRequest = new Request.Builder().url(str2).get().build();
      Object localObject2 = localRequest.url().newBuilder().host(str1).build();
      localRequest = localRequest.newBuilder().addHeader("Connection", "close").url((HttpUrl)localObject2).build();
      i = RFLog.USR;
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
      RFLog.i("QCircleOkHttpDW", i, ((StringBuilder)localObject2).toString());
    }
    localObject1 = sClient;
    if (localObject1 != null) {
      ((OkHttpClient)localObject1).newCall(localRequest).enqueue(new QCircleOkHttpDW.1(this, paramOption, paramICallBackListener));
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
        int i = RFLog.USR;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release okHttpDW queue size:");
        localStringBuilder.append(((List)localObject1).size());
        RFLog.d("QCircleOkHttpDW", i, localStringBuilder.toString());
        while (((Iterator)localObject2).hasNext()) {
          ((Call)((Iterator)localObject2).next()).cancel();
        }
        localObject1 = sClient.dispatcher().runningCalls();
        localObject2 = ((List)localObject1).iterator();
        i = RFLog.USR;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("release okHttpDW running size:");
        localStringBuilder.append(((List)localObject1).size());
        RFLog.d("QCircleOkHttpDW", i, localStringBuilder.toString());
        while (((Iterator)localObject2).hasNext()) {
          ((Call)((Iterator)localObject2).next()).cancel();
        }
        return;
      }
      catch (Exception localException)
      {
        i = RFLog.USR;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("release exception");
        ((StringBuilder)localObject2).append(localException.getMessage());
        RFLog.d("QCircleOkHttpDW", i, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void upDateTimeOut(Option paramOption, boolean paramBoolean)
  {
    sTimeOut.upDateTimeOut(paramBoolean, paramOption.getSeq());
  }
  
  /* Error */
  private void writeToFile(Option paramOption, okhttp3.Response paramResponse, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +1002 -> 1003
    //   4: aload_2
    //   5: ifnull +998 -> 1003
    //   8: aload_3
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aconst_null
    //   14: astore 13
    //   16: aconst_null
    //   17: astore 10
    //   19: aload_2
    //   20: invokevirtual 304	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   23: invokevirtual 310	okhttp3/ResponseBody:contentLength	()J
    //   26: lstore 5
    //   28: invokestatic 315	cooperation/qqcircle/picload/QCircleHttpUrlDW:getSDCardAvailableCount	()J
    //   31: lstore 7
    //   33: lload 7
    //   35: lload 5
    //   37: lcmp
    //   38: ifge +129 -> 167
    //   41: getstatic 64	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   44: istore 4
    //   46: new 66	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: ldc 102
    //   57: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 108	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   66: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: ldc_w 317
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual 320	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   83: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc_w 322
    //   91: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_2
    //   96: aload_1
    //   97: invokevirtual 144	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   100: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 324
    //   108: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: ldc 8
    //   114: iload 4
    //   116: aload_2
    //   117: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 116	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_3
    //   124: aload_1
    //   125: iconst_0
    //   126: iconst_1
    //   127: invokeinterface 330 4 0
    //   132: aload_0
    //   133: aconst_null
    //   134: aconst_null
    //   135: invokespecial 332	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   138: return
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: goto +851 -> 995
    //   147: astore 11
    //   149: aconst_null
    //   150: astore_2
    //   151: goto +538 -> 689
    //   154: astore 12
    //   156: aconst_null
    //   157: astore 11
    //   159: aconst_null
    //   160: astore 10
    //   162: aconst_null
    //   163: astore_2
    //   164: goto +639 -> 803
    //   167: aload_1
    //   168: invokevirtual 335	com/tencent/mobileqq/qcircle/api/data/Option:getLocalPath	()Ljava/lang/String;
    //   171: astore 12
    //   173: new 66	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   180: astore 11
    //   182: aload 11
    //   184: aload 12
    //   186: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 11
    //   192: ldc_w 337
    //   195: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 88	java/io/File
    //   202: dup
    //   203: aload 11
    //   205: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore 11
    //   213: aload 11
    //   215: invokevirtual 343	java/io/File:getParent	()Ljava/lang/String;
    //   218: astore 14
    //   220: aload 14
    //   222: ifnull +31 -> 253
    //   225: aload 11
    //   227: invokevirtual 347	java/io/File:getParentFile	()Ljava/io/File;
    //   230: invokevirtual 92	java/io/File:exists	()Z
    //   233: ifne +20 -> 253
    //   236: aload 11
    //   238: invokevirtual 347	java/io/File:getParentFile	()Ljava/io/File;
    //   241: invokevirtual 350	java/io/File:mkdirs	()Z
    //   244: pop
    //   245: goto +8 -> 253
    //   248: astore 12
    //   250: goto -91 -> 159
    //   253: aload 11
    //   255: invokevirtual 92	java/io/File:exists	()Z
    //   258: istore 9
    //   260: iload 9
    //   262: ifeq +9 -> 271
    //   265: aload 11
    //   267: invokevirtual 95	java/io/File:delete	()Z
    //   270: pop
    //   271: aload 11
    //   273: invokevirtual 353	java/io/File:createNewFile	()Z
    //   276: pop
    //   277: new 66	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   284: astore 10
    //   286: aload 10
    //   288: aload 12
    //   290: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 10
    //   296: ldc_w 337
    //   299: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: new 49	java/io/FileOutputStream
    //   306: dup
    //   307: aload 10
    //   309: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: iconst_1
    //   313: invokespecial 356	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   316: astore 10
    //   318: aload_2
    //   319: invokevirtual 304	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   322: invokevirtual 360	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   325: astore_2
    //   326: aload 10
    //   328: astore 14
    //   330: aload_2
    //   331: astore 15
    //   333: sipush 8192
    //   336: newarray byte
    //   338: astore 13
    //   340: aload 10
    //   342: astore 14
    //   344: aload_2
    //   345: astore 15
    //   347: aload_2
    //   348: aload 13
    //   350: iconst_0
    //   351: sipush 8192
    //   354: invokevirtual 364	java/io/InputStream:read	([BII)I
    //   357: istore 4
    //   359: iload 4
    //   361: ifle +23 -> 384
    //   364: aload 10
    //   366: astore 14
    //   368: aload_2
    //   369: astore 15
    //   371: aload 10
    //   373: aload 13
    //   375: iconst_0
    //   376: iload 4
    //   378: invokevirtual 368	java/io/FileOutputStream:write	([BII)V
    //   381: goto -41 -> 340
    //   384: aload 10
    //   386: astore 14
    //   388: aload_2
    //   389: astore 15
    //   391: aload 10
    //   393: invokevirtual 371	java/io/FileOutputStream:flush	()V
    //   396: aload 10
    //   398: astore 14
    //   400: aload_2
    //   401: astore 15
    //   403: new 88	java/io/File
    //   406: dup
    //   407: aload 12
    //   409: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   412: astore 13
    //   414: aload 10
    //   416: astore 14
    //   418: aload_2
    //   419: astore 15
    //   421: aload 13
    //   423: invokevirtual 92	java/io/File:exists	()Z
    //   426: ifeq +16 -> 442
    //   429: aload 10
    //   431: astore 14
    //   433: aload_2
    //   434: astore 15
    //   436: aload 13
    //   438: invokevirtual 95	java/io/File:delete	()Z
    //   441: pop
    //   442: aload 10
    //   444: astore 14
    //   446: aload_2
    //   447: astore 15
    //   449: aload 11
    //   451: aload 13
    //   453: invokevirtual 375	java/io/File:renameTo	(Ljava/io/File;)Z
    //   456: pop
    //   457: aload 10
    //   459: astore 14
    //   461: aload_2
    //   462: astore 15
    //   464: getstatic 64	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   467: istore 4
    //   469: aload 10
    //   471: astore 14
    //   473: aload_2
    //   474: astore 15
    //   476: new 66	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   483: astore 12
    //   485: aload 10
    //   487: astore 14
    //   489: aload_2
    //   490: astore 15
    //   492: aload 12
    //   494: ldc 102
    //   496: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 10
    //   502: astore 14
    //   504: aload_2
    //   505: astore 15
    //   507: aload 12
    //   509: aload_1
    //   510: invokevirtual 108	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   513: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 10
    //   519: astore 14
    //   521: aload_2
    //   522: astore 15
    //   524: aload 12
    //   526: ldc_w 377
    //   529: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 10
    //   535: astore 14
    //   537: aload_2
    //   538: astore 15
    //   540: aload 12
    //   542: aload_1
    //   543: invokevirtual 320	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   546: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 10
    //   552: astore 14
    //   554: aload_2
    //   555: astore 15
    //   557: aload 12
    //   559: ldc_w 322
    //   562: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 10
    //   568: astore 14
    //   570: aload_2
    //   571: astore 15
    //   573: aload 12
    //   575: aload_1
    //   576: invokevirtual 144	com/tencent/mobileqq/qcircle/api/data/Option:getUrl	()Ljava/lang/String;
    //   579: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 10
    //   585: astore 14
    //   587: aload_2
    //   588: astore 15
    //   590: ldc 8
    //   592: iload 4
    //   594: aload 12
    //   596: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 116	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 10
    //   604: astore 14
    //   606: aload_2
    //   607: astore 15
    //   609: aload_3
    //   610: aload_1
    //   611: iconst_1
    //   612: iconst_0
    //   613: invokeinterface 330 4 0
    //   618: aload 10
    //   620: astore 14
    //   622: aload_2
    //   623: astore 15
    //   625: aload_0
    //   626: aload_1
    //   627: iconst_0
    //   628: invokespecial 379	cooperation/qqcircle/picload/QCircleOkHttpDW:upDateTimeOut	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Z)V
    //   631: goto +349 -> 980
    //   634: astore 12
    //   636: goto +167 -> 803
    //   639: astore 11
    //   641: goto +48 -> 689
    //   644: astore 12
    //   646: aconst_null
    //   647: astore 13
    //   649: goto +154 -> 803
    //   652: astore_1
    //   653: aload 10
    //   655: astore_3
    //   656: goto +21 -> 677
    //   659: astore 11
    //   661: goto +26 -> 687
    //   664: astore 12
    //   666: goto +132 -> 798
    //   669: astore 12
    //   671: goto +124 -> 795
    //   674: astore_1
    //   675: aconst_null
    //   676: astore_3
    //   677: aconst_null
    //   678: astore_2
    //   679: goto +316 -> 995
    //   682: astore 11
    //   684: aconst_null
    //   685: astore 10
    //   687: aconst_null
    //   688: astore_2
    //   689: getstatic 64	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   692: istore 4
    //   694: new 66	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   701: astore 12
    //   703: aload 12
    //   705: ldc 102
    //   707: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 12
    //   713: aload_1
    //   714: invokevirtual 108	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   717: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 12
    //   723: ldc_w 381
    //   726: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 12
    //   732: aload_1
    //   733: invokevirtual 320	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   736: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 12
    //   742: ldc_w 383
    //   745: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 12
    //   751: aload 11
    //   753: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: ldc 8
    //   759: iload 4
    //   761: aload 12
    //   763: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 389	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aload_0
    //   770: aload_1
    //   771: aload_3
    //   772: invokespecial 37	cooperation/qqcircle/picload/QCircleOkHttpDW:handleRetry	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Lcooperation/qqcircle/picload/AbsPicDW$ICallBackListener;)V
    //   775: aload_0
    //   776: aload 10
    //   778: aload_2
    //   779: invokespecial 332	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   782: return
    //   783: astore_1
    //   784: aload 10
    //   786: astore_3
    //   787: goto +208 -> 995
    //   790: astore 12
    //   792: aconst_null
    //   793: astore 11
    //   795: aconst_null
    //   796: astore 10
    //   798: aconst_null
    //   799: astore 13
    //   801: aconst_null
    //   802: astore_2
    //   803: aload 10
    //   805: astore 14
    //   807: aload_2
    //   808: astore 15
    //   810: getstatic 64	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   813: istore 4
    //   815: aload 10
    //   817: astore 14
    //   819: aload_2
    //   820: astore 15
    //   822: new 66	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   829: astore 16
    //   831: aload 10
    //   833: astore 14
    //   835: aload_2
    //   836: astore 15
    //   838: aload 16
    //   840: ldc 102
    //   842: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 10
    //   848: astore 14
    //   850: aload_2
    //   851: astore 15
    //   853: aload 16
    //   855: aload_1
    //   856: invokevirtual 108	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   859: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 10
    //   865: astore 14
    //   867: aload_2
    //   868: astore 15
    //   870: aload 16
    //   872: ldc_w 381
    //   875: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 10
    //   881: astore 14
    //   883: aload_2
    //   884: astore 15
    //   886: aload 16
    //   888: aload_1
    //   889: invokevirtual 320	com/tencent/mobileqq/qcircle/api/data/Option:getCacheKey	()Ljava/lang/String;
    //   892: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 10
    //   898: astore 14
    //   900: aload_2
    //   901: astore 15
    //   903: aload 16
    //   905: ldc_w 391
    //   908: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload 10
    //   914: astore 14
    //   916: aload_2
    //   917: astore 15
    //   919: aload 16
    //   921: aload 12
    //   923: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: aload 10
    //   929: astore 14
    //   931: aload_2
    //   932: astore 15
    //   934: ldc 8
    //   936: iload 4
    //   938: aload 16
    //   940: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokestatic 389	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 10
    //   948: astore 14
    //   950: aload_2
    //   951: astore 15
    //   953: aload_0
    //   954: aload_1
    //   955: aload 12
    //   957: instanceof 393
    //   960: invokespecial 379	cooperation/qqcircle/picload/QCircleOkHttpDW:upDateTimeOut	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Z)V
    //   963: aload 10
    //   965: astore 14
    //   967: aload_2
    //   968: astore 15
    //   970: aload_0
    //   971: aload_1
    //   972: aload 11
    //   974: aload 13
    //   976: aload_3
    //   977: invokespecial 395	cooperation/qqcircle/picload/QCircleOkHttpDW:handleException	(Lcom/tencent/mobileqq/qcircle/api/data/Option;Ljava/io/File;Ljava/io/File;Lcooperation/qqcircle/picload/AbsPicDW$ICallBackListener;)V
    //   980: aload_0
    //   981: aload 10
    //   983: aload_2
    //   984: invokespecial 332	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   987: return
    //   988: astore_1
    //   989: aload 15
    //   991: astore_2
    //   992: aload 14
    //   994: astore_3
    //   995: aload_0
    //   996: aload_3
    //   997: aload_2
    //   998: invokespecial 332	cooperation/qqcircle/picload/QCircleOkHttpDW:closeStream	(Ljava/io/FileOutputStream;Ljava/io/InputStream;)V
    //   1001: aload_1
    //   1002: athrow
    //   1003: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1004	0	this	QCircleOkHttpDW
    //   0	1004	1	paramOption	Option
    //   0	1004	2	paramResponse	okhttp3.Response
    //   0	1004	3	paramICallBackListener	AbsPicDW.ICallBackListener
    //   44	893	4	i	int
    //   26	10	5	l1	long
    //   31	3	7	l2	long
    //   258	3	9	bool	boolean
    //   17	965	10	localObject1	Object
    //   147	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   157	293	11	localObject2	Object
    //   639	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   659	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   682	70	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   793	180	11	localFile	File
    //   154	1	12	localException1	Exception
    //   171	14	12	str	String
    //   248	160	12	localException2	Exception
    //   483	112	12	localStringBuilder1	StringBuilder
    //   634	1	12	localException3	Exception
    //   644	1	12	localException4	Exception
    //   664	1	12	localException5	Exception
    //   669	1	12	localException6	Exception
    //   701	61	12	localStringBuilder2	StringBuilder
    //   790	166	12	localException7	Exception
    //   14	961	13	localObject3	Object
    //   218	775	14	localObject4	Object
    //   331	659	15	localResponse	okhttp3.Response
    //   829	110	16	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	132	139	finally
    //   225	245	139	finally
    //   265	271	139	finally
    //   41	132	147	java/lang/OutOfMemoryError
    //   225	245	147	java/lang/OutOfMemoryError
    //   265	271	147	java/lang/OutOfMemoryError
    //   41	132	154	java/lang/Exception
    //   225	245	248	java/lang/Exception
    //   265	271	248	java/lang/Exception
    //   421	429	634	java/lang/Exception
    //   436	442	634	java/lang/Exception
    //   449	457	634	java/lang/Exception
    //   464	469	634	java/lang/Exception
    //   476	485	634	java/lang/Exception
    //   492	500	634	java/lang/Exception
    //   507	517	634	java/lang/Exception
    //   524	533	634	java/lang/Exception
    //   540	550	634	java/lang/Exception
    //   557	566	634	java/lang/Exception
    //   573	583	634	java/lang/Exception
    //   590	602	634	java/lang/Exception
    //   609	618	634	java/lang/Exception
    //   625	631	634	java/lang/Exception
    //   333	340	639	java/lang/OutOfMemoryError
    //   347	359	639	java/lang/OutOfMemoryError
    //   371	381	639	java/lang/OutOfMemoryError
    //   391	396	639	java/lang/OutOfMemoryError
    //   403	414	639	java/lang/OutOfMemoryError
    //   421	429	639	java/lang/OutOfMemoryError
    //   436	442	639	java/lang/OutOfMemoryError
    //   449	457	639	java/lang/OutOfMemoryError
    //   464	469	639	java/lang/OutOfMemoryError
    //   476	485	639	java/lang/OutOfMemoryError
    //   492	500	639	java/lang/OutOfMemoryError
    //   507	517	639	java/lang/OutOfMemoryError
    //   524	533	639	java/lang/OutOfMemoryError
    //   540	550	639	java/lang/OutOfMemoryError
    //   557	566	639	java/lang/OutOfMemoryError
    //   573	583	639	java/lang/OutOfMemoryError
    //   590	602	639	java/lang/OutOfMemoryError
    //   609	618	639	java/lang/OutOfMemoryError
    //   625	631	639	java/lang/OutOfMemoryError
    //   333	340	644	java/lang/Exception
    //   347	359	644	java/lang/Exception
    //   371	381	644	java/lang/Exception
    //   391	396	644	java/lang/Exception
    //   403	414	644	java/lang/Exception
    //   318	326	652	finally
    //   318	326	659	java/lang/OutOfMemoryError
    //   318	326	664	java/lang/Exception
    //   213	220	669	java/lang/Exception
    //   253	260	669	java/lang/Exception
    //   271	318	669	java/lang/Exception
    //   19	33	674	finally
    //   167	213	674	finally
    //   213	220	674	finally
    //   253	260	674	finally
    //   271	318	674	finally
    //   19	33	682	java/lang/OutOfMemoryError
    //   167	213	682	java/lang/OutOfMemoryError
    //   213	220	682	java/lang/OutOfMemoryError
    //   253	260	682	java/lang/OutOfMemoryError
    //   271	318	682	java/lang/OutOfMemoryError
    //   689	775	783	finally
    //   19	33	790	java/lang/Exception
    //   167	213	790	java/lang/Exception
    //   333	340	988	finally
    //   347	359	988	finally
    //   371	381	988	finally
    //   391	396	988	finally
    //   403	414	988	finally
    //   421	429	988	finally
    //   436	442	988	finally
    //   449	457	988	finally
    //   464	469	988	finally
    //   476	485	988	finally
    //   492	500	988	finally
    //   507	517	988	finally
    //   524	533	988	finally
    //   540	550	988	finally
    //   557	566	988	finally
    //   573	583	988	finally
    //   590	602	988	finally
    //   609	618	988	finally
    //   625	631	988	finally
    //   810	815	988	finally
    //   822	831	988	finally
    //   838	846	988	finally
    //   853	863	988	finally
    //   870	879	988	finally
    //   886	896	988	finally
    //   903	912	988	finally
    //   919	927	988	finally
    //   934	946	988	finally
    //   953	963	988	finally
    //   970	980	988	finally
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (QCircleConfig.useOkHttpDownLoadPic())
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("okHttp（） use OkHttp");
      RFLog.i("QCircleOkHttpDW", i, localStringBuilder.toString());
      okHttpDownload(paramOption, paramICallBackListener);
      return;
    }
    handleNext(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW
 * JD-Core Version:    0.7.0.1
 */