import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class sdb
  implements Runnable
{
  sdb(sda paramsda, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_Sda.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_Sda.a.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, 2);
    this.jdField_a_of_type_Sda.a.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, localMessage);
    ReportController.b(this.jdField_a_of_type_Sda.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdb
 * JD-Core Version:    0.7.0.1
 */