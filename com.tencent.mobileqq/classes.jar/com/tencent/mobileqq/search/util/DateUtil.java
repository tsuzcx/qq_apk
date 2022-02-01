package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
  public static final String a = HardCodeUtil.a(2131900944);
  public static final String b = HardCodeUtil.a(2131900970);
  public static final String c = HardCodeUtil.a(2131900943);
  public static final String d = HardCodeUtil.a(2131900942);
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return a;
    }
    StringBuilder localStringBuilder;
    if ((l >= 60L) && (l < 3600L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l / 60L);
      localStringBuilder.append(b);
      return localStringBuilder.toString();
    }
    if ((l >= 3600L) && (l < 86400L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l / 3600L);
      localStringBuilder.append(c);
      return localStringBuilder.toString();
    }
    if ((l >= 86400L) && (l < 432000L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l / 86400L);
      localStringBuilder.append(d);
      return localStringBuilder.toString();
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong * 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */