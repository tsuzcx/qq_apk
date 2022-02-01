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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, this.a.K + 1896);
        localCalendar.set(2, this.a.L);
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return this.a.H - 1896 + 1;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return "";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2 + 1);
        localStringBuilder.append(HardCodeUtil.a(2131905143));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131905153));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + 1896);
    localStringBuilder.append(HardCodeUtil.a(2131905161));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.12
 * JD-Core Version:    0.7.0.1
 */