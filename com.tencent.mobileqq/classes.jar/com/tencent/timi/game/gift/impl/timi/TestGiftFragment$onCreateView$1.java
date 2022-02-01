package com.tencent.timi.game.gift.impl.timi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TestGiftFragment$onCreateView$1
  implements View.OnClickListener
{
  TestGiftFragment$onCreateView$1(TimiGiftController paramTimiGiftController) {}
  
  public final void onClick(View paramView)
  {
    this.a.a("0");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TestGiftFragment.onCreateView.1
 * JD-Core Version:    0.7.0.1
 */