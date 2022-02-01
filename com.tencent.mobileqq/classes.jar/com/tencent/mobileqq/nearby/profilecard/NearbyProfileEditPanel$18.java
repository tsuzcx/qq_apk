package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

class NearbyProfileEditPanel$18
  implements IphonePickerView.PickerViewAdapter
{
  NearbyProfileEditPanel$18(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 4;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > 3) {
      paramInt2 = 3;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3) {
            return "";
          }
          return HardCodeUtil.a(2131707314);
        }
        return HardCodeUtil.a(2131707282);
      }
      return HardCodeUtil.a(2131707312);
    }
    return HardCodeUtil.a(2131707341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.18
 * JD-Core Version:    0.7.0.1
 */