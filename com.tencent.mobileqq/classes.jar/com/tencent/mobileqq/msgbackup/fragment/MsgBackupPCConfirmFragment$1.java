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
      MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.K), Boolean.valueOf(MsgBackupManager.s) });
      MsgBackupTransportProcessor.a().m();
      if (TextUtils.isEmpty(this.a.ab))
      {
        paramView = this.a;
        paramView.a(paramView.getActivity());
      }
      else
      {
        this.a.onBackEvent();
      }
      if (this.a.K == 2)
      {
        MsgBackupReporter.a("0X800A282");
        return;
      }
      if (MsgBackupManager.s) {
        MsgBackupReporter.a("0X800A266", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment.1
 * JD-Core Version:    0.7.0.1
 */