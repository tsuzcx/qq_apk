import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

public class sef
  implements Runnable
{
  public sef(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.getCurrentAccountUin());
    if (localTroopMemberInfo != null)
    {
      String str = localTroopMemberInfo.troopnick;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localTroopMemberInfo.troopnick;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sef
 * JD-Core Version:    0.7.0.1
 */