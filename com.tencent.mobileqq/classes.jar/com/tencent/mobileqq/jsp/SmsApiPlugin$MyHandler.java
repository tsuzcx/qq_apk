package com.tencent.mobileqq.jsp;

import android.os.Handler;
import android.os.Message;

public class SmsApiPlugin$MyHandler
  extends Handler
{
  SmsApiPlugin a;
  
  protected SmsApiPlugin$MyHandler(SmsApiPlugin paramSmsApiPlugin)
  {
    this.a = paramSmsApiPlugin;
  }
  
  protected void a()
  {
    this.a = null;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.SmsApiPlugin.MyHandler
 * JD-Core Version:    0.7.0.1
 */