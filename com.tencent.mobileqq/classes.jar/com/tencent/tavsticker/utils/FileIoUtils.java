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
    boolean bool2 = false;
    if (paramFile == null) {
      return false;
    }
    if (paramFile.exists()) {
      return paramFile.isFile();
    }
    boolean bool3 = true;
    try
    {
      File localFile = paramFile.getParentFile();
      boolean bool1 = bool3;
      if (localFile != null)
      {
        bool1 = bool3;
        if (!localFile.exists()) {
          bool1 = localFile.mkdirs();
        }
      }
      if (bool1) {
        bool2 = paramFile.createNewFile();
      }
      return bool2;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
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
    if (paramString == null) {
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  public static boolean writeFileFromBytesByStream(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +113 -> 114
    //   4: aload_0
    //   5: invokestatic 69	com/tencent/tavsticker/utils/FileIoUtils:createOrExistsFile	(Ljava/io/File;)Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_3
    //   18: new 71	java/io/BufferedOutputStream
    //   21: dup
    //   22: new 73	java/io/FileOutputStream
    //   25: dup
    //   26: aload_0
    //   27: iload_2
    //   28: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_0
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 83	java/io/BufferedOutputStream:write	([B)V
    //   40: aload_0
    //   41: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   44: iconst_1
    //   45: ireturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_1
    //   54: aload_0
    //   55: astore_3
    //   56: aload_1
    //   57: astore_0
    //   58: goto +38 -> 96
    //   61: astore_1
    //   62: goto +11 -> 73
    //   65: astore_0
    //   66: goto +30 -> 96
    //   69: astore_1
    //   70: aload 4
    //   72: astore_0
    //   73: aload_0
    //   74: astore_3
    //   75: aload_1
    //   76: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: ifnull +14 -> 94
    //   83: aload_0
    //   84: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_3
    //   97: ifnull +15 -> 112
    //   100: aload_3
    //   101: invokevirtual 86	java/io/BufferedOutputStream:close	()V
    //   104: goto +8 -> 112
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 42	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: athrow
    //   114: iconst_0
    //   115: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramFile	File
    //   0	116	1	paramArrayOfByte	byte[]
    //   0	116	2	paramBoolean	boolean
    //   17	84	3	localFile	File
    //   14	57	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	46	java/io/IOException
    //   35	40	53	finally
    //   35	40	61	java/io/IOException
    //   18	35	65	finally
    //   75	79	65	finally
    //   18	35	69	java/io/IOException
    //   83	87	89	java/io/IOException
    //   100	104	107	java/io/IOException
  }
  
  public static boolean writeFileFromBytesByStream(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return writeFileFromBytesByStream(getFileByPath(paramString), paramArrayOfByte, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.utils.FileIoUtils
 * JD-Core Version:    0.7.0.1
 */