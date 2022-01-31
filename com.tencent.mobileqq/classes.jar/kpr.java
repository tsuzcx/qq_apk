import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class kpr
  implements Runnable
{
  public kpr(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "updateUnfollowInfo");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    try
    {
      EqqAccountDetailActivity.a(this.a).b(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.a.d(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      EqqAccountDetailActivity.b(this.a).sendEmptyMessage(2);
      EqqAccountDetailActivity.b(this.a).a().a(EqqAccountDetailActivity.b(this.a), EqqAccountDetailActivity.c(this.a));
      EqqAccountDetailActivity.c(this.a).a().a(EqqAccountDetailActivity.c(this.a), 1024);
      EqqAccountDetailActivity.d(this.a).a().a(EqqAccountDetailActivity.d(this.a), 0);
      ReportController.b(EqqAccountDetailActivity.e(this.a), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.e(this.a), "0X8004E43", "0X8004E43", 0, 0, EqqAccountDetailActivity.f(this.a), "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpr
 * JD-Core Version:    0.7.0.1
 */