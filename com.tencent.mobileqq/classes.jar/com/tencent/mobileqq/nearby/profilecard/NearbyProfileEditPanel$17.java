package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class NearbyProfileEditPanel$17
  implements IphonePickerView.PickerViewAdapter
{
  NearbyProfileEditPanel$17(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
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
        localCalendar.set(1, this.a.P + 1896);
        localCalendar.set(2, this.a.Q);
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return this.a.M - 1896 + 1;
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
        localStringBuilder.append(HardCodeUtil.a(2131905194));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131905210));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + 1896);
    localStringBuilder.append(HardCodeUtil.a(2131905114));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.17
 * JD-Core Version:    0.7.0.1
 */