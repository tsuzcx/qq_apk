package com.tencent.secprotocol.utils;

import java.util.HashMap;
import java.util.Map;

public class StringManager
{
  public static byte[] Txt2 = { 6, 120, -74, 67, 37, 123, 99, -11, 32, 48, -93, 65, 60, 58, 122, -8, 49, 117, -95, 83, 111 };
  private static Map<byte[], String> sCache = new HashMap();
  
  public static String get(byte[] paramArrayOfByte)
  {
    if (sCache.get(paramArrayOfByte) == null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
        i += 1;
      }
      sCache.put(paramArrayOfByte, new String(arrayOfByte));
    }
    return (String)sCache.get(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.utils.StringManager
 * JD-Core Version:    0.7.0.1
 */