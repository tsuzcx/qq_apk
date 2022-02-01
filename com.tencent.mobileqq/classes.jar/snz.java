import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class snz
  implements MessageQueue.IdleHandler
{
  public snz(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    FastWebActivity.e(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snz
 * JD-Core Version:    0.7.0.1
 */