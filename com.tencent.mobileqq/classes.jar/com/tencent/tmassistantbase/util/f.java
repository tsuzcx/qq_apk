package com.tencent.tmassistantbase.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tmassistant.common.jce.TerminalExtra;
import java.io.File;

public class f
{
  private static volatile f b = null;
  private TerminalExtra a;
  
  public static f a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new f();
      }
      return b;
    }
    finally {}
  }
  
  public static int c()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new g());
      if (arrayOfFile == null) {
        return 1;
      }
      int i = arrayOfFile.length;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 1;
  }
  
  /* Error */
  public static int d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: iconst_0
    //   12: istore_1
    //   13: new 48	java/io/FileReader
    //   16: dup
    //   17: ldc 50
    //   19: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload 5
    //   25: astore 4
    //   27: aload_2
    //   28: astore 5
    //   30: new 53	java/io/BufferedReader
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnonnull +40 -> 87
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 63	java/io/FileReader:close	()V
    //   58: iload_1
    //   59: istore_0
    //   60: aload_3
    //   61: ifnull +9 -> 70
    //   64: aload_3
    //   65: invokevirtual 64	java/io/BufferedReader:close	()V
    //   68: iload_1
    //   69: istore_0
    //   70: iload_0
    //   71: ireturn
    //   72: astore_2
    //   73: aload_2
    //   74: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   77: goto -19 -> 58
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload 4
    //   89: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   92: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_0
    //   96: iload_0
    //   97: istore_1
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 63	java/io/FileReader:close	()V
    //   106: iload_1
    //   107: istore_0
    //   108: aload_3
    //   109: ifnull -39 -> 70
    //   112: aload_3
    //   113: invokevirtual 64	java/io/BufferedReader:close	()V
    //   116: iload_1
    //   117: ireturn
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   123: iload_1
    //   124: ireturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   130: goto -24 -> 106
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_2
    //   137: aload 4
    //   139: invokevirtual 77	java/io/FileNotFoundException:printStackTrace	()V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 63	java/io/FileReader:close	()V
    //   150: iload_1
    //   151: istore_0
    //   152: aload_2
    //   153: ifnull -83 -> 70
    //   156: aload_2
    //   157: invokevirtual 64	java/io/BufferedReader:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   174: goto -24 -> 150
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: aload 6
    //   182: astore 4
    //   184: aload_2
    //   185: astore 5
    //   187: aload_3
    //   188: invokevirtual 78	java/lang/Throwable:printStackTrace	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 63	java/io/FileReader:close	()V
    //   199: iload_1
    //   200: istore_0
    //   201: aload 6
    //   203: ifnull -133 -> 70
    //   206: aload 6
    //   208: invokevirtual 64	java/io/BufferedReader:close	()V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   225: goto -26 -> 199
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 63	java/io/FileReader:close	()V
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 64	java/io/BufferedReader:close	()V
    //   249: aload_3
    //   250: athrow
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   256: goto -17 -> 239
    //   259: astore_2
    //   260: aload_2
    //   261: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   264: goto -15 -> 249
    //   267: astore_3
    //   268: aload 5
    //   270: astore_2
    //   271: goto -40 -> 231
    //   274: astore 5
    //   276: aload_3
    //   277: astore 4
    //   279: aload 5
    //   281: astore_3
    //   282: goto -51 -> 231
    //   285: astore 4
    //   287: aload_3
    //   288: astore 5
    //   290: aload 4
    //   292: astore_3
    //   293: aload_2
    //   294: astore 4
    //   296: aload 5
    //   298: astore_2
    //   299: goto -68 -> 231
    //   302: astore_3
    //   303: goto -123 -> 180
    //   306: astore 4
    //   308: aload_3
    //   309: astore 6
    //   311: aload 4
    //   313: astore_3
    //   314: goto -134 -> 180
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 5
    //   322: aload_2
    //   323: astore_3
    //   324: aload 5
    //   326: astore_2
    //   327: goto -190 -> 137
    //   330: astore 4
    //   332: aload_2
    //   333: astore 5
    //   335: aload_3
    //   336: astore_2
    //   337: aload 5
    //   339: astore_3
    //   340: goto -203 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   59	142	0	i	int
    //   12	188	1	j	int
    //   22	33	2	localFileReader	java.io.FileReader
    //   72	2	2	localIOException1	java.io.IOException
    //   80	23	2	localIOException2	java.io.IOException
    //   118	2	2	localIOException3	java.io.IOException
    //   125	2	2	localIOException4	java.io.IOException
    //   136	21	2	localObject1	Object
    //   162	2	2	localIOException5	java.io.IOException
    //   179	17	2	localObject2	Object
    //   213	2	2	localIOException6	java.io.IOException
    //   220	2	2	localIOException7	java.io.IOException
    //   230	6	2	localObject3	Object
    //   251	2	2	localIOException8	java.io.IOException
    //   259	2	2	localIOException9	java.io.IOException
    //   270	67	2	localObject4	Object
    //   10	137	3	localBufferedReader	java.io.BufferedReader
    //   169	2	3	localIOException10	java.io.IOException
    //   177	11	3	localThrowable1	Throwable
    //   228	22	3	localObject5	Object
    //   267	10	3	localObject6	Object
    //   281	12	3	localObject7	Object
    //   302	7	3	localThrowable2	Throwable
    //   313	27	3	localObject8	Object
    //   4	84	4	localObject9	Object
    //   133	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	96	4	localObject10	Object
    //   285	6	4	localObject11	Object
    //   294	1	4	localObject12	Object
    //   306	6	4	localThrowable3	Throwable
    //   317	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   330	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   7	262	5	localObject13	Object
    //   274	6	5	localObject14	Object
    //   288	50	5	localObject15	Object
    //   1	309	6	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   54	58	72	java/io/IOException
    //   64	68	80	java/io/IOException
    //   112	116	118	java/io/IOException
    //   102	106	125	java/io/IOException
    //   13	23	133	java/io/FileNotFoundException
    //   156	160	162	java/io/IOException
    //   146	150	169	java/io/IOException
    //   13	23	177	java/lang/Throwable
    //   206	211	213	java/io/IOException
    //   195	199	220	java/io/IOException
    //   13	23	228	finally
    //   235	239	251	java/io/IOException
    //   244	249	259	java/io/IOException
    //   30	39	267	finally
    //   187	191	267	finally
    //   39	45	274	finally
    //   87	96	274	finally
    //   137	142	285	finally
    //   30	39	302	java/lang/Throwable
    //   39	45	306	java/lang/Throwable
    //   87	96	306	java/lang/Throwable
    //   30	39	317	java/io/FileNotFoundException
    //   39	45	330	java/io/FileNotFoundException
    //   87	96	330	java/io/FileNotFoundException
  }
  
  /* Error */
  public static int e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: iconst_0
    //   12: istore_1
    //   13: new 48	java/io/FileReader
    //   16: dup
    //   17: ldc 81
    //   19: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload 5
    //   25: astore 4
    //   27: aload_2
    //   28: astore 5
    //   30: new 53	java/io/BufferedReader
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnonnull +40 -> 87
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 63	java/io/FileReader:close	()V
    //   58: iload_1
    //   59: istore_0
    //   60: aload_3
    //   61: ifnull +9 -> 70
    //   64: aload_3
    //   65: invokevirtual 64	java/io/BufferedReader:close	()V
    //   68: iload_1
    //   69: istore_0
    //   70: iload_0
    //   71: ireturn
    //   72: astore_2
    //   73: aload_2
    //   74: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   77: goto -19 -> 58
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload 4
    //   89: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   92: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_0
    //   96: iload_0
    //   97: istore_1
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 63	java/io/FileReader:close	()V
    //   106: iload_1
    //   107: istore_0
    //   108: aload_3
    //   109: ifnull -39 -> 70
    //   112: aload_3
    //   113: invokevirtual 64	java/io/BufferedReader:close	()V
    //   116: iload_1
    //   117: ireturn
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   123: iload_1
    //   124: ireturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   130: goto -24 -> 106
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_2
    //   137: aload 4
    //   139: invokevirtual 77	java/io/FileNotFoundException:printStackTrace	()V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 63	java/io/FileReader:close	()V
    //   150: iload_1
    //   151: istore_0
    //   152: aload_2
    //   153: ifnull -83 -> 70
    //   156: aload_2
    //   157: invokevirtual 64	java/io/BufferedReader:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   174: goto -24 -> 150
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: aload 6
    //   182: astore 4
    //   184: aload_2
    //   185: astore 5
    //   187: aload_3
    //   188: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 63	java/io/FileReader:close	()V
    //   199: iload_1
    //   200: istore_0
    //   201: aload 6
    //   203: ifnull -133 -> 70
    //   206: aload 6
    //   208: invokevirtual 64	java/io/BufferedReader:close	()V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   225: goto -26 -> 199
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 63	java/io/FileReader:close	()V
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 64	java/io/BufferedReader:close	()V
    //   249: aload_3
    //   250: athrow
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   256: goto -17 -> 239
    //   259: astore_2
    //   260: aload_2
    //   261: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   264: goto -15 -> 249
    //   267: astore_3
    //   268: aload 5
    //   270: astore_2
    //   271: goto -40 -> 231
    //   274: astore 5
    //   276: aload_3
    //   277: astore 4
    //   279: aload 5
    //   281: astore_3
    //   282: goto -51 -> 231
    //   285: astore 4
    //   287: aload_3
    //   288: astore 5
    //   290: aload 4
    //   292: astore_3
    //   293: aload_2
    //   294: astore 4
    //   296: aload 5
    //   298: astore_2
    //   299: goto -68 -> 231
    //   302: astore_3
    //   303: goto -123 -> 180
    //   306: astore 4
    //   308: aload_3
    //   309: astore 6
    //   311: aload 4
    //   313: astore_3
    //   314: goto -134 -> 180
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 5
    //   322: aload_2
    //   323: astore_3
    //   324: aload 5
    //   326: astore_2
    //   327: goto -190 -> 137
    //   330: astore 4
    //   332: aload_2
    //   333: astore 5
    //   335: aload_3
    //   336: astore_2
    //   337: aload 5
    //   339: astore_3
    //   340: goto -203 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   59	142	0	i	int
    //   12	188	1	j	int
    //   22	33	2	localFileReader	java.io.FileReader
    //   72	2	2	localIOException1	java.io.IOException
    //   80	23	2	localIOException2	java.io.IOException
    //   118	2	2	localIOException3	java.io.IOException
    //   125	2	2	localIOException4	java.io.IOException
    //   136	21	2	localObject1	Object
    //   162	2	2	localIOException5	java.io.IOException
    //   179	17	2	localObject2	Object
    //   213	2	2	localIOException6	java.io.IOException
    //   220	2	2	localIOException7	java.io.IOException
    //   230	6	2	localObject3	Object
    //   251	2	2	localIOException8	java.io.IOException
    //   259	2	2	localIOException9	java.io.IOException
    //   270	67	2	localObject4	Object
    //   10	137	3	localBufferedReader	java.io.BufferedReader
    //   169	2	3	localIOException10	java.io.IOException
    //   177	11	3	localIOException11	java.io.IOException
    //   228	22	3	localObject5	Object
    //   267	10	3	localObject6	Object
    //   281	12	3	localObject7	Object
    //   302	7	3	localIOException12	java.io.IOException
    //   313	27	3	localObject8	Object
    //   4	84	4	localObject9	Object
    //   133	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	96	4	localObject10	Object
    //   285	6	4	localObject11	Object
    //   294	1	4	localObject12	Object
    //   306	6	4	localIOException13	java.io.IOException
    //   317	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   330	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   7	262	5	localObject13	Object
    //   274	6	5	localObject14	Object
    //   288	50	5	localObject15	Object
    //   1	309	6	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   54	58	72	java/io/IOException
    //   64	68	80	java/io/IOException
    //   112	116	118	java/io/IOException
    //   102	106	125	java/io/IOException
    //   13	23	133	java/io/FileNotFoundException
    //   156	160	162	java/io/IOException
    //   146	150	169	java/io/IOException
    //   13	23	177	java/io/IOException
    //   206	211	213	java/io/IOException
    //   195	199	220	java/io/IOException
    //   13	23	228	finally
    //   235	239	251	java/io/IOException
    //   244	249	259	java/io/IOException
    //   30	39	267	finally
    //   187	191	267	finally
    //   39	45	274	finally
    //   87	96	274	finally
    //   137	142	285	finally
    //   30	39	302	java/io/IOException
    //   39	45	306	java/io/IOException
    //   87	96	306	java/io/IOException
    //   30	39	317	java/io/FileNotFoundException
    //   39	45	330	java/io/FileNotFoundException
    //   87	96	330	java/io/FileNotFoundException
  }
  
  /* Error */
  public static long f()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: new 53	java/io/BufferedReader
    //   8: dup
    //   9: new 48	java/io/FileReader
    //   12: dup
    //   13: ldc 85
    //   15: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: bipush 80
    //   20: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   23: astore 6
    //   25: aload 6
    //   27: astore 5
    //   29: aload 6
    //   31: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 8
    //   36: aload 8
    //   38: ifnull +7 -> 45
    //   41: aload 8
    //   43: astore 7
    //   45: aload 7
    //   47: ifnonnull +28 -> 75
    //   50: lload_3
    //   51: lstore_1
    //   52: aload 6
    //   54: ifnull +10 -> 64
    //   57: aload 6
    //   59: invokevirtual 64	java/io/BufferedReader:close	()V
    //   62: lload_3
    //   63: lstore_1
    //   64: lload_1
    //   65: lreturn
    //   66: astore 5
    //   68: aload 5
    //   70: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   73: lconst_0
    //   74: lreturn
    //   75: aload 6
    //   77: astore 5
    //   79: aload 7
    //   81: aload 7
    //   83: bipush 58
    //   85: invokevirtual 92	java/lang/String:indexOf	(I)I
    //   88: iconst_1
    //   89: iadd
    //   90: aload 7
    //   92: bipush 107
    //   94: invokevirtual 92	java/lang/String:indexOf	(I)I
    //   97: invokevirtual 96	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   103: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: sipush 1024
    //   109: idiv
    //   110: istore_0
    //   111: iload_0
    //   112: i2l
    //   113: lstore_3
    //   114: lload_3
    //   115: lstore_1
    //   116: aload 6
    //   118: ifnull -54 -> 64
    //   121: aload 6
    //   123: invokevirtual 64	java/io/BufferedReader:close	()V
    //   126: lload_3
    //   127: lreturn
    //   128: astore 5
    //   130: aload 5
    //   132: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   135: lload_3
    //   136: lreturn
    //   137: astore 7
    //   139: aconst_null
    //   140: astore 6
    //   142: aload 6
    //   144: astore 5
    //   146: aload 7
    //   148: invokevirtual 77	java/io/FileNotFoundException:printStackTrace	()V
    //   151: lload_3
    //   152: lstore_1
    //   153: aload 6
    //   155: ifnull -91 -> 64
    //   158: aload 6
    //   160: invokevirtual 64	java/io/BufferedReader:close	()V
    //   163: lconst_0
    //   164: lreturn
    //   165: astore 5
    //   167: aload 5
    //   169: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   172: lconst_0
    //   173: lreturn
    //   174: astore 7
    //   176: aconst_null
    //   177: astore 6
    //   179: aload 6
    //   181: astore 5
    //   183: aload 7
    //   185: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   188: lload_3
    //   189: lstore_1
    //   190: aload 6
    //   192: ifnull -128 -> 64
    //   195: aload 6
    //   197: invokevirtual 64	java/io/BufferedReader:close	()V
    //   200: lconst_0
    //   201: lreturn
    //   202: astore 5
    //   204: aload 5
    //   206: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   209: lconst_0
    //   210: lreturn
    //   211: astore 6
    //   213: aconst_null
    //   214: astore 5
    //   216: aload 5
    //   218: ifnull +8 -> 226
    //   221: aload 5
    //   223: invokevirtual 64	java/io/BufferedReader:close	()V
    //   226: aload 6
    //   228: athrow
    //   229: astore 5
    //   231: aload 5
    //   233: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   236: goto -10 -> 226
    //   239: astore 6
    //   241: goto -25 -> 216
    //   244: astore 7
    //   246: goto -67 -> 179
    //   249: astore 7
    //   251: goto -109 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   110	2	0	i	int
    //   51	139	1	l1	long
    //   1	188	3	l2	long
    //   27	1	5	localBufferedReader1	java.io.BufferedReader
    //   66	3	5	localIOException1	java.io.IOException
    //   77	1	5	localBufferedReader2	java.io.BufferedReader
    //   128	3	5	localIOException2	java.io.IOException
    //   144	1	5	localBufferedReader3	java.io.BufferedReader
    //   165	3	5	localIOException3	java.io.IOException
    //   181	1	5	localBufferedReader4	java.io.BufferedReader
    //   202	3	5	localIOException4	java.io.IOException
    //   214	8	5	localObject1	Object
    //   229	3	5	localIOException5	java.io.IOException
    //   23	173	6	localBufferedReader5	java.io.BufferedReader
    //   211	16	6	localObject2	Object
    //   239	1	6	localObject3	Object
    //   3	88	7	localObject4	Object
    //   137	10	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   174	10	7	localException1	Exception
    //   244	1	7	localException2	Exception
    //   249	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   34	8	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   57	62	66	java/io/IOException
    //   121	126	128	java/io/IOException
    //   5	25	137	java/io/FileNotFoundException
    //   158	163	165	java/io/IOException
    //   5	25	174	java/lang/Exception
    //   195	200	202	java/io/IOException
    //   5	25	211	finally
    //   221	226	229	java/io/IOException
    //   29	36	239	finally
    //   79	111	239	finally
    //   146	151	239	finally
    //   183	188	239	finally
    //   29	36	244	java/lang/Exception
    //   79	111	244	java/lang/Exception
    //   29	36	249	java/io/FileNotFoundException
    //   79	111	249	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.lang.String g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 48	java/io/FileReader
    //   6: dup
    //   7: ldc 99
    //   9: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 53	java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: astore_2
    //   28: aload 4
    //   30: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: ifnonnull +44 -> 81
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 63	java/io/FileReader:close	()V
    //   48: aload 6
    //   50: astore_1
    //   51: aload 4
    //   53: ifnull +11 -> 64
    //   56: aload 4
    //   58: invokevirtual 64	java/io/BufferedReader:close	()V
    //   61: aload 6
    //   63: astore_1
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   71: goto -23 -> 48
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: aload 4
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload 5
    //   88: ldc 101
    //   90: iconst_2
    //   91: invokevirtual 105	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   94: astore 5
    //   96: iconst_0
    //   97: istore_0
    //   98: aload 4
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: iload_0
    //   104: aload 5
    //   106: arraylength
    //   107: if_icmpge +10 -> 117
    //   110: iload_0
    //   111: iconst_1
    //   112: iadd
    //   113: istore_0
    //   114: goto -16 -> 98
    //   117: aload 5
    //   119: iconst_1
    //   120: aaload
    //   121: astore_2
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 63	java/io/FileReader:close	()V
    //   130: aload_2
    //   131: astore_1
    //   132: aload 4
    //   134: ifnull -70 -> 64
    //   137: aload 4
    //   139: invokevirtual 64	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   149: aload_2
    //   150: areturn
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   156: goto -26 -> 130
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_1
    //   166: aload 4
    //   168: astore_3
    //   169: aload_1
    //   170: astore_2
    //   171: aload 5
    //   173: invokevirtual 77	java/io/FileNotFoundException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 63	java/io/FileReader:close	()V
    //   184: aload 6
    //   186: astore_1
    //   187: aload 4
    //   189: ifnull -125 -> 64
    //   192: aload 4
    //   194: invokevirtual 64	java/io/BufferedReader:close	()V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   211: goto -27 -> 184
    //   214: astore 5
    //   216: aconst_null
    //   217: astore 4
    //   219: aconst_null
    //   220: astore_1
    //   221: aload 4
    //   223: astore_3
    //   224: aload_1
    //   225: astore_2
    //   226: aload 5
    //   228: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 63	java/io/FileReader:close	()V
    //   239: aload 6
    //   241: astore_1
    //   242: aload 4
    //   244: ifnull -180 -> 64
    //   247: aload 4
    //   249: invokevirtual 64	java/io/BufferedReader:close	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   266: goto -27 -> 239
    //   269: astore 4
    //   271: aconst_null
    //   272: astore_3
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 63	java/io/FileReader:close	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 64	java/io/BufferedReader:close	()V
    //   291: aload 4
    //   293: athrow
    //   294: astore_1
    //   295: aload_1
    //   296: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   299: goto -16 -> 283
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   307: goto -16 -> 291
    //   310: astore 4
    //   312: aconst_null
    //   313: astore_3
    //   314: goto -39 -> 275
    //   317: astore 4
    //   319: aload_2
    //   320: astore_1
    //   321: goto -46 -> 275
    //   324: astore 5
    //   326: aconst_null
    //   327: astore 4
    //   329: goto -108 -> 221
    //   332: astore 5
    //   334: goto -113 -> 221
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 4
    //   342: goto -176 -> 166
    //   345: astore 5
    //   347: goto -181 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   97	17	0	i	int
    //   12	53	1	localObject1	Object
    //   66	2	1	localIOException1	java.io.IOException
    //   74	53	1	localIOException2	java.io.IOException
    //   131	1	1	localObject2	Object
    //   144	2	1	localIOException3	java.io.IOException
    //   151	2	1	localIOException4	java.io.IOException
    //   165	22	1	localObject3	Object
    //   199	2	1	localIOException5	java.io.IOException
    //   206	2	1	localIOException6	java.io.IOException
    //   220	22	1	localObject4	Object
    //   254	2	1	localIOException7	java.io.IOException
    //   261	2	1	localIOException8	java.io.IOException
    //   274	6	1	localObject5	Object
    //   294	2	1	localIOException9	java.io.IOException
    //   302	2	1	localIOException10	java.io.IOException
    //   320	1	1	localObject6	Object
    //   27	293	2	localObject7	Object
    //   25	289	3	localBufferedReader1	java.io.BufferedReader
    //   21	227	4	localBufferedReader2	java.io.BufferedReader
    //   269	23	4	localObject8	Object
    //   310	1	4	localObject9	Object
    //   317	1	4	localObject10	Object
    //   327	14	4	localObject11	Object
    //   33	85	5	localObject12	Object
    //   159	13	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   214	13	5	localIOException11	java.io.IOException
    //   324	1	5	localIOException12	java.io.IOException
    //   332	1	5	localIOException13	java.io.IOException
    //   337	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   345	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	239	6	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	66	java/io/IOException
    //   56	61	74	java/io/IOException
    //   137	142	144	java/io/IOException
    //   126	130	151	java/io/IOException
    //   3	13	159	java/io/FileNotFoundException
    //   192	197	199	java/io/IOException
    //   180	184	206	java/io/IOException
    //   3	13	214	java/io/IOException
    //   247	252	254	java/io/IOException
    //   235	239	261	java/io/IOException
    //   3	13	269	finally
    //   279	283	294	java/io/IOException
    //   287	291	302	java/io/IOException
    //   13	23	310	finally
    //   28	35	317	finally
    //   86	96	317	finally
    //   103	110	317	finally
    //   171	176	317	finally
    //   226	231	317	finally
    //   13	23	324	java/io/IOException
    //   28	35	332	java/io/IOException
    //   86	96	332	java/io/IOException
    //   103	110	332	java/io/IOException
    //   13	23	337	java/io/FileNotFoundException
    //   28	35	345	java/io/FileNotFoundException
    //   86	96	345	java/io/FileNotFoundException
    //   103	110	345	java/io/FileNotFoundException
  }
  
  public static int h()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {
      return 0;
    }
    try
    {
      localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      int i = (int)(localMemoryInfo.availMem / 1048576L);
      ab.c("DeviceInfoUtil_", "<getRamAvailable> :" + i);
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static int i()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks();
      ab.c("DeviceInfoUtil_", "<getSDFreeSize> blockSize " + l1);
      ab.c("DeviceInfoUtil_", "<getSDFreeSize> freeBlocks " + l2);
      int i = (int)(l2 * l1 / 1024L / 1024L);
      ab.c("DeviceInfoUtil_", "<getSDFreeSize> " + i);
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static int j()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      ab.c("DeviceInfoUtil_", "<getSDAllSize> blockSize " + l1);
      long l2 = localStatFs.getBlockCount();
      ab.c("DeviceInfoUtil_", "<getSDAllSize> allBlocks " + l2);
      int i = (int)(l2 * l1 / 1024L / 1024L);
      ab.c("DeviceInfoUtil_", "<getSDAllSize> " + i);
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private void k()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {}
    do
    {
      return;
      if (this.a == null) {
        this.a = new TerminalExtra();
      }
      localObject = ((Context)localObject).getSharedPreferences("TMAssistantSDKSharedPreference", 4);
    } while (localObject == null);
    this.a.cpuName = ((SharedPreferences)localObject).getString("key_device_cpu_name", "");
    this.a.cpuCoresNum = ((SharedPreferences)localObject).getInt("key_device_cpu_core_num", -1);
    this.a.cpuMaxFreq = ((SharedPreferences)localObject).getInt("key_device_cpu_max_freq", -1);
    this.a.cpuMinFreq = ((SharedPreferences)localObject).getInt("key_device_cpu_min_freq", -1);
    this.a.ramTotalSize = ((SharedPreferences)localObject).getLong("key_device_ram_total_size", -1L);
    this.a.romName = ((SharedPreferences)localObject).getString("key_device_rom_name", "");
    this.a.romVersion = ((SharedPreferences)localObject).getString("key_device_rom_version", "");
    localObject = ((SharedPreferences)localObject).edit();
    if (this.a.cpuCoresNum < 0)
    {
      this.a.cpuCoresNum = c();
      ((SharedPreferences.Editor)localObject).putInt("key_device_cpu_core_num", this.a.cpuCoresNum);
    }
    if (this.a.cpuMaxFreq < 0)
    {
      this.a.cpuMaxFreq = d();
      ((SharedPreferences.Editor)localObject).putInt("key_device_cpu_max_freq", this.a.cpuMaxFreq);
    }
    if (this.a.cpuMinFreq < 0)
    {
      this.a.cpuMinFreq = e();
      ((SharedPreferences.Editor)localObject).putInt("key_device_cpu_min_freq", this.a.cpuMinFreq);
    }
    if (this.a.ramTotalSize < 0L)
    {
      this.a.ramTotalSize = f();
      ((SharedPreferences.Editor)localObject).putLong("key_device_ram_total_size", this.a.ramTotalSize);
    }
    if (TextUtils.isEmpty(this.a.cpuName))
    {
      this.a.cpuName = g();
      ((SharedPreferences.Editor)localObject).putString("key_device_cpu_name", this.a.cpuName);
    }
    this.a.fingerprint = Build.FINGERPRINT;
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public TerminalExtra b()
  {
    if (this.a == null) {
      k();
    }
    if (this.a != null)
    {
      this.a.ramRemainSize = h();
      this.a.flashRemainSize = i();
      this.a.flashTotalSize = j();
      ab.c("DeviceInfoUtil_", ">>getTerminalExtra \n terminalExtra.cpuName = " + this.a.cpuName + "\n  terminalExtra.cpuCoresNum = " + this.a.cpuCoresNum + "\n  terminalExtra.cpuMaxFreq = " + this.a.cpuMaxFreq + "\n  terminalExtra.cpuMinFreq = " + this.a.cpuMinFreq + "\n  terminalExtra.ramTotalSize = " + this.a.ramTotalSize + "\n  terminalExtra.ramRemainSize = " + this.a.ramRemainSize + "\n  terminalExtra.flashRemainSize = " + this.a.flashRemainSize + "\n  terminalExtra.flashTotalSize = " + this.a.flashTotalSize + "\n  terminalExtra.abiList = " + this.a.abiList);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.f
 * JD-Core Version:    0.7.0.1
 */