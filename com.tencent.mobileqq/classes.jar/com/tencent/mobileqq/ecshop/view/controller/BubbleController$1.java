package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BubbleController$1
  implements View.OnClickListener
{
  BubbleController$1(View.OnClickListener paramOnClickListener, View paramView) {}
  
  public final void onClick(View paramView)
  {
    this.a.onClick(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.BubbleController.1
 * JD-Core Version:    0.7.0.1
 */