import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class smr
  extends RegisterProxySvcPackObserver
{
  public smr(Conversation paramConversation) {}
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onSelfPcOnlineStatusBanner int iState = " + paramInt + ", long clientType = " + paramLong1 + ", long appId" + paramLong2);
    }
    if (paramInt == 1)
    {
      if (paramLong1 == 77313L)
      {
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.c)
        {
          SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d = localSharedPreferences.getBoolean("tim_pc_banner_switch", false);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.c = true;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d) {
          break label165;
        }
      }
      label165:
      while (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.jdField_b_of_type_Boolean) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.jdField_b_of_type_Long = paramLong1;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a = paramLong2;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(-1, null);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800887F", "0X800887F", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smr
 * JD-Core Version:    0.7.0.1
 */