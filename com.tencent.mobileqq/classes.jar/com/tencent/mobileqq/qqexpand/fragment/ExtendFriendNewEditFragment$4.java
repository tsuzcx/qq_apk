package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

class ExtendFriendNewEditFragment$4
  implements IphonePickerView.PickerViewAdapter
{
  ExtendFriendNewEditFragment$4(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
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
      return HardCodeUtil.a(2131905148);
    }
    return HardCodeUtil.a(2131905120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.4
 * JD-Core Version:    0.7.0.1
 */