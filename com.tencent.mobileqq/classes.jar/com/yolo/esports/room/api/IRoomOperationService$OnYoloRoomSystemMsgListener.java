package com.yolo.esports.room.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/room/api/IRoomOperationService$OnYoloRoomSystemMsgListener;", "", "onNewSystemMsgReceive", "", "msgList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "msg", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRoomOperationService$OnYoloRoomSystemMsgListener
{
  public abstract void a(@NotNull List<YoloRoomOuterClass.YoloRoomRotateMessage> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.room.api.IRoomOperationService.OnYoloRoomSystemMsgListener
 * JD-Core Version:    0.7.0.1
 */