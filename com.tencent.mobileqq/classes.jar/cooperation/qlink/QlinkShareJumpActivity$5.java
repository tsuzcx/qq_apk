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
    //   6: invokestatic 37	alpo:a	(I)Ljava/lang/String;
    //   9: invokestatic 42	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aconst_null
    //   14: astore 12
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 10
    //   22: aconst_null
    //   23: astore 13
    //   25: aconst_null
    //   26: astore 8
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
    //   142: astore 9
    //   144: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   147: sipush 8192
    //   150: invokevirtual 94	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   153: astore 10
    //   155: lconst_0
    //   156: lstore 6
    //   158: lconst_0
    //   159: lstore_2
    //   160: aload 10
    //   162: astore 8
    //   164: aload 10
    //   166: astore 9
    //   168: aload_0
    //   169: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   172: aload 10
    //   174: invokevirtual 98	java/io/InputStream:read	([B)I
    //   177: istore_1
    //   178: iload_1
    //   179: iconst_m1
    //   180: if_icmpeq +129 -> 309
    //   183: aload 10
    //   185: astore 8
    //   187: aload 10
    //   189: astore 9
    //   191: aload_0
    //   192: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   195: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   198: ifeq +111 -> 309
    //   201: lload_2
    //   202: iload_1
    //   203: i2l
    //   204: ladd
    //   205: lstore 4
    //   207: aload 10
    //   209: astore 8
    //   211: aload 10
    //   213: astore 9
    //   215: aload 11
    //   217: aload 10
    //   219: iconst_0
    //   220: iload_1
    //   221: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   224: lload 4
    //   226: lstore_2
    //   227: aload 10
    //   229: astore 8
    //   231: aload 10
    //   233: astore 9
    //   235: lload 4
    //   237: lload 6
    //   239: lsub
    //   240: l2d
    //   241: aload_0
    //   242: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   245: l2d
    //   246: ddiv
    //   247: ldc2_w 106
    //   250: dcmpl
    //   251: ifle -91 -> 160
    //   254: aload 10
    //   256: astore 8
    //   258: aload 10
    //   260: astore 9
    //   262: aload_0
    //   263: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   266: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   269: aload_0
    //   270: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   273: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   276: iconst_3
    //   277: lload 4
    //   279: l2d
    //   280: aload_0
    //   281: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   284: l2d
    //   285: ddiv
    //   286: ldc2_w 108
    //   289: dmul
    //   290: d2i
    //   291: iconst_0
    //   292: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   295: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   298: pop
    //   299: lload 4
    //   301: lstore 6
    //   303: lload 4
    //   305: lstore_2
    //   306: goto -146 -> 160
    //   309: lload_2
    //   310: lconst_0
    //   311: lcmp
    //   312: ifne +23 -> 335
    //   315: aload 10
    //   317: astore 8
    //   319: aload 10
    //   321: astore 9
    //   323: aload_0
    //   324: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   327: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   330: iconst_1
    //   331: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   334: pop
    //   335: aload 10
    //   337: astore 8
    //   339: aload 10
    //   341: astore 9
    //   343: aload_0
    //   344: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   347: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   350: ifeq +107 -> 457
    //   353: aload 10
    //   355: astore 8
    //   357: aload 10
    //   359: astore 9
    //   361: aload_0
    //   362: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   365: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   368: aload_0
    //   369: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   372: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   375: iconst_3
    //   376: bipush 100
    //   378: iconst_0
    //   379: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   382: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   385: pop
    //   386: aload 10
    //   388: astore 8
    //   390: aload 10
    //   392: astore 9
    //   394: aload_0
    //   395: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   398: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   401: iconst_2
    //   402: ldc2_w 118
    //   405: invokevirtual 123	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   408: pop
    //   409: aload 10
    //   411: ifnull +11 -> 422
    //   414: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   417: aload 10
    //   419: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   422: aload_0
    //   423: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   426: iconst_0
    //   427: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   430: pop
    //   431: aload_0
    //   432: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   435: invokevirtual 81	java/io/InputStream:close	()V
    //   438: aload 11
    //   440: ifnull -332 -> 108
    //   443: aload 11
    //   445: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   448: return
    //   449: astore 8
    //   451: aload 8
    //   453: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   456: return
    //   457: aload 10
    //   459: astore 8
    //   461: aload 10
    //   463: astore 9
    //   465: aload 11
    //   467: invokestatic 130	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   470: aload 10
    //   472: astore 8
    //   474: aload 10
    //   476: astore 9
    //   478: aload 14
    //   480: invokevirtual 133	java/io/File:delete	()Z
    //   483: pop
    //   484: goto -75 -> 409
    //   487: astore 12
    //   489: aload 11
    //   491: astore 10
    //   493: aload 8
    //   495: astore 9
    //   497: aload 12
    //   499: astore 8
    //   501: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +13 -> 517
    //   507: ldc 140
    //   509: iconst_2
    //   510: ldc 142
    //   512: aload 8
    //   514: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload_0
    //   518: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   521: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   524: iconst_1
    //   525: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   528: pop
    //   529: aload 9
    //   531: ifnull +11 -> 542
    //   534: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   537: aload 9
    //   539: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   542: aload_0
    //   543: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   546: iconst_0
    //   547: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   550: pop
    //   551: aload_0
    //   552: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   555: invokevirtual 81	java/io/InputStream:close	()V
    //   558: aload 10
    //   560: ifnull -452 -> 108
    //   563: aload 10
    //   565: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   568: return
    //   569: astore 8
    //   571: aload 8
    //   573: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   576: return
    //   577: astore 8
    //   579: aload 8
    //   581: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   584: goto -146 -> 438
    //   587: astore 8
    //   589: aload 8
    //   591: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   594: goto -36 -> 558
    //   597: astore 8
    //   599: aconst_null
    //   600: astore 9
    //   602: aload 10
    //   604: ifnull +11 -> 615
    //   607: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   610: aload 10
    //   612: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   615: aload_0
    //   616: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   619: iconst_0
    //   620: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   623: pop
    //   624: aload_0
    //   625: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   628: invokevirtual 81	java/io/InputStream:close	()V
    //   631: aload 9
    //   633: ifnull +8 -> 641
    //   636: aload 9
    //   638: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   641: aload 8
    //   643: athrow
    //   644: astore 10
    //   646: aload 10
    //   648: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   651: goto -20 -> 631
    //   654: astore 9
    //   656: aload 9
    //   658: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   661: goto -20 -> 641
    //   664: astore 8
    //   666: aload 9
    //   668: astore 10
    //   670: aload 11
    //   672: astore 9
    //   674: goto -72 -> 602
    //   677: astore 8
    //   679: aload 10
    //   681: astore 11
    //   683: aload 9
    //   685: astore 10
    //   687: aload 11
    //   689: astore 9
    //   691: goto -89 -> 602
    //   694: astore 8
    //   696: aload 12
    //   698: astore 10
    //   700: goto -199 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	703	0	this	5
    //   177	44	1	i	int
    //   159	151	2	l1	long
    //   205	99	4	l2	long
    //   156	146	6	l3	long
    //   26	1	8	localObject1	Object
    //   109	3	8	localIOException1	java.io.IOException
    //   119	3	8	localIOException2	java.io.IOException
    //   162	227	8	localObject2	Object
    //   449	3	8	localIOException3	java.io.IOException
    //   459	54	8	localObject3	Object
    //   569	3	8	localIOException4	java.io.IOException
    //   577	3	8	localIOException5	java.io.IOException
    //   587	3	8	localIOException6	java.io.IOException
    //   597	45	8	localObject4	Object
    //   664	1	8	localObject5	Object
    //   677	1	8	localObject6	Object
    //   694	1	8	localException1	java.lang.Exception
    //   17	620	9	localObject7	Object
    //   654	13	9	localIOException7	java.io.IOException
    //   672	18	9	localObject8	Object
    //   20	591	10	localObject9	Object
    //   644	3	10	localIOException8	java.io.IOException
    //   668	31	10	localObject10	Object
    //   138	550	11	localObject11	Object
    //   14	1	12	localObject12	Object
    //   487	210	12	localException2	java.lang.Exception
    //   23	118	13	localObject13	Object
    //   39	440	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	96	109	java/io/IOException
    //   100	108	119	java/io/IOException
    //   443	448	449	java/io/IOException
    //   144	155	487	java/lang/Exception
    //   168	178	487	java/lang/Exception
    //   191	201	487	java/lang/Exception
    //   215	224	487	java/lang/Exception
    //   235	254	487	java/lang/Exception
    //   262	299	487	java/lang/Exception
    //   323	335	487	java/lang/Exception
    //   343	353	487	java/lang/Exception
    //   361	386	487	java/lang/Exception
    //   394	409	487	java/lang/Exception
    //   465	470	487	java/lang/Exception
    //   478	484	487	java/lang/Exception
    //   563	568	569	java/io/IOException
    //   431	438	577	java/io/IOException
    //   551	558	587	java/io/IOException
    //   28	69	597	finally
    //   127	140	597	finally
    //   624	631	644	java/io/IOException
    //   636	641	654	java/io/IOException
    //   144	155	664	finally
    //   168	178	664	finally
    //   191	201	664	finally
    //   215	224	664	finally
    //   235	254	664	finally
    //   262	299	664	finally
    //   323	335	664	finally
    //   343	353	664	finally
    //   361	386	664	finally
    //   394	409	664	finally
    //   465	470	664	finally
    //   478	484	664	finally
    //   501	517	677	finally
    //   517	529	677	finally
    //   28	69	694	java/lang/Exception
    //   127	140	694	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */