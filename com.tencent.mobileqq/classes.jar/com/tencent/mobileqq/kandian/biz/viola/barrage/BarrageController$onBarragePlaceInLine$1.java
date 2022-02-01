package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BarrageController$onBarragePlaceInLine$1
  implements View.OnClickListener
{
  BarrageController$onBarragePlaceInLine$1(BarrageController paramBarrageController, BarrageInfo paramBarrageInfo) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.b();
    if (paramView != null)
    {
      String str = this.b.a;
      Intrinsics.checkExpressionValueIsNotNull(str, "barrageInfo.id");
      paramView.onEventBarrageOnClick(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController.onBarragePlaceInLine.1
 * JD-Core Version:    0.7.0.1
 */