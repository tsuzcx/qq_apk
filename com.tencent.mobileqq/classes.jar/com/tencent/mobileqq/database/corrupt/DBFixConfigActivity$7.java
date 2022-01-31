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
    //   7: astore 4
    //   9: aload 4
    //   11: instanceof 27
    //   14: ifeq +721 -> 735
    //   17: aload 4
    //   19: checkcast 27	com/tencent/mobileqq/app/QQAppInterface
    //   22: astore 4
    //   24: aload 4
    //   26: invokevirtual 31	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: astore 7
    //   31: aload 4
    //   33: ifnull +8 -> 41
    //   36: aload 7
    //   38: ifnonnull +23 -> 61
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   45: getfield 35	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   48: new 37	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$1
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 40	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$1:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   56: invokevirtual 46	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: return
    //   61: aload_0
    //   62: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   65: new 48	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   72: aload 7
    //   74: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 55
    //   79: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 62	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   88: astore 8
    //   90: aload_0
    //   91: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   94: ldc 64
    //   96: invokevirtual 62	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   99: astore 9
    //   101: aload 8
    //   103: invokevirtual 70	java/io/File:exists	()Z
    //   106: ifne +23 -> 129
    //   109: aload_0
    //   110: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   113: getfield 35	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   116: new 72	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$2
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 73	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$2:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   124: invokevirtual 46	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   127: pop
    //   128: return
    //   129: new 75	java/io/BufferedOutputStream
    //   132: dup
    //   133: new 77	java/io/FileOutputStream
    //   136: dup
    //   137: aload 9
    //   139: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: invokespecial 83	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   145: astore 6
    //   147: new 85	java/io/BufferedInputStream
    //   150: dup
    //   151: new 87	java/io/FileInputStream
    //   154: dup
    //   155: aload 8
    //   157: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   163: astore 5
    //   165: sipush 8192
    //   168: newarray byte
    //   170: astore 10
    //   172: iconst_0
    //   173: istore_1
    //   174: aload 5
    //   176: aload 10
    //   178: iconst_0
    //   179: sipush 8192
    //   182: invokevirtual 95	java/io/BufferedInputStream:read	([BII)I
    //   185: istore_2
    //   186: iload_2
    //   187: iconst_m1
    //   188: if_icmpeq +159 -> 347
    //   191: iload_1
    //   192: ifne +139 -> 331
    //   195: aload 10
    //   197: bipush 28
    //   199: baload
    //   200: bipush 24
    //   202: ishl
    //   203: aload 10
    //   205: bipush 29
    //   207: baload
    //   208: bipush 16
    //   210: ishl
    //   211: ldc 96
    //   213: iand
    //   214: ior
    //   215: aload 10
    //   217: bipush 30
    //   219: baload
    //   220: bipush 8
    //   222: ishl
    //   223: ldc 97
    //   225: iand
    //   226: ior
    //   227: aload 10
    //   229: bipush 31
    //   231: baload
    //   232: sipush 255
    //   235: iand
    //   236: ior
    //   237: istore_3
    //   238: getstatic 100	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_1
    //   242: iconst_2
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: ldc 102
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: iload_3
    //   254: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   261: iload_3
    //   262: bipush 10
    //   264: iadd
    //   265: istore_3
    //   266: aload 10
    //   268: bipush 28
    //   270: iload_3
    //   271: bipush 24
    //   273: ishr
    //   274: i2b
    //   275: bastore
    //   276: aload 10
    //   278: bipush 29
    //   280: iload_3
    //   281: bipush 16
    //   283: ishr
    //   284: sipush 255
    //   287: iand
    //   288: i2b
    //   289: bastore
    //   290: aload 10
    //   292: bipush 30
    //   294: iload_3
    //   295: bipush 8
    //   297: ishr
    //   298: sipush 255
    //   301: iand
    //   302: i2b
    //   303: bastore
    //   304: aload 10
    //   306: bipush 31
    //   308: iload_3
    //   309: sipush 255
    //   312: iand
    //   313: i2b
    //   314: bastore
    //   315: aload 6
    //   317: aload 10
    //   319: iconst_0
    //   320: iload_2
    //   321: invokevirtual 118	java/io/BufferedOutputStream:write	([BII)V
    //   324: iload_1
    //   325: iload_2
    //   326: iadd
    //   327: istore_1
    //   328: goto -154 -> 174
    //   331: aload 6
    //   333: aload 10
    //   335: iconst_0
    //   336: iload_2
    //   337: invokevirtual 118	java/io/BufferedOutputStream:write	([BII)V
    //   340: iload_1
    //   341: iload_2
    //   342: iadd
    //   343: istore_1
    //   344: goto -170 -> 174
    //   347: aload 4
    //   349: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   352: getstatic 127	com/tencent/mobileqq/database/corrupt/DBFixManager:b	Ljava/lang/String;
    //   355: iconst_0
    //   356: invokevirtual 133	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   359: astore 10
    //   361: aload 7
    //   363: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +110 -> 476
    //   369: aload 10
    //   371: new 48	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   378: aload 7
    //   380: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: getstatic 141	com/tencent/mobileqq/database/corrupt/DBFixManager:d	Ljava/lang/String;
    //   386: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: iconst_0
    //   393: invokeinterface 147 3 0
    //   398: ifeq +78 -> 476
    //   401: aload 10
    //   403: invokeinterface 151 1 0
    //   408: astore 10
    //   410: aload 10
    //   412: new 48	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   419: aload 7
    //   421: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: getstatic 141	com/tencent/mobileqq/database/corrupt/DBFixManager:d	Ljava/lang/String;
    //   427: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokeinterface 157 2 0
    //   438: pop
    //   439: aload 10
    //   441: new 48	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   448: aload 7
    //   450: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: getstatic 160	com/tencent/mobileqq/database/corrupt/DBFixManager:e	Ljava/lang/String;
    //   456: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokeinterface 157 2 0
    //   467: pop
    //   468: aload 10
    //   470: invokeinterface 163 1 0
    //   475: pop
    //   476: aload 4
    //   478: sipush 205
    //   481: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   484: checkcast 124	com/tencent/mobileqq/database/corrupt/DBFixManager
    //   487: astore 4
    //   489: aload 4
    //   491: iconst_1
    //   492: invokevirtual 170	com/tencent/mobileqq/database/corrupt/DBFixManager:b	(Z)V
    //   495: aload 9
    //   497: aload 8
    //   499: invokevirtual 174	java/io/File:renameTo	(Ljava/io/File;)Z
    //   502: pop
    //   503: aload_0
    //   504: getfield 12	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7:this$0	Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity;
    //   507: getfield 35	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   510: new 176	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$3
    //   513: dup
    //   514: aload_0
    //   515: invokespecial 177	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7$3:<init>	(Lcom/tencent/mobileqq/database/corrupt/DBFixConfigActivity$7;)V
    //   518: invokevirtual 46	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   521: pop
    //   522: aload 4
    //   524: invokevirtual 180	com/tencent/mobileqq/database/corrupt/DBFixManager:c	()V
    //   527: aload 5
    //   529: ifnull +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 183	java/io/BufferedInputStream:close	()V
    //   537: aload 6
    //   539: ifnull -479 -> 60
    //   542: aload 6
    //   544: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   547: return
    //   548: astore 4
    //   550: aload 4
    //   552: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   555: return
    //   556: astore 4
    //   558: aload 4
    //   560: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   563: goto -26 -> 537
    //   566: astore 6
    //   568: aconst_null
    //   569: astore 4
    //   571: aconst_null
    //   572: astore 5
    //   574: getstatic 100	com/tencent/mobileqq/database/corrupt/DBFixConfigActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   577: iconst_1
    //   578: ldc 189
    //   580: aload 6
    //   582: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   585: aload 6
    //   587: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   590: aload 5
    //   592: ifnull +8 -> 600
    //   595: aload 5
    //   597: invokevirtual 183	java/io/BufferedInputStream:close	()V
    //   600: aload 4
    //   602: ifnull -542 -> 60
    //   605: aload 4
    //   607: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   610: return
    //   611: astore 4
    //   613: aload 4
    //   615: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   618: return
    //   619: astore 5
    //   621: aload 5
    //   623: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   626: goto -26 -> 600
    //   629: astore 4
    //   631: aconst_null
    //   632: astore 6
    //   634: aconst_null
    //   635: astore 5
    //   637: aload 5
    //   639: ifnull +8 -> 647
    //   642: aload 5
    //   644: invokevirtual 183	java/io/BufferedInputStream:close	()V
    //   647: aload 6
    //   649: ifnull +8 -> 657
    //   652: aload 6
    //   654: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   657: aload 4
    //   659: athrow
    //   660: astore 5
    //   662: aload 5
    //   664: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   667: goto -20 -> 647
    //   670: astore 5
    //   672: aload 5
    //   674: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   677: goto -20 -> 657
    //   680: astore 4
    //   682: aconst_null
    //   683: astore 5
    //   685: goto -48 -> 637
    //   688: astore 4
    //   690: goto -53 -> 637
    //   693: astore 7
    //   695: aload 4
    //   697: astore 6
    //   699: aload 7
    //   701: astore 4
    //   703: goto -66 -> 637
    //   706: astore 7
    //   708: aconst_null
    //   709: astore 5
    //   711: aload 6
    //   713: astore 4
    //   715: aload 7
    //   717: astore 6
    //   719: goto -145 -> 574
    //   722: astore 7
    //   724: aload 6
    //   726: astore 4
    //   728: aload 7
    //   730: astore 6
    //   732: goto -158 -> 574
    //   735: aconst_null
    //   736: astore 4
    //   738: aconst_null
    //   739: astore 7
    //   741: goto -710 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	7
    //   173	171	1	i	int
    //   185	158	2	j	int
    //   237	76	3	k	int
    //   7	516	4	localObject1	Object
    //   548	3	4	localIOException1	java.io.IOException
    //   556	3	4	localIOException2	java.io.IOException
    //   569	37	4	localObject2	Object
    //   611	3	4	localIOException3	java.io.IOException
    //   629	29	4	localObject3	Object
    //   680	1	4	localObject4	Object
    //   688	8	4	localObject5	Object
    //   701	36	4	localObject6	Object
    //   163	433	5	localBufferedInputStream	java.io.BufferedInputStream
    //   619	3	5	localIOException4	java.io.IOException
    //   635	8	5	localObject7	Object
    //   660	3	5	localIOException5	java.io.IOException
    //   670	3	5	localIOException6	java.io.IOException
    //   683	27	5	localObject8	Object
    //   145	398	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   566	20	6	localIOException7	java.io.IOException
    //   632	99	6	localObject9	Object
    //   29	420	7	str	java.lang.String
    //   693	7	7	localObject10	Object
    //   706	10	7	localIOException8	java.io.IOException
    //   722	7	7	localIOException9	java.io.IOException
    //   739	1	7	localObject11	Object
    //   88	410	8	localFile1	java.io.File
    //   99	397	9	localFile2	java.io.File
    //   170	299	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   542	547	548	java/io/IOException
    //   532	537	556	java/io/IOException
    //   129	147	566	java/io/IOException
    //   605	610	611	java/io/IOException
    //   595	600	619	java/io/IOException
    //   129	147	629	finally
    //   642	647	660	java/io/IOException
    //   652	657	670	java/io/IOException
    //   147	165	680	finally
    //   165	172	688	finally
    //   174	186	688	finally
    //   238	261	688	finally
    //   315	324	688	finally
    //   331	340	688	finally
    //   347	476	688	finally
    //   476	527	688	finally
    //   574	590	693	finally
    //   147	165	706	java/io/IOException
    //   165	172	722	java/io/IOException
    //   174	186	722	java/io/IOException
    //   238	261	722	java/io/IOException
    //   315	324	722	java/io/IOException
    //   331	340	722	java/io/IOException
    //   347	476	722	java/io/IOException
    //   476	527	722	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.7
 * JD-Core Version:    0.7.0.1
 */