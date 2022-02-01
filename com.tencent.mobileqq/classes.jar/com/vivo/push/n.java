package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.o;

final class n
  extends Handler
{
  n(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof l))
    {
      paramMessage = (l)paramMessage;
      o.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(paramMessage)));
      paramMessage.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.n
 * JD-Core Version:    0.7.0.1
 */