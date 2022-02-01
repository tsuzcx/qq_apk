package com.tencent.timi.game.liveroom.impl.view.operation;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorOperationView$1$instantiateItem$1
  implements View.OnClickListener
{
  AnchorOperationView$1$instantiateItem$1(AnchorOperationView.1 param1, OperationItem paramOperationItem) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.1.instantiateItem.1
 * JD-Core Version:    0.7.0.1
 */