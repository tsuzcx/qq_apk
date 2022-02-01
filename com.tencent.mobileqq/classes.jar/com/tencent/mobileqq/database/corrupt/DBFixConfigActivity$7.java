package com.tencent.mobileqq.database.corrupt;

class DBFixConfigActivity$7
  implements Runnable
{
  DBFixConfigActivity$7(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   4: invokevirtual 25	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7: astore 7
    //   9: aload 7
    //   11: instanceof 27
    //   14: istore 6
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 13
    //   22: iload 6
    //   24: ifeq +20 -> 44
    //   27: aload 7
    //   29: checkcast 27	com/tencent/mobileqq/app/QQAppInterface
    //   32: astore 11
    //   34: aload 11
    //   36: invokevirtual 31	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   39: astore 12
    //   41: goto +10 -> 51
    //   44: aconst_null
    //   45: astore 11
    //   47: aload 11
    //   49: astore 12
    //   51: aload 11
    //   53: ifnull +724 -> 777
    //   56: aload 12
    //   58: ifnonnull +6 -> 64
    //   61: goto +716 -> 777
    //   64: aload_0
    //   65: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   68: astore 7
    //   70: new 33	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload 12
    //   83: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: ldc 40
    //   91: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 7
    //   97: aload 8
    //   99: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 47	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   105: astore 14
    //   107: aload_0
    //   108: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   111: ldc 49
    //   113: invokevirtual 47	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   116: astore 15
    //   118: aload 14
    //   120: invokevirtual 55	java/io/File:exists	()Z
    //   123: ifne +23 -> 146
    //   126: aload_0
    //   127: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   130: getfield 59	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   133: new 61	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$2
    //   136: dup
    //   137: aload_0
    //   138: invokespecial 64	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$2:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   141: invokevirtual 70	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   144: pop
    //   145: return
    //   146: new 72	java/io/BufferedOutputStream
    //   149: dup
    //   150: new 74	java/io/FileOutputStream
    //   153: dup
    //   154: aload 15
    //   156: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   162: astore 7
    //   164: aload 7
    //   166: astore 8
    //   168: new 82	java/io/BufferedInputStream
    //   171: dup
    //   172: new 84	java/io/FileInputStream
    //   175: dup
    //   176: aload 14
    //   178: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   181: invokespecial 88	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   184: astore 10
    //   186: sipush 8192
    //   189: newarray byte
    //   191: astore 8
    //   193: iconst_0
    //   194: istore_1
    //   195: aload 10
    //   197: aload 8
    //   199: iconst_0
    //   200: sipush 8192
    //   203: invokevirtual 92	java/io/BufferedInputStream:read	([BII)I
    //   206: istore_2
    //   207: iload_2
    //   208: iconst_m1
    //   209: if_icmpeq +161 -> 370
    //   212: iload_1
    //   213: ifne +145 -> 358
    //   216: aload 8
    //   218: bipush 28
    //   220: baload
    //   221: istore_3
    //   222: aload 8
    //   224: bipush 29
    //   226: baload
    //   227: istore 4
    //   229: aload 8
    //   231: bipush 30
    //   233: baload
    //   234: istore 5
    //   236: aload 8
    //   238: bipush 31
    //   240: baload
    //   241: sipush 255
    //   244: iand
    //   245: iload_3
    //   246: bipush 24
    //   248: ishl
    //   249: iload 4
    //   251: bipush 16
    //   253: ishl
    //   254: ldc 93
    //   256: iand
    //   257: ior
    //   258: iload 5
    //   260: bipush 8
    //   262: ishl
    //   263: ldc 94
    //   265: iand
    //   266: ior
    //   267: ior
    //   268: istore_3
    //   269: getstatic 97	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: iconst_1
    //   273: iconst_2
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: ldc 99
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: iload_3
    //   285: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: iload_3
    //   293: bipush 10
    //   295: iadd
    //   296: istore_3
    //   297: aload 8
    //   299: bipush 28
    //   301: iload_3
    //   302: bipush 24
    //   304: ishr
    //   305: i2b
    //   306: bastore
    //   307: aload 8
    //   309: bipush 29
    //   311: iload_3
    //   312: bipush 16
    //   314: ishr
    //   315: sipush 255
    //   318: iand
    //   319: i2b
    //   320: bastore
    //   321: aload 8
    //   323: bipush 30
    //   325: iload_3
    //   326: bipush 8
    //   328: ishr
    //   329: sipush 255
    //   332: iand
    //   333: i2b
    //   334: bastore
    //   335: aload 8
    //   337: bipush 31
    //   339: iload_3
    //   340: sipush 255
    //   343: iand
    //   344: i2b
    //   345: bastore
    //   346: aload 7
    //   348: aload 8
    //   350: iconst_0
    //   351: iload_2
    //   352: invokevirtual 115	java/io/BufferedOutputStream:write	([BII)V
    //   355: goto +442 -> 797
    //   358: aload 7
    //   360: aload 8
    //   362: iconst_0
    //   363: iload_2
    //   364: invokevirtual 115	java/io/BufferedOutputStream:write	([BII)V
    //   367: goto +430 -> 797
    //   370: aload 11
    //   372: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   375: getstatic 124	com/tencent/mobileqq/database/corrupt/DBFixManager:b	Ljava/lang/String;
    //   378: iconst_0
    //   379: invokevirtual 130	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   382: astore 8
    //   384: aload 12
    //   386: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifne +140 -> 529
    //   392: new 33	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   399: astore 9
    //   401: aload 9
    //   403: aload 12
    //   405: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 9
    //   411: getstatic 138	com/tencent/mobileqq/database/corrupt/DBFixManager:d	Ljava/lang/String;
    //   414: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 8
    //   420: aload 9
    //   422: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: iconst_0
    //   426: invokeinterface 144 3 0
    //   431: ifeq +98 -> 529
    //   434: aload 8
    //   436: invokeinterface 148 1 0
    //   441: astore 8
    //   443: new 33	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   450: astore 9
    //   452: aload 9
    //   454: aload 12
    //   456: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 9
    //   462: getstatic 138	com/tencent/mobileqq/database/corrupt/DBFixManager:d	Ljava/lang/String;
    //   465: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 8
    //   471: aload 9
    //   473: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokeinterface 154 2 0
    //   481: pop
    //   482: new 33	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   489: astore 9
    //   491: aload 9
    //   493: aload 12
    //   495: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload 9
    //   501: getstatic 157	com/tencent/mobileqq/database/corrupt/DBFixManager:e	Ljava/lang/String;
    //   504: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 8
    //   510: aload 9
    //   512: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokeinterface 154 2 0
    //   520: pop
    //   521: aload 8
    //   523: invokeinterface 160 1 0
    //   528: pop
    //   529: aload 11
    //   531: getstatic 166	com/tencent/mobileqq/app/QQManagerFactory:DB_FIX_MANAGER	I
    //   534: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   537: checkcast 121	com/tencent/mobileqq/database/corrupt/DBFixManager
    //   540: astore 8
    //   542: aload 8
    //   544: iconst_1
    //   545: invokevirtual 173	com/tencent/mobileqq/database/corrupt/DBFixManager:b	(Z)V
    //   548: aload 15
    //   550: aload 14
    //   552: invokevirtual 177	java/io/File:renameTo	(Ljava/io/File;)Z
    //   555: pop
    //   556: aload_0
    //   557: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   560: getfield 59	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   563: new 179	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$3
    //   566: dup
    //   567: aload_0
    //   568: invokespecial 180	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$3:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   571: invokevirtual 70	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   574: pop
    //   575: aload 8
    //   577: invokevirtual 182	com/tencent/mobileqq/database/corrupt/DBFixManager:d	()V
    //   580: aload 10
    //   582: invokevirtual 185	java/io/BufferedInputStream:close	()V
    //   585: goto +10 -> 595
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   595: aload 7
    //   597: invokevirtual 189	java/io/BufferedOutputStream:close	()V
    //   600: return
    //   601: astore 8
    //   603: aload 10
    //   605: astore 9
    //   607: goto +127 -> 734
    //   610: astore 8
    //   612: aload 10
    //   614: astore 11
    //   616: aload 8
    //   618: astore 10
    //   620: goto +33 -> 653
    //   623: astore 10
    //   625: aload 13
    //   627: astore 11
    //   629: goto +24 -> 653
    //   632: astore 8
    //   634: aconst_null
    //   635: astore 7
    //   637: aload 7
    //   639: astore 9
    //   641: goto +93 -> 734
    //   644: astore 10
    //   646: aconst_null
    //   647: astore 7
    //   649: aload 13
    //   651: astore 11
    //   653: aload 11
    //   655: astore 9
    //   657: aload 7
    //   659: astore 8
    //   661: getstatic 97	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   664: iconst_1
    //   665: ldc 191
    //   667: aload 10
    //   669: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   672: aload 11
    //   674: astore 9
    //   676: aload 7
    //   678: astore 8
    //   680: aload 10
    //   682: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   685: aload 11
    //   687: ifnull +18 -> 705
    //   690: aload 11
    //   692: invokevirtual 185	java/io/BufferedInputStream:close	()V
    //   695: goto +10 -> 705
    //   698: astore 8
    //   700: aload 8
    //   702: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   705: aload 7
    //   707: ifnull +16 -> 723
    //   710: aload 7
    //   712: invokevirtual 189	java/io/BufferedOutputStream:close	()V
    //   715: return
    //   716: astore 7
    //   718: aload 7
    //   720: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   723: return
    //   724: astore 10
    //   726: aload 8
    //   728: astore 7
    //   730: aload 10
    //   732: astore 8
    //   734: aload 9
    //   736: ifnull +18 -> 754
    //   739: aload 9
    //   741: invokevirtual 185	java/io/BufferedInputStream:close	()V
    //   744: goto +10 -> 754
    //   747: astore 9
    //   749: aload 9
    //   751: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   754: aload 7
    //   756: ifnull +18 -> 774
    //   759: aload 7
    //   761: invokevirtual 189	java/io/BufferedOutputStream:close	()V
    //   764: goto +10 -> 774
    //   767: astore 7
    //   769: aload 7
    //   771: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   774: aload 8
    //   776: athrow
    //   777: aload_0
    //   778: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   781: getfield 59	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   784: new 196	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$1
    //   787: dup
    //   788: aload_0
    //   789: invokespecial 197	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$1:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   792: invokevirtual 70	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   795: pop
    //   796: return
    //   797: iload_1
    //   798: iload_2
    //   799: iadd
    //   800: istore_1
    //   801: goto -606 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	this	7
    //   194	607	1	i	int
    //   206	594	2	j	int
    //   221	123	3	k	int
    //   227	27	4	m	int
    //   234	29	5	n	int
    //   14	9	6	bool	boolean
    //   7	704	7	localObject1	Object
    //   716	3	7	localIOException1	java.io.IOException
    //   728	32	7	localObject2	Object
    //   767	3	7	localIOException2	java.io.IOException
    //   77	499	8	localObject3	Object
    //   588	3	8	localIOException3	java.io.IOException
    //   601	1	8	localObject4	Object
    //   610	7	8	localIOException4	java.io.IOException
    //   632	1	8	localObject5	Object
    //   659	20	8	localObject6	Object
    //   698	29	8	localIOException5	java.io.IOException
    //   732	43	8	localObject7	Object
    //   17	723	9	localObject8	Object
    //   747	3	9	localIOException6	java.io.IOException
    //   184	435	10	localObject9	Object
    //   623	1	10	localIOException7	java.io.IOException
    //   644	37	10	localIOException8	java.io.IOException
    //   724	7	10	localObject10	Object
    //   32	659	11	localObject11	Object
    //   39	455	12	localObject12	Object
    //   20	630	13	localObject13	Object
    //   105	446	14	localFile1	java.io.File
    //   116	433	15	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   580	585	588	java/io/IOException
    //   186	193	601	finally
    //   195	207	601	finally
    //   269	292	601	finally
    //   346	355	601	finally
    //   358	367	601	finally
    //   370	529	601	finally
    //   529	580	601	finally
    //   186	193	610	java/io/IOException
    //   195	207	610	java/io/IOException
    //   269	292	610	java/io/IOException
    //   346	355	610	java/io/IOException
    //   358	367	610	java/io/IOException
    //   370	529	610	java/io/IOException
    //   529	580	610	java/io/IOException
    //   168	186	623	java/io/IOException
    //   146	164	632	finally
    //   146	164	644	java/io/IOException
    //   690	695	698	java/io/IOException
    //   595	600	716	java/io/IOException
    //   710	715	716	java/io/IOException
    //   168	186	724	finally
    //   661	672	724	finally
    //   680	685	724	finally
    //   739	744	747	java/io/IOException
    //   759	764	767	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.7
 * JD-Core Version:    0.7.0.1
 */