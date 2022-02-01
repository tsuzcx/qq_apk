package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class NearbyProfileEditTribePanel$12
  implements IphonePickerView.PickerViewAdapter
{
  NearbyProfileEditTribePanel$12(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.a.b - 1896 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.a.e + 1896);
    localCalendar.set(2, this.a.f);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1896 + HardCodeUtil.a(2131707313);
    case 1: 
      return paramInt2 + 1 + HardCodeUtil.a(2131707305);
    }
    return paramInt2 + 1 + HardCodeUtil.a(2131707293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.12
 * JD-Core Version:    0.7.0.1
 */