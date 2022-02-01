package com.tencent.timi.game.component.qqlive.impl;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomStatusInfo;
import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager;
import com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TgLiveRoomServiceImpl
  implements ITgLiveRoomService
{
  private Map<Long, List<Object>> a = new HashMap();
  private ITgLiveRoomStatusInfo b = new TgLiveRoomServiceImpl.4(this);
  
  public static long a(ILiveRoom paramILiveRoom, long paramLong)
  {
    if (paramILiveRoom != null)
    {
      paramILiveRoom = paramILiveRoom.getRoomInfo();
      if (paramILiveRoom != null) {
        return paramILiveRoom.getRoomId();
      }
    }
    return paramLong;
  }
  
  public View a()
  {
    return TgLiveAnchorRoomManager.a().c();
  }
  
  @Nullable
  public IAudienceRoom a(long paramLong)
  {
    return TgLiveAudienceRoomManager.a().a(paramLong);
  }
  
  public IAudienceRoom a(long paramLong, String paramString)
  {
    return TgLiveAudienceRoomManager.a().a(paramLong, paramString);
  }
  
  public void a(long paramLong, IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audienceExitRoom - ");
    localStringBuilder.append(paramLong);
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", localStringBuilder.toString());
    TgLiveAudienceRoomManager.a().a(paramLong, paramIResultListener);
    a(paramLong, new ArrayList());
  }
  
  public void a(long paramLong, String paramString, SimpleTgLiveAnchorStartListener paramSimpleTgLiveAnchorStartListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorResumeLiveIfExist - ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", 1, localStringBuilder.toString());
    b(new TgLiveRoomServiceImpl.2(this, paramSimpleTgLiveAnchorStartListener, paramLong, paramString));
  }
  
  public void a(long paramLong, List<Object> paramList)
  {
    this.a.put(Long.valueOf(paramLong), paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, IResultListener<LiveInfo> paramIResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audienceEnterRoom - ");
    localStringBuilder.append(paramLong);
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", 1, localStringBuilder.toString());
    b(new TgLiveRoomServiceImpl.3(this, paramLong, paramBoolean, paramIResultListener));
  }
  
  public void a(Context paramContext) {}
  
  public void a(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, boolean paramBoolean, TgLiveAnchorStartListener paramTgLiveAnchorStartListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive - ");
    localStringBuilder.append(paramQQLiveAnchorStreamRecordType);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", 1, localStringBuilder.toString());
    TgLiveUtils.a(paramQQLiveAnchorStreamRecordType, new TgLiveRoomServiceImpl.1(this, paramTgLiveAnchorStartListener, paramQQLiveAnchorStreamRecordType, paramBoolean));
  }
  
  public void a(IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", "anchorStopLive");
    TgLiveAnchorRoomManager.a().a(paramIResultListener);
  }
  
  public ILiveRoom b(long paramLong)
  {
    IAudienceRoom localIAudienceRoom = e(paramLong);
    if (localIAudienceRoom != null) {
      return localIAudienceRoom;
    }
    return c(paramLong);
  }
  
  public ITPPlayerVideoView b()
  {
    IAudienceRoom localIAudienceRoom = e(0L);
    if (localIAudienceRoom != null) {
      return (ITPPlayerVideoView)localIAudienceRoom.getDisplayView();
    }
    return null;
  }
  
  public void b(IResultListener<Boolean> paramIResultListener)
  {
    TgLiveRoomCommonManager.a().a(TimiGameActivityManager.c(), paramIResultListener);
  }
  
  public IQQLiveAnchorRoom c(long paramLong)
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = TgLiveAnchorRoomManager.a().b();
    if (paramLong > 0L)
    {
      if ((localIQQLiveAnchorRoom != null) && (a(localIQQLiveAnchorRoom, 0L) == paramLong)) {
        return localIQQLiveAnchorRoom;
      }
      return null;
    }
    return localIQQLiveAnchorRoom;
  }
  
  public void c()
  {
    Logger.a("TgLiveTag_TgLiveRoomServiceImpl", "exitAndDestroy");
    TgLiveRoomCommonManager.a().a(null);
  }
  
  public IQQLiveSDK d()
  {
    return TgLiveRoomCommonManager.a().c();
  }
  
  public QQLiveAnchorRoomInfo d(long paramLong)
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = c(paramLong);
    if (localIQQLiveAnchorRoom != null) {
      return localIQQLiveAnchorRoom.getAnchorRoomInfo();
    }
    return null;
  }
  
  public IAudienceRoom e(long paramLong)
  {
    IAudienceRoom localIAudienceRoom = TgLiveAudienceRoomManager.a().b();
    if (paramLong > 0L)
    {
      if ((localIAudienceRoom != null) && (a(localIAudienceRoom, 0L) == paramLong)) {
        return localIAudienceRoom;
      }
      return null;
    }
    return localIAudienceRoom;
  }
  
  public ITgLiveRoomStatusInfo e()
  {
    return this.b;
  }
  
  @Nullable
  public IAudienceRoom f(long paramLong)
  {
    IAudienceRoom localIAudienceRoom = e(paramLong);
    if ((localIAudienceRoom != null) && (a(localIAudienceRoom, 0L) == paramLong)) {
      return localIAudienceRoom;
    }
    return TgLiveAudienceRoomManager.a().a(paramLong);
  }
  
  @Nullable
  public LiveUserInfo f()
  {
    IQQLiveSDK localIQQLiveSDK = d();
    if (localIQQLiveSDK != null) {
      return localIQQLiveSDK.getLoginModule().getUserInfo();
    }
    return null;
  }
  
  public void g() {}
  
  public boolean g(long paramLong)
  {
    ITgLiveRoomStatusInfo localITgLiveRoomStatusInfo = e();
    return (localITgLiveRoomStatusInfo != null) && (localITgLiveRoomStatusInfo.a()) && (h(paramLong) != null);
  }
  
  public BaseRoomInfo h(long paramLong)
  {
    ILiveRoom localILiveRoom = b(paramLong);
    if (localILiveRoom != null) {
      return localILiveRoom.getRoomInfo();
    }
    return null;
  }
  
  public TgLiveAnchorUserInfo i(long paramLong)
  {
    Object localObject = d(paramLong);
    if (localObject != null) {
      return new TgLiveAnchorUserInfo(((QQLiveAnchorRoomInfo)localObject).userDta);
    }
    localObject = f(paramLong);
    if ((localObject != null) && (((IAudienceRoom)localObject).getRoomLiveInfo() != null) && (((IAudienceRoom)localObject).getRoomLiveInfo().anchorInfo != null)) {
      return new TgLiveAnchorUserInfo(((IAudienceRoom)localObject).getRoomLiveInfo().anchorInfo);
    }
    return null;
  }
  
  public ILiveRoomMessage j(long paramLong)
  {
    return b(paramLong);
  }
  
  public ILiveRoomOperation k(long paramLong)
  {
    return b(paramLong);
  }
  
  public List<Object> l(long paramLong)
  {
    return (List)this.a.get(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl
 * JD-Core Version:    0.7.0.1
 */