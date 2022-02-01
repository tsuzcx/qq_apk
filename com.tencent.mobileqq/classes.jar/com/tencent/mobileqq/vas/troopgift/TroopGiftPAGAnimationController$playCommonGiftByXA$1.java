package com.tencent.mobileqq.vas.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$playCommonGiftByXA$1
  implements View.OnClickListener
{
  TroopGiftPAGAnimationController$playCommonGiftByXA$1(Function0 paramFunction0) {}
  
  public final void onClick(View paramView)
  {
    this.a.invoke();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.playCommonGiftByXA.1
 * JD-Core Version:    0.7.0.1
 */