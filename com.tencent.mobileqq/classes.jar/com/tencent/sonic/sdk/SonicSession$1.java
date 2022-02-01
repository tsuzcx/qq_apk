package com.tencent.sonic.sdk;

import android.os.Handler.Callback;
import android.os.Message;

class SonicSession$1
  implements Handler.Callback
{
  SonicSession$1(SonicSession paramSonicSession) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      paramMessage = (SonicServer)paramMessage.obj;
      SonicSession.access$000(this.this$0, paramMessage);
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    this.this$0.doSaveSonicCache(this.this$0.server, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.1
 * JD-Core Version:    0.7.0.1
 */