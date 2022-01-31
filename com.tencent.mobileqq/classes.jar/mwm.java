import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class mwm
  implements Runnable
{
  mwm(mwl parammwl, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    Object localObject1 = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    Object localObject2 = this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
    if (localObject2 != null) {
      ((EntityManager)localObject2).b((Entity)localObject1);
    }
    if ((this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject2 = (PublicAccountHandler)((QQAppInterface)this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface).a(11);
      if (localObject2 != null) {
        ((PublicAccountHandler)localObject2).a(localObject1);
      }
    }
    if (this.jdField_a_of_type_Mwl.jdField_a_of_type_Int >= 0)
    {
      if (!(this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label139;
      }
      localObject1 = (QQAppInterface)this.jdField_a_of_type_Mwl.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    for (;;)
    {
      PublicAccountReportUtils.a((QQAppInterface)localObject1, this.jdField_a_of_type_Mwl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Mwl.jdField_a_of_type_Int);
      return;
      label139:
      localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
        localObject1 = (QQAppInterface)localObject1;
      } else {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwm
 * JD-Core Version:    0.7.0.1
 */