import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;

public class sdp
  implements Runnable
{
  public sdp(ChatHistory paramChatHistory) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      ThreadManager.post(new sdq(this), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdp
 * JD-Core Version:    0.7.0.1
 */