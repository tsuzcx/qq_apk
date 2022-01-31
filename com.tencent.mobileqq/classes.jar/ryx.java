import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;

public class ryx
  implements Runnable
{
  public ryx(ChatHistory paramChatHistory) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      ThreadManager.post(new ryy(this), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryx
 * JD-Core Version:    0.7.0.1
 */