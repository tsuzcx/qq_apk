package com.tencent.timi.game.component.qqlive.impl.audience;

import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveAudienceRoomManager$1
  implements EnterAudienceRoomCallback
{
  TgLiveAudienceRoomManager$1(TgLiveAudienceRoomManager paramTgLiveAudienceRoomManager, long paramLong, IResultListener paramIResultListener) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterRoom fail code ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", ((StringBuilder)localObject).toString());
    TgLiveRoomUIData.a().b(Boolean.valueOf(false));
    localObject = this.b;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    if ((paramLiveInfo != null) && (paramLiveInfo.roomInfo != null) && (paramLiveInfo.anchorInfo != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("audienceEnterRoom success, roomId - ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" - roomName=");
      ((StringBuilder)localObject).append(paramLiveInfo.roomInfo.roomName);
      ((StringBuilder)localObject).append(" - anchorUid=");
      ((StringBuilder)localObject).append(paramLiveInfo.anchorInfo.uid);
      ((StringBuilder)localObject).append(" - bizId=");
      ((StringBuilder)localObject).append(paramLiveInfo.anchorInfo.businessUid);
      ((StringBuilder)localObject).append(" - name=");
      ((StringBuilder)localObject).append(paramLiveInfo.anchorInfo.nickName);
      Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterRoom success, roomId - ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(paramLiveInfo);
      Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", ((StringBuilder)localObject).toString());
    }
    if (TgLiveAudienceRoomManager.a(this.c) == null)
    {
      QLog.d("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "enterRoom mLiveAudienceRoom == null, ignore callback.");
      return;
    }
    TgLiveAudienceRoomManager.a(this.c, paramLiveInfo);
    Object localObject = this.b;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramLiveInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager.1
 * JD-Core Version:    0.7.0.1
 */