import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

public final class mry
  extends Handler
{
  public mry(Looper paramLooper, msa parammsa)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     mry
 * JD-Core Version:    0.7.0.1
 */