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
    if ((MsgBackupDateFragment.k(this.a) != null) && (MsgBackupDateFragment.k(this.a).isShowing()))
    {
      MsgBackupDateFragment.k(this.a).dismiss();
      MsgBackupDateFragment.l(this.a);
      MsgBackupDateFragment.i(this.a);
      MsgBackupDateFragment localMsgBackupDateFragment = this.a;
      MsgBackupDateFragment.i(localMsgBackupDateFragment, MsgBackupDateFragment.h(localMsgBackupDateFragment));
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          if (MsgBackupDateFragment.h(this.a) == 1) {
            MsgBackupDateFragment.f(this.a, paramInt2);
          } else if (MsgBackupDateFragment.h(this.a) == 2) {
            MsgBackupDateFragment.g(this.a, paramInt2);
          }
        }
      }
      else if (MsgBackupDateFragment.h(this.a) == 1) {
        MsgBackupDateFragment.d(this.a, paramInt2);
      } else if (MsgBackupDateFragment.h(this.a) == 2) {
        MsgBackupDateFragment.e(this.a, paramInt2);
      }
    }
    else if (MsgBackupDateFragment.h(this.a) == 1) {
      MsgBackupDateFragment.b(this.a, paramInt2);
    } else if (MsgBackupDateFragment.h(this.a) == 2) {
      MsgBackupDateFragment.c(this.a, paramInt2);
    }
    MsgBackupDateFragment localMsgBackupDateFragment = this.a;
    MsgBackupDateFragment.h(localMsgBackupDateFragment, MsgBackupDateFragment.h(localMsgBackupDateFragment));
    MsgBackupDateFragment.i(this.a);
    if ((MsgBackupDateFragment.j(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
      MsgBackupDateFragment.j(this.a).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.5
 * JD-Core Version:    0.7.0.1
 */