package com.tencent.tkd.topicsdk.common;

public class SHA1Util
{
  /* Error */
  @androidx.annotation.Nullable
  public static java.lang.String a(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 22	java/io/BufferedInputStream
    //   3: dup
    //   4: new 24	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 30	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_2
    //   26: astore_0
    //   27: ldc 32
    //   29: invokestatic 38	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_3
    //   33: goto +12 -> 45
    //   36: astore_3
    //   37: aload_2
    //   38: astore_0
    //   39: aload_3
    //   40: invokevirtual 41	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: astore_0
    //   47: aload_2
    //   48: aload 4
    //   50: invokevirtual 47	java/io/InputStream:read	([B)I
    //   53: istore_1
    //   54: iload_1
    //   55: ifle +20 -> 75
    //   58: aload_3
    //   59: ifnull -14 -> 45
    //   62: aload_2
    //   63: astore_0
    //   64: aload_3
    //   65: aload 4
    //   67: iconst_0
    //   68: iload_1
    //   69: invokevirtual 51	java/security/MessageDigest:update	([BII)V
    //   72: goto -27 -> 45
    //   75: aload_2
    //   76: astore_0
    //   77: aload_2
    //   78: invokevirtual 54	java/io/InputStream:close	()V
    //   81: goto +18 -> 99
    //   84: astore 4
    //   86: aload_2
    //   87: astore_0
    //   88: ldc 56
    //   90: aload 4
    //   92: invokevirtual 60	java/io/IOException:toString	()Ljava/lang/String;
    //   95: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: aload_3
    //   100: ifnull +75 -> 175
    //   103: aload_2
    //   104: astore_0
    //   105: aload_3
    //   106: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   109: invokestatic 75	com/tencent/tkd/topicsdk/common/HexUtils:a	([B)Ljava/lang/String;
    //   112: astore_3
    //   113: aload_2
    //   114: astore_0
    //   115: new 77	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   122: astore 4
    //   124: aload_2
    //   125: astore_0
    //   126: aload 4
    //   128: ldc 80
    //   130: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_2
    //   135: astore_0
    //   136: aload 4
    //   138: aload_3
    //   139: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: astore_0
    //   145: ldc 56
    //   147: aload 4
    //   149: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: aload_2
    //   157: invokevirtual 54	java/io/InputStream:close	()V
    //   160: aload_3
    //   161: areturn
    //   162: astore_0
    //   163: ldc 56
    //   165: aload_0
    //   166: invokevirtual 60	java/io/IOException:toString	()Ljava/lang/String;
    //   169: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   172: pop
    //   173: aload_3
    //   174: areturn
    //   175: aload_2
    //   176: invokevirtual 54	java/io/InputStream:close	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_0
    //   182: ldc 56
    //   184: aload_0
    //   185: invokevirtual 60	java/io/IOException:toString	()Ljava/lang/String;
    //   188: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   191: pop
    //   192: aconst_null
    //   193: areturn
    //   194: astore_3
    //   195: goto +16 -> 211
    //   198: astore_3
    //   199: goto +37 -> 236
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_0
    //   205: goto +67 -> 272
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: astore_0
    //   213: ldc 56
    //   215: aload_3
    //   216: invokevirtual 86	java/lang/Throwable:toString	()Ljava/lang/String;
    //   219: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: aload_2
    //   224: ifnull +45 -> 269
    //   227: aload_2
    //   228: invokevirtual 54	java/io/InputStream:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: astore_0
    //   238: ldc 56
    //   240: aload_3
    //   241: invokevirtual 87	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   244: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: aload_2
    //   249: ifnull +20 -> 269
    //   252: aload_2
    //   253: invokevirtual 54	java/io/InputStream:close	()V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: ldc 56
    //   261: aload_0
    //   262: invokevirtual 60	java/io/IOException:toString	()Ljava/lang/String;
    //   265: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   268: pop
    //   269: aconst_null
    //   270: areturn
    //   271: astore_2
    //   272: aload_0
    //   273: ifnull +21 -> 294
    //   276: aload_0
    //   277: invokevirtual 54	java/io/InputStream:close	()V
    //   280: goto +14 -> 294
    //   283: astore_0
    //   284: ldc 56
    //   286: aload_0
    //   287: invokevirtual 60	java/io/IOException:toString	()Ljava/lang/String;
    //   290: invokestatic 66	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   293: pop
    //   294: goto +5 -> 299
    //   297: aload_2
    //   298: athrow
    //   299: goto -2 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString	java.lang.String
    //   53	16	1	i	int
    //   15	161	2	localBufferedInputStream	java.io.BufferedInputStream
    //   202	1	2	localObject1	Object
    //   210	43	2	localObject2	Object
    //   271	27	2	localObject3	Object
    //   32	1	3	localMessageDigest	java.security.MessageDigest
    //   36	4	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   44	130	3	str	java.lang.String
    //   194	1	3	localThrowable1	java.lang.Throwable
    //   198	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   208	8	3	localThrowable2	java.lang.Throwable
    //   233	8	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   23	43	4	arrayOfByte	byte[]
    //   84	7	4	localIOException	java.io.IOException
    //   122	26	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	33	36	java/security/NoSuchAlgorithmException
    //   77	81	84	java/io/IOException
    //   156	160	162	java/io/IOException
    //   175	179	181	java/io/IOException
    //   18	25	194	java/lang/Throwable
    //   27	33	194	java/lang/Throwable
    //   39	43	194	java/lang/Throwable
    //   47	54	194	java/lang/Throwable
    //   64	72	194	java/lang/Throwable
    //   77	81	194	java/lang/Throwable
    //   88	99	194	java/lang/Throwable
    //   105	113	194	java/lang/Throwable
    //   115	124	194	java/lang/Throwable
    //   126	134	194	java/lang/Throwable
    //   136	143	194	java/lang/Throwable
    //   145	156	194	java/lang/Throwable
    //   18	25	198	java/io/FileNotFoundException
    //   27	33	198	java/io/FileNotFoundException
    //   39	43	198	java/io/FileNotFoundException
    //   47	54	198	java/io/FileNotFoundException
    //   64	72	198	java/io/FileNotFoundException
    //   77	81	198	java/io/FileNotFoundException
    //   88	99	198	java/io/FileNotFoundException
    //   105	113	198	java/io/FileNotFoundException
    //   115	124	198	java/io/FileNotFoundException
    //   126	134	198	java/io/FileNotFoundException
    //   136	143	198	java/io/FileNotFoundException
    //   145	156	198	java/io/FileNotFoundException
    //   0	16	202	finally
    //   0	16	208	java/lang/Throwable
    //   0	16	233	java/io/FileNotFoundException
    //   227	231	258	java/io/IOException
    //   252	256	258	java/io/IOException
    //   18	25	271	finally
    //   27	33	271	finally
    //   39	43	271	finally
    //   47	54	271	finally
    //   64	72	271	finally
    //   77	81	271	finally
    //   88	99	271	finally
    //   105	113	271	finally
    //   115	124	271	finally
    //   126	134	271	finally
    //   136	143	271	finally
    //   145	156	271	finally
    //   213	223	271	finally
    //   238	248	271	finally
    //   276	280	283	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.SHA1Util
 * JD-Core Version:    0.7.0.1
 */