import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;

public class sac
  implements Runnable
{
  public sac(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sac
 * JD-Core Version:    0.7.0.1
 */