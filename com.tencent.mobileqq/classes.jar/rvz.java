import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;

public class rvz
  implements Runnable
{
  public rvz(ChatHistory paramChatHistory) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      ThreadManager.post(new rwa(this), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvz
 * JD-Core Version:    0.7.0.1
 */