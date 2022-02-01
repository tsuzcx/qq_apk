package com.tencent.timi.game.component.qqlive.impl.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.timi.game.component.qqlive.api.TgCheckPermissionCallback;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveAnchorRoomManager$3
  implements TgCheckPermissionCallback
{
  TgLiveAnchorRoomManager$3(TgLiveAnchorRoomManager paramTgLiveAnchorRoomManager, QQLiveAnchorRecord paramQQLiveAnchorRecord) {}
  
  public void a()
  {
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan checkPermission success");
    TgLiveAnchorRoomManager.a(this.b, this.a);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeRoomIfCan onError errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
    if (TgLiveAnchorRoomManager.b(this.b) != null)
    {
      TgLiveAnchorRoomManager.b(this.b).a(paramInt, paramString);
      TgLiveAnchorRoomManager.b(this.b).a(1, paramInt, paramString);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeRoomIfCan onCheckFail - ");
    localStringBuilder.append(paramArrayOfString);
    Logger.c("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
    if (TgLiveAnchorRoomManager.b(this.b) != null)
    {
      TgLiveAnchorRoomManager.b(this.b).a(-1000, "需要确认授权才能正常开播哦");
      TgLiveAnchorRoomManager.b(this.b).a(1, -1000, "需要确认授权才能正常开播哦");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager.3
 * JD-Core Version:    0.7.0.1
 */