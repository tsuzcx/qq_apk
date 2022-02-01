package com.tencent.timi.game.component.qqlive.impl.audience;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData;
import com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;

public class TgLiveAudienceRoomManager
  implements ITgLiveAudienceRoomManager
{
  private static volatile TgLiveAudienceRoomManager a;
  private IAudienceRoom b;
  private long c;
  private long d;
  private ConcurrentHashMap<Long, IAudienceRoom> e = new ConcurrentHashMap();
  
  public static TgLiveAudienceRoomManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TgLiveAudienceRoomManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(LiveInfo paramLiveInfo)
  {
    TgLiveRoomUIData.a().b(Boolean.valueOf(true));
    if (paramLiveInfo != null)
    {
      if (paramLiveInfo.roomInfo != null) {
        TgLiveRoomUIData.a().a(paramLiveInfo.roomInfo.roomLogo);
      }
      if (paramLiveInfo.anchorInfo != null) {
        this.c = paramLiveInfo.anchorInfo.uid;
      }
    }
  }
  
  private void d()
  {
    TgLiveRoomListenerHandler.a(this.b);
  }
  
  private void e() {}
  
  private long f()
  {
    IAudienceRoom localIAudienceRoom = this.b;
    if ((localIAudienceRoom != null) && (localIAudienceRoom.getRoomInfo() != null)) {
      return this.b.getRoomInfo().getRoomId();
    }
    return -1L;
  }
  
  public IAudienceRoom a(long paramLong)
  {
    return (IAudienceRoom)this.e.get(Long.valueOf(paramLong));
  }
  
  public IAudienceRoom a(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("audiencePreloadRoom, roomId - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", previewStreamUrl - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", ((StringBuilder)localObject).toString());
    if (!TgLiveRoomCommonManager.a().b())
    {
      Logger.c("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "audiencePreloadRoom, live sdk not init suc.");
      return null;
    }
    localObject = (IAudienceRoom)this.e.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      ((IAudienceRoom)localObject).reset();
      ((IAudienceRoom)localObject).preloadUrl(paramString);
      return localObject;
    }
    localObject = TgLiveRoomCommonManager.a().c().createAudienceRoom();
    ((ITPPlayerVideoView)((IAudienceRoom)localObject).getDisplayView()).setXYAxis(0);
    ((IAudienceRoom)localObject).preloadUrl(paramString);
    this.e.put(Long.valueOf(paramLong), localObject);
    return localObject;
  }
  
  public void a(long paramLong, IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    long l = f();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("audienceExitRoom_ - toExitRoomId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", curRoomInfo = ");
    ((StringBuilder)localObject).append(l);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", ((StringBuilder)localObject).toString());
    if ((paramLong > 0L) && (this.b != null) && (paramLong != l))
    {
      Logger.c("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "audienceExitRoom but not equal!!! ");
      if (paramIResultListener != null) {
        paramIResultListener.a(-1000, "数据异常");
      }
    }
    else
    {
      e();
      localObject = this.b;
      if (localObject != null)
      {
        ((IAudienceRoom)localObject).exitRoom(new TgLiveAudienceRoomManager.2(this, l, paramIResultListener, (IAudienceRoom)localObject));
        this.e.remove(Long.valueOf(l));
        this.b = null;
        this.c = 0L;
        this.d = 0L;
        TgLiveRoomUIData.a().d();
        return;
      }
      if (paramIResultListener != null) {
        paramIResultListener.a(-1001, "数据异常");
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, IResultListener<LiveInfo> paramIResultListener)
  {
    boolean bool = TgLiveUtils.a(false);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("audienceEnterRoom - ");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("- ");
    ((StringBuilder)localObject1).append(bool);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, ((StringBuilder)localObject1).toString());
    if (!bool)
    {
      QLog.i("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "requestAVFocus failure.");
      a(0L, null);
      if (paramIResultListener != null) {
        paramIResultListener.a(-1000, "获取焦点失败");
      }
      return;
    }
    if (!TgLiveRoomCommonManager.a().b())
    {
      QLog.d("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "audienceEnterRoom, live sdk not init suc.");
      if (paramIResultListener != null) {
        paramIResultListener.a(-1001, "业务尚未初始化");
      }
      return;
    }
    if (this.b != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("audienceEnterRoom, AudienceRoom had created, please check it, old = ");
      ((StringBuilder)localObject1).append(f());
      Logger.c("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", ((StringBuilder)localObject1).toString());
      if (f() == paramLong)
      {
        if (paramIResultListener != null) {
          paramIResultListener.a(this.b.getRoomLiveInfo());
        }
        return;
      }
      a(0L, null);
    }
    localObject1 = TgLiveRoomCommonManager.a().c();
    this.d = ((IQQLiveSDK)localObject1).getLoginModule().getUserInfo().uid;
    Object localObject2 = (IAudienceRoom)this.e.get(Long.valueOf(paramLong));
    if (localObject2 != null) {
      this.b = ((IAudienceRoom)localObject2);
    } else {
      this.b = ((IQQLiveSDK)localObject1).createAudienceRoom();
    }
    ((ITPPlayerVideoView)this.b.getDisplayView()).setXYAxis(0);
    TgLiveRoomUIData.a().a(((ITPPlayerVideoView)this.b.getDisplayView()).getCurrentDisplayView());
    d();
    localObject1 = new EnterRoomInfo();
    ((EnterRoomInfo)localObject1).setRoomId(paramLong);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("audienceEnterRoom start, roomId - ");
    ((StringBuilder)localObject2).append(paramLong);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, ((StringBuilder)localObject2).toString());
    this.b.enterRoom((EnterRoomInfo)localObject1, paramBoolean, new TgLiveAudienceRoomManager.1(this, paramLong, paramIResultListener));
  }
  
  public IAudienceRoom b()
  {
    return this.b;
  }
  
  public void c()
  {
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "clearPreloadMap");
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager
 * JD-Core Version:    0.7.0.1
 */