package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingView$mMicDataListener$1", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomAudioListener;", "onAudioMemberMicLevelChanged", "", "memberMicLevelList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "onAudioStatusChanged", "roomState", "Lcom/tencent/timi/game/trtc/roomservice/voiceroom/info/RoomState;", "onSubRoomAudioMemberMicLevelChanged", "onSubRoomAudioStatusChanged", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView$mMicDataListener$1
  implements YoloRoomInterface.YoloRoomAudioListener
{
  public void a(@Nullable RoomState paramRoomState) {}
  
  public void a(@NotNull ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "memberMicLevelList");
    TeamFloatingView.a(this.a, paramConcurrentHashMap);
  }
  
  public void b(@Nullable RoomState paramRoomState) {}
  
  public void b(@Nullable ConcurrentHashMap<String, Integer> paramConcurrentHashMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.mMicDataListener.1
 * JD-Core Version:    0.7.0.1
 */