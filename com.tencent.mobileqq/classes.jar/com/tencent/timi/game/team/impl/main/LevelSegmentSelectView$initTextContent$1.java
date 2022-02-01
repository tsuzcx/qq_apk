package com.tencent.timi.game.team.impl.main;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LevelSegmentSelectView$initTextContent$1
  implements View.OnClickListener
{
  LevelSegmentSelectView$initTextContent$1(LevelSegmentSelectView paramLevelSegmentSelectView) {}
  
  public final void onClick(View paramView)
  {
    LevelSegmentSelectView localLevelSegmentSelectView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    LevelSegmentSelectView.a(localLevelSegmentSelectView, LevelSegmentSelectView.a(localLevelSegmentSelectView, paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.LevelSegmentSelectView.initTextContent.1
 * JD-Core Version:    0.7.0.1
 */