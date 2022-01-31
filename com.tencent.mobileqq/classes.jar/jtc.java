import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.CallbackWaitingActivityExt;

public class jtc
  extends Handler
{
  public jtc(CallbackWaitingActivityExt paramCallbackWaitingActivityExt, Looper paramLooper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtc
 * JD-Core Version:    0.7.0.1
 */