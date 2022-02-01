package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

class d
  extends Handler
{
  d(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    int i = paramMessage.arg1;
    paramMessage = this.a;
    b.b(paramMessage, (ToServiceMsg)b.a(paramMessage).get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.d
 * JD-Core Version:    0.7.0.1
 */