package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqcommon.api.ILocalManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeFormatterUtils
{
  private static Calendar a;
  private static StringBuffer b;
  private static int c;
  private static int d;
  private static java.text.DateFormat e;
  private static java.text.DateFormat f;
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(paramInt1, paramInt2, paramInt3);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(paramInt4, paramInt5, paramInt6);
    return (int)((localGregorianCalendar1.getTimeInMillis() - localGregorianCalendar2.getTimeInMillis()) / 1000L / 60L / 60L / 24L);
  }
  
  public static int a(long paramLong)
  {
    a.setTimeInMillis(paramLong + d);
    return a.get(11);
  }
  
  public static int a(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = new Time();
    paramCalendar.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime = new Time();
    localTime.set(l);
    int j = localTime.yearDay - 1;
    int k = localTime.yearDay;
    int m = paramCalendar.year;
    int n = localTime.year;
    int i = 2131897702;
    if (m == n)
    {
      if (localTime.yearDay < paramCalendar.yearDay) {
        return -1;
      }
      if (localTime.yearDay == paramCalendar.yearDay) {
        return 2131897728;
      }
      if (paramCalendar.yearDay != j) {}
    }
    do
    {
      return 2131897736;
      if ((paramCalendar.yearDay >= j) || (paramCalendar.yearDay <= k - 7)) {
        break;
      }
      switch (paramCalendar.weekDay)
      {
      default: 
        break label301;
        if (paramCalendar.year + 1 != localTime.year) {
          break label301;
        }
        paramLong = (l - paramLong + 86400000L - 1L) / 86400000L;
        if ((paramLong <= 0L) || (paramLong > 7L)) {
          break label301;
        }
      }
    } while (paramLong == 1L);
    switch (paramCalendar.weekDay)
    {
    default: 
      break;
    case 5: 
      return 2131897634;
    case 4: 
      return 2131897727;
    case 3: 
      return 2131897733;
    case 2: 
      return 2131897732;
    case 1: 
      return 2131897637;
    case 0: 
      return 2131897725;
      label301:
      i = -1;
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      if (paramString != null)
      {
        long l = paramString.getTime();
        return l;
      }
    }
    catch (ParseException paramString)
    {
      if (QLog.isColorLevel()) {
        paramString.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, paramLong, true);
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localSimpleDateFormat = (SimpleDateFormat)b();
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      SimpleDateFormat localSimpleDateFormat;
      label20:
      break label20;
    }
    localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    if (paramInt == 0)
    {
      localStringBuilder.append(localSimpleDateFormat.toLocalizedPattern());
      paramContext = new StringBuilder();
      localStringBuilder.append(" ");
      paramContext.append(android.text.format.DateFormat.format(localStringBuilder.toString(), paramLong));
      paramContext.append(c().format(Long.valueOf(paramLong)));
      return paramContext.toString();
    }
    return a(paramContext, paramLong, localStringBuilder, localSimpleDateFormat, paramInt, paramBoolean);
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (a == null) {
      a = Calendar.getInstance();
    }
    a.setTimeInMillis(paramLong);
    int i = a.get(2);
    int j = a.get(5);
    return String.format("%s%s%s%s", new Object[] { Integer.valueOf(i + 1), paramContext.getString(2131897638), Integer.valueOf(j), paramContext.getString(2131897630) });
  }
  
  private static CharSequence a(Context paramContext, long paramLong, StringBuilder paramStringBuilder, SimpleDateFormat paramSimpleDateFormat, int paramInt, boolean paramBoolean)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    Time localTime2 = new Time();
    localTime2.setToNow();
    int m = 0;
    int i;
    if ((paramInt & 0x2) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramInt & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt & 0x4) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (localTime1.year != localTime2.year)
    {
      paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern());
      paramStringBuilder.append(" ");
      paramInt = m;
    }
    else if (localTime1.yearDay != localTime2.yearDay)
    {
      int n = Math.abs(localTime2.yearDay - localTime1.yearDay);
      int k;
      if (localTime2.yearDay > localTime1.yearDay) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 0)
      {
        paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern());
        paramStringBuilder.append(" ");
        paramInt = m;
      }
      else
      {
        if ((n == 1) && (j != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131897736));
          paramStringBuilder.append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          paramContext = new StringBuilder();
          paramContext.append(paramStringBuilder.toString());
          paramContext.append(c().format(Long.valueOf(paramLong)));
          return paramContext.toString();
        }
        if ((n == 2) && (paramInt != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131897621));
          paramStringBuilder.append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          paramContext = new StringBuilder();
          paramContext.append(paramStringBuilder.toString());
          paramContext.append(c().format(Long.valueOf(paramLong)));
          return paramContext.toString();
        }
        if ((n > 1) && (n < 7) && (i != 0))
        {
          paramStringBuilder.append("EEEE");
          paramStringBuilder.append(" ");
          paramInt = m;
        }
        else if (localTime1.year == localTime2.year)
        {
          paramStringBuilder.append("MM-dd");
          paramStringBuilder.append(" ");
          paramInt = m;
        }
        else
        {
          paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern());
          paramStringBuilder.append(" ");
          paramInt = m;
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    if ((paramInt == 0) && (!paramBoolean)) {
      return android.text.format.DateFormat.format(paramStringBuilder.toString().trim(), paramLong);
    }
    paramContext = new StringBuilder();
    paramContext.append(android.text.format.DateFormat.format(paramStringBuilder.toString(), paramLong));
    paramContext.append(c().format(Long.valueOf(paramLong)));
    return paramContext.toString();
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 86400000) {
      return "unknown";
    }
    float f1 = paramInt;
    int i = (int)(f1 / 3600000.0F);
    int j = (int)(f1 % 3600000.0F / 60000.0F);
    if (paramBoolean) {
      paramInt = Math.round(f1 % 60000.0F / 1000.0F);
    } else {
      paramInt = (int)(f1 % 60000.0F / 1000.0F);
    }
    if (i > 0) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean, String paramString)
  {
    return a(b, paramLong, paramBoolean, paramString);
  }
  
  public static String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    int j = a.get(2);
    int k = a.get(6);
    a.setTimeInMillis(paramLong);
    i = b(i, j, k, a.get(1), a.get(2), a.get(6));
    String str = "HH:mm:ss";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return null;
            }
            if (paramBoolean) {
              str = "yyyy-MM-dd HH:mm:ss";
            } else {
              str = "yyyy-MM-dd HH:mm";
            }
            return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
          }
          if (paramBoolean) {
            str = "MM-dd HH:mm:ss";
          } else {
            str = "MM-dd HH:mm";
          }
          return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
        }
        if (!paramBoolean) {
          str = "HH:mm";
        }
        paramContext = new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale);
        return String.format("%s %s", new Object[] { HardCodeUtil.a(2131897718), paramContext.format(new Date(paramLong)) });
      }
      if (!paramBoolean) {
        str = "HH:mm";
      }
      paramContext = new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { HardCodeUtil.a(2131897712), paramContext.format(new Date(paramLong)) });
    }
    if (!paramBoolean) {
      str = "HH:mm";
    }
    return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static String a(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    Object localObject2;
    int n;
    int m;
    Object localObject1;
    if (paramStringBuffer != null)
    {
      int i = 0;
      paramStringBuffer.setLength(0);
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(paramLong);
      int k = a(paramLong, (Calendar)localObject2);
      if (k != -1)
      {
        j = 1;
        i = j;
        if (k != 2131897728)
        {
          paramStringBuffer.append(BaseApplication.getContext().getString(k));
          i = j;
        }
      }
      n = ((Calendar)localObject2).get(11);
      int j = 12;
      m = ((Calendar)localObject2).get(12);
      if (i != 0)
      {
        boolean bool = android.text.format.DateFormat.is24HourFormat(BaseApplication.getContext());
        if (k == 2131897728)
        {
          if (!bool)
          {
            localObject1 = BaseApplication.getContext().getString(2131897616);
            paramString = (String)localObject1;
            if (n >= 0)
            {
              paramString = (String)localObject1;
              if (n < 12) {
                paramString = BaseApplication.getContext().getString(2131897703);
              }
            }
            if (n == 12) {
              i = j;
            } else {
              i = n % 12;
            }
            localObject2 = String.valueOf(m);
            localObject1 = localObject2;
            if (m < 10)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("0");
              ((StringBuilder)localObject1).append((String)localObject2);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject2).toString();
            if (((ILocalManagerApi)QRoute.api(ILocalManagerApi.class)).isLocaleCN())
            {
              paramStringBuffer.append(paramString);
              paramStringBuffer.append((String)localObject1);
            }
            else
            {
              paramStringBuffer.append((String)localObject1);
              paramStringBuffer.append(paramString);
            }
          }
          else
          {
            paramStringBuffer.append(n);
            paramStringBuffer.append(':');
            if (m < 10) {
              paramStringBuffer.append('0');
            }
            paramStringBuffer.append(m);
          }
        }
        else if (!paramBoolean)
        {
          paramStringBuffer.append(' ');
          paramStringBuffer.append(n);
          paramStringBuffer.append(':');
          if (m < 10) {
            paramStringBuffer.append('0');
          }
          paramStringBuffer.append(m);
        }
      }
      else
      {
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = "yyyy-MM-dd";
        }
      }
    }
    try
    {
      paramString = new SimpleDateFormat((String)localObject1);
    }
    catch (Exception paramString)
    {
      label439:
      break label439;
    }
    paramString = new SimpleDateFormat("yyyy-MM-dd");
    paramStringBuffer.append(paramString.format(((Calendar)localObject2).getTime()));
    if (!paramBoolean)
    {
      paramStringBuffer.append(' ');
      paramStringBuffer.append(n);
      paramStringBuffer.append(':');
      if (m < 10) {
        paramStringBuffer.append('0');
      }
      paramStringBuffer.append(m);
    }
    return paramStringBuffer.toString();
    return null;
  }
  
  public static void a()
  {
    TimeZone localTimeZone1 = TimeZone.getTimeZone("GMT+8");
    TimeZone localTimeZone2 = TimeZone.getDefault();
    c = localTimeZone1.getRawOffset();
    int i = localTimeZone2.getRawOffset();
    d = c - i;
    a = Calendar.getInstance();
    b = new StringBuffer();
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 != paramInt4) {
      return 5;
    }
    if (paramInt3 == paramInt6) {
      return 1;
    }
    if (paramInt3 == paramInt6 + 1) {
      return 2;
    }
    if (paramInt3 == paramInt6 + 2) {
      return 3;
    }
    return 4;
  }
  
  public static int b(long paramLong)
  {
    a.setTimeInMillis(paramLong + d);
    return a.get(12);
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    int j = a.get(2);
    int k = a.get(5);
    a.setTimeInMillis(paramLong);
    i = a(i, j, k, a.get(1), a.get(2), a.get(5));
    if (i == 0) {}
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      label90:
      String str;
      break label90;
    }
    i = 0;
    if (i == 12)
    {
      if (a.get(11) < 12) {
        i = 2131897703;
      } else {
        i = 2131897616;
      }
      str = paramContext.getString(i);
      paramContext = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
      if (((ILocalManagerApi)QRoute.api(ILocalManagerApi.class)).isLocaleCN()) {
        return String.format("%s %s", new Object[] { str, paramContext.format(new Date(paramLong)) });
      }
      return String.format("%s %s", new Object[] { paramContext.format(new Date(paramLong)), str });
    }
    return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    if (i == 1) {
      return paramContext.getString(2131897736);
    }
    if ((i < 7) && (i > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return b().format(new Date(paramLong));
  }
  
  private static java.text.DateFormat b()
  {
    try
    {
      if (f == null) {
        f = android.text.format.DateFormat.getDateFormat(BaseApplication.getContext());
      }
      java.text.DateFormat localDateFormat = f;
      return localDateFormat;
    }
    finally {}
  }
  
  public static int c(long paramLong)
  {
    long l = System.currentTimeMillis();
    int j = c;
    int i = (int)((l + j) / 86400000L);
    j = (int)((paramLong + j) / 86400000L);
    if (j == i) {
      return 2131897728;
    }
    if (j == i - 1) {
      return 2131897736;
    }
    if (j == i - 2) {
      return 2131897621;
    }
    return -1;
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, false);
  }
  
  private static java.text.DateFormat c()
  {
    try
    {
      if (e == null) {
        e = android.text.format.DateFormat.getTimeFormat(BaseApplication.getContext());
      }
      java.text.DateFormat localDateFormat = e;
      return localDateFormat;
    }
    finally {}
  }
  
  public static int d(long paramLong)
  {
    try
    {
      a.setTimeInMillis(System.currentTimeMillis());
      int i = a.get(1);
      int j = a.get(2);
      int k = a.get(6);
      a.setTimeInMillis(paramLong);
      i = b(i, j, k, a.get(1), a.get(2), a.get(6));
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("calTimeInterval", 2, localException.getMessage());
    }
    return -1;
  }
  
  public static String d(Context paramContext, long paramLong)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    int j = a.get(2);
    int k = a.get(6);
    a.setTimeInMillis(paramLong);
    i = b(i, j, k, a.get(1), a.get(2), a.get(6));
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
          }
          return new SimpleDateFormat("MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
        }
        paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
        return String.format("%s %s", new Object[] { HardCodeUtil.a(2131897714), paramContext.format(new Date(paramLong)) });
      }
      paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { HardCodeUtil.a(2131897720), paramContext.format(new Date(paramLong)) });
    }
    paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
    return String.format("%s %s", new Object[] { HardCodeUtil.a(2131897713), paramContext.format(new Date(paramLong)) });
  }
  
  public static String e(long paramLong)
  {
    long l = System.currentTimeMillis();
    int i = c;
    i = (int)((l + i) / 86400000L) - (int)((i + paramLong) / 86400000L);
    Object localObject;
    if (i > 365)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i / 365);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131897705));
      return ((StringBuilder)localObject).toString();
    }
    if (i > 30)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i / 30);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131897710));
      return ((StringBuilder)localObject).toString();
    }
    if (i >= 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131897709));
      return ((StringBuilder)localObject).toString();
    }
    try
    {
      localObject = a(paramLong, "HH:mm");
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeFormatterUtils", 2, localException.getMessage());
      }
    }
    return "";
  }
  
  public static String f(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }
  
  public static long g(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L) {
      l = System.currentTimeMillis();
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l / 1000L * 1000L);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TimeFormatterUtils
 * JD-Core Version:    0.7.0.1
 */