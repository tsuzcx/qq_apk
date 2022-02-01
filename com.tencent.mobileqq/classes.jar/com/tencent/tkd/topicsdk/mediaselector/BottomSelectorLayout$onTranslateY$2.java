package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$onTranslateY$2
  implements View.OnClickListener
{
  BottomSelectorLayout$onTranslateY$2(BottomSelectorLayout paramBottomSelectorLayout) {}
  
  public final void onClick(View paramView)
  {
    if (BottomSelectorLayout.d(this.a)) {
      BottomSelectorLayout.e(this.a);
    }
    paramView = this.a;
    BottomSelectorLayout.a(paramView, 0.0F, paramView.getCurrentPanelInitY(), false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.onTranslateY.2
 * JD-Core Version:    0.7.0.1
 */