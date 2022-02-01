package com.tencent.mobileqq.music;

import com.tencent.mobileqq.app.AppConstants;
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
    File localFile = new File(AppConstants.SDCARD_MUSIC);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(AppConstants.SDCARD_MUSIC + paramString);
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
    //   0: invokestatic 104	com/tencent/mobileqq/utils/DeviceInfoUtil:getSDCardMemory	()[J
    //   3: astore 5
    //   5: aload 5
    //   7: ifnull +39 -> 46
    //   10: aload 5
    //   12: iconst_1
    //   13: laload
    //   14: ldc2_w 105
    //   17: lcmp
    //   18: ifgt +28 -> 46
    //   21: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 79
    //   29: iconst_2
    //   30: ldc 108
    //   32: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   39: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   42: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 122	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	(Ljava/lang/String;)Ljava/io/File;
    //   54: astore 10
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   61: aconst_null
    //   62: astore 5
    //   64: new 126	java/io/RandomAccessFile
    //   67: dup
    //   68: aload 10
    //   70: invokevirtual 129	java/io/File:getPath	()Ljava/lang/String;
    //   73: ldc 131
    //   75: invokespecial 134	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore 6
    //   80: aload 6
    //   82: astore 5
    //   84: ldc 136
    //   86: aload_0
    //   87: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokestatic 142	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 9
    //   95: aload 6
    //   97: astore 5
    //   99: new 144	java/net/URL
    //   102: dup
    //   103: aload 9
    //   105: invokespecial 145	java/net/URL:<init>	(Ljava/lang/String;)V
    //   108: astore 8
    //   110: aload 6
    //   112: astore 5
    //   114: invokestatic 148	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   117: astore 7
    //   119: aload 7
    //   121: ifnonnull +74 -> 195
    //   124: aload 6
    //   126: astore 5
    //   128: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +15 -> 146
    //   134: aload 6
    //   136: astore 5
    //   138: ldc 79
    //   140: iconst_2
    //   141: ldc 150
    //   143: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   151: aload 6
    //   153: ifnull +8 -> 161
    //   156: aload 6
    //   158: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   161: aload_0
    //   162: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   165: aload_0
    //   166: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   169: if_icmpge -124 -> 45
    //   172: aload_0
    //   173: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   176: ifle -131 -> 45
    //   179: aload_0
    //   180: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   187: aload_0
    //   188: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   191: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   194: return
    //   195: aload 6
    //   197: astore 5
    //   199: aload 7
    //   201: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   204: astore 11
    //   206: aload 6
    //   208: astore 5
    //   210: aload 11
    //   212: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +3103 -> 3318
    //   218: aload 6
    //   220: astore 5
    //   222: aload 11
    //   224: ldc 172
    //   226: invokevirtual 178	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   229: ifeq +3089 -> 3318
    //   232: aload 6
    //   234: astore 5
    //   236: aload_0
    //   237: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   244: aload 11
    //   246: invokestatic 181	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   249: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: istore_3
    //   253: aload 6
    //   255: astore 5
    //   257: aload 7
    //   259: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   262: aload_0
    //   263: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   266: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: ifne +7 -> 276
    //   272: iload_3
    //   273: ifeq +3050 -> 3323
    //   276: aload 6
    //   278: astore 5
    //   280: aload_0
    //   281: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   284: ifeq +3039 -> 3323
    //   287: aload 6
    //   289: astore 5
    //   291: aload_0
    //   292: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   295: i2f
    //   296: aload_0
    //   297: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   300: i2f
    //   301: aload_0
    //   302: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   305: getfield 188	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   308: fmul
    //   309: fcmpl
    //   310: ifle +594 -> 904
    //   313: aload 6
    //   315: astore 5
    //   317: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +15 -> 335
    //   323: aload 6
    //   325: astore 5
    //   327: ldc 79
    //   329: iconst_2
    //   330: ldc 190
    //   332: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload 6
    //   337: astore 5
    //   339: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   342: invokevirtual 198	android/media/MediaPlayer:reset	()V
    //   345: aload 6
    //   347: astore 5
    //   349: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   352: aload 10
    //   354: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   357: invokevirtual 204	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   360: aload 6
    //   362: astore 5
    //   364: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   367: invokevirtual 207	android/media/MediaPlayer:prepare	()V
    //   370: aload 6
    //   372: astore 5
    //   374: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   377: invokevirtual 210	android/media/MediaPlayer:start	()V
    //   380: aload 6
    //   382: astore 5
    //   384: aload_0
    //   385: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   388: iconst_2
    //   389: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   392: aload 6
    //   394: astore 5
    //   396: aload_0
    //   397: iconst_0
    //   398: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   401: goto +2922 -> 3323
    //   404: iload_2
    //   405: ifgt +2906 -> 3311
    //   408: iload_1
    //   409: iconst_5
    //   410: if_icmpgt +2901 -> 3311
    //   413: aload 6
    //   415: astore 5
    //   417: aload 8
    //   419: invokevirtual 217	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   422: checkcast 219	java/net/HttpURLConnection
    //   425: astore 7
    //   427: aload 6
    //   429: astore 5
    //   431: aload 7
    //   433: iconst_0
    //   434: invokevirtual 223	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   437: aload 6
    //   439: astore 5
    //   441: aload 7
    //   443: ldc 225
    //   445: ldc 227
    //   447: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload 6
    //   452: astore 5
    //   454: aload_0
    //   455: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   458: ifeq +63 -> 521
    //   461: aload 6
    //   463: astore 5
    //   465: aload_0
    //   466: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   469: aload_0
    //   470: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   473: if_icmple +48 -> 521
    //   476: aload 6
    //   478: astore 5
    //   480: aload 7
    //   482: ldc 232
    //   484: new 60	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   491: ldc 234
    //   493: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   500: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc 239
    //   505: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_0
    //   509: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   512: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 6
    //   523: astore 5
    //   525: aload 8
    //   527: invokevirtual 242	java/net/URL:getHost	()Ljava/lang/String;
    //   530: astore 11
    //   532: aload 6
    //   534: astore 5
    //   536: aload 11
    //   538: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   541: ifne +266 -> 807
    //   544: aload 6
    //   546: astore 5
    //   548: aload 11
    //   550: ldc 244
    //   552: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   555: ifeq +252 -> 807
    //   558: aload 6
    //   560: astore 5
    //   562: invokestatic 253	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   565: invokevirtual 257	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   568: iconst_2
    //   569: invokevirtual 263	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   572: checkcast 265	mqq/manager/TicketManager
    //   575: astore 12
    //   577: aload 6
    //   579: astore 5
    //   581: invokestatic 253	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   584: invokevirtual 257	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   587: invokevirtual 268	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   590: astore 11
    //   592: aload 6
    //   594: astore 5
    //   596: aload 12
    //   598: aload 11
    //   600: ldc2_w 269
    //   603: iconst_1
    //   604: anewarray 174	java/lang/String
    //   607: dup
    //   608: iconst_0
    //   609: ldc 244
    //   611: aastore
    //   612: aconst_null
    //   613: invokeinterface 274 6 0
    //   618: astore 12
    //   620: aload 12
    //   622: ifnull +457 -> 1079
    //   625: aload 6
    //   627: astore 5
    //   629: aload 12
    //   631: getfield 280	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   634: ifnull +445 -> 1079
    //   637: aload 6
    //   639: astore 5
    //   641: aload 12
    //   643: getfield 280	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   646: ldc 244
    //   648: invokeinterface 286 2 0
    //   653: ifnull +426 -> 1079
    //   656: aload 6
    //   658: astore 5
    //   660: ldc 79
    //   662: iconst_1
    //   663: ldc_w 288
    //   666: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload 6
    //   671: astore 5
    //   673: new 174	java/lang/String
    //   676: dup
    //   677: aload 12
    //   679: getfield 280	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   682: ldc 244
    //   684: invokeinterface 286 2 0
    //   689: checkcast 290	[B
    //   692: invokespecial 293	java/lang/String:<init>	([B)V
    //   695: astore 12
    //   697: aload 6
    //   699: astore 5
    //   701: new 60	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   708: ldc_w 295
    //   711: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 12
    //   716: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: ldc_w 297
    //   722: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 11
    //   727: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 299
    //   733: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: astore 11
    //   741: aload 6
    //   743: astore 5
    //   745: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +45 -> 793
    //   751: aload 6
    //   753: astore 5
    //   755: ldc 79
    //   757: iconst_1
    //   758: new 60	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 301
    //   768: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload 9
    //   773: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc_w 303
    //   779: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 11
    //   784: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: aload 6
    //   795: astore 5
    //   797: aload 7
    //   799: ldc_w 308
    //   802: aload 11
    //   804: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload 6
    //   809: astore 5
    //   811: aload 7
    //   813: invokevirtual 311	java/net/HttpURLConnection:connect	()V
    //   816: aload 6
    //   818: astore 5
    //   820: aload 7
    //   822: invokevirtual 315	java/net/HttpURLConnection:getResponseCode	()I
    //   825: sipush 302
    //   828: if_icmpne +335 -> 1163
    //   831: iload_1
    //   832: iconst_1
    //   833: iadd
    //   834: istore_1
    //   835: aload 6
    //   837: astore 5
    //   839: new 144	java/net/URL
    //   842: dup
    //   843: aload 7
    //   845: ldc_w 317
    //   848: invokevirtual 321	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   851: invokespecial 145	java/net/URL:<init>	(Ljava/lang/String;)V
    //   854: astore 8
    //   856: aload 6
    //   858: astore 5
    //   860: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq +2441 -> 3304
    //   866: aload 6
    //   868: astore 5
    //   870: ldc 79
    //   872: iconst_1
    //   873: new 60	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   880: ldc_w 323
    //   883: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload 8
    //   888: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload 7
    //   899: astore 5
    //   901: goto -497 -> 404
    //   904: aload 6
    //   906: astore 5
    //   908: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   911: ifeq +16 -> 927
    //   914: aload 6
    //   916: astore 5
    //   918: ldc 79
    //   920: iconst_2
    //   921: ldc_w 328
    //   924: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload 6
    //   929: astore 5
    //   931: aload_0
    //   932: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   935: iconst_1
    //   936: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   939: goto +2384 -> 3323
    //   942: astore 7
    //   944: aload 6
    //   946: astore 5
    //   948: aload 7
    //   950: astore 6
    //   952: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   955: ifeq +35 -> 990
    //   958: ldc 79
    //   960: iconst_2
    //   961: new 60	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   968: ldc_w 330
    //   971: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 6
    //   976: invokevirtual 331	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   979: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: aload 6
    //   987: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   990: aload_0
    //   991: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   994: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   997: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1000: aload_0
    //   1001: iconst_0
    //   1002: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1005: aload 5
    //   1007: ifnull +8 -> 1015
    //   1010: aload 5
    //   1012: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   1015: aload_0
    //   1016: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1019: aload_0
    //   1020: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1023: if_icmpge +25 -> 1048
    //   1026: aload_0
    //   1027: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1030: ifle +18 -> 1048
    //   1033: aload_0
    //   1034: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1037: aload_0
    //   1038: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1041: aload_0
    //   1042: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1045: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   1048: aload_0
    //   1049: getfield 333	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   1052: ifeq +6 -> 1058
    //   1055: invokestatic 335	bhfk:a	()V
    //   1058: aload_0
    //   1059: iconst_0
    //   1060: putfield 333	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   1063: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1066: ifeq -1021 -> 45
    //   1069: ldc 79
    //   1071: iconst_2
    //   1072: ldc_w 337
    //   1075: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1078: return
    //   1079: aload 6
    //   1081: astore 5
    //   1083: ldc 79
    //   1085: ldc_w 339
    //   1088: invokestatic 344	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1091: iload_1
    //   1092: iconst_1
    //   1093: iadd
    //   1094: istore_1
    //   1095: aload 6
    //   1097: astore 5
    //   1099: ldc2_w 345
    //   1102: invokestatic 350	java/lang/Thread:sleep	(J)V
    //   1105: aload 7
    //   1107: astore 5
    //   1109: goto -705 -> 404
    //   1112: astore 11
    //   1114: aload 6
    //   1116: astore 5
    //   1118: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1121: ifeq +2212 -> 3333
    //   1124: aload 6
    //   1126: astore 5
    //   1128: ldc 79
    //   1130: iconst_2
    //   1131: new 60	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 352
    //   1141: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload 11
    //   1146: invokevirtual 353	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1149: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: aload 11
    //   1157: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1160: goto +2173 -> 3333
    //   1163: aload 6
    //   1165: astore 5
    //   1167: ldc 79
    //   1169: iconst_1
    //   1170: new 60	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1177: ldc_w 355
    //   1180: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload 7
    //   1185: invokevirtual 315	java/net/HttpURLConnection:getResponseCode	()I
    //   1188: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1197: aload 6
    //   1199: astore 5
    //   1201: aload 7
    //   1203: invokevirtual 358	java/net/HttpURLConnection:getContentLength	()I
    //   1206: istore_2
    //   1207: iload_2
    //   1208: ifle +92 -> 1300
    //   1211: iload_2
    //   1212: ifgt +273 -> 1485
    //   1215: aload 6
    //   1217: astore 5
    //   1219: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1222: ifeq +16 -> 1238
    //   1225: aload 6
    //   1227: astore 5
    //   1229: ldc 79
    //   1231: iconst_2
    //   1232: ldc_w 360
    //   1235: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1238: aload 6
    //   1240: astore 5
    //   1242: aload_0
    //   1243: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1246: bipush 7
    //   1248: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1251: aload_0
    //   1252: iconst_0
    //   1253: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1256: aload 6
    //   1258: ifnull +8 -> 1266
    //   1261: aload 6
    //   1263: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   1266: aload_0
    //   1267: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1270: aload_0
    //   1271: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1274: if_icmpge -1229 -> 45
    //   1277: aload_0
    //   1278: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1281: ifle -1236 -> 45
    //   1284: aload_0
    //   1285: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1288: aload_0
    //   1289: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1292: aload_0
    //   1293: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1296: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   1299: return
    //   1300: aload 6
    //   1302: astore 5
    //   1304: ldc2_w 345
    //   1307: invokestatic 350	java/lang/Thread:sleep	(J)V
    //   1310: iload_1
    //   1311: iconst_1
    //   1312: iadd
    //   1313: istore_1
    //   1314: aload 7
    //   1316: astore 5
    //   1318: goto -914 -> 404
    //   1321: astore 11
    //   1323: aload 6
    //   1325: astore 5
    //   1327: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq -20 -> 1310
    //   1333: aload 6
    //   1335: astore 5
    //   1337: ldc 79
    //   1339: iconst_2
    //   1340: new 60	java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1347: ldc_w 352
    //   1350: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload 11
    //   1355: invokevirtual 353	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1358: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: aload 11
    //   1366: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1369: goto -59 -> 1310
    //   1372: astore 7
    //   1374: aload 6
    //   1376: astore 5
    //   1378: aload_0
    //   1379: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1382: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1385: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1388: aload 6
    //   1390: astore 5
    //   1392: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1395: ifeq +39 -> 1434
    //   1398: aload 6
    //   1400: astore 5
    //   1402: ldc 79
    //   1404: iconst_2
    //   1405: new 60	java/lang/StringBuilder
    //   1408: dup
    //   1409: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1412: ldc_w 362
    //   1415: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: aload 7
    //   1420: invokevirtual 363	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1423: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: aload 7
    //   1431: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1434: aload_0
    //   1435: iconst_0
    //   1436: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1439: aload 6
    //   1441: ifnull +8 -> 1449
    //   1444: aload 6
    //   1446: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   1449: aload_0
    //   1450: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1453: aload_0
    //   1454: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1457: if_icmpge -409 -> 1048
    //   1460: aload_0
    //   1461: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1464: ifle -416 -> 1048
    //   1467: aload_0
    //   1468: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1471: aload_0
    //   1472: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1475: aload_0
    //   1476: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1479: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   1482: goto -434 -> 1048
    //   1485: iload_2
    //   1486: istore_1
    //   1487: aload 6
    //   1489: astore 5
    //   1491: aload_0
    //   1492: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1495: ifle +14 -> 1509
    //   1498: aload 6
    //   1500: astore 5
    //   1502: iload_2
    //   1503: aload_0
    //   1504: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1507: iadd
    //   1508: istore_1
    //   1509: aload 6
    //   1511: astore 5
    //   1513: aload_0
    //   1514: iload_1
    //   1515: putfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1518: iload_1
    //   1519: istore_2
    //   1520: aload 7
    //   1522: astore 9
    //   1524: aload 6
    //   1526: astore 5
    //   1528: aload_0
    //   1529: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1532: ifeq +246 -> 1778
    //   1535: iload_1
    //   1536: istore_2
    //   1537: aload 7
    //   1539: astore 9
    //   1541: aload 6
    //   1543: astore 5
    //   1545: aload_0
    //   1546: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1549: iload_1
    //   1550: if_icmpeq +228 -> 1778
    //   1553: aload 6
    //   1555: astore 5
    //   1557: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1560: ifeq +46 -> 1606
    //   1563: aload 6
    //   1565: astore 5
    //   1567: ldc 79
    //   1569: iconst_2
    //   1570: new 60	java/lang/StringBuilder
    //   1573: dup
    //   1574: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1577: ldc_w 365
    //   1580: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: aload_0
    //   1584: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1587: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1590: ldc_w 367
    //   1593: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: iload_1
    //   1597: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1600: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1603: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1606: aload 6
    //   1608: astore 5
    //   1610: aload_0
    //   1611: iconst_0
    //   1612: putfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1615: aload 6
    //   1617: astore 5
    //   1619: aload_0
    //   1620: iconst_1
    //   1621: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   1624: aload 6
    //   1626: astore 5
    //   1628: aload 8
    //   1630: invokevirtual 217	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1633: checkcast 219	java/net/HttpURLConnection
    //   1636: astore 9
    //   1638: aload 6
    //   1640: astore 5
    //   1642: aload 9
    //   1644: iconst_1
    //   1645: invokevirtual 223	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1648: aload 6
    //   1650: astore 5
    //   1652: aload 9
    //   1654: ldc 225
    //   1656: ldc 227
    //   1658: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1661: aload 6
    //   1663: astore 5
    //   1665: aload 9
    //   1667: invokevirtual 311	java/net/HttpURLConnection:connect	()V
    //   1670: aload 6
    //   1672: astore 5
    //   1674: aload 9
    //   1676: invokevirtual 358	java/net/HttpURLConnection:getContentLength	()I
    //   1679: istore_2
    //   1680: iload_2
    //   1681: ifge +88 -> 1769
    //   1684: aload 6
    //   1686: astore 5
    //   1688: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1691: ifeq +16 -> 1707
    //   1694: aload 6
    //   1696: astore 5
    //   1698: ldc 79
    //   1700: iconst_2
    //   1701: ldc_w 369
    //   1704: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1707: aload 6
    //   1709: astore 5
    //   1711: aload_0
    //   1712: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1715: bipush 7
    //   1717: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1720: aload_0
    //   1721: iconst_0
    //   1722: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1725: aload 6
    //   1727: ifnull +8 -> 1735
    //   1730: aload 6
    //   1732: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   1735: aload_0
    //   1736: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1739: aload_0
    //   1740: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1743: if_icmpge -1698 -> 45
    //   1746: aload_0
    //   1747: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1750: ifle -1705 -> 45
    //   1753: aload_0
    //   1754: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1757: aload_0
    //   1758: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1761: aload_0
    //   1762: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1765: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   1768: return
    //   1769: aload 6
    //   1771: astore 5
    //   1773: aload_0
    //   1774: iload_2
    //   1775: putfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1778: aload 6
    //   1780: astore 5
    //   1782: aload 6
    //   1784: iload_2
    //   1785: i2l
    //   1786: invokevirtual 372	java/io/RandomAccessFile:setLength	(J)V
    //   1789: aload 6
    //   1791: astore 5
    //   1793: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1796: ifeq +62 -> 1858
    //   1799: aload 6
    //   1801: astore 5
    //   1803: ldc 79
    //   1805: iconst_2
    //   1806: new 60	java/lang/StringBuilder
    //   1809: dup
    //   1810: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1813: ldc_w 374
    //   1816: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: aload_0
    //   1820: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1823: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1826: ldc_w 376
    //   1829: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: aload_0
    //   1833: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1836: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1839: ldc_w 378
    //   1842: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: aload_0
    //   1846: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1849: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1852: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1855: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1858: aload 6
    //   1860: astore 5
    //   1862: aload 9
    //   1864: invokevirtual 382	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1867: astore 7
    //   1869: aload 6
    //   1871: astore 5
    //   1873: sipush 8192
    //   1876: newarray byte
    //   1878: astore 8
    //   1880: aload 6
    //   1882: astore 5
    //   1884: aload 6
    //   1886: aload_0
    //   1887: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1890: i2l
    //   1891: invokevirtual 385	java/io/RandomAccessFile:seek	(J)V
    //   1894: aload 6
    //   1896: astore 5
    //   1898: aload_0
    //   1899: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1902: ifne +22 -> 1924
    //   1905: aload 6
    //   1907: astore 5
    //   1909: aload_0
    //   1910: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1913: aload_0
    //   1914: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1917: aload_0
    //   1918: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1921: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   1924: iconst_0
    //   1925: istore_2
    //   1926: iload_2
    //   1927: istore_1
    //   1928: aload 6
    //   1930: astore 5
    //   1932: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1935: ifeq +51 -> 1986
    //   1938: aload 6
    //   1940: astore 5
    //   1942: ldc 79
    //   1944: iconst_2
    //   1945: new 60	java/lang/StringBuilder
    //   1948: dup
    //   1949: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1952: ldc_w 387
    //   1955: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload_0
    //   1959: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1962: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1965: ldc_w 378
    //   1968: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: aload_0
    //   1972: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1975: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1978: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1981: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1984: iload_2
    //   1985: istore_1
    //   1986: aload 6
    //   1988: astore 5
    //   1990: aload_0
    //   1991: getfield 389	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Boolean	Z
    //   1994: ifne +858 -> 2852
    //   1997: aload 6
    //   1999: astore 5
    //   2001: aload_0
    //   2002: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2005: aload_0
    //   2006: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2009: if_icmpge +843 -> 2852
    //   2012: iload_1
    //   2013: bipush 10
    //   2015: if_icmpge +837 -> 2852
    //   2018: aload 6
    //   2020: astore 5
    //   2022: invokestatic 148	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2025: astore 9
    //   2027: aload 9
    //   2029: ifnonnull +74 -> 2103
    //   2032: aload 6
    //   2034: astore 5
    //   2036: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2039: ifeq +15 -> 2054
    //   2042: aload 6
    //   2044: astore 5
    //   2046: ldc 79
    //   2048: iconst_2
    //   2049: ldc 150
    //   2051: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2054: aload_0
    //   2055: iconst_0
    //   2056: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2059: aload 6
    //   2061: ifnull +8 -> 2069
    //   2064: aload 6
    //   2066: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   2069: aload_0
    //   2070: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2073: aload_0
    //   2074: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2077: if_icmpge -2032 -> 45
    //   2080: aload_0
    //   2081: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2084: ifle -2039 -> 45
    //   2087: aload_0
    //   2088: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2091: aload_0
    //   2092: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2095: aload_0
    //   2096: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2099: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   2102: return
    //   2103: aload 6
    //   2105: astore 5
    //   2107: aload_0
    //   2108: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   2111: ifeq +191 -> 2302
    //   2114: aload 6
    //   2116: astore 5
    //   2118: aload 9
    //   2120: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2123: aload_0
    //   2124: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2127: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2130: ifne +7 -> 2137
    //   2133: iload_3
    //   2134: ifeq +168 -> 2302
    //   2137: aload 6
    //   2139: astore 5
    //   2141: aload_0
    //   2142: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2145: i2f
    //   2146: aload_0
    //   2147: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2150: i2f
    //   2151: aload_0
    //   2152: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2155: getfield 188	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   2158: fmul
    //   2159: fcmpl
    //   2160: ifle +142 -> 2302
    //   2163: aload 6
    //   2165: astore 5
    //   2167: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2170: invokevirtual 198	android/media/MediaPlayer:reset	()V
    //   2173: aload 6
    //   2175: astore 5
    //   2177: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2180: aload 10
    //   2182: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2185: invokevirtual 204	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   2188: aload 6
    //   2190: astore 5
    //   2192: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2195: invokevirtual 207	android/media/MediaPlayer:prepare	()V
    //   2198: aload 6
    //   2200: astore 5
    //   2202: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2205: ifeq +52 -> 2257
    //   2208: aload 6
    //   2210: astore 5
    //   2212: ldc 79
    //   2214: iconst_2
    //   2215: new 60	java/lang/StringBuilder
    //   2218: dup
    //   2219: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2222: ldc_w 391
    //   2225: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: aload_0
    //   2229: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2232: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2235: ldc_w 393
    //   2238: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: aload_0
    //   2242: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2245: invokestatic 396	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   2248: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2251: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2254: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2257: aload 6
    //   2259: astore 5
    //   2261: aload_0
    //   2262: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2265: invokestatic 396	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   2268: ifne +25 -> 2293
    //   2271: aload 6
    //   2273: astore 5
    //   2275: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2278: invokevirtual 210	android/media/MediaPlayer:start	()V
    //   2281: aload 6
    //   2283: astore 5
    //   2285: aload_0
    //   2286: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2289: iconst_2
    //   2290: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2293: aload 6
    //   2295: astore 5
    //   2297: aload_0
    //   2298: iconst_0
    //   2299: putfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   2302: aload 6
    //   2304: astore 5
    //   2306: aload 7
    //   2308: aload 8
    //   2310: invokevirtual 405	java/io/InputStream:read	([B)I
    //   2313: istore_2
    //   2314: iload_2
    //   2315: ifgt +392 -> 2707
    //   2318: aload 6
    //   2320: astore 5
    //   2322: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2325: ifeq +16 -> 2341
    //   2328: aload 6
    //   2330: astore 5
    //   2332: ldc 79
    //   2334: iconst_2
    //   2335: ldc_w 407
    //   2338: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2341: aload 6
    //   2343: astore 5
    //   2345: ldc2_w 345
    //   2348: invokestatic 350	java/lang/Thread:sleep	(J)V
    //   2351: iload_1
    //   2352: iconst_1
    //   2353: iadd
    //   2354: istore_1
    //   2355: goto -369 -> 1986
    //   2358: astore 9
    //   2360: aload 6
    //   2362: astore 5
    //   2364: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2367: ifeq -16 -> 2351
    //   2370: aload 6
    //   2372: astore 5
    //   2374: ldc 79
    //   2376: iconst_2
    //   2377: new 60	java/lang/StringBuilder
    //   2380: dup
    //   2381: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2384: ldc_w 409
    //   2387: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2390: aload 9
    //   2392: invokevirtual 353	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   2395: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2401: aload 9
    //   2403: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2406: goto -55 -> 2351
    //   2409: astore 7
    //   2411: aload 6
    //   2413: astore 5
    //   2415: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2418: ifeq +39 -> 2457
    //   2421: aload 6
    //   2423: astore 5
    //   2425: ldc 79
    //   2427: iconst_2
    //   2428: new 60	java/lang/StringBuilder
    //   2431: dup
    //   2432: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2435: ldc_w 411
    //   2438: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2441: aload 7
    //   2443: invokevirtual 84	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2446: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2452: aload 7
    //   2454: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2457: aload 6
    //   2459: astore 5
    //   2461: invokestatic 148	com/tencent/mobileqq/music/QQPlayerService:d	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2464: astore 7
    //   2466: iconst_0
    //   2467: istore 4
    //   2469: aload 7
    //   2471: ifnull +126 -> 2597
    //   2474: aload 6
    //   2476: astore 5
    //   2478: aload 7
    //   2480: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2483: astore 8
    //   2485: iload 4
    //   2487: istore_3
    //   2488: aload 6
    //   2490: astore 5
    //   2492: aload 8
    //   2494: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2497: ifne +44 -> 2541
    //   2500: iload 4
    //   2502: istore_3
    //   2503: aload 6
    //   2505: astore 5
    //   2507: aload 8
    //   2509: ldc 172
    //   2511: invokevirtual 178	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2514: ifeq +27 -> 2541
    //   2517: aload 6
    //   2519: astore 5
    //   2521: aload_0
    //   2522: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2525: aload_0
    //   2526: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2529: aload 7
    //   2531: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2534: invokestatic 181	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   2537: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2540: istore_3
    //   2541: aload 6
    //   2543: astore 5
    //   2545: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2548: ifnull +49 -> 2597
    //   2551: aload 6
    //   2553: astore 5
    //   2555: aload_0
    //   2556: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2559: aload 7
    //   2561: getfield 164	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2564: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2567: ifne +7 -> 2574
    //   2570: iload_3
    //   2571: ifeq +26 -> 2597
    //   2574: aload 6
    //   2576: astore 5
    //   2578: invokestatic 193	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2581: invokevirtual 198	android/media/MediaPlayer:reset	()V
    //   2584: aload 6
    //   2586: astore 5
    //   2588: aload_0
    //   2589: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2592: bipush 6
    //   2594: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2597: aload 6
    //   2599: astore 5
    //   2601: invokestatic 414	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2604: ifnull +52 -> 2656
    //   2607: aload 6
    //   2609: astore 5
    //   2611: invokestatic 414	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2614: arraylength
    //   2615: iconst_1
    //   2616: if_icmpne +40 -> 2656
    //   2619: aload 6
    //   2621: astore 5
    //   2623: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2626: ifeq +16 -> 2642
    //   2629: aload 6
    //   2631: astore 5
    //   2633: ldc 79
    //   2635: iconst_2
    //   2636: ldc_w 416
    //   2639: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2642: aload 6
    //   2644: astore 5
    //   2646: aload_0
    //   2647: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2650: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2653: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2656: aload_0
    //   2657: iconst_0
    //   2658: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2661: aload 6
    //   2663: ifnull +8 -> 2671
    //   2666: aload 6
    //   2668: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   2671: aload_0
    //   2672: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2675: aload_0
    //   2676: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2679: if_icmpge -1631 -> 1048
    //   2682: aload_0
    //   2683: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2686: ifle -1638 -> 1048
    //   2689: aload_0
    //   2690: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2693: aload_0
    //   2694: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2697: aload_0
    //   2698: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2701: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   2704: goto -1656 -> 1048
    //   2707: iconst_0
    //   2708: istore_1
    //   2709: aload 6
    //   2711: astore 5
    //   2713: aload_0
    //   2714: aload_0
    //   2715: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2718: iload_2
    //   2719: iadd
    //   2720: putfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2723: aload 6
    //   2725: astore 5
    //   2727: aload 6
    //   2729: aload 8
    //   2731: iconst_0
    //   2732: iload_2
    //   2733: invokevirtual 420	java/io/RandomAccessFile:write	([BII)V
    //   2736: goto -750 -> 1986
    //   2739: astore 7
    //   2741: aload 6
    //   2743: astore 5
    //   2745: aload_0
    //   2746: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2749: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2752: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2755: aload 6
    //   2757: astore 5
    //   2759: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2762: ifeq +39 -> 2801
    //   2765: aload 6
    //   2767: astore 5
    //   2769: ldc 79
    //   2771: iconst_2
    //   2772: new 60	java/lang/StringBuilder
    //   2775: dup
    //   2776: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2779: ldc_w 422
    //   2782: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2785: aload 7
    //   2787: invokevirtual 423	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2790: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2793: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2796: aload 7
    //   2798: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2801: aload_0
    //   2802: iconst_0
    //   2803: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2806: aload 6
    //   2808: ifnull +8 -> 2816
    //   2811: aload 6
    //   2813: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   2816: aload_0
    //   2817: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2820: aload_0
    //   2821: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2824: if_icmpge -1776 -> 1048
    //   2827: aload_0
    //   2828: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2831: ifle -1783 -> 1048
    //   2834: aload_0
    //   2835: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2838: aload_0
    //   2839: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2842: aload_0
    //   2843: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2846: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   2849: goto -1801 -> 1048
    //   2852: aload 6
    //   2854: astore 5
    //   2856: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2859: ifeq +72 -> 2931
    //   2862: aload 6
    //   2864: astore 5
    //   2866: ldc 79
    //   2868: iconst_2
    //   2869: new 60	java/lang/StringBuilder
    //   2872: dup
    //   2873: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2876: ldc_w 425
    //   2879: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2882: aload_0
    //   2883: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2886: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2889: ldc_w 427
    //   2892: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: iload_1
    //   2896: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2899: ldc_w 378
    //   2902: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2905: aload_0
    //   2906: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2909: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2912: ldc_w 376
    //   2915: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2918: aload_0
    //   2919: getfield 34	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   2922: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2925: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2928: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2931: aload 7
    //   2933: ifnull +12 -> 2945
    //   2936: aload 6
    //   2938: astore 5
    //   2940: aload 7
    //   2942: invokevirtual 428	java/io/InputStream:close	()V
    //   2945: aload 6
    //   2947: astore 5
    //   2949: aload_0
    //   2950: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2953: aload_0
    //   2954: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2957: if_icmpne +25 -> 2982
    //   2960: aload 6
    //   2962: astore 5
    //   2964: aload_0
    //   2965: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2968: ifle +14 -> 2982
    //   2971: aload 6
    //   2973: astore 5
    //   2975: aload_0
    //   2976: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2979: invokestatic 430	bhfk:a	(Ljava/lang/String;)V
    //   2982: aload_0
    //   2983: iconst_0
    //   2984: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2987: aload 6
    //   2989: ifnull +8 -> 2997
    //   2992: aload 6
    //   2994: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   2997: aload_0
    //   2998: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3001: aload_0
    //   3002: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3005: if_icmpge -1957 -> 1048
    //   3008: aload_0
    //   3009: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3012: ifle -1964 -> 1048
    //   3015: aload_0
    //   3016: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3019: aload_0
    //   3020: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3023: aload_0
    //   3024: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3027: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   3030: goto -1982 -> 1048
    //   3033: astore 7
    //   3035: aconst_null
    //   3036: astore 6
    //   3038: aload 6
    //   3040: astore 5
    //   3042: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3045: ifeq +39 -> 3084
    //   3048: aload 6
    //   3050: astore 5
    //   3052: ldc 79
    //   3054: iconst_2
    //   3055: new 60	java/lang/StringBuilder
    //   3058: dup
    //   3059: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   3062: ldc_w 432
    //   3065: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3068: aload 7
    //   3070: invokevirtual 433	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3073: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3079: aload 7
    //   3081: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3084: aload 6
    //   3086: astore 5
    //   3088: aload_0
    //   3089: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   3092: invokevirtual 117	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   3095: invokestatic 120	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   3098: aload_0
    //   3099: iconst_0
    //   3100: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3103: aload 6
    //   3105: ifnull +8 -> 3113
    //   3108: aload 6
    //   3110: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   3113: aload_0
    //   3114: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3117: aload_0
    //   3118: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3121: if_icmpge -2073 -> 1048
    //   3124: aload_0
    //   3125: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3128: ifle -2080 -> 1048
    //   3131: aload_0
    //   3132: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3135: aload_0
    //   3136: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3139: aload_0
    //   3140: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3143: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   3146: goto -2098 -> 1048
    //   3149: astore 6
    //   3151: aconst_null
    //   3152: astore 5
    //   3154: aload_0
    //   3155: iconst_0
    //   3156: putfield 124	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3159: aload 5
    //   3161: ifnull +8 -> 3169
    //   3164: aload 5
    //   3166: invokevirtual 156	java/io/RandomAccessFile:close	()V
    //   3169: aload_0
    //   3170: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3173: aload_0
    //   3174: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3177: if_icmpge +25 -> 3202
    //   3180: aload_0
    //   3181: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3184: ifle +18 -> 3202
    //   3187: aload_0
    //   3188: getfield 32	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3191: aload_0
    //   3192: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3195: aload_0
    //   3196: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3199: invokestatic 161	bhfk:a	(Ljava/lang/String;II)V
    //   3202: aload 6
    //   3204: athrow
    //   3205: astore 5
    //   3207: goto -3046 -> 161
    //   3210: astore 5
    //   3212: goto -1946 -> 1266
    //   3215: astore 5
    //   3217: goto -1482 -> 1735
    //   3220: astore 5
    //   3222: goto -1153 -> 2069
    //   3225: astore 5
    //   3227: goto -230 -> 2997
    //   3230: astore 5
    //   3232: goto -2217 -> 1015
    //   3235: astore 5
    //   3237: goto -1788 -> 1449
    //   3240: astore 5
    //   3242: goto -571 -> 2671
    //   3245: astore 5
    //   3247: goto -431 -> 2816
    //   3250: astore 5
    //   3252: goto -139 -> 3113
    //   3255: astore 5
    //   3257: goto -88 -> 3169
    //   3260: astore 6
    //   3262: goto -108 -> 3154
    //   3265: astore 6
    //   3267: goto -113 -> 3154
    //   3270: astore 7
    //   3272: goto -234 -> 3038
    //   3275: astore 7
    //   3277: aconst_null
    //   3278: astore 6
    //   3280: goto -539 -> 2741
    //   3283: astore 7
    //   3285: aconst_null
    //   3286: astore 6
    //   3288: goto -877 -> 2411
    //   3291: astore 7
    //   3293: aconst_null
    //   3294: astore 6
    //   3296: goto -1922 -> 1374
    //   3299: astore 6
    //   3301: goto -2349 -> 952
    //   3304: aload 7
    //   3306: astore 5
    //   3308: goto -2904 -> 404
    //   3311: aload 5
    //   3313: astore 7
    //   3315: goto -2104 -> 1211
    //   3318: iconst_0
    //   3319: istore_3
    //   3320: goto -3067 -> 253
    //   3323: iconst_0
    //   3324: istore_2
    //   3325: iconst_0
    //   3326: istore_1
    //   3327: aconst_null
    //   3328: astore 5
    //   3330: goto -2926 -> 404
    //   3333: aload 7
    //   3335: astore 5
    //   3337: goto -2933 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3340	0	this	DownloadThread
    //   408	2919	1	i	int
    //   404	2921	2	j	int
    //   252	3068	3	bool1	boolean
    //   2467	34	4	bool2	boolean
    //   3	3162	5	localObject1	java.lang.Object
    //   3205	1	5	localIOException1	IOException
    //   3210	1	5	localIOException2	IOException
    //   3215	1	5	localIOException3	IOException
    //   3220	1	5	localIOException4	IOException
    //   3225	1	5	localIOException5	IOException
    //   3230	1	5	localIOException6	IOException
    //   3235	1	5	localIOException7	IOException
    //   3240	1	5	localIOException8	IOException
    //   3245	1	5	localIOException9	IOException
    //   3250	1	5	localIOException10	IOException
    //   3255	1	5	localIOException11	IOException
    //   3306	30	5	localObject2	java.lang.Object
    //   78	3031	6	localObject3	java.lang.Object
    //   3149	54	6	localObject4	java.lang.Object
    //   3260	1	6	localObject5	java.lang.Object
    //   3265	1	6	localObject6	java.lang.Object
    //   3278	17	6	localObject7	java.lang.Object
    //   3299	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   117	781	7	localObject8	java.lang.Object
    //   942	373	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   1372	166	7	localMalformedURLException1	java.net.MalformedURLException
    //   1867	440	7	localInputStream	java.io.InputStream
    //   2409	44	7	localIOException12	IOException
    //   2464	96	7	localSongInfo	SongInfo
    //   2739	202	7	localIllegalStateException1	java.lang.IllegalStateException
    //   3033	47	7	localException1	java.lang.Exception
    //   3270	1	7	localException2	java.lang.Exception
    //   3275	1	7	localIllegalStateException2	java.lang.IllegalStateException
    //   3283	1	7	localIOException13	IOException
    //   3291	14	7	localMalformedURLException2	java.net.MalformedURLException
    //   3313	21	7	localObject9	java.lang.Object
    //   108	2622	8	localObject10	java.lang.Object
    //   93	2026	9	localObject11	java.lang.Object
    //   2358	44	9	localInterruptedException1	java.lang.InterruptedException
    //   54	2127	10	localFile	File
    //   204	599	11	str	String
    //   1112	44	11	localInterruptedException2	java.lang.InterruptedException
    //   1321	44	11	localInterruptedException3	java.lang.InterruptedException
    //   575	140	12	localObject12	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   84	95	942	java/io/FileNotFoundException
    //   99	110	942	java/io/FileNotFoundException
    //   114	119	942	java/io/FileNotFoundException
    //   128	134	942	java/io/FileNotFoundException
    //   138	146	942	java/io/FileNotFoundException
    //   199	206	942	java/io/FileNotFoundException
    //   210	218	942	java/io/FileNotFoundException
    //   222	232	942	java/io/FileNotFoundException
    //   236	253	942	java/io/FileNotFoundException
    //   257	272	942	java/io/FileNotFoundException
    //   280	287	942	java/io/FileNotFoundException
    //   291	313	942	java/io/FileNotFoundException
    //   317	323	942	java/io/FileNotFoundException
    //   327	335	942	java/io/FileNotFoundException
    //   339	345	942	java/io/FileNotFoundException
    //   349	360	942	java/io/FileNotFoundException
    //   364	370	942	java/io/FileNotFoundException
    //   374	380	942	java/io/FileNotFoundException
    //   384	392	942	java/io/FileNotFoundException
    //   396	401	942	java/io/FileNotFoundException
    //   417	427	942	java/io/FileNotFoundException
    //   431	437	942	java/io/FileNotFoundException
    //   441	450	942	java/io/FileNotFoundException
    //   454	461	942	java/io/FileNotFoundException
    //   465	476	942	java/io/FileNotFoundException
    //   480	521	942	java/io/FileNotFoundException
    //   525	532	942	java/io/FileNotFoundException
    //   536	544	942	java/io/FileNotFoundException
    //   548	558	942	java/io/FileNotFoundException
    //   562	577	942	java/io/FileNotFoundException
    //   581	592	942	java/io/FileNotFoundException
    //   596	620	942	java/io/FileNotFoundException
    //   629	637	942	java/io/FileNotFoundException
    //   641	656	942	java/io/FileNotFoundException
    //   660	669	942	java/io/FileNotFoundException
    //   673	697	942	java/io/FileNotFoundException
    //   701	741	942	java/io/FileNotFoundException
    //   745	751	942	java/io/FileNotFoundException
    //   755	793	942	java/io/FileNotFoundException
    //   797	807	942	java/io/FileNotFoundException
    //   811	816	942	java/io/FileNotFoundException
    //   820	831	942	java/io/FileNotFoundException
    //   839	856	942	java/io/FileNotFoundException
    //   860	866	942	java/io/FileNotFoundException
    //   870	897	942	java/io/FileNotFoundException
    //   908	914	942	java/io/FileNotFoundException
    //   918	927	942	java/io/FileNotFoundException
    //   931	939	942	java/io/FileNotFoundException
    //   1083	1091	942	java/io/FileNotFoundException
    //   1099	1105	942	java/io/FileNotFoundException
    //   1118	1124	942	java/io/FileNotFoundException
    //   1128	1160	942	java/io/FileNotFoundException
    //   1167	1197	942	java/io/FileNotFoundException
    //   1201	1207	942	java/io/FileNotFoundException
    //   1219	1225	942	java/io/FileNotFoundException
    //   1229	1238	942	java/io/FileNotFoundException
    //   1242	1251	942	java/io/FileNotFoundException
    //   1304	1310	942	java/io/FileNotFoundException
    //   1327	1333	942	java/io/FileNotFoundException
    //   1337	1369	942	java/io/FileNotFoundException
    //   1491	1498	942	java/io/FileNotFoundException
    //   1502	1509	942	java/io/FileNotFoundException
    //   1513	1518	942	java/io/FileNotFoundException
    //   1528	1535	942	java/io/FileNotFoundException
    //   1545	1553	942	java/io/FileNotFoundException
    //   1557	1563	942	java/io/FileNotFoundException
    //   1567	1606	942	java/io/FileNotFoundException
    //   1610	1615	942	java/io/FileNotFoundException
    //   1619	1624	942	java/io/FileNotFoundException
    //   1628	1638	942	java/io/FileNotFoundException
    //   1642	1648	942	java/io/FileNotFoundException
    //   1652	1661	942	java/io/FileNotFoundException
    //   1665	1670	942	java/io/FileNotFoundException
    //   1674	1680	942	java/io/FileNotFoundException
    //   1688	1694	942	java/io/FileNotFoundException
    //   1698	1707	942	java/io/FileNotFoundException
    //   1711	1720	942	java/io/FileNotFoundException
    //   1773	1778	942	java/io/FileNotFoundException
    //   1782	1789	942	java/io/FileNotFoundException
    //   1793	1799	942	java/io/FileNotFoundException
    //   1803	1858	942	java/io/FileNotFoundException
    //   1862	1869	942	java/io/FileNotFoundException
    //   1873	1880	942	java/io/FileNotFoundException
    //   1884	1894	942	java/io/FileNotFoundException
    //   1898	1905	942	java/io/FileNotFoundException
    //   1909	1924	942	java/io/FileNotFoundException
    //   1932	1938	942	java/io/FileNotFoundException
    //   1942	1984	942	java/io/FileNotFoundException
    //   1990	1997	942	java/io/FileNotFoundException
    //   2001	2012	942	java/io/FileNotFoundException
    //   2022	2027	942	java/io/FileNotFoundException
    //   2036	2042	942	java/io/FileNotFoundException
    //   2046	2054	942	java/io/FileNotFoundException
    //   2107	2114	942	java/io/FileNotFoundException
    //   2118	2133	942	java/io/FileNotFoundException
    //   2141	2163	942	java/io/FileNotFoundException
    //   2167	2173	942	java/io/FileNotFoundException
    //   2177	2188	942	java/io/FileNotFoundException
    //   2192	2198	942	java/io/FileNotFoundException
    //   2202	2208	942	java/io/FileNotFoundException
    //   2212	2257	942	java/io/FileNotFoundException
    //   2261	2271	942	java/io/FileNotFoundException
    //   2275	2281	942	java/io/FileNotFoundException
    //   2285	2293	942	java/io/FileNotFoundException
    //   2297	2302	942	java/io/FileNotFoundException
    //   2306	2314	942	java/io/FileNotFoundException
    //   2322	2328	942	java/io/FileNotFoundException
    //   2332	2341	942	java/io/FileNotFoundException
    //   2345	2351	942	java/io/FileNotFoundException
    //   2364	2370	942	java/io/FileNotFoundException
    //   2374	2406	942	java/io/FileNotFoundException
    //   2713	2723	942	java/io/FileNotFoundException
    //   2727	2736	942	java/io/FileNotFoundException
    //   2856	2862	942	java/io/FileNotFoundException
    //   2866	2931	942	java/io/FileNotFoundException
    //   2940	2945	942	java/io/FileNotFoundException
    //   2949	2960	942	java/io/FileNotFoundException
    //   2964	2971	942	java/io/FileNotFoundException
    //   2975	2982	942	java/io/FileNotFoundException
    //   1099	1105	1112	java/lang/InterruptedException
    //   1304	1310	1321	java/lang/InterruptedException
    //   84	95	1372	java/net/MalformedURLException
    //   99	110	1372	java/net/MalformedURLException
    //   114	119	1372	java/net/MalformedURLException
    //   128	134	1372	java/net/MalformedURLException
    //   138	146	1372	java/net/MalformedURLException
    //   199	206	1372	java/net/MalformedURLException
    //   210	218	1372	java/net/MalformedURLException
    //   222	232	1372	java/net/MalformedURLException
    //   236	253	1372	java/net/MalformedURLException
    //   257	272	1372	java/net/MalformedURLException
    //   280	287	1372	java/net/MalformedURLException
    //   291	313	1372	java/net/MalformedURLException
    //   317	323	1372	java/net/MalformedURLException
    //   327	335	1372	java/net/MalformedURLException
    //   339	345	1372	java/net/MalformedURLException
    //   349	360	1372	java/net/MalformedURLException
    //   364	370	1372	java/net/MalformedURLException
    //   374	380	1372	java/net/MalformedURLException
    //   384	392	1372	java/net/MalformedURLException
    //   396	401	1372	java/net/MalformedURLException
    //   417	427	1372	java/net/MalformedURLException
    //   431	437	1372	java/net/MalformedURLException
    //   441	450	1372	java/net/MalformedURLException
    //   454	461	1372	java/net/MalformedURLException
    //   465	476	1372	java/net/MalformedURLException
    //   480	521	1372	java/net/MalformedURLException
    //   525	532	1372	java/net/MalformedURLException
    //   536	544	1372	java/net/MalformedURLException
    //   548	558	1372	java/net/MalformedURLException
    //   562	577	1372	java/net/MalformedURLException
    //   581	592	1372	java/net/MalformedURLException
    //   596	620	1372	java/net/MalformedURLException
    //   629	637	1372	java/net/MalformedURLException
    //   641	656	1372	java/net/MalformedURLException
    //   660	669	1372	java/net/MalformedURLException
    //   673	697	1372	java/net/MalformedURLException
    //   701	741	1372	java/net/MalformedURLException
    //   745	751	1372	java/net/MalformedURLException
    //   755	793	1372	java/net/MalformedURLException
    //   797	807	1372	java/net/MalformedURLException
    //   811	816	1372	java/net/MalformedURLException
    //   820	831	1372	java/net/MalformedURLException
    //   839	856	1372	java/net/MalformedURLException
    //   860	866	1372	java/net/MalformedURLException
    //   870	897	1372	java/net/MalformedURLException
    //   908	914	1372	java/net/MalformedURLException
    //   918	927	1372	java/net/MalformedURLException
    //   931	939	1372	java/net/MalformedURLException
    //   1083	1091	1372	java/net/MalformedURLException
    //   1099	1105	1372	java/net/MalformedURLException
    //   1118	1124	1372	java/net/MalformedURLException
    //   1128	1160	1372	java/net/MalformedURLException
    //   1167	1197	1372	java/net/MalformedURLException
    //   1201	1207	1372	java/net/MalformedURLException
    //   1219	1225	1372	java/net/MalformedURLException
    //   1229	1238	1372	java/net/MalformedURLException
    //   1242	1251	1372	java/net/MalformedURLException
    //   1304	1310	1372	java/net/MalformedURLException
    //   1327	1333	1372	java/net/MalformedURLException
    //   1337	1369	1372	java/net/MalformedURLException
    //   1491	1498	1372	java/net/MalformedURLException
    //   1502	1509	1372	java/net/MalformedURLException
    //   1513	1518	1372	java/net/MalformedURLException
    //   1528	1535	1372	java/net/MalformedURLException
    //   1545	1553	1372	java/net/MalformedURLException
    //   1557	1563	1372	java/net/MalformedURLException
    //   1567	1606	1372	java/net/MalformedURLException
    //   1610	1615	1372	java/net/MalformedURLException
    //   1619	1624	1372	java/net/MalformedURLException
    //   1628	1638	1372	java/net/MalformedURLException
    //   1642	1648	1372	java/net/MalformedURLException
    //   1652	1661	1372	java/net/MalformedURLException
    //   1665	1670	1372	java/net/MalformedURLException
    //   1674	1680	1372	java/net/MalformedURLException
    //   1688	1694	1372	java/net/MalformedURLException
    //   1698	1707	1372	java/net/MalformedURLException
    //   1711	1720	1372	java/net/MalformedURLException
    //   1773	1778	1372	java/net/MalformedURLException
    //   1782	1789	1372	java/net/MalformedURLException
    //   1793	1799	1372	java/net/MalformedURLException
    //   1803	1858	1372	java/net/MalformedURLException
    //   1862	1869	1372	java/net/MalformedURLException
    //   1873	1880	1372	java/net/MalformedURLException
    //   1884	1894	1372	java/net/MalformedURLException
    //   1898	1905	1372	java/net/MalformedURLException
    //   1909	1924	1372	java/net/MalformedURLException
    //   1932	1938	1372	java/net/MalformedURLException
    //   1942	1984	1372	java/net/MalformedURLException
    //   1990	1997	1372	java/net/MalformedURLException
    //   2001	2012	1372	java/net/MalformedURLException
    //   2022	2027	1372	java/net/MalformedURLException
    //   2036	2042	1372	java/net/MalformedURLException
    //   2046	2054	1372	java/net/MalformedURLException
    //   2107	2114	1372	java/net/MalformedURLException
    //   2118	2133	1372	java/net/MalformedURLException
    //   2141	2163	1372	java/net/MalformedURLException
    //   2167	2173	1372	java/net/MalformedURLException
    //   2177	2188	1372	java/net/MalformedURLException
    //   2192	2198	1372	java/net/MalformedURLException
    //   2202	2208	1372	java/net/MalformedURLException
    //   2212	2257	1372	java/net/MalformedURLException
    //   2261	2271	1372	java/net/MalformedURLException
    //   2275	2281	1372	java/net/MalformedURLException
    //   2285	2293	1372	java/net/MalformedURLException
    //   2297	2302	1372	java/net/MalformedURLException
    //   2306	2314	1372	java/net/MalformedURLException
    //   2322	2328	1372	java/net/MalformedURLException
    //   2332	2341	1372	java/net/MalformedURLException
    //   2345	2351	1372	java/net/MalformedURLException
    //   2364	2370	1372	java/net/MalformedURLException
    //   2374	2406	1372	java/net/MalformedURLException
    //   2713	2723	1372	java/net/MalformedURLException
    //   2727	2736	1372	java/net/MalformedURLException
    //   2856	2862	1372	java/net/MalformedURLException
    //   2866	2931	1372	java/net/MalformedURLException
    //   2940	2945	1372	java/net/MalformedURLException
    //   2949	2960	1372	java/net/MalformedURLException
    //   2964	2971	1372	java/net/MalformedURLException
    //   2975	2982	1372	java/net/MalformedURLException
    //   2345	2351	2358	java/lang/InterruptedException
    //   84	95	2409	java/io/IOException
    //   99	110	2409	java/io/IOException
    //   114	119	2409	java/io/IOException
    //   128	134	2409	java/io/IOException
    //   138	146	2409	java/io/IOException
    //   199	206	2409	java/io/IOException
    //   210	218	2409	java/io/IOException
    //   222	232	2409	java/io/IOException
    //   236	253	2409	java/io/IOException
    //   257	272	2409	java/io/IOException
    //   280	287	2409	java/io/IOException
    //   291	313	2409	java/io/IOException
    //   317	323	2409	java/io/IOException
    //   327	335	2409	java/io/IOException
    //   339	345	2409	java/io/IOException
    //   349	360	2409	java/io/IOException
    //   364	370	2409	java/io/IOException
    //   374	380	2409	java/io/IOException
    //   384	392	2409	java/io/IOException
    //   396	401	2409	java/io/IOException
    //   417	427	2409	java/io/IOException
    //   431	437	2409	java/io/IOException
    //   441	450	2409	java/io/IOException
    //   454	461	2409	java/io/IOException
    //   465	476	2409	java/io/IOException
    //   480	521	2409	java/io/IOException
    //   525	532	2409	java/io/IOException
    //   536	544	2409	java/io/IOException
    //   548	558	2409	java/io/IOException
    //   562	577	2409	java/io/IOException
    //   581	592	2409	java/io/IOException
    //   596	620	2409	java/io/IOException
    //   629	637	2409	java/io/IOException
    //   641	656	2409	java/io/IOException
    //   660	669	2409	java/io/IOException
    //   673	697	2409	java/io/IOException
    //   701	741	2409	java/io/IOException
    //   745	751	2409	java/io/IOException
    //   755	793	2409	java/io/IOException
    //   797	807	2409	java/io/IOException
    //   811	816	2409	java/io/IOException
    //   820	831	2409	java/io/IOException
    //   839	856	2409	java/io/IOException
    //   860	866	2409	java/io/IOException
    //   870	897	2409	java/io/IOException
    //   908	914	2409	java/io/IOException
    //   918	927	2409	java/io/IOException
    //   931	939	2409	java/io/IOException
    //   1083	1091	2409	java/io/IOException
    //   1099	1105	2409	java/io/IOException
    //   1118	1124	2409	java/io/IOException
    //   1128	1160	2409	java/io/IOException
    //   1167	1197	2409	java/io/IOException
    //   1201	1207	2409	java/io/IOException
    //   1219	1225	2409	java/io/IOException
    //   1229	1238	2409	java/io/IOException
    //   1242	1251	2409	java/io/IOException
    //   1304	1310	2409	java/io/IOException
    //   1327	1333	2409	java/io/IOException
    //   1337	1369	2409	java/io/IOException
    //   1491	1498	2409	java/io/IOException
    //   1502	1509	2409	java/io/IOException
    //   1513	1518	2409	java/io/IOException
    //   1528	1535	2409	java/io/IOException
    //   1545	1553	2409	java/io/IOException
    //   1557	1563	2409	java/io/IOException
    //   1567	1606	2409	java/io/IOException
    //   1610	1615	2409	java/io/IOException
    //   1619	1624	2409	java/io/IOException
    //   1628	1638	2409	java/io/IOException
    //   1642	1648	2409	java/io/IOException
    //   1652	1661	2409	java/io/IOException
    //   1665	1670	2409	java/io/IOException
    //   1674	1680	2409	java/io/IOException
    //   1688	1694	2409	java/io/IOException
    //   1698	1707	2409	java/io/IOException
    //   1711	1720	2409	java/io/IOException
    //   1773	1778	2409	java/io/IOException
    //   1782	1789	2409	java/io/IOException
    //   1793	1799	2409	java/io/IOException
    //   1803	1858	2409	java/io/IOException
    //   1862	1869	2409	java/io/IOException
    //   1873	1880	2409	java/io/IOException
    //   1884	1894	2409	java/io/IOException
    //   1898	1905	2409	java/io/IOException
    //   1909	1924	2409	java/io/IOException
    //   1932	1938	2409	java/io/IOException
    //   1942	1984	2409	java/io/IOException
    //   1990	1997	2409	java/io/IOException
    //   2001	2012	2409	java/io/IOException
    //   2022	2027	2409	java/io/IOException
    //   2036	2042	2409	java/io/IOException
    //   2046	2054	2409	java/io/IOException
    //   2107	2114	2409	java/io/IOException
    //   2118	2133	2409	java/io/IOException
    //   2141	2163	2409	java/io/IOException
    //   2167	2173	2409	java/io/IOException
    //   2177	2188	2409	java/io/IOException
    //   2192	2198	2409	java/io/IOException
    //   2202	2208	2409	java/io/IOException
    //   2212	2257	2409	java/io/IOException
    //   2261	2271	2409	java/io/IOException
    //   2275	2281	2409	java/io/IOException
    //   2285	2293	2409	java/io/IOException
    //   2297	2302	2409	java/io/IOException
    //   2306	2314	2409	java/io/IOException
    //   2322	2328	2409	java/io/IOException
    //   2332	2341	2409	java/io/IOException
    //   2345	2351	2409	java/io/IOException
    //   2364	2370	2409	java/io/IOException
    //   2374	2406	2409	java/io/IOException
    //   2713	2723	2409	java/io/IOException
    //   2727	2736	2409	java/io/IOException
    //   2856	2862	2409	java/io/IOException
    //   2866	2931	2409	java/io/IOException
    //   2940	2945	2409	java/io/IOException
    //   2949	2960	2409	java/io/IOException
    //   2964	2971	2409	java/io/IOException
    //   2975	2982	2409	java/io/IOException
    //   84	95	2739	java/lang/IllegalStateException
    //   99	110	2739	java/lang/IllegalStateException
    //   114	119	2739	java/lang/IllegalStateException
    //   128	134	2739	java/lang/IllegalStateException
    //   138	146	2739	java/lang/IllegalStateException
    //   199	206	2739	java/lang/IllegalStateException
    //   210	218	2739	java/lang/IllegalStateException
    //   222	232	2739	java/lang/IllegalStateException
    //   236	253	2739	java/lang/IllegalStateException
    //   257	272	2739	java/lang/IllegalStateException
    //   280	287	2739	java/lang/IllegalStateException
    //   291	313	2739	java/lang/IllegalStateException
    //   317	323	2739	java/lang/IllegalStateException
    //   327	335	2739	java/lang/IllegalStateException
    //   339	345	2739	java/lang/IllegalStateException
    //   349	360	2739	java/lang/IllegalStateException
    //   364	370	2739	java/lang/IllegalStateException
    //   374	380	2739	java/lang/IllegalStateException
    //   384	392	2739	java/lang/IllegalStateException
    //   396	401	2739	java/lang/IllegalStateException
    //   417	427	2739	java/lang/IllegalStateException
    //   431	437	2739	java/lang/IllegalStateException
    //   441	450	2739	java/lang/IllegalStateException
    //   454	461	2739	java/lang/IllegalStateException
    //   465	476	2739	java/lang/IllegalStateException
    //   480	521	2739	java/lang/IllegalStateException
    //   525	532	2739	java/lang/IllegalStateException
    //   536	544	2739	java/lang/IllegalStateException
    //   548	558	2739	java/lang/IllegalStateException
    //   562	577	2739	java/lang/IllegalStateException
    //   581	592	2739	java/lang/IllegalStateException
    //   596	620	2739	java/lang/IllegalStateException
    //   629	637	2739	java/lang/IllegalStateException
    //   641	656	2739	java/lang/IllegalStateException
    //   660	669	2739	java/lang/IllegalStateException
    //   673	697	2739	java/lang/IllegalStateException
    //   701	741	2739	java/lang/IllegalStateException
    //   745	751	2739	java/lang/IllegalStateException
    //   755	793	2739	java/lang/IllegalStateException
    //   797	807	2739	java/lang/IllegalStateException
    //   811	816	2739	java/lang/IllegalStateException
    //   820	831	2739	java/lang/IllegalStateException
    //   839	856	2739	java/lang/IllegalStateException
    //   860	866	2739	java/lang/IllegalStateException
    //   870	897	2739	java/lang/IllegalStateException
    //   908	914	2739	java/lang/IllegalStateException
    //   918	927	2739	java/lang/IllegalStateException
    //   931	939	2739	java/lang/IllegalStateException
    //   1083	1091	2739	java/lang/IllegalStateException
    //   1099	1105	2739	java/lang/IllegalStateException
    //   1118	1124	2739	java/lang/IllegalStateException
    //   1128	1160	2739	java/lang/IllegalStateException
    //   1167	1197	2739	java/lang/IllegalStateException
    //   1201	1207	2739	java/lang/IllegalStateException
    //   1219	1225	2739	java/lang/IllegalStateException
    //   1229	1238	2739	java/lang/IllegalStateException
    //   1242	1251	2739	java/lang/IllegalStateException
    //   1304	1310	2739	java/lang/IllegalStateException
    //   1327	1333	2739	java/lang/IllegalStateException
    //   1337	1369	2739	java/lang/IllegalStateException
    //   1491	1498	2739	java/lang/IllegalStateException
    //   1502	1509	2739	java/lang/IllegalStateException
    //   1513	1518	2739	java/lang/IllegalStateException
    //   1528	1535	2739	java/lang/IllegalStateException
    //   1545	1553	2739	java/lang/IllegalStateException
    //   1557	1563	2739	java/lang/IllegalStateException
    //   1567	1606	2739	java/lang/IllegalStateException
    //   1610	1615	2739	java/lang/IllegalStateException
    //   1619	1624	2739	java/lang/IllegalStateException
    //   1628	1638	2739	java/lang/IllegalStateException
    //   1642	1648	2739	java/lang/IllegalStateException
    //   1652	1661	2739	java/lang/IllegalStateException
    //   1665	1670	2739	java/lang/IllegalStateException
    //   1674	1680	2739	java/lang/IllegalStateException
    //   1688	1694	2739	java/lang/IllegalStateException
    //   1698	1707	2739	java/lang/IllegalStateException
    //   1711	1720	2739	java/lang/IllegalStateException
    //   1773	1778	2739	java/lang/IllegalStateException
    //   1782	1789	2739	java/lang/IllegalStateException
    //   1793	1799	2739	java/lang/IllegalStateException
    //   1803	1858	2739	java/lang/IllegalStateException
    //   1862	1869	2739	java/lang/IllegalStateException
    //   1873	1880	2739	java/lang/IllegalStateException
    //   1884	1894	2739	java/lang/IllegalStateException
    //   1898	1905	2739	java/lang/IllegalStateException
    //   1909	1924	2739	java/lang/IllegalStateException
    //   1932	1938	2739	java/lang/IllegalStateException
    //   1942	1984	2739	java/lang/IllegalStateException
    //   1990	1997	2739	java/lang/IllegalStateException
    //   2001	2012	2739	java/lang/IllegalStateException
    //   2022	2027	2739	java/lang/IllegalStateException
    //   2036	2042	2739	java/lang/IllegalStateException
    //   2046	2054	2739	java/lang/IllegalStateException
    //   2107	2114	2739	java/lang/IllegalStateException
    //   2118	2133	2739	java/lang/IllegalStateException
    //   2141	2163	2739	java/lang/IllegalStateException
    //   2167	2173	2739	java/lang/IllegalStateException
    //   2177	2188	2739	java/lang/IllegalStateException
    //   2192	2198	2739	java/lang/IllegalStateException
    //   2202	2208	2739	java/lang/IllegalStateException
    //   2212	2257	2739	java/lang/IllegalStateException
    //   2261	2271	2739	java/lang/IllegalStateException
    //   2275	2281	2739	java/lang/IllegalStateException
    //   2285	2293	2739	java/lang/IllegalStateException
    //   2297	2302	2739	java/lang/IllegalStateException
    //   2306	2314	2739	java/lang/IllegalStateException
    //   2322	2328	2739	java/lang/IllegalStateException
    //   2332	2341	2739	java/lang/IllegalStateException
    //   2345	2351	2739	java/lang/IllegalStateException
    //   2364	2370	2739	java/lang/IllegalStateException
    //   2374	2406	2739	java/lang/IllegalStateException
    //   2713	2723	2739	java/lang/IllegalStateException
    //   2727	2736	2739	java/lang/IllegalStateException
    //   2856	2862	2739	java/lang/IllegalStateException
    //   2866	2931	2739	java/lang/IllegalStateException
    //   2940	2945	2739	java/lang/IllegalStateException
    //   2949	2960	2739	java/lang/IllegalStateException
    //   2964	2971	2739	java/lang/IllegalStateException
    //   2975	2982	2739	java/lang/IllegalStateException
    //   64	80	3033	java/lang/Exception
    //   64	80	3149	finally
    //   156	161	3205	java/io/IOException
    //   1261	1266	3210	java/io/IOException
    //   1730	1735	3215	java/io/IOException
    //   2064	2069	3220	java/io/IOException
    //   2992	2997	3225	java/io/IOException
    //   1010	1015	3230	java/io/IOException
    //   1444	1449	3235	java/io/IOException
    //   2666	2671	3240	java/io/IOException
    //   2811	2816	3245	java/io/IOException
    //   3108	3113	3250	java/io/IOException
    //   3164	3169	3255	java/io/IOException
    //   84	95	3260	finally
    //   99	110	3260	finally
    //   114	119	3260	finally
    //   128	134	3260	finally
    //   138	146	3260	finally
    //   199	206	3260	finally
    //   210	218	3260	finally
    //   222	232	3260	finally
    //   236	253	3260	finally
    //   257	272	3260	finally
    //   280	287	3260	finally
    //   291	313	3260	finally
    //   317	323	3260	finally
    //   327	335	3260	finally
    //   339	345	3260	finally
    //   349	360	3260	finally
    //   364	370	3260	finally
    //   374	380	3260	finally
    //   384	392	3260	finally
    //   396	401	3260	finally
    //   417	427	3260	finally
    //   431	437	3260	finally
    //   441	450	3260	finally
    //   454	461	3260	finally
    //   465	476	3260	finally
    //   480	521	3260	finally
    //   525	532	3260	finally
    //   536	544	3260	finally
    //   548	558	3260	finally
    //   562	577	3260	finally
    //   581	592	3260	finally
    //   596	620	3260	finally
    //   629	637	3260	finally
    //   641	656	3260	finally
    //   660	669	3260	finally
    //   673	697	3260	finally
    //   701	741	3260	finally
    //   745	751	3260	finally
    //   755	793	3260	finally
    //   797	807	3260	finally
    //   811	816	3260	finally
    //   820	831	3260	finally
    //   839	856	3260	finally
    //   860	866	3260	finally
    //   870	897	3260	finally
    //   908	914	3260	finally
    //   918	927	3260	finally
    //   931	939	3260	finally
    //   1083	1091	3260	finally
    //   1099	1105	3260	finally
    //   1118	1124	3260	finally
    //   1128	1160	3260	finally
    //   1167	1197	3260	finally
    //   1201	1207	3260	finally
    //   1219	1225	3260	finally
    //   1229	1238	3260	finally
    //   1242	1251	3260	finally
    //   1304	1310	3260	finally
    //   1327	1333	3260	finally
    //   1337	1369	3260	finally
    //   1378	1388	3260	finally
    //   1392	1398	3260	finally
    //   1402	1434	3260	finally
    //   1491	1498	3260	finally
    //   1502	1509	3260	finally
    //   1513	1518	3260	finally
    //   1528	1535	3260	finally
    //   1545	1553	3260	finally
    //   1557	1563	3260	finally
    //   1567	1606	3260	finally
    //   1610	1615	3260	finally
    //   1619	1624	3260	finally
    //   1628	1638	3260	finally
    //   1642	1648	3260	finally
    //   1652	1661	3260	finally
    //   1665	1670	3260	finally
    //   1674	1680	3260	finally
    //   1688	1694	3260	finally
    //   1698	1707	3260	finally
    //   1711	1720	3260	finally
    //   1773	1778	3260	finally
    //   1782	1789	3260	finally
    //   1793	1799	3260	finally
    //   1803	1858	3260	finally
    //   1862	1869	3260	finally
    //   1873	1880	3260	finally
    //   1884	1894	3260	finally
    //   1898	1905	3260	finally
    //   1909	1924	3260	finally
    //   1932	1938	3260	finally
    //   1942	1984	3260	finally
    //   1990	1997	3260	finally
    //   2001	2012	3260	finally
    //   2022	2027	3260	finally
    //   2036	2042	3260	finally
    //   2046	2054	3260	finally
    //   2107	2114	3260	finally
    //   2118	2133	3260	finally
    //   2141	2163	3260	finally
    //   2167	2173	3260	finally
    //   2177	2188	3260	finally
    //   2192	2198	3260	finally
    //   2202	2208	3260	finally
    //   2212	2257	3260	finally
    //   2261	2271	3260	finally
    //   2275	2281	3260	finally
    //   2285	2293	3260	finally
    //   2297	2302	3260	finally
    //   2306	2314	3260	finally
    //   2322	2328	3260	finally
    //   2332	2341	3260	finally
    //   2345	2351	3260	finally
    //   2364	2370	3260	finally
    //   2374	2406	3260	finally
    //   2415	2421	3260	finally
    //   2425	2457	3260	finally
    //   2461	2466	3260	finally
    //   2478	2485	3260	finally
    //   2492	2500	3260	finally
    //   2507	2517	3260	finally
    //   2521	2541	3260	finally
    //   2545	2551	3260	finally
    //   2555	2570	3260	finally
    //   2578	2584	3260	finally
    //   2588	2597	3260	finally
    //   2601	2607	3260	finally
    //   2611	2619	3260	finally
    //   2623	2629	3260	finally
    //   2633	2642	3260	finally
    //   2646	2656	3260	finally
    //   2713	2723	3260	finally
    //   2727	2736	3260	finally
    //   2745	2755	3260	finally
    //   2759	2765	3260	finally
    //   2769	2801	3260	finally
    //   2856	2862	3260	finally
    //   2866	2931	3260	finally
    //   2940	2945	3260	finally
    //   2949	2960	3260	finally
    //   2964	2971	3260	finally
    //   2975	2982	3260	finally
    //   3042	3048	3260	finally
    //   3052	3084	3260	finally
    //   3088	3098	3260	finally
    //   952	990	3265	finally
    //   990	1000	3265	finally
    //   84	95	3270	java/lang/Exception
    //   99	110	3270	java/lang/Exception
    //   114	119	3270	java/lang/Exception
    //   128	134	3270	java/lang/Exception
    //   138	146	3270	java/lang/Exception
    //   199	206	3270	java/lang/Exception
    //   210	218	3270	java/lang/Exception
    //   222	232	3270	java/lang/Exception
    //   236	253	3270	java/lang/Exception
    //   257	272	3270	java/lang/Exception
    //   280	287	3270	java/lang/Exception
    //   291	313	3270	java/lang/Exception
    //   317	323	3270	java/lang/Exception
    //   327	335	3270	java/lang/Exception
    //   339	345	3270	java/lang/Exception
    //   349	360	3270	java/lang/Exception
    //   364	370	3270	java/lang/Exception
    //   374	380	3270	java/lang/Exception
    //   384	392	3270	java/lang/Exception
    //   396	401	3270	java/lang/Exception
    //   417	427	3270	java/lang/Exception
    //   431	437	3270	java/lang/Exception
    //   441	450	3270	java/lang/Exception
    //   454	461	3270	java/lang/Exception
    //   465	476	3270	java/lang/Exception
    //   480	521	3270	java/lang/Exception
    //   525	532	3270	java/lang/Exception
    //   536	544	3270	java/lang/Exception
    //   548	558	3270	java/lang/Exception
    //   562	577	3270	java/lang/Exception
    //   581	592	3270	java/lang/Exception
    //   596	620	3270	java/lang/Exception
    //   629	637	3270	java/lang/Exception
    //   641	656	3270	java/lang/Exception
    //   660	669	3270	java/lang/Exception
    //   673	697	3270	java/lang/Exception
    //   701	741	3270	java/lang/Exception
    //   745	751	3270	java/lang/Exception
    //   755	793	3270	java/lang/Exception
    //   797	807	3270	java/lang/Exception
    //   811	816	3270	java/lang/Exception
    //   820	831	3270	java/lang/Exception
    //   839	856	3270	java/lang/Exception
    //   860	866	3270	java/lang/Exception
    //   870	897	3270	java/lang/Exception
    //   908	914	3270	java/lang/Exception
    //   918	927	3270	java/lang/Exception
    //   931	939	3270	java/lang/Exception
    //   1083	1091	3270	java/lang/Exception
    //   1099	1105	3270	java/lang/Exception
    //   1118	1124	3270	java/lang/Exception
    //   1128	1160	3270	java/lang/Exception
    //   1167	1197	3270	java/lang/Exception
    //   1201	1207	3270	java/lang/Exception
    //   1219	1225	3270	java/lang/Exception
    //   1229	1238	3270	java/lang/Exception
    //   1242	1251	3270	java/lang/Exception
    //   1304	1310	3270	java/lang/Exception
    //   1327	1333	3270	java/lang/Exception
    //   1337	1369	3270	java/lang/Exception
    //   1491	1498	3270	java/lang/Exception
    //   1502	1509	3270	java/lang/Exception
    //   1513	1518	3270	java/lang/Exception
    //   1528	1535	3270	java/lang/Exception
    //   1545	1553	3270	java/lang/Exception
    //   1557	1563	3270	java/lang/Exception
    //   1567	1606	3270	java/lang/Exception
    //   1610	1615	3270	java/lang/Exception
    //   1619	1624	3270	java/lang/Exception
    //   1628	1638	3270	java/lang/Exception
    //   1642	1648	3270	java/lang/Exception
    //   1652	1661	3270	java/lang/Exception
    //   1665	1670	3270	java/lang/Exception
    //   1674	1680	3270	java/lang/Exception
    //   1688	1694	3270	java/lang/Exception
    //   1698	1707	3270	java/lang/Exception
    //   1711	1720	3270	java/lang/Exception
    //   1773	1778	3270	java/lang/Exception
    //   1782	1789	3270	java/lang/Exception
    //   1793	1799	3270	java/lang/Exception
    //   1803	1858	3270	java/lang/Exception
    //   1862	1869	3270	java/lang/Exception
    //   1873	1880	3270	java/lang/Exception
    //   1884	1894	3270	java/lang/Exception
    //   1898	1905	3270	java/lang/Exception
    //   1909	1924	3270	java/lang/Exception
    //   1932	1938	3270	java/lang/Exception
    //   1942	1984	3270	java/lang/Exception
    //   1990	1997	3270	java/lang/Exception
    //   2001	2012	3270	java/lang/Exception
    //   2022	2027	3270	java/lang/Exception
    //   2036	2042	3270	java/lang/Exception
    //   2046	2054	3270	java/lang/Exception
    //   2107	2114	3270	java/lang/Exception
    //   2118	2133	3270	java/lang/Exception
    //   2141	2163	3270	java/lang/Exception
    //   2167	2173	3270	java/lang/Exception
    //   2177	2188	3270	java/lang/Exception
    //   2192	2198	3270	java/lang/Exception
    //   2202	2208	3270	java/lang/Exception
    //   2212	2257	3270	java/lang/Exception
    //   2261	2271	3270	java/lang/Exception
    //   2275	2281	3270	java/lang/Exception
    //   2285	2293	3270	java/lang/Exception
    //   2297	2302	3270	java/lang/Exception
    //   2306	2314	3270	java/lang/Exception
    //   2322	2328	3270	java/lang/Exception
    //   2332	2341	3270	java/lang/Exception
    //   2345	2351	3270	java/lang/Exception
    //   2364	2370	3270	java/lang/Exception
    //   2374	2406	3270	java/lang/Exception
    //   2713	2723	3270	java/lang/Exception
    //   2727	2736	3270	java/lang/Exception
    //   2856	2862	3270	java/lang/Exception
    //   2866	2931	3270	java/lang/Exception
    //   2940	2945	3270	java/lang/Exception
    //   2949	2960	3270	java/lang/Exception
    //   2964	2971	3270	java/lang/Exception
    //   2975	2982	3270	java/lang/Exception
    //   64	80	3275	java/lang/IllegalStateException
    //   64	80	3283	java/io/IOException
    //   64	80	3291	java/net/MalformedURLException
    //   64	80	3299	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.DownloadThread
 * JD-Core Version:    0.7.0.1
 */