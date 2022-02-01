package com.tencent.mobileqq.data;

public class MessageForFuDai$Encoder
{
  /* Error */
  public static byte[] a(MessageForFuDai paramMessageForFuDai)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: new 17	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 18	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: new 20	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 23	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore 4
    //   28: aload 5
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: invokestatic 29	com/tencent/mobileqq/data/MessageForFuDai:access$000	(Lcom/tencent/mobileqq/data/MessageForFuDai;)I
    //   37: invokevirtual 33	java/io/ObjectOutputStream:writeInt	(I)V
    //   40: aload 5
    //   42: astore_2
    //   43: lconst_0
    //   44: invokestatic 39	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: astore 6
    //   49: aload_0
    //   50: getfield 43	com/tencent/mobileqq/data/MessageForFuDai:hostUin	Ljava/lang/String;
    //   53: invokestatic 46	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: astore_3
    //   57: goto +33 -> 90
    //   60: astore 7
    //   62: aload 6
    //   64: astore_3
    //   65: aload 5
    //   67: astore_2
    //   68: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +19 -> 90
    //   74: aload 5
    //   76: astore_2
    //   77: ldc 54
    //   79: iconst_2
    //   80: ldc 56
    //   82: aload 7
    //   84: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload 6
    //   89: astore_3
    //   90: aload 5
    //   92: astore_2
    //   93: aload 4
    //   95: aload_3
    //   96: invokevirtual 64	java/lang/Long:longValue	()J
    //   99: invokevirtual 68	java/io/ObjectOutputStream:writeLong	(J)V
    //   102: aload 5
    //   104: astore_2
    //   105: aload 4
    //   107: aload_0
    //   108: getfield 71	com/tencent/mobileqq/data/MessageForFuDai:fdId	Ljava/lang/String;
    //   111: invokevirtual 75	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   114: aload 5
    //   116: astore_2
    //   117: aload 4
    //   119: aload_0
    //   120: getfield 79	com/tencent/mobileqq/data/MessageForFuDai:shareType	I
    //   123: invokevirtual 33	java/io/ObjectOutputStream:writeInt	(I)V
    //   126: aload 5
    //   128: astore_2
    //   129: lconst_0
    //   130: invokestatic 39	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: astore 6
    //   135: aload_0
    //   136: getfield 82	com/tencent/mobileqq/data/MessageForFuDai:targetId	Ljava/lang/String;
    //   139: invokestatic 46	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   142: astore_3
    //   143: goto +33 -> 176
    //   146: astore 7
    //   148: aload 6
    //   150: astore_3
    //   151: aload 5
    //   153: astore_2
    //   154: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +19 -> 176
    //   160: aload 5
    //   162: astore_2
    //   163: ldc 54
    //   165: iconst_2
    //   166: ldc 84
    //   168: aload 7
    //   170: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload 6
    //   175: astore_3
    //   176: aload 5
    //   178: astore_2
    //   179: aload 4
    //   181: aload_3
    //   182: invokevirtual 64	java/lang/Long:longValue	()J
    //   185: invokevirtual 68	java/io/ObjectOutputStream:writeLong	(J)V
    //   188: aload 5
    //   190: astore_2
    //   191: aload 4
    //   193: aload_0
    //   194: getfield 87	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
    //   197: invokevirtual 75	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   200: aload 5
    //   202: astore_2
    //   203: aload 4
    //   205: aload_0
    //   206: getfield 90	com/tencent/mobileqq/data/MessageForFuDai:aioTails	Ljava/lang/String;
    //   209: invokevirtual 75	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   212: aload 5
    //   214: astore_2
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 93	com/tencent/mobileqq/data/MessageForFuDai:busiId	I
    //   221: invokevirtual 33	java/io/ObjectOutputStream:writeInt	(I)V
    //   224: aload 5
    //   226: astore_2
    //   227: aload 4
    //   229: aload_0
    //   230: invokestatic 97	com/tencent/mobileqq/data/MessageForFuDai:access$100	(Lcom/tencent/mobileqq/data/MessageForFuDai;)Ljava/lang/String;
    //   233: invokevirtual 75	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   236: aload 5
    //   238: astore_2
    //   239: aload 4
    //   241: aload_0
    //   242: getfield 100	com/tencent/mobileqq/data/MessageForFuDai:expireTime	I
    //   245: invokevirtual 33	java/io/ObjectOutputStream:writeInt	(I)V
    //   248: aload 5
    //   250: astore_2
    //   251: aload 4
    //   253: aload_0
    //   254: getfield 103	com/tencent/mobileqq/data/MessageForFuDai:themeId	I
    //   257: invokevirtual 33	java/io/ObjectOutputStream:writeInt	(I)V
    //   260: aload 5
    //   262: astore_2
    //   263: aload 4
    //   265: invokevirtual 106	java/io/ObjectOutputStream:flush	()V
    //   268: aload 5
    //   270: astore_2
    //   271: aload_1
    //   272: invokevirtual 110	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   275: astore_0
    //   276: aload_0
    //   277: astore_2
    //   278: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +52 -> 333
    //   284: aload_0
    //   285: astore_2
    //   286: new 112	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   293: astore_3
    //   294: aload_0
    //   295: astore_2
    //   296: aload_3
    //   297: ldc 115
    //   299: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_0
    //   304: astore_2
    //   305: aload_3
    //   306: aload_0
    //   307: arraylength
    //   308: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_0
    //   313: astore_2
    //   314: aload_3
    //   315: ldc 124
    //   317: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_0
    //   322: astore_2
    //   323: ldc 54
    //   325: iconst_2
    //   326: aload_3
    //   327: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 4
    //   335: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   338: goto +13 -> 351
    //   341: astore_2
    //   342: ldc 54
    //   344: iconst_1
    //   345: ldc 137
    //   347: aload_2
    //   348: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload_1
    //   352: invokevirtual 138	java/io/ByteArrayOutputStream:close	()V
    //   355: aload_0
    //   356: areturn
    //   357: astore_1
    //   358: ldc 54
    //   360: iconst_1
    //   361: ldc 137
    //   363: aload_1
    //   364: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_0
    //   368: areturn
    //   369: astore_2
    //   370: aload 4
    //   372: astore_0
    //   373: goto +112 -> 485
    //   376: astore 5
    //   378: aload_2
    //   379: astore_0
    //   380: goto +44 -> 424
    //   383: astore 4
    //   385: aload_3
    //   386: astore_0
    //   387: aload_2
    //   388: astore_1
    //   389: aload 4
    //   391: astore_2
    //   392: goto +93 -> 485
    //   395: astore 5
    //   397: aconst_null
    //   398: astore_0
    //   399: aload 6
    //   401: astore 4
    //   403: goto +21 -> 424
    //   406: astore_2
    //   407: aconst_null
    //   408: astore_1
    //   409: aload_1
    //   410: astore_0
    //   411: goto +74 -> 485
    //   414: astore 5
    //   416: aconst_null
    //   417: astore_1
    //   418: aload_1
    //   419: astore_0
    //   420: aload 6
    //   422: astore 4
    //   424: aload 4
    //   426: astore_3
    //   427: aload_1
    //   428: astore_2
    //   429: ldc 54
    //   431: iconst_1
    //   432: ldc 137
    //   434: aload 5
    //   436: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: aload 4
    //   441: ifnull +21 -> 462
    //   444: aload 4
    //   446: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   449: goto +13 -> 462
    //   452: astore_2
    //   453: ldc 54
    //   455: iconst_1
    //   456: ldc 137
    //   458: aload_2
    //   459: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload_1
    //   463: ifnull +20 -> 483
    //   466: aload_1
    //   467: invokevirtual 138	java/io/ByteArrayOutputStream:close	()V
    //   470: goto +13 -> 483
    //   473: astore_1
    //   474: ldc 54
    //   476: iconst_1
    //   477: ldc 137
    //   479: aload_1
    //   480: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   483: aload_0
    //   484: areturn
    //   485: aload_0
    //   486: ifnull +20 -> 506
    //   489: aload_0
    //   490: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   493: goto +13 -> 506
    //   496: astore_0
    //   497: ldc 54
    //   499: iconst_1
    //   500: ldc 137
    //   502: aload_0
    //   503: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: aload_1
    //   507: ifnull +20 -> 527
    //   510: aload_1
    //   511: invokevirtual 138	java/io/ByteArrayOutputStream:close	()V
    //   514: goto +13 -> 527
    //   517: astore_0
    //   518: ldc 54
    //   520: iconst_1
    //   521: ldc 137
    //   523: aload_0
    //   524: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   527: aload_2
    //   528: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramMessageForFuDai	MessageForFuDai
    //   15	337	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   357	7	1	localIOException1	java.io.IOException
    //   388	79	1	localObject1	Object
    //   473	38	1	localIOException2	java.io.IOException
    //   17	306	2	localObject2	Object
    //   341	7	2	localIOException3	java.io.IOException
    //   369	19	2	localObject3	Object
    //   391	1	2	localObject4	Object
    //   406	1	2	localObject5	Object
    //   428	1	2	localObject6	Object
    //   452	76	2	localIOException4	java.io.IOException
    //   1	426	3	localObject7	Object
    //   26	345	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   383	7	4	localObject8	Object
    //   401	44	4	localLong1	java.lang.Long
    //   6	263	5	localObject9	Object
    //   376	1	5	localException1	java.lang.Exception
    //   395	1	5	localException2	java.lang.Exception
    //   414	21	5	localException3	java.lang.Exception
    //   3	418	6	localLong2	java.lang.Long
    //   60	23	7	localException4	java.lang.Exception
    //   146	23	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   49	57	60	java/lang/Exception
    //   135	143	146	java/lang/Exception
    //   333	338	341	java/io/IOException
    //   351	355	357	java/io/IOException
    //   31	40	369	finally
    //   43	49	369	finally
    //   49	57	369	finally
    //   68	74	369	finally
    //   77	87	369	finally
    //   93	102	369	finally
    //   105	114	369	finally
    //   117	126	369	finally
    //   129	135	369	finally
    //   135	143	369	finally
    //   154	160	369	finally
    //   163	173	369	finally
    //   179	188	369	finally
    //   191	200	369	finally
    //   203	212	369	finally
    //   215	224	369	finally
    //   227	236	369	finally
    //   239	248	369	finally
    //   251	260	369	finally
    //   263	268	369	finally
    //   271	276	369	finally
    //   278	284	369	finally
    //   286	294	369	finally
    //   296	303	369	finally
    //   305	312	369	finally
    //   314	321	369	finally
    //   323	333	369	finally
    //   31	40	376	java/lang/Exception
    //   43	49	376	java/lang/Exception
    //   68	74	376	java/lang/Exception
    //   77	87	376	java/lang/Exception
    //   93	102	376	java/lang/Exception
    //   105	114	376	java/lang/Exception
    //   117	126	376	java/lang/Exception
    //   129	135	376	java/lang/Exception
    //   154	160	376	java/lang/Exception
    //   163	173	376	java/lang/Exception
    //   179	188	376	java/lang/Exception
    //   191	200	376	java/lang/Exception
    //   203	212	376	java/lang/Exception
    //   215	224	376	java/lang/Exception
    //   227	236	376	java/lang/Exception
    //   239	248	376	java/lang/Exception
    //   251	260	376	java/lang/Exception
    //   263	268	376	java/lang/Exception
    //   271	276	376	java/lang/Exception
    //   278	284	376	java/lang/Exception
    //   286	294	376	java/lang/Exception
    //   296	303	376	java/lang/Exception
    //   305	312	376	java/lang/Exception
    //   314	321	376	java/lang/Exception
    //   323	333	376	java/lang/Exception
    //   18	28	383	finally
    //   429	439	383	finally
    //   18	28	395	java/lang/Exception
    //   8	16	406	finally
    //   8	16	414	java/lang/Exception
    //   444	449	452	java/io/IOException
    //   466	470	473	java/io/IOException
    //   489	493	496	java/io/IOException
    //   510	514	517	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFuDai.Encoder
 * JD-Core Version:    0.7.0.1
 */