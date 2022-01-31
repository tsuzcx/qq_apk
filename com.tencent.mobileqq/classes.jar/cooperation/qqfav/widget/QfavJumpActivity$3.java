package cooperation.qqfav.widget;

import java.io.InputStream;

class QfavJumpActivity$3
  implements Runnable
{
  QfavJumpActivity$3(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 13
    //   15: new 33	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 40	java/io/File:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 43	java/io/File:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   48: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   71: iconst_0
    //   72: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   80: invokevirtual 72	java/io/InputStream:close	()V
    //   83: iconst_0
    //   84: ifeq +11 -> 95
    //   87: new 74	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: return
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   103: goto -20 -> 83
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: new 80	java/io/FileOutputStream
    //   117: dup
    //   118: aload_0
    //   119: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 11
    //   127: aload 13
    //   129: astore 8
    //   131: aload 12
    //   133: astore 9
    //   135: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   138: sipush 8192
    //   141: invokevirtual 85	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   144: astore 10
    //   146: lconst_0
    //   147: lstore 6
    //   149: lconst_0
    //   150: lstore 4
    //   152: aload 10
    //   154: astore 8
    //   156: aload 10
    //   158: astore 9
    //   160: aload_0
    //   161: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   164: aload 10
    //   166: invokevirtual 89	java/io/InputStream:read	([B)I
    //   169: istore_1
    //   170: iload_1
    //   171: iconst_m1
    //   172: if_icmpeq +126 -> 298
    //   175: aload 10
    //   177: astore 8
    //   179: aload 10
    //   181: astore 9
    //   183: aload_0
    //   184: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   187: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   190: ifeq +108 -> 298
    //   193: lload 4
    //   195: iload_1
    //   196: i2l
    //   197: ladd
    //   198: lstore_2
    //   199: aload 10
    //   201: astore 8
    //   203: aload 10
    //   205: astore 9
    //   207: aload 11
    //   209: aload 10
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   216: lload_2
    //   217: lstore 4
    //   219: aload 10
    //   221: astore 8
    //   223: aload 10
    //   225: astore 9
    //   227: lload_2
    //   228: lload 6
    //   230: lsub
    //   231: l2d
    //   232: aload_0
    //   233: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   236: l2d
    //   237: ddiv
    //   238: ldc2_w 97
    //   241: dcmpl
    //   242: ifle -90 -> 152
    //   245: aload 10
    //   247: astore 8
    //   249: aload 10
    //   251: astore 9
    //   253: aload_0
    //   254: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   257: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   260: aload_0
    //   261: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   264: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   267: iconst_3
    //   268: lload_2
    //   269: l2d
    //   270: aload_0
    //   271: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   274: l2d
    //   275: ddiv
    //   276: ldc2_w 99
    //   279: dmul
    //   280: d2i
    //   281: iconst_0
    //   282: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   285: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   288: pop
    //   289: lload_2
    //   290: lstore 6
    //   292: lload_2
    //   293: lstore 4
    //   295: goto -143 -> 152
    //   298: lload 4
    //   300: lconst_0
    //   301: lcmp
    //   302: ifne +43 -> 345
    //   305: aload 10
    //   307: astore 8
    //   309: aload 10
    //   311: astore 9
    //   313: aload_0
    //   314: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   317: ldc 109
    //   319: invokevirtual 113	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   322: putstatic 114	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: aload 10
    //   327: astore 8
    //   329: aload 10
    //   331: astore 9
    //   333: aload_0
    //   334: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   337: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   340: iconst_1
    //   341: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   344: pop
    //   345: aload 10
    //   347: astore 8
    //   349: aload 10
    //   351: astore 9
    //   353: aload_0
    //   354: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   357: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   360: ifeq +107 -> 467
    //   363: aload 10
    //   365: astore 8
    //   367: aload 10
    //   369: astore 9
    //   371: aload_0
    //   372: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   375: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   378: aload_0
    //   379: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   382: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   385: iconst_3
    //   386: bipush 100
    //   388: iconst_0
    //   389: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   392: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   395: pop
    //   396: aload 10
    //   398: astore 8
    //   400: aload 10
    //   402: astore 9
    //   404: aload_0
    //   405: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   408: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   411: iconst_2
    //   412: ldc2_w 115
    //   415: invokevirtual 120	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   418: pop
    //   419: aload 10
    //   421: ifnull +11 -> 432
    //   424: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   427: aload 10
    //   429: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   432: aload_0
    //   433: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   436: iconst_0
    //   437: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   440: pop
    //   441: aload_0
    //   442: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   445: invokevirtual 72	java/io/InputStream:close	()V
    //   448: aload 11
    //   450: ifnull -355 -> 95
    //   453: aload 11
    //   455: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   458: return
    //   459: astore 8
    //   461: aload 8
    //   463: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   466: return
    //   467: aload 10
    //   469: astore 8
    //   471: aload 10
    //   473: astore 9
    //   475: aload 11
    //   477: invokestatic 127	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   480: aload 10
    //   482: astore 8
    //   484: aload 10
    //   486: astore 9
    //   488: aload 14
    //   490: invokevirtual 130	java/io/File:delete	()Z
    //   493: pop
    //   494: goto -75 -> 419
    //   497: astore 12
    //   499: aload 11
    //   501: astore 10
    //   503: aload 8
    //   505: astore 9
    //   507: aload 12
    //   509: astore 8
    //   511: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +13 -> 527
    //   517: ldc 137
    //   519: iconst_2
    //   520: ldc 139
    //   522: aload 8
    //   524: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   527: aload_0
    //   528: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   531: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   534: iconst_1
    //   535: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   538: pop
    //   539: aload 9
    //   541: ifnull +11 -> 552
    //   544: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   547: aload 9
    //   549: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   552: aload_0
    //   553: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   556: iconst_0
    //   557: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   560: pop
    //   561: aload_0
    //   562: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   565: invokevirtual 72	java/io/InputStream:close	()V
    //   568: aload 10
    //   570: ifnull -475 -> 95
    //   573: aload 10
    //   575: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   578: return
    //   579: astore 8
    //   581: aload 8
    //   583: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   586: return
    //   587: astore 8
    //   589: aload 8
    //   591: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   594: goto -146 -> 448
    //   597: astore 8
    //   599: aload 8
    //   601: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   604: goto -36 -> 568
    //   607: astore 11
    //   609: aconst_null
    //   610: astore 9
    //   612: aload 8
    //   614: astore 10
    //   616: aload 11
    //   618: astore 8
    //   620: aload 10
    //   622: ifnull +11 -> 633
    //   625: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   628: aload 10
    //   630: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   633: aload_0
    //   634: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   637: iconst_0
    //   638: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   641: pop
    //   642: aload_0
    //   643: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   646: invokevirtual 72	java/io/InputStream:close	()V
    //   649: aload 9
    //   651: ifnull +8 -> 659
    //   654: aload 9
    //   656: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   659: aload 8
    //   661: athrow
    //   662: astore 10
    //   664: aload 10
    //   666: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   669: goto -20 -> 649
    //   672: astore 9
    //   674: aload 9
    //   676: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   679: goto -20 -> 659
    //   682: astore 8
    //   684: aload 9
    //   686: astore 10
    //   688: aload 11
    //   690: astore 9
    //   692: goto -72 -> 620
    //   695: astore 8
    //   697: aload 10
    //   699: astore 11
    //   701: aload 9
    //   703: astore 10
    //   705: aload 11
    //   707: astore 9
    //   709: goto -89 -> 620
    //   712: astore 8
    //   714: goto -203 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	3
    //   169	44	1	i	int
    //   198	95	2	l1	long
    //   150	149	4	l2	long
    //   147	144	6	l3	long
    //   7	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   129	270	8	localObject2	Object
    //   459	3	8	localIOException3	java.io.IOException
    //   469	54	8	localObject3	Object
    //   579	3	8	localIOException4	java.io.IOException
    //   587	3	8	localIOException5	java.io.IOException
    //   597	16	8	localIOException6	java.io.IOException
    //   618	42	8	localObject4	Object
    //   682	1	8	localObject5	Object
    //   695	1	8	localObject6	Object
    //   712	1	8	localException1	java.lang.Exception
    //   4	651	9	localObject7	Object
    //   672	13	9	localIOException7	java.io.IOException
    //   690	18	9	localObject8	Object
    //   1	628	10	localObject9	Object
    //   662	3	10	localIOException8	java.io.IOException
    //   686	18	10	localObject10	Object
    //   125	375	11	localFileOutputStream	java.io.FileOutputStream
    //   607	82	11	localObject11	Object
    //   699	7	11	localObject12	Object
    //   10	122	12	localObject13	Object
    //   497	11	12	localException2	java.lang.Exception
    //   13	115	13	localObject14	Object
    //   26	463	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   453	458	459	java/io/IOException
    //   135	146	497	java/lang/Exception
    //   160	170	497	java/lang/Exception
    //   183	193	497	java/lang/Exception
    //   207	216	497	java/lang/Exception
    //   227	245	497	java/lang/Exception
    //   253	289	497	java/lang/Exception
    //   313	325	497	java/lang/Exception
    //   333	345	497	java/lang/Exception
    //   353	363	497	java/lang/Exception
    //   371	396	497	java/lang/Exception
    //   404	419	497	java/lang/Exception
    //   475	480	497	java/lang/Exception
    //   488	494	497	java/lang/Exception
    //   573	578	579	java/io/IOException
    //   441	448	587	java/io/IOException
    //   561	568	597	java/io/IOException
    //   15	56	607	finally
    //   114	127	607	finally
    //   642	649	662	java/io/IOException
    //   654	659	672	java/io/IOException
    //   135	146	682	finally
    //   160	170	682	finally
    //   183	193	682	finally
    //   207	216	682	finally
    //   227	245	682	finally
    //   253	289	682	finally
    //   313	325	682	finally
    //   333	345	682	finally
    //   353	363	682	finally
    //   371	396	682	finally
    //   404	419	682	finally
    //   475	480	682	finally
    //   488	494	682	finally
    //   511	527	695	finally
    //   527	539	695	finally
    //   15	56	712	java/lang/Exception
    //   114	127	712	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */