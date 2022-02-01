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
    case 1005: 
    default: 
    case 1006: 
      if (this.a.a.a != null)
      {
        this.a.a.a.f();
        return;
      }
      break;
    case 1004: 
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        this.a.a.setAppType(paramMessage);
        return;
      }
      break;
    case 1003: 
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        this.a.a.a("", paramMessage);
        return;
      }
      break;
    case 1002: 
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null) {
        this.a.a.a("", "", paramMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.8
 * JD-Core Version:    0.7.0.1
 */