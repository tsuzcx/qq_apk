package com.tencent.mobileqq.search.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return "刚刚";
    }
    if ((l >= 60L) && (l < 3600L)) {
      return l / 60L + "分钟前";
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return l / 3600L + "小时前";
    }
    if ((l >= 86400L) && (l < 432000L)) {
      return l / 86400L + "天前";
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong * 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */