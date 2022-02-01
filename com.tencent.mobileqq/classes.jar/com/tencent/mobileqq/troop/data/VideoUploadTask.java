package com.tencent.mobileqq.troop.data;

import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String c;
  private static String d;
  protected long a;
  protected TroopBarShortVideoUploadUtil.OnUploadVideoListener a;
  public TroopBarUploadItemEntity a;
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
    //   0: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: aload_0
    //   6: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: iconst_0
    //   10: invokevirtual 26	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   13: aload_0
    //   14: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   17: ifnonnull +26 -> 43
    //   20: aload_0
    //   21: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_1
    //   25: invokevirtual 26	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   28: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 52
    //   36: iconst_2
    //   37: ldc 54
    //   39: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   47: ifnull +1016 -> 1063
    //   50: aload_0
    //   51: getfield 61	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +1006 -> 1063
    //   60: aload_0
    //   61: getfield 69	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +6 -> 73
    //   70: goto +993 -> 1063
    //   73: aload_0
    //   74: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   77: getfield 72	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: astore 14
    //   82: new 74	android/os/Bundle
    //   85: dup
    //   86: invokespecial 77	android/os/Bundle:<init>	()V
    //   89: astore 12
    //   91: aload 12
    //   93: ldc 79
    //   95: getstatic 81	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   98: invokevirtual 85	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 12
    //   103: ldc 87
    //   105: aload 14
    //   107: invokevirtual 85	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 12
    //   112: ldc 89
    //   114: getstatic 91	com/tencent/mobileqq/troop/data/VideoUploadTask:d	Ljava/lang/String;
    //   117: invokevirtual 85	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 12
    //   122: ldc 93
    //   124: aload_0
    //   125: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   128: getfield 94	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: invokevirtual 85	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 12
    //   136: ldc 96
    //   138: aload_0
    //   139: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   142: getfield 97	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:c	Ljava/lang/String;
    //   145: invokevirtual 85	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 12
    //   150: ldc 99
    //   152: aload_0
    //   153: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   156: getfield 102	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_b_of_type_Int	I
    //   159: invokevirtual 106	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   162: invokestatic 112	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   165: invokestatic 118	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   168: ifeq +180 -> 348
    //   171: aload_0
    //   172: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   175: invokevirtual 30	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   178: ifne +170 -> 348
    //   181: aload_0
    //   182: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   185: getfield 102	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_b_of_type_Int	I
    //   188: iconst_3
    //   189: if_icmpne +141 -> 330
    //   192: aload_0
    //   193: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   196: getfield 121	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   199: ifnull +28 -> 227
    //   202: aload_0
    //   203: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   206: getfield 121	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   209: getfield 126	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   212: ifnull +15 -> 227
    //   215: aload_0
    //   216: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   219: getfield 121	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   222: astore 12
    //   224: goto +127 -> 351
    //   227: aload 12
    //   229: aload_0
    //   230: getfield 61	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: aload_0
    //   234: getfield 69	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   237: invokestatic 131	com/tencent/mobileqq/troop/utils/TroopRewardUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   240: astore 13
    //   242: aload 13
    //   244: astore 12
    //   246: aload 13
    //   248: ifnull +103 -> 351
    //   251: aload_0
    //   252: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   255: aload 13
    //   257: getfield 126	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   260: putfield 97	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:c	Ljava/lang/String;
    //   263: new 133	java/io/File
    //   266: dup
    //   267: aload_0
    //   268: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   271: getfield 72	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   274: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore 12
    //   279: aload 12
    //   281: invokevirtual 139	java/io/File:exists	()Z
    //   284: ifeq +15 -> 299
    //   287: aload_0
    //   288: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   291: aload 12
    //   293: invokevirtual 142	java/io/File:length	()J
    //   296: putfield 144	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_Long	J
    //   299: aload_0
    //   300: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   303: astore 12
    //   305: aload 12
    //   307: aload 12
    //   309: getfield 72	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   312: invokestatic 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   315: ldc2_w 151
    //   318: ldiv
    //   319: l2i
    //   320: putfield 154	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_Int	I
    //   323: aload 13
    //   325: astore 12
    //   327: goto +24 -> 351
    //   330: aload 12
    //   332: aload_0
    //   333: getfield 61	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   336: aload_0
    //   337: getfield 69	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   340: invokestatic 157	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   343: astore 12
    //   345: goto +6 -> 351
    //   348: aconst_null
    //   349: astore 12
    //   351: aload 12
    //   353: ifnull +550 -> 903
    //   356: ldc 159
    //   358: aload 12
    //   360: getfield 162	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   363: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +8 -> 374
    //   369: iconst_1
    //   370: istore_1
    //   371: goto +534 -> 905
    //   374: aload 12
    //   376: getfield 126	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   379: ifnull +524 -> 903
    //   382: aload 12
    //   384: getfield 169	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   387: invokestatic 175	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   390: astore 15
    //   392: aload 14
    //   394: invokestatic 179	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   397: astore 16
    //   399: aload 14
    //   401: invokestatic 184	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   404: lstore 4
    //   406: lload 4
    //   408: ldc2_w 185
    //   411: lcmp
    //   412: ifle +10 -> 422
    //   415: ldc2_w 185
    //   418: lstore_2
    //   419: goto +6 -> 425
    //   422: lload 4
    //   424: lstore_2
    //   425: new 188	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   432: astore 13
    //   434: aload 13
    //   436: ldc 191
    //   438: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 13
    //   444: aload 12
    //   446: getfield 196	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   449: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 13
    //   455: ldc 198
    //   457: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 13
    //   463: aload 12
    //   465: getfield 199	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   468: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 13
    //   474: ldc 201
    //   476: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 13
    //   482: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: astore 17
    //   487: aload_0
    //   488: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   491: invokeinterface 209 1 0
    //   496: new 211	java/io/RandomAccessFile
    //   499: dup
    //   500: aload 14
    //   502: ldc 213
    //   504: invokespecial 215	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: astore 13
    //   509: lconst_0
    //   510: lstore 6
    //   512: lload_2
    //   513: lload 6
    //   515: lsub
    //   516: l2i
    //   517: istore_1
    //   518: aload 13
    //   520: astore 12
    //   522: invokestatic 112	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   525: invokestatic 118	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   528: ifeq +156 -> 684
    //   531: aload 13
    //   533: astore 12
    //   535: aload_0
    //   536: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   539: invokevirtual 30	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   542: ifne +142 -> 684
    //   545: aload 13
    //   547: astore 12
    //   549: aload 15
    //   551: aload 16
    //   553: aload 17
    //   555: lload 4
    //   557: aload 13
    //   559: lload 6
    //   561: iload_1
    //   562: invokestatic 218	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   565: lstore 6
    //   567: aload 13
    //   569: astore 12
    //   571: aload_0
    //   572: lload 6
    //   574: putfield 219	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   577: lload 6
    //   579: ldc2_w 220
    //   582: lcmp
    //   583: ifeq +32 -> 615
    //   586: aload 13
    //   588: astore 12
    //   590: aload_0
    //   591: invokevirtual 223	com/tencent/mobileqq/troop/data/VideoUploadTask:a	()Z
    //   594: ifne +580 -> 1174
    //   597: aload 13
    //   599: astore 12
    //   601: aload_0
    //   602: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   605: lload 6
    //   607: invokeinterface 226 3 0
    //   612: goto +562 -> 1174
    //   615: aload 13
    //   617: astore 12
    //   619: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +128 -> 750
    //   625: aload 13
    //   627: astore 12
    //   629: new 188	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   636: astore 14
    //   638: aload 13
    //   640: astore 12
    //   642: aload 14
    //   644: ldc 228
    //   646: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 13
    //   652: astore 12
    //   654: aload 14
    //   656: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   659: lload 10
    //   661: lsub
    //   662: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 13
    //   668: astore 12
    //   670: ldc 52
    //   672: iconst_2
    //   673: aload 14
    //   675: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: goto +69 -> 750
    //   684: aload 13
    //   686: astore 12
    //   688: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +59 -> 750
    //   694: aload 13
    //   696: astore 12
    //   698: new 188	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   705: astore 14
    //   707: aload 13
    //   709: astore 12
    //   711: aload 14
    //   713: ldc 233
    //   715: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 13
    //   721: astore 12
    //   723: aload 14
    //   725: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   728: lload 10
    //   730: lsub
    //   731: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 13
    //   737: astore 12
    //   739: ldc 52
    //   741: iconst_2
    //   742: aload 14
    //   744: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: aload 13
    //   752: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   755: goto -386 -> 369
    //   758: astore 12
    //   760: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   763: ifeq -394 -> 369
    //   766: ldc 52
    //   768: iconst_2
    //   769: aload 12
    //   771: invokestatic 240	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   774: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: goto -408 -> 369
    //   780: astore 14
    //   782: goto +16 -> 798
    //   785: astore 12
    //   787: aconst_null
    //   788: astore 14
    //   790: goto +78 -> 868
    //   793: astore 14
    //   795: aconst_null
    //   796: astore 13
    //   798: aload 13
    //   800: astore 12
    //   802: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   805: ifeq +18 -> 823
    //   808: aload 13
    //   810: astore 12
    //   812: ldc 52
    //   814: iconst_2
    //   815: aload 14
    //   817: invokestatic 240	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   820: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: aload 13
    //   825: ifnull +78 -> 903
    //   828: aload 13
    //   830: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   833: goto +70 -> 903
    //   836: astore 12
    //   838: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq +62 -> 903
    //   844: ldc 52
    //   846: iconst_2
    //   847: aload 12
    //   849: invokestatic 240	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   852: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   855: goto +48 -> 903
    //   858: astore 13
    //   860: aload 12
    //   862: astore 14
    //   864: aload 13
    //   866: astore 12
    //   868: aload 14
    //   870: ifnull +30 -> 900
    //   873: aload 14
    //   875: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   878: goto +22 -> 900
    //   881: astore 13
    //   883: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   886: ifeq +14 -> 900
    //   889: ldc 52
    //   891: iconst_2
    //   892: aload 13
    //   894: invokestatic 240	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   897: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: aload 12
    //   902: athrow
    //   903: iconst_0
    //   904: istore_1
    //   905: aload_0
    //   906: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   909: iconst_0
    //   910: iconst_1
    //   911: invokevirtual 244	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   914: ifeq +148 -> 1062
    //   917: iload_1
    //   918: ifeq +59 -> 977
    //   921: aload_0
    //   922: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   925: invokeinterface 246 1 0
    //   930: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   933: ifeq +129 -> 1062
    //   936: new 188	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   943: astore 12
    //   945: aload 12
    //   947: ldc 248
    //   949: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload 12
    //   955: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   958: lload 10
    //   960: lsub
    //   961: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: ldc 52
    //   967: iconst_2
    //   968: aload 12
    //   970: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: return
    //   977: invokestatic 112	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   980: invokestatic 118	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   983: ifne +19 -> 1002
    //   986: ldc2_w 249
    //   989: invokestatic 255	java/lang/Thread:sleep	(J)V
    //   992: goto +10 -> 1002
    //   995: astore 12
    //   997: aload 12
    //   999: invokevirtual 258	java/lang/InterruptedException:printStackTrace	()V
    //   1002: aload_0
    //   1003: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1006: aload_0
    //   1007: getfield 219	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   1010: invokeinterface 260 3 0
    //   1015: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1018: ifeq +44 -> 1062
    //   1021: new 188	java/lang/StringBuilder
    //   1024: dup
    //   1025: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1028: astore 12
    //   1030: aload 12
    //   1032: ldc_w 262
    //   1035: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 12
    //   1041: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   1044: lload 10
    //   1046: lsub
    //   1047: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: ldc 52
    //   1053: iconst_2
    //   1054: aload 12
    //   1056: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1062: return
    //   1063: aload_0
    //   1064: getfield 20	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1067: iconst_1
    //   1068: invokevirtual 26	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1071: aload_0
    //   1072: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1075: ldc2_w 220
    //   1078: invokeinterface 260 3 0
    //   1083: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1086: ifeq +87 -> 1173
    //   1089: aload_0
    //   1090: getfield 59	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   1093: ifnonnull +11 -> 1104
    //   1096: ldc_w 264
    //   1099: astore 12
    //   1101: goto +26 -> 1127
    //   1104: aload_0
    //   1105: getfield 61	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1108: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1111: ifeq +11 -> 1122
    //   1114: ldc_w 266
    //   1117: astore 12
    //   1119: goto +8 -> 1127
    //   1122: ldc_w 268
    //   1125: astore 12
    //   1127: new 188	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1134: astore 13
    //   1136: aload 13
    //   1138: ldc_w 270
    //   1141: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload 13
    //   1147: aload 12
    //   1149: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 13
    //   1155: ldc_w 272
    //   1158: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: ldc 52
    //   1164: iconst_2
    //   1165: aload 13
    //   1167: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1173: return
    //   1174: lload 6
    //   1176: ldc2_w 185
    //   1179: ladd
    //   1180: lstore 8
    //   1182: lload 8
    //   1184: lstore_2
    //   1185: lload 8
    //   1187: lload 4
    //   1189: lcmp
    //   1190: ifle +6 -> 1196
    //   1193: lload 4
    //   1195: lstore_2
    //   1196: lload 6
    //   1198: lload 4
    //   1200: lcmp
    //   1201: iflt +6 -> 1207
    //   1204: goto -454 -> 750
    //   1207: goto -695 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1210	0	this	VideoUploadTask
    //   370	548	1	i	int
    //   418	778	2	l1	long
    //   404	795	4	l2	long
    //   510	687	6	l3	long
    //   1180	6	8	l4	long
    //   3	1042	10	l5	long
    //   89	649	12	localObject1	Object
    //   758	12	12	localIOException1	java.io.IOException
    //   785	1	12	localObject2	Object
    //   800	11	12	localObject3	Object
    //   836	25	12	localIOException2	java.io.IOException
    //   866	103	12	localObject4	Object
    //   995	3	12	localInterruptedException	java.lang.InterruptedException
    //   1028	120	12	localObject5	Object
    //   240	589	13	localObject6	Object
    //   858	7	13	localObject7	Object
    //   881	12	13	localIOException3	java.io.IOException
    //   1134	32	13	localStringBuilder	java.lang.StringBuilder
    //   80	663	14	localObject8	Object
    //   780	1	14	localException1	java.lang.Exception
    //   788	1	14	localObject9	Object
    //   793	23	14	localException2	java.lang.Exception
    //   862	12	14	localObject10	Object
    //   390	160	15	arrayOfByte1	byte[]
    //   397	155	16	arrayOfByte2	byte[]
    //   485	69	17	str	String
    // Exception table:
    //   from	to	target	type
    //   750	755	758	java/io/IOException
    //   522	531	780	java/lang/Exception
    //   535	545	780	java/lang/Exception
    //   549	567	780	java/lang/Exception
    //   571	577	780	java/lang/Exception
    //   590	597	780	java/lang/Exception
    //   601	612	780	java/lang/Exception
    //   619	625	780	java/lang/Exception
    //   629	638	780	java/lang/Exception
    //   642	650	780	java/lang/Exception
    //   654	666	780	java/lang/Exception
    //   670	681	780	java/lang/Exception
    //   688	694	780	java/lang/Exception
    //   698	707	780	java/lang/Exception
    //   711	719	780	java/lang/Exception
    //   723	735	780	java/lang/Exception
    //   739	750	780	java/lang/Exception
    //   487	509	785	finally
    //   487	509	793	java/lang/Exception
    //   828	833	836	java/io/IOException
    //   522	531	858	finally
    //   535	545	858	finally
    //   549	567	858	finally
    //   571	577	858	finally
    //   590	597	858	finally
    //   601	612	858	finally
    //   619	625	858	finally
    //   629	638	858	finally
    //   642	650	858	finally
    //   654	666	858	finally
    //   670	681	858	finally
    //   688	694	858	finally
    //   698	707	858	finally
    //   711	719	858	finally
    //   723	735	858	finally
    //   739	750	858	finally
    //   802	808	858	finally
    //   812	823	858	finally
    //   873	878	881	java/io/IOException
    //   986	992	995	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */