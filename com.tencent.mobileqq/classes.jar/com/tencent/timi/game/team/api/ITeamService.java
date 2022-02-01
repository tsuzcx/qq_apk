package com.tencent.timi.game.team.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.team.impl.main.TeamConfigBean;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog.OnActionClickListener;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public abstract interface ITeamService
  extends IService
{
  public abstract IFloatView a(long paramLong);
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, long paramLong, GuildShequnParams paramGuildShequnParams);
  
  public abstract void a(Activity paramActivity, long paramLong1, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, String paramString, GuildShequnParams paramGuildShequnParams);
  
  public abstract void a(Activity paramActivity, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener);
  
  public abstract void a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt);
  
  public abstract boolean a();
  
  public abstract void b(Context paramContext);
  
  public abstract boolean b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.api.ITeamService
 * JD-Core Version:    0.7.0.1
 */