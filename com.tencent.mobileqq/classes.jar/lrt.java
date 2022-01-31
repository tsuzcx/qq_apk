import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class lrt
  implements Runnable
{
  public lrt(SubscriptionInfoModule paramSubscriptionInfoModule) {}
  
  public void run()
  {
    ((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(55)).a();
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    localTroopBarAssistantManager.c((QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localTroopBarAssistantManager.a((QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localTroopBarAssistantManager.a(this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrt
 * JD-Core Version:    0.7.0.1
 */