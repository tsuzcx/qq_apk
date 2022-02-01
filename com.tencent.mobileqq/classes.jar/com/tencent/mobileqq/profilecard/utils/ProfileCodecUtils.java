package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class ProfileCodecUtils
{
  public static final String ADDRESS_SEPARATOR = "-";
  public static final String CODE_NO_LIMIT = "0";
  private static final String TAG = "CodecUtils";
  
  public static String decodeRemoteCode(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder(6);
    while (paramLong != 0L) {
      try
      {
        localStringBuilder.append((char)(int)(paramLong % 256L));
        paramLong >>= 8;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CodecUtils", 1, "decodeRemoteCode fail.", localOutOfMemoryError);
        return "0";
      }
    }
    return localOutOfMemoryError.reverse().toString();
  }
  
  public static int encodeLocCode(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (!bool)
    {
      if (paramString.equals("0")) {
        return 0;
      }
      int k = paramString.length();
      int j = 0;
      while (i < k)
      {
        j += (paramString.charAt(i) << (k - 1 - i) * 8);
        i += 1;
      }
      return j;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils
 * JD-Core Version:    0.7.0.1
 */