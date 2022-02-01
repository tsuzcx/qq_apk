package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

final class TeamConfigPageHelper$2
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  TeamConfigPageHelper$2(long paramLong, Activity paramActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    if ((paramBoolean) && (paramGetSmobaDefaultRoleRsp != null))
    {
      paramString = paramGetSmobaDefaultRoleRsp.role_info;
      if (paramString != null)
      {
        paramGetSmobaDefaultRoleRsp = new StringBuilder();
        paramGetSmobaDefaultRoleRsp.append("requestDefaultSmobaAccountFromServer success: big_grade_level == ");
        paramGetSmobaDefaultRoleRsp.append(paramString.big_grade_level.get());
        Logger.a("TeamConfigPageHelper", paramGetSmobaDefaultRoleRsp.toString());
        paramGetSmobaDefaultRoleRsp = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.a).g();
        if ((paramGetSmobaDefaultRoleRsp != null) && (paramGetSmobaDefaultRoleRsp.grade_list.size() != 0))
        {
          if (SmobaConfigManager.a().b() == null)
          {
            CustomToastView.a("获取数据失败");
            return;
          }
          paramString = TeamConfigBean.a(((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.a).b().introduce.get(), paramGetSmobaDefaultRoleRsp.game_mode.get(), ((Integer)paramGetSmobaDefaultRoleRsp.grade_list.get(0)).intValue(), ((Integer)paramGetSmobaDefaultRoleRsp.grade_list.get(paramGetSmobaDefaultRoleRsp.grade_list.size() - 1)).intValue(), paramString.big_grade_level.get(), this.a, paramGetSmobaDefaultRoleRsp.need_lane_type.get());
          paramGetSmobaDefaultRoleRsp = (ITeamService)ServiceCenter.a(ITeamService.class);
          Activity localActivity = this.b;
          paramGetSmobaDefaultRoleRsp.a(localActivity, paramString, TeamConfigPageHelper.a(localActivity, this.a, 0L, null, ""));
          return;
        }
        CustomToastView.a("获取房间信息失败");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigPageHelper.2
 * JD-Core Version:    0.7.0.1
 */