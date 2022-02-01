package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.GiftMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/TimiGiftController$msgListener$1", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController$msgListener$1
  implements IMsgListener
{
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void a(@NotNull IMsg paramIMsg, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msgId");
  }
  
  public void a(@NotNull List<? extends IMsg> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "historyMessages");
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void e(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramIMsg.c() == 48)
    {
      if (paramIMsg.j()) {
        return;
      }
      MessageOuterClass.GiftMsg localGiftMsg = (MessageOuterClass.GiftMsg)paramIMsg.g().gift_msg.get();
      try
      {
        Object localObject1 = Result.Companion;
        GiftAnimData localGiftAnimData = new GiftAnimData();
        localGiftAnimData.a = localGiftMsg.gift_id.get();
        localGiftAnimData.b = localGiftMsg.gift_type.get();
        localGiftAnimData.c = localGiftMsg.gift_name.get();
        try
        {
          localObject1 = Result.Companion;
          localObject1 = Result.constructor-impl(new JSONObject(localGiftMsg.client_str.get()));
        }
        catch (Throwable localThrowable)
        {
          localObject3 = Result.Companion;
          localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
        }
        Object localObject3 = localObject2;
        if (Result.isFailure-impl(localObject2)) {
          localObject3 = null;
        }
        localObject2 = (JSONObject)localObject3;
        if (localObject2 != null)
        {
          localGiftAnimData.d = ((JSONObject)localObject2).getInt("material_id");
          localGiftAnimData.e = localGiftMsg.total_num.get();
          localGiftAnimData.g = paramIMsg.d().uid.get();
          localGiftAnimData.h = ((JSONObject)localObject2).getString("sender_nick");
          localGiftAnimData.k = ((JSONObject)localObject2).getString("sender_avatar");
          localGiftAnimData.j = ((JSONObject)localObject2).getString("receiver_nick");
          localGiftAnimData.l = ((JSONObject)localObject2).getString("receiver_avatar");
          localGiftAnimData.m = ((JSONObject)localObject2).getInt("effect_level");
          localGiftAnimData.n = ((JSONObject)localObject2).getLong("combo_seq");
          localGiftAnimData.o = localGiftMsg.combo_cnt.get();
        }
        paramIMsg = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(TimiGiftController.a(this.a));
        Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "roomGetData");
        if ((paramIMsg.c().yolo_room_community_conf.wuji_yolo_room_community_conf.has()) && (!((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)paramIMsg.c().yolo_room_community_conf.wuji_yolo_room_community_conf.get()).is_show_third_part_gift.get()) && (localGiftMsg.recv_user_id.uid.get() != TimiGiftController.f(this.a))) {
          return;
        }
        paramIMsg = TimiGiftController.g(this.a);
        if (paramIMsg != null)
        {
          paramIMsg = paramIMsg.a();
          if (paramIMsg != null) {
            paramIMsg.b(localGiftAnimData);
          }
        }
        TimiGiftController.h(this.a).a();
        paramIMsg = Result.constructor-impl(Unit.INSTANCE);
      }
      catch (Throwable paramIMsg)
      {
        localObject2 = Result.Companion;
        paramIMsg = Result.constructor-impl(ResultKt.createFailure(paramIMsg));
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("new gift msg: ");
      ((StringBuilder)localObject2).append(Result.exceptionOrNull-impl(paramIMsg));
      Logger.c("TimiGiftPresenter", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.msgListener.1
 * JD-Core Version:    0.7.0.1
 */