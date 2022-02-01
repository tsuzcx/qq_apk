package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class MsgBackupPCAuthFragment$2
  implements OnItemSelectListener
{
  MsgBackupPCAuthFragment$2(MsgBackupPCAuthFragment paramMsgBackupPCAuthFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      if (MsgBackupPCAuthFragment.a(this.a)) {
        this.a.k();
      }
      this.a.onBackEvent();
    }
    while (paramInt != 2) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment.2
 * JD-Core Version:    0.7.0.1
 */