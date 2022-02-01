package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopSettingActivity$29
  extends TroopRedDotObserver
{
  TroopSettingActivity$29(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt)
  {
    if (this.a.i == null) {
      return;
    }
    if ((paramBoolean1) && (paramList != null))
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        TroopUnreadMsgInfo localTroopUnreadMsgInfo = (TroopUnreadMsgInfo)paramList.get(paramInt);
        if ((localTroopUnreadMsgInfo != null) && (Utils.a(localTroopUnreadMsgInfo.b, this.a.i.troopUin)))
        {
          Object localObject;
          if (localTroopUnreadMsgInfo.a == 2L)
          {
            this.a.i.nNewPhotoNum = localTroopUnreadMsgInfo.d;
            this.a.i.nUnreadMsgNum = localTroopUnreadMsgInfo.c;
            this.a.aD.sendEmptyMessage(4);
            if (paramBoolean2)
            {
              localObject = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
              TroopSettingActivity localTroopSettingActivity = this.a;
              ((IChatSettingForTroopApi)localObject).sendBroadcastQunMsgUnreadCount(localTroopSettingActivity, localTroopSettingActivity.i.nUnreadMsgNum);
            }
          }
          else if (localTroopUnreadMsgInfo.a == 1L)
          {
            this.a.i.nUnreadFileMsgnum = localTroopUnreadMsgInfo.c;
            this.a.i.nNewFileMsgNum = localTroopUnreadMsgInfo.d;
            this.a.aD.sendEmptyMessage(8);
          }
          else if (localTroopUnreadMsgInfo.a == 1101236949L)
          {
            this.a.i.mNewTroopNotificationNum = localTroopUnreadMsgInfo.d;
            this.a.aD.sendEmptyMessage(9);
          }
          else if (localTroopUnreadMsgInfo.a == 1106664488L)
          {
            this.a.i.nUnreadFileMsgnum = 1;
            this.a.i.nNewFileMsgNum = localTroopUnreadMsgInfo.d;
            this.a.aD.sendEmptyMessage(8);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onUpdateTroopUnreadMsg| isPush = ");
            ((StringBuilder)localObject).append(paramBoolean2);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(localTroopUnreadMsgInfo);
            QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
          }
        }
        paramInt += 1;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
    TroopSettingActivity.q(this.a);
    if (paramBoolean)
    {
      this.a.i.nNewFileMsgNum = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(TroopSettingActivity.a(this.a).getCurrentAccountUin(), "troop_file_new", this.a.i.troopUin);
      this.a.i.nUnreadFileMsgnum = 0;
      this.a.aD.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.29
 * JD-Core Version:    0.7.0.1
 */