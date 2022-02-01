package com.tencent.timi.game.ui.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class TimeUtils
{
  private static HashMap<String, SimpleDateFormat> a = new HashMap(5);
  private static long b = 0L;
  private static long c = 0L;
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return "星期六";
    case 6: 
      return "星期五";
    case 5: 
      return "星期四";
    case 4: 
      return "星期三";
    case 3: 
      return "星期二";
    case 2: 
      return "星期一";
    }
    return "星期天";
  }
  
  public static String a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(l1);
    long l2 = (((Calendar)localObject1).getTimeZone().getRawOffset() + paramLong) / 86400000L;
    long l3 = (((Calendar)localObject2).getTimeZone().getRawOffset() + l1) / 86400000L;
    if (l2 == l3)
    {
      l1 = (l1 - paramLong) / 60000L;
      if (l1 <= 2L) {
        return "刚刚";
      }
      if (l1 <= 60L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("分钟前");
        return ((StringBuilder)localObject1).toString();
      }
      if (l1 < 120L) {
        return "一小时前";
      }
      localObject1 = "";
    }
    else if (((Calendar)localObject1).get(1) != ((Calendar)localObject2).get(1))
    {
      localObject1 = a(paramLong, "yyyy-MM-dd ");
    }
    else
    {
      l1 = l3 - l2;
      if (l1 == 1L)
      {
        localObject1 = "昨天 ";
      }
      else if (l1 <= 7L)
      {
        localObject1 = a(((Calendar)localObject1).get(7));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = a(paramLong, "MM-dd ");
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(a(paramLong, "HH:mm"));
    return ((StringBuilder)localObject2).toString();
  }
  
  @Deprecated
  public static String a(long paramLong, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)a.get(paramString);
    SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
    if (localSimpleDateFormat2 == null)
    {
      localSimpleDateFormat1 = new SimpleDateFormat(paramString);
      a.put(paramString, localSimpleDateFormat1);
    }
    return localSimpleDateFormat1.format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.TimeUtils
 * JD-Core Version:    0.7.0.1
 */