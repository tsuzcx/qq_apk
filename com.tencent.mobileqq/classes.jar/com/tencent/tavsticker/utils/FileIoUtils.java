package com.tencent.tavsticker.utils;

import java.io.File;
import java.io.IOException;

public final class FileIoUtils
{
  private FileIoUtils()
  {
    throw new UnsupportedOperationException("you can't instantiate FileIoUtils");
  }
  
  private static boolean createOrExistsFile(File paramFile)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return false;
      if (paramFile.exists()) {
        return paramFile.isFile();
      }
      boolean bool2 = true;
      try
      {
        File localFile = paramFile.getParentFile();
        boolean bool1 = bool2;
        if (localFile != null)
        {
          bool1 = bool2;
          if (!localFile.exists()) {
            bool1 = localFile.mkdirs();
          }
        }
        if (bool1)
        {
          bool1 = paramFile.createNewFile();
          return bool1;
        }
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return false;
  }
  
  private static File getFileByPath(String paramString)
  {
    if (isSpace(paramString)) {
      return null;
    }
    return new File(paramString);
  }
  
  private static boolean isSpace(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return true;
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        if (!Character.isWhitespace(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static boolean writeFileFromBytesByStream(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_1
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: invokestatic 69	com/tencent/tavsticker/utils/FileIoUtils:createOrExistsFile	(Ljava/io/File;)Z
    //   14: ifne +8 -> 22
    //   17: iload 4
    //   19: istore_3
    //   20: iload_3
    //   21: ireturn
    //   22: aconst_null
    //   23: astore 6
    //   25: new 71	java/io/BufferedOutputStream
    //   28: dup
    //   29: new 73	java/io/FileOutputStream
    //   32: dup
    //   33: aload_0
    //   34: iload_2
    //   35: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   38: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore 5
    //   43: aload 5
    //   45: astore_0
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 83	java/io/BufferedOutputStream:write	([B)V
    //   52: iconst_1
    //   53: istore_3
    //   54: aload 5
    //   56: ifnull -36 -> 20
    //   59: aload 5
    //   61: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore 6
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload 6
    //   81: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   84: iload 4
    //   86: istore_3
    //   87: aload_1
    //   88: ifnull -68 -> 20
    //   91: aload_1
    //   92: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload 6
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 42	java/io/IOException:printStackTrace	()V
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
    //   73	33	6	localIOException1	IOException
    //   136	1	6	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   59	64	66	java/io/IOException
    //   25	43	73	java/io/IOException
    //   91	95	97	java/io/IOException
    //   25	43	104	finally
    //   112	116	118	java/io/IOException
    //   46	52	126	finally
    //   79	84	126	finally
    //   46	52	136	java/io/IOException
  }
  
  public static boolean writeFileFromBytesByStream(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return writeFileFromBytesByStream(getFileByPath(paramString), paramArrayOfByte, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.utils.FileIoUtils
 * JD-Core Version:    0.7.0.1
 */