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
    int i = 0;
    int k = 0;
    int j = k;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        j = k;
      }
    }
    else {
      return j;
    }
    int m = paramString.length();
    j = 0;
    for (;;)
    {
      k = j;
      j = i;
      if (k >= m) {
        break;
      }
      int n = paramString.charAt(k);
      j = k + 1;
      i = (n << (m - 1 - k) * 8) + i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils
 * JD-Core Version:    0.7.0.1
 */