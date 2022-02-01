package com.tencent.tbs.log.file;

import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption
{
  public static final String DEFAULT_TEXT_ENCODING = "UTF-8";
  public static final String LOG_ENCRYPTION_ALGORITHM = "RC4";
  
  public static String createKeyOfPlainText()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static byte[] encryptPlainText(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] getEncryptedKeyBytes(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      if (paramString1 == null) {
        return null;
      }
      paramString2 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] getEncryptedLogBytes(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic 93	com/tencent/tbs/log/file/Encryption:encryptPlainText	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +73 -> 85
    //   15: aload_2
    //   16: arraylength
    //   17: aload 4
    //   19: arraylength
    //   20: iadd
    //   21: iconst_2
    //   22: iadd
    //   23: newarray byte
    //   25: astore_0
    //   26: iconst_2
    //   27: newarray byte
    //   29: astore_1
    //   30: aload_1
    //   31: dup
    //   32: iconst_0
    //   33: ldc 94
    //   35: bastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 94
    //   40: bastore
    //   41: pop
    //   42: aload_2
    //   43: iconst_0
    //   44: aload_0
    //   45: iconst_0
    //   46: aload_2
    //   47: arraylength
    //   48: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   51: aload_2
    //   52: arraylength
    //   53: iconst_0
    //   54: iadd
    //   55: istore_3
    //   56: aload 4
    //   58: iconst_0
    //   59: aload_0
    //   60: iload_3
    //   61: aload 4
    //   63: arraylength
    //   64: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   67: aload_1
    //   68: iconst_0
    //   69: aload_0
    //   70: aload 4
    //   72: arraylength
    //   73: iload_3
    //   74: iadd
    //   75: aload_1
    //   76: arraylength
    //   77: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: areturn
    //   85: aload_1
    //   86: invokevirtual 97	java/lang/String:getBytes	()[B
    //   89: astore_0
    //   90: goto -10 -> 80
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString1	String
    //   0	99	1	paramString2	String
    //   0	99	2	paramArrayOfByte	byte[]
    //   55	20	3	i	int
    //   8	63	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	10	93	finally
    //   15	80	93	finally
    //   85	90	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.Encryption
 * JD-Core Version:    0.7.0.1
 */