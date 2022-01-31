import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class rvy
  extends Handler
{
  public rvy(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, Looper paramLooper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rvy
 * JD-Core Version:    0.7.0.1
 */