package com.tencent.mobileqq.ecshop.view.controller;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$2
  implements View.OnClickListener
{
  TitleLayoutController$2(TitleLayoutController paramTitleLayoutController) {}
  
  public final void onClick(View paramView)
  {
    this.a.a().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.2
 * JD-Core Version:    0.7.0.1
 */