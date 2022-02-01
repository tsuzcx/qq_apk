package com.tencent.mobileqq.fragment;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQSettingChatOperationFragment$6
  extends Handler
{
  QQSettingChatOperationFragment$6(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        QQSettingChatOperationFragment.d(this.a);
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
      if ((this.a.getBaseActivity() != null) && (!this.a.getBaseActivity().isFinishing()))
      {
        this.a.a.a(this.a.getString(2131887796));
        this.a.a.d(2130851772);
        this.a.a.b(false);
      }
      this.a.d.sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.6
 * JD-Core Version:    0.7.0.1
 */