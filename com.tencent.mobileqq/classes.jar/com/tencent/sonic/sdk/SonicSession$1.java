package com.tencent.sonic.sdk;

import android.os.Handler.Callback;
import android.os.Message;

class SonicSession$1
  implements Handler.Callback
{
  SonicSession$1(SonicSession paramSonicSession) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      paramMessage = (String)paramMessage.obj;
      SonicSession localSonicSession = this.this$0;
      localSonicSession.doSaveSonicCache(localSonicSession.server, paramMessage);
      return true;
    }
    paramMessage = (SonicServer)paramMessage.obj;
    SonicSession.access$000(this.this$0, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.1
 * JD-Core Version:    0.7.0.1
 */