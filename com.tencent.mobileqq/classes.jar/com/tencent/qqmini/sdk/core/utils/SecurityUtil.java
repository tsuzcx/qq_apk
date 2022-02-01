package com.tencent.qqmini.sdk.core.utils;

public class SecurityUtil
{
  private static char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String getFileSHA1(String paramString)
  {
    try
    {
      paramString = getHash(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static String getHash(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 49	java/io/BufferedInputStream
    //   5: dup
    //   6: new 51	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 57	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: invokestatic 63	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 69	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: ifle +13 -> 49
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 73	java/security/MessageDigest:update	([BII)V
    //   46: goto -17 -> 29
    //   49: aload_0
    //   50: invokevirtual 76	java/io/InputStream:close	()V
    //   53: aload_1
    //   54: invokevirtual 80	java/security/MessageDigest:digest	()[B
    //   57: invokestatic 84	com/tencent/qqmini/sdk/core/utils/SecurityUtil:toHexString	([B)Ljava/lang/String;
    //   60: areturn
    //   61: astore_3
    //   62: aload_0
    //   63: astore_1
    //   64: aload_3
    //   65: astore_0
    //   66: goto +6 -> 72
    //   69: astore_0
    //   70: aload_3
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 76	java/io/InputStream:close	()V
    //   80: goto +5 -> 85
    //   83: aload_0
    //   84: athrow
    //   85: goto -2 -> 83
    //   88: astore_0
    //   89: goto -36 -> 53
    //   92: astore_1
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramString1	String
    //   0	96	1	paramString2	String
    //   34	9	2	i	int
    //   1	40	3	arrayOfByte	byte[]
    //   61	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	61	finally
    //   29	35	61	finally
    //   39	46	61	finally
    //   2	18	69	finally
    //   49	53	88	java/io/IOException
    //   76	80	92	java/io/IOException
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(hexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.SecurityUtil
 * JD-Core Version:    0.7.0.1
 */