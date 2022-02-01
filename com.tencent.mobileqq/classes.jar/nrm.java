import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

public final class nrm
  extends Handler
{
  public nrm(Looper paramLooper, nro paramnro)
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
 * Qualified Name:     nrm
 * JD-Core Version:    0.7.0.1
 */