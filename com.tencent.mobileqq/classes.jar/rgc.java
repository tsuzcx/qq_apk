import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class rgc
  extends Handler
{
  public rgc(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == ReadInjoyXRecyclerView.b) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgc
 * JD-Core Version:    0.7.0.1
 */