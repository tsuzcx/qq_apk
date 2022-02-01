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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  long jdField_b_of_type_Long = 0L;
  WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  
  public BlessSelectMemberActivity$BlessPTVUploadTask(AppInterface paramAppInterface, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 53
    //   8: iconst_2
    //   9: ldc 55
    //   11: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 64	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: invokestatic 64	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: invokevirtual 69	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   26: ifne +87 -> 113
    //   29: invokestatic 75	android/os/SystemClock:elapsedRealtime	()J
    //   32: lstore 4
    //   34: invokestatic 64	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   37: invokestatic 77	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	()J
    //   40: invokevirtual 83	java/lang/Object:wait	(J)V
    //   43: invokestatic 75	android/os/SystemClock:elapsedRealtime	()J
    //   46: lload 4
    //   48: lsub
    //   49: invokestatic 86	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	(J)J
    //   52: pop2
    //   53: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +57 -> 113
    //   59: new 88	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: ldc 91
    //   72: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 7
    //   78: invokestatic 97	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()J
    //   81: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 7
    //   87: ldc 102
    //   89: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: invokestatic 105	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	()I
    //   98: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 53
    //   104: iconst_2
    //   105: aload 7
    //   107: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: monitorexit
    //   115: goto +55 -> 170
    //   118: astore 7
    //   120: aload_1
    //   121: monitorexit
    //   122: aload 7
    //   124: athrow
    //   125: astore_1
    //   126: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +41 -> 170
    //   132: new 88	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 117
    //   145: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 7
    //   151: aload_1
    //   152: invokevirtual 120	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 53
    //   161: iconst_2
    //   162: aload 7
    //   164: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: invokestatic 97	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()J
    //   173: invokestatic 77	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	()J
    //   176: lcmp
    //   177: iflt +9 -> 186
    //   180: bipush 9
    //   182: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: areturn
    //   186: invokestatic 105	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	()I
    //   189: iconst_1
    //   190: if_icmpeq +10 -> 200
    //   193: invokestatic 105	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:a	()I
    //   196: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: areturn
    //   200: aload_0
    //   201: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   204: putfield 22	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_Long	J
    //   207: getstatic 133	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: astore 10
    //   212: ldc 135
    //   214: invokestatic 141	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   217: checkcast 135	com/tencent/mobileqq/bless/api/IBlessApi
    //   220: aload_0
    //   221: getfield 33	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   224: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   227: checkcast 146	com/tencent/common/app/AppInterface
    //   230: invokeinterface 150 2 0
    //   235: checkcast 152	com/tencent/mobileqq/data/MessageForShortVideo
    //   238: astore 8
    //   240: aload 8
    //   242: ifnonnull +8 -> 250
    //   245: iconst_5
    //   246: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: areturn
    //   250: aload 8
    //   252: instanceof 154
    //   255: ifeq +58 -> 313
    //   258: aload 8
    //   260: checkcast 154	com/tencent/mobileqq/data/MessageForBlessPTV
    //   263: aload_0
    //   264: getfield 35	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   267: putfield 157	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
    //   270: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +40 -> 313
    //   276: new 88	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   283: astore_1
    //   284: aload_1
    //   285: ldc 159
    //   287: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: aload_0
    //   293: getfield 35	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   296: invokevirtual 162	java/util/ArrayList:toString	()Ljava/lang/String;
    //   299: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 53
    //   305: iconst_2
    //   306: aload_1
    //   307: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: getfield 33	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   317: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   320: checkcast 146	com/tencent/common/app/AppInterface
    //   323: astore 9
    //   325: aload 9
    //   327: ifnull +18 -> 345
    //   330: ldc 135
    //   332: invokestatic 141	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   335: checkcast 135	com/tencent/mobileqq/bless/api/IBlessApi
    //   338: aload 9
    //   340: invokeinterface 166 2 0
    //   345: aload 8
    //   347: getfield 169	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   350: invokestatic 175	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   353: ifeq +20 -> 373
    //   356: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +246 -> 605
    //   362: ldc 53
    //   364: iconst_2
    //   365: ldc 177
    //   367: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +235 -> 605
    //   373: aload 10
    //   375: invokestatic 175	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   378: ifne +23 -> 401
    //   381: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +11 -> 395
    //   387: ldc 53
    //   389: iconst_2
    //   390: ldc 179
    //   392: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: bipush 10
    //   397: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   400: areturn
    //   401: new 181	java/io/File
    //   404: dup
    //   405: aload 10
    //   407: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: astore 7
    //   412: aload 7
    //   414: invokevirtual 187	java/io/File:length	()J
    //   417: lstore 4
    //   419: lload 4
    //   421: lconst_0
    //   422: lcmp
    //   423: ifne +22 -> 445
    //   426: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +11 -> 440
    //   432: ldc 53
    //   434: iconst_2
    //   435: ldc 189
    //   437: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iconst_3
    //   441: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: areturn
    //   445: aconst_null
    //   446: astore_1
    //   447: new 191	java/io/FileInputStream
    //   450: dup
    //   451: aload 7
    //   453: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   456: astore 7
    //   458: aload 7
    //   460: lload 4
    //   462: invokestatic 200	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   465: invokestatic 206	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   468: astore 7
    //   470: aload 7
    //   472: astore_1
    //   473: aload 7
    //   475: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   478: ifeq +57 -> 535
    //   481: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +35 -> 519
    //   487: new 88	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   494: astore_1
    //   495: aload_1
    //   496: ldc 214
    //   498: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_1
    //   503: aload 7
    //   505: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: ldc 53
    //   511: iconst_2
    //   512: aload_1
    //   513: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: iconst_3
    //   520: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: areturn
    //   524: astore_1
    //   525: goto +485 -> 1010
    //   528: astore 7
    //   530: aload 7
    //   532: invokevirtual 217	java/io/FileNotFoundException:printStackTrace	()V
    //   535: aload_0
    //   536: aload_1
    //   537: putfield 218	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   540: aload 8
    //   542: lload 4
    //   544: l2i
    //   545: putfield 221	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   548: aload 8
    //   550: getfield 224	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   553: invokestatic 175	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   556: ifeq +49 -> 605
    //   559: aload 8
    //   561: getfield 227	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   564: ldc 229
    //   566: invokestatic 234	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   569: astore_1
    //   570: aload_1
    //   571: aload 8
    //   573: getfield 224	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   576: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   579: ifne +26 -> 605
    //   582: aload_1
    //   583: aload 8
    //   585: getfield 224	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   588: invokestatic 244	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   591: ifne +8 -> 599
    //   594: iconst_3
    //   595: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   598: areturn
    //   599: aload 8
    //   601: aload_1
    //   602: putfield 224	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   605: aload 8
    //   607: getfield 247	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   610: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   613: ifeq +92 -> 705
    //   616: aload 8
    //   618: aload_0
    //   619: getfield 218	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: putfield 247	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   625: aload 8
    //   627: ldc 249
    //   629: invokestatic 252	com/tencent/mobileqq/shortvideo/SVUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
    //   632: astore_1
    //   633: aload 10
    //   635: aload_1
    //   636: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   639: ifne +51 -> 690
    //   642: aload 10
    //   644: aload_1
    //   645: invokestatic 244	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   648: pop
    //   649: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq +38 -> 690
    //   655: new 88	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   662: astore 7
    //   664: aload 7
    //   666: ldc 254
    //   668: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 7
    //   674: aload_1
    //   675: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: ldc 53
    //   681: iconst_2
    //   682: aload 7
    //   684: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_1
    //   691: putstatic 259	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	Ljava/lang/String;
    //   694: aload 8
    //   696: aload_1
    //   697: putfield 169	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   700: aload 8
    //   702: invokevirtual 262	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
    //   705: iconst_0
    //   706: istore 6
    //   708: aload 9
    //   710: ifnull +232 -> 942
    //   713: invokestatic 264	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()Z
    //   716: ifne +226 -> 942
    //   719: new 266	com/tencent/mobileqq/shortvideo/ShortVideoReq
    //   722: dup
    //   723: invokespecial 267	com/tencent/mobileqq/shortvideo/ShortVideoReq:<init>	()V
    //   726: astore_1
    //   727: aload_1
    //   728: iconst_0
    //   729: putfield 268	com/tencent/mobileqq/shortvideo/ShortVideoReq:jdField_a_of_type_Int	I
    //   732: aload_1
    //   733: ldc 135
    //   735: invokestatic 141	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   738: checkcast 135	com/tencent/mobileqq/bless/api/IBlessApi
    //   741: invokeinterface 271 1 0
    //   746: putfield 273	com/tencent/mobileqq/shortvideo/ShortVideoReq:b	I
    //   749: ldc 135
    //   751: invokestatic 141	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   754: checkcast 135	com/tencent/mobileqq/bless/api/IBlessApi
    //   757: aload 8
    //   759: aload_1
    //   760: invokeinterface 277 3 0
    //   765: checkcast 279	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo
    //   768: astore 7
    //   770: aload 7
    //   772: iconst_0
    //   773: putfield 282	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:b	Z
    //   776: aload 7
    //   778: iconst_1
    //   779: putfield 284	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:e	Z
    //   782: aload 7
    //   784: getfield 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   787: ifnull +32 -> 819
    //   790: aload 7
    //   792: getfield 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   795: invokevirtual 289	java/lang/String:length	()I
    //   798: bipush 39
    //   800: if_icmpne +19 -> 819
    //   803: aload 7
    //   805: aload 7
    //   807: getfield 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   810: iconst_0
    //   811: bipush 28
    //   813: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   816: putfield 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   819: aload_1
    //   820: aload 7
    //   822: invokevirtual 296	com/tencent/mobileqq/shortvideo/ShortVideoReq:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;)V
    //   825: ldc 135
    //   827: invokestatic 141	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   830: checkcast 135	com/tencent/mobileqq/bless/api/IBlessApi
    //   833: aload_1
    //   834: aload 9
    //   836: invokeinterface 300 3 0
    //   841: aload_0
    //   842: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   845: putfield 24	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_b_of_type_Long	J
    //   848: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   851: ifeq +154 -> 1005
    //   854: new 88	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   861: astore_1
    //   862: aload_1
    //   863: ldc_w 302
    //   866: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload_1
    //   871: aload 8
    //   873: getfield 305	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
    //   876: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload_1
    //   881: ldc_w 307
    //   884: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload_1
    //   889: aload 8
    //   891: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload_1
    //   896: ldc_w 312
    //   899: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload_0
    //   904: getfield 24	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_b_of_type_Long	J
    //   907: aload_0
    //   908: getfield 22	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity$BlessPTVUploadTask:jdField_a_of_type_Long	J
    //   911: lsub
    //   912: l2d
    //   913: dstore_2
    //   914: dload_2
    //   915: invokestatic 318	java/lang/Double:isNaN	(D)Z
    //   918: pop
    //   919: aload_1
    //   920: dload_2
    //   921: ldc2_w 319
    //   924: ddiv
    //   925: invokevirtual 323	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: ldc 53
    //   931: iconst_2
    //   932: aload_1
    //   933: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: goto +66 -> 1005
    //   942: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   945: ifeq +60 -> 1005
    //   948: new 88	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   955: astore_1
    //   956: aload_1
    //   957: ldc_w 325
    //   960: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 9
    //   966: ifnull +6 -> 972
    //   969: iconst_1
    //   970: istore 6
    //   972: aload_1
    //   973: iload 6
    //   975: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload_1
    //   980: ldc_w 330
    //   983: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload_1
    //   988: invokestatic 264	com/tencent/mobileqq/selectmember/BlessSelectMemberActivity:b	()Z
    //   991: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: ldc 53
    //   997: iconst_2
    //   998: aload_1
    //   999: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: iconst_1
    //   1006: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1009: areturn
    //   1010: aload_1
    //   1011: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1012	0	this	BlessPTVUploadTask
    //   0	1012	1	paramVarArgs	Void[]
    //   913	8	2	d	double
    //   32	511	4	l	long
    //   706	268	6	bool	boolean
    //   66	40	7	localStringBuilder	StringBuilder
    //   118	5	7	localObject1	java.lang.Object
    //   139	365	7	localObject2	java.lang.Object
    //   528	3	7	localFileNotFoundException	java.io.FileNotFoundException
    //   662	159	7	localObject3	java.lang.Object
    //   238	652	8	localMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   323	642	9	localAppInterface	AppInterface
    //   210	433	10	str	String
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i("BlessSelectMemberActivity", 1, localStringBuilder.toString());
    if (paramInteger.intValue() != 1)
    {
      ((BlessSelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
      switch (paramInteger.intValue())
      {
      case 7: 
      default: 
        break;
      case 10: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719110, true);
        break;
      case 9: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719113);
        break;
      case 5: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719109, true);
        break;
      case 4: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719083, true);
        break;
      case 3: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719112, true);
        break;
      case 2: 
      case 6: 
      case 8: 
        BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719117, true);
      }
      BlessSelectMemberActivity.b(1);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.BlessPTVUploadTask
 * JD-Core Version:    0.7.0.1
 */