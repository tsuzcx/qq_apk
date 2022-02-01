package com.tencent.timi.game.room.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomPage;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.RoomInterceptCheckCallback;
import com.tencent.timi.game.room.api.RoomInterceptCheckParam;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.room.api.wrapper.IRoomLiveVideoService;
import com.tencent.timi.game.room.api.wrapper.IRoomPushHandlerService;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;
import com.tencent.timi.game.room.impl.test.TimiRoomTestFragment;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public class RoomServiceImpl
  implements IRoomService
{
  INewMsgListener a = new RoomServiceImpl.1(this);
  private IRoomGetDataService b = new RoomServiceImpl.3(this);
  private IRoomDoOpService c = new RoomServiceImpl.4(this);
  private IRoomListenerService d = new RoomServiceImpl.5(this);
  private IRoomAudioService e = new RoomServiceImpl.6(this);
  private IRoomLiveVideoService f = new RoomServiceImpl.7(this);
  private IRoomPushHandlerService g = new RoomServiceImpl.8(this);
  
  public IRoomGetDataService a(long paramLong)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null) {
      return localYoloRoomManager;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - IRoomGetDataService");
    return this.b;
  }
  
  public YoloRoomOuterClass.YoloRoomInfo a(int paramInt)
  {
    return YoloRoomList.a().a(paramInt);
  }
  
  public void a() {}
  
  public void a(long paramLong, IRoomPage paramIRoomPage)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null)
    {
      localYoloRoomManager.a(true, paramIRoomPage);
      return;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - notifyRoomPageOpen");
  }
  
  public void a(long paramLong, IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp> paramIResultListener)
  {
    YoloRoomUtil.a(paramLong, paramIResultListener);
  }
  
  public void a(long paramLong, String paramString)
  {
    YoloRoomManager.b(paramString);
  }
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener, boolean paramBoolean2)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null)
    {
      localYoloRoomManager.a(paramBoolean1, paramInt, paramIResultListener, paramBoolean2);
      return;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - leaveRoom");
  }
  
  public void a(Activity paramActivity, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    YoloRoomUtil.a(paramActivity, paramInt, 5, false, paramIResultListener);
  }
  
  public void a(Activity paramActivity, RoomInterceptCheckParam paramRoomInterceptCheckParam, RoomInterceptCheckCallback paramRoomInterceptCheckCallback)
  {
    YoloRoomUtil.a(paramActivity, paramRoomInterceptCheckParam, paramRoomInterceptCheckCallback);
  }
  
  public void a(Context paramContext) {}
  
  public void a(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    YoloRoomList.a().a(paramYoloRoomLifecycleListener);
  }
  
  public void a(IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp> paramIResultListener)
  {
    a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), paramIResultListener);
  }
  
  public void a(boolean paramBoolean1, Activity paramActivity, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList, boolean paramBoolean2, GuildShequnParams paramGuildShequnParams, long paramLong2, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    YoloRoomUtil.a(paramBoolean1, paramActivity, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramList, paramBoolean2, paramGuildShequnParams, paramLong2, paramIResultListener);
  }
  
  public void a(boolean paramBoolean, YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    YoloRoomUtil.a(paramBoolean, 1, paramYoloRoomParams, paramYoloSmobaRoomParams, null, null, new RoomServiceImpl.2(this, paramIResultListener));
  }
  
  public boolean a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    return YoloRoomUtil.a(paramContext, paramYoloRoomInfo, paramInt);
  }
  
  public IRoomDoOpService b(long paramLong)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null) {
      return localYoloRoomManager;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - IRoomDoOpService");
    return this.c;
  }
  
  public void b()
  {
    YoloRoomList.a().c();
  }
  
  public void b(long paramLong, IRoomPage paramIRoomPage)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null)
    {
      localYoloRoomManager.a(false, paramIRoomPage);
      return;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - notifyRoomPageClose");
  }
  
  public void b(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    YoloRoomList.a().b(paramYoloRoomLifecycleListener);
  }
  
  public boolean b(int paramInt)
  {
    return YoloRoomMediaLogic.c(paramInt);
  }
  
  public IRoomCommonConf c()
  {
    return YoloRoomCommonConfManager.a;
  }
  
  public IRoomListenerService c(long paramLong)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null) {
      return localYoloRoomManager;
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - IRoomListenerService");
    return this.d;
  }
  
  public IRoomAudioService d(long paramLong)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramLong);
    if (localYoloRoomManager != null) {
      return localYoloRoomManager.F();
    }
    Logger.c("RoomServiceImpl", "YoloRoomManager is null! - IRoomAudioService");
    return this.e;
  }
  
  public void d()
  {
    TimiRoomTestFragment.a(TimiGameActivityManager.a());
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.RoomServiceImpl
 * JD-Core Version:    0.7.0.1
 */