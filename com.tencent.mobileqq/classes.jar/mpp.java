import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mpp
  implements MessageQueue.IdleHandler
{
  public mpp(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    this.a.a(FastWebActivity.a(this.a));
    FastWebActivity.c(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpp
 * JD-Core Version:    0.7.0.1
 */