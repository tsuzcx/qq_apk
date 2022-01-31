import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.qphone.base.util.QLog;

public class ksm
  implements Runnable
{
  public ksm(AccountDetailDynamicDataManager paramAccountDetailDynamicDataManager, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailDynamicDataManager.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksm
 * JD-Core Version:    0.7.0.1
 */