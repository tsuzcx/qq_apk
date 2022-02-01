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
    //   8: new 27	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: sipush 8192
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 34	java/io/FileInputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: aload_2
    //   37: aload 4
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 38	java/security/MessageDigest:update	([BII)V
    //   44: goto -20 -> 24
    //   47: astore_2
    //   48: aload_3
    //   49: astore_2
    //   50: aload_0
    //   51: ifnull +9 -> 60
    //   54: aload_0
    //   55: invokevirtual 41	java/io/FileInputStream:close	()V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 44	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   67: aconst_null
    //   68: astore_2
    //   69: goto -61 -> 8
    //   72: aload_2
    //   73: invokevirtual 48	java/security/MessageDigest:digest	()[B
    //   76: invokestatic 54	com/tencent/smtt/utils/ByteUtils:a	([B)Ljava/lang/String;
    //   79: astore_2
    //   80: aload_2
    //   81: astore_3
    //   82: aload_3
    //   83: astore_2
    //   84: aload_0
    //   85: ifnull -25 -> 60
    //   88: aload_0
    //   89: invokevirtual 41	java/io/FileInputStream:close	()V
    //   92: aload_3
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   99: aload_3
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_3
    //   112: astore_2
    //   113: aload_0
    //   114: ifnull -54 -> 60
    //   117: aload_0
    //   118: invokevirtual 41	java/io/FileInputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 41	java/io/FileInputStream:close	()V
    //   141: aload_2
    //   142: athrow
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   148: goto -7 -> 141
    //   151: astore_2
    //   152: goto -19 -> 133
    //   155: astore_2
    //   156: goto -45 -> 111
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -114 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramFile	java.io.File
    //   30	11	1	i	int
    //   7	30	2	localMessageDigest	MessageDigest
    //   47	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   49	12	2	localObject1	Object
    //   62	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   68	45	2	localObject2	Object
    //   130	12	2	localObject3	Object
    //   151	1	2	localObject4	Object
    //   155	1	2	localIOException	java.io.IOException
    //   1	111	3	localObject5	Object
    //   22	16	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	47	java/io/FileNotFoundException
    //   24	31	47	java/io/FileNotFoundException
    //   36	44	47	java/io/FileNotFoundException
    //   72	80	47	java/io/FileNotFoundException
    //   2	8	62	java/security/NoSuchAlgorithmException
    //   88	92	94	java/io/IOException
    //   54	58	101	java/io/IOException
    //   2	8	108	java/io/IOException
    //   8	17	108	java/io/IOException
    //   63	67	108	java/io/IOException
    //   117	121	123	java/io/IOException
    //   2	8	130	finally
    //   8	17	130	finally
    //   63	67	130	finally
    //   137	141	143	java/io/IOException
    //   17	24	151	finally
    //   24	31	151	finally
    //   36	44	151	finally
    //   72	80	151	finally
    //   17	24	155	java/io/IOException
    //   24	31	155	java/io/IOException
    //   36	44	155	java/io/IOException
    //   72	80	155	java/io/IOException
    //   2	8	159	java/io/FileNotFoundException
    //   8	17	159	java/io/FileNotFoundException
    //   63	67	159	java/io/FileNotFoundException
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
    if (paramInputStream != null) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null)
        {
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
          paramInputStream = localMessageDigest.digest();
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream) {}
    }
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
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.utils.Md5Utils
 * JD-Core Version:    0.7.0.1
 */