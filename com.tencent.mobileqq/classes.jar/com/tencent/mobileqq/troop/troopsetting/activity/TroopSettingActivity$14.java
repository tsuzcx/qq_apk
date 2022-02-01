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
      this.this$0.s();
      this.this$0.i.nUnreadMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_photo_message", this.this$0.i.troopUin);
      this.this$0.i.nNewPhotoNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_photo_new", this.this$0.i.troopUin);
      this.this$0.aD.sendEmptyMessage(4);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("初始化，群空间未读计数， troopuin = ");
        localStringBuilder.append(this.this$0.i.troopUin);
        localStringBuilder.append(", unreadmsgnum = ");
        localStringBuilder.append(this.this$0.i.nUnreadMsgNum);
        localStringBuilder.append(", newphotonum = ");
        localStringBuilder.append(this.this$0.i.nNewPhotoNum);
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      this.this$0.i.nNewFileMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_file_new", this.this$0.i.troopUin);
      this.this$0.i.nUnreadFileMsgnum = 0;
      this.this$0.aD.sendEmptyMessage(8);
      this.this$0.i.mNewTroopNotificationNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.this$0).getCurrentAccountUin(), "troop_notification_new", this.this$0.i.troopUin);
      this.this$0.aD.sendEmptyMessage(9);
      this.this$0.c();
      this.this$0.q();
      TroopSettingActivity.a(this.this$0, 0, false);
      this.this$0.aD.sendEmptyMessage(17);
      TroopSettingActivity.a(this.this$0, this.this$0.i.troopUin);
      TroopSettingActivity.f(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */