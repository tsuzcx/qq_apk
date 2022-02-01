package com.tencent.mobileqq.msgbackup.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class MsgBackupDateFragment$DateAdapter
  implements IphonePickerView.PickerViewAdapter
{
  private MsgBackupDateFragment$DateAdapter(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
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
        if (MsgBackupDateFragment.h(this.a) == 1)
        {
          localCalendar.set(1, MsgBackupDateFragment.o(this.a) + MsgBackupDateFragment.n(this.a));
          localCalendar.set(2, MsgBackupDateFragment.p(this.a));
          localCalendar.set(5, 1);
        }
        else
        {
          localCalendar.set(1, MsgBackupDateFragment.q(this.a) + MsgBackupDateFragment.n(this.a));
          localCalendar.set(2, MsgBackupDateFragment.r(this.a));
          localCalendar.set(5, 1);
        }
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return MsgBackupDateFragment.m(this.a) - MsgBackupDateFragment.n(this.a) + 1;
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
        localStringBuilder.append(HardCodeUtil.a(2131904801));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131904785));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupDateFragment.n(this.a) + paramInt2);
    localStringBuilder.append(HardCodeUtil.a(2131904802));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.DateAdapter
 * JD-Core Version:    0.7.0.1
 */