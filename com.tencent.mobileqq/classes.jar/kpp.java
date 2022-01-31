import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

public class kpp
  implements Runnable
{
  public kpp(EqqAccountDetailActivity paramEqqAccountDetailActivity, EqqDetail paramEqqDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "saveEqqDetailInSubThread");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpp
 * JD-Core Version:    0.7.0.1
 */