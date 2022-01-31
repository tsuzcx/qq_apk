package mqq.os;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class MqqHandler$NativeHandler
  extends Handler
{
  MqqHandler mParentHandler;
  
  public MqqHandler$NativeHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    this.mParentHandler.dispatchMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.os.MqqHandler.NativeHandler
 * JD-Core Version:    0.7.0.1
 */