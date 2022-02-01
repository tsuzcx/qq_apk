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
    //   0: ldc 33
    //   2: astore 7
    //   4: new 35	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 36	java/util/ArrayList:<init>	()V
    //   11: astore 12
    //   13: new 35	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 36	java/util/ArrayList:<init>	()V
    //   20: astore 10
    //   22: new 35	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 36	java/util/ArrayList:<init>	()V
    //   29: astore 9
    //   31: new 38	java/util/HashMap
    //   34: dup
    //   35: invokespecial 39	java/util/HashMap:<init>	()V
    //   38: astore 11
    //   40: aload_0
    //   41: getfield 16	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentClipData	Landroid/content/ClipData;
    //   44: invokevirtual 45	android/content/ClipData:getItemCount	()I
    //   47: istore_2
    //   48: new 47	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: ldc 50
    //   61: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: iload_2
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 59
    //   74: iconst_1
    //   75: aload 5
    //   77: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: iload_2
    //   87: if_icmpge +824 -> 911
    //   90: aload_0
    //   91: getfield 16	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentClipData	Landroid/content/ClipData;
    //   94: iload_1
    //   95: invokevirtual 73	android/content/ClipData:getItemAt	(I)Landroid/content/ClipData$Item;
    //   98: astore 5
    //   100: aload 5
    //   102: ifnonnull +14 -> 116
    //   105: ldc 59
    //   107: iconst_1
    //   108: ldc 75
    //   110: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: goto +1329 -> 1442
    //   116: aload 5
    //   118: invokevirtual 81	android/content/ClipData$Item:getText	()Ljava/lang/CharSequence;
    //   121: astore 6
    //   123: aload 6
    //   125: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +60 -> 188
    //   131: new 47	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   138: astore 5
    //   140: aload 5
    //   142: ldc 89
    //   144: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: aload 6
    //   152: invokeinterface 94 1 0
    //   157: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 59
    //   163: iconst_2
    //   164: aload 5
    //   166: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 12
    //   174: aload 6
    //   176: invokeinterface 95 1 0
    //   181: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: goto +1257 -> 1442
    //   188: aload 5
    //   190: invokevirtual 103	android/content/ClipData$Item:getIntent	()Landroid/content/Intent;
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +70 -> 267
    //   200: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +1239 -> 1442
    //   206: new 47	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload 5
    //   217: ldc 109
    //   219: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 5
    //   225: aload 6
    //   227: invokevirtual 114	android/content/Intent:getAction	()Ljava/lang/String;
    //   230: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 5
    //   236: ldc 116
    //   238: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: aload 6
    //   246: invokevirtual 119	android/content/Intent:getScheme	()Ljava/lang/String;
    //   249: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 59
    //   255: iconst_2
    //   256: aload 5
    //   258: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: goto +1178 -> 1442
    //   267: aload 5
    //   269: invokevirtual 122	android/content/ClipData$Item:getHtmlText	()Ljava/lang/String;
    //   272: astore 6
    //   274: aload 6
    //   276: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +59 -> 338
    //   282: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +42 -> 327
    //   288: new 47	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   295: astore 5
    //   297: aload 5
    //   299: ldc 124
    //   301: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 5
    //   307: aload 6
    //   309: invokevirtual 127	java/lang/String:length	()I
    //   312: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 59
    //   318: iconst_2
    //   319: aload 5
    //   321: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 12
    //   329: aload 6
    //   331: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: goto +1107 -> 1442
    //   338: new 47	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   345: astore 6
    //   347: aload 6
    //   349: ldc 129
    //   351: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 6
    //   357: aload 5
    //   359: invokevirtual 130	android/content/ClipData$Item:toString	()Ljava/lang/String;
    //   362: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 59
    //   368: iconst_1
    //   369: aload 6
    //   371: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 5
    //   379: invokevirtual 134	android/content/ClipData$Item:getUri	()Landroid/net/Uri;
    //   382: astore 13
    //   384: aload_0
    //   385: getfield 18	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   388: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   391: aload 13
    //   393: invokevirtual 146	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   396: astore 6
    //   398: aload 6
    //   400: ifnull +1045 -> 1445
    //   403: aload 6
    //   405: aload 7
    //   407: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   410: ifnull +1035 -> 1445
    //   413: aload 6
    //   415: aload 7
    //   417: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   420: arraylength
    //   421: ifle +1024 -> 1445
    //   424: aload 6
    //   426: aload 7
    //   428: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   431: iconst_0
    //   432: aaload
    //   433: astore 5
    //   435: goto +3 -> 438
    //   438: invokestatic 156	android/webkit/MimeTypeMap:getSingleton	()Landroid/webkit/MimeTypeMap;
    //   441: aload 6
    //   443: invokevirtual 160	android/webkit/MimeTypeMap:getExtensionFromMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   446: astore 14
    //   448: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +74 -> 525
    //   454: new 47	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   461: astore 6
    //   463: aload 6
    //   465: ldc 162
    //   467: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 6
    //   473: aload 13
    //   475: invokevirtual 165	android/net/Uri:toString	()Ljava/lang/String;
    //   478: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 6
    //   484: ldc 167
    //   486: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 6
    //   492: aload 5
    //   494: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 6
    //   500: ldc 169
    //   502: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 6
    //   508: aload 14
    //   510: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 59
    //   516: iconst_2
    //   517: aload 6
    //   519: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: ldc 171
    //   527: aload 13
    //   529: invokevirtual 172	android/net/Uri:getScheme	()Ljava/lang/String;
    //   532: invokevirtual 176	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   535: istore 4
    //   537: iload 4
    //   539: ifeq +27 -> 566
    //   542: aload 13
    //   544: invokevirtual 179	android/net/Uri:getPath	()Ljava/lang/String;
    //   547: astore 6
    //   549: aload 6
    //   551: invokestatic 184	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   554: istore_3
    //   555: iload_3
    //   556: ifne +895 -> 1451
    //   559: ldc 186
    //   561: astore 5
    //   563: goto +897 -> 1460
    //   566: ldc 188
    //   568: aload 13
    //   570: invokevirtual 172	android/net/Uri:getScheme	()Ljava/lang/String;
    //   573: invokevirtual 176	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   576: ifeq +893 -> 1469
    //   579: aload 13
    //   581: aload_0
    //   582: getfield 18	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   585: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   588: invokestatic 193	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/String;
    //   591: astore 6
    //   593: aload 6
    //   595: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   598: ifeq +868 -> 1466
    //   601: aload 13
    //   603: aload_0
    //   604: getfield 18	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   607: invokestatic 196	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   610: astore 8
    //   612: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +848 -> 1463
    //   618: new 47	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   625: astore 6
    //   627: aload 6
    //   629: ldc 198
    //   631: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 6
    //   637: aload 8
    //   639: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: ldc 59
    //   645: iconst_2
    //   646: aload 6
    //   648: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: goto +3 -> 657
    //   657: aload 8
    //   659: astore 6
    //   661: aload 8
    //   663: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   666: ifeq +49 -> 715
    //   669: new 47	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   676: astore 6
    //   678: aload 6
    //   680: aload 13
    //   682: invokevirtual 165	android/net/Uri:toString	()Ljava/lang/String;
    //   685: invokestatic 202	com/tencent/securitysdk/utils/MD5:a	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 6
    //   694: ldc 204
    //   696: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 6
    //   702: aload 14
    //   704: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 6
    //   710: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: astore 6
    //   715: aload_0
    //   716: getfield 18	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   719: aload 13
    //   721: invokestatic 206	com/tencent/mobileqq/util/SystemDragUtils:a	()Ljava/lang/String;
    //   724: aload 6
    //   726: invokestatic 209	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 6
    //   731: goto +3 -> 734
    //   734: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq +39 -> 776
    //   740: new 47	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   747: astore 8
    //   749: aload 8
    //   751: ldc 211
    //   753: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 8
    //   759: aload 6
    //   761: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: ldc 59
    //   767: iconst_2
    //   768: aload 8
    //   770: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload 6
    //   778: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   781: ifne +694 -> 1475
    //   784: new 213	java/io/File
    //   787: dup
    //   788: aload 6
    //   790: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;)V
    //   793: invokevirtual 219	java/io/File:exists	()Z
    //   796: ifeq +679 -> 1475
    //   799: aload 5
    //   801: ifnull +24 -> 825
    //   804: ldc 186
    //   806: aload 5
    //   808: invokevirtual 176	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   811: ifeq +14 -> 825
    //   814: aload 10
    //   816: aload 6
    //   818: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   821: pop
    //   822: goto +78 -> 900
    //   825: aload 5
    //   827: ifnull +73 -> 900
    //   830: ldc 221
    //   832: aload 5
    //   834: invokevirtual 176	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   837: ifeq +63 -> 900
    //   840: new 223	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo
    //   843: dup
    //   844: invokespecial 224	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:<init>	()V
    //   847: astore 5
    //   849: aload 5
    //   851: new 213	java/io/File
    //   854: dup
    //   855: aload 6
    //   857: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;)V
    //   860: invokevirtual 227	java/io/File:length	()J
    //   863: putfield 231	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:fileSize	J
    //   866: aload 5
    //   868: aload 6
    //   870: invokestatic 237	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   873: putfield 240	com/tencent/mobileqq/activity/shortvideo/SendVideoInfo:duration	J
    //   876: aload 11
    //   878: aload 10
    //   880: invokevirtual 243	java/util/ArrayList:size	()I
    //   883: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: aload 5
    //   888: invokevirtual 253	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   891: pop
    //   892: aload 10
    //   894: aload 6
    //   896: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   899: pop
    //   900: aload 9
    //   902: aload 6
    //   904: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   907: pop
    //   908: goto +567 -> 1475
    //   911: new 47	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   918: astore 5
    //   920: aload 5
    //   922: ldc 255
    //   924: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload 5
    //   930: aload 12
    //   932: invokevirtual 243	java/util/ArrayList:size	()I
    //   935: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 5
    //   941: ldc_w 257
    //   944: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload 5
    //   950: aload 10
    //   952: invokevirtual 243	java/util/ArrayList:size	()I
    //   955: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload 5
    //   961: ldc_w 259
    //   964: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 5
    //   970: aload 11
    //   972: invokevirtual 260	java/util/HashMap:size	()I
    //   975: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 5
    //   981: ldc_w 262
    //   984: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 5
    //   990: aload 9
    //   992: invokevirtual 243	java/util/ArrayList:size	()I
    //   995: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: ldc 59
    //   1001: iconst_1
    //   1002: aload 5
    //   1004: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1010: aload 12
    //   1012: invokevirtual 243	java/util/ArrayList:size	()I
    //   1015: ifle +52 -> 1067
    //   1018: aload 12
    //   1020: invokevirtual 266	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1023: astore 5
    //   1025: aload 5
    //   1027: invokeinterface 271 1 0
    //   1032: ifeq +35 -> 1067
    //   1035: aload 5
    //   1037: invokeinterface 275 1 0
    //   1042: checkcast 126	java/lang/String
    //   1045: astore 6
    //   1047: aload_0
    //   1048: getfield 20	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1051: aload_0
    //   1052: getfield 18	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1055: aload_0
    //   1056: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1059: aload 6
    //   1061: invokestatic 281	com/tencent/mobileqq/activity/ChatActivityFacade:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)V
    //   1064: goto -39 -> 1025
    //   1067: aload 10
    //   1069: invokevirtual 243	java/util/ArrayList:size	()I
    //   1072: ifle +58 -> 1130
    //   1075: aload 10
    //   1077: invokevirtual 243	java/util/ArrayList:size	()I
    //   1080: aload 9
    //   1082: invokevirtual 243	java/util/ArrayList:size	()I
    //   1085: if_icmpne +45 -> 1130
    //   1088: new 283	com/tencent/mobileqq/util/SystemDragUtils$2$1
    //   1091: dup
    //   1092: aload_0
    //   1093: aload 10
    //   1095: aload 11
    //   1097: invokespecial 286	com/tencent/mobileqq/util/SystemDragUtils$2$1:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;Ljava/util/ArrayList;Ljava/util/HashMap;)V
    //   1100: invokestatic 291	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1103: aload_0
    //   1104: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1107: astore 5
    //   1109: aload 5
    //   1111: ifnull +18 -> 1129
    //   1114: aload 5
    //   1116: invokevirtual 296	android/app/ProgressDialog:isShowing	()Z
    //   1119: ifeq +10 -> 1129
    //   1122: aload_0
    //   1123: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1126: invokevirtual 299	android/app/ProgressDialog:cancel	()V
    //   1129: return
    //   1130: aload 9
    //   1132: invokevirtual 243	java/util/ArrayList:size	()I
    //   1135: ifle +205 -> 1340
    //   1138: getstatic 305	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1141: invokevirtual 309	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1144: astore 5
    //   1146: aload 5
    //   1148: ifnull +165 -> 1313
    //   1151: aload 5
    //   1153: instanceof 311
    //   1156: ifeq +157 -> 1313
    //   1159: new 313	com/tencent/mobileqq/util/SystemDragUtils$2$2
    //   1162: dup
    //   1163: aload_0
    //   1164: invokespecial 316	com/tencent/mobileqq/util/SystemDragUtils$2$2:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;)V
    //   1167: invokestatic 291	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1170: aload_0
    //   1171: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1174: getfield 321	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1177: iconst_1
    //   1178: if_icmpne +56 -> 1234
    //   1181: aload 9
    //   1183: invokevirtual 266	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1186: astore 6
    //   1188: aload 6
    //   1190: invokeinterface 271 1 0
    //   1195: ifeq +107 -> 1302
    //   1198: aload 6
    //   1200: invokeinterface 275 1 0
    //   1205: checkcast 126	java/lang/String
    //   1208: astore 7
    //   1210: aload 5
    //   1212: checkcast 311	com/tencent/mobileqq/app/QQAppInterface
    //   1215: invokevirtual 325	com/tencent/mobileqq/app/QQAppInterface:getFileManagerEngine	()Lcom/tencent/mobileqq/filemanager/app/FileManagerEngine;
    //   1218: aload 7
    //   1220: aload_0
    //   1221: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1224: getfield 328	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1227: invokevirtual 333	com/tencent/mobileqq/filemanager/app/FileManagerEngine:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1230: pop
    //   1231: goto -43 -> 1188
    //   1234: aload 9
    //   1236: invokevirtual 266	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1239: astore 6
    //   1241: aload 6
    //   1243: invokeinterface 271 1 0
    //   1248: ifeq +54 -> 1302
    //   1251: aload 6
    //   1253: invokeinterface 275 1 0
    //   1258: checkcast 126	java/lang/String
    //   1261: astore 7
    //   1263: aload 5
    //   1265: checkcast 311	com/tencent/mobileqq/app/QQAppInterface
    //   1268: invokevirtual 325	com/tencent/mobileqq/app/QQAppInterface:getFileManagerEngine	()Lcom/tencent/mobileqq/filemanager/app/FileManagerEngine;
    //   1271: aload 7
    //   1273: aload_0
    //   1274: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1277: getfield 328	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1280: aload_0
    //   1281: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1284: getfield 328	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1287: aload_0
    //   1288: getfield 22	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1291: getfield 321	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1294: iconst_1
    //   1295: invokevirtual 336	com/tencent/mobileqq/filemanager/app/FileManagerEngine:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1298: pop
    //   1299: goto -58 -> 1241
    //   1302: new 338	com/tencent/mobileqq/util/SystemDragUtils$2$3
    //   1305: dup
    //   1306: aload_0
    //   1307: invokespecial 339	com/tencent/mobileqq/util/SystemDragUtils$2$3:<init>	(Lcom/tencent/mobileqq/util/SystemDragUtils$2;)V
    //   1310: invokestatic 291	com/tencent/util/UiThreadUtil:a	(Ljava/lang/Runnable;)V
    //   1313: aload_0
    //   1314: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1317: astore 5
    //   1319: aload 5
    //   1321: ifnull +18 -> 1339
    //   1324: aload 5
    //   1326: invokevirtual 296	android/app/ProgressDialog:isShowing	()Z
    //   1329: ifeq +10 -> 1339
    //   1332: aload_0
    //   1333: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1336: invokevirtual 299	android/app/ProgressDialog:cancel	()V
    //   1339: return
    //   1340: aload_0
    //   1341: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1344: astore 5
    //   1346: aload 5
    //   1348: ifnull +58 -> 1406
    //   1351: aload 5
    //   1353: invokevirtual 296	android/app/ProgressDialog:isShowing	()Z
    //   1356: ifeq +50 -> 1406
    //   1359: goto +40 -> 1399
    //   1362: astore 5
    //   1364: goto +43 -> 1407
    //   1367: astore 5
    //   1369: ldc 59
    //   1371: iconst_1
    //   1372: ldc_w 341
    //   1375: aload 5
    //   1377: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1380: aload_0
    //   1381: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1384: astore 5
    //   1386: aload 5
    //   1388: ifnull +18 -> 1406
    //   1391: aload 5
    //   1393: invokevirtual 296	android/app/ProgressDialog:isShowing	()Z
    //   1396: ifeq +10 -> 1406
    //   1399: aload_0
    //   1400: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1403: invokevirtual 299	android/app/ProgressDialog:cancel	()V
    //   1406: return
    //   1407: aload_0
    //   1408: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1411: astore 6
    //   1413: aload 6
    //   1415: ifnull +18 -> 1433
    //   1418: aload 6
    //   1420: invokevirtual 296	android/app/ProgressDialog:isShowing	()Z
    //   1423: ifeq +10 -> 1433
    //   1426: aload_0
    //   1427: getfield 24	com/tencent/mobileqq/util/SystemDragUtils$2:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1430: invokevirtual 299	android/app/ProgressDialog:cancel	()V
    //   1433: goto +6 -> 1439
    //   1436: aload 5
    //   1438: athrow
    //   1439: goto -3 -> 1436
    //   1442: goto +33 -> 1475
    //   1445: aconst_null
    //   1446: astore 5
    //   1448: goto -1010 -> 438
    //   1451: iload_3
    //   1452: iconst_2
    //   1453: if_icmpne +7 -> 1460
    //   1456: ldc 221
    //   1458: astore 5
    //   1460: goto -726 -> 734
    //   1463: goto -806 -> 657
    //   1466: goto -732 -> 734
    //   1469: aconst_null
    //   1470: astore 6
    //   1472: goto -738 -> 734
    //   1475: iload_1
    //   1476: iconst_1
    //   1477: iadd
    //   1478: istore_1
    //   1479: goto -1394 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1482	0	this	2
    //   84	1395	1	i	int
    //   47	41	2	j	int
    //   554	900	3	k	int
    //   535	3	4	bool	boolean
    //   55	1297	5	localObject1	Object
    //   1362	1	5	localObject2	Object
    //   1367	9	5	localThrowable	java.lang.Throwable
    //   1384	75	5	localObject3	Object
    //   121	1350	6	localObject4	Object
    //   2	1270	7	str1	java.lang.String
    //   610	159	8	localObject5	Object
    //   29	1206	9	localArrayList1	java.util.ArrayList
    //   20	1074	10	localArrayList2	java.util.ArrayList
    //   38	1058	11	localHashMap	java.util.HashMap
    //   11	1008	12	localArrayList3	java.util.ArrayList
    //   382	338	13	localUri	android.net.Uri
    //   446	257	14	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   4	83	1362	finally
    //   90	100	1362	finally
    //   105	113	1362	finally
    //   116	185	1362	finally
    //   188	195	1362	finally
    //   200	264	1362	finally
    //   267	327	1362	finally
    //   327	335	1362	finally
    //   338	398	1362	finally
    //   403	435	1362	finally
    //   438	525	1362	finally
    //   525	537	1362	finally
    //   542	555	1362	finally
    //   566	654	1362	finally
    //   661	715	1362	finally
    //   715	731	1362	finally
    //   734	776	1362	finally
    //   776	799	1362	finally
    //   804	822	1362	finally
    //   830	900	1362	finally
    //   900	908	1362	finally
    //   911	1025	1362	finally
    //   1025	1064	1362	finally
    //   1067	1103	1362	finally
    //   1130	1146	1362	finally
    //   1151	1188	1362	finally
    //   1188	1231	1362	finally
    //   1234	1241	1362	finally
    //   1241	1299	1362	finally
    //   1302	1313	1362	finally
    //   1369	1380	1362	finally
    //   4	83	1367	java/lang/Throwable
    //   90	100	1367	java/lang/Throwable
    //   105	113	1367	java/lang/Throwable
    //   116	185	1367	java/lang/Throwable
    //   188	195	1367	java/lang/Throwable
    //   200	264	1367	java/lang/Throwable
    //   267	327	1367	java/lang/Throwable
    //   327	335	1367	java/lang/Throwable
    //   338	398	1367	java/lang/Throwable
    //   403	435	1367	java/lang/Throwable
    //   438	525	1367	java/lang/Throwable
    //   525	537	1367	java/lang/Throwable
    //   542	555	1367	java/lang/Throwable
    //   566	654	1367	java/lang/Throwable
    //   661	715	1367	java/lang/Throwable
    //   715	731	1367	java/lang/Throwable
    //   734	776	1367	java/lang/Throwable
    //   776	799	1367	java/lang/Throwable
    //   804	822	1367	java/lang/Throwable
    //   830	900	1367	java/lang/Throwable
    //   900	908	1367	java/lang/Throwable
    //   911	1025	1367	java/lang/Throwable
    //   1025	1064	1367	java/lang/Throwable
    //   1067	1103	1367	java/lang/Throwable
    //   1130	1146	1367	java/lang/Throwable
    //   1151	1188	1367	java/lang/Throwable
    //   1188	1231	1367	java/lang/Throwable
    //   1234	1241	1367	java/lang/Throwable
    //   1241	1299	1367	java/lang/Throwable
    //   1302	1313	1367	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.2
 * JD-Core Version:    0.7.0.1
 */