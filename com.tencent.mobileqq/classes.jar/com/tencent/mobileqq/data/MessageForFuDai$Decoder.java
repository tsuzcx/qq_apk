package com.tencent.mobileqq.data;

public class MessageForFuDai$Decoder
{
  /* Error */
  public static void a(byte[] paramArrayOfByte, MessageForFuDai paramMessageForFuDai)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 17	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 20	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_0
    //   14: aload_0
    //   15: astore_2
    //   16: new 22	java/io/ObjectInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 25	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 4
    //   26: aload_1
    //   27: aload 4
    //   29: invokevirtual 29	java/io/ObjectInputStream:readInt	()I
    //   32: invokestatic 35	com/tencent/mobileqq/data/MessageForFuDai:access$002	(Lcom/tencent/mobileqq/data/MessageForFuDai;I)I
    //   35: pop
    //   36: new 37	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload 4
    //   47: invokevirtual 42	java/io/ObjectInputStream:readLong	()J
    //   50: invokevirtual 46	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: ldc 48
    //   57: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: putfield 59	com/tencent/mobileqq/data/MessageForFuDai:hostUin	Ljava/lang/String;
    //   69: aload_1
    //   70: aload 4
    //   72: invokevirtual 62	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   75: putfield 65	com/tencent/mobileqq/data/MessageForFuDai:fdId	Ljava/lang/String;
    //   78: aload_1
    //   79: aload 4
    //   81: invokevirtual 29	java/io/ObjectInputStream:readInt	()I
    //   84: putfield 69	com/tencent/mobileqq/data/MessageForFuDai:shareType	I
    //   87: new 37	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   94: astore_2
    //   95: aload_2
    //   96: aload 4
    //   98: invokevirtual 42	java/io/ObjectInputStream:readLong	()J
    //   101: invokevirtual 46	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: ldc 48
    //   108: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload_2
    //   114: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: putfield 72	com/tencent/mobileqq/data/MessageForFuDai:targetId	Ljava/lang/String;
    //   120: aload_1
    //   121: aload 4
    //   123: invokevirtual 62	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   126: putfield 75	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
    //   129: aload_1
    //   130: aload 4
    //   132: invokevirtual 62	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   135: putfield 78	com/tencent/mobileqq/data/MessageForFuDai:aioTails	Ljava/lang/String;
    //   138: aload_1
    //   139: aload 4
    //   141: invokevirtual 29	java/io/ObjectInputStream:readInt	()I
    //   144: putfield 81	com/tencent/mobileqq/data/MessageForFuDai:busiId	I
    //   147: aload_1
    //   148: aload 4
    //   150: invokevirtual 62	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   153: invokestatic 85	com/tencent/mobileqq/data/MessageForFuDai:access$102	(Lcom/tencent/mobileqq/data/MessageForFuDai;Ljava/lang/String;)Ljava/lang/String;
    //   156: pop
    //   157: aload_1
    //   158: aload 4
    //   160: invokevirtual 29	java/io/ObjectInputStream:readInt	()I
    //   163: putfield 88	com/tencent/mobileqq/data/MessageForFuDai:expireTime	I
    //   166: aload_1
    //   167: aload 4
    //   169: invokevirtual 29	java/io/ObjectInputStream:readInt	()I
    //   172: putfield 91	com/tencent/mobileqq/data/MessageForFuDai:themeId	I
    //   175: aload_1
    //   176: aload_1
    //   177: getfield 75	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
    //   180: putfield 94	com/tencent/mobileqq/data/MessageForFuDai:msg	Ljava/lang/String;
    //   183: aload 4
    //   185: invokevirtual 97	java/io/ObjectInputStream:close	()V
    //   188: goto +13 -> 201
    //   191: astore_1
    //   192: ldc 99
    //   194: iconst_1
    //   195: ldc 101
    //   197: aload_1
    //   198: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: invokevirtual 108	java/io/ByteArrayInputStream:close	()V
    //   205: return
    //   206: astore_2
    //   207: aload 4
    //   209: astore_1
    //   210: goto +103 -> 313
    //   213: astore_2
    //   214: aload 4
    //   216: astore_1
    //   217: aload_2
    //   218: astore 4
    //   220: goto +38 -> 258
    //   223: astore 4
    //   225: aload_3
    //   226: astore_1
    //   227: aload_2
    //   228: astore_0
    //   229: aload 4
    //   231: astore_2
    //   232: goto +81 -> 313
    //   235: astore 4
    //   237: aload 5
    //   239: astore_1
    //   240: goto +18 -> 258
    //   243: astore_2
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_1
    //   247: astore_0
    //   248: goto +65 -> 313
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_0
    //   255: aload 5
    //   257: astore_1
    //   258: aload_1
    //   259: astore_3
    //   260: aload_0
    //   261: astore_2
    //   262: ldc 99
    //   264: iconst_1
    //   265: ldc 101
    //   267: aload 4
    //   269: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_1
    //   273: ifnull +20 -> 293
    //   276: aload_1
    //   277: invokevirtual 97	java/io/ObjectInputStream:close	()V
    //   280: goto +13 -> 293
    //   283: astore_1
    //   284: ldc 99
    //   286: iconst_1
    //   287: ldc 101
    //   289: aload_1
    //   290: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: aload_0
    //   294: ifnull +18 -> 312
    //   297: aload_0
    //   298: invokevirtual 108	java/io/ByteArrayInputStream:close	()V
    //   301: return
    //   302: astore_0
    //   303: ldc 99
    //   305: iconst_1
    //   306: ldc 101
    //   308: aload_0
    //   309: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: return
    //   313: aload_1
    //   314: ifnull +20 -> 334
    //   317: aload_1
    //   318: invokevirtual 97	java/io/ObjectInputStream:close	()V
    //   321: goto +13 -> 334
    //   324: astore_1
    //   325: ldc 99
    //   327: iconst_1
    //   328: ldc 101
    //   330: aload_1
    //   331: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload_0
    //   335: ifnull +20 -> 355
    //   338: aload_0
    //   339: invokevirtual 108	java/io/ByteArrayInputStream:close	()V
    //   342: goto +13 -> 355
    //   345: astore_0
    //   346: ldc 99
    //   348: iconst_1
    //   349: ldc 101
    //   351: aload_0
    //   352: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   355: aload_2
    //   356: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramArrayOfByte	byte[]
    //   0	357	1	paramMessageForFuDai	MessageForFuDai
    //   15	99	2	localObject1	Object
    //   206	1	2	localObject2	Object
    //   213	15	2	localException1	java.lang.Exception
    //   231	1	2	localObject3	Object
    //   243	1	2	localObject4	Object
    //   261	95	2	arrayOfByte	byte[]
    //   4	256	3	localMessageForFuDai	MessageForFuDai
    //   24	195	4	localObject5	Object
    //   223	7	4	localObject6	Object
    //   235	1	4	localException2	java.lang.Exception
    //   251	17	4	localException3	java.lang.Exception
    //   1	255	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   183	188	191	java/io/IOException
    //   26	183	206	finally
    //   26	183	213	java/lang/Exception
    //   16	26	223	finally
    //   262	272	223	finally
    //   16	26	235	java/lang/Exception
    //   5	14	243	finally
    //   5	14	251	java/lang/Exception
    //   276	280	283	java/io/IOException
    //   201	205	302	java/io/IOException
    //   297	301	302	java/io/IOException
    //   317	321	324	java/io/IOException
    //   338	342	345	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFuDai.Decoder
 * JD-Core Version:    0.7.0.1
 */