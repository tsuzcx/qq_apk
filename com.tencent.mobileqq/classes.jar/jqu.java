import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.CallbackWaitingActivity;

public class jqu
  extends Handler
{
  public jqu(CallbackWaitingActivity paramCallbackWaitingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqu
 * JD-Core Version:    0.7.0.1
 */