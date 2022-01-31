import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class kqt
  implements Runnable
{
  kqt(kqs paramkqs, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
    }
    AccountDetailBaseInfoModel.a(this.jdField_a_of_type_Kqs.a, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqt
 * JD-Core Version:    0.7.0.1
 */