package com.tencent.turingfd.sdk.xq;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public class instanceof
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
  }
  
  public static boolean a(File paramFile)
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
    finally
    {
      try
      {
        File[] arrayOfFile;
        int j;
        int i;
        boolean bool = paramFile.delete();
        return bool;
      }
      finally {}
      paramFile = finally;
      return false;
    }
    arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 35	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 37	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 44	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 48	java/io/BufferedOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 51	java/io/BufferedOutputStream:flush	()V
    //   25: aload_0
    //   26: invokestatic 53	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/io/Closeable;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_0
    //   34: invokestatic 53	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/io/Closeable;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: astore_0
    //   40: goto -9 -> 31
    //   43: astore_1
    //   44: goto -11 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramString	String
    //   0	47	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	16	39	finally
    //   16	25	43	finally
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 56	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 59	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_3
    //   16: invokevirtual 63	java/io/FileInputStream:available	()I
    //   19: invokespecial 66	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore 4
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_3
    //   31: aload_0
    //   32: invokevirtual 72	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iconst_m1
    //   37: iload_1
    //   38: if_icmpeq +14 -> 52
    //   41: aload 4
    //   43: aload_0
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 77	java/io/OutputStream:write	([BII)V
    //   49: goto -19 -> 30
    //   52: aload 4
    //   54: invokevirtual 81	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +6 -> 65
    //   62: goto +9 -> 71
    //   65: ldc 83
    //   67: invokevirtual 88	java/lang/String:getBytes	()[B
    //   70: astore_0
    //   71: aload_3
    //   72: invokestatic 91	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   75: aload 4
    //   77: invokestatic 91	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: areturn
    //   82: astore_0
    //   83: aload 4
    //   85: astore_2
    //   86: goto +10 -> 96
    //   89: astore_0
    //   90: goto +6 -> 96
    //   93: astore_0
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_0
    //   97: athrow
    //   98: astore_0
    //   99: aload_3
    //   100: invokestatic 91	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   103: aload_2
    //   104: invokestatic 91	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   107: goto +5 -> 112
    //   110: aload_0
    //   111: athrow
    //   112: goto -2 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramString	String
    //   35	11	1	i	int
    //   1	103	2	localObject	Object
    //   10	90	3	localFileInputStream	FileInputStream
    //   22	62	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	82	finally
    //   30	36	82	finally
    //   41	49	82	finally
    //   52	58	82	finally
    //   65	71	82	finally
    //   11	24	89	finally
    //   2	11	93	finally
    //   96	98	98	finally
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    try
    {
      localFileInputStream = new FileInputStream(paramString);
    }
    finally
    {
      int i;
      label34:
      int k;
      int j;
      label109:
      label111:
      break label109;
    }
    try
    {
      paramString = new byte[paramInt];
      i = 0;
      k = localFileInputStream.read(paramString, i, paramInt - i);
      j = i;
      if (k != -1)
      {
        j = i + k;
        i = j;
        if (j < paramInt) {
          break label34;
        }
      }
      if (j == 0)
      {
        const.a(localFileInputStream);
        return null;
      }
      if (j < paramInt)
      {
        byte[] arrayOfByte = new byte[j];
        System.arraycopy(paramString, 0, arrayOfByte, 0, j);
        paramString = arrayOfByte;
      }
      const.a(localFileInputStream);
      return paramString;
    }
    finally
    {
      paramString = localFileInputStream;
      break label111;
    }
    paramString = null;
    const.a(paramString);
    return null;
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: new 16	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 110	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 112
    //   16: invokespecial 115	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 119	java/io/RandomAccessFile:length	()J
    //   26: lstore_2
    //   27: lload_2
    //   28: l2i
    //   29: istore_1
    //   30: iload_1
    //   31: i2l
    //   32: lload_2
    //   33: lcmp
    //   34: ifne +26 -> 60
    //   37: iload_1
    //   38: newarray byte
    //   40: astore 5
    //   42: aload 4
    //   44: aload 5
    //   46: invokevirtual 122	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload 5
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 123	java/io/RandomAccessFile:close	()V
    //   57: aload 5
    //   59: areturn
    //   60: new 108	java/io/IOException
    //   63: dup
    //   64: ldc 83
    //   66: invokespecial 124	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aconst_null
    //   71: astore 4
    //   73: iconst_0
    //   74: newarray byte
    //   76: astore 5
    //   78: aload 5
    //   80: astore_0
    //   81: aload 4
    //   83: ifnull +21 -> 104
    //   86: aload 5
    //   88: astore_0
    //   89: aload 4
    //   91: invokevirtual 123	java/io/RandomAccessFile:close	()V
    //   94: aload 5
    //   96: areturn
    //   97: astore 4
    //   99: aload 4
    //   101: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: aload 4
    //   109: ifnull +18 -> 127
    //   112: aload 4
    //   114: invokevirtual 123	java/io/RandomAccessFile:close	()V
    //   117: goto +10 -> 127
    //   120: astore 4
    //   122: aload 4
    //   124: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: goto -60 -> 70
    //   133: astore_0
    //   134: goto -61 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   29	9	1	i	int
    //   26	7	2	l	long
    //   19	71	4	localRandomAccessFile	java.io.RandomAccessFile
    //   97	16	4	localIOException1	java.io.IOException
    //   120	3	4	localIOException2	java.io.IOException
    //   40	55	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	57	97	java/io/IOException
    //   89	94	97	java/io/IOException
    //   73	78	106	finally
    //   112	117	120	java/io/IOException
    //   9	21	129	finally
    //   21	27	133	finally
    //   37	49	133	finally
    //   60	70	133	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.instanceof
 * JD-Core Version:    0.7.0.1
 */