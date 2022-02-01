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
    //   17: astore 13
    //   19: aconst_null
    //   20: astore 15
    //   22: aconst_null
    //   23: astore 14
    //   25: new 44	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 17
    //   38: aload 17
    //   40: invokevirtual 51	java/io/File:exists	()Z
    //   43: ifne +48 -> 91
    //   46: aload 17
    //   48: invokevirtual 54	java/io/File:createNewFile	()Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   58: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   61: iconst_1
    //   62: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   70: iconst_0
    //   71: invokestatic 66	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   74: pop
    //   75: aload_0
    //   76: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   79: invokevirtual 71	java/io/InputStream:close	()V
    //   82: return
    //   83: astore 12
    //   85: aload 12
    //   87: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   90: return
    //   91: new 76	java/io/FileOutputStream
    //   94: dup
    //   95: aload_0
    //   96: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   102: astore 16
    //   104: aload 13
    //   106: astore 12
    //   108: aload 16
    //   110: astore 13
    //   112: invokestatic 83	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   115: sipush 8192
    //   118: invokevirtual 87	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   121: astore 15
    //   123: lconst_0
    //   124: lstore 6
    //   126: lconst_0
    //   127: lstore 8
    //   129: aload 15
    //   131: astore 14
    //   133: aload 15
    //   135: astore 12
    //   137: aload 16
    //   139: astore 13
    //   141: aload_0
    //   142: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   145: aload 15
    //   147: invokevirtual 91	java/io/InputStream:read	([B)I
    //   150: istore 5
    //   152: iload 5
    //   154: iconst_m1
    //   155: if_icmpeq +226 -> 381
    //   158: aload 15
    //   160: astore 14
    //   162: aload 15
    //   164: astore 12
    //   166: aload 16
    //   168: astore 13
    //   170: aload_0
    //   171: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   174: invokestatic 94	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   177: ifeq +204 -> 381
    //   180: iload 5
    //   182: i2l
    //   183: lload 6
    //   185: ladd
    //   186: lstore 6
    //   188: aload 15
    //   190: astore 14
    //   192: aload 15
    //   194: astore 12
    //   196: aload 16
    //   198: astore 13
    //   200: aload 16
    //   202: aload 15
    //   204: iconst_0
    //   205: iload 5
    //   207: invokevirtual 98	java/io/FileOutputStream:write	([BII)V
    //   210: lload 6
    //   212: lload 8
    //   214: lsub
    //   215: l2d
    //   216: dstore_1
    //   217: aload 15
    //   219: astore 14
    //   221: aload 15
    //   223: astore 12
    //   225: aload 16
    //   227: astore 13
    //   229: aload_0
    //   230: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   233: lstore 10
    //   235: lload 10
    //   237: l2d
    //   238: dstore_3
    //   239: dload_1
    //   240: invokestatic 104	java/lang/Double:isNaN	(D)Z
    //   243: pop
    //   244: dload_3
    //   245: invokestatic 104	java/lang/Double:isNaN	(D)Z
    //   248: pop
    //   249: dload_1
    //   250: dload_3
    //   251: ddiv
    //   252: ldc2_w 105
    //   255: dcmpl
    //   256: ifle +543 -> 799
    //   259: aload 15
    //   261: astore 14
    //   263: aload 15
    //   265: astore 12
    //   267: aload 16
    //   269: astore 13
    //   271: aload_0
    //   272: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   275: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   278: astore 18
    //   280: aload 15
    //   282: astore 14
    //   284: aload 15
    //   286: astore 12
    //   288: aload 16
    //   290: astore 13
    //   292: aload_0
    //   293: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   296: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   299: astore 19
    //   301: lload 6
    //   303: l2d
    //   304: dstore_1
    //   305: aload 15
    //   307: astore 14
    //   309: aload 15
    //   311: astore 12
    //   313: aload 16
    //   315: astore 13
    //   317: aload_0
    //   318: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_Long	J
    //   321: lstore 8
    //   323: lload 8
    //   325: l2d
    //   326: dstore_3
    //   327: dload_1
    //   328: invokestatic 104	java/lang/Double:isNaN	(D)Z
    //   331: pop
    //   332: dload_3
    //   333: invokestatic 104	java/lang/Double:isNaN	(D)Z
    //   336: pop
    //   337: dload_1
    //   338: dload_3
    //   339: ddiv
    //   340: ldc2_w 107
    //   343: dmul
    //   344: d2i
    //   345: istore 5
    //   347: aload 15
    //   349: astore 14
    //   351: aload 15
    //   353: astore 12
    //   355: aload 16
    //   357: astore 13
    //   359: aload 18
    //   361: aload 19
    //   363: iconst_3
    //   364: iload 5
    //   366: iconst_0
    //   367: invokevirtual 112	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   370: invokevirtual 116	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   373: pop
    //   374: lload 6
    //   376: lstore 8
    //   378: goto -249 -> 129
    //   381: lload 6
    //   383: lconst_0
    //   384: lcmp
    //   385: ifne +27 -> 412
    //   388: aload 15
    //   390: astore 14
    //   392: aload 15
    //   394: astore 12
    //   396: aload 16
    //   398: astore 13
    //   400: aload_0
    //   401: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   404: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   407: iconst_1
    //   408: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   411: pop
    //   412: aload 15
    //   414: astore 14
    //   416: aload 15
    //   418: astore 12
    //   420: aload 16
    //   422: astore 13
    //   424: aload_0
    //   425: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   428: invokestatic 94	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   431: ifeq +70 -> 501
    //   434: aload 15
    //   436: astore 14
    //   438: aload 15
    //   440: astore 12
    //   442: aload 16
    //   444: astore 13
    //   446: aload_0
    //   447: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   450: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   453: aload_0
    //   454: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   457: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   460: iconst_3
    //   461: bipush 100
    //   463: iconst_0
    //   464: invokevirtual 112	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   467: invokevirtual 116	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   470: pop
    //   471: aload 15
    //   473: astore 14
    //   475: aload 15
    //   477: astore 12
    //   479: aload 16
    //   481: astore 13
    //   483: aload_0
    //   484: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   487: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   490: iconst_2
    //   491: ldc2_w 117
    //   494: invokevirtual 122	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   497: pop
    //   498: goto +38 -> 536
    //   501: aload 15
    //   503: astore 14
    //   505: aload 15
    //   507: astore 12
    //   509: aload 16
    //   511: astore 13
    //   513: aload 16
    //   515: invokestatic 128	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   518: aload 15
    //   520: astore 14
    //   522: aload 15
    //   524: astore 12
    //   526: aload 16
    //   528: astore 13
    //   530: aload 17
    //   532: invokevirtual 131	java/io/File:delete	()Z
    //   535: pop
    //   536: aload 15
    //   538: ifnull +11 -> 549
    //   541: invokestatic 83	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   544: aload 15
    //   546: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   549: aload_0
    //   550: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   553: iconst_0
    //   554: invokestatic 66	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   557: pop
    //   558: aload_0
    //   559: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   562: invokevirtual 71	java/io/InputStream:close	()V
    //   565: goto +10 -> 575
    //   568: astore 12
    //   570: aload 12
    //   572: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   575: aload 16
    //   577: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   580: return
    //   581: astore 17
    //   583: aload 14
    //   585: astore 15
    //   587: aload 16
    //   589: astore 14
    //   591: goto +20 -> 611
    //   594: astore 12
    //   596: aconst_null
    //   597: astore 13
    //   599: goto +132 -> 731
    //   602: astore 17
    //   604: aconst_null
    //   605: astore 14
    //   607: aload 12
    //   609: astore 15
    //   611: aload 15
    //   613: astore 12
    //   615: aload 14
    //   617: astore 13
    //   619: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +21 -> 643
    //   625: aload 15
    //   627: astore 12
    //   629: aload 14
    //   631: astore 13
    //   633: ldc 143
    //   635: iconst_2
    //   636: ldc 145
    //   638: aload 17
    //   640: invokestatic 149	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   643: aload 15
    //   645: astore 12
    //   647: aload 14
    //   649: astore 13
    //   651: aload_0
    //   652: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   655: getfield 57	cooperation/qlink/QlinkShareJumpActivity:a	Lmqq/os/MqqHandler;
    //   658: iconst_1
    //   659: invokevirtual 63	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   662: pop
    //   663: aload 15
    //   665: ifnull +11 -> 676
    //   668: invokestatic 83	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   671: aload 15
    //   673: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   676: aload_0
    //   677: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   680: iconst_0
    //   681: invokestatic 66	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   684: pop
    //   685: aload_0
    //   686: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   689: invokevirtual 71	java/io/InputStream:close	()V
    //   692: goto +10 -> 702
    //   695: astore 12
    //   697: aload 12
    //   699: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   702: aload 14
    //   704: ifnull +16 -> 720
    //   707: aload 14
    //   709: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   712: return
    //   713: astore 12
    //   715: aload 12
    //   717: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   720: return
    //   721: astore 14
    //   723: aload 12
    //   725: astore 15
    //   727: aload 14
    //   729: astore 12
    //   731: aload 15
    //   733: ifnull +11 -> 744
    //   736: invokestatic 83	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   739: aload 15
    //   741: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   744: aload_0
    //   745: getfield 16	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   748: iconst_0
    //   749: invokestatic 66	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   752: pop
    //   753: aload_0
    //   754: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   757: invokevirtual 71	java/io/InputStream:close	()V
    //   760: goto +10 -> 770
    //   763: astore 14
    //   765: aload 14
    //   767: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   770: aload 13
    //   772: ifnull +18 -> 790
    //   775: aload 13
    //   777: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   780: goto +10 -> 790
    //   783: astore 13
    //   785: aload 13
    //   787: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   790: goto +6 -> 796
    //   793: aload 12
    //   795: athrow
    //   796: goto -3 -> 793
    //   799: goto -670 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	this	5
    //   216	122	1	d1	double
    //   238	101	3	d2	double
    //   150	215	5	i	int
    //   124	258	6	l1	long
    //   127	250	8	l2	long
    //   233	3	10	l3	long
    //   14	1	12	localObject1	Object
    //   83	3	12	localIOException1	java.io.IOException
    //   106	419	12	localObject2	Object
    //   568	3	12	localIOException2	java.io.IOException
    //   594	14	12	localObject3	Object
    //   613	33	12	localObject4	Object
    //   695	3	12	localIOException3	java.io.IOException
    //   713	11	12	localIOException4	java.io.IOException
    //   729	65	12	localObject5	Object
    //   17	759	13	localObject6	Object
    //   783	3	13	localIOException5	java.io.IOException
    //   23	685	14	localObject7	Object
    //   721	7	14	localObject8	Object
    //   763	3	14	localIOException6	java.io.IOException
    //   20	720	15	localObject9	Object
    //   102	486	16	localFileOutputStream	java.io.FileOutputStream
    //   36	495	17	localFile	java.io.File
    //   581	1	17	localException1	java.lang.Exception
    //   602	37	17	localException2	java.lang.Exception
    //   278	82	18	localMqqHandler1	mqq.os.MqqHandler
    //   299	63	19	localMqqHandler2	mqq.os.MqqHandler
    // Exception table:
    //   from	to	target	type
    //   75	82	83	java/io/IOException
    //   558	565	568	java/io/IOException
    //   112	123	581	java/lang/Exception
    //   141	152	581	java/lang/Exception
    //   170	180	581	java/lang/Exception
    //   200	210	581	java/lang/Exception
    //   229	235	581	java/lang/Exception
    //   271	280	581	java/lang/Exception
    //   292	301	581	java/lang/Exception
    //   317	323	581	java/lang/Exception
    //   359	374	581	java/lang/Exception
    //   400	412	581	java/lang/Exception
    //   424	434	581	java/lang/Exception
    //   446	471	581	java/lang/Exception
    //   483	498	581	java/lang/Exception
    //   513	518	581	java/lang/Exception
    //   530	536	581	java/lang/Exception
    //   25	66	594	finally
    //   91	104	594	finally
    //   25	66	602	java/lang/Exception
    //   91	104	602	java/lang/Exception
    //   685	692	695	java/io/IOException
    //   575	580	713	java/io/IOException
    //   707	712	713	java/io/IOException
    //   112	123	721	finally
    //   141	152	721	finally
    //   170	180	721	finally
    //   200	210	721	finally
    //   229	235	721	finally
    //   271	280	721	finally
    //   292	301	721	finally
    //   317	323	721	finally
    //   359	374	721	finally
    //   400	412	721	finally
    //   424	434	721	finally
    //   446	471	721	finally
    //   483	498	721	finally
    //   513	518	721	finally
    //   530	536	721	finally
    //   619	625	721	finally
    //   633	643	721	finally
    //   651	663	721	finally
    //   753	760	763	java/io/IOException
    //   775	780	783	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */