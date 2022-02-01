package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/YoloRoomCommonConfManager;", "Lcom/tencent/timi/game/room/api/IRoomCommonConf;", "()V", "TAG", "", "TAG_GAME_ROOM_SEND_INTERVAL_TIME", "TAG_SEND_INTERVAL_TIME", "mGameRoomSendIntervalTime", "", "mSendIntervalTime", "getGameRoomSendIntervalTimes", "getSendIntervalTimes", "setGameRoomSendIntervalTime", "", "sendIntervalTime", "setSendIntervalTime", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YoloRoomCommonConfManager
  implements IRoomCommonConf
{
  public static final YoloRoomCommonConfManager a = new YoloRoomCommonConfManager();
  private static int b = TGSharedPreferenceUtil.b("tag_send_interval_time", 5);
  private static int c = TGSharedPreferenceUtil.b("tag_game_room_send_interval_time", 1);
  
  public int a()
  {
    return b;
  }
  
  public final void a(int paramInt)
  {
    b = Math.max(paramInt, 3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSendIntervalTime # ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(b);
    Logger.c("YoloRoomCommonConfManager", localStringBuilder.toString());
    TGSharedPreferenceUtil.a("tag_send_interval_time", b);
  }
  
  public int b()
  {
    return c;
  }
  
  public final void b(int paramInt)
  {
    c = RangesKt.coerceAtLeast(paramInt, 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGameRoomSendIntervalTime # ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(c);
    Logger.c("YoloRoomCommonConfManager", localStringBuilder.toString());
    TGSharedPreferenceUtil.a("tag_game_room_send_interval_time", b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomCommonConfManager
 * JD-Core Version:    0.7.0.1
 */