package com.tencent.mobileqq.msgbackup.fragment;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

class MsgBackupDateFragment$5
  implements IphonePickerView.IphonePickListener
{
  MsgBackupDateFragment$5(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onConfirmBtClicked()
  {
    if ((MsgBackupDateFragment.a(this.a) != null) && (MsgBackupDateFragment.a(this.a).isShowing()))
    {
      MsgBackupDateFragment.a(this.a).dismiss();
      MsgBackupDateFragment.b(this.a);
      MsgBackupDateFragment.a(this.a);
      MsgBackupDateFragment localMsgBackupDateFragment = this.a;
      MsgBackupDateFragment.b(localMsgBackupDateFragment, MsgBackupDateFragment.b(localMsgBackupDateFragment));
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          if (MsgBackupDateFragment.b(this.a) == 1) {
            MsgBackupDateFragment.f(this.a, paramInt2);
          } else if (MsgBackupDateFragment.b(this.a) == 2) {
            MsgBackupDateFragment.g(this.a, paramInt2);
          }
        }
      }
      else if (MsgBackupDateFragment.b(this.a) == 1) {
        MsgBackupDateFragment.d(this.a, paramInt2);
      } else if (MsgBackupDateFragment.b(this.a) == 2) {
        MsgBackupDateFragment.e(this.a, paramInt2);
      }
    }
    else if (MsgBackupDateFragment.b(this.a) == 1) {
      MsgBackupDateFragment.b(this.a, paramInt2);
    } else if (MsgBackupDateFragment.b(this.a) == 2) {
      MsgBackupDateFragment.c(this.a, paramInt2);
    }
    MsgBackupDateFragment localMsgBackupDateFragment = this.a;
    MsgBackupDateFragment.a(localMsgBackupDateFragment, MsgBackupDateFragment.b(localMsgBackupDateFragment));
    MsgBackupDateFragment.a(this.a);
    if ((MsgBackupDateFragment.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
      MsgBackupDateFragment.a(this.a).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.5
 * JD-Core Version:    0.7.0.1
 */