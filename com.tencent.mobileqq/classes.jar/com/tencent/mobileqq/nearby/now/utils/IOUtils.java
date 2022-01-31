package com.tencent.mobileqq.nearby.now.utils;

import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
{
  public static long a(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int j = -1;
    if ((paramInt > 0) && (paramInt <= 8))
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(paramInt);
      }
      int i = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (i <= 0) {
        return -1L;
      }
      if (paramBoolean)
      {
        paramInt = k;
        if (!paramBoolean) {
          break label108;
        }
      }
      long l;
      for (;;)
      {
        if (paramBoolean) {
          j = 1;
        }
        l = 0L;
        while (paramInt != i)
        {
          l = l << 8 | arrayOfByte[paramInt] & 0xFF;
          paramInt += j;
        }
        paramInt = i - 1;
        break;
        label108:
        i = -1;
      }
      return l;
    }
    throw new IllegalArgumentException("length must between 1 and 8.");
  }
  
  public static long a(InputStream paramInputStream, boolean paramBoolean)
  {
    return a(paramInputStream, 4, paramBoolean);
  }
  
  public static void a(OutputStream paramOutputStream, long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      paramOutputStream.write(a(paramLong, paramInt, paramBoolean));
      paramOutputStream.flush();
      return;
    }
    throw new IllegalArgumentException("length must between 1 and 8.");
  }
  
  public static void a(OutputStream paramOutputStream, long paramLong, boolean paramBoolean)
  {
    a(paramOutputStream, paramLong, 4, paramBoolean);
  }
  
  public static byte[] a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int j = -1;
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    if (paramBoolean)
    {
      i = paramInt - 1;
      if (paramBoolean) {
        paramInt = -1;
      }
      if (!paramBoolean) {
        break label66;
      }
    }
    for (;;)
    {
      if (i == paramInt) {
        break label72;
      }
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong));
      paramLong >>>= 8;
      i += j;
      continue;
      i = 0;
      break;
      label66:
      j = 1;
    }
    label72:
    return arrayOfByte;
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 65	java/io/File:isFile	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore 4
    //   16: ldc 67
    //   18: invokestatic 73	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   21: astore_3
    //   22: new 75	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: aload 4
    //   36: iconst_0
    //   37: sipush 1024
    //   40: invokevirtual 79	java/io/FileInputStream:read	([BII)I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_m1
    //   46: if_icmpeq +36 -> 82
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_1
    //   56: invokevirtual 83	java/security/MessageDigest:update	([BII)V
    //   59: goto -28 -> 31
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   69: aload_2
    //   70: ifnull -63 -> 7
    //   73: aload_2
    //   74: invokevirtual 89	java/io/FileInputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 89	java/io/FileInputStream:close	()V
    //   90: aload_3
    //   91: invokevirtual 93	java/security/MessageDigest:digest	()[B
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 89	java/io/FileInputStream:close	()V
    //   106: aload_2
    //   107: athrow
    //   108: astore_0
    //   109: goto -19 -> 90
    //   112: astore_0
    //   113: goto -7 -> 106
    //   116: astore_2
    //   117: goto -19 -> 98
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: goto -60 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramFile	java.io.File
    //   43	13	1	i	int
    //   30	57	2	localFileInputStream	java.io.FileInputStream
    //   95	12	2	localObject1	Object
    //   116	1	2	localObject2	Object
    //   122	1	2	localObject3	Object
    //   21	31	3	localMessageDigest	java.security.MessageDigest
    //   62	29	3	localException1	java.lang.Exception
    //   120	1	3	localException2	java.lang.Exception
    //   14	39	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	44	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   16	31	95	finally
    //   86	90	108	java/io/IOException
    //   102	106	112	java/io/IOException
    //   33	44	116	finally
    //   51	59	116	finally
    //   65	69	116	finally
    //   16	31	120	java/lang/Exception
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt)
  {
    Object localObject;
    if (paramInt <= 0) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      int i = 0;
      byte[] arrayOfByte = new byte[paramInt];
      localObject = arrayOfByte;
      if (i >= paramInt) {
        continue;
      }
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        localObject = arrayOfByte;
        if (j <= 0) {
          continue;
        }
        i += j;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */