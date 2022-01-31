import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class kqe
  implements Runnable
{
  kqe(kqd paramkqd, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
    }
    AccountDetailBaseInfoModel.a(this.jdField_a_of_type_Kqd.a, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqe
 * JD-Core Version:    0.7.0.1
 */