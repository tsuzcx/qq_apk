import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

public class kpn
  implements Runnable
{
  public kpn(EqqAccountDetailActivity paramEqqAccountDetailActivity, EqqDetail paramEqqDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "updateDetailInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      if (this.jdField_a_of_type_Boolean) {
        EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity).sendEmptyMessage(1);
      }
    }
    else
    {
      return;
    }
    EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, new kpo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpn
 * JD-Core Version:    0.7.0.1
 */