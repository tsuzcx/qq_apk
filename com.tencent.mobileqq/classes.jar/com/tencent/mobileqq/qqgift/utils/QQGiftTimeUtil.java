package com.tencent.mobileqq.qqgift.utils;

import androidx.annotation.NonNull;

public class QQGiftTimeUtil
{
  @NonNull
  public static String a(long paramLong)
  {
    long l1 = paramLong / 3600000L;
    long l2 = paramLong - 3600000L * l1;
    paramLong = l2 / 60000L;
    l2 = (l2 - 60000L * paramLong) / 1000L;
    Object localObject;
    if (paramLong > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(paramLong);
    String str = ((StringBuilder)localObject).toString();
    if (l2 > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(l2);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(l2);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (l1 == 0L) {
      return String.format("%s:%s", new Object[] { str, localObject });
    }
    return String.format("%s:%s:%s", new Object[] { Long.valueOf(l1), str, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftTimeUtil
 * JD-Core Version:    0.7.0.1
 */