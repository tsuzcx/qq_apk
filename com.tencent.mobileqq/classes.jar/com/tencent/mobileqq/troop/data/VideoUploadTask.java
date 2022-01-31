package com.tencent.mobileqq.troop.data;

import aznu;
import azny;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String c;
  private static String d;
  protected long a;
  protected aznu a;
  public azny a;
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
    //   14: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
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
    //   44: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
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
    //   79: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
    //   82: ldc2_w 69
    //   85: invokeinterface 75 3 0
    //   90: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -51 -> 42
    //   96: aload_0
    //   97: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
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
    //   164: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   167: getfield 101	azny:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   215: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   218: getfield 121	azny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   221: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 13
    //   226: ldc 123
    //   228: aload_0
    //   229: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   232: getfield 124	azny:c	Ljava/lang/String;
    //   235: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 13
    //   240: ldc 126
    //   242: aload_0
    //   243: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   246: getfield 129	azny:jdField_b_of_type_Int	I
    //   249: invokevirtual 133	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   252: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   255: invokestatic 144	nam:a	(Landroid/content/Context;)Z
    //   258: ifeq +869 -> 1127
    //   261: aload_0
    //   262: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   265: invokevirtual 29	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   268: ifne +859 -> 1127
    //   271: aload_0
    //   272: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   275: getfield 129	azny:jdField_b_of_type_Int	I
    //   278: iconst_3
    //   279: if_icmpne +210 -> 489
    //   282: aload_0
    //   283: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   286: getfield 147	azny:jdField_a_of_type_Aznt	Laznt;
    //   289: ifnull +107 -> 396
    //   292: aload_0
    //   293: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   296: getfield 147	azny:jdField_a_of_type_Aznt	Laznt;
    //   299: getfield 152	aznt:f	Ljava/lang/String;
    //   302: ifnull +94 -> 396
    //   305: aload_0
    //   306: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   309: getfield 147	azny:jdField_a_of_type_Aznt	Laznt;
    //   312: astore 13
    //   314: aload 13
    //   316: ifnull +790 -> 1106
    //   319: ldc 154
    //   321: aload 13
    //   323: getfield 157	aznt:h	Ljava/lang/String;
    //   326: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +178 -> 507
    //   332: iconst_1
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_0
    //   339: iconst_1
    //   340: invokevirtual 167	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: ifeq -301 -> 42
    //   346: iload_1
    //   347: ifeq +667 -> 1014
    //   350: aload_0
    //   351: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
    //   354: invokeinterface 169 1 0
    //   359: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -320 -> 42
    //   365: ldc 51
    //   367: iconst_2
    //   368: new 79	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   375: ldc 171
    //   377: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   383: lload 11
    //   385: lsub
    //   386: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: return
    //   396: aload 13
    //   398: aload_0
    //   399: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 68	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   406: invokestatic 179	balt:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Laznt;
    //   409: astore 13
    //   411: aload 13
    //   413: ifnull +711 -> 1124
    //   416: aload_0
    //   417: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   420: aload 13
    //   422: getfield 152	aznt:f	Ljava/lang/String;
    //   425: putfield 124	azny:c	Ljava/lang/String;
    //   428: new 181	java/io/File
    //   431: dup
    //   432: aload_0
    //   433: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   436: getfield 101	azny:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   439: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: astore 15
    //   444: aload 15
    //   446: invokevirtual 187	java/io/File:exists	()Z
    //   449: ifeq +15 -> 464
    //   452: aload_0
    //   453: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   456: aload 15
    //   458: invokevirtual 190	java/io/File:length	()J
    //   461: putfield 192	azny:jdField_a_of_type_Long	J
    //   464: aload_0
    //   465: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   468: aload_0
    //   469: getfield 58	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Azny	Lazny;
    //   472: getfield 101	azny:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   475: invokestatic 197	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   478: ldc2_w 198
    //   481: ldiv
    //   482: l2i
    //   483: putfield 201	azny:jdField_a_of_type_Int	I
    //   486: goto -172 -> 314
    //   489: aload 13
    //   491: aload_0
    //   492: getfield 60	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 68	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   499: invokestatic 204	azns:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Laznt;
    //   502: astore 13
    //   504: goto -190 -> 314
    //   507: aload 13
    //   509: getfield 152	aznt:f	Ljava/lang/String;
    //   512: ifnull +594 -> 1106
    //   515: aload 13
    //   517: getfield 205	aznt:c	Ljava/lang/String;
    //   520: invokestatic 210	bbdm:a	(Ljava/lang/String;)[B
    //   523: astore 15
    //   525: aload 14
    //   527: invokestatic 213	apue:a	(Ljava/lang/String;)[B
    //   530: astore 16
    //   532: aload 14
    //   534: invokestatic 216	bbdj:a	(Ljava/lang/String;)J
    //   537: lstore 5
    //   539: lload 5
    //   541: ldc2_w 217
    //   544: lcmp
    //   545: ifle +248 -> 793
    //   548: ldc2_w 217
    //   551: lstore_3
    //   552: new 79	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   559: ldc 220
    //   561: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 13
    //   566: getfield 221	aznt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc 223
    //   574: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 13
    //   579: getfield 224	aznt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   582: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 226
    //   587: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: astore 17
    //   595: aload_0
    //   596: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
    //   599: invokeinterface 228 1 0
    //   604: new 230	java/io/RandomAccessFile
    //   607: dup
    //   608: aload 14
    //   610: ldc 232
    //   612: invokespecial 234	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   639: invokestatic 144	nam:a	(Landroid/content/Context;)Z
    //   642: ifeq +256 -> 898
    //   645: aload 14
    //   647: astore 13
    //   649: aload_0
    //   650: getfield 18	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   653: invokevirtual 29	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   656: ifne +242 -> 898
    //   659: aload 14
    //   661: astore 13
    //   663: aload 15
    //   665: aload 16
    //   667: aload 17
    //   669: lload 5
    //   671: aload 14
    //   673: lload_3
    //   674: iload_1
    //   675: invokestatic 237	azns:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   678: lstore 7
    //   680: aload 14
    //   682: astore 13
    //   684: aload_0
    //   685: lload 7
    //   687: putfield 238	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   690: lload 7
    //   692: ldc2_w 69
    //   695: lcmp
    //   696: ifeq +103 -> 799
    //   699: aload 14
    //   701: astore 13
    //   703: aload_0
    //   704: invokevirtual 240	com/tencent/mobileqq/troop/data/VideoUploadTask:a	()Z
    //   707: ifne +18 -> 725
    //   710: aload 14
    //   712: astore 13
    //   714: aload_0
    //   715: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
    //   718: lload 7
    //   720: invokeinterface 242 3 0
    //   725: ldc2_w 217
    //   728: lload 7
    //   730: ladd
    //   731: lload 5
    //   733: lcmp
    //   734: ifle +154 -> 888
    //   737: lload 5
    //   739: lstore_3
    //   740: lload 7
    //   742: lload 5
    //   744: lcmp
    //   745: iflt +366 -> 1111
    //   748: iconst_1
    //   749: istore_2
    //   750: iload_2
    //   751: istore_1
    //   752: aload 14
    //   754: ifnull -420 -> 334
    //   757: aload 14
    //   759: invokevirtual 245	java/io/RandomAccessFile:close	()V
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
    //   782: invokestatic 249	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
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
    //   823: ldc 251
    //   825: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   831: lload 11
    //   833: lsub
    //   834: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   837: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: goto -95 -> 748
    //   846: astore 15
    //   848: aload 14
    //   850: astore 13
    //   852: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +18 -> 873
    //   858: aload 14
    //   860: astore 13
    //   862: ldc 51
    //   864: iconst_2
    //   865: aload 15
    //   867: invokestatic 249	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   870: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: aload 14
    //   875: ifnull +231 -> 1106
    //   878: aload 14
    //   880: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   883: iconst_0
    //   884: istore_1
    //   885: goto -551 -> 334
    //   888: ldc2_w 217
    //   891: lload 7
    //   893: ladd
    //   894: lstore_3
    //   895: goto -155 -> 740
    //   898: aload 14
    //   900: astore 13
    //   902: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   905: ifeq -157 -> 748
    //   908: aload 14
    //   910: astore 13
    //   912: ldc 51
    //   914: iconst_2
    //   915: new 79	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   922: ldc 253
    //   924: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   930: lload 11
    //   932: lsub
    //   933: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   936: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: goto -194 -> 748
    //   945: astore 15
    //   947: aload 13
    //   949: astore 14
    //   951: aload 15
    //   953: astore 13
    //   955: aload 14
    //   957: ifnull +8 -> 965
    //   960: aload 14
    //   962: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   965: aload 13
    //   967: athrow
    //   968: astore 13
    //   970: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   973: ifeq +14 -> 987
    //   976: ldc 51
    //   978: iconst_2
    //   979: aload 13
    //   981: invokestatic 249	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   984: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: iconst_0
    //   988: istore_1
    //   989: goto -655 -> 334
    //   992: astore 14
    //   994: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   997: ifeq -32 -> 965
    //   1000: ldc 51
    //   1002: iconst_2
    //   1003: aload 14
    //   1005: invokestatic 249	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1008: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: goto -46 -> 965
    //   1014: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1017: invokestatic 144	nam:a	(Landroid/content/Context;)Z
    //   1020: ifne +9 -> 1029
    //   1023: ldc2_w 254
    //   1026: invokestatic 260	java/lang/Thread:sleep	(J)V
    //   1029: aload_0
    //   1030: getfield 44	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Aznu	Laznu;
    //   1033: aload_0
    //   1034: getfield 238	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   1037: invokeinterface 75 3 0
    //   1042: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1045: ifeq -1003 -> 42
    //   1048: ldc 51
    //   1050: iconst_2
    //   1051: new 79	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 262
    //   1061: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   1067: lload 11
    //   1069: lsub
    //   1070: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1079: return
    //   1080: astore 13
    //   1082: aload 13
    //   1084: invokevirtual 265	java/lang/InterruptedException:printStackTrace	()V
    //   1087: goto -58 -> 1029
    //   1090: astore 13
    //   1092: aconst_null
    //   1093: astore 14
    //   1095: goto -140 -> 955
    //   1098: astore 15
    //   1100: aconst_null
    //   1101: astore 14
    //   1103: goto -255 -> 848
    //   1106: iconst_0
    //   1107: istore_1
    //   1108: goto -774 -> 334
    //   1111: lload_3
    //   1112: lstore 9
    //   1114: lload 7
    //   1116: lstore_3
    //   1117: lload 9
    //   1119: lstore 7
    //   1121: goto -495 -> 626
    //   1124: goto -810 -> 314
    //   1127: aconst_null
    //   1128: astore 13
    //   1130: goto -816 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1133	0	this	VideoUploadTask
    //   333	775	1	i	int
    //   749	40	2	j	int
    //   551	566	3	l1	long
    //   537	257	5	l2	long
    //   621	499	7	l3	long
    //   618	500	9	l4	long
    //   3	1065	11	l5	long
    //   105	608	13	localObject1	Object
    //   767	14	13	localIOException1	java.io.IOException
    //   801	165	13	localObject2	Object
    //   968	12	13	localIOException2	java.io.IOException
    //   1080	3	13	localInterruptedException	java.lang.InterruptedException
    //   1090	1	13	localObject3	Object
    //   1128	1	13	localObject4	Object
    //   170	791	14	localObject5	Object
    //   992	12	14	localIOException3	java.io.IOException
    //   1093	9	14	localObject6	Object
    //   442	222	15	localObject7	Object
    //   846	20	15	localException1	java.lang.Exception
    //   945	7	15	localObject8	Object
    //   1098	1	15	localException2	java.lang.Exception
    //   530	136	16	arrayOfByte	byte[]
    //   593	75	17	str	String
    // Exception table:
    //   from	to	target	type
    //   757	762	767	java/io/IOException
    //   636	645	846	java/lang/Exception
    //   649	659	846	java/lang/Exception
    //   663	680	846	java/lang/Exception
    //   684	690	846	java/lang/Exception
    //   703	710	846	java/lang/Exception
    //   714	725	846	java/lang/Exception
    //   803	809	846	java/lang/Exception
    //   813	843	846	java/lang/Exception
    //   902	908	846	java/lang/Exception
    //   912	942	846	java/lang/Exception
    //   636	645	945	finally
    //   649	659	945	finally
    //   663	680	945	finally
    //   684	690	945	finally
    //   703	710	945	finally
    //   714	725	945	finally
    //   803	809	945	finally
    //   813	843	945	finally
    //   852	858	945	finally
    //   862	873	945	finally
    //   902	908	945	finally
    //   912	942	945	finally
    //   878	883	968	java/io/IOException
    //   960	965	992	java/io/IOException
    //   1023	1029	1080	java/lang/InterruptedException
    //   595	617	1090	finally
    //   595	617	1098	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */