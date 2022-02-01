package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistorySettingFragment$8
  extends Handler
{
  ChatHistorySettingFragment$8(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.c != null) && (this.a.c.isShowing()))
      {
        this.a.c.cancel();
        this.a.c.a(this.a.getString(2131887798));
        this.a.c.c(true);
        this.a.c.a(false);
        this.a.c.b(true);
      }
    }
    else
    {
      if ((this.a.getBaseActivity() != null) && (!this.a.getBaseActivity().isFinishing()))
      {
        this.a.c.a(this.a.getString(2131887796));
        this.a.c.d(2130851772);
        this.a.c.b(false);
      }
      this.a.f.sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.8
 * JD-Core Version:    0.7.0.1
 */