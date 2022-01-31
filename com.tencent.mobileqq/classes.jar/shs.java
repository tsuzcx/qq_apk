import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;

class shs
  implements Runnable
{
  shs(shq paramshq, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Shq.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      this.jdField_a_of_type_Shq.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (this.jdField_a_of_type_Shq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Shq.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(32, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Shq.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shs
 * JD-Core Version:    0.7.0.1
 */