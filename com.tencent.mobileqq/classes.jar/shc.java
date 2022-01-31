import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class shc
  implements Runnable
{
  public shc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    String str = null;
    try
    {
      Object localObject = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.getCurrentAccountUin());
      if (localObject == null)
      {
        localObject = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.getCurrentAccountUin());
        if (localObject == null) {}
      }
      for (str = ((TroopMemberInfo)localObject).troopnick;; str = ((TroopMemberCardInfo)localObject).name)
      {
        if (!TextUtils.isEmpty(str))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = str;
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_photo_message", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_photo_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "初始化，群空间未读计数， troopuin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ", unreadmsgnum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum + ", newphotonum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_file_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_notification_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isGameTroop()) {
          this.a.m = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        this.a.c();
        this.a.z();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
        this.a.app.d(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.e("Q.chatopttroop", 4, localNumberFormatException.toString());
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.e("Q.chatopttroop", 4, localIllegalArgumentException.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.e("Q.chatopttroop", 4, localException.toString());
        return;
      }
    }
    catch (Error localError)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.chatopttroop", 4, localError.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shc
 * JD-Core Version:    0.7.0.1
 */