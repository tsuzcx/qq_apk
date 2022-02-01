package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.GiftMsg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$renderUI$1$1"}, k=3, mv={1, 1, 16})
final class SendGiftMessageBaseItemView$renderUI$$inlined$also$lambda$1
  implements View.OnClickListener
{
  SendGiftMessageBaseItemView$renderUI$$inlined$also$lambda$1(MessageOuterClass.GiftMsg paramGiftMsg, SendGiftMessageBaseItemView paramSendGiftMessageBaseItemView, IMsg paramIMsg) {}
  
  public final void onClick(View paramView)
  {
    IMessageListener localIMessageListener = this.b.getIMessageListener();
    if (localIMessageListener != null)
    {
      CommonOuterClass.QQUserId localQQUserId = this.a.recv_user_id;
      Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "it.recv_user_id");
      localIMessageListener.a(localQQUserId);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView.renderUI..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */