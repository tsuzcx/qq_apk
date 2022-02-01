package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.RoomInterceptCheckCallback;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

final class TeamConfigPageHelper$1
  implements RoomInterceptCheckCallback
{
  TeamConfigPageHelper$1(int paramInt1, int paramInt2, long paramLong1, GuildShequnParams paramGuildShequnParams, Activity paramActivity, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, String paramString) {}
  
  public void a()
  {
    Object localObject1 = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a().getValue();
    if (localObject1 != null)
    {
      localObject1 = ((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)localObject1).role_info;
      if (SmobaConfigManager.a().b() == null)
      {
        CustomToastView.a("获取数据失败");
        return;
      }
      if (localObject1 != null)
      {
        Object localObject2 = TeamConfigBean.a(((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).big_grade_level.get(), this.a, this.b, this.c, this.d);
        Activity localActivity = this.e;
        TeamConfigDialog.a(localActivity, (TeamConfigBean)localObject2, TeamConfigPageHelper.a(localActivity, 0L, this.f, this.g, this.h)).show();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestDefaultSmobaAccountFromServer success: big_grade_level == ");
        ((StringBuilder)localObject2).append(((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).big_grade_level.get());
        Logger.a("TeamConfigPageHelper", ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      CustomToastView.a("获取角色信息失败");
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoomInterceptCheck checkFail - ");
    localStringBuilder.append(paramString);
    Logger.a("TeamConfigPageHelper", localStringBuilder.toString());
  }
  
  public void b()
  {
    Logger.a("TeamConfigPageHelper", "enterRoomInterceptCheck SameRoomClick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigPageHelper.1
 * JD-Core Version:    0.7.0.1
 */