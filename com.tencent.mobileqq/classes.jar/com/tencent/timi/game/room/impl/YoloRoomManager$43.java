package com.tencent.timi.game.room.impl;

import android.text.TextUtils;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction;

class YoloRoomManager$43
  implements IResultListener<IUserInfo>
{
  YoloRoomManager$43(YoloRoomManager paramYoloRoomManager, YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction paramYoloSmobaRoomOwnerChangeAction) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null) {
      paramIUserInfo = paramIUserInfo.c(this.a.to_user_id);
    } else {
      paramIUserInfo = "";
    }
    if (!TextUtils.isEmpty(paramIUserInfo))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("队长已离开队伍，已转移给 ");
      localStringBuilder.append(paramIUserInfo);
      paramIUserInfo = localStringBuilder.toString();
    }
    else
    {
      paramIUserInfo = "队长已离开队伍，队长已转移";
    }
    CustomToastView.a(paramIUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.43
 * JD-Core Version:    0.7.0.1
 */