package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Coffee
{
  private static final String TAG = Coffee.class.getSimpleName();
  
  public static byte[] drink(byte[] paramArrayOfByte, String paramString)
  {
    LogUtils.v("Coffee", "drink(), sign = %s", new Object[] { paramString });
    byte[] arrayOfByte = nDrink(paramArrayOfByte, paramArrayOfByte.length, paramString);
    if (arrayOfByte == null) {
      return paramArrayOfByte;
    }
    if ((arrayOfByte[0] == 120) && (arrayOfByte[1] == -100))
    {
      paramArrayOfByte = new Inflater();
      paramString = new ByteArrayOutputStream();
      try
      {
        paramArrayOfByte.setInput(arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = new byte[1024];
        while (!paramArrayOfByte.finished()) {
          paramString.write(arrayOfByte, 0, paramArrayOfByte.inflate(arrayOfByte));
        }
        return localDataFormatException;
      }
      catch (DataFormatException localDataFormatException)
      {
        localDataFormatException.printStackTrace();
        for (;;)
        {
          return paramString.toByteArray();
          paramArrayOfByte.end();
        }
      }
      finally
      {
        paramArrayOfByte.end();
      }
    }
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean)
  {
    return drinkACupOfCoffee(paramInputStream, paramBoolean, getDefaultSign());
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean, String paramString)
  {
    paramInputStream = IOUtils.toByteArray(paramInputStream);
    if (paramBoolean) {}
    for (paramInputStream = drink_ios(paramInputStream, paramString);; paramInputStream = drink(paramInputStream, paramString)) {
      return IOUtils.toInputStream(paramInputStream);
    }
  }
  
  /* Error */
  public static byte[] drink_ios(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc 26
    //   2: ldc 28
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 34	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: aload_0
    //   17: arraylength
    //   18: aload_1
    //   19: invokestatic 94	com/tencent/ttpic/util/Coffee:nDrinkios	([BILjava/lang/String;)[B
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: iconst_0
    //   27: baload
    //   28: bipush 120
    //   30: if_icmpne +78 -> 108
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_1
    //   37: baload
    //   38: bipush 156
    //   40: if_icmpne +68 -> 108
    //   43: new 40	java/util/zip/Inflater
    //   46: dup
    //   47: invokespecial 41	java/util/zip/Inflater:<init>	()V
    //   50: astore_0
    //   51: new 43	java/io/ByteArrayOutputStream
    //   54: dup
    //   55: invokespecial 44	java/io/ByteArrayOutputStream:<init>	()V
    //   58: astore_2
    //   59: aload_0
    //   60: aload_1
    //   61: iconst_0
    //   62: aload_1
    //   63: arraylength
    //   64: invokevirtual 48	java/util/zip/Inflater:setInput	([BII)V
    //   67: sipush 1024
    //   70: newarray byte
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 52	java/util/zip/Inflater:finished	()Z
    //   77: ifne +33 -> 110
    //   80: aload_2
    //   81: aload_1
    //   82: iconst_0
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 56	java/util/zip/Inflater:inflate	([B)I
    //   88: invokevirtual 59	java/io/ByteArrayOutputStream:write	([BII)V
    //   91: goto -18 -> 73
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 62	java/util/zip/DataFormatException:printStackTrace	()V
    //   99: aload_0
    //   100: invokevirtual 65	java/util/zip/Inflater:end	()V
    //   103: aload_2
    //   104: invokevirtual 69	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: astore_0
    //   108: aload_0
    //   109: areturn
    //   110: aload_0
    //   111: invokevirtual 65	java/util/zip/Inflater:end	()V
    //   114: goto -11 -> 103
    //   117: astore_1
    //   118: aload_0
    //   119: invokevirtual 65	java/util/zip/Inflater:end	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramArrayOfByte	byte[]
    //   0	124	1	paramString	String
    //   58	46	2	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   59	73	94	java/util/zip/DataFormatException
    //   73	91	94	java/util/zip/DataFormatException
    //   59	73	117	finally
    //   73	91	117	finally
    //   95	99	117	finally
  }
  
  @SoInfo(libName="pitu_tools")
  public static native String getDefaultSign();
  
  @SoInfo(libName="pitu_tools")
  public static native boolean isSign(String paramString);
  
  @SoInfo(libName="pitu_tools")
  public static native byte[] nDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  @SoInfo(libName="pitu_tools")
  private static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  @SoInfo(libName="pitu_tools")
  private static native byte[] nDrinkios(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  @SoInfo(libName="pitu_tools")
  public static native byte[] nEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.Coffee
 * JD-Core Version:    0.7.0.1
 */