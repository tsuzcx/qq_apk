import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class rje
  implements MessageQueue.IdleHandler
{
  public rje(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    FastWebActivity.e(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rje
 * JD-Core Version:    0.7.0.1
 */