import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ksn
  implements Runnable
{
  public ksn(AccountDetailDynamicDataManager paramAccountDetailDynamicDataManager, long paramLong, QQAppInterface paramQQAppInterface, PublicAccountObserver paramPublicAccountObserver) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)AccountDetailDynamicDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailDynamicDataManager).a(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = AccountDetailDynamicDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((AccountDetailDynamicInfo)localObject).a().isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksn
 * JD-Core Version:    0.7.0.1
 */