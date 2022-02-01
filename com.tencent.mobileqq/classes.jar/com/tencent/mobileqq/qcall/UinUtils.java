package com.tencent.mobileqq.qcall;

import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;

public class UinUtils
{
  public static long a(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      label14:
      String str;
      StringBuilder localStringBuilder;
      break label14;
    }
    if (QLog.isColorLevel())
    {
      str = UinUtils.class.getSimpleName();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to long:");
      localStringBuilder.append(paramString);
      QLog.w(str, 2, localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static String a(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  public static String a(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      label14:
      String str;
      StringBuilder localStringBuilder;
      break label14;
    }
    if (QLog.isColorLevel())
    {
      str = UinUtils.class.getSimpleName();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed getLong, uin = ");
      localStringBuilder.append(paramString);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int j = paramString.length() - 4;
    int k = j - 4;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = k;
    if (k < 0) {
      j = 0;
    }
    if ((j < i) && (i > 0)) {
      localStringBuffer.replace(j, i, "*");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.UinUtils
 * JD-Core Version:    0.7.0.1
 */