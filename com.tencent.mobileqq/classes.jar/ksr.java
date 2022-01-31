import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

public class ksr
  implements Runnable
{
  public ksr(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateFollowInfo");
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.a.d();
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null) {}
    for (int i = 1;; i = 0)
    {
      PAStartupTracker.a("pubAcc_follow_confirm", null, this.a.d);
      if ((i != 0) && (!AccountDetailActivity.a(this.a))) {
        AccountDetailActivity.a(this.a, new kss(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksr
 * JD-Core Version:    0.7.0.1
 */