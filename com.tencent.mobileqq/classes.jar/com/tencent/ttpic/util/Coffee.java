package com.tencent.ttpic.util;

public class Coffee
{
  public static byte[] drink(byte[] paramArrayOfByte)
  {
    String str = getSignature();
    return nDrink(paramArrayOfByte, paramArrayOfByte.length, str);
  }
  
  public static native String getDefaultSign();
  
  private static String getSignature()
  {
    return getDefaultSign();
  }
  
  public static native boolean isSign(String paramString);
  
  private static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.Coffee
 * JD-Core Version:    0.7.0.1
 */