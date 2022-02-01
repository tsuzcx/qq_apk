package com.tencent.timi.game.team.impl.main;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

final class TeamConfigPageHelper$5
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  TeamConfigPageHelper$5(long paramLong, CommonOuterClass.QQUserId paramQQUserId, String paramString, TeamConfigDialog paramTeamConfigDialog) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createSmobaRoom : errorCode == ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",errorMessage == ");
    localStringBuilder.append(paramString);
    Logger.c("TeamConfigPageHelper", localStringBuilder.toString());
    this.d.r();
    this.d.dismiss();
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("testRoom CREATE SUCCESS - ");
    ((StringBuilder)localObject).append(paramYoloRoomInfo);
    Logger.a("TeamConfigPageHelper", ((StringBuilder)localObject).toString());
    long l = this.a;
    if (l != 0L)
    {
      localObject = this.b;
      if (localObject != null)
      {
        TeamConfigPageHelper.a(paramYoloRoomInfo, l, (CommonOuterClass.QQUserId)localObject, this.c);
        break label75;
      }
    }
    CustomToastView.a("创建车队成功");
    label75:
    this.d.dismiss();
    this.d.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigPageHelper.5
 * JD-Core Version:    0.7.0.1
 */