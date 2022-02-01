package com.tencent.qcircle.weseevideo.model.utils;

import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.Logger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  private static final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  private static String byteToArrayString(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(strDigits[paramByte]);
    localStringBuilder.append(strDigits[(i % 16)]);
    return localStringBuilder.toString();
  }
  
  private static String byteToString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(byteToArrayString(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getMD5Code(String paramString)
  {
    try
    {
      paramString = byteToString(MessageDigest.getInstance("MD5").digest(paramString.getBytes(Charset.defaultCharset())));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Logger.e(paramString);
    }
    return null;
  }
  
  @Nullable
  public static String getUrlStrMd5(String paramString)
  {
    try
    {
      paramString = getMD5Code(URLEncoder.encode(paramString, "utf-8"));
      return paramString;
    }
    catch (Exception paramString)
    {
      label12:
      break label12;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.MD5Util
 * JD-Core Version:    0.7.0.1
 */