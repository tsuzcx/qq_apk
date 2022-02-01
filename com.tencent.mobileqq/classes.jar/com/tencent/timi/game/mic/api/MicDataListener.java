package com.tencent.timi.game.mic.api;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/mic/api/MicDataListener;", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomCommonListener;", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomAudioListener;", "observer", "Lcom/tencent/timi/game/mic/api/IMicDataObserver;", "(Lcom/tencent/timi/game/mic/api/IMicDataObserver;)V", "getObserver", "()Lcom/tencent/timi/game/mic/api/IMicDataObserver;", "onAgreeSpeaking", "", "uid", "", "expireTimeStamp", "onApplySpeaking", "onAudioMemberMicLevelChanged", "memberMicLevelList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "onAudioStatusChanged", "roomState", "Lcom/tencent/timi/game/trtc/roomservice/voiceroom/info/RoomState;", "onBattleObStatusChange", "msgId", "obStatus", "obStatusChangeAction", "Ltrpc/yes/common/YoloRoomOuterClass$YoloBattleOBStatusChangeAction;", "onGameRouteStatusUpdate", "isStatusChanged", "", "gameStatus", "gameRouteInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGameRouteInfo;", "onInOutSpeaking", "inOutType", "speakingPosInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "lastestPosInfoList", "", "onInvitedSpeaking", "inviterUid", "invitedUid", "onReadyStatusChanged", "readyStatusType", "onRemindStartGame", "isRemindOwner", "onRoomBannedError", "errorCode", "errorMsg", "onRoomInfoModifyed", "modifyInfoContentList", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomModifyInfoActionContent;", "onRoomOwnerChanged", "newRoomOwnerUid", "onSendGift", "onSpeakingPosChanged", "speakingPosInfoList", "onSpeakingPosStatusChanged", "posStatus", "onSpeakingUserStatusUpdate", "onSubRoomAudioMemberMicLevelChanged", "onSubRoomAudioStatusChanged", "onUserEnter", "userId", "onUserKickedOutRoom", "kickedUserId", "onUserKickedOutSpeaking", "onUserLeave", "onVoiceSwitchChanged", "switchType", "onlineNumChanged", "onlineNum", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicDataListener
  implements YoloRoomInterface.YoloRoomAudioListener, YoloRoomInterface.YoloRoomCommonListener
{
  @NotNull
  private final IMicDataObserver a;
  
  public MicDataListener(@NotNull IMicDataObserver paramIMicDataObserver)
  {
    this.a = paramIMicDataObserver;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(int paramInt, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(long paramLong, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void a(@Nullable RoomState paramRoomState) {}
  
  public void a(@Nullable String paramString, int paramInt, @Nullable YoloRoomOuterClass.YoloBattleOBStatusChangeAction paramYoloBattleOBStatusChangeAction) {}
  
  public void a(@Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void a(@Nullable ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap != null) {
      this.a.a(paramConcurrentHashMap);
    }
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo) {}
  
  public void b(int paramInt, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void b(@Nullable RoomState paramRoomState) {}
  
  public void b(@Nullable List<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> paramList) {}
  
  public void b(@Nullable ConcurrentHashMap<String, Integer> paramConcurrentHashMap) {}
  
  public void c(int paramInt, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void c(long paramLong) {}
  
  public void d(int paramInt, @Nullable YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, @Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    if (paramList != null) {
      this.a.a(paramList);
    }
  }
  
  public void d(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.mic.api.MicDataListener
 * JD-Core Version:    0.7.0.1
 */