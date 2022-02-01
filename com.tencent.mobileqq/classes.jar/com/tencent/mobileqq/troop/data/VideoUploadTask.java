package com.tencent.mobileqq.troop.data;

import bfgt;
import bfgx;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String c;
  private static String d;
  protected long a;
  protected bfgt a;
  public bfgx a;
  protected String a;
  protected AtomicBoolean a;
  protected String b;
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: aload_0
    //   6: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: iconst_0
    //   10: invokevirtual 24	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   13: aload_0
    //   14: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   17: ifnonnull +26 -> 43
    //   20: aload_0
    //   21: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_1
    //   25: invokevirtual 24	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   28: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 51
    //   36: iconst_2
    //   37: ldc 53
    //   39: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   47: ifnull +23 -> 70
    //   50: aload_0
    //   51: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +13 -> 70
    //   60: aload_0
    //   61: getfield 68	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +96 -> 163
    //   70: aload_0
    //   71: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 24	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   82: ldc2_w 69
    //   85: invokeinterface 75 3 0
    //   90: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -51 -> 42
    //   96: aload_0
    //   97: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   100: ifnonnull +39 -> 139
    //   103: ldc 77
    //   105: astore 13
    //   107: ldc 51
    //   109: iconst_2
    //   110: new 79	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   117: ldc 84
    //   119: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 13
    //   124: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 90
    //   129: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: aload_0
    //   140: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifeq +10 -> 156
    //   149: ldc 96
    //   151: astore 13
    //   153: goto -46 -> 107
    //   156: ldc 98
    //   158: astore 13
    //   160: goto -53 -> 107
    //   163: aload_0
    //   164: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   167: getfield 101	bfgx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   170: astore 14
    //   172: new 103	android/os/Bundle
    //   175: dup
    //   176: invokespecial 104	android/os/Bundle:<init>	()V
    //   179: astore 13
    //   181: aload 13
    //   183: ldc 106
    //   185: getstatic 108	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   188: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 13
    //   193: ldc 114
    //   195: aload 14
    //   197: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 13
    //   202: ldc 116
    //   204: getstatic 118	com/tencent/mobileqq/troop/data/VideoUploadTask:d	Ljava/lang/String;
    //   207: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 13
    //   212: ldc 120
    //   214: aload_0
    //   215: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   218: getfield 121	bfgx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   221: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 13
    //   226: ldc 123
    //   228: aload_0
    //   229: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   232: getfield 124	bfgx:c	Ljava/lang/String;
    //   235: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 13
    //   240: ldc 126
    //   242: aload_0
    //   243: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   246: getfield 129	bfgx:jdField_b_of_type_Int	I
    //   249: invokevirtual 133	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   252: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   255: invokestatic 145	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   258: ifeq +871 -> 1129
    //   261: aload_0
    //   262: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   265: invokevirtual 29	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   268: ifne +861 -> 1129
    //   271: aload_0
    //   272: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   275: getfield 129	bfgx:jdField_b_of_type_Int	I
    //   278: iconst_3
    //   279: if_icmpne +210 -> 489
    //   282: aload_0
    //   283: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   286: getfield 148	bfgx:jdField_a_of_type_Bfgs	Lbfgs;
    //   289: ifnull +107 -> 396
    //   292: aload_0
    //   293: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   296: getfield 148	bfgx:jdField_a_of_type_Bfgs	Lbfgs;
    //   299: getfield 153	bfgs:f	Ljava/lang/String;
    //   302: ifnull +94 -> 396
    //   305: aload_0
    //   306: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   309: getfield 148	bfgx:jdField_a_of_type_Bfgs	Lbfgs;
    //   312: astore 13
    //   314: aload 13
    //   316: ifnull +792 -> 1108
    //   319: ldc 155
    //   321: aload 13
    //   323: getfield 158	bfgs:h	Ljava/lang/String;
    //   326: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +178 -> 507
    //   332: iconst_1
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_0
    //   339: iconst_1
    //   340: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: ifeq -301 -> 42
    //   346: iload_1
    //   347: ifeq +669 -> 1016
    //   350: aload_0
    //   351: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   354: invokeinterface 170 1 0
    //   359: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -320 -> 42
    //   365: ldc 51
    //   367: iconst_2
    //   368: new 79	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   375: ldc 172
    //   377: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   383: lload 11
    //   385: lsub
    //   386: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: return
    //   396: aload 13
    //   398: aload_0
    //   399: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 68	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   406: invokestatic 180	bglp:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lbfgs;
    //   409: astore 13
    //   411: aload 13
    //   413: ifnull +713 -> 1126
    //   416: aload_0
    //   417: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   420: aload 13
    //   422: getfield 153	bfgs:f	Ljava/lang/String;
    //   425: putfield 124	bfgx:c	Ljava/lang/String;
    //   428: new 182	java/io/File
    //   431: dup
    //   432: aload_0
    //   433: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   436: getfield 101	bfgx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   439: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: astore 15
    //   444: aload 15
    //   446: invokevirtual 188	java/io/File:exists	()Z
    //   449: ifeq +15 -> 464
    //   452: aload_0
    //   453: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   456: aload 15
    //   458: invokevirtual 191	java/io/File:length	()J
    //   461: putfield 193	bfgx:jdField_a_of_type_Long	J
    //   464: aload_0
    //   465: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   468: aload_0
    //   469: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgx	Lbfgx;
    //   472: getfield 101	bfgx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   475: invokestatic 199	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   478: ldc2_w 200
    //   481: ldiv
    //   482: l2i
    //   483: putfield 203	bfgx:jdField_a_of_type_Int	I
    //   486: goto -172 -> 314
    //   489: aload 13
    //   491: aload_0
    //   492: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 68	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   499: invokestatic 206	bfgr:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lbfgs;
    //   502: astore 13
    //   504: goto -190 -> 314
    //   507: aload 13
    //   509: getfield 153	bfgs:f	Ljava/lang/String;
    //   512: ifnull +596 -> 1108
    //   515: aload 13
    //   517: getfield 207	bfgs:c	Ljava/lang/String;
    //   520: invokestatic 213	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   523: astore 15
    //   525: aload 14
    //   527: invokestatic 217	auea:a	(Ljava/lang/String;)[B
    //   530: astore 16
    //   532: aload 14
    //   534: invokestatic 222	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   537: lstore 5
    //   539: lload 5
    //   541: ldc2_w 223
    //   544: lcmp
    //   545: ifle +248 -> 793
    //   548: ldc2_w 223
    //   551: lstore_3
    //   552: new 79	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   559: ldc 226
    //   561: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 13
    //   566: getfield 227	bfgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc 229
    //   574: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 13
    //   579: getfield 230	bfgs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   582: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 232
    //   587: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: astore 17
    //   595: aload_0
    //   596: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   599: invokeinterface 234 1 0
    //   604: new 236	java/io/RandomAccessFile
    //   607: dup
    //   608: aload 14
    //   610: ldc 238
    //   612: invokespecial 240	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: astore 14
    //   617: lconst_0
    //   618: lstore 9
    //   620: lload_3
    //   621: lstore 7
    //   623: lload 9
    //   625: lstore_3
    //   626: lload 7
    //   628: lload_3
    //   629: lsub
    //   630: l2i
    //   631: istore_1
    //   632: aload 14
    //   634: astore 13
    //   636: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   639: invokestatic 145	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   642: ifeq +257 -> 899
    //   645: aload 14
    //   647: astore 13
    //   649: aload_0
    //   650: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   653: invokevirtual 29	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   656: ifne +243 -> 899
    //   659: aload 14
    //   661: astore 13
    //   663: aload 15
    //   665: aload 16
    //   667: aload 17
    //   669: lload 5
    //   671: aload 14
    //   673: lload_3
    //   674: iload_1
    //   675: invokestatic 243	bfgr:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   678: lstore 7
    //   680: aload 14
    //   682: astore 13
    //   684: aload_0
    //   685: lload 7
    //   687: putfield 244	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   690: lload 7
    //   692: ldc2_w 69
    //   695: lcmp
    //   696: ifeq +103 -> 799
    //   699: aload 14
    //   701: astore 13
    //   703: aload_0
    //   704: invokevirtual 246	com/tencent/mobileqq/troop/data/VideoUploadTask:a	()Z
    //   707: ifne +18 -> 725
    //   710: aload 14
    //   712: astore 13
    //   714: aload_0
    //   715: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   718: lload 7
    //   720: invokeinterface 248 3 0
    //   725: ldc2_w 223
    //   728: lload 7
    //   730: ladd
    //   731: lload 5
    //   733: lcmp
    //   734: ifle +155 -> 889
    //   737: lload 5
    //   739: lstore_3
    //   740: lload 7
    //   742: lload 5
    //   744: lcmp
    //   745: iflt +368 -> 1113
    //   748: iconst_1
    //   749: istore_2
    //   750: iload_2
    //   751: istore_1
    //   752: aload 14
    //   754: ifnull -420 -> 334
    //   757: aload 14
    //   759: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   762: iload_2
    //   763: istore_1
    //   764: goto -430 -> 334
    //   767: astore 13
    //   769: iload_2
    //   770: istore_1
    //   771: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq -440 -> 334
    //   777: ldc 51
    //   779: iconst_2
    //   780: aload 13
    //   782: invokestatic 255	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   785: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   788: iload_2
    //   789: istore_1
    //   790: goto -456 -> 334
    //   793: lload 5
    //   795: lstore_3
    //   796: goto -244 -> 552
    //   799: aload 14
    //   801: astore 13
    //   803: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq -58 -> 748
    //   809: aload 14
    //   811: astore 13
    //   813: ldc 51
    //   815: iconst_2
    //   816: new 79	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 257
    //   826: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   832: lload 11
    //   834: lsub
    //   835: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   838: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: goto -96 -> 748
    //   847: astore 15
    //   849: aload 14
    //   851: astore 13
    //   853: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   856: ifeq +18 -> 874
    //   859: aload 14
    //   861: astore 13
    //   863: ldc 51
    //   865: iconst_2
    //   866: aload 15
    //   868: invokestatic 255	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   871: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: aload 14
    //   876: ifnull +232 -> 1108
    //   879: aload 14
    //   881: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   884: iconst_0
    //   885: istore_1
    //   886: goto -552 -> 334
    //   889: ldc2_w 223
    //   892: lload 7
    //   894: ladd
    //   895: lstore_3
    //   896: goto -156 -> 740
    //   899: aload 14
    //   901: astore 13
    //   903: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq -158 -> 748
    //   909: aload 14
    //   911: astore 13
    //   913: ldc 51
    //   915: iconst_2
    //   916: new 79	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 259
    //   926: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   932: lload 11
    //   934: lsub
    //   935: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   938: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: goto -196 -> 748
    //   947: astore 15
    //   949: aload 13
    //   951: astore 14
    //   953: aload 15
    //   955: astore 13
    //   957: aload 14
    //   959: ifnull +8 -> 967
    //   962: aload 14
    //   964: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   967: aload 13
    //   969: athrow
    //   970: astore 13
    //   972: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   975: ifeq +14 -> 989
    //   978: ldc 51
    //   980: iconst_2
    //   981: aload 13
    //   983: invokestatic 255	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   986: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: iconst_0
    //   990: istore_1
    //   991: goto -657 -> 334
    //   994: astore 14
    //   996: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   999: ifeq -32 -> 967
    //   1002: ldc 51
    //   1004: iconst_2
    //   1005: aload 14
    //   1007: invokestatic 255	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1010: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1013: goto -46 -> 967
    //   1016: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1019: invokestatic 145	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   1022: ifne +9 -> 1031
    //   1025: ldc2_w 260
    //   1028: invokestatic 266	java/lang/Thread:sleep	(J)V
    //   1031: aload_0
    //   1032: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Bfgt	Lbfgt;
    //   1035: aload_0
    //   1036: getfield 244	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   1039: invokeinterface 75 3 0
    //   1044: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1047: ifeq -1005 -> 42
    //   1050: ldc 51
    //   1052: iconst_2
    //   1053: new 79	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1060: ldc_w 268
    //   1063: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   1069: lload 11
    //   1071: lsub
    //   1072: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1075: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1081: return
    //   1082: astore 13
    //   1084: aload 13
    //   1086: invokevirtual 271	java/lang/InterruptedException:printStackTrace	()V
    //   1089: goto -58 -> 1031
    //   1092: astore 13
    //   1094: aconst_null
    //   1095: astore 14
    //   1097: goto -140 -> 957
    //   1100: astore 15
    //   1102: aconst_null
    //   1103: astore 14
    //   1105: goto -256 -> 849
    //   1108: iconst_0
    //   1109: istore_1
    //   1110: goto -776 -> 334
    //   1113: lload_3
    //   1114: lstore 9
    //   1116: lload 7
    //   1118: lstore_3
    //   1119: lload 9
    //   1121: lstore 7
    //   1123: goto -497 -> 626
    //   1126: goto -812 -> 314
    //   1129: aconst_null
    //   1130: astore 13
    //   1132: goto -818 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1135	0	this	VideoUploadTask
    //   333	777	1	i	int
    //   749	40	2	j	int
    //   551	568	3	l1	long
    //   537	257	5	l2	long
    //   621	501	7	l3	long
    //   618	502	9	l4	long
    //   3	1067	11	l5	long
    //   105	608	13	localObject1	Object
    //   767	14	13	localIOException1	java.io.IOException
    //   801	167	13	localObject2	Object
    //   970	12	13	localIOException2	java.io.IOException
    //   1082	3	13	localInterruptedException	java.lang.InterruptedException
    //   1092	1	13	localObject3	Object
    //   1130	1	13	localObject4	Object
    //   170	793	14	localObject5	Object
    //   994	12	14	localIOException3	java.io.IOException
    //   1095	9	14	localObject6	Object
    //   442	222	15	localObject7	Object
    //   847	20	15	localException1	java.lang.Exception
    //   947	7	15	localObject8	Object
    //   1100	1	15	localException2	java.lang.Exception
    //   530	136	16	arrayOfByte	byte[]
    //   593	75	17	str	String
    // Exception table:
    //   from	to	target	type
    //   757	762	767	java/io/IOException
    //   636	645	847	java/lang/Exception
    //   649	659	847	java/lang/Exception
    //   663	680	847	java/lang/Exception
    //   684	690	847	java/lang/Exception
    //   703	710	847	java/lang/Exception
    //   714	725	847	java/lang/Exception
    //   803	809	847	java/lang/Exception
    //   813	844	847	java/lang/Exception
    //   903	909	847	java/lang/Exception
    //   913	944	847	java/lang/Exception
    //   636	645	947	finally
    //   649	659	947	finally
    //   663	680	947	finally
    //   684	690	947	finally
    //   703	710	947	finally
    //   714	725	947	finally
    //   803	809	947	finally
    //   813	844	947	finally
    //   853	859	947	finally
    //   863	874	947	finally
    //   903	909	947	finally
    //   913	944	947	finally
    //   879	884	970	java/io/IOException
    //   962	967	994	java/io/IOException
    //   1025	1031	1082	java/lang/InterruptedException
    //   595	617	1092	finally
    //   595	617	1100	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */