package com.tencent.qqprotect.qsec;

public class QSecStoreUtil
{
  private byte a = 0;
  
  /* Error */
  public boolean a(java.lang.String paramString1, byte[] paramArrayOfByte, java.lang.String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_3
    //   7: astore 5
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: ldc 18
    //   15: astore 5
    //   17: aload 7
    //   19: astore_3
    //   20: new 20	com/tencent/qphone/base/util/Cryptor
    //   23: dup
    //   24: invokespecial 21	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   27: aload_2
    //   28: aload 5
    //   30: invokevirtual 27	java/lang/String:getBytes	()[B
    //   33: invokevirtual 31	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +14 -> 52
    //   41: aload 7
    //   43: astore_3
    //   44: aload_0
    //   45: bipush 8
    //   47: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   50: iconst_0
    //   51: ireturn
    //   52: aload 7
    //   54: astore_3
    //   55: new 33	java/io/DataOutputStream
    //   58: dup
    //   59: new 35	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 38	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: invokespecial 41	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 42
    //   74: invokevirtual 46	java/io/DataOutputStream:writeInt	(I)V
    //   77: aload_1
    //   78: iload 4
    //   80: invokevirtual 46	java/io/DataOutputStream:writeInt	(I)V
    //   83: aload_1
    //   84: iconst_1
    //   85: invokevirtual 46	java/io/DataOutputStream:writeInt	(I)V
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 50	java/io/DataOutputStream:write	([B)V
    //   93: aload_1
    //   94: invokevirtual 53	java/io/DataOutputStream:close	()V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_2
    //   107: aload_1
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: goto +46 -> 157
    //   114: astore_2
    //   115: goto +11 -> 126
    //   118: astore_1
    //   119: goto +38 -> 157
    //   122: astore_2
    //   123: aload 6
    //   125: astore_1
    //   126: aload_1
    //   127: astore_3
    //   128: aload_0
    //   129: bipush 6
    //   131: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   134: aload_1
    //   135: astore_3
    //   136: aload_2
    //   137: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   140: aload_1
    //   141: ifnull +14 -> 155
    //   144: aload_1
    //   145: invokevirtual 53	java/io/DataOutputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: aload_3
    //   158: ifnull +15 -> 173
    //   161: aload_3
    //   162: invokevirtual 53	java/io/DataOutputStream:close	()V
    //   165: goto +8 -> 173
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	QSecStoreUtil
    //   0	175	1	paramString1	java.lang.String
    //   0	175	2	paramArrayOfByte	byte[]
    //   0	175	3	paramString2	java.lang.String
    //   0	175	4	paramInt	int
    //   7	22	5	str	java.lang.String
    //   1	123	6	localObject1	Object
    //   4	49	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   93	97	99	java/io/IOException
    //   71	93	106	finally
    //   71	93	114	java/io/IOException
    //   20	37	118	finally
    //   44	50	118	finally
    //   55	71	118	finally
    //   128	134	118	finally
    //   136	140	118	finally
    //   20	37	122	java/io/IOException
    //   44	50	122	java/io/IOException
    //   55	71	122	java/io/IOException
    //   144	148	150	java/io/IOException
    //   161	165	168	java/io/IOException
  }
  
  /* Error */
  public byte[] a(java.lang.String paramString1, java.lang.String paramString2, int paramInt)
  {
    // Byte code:
    //   0: new 59	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 64	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   21: aconst_null
    //   22: areturn
    //   23: new 66	java/io/DataInputStream
    //   26: dup
    //   27: new 68	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 74	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: aload 6
    //   45: invokevirtual 78	java/io/DataInputStream:available	()I
    //   48: istore 4
    //   50: iload 4
    //   52: bipush 12
    //   54: if_icmple +256 -> 310
    //   57: iload 4
    //   59: ldc 79
    //   61: if_icmple +6 -> 67
    //   64: goto +246 -> 310
    //   67: aload 6
    //   69: astore_1
    //   70: aload 6
    //   72: invokevirtual 82	java/io/DataInputStream:readInt	()I
    //   75: ldc 42
    //   77: if_icmpeq +25 -> 102
    //   80: aload 6
    //   82: astore_1
    //   83: aload_0
    //   84: iconst_3
    //   85: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   88: aload 6
    //   90: invokevirtual 83	java/io/DataInputStream:close	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   100: aconst_null
    //   101: areturn
    //   102: aload 6
    //   104: astore_1
    //   105: aload 6
    //   107: invokevirtual 82	java/io/DataInputStream:readInt	()I
    //   110: istore 5
    //   112: iload 5
    //   114: ifle +174 -> 288
    //   117: iload 5
    //   119: iload_3
    //   120: if_icmple +6 -> 126
    //   123: goto +165 -> 288
    //   126: aload 6
    //   128: astore_1
    //   129: aload 6
    //   131: invokevirtual 82	java/io/DataInputStream:readInt	()I
    //   134: iconst_1
    //   135: if_icmpeq +25 -> 160
    //   138: aload 6
    //   140: astore_1
    //   141: aload_0
    //   142: iconst_5
    //   143: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   146: aload 6
    //   148: invokevirtual 83	java/io/DataInputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: aload 6
    //   162: astore_1
    //   163: iload 4
    //   165: bipush 12
    //   167: isub
    //   168: newarray byte
    //   170: astore 8
    //   172: aload 6
    //   174: astore_1
    //   175: aload 8
    //   177: arraylength
    //   178: aload 6
    //   180: aload 8
    //   182: invokevirtual 87	java/io/DataInputStream:read	([B)I
    //   185: if_icmpeq +26 -> 211
    //   188: aload 6
    //   190: astore_1
    //   191: aload_0
    //   192: bipush 6
    //   194: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   197: aload 6
    //   199: invokevirtual 83	java/io/DataInputStream:close	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   209: aconst_null
    //   210: areturn
    //   211: aload_2
    //   212: astore 7
    //   214: aload_2
    //   215: ifnonnull +7 -> 222
    //   218: ldc 18
    //   220: astore 7
    //   222: aload 6
    //   224: astore_1
    //   225: new 20	com/tencent/qphone/base/util/Cryptor
    //   228: dup
    //   229: invokespecial 21	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   232: aload 8
    //   234: iconst_0
    //   235: aload 8
    //   237: arraylength
    //   238: aload 7
    //   240: invokevirtual 27	java/lang/String:getBytes	()[B
    //   243: invokevirtual 91	com/tencent/qphone/base/util/Cryptor:decrypt	([BII[B)[B
    //   246: astore_2
    //   247: aload_2
    //   248: ifnonnull +26 -> 274
    //   251: aload 6
    //   253: astore_1
    //   254: aload_0
    //   255: bipush 7
    //   257: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   260: aload 6
    //   262: invokevirtual 83	java/io/DataInputStream:close	()V
    //   265: aconst_null
    //   266: areturn
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 6
    //   276: invokevirtual 83	java/io/DataInputStream:close	()V
    //   279: aload_2
    //   280: areturn
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   286: aload_2
    //   287: areturn
    //   288: aload 6
    //   290: astore_1
    //   291: aload_0
    //   292: iconst_4
    //   293: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   296: aload 6
    //   298: invokevirtual 83	java/io/DataInputStream:close	()V
    //   301: aconst_null
    //   302: areturn
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   308: aconst_null
    //   309: areturn
    //   310: aload 6
    //   312: astore_1
    //   313: aload_0
    //   314: iconst_2
    //   315: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   318: aload 6
    //   320: invokevirtual 83	java/io/DataInputStream:close	()V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_1
    //   333: aload 6
    //   335: astore_2
    //   336: aload_1
    //   337: astore 6
    //   339: goto +13 -> 352
    //   342: astore_2
    //   343: aconst_null
    //   344: astore_1
    //   345: goto +40 -> 385
    //   348: astore 6
    //   350: aconst_null
    //   351: astore_2
    //   352: aload_2
    //   353: astore_1
    //   354: aload_0
    //   355: bipush 6
    //   357: putfield 12	com/tencent/qqprotect/qsec/QSecStoreUtil:a	B
    //   360: aload_2
    //   361: astore_1
    //   362: aload 6
    //   364: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   367: aload_2
    //   368: ifnull +14 -> 382
    //   371: aload_2
    //   372: invokevirtual 83	java/io/DataInputStream:close	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore_1
    //   378: aload_1
    //   379: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   382: aconst_null
    //   383: areturn
    //   384: astore_2
    //   385: aload_1
    //   386: ifnull +15 -> 401
    //   389: aload_1
    //   390: invokevirtual 83	java/io/DataInputStream:close	()V
    //   393: goto +8 -> 401
    //   396: astore_1
    //   397: aload_1
    //   398: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   401: aload_2
    //   402: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	QSecStoreUtil
    //   0	403	1	paramString1	java.lang.String
    //   0	403	2	paramString2	java.lang.String
    //   0	403	3	paramInt	int
    //   48	120	4	i	int
    //   110	11	5	j	int
    //   38	300	6	localObject	Object
    //   348	15	6	localIOException	java.io.IOException
    //   212	27	7	str	java.lang.String
    //   170	66	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   146	151	153	java/io/IOException
    //   197	202	204	java/io/IOException
    //   260	265	267	java/io/IOException
    //   274	279	281	java/io/IOException
    //   296	301	303	java/io/IOException
    //   318	323	325	java/io/IOException
    //   43	50	332	java/io/IOException
    //   70	80	332	java/io/IOException
    //   83	88	332	java/io/IOException
    //   105	112	332	java/io/IOException
    //   129	138	332	java/io/IOException
    //   141	146	332	java/io/IOException
    //   163	172	332	java/io/IOException
    //   175	188	332	java/io/IOException
    //   191	197	332	java/io/IOException
    //   225	247	332	java/io/IOException
    //   254	260	332	java/io/IOException
    //   291	296	332	java/io/IOException
    //   313	318	332	java/io/IOException
    //   23	40	342	finally
    //   23	40	348	java/io/IOException
    //   371	375	377	java/io/IOException
    //   43	50	384	finally
    //   70	80	384	finally
    //   83	88	384	finally
    //   105	112	384	finally
    //   129	138	384	finally
    //   141	146	384	finally
    //   163	172	384	finally
    //   175	188	384	finally
    //   191	197	384	finally
    //   225	247	384	finally
    //   254	260	384	finally
    //   291	296	384	finally
    //   313	318	384	finally
    //   354	360	384	finally
    //   362	367	384	finally
    //   389	393	396	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecStoreUtil
 * JD-Core Version:    0.7.0.1
 */