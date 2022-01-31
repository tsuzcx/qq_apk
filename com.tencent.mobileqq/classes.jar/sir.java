import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class sir
  implements Runnable
{
  public sir(ChatSettingForTroop paramChatSettingForTroop, TroopManager paramTroopManager) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = ((TroopMemberInfo)localObject).troopnick;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.runOnUiThread(new sis(this, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sir
 * JD-Core Version:    0.7.0.1
 */