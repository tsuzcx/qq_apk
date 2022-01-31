import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;

class smj
  implements Runnable
{
  smj(smi paramsmi, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Smi.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      this.jdField_a_of_type_Smi.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (this.jdField_a_of_type_Smi.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Smi.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(32, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smj
 * JD-Core Version:    0.7.0.1
 */