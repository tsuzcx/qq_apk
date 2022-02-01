package com.tencent.tgpa.vendorpd.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class f
{
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new File(paramString);
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return false;
      if ((paramFile.exists()) && (paramFile.isFile())) {
        return true;
      }
    } while (!b(paramFile.getParentFile()));
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_1
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: invokestatic 42	com/tencent/tgpa/vendorpd/a/f:a	(Ljava/io/File;)Z
    //   14: ifne +8 -> 22
    //   17: iload 4
    //   19: istore_3
    //   20: iload_3
    //   21: ireturn
    //   22: aconst_null
    //   23: astore 6
    //   25: new 44	java/io/BufferedOutputStream
    //   28: dup
    //   29: new 46	java/io/FileOutputStream
    //   32: dup
    //   33: aload_0
    //   34: iload_2
    //   35: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   38: invokespecial 52	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore 5
    //   43: aload 5
    //   45: astore_0
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 56	java/io/BufferedOutputStream:write	([B)V
    //   52: iconst_1
    //   53: istore_3
    //   54: aload 5
    //   56: ifnull -36 -> 20
    //   59: aload 5
    //   61: invokevirtual 59	java/io/BufferedOutputStream:close	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore 6
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload 6
    //   81: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   84: iload 4
    //   86: istore_3
    //   87: aload_1
    //   88: ifnull -68 -> 20
    //   91: aload_1
    //   92: invokevirtual 59	java/io/BufferedOutputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload 6
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 59	java/io/BufferedOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore 5
    //   128: aload_0
    //   129: astore_1
    //   130: aload 5
    //   132: astore_0
    //   133: goto -25 -> 108
    //   136: astore 6
    //   138: aload 5
    //   140: astore_1
    //   141: goto -64 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramFile	File
    //   0	144	1	paramArrayOfByte	byte[]
    //   0	144	2	paramBoolean	boolean
    //   5	82	3	bool1	boolean
    //   1	84	4	bool2	boolean
    //   41	19	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   126	13	5	localObject1	Object
    //   23	1	6	localObject2	Object
    //   73	33	6	localException1	Exception
    //   136	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   59	64	66	java/io/IOException
    //   25	43	73	java/lang/Exception
    //   91	95	97	java/io/IOException
    //   25	43	104	finally
    //   112	116	118	java/io/IOException
    //   46	52	126	finally
    //   79	84	126	finally
    //   46	52	136	java/lang/Exception
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    return a(a(paramString), paramArrayOfByte, false);
  }
  
  public static boolean b(File paramFile)
  {
    if (paramFile != null) {
      if (paramFile.exists())
      {
        if (!paramFile.isDirectory()) {}
      }
      else {
        while (paramFile.mkdirs()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return b(a(paramString));
  }
  
  public static String c(File paramFile)
  {
    if (!d(paramFile)) {
      return null;
    }
    try
    {
      paramFile = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile)));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramFile.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append("\n");
      }
      paramFile = localStringBuilder.toString();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return paramFile;
  }
  
  public static String c(String paramString)
  {
    return c(a(paramString));
  }
  
  public static boolean d(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }
  
  public static boolean d(String paramString)
  {
    return d(a(paramString));
  }
  
  public static boolean e(File paramFile)
  {
    return (paramFile != null) && (paramFile.isDirectory());
  }
  
  public static boolean e(String paramString)
  {
    return e(a(paramString));
  }
  
  public static boolean f(File paramFile)
  {
    return (paramFile != null) && ((!paramFile.exists()) || ((paramFile.isFile()) && (paramFile.delete())));
  }
  
  public static boolean f(String paramString)
  {
    return (paramString != null) && (f(a(paramString)));
  }
  
  public static String g(File paramFile)
  {
    if (paramFile != null) {
      return paramFile.getName();
    }
    return null;
  }
  
  public static String g(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return g(a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.f
 * JD-Core Version:    0.7.0.1
 */