package com.tencent.mobileqq.flashshow.utils;

import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  public static final SimpleDateFormat c = new SimpleDateFormat("yyyyMMddHHmm");
  public static final SimpleDateFormat d = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  private static final String e = "DateUtils";
  private static StringBuilder f = new StringBuilder(32);
  
  public static String a(int paramInt)
  {
    int i = paramInt / 1000;
    paramInt = i / 60;
    i %= 60;
    Object localObject;
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = String.valueOf(paramInt);
    }
    if (i < 10) {
      return String.format("%s:0%s", new Object[] { localObject, Integer.valueOf(i) });
    }
    return String.format("%s:%s", new Object[] { localObject, Integer.valueOf(i) });
  }
  
  public static String a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    String str2;
    try
    {
      localObject1 = FSHardCodeUtil.a(2131918185);
      String str1 = FSHardCodeUtil.a(2131918186);
      str2 = FSHardCodeUtil.a(2131918184);
    }
    catch (Exception localException)
    {
      localObject1 = FSHardCodeUtil.a(2131900988);
      QLog.d(e, 1, localException, new Object[0]);
      str2 = "%d小时前";
      localObject2 = "%d分钟前";
    }
    long l2 = (l1 - paramLong) / 1000L;
    if (l2 < 60L) {
      return localObject1;
    }
    if (l2 < 3600L) {
      return String.format((String)localObject2, new Object[] { Long.valueOf(l2 / 60L) });
    }
    if (l2 < 86400L) {
      return String.format(str2, new Object[] { Long.valueOf(l2 / 60L / 60L) });
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject1).get(5);
    int n = ((Calendar)localObject1).get(11);
    int i1 = ((Calendar)localObject1).get(12);
    int k = ((Calendar)localObject1).get(1);
    int i2 = ((Calendar)localObject1).get(2) + 1;
    int i4 = ((Calendar)localObject1).get(6);
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l1);
    int i3 = ((Calendar)localObject1).get(1);
    int i5 = ((Calendar)localObject1).get(6);
    int i;
    if (i3 != k)
    {
      int j = k;
      i = 0;
      while (j < i3)
      {
        if (((j % 4 == 0) && (j % 100 != 0)) || (j % 400 == 0)) {
          i += 366;
        } else {
          i += 365;
        }
        j += 1;
      }
      i += i5 - i4;
    }
    else
    {
      i = i5 - i4;
    }
    localObject1 = f;
    ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
    if (i == 1)
    {
      localObject2 = f;
      ((StringBuilder)localObject2).append("昨天");
      if (n < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(n);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(n);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(":");
      if (i1 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i1);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    if (i == 2)
    {
      localObject2 = f;
      ((StringBuilder)localObject2).append("前天");
      if (n < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(n);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(n);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(":");
      if (i1 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i1);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    if (i3 != k)
    {
      localObject2 = f;
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("-");
      if (i2 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i2);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("-");
      if (m < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(m);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(m);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = f;
    if (i2 < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(i2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(i2);
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("-");
    if (m < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(m);
    }
    ((StringBuilder)localObject2).append(localObject1);
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */