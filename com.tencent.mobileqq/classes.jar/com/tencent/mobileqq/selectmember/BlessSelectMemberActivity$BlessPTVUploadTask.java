package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class BlessSelectMemberActivity$BlessPTVUploadTask
  extends AsyncTask<Void, Void, Integer>
{
  WeakReference<Context> a;
  WeakReference<AppInterface> b;
  String c;
  long d = 0L;
  long e = 0L;
  ArrayList<String> f;
  int g;
  
  public BlessSelectMemberActivity$BlessPTVUploadTask(AppInterface paramAppInterface, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    this.a = new WeakReference(paramContext);
    this.b = new WeakReference(paramAppInterface);
    this.f = paramArrayList;
    this.g = paramInt;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 58
    //   8: iconst_2
    //   9: ldc 60
    //   11: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 69	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:l	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: invokestatic 69	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:l	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   26: ifne +87 -> 113
    //   29: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
    //   32: lstore 4
    //   34: invokestatic 69	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:l	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   37: invokestatic 83	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:i	()J
    //   40: invokevirtual 89	java/lang/Object:wait	(J)V
    //   43: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
    //   46: lload 4
    //   48: lsub
    //   49: invokestatic 92	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:c	(J)J
    //   52: pop2
    //   53: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +57 -> 113
    //   59: new 94	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: ldc 97
    //   72: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 7
    //   78: invokestatic 104	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:j	()J
    //   81: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 7
    //   87: ldc 109
    //   89: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: invokestatic 113	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:k	()I
    //   98: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 58
    //   104: iconst_2
    //   105: aload 7
    //   107: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: monitorexit
    //   115: goto +55 -> 170
    //   118: astore 7
    //   120: aload_1
    //   121: monitorexit
    //   122: aload 7
    //   124: athrow
    //   125: astore_1
    //   126: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +41 -> 170
    //   132: new 94	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 124
    //   145: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 7
    //   151: aload_1
    //   152: invokevirtual 127	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 58
    //   161: iconst_2
    //   162: aload 7
    //   164: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: invokestatic 104	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:j	()J
    //   173: invokestatic 83	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:i	()J
    //   176: lcmp
    //   177: iflt +9 -> 186
    //   180: bipush 9
    //   182: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: areturn
    //   186: invokestatic 113	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:k	()I
    //   189: iconst_1
    //   190: if_icmpeq +10 -> 200
    //   193: invokestatic 113	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:k	()I
    //   196: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: areturn
    //   200: aload_0
    //   201: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   204: putfield 27	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:d	J
    //   207: getstatic 140	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	Ljava/lang/String;
    //   210: astore 10
    //   212: ldc 142
    //   214: invokestatic 148	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   217: checkcast 142	com/tencent/mobileqq/bless/api/IBlessApi
    //   220: aload_0
    //   221: getfield 38	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:b	Ljava/lang/ref/WeakReference;
    //   224: invokevirtual 151	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   227: checkcast 153	com/tencent/common/app/AppInterface
    //   230: invokeinterface 157 2 0
    //   235: checkcast 159	com/tencent/mobileqq/data/MessageForShortVideo
    //   238: astore 8
    //   240: aload 8
    //   242: ifnonnull +8 -> 250
    //   245: iconst_5
    //   246: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: areturn
    //   250: aload 8
    //   252: instanceof 161
    //   255: ifeq +58 -> 313
    //   258: aload 8
    //   260: checkcast 161	com/tencent/mobileqq/data/MessageForBlessPTV
    //   263: aload_0
    //   264: getfield 40	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:f	Ljava/util/ArrayList;
    //   267: putfield 164	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
    //   270: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +40 -> 313
    //   276: new 94	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   283: astore_1
    //   284: aload_1
    //   285: ldc 166
    //   287: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: aload_0
    //   293: getfield 40	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:f	Ljava/util/ArrayList;
    //   296: invokevirtual 169	java/util/ArrayList:toString	()Ljava/lang/String;
    //   299: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 58
    //   305: iconst_2
    //   306: aload_1
    //   307: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: getfield 38	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:b	Ljava/lang/ref/WeakReference;
    //   317: invokevirtual 151	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   320: checkcast 153	com/tencent/common/app/AppInterface
    //   323: astore 9
    //   325: aload 9
    //   327: ifnull +18 -> 345
    //   330: ldc 142
    //   332: invokestatic 148	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   335: checkcast 142	com/tencent/mobileqq/bless/api/IBlessApi
    //   338: aload 9
    //   340: invokeinterface 173 2 0
    //   345: aload 8
    //   347: getfield 176	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   350: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   353: ifeq +20 -> 373
    //   356: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +246 -> 605
    //   362: ldc 58
    //   364: iconst_2
    //   365: ldc 184
    //   367: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +235 -> 605
    //   373: aload 10
    //   375: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   378: ifne +23 -> 401
    //   381: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +11 -> 395
    //   387: ldc 58
    //   389: iconst_2
    //   390: ldc 186
    //   392: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: bipush 10
    //   397: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   400: areturn
    //   401: new 188	java/io/File
    //   404: dup
    //   405: aload 10
    //   407: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: astore 7
    //   412: aload 7
    //   414: invokevirtual 194	java/io/File:length	()J
    //   417: lstore 4
    //   419: lload 4
    //   421: lconst_0
    //   422: lcmp
    //   423: ifne +22 -> 445
    //   426: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +11 -> 440
    //   432: ldc 58
    //   434: iconst_2
    //   435: ldc 196
    //   437: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iconst_3
    //   441: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: areturn
    //   445: aconst_null
    //   446: astore_1
    //   447: new 198	java/io/FileInputStream
    //   450: dup
    //   451: aload 7
    //   453: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   456: astore 7
    //   458: aload 7
    //   460: lload 4
    //   462: invokestatic 207	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   465: invokestatic 213	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   468: astore 7
    //   470: aload 7
    //   472: astore_1
    //   473: aload 7
    //   475: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   478: ifeq +57 -> 535
    //   481: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +35 -> 519
    //   487: new 94	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   494: astore_1
    //   495: aload_1
    //   496: ldc 221
    //   498: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_1
    //   503: aload 7
    //   505: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: ldc 58
    //   511: iconst_2
    //   512: aload_1
    //   513: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: iconst_3
    //   520: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: areturn
    //   524: astore_1
    //   525: goto +487 -> 1012
    //   528: astore 7
    //   530: aload 7
    //   532: invokevirtual 224	java/io/FileNotFoundException:printStackTrace	()V
    //   535: aload_0
    //   536: aload_1
    //   537: putfield 226	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:c	Ljava/lang/String;
    //   540: aload 8
    //   542: lload 4
    //   544: l2i
    //   545: putfield 229	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   548: aload 8
    //   550: getfield 232	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   553: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   556: ifeq +49 -> 605
    //   559: aload 8
    //   561: getfield 235	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   564: ldc 237
    //   566: invokestatic 242	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   569: astore_1
    //   570: aload_1
    //   571: aload 8
    //   573: getfield 232	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   576: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   579: ifne +26 -> 605
    //   582: aload_1
    //   583: aload 8
    //   585: getfield 232	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   588: invokestatic 252	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   591: ifne +8 -> 599
    //   594: iconst_3
    //   595: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   598: areturn
    //   599: aload 8
    //   601: aload_1
    //   602: putfield 232	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   605: aload 8
    //   607: getfield 255	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   610: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   613: ifeq +94 -> 707
    //   616: aload 8
    //   618: aload_0
    //   619: getfield 226	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:c	Ljava/lang/String;
    //   622: putfield 255	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   625: aload 8
    //   627: ldc_w 257
    //   630: invokestatic 260	com/tencent/mobileqq/shortvideo/SVUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
    //   633: astore_1
    //   634: aload 10
    //   636: aload_1
    //   637: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifne +52 -> 692
    //   643: aload 10
    //   645: aload_1
    //   646: invokestatic 252	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   649: pop
    //   650: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +39 -> 692
    //   656: new 94	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   663: astore 7
    //   665: aload 7
    //   667: ldc_w 262
    //   670: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 7
    //   676: aload_1
    //   677: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 58
    //   683: iconst_2
    //   684: aload 7
    //   686: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 264	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: aload_1
    //   693: putstatic 266	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	Ljava/lang/String;
    //   696: aload 8
    //   698: aload_1
    //   699: putfield 176	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   702: aload 8
    //   704: invokevirtual 269	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
    //   707: iconst_0
    //   708: istore 6
    //   710: aload 9
    //   712: ifnull +232 -> 944
    //   715: invokestatic 271	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:f	()Z
    //   718: ifne +226 -> 944
    //   721: new 273	com/tencent/mobileqq/shortvideo/ShortVideoReq
    //   724: dup
    //   725: invokespecial 274	com/tencent/mobileqq/shortvideo/ShortVideoReq:<init>	()V
    //   728: astore_1
    //   729: aload_1
    //   730: iconst_0
    //   731: putfield 276	com/tencent/mobileqq/shortvideo/ShortVideoReq:a	I
    //   734: aload_1
    //   735: ldc 142
    //   737: invokestatic 148	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   740: checkcast 142	com/tencent/mobileqq/bless/api/IBlessApi
    //   743: invokeinterface 279 1 0
    //   748: putfield 281	com/tencent/mobileqq/shortvideo/ShortVideoReq:b	I
    //   751: ldc 142
    //   753: invokestatic 148	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   756: checkcast 142	com/tencent/mobileqq/bless/api/IBlessApi
    //   759: aload 8
    //   761: aload_1
    //   762: invokeinterface 285 3 0
    //   767: checkcast 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo
    //   770: astore 7
    //   772: aload 7
    //   774: iconst_0
    //   775: putfield 291	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:w	Z
    //   778: aload 7
    //   780: iconst_1
    //   781: putfield 294	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:B	Z
    //   784: aload 7
    //   786: getfield 297	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:O	Ljava/lang/String;
    //   789: ifnull +32 -> 821
    //   792: aload 7
    //   794: getfield 297	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:O	Ljava/lang/String;
    //   797: invokevirtual 299	java/lang/String:length	()I
    //   800: bipush 39
    //   802: if_icmpne +19 -> 821
    //   805: aload 7
    //   807: aload 7
    //   809: getfield 297	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:O	Ljava/lang/String;
    //   812: iconst_0
    //   813: bipush 28
    //   815: invokevirtual 303	java/lang/String:substring	(II)Ljava/lang/String;
    //   818: putfield 297	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:O	Ljava/lang/String;
    //   821: aload_1
    //   822: aload 7
    //   824: invokevirtual 306	com/tencent/mobileqq/shortvideo/ShortVideoReq:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;)V
    //   827: ldc 142
    //   829: invokestatic 148	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   832: checkcast 142	com/tencent/mobileqq/bless/api/IBlessApi
    //   835: aload_1
    //   836: aload 9
    //   838: invokeinterface 310 3 0
    //   843: aload_0
    //   844: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   847: putfield 29	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:e	J
    //   850: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +154 -> 1007
    //   856: new 94	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   863: astore_1
    //   864: aload_1
    //   865: ldc_w 312
    //   868: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: aload_1
    //   873: aload 8
    //   875: getfield 315	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
    //   878: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload_1
    //   883: ldc_w 317
    //   886: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload_1
    //   891: aload 8
    //   893: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_1
    //   898: ldc_w 322
    //   901: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload_0
    //   906: getfield 29	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:e	J
    //   909: aload_0
    //   910: getfield 27	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:d	J
    //   913: lsub
    //   914: l2d
    //   915: dstore_2
    //   916: dload_2
    //   917: invokestatic 328	java/lang/Double:isNaN	(D)Z
    //   920: pop
    //   921: aload_1
    //   922: dload_2
    //   923: ldc2_w 329
    //   926: ddiv
    //   927: invokevirtual 333	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: ldc 58
    //   933: iconst_2
    //   934: aload_1
    //   935: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 264	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: goto +66 -> 1007
    //   944: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   947: ifeq +60 -> 1007
    //   950: new 94	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   957: astore_1
    //   958: aload_1
    //   959: ldc_w 335
    //   962: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload 9
    //   968: ifnull +6 -> 974
    //   971: iconst_1
    //   972: istore 6
    //   974: aload_1
    //   975: iload 6
    //   977: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload_1
    //   982: ldc_w 340
    //   985: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload_1
    //   990: invokestatic 271	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:f	()Z
    //   993: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: ldc 58
    //   999: iconst_2
    //   1000: aload_1
    //   1001: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 264	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1007: iconst_1
    //   1008: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1011: areturn
    //   1012: aload_1
    //   1013: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	this	BlessPTVUploadTask
    //   0	1014	1	paramVarArgs	Void[]
    //   915	8	2	d1	double
    //   32	511	4	l	long
    //   708	268	6	bool	boolean
    //   66	40	7	localStringBuilder	StringBuilder
    //   118	5	7	localObject1	java.lang.Object
    //   139	365	7	localObject2	java.lang.Object
    //   528	3	7	localFileNotFoundException	java.io.FileNotFoundException
    //   663	160	7	localObject3	java.lang.Object
    //   238	654	8	localMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   323	644	9	localAppInterface	AppInterface
    //   210	434	10	str	String
    // Exception table:
    //   from	to	target	type
    //   20	113	118	finally
    //   113	115	118	finally
    //   120	122	118	finally
    //   14	20	125	java/lang/InterruptedException
    //   122	125	125	java/lang/InterruptedException
    //   447	458	524	finally
    //   530	535	524	finally
    //   447	458	528	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlessPTVUploadTask: onPostExecute result=");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append(" ,entrance=");
    localStringBuilder.append(this.g);
    QLog.i("BlessSelectMemberActivity", 1, localStringBuilder.toString());
    if (paramInteger.intValue() != 1)
    {
      ((BlessSelectMemberActivity)this.a.get()).d();
      switch (paramInteger.intValue())
      {
      case 7: 
      default: 
        break;
      case 10: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916646, true);
        break;
      case 9: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916649);
        break;
      case 5: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916645, true);
        break;
      case 4: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916619, true);
        break;
      case 3: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916648, true);
        break;
      case 2: 
      case 6: 
      case 8: 
        BlessSelectMemberActivity.a((Context)this.a.get(), 2131916653, true);
      }
      BlessSelectMemberActivity.b(1);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.c(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.BlessPTVUploadTask
 * JD-Core Version:    0.7.0.1
 */