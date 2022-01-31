import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.managers.LoadingStateManager;

public class sgb
  implements Handler.Callback
{
  public sgb(Conversation paramConversation) {}
  
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
 * Qualified Name:     sgb
 * JD-Core Version:    0.7.0.1
 */