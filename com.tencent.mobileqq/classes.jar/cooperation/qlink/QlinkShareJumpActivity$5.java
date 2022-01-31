package cooperation.qlink;

import java.io.InputStream;

class QlinkShareJumpActivity$5
  implements Runnable
{
  QlinkShareJumpActivity$5(QlinkShareJumpActivity paramQlinkShareJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   4: ldc 32
    //   6: invokestatic 37	ajjy:a	(I)Ljava/lang/String;
    //   9: invokestatic 42	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 12
    //   25: aconst_null
    //   26: astore 13
    //   28: new 44	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 14
    //   41: aload 14
    //   43: invokevirtual 51	java/io/File:exists	()Z
    //   46: ifne +81 -> 127
    //   49: aload 14
    //   51: invokevirtual 54	java/io/File:createNewFile	()Z
    //   54: ifne +73 -> 127
    //   57: aload_0
    //   58: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   61: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   64: iconst_1
    //   65: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   68: pop
    //   69: iconst_0
    //   70: ifeq +10 -> 80
    //   73: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   76: aconst_null
    //   77: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   80: aload_0
    //   81: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   84: iconst_0
    //   85: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   93: invokevirtual 81	java/io/InputStream:close	()V
    //   96: iconst_0
    //   97: ifeq +11 -> 108
    //   100: new 83	java/lang/NullPointerException
    //   103: dup
    //   104: invokespecial 84	java/lang/NullPointerException:<init>	()V
    //   107: athrow
    //   108: return
    //   109: astore 8
    //   111: aload 8
    //   113: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   116: goto -20 -> 96
    //   119: astore 8
    //   121: aload 8
    //   123: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   126: return
    //   127: new 89	java/io/FileOutputStream
    //   130: dup
    //   131: aload_0
    //   132: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   135: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   138: astore 11
    //   140: aload 13
    //   142: astore 8
    //   144: aload 12
    //   146: astore 9
    //   148: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   151: sipush 8192
    //   154: invokevirtual 94	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   157: astore 10
    //   159: lconst_0
    //   160: lstore 6
    //   162: lconst_0
    //   163: lstore 4
    //   165: aload 10
    //   167: astore 8
    //   169: aload 10
    //   171: astore 9
    //   173: aload_0
    //   174: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   177: aload 10
    //   179: invokevirtual 98	java/io/InputStream:read	([B)I
    //   182: istore_1
    //   183: iload_1
    //   184: iconst_m1
    //   185: if_icmpeq +126 -> 311
    //   188: aload 10
    //   190: astore 8
    //   192: aload 10
    //   194: astore 9
    //   196: aload_0
    //   197: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   200: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   203: ifeq +108 -> 311
    //   206: lload 4
    //   208: iload_1
    //   209: i2l
    //   210: ladd
    //   211: lstore_2
    //   212: aload 10
    //   214: astore 8
    //   216: aload 10
    //   218: astore 9
    //   220: aload 11
    //   222: aload 10
    //   224: iconst_0
    //   225: iload_1
    //   226: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   229: lload_2
    //   230: lstore 4
    //   232: aload 10
    //   234: astore 8
    //   236: aload 10
    //   238: astore 9
    //   240: lload_2
    //   241: lload 6
    //   243: lsub
    //   244: l2d
    //   245: aload_0
    //   246: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   249: l2d
    //   250: ddiv
    //   251: ldc2_w 106
    //   254: dcmpl
    //   255: ifle -90 -> 165
    //   258: aload 10
    //   260: astore 8
    //   262: aload 10
    //   264: astore 9
    //   266: aload_0
    //   267: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   270: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   273: aload_0
    //   274: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   277: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   280: iconst_3
    //   281: lload_2
    //   282: l2d
    //   283: aload_0
    //   284: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   287: l2d
    //   288: ddiv
    //   289: ldc2_w 108
    //   292: dmul
    //   293: d2i
    //   294: iconst_0
    //   295: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   298: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   301: pop
    //   302: lload_2
    //   303: lstore 6
    //   305: lload_2
    //   306: lstore 4
    //   308: goto -143 -> 165
    //   311: lload 4
    //   313: lconst_0
    //   314: lcmp
    //   315: ifne +23 -> 338
    //   318: aload 10
    //   320: astore 8
    //   322: aload 10
    //   324: astore 9
    //   326: aload_0
    //   327: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   330: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   333: iconst_1
    //   334: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   337: pop
    //   338: aload 10
    //   340: astore 8
    //   342: aload 10
    //   344: astore 9
    //   346: aload_0
    //   347: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   350: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   353: ifeq +107 -> 460
    //   356: aload 10
    //   358: astore 8
    //   360: aload 10
    //   362: astore 9
    //   364: aload_0
    //   365: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   368: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   371: aload_0
    //   372: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   375: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   378: iconst_3
    //   379: bipush 100
    //   381: iconst_0
    //   382: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   385: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   388: pop
    //   389: aload 10
    //   391: astore 8
    //   393: aload 10
    //   395: astore 9
    //   397: aload_0
    //   398: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   401: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   404: iconst_2
    //   405: ldc2_w 118
    //   408: invokevirtual 123	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   411: pop
    //   412: aload 10
    //   414: ifnull +11 -> 425
    //   417: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   420: aload 10
    //   422: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   425: aload_0
    //   426: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   429: iconst_0
    //   430: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   433: pop
    //   434: aload_0
    //   435: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   438: invokevirtual 81	java/io/InputStream:close	()V
    //   441: aload 11
    //   443: ifnull -335 -> 108
    //   446: aload 11
    //   448: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   451: return
    //   452: astore 8
    //   454: aload 8
    //   456: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   459: return
    //   460: aload 10
    //   462: astore 8
    //   464: aload 10
    //   466: astore 9
    //   468: aload 11
    //   470: invokestatic 130	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   473: aload 10
    //   475: astore 8
    //   477: aload 10
    //   479: astore 9
    //   481: aload 14
    //   483: invokevirtual 133	java/io/File:delete	()Z
    //   486: pop
    //   487: goto -75 -> 412
    //   490: astore 12
    //   492: aload 11
    //   494: astore 10
    //   496: aload 8
    //   498: astore 9
    //   500: aload 12
    //   502: astore 8
    //   504: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +13 -> 520
    //   510: ldc 140
    //   512: iconst_2
    //   513: ldc 142
    //   515: aload 8
    //   517: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   524: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   527: iconst_1
    //   528: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   531: pop
    //   532: aload 9
    //   534: ifnull +11 -> 545
    //   537: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   540: aload 9
    //   542: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   545: aload_0
    //   546: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   549: iconst_0
    //   550: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   553: pop
    //   554: aload_0
    //   555: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   558: invokevirtual 81	java/io/InputStream:close	()V
    //   561: aload 10
    //   563: ifnull -455 -> 108
    //   566: aload 10
    //   568: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   571: return
    //   572: astore 8
    //   574: aload 8
    //   576: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   579: return
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   587: goto -146 -> 441
    //   590: astore 8
    //   592: aload 8
    //   594: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   597: goto -36 -> 561
    //   600: astore 11
    //   602: aconst_null
    //   603: astore 9
    //   605: aload 8
    //   607: astore 10
    //   609: aload 11
    //   611: astore 8
    //   613: aload 10
    //   615: ifnull +11 -> 626
    //   618: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   621: aload 10
    //   623: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   626: aload_0
    //   627: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   630: iconst_0
    //   631: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   634: pop
    //   635: aload_0
    //   636: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   639: invokevirtual 81	java/io/InputStream:close	()V
    //   642: aload 9
    //   644: ifnull +8 -> 652
    //   647: aload 9
    //   649: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   652: aload 8
    //   654: athrow
    //   655: astore 10
    //   657: aload 10
    //   659: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   662: goto -20 -> 642
    //   665: astore 9
    //   667: aload 9
    //   669: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   672: goto -20 -> 652
    //   675: astore 8
    //   677: aload 9
    //   679: astore 10
    //   681: aload 11
    //   683: astore 9
    //   685: goto -72 -> 613
    //   688: astore 8
    //   690: aload 10
    //   692: astore 11
    //   694: aload 9
    //   696: astore 10
    //   698: aload 11
    //   700: astore 9
    //   702: goto -89 -> 613
    //   705: astore 8
    //   707: goto -203 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	5
    //   182	44	1	i	int
    //   211	95	2	l1	long
    //   163	149	4	l2	long
    //   160	144	6	l3	long
    //   20	1	8	localObject1	Object
    //   109	3	8	localIOException1	java.io.IOException
    //   119	3	8	localIOException2	java.io.IOException
    //   142	250	8	localObject2	Object
    //   452	3	8	localIOException3	java.io.IOException
    //   462	54	8	localObject3	Object
    //   572	3	8	localIOException4	java.io.IOException
    //   580	3	8	localIOException5	java.io.IOException
    //   590	16	8	localIOException6	java.io.IOException
    //   611	42	8	localObject4	Object
    //   675	1	8	localObject5	Object
    //   688	1	8	localObject6	Object
    //   705	1	8	localException1	java.lang.Exception
    //   17	631	9	localObject7	Object
    //   665	13	9	localIOException7	java.io.IOException
    //   683	18	9	localObject8	Object
    //   14	608	10	localObject9	Object
    //   655	3	10	localIOException8	java.io.IOException
    //   679	18	10	localObject10	Object
    //   138	355	11	localFileOutputStream	java.io.FileOutputStream
    //   600	82	11	localObject11	Object
    //   692	7	11	localObject12	Object
    //   23	122	12	localObject13	Object
    //   490	11	12	localException2	java.lang.Exception
    //   26	115	13	localObject14	Object
    //   39	443	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	96	109	java/io/IOException
    //   100	108	119	java/io/IOException
    //   446	451	452	java/io/IOException
    //   148	159	490	java/lang/Exception
    //   173	183	490	java/lang/Exception
    //   196	206	490	java/lang/Exception
    //   220	229	490	java/lang/Exception
    //   240	258	490	java/lang/Exception
    //   266	302	490	java/lang/Exception
    //   326	338	490	java/lang/Exception
    //   346	356	490	java/lang/Exception
    //   364	389	490	java/lang/Exception
    //   397	412	490	java/lang/Exception
    //   468	473	490	java/lang/Exception
    //   481	487	490	java/lang/Exception
    //   566	571	572	java/io/IOException
    //   434	441	580	java/io/IOException
    //   554	561	590	java/io/IOException
    //   28	69	600	finally
    //   127	140	600	finally
    //   635	642	655	java/io/IOException
    //   647	652	665	java/io/IOException
    //   148	159	675	finally
    //   173	183	675	finally
    //   196	206	675	finally
    //   220	229	675	finally
    //   240	258	675	finally
    //   266	302	675	finally
    //   326	338	675	finally
    //   346	356	675	finally
    //   364	389	675	finally
    //   397	412	675	finally
    //   468	473	675	finally
    //   481	487	675	finally
    //   504	520	688	finally
    //   520	532	688	finally
    //   28	69	705	java/lang/Exception
    //   127	140	705	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */