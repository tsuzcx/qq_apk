package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.f.k;

public class m
{
  private static final byte[] a = { 96, 110, -109, 82, 109, 2, 36, -77, 108, 59, -80, 10, 112, 122, 56, -67 };
  
  public String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  /* Error */
  public boolean a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: astore 5
    //   6: aload_3
    //   7: ifnonnull +12 -> 19
    //   10: aload_0
    //   11: getstatic 26	com/tencent/qmsp/sdk/c/m:a	[B
    //   14: invokevirtual 39	com/tencent/qmsp/sdk/c/m:a	([B)Ljava/lang/String;
    //   17: astore 5
    //   19: new 41	com/tencent/qmsp/sdk/f/b
    //   22: dup
    //   23: invokespecial 42	com/tencent/qmsp/sdk/f/b:<init>	()V
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 48	java/lang/String:getBytes	()[B
    //   32: invokevirtual 51	com/tencent/qmsp/sdk/f/b:a	([B[B)[B
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: new 53	java/io/DataOutputStream
    //   45: dup
    //   46: new 55	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 61	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_2
    //   61: ldc 62
    //   63: invokevirtual 66	java/io/DataOutputStream:writeInt	(I)V
    //   66: aload_2
    //   67: astore_1
    //   68: aload_2
    //   69: iload 4
    //   71: invokevirtual 66	java/io/DataOutputStream:writeInt	(I)V
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: iconst_1
    //   78: invokevirtual 66	java/io/DataOutputStream:writeInt	(I)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: aload_3
    //   85: invokevirtual 70	java/io/DataOutputStream:write	([B)V
    //   88: aload_2
    //   89: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_3
    //   102: goto +13 -> 115
    //   105: astore_1
    //   106: aload 6
    //   108: astore_2
    //   109: goto +34 -> 143
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   121: aload_2
    //   122: ifnull +14 -> 136
    //   125: aload_2
    //   126: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_3
    //   139: aload_1
    //   140: astore_2
    //   141: aload_3
    //   142: astore_1
    //   143: aload_2
    //   144: ifnull +15 -> 159
    //   147: aload_2
    //   148: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   151: goto +8 -> 159
    //   154: astore_2
    //   155: aload_2
    //   156: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	m
    //   0	161	1	paramString1	String
    //   0	161	2	paramArrayOfByte	byte[]
    //   0	161	3	paramString2	String
    //   0	161	4	paramInt	int
    //   4	24	5	str	String
    //   1	106	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   60	66	101	java/io/IOException
    //   68	74	101	java/io/IOException
    //   76	81	101	java/io/IOException
    //   83	88	101	java/io/IOException
    //   10	19	105	finally
    //   19	36	105	finally
    //   42	58	105	finally
    //   10	19	112	java/io/IOException
    //   19	36	112	java/io/IOException
    //   42	58	112	java/io/IOException
    //   125	129	131	java/io/IOException
    //   60	66	138	finally
    //   68	74	138	finally
    //   76	81	138	finally
    //   83	88	138	finally
    //   117	121	138	finally
    //   147	151	154	java/io/IOException
  }
  
