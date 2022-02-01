package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addAtButton$1
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    paramView = this.a.getOnAtButtonClickListener();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addAtButton.1
 * JD-Core Version:    0.7.0.1
 */