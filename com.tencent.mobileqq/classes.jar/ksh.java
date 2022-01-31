import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

public class ksh
  implements Runnable
{
  public ksh(AccountDetailActivity paramAccountDetailActivity, AccountDetail paramAccountDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs)) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    AccountDetailActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, new ksi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksh
 * JD-Core Version:    0.7.0.1
 */