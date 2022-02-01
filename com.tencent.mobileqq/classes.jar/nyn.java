import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

public final class nyn
  extends Handler
{
  public nyn(Looper paramLooper, nyp paramnyp)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      this.a.a(paramMessage.arg1, (List)paramMessage.obj);
      return;
    }
    this.a.a(paramMessage.arg1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyn
 * JD-Core Version:    0.7.0.1
 */