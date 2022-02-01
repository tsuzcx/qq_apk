package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;
import trpc.yes.common.MessageOuterClass.UserInfoModifyNotifyMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomNewDataPushMsg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/room/impl/YoloRoomChatManager$newMsgListener$1", "Lcom/tencent/timi/game/tim/api/message/INewMsgListener;", "onGroupMemberInfoChange", "", "groupId", "", "uids", "", "onGroupMsgNotify", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "onNewMsg", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YoloRoomChatManager$newMsgListener$1
  implements INewMsgListener
{
  public void a(long paramLong, @NotNull MessageOuterClass.TimMsgBody paramTimMsgBody)
  {
    Intrinsics.checkParameterIsNotNull(paramTimMsgBody, "timMsgBody");
    Object localObject;
    if (Env.c())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("YoloRoomChatManager#onGroupMsgNotify ");
      ((StringBuilder)localObject).append(paramTimMsgBody.msg_type.get());
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(paramTimMsgBody.content);
      Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    }
    if ((paramTimMsgBody.msg_type.get() == 49) && (paramTimMsgBody.content != null) && (paramTimMsgBody.content.yolo_room_action_msg.has()))
    {
      localObject = this.a.a();
      if (localObject != null)
      {
        paramTimMsgBody = paramTimMsgBody.content.yolo_room_action_msg;
        Intrinsics.checkExpressionValueIsNotNull(paramTimMsgBody, "timMsgBody.content.yolo_room_action_msg");
        ((YoloRoomChatManager.MessageListener)localObject).a(paramTimMsgBody, paramLong);
      }
    }
    else if ((paramTimMsgBody.msg_type.get() == 69) && (paramTimMsgBody.content != null) && (paramTimMsgBody.content.yolo_room_new_data_push_msg.has()))
    {
      localObject = this.a.a();
      if (localObject != null)
      {
        paramTimMsgBody = paramTimMsgBody.content.yolo_room_new_data_push_msg;
        Intrinsics.checkExpressionValueIsNotNull(paramTimMsgBody, "timMsgBody.content.yolo_room_new_data_push_msg");
        ((YoloRoomChatManager.MessageListener)localObject).a(paramTimMsgBody, paramLong);
      }
    }
    else if ((paramTimMsgBody.msg_type.get() == 80) && (paramTimMsgBody.content.user_info_modify_notify_msg.has()))
    {
      paramTimMsgBody = paramTimMsgBody.content.user_info_modify_notify_msg.qq_user_info;
      localObject = (IUserInfoService)ServiceCenter.a(IUserInfoService.class);
      Intrinsics.checkExpressionValueIsNotNull(paramTimMsgBody, "info");
      ((IUserInfoService)localObject).b(paramTimMsgBody);
    }
  }
  
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if ((paramIMsg.c() == 49) && (paramIMsg.g().yolo_room_action_msg.has()))
    {
      YoloRoomChatManager.MessageListener localMessageListener = this.a.a();
      if (localMessageListener != null)
      {
        String str = paramIMsg.a();
        MessageOuterClass.YoloRoomActionMsg localYoloRoomActionMsg = paramIMsg.g().yolo_room_action_msg;
        Intrinsics.checkExpressionValueIsNotNull(localYoloRoomActionMsg, "msg.content().yolo_room_action_msg");
        localMessageListener.a(str, localYoloRoomActionMsg, paramIMsg.h());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomChatManager.newMsgListener.1
 * JD-Core Version:    0.7.0.1
 */