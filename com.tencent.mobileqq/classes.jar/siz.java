import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.managers.LoadingStateManager;

public class siz
  implements Handler.Callback
{
  public siz(Conversation paramConversation) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    LoadingStateManager.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      this.a.a(1134013, 0L, false);
      return true;
    }
    this.a.d(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     siz
 * JD-Core Version:    0.7.0.1
 */