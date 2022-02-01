package com.tencent.smtt.utils;

import java.io.InputStream;
import java.security.MessageDigest;

public class Md5Utils
{
  /* Error */
  public static String getMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 19
    //   4: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore_2
    //   8: goto +26 -> 34
    //   11: astore_0
    //   12: aload_3
    //   13: astore_2
    //   14: goto +82 -> 96
    //   17: aconst_null
    //   18: astore_0
    //   19: goto +95 -> 114
    //   22: aconst_null
    //   23: astore_0
    //   24: goto +107 -> 131
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 28	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   32: aconst_null
    //   33: astore_2
    //   34: new 30	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore_0
    //   43: sipush 8192
    //   46: newarray byte
    //   48: astore_3
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 37	java/io/FileInputStream:read	([B)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpeq +13 -> 70
    //   60: aload_2
    //   61: aload_3
    //   62: iconst_0
    //   63: iload_1
    //   64: invokevirtual 41	java/security/MessageDigest:update	([BII)V
    //   67: goto -18 -> 49
    //   70: aload_2
    //   71: invokevirtual 45	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 51	com/tencent/smtt/utils/ByteUtils:a	([B)Ljava/lang/String;
    //   77: astore_2
    //   78: aload_0
    //   79: invokevirtual 54	java/io/FileInputStream:close	()V
    //   82: aload_2
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: aload_0
    //   93: astore_2
    //   94: aload_3
    //   95: astore_0
    //   96: aload_2
    //   97: ifnull +15 -> 112
    //   100: aload_2
    //   101: invokevirtual 54	java/io/FileInputStream:close	()V
    //   104: goto +8 -> 112
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: athrow
    //   114: aload_0
    //   115: ifnull +14 -> 129
    //   118: aload_0
    //   119: invokevirtual 54	java/io/FileInputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: aload_0
    //   132: ifnull +14 -> 146
    //   135: aload_0
    //   136: invokevirtual 54	java/io/FileInputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: goto -127 -> 22
    //   152: astore_0
    //   153: goto -136 -> 17
    //   156: astore_2
    //   157: goto -26 -> 131
    //   160: astore_2
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramFile	java.io.File
    //   54	10	1	i	int
    //   7	7	2	localObject1	Object
    //   27	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   33	68	2	localObject2	Object
    //   107	2	2	localIOException1	java.io.IOException
    //   156	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   160	1	2	localIOException2	java.io.IOException
    //   1	61	3	arrayOfByte	byte[]
    //   91	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	11	finally
    //   28	32	11	finally
    //   34	43	11	finally
    //   2	8	27	java/security/NoSuchAlgorithmException
    //   78	82	84	java/io/IOException
    //   43	49	91	finally
    //   49	55	91	finally
    //   60	67	91	finally
    //   70	78	91	finally
    //   100	104	107	java/io/IOException
    //   118	122	124	java/io/IOException
    //   135	139	141	java/io/IOException
    //   2	8	148	java/io/FileNotFoundException
    //   28	32	148	java/io/FileNotFoundException
    //   34	43	148	java/io/FileNotFoundException
    //   2	8	152	java/io/IOException
    //   28	32	152	java/io/IOException
    //   34	43	152	java/io/IOException
    //   43	49	156	java/io/FileNotFoundException
    //   49	55	156	java/io/FileNotFoundException
    //   60	67	156	java/io/FileNotFoundException
    //   70	78	156	java/io/FileNotFoundException
    //   43	49	160	java/io/IOException
    //   49	55	160	java/io/IOException
    //   60	67	160	java/io/IOException
    //   70	78	160	java/io/IOException
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = ByteUtils.a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] getMD5(InputStream paramInputStream)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInputStream != null) {}
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject1 = localObject2;
      if (localMessageDigest != null)
      {
        localObject1 = new byte[8192];
        for (;;)
        {
          int i = paramInputStream.read((byte[])localObject1);
          if (i == -1) {
            break;
          }
          localMessageDigest.update((byte[])localObject1, 0, i);
        }
        localObject1 = localMessageDigest.digest();
      }
      return localObject1;
    }
    catch (Throwable paramInputStream) {}
    return null;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.Md5Utils
 * JD-Core Version:    0.7.0.1
 */