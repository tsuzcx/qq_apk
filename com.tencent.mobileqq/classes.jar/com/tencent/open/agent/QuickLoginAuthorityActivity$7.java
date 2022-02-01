package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class QuickLoginAuthorityActivity$7
  extends Handler
{
  QuickLoginAuthorityActivity$7(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Message localMessage;
    if (i != 1000)
    {
      if (i != 1001)
      {
        if (i != 1005) {
          return;
        }
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "--> handler message GET_ACCOUNT_LIST");
        if (this.a.a.a != null)
        {
          this.a.a.a.e();
          paramMessage = Message.obtain();
          paramMessage.what = 1006;
          this.a.b.sendMessage(paramMessage);
        }
      }
      else
      {
        paramMessage = (String)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage))
        {
          paramMessage = AuthorityUtil.a(paramMessage);
          if (paramMessage != null)
          {
            localMessage = Message.obtain();
            localMessage.what = 1003;
            localMessage.obj = paramMessage;
            this.a.b.sendMessage(localMessage);
          }
        }
      }
    }
    else
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        paramMessage = AuthorityUtil.a(this.a, paramMessage, 50, 50);
        localMessage = Message.obtain();
        localMessage.what = 1002;
        localMessage.obj = paramMessage;
        this.a.b.sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.7
 * JD-Core Version:    0.7.0.1
 */