package com.tencent.qqconnect.wtlogin;

import android.os.Handler.Callback;
import android.os.Message;

class Login$11
  implements Handler.Callback
{
  Login$11(Login paramLogin) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.a.setResult(0);
      this.a.finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.11
 * JD-Core Version:    0.7.0.1
 */