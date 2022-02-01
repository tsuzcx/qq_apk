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
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 14
    //   12: new 33	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 17
    //   25: aload 17
    //   27: invokevirtual 40	java/io/File:exists	()Z
    //   30: ifne +48 -> 78
    //   33: aload 17
    //   35: invokevirtual 43	java/io/File:createNewFile	()Z
    //   38: ifne +40 -> 78
    //   41: aload_0
    //   42: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   45: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   48: iconst_1
    //   49: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   57: iconst_0
    //   58: invokestatic 57	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   66: invokevirtual 62	java/io/InputStream:close	()V
    //   69: return
    //   70: astore 12
    //   72: aload 12
    //   74: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   77: return
    //   78: new 67	java/io/FileOutputStream
    //   81: dup
    //   82: aload_0
    //   83: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   89: astore 16
    //   91: aload 13
    //   93: astore 12
    //   95: aload 16
    //   97: astore 13
    //   99: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   102: sipush 8192
    //   105: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   108: astore 15
    //   110: lconst_0
    //   111: lstore 6
    //   113: lconst_0
    //   114: lstore 8
    //   116: aload 15
    //   118: astore 14
    //   120: aload 15
    //   122: astore 12
    //   124: aload 16
    //   126: astore 13
    //   128: aload_0
    //   129: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   132: aload 15
    //   134: invokevirtual 82	java/io/InputStream:read	([B)I
    //   137: istore 5
    //   139: iload 5
    //   141: iconst_m1
    //   142: if_icmpeq +226 -> 368
    //   145: aload 15
    //   147: astore 14
    //   149: aload 15
    //   151: astore 12
    //   153: aload 16
    //   155: astore 13
    //   157: aload_0
    //   158: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   161: invokestatic 85	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   164: ifeq +204 -> 368
    //   167: iload 5
    //   169: i2l
    //   170: lload 6
    //   172: ladd
    //   173: lstore 6
    //   175: aload 15
    //   177: astore 14
    //   179: aload 15
    //   181: astore 12
    //   183: aload 16
    //   185: astore 13
    //   187: aload 16
    //   189: aload 15
    //   191: iconst_0
    //   192: iload 5
    //   194: invokevirtual 89	java/io/FileOutputStream:write	([BII)V
    //   197: lload 6
    //   199: lload 8
    //   201: lsub
    //   202: l2d
    //   203: dstore_1
    //   204: aload 15
    //   206: astore 14
    //   208: aload 15
    //   210: astore 12
    //   212: aload 16
    //   214: astore 13
    //   216: aload_0
    //   217: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   220: lstore 10
    //   222: lload 10
    //   224: l2d
    //   225: dstore_3
    //   226: dload_1
    //   227: invokestatic 95	java/lang/Double:isNaN	(D)Z
    //   230: pop
    //   231: dload_3
    //   232: invokestatic 95	java/lang/Double:isNaN	(D)Z
    //   235: pop
    //   236: dload_1
    //   237: dload_3
    //   238: ddiv
    //   239: ldc2_w 96
    //   242: dcmpl
    //   243: ifle +567 -> 810
    //   246: aload 15
    //   248: astore 14
    //   250: aload 15
    //   252: astore 12
    //   254: aload 16
    //   256: astore 13
    //   258: aload_0
    //   259: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   262: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   265: astore 18
    //   267: aload 15
    //   269: astore 14
    //   271: aload 15
    //   273: astore 12
    //   275: aload 16
    //   277: astore 13
    //   279: aload_0
    //   280: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   283: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: astore 19
    //   288: lload 6
    //   290: l2d
    //   291: dstore_1
    //   292: aload 15
    //   294: astore 14
    //   296: aload 15
    //   298: astore 12
    //   300: aload 16
    //   302: astore 13
    //   304: aload_0
    //   305: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_Long	J
    //   308: lstore 8
    //   310: lload 8
    //   312: l2d
    //   313: dstore_3
    //   314: dload_1
    //   315: invokestatic 95	java/lang/Double:isNaN	(D)Z
    //   318: pop
    //   319: dload_3
    //   320: invokestatic 95	java/lang/Double:isNaN	(D)Z
    //   323: pop
    //   324: dload_1
    //   325: dload_3
    //   326: ddiv
    //   327: ldc2_w 98
    //   330: dmul
    //   331: d2i
    //   332: istore 5
    //   334: aload 15
    //   336: astore 14
    //   338: aload 15
    //   340: astore 12
    //   342: aload 16
    //   344: astore 13
    //   346: aload 18
    //   348: aload 19
    //   350: iconst_3
    //   351: iload 5
    //   353: iconst_0
    //   354: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   357: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   360: pop
    //   361: lload 6
    //   363: lstore 8
    //   365: goto -249 -> 116
    //   368: lload 6
    //   370: lconst_0
    //   371: lcmp
    //   372: ifne +51 -> 423
    //   375: aload 15
    //   377: astore 14
    //   379: aload 15
    //   381: astore 12
    //   383: aload 16
    //   385: astore 13
    //   387: aload_0
    //   388: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   391: ldc 108
    //   393: invokevirtual 112	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   396: putstatic 113	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   399: aload 15
    //   401: astore 14
    //   403: aload 15
    //   405: astore 12
    //   407: aload 16
    //   409: astore 13
    //   411: aload_0
    //   412: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   415: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   418: iconst_1
    //   419: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   422: pop
    //   423: aload 15
    //   425: astore 14
    //   427: aload 15
    //   429: astore 12
    //   431: aload 16
    //   433: astore 13
    //   435: aload_0
    //   436: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   439: invokestatic 85	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   442: ifeq +70 -> 512
    //   445: aload 15
    //   447: astore 14
    //   449: aload 15
    //   451: astore 12
    //   453: aload 16
    //   455: astore 13
    //   457: aload_0
    //   458: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   461: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   464: aload_0
    //   465: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   468: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   471: iconst_3
    //   472: bipush 100
    //   474: iconst_0
    //   475: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   478: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   481: pop
    //   482: aload 15
    //   484: astore 14
    //   486: aload 15
    //   488: astore 12
    //   490: aload 16
    //   492: astore 13
    //   494: aload_0
    //   495: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   498: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   501: iconst_2
    //   502: ldc2_w 114
    //   505: invokevirtual 119	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   508: pop
    //   509: goto +38 -> 547
    //   512: aload 15
    //   514: astore 14
    //   516: aload 15
    //   518: astore 12
    //   520: aload 16
    //   522: astore 13
    //   524: aload 16
    //   526: invokestatic 125	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   529: aload 15
    //   531: astore 14
    //   533: aload 15
    //   535: astore 12
    //   537: aload 16
    //   539: astore 13
    //   541: aload 17
    //   543: invokevirtual 128	java/io/File:delete	()Z
    //   546: pop
    //   547: aload 15
    //   549: ifnull +11 -> 560
    //   552: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   555: aload 15
    //   557: invokevirtual 132	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   560: aload_0
    //   561: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   564: iconst_0
    //   565: invokestatic 57	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   568: pop
    //   569: aload_0
    //   570: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   573: invokevirtual 62	java/io/InputStream:close	()V
    //   576: goto +10 -> 586
    //   579: astore 12
    //   581: aload 12
    //   583: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   586: aload 16
    //   588: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   591: return
    //   592: astore 17
    //   594: aload 14
    //   596: astore 15
    //   598: aload 16
    //   600: astore 14
    //   602: goto +20 -> 622
    //   605: astore 12
    //   607: aconst_null
    //   608: astore 13
    //   610: goto +132 -> 742
    //   613: astore 17
    //   615: aconst_null
    //   616: astore 14
    //   618: aload 12
    //   620: astore 15
    //   622: aload 15
    //   624: astore 12
    //   626: aload 14
    //   628: astore 13
    //   630: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +21 -> 654
    //   636: aload 15
    //   638: astore 12
    //   640: aload 14
    //   642: astore 13
    //   644: ldc 140
    //   646: iconst_2
    //   647: ldc 142
    //   649: aload 17
    //   651: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: aload 15
    //   656: astore 12
    //   658: aload 14
    //   660: astore 13
    //   662: aload_0
    //   663: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   666: getfield 48	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   669: iconst_1
    //   670: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   673: pop
    //   674: aload 15
    //   676: ifnull +11 -> 687
    //   679: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   682: aload 15
    //   684: invokevirtual 132	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   687: aload_0
    //   688: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   691: iconst_0
    //   692: invokestatic 57	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   695: pop
    //   696: aload_0
    //   697: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   700: invokevirtual 62	java/io/InputStream:close	()V
    //   703: goto +10 -> 713
    //   706: astore 12
    //   708: aload 12
    //   710: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   713: aload 14
    //   715: ifnull +16 -> 731
    //   718: aload 14
    //   720: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   723: return
    //   724: astore 12
    //   726: aload 12
    //   728: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   731: return
    //   732: astore 14
    //   734: aload 12
    //   736: astore 15
    //   738: aload 14
    //   740: astore 12
    //   742: aload 15
    //   744: ifnull +11 -> 755
    //   747: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   750: aload 15
    //   752: invokevirtual 132	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   755: aload_0
    //   756: getfield 16	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   759: iconst_0
    //   760: invokestatic 57	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   763: pop
    //   764: aload_0
    //   765: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   768: invokevirtual 62	java/io/InputStream:close	()V
    //   771: goto +10 -> 781
    //   774: astore 14
    //   776: aload 14
    //   778: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   781: aload 13
    //   783: ifnull +18 -> 801
    //   786: aload 13
    //   788: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   791: goto +10 -> 801
    //   794: astore 13
    //   796: aload 13
    //   798: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   801: goto +6 -> 807
    //   804: aload 12
    //   806: athrow
    //   807: goto -3 -> 804
    //   810: goto -694 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	this	3
    //   203	122	1	d1	double
    //   225	101	3	d2	double
    //   137	215	5	i	int
    //   111	258	6	l1	long
    //   114	250	8	l2	long
    //   220	3	10	l3	long
    //   1	1	12	localObject1	Object
    //   70	3	12	localIOException1	java.io.IOException
    //   93	443	12	localObject2	Object
    //   579	3	12	localIOException2	java.io.IOException
    //   605	14	12	localObject3	Object
    //   624	33	12	localObject4	Object
    //   706	3	12	localIOException3	java.io.IOException
    //   724	11	12	localIOException4	java.io.IOException
    //   740	65	12	localObject5	Object
    //   4	783	13	localObject6	Object
    //   794	3	13	localIOException5	java.io.IOException
    //   10	709	14	localObject7	Object
    //   732	7	14	localObject8	Object
    //   774	3	14	localIOException6	java.io.IOException
    //   7	744	15	localObject9	Object
    //   89	510	16	localFileOutputStream	java.io.FileOutputStream
    //   23	519	17	localFile	java.io.File
    //   592	1	17	localException1	java.lang.Exception
    //   613	37	17	localException2	java.lang.Exception
    //   265	82	18	localMqqHandler1	mqq.os.MqqHandler
    //   286	63	19	localMqqHandler2	mqq.os.MqqHandler
    // Exception table:
    //   from	to	target	type
    //   62	69	70	java/io/IOException
    //   569	576	579	java/io/IOException
    //   99	110	592	java/lang/Exception
    //   128	139	592	java/lang/Exception
    //   157	167	592	java/lang/Exception
    //   187	197	592	java/lang/Exception
    //   216	222	592	java/lang/Exception
    //   258	267	592	java/lang/Exception
    //   279	288	592	java/lang/Exception
    //   304	310	592	java/lang/Exception
    //   346	361	592	java/lang/Exception
    //   387	399	592	java/lang/Exception
    //   411	423	592	java/lang/Exception
    //   435	445	592	java/lang/Exception
    //   457	482	592	java/lang/Exception
    //   494	509	592	java/lang/Exception
    //   524	529	592	java/lang/Exception
    //   541	547	592	java/lang/Exception
    //   12	53	605	finally
    //   78	91	605	finally
    //   12	53	613	java/lang/Exception
    //   78	91	613	java/lang/Exception
    //   696	703	706	java/io/IOException
    //   586	591	724	java/io/IOException
    //   718	723	724	java/io/IOException
    //   99	110	732	finally
    //   128	139	732	finally
    //   157	167	732	finally
    //   187	197	732	finally
    //   216	222	732	finally
    //   258	267	732	finally
    //   279	288	732	finally
    //   304	310	732	finally
    //   346	361	732	finally
    //   387	399	732	finally
    //   411	423	732	finally
    //   435	445	732	finally
    //   457	482	732	finally
    //   494	509	732	finally
    //   524	529	732	finally
    //   541	547	732	finally
    //   630	636	732	finally
    //   644	654	732	finally
    //   662	674	732	finally
    //   764	771	774	java/io/IOException
    //   786	791	794	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */