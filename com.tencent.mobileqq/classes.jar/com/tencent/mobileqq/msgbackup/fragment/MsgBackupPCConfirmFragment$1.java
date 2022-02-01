package com.tencent.mobileqq.msgbackup.fragment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class MsgBackupPCConfirmFragment$1
  implements OnItemSelectListener
{
  MsgBackupPCConfirmFragment$1(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.b), Boolean.valueOf(MsgBackupManager.c) });
      MsgBackupTransportProcessor.a().c();
      if (!TextUtils.isEmpty(this.a.a)) {
        break label93;
      }
      this.a.a(this.a.getActivity());
      if (this.a.b != 2) {
        break label104;
      }
      MsgBackupReporter.a("0X800A282");
    }
    label93:
    label104:
    while (!MsgBackupManager.c)
    {
      return;
      this.a.onBackEvent();
      break;
    }
    MsgBackupReporter.a("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment.1
 * JD-Core Version:    0.7.0.1
 */