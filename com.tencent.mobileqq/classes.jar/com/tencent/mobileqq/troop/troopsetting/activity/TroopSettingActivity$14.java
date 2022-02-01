package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$14
  implements Runnable
{
  TroopSettingActivity$14(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mInitRunnable and init cardInfo");
      }
      this.this$0.r();
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nUnreadMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_photo_message", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nNewPhotoNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_photo_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("初始化，群空间未读计数， troopuin = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        localStringBuilder.append(", unreadmsgnum = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nUnreadMsgNum);
        localStringBuilder.append(", newphotonum = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nNewPhotoNum);
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nNewFileMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_file_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nUnreadFileMsgnum = 0;
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mNewTroopNotificationNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_notification_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      this.this$0.b();
      this.this$0.p();
      TroopSettingActivity.a(this.this$0, 0, false);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      TroopSettingActivity.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      TroopSettingActivity.c(this.this$0);
      return;
    }
    catch (Error localError)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.e("Q.chatopttroop", 4, localError.toString());
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
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.e("Q.chatopttroop", 4, localIllegalArgumentException.toString());
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.chatopttroop", 4, localNumberFormatException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */