package cooperation.qqreader.shadow;

public class ReaderPmFileVerifyHelper
{
  /* Error */
  public static boolean a(@org.jetbrains.annotations.NotNull android.content.Context paramContext, @org.jetbrains.annotations.NotNull java.io.File paramFile)
  {
    // Byte code:
    //   0: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: invokevirtual 28	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 5
    //   15: aload_1
    //   16: invokevirtual 34	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19: sipush 128
    //   22: invokevirtual 40	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   25: astore 5
    //   27: aload 5
    //   29: astore 4
    //   31: aload 5
    //   33: astore 6
    //   35: ldc 42
    //   37: new 44	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   44: ldc 47
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   52: lload_2
    //   53: lsub
    //   54: invokevirtual 54	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 63	cooperation/qqreader/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 5
    //   65: astore 6
    //   67: aload 5
    //   69: ifnonnull +88 -> 157
    //   72: ldc 65
    //   74: astore 4
    //   76: aload_1
    //   77: invokestatic 70	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   80: astore 6
    //   82: aload 6
    //   84: astore 4
    //   86: new 44	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   93: ldc 72
    //   95: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 34	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 74
    //   107: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 4
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_1
    //   119: ldc 42
    //   121: new 44	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   128: ldc 76
    //   130: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 79	cooperation/qqreader/utils/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: sipush -1002
    //   147: ldc 81
    //   149: aload_1
    //   150: invokestatic 86	cooperation/qqreader/utils/ReportUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   153: aload 5
    //   155: astore 6
    //   157: aload 6
    //   159: ifnull +229 -> 388
    //   162: iconst_1
    //   163: ireturn
    //   164: astore 5
    //   166: aload 4
    //   168: astore 6
    //   170: ldc 42
    //   172: ldc 88
    //   174: aload 5
    //   176: invokestatic 91	cooperation/qqreader/utils/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload 4
    //   181: astore 6
    //   183: aload_0
    //   184: sipush -1001
    //   187: ldc 93
    //   189: aload 5
    //   191: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   194: invokestatic 86	cooperation/qqreader/utils/ReportUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   197: aload 4
    //   199: astore 6
    //   201: aload 4
    //   203: ifnonnull -46 -> 157
    //   206: ldc 65
    //   208: astore 5
    //   210: aload_1
    //   211: invokestatic 70	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   214: astore 6
    //   216: aload 6
    //   218: astore 5
    //   220: new 44	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   227: ldc 72
    //   229: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 34	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 74
    //   241: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore_1
    //   253: ldc 42
    //   255: new 44	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   262: ldc 76
    //   264: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 79	cooperation/qqreader/utils/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_0
    //   278: sipush -1002
    //   281: ldc 81
    //   283: aload_1
    //   284: invokestatic 86	cooperation/qqreader/utils/ReportUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   287: aload 4
    //   289: astore 6
    //   291: goto -134 -> 157
    //   294: astore 4
    //   296: aconst_null
    //   297: astore 5
    //   299: aload 5
    //   301: ifnonnull +84 -> 385
    //   304: ldc 65
    //   306: astore 5
    //   308: aload_1
    //   309: invokestatic 70	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   312: astore 6
    //   314: aload 6
    //   316: astore 5
    //   318: new 44	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   325: ldc 72
    //   327: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_1
    //   331: invokevirtual 34	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   334: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc 74
    //   339: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore_1
    //   351: ldc 42
    //   353: new 44	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   360: ldc 76
    //   362: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 79	cooperation/qqreader/utils/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: sipush -1002
    //   379: ldc 81
    //   381: aload_1
    //   382: invokestatic 86	cooperation/qqreader/utils/ReportUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   385: aload 4
    //   387: athrow
    //   388: iconst_0
    //   389: ireturn
    //   390: astore 6
    //   392: goto -306 -> 86
    //   395: astore 6
    //   397: goto -177 -> 220
    //   400: astore 6
    //   402: goto -84 -> 318
    //   405: astore 4
    //   407: aload 6
    //   409: astore 5
    //   411: goto -112 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	paramContext	android.content.Context
    //   0	414	1	paramFile	java.io.File
    //   3	50	2	l	long
    //   11	277	4	localObject1	Object
    //   294	92	4	localObject2	Object
    //   405	1	4	localObject3	Object
    //   8	146	5	localObject4	Object
    //   164	26	5	localException	java.lang.Exception
    //   208	202	5	localObject5	Object
    //   33	282	6	localObject6	Object
    //   390	1	6	localIOException1	java.io.IOException
    //   395	1	6	localIOException2	java.io.IOException
    //   400	8	6	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   13	27	164	java/lang/Exception
    //   35	63	164	java/lang/Exception
    //   13	27	294	finally
    //   76	82	390	java/io/IOException
    //   210	216	395	java/io/IOException
    //   308	314	400	java/io/IOException
    //   35	63	405	finally
    //   170	179	405	finally
    //   183	197	405	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderPmFileVerifyHelper
 * JD-Core Version:    0.7.0.1
 */