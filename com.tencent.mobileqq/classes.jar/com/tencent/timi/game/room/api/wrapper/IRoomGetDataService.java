package com.tencent.timi.game.room.api.wrapper;

import androidx.annotation.Nullable;
import com.tencent.timi.game.room.api.GuildShequnParams;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

public abstract interface IRoomGetDataService
{
  public abstract int a();
  
  public abstract boolean a(long paramLong);
  
  public abstract YoloRoomOuterClass.YoloRoomInfo b();
  
  public abstract YoloRoomOuterClass.YoloRoomSpeakingPosInfo b(long paramLong);
  
  public abstract YoloRoomOuterClass.YoloRoomConf c();
  
  public abstract YoloRoomOuterClass.YoloRoomDoubleCheckPlayer c(long paramLong);
  
  public abstract YoloRoomOuterClass.YoloRoomUserData d();
  
  public abstract int e();
  
  public abstract long f();
  
  public abstract YoloRoomOuterClass.YoloSmobaGameDataInfo g();
  
  public abstract List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> h();
  
  public abstract int i();
  
  public abstract YoloRoomOuterClass.YoloGameRouteInfo j();
  
  public abstract YoloBattleSmobaOuterClass.YoloSmobaOneSchema k();
  
  public abstract YoloBattleSmobaOuterClass.YoloSmobaOneSchema l();
  
  public abstract boolean m();
  
  @Nullable
  public abstract CommonOuterClass.QQUserId n();
  
  public abstract boolean o();
  
  public abstract long p();
  
  public abstract GuildShequnParams q();
  
  public abstract ConcurrentHashMap<String, String> r();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.wrapper.IRoomGetDataService
 * JD-Core Version:    0.7.0.1
 */