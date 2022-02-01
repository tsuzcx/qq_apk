package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

class NearbyProfileEditTribePanel$19
  implements IphonePickerView.PickerViewAdapter
{
  NearbyProfileEditTribePanel$19(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 2;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 1) {}
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      return HardCodeUtil.a(2131707278);
    }
    return HardCodeUtil.a(2131707379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.19
 * JD-Core Version:    0.7.0.1
 */