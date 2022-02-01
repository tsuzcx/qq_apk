package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$showAtMsgWhenFirstLoad$2$1
  implements View.OnClickListener
{
  MessageLayoutImpl$showAtMsgWhenFirstLoad$2$1(MessageLayoutImpl.showAtMsgWhenFirstLoad.2 param2) {}
  
  public final void onClick(View paramView)
  {
    int i = MessageLayoutImpl.c(this.a.this$0);
    String str = MessageLayoutImpl.d(this.a.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAtMsgWhenFirstLoad: next ");
    localStringBuilder.append(i);
    Logger.b(str, localStringBuilder.toString());
    MessageLayoutImpl.a(this.a.this$0, MessageLayoutImpl.g(this.a.this$0), Math.max(0, i), true);
    MessageLayoutImpl.h(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.showAtMsgWhenFirstLoad.2.1
 * JD-Core Version:    0.7.0.1
 */