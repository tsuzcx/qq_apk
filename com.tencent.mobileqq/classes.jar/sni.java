import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class sni
  implements MessageQueue.IdleHandler
{
  public sni(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    FastWebActivity.a(this.a, this.a.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sni
 * JD-Core Version:    0.7.0.1
 */