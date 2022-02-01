package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.io.IOUtils;
import java.io.InputStream;

public class Coffee
{
  private static final String TAG = "Coffee";
  
  /* Error */
  public static byte[] drink(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 20
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 26	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: aload_0
    //   17: arraylength
    //   18: aload_1
    //   19: invokestatic 30	com/tencent/ttpic/util/Coffee:nDrink	([BILjava/lang/String;)[B
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +5 -> 29
    //   27: aload_0
    //   28: areturn
    //   29: aload_2
    //   30: iconst_0
    //   31: baload
    //   32: bipush 120
    //   34: if_icmpne +86 -> 120
    //   37: aload_2
    //   38: iconst_1
    //   39: baload
    //   40: bipush 156
    //   42: if_icmpne +78 -> 120
    //   45: new 32	java/util/zip/Inflater
    //   48: dup
    //   49: invokespecial 33	java/util/zip/Inflater:<init>	()V
    //   52: astore_0
    //   53: new 35	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 36	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore_1
    //   61: aload_0
    //   62: aload_2
    //   63: iconst_0
    //   64: aload_2
    //   65: arraylength
    //   66: invokevirtual 40	java/util/zip/Inflater:setInput	([BII)V
    //   69: sipush 1024
    //   72: newarray byte
    //   74: astore_2
    //   75: aload_0
    //   76: invokevirtual 44	java/util/zip/Inflater:finished	()Z
    //   79: ifne +26 -> 105
    //   82: aload_1
    //   83: aload_2
    //   84: iconst_0
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 48	java/util/zip/Inflater:inflate	([B)I
    //   90: invokevirtual 51	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -18 -> 75
    //   96: astore_1
    //   97: goto +17 -> 114
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 54	java/util/zip/DataFormatException:printStackTrace	()V
    //   105: aload_0
    //   106: invokevirtual 57	java/util/zip/Inflater:end	()V
    //   109: aload_1
    //   110: invokevirtual 61	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: areturn
    //   114: aload_0
    //   115: invokevirtual 57	java/util/zip/Inflater:end	()V
    //   118: aload_1
    //   119: athrow
    //   120: aload_2
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramArrayOfByte	byte[]
    //   0	122	1	paramString	String
    //   22	65	2	arrayOfByte	byte[]
    //   100	21	2	localDataFormatException	java.util.zip.DataFormatException
    // Exception table:
    //   from	to	target	type
    //   61	75	96	finally
    //   75	93	96	finally
    //   101	105	96	finally
    //   61	75	100	java/util/zip/DataFormatException
    //   75	93	100	java/util/zip/DataFormatException
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean)
  {
    return drinkACupOfCoffee(paramInputStream, paramBoolean, getDefaultSign());
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean, String paramString)
  {
    paramInputStream = IOUtils.toByteArray(paramInputStream);
    if (paramBoolean) {
      paramInputStream = drink_ios(paramInputStream, paramString);
    } else {
      paramInputStream = drink(paramInputStream, paramString);
    }
    return IOUtils.toInputStream(paramInputStream);
  }
  
  /* Error */
  public static byte[] drink_ios(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 20
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 26	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: aload_0
    //   17: arraylength
    //   18: aload_1
    //   19: invokestatic 87	com/tencent/ttpic/util/Coffee:nDrinkios	([BILjava/lang/String;)[B
    //   22: astore_2
    //   23: aload_2
    //   24: iconst_0
    //   25: baload
    //   26: bipush 120
    //   28: if_icmpne +86 -> 114
    //   31: aload_2
    //   32: iconst_1
    //   33: baload
    //   34: bipush 156
    //   36: if_icmpne +78 -> 114
    //   39: new 32	java/util/zip/Inflater
    //   42: dup
    //   43: invokespecial 33	java/util/zip/Inflater:<init>	()V
    //   46: astore_0
    //   47: new 35	java/io/ByteArrayOutputStream
    //   50: dup
    //   51: invokespecial 36	java/io/ByteArrayOutputStream:<init>	()V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_2
    //   57: iconst_0
    //   58: aload_2
    //   59: arraylength
    //   60: invokevirtual 40	java/util/zip/Inflater:setInput	([BII)V
    //   63: sipush 1024
    //   66: newarray byte
    //   68: astore_2
    //   69: aload_0
    //   70: invokevirtual 44	java/util/zip/Inflater:finished	()Z
    //   73: ifne +26 -> 99
    //   76: aload_1
    //   77: aload_2
    //   78: iconst_0
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 48	java/util/zip/Inflater:inflate	([B)I
    //   84: invokevirtual 51	java/io/ByteArrayOutputStream:write	([BII)V
    //   87: goto -18 -> 69
    //   90: astore_1
    //   91: goto +17 -> 108
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 54	java/util/zip/DataFormatException:printStackTrace	()V
    //   99: aload_0
    //   100: invokevirtual 57	java/util/zip/Inflater:end	()V
    //   103: aload_1
    //   104: invokevirtual 61	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: areturn
    //   108: aload_0
    //   109: invokevirtual 57	java/util/zip/Inflater:end	()V
    //   112: aload_1
    //   113: athrow
    //   114: aload_2
    //   115: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramArrayOfByte	byte[]
    //   0	116	1	paramString	String
    //   22	59	2	arrayOfByte	byte[]
    //   94	21	2	localDataFormatException	java.util.zip.DataFormatException
    // Exception table:
    //   from	to	target	type
    //   55	69	90	finally
    //   69	87	90	finally
    //   95	99	90	finally
    //   55	69	94	java/util/zip/DataFormatException
    //   69	87	94	java/util/zip/DataFormatException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.Coffee
 * JD-Core Version:    0.7.0.1
 */