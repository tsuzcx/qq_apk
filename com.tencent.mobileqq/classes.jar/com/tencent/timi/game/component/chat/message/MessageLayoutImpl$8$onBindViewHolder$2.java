package com.tencent.timi.game.component.chat.message;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$8$onBindViewHolder$2
  implements Runnable
{
  MessageLayoutImpl$8$onBindViewHolder$2(MessageLayoutImpl.8 param8, MessageLayoutImpl.ViewHolder paramViewHolder) {}
  
  public final void run()
  {
    Object localObject = this.a.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "holder.itemView");
    ((TextMessageItemView)localObject).setVisibility(0);
    this.a.itemView.clearAnimation();
    localObject = this.this$0;
    View localView = this.a.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localView, "holder.itemView");
    MessageLayoutImpl.8.a((MessageLayoutImpl.8)localObject, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.8.onBindViewHolder.2
 * JD-Core Version:    0.7.0.1
 */