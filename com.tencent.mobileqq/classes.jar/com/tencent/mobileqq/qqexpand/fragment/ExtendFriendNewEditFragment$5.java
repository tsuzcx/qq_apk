package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class ExtendFriendNewEditFragment$5
  implements IphonePickerView.PickerViewAdapter
{
  ExtendFriendNewEditFragment$5(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
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
        if ((ExtendFriendNewEditFragment.k(this.a) + 1896 == ExtendFriendNewEditFragment.j(this.a)) && (ExtendFriendNewEditFragment.m(this.a) + 1 == ExtendFriendNewEditFragment.l(this.a))) {
          return ExtendFriendNewEditFragment.n(this.a);
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, ExtendFriendNewEditFragment.k(this.a) + 1896);
        localCalendar.set(2, ExtendFriendNewEditFragment.m(this.a));
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      if (ExtendFriendNewEditFragment.k(this.a) + 1896 == ExtendFriendNewEditFragment.j(this.a)) {
        return ExtendFriendNewEditFragment.l(this.a);
      }
      return 12;
    }
    return ExtendFriendNewEditFragment.j(this.a) - 1896 + 1;
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
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.5
 * JD-Core Version:    0.7.0.1
 */