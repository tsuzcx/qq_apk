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
    //   6: invokestatic 37	alud:a	(I)Ljava/lang/String;
    //   9: invokestatic 42	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aconst_null
    //   14: astore 11
    //   16: aconst_null
    //   17: astore 12
    //   19: aconst_null
    //   20: astore 9
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
    //   138: astore 10
    //   140: aload 13
    //   142: astore 9
    //   144: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   147: sipush 8192
    //   150: invokevirtual 94	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   153: astore 11
    //   155: lconst_0
    //   156: lstore 6
    //   158: lconst_0
    //   159: lstore_2
    //   160: aload 11
    //   162: astore 8
    //   164: aload 11
    //   166: astore 9
    //   168: aload_0
    //   169: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   172: aload 11
    //   174: invokevirtual 98	java/io/InputStream:read	([B)I
    //   177: istore_1
    //   178: iload_1
    //   179: iconst_m1
    //   180: if_icmpeq +129 -> 309
    //   183: aload 11
    //   185: astore 8
    //   187: aload 11
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
    //   207: aload 11
    //   209: astore 8
    //   211: aload 11
    //   213: astore 9
    //   215: aload 10
    //   217: aload 11
    //   219: iconst_0
    //   220: iload_1
    //   221: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   224: lload 4
    //   226: lstore_2
    //   227: aload 11
    //   229: astore 8
    //   231: aload 11
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
    //   254: aload 11
    //   256: astore 8
    //   258: aload 11
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
    //   315: aload 11
    //   317: astore 8
    //   319: aload 11
    //   321: astore 9
    //   323: aload_0
    //   324: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   327: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   330: iconst_1
    //   331: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   334: pop
    //   335: aload 11
    //   337: astore 8
    //   339: aload 11
    //   341: astore 9
    //   343: aload_0
    //   344: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   347: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   350: ifeq +107 -> 457
    //   353: aload 11
    //   355: astore 8
    //   357: aload 11
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
    //   386: aload 11
    //   388: astore 8
    //   390: aload 11
    //   392: astore 9
    //   394: aload_0
    //   395: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   398: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   401: iconst_2
    //   402: ldc2_w 118
    //   405: invokevirtual 123	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   408: pop
    //   409: aload 11
    //   411: ifnull +11 -> 422
    //   414: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   417: aload 11
    //   419: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   422: aload_0
    //   423: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   426: iconst_0
    //   427: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   430: pop
    //   431: aload_0
    //   432: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   435: invokevirtual 81	java/io/InputStream:close	()V
    //   438: aload 10
    //   440: ifnull -332 -> 108
    //   443: aload 10
    //   445: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   448: return
    //   449: astore 8
    //   451: aload 8
    //   453: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   456: return
    //   457: aload 11
    //   459: astore 8
    //   461: aload 11
    //   463: astore 9
    //   465: aload 10
    //   467: invokestatic 130	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   470: aload 11
    //   472: astore 8
    //   474: aload 11
    //   476: astore 9
    //   478: aload 14
    //   480: invokevirtual 133	java/io/File:delete	()Z
    //   483: pop
    //   484: goto -75 -> 409
    //   487: astore 11
    //   489: aload 8
    //   491: astore 9
    //   493: aload 11
    //   495: astore 8
    //   497: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +13 -> 513
    //   503: ldc 140
    //   505: iconst_2
    //   506: ldc 142
    //   508: aload 8
    //   510: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: aload_0
    //   514: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   517: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   520: iconst_1
    //   521: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   524: pop
    //   525: aload 9
    //   527: ifnull +11 -> 538
    //   530: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   533: aload 9
    //   535: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   538: aload_0
    //   539: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   542: iconst_0
    //   543: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   546: pop
    //   547: aload_0
    //   548: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   551: invokevirtual 81	java/io/InputStream:close	()V
    //   554: aload 10
    //   556: ifnull -448 -> 108
    //   559: aload 10
    //   561: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   564: return
    //   565: astore 8
    //   567: aload 8
    //   569: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   572: return
    //   573: astore 8
    //   575: aload 8
    //   577: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   580: goto -142 -> 438
    //   583: astore 8
    //   585: aload 8
    //   587: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   590: goto -36 -> 554
    //   593: astore 8
    //   595: aconst_null
    //   596: astore 10
    //   598: aload 9
    //   600: ifnull +11 -> 611
    //   603: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   606: aload 9
    //   608: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   611: aload_0
    //   612: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   615: iconst_0
    //   616: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   619: pop
    //   620: aload_0
    //   621: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   624: invokevirtual 81	java/io/InputStream:close	()V
    //   627: aload 10
    //   629: ifnull +8 -> 637
    //   632: aload 10
    //   634: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   637: aload 8
    //   639: athrow
    //   640: astore 9
    //   642: aload 9
    //   644: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   647: goto -20 -> 627
    //   650: astore 9
    //   652: aload 9
    //   654: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   657: goto -20 -> 637
    //   660: astore 8
    //   662: goto -64 -> 598
    //   665: astore 8
    //   667: goto -69 -> 598
    //   670: astore 8
    //   672: aload 12
    //   674: astore 9
    //   676: aload 11
    //   678: astore 10
    //   680: goto -183 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	5
    //   177	44	1	i	int
    //   159	151	2	l1	long
    //   205	99	4	l2	long
    //   156	146	6	l3	long
    //   26	1	8	localObject1	Object
    //   109	3	8	localIOException1	java.io.IOException
    //   119	3	8	localIOException2	java.io.IOException
    //   162	227	8	arrayOfByte1	byte[]
    //   449	3	8	localIOException3	java.io.IOException
    //   459	50	8	localObject2	Object
    //   565	3	8	localIOException4	java.io.IOException
    //   573	3	8	localIOException5	java.io.IOException
    //   583	3	8	localIOException6	java.io.IOException
    //   593	45	8	localObject3	Object
    //   660	1	8	localObject4	Object
    //   665	1	8	localObject5	Object
    //   670	1	8	localException1	java.lang.Exception
    //   20	587	9	localObject6	Object
    //   640	3	9	localIOException7	java.io.IOException
    //   650	3	9	localIOException8	java.io.IOException
    //   674	1	9	localObject7	Object
    //   138	541	10	localObject8	Object
    //   14	461	11	arrayOfByte2	byte[]
    //   487	190	11	localException2	java.lang.Exception
    //   17	656	12	localObject9	Object
    //   23	118	13	localObject10	Object
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
    //   559	564	565	java/io/IOException
    //   431	438	573	java/io/IOException
    //   547	554	583	java/io/IOException
    //   28	69	593	finally
    //   127	140	593	finally
    //   620	627	640	java/io/IOException
    //   632	637	650	java/io/IOException
    //   144	155	660	finally
    //   168	178	660	finally
    //   191	201	660	finally
    //   215	224	660	finally
    //   235	254	660	finally
    //   262	299	660	finally
    //   323	335	660	finally
    //   343	353	660	finally
    //   361	386	660	finally
    //   394	409	660	finally
    //   465	470	660	finally
    //   478	484	660	finally
    //   497	513	665	finally
    //   513	525	665	finally
    //   28	69	670	java/lang/Exception
    //   127	140	670	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */