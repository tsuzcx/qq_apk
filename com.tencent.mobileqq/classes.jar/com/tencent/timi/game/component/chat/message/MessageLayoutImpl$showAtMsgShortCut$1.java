package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$showAtMsgShortCut$1
  implements View.OnClickListener
{
  MessageLayoutImpl$showAtMsgShortCut$1(MessageLayoutImpl paramMessageLayoutImpl, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    MessageLayoutImpl localMessageLayoutImpl = this.a;
    MessageLayoutImpl.a(localMessageLayoutImpl, MessageLayoutImpl.g(localMessageLayoutImpl), Math.max(0, MessageLayoutImpl.i(this.a).size() - this.b), true);
    MessageLayoutImpl.h(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.showAtMsgShortCut.1
 * JD-Core Version:    0.7.0.1
 */