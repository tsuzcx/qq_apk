import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class sms
  extends QZoneFeedsObserver
{
  public sms(Conversation paramConversation) {}
  
  protected void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new smt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */