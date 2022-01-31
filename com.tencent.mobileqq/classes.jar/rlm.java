import android.os.Handler;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class rlm
  implements Runnable
{
  public rlm(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
    this.a.a.sendMessage(this.a.a.obtainMessage(2, Boolean.valueOf(localCard.medalSwitchDisable)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlm
 * JD-Core Version:    0.7.0.1
 */