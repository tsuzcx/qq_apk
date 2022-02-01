package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/component/chat/message/MessageLayoutImpl$4$1"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$$special$$inlined$textView$lambda$2
  implements View.OnClickListener
{
  MessageLayoutImpl$$special$$inlined$textView$lambda$2(MessageLayoutImpl paramMessageLayoutImpl) {}
  
  public final void onClick(View paramView)
  {
    this.a.a();
    MessageLayoutImpl.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl..special..inlined.textView.lambda.2
 * JD-Core Version:    0.7.0.1
 */