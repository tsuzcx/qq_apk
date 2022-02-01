package com.tencent.xaction.trigger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ClickTrigger$monitor$1
  implements View.OnClickListener
{
  ClickTrigger$monitor$1(ClickTrigger paramClickTrigger) {}
  
  public final void onClick(View paramView)
  {
    ClickTrigger localClickTrigger = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
    localClickTrigger.updateStatus(paramView, "click");
    this.a.setStatus("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.ClickTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */