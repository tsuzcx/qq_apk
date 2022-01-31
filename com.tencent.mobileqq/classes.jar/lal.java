import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class lal
  implements Runnable
{
  public lal(EcShopAssistantManager paramEcShopAssistantManager, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a.getEntityManagerFactory().createEntityManager();
    if (EcShopAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager, localEntityManager, this.jdField_a_of_type_JavaLangString)) {
      EcShopAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager, this.jdField_a_of_type_JavaLangString);
    }
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lal
 * JD-Core Version:    0.7.0.1
 */