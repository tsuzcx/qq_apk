package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$49
  implements Runnable
{
  TroopSettingActivity$49(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nUnreadMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_photo_message", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("从群空间返回，更新群空间未读计数， troopuin = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        localStringBuilder.append(", unreadmsgnum = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nUnreadMsgNum);
        localStringBuilder.append(", newphotonum = ");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nNewPhotoNum);
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.49
 * JD-Core Version:    0.7.0.1
 */