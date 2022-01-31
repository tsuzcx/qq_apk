package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.observer.ServerNotifyObserver;

class VerifyCodeManagerImpl$1
  extends Handler
{
  VerifyCodeManagerImpl$1(VerifyCodeManagerImpl paramVerifyCodeManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (Object[])paramMessage.obj;
      ((ServerNotifyObserver)paramMessage[0]).onReceiveVerifyCode((String)paramMessage[1], ((Integer)paramMessage[2]).intValue(), (String)paramMessage[3], (byte[])paramMessage[4]);
      return;
    }
    ((ServerNotifyObserver)((Object[])(Object[])paramMessage.obj)[0]).onVerifyClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */