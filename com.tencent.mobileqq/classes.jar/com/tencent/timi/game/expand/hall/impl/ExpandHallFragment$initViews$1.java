package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallFragment$initViews$1
  implements View.OnClickListener
{
  public static final 1 a = new 1();
  
  public final void onClick(View paramView)
  {
    Logger.a("ExpandHallFragment_", "rootView setOnClickListener");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.initViews.1
 * JD-Core Version:    0.7.0.1
 */