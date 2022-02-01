package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

final class TeamUtil$5
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  TeamUtil$5(Activity paramActivity, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString)
  {
    LoadingUtils.a.b(this.a);
    Object localObject = TeamUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leave room failed : errorCode == ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",errorMessage == ");
    localStringBuilder.append(paramString);
    Logger.c((String)localObject, localStringBuilder.toString());
    localObject = this.b;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    LoadingUtils.a.b(this.a);
    Logger.a(TeamUtil.a(), "leave room success");
    IResultListener localIResultListener = this.b;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomLeaveRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamUtil.5
 * JD-Core Version:    0.7.0.1
 */