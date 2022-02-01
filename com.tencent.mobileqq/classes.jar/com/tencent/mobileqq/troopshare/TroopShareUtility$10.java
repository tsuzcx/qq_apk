package com.tencent.mobileqq.troopshare;

class TroopShareUtility$10
  implements Runnable
{
  TroopShareUtility$10(TroopShareUtility paramTroopShareUtility, TroopShareUtility.UploadHeaderCallback paramUploadHeaderCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   4: getfield 28	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/QBaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   10: checkcast 36	com/tencent/mobileqq/app/QQAppInterface
    //   13: astore 9
    //   15: aload 9
    //   17: iconst_2
    //   18: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   21: checkcast 42	mqq/manager/TicketManager
    //   24: aload 9
    //   26: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokeinterface 50 2 0
    //   34: astore 10
    //   36: aload 9
    //   38: getstatic 56	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   41: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   44: checkcast 58	com/tencent/mobileqq/app/TroopManager
    //   47: aload_0
    //   48: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   51: getfield 61	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData	Lcom/tencent/mobileqq/troop/data/TroopInfoData;
    //   54: getfield 67	com/tencent/mobileqq/troop/data/TroopInfoData:troopUin	Ljava/lang/String;
    //   57: invokevirtual 71	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   60: astore 4
    //   62: aload 10
    //   64: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +530 -> 597
    //   70: aload 4
    //   72: ifnull +525 -> 597
    //   75: aload 4
    //   77: getfield 82	com/tencent/mobileqq/data/troop/TroopInfo:wMemberNum	I
    //   80: istore_1
    //   81: aconst_null
    //   82: astore 8
    //   84: iconst_1
    //   85: iload_1
    //   86: if_icmpne +306 -> 392
    //   89: invokestatic 87	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   92: ifeq +11 -> 103
    //   95: getstatic 92	com/tencent/mobileqq/app/AppConstants:PATH_HEAD_HD	Ljava/lang/String;
    //   98: astore 4
    //   100: goto +7 -> 107
    //   103: ldc 94
    //   105: astore 4
    //   107: new 96	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   114: astore 5
    //   116: aload 5
    //   118: aload 4
    //   120: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 5
    //   126: ldc 103
    //   128: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 5
    //   134: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 6
    //   139: new 108	java/io/File
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 4
    //   150: aload 6
    //   152: astore 5
    //   154: aload 4
    //   156: invokevirtual 114	java/io/File:exists	()Z
    //   159: ifne +236 -> 395
    //   162: aload 4
    //   164: invokevirtual 117	java/io/File:createNewFile	()Z
    //   167: pop
    //   168: new 119	java/io/BufferedOutputStream
    //   171: dup
    //   172: new 121	java/io/FileOutputStream
    //   175: dup
    //   176: aload 4
    //   178: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: sipush 8192
    //   184: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   187: astore 4
    //   189: aload 4
    //   191: astore 5
    //   193: invokestatic 132	com/tencent/mobileqq/utils/ImageUtil:c	()Landroid/graphics/drawable/Drawable;
    //   196: checkcast 134	android/graphics/drawable/BitmapDrawable
    //   199: invokevirtual 138	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   202: getstatic 144	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   205: bipush 100
    //   207: aload 4
    //   209: invokevirtual 150	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   212: istore_3
    //   213: aload 4
    //   215: invokevirtual 155	java/io/OutputStream:close	()V
    //   218: aload 6
    //   220: astore 4
    //   222: iload_3
    //   223: istore_2
    //   224: goto +177 -> 401
    //   227: astore 5
    //   229: aload 6
    //   231: astore 4
    //   233: iload_3
    //   234: istore_2
    //   235: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +163 -> 401
    //   241: ldc 162
    //   243: iconst_2
    //   244: aload 5
    //   246: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: aload 5
    //   251: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 6
    //   256: astore 4
    //   258: iload_3
    //   259: istore_2
    //   260: goto +141 -> 401
    //   263: astore 7
    //   265: goto +16 -> 281
    //   268: astore 4
    //   270: aconst_null
    //   271: astore 5
    //   273: goto +82 -> 355
    //   276: astore 7
    //   278: aconst_null
    //   279: astore 4
    //   281: aload 4
    //   283: astore 5
    //   285: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +12 -> 300
    //   291: aload 4
    //   293: astore 5
    //   295: aload 7
    //   297: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   300: aload 6
    //   302: astore 5
    //   304: aload 4
    //   306: ifnull +89 -> 395
    //   309: aload 4
    //   311: invokevirtual 155	java/io/OutputStream:close	()V
    //   314: aload 6
    //   316: astore 5
    //   318: goto +77 -> 395
    //   321: astore 4
    //   323: aload 6
    //   325: astore 5
    //   327: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +65 -> 395
    //   333: ldc 162
    //   335: iconst_2
    //   336: aload 4
    //   338: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   341: aload 4
    //   343: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: aload 6
    //   348: astore 5
    //   350: goto +45 -> 395
    //   353: astore 4
    //   355: aload 5
    //   357: ifnull +32 -> 389
    //   360: aload 5
    //   362: invokevirtual 155	java/io/OutputStream:close	()V
    //   365: goto +24 -> 389
    //   368: astore 5
    //   370: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +16 -> 389
    //   376: ldc 162
    //   378: iconst_2
    //   379: aload 5
    //   381: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   384: aload 5
    //   386: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   389: aload 4
    //   391: athrow
    //   392: aconst_null
    //   393: astore 5
    //   395: iconst_0
    //   396: istore_2
    //   397: aload 5
    //   399: astore 4
    //   401: new 174	java/util/ArrayList
    //   404: dup
    //   405: invokespecial 175	java/util/ArrayList:<init>	()V
    //   408: astore 6
    //   410: aload 9
    //   412: bipush 113
    //   414: aload_0
    //   415: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   418: getfield 61	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData	Lcom/tencent/mobileqq/troop/data/TroopInfoData;
    //   421: getfield 67	com/tencent/mobileqq/troop/data/TroopInfoData:troopUin	Ljava/lang/String;
    //   424: iconst_0
    //   425: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ILjava/lang/String;I)Ljava/lang/String;
    //   428: astore 5
    //   430: new 108	java/io/File
    //   433: dup
    //   434: aload 5
    //   436: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   439: astore 7
    //   441: iload_1
    //   442: iconst_1
    //   443: if_icmpeq +11 -> 454
    //   446: aload 7
    //   448: invokevirtual 114	java/io/File:exists	()Z
    //   451: ifne +7 -> 458
    //   454: aload 4
    //   456: astore 5
    //   458: aload 6
    //   460: aload 5
    //   462: invokevirtual 183	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   465: pop
    //   466: aload 6
    //   468: aload 9
    //   470: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   473: aload 10
    //   475: ldc 188
    //   477: invokestatic 194	cooperation/qzone/QZoneShareManager:batchUploadImages	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   480: astore 5
    //   482: aload 8
    //   484: astore 4
    //   486: iload_2
    //   487: istore_3
    //   488: aload 5
    //   490: ifnull +74 -> 564
    //   493: aload 8
    //   495: astore 4
    //   497: iload_2
    //   498: istore_3
    //   499: aload 5
    //   501: invokevirtual 198	java/util/ArrayList:size	()I
    //   504: ifle +60 -> 564
    //   507: aload 5
    //   509: iconst_0
    //   510: invokevirtual 202	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   513: checkcast 204	java/lang/String
    //   516: astore 5
    //   518: aload 5
    //   520: astore 4
    //   522: iload_2
    //   523: istore_3
    //   524: aload 5
    //   526: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   529: ifne +35 -> 564
    //   532: aload 5
    //   534: ldc 206
    //   536: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   539: ifne +19 -> 558
    //   542: aload 5
    //   544: astore 4
    //   546: iload_2
    //   547: istore_3
    //   548: aload 5
    //   550: ldc 212
    //   552: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   555: ifeq +9 -> 564
    //   558: iconst_1
    //   559: istore_3
    //   560: aload 5
    //   562: astore 4
    //   564: iload_3
    //   565: ifne +7 -> 572
    //   568: ldc 214
    //   570: astore 4
    //   572: new 216	android/os/Handler
    //   575: dup
    //   576: invokestatic 222	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   579: invokespecial 225	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   582: new 227	com/tencent/mobileqq/troopshare/TroopShareUtility$10$1
    //   585: dup
    //   586: aload_0
    //   587: iload_3
    //   588: aload 4
    //   590: invokespecial 230	com/tencent/mobileqq/troopshare/TroopShareUtility$10$1:<init>	(Lcom/tencent/mobileqq/troopshare/TroopShareUtility$10;ZLjava/lang/String;)V
    //   593: invokevirtual 234	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   596: pop
    //   597: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	10
    //   80	364	1	i	int
    //   223	324	2	bool1	boolean
    //   212	376	3	bool2	boolean
    //   60	197	4	localObject1	Object
    //   268	1	4	localObject2	Object
    //   279	31	4	localObject3	Object
    //   321	21	4	localIOException1	java.io.IOException
    //   353	37	4	localObject4	Object
    //   399	190	4	localObject5	Object
    //   114	78	5	localObject6	Object
    //   227	23	5	localIOException2	java.io.IOException
    //   271	90	5	localObject7	Object
    //   368	17	5	localIOException3	java.io.IOException
    //   393	168	5	localObject8	Object
    //   137	330	6	localObject9	Object
    //   263	1	7	localIOException4	java.io.IOException
    //   276	20	7	localIOException5	java.io.IOException
    //   439	8	7	localFile	java.io.File
    //   82	412	8	localObject10	Object
    //   13	456	9	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   34	440	10	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   213	218	227	java/io/IOException
    //   193	213	263	java/io/IOException
    //   162	189	268	finally
    //   162	189	276	java/io/IOException
    //   309	314	321	java/io/IOException
    //   193	213	353	finally
    //   285	291	353	finally
    //   295	300	353	finally
    //   360	365	368	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.10
 * JD-Core Version:    0.7.0.1
 */