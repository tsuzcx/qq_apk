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
    //   146: lstore 4
    //   148: aload 11
    //   150: astore 8
    //   152: aload 11
    //   154: astore 9
    //   156: aload_0
    //   157: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   160: aload 11
    //   162: invokevirtual 89	java/io/InputStream:read	([B)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +126 -> 294
    //   171: aload 11
    //   173: astore 8
    //   175: aload 11
    //   177: astore 9
    //   179: aload_0
    //   180: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   183: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   186: ifeq +108 -> 294
    //   189: lload 4
    //   191: iload_1
    //   192: i2l
    //   193: ladd
    //   194: lstore_2
    //   195: aload 11
    //   197: astore 8
    //   199: aload 11
    //   201: astore 9
    //   203: aload 10
    //   205: aload 11
    //   207: iconst_0
    //   208: iload_1
    //   209: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   212: lload_2
    //   213: lstore 4
    //   215: aload 11
    //   217: astore 8
    //   219: aload 11
    //   221: astore 9
    //   223: lload_2
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 97
    //   237: dcmpl
    //   238: ifle -90 -> 148
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
    //   264: lload_2
    //   265: l2d
    //   266: aload_0
    //   267: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   270: l2d
    //   271: ddiv
    //   272: ldc2_w 99
    //   275: dmul
    //   276: d2i
    //   277: iconst_0
    //   278: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   281: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   284: pop
    //   285: lload_2
    //   286: lstore 6
    //   288: lload_2
    //   289: lstore 4
    //   291: goto -143 -> 148
    //   294: lload 4
    //   296: lconst_0
    //   297: lcmp
    //   298: ifne +43 -> 341
    //   301: aload 11
    //   303: astore 8
    //   305: aload 11
    //   307: astore 9
    //   309: aload_0
    //   310: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   313: ldc 109
    //   315: invokevirtual 113	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   318: putstatic 114	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: aload 11
    //   323: astore 8
    //   325: aload 11
    //   327: astore 9
    //   329: aload_0
    //   330: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   333: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   336: iconst_1
    //   337: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   340: pop
    //   341: aload 11
    //   343: astore 8
    //   345: aload 11
    //   347: astore 9
    //   349: aload_0
    //   350: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   353: invokestatic 92	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   356: ifeq +107 -> 463
    //   359: aload 11
    //   361: astore 8
    //   363: aload 11
    //   365: astore 9
    //   367: aload_0
    //   368: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   371: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   374: aload_0
    //   375: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   378: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   381: iconst_3
    //   382: bipush 100
    //   384: iconst_0
    //   385: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   388: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   391: pop
    //   392: aload 11
    //   394: astore 8
    //   396: aload 11
    //   398: astore 9
    //   400: aload_0
    //   401: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   404: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   407: iconst_2
    //   408: ldc2_w 115
    //   411: invokevirtual 120	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   414: pop
    //   415: aload 11
    //   417: ifnull +11 -> 428
    //   420: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   423: aload 11
    //   425: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   428: aload_0
    //   429: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   432: iconst_0
    //   433: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   436: pop
    //   437: aload_0
    //   438: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   441: invokevirtual 72	java/io/InputStream:close	()V
    //   444: aload 10
    //   446: ifnull -351 -> 95
    //   449: aload 10
    //   451: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   454: return
    //   455: astore 8
    //   457: aload 8
    //   459: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   462: return
    //   463: aload 11
    //   465: astore 8
    //   467: aload 11
    //   469: astore 9
    //   471: aload 10
    //   473: invokestatic 127	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   476: aload 11
    //   478: astore 8
    //   480: aload 11
    //   482: astore 9
    //   484: aload 14
    //   486: invokevirtual 130	java/io/File:delete	()Z
    //   489: pop
    //   490: goto -75 -> 415
    //   493: astore 11
    //   495: aload 8
    //   497: astore 9
    //   499: aload 11
    //   501: astore 8
    //   503: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +13 -> 519
    //   509: ldc 137
    //   511: iconst_2
    //   512: ldc 139
    //   514: aload 8
    //   516: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload_0
    //   520: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   523: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   526: iconst_1
    //   527: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   530: pop
    //   531: aload 9
    //   533: ifnull +11 -> 544
    //   536: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   539: aload 9
    //   541: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   544: aload_0
    //   545: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   548: iconst_0
    //   549: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   552: pop
    //   553: aload_0
    //   554: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   557: invokevirtual 72	java/io/InputStream:close	()V
    //   560: aload 10
    //   562: ifnull -467 -> 95
    //   565: aload 10
    //   567: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   570: return
    //   571: astore 8
    //   573: aload 8
    //   575: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   578: return
    //   579: astore 8
    //   581: aload 8
    //   583: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   586: goto -142 -> 444
    //   589: astore 8
    //   591: aload 8
    //   593: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   596: goto -36 -> 560
    //   599: astore 8
    //   601: aconst_null
    //   602: astore 10
    //   604: aload 9
    //   606: ifnull +11 -> 617
    //   609: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   612: aload 9
    //   614: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   617: aload_0
    //   618: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   621: iconst_0
    //   622: invokestatic 67	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   625: pop
    //   626: aload_0
    //   627: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   630: invokevirtual 72	java/io/InputStream:close	()V
    //   633: aload 10
    //   635: ifnull +8 -> 643
    //   638: aload 10
    //   640: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   643: aload 8
    //   645: athrow
    //   646: astore 9
    //   648: aload 9
    //   650: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   653: goto -20 -> 633
    //   656: astore 9
    //   658: aload 9
    //   660: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   663: goto -20 -> 643
    //   666: astore 8
    //   668: goto -64 -> 604
    //   671: astore 8
    //   673: goto -69 -> 604
    //   676: astore 8
    //   678: aload 12
    //   680: astore 9
    //   682: aload 11
    //   684: astore 10
    //   686: goto -183 -> 503
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	3
    //   165	44	1	i	int
    //   194	95	2	l1	long
    //   146	149	4	l2	long
    //   143	144	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   150	245	8	arrayOfByte1	byte[]
    //   455	3	8	localIOException3	java.io.IOException
    //   465	50	8	localObject2	Object
    //   571	3	8	localIOException4	java.io.IOException
    //   579	3	8	localIOException5	java.io.IOException
    //   589	3	8	localIOException6	java.io.IOException
    //   599	45	8	localObject3	Object
    //   666	1	8	localObject4	Object
    //   671	1	8	localObject5	Object
    //   676	1	8	localException1	java.lang.Exception
    //   7	606	9	localObject6	Object
    //   646	3	9	localIOException7	java.io.IOException
    //   656	3	9	localIOException8	java.io.IOException
    //   680	1	9	localObject7	Object
    //   125	560	10	localObject8	Object
    //   1	480	11	arrayOfByte2	byte[]
    //   493	190	11	localException2	java.lang.Exception
    //   4	675	12	localObject9	Object
    //   10	118	13	localObject10	Object
    //   26	459	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   449	454	455	java/io/IOException
    //   131	142	493	java/lang/Exception
    //   156	166	493	java/lang/Exception
    //   179	189	493	java/lang/Exception
    //   203	212	493	java/lang/Exception
    //   223	241	493	java/lang/Exception
    //   249	285	493	java/lang/Exception
    //   309	321	493	java/lang/Exception
    //   329	341	493	java/lang/Exception
    //   349	359	493	java/lang/Exception
    //   367	392	493	java/lang/Exception
    //   400	415	493	java/lang/Exception
    //   471	476	493	java/lang/Exception
    //   484	490	493	java/lang/Exception
    //   565	570	571	java/io/IOException
    //   437	444	579	java/io/IOException
    //   553	560	589	java/io/IOException
    //   15	56	599	finally
    //   114	127	599	finally
    //   626	633	646	java/io/IOException
    //   638	643	656	java/io/IOException
    //   131	142	666	finally
    //   156	166	666	finally
    //   179	189	666	finally
    //   203	212	666	finally
    //   223	241	666	finally
    //   249	285	666	finally
    //   309	321	666	finally
    //   329	341	666	finally
    //   349	359	666	finally
    //   367	392	666	finally
    //   400	415	666	finally
    //   471	476	666	finally
    //   484	490	666	finally
    //   503	519	671	finally
    //   519	531	671	finally
    //   15	56	676	java/lang/Exception
    //   114	127	676	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */