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
    int i = 3;
    if (paramInt2 < 0) {}
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      if (paramInt1 > 3) {
        paramInt1 = i;
      }
      for (;;)
      {
        switch (paramInt1)
        {
        default: 
          return "";
        case 0: 
          return HardCodeUtil.a(2131707316);
        case 1: 
          return HardCodeUtil.a(2131707287);
        case 2: 
          return HardCodeUtil.a(2131707257);
        }
        return HardCodeUtil.a(2131707289);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.18
 * JD-Core Version:    0.7.0.1
 */