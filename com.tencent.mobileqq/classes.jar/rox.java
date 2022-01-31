import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

public class rox
  implements Runnable
{
  public rox(BaseChatPie paramBaseChatPie, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(40, localExtensionInfo.audioPanelType, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rox
 * JD-Core Version:    0.7.0.1
 */