package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.main.TeamConfigPageHelper;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/TextMessageItemView$Companion;", "", "()V", "arrowBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "arrowSpan", "Lcom/tencent/timi/game/ui/CenterAlignSizeImageSpan;", "sendToHallColorSpan", "Landroid/text/style/ForegroundColorSpan;", "handleShareClick", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TextMessageItemView$Companion
{
  private final void a()
  {
    Object localObject5 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
    Object localObject2 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
    if (localObject2 == null)
    {
      CustomToastView.a("目前不在开黑大厅无法分享哦");
      return;
    }
    if (localObject5 != null)
    {
      Object localObject1 = new MessageOuterClass.MsgContent();
      Object localObject3 = new MessageOuterClass.ShareYoloRoomMsg();
      ((MessageOuterClass.ShareYoloRoomMsg)localObject3).room_info.set((MessageMicro)localObject5);
      Object localObject4 = ((MessageOuterClass.ShareYoloRoomMsg)localObject3).room_speaking_pos_list;
      localObject5 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(((YoloRoomOuterClass.YoloRoomInfo)localObject5).room_id.get());
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "ServiceCenter.getService…a(roomInfo.room_id.get())");
      ((PBRepeatMessageField)localObject4).set(((IRoomGetDataService)localObject5).h());
      ((MessageOuterClass.MsgContent)localObject1).share_yolo_room_msg.set((MessageMicro)localObject3);
      localObject2 = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(((YoloRoomOuterClass.YoloRoomInfo)localObject2).tim_group_id.get());
      localObject3 = (IUserInfoService)ServiceCenter.a(IUserInfoService.class);
      localObject4 = ServiceCenter.a(ILoginCoreService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "ServiceCenter.getService…nCoreService::class.java)");
      localObject3 = ((IUserInfoService)localObject3).b(((ILoginCoreService)localObject4).a());
      ((IMsgManager)localObject2).a((CommonOuterClass.QQUserId)localObject3, 78, (MessageOuterClass.MsgContent)localObject1);
      localObject1 = TeamConfigPageHelper.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "TeamConfigPageHelper.getInviteTips()");
      ((IMsgManager)localObject2).a((CommonOuterClass.QQUserId)localObject3, (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TextMessageItemView.Companion
 * JD-Core Version:    0.7.0.1
 */