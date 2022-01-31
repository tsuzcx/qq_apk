import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.statistics.ReportController;

public class rfp
  implements View.OnClickListener
{
  public rfp(AboutActivity paramAboutActivity, TimUpgradeHongdianManager paramTimUpgradeHongdianManager) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqManagersTimUpgradeHongdianManager.d))
    {
      ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getManager(255)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_ComTencentMobileqqManagersTimUpgradeHongdianManager.d);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersTimUpgradeHongdianManager.a();
    AboutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfp
 * JD-Core Version:    0.7.0.1
 */