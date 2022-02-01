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
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage == null);
          paramMessage = AuthorityUtil.a(this.a, paramMessage, 50, 50);
          localMessage = Message.obtain();
          localMessage.what = 1002;
          localMessage.obj = paramMessage;
          this.a.b.sendMessage(localMessage);
          return;
          paramMessage = (String)paramMessage.obj;
        } while (TextUtils.isEmpty(paramMessage));
        paramMessage = AuthorityActivity.a(paramMessage);
      } while (paramMessage == null);
      Message localMessage = Message.obtain();
      localMessage.what = 1003;
      localMessage.obj = paramMessage;
      this.a.b.sendMessage(localMessage);
      return;
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "--> handler message GET_ACCOUNT_LIST");
    } while (this.a.a.a == null);
    this.a.a.a.c();
    paramMessage = Message.obtain();
    paramMessage.what = 1006;
    this.a.b.sendMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.7
 * JD-Core Version:    0.7.0.1
 */