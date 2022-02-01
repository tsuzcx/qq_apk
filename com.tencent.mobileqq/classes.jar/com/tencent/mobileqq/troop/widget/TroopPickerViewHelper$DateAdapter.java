package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TroopPickerViewHelper$DateAdapter
  implements WheelPickerLayout.PickerViewAdapter
{
  private final DateFormat b = new SimpleDateFormat("M月d日");
  private WheelPickerLayout c;
  private Date d;
  private boolean e = true;
  
  public TroopPickerViewHelper$DateAdapter(TroopPickerViewHelper paramTroopPickerViewHelper, WheelPickerLayout paramWheelPickerLayout)
  {
    this.c = paramWheelPickerLayout;
    this.d = new Date();
    paramWheelPickerLayout = Calendar.getInstance();
    paramWheelPickerLayout.setTime(this.d);
    paramWheelPickerLayout.set(13, 0);
    paramWheelPickerLayout.set(14, 0);
    int i = paramWheelPickerLayout.get(11);
    if (i >= TroopPickerViewHelper.e(paramTroopPickerViewHelper))
    {
      paramWheelPickerLayout.add(5, 1);
      paramWheelPickerLayout.set(11, TroopPickerViewHelper.f(paramTroopPickerViewHelper));
      paramWheelPickerLayout.set(12, 0);
      this.e = false;
    }
    else if (i < TroopPickerViewHelper.f(paramTroopPickerViewHelper))
    {
      paramWheelPickerLayout.set(11, TroopPickerViewHelper.f(paramTroopPickerViewHelper));
      paramWheelPickerLayout.set(12, 0);
    }
    else
    {
      i = paramWheelPickerLayout.get(12);
      paramWheelPickerLayout.add(12, TroopPickerViewHelper.g(paramTroopPickerViewHelper) - i % TroopPickerViewHelper.g(paramTroopPickerViewHelper));
    }
    this.d = paramWheelPickerLayout.getTime();
  }
  
  private String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(this.d);
    if (paramInt > 0) {
      localCalendar.add(5, paramInt);
    }
    long l1 = this.d.getTime();
    long l2 = localCalendar.getTimeInMillis();
    int i = (int)((l2 - l1) / 86400000L);
    paramInt = i;
    if (!this.e) {
      paramInt = i + 1;
    }
    if (paramInt != 0)
    {
      localStringBuilder.append(this.b.format(Long.valueOf(l2)));
      localStringBuilder.append(" ");
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localStringBuilder.append(c(localCalendar.get(7)));
        } else {
          localStringBuilder.append("后天");
        }
      }
      else {
        localStringBuilder.append("明天");
      }
    }
    else {
      localStringBuilder.append("今天");
    }
    return localStringBuilder.toString();
  }
  
  private String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return HardCodeUtil.a(2131912966);
    case 6: 
      return HardCodeUtil.a(2131912964);
    case 5: 
      return HardCodeUtil.a(2131912949);
    case 4: 
      return HardCodeUtil.a(2131912950);
    case 3: 
      return HardCodeUtil.a(2131912956);
    case 2: 
      return HardCodeUtil.a(2131912965);
    }
    return HardCodeUtil.a(2131912952);
  }
  
  public int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        return (60 - a(new int[] { this.c.b(0), this.c.b(1) }).get(12)) / TroopPickerViewHelper.g(this.a);
      }
      paramInt = a(new int[] { this.c.b(0) }).get(11);
      return TroopPickerViewHelper.e(this.a) - paramInt + 1;
    }
    return TroopPickerViewHelper.h(this.a);
  }
  
  public int a(Calendar paramCalendar, int paramInt)
  {
    paramInt = a(new int[] { paramInt }).get(11);
    paramInt = paramCalendar.get(11) - paramInt;
    if (paramInt > 0) {
      return paramInt;
    }
    return 0;
  }
  
  public int a(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    long l = a(new int[] { paramInt1, paramInt2 }).get(12);
    paramInt1 = (int)((paramCalendar.get(12) - l) / TroopPickerViewHelper.g(this.a));
    if (paramInt1 > 0) {
      return paramInt1;
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return "";
        }
        return String.format("%d分", new Object[] { Integer.valueOf(a(new int[] { this.c.b(0), this.c.b(1), paramInt2 }).get(12)) });
      }
      return String.format("%d点", new Object[] { Integer.valueOf(a(new int[] { this.c.b(0), paramInt2 }).get(11)) });
    }
    return b(paramInt2);
  }
  
  public Calendar a(int... paramVarArgs)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(this.d);
    if (paramVarArgs[0] > 0)
    {
      localCalendar.add(5, paramVarArgs[0]);
      localCalendar.set(11, TroopPickerViewHelper.f(this.a));
      localCalendar.set(12, 0);
    }
    if ((paramVarArgs.length > 1) && (paramVarArgs[1] > 0))
    {
      localCalendar.add(11, paramVarArgs[1]);
      localCalendar.set(12, 0);
    }
    if (paramVarArgs.length > 2) {
      localCalendar.add(12, paramVarArgs[2] * TroopPickerViewHelper.g(this.a));
    }
    return localCalendar;
  }
  
  public int[] a(long paramLong)
  {
    int[] arrayOfInt = new int[3];
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.d);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    arrayOfInt[0] = ((int)((localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L));
    localCalendar2 = a(new int[] { arrayOfInt[0] });
    localCalendar1.setTimeInMillis(paramLong);
    arrayOfInt[1] = (localCalendar1.get(11) - localCalendar2.get(11));
    localCalendar2 = a(new int[] { arrayOfInt[0], arrayOfInt[1] });
    arrayOfInt[2] = ((localCalendar1.get(12) - localCalendar2.get(12)) / TroopPickerViewHelper.g(this.a));
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper.DateAdapter
 * JD-Core Version:    0.7.0.1
 */