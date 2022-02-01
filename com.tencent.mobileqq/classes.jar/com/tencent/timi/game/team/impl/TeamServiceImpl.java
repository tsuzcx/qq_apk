package com.tencent.timi.game.team.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.team.impl.floating.TeamFloatingView;
import com.tencent.timi.game.team.impl.main.TeamConfigBean;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog.OnActionClickListener;
import com.tencent.timi.game.team.impl.main.TeamConfigPageHelper;
import com.tencent.timi.game.utils.Logger;
import mqq.app.MobileQQ;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamServiceImpl
  implements ITeamService
{
  public IFloatView a(long paramLong)
  {
    TeamFloatingView localTeamFloatingView = new TeamFloatingView(MobileQQ.context);
    localTeamFloatingView.a(paramLong);
    return localTeamFloatingView;
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, long paramLong, GuildShequnParams paramGuildShequnParams)
  {
    TeamConfigPageHelper.a(paramActivity, paramInt1, paramInt2, paramLong, paramGuildShequnParams, 0L, null, "");
  }
  
  public void a(Activity paramActivity, long paramLong1, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, String paramString, GuildShequnParams paramGuildShequnParams)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
    if (localYoloRoomInfo != null)
    {
      TeamConfigPageHelper.a(localYoloRoomInfo, paramLong2, paramQQUserId, paramString);
      return;
    }
    TeamConfigPageHelper.a(paramActivity, 1, 1, paramLong1, paramGuildShequnParams, paramLong2, paramQQUserId, paramString);
  }
  
  public void a(Activity paramActivity, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener)
  {
    TeamConfigDialog.b(paramActivity, paramTeamConfigBean, paramOnActionClickListener).show();
  }
  
  public void a(Context paramContext) {}
  
  public void a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    TeamActivity.a(paramContext, paramYoloRoomInfo, paramInt);
  }
  
  public boolean a()
  {
    Object localObject = (IRoomService)ServiceCenter.a(IRoomService.class);
    boolean bool = true;
    if (((IRoomService)localObject).a(1) == null) {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isInSmobaTeam ");
    ((StringBuilder)localObject).append(bool);
    Logger.a("TeamServiceImpl", ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void b(Context paramContext) {}
  
  public boolean b(long paramLong)
  {
    return ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).f() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamServiceImpl
 * JD-Core Version:    0.7.0.1
 */