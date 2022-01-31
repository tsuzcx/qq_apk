import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

public class scw
  implements Runnable
{
  public scw(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    int i = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_game_feed", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(20);
    localMessage.arg1 = i;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scw
 * JD-Core Version:    0.7.0.1
 */