package com.tencent.mobileqq.music;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class QQPlayerService$DownloadThread
  extends Thread
{
  public int a;
  public String a;
  public volatile boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int c;
  public volatile boolean c;
  public volatile boolean d = true;
  
  public QQPlayerService$DownloadThread(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    setName("QQPlayerService-DownloadThread");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private File a(String paramString)
  {
    File localFile = new File(QQPlayerService.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(QQPlayerService.b() + "/" + paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "createNewFile:" + localIOException.getMessage(), localIOException);
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 104	babp:b	()[J
    //   3: astore 5
    //   5: aload 5
    //   7: ifnull +39 -> 46
    //   10: aload 5
    //   12: iconst_1
    //   13: laload
    //   14: ldc2_w 105
    //   17: lcmp
    //   18: ifgt +28 -> 46
    //   21: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 80
    //   29: iconst_2
    //   30: ldc 108
    //   32: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   39: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   42: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 120	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	(Ljava/lang/String;)Ljava/io/File;
    //   54: astore 10
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   61: aconst_null
    //   62: astore 5
    //   64: new 124	java/io/RandomAccessFile
    //   67: dup
    //   68: aload 10
    //   70: ldc 126
    //   72: invokespecial 129	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 6
    //   77: aload 6
    //   79: astore 5
    //   81: ldc 131
    //   83: aload_0
    //   84: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: invokestatic 137	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 9
    //   92: aload 6
    //   94: astore 5
    //   96: new 139	java/net/URL
    //   99: dup
    //   100: aload 9
    //   102: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;)V
    //   105: astore 8
    //   107: aload 6
    //   109: astore 5
    //   111: invokestatic 143	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   114: astore 7
    //   116: aload 7
    //   118: ifnonnull +74 -> 192
    //   121: aload 6
    //   123: astore 5
    //   125: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +15 -> 143
    //   131: aload 6
    //   133: astore 5
    //   135: ldc 80
    //   137: iconst_2
    //   138: ldc 145
    //   140: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: iconst_0
    //   145: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   148: aload 6
    //   150: ifnull +8 -> 158
    //   153: aload 6
    //   155: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   158: aload_0
    //   159: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   162: aload_0
    //   163: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   166: if_icmpge -121 -> 45
    //   169: aload_0
    //   170: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   173: ifle -128 -> 45
    //   176: aload_0
    //   177: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   184: aload_0
    //   185: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   188: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   191: return
    //   192: aload 6
    //   194: astore 5
    //   196: aload 7
    //   198: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: astore 11
    //   203: aload 6
    //   205: astore 5
    //   207: aload 11
    //   209: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifne +3103 -> 3315
    //   215: aload 6
    //   217: astore 5
    //   219: aload 11
    //   221: ldc 167
    //   223: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   226: ifeq +3089 -> 3315
    //   229: aload 6
    //   231: astore 5
    //   233: aload_0
    //   234: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: aload_0
    //   238: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   241: aload 11
    //   243: invokestatic 176	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: istore_3
    //   250: aload 6
    //   252: astore 5
    //   254: aload 7
    //   256: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   259: aload_0
    //   260: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   263: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifne +7 -> 273
    //   269: iload_3
    //   270: ifeq +3050 -> 3320
    //   273: aload 6
    //   275: astore 5
    //   277: aload_0
    //   278: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   281: ifeq +3039 -> 3320
    //   284: aload 6
    //   286: astore 5
    //   288: aload_0
    //   289: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   292: i2f
    //   293: aload_0
    //   294: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   297: i2f
    //   298: aload_0
    //   299: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   302: getfield 183	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   305: fmul
    //   306: fcmpl
    //   307: ifle +594 -> 901
    //   310: aload 6
    //   312: astore 5
    //   314: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +15 -> 332
    //   320: aload 6
    //   322: astore 5
    //   324: ldc 80
    //   326: iconst_2
    //   327: ldc 185
    //   329: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 6
    //   334: astore 5
    //   336: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   339: invokevirtual 193	android/media/MediaPlayer:reset	()V
    //   342: aload 6
    //   344: astore 5
    //   346: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   349: aload 10
    //   351: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   354: invokevirtual 199	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   357: aload 6
    //   359: astore 5
    //   361: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   364: invokevirtual 202	android/media/MediaPlayer:prepare	()V
    //   367: aload 6
    //   369: astore 5
    //   371: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   374: invokevirtual 205	android/media/MediaPlayer:start	()V
    //   377: aload 6
    //   379: astore 5
    //   381: aload_0
    //   382: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   385: iconst_2
    //   386: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   389: aload 6
    //   391: astore 5
    //   393: aload_0
    //   394: iconst_0
    //   395: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   398: goto +2922 -> 3320
    //   401: iload_2
    //   402: ifgt +2906 -> 3308
    //   405: iload_1
    //   406: iconst_5
    //   407: if_icmpgt +2901 -> 3308
    //   410: aload 6
    //   412: astore 5
    //   414: aload 8
    //   416: invokevirtual 212	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   419: checkcast 214	java/net/HttpURLConnection
    //   422: astore 7
    //   424: aload 6
    //   426: astore 5
    //   428: aload 7
    //   430: iconst_0
    //   431: invokevirtual 218	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   434: aload 6
    //   436: astore 5
    //   438: aload 7
    //   440: ldc 220
    //   442: ldc 222
    //   444: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 6
    //   449: astore 5
    //   451: aload_0
    //   452: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   455: ifeq +63 -> 518
    //   458: aload 6
    //   460: astore 5
    //   462: aload_0
    //   463: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   466: aload_0
    //   467: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   470: if_icmple +48 -> 518
    //   473: aload 6
    //   475: astore 5
    //   477: aload 7
    //   479: ldc 228
    //   481: new 60	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   488: ldc 230
    //   490: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_0
    //   494: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   497: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: ldc 235
    //   502: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_0
    //   506: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   509: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 6
    //   520: astore 5
    //   522: aload 8
    //   524: invokevirtual 238	java/net/URL:getHost	()Ljava/lang/String;
    //   527: astore 11
    //   529: aload 6
    //   531: astore 5
    //   533: aload 11
    //   535: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   538: ifne +266 -> 804
    //   541: aload 6
    //   543: astore 5
    //   545: aload 11
    //   547: ldc 240
    //   549: invokevirtual 243	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   552: ifeq +252 -> 804
    //   555: aload 6
    //   557: astore 5
    //   559: invokestatic 249	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   562: invokevirtual 253	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   565: iconst_2
    //   566: invokevirtual 259	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   569: checkcast 261	mqq/manager/TicketManager
    //   572: astore 12
    //   574: aload 6
    //   576: astore 5
    //   578: invokestatic 249	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   581: invokevirtual 253	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   584: invokevirtual 264	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   587: astore 11
    //   589: aload 6
    //   591: astore 5
    //   593: aload 12
    //   595: aload 11
    //   597: ldc2_w 265
    //   600: iconst_1
    //   601: anewarray 169	java/lang/String
    //   604: dup
    //   605: iconst_0
    //   606: ldc 240
    //   608: aastore
    //   609: aconst_null
    //   610: invokeinterface 270 6 0
    //   615: astore 12
    //   617: aload 12
    //   619: ifnull +457 -> 1076
    //   622: aload 6
    //   624: astore 5
    //   626: aload 12
    //   628: getfield 276	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   631: ifnull +445 -> 1076
    //   634: aload 6
    //   636: astore 5
    //   638: aload 12
    //   640: getfield 276	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   643: ldc 240
    //   645: invokeinterface 282 2 0
    //   650: ifnull +426 -> 1076
    //   653: aload 6
    //   655: astore 5
    //   657: ldc 80
    //   659: iconst_1
    //   660: ldc_w 284
    //   663: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload 6
    //   668: astore 5
    //   670: new 169	java/lang/String
    //   673: dup
    //   674: aload 12
    //   676: getfield 276	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   679: ldc 240
    //   681: invokeinterface 282 2 0
    //   686: checkcast 286	[B
    //   689: invokespecial 289	java/lang/String:<init>	([B)V
    //   692: astore 12
    //   694: aload 6
    //   696: astore 5
    //   698: new 60	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   705: ldc_w 291
    //   708: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 12
    //   713: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: ldc_w 293
    //   719: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload 11
    //   724: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc_w 295
    //   730: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: astore 11
    //   738: aload 6
    //   740: astore 5
    //   742: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +45 -> 790
    //   748: aload 6
    //   750: astore 5
    //   752: ldc 80
    //   754: iconst_1
    //   755: new 60	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 297
    //   765: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload 9
    //   770: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc_w 299
    //   776: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 11
    //   781: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   790: aload 6
    //   792: astore 5
    //   794: aload 7
    //   796: ldc_w 304
    //   799: aload 11
    //   801: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload 6
    //   806: astore 5
    //   808: aload 7
    //   810: invokevirtual 307	java/net/HttpURLConnection:connect	()V
    //   813: aload 6
    //   815: astore 5
    //   817: aload 7
    //   819: invokevirtual 311	java/net/HttpURLConnection:getResponseCode	()I
    //   822: sipush 302
    //   825: if_icmpne +335 -> 1160
    //   828: iload_1
    //   829: iconst_1
    //   830: iadd
    //   831: istore_1
    //   832: aload 6
    //   834: astore 5
    //   836: new 139	java/net/URL
    //   839: dup
    //   840: aload 7
    //   842: ldc_w 313
    //   845: invokevirtual 317	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   848: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;)V
    //   851: astore 8
    //   853: aload 6
    //   855: astore 5
    //   857: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +2441 -> 3301
    //   863: aload 6
    //   865: astore 5
    //   867: ldc 80
    //   869: iconst_1
    //   870: new 60	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 319
    //   880: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 8
    //   885: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   888: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: aload 7
    //   896: astore 5
    //   898: goto -497 -> 401
    //   901: aload 6
    //   903: astore 5
    //   905: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq +16 -> 924
    //   911: aload 6
    //   913: astore 5
    //   915: ldc 80
    //   917: iconst_2
    //   918: ldc_w 324
    //   921: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload 6
    //   926: astore 5
    //   928: aload_0
    //   929: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   932: iconst_1
    //   933: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   936: goto +2384 -> 3320
    //   939: astore 7
    //   941: aload 6
    //   943: astore 5
    //   945: aload 7
    //   947: astore 6
    //   949: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +35 -> 987
    //   955: ldc 80
    //   957: iconst_2
    //   958: new 60	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   965: ldc_w 326
    //   968: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload 6
    //   973: invokevirtual 327	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   976: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: aload 6
    //   984: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   987: aload_0
    //   988: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   991: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   994: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   997: aload_0
    //   998: iconst_0
    //   999: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1002: aload 5
    //   1004: ifnull +8 -> 1012
    //   1007: aload 5
    //   1009: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   1012: aload_0
    //   1013: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1016: aload_0
    //   1017: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1020: if_icmpge +25 -> 1045
    //   1023: aload_0
    //   1024: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1027: ifle +18 -> 1045
    //   1030: aload_0
    //   1031: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1034: aload_0
    //   1035: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1038: aload_0
    //   1039: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1042: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   1045: aload_0
    //   1046: getfield 329	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   1049: ifeq +6 -> 1055
    //   1052: invokestatic 331	badp:a	()V
    //   1055: aload_0
    //   1056: iconst_0
    //   1057: putfield 329	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   1060: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq -1018 -> 45
    //   1066: ldc 80
    //   1068: iconst_2
    //   1069: ldc_w 333
    //   1072: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1075: return
    //   1076: aload 6
    //   1078: astore 5
    //   1080: ldc 80
    //   1082: ldc_w 335
    //   1085: invokestatic 340	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1088: iload_1
    //   1089: iconst_1
    //   1090: iadd
    //   1091: istore_1
    //   1092: aload 6
    //   1094: astore 5
    //   1096: ldc2_w 341
    //   1099: invokestatic 346	java/lang/Thread:sleep	(J)V
    //   1102: aload 7
    //   1104: astore 5
    //   1106: goto -705 -> 401
    //   1109: astore 11
    //   1111: aload 6
    //   1113: astore 5
    //   1115: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq +2212 -> 3330
    //   1121: aload 6
    //   1123: astore 5
    //   1125: ldc 80
    //   1127: iconst_2
    //   1128: new 60	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1135: ldc_w 348
    //   1138: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: aload 11
    //   1143: invokevirtual 349	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1146: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: aload 11
    //   1154: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1157: goto +2173 -> 3330
    //   1160: aload 6
    //   1162: astore 5
    //   1164: ldc 80
    //   1166: iconst_1
    //   1167: new 60	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1174: ldc_w 351
    //   1177: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: aload 7
    //   1182: invokevirtual 311	java/net/HttpURLConnection:getResponseCode	()I
    //   1185: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1188: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1191: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1194: aload 6
    //   1196: astore 5
    //   1198: aload 7
    //   1200: invokevirtual 354	java/net/HttpURLConnection:getContentLength	()I
    //   1203: istore_2
    //   1204: iload_2
    //   1205: ifle +92 -> 1297
    //   1208: iload_2
    //   1209: ifgt +273 -> 1482
    //   1212: aload 6
    //   1214: astore 5
    //   1216: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq +16 -> 1235
    //   1222: aload 6
    //   1224: astore 5
    //   1226: ldc 80
    //   1228: iconst_2
    //   1229: ldc_w 356
    //   1232: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1235: aload 6
    //   1237: astore 5
    //   1239: aload_0
    //   1240: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1243: bipush 7
    //   1245: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1248: aload_0
    //   1249: iconst_0
    //   1250: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1253: aload 6
    //   1255: ifnull +8 -> 1263
    //   1258: aload 6
    //   1260: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   1263: aload_0
    //   1264: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1267: aload_0
    //   1268: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1271: if_icmpge -1226 -> 45
    //   1274: aload_0
    //   1275: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1278: ifle -1233 -> 45
    //   1281: aload_0
    //   1282: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1285: aload_0
    //   1286: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1289: aload_0
    //   1290: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1293: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   1296: return
    //   1297: aload 6
    //   1299: astore 5
    //   1301: ldc2_w 341
    //   1304: invokestatic 346	java/lang/Thread:sleep	(J)V
    //   1307: iload_1
    //   1308: iconst_1
    //   1309: iadd
    //   1310: istore_1
    //   1311: aload 7
    //   1313: astore 5
    //   1315: goto -914 -> 401
    //   1318: astore 11
    //   1320: aload 6
    //   1322: astore 5
    //   1324: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1327: ifeq -20 -> 1307
    //   1330: aload 6
    //   1332: astore 5
    //   1334: ldc 80
    //   1336: iconst_2
    //   1337: new 60	java/lang/StringBuilder
    //   1340: dup
    //   1341: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1344: ldc_w 348
    //   1347: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: aload 11
    //   1352: invokevirtual 349	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1355: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: aload 11
    //   1363: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1366: goto -59 -> 1307
    //   1369: astore 7
    //   1371: aload 6
    //   1373: astore 5
    //   1375: aload_0
    //   1376: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1379: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1382: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1385: aload 6
    //   1387: astore 5
    //   1389: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1392: ifeq +39 -> 1431
    //   1395: aload 6
    //   1397: astore 5
    //   1399: ldc 80
    //   1401: iconst_2
    //   1402: new 60	java/lang/StringBuilder
    //   1405: dup
    //   1406: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1409: ldc_w 358
    //   1412: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload 7
    //   1417: invokevirtual 359	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1420: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: aload 7
    //   1428: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1431: aload_0
    //   1432: iconst_0
    //   1433: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1436: aload 6
    //   1438: ifnull +8 -> 1446
    //   1441: aload 6
    //   1443: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   1446: aload_0
    //   1447: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1450: aload_0
    //   1451: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1454: if_icmpge -409 -> 1045
    //   1457: aload_0
    //   1458: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1461: ifle -416 -> 1045
    //   1464: aload_0
    //   1465: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1468: aload_0
    //   1469: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1472: aload_0
    //   1473: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1476: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   1479: goto -434 -> 1045
    //   1482: iload_2
    //   1483: istore_1
    //   1484: aload 6
    //   1486: astore 5
    //   1488: aload_0
    //   1489: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1492: ifle +14 -> 1506
    //   1495: aload 6
    //   1497: astore 5
    //   1499: iload_2
    //   1500: aload_0
    //   1501: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1504: iadd
    //   1505: istore_1
    //   1506: aload 6
    //   1508: astore 5
    //   1510: aload_0
    //   1511: iload_1
    //   1512: putfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1515: iload_1
    //   1516: istore_2
    //   1517: aload 7
    //   1519: astore 9
    //   1521: aload 6
    //   1523: astore 5
    //   1525: aload_0
    //   1526: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1529: ifeq +246 -> 1775
    //   1532: iload_1
    //   1533: istore_2
    //   1534: aload 7
    //   1536: astore 9
    //   1538: aload 6
    //   1540: astore 5
    //   1542: aload_0
    //   1543: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1546: iload_1
    //   1547: if_icmpeq +228 -> 1775
    //   1550: aload 6
    //   1552: astore 5
    //   1554: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1557: ifeq +46 -> 1603
    //   1560: aload 6
    //   1562: astore 5
    //   1564: ldc 80
    //   1566: iconst_2
    //   1567: new 60	java/lang/StringBuilder
    //   1570: dup
    //   1571: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1574: ldc_w 361
    //   1577: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: aload_0
    //   1581: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1584: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1587: ldc_w 363
    //   1590: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: iload_1
    //   1594: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1597: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1600: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1603: aload 6
    //   1605: astore 5
    //   1607: aload_0
    //   1608: iconst_0
    //   1609: putfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1612: aload 6
    //   1614: astore 5
    //   1616: aload_0
    //   1617: iconst_1
    //   1618: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   1621: aload 6
    //   1623: astore 5
    //   1625: aload 8
    //   1627: invokevirtual 212	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1630: checkcast 214	java/net/HttpURLConnection
    //   1633: astore 9
    //   1635: aload 6
    //   1637: astore 5
    //   1639: aload 9
    //   1641: iconst_1
    //   1642: invokevirtual 218	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1645: aload 6
    //   1647: astore 5
    //   1649: aload 9
    //   1651: ldc 220
    //   1653: ldc 222
    //   1655: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1658: aload 6
    //   1660: astore 5
    //   1662: aload 9
    //   1664: invokevirtual 307	java/net/HttpURLConnection:connect	()V
    //   1667: aload 6
    //   1669: astore 5
    //   1671: aload 9
    //   1673: invokevirtual 354	java/net/HttpURLConnection:getContentLength	()I
    //   1676: istore_2
    //   1677: iload_2
    //   1678: ifge +88 -> 1766
    //   1681: aload 6
    //   1683: astore 5
    //   1685: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1688: ifeq +16 -> 1704
    //   1691: aload 6
    //   1693: astore 5
    //   1695: ldc 80
    //   1697: iconst_2
    //   1698: ldc_w 365
    //   1701: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1704: aload 6
    //   1706: astore 5
    //   1708: aload_0
    //   1709: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1712: bipush 7
    //   1714: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1717: aload_0
    //   1718: iconst_0
    //   1719: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1722: aload 6
    //   1724: ifnull +8 -> 1732
    //   1727: aload 6
    //   1729: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   1732: aload_0
    //   1733: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1736: aload_0
    //   1737: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1740: if_icmpge -1695 -> 45
    //   1743: aload_0
    //   1744: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1747: ifle -1702 -> 45
    //   1750: aload_0
    //   1751: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1754: aload_0
    //   1755: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1758: aload_0
    //   1759: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1762: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   1765: return
    //   1766: aload 6
    //   1768: astore 5
    //   1770: aload_0
    //   1771: iload_2
    //   1772: putfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1775: aload 6
    //   1777: astore 5
    //   1779: aload 6
    //   1781: iload_2
    //   1782: i2l
    //   1783: invokevirtual 368	java/io/RandomAccessFile:setLength	(J)V
    //   1786: aload 6
    //   1788: astore 5
    //   1790: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1793: ifeq +62 -> 1855
    //   1796: aload 6
    //   1798: astore 5
    //   1800: ldc 80
    //   1802: iconst_2
    //   1803: new 60	java/lang/StringBuilder
    //   1806: dup
    //   1807: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1810: ldc_w 370
    //   1813: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: aload_0
    //   1817: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1820: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1823: ldc_w 372
    //   1826: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: aload_0
    //   1830: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1833: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1836: ldc_w 374
    //   1839: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload_0
    //   1843: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1846: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1849: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1852: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1855: aload 6
    //   1857: astore 5
    //   1859: aload 9
    //   1861: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1864: astore 7
    //   1866: aload 6
    //   1868: astore 5
    //   1870: sipush 8192
    //   1873: newarray byte
    //   1875: astore 8
    //   1877: aload 6
    //   1879: astore 5
    //   1881: aload 6
    //   1883: aload_0
    //   1884: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1887: i2l
    //   1888: invokevirtual 381	java/io/RandomAccessFile:seek	(J)V
    //   1891: aload 6
    //   1893: astore 5
    //   1895: aload_0
    //   1896: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1899: ifne +22 -> 1921
    //   1902: aload 6
    //   1904: astore 5
    //   1906: aload_0
    //   1907: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1910: aload_0
    //   1911: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1914: aload_0
    //   1915: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1918: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   1921: iconst_0
    //   1922: istore_2
    //   1923: iload_2
    //   1924: istore_1
    //   1925: aload 6
    //   1927: astore 5
    //   1929: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1932: ifeq +51 -> 1983
    //   1935: aload 6
    //   1937: astore 5
    //   1939: ldc 80
    //   1941: iconst_2
    //   1942: new 60	java/lang/StringBuilder
    //   1945: dup
    //   1946: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1949: ldc_w 383
    //   1952: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: aload_0
    //   1956: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1959: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1962: ldc_w 374
    //   1965: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: aload_0
    //   1969: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1972: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1981: iload_2
    //   1982: istore_1
    //   1983: aload 6
    //   1985: astore 5
    //   1987: aload_0
    //   1988: getfield 385	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Boolean	Z
    //   1991: ifne +858 -> 2849
    //   1994: aload 6
    //   1996: astore 5
    //   1998: aload_0
    //   1999: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2002: aload_0
    //   2003: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2006: if_icmpge +843 -> 2849
    //   2009: iload_1
    //   2010: bipush 10
    //   2012: if_icmpge +837 -> 2849
    //   2015: aload 6
    //   2017: astore 5
    //   2019: invokestatic 143	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2022: astore 9
    //   2024: aload 9
    //   2026: ifnonnull +74 -> 2100
    //   2029: aload 6
    //   2031: astore 5
    //   2033: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2036: ifeq +15 -> 2051
    //   2039: aload 6
    //   2041: astore 5
    //   2043: ldc 80
    //   2045: iconst_2
    //   2046: ldc 145
    //   2048: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2051: aload_0
    //   2052: iconst_0
    //   2053: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2056: aload 6
    //   2058: ifnull +8 -> 2066
    //   2061: aload 6
    //   2063: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   2066: aload_0
    //   2067: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2070: aload_0
    //   2071: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2074: if_icmpge -2029 -> 45
    //   2077: aload_0
    //   2078: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2081: ifle -2036 -> 45
    //   2084: aload_0
    //   2085: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2088: aload_0
    //   2089: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2092: aload_0
    //   2093: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2096: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   2099: return
    //   2100: aload 6
    //   2102: astore 5
    //   2104: aload_0
    //   2105: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   2108: ifeq +191 -> 2299
    //   2111: aload 6
    //   2113: astore 5
    //   2115: aload 9
    //   2117: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2120: aload_0
    //   2121: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2124: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2127: ifne +7 -> 2134
    //   2130: iload_3
    //   2131: ifeq +168 -> 2299
    //   2134: aload 6
    //   2136: astore 5
    //   2138: aload_0
    //   2139: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2142: i2f
    //   2143: aload_0
    //   2144: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2147: i2f
    //   2148: aload_0
    //   2149: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2152: getfield 183	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   2155: fmul
    //   2156: fcmpl
    //   2157: ifle +142 -> 2299
    //   2160: aload 6
    //   2162: astore 5
    //   2164: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2167: invokevirtual 193	android/media/MediaPlayer:reset	()V
    //   2170: aload 6
    //   2172: astore 5
    //   2174: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2177: aload 10
    //   2179: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2182: invokevirtual 199	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   2185: aload 6
    //   2187: astore 5
    //   2189: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2192: invokevirtual 202	android/media/MediaPlayer:prepare	()V
    //   2195: aload 6
    //   2197: astore 5
    //   2199: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2202: ifeq +52 -> 2254
    //   2205: aload 6
    //   2207: astore 5
    //   2209: ldc 80
    //   2211: iconst_2
    //   2212: new 60	java/lang/StringBuilder
    //   2215: dup
    //   2216: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2219: ldc_w 387
    //   2222: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: aload_0
    //   2226: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2229: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2232: ldc_w 389
    //   2235: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: aload_0
    //   2239: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2242: invokestatic 392	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   2245: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2248: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2251: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2254: aload 6
    //   2256: astore 5
    //   2258: aload_0
    //   2259: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2262: invokestatic 392	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   2265: ifne +25 -> 2290
    //   2268: aload 6
    //   2270: astore 5
    //   2272: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2275: invokevirtual 205	android/media/MediaPlayer:start	()V
    //   2278: aload 6
    //   2280: astore 5
    //   2282: aload_0
    //   2283: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2286: iconst_2
    //   2287: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2290: aload 6
    //   2292: astore 5
    //   2294: aload_0
    //   2295: iconst_0
    //   2296: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   2299: aload 6
    //   2301: astore 5
    //   2303: aload 7
    //   2305: aload 8
    //   2307: invokevirtual 401	java/io/InputStream:read	([B)I
    //   2310: istore_2
    //   2311: iload_2
    //   2312: ifgt +392 -> 2704
    //   2315: aload 6
    //   2317: astore 5
    //   2319: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2322: ifeq +16 -> 2338
    //   2325: aload 6
    //   2327: astore 5
    //   2329: ldc 80
    //   2331: iconst_2
    //   2332: ldc_w 403
    //   2335: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2338: aload 6
    //   2340: astore 5
    //   2342: ldc2_w 341
    //   2345: invokestatic 346	java/lang/Thread:sleep	(J)V
    //   2348: iload_1
    //   2349: iconst_1
    //   2350: iadd
    //   2351: istore_1
    //   2352: goto -369 -> 1983
    //   2355: astore 9
    //   2357: aload 6
    //   2359: astore 5
    //   2361: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2364: ifeq -16 -> 2348
    //   2367: aload 6
    //   2369: astore 5
    //   2371: ldc 80
    //   2373: iconst_2
    //   2374: new 60	java/lang/StringBuilder
    //   2377: dup
    //   2378: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2381: ldc_w 405
    //   2384: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: aload 9
    //   2389: invokevirtual 349	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   2392: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2398: aload 9
    //   2400: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2403: goto -55 -> 2348
    //   2406: astore 7
    //   2408: aload 6
    //   2410: astore 5
    //   2412: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2415: ifeq +39 -> 2454
    //   2418: aload 6
    //   2420: astore 5
    //   2422: ldc 80
    //   2424: iconst_2
    //   2425: new 60	java/lang/StringBuilder
    //   2428: dup
    //   2429: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2432: ldc_w 407
    //   2435: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2438: aload 7
    //   2440: invokevirtual 85	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2443: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2449: aload 7
    //   2451: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2454: aload 6
    //   2456: astore 5
    //   2458: invokestatic 143	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2461: astore 7
    //   2463: iconst_0
    //   2464: istore 4
    //   2466: aload 7
    //   2468: ifnull +126 -> 2594
    //   2471: aload 6
    //   2473: astore 5
    //   2475: aload 7
    //   2477: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2480: astore 8
    //   2482: iload 4
    //   2484: istore_3
    //   2485: aload 6
    //   2487: astore 5
    //   2489: aload 8
    //   2491: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2494: ifne +44 -> 2538
    //   2497: iload 4
    //   2499: istore_3
    //   2500: aload 6
    //   2502: astore 5
    //   2504: aload 8
    //   2506: ldc 167
    //   2508: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2511: ifeq +27 -> 2538
    //   2514: aload 6
    //   2516: astore 5
    //   2518: aload_0
    //   2519: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2522: aload_0
    //   2523: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2526: aload 7
    //   2528: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2531: invokestatic 176	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   2534: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2537: istore_3
    //   2538: aload 6
    //   2540: astore 5
    //   2542: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2545: ifnull +49 -> 2594
    //   2548: aload 6
    //   2550: astore 5
    //   2552: aload_0
    //   2553: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2556: aload 7
    //   2558: getfield 159	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2561: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2564: ifne +7 -> 2571
    //   2567: iload_3
    //   2568: ifeq +26 -> 2594
    //   2571: aload 6
    //   2573: astore 5
    //   2575: invokestatic 188	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2578: invokevirtual 193	android/media/MediaPlayer:reset	()V
    //   2581: aload 6
    //   2583: astore 5
    //   2585: aload_0
    //   2586: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2589: bipush 6
    //   2591: invokestatic 208	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2594: aload 6
    //   2596: astore 5
    //   2598: invokestatic 410	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2601: ifnull +52 -> 2653
    //   2604: aload 6
    //   2606: astore 5
    //   2608: invokestatic 410	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2611: arraylength
    //   2612: iconst_1
    //   2613: if_icmpne +40 -> 2653
    //   2616: aload 6
    //   2618: astore 5
    //   2620: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2623: ifeq +16 -> 2639
    //   2626: aload 6
    //   2628: astore 5
    //   2630: ldc 80
    //   2632: iconst_2
    //   2633: ldc_w 412
    //   2636: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2639: aload 6
    //   2641: astore 5
    //   2643: aload_0
    //   2644: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2647: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2650: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2653: aload_0
    //   2654: iconst_0
    //   2655: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2658: aload 6
    //   2660: ifnull +8 -> 2668
    //   2663: aload 6
    //   2665: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   2668: aload_0
    //   2669: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2672: aload_0
    //   2673: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2676: if_icmpge -1631 -> 1045
    //   2679: aload_0
    //   2680: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2683: ifle -1638 -> 1045
    //   2686: aload_0
    //   2687: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2690: aload_0
    //   2691: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2694: aload_0
    //   2695: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2698: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   2701: goto -1656 -> 1045
    //   2704: iconst_0
    //   2705: istore_1
    //   2706: aload 6
    //   2708: astore 5
    //   2710: aload_0
    //   2711: aload_0
    //   2712: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2715: iload_2
    //   2716: iadd
    //   2717: putfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2720: aload 6
    //   2722: astore 5
    //   2724: aload 6
    //   2726: aload 8
    //   2728: iconst_0
    //   2729: iload_2
    //   2730: invokevirtual 416	java/io/RandomAccessFile:write	([BII)V
    //   2733: goto -750 -> 1983
    //   2736: astore 7
    //   2738: aload 6
    //   2740: astore 5
    //   2742: aload_0
    //   2743: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2746: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2749: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2752: aload 6
    //   2754: astore 5
    //   2756: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2759: ifeq +39 -> 2798
    //   2762: aload 6
    //   2764: astore 5
    //   2766: ldc 80
    //   2768: iconst_2
    //   2769: new 60	java/lang/StringBuilder
    //   2772: dup
    //   2773: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2776: ldc_w 418
    //   2779: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: aload 7
    //   2784: invokevirtual 419	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2787: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2790: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2793: aload 7
    //   2795: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2798: aload_0
    //   2799: iconst_0
    //   2800: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2803: aload 6
    //   2805: ifnull +8 -> 2813
    //   2808: aload 6
    //   2810: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   2813: aload_0
    //   2814: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2817: aload_0
    //   2818: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2821: if_icmpge -1776 -> 1045
    //   2824: aload_0
    //   2825: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2828: ifle -1783 -> 1045
    //   2831: aload_0
    //   2832: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2835: aload_0
    //   2836: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2839: aload_0
    //   2840: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2843: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   2846: goto -1801 -> 1045
    //   2849: aload 6
    //   2851: astore 5
    //   2853: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2856: ifeq +72 -> 2928
    //   2859: aload 6
    //   2861: astore 5
    //   2863: ldc 80
    //   2865: iconst_2
    //   2866: new 60	java/lang/StringBuilder
    //   2869: dup
    //   2870: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2873: ldc_w 421
    //   2876: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: aload_0
    //   2880: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2883: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2886: ldc_w 423
    //   2889: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: iload_1
    //   2893: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2896: ldc_w 374
    //   2899: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2902: aload_0
    //   2903: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2906: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2909: ldc_w 372
    //   2912: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2915: aload_0
    //   2916: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   2919: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2922: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2925: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2928: aload 7
    //   2930: ifnull +12 -> 2942
    //   2933: aload 6
    //   2935: astore 5
    //   2937: aload 7
    //   2939: invokevirtual 424	java/io/InputStream:close	()V
    //   2942: aload 6
    //   2944: astore 5
    //   2946: aload_0
    //   2947: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2950: aload_0
    //   2951: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2954: if_icmpne +25 -> 2979
    //   2957: aload 6
    //   2959: astore 5
    //   2961: aload_0
    //   2962: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2965: ifle +14 -> 2979
    //   2968: aload 6
    //   2970: astore 5
    //   2972: aload_0
    //   2973: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2976: invokestatic 426	badp:a	(Ljava/lang/String;)V
    //   2979: aload_0
    //   2980: iconst_0
    //   2981: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2984: aload 6
    //   2986: ifnull +8 -> 2994
    //   2989: aload 6
    //   2991: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   2994: aload_0
    //   2995: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2998: aload_0
    //   2999: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3002: if_icmpge -1957 -> 1045
    //   3005: aload_0
    //   3006: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3009: ifle -1964 -> 1045
    //   3012: aload_0
    //   3013: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3016: aload_0
    //   3017: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3020: aload_0
    //   3021: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3024: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   3027: goto -1982 -> 1045
    //   3030: astore 7
    //   3032: aconst_null
    //   3033: astore 6
    //   3035: aload 6
    //   3037: astore 5
    //   3039: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3042: ifeq +39 -> 3081
    //   3045: aload 6
    //   3047: astore 5
    //   3049: ldc 80
    //   3051: iconst_2
    //   3052: new 60	java/lang/StringBuilder
    //   3055: dup
    //   3056: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   3059: ldc_w 428
    //   3062: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3065: aload 7
    //   3067: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3070: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3076: aload 7
    //   3078: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3081: aload 6
    //   3083: astore 5
    //   3085: aload_0
    //   3086: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   3089: invokevirtual 115	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   3092: invokestatic 118	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   3095: aload_0
    //   3096: iconst_0
    //   3097: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3100: aload 6
    //   3102: ifnull +8 -> 3110
    //   3105: aload 6
    //   3107: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   3110: aload_0
    //   3111: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3114: aload_0
    //   3115: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3118: if_icmpge -2073 -> 1045
    //   3121: aload_0
    //   3122: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3125: ifle -2080 -> 1045
    //   3128: aload_0
    //   3129: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3132: aload_0
    //   3133: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3136: aload_0
    //   3137: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3140: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   3143: goto -2098 -> 1045
    //   3146: astore 6
    //   3148: aconst_null
    //   3149: astore 5
    //   3151: aload_0
    //   3152: iconst_0
    //   3153: putfield 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3156: aload 5
    //   3158: ifnull +8 -> 3166
    //   3161: aload 5
    //   3163: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   3166: aload_0
    //   3167: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3170: aload_0
    //   3171: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3174: if_icmpge +25 -> 3199
    //   3177: aload_0
    //   3178: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3181: ifle +18 -> 3199
    //   3184: aload_0
    //   3185: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3188: aload_0
    //   3189: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3192: aload_0
    //   3193: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3196: invokestatic 156	badp:a	(Ljava/lang/String;II)V
    //   3199: aload 6
    //   3201: athrow
    //   3202: astore 5
    //   3204: goto -3046 -> 158
    //   3207: astore 5
    //   3209: goto -1946 -> 1263
    //   3212: astore 5
    //   3214: goto -1482 -> 1732
    //   3217: astore 5
    //   3219: goto -1153 -> 2066
    //   3222: astore 5
    //   3224: goto -230 -> 2994
    //   3227: astore 5
    //   3229: goto -2217 -> 1012
    //   3232: astore 5
    //   3234: goto -1788 -> 1446
    //   3237: astore 5
    //   3239: goto -571 -> 2668
    //   3242: astore 5
    //   3244: goto -431 -> 2813
    //   3247: astore 5
    //   3249: goto -139 -> 3110
    //   3252: astore 5
    //   3254: goto -88 -> 3166
    //   3257: astore 6
    //   3259: goto -108 -> 3151
    //   3262: astore 6
    //   3264: goto -113 -> 3151
    //   3267: astore 7
    //   3269: goto -234 -> 3035
    //   3272: astore 7
    //   3274: aconst_null
    //   3275: astore 6
    //   3277: goto -539 -> 2738
    //   3280: astore 7
    //   3282: aconst_null
    //   3283: astore 6
    //   3285: goto -877 -> 2408
    //   3288: astore 7
    //   3290: aconst_null
    //   3291: astore 6
    //   3293: goto -1922 -> 1371
    //   3296: astore 6
    //   3298: goto -2349 -> 949
    //   3301: aload 7
    //   3303: astore 5
    //   3305: goto -2904 -> 401
    //   3308: aload 5
    //   3310: astore 7
    //   3312: goto -2104 -> 1208
    //   3315: iconst_0
    //   3316: istore_3
    //   3317: goto -3067 -> 250
    //   3320: iconst_0
    //   3321: istore_2
    //   3322: iconst_0
    //   3323: istore_1
    //   3324: aconst_null
    //   3325: astore 5
    //   3327: goto -2926 -> 401
    //   3330: aload 7
    //   3332: astore 5
    //   3334: goto -2933 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3337	0	this	DownloadThread
    //   405	2919	1	i	int
    //   401	2921	2	j	int
    //   249	3068	3	bool1	boolean
    //   2464	34	4	bool2	boolean
    //   3	3159	5	localObject1	java.lang.Object
    //   3202	1	5	localIOException1	IOException
    //   3207	1	5	localIOException2	IOException
    //   3212	1	5	localIOException3	IOException
    //   3217	1	5	localIOException4	IOException
    //   3222	1	5	localIOException5	IOException
    //   3227	1	5	localIOException6	IOException
    //   3232	1	5	localIOException7	IOException
    //   3237	1	5	localIOException8	IOException
    //   3242	1	5	localIOException9	IOException
    //   3247	1	5	localIOException10	IOException
    //   3252	1	5	localIOException11	IOException
    //   3303	30	5	localObject2	java.lang.Object
    //   75	3031	6	localObject3	java.lang.Object
    //   3146	54	6	localObject4	java.lang.Object
    //   3257	1	6	localObject5	java.lang.Object
    //   3262	1	6	localObject6	java.lang.Object
    //   3275	17	6	localObject7	java.lang.Object
    //   3296	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   114	781	7	localObject8	java.lang.Object
    //   939	373	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   1369	166	7	localMalformedURLException1	java.net.MalformedURLException
    //   1864	440	7	localInputStream	java.io.InputStream
    //   2406	44	7	localIOException12	IOException
    //   2461	96	7	localSongInfo	SongInfo
    //   2736	202	7	localIllegalStateException1	java.lang.IllegalStateException
    //   3030	47	7	localException1	java.lang.Exception
    //   3267	1	7	localException2	java.lang.Exception
    //   3272	1	7	localIllegalStateException2	java.lang.IllegalStateException
    //   3280	1	7	localIOException13	IOException
    //   3288	14	7	localMalformedURLException2	java.net.MalformedURLException
    //   3310	21	7	localObject9	java.lang.Object
    //   105	2622	8	localObject10	java.lang.Object
    //   90	2026	9	localObject11	java.lang.Object
    //   2355	44	9	localInterruptedException1	java.lang.InterruptedException
    //   54	2124	10	localFile	File
    //   201	599	11	str	String
    //   1109	44	11	localInterruptedException2	java.lang.InterruptedException
    //   1318	44	11	localInterruptedException3	java.lang.InterruptedException
    //   572	140	12	localObject12	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   81	92	939	java/io/FileNotFoundException
    //   96	107	939	java/io/FileNotFoundException
    //   111	116	939	java/io/FileNotFoundException
    //   125	131	939	java/io/FileNotFoundException
    //   135	143	939	java/io/FileNotFoundException
    //   196	203	939	java/io/FileNotFoundException
    //   207	215	939	java/io/FileNotFoundException
    //   219	229	939	java/io/FileNotFoundException
    //   233	250	939	java/io/FileNotFoundException
    //   254	269	939	java/io/FileNotFoundException
    //   277	284	939	java/io/FileNotFoundException
    //   288	310	939	java/io/FileNotFoundException
    //   314	320	939	java/io/FileNotFoundException
    //   324	332	939	java/io/FileNotFoundException
    //   336	342	939	java/io/FileNotFoundException
    //   346	357	939	java/io/FileNotFoundException
    //   361	367	939	java/io/FileNotFoundException
    //   371	377	939	java/io/FileNotFoundException
    //   381	389	939	java/io/FileNotFoundException
    //   393	398	939	java/io/FileNotFoundException
    //   414	424	939	java/io/FileNotFoundException
    //   428	434	939	java/io/FileNotFoundException
    //   438	447	939	java/io/FileNotFoundException
    //   451	458	939	java/io/FileNotFoundException
    //   462	473	939	java/io/FileNotFoundException
    //   477	518	939	java/io/FileNotFoundException
    //   522	529	939	java/io/FileNotFoundException
    //   533	541	939	java/io/FileNotFoundException
    //   545	555	939	java/io/FileNotFoundException
    //   559	574	939	java/io/FileNotFoundException
    //   578	589	939	java/io/FileNotFoundException
    //   593	617	939	java/io/FileNotFoundException
    //   626	634	939	java/io/FileNotFoundException
    //   638	653	939	java/io/FileNotFoundException
    //   657	666	939	java/io/FileNotFoundException
    //   670	694	939	java/io/FileNotFoundException
    //   698	738	939	java/io/FileNotFoundException
    //   742	748	939	java/io/FileNotFoundException
    //   752	790	939	java/io/FileNotFoundException
    //   794	804	939	java/io/FileNotFoundException
    //   808	813	939	java/io/FileNotFoundException
    //   817	828	939	java/io/FileNotFoundException
    //   836	853	939	java/io/FileNotFoundException
    //   857	863	939	java/io/FileNotFoundException
    //   867	894	939	java/io/FileNotFoundException
    //   905	911	939	java/io/FileNotFoundException
    //   915	924	939	java/io/FileNotFoundException
    //   928	936	939	java/io/FileNotFoundException
    //   1080	1088	939	java/io/FileNotFoundException
    //   1096	1102	939	java/io/FileNotFoundException
    //   1115	1121	939	java/io/FileNotFoundException
    //   1125	1157	939	java/io/FileNotFoundException
    //   1164	1194	939	java/io/FileNotFoundException
    //   1198	1204	939	java/io/FileNotFoundException
    //   1216	1222	939	java/io/FileNotFoundException
    //   1226	1235	939	java/io/FileNotFoundException
    //   1239	1248	939	java/io/FileNotFoundException
    //   1301	1307	939	java/io/FileNotFoundException
    //   1324	1330	939	java/io/FileNotFoundException
    //   1334	1366	939	java/io/FileNotFoundException
    //   1488	1495	939	java/io/FileNotFoundException
    //   1499	1506	939	java/io/FileNotFoundException
    //   1510	1515	939	java/io/FileNotFoundException
    //   1525	1532	939	java/io/FileNotFoundException
    //   1542	1550	939	java/io/FileNotFoundException
    //   1554	1560	939	java/io/FileNotFoundException
    //   1564	1603	939	java/io/FileNotFoundException
    //   1607	1612	939	java/io/FileNotFoundException
    //   1616	1621	939	java/io/FileNotFoundException
    //   1625	1635	939	java/io/FileNotFoundException
    //   1639	1645	939	java/io/FileNotFoundException
    //   1649	1658	939	java/io/FileNotFoundException
    //   1662	1667	939	java/io/FileNotFoundException
    //   1671	1677	939	java/io/FileNotFoundException
    //   1685	1691	939	java/io/FileNotFoundException
    //   1695	1704	939	java/io/FileNotFoundException
    //   1708	1717	939	java/io/FileNotFoundException
    //   1770	1775	939	java/io/FileNotFoundException
    //   1779	1786	939	java/io/FileNotFoundException
    //   1790	1796	939	java/io/FileNotFoundException
    //   1800	1855	939	java/io/FileNotFoundException
    //   1859	1866	939	java/io/FileNotFoundException
    //   1870	1877	939	java/io/FileNotFoundException
    //   1881	1891	939	java/io/FileNotFoundException
    //   1895	1902	939	java/io/FileNotFoundException
    //   1906	1921	939	java/io/FileNotFoundException
    //   1929	1935	939	java/io/FileNotFoundException
    //   1939	1981	939	java/io/FileNotFoundException
    //   1987	1994	939	java/io/FileNotFoundException
    //   1998	2009	939	java/io/FileNotFoundException
    //   2019	2024	939	java/io/FileNotFoundException
    //   2033	2039	939	java/io/FileNotFoundException
    //   2043	2051	939	java/io/FileNotFoundException
    //   2104	2111	939	java/io/FileNotFoundException
    //   2115	2130	939	java/io/FileNotFoundException
    //   2138	2160	939	java/io/FileNotFoundException
    //   2164	2170	939	java/io/FileNotFoundException
    //   2174	2185	939	java/io/FileNotFoundException
    //   2189	2195	939	java/io/FileNotFoundException
    //   2199	2205	939	java/io/FileNotFoundException
    //   2209	2254	939	java/io/FileNotFoundException
    //   2258	2268	939	java/io/FileNotFoundException
    //   2272	2278	939	java/io/FileNotFoundException
    //   2282	2290	939	java/io/FileNotFoundException
    //   2294	2299	939	java/io/FileNotFoundException
    //   2303	2311	939	java/io/FileNotFoundException
    //   2319	2325	939	java/io/FileNotFoundException
    //   2329	2338	939	java/io/FileNotFoundException
    //   2342	2348	939	java/io/FileNotFoundException
    //   2361	2367	939	java/io/FileNotFoundException
    //   2371	2403	939	java/io/FileNotFoundException
    //   2710	2720	939	java/io/FileNotFoundException
    //   2724	2733	939	java/io/FileNotFoundException
    //   2853	2859	939	java/io/FileNotFoundException
    //   2863	2928	939	java/io/FileNotFoundException
    //   2937	2942	939	java/io/FileNotFoundException
    //   2946	2957	939	java/io/FileNotFoundException
    //   2961	2968	939	java/io/FileNotFoundException
    //   2972	2979	939	java/io/FileNotFoundException
    //   1096	1102	1109	java/lang/InterruptedException
    //   1301	1307	1318	java/lang/InterruptedException
    //   81	92	1369	java/net/MalformedURLException
    //   96	107	1369	java/net/MalformedURLException
    //   111	116	1369	java/net/MalformedURLException
    //   125	131	1369	java/net/MalformedURLException
    //   135	143	1369	java/net/MalformedURLException
    //   196	203	1369	java/net/MalformedURLException
    //   207	215	1369	java/net/MalformedURLException
    //   219	229	1369	java/net/MalformedURLException
    //   233	250	1369	java/net/MalformedURLException
    //   254	269	1369	java/net/MalformedURLException
    //   277	284	1369	java/net/MalformedURLException
    //   288	310	1369	java/net/MalformedURLException
    //   314	320	1369	java/net/MalformedURLException
    //   324	332	1369	java/net/MalformedURLException
    //   336	342	1369	java/net/MalformedURLException
    //   346	357	1369	java/net/MalformedURLException
    //   361	367	1369	java/net/MalformedURLException
    //   371	377	1369	java/net/MalformedURLException
    //   381	389	1369	java/net/MalformedURLException
    //   393	398	1369	java/net/MalformedURLException
    //   414	424	1369	java/net/MalformedURLException
    //   428	434	1369	java/net/MalformedURLException
    //   438	447	1369	java/net/MalformedURLException
    //   451	458	1369	java/net/MalformedURLException
    //   462	473	1369	java/net/MalformedURLException
    //   477	518	1369	java/net/MalformedURLException
    //   522	529	1369	java/net/MalformedURLException
    //   533	541	1369	java/net/MalformedURLException
    //   545	555	1369	java/net/MalformedURLException
    //   559	574	1369	java/net/MalformedURLException
    //   578	589	1369	java/net/MalformedURLException
    //   593	617	1369	java/net/MalformedURLException
    //   626	634	1369	java/net/MalformedURLException
    //   638	653	1369	java/net/MalformedURLException
    //   657	666	1369	java/net/MalformedURLException
    //   670	694	1369	java/net/MalformedURLException
    //   698	738	1369	java/net/MalformedURLException
    //   742	748	1369	java/net/MalformedURLException
    //   752	790	1369	java/net/MalformedURLException
    //   794	804	1369	java/net/MalformedURLException
    //   808	813	1369	java/net/MalformedURLException
    //   817	828	1369	java/net/MalformedURLException
    //   836	853	1369	java/net/MalformedURLException
    //   857	863	1369	java/net/MalformedURLException
    //   867	894	1369	java/net/MalformedURLException
    //   905	911	1369	java/net/MalformedURLException
    //   915	924	1369	java/net/MalformedURLException
    //   928	936	1369	java/net/MalformedURLException
    //   1080	1088	1369	java/net/MalformedURLException
    //   1096	1102	1369	java/net/MalformedURLException
    //   1115	1121	1369	java/net/MalformedURLException
    //   1125	1157	1369	java/net/MalformedURLException
    //   1164	1194	1369	java/net/MalformedURLException
    //   1198	1204	1369	java/net/MalformedURLException
    //   1216	1222	1369	java/net/MalformedURLException
    //   1226	1235	1369	java/net/MalformedURLException
    //   1239	1248	1369	java/net/MalformedURLException
    //   1301	1307	1369	java/net/MalformedURLException
    //   1324	1330	1369	java/net/MalformedURLException
    //   1334	1366	1369	java/net/MalformedURLException
    //   1488	1495	1369	java/net/MalformedURLException
    //   1499	1506	1369	java/net/MalformedURLException
    //   1510	1515	1369	java/net/MalformedURLException
    //   1525	1532	1369	java/net/MalformedURLException
    //   1542	1550	1369	java/net/MalformedURLException
    //   1554	1560	1369	java/net/MalformedURLException
    //   1564	1603	1369	java/net/MalformedURLException
    //   1607	1612	1369	java/net/MalformedURLException
    //   1616	1621	1369	java/net/MalformedURLException
    //   1625	1635	1369	java/net/MalformedURLException
    //   1639	1645	1369	java/net/MalformedURLException
    //   1649	1658	1369	java/net/MalformedURLException
    //   1662	1667	1369	java/net/MalformedURLException
    //   1671	1677	1369	java/net/MalformedURLException
    //   1685	1691	1369	java/net/MalformedURLException
    //   1695	1704	1369	java/net/MalformedURLException
    //   1708	1717	1369	java/net/MalformedURLException
    //   1770	1775	1369	java/net/MalformedURLException
    //   1779	1786	1369	java/net/MalformedURLException
    //   1790	1796	1369	java/net/MalformedURLException
    //   1800	1855	1369	java/net/MalformedURLException
    //   1859	1866	1369	java/net/MalformedURLException
    //   1870	1877	1369	java/net/MalformedURLException
    //   1881	1891	1369	java/net/MalformedURLException
    //   1895	1902	1369	java/net/MalformedURLException
    //   1906	1921	1369	java/net/MalformedURLException
    //   1929	1935	1369	java/net/MalformedURLException
    //   1939	1981	1369	java/net/MalformedURLException
    //   1987	1994	1369	java/net/MalformedURLException
    //   1998	2009	1369	java/net/MalformedURLException
    //   2019	2024	1369	java/net/MalformedURLException
    //   2033	2039	1369	java/net/MalformedURLException
    //   2043	2051	1369	java/net/MalformedURLException
    //   2104	2111	1369	java/net/MalformedURLException
    //   2115	2130	1369	java/net/MalformedURLException
    //   2138	2160	1369	java/net/MalformedURLException
    //   2164	2170	1369	java/net/MalformedURLException
    //   2174	2185	1369	java/net/MalformedURLException
    //   2189	2195	1369	java/net/MalformedURLException
    //   2199	2205	1369	java/net/MalformedURLException
    //   2209	2254	1369	java/net/MalformedURLException
    //   2258	2268	1369	java/net/MalformedURLException
    //   2272	2278	1369	java/net/MalformedURLException
    //   2282	2290	1369	java/net/MalformedURLException
    //   2294	2299	1369	java/net/MalformedURLException
    //   2303	2311	1369	java/net/MalformedURLException
    //   2319	2325	1369	java/net/MalformedURLException
    //   2329	2338	1369	java/net/MalformedURLException
    //   2342	2348	1369	java/net/MalformedURLException
    //   2361	2367	1369	java/net/MalformedURLException
    //   2371	2403	1369	java/net/MalformedURLException
    //   2710	2720	1369	java/net/MalformedURLException
    //   2724	2733	1369	java/net/MalformedURLException
    //   2853	2859	1369	java/net/MalformedURLException
    //   2863	2928	1369	java/net/MalformedURLException
    //   2937	2942	1369	java/net/MalformedURLException
    //   2946	2957	1369	java/net/MalformedURLException
    //   2961	2968	1369	java/net/MalformedURLException
    //   2972	2979	1369	java/net/MalformedURLException
    //   2342	2348	2355	java/lang/InterruptedException
    //   81	92	2406	java/io/IOException
    //   96	107	2406	java/io/IOException
    //   111	116	2406	java/io/IOException
    //   125	131	2406	java/io/IOException
    //   135	143	2406	java/io/IOException
    //   196	203	2406	java/io/IOException
    //   207	215	2406	java/io/IOException
    //   219	229	2406	java/io/IOException
    //   233	250	2406	java/io/IOException
    //   254	269	2406	java/io/IOException
    //   277	284	2406	java/io/IOException
    //   288	310	2406	java/io/IOException
    //   314	320	2406	java/io/IOException
    //   324	332	2406	java/io/IOException
    //   336	342	2406	java/io/IOException
    //   346	357	2406	java/io/IOException
    //   361	367	2406	java/io/IOException
    //   371	377	2406	java/io/IOException
    //   381	389	2406	java/io/IOException
    //   393	398	2406	java/io/IOException
    //   414	424	2406	java/io/IOException
    //   428	434	2406	java/io/IOException
    //   438	447	2406	java/io/IOException
    //   451	458	2406	java/io/IOException
    //   462	473	2406	java/io/IOException
    //   477	518	2406	java/io/IOException
    //   522	529	2406	java/io/IOException
    //   533	541	2406	java/io/IOException
    //   545	555	2406	java/io/IOException
    //   559	574	2406	java/io/IOException
    //   578	589	2406	java/io/IOException
    //   593	617	2406	java/io/IOException
    //   626	634	2406	java/io/IOException
    //   638	653	2406	java/io/IOException
    //   657	666	2406	java/io/IOException
    //   670	694	2406	java/io/IOException
    //   698	738	2406	java/io/IOException
    //   742	748	2406	java/io/IOException
    //   752	790	2406	java/io/IOException
    //   794	804	2406	java/io/IOException
    //   808	813	2406	java/io/IOException
    //   817	828	2406	java/io/IOException
    //   836	853	2406	java/io/IOException
    //   857	863	2406	java/io/IOException
    //   867	894	2406	java/io/IOException
    //   905	911	2406	java/io/IOException
    //   915	924	2406	java/io/IOException
    //   928	936	2406	java/io/IOException
    //   1080	1088	2406	java/io/IOException
    //   1096	1102	2406	java/io/IOException
    //   1115	1121	2406	java/io/IOException
    //   1125	1157	2406	java/io/IOException
    //   1164	1194	2406	java/io/IOException
    //   1198	1204	2406	java/io/IOException
    //   1216	1222	2406	java/io/IOException
    //   1226	1235	2406	java/io/IOException
    //   1239	1248	2406	java/io/IOException
    //   1301	1307	2406	java/io/IOException
    //   1324	1330	2406	java/io/IOException
    //   1334	1366	2406	java/io/IOException
    //   1488	1495	2406	java/io/IOException
    //   1499	1506	2406	java/io/IOException
    //   1510	1515	2406	java/io/IOException
    //   1525	1532	2406	java/io/IOException
    //   1542	1550	2406	java/io/IOException
    //   1554	1560	2406	java/io/IOException
    //   1564	1603	2406	java/io/IOException
    //   1607	1612	2406	java/io/IOException
    //   1616	1621	2406	java/io/IOException
    //   1625	1635	2406	java/io/IOException
    //   1639	1645	2406	java/io/IOException
    //   1649	1658	2406	java/io/IOException
    //   1662	1667	2406	java/io/IOException
    //   1671	1677	2406	java/io/IOException
    //   1685	1691	2406	java/io/IOException
    //   1695	1704	2406	java/io/IOException
    //   1708	1717	2406	java/io/IOException
    //   1770	1775	2406	java/io/IOException
    //   1779	1786	2406	java/io/IOException
    //   1790	1796	2406	java/io/IOException
    //   1800	1855	2406	java/io/IOException
    //   1859	1866	2406	java/io/IOException
    //   1870	1877	2406	java/io/IOException
    //   1881	1891	2406	java/io/IOException
    //   1895	1902	2406	java/io/IOException
    //   1906	1921	2406	java/io/IOException
    //   1929	1935	2406	java/io/IOException
    //   1939	1981	2406	java/io/IOException
    //   1987	1994	2406	java/io/IOException
    //   1998	2009	2406	java/io/IOException
    //   2019	2024	2406	java/io/IOException
    //   2033	2039	2406	java/io/IOException
    //   2043	2051	2406	java/io/IOException
    //   2104	2111	2406	java/io/IOException
    //   2115	2130	2406	java/io/IOException
    //   2138	2160	2406	java/io/IOException
    //   2164	2170	2406	java/io/IOException
    //   2174	2185	2406	java/io/IOException
    //   2189	2195	2406	java/io/IOException
    //   2199	2205	2406	java/io/IOException
    //   2209	2254	2406	java/io/IOException
    //   2258	2268	2406	java/io/IOException
    //   2272	2278	2406	java/io/IOException
    //   2282	2290	2406	java/io/IOException
    //   2294	2299	2406	java/io/IOException
    //   2303	2311	2406	java/io/IOException
    //   2319	2325	2406	java/io/IOException
    //   2329	2338	2406	java/io/IOException
    //   2342	2348	2406	java/io/IOException
    //   2361	2367	2406	java/io/IOException
    //   2371	2403	2406	java/io/IOException
    //   2710	2720	2406	java/io/IOException
    //   2724	2733	2406	java/io/IOException
    //   2853	2859	2406	java/io/IOException
    //   2863	2928	2406	java/io/IOException
    //   2937	2942	2406	java/io/IOException
    //   2946	2957	2406	java/io/IOException
    //   2961	2968	2406	java/io/IOException
    //   2972	2979	2406	java/io/IOException
    //   81	92	2736	java/lang/IllegalStateException
    //   96	107	2736	java/lang/IllegalStateException
    //   111	116	2736	java/lang/IllegalStateException
    //   125	131	2736	java/lang/IllegalStateException
    //   135	143	2736	java/lang/IllegalStateException
    //   196	203	2736	java/lang/IllegalStateException
    //   207	215	2736	java/lang/IllegalStateException
    //   219	229	2736	java/lang/IllegalStateException
    //   233	250	2736	java/lang/IllegalStateException
    //   254	269	2736	java/lang/IllegalStateException
    //   277	284	2736	java/lang/IllegalStateException
    //   288	310	2736	java/lang/IllegalStateException
    //   314	320	2736	java/lang/IllegalStateException
    //   324	332	2736	java/lang/IllegalStateException
    //   336	342	2736	java/lang/IllegalStateException
    //   346	357	2736	java/lang/IllegalStateException
    //   361	367	2736	java/lang/IllegalStateException
    //   371	377	2736	java/lang/IllegalStateException
    //   381	389	2736	java/lang/IllegalStateException
    //   393	398	2736	java/lang/IllegalStateException
    //   414	424	2736	java/lang/IllegalStateException
    //   428	434	2736	java/lang/IllegalStateException
    //   438	447	2736	java/lang/IllegalStateException
    //   451	458	2736	java/lang/IllegalStateException
    //   462	473	2736	java/lang/IllegalStateException
    //   477	518	2736	java/lang/IllegalStateException
    //   522	529	2736	java/lang/IllegalStateException
    //   533	541	2736	java/lang/IllegalStateException
    //   545	555	2736	java/lang/IllegalStateException
    //   559	574	2736	java/lang/IllegalStateException
    //   578	589	2736	java/lang/IllegalStateException
    //   593	617	2736	java/lang/IllegalStateException
    //   626	634	2736	java/lang/IllegalStateException
    //   638	653	2736	java/lang/IllegalStateException
    //   657	666	2736	java/lang/IllegalStateException
    //   670	694	2736	java/lang/IllegalStateException
    //   698	738	2736	java/lang/IllegalStateException
    //   742	748	2736	java/lang/IllegalStateException
    //   752	790	2736	java/lang/IllegalStateException
    //   794	804	2736	java/lang/IllegalStateException
    //   808	813	2736	java/lang/IllegalStateException
    //   817	828	2736	java/lang/IllegalStateException
    //   836	853	2736	java/lang/IllegalStateException
    //   857	863	2736	java/lang/IllegalStateException
    //   867	894	2736	java/lang/IllegalStateException
    //   905	911	2736	java/lang/IllegalStateException
    //   915	924	2736	java/lang/IllegalStateException
    //   928	936	2736	java/lang/IllegalStateException
    //   1080	1088	2736	java/lang/IllegalStateException
    //   1096	1102	2736	java/lang/IllegalStateException
    //   1115	1121	2736	java/lang/IllegalStateException
    //   1125	1157	2736	java/lang/IllegalStateException
    //   1164	1194	2736	java/lang/IllegalStateException
    //   1198	1204	2736	java/lang/IllegalStateException
    //   1216	1222	2736	java/lang/IllegalStateException
    //   1226	1235	2736	java/lang/IllegalStateException
    //   1239	1248	2736	java/lang/IllegalStateException
    //   1301	1307	2736	java/lang/IllegalStateException
    //   1324	1330	2736	java/lang/IllegalStateException
    //   1334	1366	2736	java/lang/IllegalStateException
    //   1488	1495	2736	java/lang/IllegalStateException
    //   1499	1506	2736	java/lang/IllegalStateException
    //   1510	1515	2736	java/lang/IllegalStateException
    //   1525	1532	2736	java/lang/IllegalStateException
    //   1542	1550	2736	java/lang/IllegalStateException
    //   1554	1560	2736	java/lang/IllegalStateException
    //   1564	1603	2736	java/lang/IllegalStateException
    //   1607	1612	2736	java/lang/IllegalStateException
    //   1616	1621	2736	java/lang/IllegalStateException
    //   1625	1635	2736	java/lang/IllegalStateException
    //   1639	1645	2736	java/lang/IllegalStateException
    //   1649	1658	2736	java/lang/IllegalStateException
    //   1662	1667	2736	java/lang/IllegalStateException
    //   1671	1677	2736	java/lang/IllegalStateException
    //   1685	1691	2736	java/lang/IllegalStateException
    //   1695	1704	2736	java/lang/IllegalStateException
    //   1708	1717	2736	java/lang/IllegalStateException
    //   1770	1775	2736	java/lang/IllegalStateException
    //   1779	1786	2736	java/lang/IllegalStateException
    //   1790	1796	2736	java/lang/IllegalStateException
    //   1800	1855	2736	java/lang/IllegalStateException
    //   1859	1866	2736	java/lang/IllegalStateException
    //   1870	1877	2736	java/lang/IllegalStateException
    //   1881	1891	2736	java/lang/IllegalStateException
    //   1895	1902	2736	java/lang/IllegalStateException
    //   1906	1921	2736	java/lang/IllegalStateException
    //   1929	1935	2736	java/lang/IllegalStateException
    //   1939	1981	2736	java/lang/IllegalStateException
    //   1987	1994	2736	java/lang/IllegalStateException
    //   1998	2009	2736	java/lang/IllegalStateException
    //   2019	2024	2736	java/lang/IllegalStateException
    //   2033	2039	2736	java/lang/IllegalStateException
    //   2043	2051	2736	java/lang/IllegalStateException
    //   2104	2111	2736	java/lang/IllegalStateException
    //   2115	2130	2736	java/lang/IllegalStateException
    //   2138	2160	2736	java/lang/IllegalStateException
    //   2164	2170	2736	java/lang/IllegalStateException
    //   2174	2185	2736	java/lang/IllegalStateException
    //   2189	2195	2736	java/lang/IllegalStateException
    //   2199	2205	2736	java/lang/IllegalStateException
    //   2209	2254	2736	java/lang/IllegalStateException
    //   2258	2268	2736	java/lang/IllegalStateException
    //   2272	2278	2736	java/lang/IllegalStateException
    //   2282	2290	2736	java/lang/IllegalStateException
    //   2294	2299	2736	java/lang/IllegalStateException
    //   2303	2311	2736	java/lang/IllegalStateException
    //   2319	2325	2736	java/lang/IllegalStateException
    //   2329	2338	2736	java/lang/IllegalStateException
    //   2342	2348	2736	java/lang/IllegalStateException
    //   2361	2367	2736	java/lang/IllegalStateException
    //   2371	2403	2736	java/lang/IllegalStateException
    //   2710	2720	2736	java/lang/IllegalStateException
    //   2724	2733	2736	java/lang/IllegalStateException
    //   2853	2859	2736	java/lang/IllegalStateException
    //   2863	2928	2736	java/lang/IllegalStateException
    //   2937	2942	2736	java/lang/IllegalStateException
    //   2946	2957	2736	java/lang/IllegalStateException
    //   2961	2968	2736	java/lang/IllegalStateException
    //   2972	2979	2736	java/lang/IllegalStateException
    //   64	77	3030	java/lang/Exception
    //   64	77	3146	finally
    //   153	158	3202	java/io/IOException
    //   1258	1263	3207	java/io/IOException
    //   1727	1732	3212	java/io/IOException
    //   2061	2066	3217	java/io/IOException
    //   2989	2994	3222	java/io/IOException
    //   1007	1012	3227	java/io/IOException
    //   1441	1446	3232	java/io/IOException
    //   2663	2668	3237	java/io/IOException
    //   2808	2813	3242	java/io/IOException
    //   3105	3110	3247	java/io/IOException
    //   3161	3166	3252	java/io/IOException
    //   81	92	3257	finally
    //   96	107	3257	finally
    //   111	116	3257	finally
    //   125	131	3257	finally
    //   135	143	3257	finally
    //   196	203	3257	finally
    //   207	215	3257	finally
    //   219	229	3257	finally
    //   233	250	3257	finally
    //   254	269	3257	finally
    //   277	284	3257	finally
    //   288	310	3257	finally
    //   314	320	3257	finally
    //   324	332	3257	finally
    //   336	342	3257	finally
    //   346	357	3257	finally
    //   361	367	3257	finally
    //   371	377	3257	finally
    //   381	389	3257	finally
    //   393	398	3257	finally
    //   414	424	3257	finally
    //   428	434	3257	finally
    //   438	447	3257	finally
    //   451	458	3257	finally
    //   462	473	3257	finally
    //   477	518	3257	finally
    //   522	529	3257	finally
    //   533	541	3257	finally
    //   545	555	3257	finally
    //   559	574	3257	finally
    //   578	589	3257	finally
    //   593	617	3257	finally
    //   626	634	3257	finally
    //   638	653	3257	finally
    //   657	666	3257	finally
    //   670	694	3257	finally
    //   698	738	3257	finally
    //   742	748	3257	finally
    //   752	790	3257	finally
    //   794	804	3257	finally
    //   808	813	3257	finally
    //   817	828	3257	finally
    //   836	853	3257	finally
    //   857	863	3257	finally
    //   867	894	3257	finally
    //   905	911	3257	finally
    //   915	924	3257	finally
    //   928	936	3257	finally
    //   1080	1088	3257	finally
    //   1096	1102	3257	finally
    //   1115	1121	3257	finally
    //   1125	1157	3257	finally
    //   1164	1194	3257	finally
    //   1198	1204	3257	finally
    //   1216	1222	3257	finally
    //   1226	1235	3257	finally
    //   1239	1248	3257	finally
    //   1301	1307	3257	finally
    //   1324	1330	3257	finally
    //   1334	1366	3257	finally
    //   1375	1385	3257	finally
    //   1389	1395	3257	finally
    //   1399	1431	3257	finally
    //   1488	1495	3257	finally
    //   1499	1506	3257	finally
    //   1510	1515	3257	finally
    //   1525	1532	3257	finally
    //   1542	1550	3257	finally
    //   1554	1560	3257	finally
    //   1564	1603	3257	finally
    //   1607	1612	3257	finally
    //   1616	1621	3257	finally
    //   1625	1635	3257	finally
    //   1639	1645	3257	finally
    //   1649	1658	3257	finally
    //   1662	1667	3257	finally
    //   1671	1677	3257	finally
    //   1685	1691	3257	finally
    //   1695	1704	3257	finally
    //   1708	1717	3257	finally
    //   1770	1775	3257	finally
    //   1779	1786	3257	finally
    //   1790	1796	3257	finally
    //   1800	1855	3257	finally
    //   1859	1866	3257	finally
    //   1870	1877	3257	finally
    //   1881	1891	3257	finally
    //   1895	1902	3257	finally
    //   1906	1921	3257	finally
    //   1929	1935	3257	finally
    //   1939	1981	3257	finally
    //   1987	1994	3257	finally
    //   1998	2009	3257	finally
    //   2019	2024	3257	finally
    //   2033	2039	3257	finally
    //   2043	2051	3257	finally
    //   2104	2111	3257	finally
    //   2115	2130	3257	finally
    //   2138	2160	3257	finally
    //   2164	2170	3257	finally
    //   2174	2185	3257	finally
    //   2189	2195	3257	finally
    //   2199	2205	3257	finally
    //   2209	2254	3257	finally
    //   2258	2268	3257	finally
    //   2272	2278	3257	finally
    //   2282	2290	3257	finally
    //   2294	2299	3257	finally
    //   2303	2311	3257	finally
    //   2319	2325	3257	finally
    //   2329	2338	3257	finally
    //   2342	2348	3257	finally
    //   2361	2367	3257	finally
    //   2371	2403	3257	finally
    //   2412	2418	3257	finally
    //   2422	2454	3257	finally
    //   2458	2463	3257	finally
    //   2475	2482	3257	finally
    //   2489	2497	3257	finally
    //   2504	2514	3257	finally
    //   2518	2538	3257	finally
    //   2542	2548	3257	finally
    //   2552	2567	3257	finally
    //   2575	2581	3257	finally
    //   2585	2594	3257	finally
    //   2598	2604	3257	finally
    //   2608	2616	3257	finally
    //   2620	2626	3257	finally
    //   2630	2639	3257	finally
    //   2643	2653	3257	finally
    //   2710	2720	3257	finally
    //   2724	2733	3257	finally
    //   2742	2752	3257	finally
    //   2756	2762	3257	finally
    //   2766	2798	3257	finally
    //   2853	2859	3257	finally
    //   2863	2928	3257	finally
    //   2937	2942	3257	finally
    //   2946	2957	3257	finally
    //   2961	2968	3257	finally
    //   2972	2979	3257	finally
    //   3039	3045	3257	finally
    //   3049	3081	3257	finally
    //   3085	3095	3257	finally
    //   949	987	3262	finally
    //   987	997	3262	finally
    //   81	92	3267	java/lang/Exception
    //   96	107	3267	java/lang/Exception
    //   111	116	3267	java/lang/Exception
    //   125	131	3267	java/lang/Exception
    //   135	143	3267	java/lang/Exception
    //   196	203	3267	java/lang/Exception
    //   207	215	3267	java/lang/Exception
    //   219	229	3267	java/lang/Exception
    //   233	250	3267	java/lang/Exception
    //   254	269	3267	java/lang/Exception
    //   277	284	3267	java/lang/Exception
    //   288	310	3267	java/lang/Exception
    //   314	320	3267	java/lang/Exception
    //   324	332	3267	java/lang/Exception
    //   336	342	3267	java/lang/Exception
    //   346	357	3267	java/lang/Exception
    //   361	367	3267	java/lang/Exception
    //   371	377	3267	java/lang/Exception
    //   381	389	3267	java/lang/Exception
    //   393	398	3267	java/lang/Exception
    //   414	424	3267	java/lang/Exception
    //   428	434	3267	java/lang/Exception
    //   438	447	3267	java/lang/Exception
    //   451	458	3267	java/lang/Exception
    //   462	473	3267	java/lang/Exception
    //   477	518	3267	java/lang/Exception
    //   522	529	3267	java/lang/Exception
    //   533	541	3267	java/lang/Exception
    //   545	555	3267	java/lang/Exception
    //   559	574	3267	java/lang/Exception
    //   578	589	3267	java/lang/Exception
    //   593	617	3267	java/lang/Exception
    //   626	634	3267	java/lang/Exception
    //   638	653	3267	java/lang/Exception
    //   657	666	3267	java/lang/Exception
    //   670	694	3267	java/lang/Exception
    //   698	738	3267	java/lang/Exception
    //   742	748	3267	java/lang/Exception
    //   752	790	3267	java/lang/Exception
    //   794	804	3267	java/lang/Exception
    //   808	813	3267	java/lang/Exception
    //   817	828	3267	java/lang/Exception
    //   836	853	3267	java/lang/Exception
    //   857	863	3267	java/lang/Exception
    //   867	894	3267	java/lang/Exception
    //   905	911	3267	java/lang/Exception
    //   915	924	3267	java/lang/Exception
    //   928	936	3267	java/lang/Exception
    //   1080	1088	3267	java/lang/Exception
    //   1096	1102	3267	java/lang/Exception
    //   1115	1121	3267	java/lang/Exception
    //   1125	1157	3267	java/lang/Exception
    //   1164	1194	3267	java/lang/Exception
    //   1198	1204	3267	java/lang/Exception
    //   1216	1222	3267	java/lang/Exception
    //   1226	1235	3267	java/lang/Exception
    //   1239	1248	3267	java/lang/Exception
    //   1301	1307	3267	java/lang/Exception
    //   1324	1330	3267	java/lang/Exception
    //   1334	1366	3267	java/lang/Exception
    //   1488	1495	3267	java/lang/Exception
    //   1499	1506	3267	java/lang/Exception
    //   1510	1515	3267	java/lang/Exception
    //   1525	1532	3267	java/lang/Exception
    //   1542	1550	3267	java/lang/Exception
    //   1554	1560	3267	java/lang/Exception
    //   1564	1603	3267	java/lang/Exception
    //   1607	1612	3267	java/lang/Exception
    //   1616	1621	3267	java/lang/Exception
    //   1625	1635	3267	java/lang/Exception
    //   1639	1645	3267	java/lang/Exception
    //   1649	1658	3267	java/lang/Exception
    //   1662	1667	3267	java/lang/Exception
    //   1671	1677	3267	java/lang/Exception
    //   1685	1691	3267	java/lang/Exception
    //   1695	1704	3267	java/lang/Exception
    //   1708	1717	3267	java/lang/Exception
    //   1770	1775	3267	java/lang/Exception
    //   1779	1786	3267	java/lang/Exception
    //   1790	1796	3267	java/lang/Exception
    //   1800	1855	3267	java/lang/Exception
    //   1859	1866	3267	java/lang/Exception
    //   1870	1877	3267	java/lang/Exception
    //   1881	1891	3267	java/lang/Exception
    //   1895	1902	3267	java/lang/Exception
    //   1906	1921	3267	java/lang/Exception
    //   1929	1935	3267	java/lang/Exception
    //   1939	1981	3267	java/lang/Exception
    //   1987	1994	3267	java/lang/Exception
    //   1998	2009	3267	java/lang/Exception
    //   2019	2024	3267	java/lang/Exception
    //   2033	2039	3267	java/lang/Exception
    //   2043	2051	3267	java/lang/Exception
    //   2104	2111	3267	java/lang/Exception
    //   2115	2130	3267	java/lang/Exception
    //   2138	2160	3267	java/lang/Exception
    //   2164	2170	3267	java/lang/Exception
    //   2174	2185	3267	java/lang/Exception
    //   2189	2195	3267	java/lang/Exception
    //   2199	2205	3267	java/lang/Exception
    //   2209	2254	3267	java/lang/Exception
    //   2258	2268	3267	java/lang/Exception
    //   2272	2278	3267	java/lang/Exception
    //   2282	2290	3267	java/lang/Exception
    //   2294	2299	3267	java/lang/Exception
    //   2303	2311	3267	java/lang/Exception
    //   2319	2325	3267	java/lang/Exception
    //   2329	2338	3267	java/lang/Exception
    //   2342	2348	3267	java/lang/Exception
    //   2361	2367	3267	java/lang/Exception
    //   2371	2403	3267	java/lang/Exception
    //   2710	2720	3267	java/lang/Exception
    //   2724	2733	3267	java/lang/Exception
    //   2853	2859	3267	java/lang/Exception
    //   2863	2928	3267	java/lang/Exception
    //   2937	2942	3267	java/lang/Exception
    //   2946	2957	3267	java/lang/Exception
    //   2961	2968	3267	java/lang/Exception
    //   2972	2979	3267	java/lang/Exception
    //   64	77	3272	java/lang/IllegalStateException
    //   64	77	3280	java/io/IOException
    //   64	77	3288	java/net/MalformedURLException
    //   64	77	3296	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.DownloadThread
 * JD-Core Version:    0.7.0.1
 */