  /* Error */
  public byte[] a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: new 79	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 84	java/io/File:exists	()Z
    //   15: istore 6
    //   17: aconst_null
    //   18: astore_1
    //   19: iload 6
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 86	java/io/DataInputStream
    //   29: dup
    //   30: new 88	java/io/FileInputStream
    //   33: dup
    //   34: aload 7
    //   36: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 94	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore 7
    //   44: aload 7
    //   46: astore_1
    //   47: aload 7
    //   49: invokevirtual 98	java/io/DataInputStream:available	()I
    //   52: istore 4
    //   54: iload 4
    //   56: bipush 12
    //   58: if_icmple +237 -> 295
    //   61: iload 4
    //   63: ldc 99
    //   65: if_icmple +6 -> 71
    //   68: goto +227 -> 295
    //   71: aload 7
    //   73: astore_1
    //   74: aload 7
    //   76: invokevirtual 102	java/io/DataInputStream:readInt	()I
    //   79: istore 5
    //   81: iload 5
    //   83: ldc 62
    //   85: if_icmpeq +17 -> 102
    //   88: aload 7
    //   90: invokevirtual 103	java/io/DataInputStream:close	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   100: aconst_null
    //   101: areturn
    //   102: aload 7
    //   104: astore_1
    //   105: aload 7
    //   107: invokevirtual 102	java/io/DataInputStream:readInt	()I
    //   110: istore 5
    //   112: iload 5
    //   114: ifle +167 -> 281
    //   117: iload 5
    //   119: iload_3
    //   120: if_icmple +6 -> 126
    //   123: goto +158 -> 281
    //   126: aload 7
    //   128: astore_1
    //   129: aload 7
    //   131: invokevirtual 102	java/io/DataInputStream:readInt	()I
    //   134: istore_3
    //   135: iload_3
    //   136: iconst_1
    //   137: if_icmpeq +17 -> 154
    //   140: aload 7
    //   142: invokevirtual 103	java/io/DataInputStream:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   152: aconst_null
    //   153: areturn
    //   154: aload 7
    //   156: astore_1
    //   157: iload 4
    //   159: bipush 12
    //   161: isub
    //   162: newarray byte
    //   164: astore 9
    //   166: aload 7
    //   168: astore_1
    //   169: aload 9
    //   171: arraylength
    //   172: istore_3
    //   173: aload 7
    //   175: astore_1
    //   176: aload 7
    //   178: aload 9
    //   180: invokevirtual 107	java/io/DataInputStream:read	([B)I
    //   183: istore 4
    //   185: iload_3
    //   186: iload 4
    //   188: if_icmpeq +17 -> 205
    //   191: aload 7
    //   193: invokevirtual 103	java/io/DataInputStream:close	()V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   203: aconst_null
    //   204: areturn
    //   205: aload_2
    //   206: astore 8
    //   208: aload_2
    //   209: ifnonnull +15 -> 224
    //   212: aload 7
    //   214: astore_1
    //   215: aload_0
    //   216: getstatic 26	com/tencent/qmsp/sdk/c/m:a	[B
    //   219: invokevirtual 39	com/tencent/qmsp/sdk/c/m:a	([B)Ljava/lang/String;
    //   222: astore 8
    //   224: aload 7
    //   226: astore_1
    //   227: new 41	com/tencent/qmsp/sdk/f/b
    //   230: dup
    //   231: invokespecial 42	com/tencent/qmsp/sdk/f/b:<init>	()V
    //   234: aload 9
    //   236: iconst_0
    //   237: aload 9
    //   239: arraylength
    //   240: aload 8
    //   242: invokevirtual 48	java/lang/String:getBytes	()[B
    //   245: invokevirtual 110	com/tencent/qmsp/sdk/f/b:a	([BII[B)[B
    //   248: astore_2
    //   249: aload_2
    //   250: ifnonnull +17 -> 267
    //   253: aload 7
    //   255: invokevirtual 103	java/io/DataInputStream:close	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   265: aconst_null
    //   266: areturn
    //   267: aload 7
    //   269: invokevirtual 103	java/io/DataInputStream:close	()V
    //   272: aload_2
    //   273: areturn
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   279: aload_2
    //   280: areturn
    //   281: aload 7
    //   283: invokevirtual 103	java/io/DataInputStream:close	()V
    //   286: aconst_null
    //   287: areturn
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   293: aconst_null
    //   294: areturn
    //   295: aload 7
    //   297: invokevirtual 103	java/io/DataInputStream:close	()V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   307: aconst_null
    //   308: areturn
    //   309: astore_1
    //   310: aload 7
    //   312: astore_2
    //   313: aload_1
    //   314: astore 7
    //   316: goto +11 -> 327
    //   319: astore_2
    //   320: goto +32 -> 352
    //   323: astore 7
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: astore_1
    //   329: aload 7
    //   331: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   334: aload_2
    //   335: ifnull +14 -> 349
    //   338: aload_2
    //   339: invokevirtual 103	java/io/DataInputStream:close	()V
    //   342: aconst_null
    //   343: areturn
    //   344: astore_1
    //   345: aload_1
    //   346: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   349: aconst_null
    //   350: areturn
    //   351: astore_2
    //   352: aload_1
    //   353: ifnull +15 -> 368
    //   356: aload_1
    //   357: invokevirtual 103	java/io/DataInputStream:close	()V
    //   360: goto +8 -> 368
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   368: aload_2
    //   369: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	m
    //   0	370	1	paramString1	String
    //   0	370	2	paramString2	String
    //   0	370	3	paramInt	int
    //   52	137	4	i	int
    //   79	42	5	j	int
    //   15	5	6	bool	boolean
    //   8	307	7	localObject	Object
    //   323	7	7	localIOException	java.io.IOException
    //   206	35	8	str	String
    //   164	74	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   140	145	147	java/io/IOException
    //   191	196	198	java/io/IOException
    //   253	258	260	java/io/IOException
    //   267	272	274	java/io/IOException
    //   281	286	288	java/io/IOException
    //   295	300	302	java/io/IOException
    //   47	54	309	java/io/IOException
    //   74	81	309	java/io/IOException
    //   105	112	309	java/io/IOException
    //   129	135	309	java/io/IOException
    //   157	166	309	java/io/IOException
    //   169	173	309	java/io/IOException
    //   176	185	309	java/io/IOException
    //   215	224	309	java/io/IOException
    //   227	249	309	java/io/IOException
    //   26	44	319	finally
    //   26	44	323	java/io/IOException
    //   338	342	344	java/io/IOException
    //   47	54	351	finally
    //   74	81	351	finally
    //   105	112	351	finally
    //   129	135	351	finally
    //   157	166	351	finally
    //   169	173	351	finally
    //   176	185	351	finally
    //   215	224	351	finally
    //   227	249	351	finally
    //   329	334	351	finally
    //   356	360	363	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.m
 * JD-Core Version:    0.7.0.1
 */