package com.tencent.mobileqq.music;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class QQPlayerService$DownloadThread
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    setName("QQPlayerService-DownloadThread");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private File a(String paramString)
  {
    Object localObject = new File(AppConstants.SDCARD_MUSIC);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_MUSIC);
    ((StringBuilder)localObject).append(paramString);
    paramString = new File(((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      try
      {
        paramString.createNewFile();
        return paramString;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createNewFile:");
          localStringBuilder.append(localIOException.getMessage());
          QLog.d("QQPlayerService", 2, localStringBuilder.toString(), localIOException);
        }
      }
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 106
    //   2: astore 7
    //   4: invokestatic 111	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()[J
    //   7: astore 6
    //   9: aload 6
    //   11: ifnull +39 -> 50
    //   14: aload 6
    //   16: iconst_1
    //   17: laload
    //   18: ldc2_w 112
    //   21: lcmp
    //   22: ifgt +28 -> 50
    //   25: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 90
    //   33: iconst_2
    //   34: ldc 115
    //   36: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   43: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   46: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   49: return
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokespecial 129	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	(Ljava/lang/String;)Ljava/io/File;
    //   58: astore 11
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   65: new 131	java/io/RandomAccessFile
    //   68: dup
    //   69: aload 11
    //   71: invokevirtual 134	java/io/File:getPath	()Ljava/lang/String;
    //   74: ldc 136
    //   76: invokespecial 139	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: astore 6
    //   81: aload 7
    //   83: astore 10
    //   85: ldc 141
    //   87: aload_0
    //   88: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokestatic 147	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 13
    //   96: aload 7
    //   98: astore 10
    //   100: new 149	java/net/URL
    //   103: dup
    //   104: aload 13
    //   106: invokespecial 150	java/net/URL:<init>	(Ljava/lang/String;)V
    //   109: astore 9
    //   111: aload 7
    //   113: astore 10
    //   115: invokestatic 154	com/tencent/mobileqq/music/QQPlayerService:e	()Lcom/tencent/mobileqq/music/SongInfo;
    //   118: astore 12
    //   120: ldc 156
    //   122: astore 8
    //   124: aload 12
    //   126: ifnonnull +69 -> 195
    //   129: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +11 -> 143
    //   135: ldc 90
    //   137: iconst_2
    //   138: ldc 156
    //   140: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: iconst_0
    //   145: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   148: aload 6
    //   150: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   153: aload_0
    //   154: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   157: istore_1
    //   158: aload_0
    //   159: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   162: istore_2
    //   163: iload_1
    //   164: iload_2
    //   165: if_icmpge +16 -> 181
    //   168: iload_2
    //   169: ifle +12 -> 181
    //   172: aload_0
    //   173: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   176: iload_1
    //   177: iload_2
    //   178: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   181: return
    //   182: astore 8
    //   184: ldc 106
    //   186: astore 9
    //   188: aload 6
    //   190: astore 7
    //   192: goto +2315 -> 2507
    //   195: aload 7
    //   197: astore 10
    //   199: aload 12
    //   201: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   204: astore 14
    //   206: aload 7
    //   208: astore 10
    //   210: aload 14
    //   212: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: istore 4
    //   217: iload 4
    //   219: ifne +34 -> 253
    //   222: aload 14
    //   224: ldc 106
    //   226: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   229: ifeq +24 -> 253
    //   232: aload_0
    //   233: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: aload_0
    //   237: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   240: aload 14
    //   242: invokestatic 185	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: istore 4
    //   250: goto +6 -> 256
    //   253: iconst_0
    //   254: istore 4
    //   256: aload 7
    //   258: astore 10
    //   260: aload 12
    //   262: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifne +8 -> 280
    //   275: iload 4
    //   277: ifeq +121 -> 398
    //   280: aload 7
    //   282: astore 10
    //   284: aload_0
    //   285: getfield 28	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   288: istore 5
    //   290: iload 5
    //   292: ifeq +106 -> 398
    //   295: aload_0
    //   296: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   299: i2f
    //   300: aload_0
    //   301: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   304: i2f
    //   305: aload_0
    //   306: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   309: getfield 192	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   312: fmul
    //   313: fcmpl
    //   314: ifle +62 -> 376
    //   317: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +11 -> 331
    //   323: ldc 90
    //   325: iconst_2
    //   326: ldc 194
    //   328: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   334: invokevirtual 202	android/media/MediaPlayer:reset	()V
    //   337: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   340: aload 11
    //   342: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   345: invokevirtual 208	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   348: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   351: invokevirtual 211	android/media/MediaPlayer:prepare	()V
    //   354: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   357: invokevirtual 214	android/media/MediaPlayer:start	()V
    //   360: aload_0
    //   361: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   364: iconst_2
    //   365: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   368: aload_0
    //   369: iconst_0
    //   370: putfield 28	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   373: goto +25 -> 398
    //   376: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +11 -> 390
    //   382: ldc 90
    //   384: iconst_2
    //   385: ldc 219
    //   387: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   394: iconst_1
    //   395: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   398: iconst_0
    //   399: istore_1
    //   400: iconst_0
    //   401: istore_2
    //   402: aconst_null
    //   403: astore 10
    //   405: iload_1
    //   406: ifgt +2830 -> 3236
    //   409: iload_2
    //   410: iconst_5
    //   411: if_icmpgt +2822 -> 3233
    //   414: aload 7
    //   416: astore 10
    //   418: aload 9
    //   420: invokevirtual 223	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   423: checkcast 225	java/net/HttpURLConnection
    //   426: astore 12
    //   428: aload 7
    //   430: astore 10
    //   432: aload 12
    //   434: iconst_0
    //   435: invokevirtual 229	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   438: aload 7
    //   440: astore 10
    //   442: aload 12
    //   444: ldc 231
    //   446: ldc 233
    //   448: invokevirtual 236	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload 7
    //   453: astore 10
    //   455: aload_0
    //   456: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   459: ifeq +2754 -> 3213
    //   462: aload 7
    //   464: astore 10
    //   466: aload_0
    //   467: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   470: istore_3
    //   471: iload_3
    //   472: aload_0
    //   473: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   476: if_icmple +2737 -> 3213
    //   479: new 66	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   486: astore 10
    //   488: aload 10
    //   490: ldc 238
    //   492: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 10
    //   498: aload_0
    //   499: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   502: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 10
    //   508: ldc 243
    //   510: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 10
    //   516: aload_0
    //   517: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   520: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 12
    //   526: ldc 245
    //   528: aload 10
    //   530: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 236	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto +3 -> 539
    //   539: aload 9
    //   541: invokevirtual 248	java/net/URL:getHost	()Ljava/lang/String;
    //   544: astore 10
    //   546: aload 10
    //   548: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   551: istore 5
    //   553: iload 5
    //   555: ifne +2661 -> 3216
    //   558: aload 10
    //   560: ldc 250
    //   562: invokevirtual 253	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   565: ifeq +2651 -> 3216
    //   568: getstatic 259	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   571: aconst_null
    //   572: invokevirtual 263	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   575: astore 10
    //   577: aload 10
    //   579: iconst_2
    //   580: invokevirtual 269	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   583: checkcast 271	mqq/manager/TicketManager
    //   586: astore 14
    //   588: aload 10
    //   590: invokevirtual 274	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   593: astore 10
    //   595: aload 14
    //   597: aload 10
    //   599: ldc2_w 275
    //   602: iconst_1
    //   603: anewarray 178	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: ldc 250
    //   610: aastore
    //   611: aconst_null
    //   612: invokeinterface 280 6 0
    //   617: astore 14
    //   619: aload 14
    //   621: ifnull +191 -> 812
    //   624: aload 14
    //   626: getfield 286	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   629: ifnull +183 -> 812
    //   632: aload 14
    //   634: getfield 286	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   637: ldc 250
    //   639: invokeinterface 292 2 0
    //   644: ifnull +168 -> 812
    //   647: ldc 90
    //   649: iconst_1
    //   650: ldc_w 294
    //   653: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: new 178	java/lang/String
    //   659: dup
    //   660: aload 14
    //   662: getfield 286	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   665: ldc 250
    //   667: invokeinterface 292 2 0
    //   672: checkcast 296	[B
    //   675: invokespecial 299	java/lang/String:<init>	([B)V
    //   678: astore 14
    //   680: new 66	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   687: astore 15
    //   689: aload 15
    //   691: ldc_w 301
    //   694: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 15
    //   700: aload 14
    //   702: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 15
    //   708: ldc_w 303
    //   711: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 15
    //   717: aload 10
    //   719: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 15
    //   725: ldc_w 305
    //   728: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 15
    //   734: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: astore 10
    //   739: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   742: ifeq +57 -> 799
    //   745: new 66	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   752: astore 14
    //   754: aload 14
    //   756: ldc_w 307
    //   759: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload 14
    //   765: aload 13
    //   767: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload 14
    //   773: ldc_w 309
    //   776: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload 14
    //   782: aload 10
    //   784: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: ldc 90
    //   790: iconst_1
    //   791: aload 14
    //   793: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   799: aload 12
    //   801: ldc_w 313
    //   804: aload 10
    //   806: invokevirtual 236	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   809: goto +95 -> 904
    //   812: ldc 90
    //   814: ldc_w 315
    //   817: invokestatic 320	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: iload_2
    //   821: iconst_1
    //   822: iadd
    //   823: istore_3
    //   824: ldc2_w 321
    //   827: invokestatic 326	java/lang/Thread:sleep	(J)V
    //   830: iload_3
    //   831: istore_2
    //   832: aload 9
    //   834: astore 10
    //   836: goto +2383 -> 3219
    //   839: astore 14
    //   841: iload_3
    //   842: istore_2
    //   843: aload 9
    //   845: astore 10
    //   847: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   850: ifeq +2369 -> 3219
    //   853: new 66	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   860: astore 10
    //   862: aload 10
    //   864: ldc_w 328
    //   867: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 10
    //   873: aload 14
    //   875: invokevirtual 329	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   878: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: ldc 90
    //   884: iconst_2
    //   885: aload 10
    //   887: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: aload 14
    //   892: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   895: iload_3
    //   896: istore_2
    //   897: aload 9
    //   899: astore 10
    //   901: goto +2318 -> 3219
    //   904: aload 12
    //   906: invokevirtual 332	java/net/HttpURLConnection:connect	()V
    //   909: aload 12
    //   911: invokevirtual 336	java/net/HttpURLConnection:getResponseCode	()I
    //   914: sipush 302
    //   917: if_icmpne +82 -> 999
    //   920: iload_2
    //   921: iconst_1
    //   922: iadd
    //   923: istore_3
    //   924: new 149	java/net/URL
    //   927: dup
    //   928: aload 12
    //   930: ldc_w 338
    //   933: invokevirtual 342	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   936: invokespecial 150	java/net/URL:<init>	(Ljava/lang/String;)V
    //   939: astore 9
    //   941: iload_3
    //   942: istore_2
    //   943: aload 9
    //   945: astore 10
    //   947: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   950: ifeq +2269 -> 3219
    //   953: new 66	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   960: astore 10
    //   962: aload 10
    //   964: ldc_w 344
    //   967: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload 10
    //   973: aload 9
    //   975: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: ldc 90
    //   981: iconst_1
    //   982: aload 10
    //   984: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: iload_3
    //   991: istore_2
    //   992: aload 9
    //   994: astore 10
    //   996: goto +2223 -> 3219
    //   999: new 66	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1006: astore 10
    //   1008: aload 10
    //   1010: ldc_w 349
    //   1013: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 10
    //   1019: aload 12
    //   1021: invokevirtual 336	java/net/HttpURLConnection:getResponseCode	()I
    //   1024: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: ldc 90
    //   1030: iconst_1
    //   1031: aload 10
    //   1033: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: aload 12
    //   1041: invokevirtual 352	java/net/HttpURLConnection:getContentLength	()I
    //   1044: istore_1
    //   1045: iload_1
    //   1046: ifle +12 -> 1058
    //   1049: iload_1
    //   1050: istore_2
    //   1051: aload 12
    //   1053: astore 10
    //   1055: goto +69 -> 1124
    //   1058: iload_2
    //   1059: iconst_1
    //   1060: iadd
    //   1061: istore_2
    //   1062: ldc2_w 321
    //   1065: invokestatic 326	java/lang/Thread:sleep	(J)V
    //   1068: goto +2162 -> 3230
    //   1071: astore 10
    //   1073: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1076: ifeq +2154 -> 3230
    //   1079: new 66	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1086: astore 14
    //   1088: aload 14
    //   1090: ldc_w 328
    //   1093: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload 14
    //   1099: aload 10
    //   1101: invokevirtual 329	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1104: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: ldc 90
    //   1110: iconst_2
    //   1111: aload 14
    //   1113: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: aload 10
    //   1118: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1121: goto +2109 -> 3230
    //   1124: aload 8
    //   1126: astore 12
    //   1128: iload_2
    //   1129: ifgt +66 -> 1195
    //   1132: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1135: ifeq +12 -> 1147
    //   1138: ldc 90
    //   1140: iconst_2
    //   1141: ldc_w 354
    //   1144: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1147: aload_0
    //   1148: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1151: bipush 7
    //   1153: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1156: aload_0
    //   1157: iconst_0
    //   1158: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1161: aload 6
    //   1163: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   1166: aload_0
    //   1167: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1170: istore_1
    //   1171: aload_0
    //   1172: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1175: istore_2
    //   1176: iload_1
    //   1177: iload_2
    //   1178: if_icmpge +16 -> 1194
    //   1181: iload_2
    //   1182: ifle +12 -> 1194
    //   1185: aload_0
    //   1186: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1189: iload_1
    //   1190: iload_2
    //   1191: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1194: return
    //   1195: iload_2
    //   1196: istore_1
    //   1197: aload_0
    //   1198: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1201: ifle +10 -> 1211
    //   1204: iload_2
    //   1205: aload_0
    //   1206: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1209: iadd
    //   1210: istore_1
    //   1211: aload_0
    //   1212: iload_1
    //   1213: putfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1216: iload_1
    //   1217: istore_2
    //   1218: aload 10
    //   1220: astore 8
    //   1222: aload_0
    //   1223: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1226: ifeq +196 -> 1422
    //   1229: iload_1
    //   1230: istore_2
    //   1231: aload 10
    //   1233: astore 8
    //   1235: aload_0
    //   1236: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1239: iload_1
    //   1240: if_icmpeq +182 -> 1422
    //   1243: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1246: ifeq +58 -> 1304
    //   1249: new 66	java/lang/StringBuilder
    //   1252: dup
    //   1253: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1256: astore 8
    //   1258: aload 8
    //   1260: ldc_w 356
    //   1263: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload 8
    //   1269: aload_0
    //   1270: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1273: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload 8
    //   1279: ldc_w 358
    //   1282: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload 8
    //   1288: iload_1
    //   1289: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: ldc 90
    //   1295: iconst_2
    //   1296: aload 8
    //   1298: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: aload_0
    //   1305: iconst_0
    //   1306: putfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1309: aload_0
    //   1310: iconst_1
    //   1311: putfield 28	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   1314: aload 9
    //   1316: invokevirtual 223	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1319: checkcast 225	java/net/HttpURLConnection
    //   1322: astore 8
    //   1324: aload 8
    //   1326: iconst_1
    //   1327: invokevirtual 229	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1330: aload 8
    //   1332: ldc 231
    //   1334: ldc 233
    //   1336: invokevirtual 236	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1339: aload 8
    //   1341: invokevirtual 332	java/net/HttpURLConnection:connect	()V
    //   1344: aload 8
    //   1346: invokevirtual 352	java/net/HttpURLConnection:getContentLength	()I
    //   1349: istore_2
    //   1350: iload_2
    //   1351: ifge +66 -> 1417
    //   1354: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1357: ifeq +12 -> 1369
    //   1360: ldc 90
    //   1362: iconst_2
    //   1363: ldc_w 360
    //   1366: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1369: aload_0
    //   1370: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1373: bipush 7
    //   1375: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1378: aload_0
    //   1379: iconst_0
    //   1380: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1383: aload 6
    //   1385: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   1388: aload_0
    //   1389: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1392: istore_1
    //   1393: aload_0
    //   1394: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1397: istore_2
    //   1398: iload_1
    //   1399: iload_2
    //   1400: if_icmpge +16 -> 1416
    //   1403: iload_2
    //   1404: ifle +12 -> 1416
    //   1407: aload_0
    //   1408: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1411: iload_1
    //   1412: iload_2
    //   1413: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1416: return
    //   1417: aload_0
    //   1418: iload_2
    //   1419: putfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1422: aload 6
    //   1424: iload_2
    //   1425: i2l
    //   1426: invokevirtual 363	java/io/RandomAccessFile:setLength	(J)V
    //   1429: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: istore 5
    //   1434: iload 5
    //   1436: ifeq +80 -> 1516
    //   1439: new 66	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1446: astore 9
    //   1448: aload 9
    //   1450: ldc_w 365
    //   1453: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 9
    //   1459: aload_0
    //   1460: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1463: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: aload 9
    //   1469: ldc_w 367
    //   1472: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: aload 9
    //   1478: aload_0
    //   1479: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1482: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1485: pop
    //   1486: aload 9
    //   1488: ldc_w 369
    //   1491: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload 9
    //   1497: aload_0
    //   1498: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1501: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: ldc 90
    //   1507: iconst_2
    //   1508: aload 9
    //   1510: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1513: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1516: aload 8
    //   1518: invokevirtual 373	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1521: astore 9
    //   1523: sipush 8192
    //   1526: newarray byte
    //   1528: astore 10
    //   1530: aload 6
    //   1532: aload_0
    //   1533: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1536: i2l
    //   1537: invokevirtual 376	java/io/RandomAccessFile:seek	(J)V
    //   1540: aload_0
    //   1541: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   1544: ifne +18 -> 1562
    //   1547: aload_0
    //   1548: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1551: aload_0
    //   1552: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1555: aload_0
    //   1556: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1559: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1562: aload 12
    //   1564: astore 8
    //   1566: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1569: ifeq +1672 -> 3241
    //   1572: new 66	java/lang/StringBuilder
    //   1575: dup
    //   1576: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1579: astore 8
    //   1581: aload 8
    //   1583: ldc_w 378
    //   1586: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: pop
    //   1590: aload 8
    //   1592: aload_0
    //   1593: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1596: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1599: pop
    //   1600: aload 8
    //   1602: ldc_w 369
    //   1605: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: pop
    //   1609: aload 8
    //   1611: aload_0
    //   1612: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1615: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1618: pop
    //   1619: ldc 90
    //   1621: iconst_2
    //   1622: aload 8
    //   1624: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1630: aload 12
    //   1632: astore 8
    //   1634: goto +1607 -> 3241
    //   1637: aload_0
    //   1638: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Boolean	Z
    //   1641: ifne +362 -> 2003
    //   1644: aload_0
    //   1645: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1648: aload_0
    //   1649: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1652: if_icmpge +351 -> 2003
    //   1655: iload_1
    //   1656: bipush 10
    //   1658: if_icmpge +345 -> 2003
    //   1661: invokestatic 154	com/tencent/mobileqq/music/QQPlayerService:e	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1664: astore 12
    //   1666: aload 12
    //   1668: ifnonnull +56 -> 1724
    //   1671: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1674: ifeq +11 -> 1685
    //   1677: ldc 90
    //   1679: iconst_2
    //   1680: aload 8
    //   1682: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1685: aload_0
    //   1686: iconst_0
    //   1687: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   1690: aload 6
    //   1692: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   1695: aload_0
    //   1696: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1699: istore_1
    //   1700: aload_0
    //   1701: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1704: istore_2
    //   1705: iload_1
    //   1706: iload_2
    //   1707: if_icmpge +16 -> 1723
    //   1710: iload_2
    //   1711: ifle +12 -> 1723
    //   1714: aload_0
    //   1715: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1718: iload_1
    //   1719: iload_2
    //   1720: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1723: return
    //   1724: aload_0
    //   1725: getfield 28	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   1728: ifeq +164 -> 1892
    //   1731: aload 12
    //   1733: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1736: aload_0
    //   1737: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1740: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1743: ifne +8 -> 1751
    //   1746: iload 4
    //   1748: ifeq +144 -> 1892
    //   1751: aload_0
    //   1752: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1755: i2f
    //   1756: aload_0
    //   1757: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   1760: i2f
    //   1761: aload_0
    //   1762: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1765: getfield 192	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   1768: fmul
    //   1769: fcmpl
    //   1770: ifle +122 -> 1892
    //   1773: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1776: invokevirtual 202	android/media/MediaPlayer:reset	()V
    //   1779: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1782: aload 11
    //   1784: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1787: invokevirtual 208	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1790: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1793: invokevirtual 211	android/media/MediaPlayer:prepare	()V
    //   1796: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1799: ifeq +64 -> 1863
    //   1802: new 66	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1809: astore 12
    //   1811: aload 12
    //   1813: ldc_w 380
    //   1816: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: pop
    //   1820: aload 12
    //   1822: aload_0
    //   1823: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1826: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload 12
    //   1832: ldc_w 382
    //   1835: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: pop
    //   1839: aload 12
    //   1841: aload_0
    //   1842: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1845: invokestatic 385	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1848: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1851: pop
    //   1852: ldc 90
    //   1854: iconst_2
    //   1855: aload 12
    //   1857: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1863: aload_0
    //   1864: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1867: invokestatic 385	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1870: ifne +17 -> 1887
    //   1873: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1876: invokevirtual 214	android/media/MediaPlayer:start	()V
    //   1879: aload_0
    //   1880: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1883: iconst_2
    //   1884: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1887: aload_0
    //   1888: iconst_0
    //   1889: putfield 28	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   1892: aload 9
    //   1894: aload 10
    //   1896: invokevirtual 394	java/io/InputStream:read	([B)I
    //   1899: istore_2
    //   1900: iload_2
    //   1901: ifgt +80 -> 1981
    //   1904: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1907: ifeq +12 -> 1919
    //   1910: ldc 90
    //   1912: iconst_2
    //   1913: ldc_w 396
    //   1916: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1919: ldc2_w 321
    //   1922: invokestatic 326	java/lang/Thread:sleep	(J)V
    //   1925: goto +1321 -> 3246
    //   1928: astore 12
    //   1930: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1933: ifeq +1313 -> 3246
    //   1936: new 66	java/lang/StringBuilder
    //   1939: dup
    //   1940: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1943: astore 13
    //   1945: aload 13
    //   1947: ldc_w 398
    //   1950: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: aload 13
    //   1956: aload 12
    //   1958: invokevirtual 329	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1961: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: pop
    //   1965: ldc 90
    //   1967: iconst_2
    //   1968: aload 13
    //   1970: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1973: aload 12
    //   1975: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1978: goto +1268 -> 3246
    //   1981: aload_0
    //   1982: aload_0
    //   1983: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1986: iload_2
    //   1987: iadd
    //   1988: putfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   1991: aload 6
    //   1993: aload 10
    //   1995: iconst_0
    //   1996: iload_2
    //   1997: invokevirtual 402	java/io/RandomAccessFile:write	([BII)V
    //   2000: goto +1241 -> 3241
    //   2003: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2006: ifeq +96 -> 2102
    //   2009: new 66	java/lang/StringBuilder
    //   2012: dup
    //   2013: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2016: astore 8
    //   2018: aload 8
    //   2020: ldc_w 404
    //   2023: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 8
    //   2029: aload_0
    //   2030: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2033: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2036: pop
    //   2037: aload 8
    //   2039: ldc_w 406
    //   2042: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: pop
    //   2046: aload 8
    //   2048: iload_1
    //   2049: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2052: pop
    //   2053: aload 8
    //   2055: ldc_w 369
    //   2058: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2061: pop
    //   2062: aload 8
    //   2064: aload_0
    //   2065: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2068: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2071: pop
    //   2072: aload 8
    //   2074: ldc_w 367
    //   2077: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2080: pop
    //   2081: aload 8
    //   2083: aload_0
    //   2084: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Int	I
    //   2087: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2090: pop
    //   2091: ldc 90
    //   2093: iconst_2
    //   2094: aload 8
    //   2096: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2099: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2102: aload 9
    //   2104: ifnull +8 -> 2112
    //   2107: aload 9
    //   2109: invokevirtual 407	java/io/InputStream:close	()V
    //   2112: aload_0
    //   2113: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2116: aload_0
    //   2117: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2120: if_icmpne +17 -> 2137
    //   2123: aload_0
    //   2124: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2127: ifle +10 -> 2137
    //   2130: aload_0
    //   2131: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2134: invokestatic 409	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   2137: aload_0
    //   2138: iconst_0
    //   2139: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2142: aload 6
    //   2144: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   2147: aload_0
    //   2148: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2151: istore_1
    //   2152: aload_0
    //   2153: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2156: istore_2
    //   2157: iload_1
    //   2158: iload_2
    //   2159: if_icmpge +911 -> 3070
    //   2162: iload_2
    //   2163: ifle +907 -> 3070
    //   2166: goto +895 -> 3061
    //   2169: aload 7
    //   2171: astore 9
    //   2173: astore 7
    //   2175: goto +32 -> 2207
    //   2178: astore 7
    //   2180: goto +923 -> 3103
    //   2183: astore 8
    //   2185: aload 6
    //   2187: astore 7
    //   2189: goto +60 -> 2249
    //   2192: astore 8
    //   2194: aload 6
    //   2196: astore 7
    //   2198: goto +178 -> 2376
    //   2201: astore 7
    //   2203: aload 10
    //   2205: astore 9
    //   2207: aload 7
    //   2209: astore 8
    //   2211: aload 6
    //   2213: astore 7
    //   2215: goto +292 -> 2507
    //   2218: astore 8
    //   2220: aload 6
    //   2222: astore 7
    //   2224: goto +591 -> 2815
    //   2227: astore 8
    //   2229: aload 6
    //   2231: astore 7
    //   2233: goto +709 -> 2942
    //   2236: astore 7
    //   2238: aconst_null
    //   2239: astore 6
    //   2241: goto +862 -> 3103
    //   2244: astore 8
    //   2246: aconst_null
    //   2247: astore 7
    //   2249: aload 7
    //   2251: astore 6
    //   2253: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2256: ifeq +61 -> 2317
    //   2259: aload 7
    //   2261: astore 6
    //   2263: new 66	java/lang/StringBuilder
    //   2266: dup
    //   2267: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2270: astore 9
    //   2272: aload 7
    //   2274: astore 6
    //   2276: aload 9
    //   2278: ldc_w 411
    //   2281: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: pop
    //   2285: aload 7
    //   2287: astore 6
    //   2289: aload 9
    //   2291: aload 8
    //   2293: invokevirtual 412	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2296: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: pop
    //   2300: aload 7
    //   2302: astore 6
    //   2304: ldc 90
    //   2306: iconst_2
    //   2307: aload 9
    //   2309: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: aload 8
    //   2314: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2317: aload 7
    //   2319: astore 6
    //   2321: aload_0
    //   2322: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2325: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2328: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2331: aload_0
    //   2332: iconst_0
    //   2333: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2336: aload 7
    //   2338: ifnull +11 -> 2349
    //   2341: aload 7
    //   2343: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   2346: goto +3 -> 2349
    //   2349: aload_0
    //   2350: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2353: istore_1
    //   2354: aload_0
    //   2355: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2358: istore_2
    //   2359: iload_1
    //   2360: iload_2
    //   2361: if_icmpge +709 -> 3070
    //   2364: iload_2
    //   2365: ifle +705 -> 3070
    //   2368: goto +693 -> 3061
    //   2371: astore 8
    //   2373: aconst_null
    //   2374: astore 7
    //   2376: aload 7
    //   2378: astore 6
    //   2380: aload_0
    //   2381: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2384: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2387: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2390: aload 7
    //   2392: astore 6
    //   2394: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2397: ifeq +61 -> 2458
    //   2400: aload 7
    //   2402: astore 6
    //   2404: new 66	java/lang/StringBuilder
    //   2407: dup
    //   2408: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2411: astore 9
    //   2413: aload 7
    //   2415: astore 6
    //   2417: aload 9
    //   2419: ldc_w 414
    //   2422: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: pop
    //   2426: aload 7
    //   2428: astore 6
    //   2430: aload 9
    //   2432: aload 8
    //   2434: invokevirtual 415	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2437: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: pop
    //   2441: aload 7
    //   2443: astore 6
    //   2445: ldc 90
    //   2447: iconst_2
    //   2448: aload 9
    //   2450: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: aload 8
    //   2455: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2458: aload_0
    //   2459: iconst_0
    //   2460: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2463: aload 7
    //   2465: ifnull +11 -> 2476
    //   2468: aload 7
    //   2470: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   2473: goto +3 -> 2476
    //   2476: aload_0
    //   2477: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2480: istore_1
    //   2481: aload_0
    //   2482: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2485: istore_2
    //   2486: iload_1
    //   2487: iload_2
    //   2488: if_icmpge +582 -> 3070
    //   2491: iload_2
    //   2492: ifle +578 -> 3070
    //   2495: goto +566 -> 3061
    //   2498: astore 8
    //   2500: ldc 106
    //   2502: astore 9
    //   2504: aconst_null
    //   2505: astore 7
    //   2507: aload 7
    //   2509: astore 6
    //   2511: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2514: ifeq +61 -> 2575
    //   2517: aload 7
    //   2519: astore 6
    //   2521: new 66	java/lang/StringBuilder
    //   2524: dup
    //   2525: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2528: astore 10
    //   2530: aload 7
    //   2532: astore 6
    //   2534: aload 10
    //   2536: ldc_w 417
    //   2539: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: pop
    //   2543: aload 7
    //   2545: astore 6
    //   2547: aload 10
    //   2549: aload 8
    //   2551: invokevirtual 88	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2554: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: pop
    //   2558: aload 7
    //   2560: astore 6
    //   2562: ldc 90
    //   2564: iconst_2
    //   2565: aload 10
    //   2567: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2570: aload 8
    //   2572: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2575: aload 7
    //   2577: astore 6
    //   2579: invokestatic 154	com/tencent/mobileqq/music/QQPlayerService:e	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2582: astore 8
    //   2584: aload 8
    //   2586: ifnull +125 -> 2711
    //   2589: aload 7
    //   2591: astore 6
    //   2593: aload 8
    //   2595: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2598: astore 10
    //   2600: aload 7
    //   2602: astore 6
    //   2604: aload 10
    //   2606: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2609: ifne +644 -> 3253
    //   2612: aload 7
    //   2614: astore 6
    //   2616: aload 10
    //   2618: aload 9
    //   2620: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2623: ifeq +630 -> 3253
    //   2626: aload 7
    //   2628: astore 6
    //   2630: aload_0
    //   2631: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2634: aload_0
    //   2635: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2638: aload 8
    //   2640: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2643: invokestatic 185	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   2646: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2649: istore 4
    //   2651: goto +3 -> 2654
    //   2654: aload 7
    //   2656: astore 6
    //   2658: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2661: ifnull +50 -> 2711
    //   2664: aload 7
    //   2666: astore 6
    //   2668: aload_0
    //   2669: getfield 36	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2672: aload 8
    //   2674: getfield 170	com/tencent/mobileqq/music/SongInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2677: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2680: ifne +8 -> 2688
    //   2683: iload 4
    //   2685: ifeq +26 -> 2711
    //   2688: aload 7
    //   2690: astore 6
    //   2692: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2695: invokevirtual 202	android/media/MediaPlayer:reset	()V
    //   2698: aload 7
    //   2700: astore 6
    //   2702: aload_0
    //   2703: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2706: bipush 6
    //   2708: invokestatic 217	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2711: aload 7
    //   2713: astore 6
    //   2715: invokestatic 420	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2718: ifnull +52 -> 2770
    //   2721: aload 7
    //   2723: astore 6
    //   2725: invokestatic 420	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2728: arraylength
    //   2729: iconst_1
    //   2730: if_icmpne +40 -> 2770
    //   2733: aload 7
    //   2735: astore 6
    //   2737: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2740: ifeq +16 -> 2756
    //   2743: aload 7
    //   2745: astore 6
    //   2747: ldc 90
    //   2749: iconst_2
    //   2750: ldc_w 422
    //   2753: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2756: aload 7
    //   2758: astore 6
    //   2760: aload_0
    //   2761: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2764: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2767: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2770: aload_0
    //   2771: iconst_0
    //   2772: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2775: aload 7
    //   2777: ifnull +11 -> 2788
    //   2780: aload 7
    //   2782: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   2785: goto +3 -> 2788
    //   2788: aload_0
    //   2789: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2792: istore_1
    //   2793: aload_0
    //   2794: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2797: istore_2
    //   2798: iload_1
    //   2799: iload_2
    //   2800: if_icmpge +270 -> 3070
    //   2803: iload_2
    //   2804: ifle +266 -> 3070
    //   2807: goto +254 -> 3061
    //   2810: astore 8
    //   2812: aconst_null
    //   2813: astore 7
    //   2815: aload 7
    //   2817: astore 6
    //   2819: aload_0
    //   2820: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2823: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2826: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2829: aload 7
    //   2831: astore 6
    //   2833: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2836: ifeq +61 -> 2897
    //   2839: aload 7
    //   2841: astore 6
    //   2843: new 66	java/lang/StringBuilder
    //   2846: dup
    //   2847: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2850: astore 9
    //   2852: aload 7
    //   2854: astore 6
    //   2856: aload 9
    //   2858: ldc_w 424
    //   2861: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: pop
    //   2865: aload 7
    //   2867: astore 6
    //   2869: aload 9
    //   2871: aload 8
    //   2873: invokevirtual 425	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   2876: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: pop
    //   2880: aload 7
    //   2882: astore 6
    //   2884: ldc 90
    //   2886: iconst_2
    //   2887: aload 9
    //   2889: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2892: aload 8
    //   2894: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2897: aload_0
    //   2898: iconst_0
    //   2899: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   2902: aload 7
    //   2904: ifnull +11 -> 2915
    //   2907: aload 7
    //   2909: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   2912: goto +3 -> 2915
    //   2915: aload_0
    //   2916: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   2919: istore_1
    //   2920: aload_0
    //   2921: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   2924: istore_2
    //   2925: iload_1
    //   2926: iload_2
    //   2927: if_icmpge +143 -> 3070
    //   2930: iload_2
    //   2931: ifle +139 -> 3070
    //   2934: goto +127 -> 3061
    //   2937: astore 8
    //   2939: aconst_null
    //   2940: astore 7
    //   2942: aload 7
    //   2944: astore 6
    //   2946: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2949: ifeq +61 -> 3010
    //   2952: aload 7
    //   2954: astore 6
    //   2956: new 66	java/lang/StringBuilder
    //   2959: dup
    //   2960: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2963: astore 9
    //   2965: aload 7
    //   2967: astore 6
    //   2969: aload 9
    //   2971: ldc_w 427
    //   2974: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2977: pop
    //   2978: aload 7
    //   2980: astore 6
    //   2982: aload 9
    //   2984: aload 8
    //   2986: invokevirtual 428	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   2989: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2992: pop
    //   2993: aload 7
    //   2995: astore 6
    //   2997: ldc 90
    //   2999: iconst_2
    //   3000: aload 9
    //   3002: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3005: aload 8
    //   3007: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3010: aload 7
    //   3012: astore 6
    //   3014: aload_0
    //   3015: getfield 17	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   3018: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   3021: invokestatic 127	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   3024: aload_0
    //   3025: iconst_0
    //   3026: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3029: aload 7
    //   3031: ifnull +11 -> 3042
    //   3034: aload 7
    //   3036: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   3039: goto +3 -> 3042
    //   3042: aload_0
    //   3043: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3046: istore_1
    //   3047: aload_0
    //   3048: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3051: istore_2
    //   3052: iload_1
    //   3053: iload_2
    //   3054: if_icmpge +16 -> 3070
    //   3057: iload_2
    //   3058: ifle +12 -> 3070
    //   3061: aload_0
    //   3062: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3065: iload_1
    //   3066: iload_2
    //   3067: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   3070: aload_0
    //   3071: getfield 24	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   3074: ifeq +6 -> 3080
    //   3077: invokestatic 430	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   3080: aload_0
    //   3081: iconst_0
    //   3082: putfield 24	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Boolean	Z
    //   3085: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3088: ifeq +12 -> 3100
    //   3091: ldc 90
    //   3093: iconst_2
    //   3094: ldc_w 432
    //   3097: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3100: return
    //   3101: astore 7
    //   3103: aload_0
    //   3104: iconst_0
    //   3105: putfield 26	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_c_of_type_Boolean	Z
    //   3108: aload 6
    //   3110: ifnull +11 -> 3121
    //   3113: aload 6
    //   3115: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   3118: goto +3 -> 3121
    //   3121: aload_0
    //   3122: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_a_of_type_Int	I
    //   3125: istore_1
    //   3126: aload_0
    //   3127: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_Int	I
    //   3130: istore_2
    //   3131: iload_1
    //   3132: iload_2
    //   3133: if_icmpge +16 -> 3149
    //   3136: iload_2
    //   3137: ifle +12 -> 3149
    //   3140: aload_0
    //   3141: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3144: iload_1
    //   3145: iload_2
    //   3146: invokestatic 167	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   3149: goto +6 -> 3155
    //   3152: aload 7
    //   3154: athrow
    //   3155: goto -3 -> 3152
    //   3158: astore 6
    //   3160: goto -3007 -> 153
    //   3163: astore 6
    //   3165: goto -1999 -> 1166
    //   3168: astore 6
    //   3170: goto -1782 -> 1388
    //   3173: astore 6
    //   3175: goto -1480 -> 1695
    //   3178: astore 6
    //   3180: goto -1033 -> 2147
    //   3183: astore 6
    //   3185: goto -836 -> 2349
    //   3188: astore 6
    //   3190: goto -714 -> 2476
    //   3193: astore 6
    //   3195: goto -407 -> 2788
    //   3198: astore 6
    //   3200: goto -285 -> 2915
    //   3203: astore 6
    //   3205: goto -163 -> 3042
    //   3208: astore 6
    //   3210: goto -89 -> 3121
    //   3213: goto -2674 -> 539
    //   3216: goto -2312 -> 904
    //   3219: aload 10
    //   3221: astore 9
    //   3223: aload 12
    //   3225: astore 10
    //   3227: goto -2822 -> 405
    //   3230: goto -7 -> 3223
    //   3233: goto +3 -> 3236
    //   3236: iload_1
    //   3237: istore_2
    //   3238: goto -2114 -> 1124
    //   3241: iconst_0
    //   3242: istore_1
    //   3243: goto -1606 -> 1637
    //   3246: iload_1
    //   3247: iconst_1
    //   3248: iadd
    //   3249: istore_1
    //   3250: goto -1613 -> 1637
    //   3253: iconst_0
    //   3254: istore 4
    //   3256: goto -602 -> 2654
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3259	0	this	DownloadThread
    //   157	3093	1	i	int
    //   162	3076	2	j	int
    //   470	521	3	k	int
    //   215	3040	4	bool1	boolean
    //   288	1147	5	bool2	boolean
    //   7	3107	6	localObject1	Object
    //   3158	1	6	localIOException1	IOException
    //   3163	1	6	localIOException2	IOException
    //   3168	1	6	localIOException3	IOException
    //   3173	1	6	localIOException4	IOException
    //   3178	1	6	localIOException5	IOException
    //   3183	1	6	localIOException6	IOException
    //   3188	1	6	localIOException7	IOException
    //   3193	1	6	localIOException8	IOException
    //   3198	1	6	localIOException9	IOException
    //   3203	1	6	localIOException10	IOException
    //   3208	1	6	localIOException11	IOException
    //   2	2168	7	localObject2	Object
    //   2173	1	7	localIOException12	IOException
    //   2178	1	7	localObject3	Object
    //   2187	10	7	localObject4	Object
    //   2201	7	7	localIOException13	IOException
    //   2213	19	7	localObject5	Object
    //   2236	1	7	localObject6	Object
    //   2247	788	7	localObject7	Object
    //   3101	52	7	localObject8	Object
    //   122	1	8	str	String
    //   182	943	8	localIOException14	IOException
    //   1220	875	8	localObject9	Object
    //   2183	1	8	localException1	java.lang.Exception
    //   2192	1	8	localIllegalStateException1	java.lang.IllegalStateException
    //   2209	1	8	localIOException15	IOException
    //   2218	1	8	localMalformedURLException1	java.net.MalformedURLException
    //   2227	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   2244	69	8	localException2	java.lang.Exception
    //   2371	83	8	localIllegalStateException2	java.lang.IllegalStateException
    //   2498	73	8	localIOException16	IOException
    //   2582	91	8	localSongInfo	SongInfo
    //   2810	83	8	localMalformedURLException2	java.net.MalformedURLException
    //   2937	69	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   109	3113	9	localObject10	Object
    //   83	971	10	localObject11	Object
    //   1071	161	10	localInterruptedException1	java.lang.InterruptedException
    //   1528	1698	10	localObject12	Object
    //   58	1725	11	localFile	File
    //   118	1738	12	localObject13	Object
    //   1928	1296	12	localInterruptedException2	java.lang.InterruptedException
    //   94	1875	13	localObject14	Object
    //   204	588	14	localObject15	Object
    //   839	52	14	localInterruptedException3	java.lang.InterruptedException
    //   1086	26	14	localStringBuilder1	StringBuilder
    //   687	46	15	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	143	182	java/io/IOException
    //   222	250	182	java/io/IOException
    //   295	331	182	java/io/IOException
    //   331	373	182	java/io/IOException
    //   376	390	182	java/io/IOException
    //   390	398	182	java/io/IOException
    //   824	830	839	java/lang/InterruptedException
    //   1062	1068	1071	java/lang/InterruptedException
    //   1919	1925	1928	java/lang/InterruptedException
    //   471	536	2169	java/io/IOException
    //   539	553	2169	java/io/IOException
    //   558	619	2169	java/io/IOException
    //   624	799	2169	java/io/IOException
    //   799	809	2169	java/io/IOException
    //   812	820	2169	java/io/IOException
    //   824	830	2169	java/io/IOException
    //   847	895	2169	java/io/IOException
    //   904	920	2169	java/io/IOException
    //   924	941	2169	java/io/IOException
    //   947	990	2169	java/io/IOException
    //   999	1045	2169	java/io/IOException
    //   1062	1068	2169	java/io/IOException
    //   1073	1121	2169	java/io/IOException
    //   1132	1147	2169	java/io/IOException
    //   1147	1156	2169	java/io/IOException
    //   1197	1211	2169	java/io/IOException
    //   1211	1216	2169	java/io/IOException
    //   1222	1229	2169	java/io/IOException
    //   1235	1304	2169	java/io/IOException
    //   1304	1350	2169	java/io/IOException
    //   1354	1369	2169	java/io/IOException
    //   1369	1378	2169	java/io/IOException
    //   1417	1422	2169	java/io/IOException
    //   1422	1434	2169	java/io/IOException
    //   1439	1516	2169	java/io/IOException
    //   1516	1562	2169	java/io/IOException
    //   1566	1630	2169	java/io/IOException
    //   1637	1655	2169	java/io/IOException
    //   1661	1666	2169	java/io/IOException
    //   1671	1685	2169	java/io/IOException
    //   1724	1746	2169	java/io/IOException
    //   1751	1863	2169	java/io/IOException
    //   1863	1887	2169	java/io/IOException
    //   1887	1892	2169	java/io/IOException
    //   1892	1900	2169	java/io/IOException
    //   1904	1919	2169	java/io/IOException
    //   1919	1925	2169	java/io/IOException
    //   1930	1978	2169	java/io/IOException
    //   1981	2000	2169	java/io/IOException
    //   2003	2102	2169	java/io/IOException
    //   2107	2112	2169	java/io/IOException
    //   2112	2137	2169	java/io/IOException
    //   85	96	2178	finally
    //   100	111	2178	finally
    //   115	120	2178	finally
    //   129	143	2178	finally
    //   199	206	2178	finally
    //   210	217	2178	finally
    //   222	250	2178	finally
    //   260	275	2178	finally
    //   284	290	2178	finally
    //   295	331	2178	finally
    //   331	373	2178	finally
    //   376	390	2178	finally
    //   390	398	2178	finally
    //   418	428	2178	finally
    //   432	438	2178	finally
    //   442	451	2178	finally
    //   455	462	2178	finally
    //   466	471	2178	finally
    //   471	536	2178	finally
    //   539	553	2178	finally
    //   558	619	2178	finally
    //   624	799	2178	finally
    //   799	809	2178	finally
    //   812	820	2178	finally
    //   824	830	2178	finally
    //   847	895	2178	finally
    //   904	920	2178	finally
    //   924	941	2178	finally
    //   947	990	2178	finally
    //   999	1045	2178	finally
    //   1062	1068	2178	finally
    //   1073	1121	2178	finally
    //   1132	1147	2178	finally
    //   1147	1156	2178	finally
    //   1197	1211	2178	finally
    //   1211	1216	2178	finally
    //   1222	1229	2178	finally
    //   1235	1304	2178	finally
    //   1304	1350	2178	finally
    //   1354	1369	2178	finally
    //   1369	1378	2178	finally
    //   1417	1422	2178	finally
    //   1422	1434	2178	finally
    //   1439	1516	2178	finally
    //   1516	1562	2178	finally
    //   1566	1630	2178	finally
    //   1637	1655	2178	finally
    //   1661	1666	2178	finally
    //   1671	1685	2178	finally
    //   1724	1746	2178	finally
    //   1751	1863	2178	finally
    //   1863	1887	2178	finally
    //   1887	1892	2178	finally
    //   1892	1900	2178	finally
    //   1904	1919	2178	finally
    //   1919	1925	2178	finally
    //   1930	1978	2178	finally
    //   1981	2000	2178	finally
    //   2003	2102	2178	finally
    //   2107	2112	2178	finally
    //   2112	2137	2178	finally
    //   85	96	2183	java/lang/Exception
    //   100	111	2183	java/lang/Exception
    //   115	120	2183	java/lang/Exception
    //   129	143	2183	java/lang/Exception
    //   199	206	2183	java/lang/Exception
    //   210	217	2183	java/lang/Exception
    //   222	250	2183	java/lang/Exception
    //   260	275	2183	java/lang/Exception
    //   284	290	2183	java/lang/Exception
    //   295	331	2183	java/lang/Exception
    //   331	373	2183	java/lang/Exception
    //   376	390	2183	java/lang/Exception
    //   390	398	2183	java/lang/Exception
    //   418	428	2183	java/lang/Exception
    //   432	438	2183	java/lang/Exception
    //   442	451	2183	java/lang/Exception
    //   455	462	2183	java/lang/Exception
    //   466	471	2183	java/lang/Exception
    //   471	536	2183	java/lang/Exception
    //   539	553	2183	java/lang/Exception
    //   558	619	2183	java/lang/Exception
    //   624	799	2183	java/lang/Exception
    //   799	809	2183	java/lang/Exception
    //   812	820	2183	java/lang/Exception
    //   824	830	2183	java/lang/Exception
    //   847	895	2183	java/lang/Exception
    //   904	920	2183	java/lang/Exception
    //   924	941	2183	java/lang/Exception
    //   947	990	2183	java/lang/Exception
    //   999	1045	2183	java/lang/Exception
    //   1062	1068	2183	java/lang/Exception
    //   1073	1121	2183	java/lang/Exception
    //   1132	1147	2183	java/lang/Exception
    //   1147	1156	2183	java/lang/Exception
    //   1197	1211	2183	java/lang/Exception
    //   1211	1216	2183	java/lang/Exception
    //   1222	1229	2183	java/lang/Exception
    //   1235	1304	2183	java/lang/Exception
    //   1304	1350	2183	java/lang/Exception
    //   1354	1369	2183	java/lang/Exception
    //   1369	1378	2183	java/lang/Exception
    //   1417	1422	2183	java/lang/Exception
    //   1422	1434	2183	java/lang/Exception
    //   1439	1516	2183	java/lang/Exception
    //   1516	1562	2183	java/lang/Exception
    //   1566	1630	2183	java/lang/Exception
    //   1637	1655	2183	java/lang/Exception
    //   1661	1666	2183	java/lang/Exception
    //   1671	1685	2183	java/lang/Exception
    //   1724	1746	2183	java/lang/Exception
    //   1751	1863	2183	java/lang/Exception
    //   1863	1887	2183	java/lang/Exception
    //   1887	1892	2183	java/lang/Exception
    //   1892	1900	2183	java/lang/Exception
    //   1904	1919	2183	java/lang/Exception
    //   1919	1925	2183	java/lang/Exception
    //   1930	1978	2183	java/lang/Exception
    //   1981	2000	2183	java/lang/Exception
    //   2003	2102	2183	java/lang/Exception
    //   2107	2112	2183	java/lang/Exception
    //   2112	2137	2183	java/lang/Exception
    //   85	96	2192	java/lang/IllegalStateException
    //   100	111	2192	java/lang/IllegalStateException
    //   115	120	2192	java/lang/IllegalStateException
    //   129	143	2192	java/lang/IllegalStateException
    //   199	206	2192	java/lang/IllegalStateException
    //   210	217	2192	java/lang/IllegalStateException
    //   222	250	2192	java/lang/IllegalStateException
    //   260	275	2192	java/lang/IllegalStateException
    //   284	290	2192	java/lang/IllegalStateException
    //   295	331	2192	java/lang/IllegalStateException
    //   331	373	2192	java/lang/IllegalStateException
    //   376	390	2192	java/lang/IllegalStateException
    //   390	398	2192	java/lang/IllegalStateException
    //   418	428	2192	java/lang/IllegalStateException
    //   432	438	2192	java/lang/IllegalStateException
    //   442	451	2192	java/lang/IllegalStateException
    //   455	462	2192	java/lang/IllegalStateException
    //   466	471	2192	java/lang/IllegalStateException
    //   471	536	2192	java/lang/IllegalStateException
    //   539	553	2192	java/lang/IllegalStateException
    //   558	619	2192	java/lang/IllegalStateException
    //   624	799	2192	java/lang/IllegalStateException
    //   799	809	2192	java/lang/IllegalStateException
    //   812	820	2192	java/lang/IllegalStateException
    //   824	830	2192	java/lang/IllegalStateException
    //   847	895	2192	java/lang/IllegalStateException
    //   904	920	2192	java/lang/IllegalStateException
    //   924	941	2192	java/lang/IllegalStateException
    //   947	990	2192	java/lang/IllegalStateException
    //   999	1045	2192	java/lang/IllegalStateException
    //   1062	1068	2192	java/lang/IllegalStateException
    //   1073	1121	2192	java/lang/IllegalStateException
    //   1132	1147	2192	java/lang/IllegalStateException
    //   1147	1156	2192	java/lang/IllegalStateException
    //   1197	1211	2192	java/lang/IllegalStateException
    //   1211	1216	2192	java/lang/IllegalStateException
    //   1222	1229	2192	java/lang/IllegalStateException
    //   1235	1304	2192	java/lang/IllegalStateException
    //   1304	1350	2192	java/lang/IllegalStateException
    //   1354	1369	2192	java/lang/IllegalStateException
    //   1369	1378	2192	java/lang/IllegalStateException
    //   1417	1422	2192	java/lang/IllegalStateException
    //   1422	1434	2192	java/lang/IllegalStateException
    //   1439	1516	2192	java/lang/IllegalStateException
    //   1516	1562	2192	java/lang/IllegalStateException
    //   1566	1630	2192	java/lang/IllegalStateException
    //   1637	1655	2192	java/lang/IllegalStateException
    //   1661	1666	2192	java/lang/IllegalStateException
    //   1671	1685	2192	java/lang/IllegalStateException
    //   1724	1746	2192	java/lang/IllegalStateException
    //   1751	1863	2192	java/lang/IllegalStateException
    //   1863	1887	2192	java/lang/IllegalStateException
    //   1887	1892	2192	java/lang/IllegalStateException
    //   1892	1900	2192	java/lang/IllegalStateException
    //   1904	1919	2192	java/lang/IllegalStateException
    //   1919	1925	2192	java/lang/IllegalStateException
    //   1930	1978	2192	java/lang/IllegalStateException
    //   1981	2000	2192	java/lang/IllegalStateException
    //   2003	2102	2192	java/lang/IllegalStateException
    //   2107	2112	2192	java/lang/IllegalStateException
    //   2112	2137	2192	java/lang/IllegalStateException
    //   85	96	2201	java/io/IOException
    //   100	111	2201	java/io/IOException
    //   115	120	2201	java/io/IOException
    //   199	206	2201	java/io/IOException
    //   210	217	2201	java/io/IOException
    //   260	275	2201	java/io/IOException
    //   284	290	2201	java/io/IOException
    //   418	428	2201	java/io/IOException
    //   432	438	2201	java/io/IOException
    //   442	451	2201	java/io/IOException
    //   455	462	2201	java/io/IOException
    //   466	471	2201	java/io/IOException
    //   85	96	2218	java/net/MalformedURLException
    //   100	111	2218	java/net/MalformedURLException
    //   115	120	2218	java/net/MalformedURLException
    //   129	143	2218	java/net/MalformedURLException
    //   199	206	2218	java/net/MalformedURLException
    //   210	217	2218	java/net/MalformedURLException
    //   222	250	2218	java/net/MalformedURLException
    //   260	275	2218	java/net/MalformedURLException
    //   284	290	2218	java/net/MalformedURLException
    //   295	331	2218	java/net/MalformedURLException
    //   331	373	2218	java/net/MalformedURLException
    //   376	390	2218	java/net/MalformedURLException
    //   390	398	2218	java/net/MalformedURLException
    //   418	428	2218	java/net/MalformedURLException
    //   432	438	2218	java/net/MalformedURLException
    //   442	451	2218	java/net/MalformedURLException
    //   455	462	2218	java/net/MalformedURLException
    //   466	471	2218	java/net/MalformedURLException
    //   471	536	2218	java/net/MalformedURLException
    //   539	553	2218	java/net/MalformedURLException
    //   558	619	2218	java/net/MalformedURLException
    //   624	799	2218	java/net/MalformedURLException
    //   799	809	2218	java/net/MalformedURLException
    //   812	820	2218	java/net/MalformedURLException
    //   824	830	2218	java/net/MalformedURLException
    //   847	895	2218	java/net/MalformedURLException
    //   904	920	2218	java/net/MalformedURLException
    //   924	941	2218	java/net/MalformedURLException
    //   947	990	2218	java/net/MalformedURLException
    //   999	1045	2218	java/net/MalformedURLException
    //   1062	1068	2218	java/net/MalformedURLException
    //   1073	1121	2218	java/net/MalformedURLException
    //   1132	1147	2218	java/net/MalformedURLException
    //   1147	1156	2218	java/net/MalformedURLException
    //   1197	1211	2218	java/net/MalformedURLException
    //   1211	1216	2218	java/net/MalformedURLException
    //   1222	1229	2218	java/net/MalformedURLException
    //   1235	1304	2218	java/net/MalformedURLException
    //   1304	1350	2218	java/net/MalformedURLException
    //   1354	1369	2218	java/net/MalformedURLException
    //   1369	1378	2218	java/net/MalformedURLException
    //   1417	1422	2218	java/net/MalformedURLException
    //   1422	1434	2218	java/net/MalformedURLException
    //   1439	1516	2218	java/net/MalformedURLException
    //   1516	1562	2218	java/net/MalformedURLException
    //   1566	1630	2218	java/net/MalformedURLException
    //   1637	1655	2218	java/net/MalformedURLException
    //   1661	1666	2218	java/net/MalformedURLException
    //   1671	1685	2218	java/net/MalformedURLException
    //   1724	1746	2218	java/net/MalformedURLException
    //   1751	1863	2218	java/net/MalformedURLException
    //   1863	1887	2218	java/net/MalformedURLException
    //   1887	1892	2218	java/net/MalformedURLException
    //   1892	1900	2218	java/net/MalformedURLException
    //   1904	1919	2218	java/net/MalformedURLException
    //   1919	1925	2218	java/net/MalformedURLException
    //   1930	1978	2218	java/net/MalformedURLException
    //   1981	2000	2218	java/net/MalformedURLException
    //   2003	2102	2218	java/net/MalformedURLException
    //   2107	2112	2218	java/net/MalformedURLException
    //   2112	2137	2218	java/net/MalformedURLException
    //   85	96	2227	java/io/FileNotFoundException
    //   100	111	2227	java/io/FileNotFoundException
    //   115	120	2227	java/io/FileNotFoundException
    //   129	143	2227	java/io/FileNotFoundException
    //   199	206	2227	java/io/FileNotFoundException
    //   210	217	2227	java/io/FileNotFoundException
    //   222	250	2227	java/io/FileNotFoundException
    //   260	275	2227	java/io/FileNotFoundException
    //   284	290	2227	java/io/FileNotFoundException
    //   295	331	2227	java/io/FileNotFoundException
    //   331	373	2227	java/io/FileNotFoundException
    //   376	390	2227	java/io/FileNotFoundException
    //   390	398	2227	java/io/FileNotFoundException
    //   418	428	2227	java/io/FileNotFoundException
    //   432	438	2227	java/io/FileNotFoundException
    //   442	451	2227	java/io/FileNotFoundException
    //   455	462	2227	java/io/FileNotFoundException
    //   466	471	2227	java/io/FileNotFoundException
    //   471	536	2227	java/io/FileNotFoundException
    //   539	553	2227	java/io/FileNotFoundException
    //   558	619	2227	java/io/FileNotFoundException
    //   624	799	2227	java/io/FileNotFoundException
    //   799	809	2227	java/io/FileNotFoundException
    //   812	820	2227	java/io/FileNotFoundException
    //   824	830	2227	java/io/FileNotFoundException
    //   847	895	2227	java/io/FileNotFoundException
    //   904	920	2227	java/io/FileNotFoundException
    //   924	941	2227	java/io/FileNotFoundException
    //   947	990	2227	java/io/FileNotFoundException
    //   999	1045	2227	java/io/FileNotFoundException
    //   1062	1068	2227	java/io/FileNotFoundException
    //   1073	1121	2227	java/io/FileNotFoundException
    //   1132	1147	2227	java/io/FileNotFoundException
    //   1147	1156	2227	java/io/FileNotFoundException
    //   1197	1211	2227	java/io/FileNotFoundException
    //   1211	1216	2227	java/io/FileNotFoundException
    //   1222	1229	2227	java/io/FileNotFoundException
    //   1235	1304	2227	java/io/FileNotFoundException
    //   1304	1350	2227	java/io/FileNotFoundException
    //   1354	1369	2227	java/io/FileNotFoundException
    //   1369	1378	2227	java/io/FileNotFoundException
    //   1417	1422	2227	java/io/FileNotFoundException
    //   1422	1434	2227	java/io/FileNotFoundException
    //   1439	1516	2227	java/io/FileNotFoundException
    //   1516	1562	2227	java/io/FileNotFoundException
    //   1566	1630	2227	java/io/FileNotFoundException
    //   1637	1655	2227	java/io/FileNotFoundException
    //   1661	1666	2227	java/io/FileNotFoundException
    //   1671	1685	2227	java/io/FileNotFoundException
    //   1724	1746	2227	java/io/FileNotFoundException
    //   1751	1863	2227	java/io/FileNotFoundException
    //   1863	1887	2227	java/io/FileNotFoundException
    //   1887	1892	2227	java/io/FileNotFoundException
    //   1892	1900	2227	java/io/FileNotFoundException
    //   1904	1919	2227	java/io/FileNotFoundException
    //   1919	1925	2227	java/io/FileNotFoundException
    //   1930	1978	2227	java/io/FileNotFoundException
    //   1981	2000	2227	java/io/FileNotFoundException
    //   2003	2102	2227	java/io/FileNotFoundException
    //   2107	2112	2227	java/io/FileNotFoundException
    //   2112	2137	2227	java/io/FileNotFoundException
    //   65	81	2236	finally
    //   65	81	2244	java/lang/Exception
    //   65	81	2371	java/lang/IllegalStateException
    //   65	81	2498	java/io/IOException
    //   65	81	2810	java/net/MalformedURLException
    //   65	81	2937	java/io/FileNotFoundException
    //   2253	2259	3101	finally
    //   2263	2272	3101	finally
    //   2276	2285	3101	finally
    //   2289	2300	3101	finally
    //   2304	2317	3101	finally
    //   2321	2331	3101	finally
    //   2380	2390	3101	finally
    //   2394	2400	3101	finally
    //   2404	2413	3101	finally
    //   2417	2426	3101	finally
    //   2430	2441	3101	finally
    //   2445	2458	3101	finally
    //   2511	2517	3101	finally
    //   2521	2530	3101	finally
    //   2534	2543	3101	finally
    //   2547	2558	3101	finally
    //   2562	2575	3101	finally
    //   2579	2584	3101	finally
    //   2593	2600	3101	finally
    //   2604	2612	3101	finally
    //   2616	2626	3101	finally
    //   2630	2651	3101	finally
    //   2658	2664	3101	finally
    //   2668	2683	3101	finally
    //   2692	2698	3101	finally
    //   2702	2711	3101	finally
    //   2715	2721	3101	finally
    //   2725	2733	3101	finally
    //   2737	2743	3101	finally
    //   2747	2756	3101	finally
    //   2760	2770	3101	finally
    //   2819	2829	3101	finally
    //   2833	2839	3101	finally
    //   2843	2852	3101	finally
    //   2856	2865	3101	finally
    //   2869	2880	3101	finally
    //   2884	2897	3101	finally
    //   2946	2952	3101	finally
    //   2956	2965	3101	finally
    //   2969	2978	3101	finally
    //   2982	2993	3101	finally
    //   2997	3010	3101	finally
    //   3014	3024	3101	finally
    //   148	153	3158	java/io/IOException
    //   1161	1166	3163	java/io/IOException
    //   1383	1388	3168	java/io/IOException
    //   1690	1695	3173	java/io/IOException
    //   2142	2147	3178	java/io/IOException
    //   2341	2346	3183	java/io/IOException
    //   2468	2473	3188	java/io/IOException
    //   2780	2785	3193	java/io/IOException
    //   2907	2912	3198	java/io/IOException
    //   3034	3039	3203	java/io/IOException
    //   3113	3118	3208	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.DownloadThread
 * JD-Core Version:    0.7.0.1
 */