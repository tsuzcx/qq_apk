package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.Button;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

class MsgBackupPCAuthFragment$1
  implements Handler.Callback
{
  MsgBackupPCAuthFragment$1(MsgBackupPCAuthFragment paramMsgBackupPCAuthFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (this.a.getActivity() == null) {
        return true;
      }
      if (MsgBackupPCAuthFragment.a(this.a) > 0)
      {
        if (MsgBackupPCAuthFragment.a(this.a) == 60)
        {
          MsgBackupPCAuthFragment.a(this.a, 1);
          MsgBackupPCAuthFragment.b(this.a).setLeftBackVisible(0);
          MsgBackupPCAuthFragment.c(this.a).setRightViewTextVisible(8);
        }
        MsgBackupPCAuthFragment.d(this.a);
        paramMessage = this.a.H;
        MsgBackupPCAuthFragment localMsgBackupPCAuthFragment = this.a;
        paramMessage.setText(localMsgBackupPCAuthFragment.getString(2131887523, new Object[] { Integer.valueOf(MsgBackupPCAuthFragment.a(localMsgBackupPCAuthFragment)) }));
        if (AppSetting.e) {
          this.a.H.setContentDescription(this.a.getString(2131887523));
        }
        MsgBackupPCAuthFragment.e(this.a).sendEmptyMessageDelayed(1, 1000L);
        return true;
      }
      MsgBackupPCAuthFragment.e(this.a).removeCallbacksAndMessages(null);
      MsgBackupPCAuthFragment.b(this.a, 60);
      MsgBackupPCAuthFragment.a(this.a, false);
      int i;
      if (NetworkUtil.getSystemNetwork(this.a.getActivity()) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      paramMessage = this.a;
      if (i != 0) {
        i = 0;
      } else {
        i = 2;
      }
      MsgBackupPCAuthFragment.a(paramMessage, i);
      MsgBackupPCAuthFragment.f(this.a).setLeftBackVisible(0);
      MsgBackupPCAuthFragment.g(this.a).setRightViewTextVisible(8);
      this.a.H.setText(2131887513);
      if (AppSetting.e) {
        this.a.H.setContentDescription(this.a.getString(2131887513));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment.1
 * JD-Core Version:    0.7.0.1
 */