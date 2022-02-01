package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQSettingMsgClearFragment$8
  extends Handler
{
  QQSettingMsgClearFragment$8(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.a != null) && (this.a.a.isShowing()))
      {
        this.a.a.cancel();
        this.a.a.a(this.a.getString(2131887798));
        this.a.a.c(true);
        this.a.a.a(false);
        this.a.a.b(true);
      }
    }
    else
    {
      paramMessage = this.a.getBaseActivity();
      if ((paramMessage != null) && (!paramMessage.isFinishing()))
      {
        this.a.a.a(this.a.getString(2131887796));
        this.a.a.d(2130851772);
        this.a.a.b(false);
      }
      this.a.c.sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.8
 * JD-Core Version:    0.7.0.1
 */