package com.tencent.turingfd.sdk.xq;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class abstract
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 19	java/io/BufferedOutputStream
    //   7: dup
    //   8: new 21	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 25	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 28	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 32	java/io/BufferedOutputStream:write	([B)V
    //   25: aload_0
    //   26: invokevirtual 35	java/io/BufferedOutputStream:flush	()V
    //   29: aload_0
    //   30: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   33: iconst_1
    //   34: ireturn
    //   35: astore_1
    //   36: goto +9 -> 45
    //   39: goto +12 -> 51
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: aload_0
    //   46: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   55: iconst_0
    //   56: ireturn
    //   57: astore_0
    //   58: aload_3
    //   59: astore_0
    //   60: goto -9 -> 51
    //   63: astore_1
    //   64: goto -25 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString	String
    //   0	67	1	paramArrayOfByte	byte[]
    //   3	41	2	localObject1	Object
    //   1	58	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	35	finally
    //   4	20	42	finally
    //   4	20	57	java/lang/Throwable
    //   20	29	63	java/lang/Throwable
  }
  
  public static boolean b(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (!paramFile.isDirectory()) {}
    try
    {
      bool = paramFile.delete();
      return bool;
    }
    catch (Throwable paramFile)
    {
      try
      {
        File[] arrayOfFile;
        int j;
        int i;
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Throwable paramFile) {}
      paramFile = paramFile;
      return false;
    }
    arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        b(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  public static String c(File paramFile)
  {
    try
    {
      paramFile = paramFile.getCanonicalPath();
      return paramFile;
    }
    catch (IOException paramFile)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  /* Error */
  public static byte[] c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 45	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 69	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: iload_1
    //   28: newarray byte
    //   30: astore 5
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_0
    //   35: aload 5
    //   37: iload_2
    //   38: iload_1
    //   39: iload_2
    //   40: isub
    //   41: invokevirtual 76	java/io/FileInputStream:read	([BII)I
    //   44: istore 4
    //   46: iload_2
    //   47: istore_3
    //   48: iload 4
    //   50: iconst_m1
    //   51: if_icmpeq +15 -> 66
    //   54: iload_2
    //   55: iload 4
    //   57: iadd
    //   58: istore_3
    //   59: iload_3
    //   60: istore_2
    //   61: iload_3
    //   62: iload_1
    //   63: if_icmplt -29 -> 34
    //   66: iload_3
    //   67: ifne +9 -> 76
    //   70: aload_0
    //   71: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: iload_3
    //   77: iload_1
    //   78: if_icmpge +25 -> 103
    //   81: iload_3
    //   82: newarray byte
    //   84: astore 6
    //   86: aload 5
    //   88: iconst_0
    //   89: aload 6
    //   91: iconst_0
    //   92: iload_3
    //   93: invokestatic 85	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   96: aload 6
    //   98: astore 5
    //   100: goto +3 -> 103
    //   103: aload_0
    //   104: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   107: aload 5
    //   109: areturn
    //   110: astore 5
    //   112: goto +7 -> 119
    //   115: astore 5
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   123: aload 5
    //   125: athrow
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: goto -9 -> 126
    //   138: astore 5
    //   140: goto -12 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramInt	int
    //   33	28	2	i	int
    //   47	46	3	j	int
    //   44	14	4	k	int
    //   30	78	5	localObject1	Object
    //   110	1	5	localObject2	Object
    //   115	9	5	localObject3	Object
    //   138	1	5	localThrowable	Throwable
    //   84	13	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	32	110	finally
    //   34	46	110	finally
    //   81	96	110	finally
    //   18	27	115	finally
    //   18	27	134	java/lang/Throwable
    //   27	32	138	java/lang/Throwable
    //   34	46	138	java/lang/Throwable
    //   81	96	138	java/lang/Throwable
  }
  
  /* Error */
  public static String d(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 88	java/io/BufferedReader
    //   7: dup
    //   8: new 90	java/io/FileReader
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 91	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   16: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +9 -> 35
    //   29: aload_0
    //   30: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: goto +9 -> 51
    //   45: goto +16 -> 61
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   59: aload_1
    //   60: athrow
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokestatic 37	com/tencent/turingfd/sdk/xq/abstract:a	(Ljava/io/Closeable;)V
    //   69: ldc 99
    //   71: areturn
    //   72: astore_0
    //   73: aload_1
    //   74: astore_0
    //   75: goto -14 -> 61
    //   78: astore_1
    //   79: goto -34 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramFile	File
    //   1	39	1	str	String
    //   41	1	1	localObject1	Object
    //   48	26	1	localObject2	Object
    //   78	1	1	localThrowable	Throwable
    //   3	47	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	41	finally
    //   4	20	48	finally
    //   4	20	72	java/lang/Throwable
    //   20	25	78	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] i(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 69	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_3
    //   17: astore_2
    //   18: aload_0
    //   19: astore_3
    //   20: new 104	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 108	java/io/FileInputStream:available	()I
    //   28: invokespecial 111	java/io/ByteArrayOutputStream:<init>	(I)V
    //   31: astore 4
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_0
    //   40: aload_2
    //   41: invokevirtual 116	java/io/InputStream:read	([B)I
    //   44: istore_1
    //   45: iconst_m1
    //   46: iload_1
    //   47: if_icmpeq +14 -> 61
    //   50: aload 4
    //   52: aload_2
    //   53: iconst_0
    //   54: iload_1
    //   55: invokevirtual 121	java/io/OutputStream:write	([BII)V
    //   58: goto -19 -> 39
    //   61: aload 4
    //   63: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +6 -> 74
    //   71: goto +9 -> 80
    //   74: ldc 99
    //   76: invokevirtual 130	java/lang/String:getBytes	()[B
    //   79: astore_2
    //   80: aload_0
    //   81: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   84: aload 4
    //   86: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: aload 4
    //   94: astore_2
    //   95: goto +40 -> 135
    //   98: aload 4
    //   100: astore_2
    //   101: goto +24 -> 125
    //   104: astore 4
    //   106: aload_3
    //   107: astore_0
    //   108: aload 4
    //   110: astore_3
    //   111: goto +24 -> 135
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_0
    //   117: goto +18 -> 135
    //   120: aconst_null
    //   121: astore_0
    //   122: aload 5
    //   124: astore_2
    //   125: aload_0
    //   126: astore_3
    //   127: new 61	java/io/IOException
    //   130: dup
    //   131: invokespecial 132	java/io/IOException:<init>	()V
    //   134: athrow
    //   135: aload_0
    //   136: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   139: aload_2
    //   140: invokestatic 79	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   143: goto +5 -> 148
    //   146: aload_3
    //   147: athrow
    //   148: goto -2 -> 146
    //   151: astore_0
    //   152: goto -32 -> 120
    //   155: astore_2
    //   156: aload 5
    //   158: astore_2
    //   159: goto -34 -> 125
    //   162: astore_2
    //   163: goto -65 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   44	11	1	i	int
    //   4	136	2	localObject1	Object
    //   155	1	2	localThrowable1	Throwable
    //   158	1	2	localObject2	Object
    //   162	1	2	localThrowable2	Throwable
    //   6	14	3	str1	String
    //   91	16	3	localObject3	Object
    //   110	1	3	localObject4	Object
    //   114	1	3	localObject5	Object
    //   126	21	3	str2	String
    //   31	68	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   104	5	4	localObject6	Object
    //   1	156	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	91	finally
    //   39	45	91	finally
    //   50	58	91	finally
    //   61	67	91	finally
    //   74	80	91	finally
    //   20	33	104	finally
    //   127	135	104	finally
    //   7	16	114	finally
    //   7	16	151	java/lang/Throwable
    //   20	33	155	java/lang/Throwable
    //   33	39	162	java/lang/Throwable
    //   39	45	162	java/lang/Throwable
    //   50	58	162	java/lang/Throwable
    //   61	67	162	java/lang/Throwable
    //   74	80	162	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] j(String paramString)
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_0
    //   15: new 135	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 4
    //   21: ldc 137
    //   23: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 144	java/io/RandomAccessFile:length	()J
    //   33: lstore_2
    //   34: lload_2
    //   35: l2i
    //   36: istore_1
    //   37: iload_1
    //   38: i2l
    //   39: lload_2
    //   40: lcmp
    //   41: ifne +25 -> 66
    //   44: iload_1
    //   45: newarray byte
    //   47: astore_0
    //   48: aload 4
    //   50: aload_0
    //   51: invokevirtual 147	java/io/RandomAccessFile:readFully	([B)V
    //   54: aload 4
    //   56: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: astore 4
    //   63: goto +64 -> 127
    //   66: new 61	java/io/IOException
    //   69: dup
    //   70: ldc 99
    //   72: invokespecial 149	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_0
    //   77: aload 4
    //   79: astore 5
    //   81: aload_0
    //   82: astore 4
    //   84: aload 5
    //   86: astore_0
    //   87: goto +47 -> 134
    //   90: goto +8 -> 98
    //   93: astore 4
    //   95: goto +39 -> 134
    //   98: aload 4
    //   100: astore_0
    //   101: iconst_0
    //   102: newarray byte
    //   104: astore 5
    //   106: aload 5
    //   108: astore_0
    //   109: aload 4
    //   111: ifnull +21 -> 132
    //   114: aload 4
    //   116: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   119: aload 5
    //   121: areturn
    //   122: astore 4
    //   124: aload 5
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   132: aload_0
    //   133: areturn
    //   134: aload_0
    //   135: ifnull +15 -> 150
    //   138: aload_0
    //   139: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   142: goto +8 -> 150
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   150: aload 4
    //   152: athrow
    //   153: astore_0
    //   154: aload 5
    //   156: astore 4
    //   158: goto -60 -> 98
    //   161: astore_0
    //   162: goto -72 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   36	9	1	i	int
    //   33	7	2	l	long
    //   8	47	4	localObject1	Object
    //   61	17	4	localIOException1	IOException
    //   82	1	4	str	String
    //   93	22	4	localObject2	Object
    //   122	29	4	localIOException2	IOException
    //   156	1	4	localObject3	Object
    //   11	144	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	61	java/io/IOException
    //   28	34	76	finally
    //   44	54	76	finally
    //   66	76	76	finally
    //   15	28	93	finally
    //   101	106	93	finally
    //   114	119	122	java/io/IOException
    //   138	142	145	java/io/IOException
    //   15	28	153	java/lang/Throwable
    //   28	34	161	java/lang/Throwable
    //   44	54	161	java/lang/Throwable
    //   66	76	161	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.abstract
 * JD-Core Version:    0.7.0.1
 */