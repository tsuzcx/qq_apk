package com.tencent.mobileqq.filemanager.util;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QQFileTimeUtils
{
  private static Calendar a = ;
  
  public static String a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(MessageCache.a() * 1000L);
    localCalendar2.setTimeInMillis(paramLong);
    int k = localCalendar1.get(1);
    int i = localCalendar1.get(6) - localCalendar2.get(6);
    int j = i;
    if (localCalendar2.get(1) != k)
    {
      localCalendar1 = (Calendar)localCalendar2.clone();
      do
      {
        j = i + localCalendar1.getActualMaximum(6);
        localCalendar1.add(1, 1);
        i = j;
      } while (localCalendar1.get(1) != k);
    }
    if (j <= 7) {
      return "7天内";
    }
    return a(paramLong, "yyyy年MM月");
  }
  
  private static String a(long paramLong, String paramString)
  {
    if (paramLong == 0L) {
      return "";
    }
    try
    {
      paramString = new SimpleDateFormat(paramString).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      label31:
      break label31;
    }
    paramString = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = paramString.format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    return null;
  }
  
  public static String b(long paramLong)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    int j = a.get(2);
    int k = a.get(5);
    a.setTimeInMillis(paramLong);
    int m = a.get(1);
    int n = a.get(2);
    int i1 = a.get(5);
    if (i != m) {
      return new SimpleDateFormat("yyyy-MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (j != n) {
      return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (k == i1) {
      return new SimpleDateFormat("HH:mm ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (k - i1 <= 1) {
      return HardCodeUtil.a(2131709678);
    }
    return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileTimeUtils
 * JD-Core Version:    0.7.0.1
 */