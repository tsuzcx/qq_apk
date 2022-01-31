import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class sed
  implements Runnable
{
  public sed(ChatSettingForTroop paramChatSettingForTroop, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getExtras().getStringArrayList("param_admins");
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.coverAdministrators(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidOsHandler.post(new see(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, localException, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sed
 * JD-Core Version:    0.7.0.1
 */