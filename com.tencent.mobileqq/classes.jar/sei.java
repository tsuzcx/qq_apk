import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

public class sei
  implements Runnable
{
  public sei(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (this.a.app != null) {
      ((TroopManager)this.a.app.getManager(51)).b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sei
 * JD-Core Version:    0.7.0.1
 */