package com.tencent.mobileqq.util;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class SystemDragUtils$2
  implements Runnable
{
  SystemDragUtils$2(ClipData paramClipData, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ProgressDialog paramProgressDialog) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 37
    //   2: astore 7
    //   4: new 39	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 40	java/util/ArrayList:<init>	()V
    //   11: astore 12
    //   13: new 39	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 40	java/util/ArrayList:<init>	()V
    //   20: astore 10
    //   22: new 39	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 40	java/util/ArrayList:<init>	()V
    //   29: astore 9
    //   31: new 42	java/util/HashMap
    //   34: dup
    //   35: invokespecial 43	java/util/HashMap:<init>	()V
    //   38: astore 11
    //   40: aload_0
    //   41: getfield 20	com/tencent/mobileqq/util/SystemDragUtils$2:a	Landroid/content/ClipData;
    //   44: invokevirtual 49	android/content/ClipData:getItemCount	()I
    //   47: istore_2
    //   48: new 51	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: ldc 54
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: iload_2
    //   68: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 63
    //   74: iconst_1
    //   75: aload 5
    //   77: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: iload_2
    //   87: if_icmpge +824 -> 911
    //   90: aload_0
    //   91: getfield 20	com/tencent/mobileqq/util/SystemDragUtils$2:a	Landroid/content/ClipData;
    //   94: iload_1
    //   95: invokevirtual 76	android/content/ClipData:getItemAt	(I)Landroid/content/ClipData$Item;
    //   98: astore 5
    //   100: aload 5
    //   102: ifnonnull +14 -> 116
    //   105: ldc 63
    //   107: iconst_1
    //   108: ldc 78
    //   110: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: goto +1330 -> 1443
    //   116: aload 5
    //   118: invokevirtual 84	android/content/ClipData$Item:getText	()Ljava/lang/CharSequence;
    //   121: astore 6
    //   123: aload 6
    //   125: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +60 -> 188
    //   131: new 51	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   138: astore 5
    //   140: aload 5
    //   142: ldc 92
    //   144: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: aload 6
    //   152: invokeinterface 97 1 0
    //   157: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 63
    //   163: iconst_2
    //   164: aload 5
    //   166: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 12
    //   174: aload 6
    //   176: invokeinterface 98 1 0
    //   181: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: goto +1258 -> 1443
    //   188: aload 5
    //   190: invokevirtual 106	android/content/ClipData$Item:getIntent	()Landroid/content/Intent;
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +70 -> 267
    //   200: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +1240 -> 1443
    //   206: new 51	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload 5
    //   217: ldc 112
    //   219: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 5
    //   225: aload 6
    //   227: invokevirtual 117	android/content/Intent:getAction	()Ljava/lang/String;
    //   230: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 5
    //   236: ldc 119
    //   238: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: aload 6
    //   246: invokevirtual 122	android/content/Intent:getScheme	()Ljava/lang/String;
    //   249: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 63
    //   255: iconst_2
    //   256: aload 5
    //   258: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: goto +1179 -> 1443
    //   267: aload 5
    //   269: invokevirtual 125	android/content/ClipData$Item:getHtmlText	()Ljava/lang/String;
    //   272: astore 6
    //   274: aload 6
    //   276: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +59 -> 338
    //   282: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +42 -> 327
    //   288: new 51	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   295: astore 5
    //   297: aload 5
    //   299: ldc 127
    //   301: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 5
    //   307: aload 6
    //   309: invokevirtual 130	java/lang/String:length	()I
    //   312: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 63
    //   318: iconst_2
    //   319: aload 5
    //   321: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 12
    //   329: aload 6
    //   331: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: goto +1108 -> 1443
    //   338: new 51	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   345: astore 6
    //   347: aload 6
    //   349: ldc 132
    //   351: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 6
    //   357: aload 5
    //   359: invokevirtual 133	android/content/ClipData$Item:toString	()Ljava/lang/String;
    //   362: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 63
    //   368: iconst_1
    //   369: aload 6
    //   371: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 5
    //   379: invokevirtual 137	android/content/ClipData$Item:getUri	()Landroid/net/Uri;
    //   382: astore 13
    //   384: aload_0
    //   385: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:b	Landroid/content/Context;
    //   388: invokevirtual 143	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   391: aload 13
    //   393: invokevirtual 149	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   396: astore 6
    //   398: aload 6
    //   400: ifnull +1046 -> 1446
    //   403: aload 6
    //   405: aload 7
    //   407: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   410: ifnull +1036 -> 1446
    //   413: aload 6
    //   415: aload 7
    //   417: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   420: arraylength
    //   421: ifle +1025 -> 1446
    //   424: aload 6
    //   426: aload 7
    //   428: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   431: iconst_0
    //   432: aaload
    //   433: astore 5
    //   435: goto +3 -> 438
    //   438: invokestatic 159	android/webkit/MimeTypeMap:getSingleton	()Landroid/webkit/MimeTypeMap;
    //   441: aload 6
    //   443: invokevirtual 163	android/webkit/MimeTypeMap:getExtensionFromMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   446: astore 14
    //   448: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +74 -> 525
    //   454: new 51	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   461: astore 6
    //   463: aload 6
    //   465: ldc 165
    //   467: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 6
    //   473: aload 13
    //   475: invokevirtual 168	android/net/Uri:toString	()Ljava/lang/String;
    //   478: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 6
    //   484: ldc 170
    //   486: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 6
    //   492: aload 5
    //   494: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 6
    //   500: ldc 172
    //   502: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 6
    //   508: aload 14
    //   510: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 63
    //   516: iconst_2
    //   517: aload 6
    //   519: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: ldc 174
    //   527: aload 13
    //   529: invokevirtual 175	android/net/Uri:getScheme	()Ljava/lang/String;
    //   532: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   535: istore 4
    //   537: iload 4
    //   539: ifeq +27 -> 566
    //   542: aload 13
    //   544: invokevirtual 182	android/net/Uri:getPath	()Ljava/lang/String;
    //   547: astore 6
    //   549: aload 6
    //   551: invokestatic 187	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)I
    //   554: istore_3
    //   555: iload_3
    //   556: ifne +896 -> 1452
    //   559: ldc 189
    //   561: astore 5
    //   563: goto +898 -> 1461
    //   566: ldc 191
    //   568: aload 13
    //   570: invokevirtual 175	android/net/Uri:getScheme	()Ljava/lang/String;
    //   573: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   576: ifeq +894 -> 1470
    //   579: aload 13
    //   581: aload_0
    //   582: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:b	Landroid/content/Context;
    //   585: invokevirtual 143	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   588: invokestatic 196	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/String;
    //   591: astore 6
    //   593: aload 6
    //   595: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   598: ifeq +869 -> 1467
    //   601: aload 13
    //   603: aload_0
    //   604: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:b	Landroid/content/Context;
    //   607: invokestatic 199	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   610: astore 8
    //   612: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +849 -> 1464
    //   618: new 51	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   625: astore 6
    //   627: aload 6
    //   629: ldc 201
    //   631: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 6
    //   637: aload 8
    //   639: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: ldc 63
    //   645: iconst_2
    //   646: aload 6
    //   648: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: goto +3 -> 657
    //   657: aload 8
    //   659: astore 6
    //   661: aload 8
    //   663: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   666: ifeq +49 -> 715
    //   669: new 51	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   676: astore 6
    //   678: aload 6
    //   680: aload 13
    //   682: invokevirtual 168	android/net/Uri:toString	()Ljava/lang/String;
    //   685: invokestatic 205	com/tencent/securitysdk/utils/MD5:b	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 6
    //   694: ldc 207
    //   696: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 6
    //   702: aload 14
    //   704: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 6
    //   710: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: astore 6
    //   715: aload_0
    //   716: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:b	Landroid/content/Context;
    //   719: aload 13
    //   721: invokestatic 209	com/tencent/mobileqq/util/SystemDragUtils:a	()Ljava/lang/String;
    //   724: aload 6
    //   726: invokestatic 212	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 6
    //   731: goto +3 -> 734
    //   734: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq +39 -> 776
    //   740: new 51	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   747: astore 8
    //   749: aload 8
    //   751: ldc 214
    //   753: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 8
    //   759: aload 6
    //   761: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: ldc 63
    //   767: iconst_2
    //   768: aload 8
    //   770: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload 6
    //   778: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   781: ifne +695 -> 1476
    //   784: new 216	java/io/File
    //   787: dup
    //   788: aload 6
    //   790: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   793: invokevirtual 222	java/io/File:exists	()Z
    //   796: ifeq +680 -> 1476
    //   799: aload 5
    //   801: ifnull +24 -> 825
    //   804: ldc 189
    //   806: aload 5
    //   808: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   811: ifeq +14 -> 825
    //   814: aload 10
    //   816: aload 6
    //   818: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   821: pop
    //   822: goto +78 -> 900
    //   825: aload 5
    //   827: ifnull +73 -> 900
    //   830: ldc 224
    //   832: aload 5
    //   834: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   837: ifeq +63 -> 900
    //   840: new 226	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo
    //   843: dup
    //   844: invokespecial 227	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:<init>	()V
    //   847: astore 5
    //   849: aload 5
    //   851: new 216	java/io/File
    //   854: dup
    //   855: aload 6
    //   857: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   860: invokevirtual 230	java/io/File:length	()J
    //   863: putfield 234	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:fileSize	J
    //   866: aload 5
    //   868: aload 6
    //   870: invokestatic 240	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   873: putfield 243	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:duration	J
    //   876: aload 11
    //   878: aload 10
    //   880: invokevirtual 246	java/util/ArrayList:size	()I
    //   883: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: aload 5
    //   888: invokevirtual 256	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   891: pop
    //   892: aload 10
    //   894: aload 6
    //   896: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   899: pop
    //   900: aload 9
    //   902: aload 6
    //   904: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   907: pop
    //   908: goto +568 -> 1476
    //   911: new 51	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   918: astore 5
    //   920: aload 5
    //   922: ldc_w 258
    //   925: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 5
    //   931: aload 12
    //   933: invokevirtual 246	java/util/ArrayList:size	()I
    //   936: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 5
    //   942: ldc_w 260
    //   945: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload 5
    //   951: aload 10
    //   953: invokevirtual 246	java/util/ArrayList:size	()I
    //   956: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload 5
    //   962: ldc_w 262
    //   965: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 5
    //   971: aload 11
    //   973: invokevirtual 263	java/util/HashMap:size	()I
    //   976: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 5
    //   982: ldc_w 265
    //   985: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload 5
    //   991: aload 9
    //   993: invokevirtual 246	java/util/ArrayList:size	()I
    //   996: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: ldc 63
    //   1002: iconst_1
    //   1003: aload 5
    //   1005: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: aload 12
    //   1013: invokevirtual 246	java/util/ArrayList:size	()I
    //   1016: ifle +52 -> 1068
    //   1019: aload 12
    //   1021: invokevirtual 269	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1024: astore 5
    //   1026: aload 5
    //   1028: invokeinterface 274 1 0
    //   1033: ifeq +35 -> 1068
    //   1036: aload 5
    //   1038: invokeinterface 278 1 0
    //   1043: checkcast 129	java/lang/String
    //   1046: astore 6
    //   1048: aload_0
    //   1049: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1052: aload_0
    //   1053: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:b	Landroid/content/Context;
    //   1056: aload_0
    //   1057: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1060: aload 6
    //   1062: invokestatic 283	com/tencent/mobileqq/activity/ChatActivityFacade:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)V
    //   1065: goto -39 -> 1026
    //   1068: aload 10
    //   1070: invokevirtual 246	java/util/ArrayList:size	()I
    //   1073: ifle +58 -> 1131
    //   1076: aload 10
    //   1078: invokevirtual 246	java/util/ArrayList:size	()I
    //   1081: aload 9
    //   1083: invokevirtual 246	java/util/ArrayList:size	()I
    //   1086: if_icmpne +45 -> 1131
    //   1089: new 285	com/tencent/mobileqq/util/SystemDragUtils$2$1
    //   1092: dup
    //   1093: aload_0
    //   1094: aload 10
    //   1096: aload 11
    //   1098: invokespecial 288	com/tencent/mobileqq/util/SystemDragUtils$2$1:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;Ljava/util/ArrayList;Ljava/util/HashMap;)V
    //   1101: invokestatic 293	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1104: aload_0
    //   1105: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1108: astore 5
    //   1110: aload 5
    //   1112: ifnull +18 -> 1130
    //   1115: aload 5
    //   1117: invokevirtual 298	android/app/ProgressDialog:isShowing	()Z
    //   1120: ifeq +10 -> 1130
    //   1123: aload_0
    //   1124: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1127: invokevirtual 301	android/app/ProgressDialog:cancel	()V
    //   1130: return
    //   1131: aload 9
    //   1133: invokevirtual 246	java/util/ArrayList:size	()I
    //   1136: ifle +205 -> 1341
    //   1139: getstatic 307	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1142: invokevirtual 311	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1145: astore 5
    //   1147: aload 5
    //   1149: ifnull +165 -> 1314
    //   1152: aload 5
    //   1154: instanceof 313
    //   1157: ifeq +157 -> 1314
    //   1160: new 315	com/tencent/mobileqq/util/SystemDragUtils$2$2
    //   1163: dup
    //   1164: aload_0
    //   1165: invokespecial 318	com/tencent/mobileqq/util/SystemDragUtils$2$2:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;)V
    //   1168: invokestatic 293	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1171: aload_0
    //   1172: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1175: getfield 323	com/tencent/mobileqq/activity/aio/SessionInfo:a	I
    //   1178: iconst_1
    //   1179: if_icmpne +56 -> 1235
    //   1182: aload 9
    //   1184: invokevirtual 269	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1187: astore 6
    //   1189: aload 6
    //   1191: invokeinterface 274 1 0
    //   1196: ifeq +107 -> 1303
    //   1199: aload 6
    //   1201: invokeinterface 278 1 0
    //   1206: checkcast 129	java/lang/String
    //   1209: astore 7
    //   1211: aload 5
    //   1213: checkcast 313	com/tencent/mobileqq/app/QQAppInterface
    //   1216: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getFileManagerEngine	()Lcom/tencent/mobileqq/filemanager/app/FileManagerEngine;
    //   1219: aload 7
    //   1221: aload_0
    //   1222: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1225: getfield 330	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   1228: invokevirtual 335	com/tencent/mobileqq/filemanager/app/FileManagerEngine:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1231: pop
    //   1232: goto -43 -> 1189
    //   1235: aload 9
    //   1237: invokevirtual 269	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1240: astore 6
    //   1242: aload 6
    //   1244: invokeinterface 274 1 0
    //   1249: ifeq +54 -> 1303
    //   1252: aload 6
    //   1254: invokeinterface 278 1 0
    //   1259: checkcast 129	java/lang/String
    //   1262: astore 7
    //   1264: aload 5
    //   1266: checkcast 313	com/tencent/mobileqq/app/QQAppInterface
    //   1269: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getFileManagerEngine	()Lcom/tencent/mobileqq/filemanager/app/FileManagerEngine;
    //   1272: aload 7
    //   1274: aload_0
    //   1275: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1278: getfield 330	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   1281: aload_0
    //   1282: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1285: getfield 330	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   1288: aload_0
    //   1289: getfield 26	com/tencent/mobileqq/util/SystemDragUtils$2:d	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1292: getfield 323	com/tencent/mobileqq/activity/aio/SessionInfo:a	I
    //   1295: iconst_1
    //   1296: invokevirtual 338	com/tencent/mobileqq/filemanager/app/FileManagerEngine:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1299: pop
    //   1300: goto -58 -> 1242
    //   1303: new 340	com/tencent/mobileqq/util/SystemDragUtils$2$3
    //   1306: dup
    //   1307: aload_0
    //   1308: invokespecial 341	com/tencent/mobileqq/util/SystemDragUtils$2$3:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;)V
    //   1311: invokestatic 293	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1314: aload_0
    //   1315: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1318: astore 5
    //   1320: aload 5
    //   1322: ifnull +18 -> 1340
    //   1325: aload 5
    //   1327: invokevirtual 298	android/app/ProgressDialog:isShowing	()Z
    //   1330: ifeq +10 -> 1340
    //   1333: aload_0
    //   1334: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1337: invokevirtual 301	android/app/ProgressDialog:cancel	()V
    //   1340: return
    //   1341: aload_0
    //   1342: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1345: astore 5
    //   1347: aload 5
    //   1349: ifnull +58 -> 1407
    //   1352: aload 5
    //   1354: invokevirtual 298	android/app/ProgressDialog:isShowing	()Z
    //   1357: ifeq +50 -> 1407
    //   1360: goto +40 -> 1400
    //   1363: astore 5
    //   1365: goto +43 -> 1408
    //   1368: astore 5
    //   1370: ldc 63
    //   1372: iconst_1
    //   1373: ldc_w 343
    //   1376: aload 5
    //   1378: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1381: aload_0
    //   1382: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1385: astore 5
    //   1387: aload 5
    //   1389: ifnull +18 -> 1407
    //   1392: aload 5
    //   1394: invokevirtual 298	android/app/ProgressDialog:isShowing	()Z
    //   1397: ifeq +10 -> 1407
    //   1400: aload_0
    //   1401: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1404: invokevirtual 301	android/app/ProgressDialog:cancel	()V
    //   1407: return
    //   1408: aload_0
    //   1409: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1412: astore 6
    //   1414: aload 6
    //   1416: ifnull +18 -> 1434
    //   1419: aload 6
    //   1421: invokevirtual 298	android/app/ProgressDialog:isShowing	()Z
    //   1424: ifeq +10 -> 1434
    //   1427: aload_0
    //   1428: getfield 28	com/tencent/mobileqq/util/SystemDragUtils$2:e	Landroid/app/ProgressDialog;
    //   1431: invokevirtual 301	android/app/ProgressDialog:cancel	()V
    //   1434: goto +6 -> 1440
    //   1437: aload 5
    //   1439: athrow
    //   1440: goto -3 -> 1437
    //   1443: goto +33 -> 1476
    //   1446: aconst_null
    //   1447: astore 5
    //   1449: goto -1011 -> 438
    //   1452: iload_3
    //   1453: iconst_2
    //   1454: if_icmpne +7 -> 1461
    //   1457: ldc 224
    //   1459: astore 5
    //   1461: goto -727 -> 734
    //   1464: goto -807 -> 657
    //   1467: goto -733 -> 734
    //   1470: aconst_null
    //   1471: astore 6
    //   1473: goto -739 -> 734
    //   1476: iload_1
    //   1477: iconst_1
    //   1478: iadd
    //   1479: istore_1
    //   1480: goto -1395 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1483	0	this	2
    //   84	1396	1	i	int
    //   47	41	2	j	int
    //   554	901	3	k	int
    //   535	3	4	bool	boolean
    //   55	1298	5	localObject1	Object
    //   1363	1	5	localObject2	Object
    //   1368	9	5	localThrowable	java.lang.Throwable
    //   1385	75	5	localObject3	Object
    //   121	1351	6	localObject4	Object
    //   2	1271	7	str1	java.lang.String
    //   610	159	8	localObject5	Object
    //   29	1207	9	localArrayList1	java.util.ArrayList
    //   20	1075	10	localArrayList2	java.util.ArrayList
    //   38	1059	11	localHashMap	java.util.HashMap
    //   11	1009	12	localArrayList3	java.util.ArrayList
    //   382	338	13	localUri	android.net.Uri
    //   446	257	14	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   4	83	1363	finally
    //   90	100	1363	finally
    //   105	113	1363	finally
    //   116	185	1363	finally
    //   188	195	1363	finally
    //   200	264	1363	finally
    //   267	327	1363	finally
    //   327	335	1363	finally
    //   338	398	1363	finally
    //   403	435	1363	finally
    //   438	525	1363	finally
    //   525	537	1363	finally
    //   542	555	1363	finally
    //   566	654	1363	finally
    //   661	715	1363	finally
    //   715	731	1363	finally
    //   734	776	1363	finally
    //   776	799	1363	finally
    //   804	822	1363	finally
    //   830	900	1363	finally
    //   900	908	1363	finally
    //   911	1026	1363	finally
    //   1026	1065	1363	finally
    //   1068	1104	1363	finally
    //   1131	1147	1363	finally
    //   1152	1189	1363	finally
    //   1189	1232	1363	finally
    //   1235	1242	1363	finally
    //   1242	1300	1363	finally
    //   1303	1314	1363	finally
    //   1370	1381	1363	finally
    //   4	83	1368	java/lang/Throwable
    //   90	100	1368	java/lang/Throwable
    //   105	113	1368	java/lang/Throwable
    //   116	185	1368	java/lang/Throwable
    //   188	195	1368	java/lang/Throwable
    //   200	264	1368	java/lang/Throwable
    //   267	327	1368	java/lang/Throwable
    //   327	335	1368	java/lang/Throwable
    //   338	398	1368	java/lang/Throwable
    //   403	435	1368	java/lang/Throwable
    //   438	525	1368	java/lang/Throwable
    //   525	537	1368	java/lang/Throwable
    //   542	555	1368	java/lang/Throwable
    //   566	654	1368	java/lang/Throwable
    //   661	715	1368	java/lang/Throwable
    //   715	731	1368	java/lang/Throwable
    //   734	776	1368	java/lang/Throwable
    //   776	799	1368	java/lang/Throwable
    //   804	822	1368	java/lang/Throwable
    //   830	900	1368	java/lang/Throwable
    //   900	908	1368	java/lang/Throwable
    //   911	1026	1368	java/lang/Throwable
    //   1026	1065	1368	java/lang/Throwable
    //   1068	1104	1368	java/lang/Throwable
    //   1131	1147	1368	java/lang/Throwable
    //   1152	1189	1368	java/lang/Throwable
    //   1189	1232	1368	java/lang/Throwable
    //   1235	1242	1368	java/lang/Throwable
    //   1242	1300	1368	java/lang/Throwable
    //   1303	1314	1368	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.2
 * JD-Core Version:    0.7.0.1
 */