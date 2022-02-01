package com.tencent.timi.game.component.chat;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.util.MessageUtil;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ChatView$createChat$2
  implements View.OnClickListener
{
  ChatView$createChat$2(ChatView paramChatView, CommonOuterClass.QQUserId paramQQUserId, IMsgManager paramIMsgManager, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo) {}
  
  public final void onClick(View paramView)
  {
    if (NoDoubleClickUtils.b("tag_suspend_send_msg", ChatView.a(this.a)))
    {
      CustomToastView.a("说话太快了，休息一下吧");
    }
    else
    {
      MessageUtil localMessageUtil = MessageUtil.a;
      CommonOuterClass.QQUserId localQQUserId = this.b;
      IMsgManager localIMsgManager = this.c;
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localMessageUtil.a(localQQUserId, localIMsgManager, localContext, this.d.room_id.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ChatView.createChat.2
 * JD-Core Version:    0.7.0.1
 */