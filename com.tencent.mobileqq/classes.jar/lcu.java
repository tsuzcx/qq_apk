import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityManagerFactory;

public class lcu
  implements Runnable
{
  public lcu(PublicAccountEntityHelper paramPublicAccountEntityHelper, PublicAccountEntityManagerFactory paramPublicAccountEntityManagerFactory) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPersistenceManagerPublicAccountEntityManagerFactory.verifyAuthentication();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcu
 * JD-Core Version:    0.7.0.1
 */