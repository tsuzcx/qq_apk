package cooperation.qqcircle.picload;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.utils.QCircleCommonUtil;
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
  protected static int dataBlockLength = 2048;
  protected static int max_length = 2097152;
  private static OkHttpClient sClient = QCircleOkHttpFactory.createOkHttpClient(QCircleOkHttpFactory.DEFAULT_CONNECT_POOL * 2, QCircleOkHttpFactory.DEFAULT_MAX_REQUEST * 2, QCircleOkHttpFactory.DEFAULT_MAX_REQUEST_PEER_HOST * 2);
  
  private void handleNext(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (getNextDw() != null)
    {
      QLog.i("QCircleOkHttpDW", 1, "seq = " + paramOption.getSeq() + "okHttp（） use httpUrlConnection");
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
  
  private void okHttpDownload(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    String str1 = MsfSdkUtils.insertMtype("yingyongbao", paramOption.getUrl());
    String str2 = QCircleCommonUtil.getUrlHost(str1);
    String str3 = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", str1, str2);
    boolean bool = str1.equals(str3);
    Request localRequest = new Request.Builder().url(str1).get().build();
    if (bool)
    {
      localRequest = new Request.Builder().url(str3).get().build();
      HttpUrl localHttpUrl = localRequest.url().newBuilder().host(str2).build();
      localRequest = localRequest.newBuilder().url(localHttpUrl).build();
      QLog.i("QCircleOkHttpDW", 1, "seq = " + paramOption.getSeq() + "okHttp（）hasConvert:" + bool + "\nafter convert :origin:" + str1 + "\nconvert:" + str3 + "\nhost:" + str2);
    }
    if (sClient != null) {
      sClient.newCall(localRequest).enqueue(new QCircleOkHttpDW.1(this, paramOption, paramICallBackListener));
    }
  }
  
  public static void release()
  {
    if (sClient != null) {
      try
      {
        List localList = sClient.dispatcher().queuedCalls();
        Iterator localIterator = localList.iterator();
        QLog.d("QCircleOkHttpDW", 1, "release okHttpDW queue size:" + localList.size());
        while (localIterator.hasNext()) {
          ((Call)localIterator.next()).cancel();
        }
        localList = sClient.dispatcher().runningCalls();
        localIterator = localList.iterator();
        QLog.d("QCircleOkHttpDW", 1, "release okHttpDW running size:" + localList.size());
        while (localIterator.hasNext()) {
          ((Call)localIterator.next()).cancel();
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  /* Error */
  private void writeToFile(Option paramOption, okhttp3.Response paramResponse, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 11
    //   12: aload_1
    //   13: ifnull +11 -> 24
    //   16: aload_2
    //   17: ifnull +7 -> 24
    //   20: aload_3
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: aload_2
    //   26: invokevirtual 241	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   29: invokevirtual 247	okhttp3/ResponseBody:contentLength	()J
    //   32: lstore 5
    //   34: invokestatic 252	bjht:a	()J
    //   37: lload 5
    //   39: lcmp
    //   40: ifge +101 -> 141
    //   43: ldc 8
    //   45: iconst_1
    //   46: new 59	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   53: ldc 62
    //   55: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: invokevirtual 72	cooperation/qqcircle/picload/Option:getSeq	()I
    //   62: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 254
    //   67: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 257	cooperation/qqcircle/picload/Option:getCacheKey	()Ljava/lang/String;
    //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 259
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 96	cooperation/qqcircle/picload/Option:getUrl	()Ljava/lang/String;
    //   87: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 261
    //   93: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_3
    //   103: aload_1
    //   104: iconst_0
    //   105: iconst_1
    //   106: invokeinterface 267 4 0
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 269	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 270	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_0
    //   124: ifeq -100 -> 24
    //   127: new 269	java/lang/NullPointerException
    //   130: dup
    //   131: invokespecial 270	java/lang/NullPointerException:<init>	()V
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   140: return
    //   141: aload_2
    //   142: invokevirtual 241	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   145: invokevirtual 277	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   148: astore_2
    //   149: lconst_0
    //   150: lstore 5
    //   152: aload 7
    //   154: astore 9
    //   156: aload_2
    //   157: astore 8
    //   159: getstatic 17	cooperation/qqcircle/picload/QCircleOkHttpDW:dataBlockLength	I
    //   162: newarray byte
    //   164: astore 10
    //   166: aload 7
    //   168: astore 9
    //   170: aload_2
    //   171: astore 8
    //   173: new 279	java/io/ByteArrayOutputStream
    //   176: dup
    //   177: invokespecial 280	java/io/ByteArrayOutputStream:<init>	()V
    //   180: astore 13
    //   182: aload 7
    //   184: astore 9
    //   186: aload_2
    //   187: astore 8
    //   189: aload_2
    //   190: aload 10
    //   192: iconst_0
    //   193: getstatic 17	cooperation/qqcircle/picload/QCircleOkHttpDW:dataBlockLength	I
    //   196: invokevirtual 286	java/io/InputStream:read	([BII)I
    //   199: istore 4
    //   201: iload 4
    //   203: ifle +91 -> 294
    //   206: aload 7
    //   208: astore 9
    //   210: aload_2
    //   211: astore 8
    //   213: lload 5
    //   215: getstatic 20	cooperation/qqcircle/picload/QCircleOkHttpDW:max_length	I
    //   218: i2l
    //   219: lcmp
    //   220: iflt +46 -> 266
    //   223: aload 7
    //   225: astore 9
    //   227: aload_2
    //   228: astore 8
    //   230: aload_3
    //   231: aload_1
    //   232: iconst_0
    //   233: iconst_2
    //   234: invokeinterface 267 4 0
    //   239: iconst_0
    //   240: ifeq +11 -> 251
    //   243: new 269	java/lang/NullPointerException
    //   246: dup
    //   247: invokespecial 270	java/lang/NullPointerException:<init>	()V
    //   250: athrow
    //   251: aload_2
    //   252: ifnull -228 -> 24
    //   255: aload_2
    //   256: invokevirtual 289	java/io/InputStream:close	()V
    //   259: return
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   265: return
    //   266: aload 7
    //   268: astore 9
    //   270: aload_2
    //   271: astore 8
    //   273: aload 13
    //   275: aload 10
    //   277: iconst_0
    //   278: iload 4
    //   280: invokevirtual 293	java/io/ByteArrayOutputStream:write	([BII)V
    //   283: lload 5
    //   285: iload 4
    //   287: i2l
    //   288: ladd
    //   289: lstore 5
    //   291: goto -109 -> 182
    //   294: aload 7
    //   296: astore 9
    //   298: aload_2
    //   299: astore 8
    //   301: aload_1
    //   302: invokevirtual 296	cooperation/qqcircle/picload/Option:getLocalPath	()Ljava/lang/String;
    //   305: astore 14
    //   307: aload 7
    //   309: astore 9
    //   311: aload_2
    //   312: astore 8
    //   314: new 298	java/io/File
    //   317: dup
    //   318: new 59	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   325: aload 14
    //   327: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 300
    //   333: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   342: astore 10
    //   344: aload 7
    //   346: astore 9
    //   348: aload_2
    //   349: astore 8
    //   351: aload 10
    //   353: invokevirtual 306	java/io/File:getParent	()Ljava/lang/String;
    //   356: ifnull +37 -> 393
    //   359: aload 7
    //   361: astore 9
    //   363: aload_2
    //   364: astore 8
    //   366: aload 10
    //   368: invokevirtual 310	java/io/File:getParentFile	()Ljava/io/File;
    //   371: invokevirtual 313	java/io/File:exists	()Z
    //   374: ifne +19 -> 393
    //   377: aload 7
    //   379: astore 9
    //   381: aload_2
    //   382: astore 8
    //   384: aload 10
    //   386: invokevirtual 310	java/io/File:getParentFile	()Ljava/io/File;
    //   389: invokevirtual 316	java/io/File:mkdirs	()Z
    //   392: pop
    //   393: aload 7
    //   395: astore 9
    //   397: aload_2
    //   398: astore 8
    //   400: aload 10
    //   402: invokevirtual 313	java/io/File:exists	()Z
    //   405: ifeq +16 -> 421
    //   408: aload 7
    //   410: astore 9
    //   412: aload_2
    //   413: astore 8
    //   415: aload 10
    //   417: invokevirtual 319	java/io/File:delete	()Z
    //   420: pop
    //   421: aload 7
    //   423: astore 9
    //   425: aload_2
    //   426: astore 8
    //   428: aload 10
    //   430: invokevirtual 322	java/io/File:createNewFile	()Z
    //   433: pop
    //   434: aload 7
    //   436: astore 9
    //   438: aload_2
    //   439: astore 8
    //   441: new 324	java/io/FileOutputStream
    //   444: dup
    //   445: new 59	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   452: aload 14
    //   454: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 300
    //   460: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   469: astore 7
    //   471: aload 7
    //   473: aload 13
    //   475: invokevirtual 329	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   478: invokevirtual 332	java/io/FileOutputStream:write	([B)V
    //   481: aload 7
    //   483: invokevirtual 335	java/io/FileOutputStream:flush	()V
    //   486: new 298	java/io/File
    //   489: dup
    //   490: aload 14
    //   492: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   495: astore 9
    //   497: aload 9
    //   499: invokevirtual 313	java/io/File:exists	()Z
    //   502: ifeq +9 -> 511
    //   505: aload 9
    //   507: invokevirtual 319	java/io/File:delete	()Z
    //   510: pop
    //   511: aload 10
    //   513: aload 9
    //   515: invokevirtual 339	java/io/File:renameTo	(Ljava/io/File;)Z
    //   518: pop
    //   519: ldc 8
    //   521: iconst_1
    //   522: new 59	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   529: ldc 62
    //   531: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 72	cooperation/qqcircle/picload/Option:getSeq	()I
    //   538: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: ldc_w 341
    //   544: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_1
    //   548: invokevirtual 257	cooperation/qqcircle/picload/Option:getCacheKey	()Ljava/lang/String;
    //   551: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: ldc_w 259
    //   557: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload_1
    //   561: invokevirtual 96	cooperation/qqcircle/picload/Option:getUrl	()Ljava/lang/String;
    //   564: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload_3
    //   574: aload_1
    //   575: iconst_1
    //   576: iconst_0
    //   577: invokeinterface 267 4 0
    //   582: aload 7
    //   584: ifnull +8 -> 592
    //   587: aload 7
    //   589: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   592: aload_2
    //   593: ifnull -569 -> 24
    //   596: aload_2
    //   597: invokevirtual 289	java/io/InputStream:close	()V
    //   600: return
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   606: return
    //   607: astore 7
    //   609: aconst_null
    //   610: astore 8
    //   612: aconst_null
    //   613: astore_2
    //   614: aconst_null
    //   615: astore_3
    //   616: aload 11
    //   618: astore 9
    //   620: ldc 8
    //   622: iconst_1
    //   623: new 59	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   630: ldc 62
    //   632: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_1
    //   636: invokevirtual 72	cooperation/qqcircle/picload/Option:getSeq	()I
    //   639: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: ldc_w 344
    //   645: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_1
    //   649: invokevirtual 257	cooperation/qqcircle/picload/Option:getCacheKey	()Ljava/lang/String;
    //   652: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 346
    //   658: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload 7
    //   663: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aload 8
    //   674: ifnull +17 -> 691
    //   677: aload 8
    //   679: invokevirtual 313	java/io/File:exists	()Z
    //   682: ifeq +9 -> 691
    //   685: aload 8
    //   687: invokevirtual 319	java/io/File:delete	()Z
    //   690: pop
    //   691: aload 9
    //   693: ifnull +17 -> 710
    //   696: aload 9
    //   698: invokevirtual 313	java/io/File:exists	()Z
    //   701: ifeq +9 -> 710
    //   704: aload 9
    //   706: invokevirtual 319	java/io/File:delete	()Z
    //   709: pop
    //   710: aload_2
    //   711: ifnull +7 -> 718
    //   714: aload_2
    //   715: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   718: aload_3
    //   719: ifnull -695 -> 24
    //   722: aload_3
    //   723: invokevirtual 289	java/io/InputStream:close	()V
    //   726: return
    //   727: astore_1
    //   728: aload_1
    //   729: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   732: return
    //   733: astore 7
    //   735: aconst_null
    //   736: astore_2
    //   737: aload 12
    //   739: astore 10
    //   741: aload 10
    //   743: astore 9
    //   745: aload_2
    //   746: astore 8
    //   748: ldc 8
    //   750: iconst_1
    //   751: new 59	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   758: ldc 62
    //   760: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_1
    //   764: invokevirtual 72	cooperation/qqcircle/picload/Option:getSeq	()I
    //   767: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: ldc_w 344
    //   773: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_1
    //   777: invokevirtual 257	cooperation/qqcircle/picload/Option:getCacheKey	()Ljava/lang/String;
    //   780: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: ldc_w 354
    //   786: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload 7
    //   791: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload 10
    //   802: astore 9
    //   804: aload_2
    //   805: astore 8
    //   807: aload_0
    //   808: aload_1
    //   809: aload_3
    //   810: invokespecial 47	cooperation/qqcircle/picload/QCircleOkHttpDW:handleNext	(Lcooperation/qqcircle/picload/Option;Lcooperation/qqcircle/picload/AbsPicDW$ICallBackListener;)V
    //   813: aload 10
    //   815: ifnull +8 -> 823
    //   818: aload 10
    //   820: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   823: aload_2
    //   824: ifnull -800 -> 24
    //   827: aload_2
    //   828: invokevirtual 289	java/io/InputStream:close	()V
    //   831: return
    //   832: astore_1
    //   833: aload_1
    //   834: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   837: return
    //   838: astore_1
    //   839: aconst_null
    //   840: astore_2
    //   841: aload 8
    //   843: astore_3
    //   844: aload_3
    //   845: ifnull +7 -> 852
    //   848: aload_3
    //   849: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   852: aload_2
    //   853: ifnull +7 -> 860
    //   856: aload_2
    //   857: invokevirtual 289	java/io/InputStream:close	()V
    //   860: aload_1
    //   861: athrow
    //   862: astore_2
    //   863: aload_2
    //   864: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   867: goto -7 -> 860
    //   870: astore_1
    //   871: aload 9
    //   873: astore_3
    //   874: aload 8
    //   876: astore_2
    //   877: goto -33 -> 844
    //   880: astore_1
    //   881: aload 7
    //   883: astore_3
    //   884: goto -40 -> 844
    //   887: astore_1
    //   888: aload_3
    //   889: astore 7
    //   891: aload_2
    //   892: astore_3
    //   893: aload 7
    //   895: astore_2
    //   896: goto -52 -> 844
    //   899: astore 7
    //   901: aload 12
    //   903: astore 10
    //   905: goto -164 -> 741
    //   908: astore 8
    //   910: aload 7
    //   912: astore 10
    //   914: aload 8
    //   916: astore 7
    //   918: goto -177 -> 741
    //   921: astore 7
    //   923: aconst_null
    //   924: astore 8
    //   926: aconst_null
    //   927: astore 10
    //   929: aload_2
    //   930: astore_3
    //   931: aload 11
    //   933: astore 9
    //   935: aload 10
    //   937: astore_2
    //   938: goto -318 -> 620
    //   941: astore 7
    //   943: aload 10
    //   945: astore 8
    //   947: aload_2
    //   948: astore_3
    //   949: aconst_null
    //   950: astore_2
    //   951: aload 11
    //   953: astore 9
    //   955: goto -335 -> 620
    //   958: astore 9
    //   960: aload 10
    //   962: astore 8
    //   964: aload 7
    //   966: astore 10
    //   968: aload_2
    //   969: astore_3
    //   970: aload 9
    //   972: astore 7
    //   974: aload 11
    //   976: astore 9
    //   978: aload 10
    //   980: astore_2
    //   981: goto -361 -> 620
    //   984: astore 11
    //   986: aload 10
    //   988: astore 8
    //   990: aload 7
    //   992: astore 10
    //   994: aload_2
    //   995: astore_3
    //   996: aload 11
    //   998: astore 7
    //   1000: aload 10
    //   1002: astore_2
    //   1003: goto -383 -> 620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	QCircleOkHttpDW
    //   0	1006	1	paramOption	Option
    //   0	1006	2	paramResponse	okhttp3.Response
    //   0	1006	3	paramICallBackListener	AbsPicDW.ICallBackListener
    //   199	87	4	i	int
    //   32	258	5	l	long
    //   7	581	7	localFileOutputStream	java.io.FileOutputStream
    //   607	55	7	localException1	Exception
    //   733	149	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   889	5	7	localICallBackListener	AbsPicDW.ICallBackListener
    //   899	12	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   916	1	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   921	1	7	localException2	Exception
    //   941	24	7	localException3	Exception
    //   972	27	7	localObject1	java.lang.Object
    //   4	871	8	localResponse	okhttp3.Response
    //   908	7	8	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   924	65	8	localObject2	java.lang.Object
    //   154	800	9	localObject3	java.lang.Object
    //   958	13	9	localException4	Exception
    //   976	1	9	localObject4	java.lang.Object
    //   164	837	10	localObject5	java.lang.Object
    //   10	965	11	localObject6	java.lang.Object
    //   984	13	11	localException5	Exception
    //   1	901	12	localObject7	java.lang.Object
    //   180	294	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   305	186	14	str	String
    // Exception table:
    //   from	to	target	type
    //   115	123	135	java/lang/Exception
    //   127	135	135	java/lang/Exception
    //   243	251	260	java/lang/Exception
    //   255	259	260	java/lang/Exception
    //   587	592	601	java/lang/Exception
    //   596	600	601	java/lang/Exception
    //   25	111	607	java/lang/Exception
    //   141	149	607	java/lang/Exception
    //   714	718	727	java/lang/Exception
    //   722	726	727	java/lang/Exception
    //   25	111	733	java/lang/OutOfMemoryError
    //   141	149	733	java/lang/OutOfMemoryError
    //   818	823	832	java/lang/Exception
    //   827	831	832	java/lang/Exception
    //   25	111	838	finally
    //   141	149	838	finally
    //   848	852	862	java/lang/Exception
    //   856	860	862	java/lang/Exception
    //   159	166	870	finally
    //   173	182	870	finally
    //   189	201	870	finally
    //   213	223	870	finally
    //   230	239	870	finally
    //   273	283	870	finally
    //   301	307	870	finally
    //   314	344	870	finally
    //   351	359	870	finally
    //   366	377	870	finally
    //   384	393	870	finally
    //   400	408	870	finally
    //   415	421	870	finally
    //   428	434	870	finally
    //   441	471	870	finally
    //   748	800	870	finally
    //   807	813	870	finally
    //   471	497	880	finally
    //   497	511	880	finally
    //   511	582	880	finally
    //   620	672	887	finally
    //   677	691	887	finally
    //   696	710	887	finally
    //   159	166	899	java/lang/OutOfMemoryError
    //   173	182	899	java/lang/OutOfMemoryError
    //   189	201	899	java/lang/OutOfMemoryError
    //   213	223	899	java/lang/OutOfMemoryError
    //   230	239	899	java/lang/OutOfMemoryError
    //   273	283	899	java/lang/OutOfMemoryError
    //   301	307	899	java/lang/OutOfMemoryError
    //   314	344	899	java/lang/OutOfMemoryError
    //   351	359	899	java/lang/OutOfMemoryError
    //   366	377	899	java/lang/OutOfMemoryError
    //   384	393	899	java/lang/OutOfMemoryError
    //   400	408	899	java/lang/OutOfMemoryError
    //   415	421	899	java/lang/OutOfMemoryError
    //   428	434	899	java/lang/OutOfMemoryError
    //   441	471	899	java/lang/OutOfMemoryError
    //   471	497	908	java/lang/OutOfMemoryError
    //   497	511	908	java/lang/OutOfMemoryError
    //   511	582	908	java/lang/OutOfMemoryError
    //   159	166	921	java/lang/Exception
    //   173	182	921	java/lang/Exception
    //   189	201	921	java/lang/Exception
    //   213	223	921	java/lang/Exception
    //   230	239	921	java/lang/Exception
    //   273	283	921	java/lang/Exception
    //   301	307	921	java/lang/Exception
    //   314	344	921	java/lang/Exception
    //   351	359	941	java/lang/Exception
    //   366	377	941	java/lang/Exception
    //   384	393	941	java/lang/Exception
    //   400	408	941	java/lang/Exception
    //   415	421	941	java/lang/Exception
    //   428	434	941	java/lang/Exception
    //   441	471	941	java/lang/Exception
    //   471	497	958	java/lang/Exception
    //   497	511	984	java/lang/Exception
    //   511	582	984	java/lang/Exception
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    if (QzoneConfig.useOkHttpDownLoadPic())
    {
      QLog.i("QCircleOkHttpDW", 1, "seq = " + paramOption.getSeq() + "okHttp（） use OkHttp");
      okHttpDownload(paramOption, paramICallBackListener);
      return;
    }
    handleNext(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW
 * JD-Core Version:    0.7.0.1
 */