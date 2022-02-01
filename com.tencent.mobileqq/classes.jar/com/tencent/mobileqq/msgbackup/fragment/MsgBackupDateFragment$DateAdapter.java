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
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return MsgBackupDateFragment.c(this.a) - MsgBackupDateFragment.d(this.a) + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    if (MsgBackupDateFragment.b(this.a) == 1)
    {
      localCalendar.set(1, MsgBackupDateFragment.e(this.a) + MsgBackupDateFragment.d(this.a));
      localCalendar.set(2, MsgBackupDateFragment.f(this.a));
      localCalendar.set(5, 1);
    }
    for (;;)
    {
      return localCalendar.getActualMaximum(5);
      localCalendar.set(1, MsgBackupDateFragment.g(this.a) + MsgBackupDateFragment.d(this.a));
      localCalendar.set(2, MsgBackupDateFragment.h(this.a));
      localCalendar.set(5, 1);
    }
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return MsgBackupDateFragment.d(this.a) + paramInt2 + HardCodeUtil.a(2131706937);
    case 1: 
      return paramInt2 + 1 + HardCodeUtil.a(2131706920);
    }
    return paramInt2 + 1 + HardCodeUtil.a(2131706936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.DateAdapter
 * JD-Core Version:    0.7.0.1
 */