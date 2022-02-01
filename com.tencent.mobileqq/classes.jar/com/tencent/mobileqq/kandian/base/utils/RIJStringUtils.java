package com.tencent.mobileqq.kandian.base.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Properties;

public class RIJStringUtils
{
  private static final BigInteger a = BigInteger.ONE.shiftLeft(64);
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static String a(long paramLong)
  {
    long l = (paramLong >>> 1) / 5L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Long.toString(l));
    localStringBuilder.append(paramLong - 10L * l);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (DeviceInfoUtil.E() > 720L) {
      return a(paramString, 18);
    }
    return a(paramString, 24);
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      int j = 0;
      while (i < paramString.length())
      {
        int k = paramString.charAt(i);
        if (((97 <= k) && (k <= 122)) || ((65 <= k) && (k <= 90)) || ((48 <= k) && (k <= 57))) {
          j += 1;
        } else {
          j += 2;
        }
        if (j > paramInt)
        {
          j = 1;
          break label101;
        }
        i += 1;
      }
      j = 0;
      label101:
      localObject = paramString;
      if (j != 0)
      {
        j = i;
        if (i == paramInt) {
          j = i - 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, j));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static BigInteger b(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    if (paramLong >= 0L) {
      return localBigInteger;
    }
    return localBigInteger.add(a);
  }
  
  public static Properties b(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJStringUtils
 * JD-Core Version:    0.7.0.1
 */