package com.tencent.timi.game.component.qqlive.api;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
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
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;

public abstract interface ITgLiveRoomService
  extends IService
{
  @Nullable
  public abstract View a();
  
  @Nullable
  public abstract IAudienceRoom a(long paramLong);
  
  @Nullable
  public abstract IAudienceRoom a(long paramLong, String paramString);
  
  public abstract void a(long paramLong, IResultListener<LiveRealTimeInfo> paramIResultListener);
  
  public abstract void a(long paramLong, String paramString, SimpleTgLiveAnchorStartListener paramSimpleTgLiveAnchorStartListener);
  
  public abstract void a(long paramLong, List<Object> paramList);
  
  public abstract void a(long paramLong, boolean paramBoolean, IResultListener<LiveInfo> paramIResultListener);
  
  public abstract void a(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, boolean paramBoolean, TgLiveAnchorStartListener paramTgLiveAnchorStartListener);
  
  public abstract void a(IResultListener<LiveRealTimeInfo> paramIResultListener);
  
  @Nullable
  public abstract ILiveRoom b(long paramLong);
  
  @Nullable
  public abstract ITPPlayerVideoView b();
  
  @Nullable
  public abstract IQQLiveAnchorRoom c(long paramLong);
  
  public abstract void c();
  
  @Nullable
  public abstract IQQLiveSDK d();
  
  @Nullable
  public abstract QQLiveAnchorRoomInfo d(long paramLong);
  
  @Nullable
  public abstract IAudienceRoom e(long paramLong);
  
  public abstract ITgLiveRoomStatusInfo e();
  
  @Nullable
  public abstract IAudienceRoom f(long paramLong);
  
  @Nullable
  public abstract LiveUserInfo f();
  
  public abstract boolean g(long paramLong);
  
  @Nullable
  public abstract BaseRoomInfo h(long paramLong);
  
  @Nullable
  public abstract TgLiveAnchorUserInfo i(long paramLong);
  
  @Nullable
  public abstract ILiveRoomMessage j(long paramLong);
  
  @Nullable
  public abstract ILiveRoomOperation k(long paramLong);
  
  public abstract List<Object> l(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService
 * JD-Core Version:    0.7.0.1
 */