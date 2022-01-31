import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class mro
  implements Runnable
{
  public mro(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    ((PublicAccountDataManager)this.a.app.getManager(55)).a();
    TroopBarAssistantManager.a().c(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mro
 * JD-Core Version:    0.7.0.1
 */