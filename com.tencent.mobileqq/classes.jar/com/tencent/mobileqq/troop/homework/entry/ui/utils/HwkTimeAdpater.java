package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;
import java.util.Date;

public class HwkTimeAdpater
  implements IphonePickerView.PickerViewAdapter
{
  private final int a = this.c.getMaximum(1);
  private final int b = this.c.getMinimum(1);
  private Calendar c = Calendar.getInstance();
  private long d;
  private final int e;
  
  public HwkTimeAdpater()
  {
    this.c.add(5, 1);
    this.c.set(11, 8);
    this.c.set(12, 0);
    this.c.set(13, 0);
    this.c.set(14, 0);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.b);
    localCalendar.set(5, 0);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.d = localCalendar.getTimeInMillis();
    this.e = ((int)((this.c.getTimeInMillis() - this.d) / 86400000L));
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 8);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public static long a(HwkTimePicker paramHwkTimePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramHwkTimePicker != null) && ((paramHwkTimePicker.a() instanceof HwkTimeAdpater)))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(a(paramHwkTimePicker, paramInt1));
      localCalendar.set(11, b(paramHwkTimePicker, paramInt2));
      localCalendar.set(12, c(paramHwkTimePicker, paramInt3));
      return localCalendar.getTimeInMillis();
    }
    return 0L;
  }
  
  public static HwkTimePicker a(Context paramContext)
  {
    HwkTimeAdpater localHwkTimeAdpater = new HwkTimeAdpater();
    paramContext = new HwkTimePicker(paramContext, localHwkTimeAdpater);
    a(paramContext, localHwkTimeAdpater);
    return paramContext;
  }
  
  public static Date a(HwkTimePicker paramHwkTimePicker, int paramInt)
  {
    if ((paramHwkTimePicker != null) && ((paramHwkTimePicker.a() instanceof HwkTimeAdpater)))
    {
      paramHwkTimePicker = (HwkTimeAdpater)paramHwkTimePicker.a();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramHwkTimePicker.d + paramInt * 86400000L);
      return localCalendar.getTime();
    }
    return null;
  }
  
  public static void a(HwkTimePicker paramHwkTimePicker, HwkTimeAdpater paramHwkTimeAdpater)
  {
    if ((paramHwkTimePicker != null) && (paramHwkTimeAdpater != null))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.add(5, 1);
      localCalendar.set(11, 8);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      paramHwkTimePicker.a(0, paramHwkTimeAdpater.e);
      paramHwkTimePicker.a(1, localCalendar.get(11));
      paramHwkTimePicker.a(2, localCalendar.get(12));
    }
  }
  
  public static int b(HwkTimePicker paramHwkTimePicker, int paramInt)
  {
    return paramInt;
  }
  
  public static int c(HwkTimePicker paramHwkTimePicker, int paramInt)
  {
    return paramInt;
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        return 60;
      }
      return 24;
    }
    return this.a - this.b + 1;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          localStringBuilder.append(paramInt2);
          this.c.set(12, paramInt2);
        }
      }
      else
      {
        localStringBuilder.append(paramInt2);
        this.c.set(11, paramInt2);
      }
    }
    else
    {
      this.c.setTimeInMillis(this.d + paramInt2 * 86400000L);
      paramInt1 = this.c.get(1);
      paramInt2 = this.c.get(2);
      int i = this.c.get(5);
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("年");
      localStringBuilder.append(String.valueOf(paramInt2 + 1));
      localStringBuilder.append("月");
      localStringBuilder.append(i);
      localStringBuilder.append("日");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimeAdpater
 * JD-Core Version:    0.7.0.1
 */