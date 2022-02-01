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
  private static volatile f b;
  private TerminalExtra a;
  
  public static f a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new f();
        }
      }
      finally {}
    }
    return b;
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
    //   0: iconst_0
    //   1: istore_0
    //   2: new 48	java/io/FileReader
    //   5: dup
    //   6: ldc 50
    //   8: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 53	java/io/BufferedReader
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 5
    //   22: aload_2
    //   23: astore_3
    //   24: aload 5
    //   26: astore 4
    //   28: aload 5
    //   30: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnonnull +29 -> 66
    //   40: aload_2
    //   41: invokevirtual 63	java/io/FileReader:close	()V
    //   44: goto +8 -> 52
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   52: aload 5
    //   54: invokevirtual 65	java/io/BufferedReader:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_2
    //   67: astore_3
    //   68: aload 5
    //   70: astore 4
    //   72: aload 6
    //   74: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   77: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: aload_2
    //   82: invokevirtual 63	java/io/FileReader:close	()V
    //   85: goto +8 -> 93
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   93: iload_1
    //   94: istore_0
    //   95: aload 5
    //   97: invokevirtual 65	java/io/BufferedReader:close	()V
    //   100: iload_1
    //   101: ireturn
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   107: iload_0
    //   108: ireturn
    //   109: astore 6
    //   111: aload_2
    //   112: astore 7
    //   114: aload 5
    //   116: astore_2
    //   117: goto +58 -> 175
    //   120: astore 6
    //   122: aload_2
    //   123: astore 7
    //   125: aload 5
    //   127: astore_2
    //   128: goto +93 -> 221
    //   131: astore_3
    //   132: goto +30 -> 162
    //   135: astore 6
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_2
    //   140: astore 7
    //   142: aload_3
    //   143: astore_2
    //   144: goto +31 -> 175
    //   147: astore 6
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_2
    //   152: astore 7
    //   154: aload_3
    //   155: astore_2
    //   156: goto +65 -> 221
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aconst_null
    //   163: astore 4
    //   165: goto +102 -> 267
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: astore 7
    //   175: aload 7
    //   177: astore_3
    //   178: aload_2
    //   179: astore 4
    //   181: aload 6
    //   183: invokevirtual 77	java/lang/Throwable:printStackTrace	()V
    //   186: aload 7
    //   188: ifnull +16 -> 204
    //   191: aload 7
    //   193: invokevirtual 63	java/io/FileReader:close	()V
    //   196: goto +8 -> 204
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   204: aload_2
    //   205: ifnull +53 -> 258
    //   208: aload_2
    //   209: invokevirtual 65	java/io/BufferedReader:close	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore 6
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_2
    //   219: astore 7
    //   221: aload 7
    //   223: astore_3
    //   224: aload_2
    //   225: astore 4
    //   227: aload 6
    //   229: invokevirtual 78	java/io/FileNotFoundException:printStackTrace	()V
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: aload 7
    //   239: invokevirtual 63	java/io/FileReader:close	()V
    //   242: goto +8 -> 250
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 65	java/io/BufferedReader:close	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore 5
    //   262: aload_3
    //   263: astore_2
    //   264: aload 5
    //   266: astore_3
    //   267: aload_2
    //   268: ifnull +15 -> 283
    //   271: aload_2
    //   272: invokevirtual 63	java/io/FileReader:close	()V
    //   275: goto +8 -> 283
    //   278: astore_2
    //   279: aload_2
    //   280: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +16 -> 301
    //   288: aload 4
    //   290: invokevirtual 65	java/io/BufferedReader:close	()V
    //   293: goto +8 -> 301
    //   296: astore_2
    //   297: aload_2
    //   298: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   301: aload_3
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	107	0	i	int
    //   80	21	1	j	int
    //   11	30	2	localFileReader	java.io.FileReader
    //   47	2	2	localIOException1	java.io.IOException
    //   59	23	2	localIOException2	java.io.IOException
    //   88	2	2	localIOException3	java.io.IOException
    //   102	10	2	localIOException4	java.io.IOException
    //   116	156	2	localObject1	Object
    //   278	2	2	localIOException5	java.io.IOException
    //   296	2	2	localIOException6	java.io.IOException
    //   23	45	3	localObject2	Object
    //   131	1	3	localObject3	Object
    //   138	17	3	localObject4	Object
    //   159	1	3	localObject5	Object
    //   177	1	3	localObject6	Object
    //   199	2	3	localIOException7	java.io.IOException
    //   223	1	3	localObject7	Object
    //   245	18	3	localIOException8	java.io.IOException
    //   266	36	3	localObject8	Object
    //   26	263	4	localObject9	Object
    //   20	106	5	localBufferedReader	java.io.BufferedReader
    //   260	5	5	localObject10	Object
    //   33	40	6	str	java.lang.String
    //   109	1	6	localThrowable1	Throwable
    //   120	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   135	1	6	localThrowable2	Throwable
    //   147	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   168	14	6	localThrowable3	Throwable
    //   214	14	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   112	126	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/io/IOException
    //   52	57	59	java/io/IOException
    //   81	85	88	java/io/IOException
    //   95	100	102	java/io/IOException
    //   208	212	102	java/io/IOException
    //   254	258	102	java/io/IOException
    //   28	35	109	java/lang/Throwable
    //   72	81	109	java/lang/Throwable
    //   28	35	120	java/io/FileNotFoundException
    //   72	81	120	java/io/FileNotFoundException
    //   12	22	131	finally
    //   12	22	135	java/lang/Throwable
    //   12	22	147	java/io/FileNotFoundException
    //   2	12	159	finally
    //   2	12	168	java/lang/Throwable
    //   191	196	199	java/io/IOException
    //   2	12	214	java/io/FileNotFoundException
    //   237	242	245	java/io/IOException
    //   28	35	260	finally
    //   72	81	260	finally
    //   181	186	260	finally
    //   227	232	260	finally
    //   271	275	278	java/io/IOException
    //   288	293	296	java/io/IOException
  }
  
  /* Error */
  public static int e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: new 48	java/io/FileReader
    //   5: dup
    //   6: ldc 81
    //   8: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 53	java/io/BufferedReader
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 5
    //   22: aload_2
    //   23: astore_3
    //   24: aload 5
    //   26: astore 4
    //   28: aload 5
    //   30: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnonnull +29 -> 66
    //   40: aload_2
    //   41: invokevirtual 63	java/io/FileReader:close	()V
    //   44: goto +8 -> 52
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   52: aload 5
    //   54: invokevirtual 65	java/io/BufferedReader:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_2
    //   67: astore_3
    //   68: aload 5
    //   70: astore 4
    //   72: aload 6
    //   74: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   77: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: aload_2
    //   82: invokevirtual 63	java/io/FileReader:close	()V
    //   85: goto +8 -> 93
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   93: iload_1
    //   94: istore_0
    //   95: aload 5
    //   97: invokevirtual 65	java/io/BufferedReader:close	()V
    //   100: iload_1
    //   101: ireturn
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   107: iload_0
    //   108: ireturn
    //   109: astore 6
    //   111: aload_2
    //   112: astore 7
    //   114: aload 5
    //   116: astore_2
    //   117: goto +58 -> 175
    //   120: astore 6
    //   122: aload_2
    //   123: astore 7
    //   125: aload 5
    //   127: astore_2
    //   128: goto +93 -> 221
    //   131: astore_3
    //   132: goto +30 -> 162
    //   135: astore 6
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_2
    //   140: astore 7
    //   142: aload_3
    //   143: astore_2
    //   144: goto +31 -> 175
    //   147: astore 6
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_2
    //   152: astore 7
    //   154: aload_3
    //   155: astore_2
    //   156: goto +65 -> 221
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aconst_null
    //   163: astore 4
    //   165: goto +102 -> 267
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: astore 7
    //   175: aload 7
    //   177: astore_3
    //   178: aload_2
    //   179: astore 4
    //   181: aload 6
    //   183: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   186: aload 7
    //   188: ifnull +16 -> 204
    //   191: aload 7
    //   193: invokevirtual 63	java/io/FileReader:close	()V
    //   196: goto +8 -> 204
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   204: aload_2
    //   205: ifnull +53 -> 258
    //   208: aload_2
    //   209: invokevirtual 65	java/io/BufferedReader:close	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore 6
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_2
    //   219: astore 7
    //   221: aload 7
    //   223: astore_3
    //   224: aload_2
    //   225: astore 4
    //   227: aload 6
    //   229: invokevirtual 78	java/io/FileNotFoundException:printStackTrace	()V
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: aload 7
    //   239: invokevirtual 63	java/io/FileReader:close	()V
    //   242: goto +8 -> 250
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 65	java/io/BufferedReader:close	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore 5
    //   262: aload_3
    //   263: astore_2
    //   264: aload 5
    //   266: astore_3
    //   267: aload_2
    //   268: ifnull +15 -> 283
    //   271: aload_2
    //   272: invokevirtual 63	java/io/FileReader:close	()V
    //   275: goto +8 -> 283
    //   278: astore_2
    //   279: aload_2
    //   280: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +16 -> 301
    //   288: aload 4
    //   290: invokevirtual 65	java/io/BufferedReader:close	()V
    //   293: goto +8 -> 301
    //   296: astore_2
    //   297: aload_2
    //   298: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   301: aload_3
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	107	0	i	int
    //   80	21	1	j	int
    //   11	30	2	localFileReader	java.io.FileReader
    //   47	2	2	localIOException1	java.io.IOException
    //   59	23	2	localIOException2	java.io.IOException
    //   88	2	2	localIOException3	java.io.IOException
    //   102	10	2	localIOException4	java.io.IOException
    //   116	156	2	localObject1	Object
    //   278	2	2	localIOException5	java.io.IOException
    //   296	2	2	localIOException6	java.io.IOException
    //   23	45	3	localObject2	Object
    //   131	1	3	localObject3	Object
    //   138	17	3	localObject4	Object
    //   159	1	3	localObject5	Object
    //   177	1	3	localObject6	Object
    //   199	2	3	localIOException7	java.io.IOException
    //   223	1	3	localObject7	Object
    //   245	18	3	localIOException8	java.io.IOException
    //   266	36	3	localObject8	Object
    //   26	263	4	localObject9	Object
    //   20	106	5	localBufferedReader	java.io.BufferedReader
    //   260	5	5	localObject10	Object
    //   33	40	6	str	java.lang.String
    //   109	1	6	localIOException9	java.io.IOException
    //   120	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   135	1	6	localIOException10	java.io.IOException
    //   147	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   168	14	6	localIOException11	java.io.IOException
    //   214	14	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   112	126	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/io/IOException
    //   52	57	59	java/io/IOException
    //   81	85	88	java/io/IOException
    //   95	100	102	java/io/IOException
    //   208	212	102	java/io/IOException
    //   254	258	102	java/io/IOException
    //   28	35	109	java/io/IOException
    //   72	81	109	java/io/IOException
    //   28	35	120	java/io/FileNotFoundException
    //   72	81	120	java/io/FileNotFoundException
    //   12	22	131	finally
    //   12	22	135	java/io/IOException
    //   12	22	147	java/io/FileNotFoundException
    //   2	12	159	finally
    //   2	12	168	java/io/IOException
    //   191	196	199	java/io/IOException
    //   2	12	214	java/io/FileNotFoundException
    //   237	242	245	java/io/IOException
    //   28	35	260	finally
    //   72	81	260	finally
    //   181	186	260	finally
    //   227	232	260	finally
    //   271	275	278	java/io/IOException
    //   288	293	296	java/io/IOException
  }
  
  /* Error */
  public static long f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: new 53	java/io/BufferedReader
    //   11: dup
    //   12: new 48	java/io/FileReader
    //   15: dup
    //   16: ldc 85
    //   18: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: bipush 80
    //   23: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +6 -> 41
    //   38: goto +5 -> 43
    //   41: aconst_null
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +17 -> 61
    //   47: aload 4
    //   49: invokevirtual 65	java/io/BufferedReader:close	()V
    //   52: lconst_0
    //   53: lreturn
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   59: lconst_0
    //   60: lreturn
    //   61: aload_3
    //   62: aload_3
    //   63: bipush 58
    //   65: invokevirtual 92	java/lang/String:indexOf	(I)I
    //   68: iconst_1
    //   69: iadd
    //   70: aload_3
    //   71: bipush 107
    //   73: invokevirtual 92	java/lang/String:indexOf	(I)I
    //   76: invokevirtual 96	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 70	java/lang/String:trim	()Ljava/lang/String;
    //   82: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: sipush 1024
    //   88: idiv
    //   89: istore_0
    //   90: iload_0
    //   91: i2l
    //   92: lstore_1
    //   93: aload 4
    //   95: invokevirtual 65	java/io/BufferedReader:close	()V
    //   98: lload_1
    //   99: lreturn
    //   100: astore_3
    //   101: aload_3
    //   102: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   105: lload_1
    //   106: lreturn
    //   107: astore_3
    //   108: goto +85 -> 193
    //   111: astore 5
    //   113: goto +27 -> 140
    //   116: astore 5
    //   118: goto +48 -> 166
    //   121: astore 5
    //   123: aload_3
    //   124: astore 4
    //   126: aload 5
    //   128: astore_3
    //   129: goto +64 -> 193
    //   132: astore_3
    //   133: aload 5
    //   135: astore 4
    //   137: aload_3
    //   138: astore 5
    //   140: aload 4
    //   142: astore_3
    //   143: aload 5
    //   145: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   148: aload 4
    //   150: ifnull +41 -> 191
    //   153: aload 4
    //   155: invokevirtual 65	java/io/BufferedReader:close	()V
    //   158: lconst_0
    //   159: lreturn
    //   160: astore 5
    //   162: aload 6
    //   164: astore 4
    //   166: aload 4
    //   168: astore_3
    //   169: aload 5
    //   171: invokevirtual 78	java/io/FileNotFoundException:printStackTrace	()V
    //   174: aload 4
    //   176: ifnull +15 -> 191
    //   179: aload 4
    //   181: invokevirtual 65	java/io/BufferedReader:close	()V
    //   184: lconst_0
    //   185: lreturn
    //   186: astore_3
    //   187: aload_3
    //   188: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   191: lconst_0
    //   192: lreturn
    //   193: aload 4
    //   195: ifnull +18 -> 213
    //   198: aload 4
    //   200: invokevirtual 65	java/io/BufferedReader:close	()V
    //   203: goto +10 -> 213
    //   206: astore 4
    //   208: aload 4
    //   210: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   213: aload_3
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   89	2	0	i	int
    //   92	14	1	l	long
    //   7	37	3	str	java.lang.String
    //   54	17	3	localIOException1	java.io.IOException
    //   100	2	3	localIOException2	java.io.IOException
    //   107	17	3	localObject1	Object
    //   128	1	3	localObject2	Object
    //   132	6	3	localException1	Exception
    //   142	27	3	localObject3	Object
    //   186	28	3	localIOException3	java.io.IOException
    //   26	173	4	localObject4	Object
    //   206	3	4	localIOException4	java.io.IOException
    //   1	1	5	localObject5	Object
    //   111	1	5	localException2	Exception
    //   116	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   121	13	5	localObject6	Object
    //   138	6	5	localObject7	Object
    //   160	10	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	159	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   47	52	54	java/io/IOException
    //   93	98	100	java/io/IOException
    //   28	34	107	finally
    //   61	90	107	finally
    //   28	34	111	java/lang/Exception
    //   61	90	111	java/lang/Exception
    //   28	34	116	java/io/FileNotFoundException
    //   61	90	116	java/io/FileNotFoundException
    //   8	28	121	finally
    //   143	148	121	finally
    //   169	174	121	finally
    //   8	28	132	java/lang/Exception
    //   8	28	160	java/io/FileNotFoundException
    //   153	158	186	java/io/IOException
    //   179	184	186	java/io/IOException
    //   198	203	206	java/io/IOException
  }
  
  /* Error */
  public static java.lang.String g()
  {
    // Byte code:
    //   0: new 48	java/io/FileReader
    //   3: dup
    //   4: ldc 99
    //   6: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: new 53	java/io/BufferedReader
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore 4
    //   20: aload_1
    //   21: astore_2
    //   22: aload 4
    //   24: astore_3
    //   25: aload 4
    //   27: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 5
    //   32: aload 5
    //   34: ifnonnull +29 -> 63
    //   37: aload_1
    //   38: invokevirtual 63	java/io/FileReader:close	()V
    //   41: goto +8 -> 49
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   49: aload 4
    //   51: invokevirtual 65	java/io/BufferedReader:close	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload 5
    //   70: ldc 101
    //   72: iconst_2
    //   73: invokevirtual 105	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   76: astore 5
    //   78: iconst_0
    //   79: istore_0
    //   80: aload_1
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: iload_0
    //   86: aload 5
    //   88: arraylength
    //   89: if_icmpge +10 -> 99
    //   92: iload_0
    //   93: iconst_1
    //   94: iadd
    //   95: istore_0
    //   96: goto -16 -> 80
    //   99: aload 5
    //   101: iconst_1
    //   102: aaload
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 63	java/io/FileReader:close	()V
    //   108: goto +8 -> 116
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   116: aload 4
    //   118: invokevirtual 65	java/io/BufferedReader:close	()V
    //   121: aload_2
    //   122: areturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: aload_1
    //   132: astore 5
    //   134: aload 4
    //   136: astore_1
    //   137: aload_2
    //   138: astore 4
    //   140: goto +62 -> 202
    //   143: astore_2
    //   144: aload_1
    //   145: astore 5
    //   147: aload 4
    //   149: astore_1
    //   150: aload_2
    //   151: astore 4
    //   153: goto +95 -> 248
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_3
    //   159: goto +141 -> 300
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_1
    //   167: astore 5
    //   169: aload_2
    //   170: astore_1
    //   171: goto +31 -> 202
    //   174: astore 4
    //   176: aconst_null
    //   177: astore_2
    //   178: aload_1
    //   179: astore 5
    //   181: aload_2
    //   182: astore_1
    //   183: goto +65 -> 248
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_3
    //   189: aload_3
    //   190: astore_1
    //   191: goto +109 -> 300
    //   194: astore 4
    //   196: aconst_null
    //   197: astore 5
    //   199: aload 5
    //   201: astore_1
    //   202: aload 5
    //   204: astore_2
    //   205: aload_1
    //   206: astore_3
    //   207: aload 4
    //   209: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   212: aload 5
    //   214: ifnull +16 -> 230
    //   217: aload 5
    //   219: invokevirtual 63	java/io/FileReader:close	()V
    //   222: goto +8 -> 230
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   230: aload_1
    //   231: ifnull +60 -> 291
    //   234: aload_1
    //   235: invokevirtual 65	java/io/BufferedReader:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore 4
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 5
    //   247: astore_1
    //   248: aload 5
    //   250: astore_2
    //   251: aload_1
    //   252: astore_3
    //   253: aload 4
    //   255: invokevirtual 78	java/io/FileNotFoundException:printStackTrace	()V
    //   258: aload 5
    //   260: ifnull +16 -> 276
    //   263: aload 5
    //   265: invokevirtual 63	java/io/FileReader:close	()V
    //   268: goto +8 -> 276
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   276: aload_1
    //   277: ifnull +14 -> 291
    //   280: aload_1
    //   281: invokevirtual 65	java/io/BufferedReader:close	()V
    //   284: aconst_null
    //   285: areturn
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   291: aconst_null
    //   292: areturn
    //   293: astore 4
    //   295: aload_2
    //   296: astore_1
    //   297: aload 4
    //   299: astore_2
    //   300: aload_1
    //   301: ifnull +15 -> 316
    //   304: aload_1
    //   305: invokevirtual 63	java/io/FileReader:close	()V
    //   308: goto +8 -> 316
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   316: aload_3
    //   317: ifnull +15 -> 332
    //   320: aload_3
    //   321: invokevirtual 65	java/io/BufferedReader:close	()V
    //   324: goto +8 -> 332
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   332: goto +5 -> 337
    //   335: aload_2
    //   336: athrow
    //   337: goto -2 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	17	0	i	int
    //   9	29	1	localFileReader	java.io.FileReader
    //   44	2	1	localIOException1	java.io.IOException
    //   56	49	1	localIOException2	java.io.IOException
    //   111	2	1	localIOException3	java.io.IOException
    //   123	9	1	localIOException4	java.io.IOException
    //   136	145	1	localObject1	Object
    //   286	2	1	localIOException5	java.io.IOException
    //   296	9	1	localObject2	Object
    //   311	2	1	localIOException6	java.io.IOException
    //   327	2	1	localIOException7	java.io.IOException
    //   21	108	2	localObject3	Object
    //   130	8	2	localIOException8	java.io.IOException
    //   143	8	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   156	1	2	localObject4	Object
    //   165	17	2	localObject5	Object
    //   186	1	2	localObject6	Object
    //   204	1	2	localObject7	Object
    //   225	2	2	localIOException9	java.io.IOException
    //   250	1	2	localObject8	Object
    //   271	25	2	localIOException10	java.io.IOException
    //   299	37	2	localObject9	Object
    //   24	297	3	localObject10	Object
    //   18	134	4	localObject11	Object
    //   162	1	4	localIOException11	java.io.IOException
    //   174	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   194	14	4	localIOException12	java.io.IOException
    //   240	14	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   293	5	4	localObject12	Object
    //   30	234	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	44	java/io/IOException
    //   49	54	56	java/io/IOException
    //   104	108	111	java/io/IOException
    //   116	121	123	java/io/IOException
    //   25	32	130	java/io/IOException
    //   68	78	130	java/io/IOException
    //   85	92	130	java/io/IOException
    //   25	32	143	java/io/FileNotFoundException
    //   68	78	143	java/io/FileNotFoundException
    //   85	92	143	java/io/FileNotFoundException
    //   10	20	156	finally
    //   10	20	162	java/io/IOException
    //   10	20	174	java/io/FileNotFoundException
    //   0	10	186	finally
    //   0	10	194	java/io/IOException
    //   217	222	225	java/io/IOException
    //   0	10	240	java/io/FileNotFoundException
    //   263	268	271	java/io/IOException
    //   234	238	286	java/io/IOException
    //   280	284	286	java/io/IOException
    //   25	32	293	finally
    //   68	78	293	finally
    //   85	92	293	finally
    //   207	212	293	finally
    //   253	258	293	finally
    //   304	308	311	java/io/IOException
    //   320	324	327	java/io/IOException
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getRamAvailable> :");
      ((StringBuilder)localObject).append(i);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static int i()
  {
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getSDFreeSize> blockSize ");
      ((StringBuilder)localObject).append(l1);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getSDFreeSize> freeBlocks ");
      ((StringBuilder)localObject).append(l2);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      int i = (int)(l2 * l1 / 1024L / 1024L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getSDFreeSize> ");
      ((StringBuilder)localObject).append(i);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      return i;
    }
    catch (Throwable localThrowable)
    {
      label146:
      break label146;
    }
    return 0;
  }
  
  public static int j()
  {
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getSDAllSize> blockSize ");
      localStringBuilder.append(l1);
      ab.c("DeviceInfoUtil_", localStringBuilder.toString());
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getSDAllSize> allBlocks ");
      ((StringBuilder)localObject).append(l2);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      int i = (int)(l2 * l1 / 1024L / 1024L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getSDAllSize> ");
      ((StringBuilder)localObject).append(i);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
      return i;
    }
    catch (Throwable localThrowable)
    {
      label146:
      break label146;
    }
    return 0;
  }
  
  private void k()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {
      return;
    }
    if (this.a == null) {
      this.a = new TerminalExtra();
    }
    localObject = ((Context)localObject).getSharedPreferences("TMAssistantSDKSharedPreference", 4);
    if (localObject != null)
    {
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
  }
  
  public TerminalExtra b()
  {
    if (this.a == null) {
      k();
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((TerminalExtra)localObject).ramRemainSize = h();
      this.a.flashRemainSize = i();
      this.a.flashTotalSize = j();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>getTerminalExtra \n terminalExtra.cpuName = ");
      ((StringBuilder)localObject).append(this.a.cpuName);
      ((StringBuilder)localObject).append("\n  terminalExtra.cpuCoresNum = ");
      ((StringBuilder)localObject).append(this.a.cpuCoresNum);
      ((StringBuilder)localObject).append("\n  terminalExtra.cpuMaxFreq = ");
      ((StringBuilder)localObject).append(this.a.cpuMaxFreq);
      ((StringBuilder)localObject).append("\n  terminalExtra.cpuMinFreq = ");
      ((StringBuilder)localObject).append(this.a.cpuMinFreq);
      ((StringBuilder)localObject).append("\n  terminalExtra.ramTotalSize = ");
      ((StringBuilder)localObject).append(this.a.ramTotalSize);
      ((StringBuilder)localObject).append("\n  terminalExtra.ramRemainSize = ");
      ((StringBuilder)localObject).append(this.a.ramRemainSize);
      ((StringBuilder)localObject).append("\n  terminalExtra.flashRemainSize = ");
      ((StringBuilder)localObject).append(this.a.flashRemainSize);
      ((StringBuilder)localObject).append("\n  terminalExtra.flashTotalSize = ");
      ((StringBuilder)localObject).append(this.a.flashTotalSize);
      ((StringBuilder)localObject).append("\n  terminalExtra.abiList = ");
      ((StringBuilder)localObject).append(this.a.abiList);
      ab.c("DeviceInfoUtil_", ((StringBuilder)localObject).toString());
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.f
 * JD-Core Version:    0.7.0.1
 */