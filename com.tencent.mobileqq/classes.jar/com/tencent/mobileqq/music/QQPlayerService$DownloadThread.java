package com.tencent.mobileqq.music;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class QQPlayerService$DownloadThread
  extends Thread
{
  public String a;
  public String b;
  public volatile boolean c = false;
  public volatile boolean d = false;
  public int e;
  public int f;
  public volatile boolean g = false;
  public volatile boolean h = true;
  private int i;
  
  public QQPlayerService$DownloadThread(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    setName("QQPlayerService-DownloadThread");
    this.a = paramString1;
    this.b = paramString2;
    this.i = paramInt2;
    this.f = paramInt2;
    this.e = paramInt1;
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
    //   0: ldc 111
    //   2: astore 7
    //   4: invokestatic 117	com/tencent/mobileqq/utils/DeviceInfoUtil:q	()[J
    //   7: astore 6
    //   9: aload 6
    //   11: ifnull +39 -> 50
    //   14: aload 6
    //   16: iconst_1
    //   17: laload
    //   18: ldc2_w 118
    //   21: lcmp
    //   22: ifgt +28 -> 50
    //   25: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 95
    //   33: iconst_2
    //   34: ldc 121
    //   36: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   43: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   46: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   49: return
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   55: invokespecial 135	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	(Ljava/lang/String;)Ljava/io/File;
    //   58: astore 11
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   65: new 137	java/io/RandomAccessFile
    //   68: dup
    //   69: aload 11
    //   71: invokevirtual 140	java/io/File:getPath	()Ljava/lang/String;
    //   74: ldc 142
    //   76: invokespecial 145	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: astore 6
    //   81: aload 7
    //   83: astore 10
    //   85: ldc 147
    //   87: aload_0
    //   88: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   91: invokestatic 153	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 13
    //   96: aload 7
    //   98: astore 10
    //   100: new 155	java/net/URL
    //   103: dup
    //   104: aload 13
    //   106: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;)V
    //   109: astore 9
    //   111: aload 7
    //   113: astore 10
    //   115: invokestatic 160	com/tencent/mobileqq/music/QQPlayerService:s	()Lcom/tencent/mobileqq/music/SongInfo;
    //   118: astore 12
    //   120: ldc 162
    //   122: astore 8
    //   124: aload 12
    //   126: ifnonnull +69 -> 195
    //   129: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +11 -> 143
    //   135: ldc 95
    //   137: iconst_2
    //   138: ldc 162
    //   140: invokestatic 164	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: iconst_0
    //   145: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   148: aload 6
    //   150: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   153: aload_0
    //   154: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   157: istore_1
    //   158: aload_0
    //   159: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   162: istore_2
    //   163: iload_1
    //   164: iload_2
    //   165: if_icmpge +16 -> 181
    //   168: iload_2
    //   169: ifle +12 -> 181
    //   172: aload_0
    //   173: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   176: iload_1
    //   177: iload_2
    //   178: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   181: return
    //   182: astore 8
    //   184: ldc 111
    //   186: astore 9
    //   188: aload 6
    //   190: astore 7
    //   192: goto +2319 -> 2511
    //   195: aload 7
    //   197: astore 10
    //   199: aload 12
    //   201: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   204: astore 14
    //   206: aload 7
    //   208: astore 10
    //   210: aload 14
    //   212: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: istore 4
    //   217: iload 4
    //   219: ifne +34 -> 253
    //   222: aload 14
    //   224: ldc 111
    //   226: invokevirtual 188	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   229: ifeq +24 -> 253
    //   232: aload_0
    //   233: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   236: aload_0
    //   237: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   240: aload 14
    //   242: invokestatic 191	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: istore 4
    //   250: goto +6 -> 256
    //   253: iconst_0
    //   254: istore 4
    //   256: aload 7
    //   258: astore 10
    //   260: aload 12
    //   262: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   269: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifne +8 -> 280
    //   275: iload 4
    //   277: ifeq +121 -> 398
    //   280: aload 7
    //   282: astore 10
    //   284: aload_0
    //   285: getfield 33	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:h	Z
    //   288: istore 5
    //   290: iload 5
    //   292: ifeq +106 -> 398
    //   295: aload_0
    //   296: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   299: i2f
    //   300: aload_0
    //   301: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   304: i2f
    //   305: aload_0
    //   306: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   309: getfield 198	com/tencent/mobileqq/music/QQPlayerService:e	F
    //   312: fmul
    //   313: fcmpl
    //   314: ifle +62 -> 376
    //   317: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +11 -> 331
    //   323: ldc 95
    //   325: iconst_2
    //   326: ldc 200
    //   328: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   334: invokevirtual 209	android/media/MediaPlayer:reset	()V
    //   337: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   340: aload 11
    //   342: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   345: invokevirtual 215	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   348: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   351: invokevirtual 218	android/media/MediaPlayer:prepare	()V
    //   354: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   357: invokevirtual 221	android/media/MediaPlayer:start	()V
    //   360: aload_0
    //   361: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   364: iconst_2
    //   365: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   368: aload_0
    //   369: iconst_0
    //   370: putfield 33	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:h	Z
    //   373: goto +25 -> 398
    //   376: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +11 -> 390
    //   382: ldc 95
    //   384: iconst_2
    //   385: ldc 226
    //   387: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   394: iconst_1
    //   395: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   398: iconst_0
    //   399: istore_1
    //   400: iconst_0
    //   401: istore_2
    //   402: aconst_null
    //   403: astore 10
    //   405: iload_1
    //   406: ifgt +2834 -> 3240
    //   409: iload_2
    //   410: iconst_5
    //   411: if_icmpgt +2826 -> 3237
    //   414: aload 7
    //   416: astore 10
    //   418: aload 9
    //   420: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   423: checkcast 232	java/net/HttpURLConnection
    //   426: astore 12
    //   428: aload 7
    //   430: astore 10
    //   432: aload 12
    //   434: iconst_0
    //   435: invokevirtual 236	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   438: aload 7
    //   440: astore 10
    //   442: aload 12
    //   444: ldc 238
    //   446: ldc 240
    //   448: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload 7
    //   453: astore 10
    //   455: aload_0
    //   456: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   459: ifeq +2758 -> 3217
    //   462: aload 7
    //   464: astore 10
    //   466: aload_0
    //   467: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   470: istore_3
    //   471: iload_3
    //   472: aload_0
    //   473: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   476: if_icmple +2741 -> 3217
    //   479: new 71	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   486: astore 10
    //   488: aload 10
    //   490: ldc 245
    //   492: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 10
    //   498: aload_0
    //   499: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   502: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 10
    //   508: ldc 250
    //   510: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 10
    //   516: aload_0
    //   517: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   520: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 12
    //   526: ldc 252
    //   528: aload 10
    //   530: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto +3 -> 539
    //   539: aload 9
    //   541: invokevirtual 255	java/net/URL:getHost	()Ljava/lang/String;
    //   544: astore 10
    //   546: aload 10
    //   548: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   551: istore 5
    //   553: iload 5
    //   555: ifne +2665 -> 3220
    //   558: aload 10
    //   560: ldc_w 257
    //   563: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   566: ifeq +2654 -> 3220
    //   569: getstatic 266	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   572: aconst_null
    //   573: invokevirtual 270	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   576: astore 10
    //   578: aload 10
    //   580: iconst_2
    //   581: invokevirtual 276	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   584: checkcast 278	mqq/manager/TicketManager
    //   587: astore 14
    //   589: aload 10
    //   591: invokevirtual 281	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   594: astore 10
    //   596: aload 14
    //   598: aload 10
    //   600: ldc2_w 282
    //   603: iconst_1
    //   604: anewarray 184	java/lang/String
    //   607: dup
    //   608: iconst_0
    //   609: ldc_w 257
    //   612: aastore
    //   613: aconst_null
    //   614: invokeinterface 287 6 0
    //   619: astore 14
    //   621: aload 14
    //   623: ifnull +193 -> 816
    //   626: aload 14
    //   628: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   631: ifnull +185 -> 816
    //   634: aload 14
    //   636: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   639: ldc_w 257
    //   642: invokeinterface 299 2 0
    //   647: ifnull +169 -> 816
    //   650: ldc 95
    //   652: iconst_1
    //   653: ldc_w 301
    //   656: invokestatic 164	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: new 184	java/lang/String
    //   662: dup
    //   663: aload 14
    //   665: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   668: ldc_w 257
    //   671: invokeinterface 299 2 0
    //   676: checkcast 303	[B
    //   679: invokespecial 306	java/lang/String:<init>	([B)V
    //   682: astore 14
    //   684: new 71	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   691: astore 15
    //   693: aload 15
    //   695: ldc_w 308
    //   698: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 15
    //   704: aload 14
    //   706: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 15
    //   712: ldc_w 310
    //   715: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 15
    //   721: aload 10
    //   723: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 15
    //   729: ldc_w 312
    //   732: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 15
    //   738: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: astore 10
    //   743: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq +57 -> 803
    //   749: new 71	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   756: astore 14
    //   758: aload 14
    //   760: ldc_w 314
    //   763: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 14
    //   769: aload 13
    //   771: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload 14
    //   777: ldc_w 316
    //   780: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 14
    //   786: aload 10
    //   788: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: ldc 95
    //   794: iconst_1
    //   795: aload 14
    //   797: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: aload 12
    //   805: ldc_w 320
    //   808: aload 10
    //   810: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: goto +95 -> 908
    //   816: ldc 95
    //   818: ldc_w 322
    //   821: invokestatic 327	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: iload_2
    //   825: iconst_1
    //   826: iadd
    //   827: istore_3
    //   828: ldc2_w 328
    //   831: invokestatic 333	java/lang/Thread:sleep	(J)V
    //   834: iload_3
    //   835: istore_2
    //   836: aload 9
    //   838: astore 10
    //   840: goto +2383 -> 3223
    //   843: astore 14
    //   845: iload_3
    //   846: istore_2
    //   847: aload 9
    //   849: astore 10
    //   851: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq +2369 -> 3223
    //   857: new 71	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   864: astore 10
    //   866: aload 10
    //   868: ldc_w 335
    //   871: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 10
    //   877: aload 14
    //   879: invokevirtual 336	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   882: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: ldc 95
    //   888: iconst_2
    //   889: aload 10
    //   891: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: aload 14
    //   896: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   899: iload_3
    //   900: istore_2
    //   901: aload 9
    //   903: astore 10
    //   905: goto +2318 -> 3223
    //   908: aload 12
    //   910: invokevirtual 339	java/net/HttpURLConnection:connect	()V
    //   913: aload 12
    //   915: invokevirtual 343	java/net/HttpURLConnection:getResponseCode	()I
    //   918: sipush 302
    //   921: if_icmpne +82 -> 1003
    //   924: iload_2
    //   925: iconst_1
    //   926: iadd
    //   927: istore_3
    //   928: new 155	java/net/URL
    //   931: dup
    //   932: aload 12
    //   934: ldc_w 345
    //   937: invokevirtual 349	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   940: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;)V
    //   943: astore 9
    //   945: iload_3
    //   946: istore_2
    //   947: aload 9
    //   949: astore 10
    //   951: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +2269 -> 3223
    //   957: new 71	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   964: astore 10
    //   966: aload 10
    //   968: ldc_w 351
    //   971: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload 10
    //   977: aload 9
    //   979: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: ldc 95
    //   985: iconst_1
    //   986: aload 10
    //   988: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: iload_3
    //   995: istore_2
    //   996: aload 9
    //   998: astore 10
    //   1000: goto +2223 -> 3223
    //   1003: new 71	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1010: astore 10
    //   1012: aload 10
    //   1014: ldc_w 356
    //   1017: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 10
    //   1023: aload 12
    //   1025: invokevirtual 343	java/net/HttpURLConnection:getResponseCode	()I
    //   1028: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: ldc 95
    //   1034: iconst_1
    //   1035: aload 10
    //   1037: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 164	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: aload 12
    //   1045: invokevirtual 359	java/net/HttpURLConnection:getContentLength	()I
    //   1048: istore_1
    //   1049: iload_1
    //   1050: ifle +12 -> 1062
    //   1053: iload_1
    //   1054: istore_2
    //   1055: aload 12
    //   1057: astore 10
    //   1059: goto +69 -> 1128
    //   1062: iload_2
    //   1063: iconst_1
    //   1064: iadd
    //   1065: istore_2
    //   1066: ldc2_w 328
    //   1069: invokestatic 333	java/lang/Thread:sleep	(J)V
    //   1072: goto +2162 -> 3234
    //   1075: astore 10
    //   1077: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1080: ifeq +2154 -> 3234
    //   1083: new 71	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1090: astore 14
    //   1092: aload 14
    //   1094: ldc_w 335
    //   1097: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload 14
    //   1103: aload 10
    //   1105: invokevirtual 336	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1108: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: pop
    //   1112: ldc 95
    //   1114: iconst_2
    //   1115: aload 14
    //   1117: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: aload 10
    //   1122: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1125: goto +2109 -> 3234
    //   1128: aload 8
    //   1130: astore 12
    //   1132: iload_2
    //   1133: ifgt +66 -> 1199
    //   1136: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1139: ifeq +12 -> 1151
    //   1142: ldc 95
    //   1144: iconst_2
    //   1145: ldc_w 361
    //   1148: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1151: aload_0
    //   1152: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1155: bipush 7
    //   1157: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1160: aload_0
    //   1161: iconst_0
    //   1162: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   1165: aload 6
    //   1167: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   1170: aload_0
    //   1171: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1174: istore_1
    //   1175: aload_0
    //   1176: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1179: istore_2
    //   1180: iload_1
    //   1181: iload_2
    //   1182: if_icmpge +16 -> 1198
    //   1185: iload_2
    //   1186: ifle +12 -> 1198
    //   1189: aload_0
    //   1190: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   1193: iload_1
    //   1194: iload_2
    //   1195: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1198: return
    //   1199: iload_2
    //   1200: istore_1
    //   1201: aload_0
    //   1202: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1205: ifle +10 -> 1215
    //   1208: iload_2
    //   1209: aload_0
    //   1210: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1213: iadd
    //   1214: istore_1
    //   1215: aload_0
    //   1216: iload_1
    //   1217: putfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1220: iload_1
    //   1221: istore_2
    //   1222: aload 10
    //   1224: astore 8
    //   1226: aload_0
    //   1227: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   1230: ifeq +196 -> 1426
    //   1233: iload_1
    //   1234: istore_2
    //   1235: aload 10
    //   1237: astore 8
    //   1239: aload_0
    //   1240: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   1243: iload_1
    //   1244: if_icmpeq +182 -> 1426
    //   1247: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1250: ifeq +58 -> 1308
    //   1253: new 71	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1260: astore 8
    //   1262: aload 8
    //   1264: ldc_w 363
    //   1267: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 8
    //   1273: aload_0
    //   1274: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   1277: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 8
    //   1283: ldc_w 365
    //   1286: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload 8
    //   1292: iload_1
    //   1293: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: ldc 95
    //   1299: iconst_2
    //   1300: aload 8
    //   1302: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1305: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1308: aload_0
    //   1309: iconst_0
    //   1310: putfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1313: aload_0
    //   1314: iconst_1
    //   1315: putfield 33	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:h	Z
    //   1318: aload 9
    //   1320: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1323: checkcast 232	java/net/HttpURLConnection
    //   1326: astore 8
    //   1328: aload 8
    //   1330: iconst_1
    //   1331: invokevirtual 236	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1334: aload 8
    //   1336: ldc 238
    //   1338: ldc 240
    //   1340: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1343: aload 8
    //   1345: invokevirtual 339	java/net/HttpURLConnection:connect	()V
    //   1348: aload 8
    //   1350: invokevirtual 359	java/net/HttpURLConnection:getContentLength	()I
    //   1353: istore_2
    //   1354: iload_2
    //   1355: ifge +66 -> 1421
    //   1358: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +12 -> 1373
    //   1364: ldc 95
    //   1366: iconst_2
    //   1367: ldc_w 367
    //   1370: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1373: aload_0
    //   1374: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1377: bipush 7
    //   1379: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1382: aload_0
    //   1383: iconst_0
    //   1384: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   1387: aload 6
    //   1389: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   1392: aload_0
    //   1393: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1396: istore_1
    //   1397: aload_0
    //   1398: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1401: istore_2
    //   1402: iload_1
    //   1403: iload_2
    //   1404: if_icmpge +16 -> 1420
    //   1407: iload_2
    //   1408: ifle +12 -> 1420
    //   1411: aload_0
    //   1412: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   1415: iload_1
    //   1416: iload_2
    //   1417: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1420: return
    //   1421: aload_0
    //   1422: iload_2
    //   1423: putfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1426: aload 6
    //   1428: iload_2
    //   1429: i2l
    //   1430: invokevirtual 370	java/io/RandomAccessFile:setLength	(J)V
    //   1433: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1436: istore 5
    //   1438: iload 5
    //   1440: ifeq +80 -> 1520
    //   1443: new 71	java/lang/StringBuilder
    //   1446: dup
    //   1447: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1450: astore 9
    //   1452: aload 9
    //   1454: ldc_w 372
    //   1457: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload 9
    //   1463: aload_0
    //   1464: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1467: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: aload 9
    //   1473: ldc_w 374
    //   1476: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload 9
    //   1482: aload_0
    //   1483: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   1486: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload 9
    //   1492: ldc_w 376
    //   1495: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: pop
    //   1499: aload 9
    //   1501: aload_0
    //   1502: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1505: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1508: pop
    //   1509: ldc 95
    //   1511: iconst_2
    //   1512: aload 9
    //   1514: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1520: aload 8
    //   1522: invokevirtual 380	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1525: astore 9
    //   1527: sipush 8192
    //   1530: newarray byte
    //   1532: astore 10
    //   1534: aload 6
    //   1536: aload_0
    //   1537: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1540: i2l
    //   1541: invokevirtual 383	java/io/RandomAccessFile:seek	(J)V
    //   1544: aload_0
    //   1545: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   1548: ifne +18 -> 1566
    //   1551: aload_0
    //   1552: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   1555: aload_0
    //   1556: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1559: aload_0
    //   1560: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1563: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1566: aload 12
    //   1568: astore 8
    //   1570: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1573: ifeq +1672 -> 3245
    //   1576: new 71	java/lang/StringBuilder
    //   1579: dup
    //   1580: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1583: astore 8
    //   1585: aload 8
    //   1587: ldc_w 385
    //   1590: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: aload 8
    //   1596: aload_0
    //   1597: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1600: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1603: pop
    //   1604: aload 8
    //   1606: ldc_w 376
    //   1609: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 8
    //   1615: aload_0
    //   1616: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1619: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1622: pop
    //   1623: ldc 95
    //   1625: iconst_2
    //   1626: aload 8
    //   1628: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1634: aload 12
    //   1636: astore 8
    //   1638: goto +1607 -> 3245
    //   1641: aload_0
    //   1642: getfield 27	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:c	Z
    //   1645: ifne +362 -> 2007
    //   1648: aload_0
    //   1649: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1652: aload_0
    //   1653: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1656: if_icmpge +351 -> 2007
    //   1659: iload_1
    //   1660: bipush 10
    //   1662: if_icmpge +345 -> 2007
    //   1665: invokestatic 160	com/tencent/mobileqq/music/QQPlayerService:s	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1668: astore 12
    //   1670: aload 12
    //   1672: ifnonnull +56 -> 1728
    //   1675: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq +11 -> 1689
    //   1681: ldc 95
    //   1683: iconst_2
    //   1684: aload 8
    //   1686: invokestatic 164	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1689: aload_0
    //   1690: iconst_0
    //   1691: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   1694: aload 6
    //   1696: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   1699: aload_0
    //   1700: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1703: istore_1
    //   1704: aload_0
    //   1705: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1708: istore_2
    //   1709: iload_1
    //   1710: iload_2
    //   1711: if_icmpge +16 -> 1727
    //   1714: iload_2
    //   1715: ifle +12 -> 1727
    //   1718: aload_0
    //   1719: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   1722: iload_1
    //   1723: iload_2
    //   1724: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1727: return
    //   1728: aload_0
    //   1729: getfield 33	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:h	Z
    //   1732: ifeq +164 -> 1896
    //   1735: aload 12
    //   1737: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   1740: aload_0
    //   1741: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   1744: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1747: ifne +8 -> 1755
    //   1750: iload 4
    //   1752: ifeq +144 -> 1896
    //   1755: aload_0
    //   1756: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1759: i2f
    //   1760: aload_0
    //   1761: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   1764: i2f
    //   1765: aload_0
    //   1766: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1769: getfield 198	com/tencent/mobileqq/music/QQPlayerService:e	F
    //   1772: fmul
    //   1773: fcmpl
    //   1774: ifle +122 -> 1896
    //   1777: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   1780: invokevirtual 209	android/media/MediaPlayer:reset	()V
    //   1783: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   1786: aload 11
    //   1788: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1791: invokevirtual 215	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1794: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   1797: invokevirtual 218	android/media/MediaPlayer:prepare	()V
    //   1800: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1803: ifeq +64 -> 1867
    //   1806: new 71	java/lang/StringBuilder
    //   1809: dup
    //   1810: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1813: astore 12
    //   1815: aload 12
    //   1817: ldc_w 387
    //   1820: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: pop
    //   1824: aload 12
    //   1826: aload_0
    //   1827: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1830: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1833: pop
    //   1834: aload 12
    //   1836: ldc_w 389
    //   1839: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: pop
    //   1843: aload 12
    //   1845: aload_0
    //   1846: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1849: invokestatic 392	com/tencent/mobileqq/music/QQPlayerService:d	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1852: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1855: pop
    //   1856: ldc 95
    //   1858: iconst_2
    //   1859: aload 12
    //   1861: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1864: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1867: aload_0
    //   1868: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1871: invokestatic 392	com/tencent/mobileqq/music/QQPlayerService:d	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1874: ifne +17 -> 1891
    //   1877: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   1880: invokevirtual 221	android/media/MediaPlayer:start	()V
    //   1883: aload_0
    //   1884: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1887: iconst_2
    //   1888: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1891: aload_0
    //   1892: iconst_0
    //   1893: putfield 33	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:h	Z
    //   1896: aload 9
    //   1898: aload 10
    //   1900: invokevirtual 401	java/io/InputStream:read	([B)I
    //   1903: istore_2
    //   1904: iload_2
    //   1905: ifgt +80 -> 1985
    //   1908: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1911: ifeq +12 -> 1923
    //   1914: ldc 95
    //   1916: iconst_2
    //   1917: ldc_w 403
    //   1920: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1923: ldc2_w 328
    //   1926: invokestatic 333	java/lang/Thread:sleep	(J)V
    //   1929: goto +1321 -> 3250
    //   1932: astore 12
    //   1934: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1937: ifeq +1313 -> 3250
    //   1940: new 71	java/lang/StringBuilder
    //   1943: dup
    //   1944: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1947: astore 13
    //   1949: aload 13
    //   1951: ldc_w 405
    //   1954: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 13
    //   1960: aload 12
    //   1962: invokevirtual 336	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1965: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: pop
    //   1969: ldc 95
    //   1971: iconst_2
    //   1972: aload 13
    //   1974: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1977: aload 12
    //   1979: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1982: goto +1268 -> 3250
    //   1985: aload_0
    //   1986: aload_0
    //   1987: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1990: iload_2
    //   1991: iadd
    //   1992: putfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   1995: aload 6
    //   1997: aload 10
    //   1999: iconst_0
    //   2000: iload_2
    //   2001: invokevirtual 409	java/io/RandomAccessFile:write	([BII)V
    //   2004: goto +1241 -> 3245
    //   2007: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2010: ifeq +96 -> 2106
    //   2013: new 71	java/lang/StringBuilder
    //   2016: dup
    //   2017: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2020: astore 8
    //   2022: aload 8
    //   2024: ldc_w 411
    //   2027: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: pop
    //   2031: aload 8
    //   2033: aload_0
    //   2034: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2037: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2040: pop
    //   2041: aload 8
    //   2043: ldc_w 413
    //   2046: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: pop
    //   2050: aload 8
    //   2052: iload_1
    //   2053: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2056: pop
    //   2057: aload 8
    //   2059: ldc_w 376
    //   2062: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: pop
    //   2066: aload 8
    //   2068: aload_0
    //   2069: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2072: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 8
    //   2078: ldc_w 374
    //   2081: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload 8
    //   2087: aload_0
    //   2088: getfield 45	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:i	I
    //   2091: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2094: pop
    //   2095: ldc 95
    //   2097: iconst_2
    //   2098: aload 8
    //   2100: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2103: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2106: aload 9
    //   2108: ifnull +8 -> 2116
    //   2111: aload 9
    //   2113: invokevirtual 414	java/io/InputStream:close	()V
    //   2116: aload_0
    //   2117: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2120: aload_0
    //   2121: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2124: if_icmpne +17 -> 2141
    //   2127: aload_0
    //   2128: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2131: ifle +10 -> 2141
    //   2134: aload_0
    //   2135: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   2138: invokestatic 416	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   2141: aload_0
    //   2142: iconst_0
    //   2143: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   2146: aload 6
    //   2148: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   2151: aload_0
    //   2152: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2155: istore_1
    //   2156: aload_0
    //   2157: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2160: istore_2
    //   2161: iload_1
    //   2162: iload_2
    //   2163: if_icmpge +911 -> 3074
    //   2166: iload_2
    //   2167: ifle +907 -> 3074
    //   2170: goto +895 -> 3065
    //   2173: aload 7
    //   2175: astore 9
    //   2177: astore 7
    //   2179: goto +32 -> 2211
    //   2182: astore 7
    //   2184: goto +923 -> 3107
    //   2187: astore 8
    //   2189: aload 6
    //   2191: astore 7
    //   2193: goto +60 -> 2253
    //   2196: astore 8
    //   2198: aload 6
    //   2200: astore 7
    //   2202: goto +178 -> 2380
    //   2205: astore 7
    //   2207: aload 10
    //   2209: astore 9
    //   2211: aload 7
    //   2213: astore 8
    //   2215: aload 6
    //   2217: astore 7
    //   2219: goto +292 -> 2511
    //   2222: astore 8
    //   2224: aload 6
    //   2226: astore 7
    //   2228: goto +591 -> 2819
    //   2231: astore 8
    //   2233: aload 6
    //   2235: astore 7
    //   2237: goto +709 -> 2946
    //   2240: astore 7
    //   2242: aconst_null
    //   2243: astore 6
    //   2245: goto +862 -> 3107
    //   2248: astore 8
    //   2250: aconst_null
    //   2251: astore 7
    //   2253: aload 7
    //   2255: astore 6
    //   2257: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2260: ifeq +61 -> 2321
    //   2263: aload 7
    //   2265: astore 6
    //   2267: new 71	java/lang/StringBuilder
    //   2270: dup
    //   2271: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2274: astore 9
    //   2276: aload 7
    //   2278: astore 6
    //   2280: aload 9
    //   2282: ldc_w 418
    //   2285: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: aload 7
    //   2291: astore 6
    //   2293: aload 9
    //   2295: aload 8
    //   2297: invokevirtual 419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2300: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: pop
    //   2304: aload 7
    //   2306: astore 6
    //   2308: ldc 95
    //   2310: iconst_2
    //   2311: aload 9
    //   2313: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2316: aload 8
    //   2318: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2321: aload 7
    //   2323: astore 6
    //   2325: aload_0
    //   2326: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2329: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2332: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   2335: aload_0
    //   2336: iconst_0
    //   2337: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   2340: aload 7
    //   2342: ifnull +11 -> 2353
    //   2345: aload 7
    //   2347: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   2350: goto +3 -> 2353
    //   2353: aload_0
    //   2354: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2357: istore_1
    //   2358: aload_0
    //   2359: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2362: istore_2
    //   2363: iload_1
    //   2364: iload_2
    //   2365: if_icmpge +709 -> 3074
    //   2368: iload_2
    //   2369: ifle +705 -> 3074
    //   2372: goto +693 -> 3065
    //   2375: astore 8
    //   2377: aconst_null
    //   2378: astore 7
    //   2380: aload 7
    //   2382: astore 6
    //   2384: aload_0
    //   2385: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2388: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2391: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   2394: aload 7
    //   2396: astore 6
    //   2398: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2401: ifeq +61 -> 2462
    //   2404: aload 7
    //   2406: astore 6
    //   2408: new 71	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2415: astore 9
    //   2417: aload 7
    //   2419: astore 6
    //   2421: aload 9
    //   2423: ldc_w 421
    //   2426: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: pop
    //   2430: aload 7
    //   2432: astore 6
    //   2434: aload 9
    //   2436: aload 8
    //   2438: invokevirtual 422	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2441: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2444: pop
    //   2445: aload 7
    //   2447: astore 6
    //   2449: ldc 95
    //   2451: iconst_2
    //   2452: aload 9
    //   2454: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2457: aload 8
    //   2459: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2462: aload_0
    //   2463: iconst_0
    //   2464: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   2467: aload 7
    //   2469: ifnull +11 -> 2480
    //   2472: aload 7
    //   2474: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   2477: goto +3 -> 2480
    //   2480: aload_0
    //   2481: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2484: istore_1
    //   2485: aload_0
    //   2486: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2489: istore_2
    //   2490: iload_1
    //   2491: iload_2
    //   2492: if_icmpge +582 -> 3074
    //   2495: iload_2
    //   2496: ifle +578 -> 3074
    //   2499: goto +566 -> 3065
    //   2502: astore 8
    //   2504: ldc 111
    //   2506: astore 9
    //   2508: aconst_null
    //   2509: astore 7
    //   2511: aload 7
    //   2513: astore 6
    //   2515: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2518: ifeq +61 -> 2579
    //   2521: aload 7
    //   2523: astore 6
    //   2525: new 71	java/lang/StringBuilder
    //   2528: dup
    //   2529: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2532: astore 10
    //   2534: aload 7
    //   2536: astore 6
    //   2538: aload 10
    //   2540: ldc_w 424
    //   2543: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: pop
    //   2547: aload 7
    //   2549: astore 6
    //   2551: aload 10
    //   2553: aload 8
    //   2555: invokevirtual 93	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2558: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: pop
    //   2562: aload 7
    //   2564: astore 6
    //   2566: ldc 95
    //   2568: iconst_2
    //   2569: aload 10
    //   2571: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2574: aload 8
    //   2576: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2579: aload 7
    //   2581: astore 6
    //   2583: invokestatic 160	com/tencent/mobileqq/music/QQPlayerService:s	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2586: astore 8
    //   2588: aload 8
    //   2590: ifnull +125 -> 2715
    //   2593: aload 7
    //   2595: astore 6
    //   2597: aload 8
    //   2599: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   2602: astore 10
    //   2604: aload 7
    //   2606: astore 6
    //   2608: aload 10
    //   2610: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2613: ifne +644 -> 3257
    //   2616: aload 7
    //   2618: astore 6
    //   2620: aload 10
    //   2622: aload 9
    //   2624: invokevirtual 188	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2627: ifeq +630 -> 3257
    //   2630: aload 7
    //   2632: astore 6
    //   2634: aload_0
    //   2635: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   2638: aload_0
    //   2639: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2642: aload 8
    //   2644: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   2647: invokestatic 191	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
    //   2650: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2653: istore 4
    //   2655: goto +3 -> 2658
    //   2658: aload 7
    //   2660: astore 6
    //   2662: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   2665: ifnull +50 -> 2715
    //   2668: aload 7
    //   2670: astore 6
    //   2672: aload_0
    //   2673: getfield 41	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:a	Ljava/lang/String;
    //   2676: aload 8
    //   2678: getfield 176	com/tencent/mobileqq/music/SongInfo:d	Ljava/lang/String;
    //   2681: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2684: ifne +8 -> 2692
    //   2687: iload 4
    //   2689: ifeq +26 -> 2715
    //   2692: aload 7
    //   2694: astore 6
    //   2696: invokestatic 204	com/tencent/mobileqq/music/QQPlayerService:r	()Landroid/media/MediaPlayer;
    //   2699: invokevirtual 209	android/media/MediaPlayer:reset	()V
    //   2702: aload 7
    //   2704: astore 6
    //   2706: aload_0
    //   2707: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2710: bipush 6
    //   2712: invokestatic 224	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2715: aload 7
    //   2717: astore 6
    //   2719: invokestatic 427	com/tencent/mobileqq/music/QQPlayerService:w	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2722: ifnull +52 -> 2774
    //   2725: aload 7
    //   2727: astore 6
    //   2729: invokestatic 427	com/tencent/mobileqq/music/QQPlayerService:w	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2732: arraylength
    //   2733: iconst_1
    //   2734: if_icmpne +40 -> 2774
    //   2737: aload 7
    //   2739: astore 6
    //   2741: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2744: ifeq +16 -> 2760
    //   2747: aload 7
    //   2749: astore 6
    //   2751: ldc 95
    //   2753: iconst_2
    //   2754: ldc_w 429
    //   2757: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2760: aload 7
    //   2762: astore 6
    //   2764: aload_0
    //   2765: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2768: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2771: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   2774: aload_0
    //   2775: iconst_0
    //   2776: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   2779: aload 7
    //   2781: ifnull +11 -> 2792
    //   2784: aload 7
    //   2786: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   2789: goto +3 -> 2792
    //   2792: aload_0
    //   2793: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2796: istore_1
    //   2797: aload_0
    //   2798: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2801: istore_2
    //   2802: iload_1
    //   2803: iload_2
    //   2804: if_icmpge +270 -> 3074
    //   2807: iload_2
    //   2808: ifle +266 -> 3074
    //   2811: goto +254 -> 3065
    //   2814: astore 8
    //   2816: aconst_null
    //   2817: astore 7
    //   2819: aload 7
    //   2821: astore 6
    //   2823: aload_0
    //   2824: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2827: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2830: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   2833: aload 7
    //   2835: astore 6
    //   2837: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2840: ifeq +61 -> 2901
    //   2843: aload 7
    //   2845: astore 6
    //   2847: new 71	java/lang/StringBuilder
    //   2850: dup
    //   2851: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2854: astore 9
    //   2856: aload 7
    //   2858: astore 6
    //   2860: aload 9
    //   2862: ldc_w 431
    //   2865: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: pop
    //   2869: aload 7
    //   2871: astore 6
    //   2873: aload 9
    //   2875: aload 8
    //   2877: invokevirtual 432	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   2880: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2883: pop
    //   2884: aload 7
    //   2886: astore 6
    //   2888: ldc 95
    //   2890: iconst_2
    //   2891: aload 9
    //   2893: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2896: aload 8
    //   2898: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2901: aload_0
    //   2902: iconst_0
    //   2903: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   2906: aload 7
    //   2908: ifnull +11 -> 2919
    //   2911: aload 7
    //   2913: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   2916: goto +3 -> 2919
    //   2919: aload_0
    //   2920: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   2923: istore_1
    //   2924: aload_0
    //   2925: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   2928: istore_2
    //   2929: iload_1
    //   2930: iload_2
    //   2931: if_icmpge +143 -> 3074
    //   2934: iload_2
    //   2935: ifle +139 -> 3074
    //   2938: goto +127 -> 3065
    //   2941: astore 8
    //   2943: aconst_null
    //   2944: astore 7
    //   2946: aload 7
    //   2948: astore 6
    //   2950: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2953: ifeq +61 -> 3014
    //   2956: aload 7
    //   2958: astore 6
    //   2960: new 71	java/lang/StringBuilder
    //   2963: dup
    //   2964: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2967: astore 9
    //   2969: aload 7
    //   2971: astore 6
    //   2973: aload 9
    //   2975: ldc_w 434
    //   2978: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2981: pop
    //   2982: aload 7
    //   2984: astore 6
    //   2986: aload 9
    //   2988: aload 8
    //   2990: invokevirtual 435	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   2993: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2996: pop
    //   2997: aload 7
    //   2999: astore 6
    //   3001: ldc 95
    //   3003: iconst_2
    //   3004: aload 9
    //   3006: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3009: aload 8
    //   3011: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3014: aload 7
    //   3016: astore 6
    //   3018: aload_0
    //   3019: getfield 22	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   3022: invokevirtual 130	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   3025: invokestatic 133	com/tencent/mobileqq/music/QQPlayerService:e	(Landroid/content/Context;)V
    //   3028: aload_0
    //   3029: iconst_0
    //   3030: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   3033: aload 7
    //   3035: ifnull +11 -> 3046
    //   3038: aload 7
    //   3040: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   3043: goto +3 -> 3046
    //   3046: aload_0
    //   3047: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   3050: istore_1
    //   3051: aload_0
    //   3052: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   3055: istore_2
    //   3056: iload_1
    //   3057: iload_2
    //   3058: if_icmpge +16 -> 3074
    //   3061: iload_2
    //   3062: ifle +12 -> 3074
    //   3065: aload_0
    //   3066: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   3069: iload_1
    //   3070: iload_2
    //   3071: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   3074: aload_0
    //   3075: getfield 29	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   3078: ifeq +6 -> 3084
    //   3081: invokestatic 437	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   3084: aload_0
    //   3085: iconst_0
    //   3086: putfield 29	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:d	Z
    //   3089: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3092: ifeq +12 -> 3104
    //   3095: ldc 95
    //   3097: iconst_2
    //   3098: ldc_w 439
    //   3101: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3104: return
    //   3105: astore 7
    //   3107: aload_0
    //   3108: iconst_0
    //   3109: putfield 31	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:g	Z
    //   3112: aload 6
    //   3114: ifnull +11 -> 3125
    //   3117: aload 6
    //   3119: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   3122: goto +3 -> 3125
    //   3125: aload_0
    //   3126: getfield 49	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:e	I
    //   3129: istore_1
    //   3130: aload_0
    //   3131: getfield 47	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:f	I
    //   3134: istore_2
    //   3135: iload_1
    //   3136: iload_2
    //   3137: if_icmpge +16 -> 3153
    //   3140: iload_2
    //   3141: ifle +12 -> 3153
    //   3144: aload_0
    //   3145: getfield 43	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:b	Ljava/lang/String;
    //   3148: iload_1
    //   3149: iload_2
    //   3150: invokestatic 172	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   3153: goto +6 -> 3159
    //   3156: aload 7
    //   3158: athrow
    //   3159: goto -3 -> 3156
    //   3162: astore 6
    //   3164: goto -3011 -> 153
    //   3167: astore 6
    //   3169: goto -1999 -> 1170
    //   3172: astore 6
    //   3174: goto -1782 -> 1392
    //   3177: astore 6
    //   3179: goto -1480 -> 1699
    //   3182: astore 6
    //   3184: goto -1033 -> 2151
    //   3187: astore 6
    //   3189: goto -836 -> 2353
    //   3192: astore 6
    //   3194: goto -714 -> 2480
    //   3197: astore 6
    //   3199: goto -407 -> 2792
    //   3202: astore 6
    //   3204: goto -285 -> 2919
    //   3207: astore 6
    //   3209: goto -163 -> 3046
    //   3212: astore 6
    //   3214: goto -89 -> 3125
    //   3217: goto -2678 -> 539
    //   3220: goto -2312 -> 908
    //   3223: aload 10
    //   3225: astore 9
    //   3227: aload 12
    //   3229: astore 10
    //   3231: goto -2826 -> 405
    //   3234: goto -7 -> 3227
    //   3237: goto +3 -> 3240
    //   3240: iload_1
    //   3241: istore_2
    //   3242: goto -2114 -> 1128
    //   3245: iconst_0
    //   3246: istore_1
    //   3247: goto -1606 -> 1641
    //   3250: iload_1
    //   3251: iconst_1
    //   3252: iadd
    //   3253: istore_1
    //   3254: goto -1613 -> 1641
    //   3257: iconst_0
    //   3258: istore 4
    //   3260: goto -602 -> 2658
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3263	0	this	DownloadThread
    //   157	3097	1	j	int
    //   162	3080	2	k	int
    //   470	525	3	m	int
    //   215	3044	4	bool1	boolean
    //   288	1151	5	bool2	boolean
    //   7	3111	6	localObject1	Object
    //   3162	1	6	localIOException1	IOException
    //   3167	1	6	localIOException2	IOException
    //   3172	1	6	localIOException3	IOException
    //   3177	1	6	localIOException4	IOException
    //   3182	1	6	localIOException5	IOException
    //   3187	1	6	localIOException6	IOException
    //   3192	1	6	localIOException7	IOException
    //   3197	1	6	localIOException8	IOException
    //   3202	1	6	localIOException9	IOException
    //   3207	1	6	localIOException10	IOException
    //   3212	1	6	localIOException11	IOException
    //   2	2172	7	localObject2	Object
    //   2177	1	7	localIOException12	IOException
    //   2182	1	7	localObject3	Object
    //   2191	10	7	localObject4	Object
    //   2205	7	7	localIOException13	IOException
    //   2217	19	7	localObject5	Object
    //   2240	1	7	localObject6	Object
    //   2251	788	7	localObject7	Object
    //   3105	52	7	localObject8	Object
    //   122	1	8	str	String
    //   182	947	8	localIOException14	IOException
    //   1224	875	8	localObject9	Object
    //   2187	1	8	localException1	java.lang.Exception
    //   2196	1	8	localIllegalStateException1	java.lang.IllegalStateException
    //   2213	1	8	localIOException15	IOException
    //   2222	1	8	localMalformedURLException1	java.net.MalformedURLException
    //   2231	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   2248	69	8	localException2	java.lang.Exception
    //   2375	83	8	localIllegalStateException2	java.lang.IllegalStateException
    //   2502	73	8	localIOException16	IOException
    //   2586	91	8	localSongInfo	SongInfo
    //   2814	83	8	localMalformedURLException2	java.net.MalformedURLException
    //   2941	69	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   109	3117	9	localObject10	Object
    //   83	975	10	localObject11	Object
    //   1075	161	10	localInterruptedException1	java.lang.InterruptedException
    //   1532	1698	10	localObject12	Object
    //   58	1729	11	localFile	File
    //   118	1742	12	localObject13	Object
    //   1932	1296	12	localInterruptedException2	java.lang.InterruptedException
    //   94	1879	13	localObject14	Object
    //   204	592	14	localObject15	Object
    //   843	52	14	localInterruptedException3	java.lang.InterruptedException
    //   1090	26	14	localStringBuilder1	StringBuilder
    //   691	46	15	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	143	182	java/io/IOException
    //   222	250	182	java/io/IOException
    //   295	331	182	java/io/IOException
    //   331	373	182	java/io/IOException
    //   376	390	182	java/io/IOException
    //   390	398	182	java/io/IOException
    //   828	834	843	java/lang/InterruptedException
    //   1066	1072	1075	java/lang/InterruptedException
    //   1923	1929	1932	java/lang/InterruptedException
    //   471	536	2173	java/io/IOException
    //   539	553	2173	java/io/IOException
    //   558	621	2173	java/io/IOException
    //   626	803	2173	java/io/IOException
    //   803	813	2173	java/io/IOException
    //   816	824	2173	java/io/IOException
    //   828	834	2173	java/io/IOException
    //   851	899	2173	java/io/IOException
    //   908	924	2173	java/io/IOException
    //   928	945	2173	java/io/IOException
    //   951	994	2173	java/io/IOException
    //   1003	1049	2173	java/io/IOException
    //   1066	1072	2173	java/io/IOException
    //   1077	1125	2173	java/io/IOException
    //   1136	1151	2173	java/io/IOException
    //   1151	1160	2173	java/io/IOException
    //   1201	1215	2173	java/io/IOException
    //   1215	1220	2173	java/io/IOException
    //   1226	1233	2173	java/io/IOException
    //   1239	1308	2173	java/io/IOException
    //   1308	1354	2173	java/io/IOException
    //   1358	1373	2173	java/io/IOException
    //   1373	1382	2173	java/io/IOException
    //   1421	1426	2173	java/io/IOException
    //   1426	1438	2173	java/io/IOException
    //   1443	1520	2173	java/io/IOException
    //   1520	1566	2173	java/io/IOException
    //   1570	1634	2173	java/io/IOException
    //   1641	1659	2173	java/io/IOException
    //   1665	1670	2173	java/io/IOException
    //   1675	1689	2173	java/io/IOException
    //   1728	1750	2173	java/io/IOException
    //   1755	1867	2173	java/io/IOException
    //   1867	1891	2173	java/io/IOException
    //   1891	1896	2173	java/io/IOException
    //   1896	1904	2173	java/io/IOException
    //   1908	1923	2173	java/io/IOException
    //   1923	1929	2173	java/io/IOException
    //   1934	1982	2173	java/io/IOException
    //   1985	2004	2173	java/io/IOException
    //   2007	2106	2173	java/io/IOException
    //   2111	2116	2173	java/io/IOException
    //   2116	2141	2173	java/io/IOException
    //   85	96	2182	finally
    //   100	111	2182	finally
    //   115	120	2182	finally
    //   129	143	2182	finally
    //   199	206	2182	finally
    //   210	217	2182	finally
    //   222	250	2182	finally
    //   260	275	2182	finally
    //   284	290	2182	finally
    //   295	331	2182	finally
    //   331	373	2182	finally
    //   376	390	2182	finally
    //   390	398	2182	finally
    //   418	428	2182	finally
    //   432	438	2182	finally
    //   442	451	2182	finally
    //   455	462	2182	finally
    //   466	471	2182	finally
    //   471	536	2182	finally
    //   539	553	2182	finally
    //   558	621	2182	finally
    //   626	803	2182	finally
    //   803	813	2182	finally
    //   816	824	2182	finally
    //   828	834	2182	finally
    //   851	899	2182	finally
    //   908	924	2182	finally
    //   928	945	2182	finally
    //   951	994	2182	finally
    //   1003	1049	2182	finally
    //   1066	1072	2182	finally
    //   1077	1125	2182	finally
    //   1136	1151	2182	finally
    //   1151	1160	2182	finally
    //   1201	1215	2182	finally
    //   1215	1220	2182	finally
    //   1226	1233	2182	finally
    //   1239	1308	2182	finally
    //   1308	1354	2182	finally
    //   1358	1373	2182	finally
    //   1373	1382	2182	finally
    //   1421	1426	2182	finally
    //   1426	1438	2182	finally
    //   1443	1520	2182	finally
    //   1520	1566	2182	finally
    //   1570	1634	2182	finally
    //   1641	1659	2182	finally
    //   1665	1670	2182	finally
    //   1675	1689	2182	finally
    //   1728	1750	2182	finally
    //   1755	1867	2182	finally
    //   1867	1891	2182	finally
    //   1891	1896	2182	finally
    //   1896	1904	2182	finally
    //   1908	1923	2182	finally
    //   1923	1929	2182	finally
    //   1934	1982	2182	finally
    //   1985	2004	2182	finally
    //   2007	2106	2182	finally
    //   2111	2116	2182	finally
    //   2116	2141	2182	finally
    //   85	96	2187	java/lang/Exception
    //   100	111	2187	java/lang/Exception
    //   115	120	2187	java/lang/Exception
    //   129	143	2187	java/lang/Exception
    //   199	206	2187	java/lang/Exception
    //   210	217	2187	java/lang/Exception
    //   222	250	2187	java/lang/Exception
    //   260	275	2187	java/lang/Exception
    //   284	290	2187	java/lang/Exception
    //   295	331	2187	java/lang/Exception
    //   331	373	2187	java/lang/Exception
    //   376	390	2187	java/lang/Exception
    //   390	398	2187	java/lang/Exception
    //   418	428	2187	java/lang/Exception
    //   432	438	2187	java/lang/Exception
    //   442	451	2187	java/lang/Exception
    //   455	462	2187	java/lang/Exception
    //   466	471	2187	java/lang/Exception
    //   471	536	2187	java/lang/Exception
    //   539	553	2187	java/lang/Exception
    //   558	621	2187	java/lang/Exception
    //   626	803	2187	java/lang/Exception
    //   803	813	2187	java/lang/Exception
    //   816	824	2187	java/lang/Exception
    //   828	834	2187	java/lang/Exception
    //   851	899	2187	java/lang/Exception
    //   908	924	2187	java/lang/Exception
    //   928	945	2187	java/lang/Exception
    //   951	994	2187	java/lang/Exception
    //   1003	1049	2187	java/lang/Exception
    //   1066	1072	2187	java/lang/Exception
    //   1077	1125	2187	java/lang/Exception
    //   1136	1151	2187	java/lang/Exception
    //   1151	1160	2187	java/lang/Exception
    //   1201	1215	2187	java/lang/Exception
    //   1215	1220	2187	java/lang/Exception
    //   1226	1233	2187	java/lang/Exception
    //   1239	1308	2187	java/lang/Exception
    //   1308	1354	2187	java/lang/Exception
    //   1358	1373	2187	java/lang/Exception
    //   1373	1382	2187	java/lang/Exception
    //   1421	1426	2187	java/lang/Exception
    //   1426	1438	2187	java/lang/Exception
    //   1443	1520	2187	java/lang/Exception
    //   1520	1566	2187	java/lang/Exception
    //   1570	1634	2187	java/lang/Exception
    //   1641	1659	2187	java/lang/Exception
    //   1665	1670	2187	java/lang/Exception
    //   1675	1689	2187	java/lang/Exception
    //   1728	1750	2187	java/lang/Exception
    //   1755	1867	2187	java/lang/Exception
    //   1867	1891	2187	java/lang/Exception
    //   1891	1896	2187	java/lang/Exception
    //   1896	1904	2187	java/lang/Exception
    //   1908	1923	2187	java/lang/Exception
    //   1923	1929	2187	java/lang/Exception
    //   1934	1982	2187	java/lang/Exception
    //   1985	2004	2187	java/lang/Exception
    //   2007	2106	2187	java/lang/Exception
    //   2111	2116	2187	java/lang/Exception
    //   2116	2141	2187	java/lang/Exception
    //   85	96	2196	java/lang/IllegalStateException
    //   100	111	2196	java/lang/IllegalStateException
    //   115	120	2196	java/lang/IllegalStateException
    //   129	143	2196	java/lang/IllegalStateException
    //   199	206	2196	java/lang/IllegalStateException
    //   210	217	2196	java/lang/IllegalStateException
    //   222	250	2196	java/lang/IllegalStateException
    //   260	275	2196	java/lang/IllegalStateException
    //   284	290	2196	java/lang/IllegalStateException
    //   295	331	2196	java/lang/IllegalStateException
    //   331	373	2196	java/lang/IllegalStateException
    //   376	390	2196	java/lang/IllegalStateException
    //   390	398	2196	java/lang/IllegalStateException
    //   418	428	2196	java/lang/IllegalStateException
    //   432	438	2196	java/lang/IllegalStateException
    //   442	451	2196	java/lang/IllegalStateException
    //   455	462	2196	java/lang/IllegalStateException
    //   466	471	2196	java/lang/IllegalStateException
    //   471	536	2196	java/lang/IllegalStateException
    //   539	553	2196	java/lang/IllegalStateException
    //   558	621	2196	java/lang/IllegalStateException
    //   626	803	2196	java/lang/IllegalStateException
    //   803	813	2196	java/lang/IllegalStateException
    //   816	824	2196	java/lang/IllegalStateException
    //   828	834	2196	java/lang/IllegalStateException
    //   851	899	2196	java/lang/IllegalStateException
    //   908	924	2196	java/lang/IllegalStateException
    //   928	945	2196	java/lang/IllegalStateException
    //   951	994	2196	java/lang/IllegalStateException
    //   1003	1049	2196	java/lang/IllegalStateException
    //   1066	1072	2196	java/lang/IllegalStateException
    //   1077	1125	2196	java/lang/IllegalStateException
    //   1136	1151	2196	java/lang/IllegalStateException
    //   1151	1160	2196	java/lang/IllegalStateException
    //   1201	1215	2196	java/lang/IllegalStateException
    //   1215	1220	2196	java/lang/IllegalStateException
    //   1226	1233	2196	java/lang/IllegalStateException
    //   1239	1308	2196	java/lang/IllegalStateException
    //   1308	1354	2196	java/lang/IllegalStateException
    //   1358	1373	2196	java/lang/IllegalStateException
    //   1373	1382	2196	java/lang/IllegalStateException
    //   1421	1426	2196	java/lang/IllegalStateException
    //   1426	1438	2196	java/lang/IllegalStateException
    //   1443	1520	2196	java/lang/IllegalStateException
    //   1520	1566	2196	java/lang/IllegalStateException
    //   1570	1634	2196	java/lang/IllegalStateException
    //   1641	1659	2196	java/lang/IllegalStateException
    //   1665	1670	2196	java/lang/IllegalStateException
    //   1675	1689	2196	java/lang/IllegalStateException
    //   1728	1750	2196	java/lang/IllegalStateException
    //   1755	1867	2196	java/lang/IllegalStateException
    //   1867	1891	2196	java/lang/IllegalStateException
    //   1891	1896	2196	java/lang/IllegalStateException
    //   1896	1904	2196	java/lang/IllegalStateException
    //   1908	1923	2196	java/lang/IllegalStateException
    //   1923	1929	2196	java/lang/IllegalStateException
    //   1934	1982	2196	java/lang/IllegalStateException
    //   1985	2004	2196	java/lang/IllegalStateException
    //   2007	2106	2196	java/lang/IllegalStateException
    //   2111	2116	2196	java/lang/IllegalStateException
    //   2116	2141	2196	java/lang/IllegalStateException
    //   85	96	2205	java/io/IOException
    //   100	111	2205	java/io/IOException
    //   115	120	2205	java/io/IOException
    //   199	206	2205	java/io/IOException
    //   210	217	2205	java/io/IOException
    //   260	275	2205	java/io/IOException
    //   284	290	2205	java/io/IOException
    //   418	428	2205	java/io/IOException
    //   432	438	2205	java/io/IOException
    //   442	451	2205	java/io/IOException
    //   455	462	2205	java/io/IOException
    //   466	471	2205	java/io/IOException
    //   85	96	2222	java/net/MalformedURLException
    //   100	111	2222	java/net/MalformedURLException
    //   115	120	2222	java/net/MalformedURLException
    //   129	143	2222	java/net/MalformedURLException
    //   199	206	2222	java/net/MalformedURLException
    //   210	217	2222	java/net/MalformedURLException
    //   222	250	2222	java/net/MalformedURLException
    //   260	275	2222	java/net/MalformedURLException
    //   284	290	2222	java/net/MalformedURLException
    //   295	331	2222	java/net/MalformedURLException
    //   331	373	2222	java/net/MalformedURLException
    //   376	390	2222	java/net/MalformedURLException
    //   390	398	2222	java/net/MalformedURLException
    //   418	428	2222	java/net/MalformedURLException
    //   432	438	2222	java/net/MalformedURLException
    //   442	451	2222	java/net/MalformedURLException
    //   455	462	2222	java/net/MalformedURLException
    //   466	471	2222	java/net/MalformedURLException
    //   471	536	2222	java/net/MalformedURLException
    //   539	553	2222	java/net/MalformedURLException
    //   558	621	2222	java/net/MalformedURLException
    //   626	803	2222	java/net/MalformedURLException
    //   803	813	2222	java/net/MalformedURLException
    //   816	824	2222	java/net/MalformedURLException
    //   828	834	2222	java/net/MalformedURLException
    //   851	899	2222	java/net/MalformedURLException
    //   908	924	2222	java/net/MalformedURLException
    //   928	945	2222	java/net/MalformedURLException
    //   951	994	2222	java/net/MalformedURLException
    //   1003	1049	2222	java/net/MalformedURLException
    //   1066	1072	2222	java/net/MalformedURLException
    //   1077	1125	2222	java/net/MalformedURLException
    //   1136	1151	2222	java/net/MalformedURLException
    //   1151	1160	2222	java/net/MalformedURLException
    //   1201	1215	2222	java/net/MalformedURLException
    //   1215	1220	2222	java/net/MalformedURLException
    //   1226	1233	2222	java/net/MalformedURLException
    //   1239	1308	2222	java/net/MalformedURLException
    //   1308	1354	2222	java/net/MalformedURLException
    //   1358	1373	2222	java/net/MalformedURLException
    //   1373	1382	2222	java/net/MalformedURLException
    //   1421	1426	2222	java/net/MalformedURLException
    //   1426	1438	2222	java/net/MalformedURLException
    //   1443	1520	2222	java/net/MalformedURLException
    //   1520	1566	2222	java/net/MalformedURLException
    //   1570	1634	2222	java/net/MalformedURLException
    //   1641	1659	2222	java/net/MalformedURLException
    //   1665	1670	2222	java/net/MalformedURLException
    //   1675	1689	2222	java/net/MalformedURLException
    //   1728	1750	2222	java/net/MalformedURLException
    //   1755	1867	2222	java/net/MalformedURLException
    //   1867	1891	2222	java/net/MalformedURLException
    //   1891	1896	2222	java/net/MalformedURLException
    //   1896	1904	2222	java/net/MalformedURLException
    //   1908	1923	2222	java/net/MalformedURLException
    //   1923	1929	2222	java/net/MalformedURLException
    //   1934	1982	2222	java/net/MalformedURLException
    //   1985	2004	2222	java/net/MalformedURLException
    //   2007	2106	2222	java/net/MalformedURLException
    //   2111	2116	2222	java/net/MalformedURLException
    //   2116	2141	2222	java/net/MalformedURLException
    //   85	96	2231	java/io/FileNotFoundException
    //   100	111	2231	java/io/FileNotFoundException
    //   115	120	2231	java/io/FileNotFoundException
    //   129	143	2231	java/io/FileNotFoundException
    //   199	206	2231	java/io/FileNotFoundException
    //   210	217	2231	java/io/FileNotFoundException
    //   222	250	2231	java/io/FileNotFoundException
    //   260	275	2231	java/io/FileNotFoundException
    //   284	290	2231	java/io/FileNotFoundException
    //   295	331	2231	java/io/FileNotFoundException
    //   331	373	2231	java/io/FileNotFoundException
    //   376	390	2231	java/io/FileNotFoundException
    //   390	398	2231	java/io/FileNotFoundException
    //   418	428	2231	java/io/FileNotFoundException
    //   432	438	2231	java/io/FileNotFoundException
    //   442	451	2231	java/io/FileNotFoundException
    //   455	462	2231	java/io/FileNotFoundException
    //   466	471	2231	java/io/FileNotFoundException
    //   471	536	2231	java/io/FileNotFoundException
    //   539	553	2231	java/io/FileNotFoundException
    //   558	621	2231	java/io/FileNotFoundException
    //   626	803	2231	java/io/FileNotFoundException
    //   803	813	2231	java/io/FileNotFoundException
    //   816	824	2231	java/io/FileNotFoundException
    //   828	834	2231	java/io/FileNotFoundException
    //   851	899	2231	java/io/FileNotFoundException
    //   908	924	2231	java/io/FileNotFoundException
    //   928	945	2231	java/io/FileNotFoundException
    //   951	994	2231	java/io/FileNotFoundException
    //   1003	1049	2231	java/io/FileNotFoundException
    //   1066	1072	2231	java/io/FileNotFoundException
    //   1077	1125	2231	java/io/FileNotFoundException
    //   1136	1151	2231	java/io/FileNotFoundException
    //   1151	1160	2231	java/io/FileNotFoundException
    //   1201	1215	2231	java/io/FileNotFoundException
    //   1215	1220	2231	java/io/FileNotFoundException
    //   1226	1233	2231	java/io/FileNotFoundException
    //   1239	1308	2231	java/io/FileNotFoundException
    //   1308	1354	2231	java/io/FileNotFoundException
    //   1358	1373	2231	java/io/FileNotFoundException
    //   1373	1382	2231	java/io/FileNotFoundException
    //   1421	1426	2231	java/io/FileNotFoundException
    //   1426	1438	2231	java/io/FileNotFoundException
    //   1443	1520	2231	java/io/FileNotFoundException
    //   1520	1566	2231	java/io/FileNotFoundException
    //   1570	1634	2231	java/io/FileNotFoundException
    //   1641	1659	2231	java/io/FileNotFoundException
    //   1665	1670	2231	java/io/FileNotFoundException
    //   1675	1689	2231	java/io/FileNotFoundException
    //   1728	1750	2231	java/io/FileNotFoundException
    //   1755	1867	2231	java/io/FileNotFoundException
    //   1867	1891	2231	java/io/FileNotFoundException
    //   1891	1896	2231	java/io/FileNotFoundException
    //   1896	1904	2231	java/io/FileNotFoundException
    //   1908	1923	2231	java/io/FileNotFoundException
    //   1923	1929	2231	java/io/FileNotFoundException
    //   1934	1982	2231	java/io/FileNotFoundException
    //   1985	2004	2231	java/io/FileNotFoundException
    //   2007	2106	2231	java/io/FileNotFoundException
    //   2111	2116	2231	java/io/FileNotFoundException
    //   2116	2141	2231	java/io/FileNotFoundException
    //   65	81	2240	finally
    //   65	81	2248	java/lang/Exception
    //   65	81	2375	java/lang/IllegalStateException
    //   65	81	2502	java/io/IOException
    //   65	81	2814	java/net/MalformedURLException
    //   65	81	2941	java/io/FileNotFoundException
    //   2257	2263	3105	finally
    //   2267	2276	3105	finally
    //   2280	2289	3105	finally
    //   2293	2304	3105	finally
    //   2308	2321	3105	finally
    //   2325	2335	3105	finally
    //   2384	2394	3105	finally
    //   2398	2404	3105	finally
    //   2408	2417	3105	finally
    //   2421	2430	3105	finally
    //   2434	2445	3105	finally
    //   2449	2462	3105	finally
    //   2515	2521	3105	finally
    //   2525	2534	3105	finally
    //   2538	2547	3105	finally
    //   2551	2562	3105	finally
    //   2566	2579	3105	finally
    //   2583	2588	3105	finally
    //   2597	2604	3105	finally
    //   2608	2616	3105	finally
    //   2620	2630	3105	finally
    //   2634	2655	3105	finally
    //   2662	2668	3105	finally
    //   2672	2687	3105	finally
    //   2696	2702	3105	finally
    //   2706	2715	3105	finally
    //   2719	2725	3105	finally
    //   2729	2737	3105	finally
    //   2741	2747	3105	finally
    //   2751	2760	3105	finally
    //   2764	2774	3105	finally
    //   2823	2833	3105	finally
    //   2837	2843	3105	finally
    //   2847	2856	3105	finally
    //   2860	2869	3105	finally
    //   2873	2884	3105	finally
    //   2888	2901	3105	finally
    //   2950	2956	3105	finally
    //   2960	2969	3105	finally
    //   2973	2982	3105	finally
    //   2986	2997	3105	finally
    //   3001	3014	3105	finally
    //   3018	3028	3105	finally
    //   148	153	3162	java/io/IOException
    //   1165	1170	3167	java/io/IOException
    //   1387	1392	3172	java/io/IOException
    //   1694	1699	3177	java/io/IOException
    //   2146	2151	3182	java/io/IOException
    //   2345	2350	3187	java/io/IOException
    //   2472	2477	3192	java/io/IOException
    //   2784	2789	3197	java/io/IOException
    //   2911	2916	3202	java/io/IOException
    //   3038	3043	3207	java/io/IOException
    //   3117	3122	3212	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.DownloadThread
 * JD-Core Version:    0.7.0.1
 */