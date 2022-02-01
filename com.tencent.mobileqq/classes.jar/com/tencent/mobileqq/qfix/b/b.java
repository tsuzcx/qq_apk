package com.tencent.mobileqq.qfix.b;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class b
{
  public static String a(File paramFile)
  {
    return a(paramFile, 102400);
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +89 -> 90
    //   4: iload_1
    //   5: ifle +85 -> 90
    //   8: aload_0
    //   9: invokevirtual 23	java/io/File:exists	()Z
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 25	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: iload_1
    //   28: i2l
    //   29: lstore_2
    //   30: lload_2
    //   31: aload_0
    //   32: invokevirtual 32	java/io/File:length	()J
    //   35: lcmp
    //   36: ifgt +6 -> 42
    //   39: goto +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 32	java/io/File:length	()J
    //   46: lstore_2
    //   47: aload 4
    //   49: lload_2
    //   50: l2i
    //   51: invokestatic 35	com/tencent/mobileqq/qfix/b/b:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   54: astore_0
    //   55: aload 4
    //   57: invokevirtual 38	java/io/FileInputStream:close	()V
    //   60: aload 4
    //   62: invokestatic 43	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: goto +7 -> 75
    //   71: astore_0
    //   72: aconst_null
    //   73: astore 4
    //   75: aload 4
    //   77: invokestatic 43	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   80: aload_0
    //   81: athrow
    //   82: aconst_null
    //   83: astore 4
    //   85: aload 4
    //   87: invokestatic 43	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: goto -11 -> 82
    //   96: astore_0
    //   97: goto -12 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramFile	File
    //   0	100	1	paramInt	int
    //   29	21	2	l	long
    //   25	61	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   30	39	67	finally
    //   42	47	67	finally
    //   47	60	67	finally
    //   17	27	71	finally
    //   17	27	92	java/lang/Exception
    //   30	39	96	java/lang/Exception
    //   42	47	96	java/lang/Exception
    //   47	60	96	java/lang/Exception
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 48	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 49	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: aload_2
    //   12: aload_1
    //   13: invokevirtual 53	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +16 -> 34
    //   21: aload_2
    //   22: invokevirtual 54	java/util/zip/ZipFile:close	()V
    //   25: aconst_null
    //   26: areturn
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_2
    //   35: astore_0
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 61	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   41: ldc 12
    //   43: invokestatic 35	com/tencent/mobileqq/qfix/b/b:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_2
    //   48: invokevirtual 54	java/util/zip/ZipFile:close	()V
    //   51: aload_1
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   58: aload_1
    //   59: areturn
    //   60: astore_0
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: goto +12 -> 77
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: goto +30 -> 101
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload_2
    //   80: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: ifnull +14 -> 98
    //   87: aload_1
    //   88: invokevirtual 54	java/util/zip/ZipFile:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload_0
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: invokevirtual 54	java/util/zip/ZipFile:close	()V
    //   109: goto +8 -> 117
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramFile	File
    //   0	119	1	paramString	String
    //   8	57	2	localObject	Object
    //   74	6	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	25	27	java/io/IOException
    //   47	51	53	java/io/IOException
    //   11	17	60	java/io/IOException
    //   36	47	60	java/io/IOException
    //   0	9	68	finally
    //   0	9	74	java/io/IOException
    //   87	91	93	java/io/IOException
    //   11	17	100	finally
    //   36	47	100	finally
    //   79	83	100	finally
    //   105	109	112	java/io/IOException
  }
  
  public static String a(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream != null) {
      if (paramInt <= 0) {
        return null;
      }
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        paramInt = 0;
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
    return null;
  }
  
  public static String a(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInputStream, paramInt1, paramInt2, paramInt3, null);
  }
  
  public static String a(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    long l;
    if ((paramInputStream != null) && (paramInt1 > 0) && (paramInt2 >= 0))
    {
      if (paramInt3 <= 0) {
        return null;
      }
      l = paramInt2;
    }
    try
    {
      if (paramInputStream.skip(l) < l) {
        return null;
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt1];
      paramInt2 = 0;
      paramInt1 = 0;
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if ((j == -1) || (paramInt1 >= paramInt3)) {
          break;
        }
        int i = paramInt1 + j;
        if (i <= paramInt3)
        {
          localMessageDigest.update(arrayOfByte, 0, j);
          paramInt1 = i;
        }
        else
        {
          localMessageDigest.update(arrayOfByte, 0, paramInt3 - paramInt1);
          paramInt1 = paramInt3;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMessageDigest.update(paramArrayOfByte);
      }
      paramInputStream = localMessageDigest.digest();
      paramInt1 = paramInt2;
      while (paramInt1 < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt1] & 0xFF) + 256, 16).substring(1));
        paramInt1 += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.b
 * JD-Core Version:    0.7.0.1
 */