import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.qphone.base.util.QLog;

public class krk
  implements Runnable
{
  public krk(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "updateFollowInfo");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      EqqAccountDetailActivity.b(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.a.d();
      EnterpriseQQManager.a(EqqAccountDetailActivity.g(this.a)).a(EqqAccountDetailActivity.f(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
      if (EqqAccountDetailActivity.a(this.a) != null) {
        break label130;
      }
    }
    for (;;)
    {
      if (i != 0) {
        EqqAccountDetailActivity.b(this.a, new krl(this));
      }
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     krk
 * JD-Core Version:    0.7.0.1
 */