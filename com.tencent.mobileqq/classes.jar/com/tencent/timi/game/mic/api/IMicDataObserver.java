package com.tencent.timi.game.mic.api;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/mic/api/IMicDataObserver;", "", "onAudioMemberMicLevelChanged", "", "memberMicLevelList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "onRefreshSpeakingPosInfoList", "dataList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMicDataObserver
{
  public abstract void a(@NotNull List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void a(@NotNull ConcurrentHashMap<String, Integer> paramConcurrentHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.mic.api.IMicDataObserver
 * JD-Core Version:    0.7.0.1
 */