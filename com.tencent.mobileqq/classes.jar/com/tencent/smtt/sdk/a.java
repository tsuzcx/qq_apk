package com.tencent.smtt.sdk;

public class a
{
  public static int a = 600;
  private static int b;
  
  /* Error */
  public static int a()
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/smtt/sdk/a:b	I
    //   3: istore_0
    //   4: iload_0
    //   5: ifle +5 -> 10
    //   8: iload_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 4
    //   19: iconst_0
    //   20: istore_1
    //   21: iconst_0
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: new 20	java/io/BufferedReader
    //   28: dup
    //   29: new 22	java/io/FileReader
    //   32: dup
    //   33: ldc 24
    //   35: invokespecial 28	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   38: sipush 8192
    //   41: invokespecial 31	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 35	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 4
    //   53: iload_3
    //   54: istore_0
    //   55: aload 4
    //   57: ifnull +83 -> 140
    //   60: aload 4
    //   62: ldc 37
    //   64: invokevirtual 43	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   67: istore_0
    //   68: iconst_m1
    //   69: iload_0
    //   70: if_icmpeq -24 -> 46
    //   73: aload 4
    //   75: iload_0
    //   76: bipush 9
    //   78: iadd
    //   79: invokevirtual 47	java/lang/String:substring	(I)Ljava/lang/String;
    //   82: invokevirtual 50	java/lang/String:trim	()Ljava/lang/String;
    //   85: astore 4
    //   87: iload_3
    //   88: istore_0
    //   89: aload 4
    //   91: ifnull +49 -> 140
    //   94: iload_3
    //   95: istore_0
    //   96: aload 4
    //   98: invokevirtual 53	java/lang/String:length	()I
    //   101: ifeq +39 -> 140
    //   104: iload_3
    //   105: istore_0
    //   106: aload 4
    //   108: ldc 55
    //   110: invokevirtual 59	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +27 -> 140
    //   116: aload 4
    //   118: iconst_0
    //   119: aload 4
    //   121: ldc 55
    //   123: invokevirtual 43	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   126: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
    //   129: invokevirtual 50	java/lang/String:trim	()Ljava/lang/String;
    //   132: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   135: sipush 1024
    //   138: idiv
    //   139: istore_0
    //   140: iload_0
    //   141: istore_1
    //   142: aload 5
    //   144: invokevirtual 70	java/io/BufferedReader:close	()V
    //   147: goto +108 -> 255
    //   150: astore 4
    //   152: aload 4
    //   154: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   157: iload_1
    //   158: istore_0
    //   159: goto +96 -> 255
    //   162: astore 4
    //   164: goto +99 -> 263
    //   167: astore 6
    //   169: goto +31 -> 200
    //   172: astore 6
    //   174: goto +58 -> 232
    //   177: astore 6
    //   179: aload 4
    //   181: astore 5
    //   183: aload 6
    //   185: astore 4
    //   187: goto +76 -> 263
    //   190: astore 4
    //   192: aload 6
    //   194: astore 5
    //   196: aload 4
    //   198: astore 6
    //   200: aload 5
    //   202: astore 4
    //   204: aload 6
    //   206: invokevirtual 74	java/lang/Throwable:printStackTrace	()V
    //   209: iload_2
    //   210: istore_0
    //   211: aload 5
    //   213: ifnull +42 -> 255
    //   216: aload 5
    //   218: invokevirtual 70	java/io/BufferedReader:close	()V
    //   221: iload_2
    //   222: istore_0
    //   223: goto +32 -> 255
    //   226: astore 6
    //   228: aload 7
    //   230: astore 5
    //   232: aload 5
    //   234: astore 4
    //   236: aload 6
    //   238: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   241: iload_2
    //   242: istore_0
    //   243: aload 5
    //   245: ifnull +10 -> 255
    //   248: aload 5
    //   250: invokevirtual 70	java/io/BufferedReader:close	()V
    //   253: iload_2
    //   254: istore_0
    //   255: iload_0
    //   256: putstatic 18	com/tencent/smtt/sdk/a:b	I
    //   259: getstatic 18	com/tencent/smtt/sdk/a:b	I
    //   262: ireturn
    //   263: aload 5
    //   265: ifnull +18 -> 283
    //   268: aload 5
    //   270: invokevirtual 70	java/io/BufferedReader:close	()V
    //   273: goto +10 -> 283
    //   276: astore 5
    //   278: aload 5
    //   280: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   283: goto +6 -> 289
    //   286: aload 4
    //   288: athrow
    //   289: goto -3 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	253	0	i	int
    //   20	138	1	j	int
    //   22	232	2	k	int
    //   24	81	3	m	int
    //   17	103	4	str	java.lang.String
    //   150	3	4	localIOException1	java.io.IOException
    //   162	18	4	localObject1	Object
    //   185	1	4	localObject2	Object
    //   190	7	4	localThrowable1	java.lang.Throwable
    //   202	85	4	localObject3	Object
    //   44	225	5	localObject4	Object
    //   276	3	5	localIOException2	java.io.IOException
    //   11	1	6	localObject5	Object
    //   167	1	6	localThrowable2	java.lang.Throwable
    //   172	1	6	localIOException3	java.io.IOException
    //   177	16	6	localObject6	Object
    //   198	7	6	localObject7	Object
    //   226	11	6	localIOException4	java.io.IOException
    //   14	215	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   142	147	150	java/io/IOException
    //   216	221	150	java/io/IOException
    //   248	253	150	java/io/IOException
    //   46	53	162	finally
    //   60	68	162	finally
    //   73	87	162	finally
    //   96	104	162	finally
    //   106	140	162	finally
    //   46	53	167	java/lang/Throwable
    //   60	68	167	java/lang/Throwable
    //   73	87	167	java/lang/Throwable
    //   96	104	167	java/lang/Throwable
    //   106	140	167	java/lang/Throwable
    //   46	53	172	java/io/IOException
    //   60	68	172	java/io/IOException
    //   73	87	172	java/io/IOException
    //   96	104	172	java/io/IOException
    //   106	140	172	java/io/IOException
    //   25	46	177	finally
    //   204	209	177	finally
    //   236	241	177	finally
    //   25	46	190	java/lang/Throwable
    //   25	46	226	java/io/IOException
    //   268	273	276	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.a
 * JD-Core Version:    0.7.0.1
 */