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
    //   6: invokestatic 37	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
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
    //   159: lstore 4
    //   161: aload 10
    //   163: astore 8
    //   165: aload 10
    //   167: astore 9
    //   169: aload_0
    //   170: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   173: aload 10
    //   175: invokevirtual 98	java/io/InputStream:read	([B)I
    //   178: istore_1
    //   179: iload_1
    //   180: iconst_m1
    //   181: if_icmpeq +126 -> 307
    //   184: aload 10
    //   186: astore 8
    //   188: aload 10
    //   190: astore 9
    //   192: aload_0
    //   193: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   196: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   199: ifeq +108 -> 307
    //   202: lload 4
    //   204: iload_1
    //   205: i2l
    //   206: ladd
    //   207: lstore_2
    //   208: aload 10
    //   210: astore 8
    //   212: aload 10
    //   214: astore 9
    //   216: aload 11
    //   218: aload 10
    //   220: iconst_0
    //   221: iload_1
    //   222: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   225: lload_2
    //   226: lstore 4
    //   228: aload 10
    //   230: astore 8
    //   232: aload 10
    //   234: astore 9
    //   236: lload_2
    //   237: lload 6
    //   239: lsub
    //   240: l2d
    //   241: aload_0
    //   242: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   245: l2d
    //   246: ddiv
    //   247: ldc2_w 106
    //   250: dcmpl
    //   251: ifle -90 -> 161
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
    //   277: lload_2
    //   278: l2d
    //   279: aload_0
    //   280: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   283: l2d
    //   284: ddiv
    //   285: ldc2_w 108
    //   288: dmul
    //   289: d2i
    //   290: iconst_0
    //   291: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   294: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   297: pop
    //   298: lload_2
    //   299: lstore 6
    //   301: lload_2
    //   302: lstore 4
    //   304: goto -143 -> 161
    //   307: lload 4
    //   309: lconst_0
    //   310: lcmp
    //   311: ifne +23 -> 334
    //   314: aload 10
    //   316: astore 8
    //   318: aload 10
    //   320: astore 9
    //   322: aload_0
    //   323: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   326: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   329: iconst_1
    //   330: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   333: pop
    //   334: aload 10
    //   336: astore 8
    //   338: aload 10
    //   340: astore 9
    //   342: aload_0
    //   343: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   346: invokestatic 101	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   349: ifeq +107 -> 456
    //   352: aload 10
    //   354: astore 8
    //   356: aload 10
    //   358: astore 9
    //   360: aload_0
    //   361: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   364: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   367: aload_0
    //   368: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   371: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   374: iconst_3
    //   375: bipush 100
    //   377: iconst_0
    //   378: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   381: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   384: pop
    //   385: aload 10
    //   387: astore 8
    //   389: aload 10
    //   391: astore 9
    //   393: aload_0
    //   394: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   397: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   400: iconst_2
    //   401: ldc2_w 118
    //   404: invokevirtual 123	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   407: pop
    //   408: aload 10
    //   410: ifnull +11 -> 421
    //   413: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   416: aload 10
    //   418: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   421: aload_0
    //   422: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   425: iconst_0
    //   426: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   429: pop
    //   430: aload_0
    //   431: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   434: invokevirtual 81	java/io/InputStream:close	()V
    //   437: aload 11
    //   439: ifnull -331 -> 108
    //   442: aload 11
    //   444: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   447: return
    //   448: astore 8
    //   450: aload 8
    //   452: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   455: return
    //   456: aload 10
    //   458: astore 8
    //   460: aload 10
    //   462: astore 9
    //   464: aload 11
    //   466: invokestatic 130	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   469: aload 10
    //   471: astore 8
    //   473: aload 10
    //   475: astore 9
    //   477: aload 14
    //   479: invokevirtual 133	java/io/File:delete	()Z
    //   482: pop
    //   483: goto -75 -> 408
    //   486: astore 12
    //   488: aload 11
    //   490: astore 10
    //   492: aload 8
    //   494: astore 9
    //   496: aload 12
    //   498: astore 8
    //   500: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +13 -> 516
    //   506: ldc 140
    //   508: iconst_2
    //   509: ldc 142
    //   511: aload 8
    //   513: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   516: aload_0
    //   517: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   520: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   523: iconst_1
    //   524: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   527: pop
    //   528: aload 9
    //   530: ifnull +11 -> 541
    //   533: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   536: aload 9
    //   538: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   541: aload_0
    //   542: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   545: iconst_0
    //   546: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   549: pop
    //   550: aload_0
    //   551: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   554: invokevirtual 81	java/io/InputStream:close	()V
    //   557: aload 10
    //   559: ifnull -451 -> 108
    //   562: aload 10
    //   564: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   567: return
    //   568: astore 8
    //   570: aload 8
    //   572: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   575: return
    //   576: astore 8
    //   578: aload 8
    //   580: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   583: goto -146 -> 437
    //   586: astore 8
    //   588: aload 8
    //   590: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   593: goto -36 -> 557
    //   596: astore 8
    //   598: aconst_null
    //   599: astore 9
    //   601: aload 10
    //   603: ifnull +11 -> 614
    //   606: invokestatic 69	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   609: aload 10
    //   611: invokevirtual 73	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   614: aload_0
    //   615: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   618: iconst_0
    //   619: invokestatic 76	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   622: pop
    //   623: aload_0
    //   624: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   627: invokevirtual 81	java/io/InputStream:close	()V
    //   630: aload 9
    //   632: ifnull +8 -> 640
    //   635: aload 9
    //   637: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   640: aload 8
    //   642: athrow
    //   643: astore 10
    //   645: aload 10
    //   647: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   650: goto -20 -> 630
    //   653: astore 9
    //   655: aload 9
    //   657: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   660: goto -20 -> 640
    //   663: astore 8
    //   665: aload 9
    //   667: astore 10
    //   669: aload 11
    //   671: astore 9
    //   673: goto -72 -> 601
    //   676: astore 8
    //   678: aload 10
    //   680: astore 11
    //   682: aload 9
    //   684: astore 10
    //   686: aload 11
    //   688: astore 9
    //   690: goto -89 -> 601
    //   693: astore 8
    //   695: aload 12
    //   697: astore 10
    //   699: goto -199 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	5
    //   178	44	1	i	int
    //   207	95	2	l1	long
    //   159	149	4	l2	long
    //   156	144	6	l3	long
    //   26	1	8	localObject1	Object
    //   109	3	8	localIOException1	java.io.IOException
    //   119	3	8	localIOException2	java.io.IOException
    //   163	225	8	localObject2	Object
    //   448	3	8	localIOException3	java.io.IOException
    //   458	54	8	localObject3	Object
    //   568	3	8	localIOException4	java.io.IOException
    //   576	3	8	localIOException5	java.io.IOException
    //   586	3	8	localIOException6	java.io.IOException
    //   596	45	8	localObject4	Object
    //   663	1	8	localObject5	Object
    //   676	1	8	localObject6	Object
    //   693	1	8	localException1	java.lang.Exception
    //   17	619	9	localObject7	Object
    //   653	13	9	localIOException7	java.io.IOException
    //   671	18	9	localObject8	Object
    //   20	590	10	localObject9	Object
    //   643	3	10	localIOException8	java.io.IOException
    //   667	31	10	localObject10	Object
    //   138	549	11	localObject11	Object
    //   14	1	12	localObject12	Object
    //   486	210	12	localException2	java.lang.Exception
    //   23	118	13	localObject13	Object
    //   39	439	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	96	109	java/io/IOException
    //   100	108	119	java/io/IOException
    //   442	447	448	java/io/IOException
    //   144	155	486	java/lang/Exception
    //   169	179	486	java/lang/Exception
    //   192	202	486	java/lang/Exception
    //   216	225	486	java/lang/Exception
    //   236	254	486	java/lang/Exception
    //   262	298	486	java/lang/Exception
    //   322	334	486	java/lang/Exception
    //   342	352	486	java/lang/Exception
    //   360	385	486	java/lang/Exception
    //   393	408	486	java/lang/Exception
    //   464	469	486	java/lang/Exception
    //   477	483	486	java/lang/Exception
    //   562	567	568	java/io/IOException
    //   430	437	576	java/io/IOException
    //   550	557	586	java/io/IOException
    //   28	69	596	finally
    //   127	140	596	finally
    //   623	630	643	java/io/IOException
    //   635	640	653	java/io/IOException
    //   144	155	663	finally
    //   169	179	663	finally
    //   192	202	663	finally
    //   216	225	663	finally
    //   236	254	663	finally
    //   262	298	663	finally
    //   322	334	663	finally
    //   342	352	663	finally
    //   360	385	663	finally
    //   393	408	663	finally
    //   464	469	663	finally
    //   477	483	663	finally
    //   500	516	676	finally
    //   516	528	676	finally
    //   28	69	693	java/lang/Exception
    //   127	140	693	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */