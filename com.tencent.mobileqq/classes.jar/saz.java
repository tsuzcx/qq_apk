import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class saz
  implements Runnable
{
  public saz(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_photo_message", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "从群空间返回，更新群空间未读计数， troopuin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ", unreadmsgnum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum + ", newphotonum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saz
 * JD-Core Version:    0.7.0.1
 */