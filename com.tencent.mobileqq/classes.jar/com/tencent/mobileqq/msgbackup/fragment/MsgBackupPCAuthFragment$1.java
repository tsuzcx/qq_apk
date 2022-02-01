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
          MsgBackupPCAuthFragment.a(this.a).setLeftBackVisible(0);
          MsgBackupPCAuthFragment.b(this.a).setRightViewTextVisible(8);
        }
        MsgBackupPCAuthFragment.b(this.a);
        this.a.b.setText(this.a.getString(2131690684, new Object[] { Integer.valueOf(MsgBackupPCAuthFragment.a(this.a)) }));
        if (AppSetting.d) {
          this.a.b.setContentDescription(this.a.getString(2131690684));
        }
        MsgBackupPCAuthFragment.a(this.a).sendEmptyMessageDelayed(1, 1000L);
        return true;
      }
      MsgBackupPCAuthFragment.a(this.a).removeCallbacksAndMessages(null);
      MsgBackupPCAuthFragment.a(this.a, 60);
      MsgBackupPCAuthFragment.a(this.a, false);
      if (NetworkUtil.a(this.a.getActivity()) == 1)
      {
        i = 1;
        label205:
        paramMessage = this.a;
        if (i == 0) {
          break label288;
        }
      }
      label288:
      for (int i = 0;; i = 2)
      {
        MsgBackupPCAuthFragment.a(paramMessage, i);
        MsgBackupPCAuthFragment.c(this.a).setLeftBackVisible(0);
        MsgBackupPCAuthFragment.d(this.a).setRightViewTextVisible(8);
        this.a.b.setText(2131690674);
        if (!AppSetting.d) {
          break;
        }
        this.a.b.setContentDescription(this.a.getString(2131690674));
        return true;
        i = 0;
        break label205;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment.1
 * JD-Core Version:    0.7.0.1
 */