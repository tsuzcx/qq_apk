package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseMessageView$renderUI$1
  implements View.OnClickListener
{
  BaseMessageView$renderUI$1(BaseMessageView paramBaseMessageView, IMsg paramIMsg) {}
  
  public final void onClick(View paramView)
  {
    this.a.a(this.b);
    BaseMessageView.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.renderUI.1
 * JD-Core Version:    0.7.0.1
 */