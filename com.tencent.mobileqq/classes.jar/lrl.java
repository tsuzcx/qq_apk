import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class lrl
  implements Runnable
{
  public lrl(SubscriptionInfoModule paramSubscriptionInfoModule) {}
  
  public void run()
  {
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    SubscriptionInfoModule.a(this.a, localTroopBarAssistantManager.b((QQAppInterface)this.a.a));
    this.a.a(SubscriptionInfoModule.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrl
 * JD-Core Version:    0.7.0.1
 */