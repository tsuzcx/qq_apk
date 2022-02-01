package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.weiyun.utils.Utils;

public class StringUtils
{
  public static ByteStringMicro a(String paramString)
  {
    return ByteStringMicro.copyFrom(Utils.hexStr2Bytes(paramString));
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    return Utils.bytes2HexStr(paramByteStringMicro.toByteArray());
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.StringUtils
 * JD-Core Version:    0.7.0.1
 */