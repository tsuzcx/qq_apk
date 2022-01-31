import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import java.util.List;

public final class koe
  extends Handler
{
  public koe(Looper paramLooper, SearchProtocol.SearchObserver paramSearchObserver)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     koe
 * JD-Core Version:    0.7.0.1
 */