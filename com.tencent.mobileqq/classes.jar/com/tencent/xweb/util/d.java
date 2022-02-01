package com.tencent.xweb.util;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class d
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
    //   1: ifnull +99 -> 100
    //   4: iload_1
    //   5: ifle +95 -> 100
    //   8: aload_0
    //   9: invokevirtual 21	java/io/File:exists	()Z
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 23	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: iload_1
    //   28: i2l
    //   29: lstore_2
    //   30: lload_2
    //   31: aload_0
    //   32: invokevirtual 31	java/io/File:length	()J
    //   35: lcmp
    //   36: ifgt +6 -> 42
    //   39: goto +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 31	java/io/File:length	()J
    //   46: lstore_2
    //   47: aload 4
    //   49: lload_2
    //   50: l2i
    //   51: invokestatic 34	com/tencent/xweb/util/d:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   54: astore_0
    //   55: aload 4
    //   57: invokevirtual 38	java/io/FileInputStream:close	()V
    //   60: aload 4
    //   62: invokevirtual 38	java/io/FileInputStream:close	()V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: goto +7 -> 75
    //   71: astore_0
    //   72: aconst_null
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 38	java/io/FileInputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: aconst_null
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 38	java/io/FileInputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: goto -16 -> 87
    //   106: astore_0
    //   107: goto -17 -> 90
    //   110: astore 4
    //   112: aload_0
    //   113: areturn
    //   114: astore 4
    //   116: goto -31 -> 85
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile	File
    //   0	122	1	paramInt	int
    //   29	21	2	l	long
    //   25	71	4	localFileInputStream	java.io.FileInputStream
    //   110	1	4	localIOException1	java.io.IOException
    //   114	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   30	39	67	finally
    //   42	47	67	finally
    //   47	60	67	finally
    //   17	27	71	finally
    //   17	27	102	java/lang/Exception
    //   30	39	106	java/lang/Exception
    //   42	47	106	java/lang/Exception
    //   47	60	106	java/lang/Exception
    //   60	65	110	java/io/IOException
    //   80	85	114	java/io/IOException
    //   95	100	119	java/io/IOException
  }
  
  public static final String a(InputStream paramInputStream, int paramInt)
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
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return a(paramString, 102400);
    }
    return null;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    return (paramString1 != null) && (paramString2 != null) && (paramString2.equalsIgnoreCase(paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.d
 * JD-Core Version:    0.7.0.1
 */