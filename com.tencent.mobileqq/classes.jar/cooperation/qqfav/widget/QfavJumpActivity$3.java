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
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
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
    //   125: astore 10
    //   127: aload 13
    //   129: astore 9
    //   131: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: sipush 8192
    //   137: invokevirtual 85	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   140: astore 11
    //   142: lconst_0
    //   143: lstore 6
    //   145: lconst_0
    //   146: lstore_2
    //   147: aload 11
    //   149: astore 8
    //   151: aload 11
    //   153: astore 9
    //   155: aload_0
    //   156: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   159: aload 11
    //   161: invokevirtual 89	java/io/InputStream:read	([B)I
    //   164: istore_1
    //   165: iload_1
    //   166: iconst_m1
    //   167: if_icmpeq +129 -> 296
    //   170: aload 11
    //   172: astore 8
    //   174: aload 11
    //   176: astore 9
    //   178: aload_0
    //   179: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   182: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   185: ifeq +111 -> 296
    //   188: lload_2
    //   189: iload_1
    //   190: i2l
    //   191: ladd
    //   192: lstore 4
    //   194: aload 11
    //   196: astore 8
    //   198: aload 11
    //   200: astore 9
    //   202: aload 10
    //   204: aload 11
    //   206: iconst_0
    //   207: iload_1
    //   208: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   211: lload 4
    //   213: lstore_2
    //   214: aload 11
    //   216: astore 8
    //   218: aload 11
    //   220: astore 9
    //   222: lload 4
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 97
    //   237: dcmpl
    //   238: ifle -91 -> 147
    //   241: aload 11
    //   243: astore 8
    //   245: aload 11
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   253: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   256: aload_0
    //   257: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   260: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   263: iconst_3
    //   264: lload 4
    //   266: l2d
    //   267: aload_0
    //   268: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   271: l2d
    //   272: ddiv
    //   273: ldc2_w 99
    //   276: dmul
    //   277: d2i
    //   278: iconst_0
    //   279: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   282: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   285: pop
    //   286: lload 4
    //   288: lstore 6
    //   290: lload 4
    //   292: lstore_2
    //   293: goto -146 -> 147
    //   296: lload_2
    //   297: lconst_0
    //   298: lcmp
    //   299: ifne +43 -> 342
    //   302: aload 11
    //   304: astore 8
    //   306: aload 11
    //   308: astore 9
    //   310: aload_0
    //   311: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   314: ldc 109
    //   316: invokevirtual 113	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   319: putstatic 114	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: aload 11
    //   324: astore 8
    //   326: aload 11
    //   328: astore 9
    //   330: aload_0
    //   331: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   334: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   337: iconst_1
    //   338: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   341: pop
    //   342: aload 11
    //   344: astore 8
    //   346: aload 11
    //   348: astore 9
    //   350: aload_0
    //   351: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   354: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   357: ifeq +107 -> 464
    //   360: aload 11
    //   362: astore 8
    //   364: aload 11
    //   366: astore 9
    //   368: aload_0
    //   369: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   372: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   375: aload_0
    //   376: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   379: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   382: iconst_3
    //   383: bipush 100
    //   385: iconst_0
    //   386: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   389: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   392: pop
    //   393: aload 11
    //   395: astore 8
    //   397: aload 11
    //   399: astore 9
    //   401: aload_0
    //   402: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   405: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   408: iconst_2
    //   409: ldc2_w 115
    //   412: invokevirtual 120	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   415: pop
    //   416: aload 11
    //   418: ifnull +11 -> 429
    //   421: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   424: aload 11
    //   426: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   429: aload_0
    //   430: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   433: iconst_0
    //   434: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   442: invokevirtual 72	java/io/InputStream:close	()V
    //   445: aload 10
    //   447: ifnull -352 -> 95
    //   450: aload 10
    //   452: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   455: return
    //   456: astore 8
    //   458: aload 8
    //   460: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   463: return
    //   464: aload 11
    //   466: astore 8
    //   468: aload 11
    //   470: astore 9
    //   472: aload 10
    //   474: invokestatic 127	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   477: aload 11
    //   479: astore 8
    //   481: aload 11
    //   483: astore 9
    //   485: aload 14
    //   487: invokevirtual 130	java/io/File:delete	()Z
    //   490: pop
    //   491: goto -75 -> 416
    //   494: astore 11
    //   496: aload 8
    //   498: astore 9
    //   500: aload 11
    //   502: astore 8
    //   504: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +13 -> 520
    //   510: ldc 137
    //   512: iconst_2
    //   513: ldc 139
    //   515: aload 8
    //   517: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   524: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   527: iconst_1
    //   528: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   531: pop
    //   532: aload 9
    //   534: ifnull +11 -> 545
    //   537: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   540: aload 9
    //   542: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   545: aload_0
    //   546: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   549: iconst_0
    //   550: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   553: pop
    //   554: aload_0
    //   555: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   558: invokevirtual 72	java/io/InputStream:close	()V
    //   561: aload 10
    //   563: ifnull -468 -> 95
    //   566: aload 10
    //   568: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   571: return
    //   572: astore 8
    //   574: aload 8
    //   576: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   579: return
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   587: goto -142 -> 445
    //   590: astore 8
    //   592: aload 8
    //   594: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   597: goto -36 -> 561
    //   600: astore 8
    //   602: aconst_null
    //   603: astore 10
    //   605: aload 9
    //   607: ifnull +11 -> 618
    //   610: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   613: aload 9
    //   615: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   618: aload_0
    //   619: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   622: iconst_0
    //   623: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   626: pop
    //   627: aload_0
    //   628: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   631: invokevirtual 72	java/io/InputStream:close	()V
    //   634: aload 10
    //   636: ifnull +8 -> 644
    //   639: aload 10
    //   641: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   644: aload 8
    //   646: athrow
    //   647: astore 9
    //   649: aload 9
    //   651: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   654: goto -20 -> 634
    //   657: astore 9
    //   659: aload 9
    //   661: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   664: goto -20 -> 644
    //   667: astore 8
    //   669: goto -64 -> 605
    //   672: astore 8
    //   674: goto -69 -> 605
    //   677: astore 8
    //   679: aload 12
    //   681: astore 9
    //   683: aload 11
    //   685: astore 10
    //   687: goto -183 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	3
    //   164	44	1	i	int
    //   146	151	2	l1	long
    //   192	99	4	l2	long
    //   143	146	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   149	247	8	arrayOfByte1	byte[]
    //   456	3	8	localIOException3	java.io.IOException
    //   466	50	8	localObject2	Object
    //   572	3	8	localIOException4	java.io.IOException
    //   580	3	8	localIOException5	java.io.IOException
    //   590	3	8	localIOException6	java.io.IOException
    //   600	45	8	localObject3	Object
    //   667	1	8	localObject4	Object
    //   672	1	8	localObject5	Object
    //   677	1	8	localException1	java.lang.Exception
    //   7	607	9	localObject6	Object
    //   647	3	9	localIOException7	java.io.IOException
    //   657	3	9	localIOException8	java.io.IOException
    //   681	1	9	localObject7	Object
    //   125	561	10	localObject8	Object
    //   1	481	11	arrayOfByte2	byte[]
    //   494	190	11	localException2	java.lang.Exception
    //   4	676	12	localObject9	Object
    //   10	118	13	localObject10	Object
    //   26	460	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   450	455	456	java/io/IOException
    //   131	142	494	java/lang/Exception
    //   155	165	494	java/lang/Exception
    //   178	188	494	java/lang/Exception
    //   202	211	494	java/lang/Exception
    //   222	241	494	java/lang/Exception
    //   249	286	494	java/lang/Exception
    //   310	322	494	java/lang/Exception
    //   330	342	494	java/lang/Exception
    //   350	360	494	java/lang/Exception
    //   368	393	494	java/lang/Exception
    //   401	416	494	java/lang/Exception
    //   472	477	494	java/lang/Exception
    //   485	491	494	java/lang/Exception
    //   566	571	572	java/io/IOException
    //   438	445	580	java/io/IOException
    //   554	561	590	java/io/IOException
    //   15	56	600	finally
    //   114	127	600	finally
    //   627	634	647	java/io/IOException
    //   639	644	657	java/io/IOException
    //   131	142	667	finally
    //   155	165	667	finally
    //   178	188	667	finally
    //   202	211	667	finally
    //   222	241	667	finally
    //   249	286	667	finally
    //   310	322	667	finally
    //   330	342	667	finally
    //   350	360	667	finally
    //   368	393	667	finally
    //   401	416	667	finally
    //   472	477	667	finally
    //   485	491	667	finally
    //   504	520	672	finally
    //   520	532	672	finally
    //   15	56	677	java/lang/Exception
    //   114	127	677	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */