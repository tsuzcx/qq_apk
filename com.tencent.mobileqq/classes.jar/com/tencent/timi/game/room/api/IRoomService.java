package com.tencent.timi.game.room.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public abstract interface IRoomService
  extends IService
{
  public abstract IRoomGetDataService a(long paramLong);
  
  public abstract YoloRoomOuterClass.YoloRoomInfo a(int paramInt);
  
  public abstract void a();
  
  public abstract void a(long paramLong, IRoomPage paramIRoomPage);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(long paramLong, boolean paramBoolean1, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener, boolean paramBoolean2);
  
  public abstract void a(Activity paramActivity, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener);
  
  public abstract void a(Activity paramActivity, RoomInterceptCheckParam paramRoomInterceptCheckParam, RoomInterceptCheckCallback paramRoomInterceptCheckCallback);
  
  public abstract void a(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener);
  
  public abstract void a(IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp> paramIResultListener);
  
  public abstract void a(boolean paramBoolean1, Activity paramActivity, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList, boolean paramBoolean2, GuildShequnParams paramGuildShequnParams, long paramLong2, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener);
  
  public abstract void a(boolean paramBoolean, YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener);
  
  public abstract boolean a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt);
  
  public abstract IRoomDoOpService b(long paramLong);
  
  public abstract void b();
  
  public abstract void b(long paramLong, IRoomPage paramIRoomPage);
  
  public abstract void b(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener);
  
  public abstract boolean b(int paramInt);
  
  public abstract IRoomCommonConf c();
  
  public abstract IRoomListenerService c(long paramLong);
  
  public abstract IRoomAudioService d(long paramLong);
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.IRoomService
 * JD-Core Version:    0.7.0.1
 */