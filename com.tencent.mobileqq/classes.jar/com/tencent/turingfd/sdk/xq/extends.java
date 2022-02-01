package com.tencent.turingfd.sdk.xq;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class extends
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
    //   0: new 19	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 21	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 25	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 28	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 32	java/io/BufferedOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 35	java/io/BufferedOutputStream:flush	()V
    //   25: aload_0
    //   26: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: athrow
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_1
    //   50: goto -7 -> 43
    //   53: astore_1
    //   54: goto -20 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   0	57	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	16	31	finally
    //   0	16	40	java/lang/Throwable
    //   16	25	49	java/lang/Throwable
    //   16	25	53	finally
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
    catch (IOException paramFile) {}
    return null;
  }
  
  /* Error */
  public static byte[] c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 41	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 45	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 69	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: iload_1
    //   30: newarray byte
    //   32: astore 5
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
    //   71: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: iload_3
    //   77: iload_1
    //   78: if_icmpge +65 -> 143
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
    //   100: aload_0
    //   101: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   104: aload 5
    //   106: areturn
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: astore_0
    //   115: aload 5
    //   117: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore 5
    //   126: goto -11 -> 115
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore 5
    //   140: goto -8 -> 132
    //   143: goto -43 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramInt	int
    //   1	60	2	i	int
    //   47	46	3	j	int
    //   44	14	4	k	int
    //   32	93	5	localObject1	Object
    //   138	1	5	localThrowable	Throwable
    //   84	13	6	arrayOfByte	byte[]
    //   107	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	107	finally
    //   34	46	107	finally
    //   81	96	107	finally
    //   20	29	122	finally
    //   20	29	129	java/lang/Throwable
    //   29	34	138	java/lang/Throwable
    //   34	46	138	java/lang/Throwable
    //   81	96	138	java/lang/Throwable
  }
  
  /* Error */
  public static String d(File paramFile)
  {
    // Byte code:
    //   0: ldc 88
    //   2: astore_1
    //   3: new 90	java/io/BufferedReader
    //   6: dup
    //   7: new 92	java/io/FileReader
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 93	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   15: invokespecial 96	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 99	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_0
    //   31: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   40: aload_1
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   53: aload_1
    //   54: athrow
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull -25 -> 34
    //   62: aload_0
    //   63: invokestatic 37	com/tencent/turingfd/sdk/xq/extends:a	(Ljava/io/Closeable;)V
    //   66: ldc 88
    //   68: areturn
    //   69: astore_2
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: goto -29 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramFile	File
    //   2	39	1	localObject1	Object
    //   42	12	1	localObject2	Object
    //   73	1	1	localObject3	Object
    //   23	2	2	str	String
    //   69	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	19	42	finally
    //   3	19	55	java/lang/Throwable
    //   19	24	69	java/lang/Throwable
    //   19	24	73	finally
  }
  
  /* Error */
  public static byte[] h(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 69	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 104	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 108	java/io/FileInputStream:available	()I
    //   21: invokespecial 111	java/io/ByteArrayOutputStream:<init>	(I)V
    //   24: astore_3
    //   25: sipush 4096
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 116	java/io/InputStream:read	([B)I
    //   36: istore_1
    //   37: iconst_m1
    //   38: iload_1
    //   39: if_icmpeq +33 -> 72
    //   42: aload_3
    //   43: aload_2
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 121	java/io/OutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: new 61	java/io/IOException
    //   56: dup
    //   57: invokespecial 123	java/io/IOException:<init>	()V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   66: aload_3
    //   67: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aload_3
    //   73: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +13 -> 91
    //   81: aload_0
    //   82: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: invokestatic 79	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: areturn
    //   91: ldc 88
    //   93: invokevirtual 132	java/lang/String:getBytes	()[B
    //   96: astore_2
    //   97: goto -16 -> 81
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -41 -> 62
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_3
    //   109: goto -56 -> 53
    //   112: astore_2
    //   113: aconst_null
    //   114: astore 4
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: astore_3
    //   121: goto -59 -> 62
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: goto -76 -> 53
    //   132: astore_2
    //   133: goto -71 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   36	10	1	i	int
    //   3	41	2	arrayOfByte1	byte[]
    //   52	1	2	localThrowable1	Throwable
    //   61	10	2	localObject1	Object
    //   76	21	2	arrayOfByte2	byte[]
    //   100	1	2	localObject2	Object
    //   106	1	2	localThrowable2	Throwable
    //   112	16	2	localObject3	Object
    //   132	1	2	localObject4	Object
    //   1	126	3	localObject5	Object
    //   114	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	52	java/lang/Throwable
    //   31	37	52	java/lang/Throwable
    //   42	49	52	java/lang/Throwable
    //   72	77	52	java/lang/Throwable
    //   91	97	52	java/lang/Throwable
    //   53	61	61	finally
    //   13	25	100	finally
    //   13	25	106	java/lang/Throwable
    //   4	13	112	finally
    //   4	13	124	java/lang/Throwable
    //   25	31	132	finally
    //   31	37	132	finally
    //   42	49	132	finally
    //   72	77	132	finally
    //   91	97	132	finally
  }
  
  /* Error */
  public static byte[] i(String paramString)
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_0
    //   12: new 135	java/io/RandomAccessFile
    //   15: dup
    //   16: aload 4
    //   18: ldc 137
    //   20: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 4
    //   25: aload 4
    //   27: astore_0
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
    //   41: ifne +41 -> 82
    //   44: aload 4
    //   46: astore_0
    //   47: iload_1
    //   48: newarray byte
    //   50: astore 5
    //   52: aload 4
    //   54: astore_0
    //   55: aload 4
    //   57: aload 5
    //   59: invokevirtual 147	java/io/RandomAccessFile:readFully	([B)V
    //   62: aload 5
    //   64: astore_0
    //   65: aload 4
    //   67: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   70: aload 5
    //   72: areturn
    //   73: astore 4
    //   75: aload 4
    //   77: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   80: aload_0
    //   81: areturn
    //   82: aload 4
    //   84: astore_0
    //   85: new 61	java/io/IOException
    //   88: dup
    //   89: ldc 88
    //   91: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: astore_0
    //   96: aload 4
    //   98: astore_0
    //   99: iconst_0
    //   100: newarray byte
    //   102: astore 5
    //   104: aload 4
    //   106: ifnull +11 -> 117
    //   109: aload 5
    //   111: astore_0
    //   112: aload 4
    //   114: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   117: aload 5
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore 4
    //   124: goto -28 -> 96
    //   127: astore 5
    //   129: aload_0
    //   130: astore 4
    //   132: aload 5
    //   134: astore_0
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: astore 4
    //   149: aload 4
    //   151: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   154: goto -9 -> 145
    //   157: astore 5
    //   159: aload_0
    //   160: astore 4
    //   162: aload 5
    //   164: astore_0
    //   165: goto -30 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   36	12	1	i	int
    //   33	7	2	l	long
    //   8	58	4	localObject1	Object
    //   73	40	4	localIOException1	IOException
    //   122	19	4	str1	String
    //   147	3	4	localIOException2	IOException
    //   160	1	4	str2	String
    //   50	68	5	arrayOfByte	byte[]
    //   127	6	5	localObject2	Object
    //   157	6	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	70	73	java/io/IOException
    //   112	117	73	java/io/IOException
    //   28	34	95	java/lang/Throwable
    //   47	52	95	java/lang/Throwable
    //   55	62	95	java/lang/Throwable
    //   85	95	95	java/lang/Throwable
    //   12	25	120	java/lang/Throwable
    //   12	25	127	finally
    //   140	145	147	java/io/IOException
    //   28	34	157	finally
    //   47	52	157	finally
    //   55	62	157	finally
    //   85	95	157	finally
    //   99	104	157	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.extends
 * JD-Core Version:    0.7.0.1
 */