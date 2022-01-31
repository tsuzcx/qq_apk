import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mmr
  implements MessageQueue.IdleHandler
{
  public mmr(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    FastWebActivity.a(this.a, FastWebActivity.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmr
 * JD-Core Version:    0.7.0.1
 */