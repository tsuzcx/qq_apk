package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

class QuickLoginAuthorityActivity$8
  extends Handler
{
  QuickLoginAuthorityActivity$8(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
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
          this.a.a.a("", "", paramMessage, true);
          return;
          paramMessage = (Bitmap)paramMessage.obj;
        } while (paramMessage == null);
        this.a.a.a("", paramMessage);
        return;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      this.a.a.setAppType(paramMessage);
      return;
    } while (this.a.a.a == null);
    this.a.a.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.8
 * JD-Core Version:    0.7.0.1
 */