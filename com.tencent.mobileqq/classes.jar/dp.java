import android.os.Handler;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;

public class dp
  implements Runnable
{
  public dp(WaitTextView paramWaitTextView) {}
  
  public void run()
  {
    WaitTextView.a(this.a);
    if (WaitTextView.a(this.a) != null) {
      WaitTextView.a(this.a).a();
    }
    WaitTextView.a(this.a).postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dp
 * JD-Core Version:    0.7.0.1
 */