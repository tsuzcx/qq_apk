package com.yolo.esports.room.api;

import com.tencent.timi.game.IViewCreator;
import com.tencent.timi.game.router.IService;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/room/api/IRoomOperationService;", "Lcom/tencent/timi/game/IViewCreator;", "Lcom/tencent/timi/game/router/IService;", "clearYoloRoomRotateMsg", "", "roomId", "", "delegateRoomOperation", "owner", "Landroidx/lifecycle/LifecycleOwner;", "roomOperation", "Lcom/yolo/esports/room/api/IRoomOperation;", "getYoloRoomRotateMsgList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "interceptYoloRoomRotateMsg", "msg", "interceptYoloRoomRotateMsgList", "msgList", "registerOnYoloRoomSystemMsgListener", "onYoloRoomSystemMsgListener", "Lcom/yolo/esports/room/api/IRoomOperationService$OnYoloRoomSystemMsgListener;", "unregisterOnYoloRoomSystemMsgListener", "OnYoloRoomSystemMsgListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRoomOperationService
  extends IViewCreator, IService
{
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, @NotNull List<YoloRoomOuterClass.YoloRoomRotateMessage> paramList);
  
  @NotNull
  public abstract List<YoloRoomOuterClass.YoloRoomRotateMessage> b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.room.api.IRoomOperationService
 * JD-Core Version:    0.7.0.1
 */