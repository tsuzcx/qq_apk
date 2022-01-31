import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class sdz
  implements Runnable
{
  public sdz(ChatSettingForTroop paramChatSettingForTroop, TroopManager paramTroopManager) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = ((TroopMemberInfo)localObject).troopnick;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.runOnUiThread(new sea(this, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdz
 * JD-Core Version:    0.7.0.1
 */