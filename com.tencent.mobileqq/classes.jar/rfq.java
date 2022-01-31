import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import protocol.KQQConfig.UpgradeInfo;

public class rfq
  implements View.OnClickListener
{
  public rfq(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (MyAppApi.a().b())
    {
      if (SPSettings.a()) {
        i = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      paramView = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      paramView.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      paramView.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      paramView.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      paramView.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(paramView);
      }
    }
    do
    {
      do
      {
        return;
        if ((AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null) || (!SPSettings.a(AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.a))) {
          break;
        }
        if (SPSettings.a()) {
          i = 1;
        }
        ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
        paramView = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
        paramView.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
        paramView.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
        paramView.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
        paramView.putExtra("activity_type", 4096);
      } while (BaseActivity.sTopActivity == null);
      BaseActivity.sTopActivity.startActivity(paramView);
      return;
    } while ((AboutActivity.a(this.a) == null) || (AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null));
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", UpgradeController.a(), "");
    UpgradeDetailActivity.a(this.a, UpgradeController.a().a(), false, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfq
 * JD-Core Version:    0.7.0.1
 */