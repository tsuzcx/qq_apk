package com.tencent.timi.game.room.impl.util;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.impl.message.MessageOuterClassExKt;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameMode;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/util/YoloRoomIMUtil;", "", "()V", "insertGroupMsg", "", "msgType", "", "groupID", "", "msgContent", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "sendEntertainmentAnnouncementMessage", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "sendLocalInviteMessage", "sendLocalRoadSelectMessage", "sendYoloActionMessage", "action", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomAction;", "sendZhanjiMessage", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YoloRoomIMUtil
{
  public static final YoloRoomIMUtil a = new YoloRoomIMUtil();
  
  private final void a(int paramInt, long paramLong, MessageOuterClass.MsgContent paramMsgContent) {}
  
  public final void a(long paramLong)
  {
    IMsgManager localIMsgManager = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramLong);
    MessageOuterClass.TimMsgBody localTimMsgBody = new MessageOuterClass.TimMsgBody();
    localTimMsgBody.msg_type.set(MessageOuterClassExKt.a());
    CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
    localQQUserId.uid.set(2000L);
    localIMsgManager.a(localTimMsgBody, localQQUserId);
  }
  
  public final void a(@NotNull YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramYoloRoomAction, "action");
    Object localObject = new MessageOuterClass.YoloRoomActionMsg();
    ((MessageOuterClass.YoloRoomActionMsg)localObject).yolo_room_action.set((MessageMicro)paramYoloRoomAction);
    MessageOuterClass.MsgContent localMsgContent = new MessageOuterClass.MsgContent();
    localMsgContent.yolo_room_action_msg.set((MessageMicro)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendYoloActionMessage ");
    ((StringBuilder)localObject).append(paramYoloRoomAction.action_type);
    Logger.a("YoloRoomIMUtil ", ((StringBuilder)localObject).toString());
    a(49, paramLong, localMsgContent);
  }
  
  public final void a(@NotNull YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramYoloRoomInfo, "roomInfo");
    paramYoloRoomInfo.tim_group_id.get();
    GameDataServerOuterClass.SmobaGameMode localSmobaGameMode = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).e(paramYoloRoomInfo.game_data_info.smoba_game_data_info.game_mode.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendEntertainmentAnnouncementMessage ");
    if (localSmobaGameMode != null) {
      paramYoloRoomInfo = localSmobaGameMode.game_type;
    } else {
      paramYoloRoomInfo = null;
    }
    localStringBuilder.append(paramYoloRoomInfo);
    Logger.a("YoloRoomIMUtil ", localStringBuilder.toString());
    if (localSmobaGameMode != null) {
      localSmobaGameMode.game_type.get();
    }
  }
  
  public final void b(long paramLong)
  {
    IMsgManager localIMsgManager = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramLong);
    MessageOuterClass.TimMsgBody localTimMsgBody = new MessageOuterClass.TimMsgBody();
    localTimMsgBody.msg_type.set(MessageOuterClassExKt.b());
    CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
    localQQUserId.uid.set(2000L);
    localIMsgManager.a(localTimMsgBody, localQQUserId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomIMUtil
 * JD-Core Version:    0.7.0.1
 */