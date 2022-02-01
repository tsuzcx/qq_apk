package com.tencent.tkd.topicsdk.adapter.widget;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RichEditTextMenuView$1
  implements View.OnClickListener
{
  RichEditTextMenuView$1(RichEditTextMenuView paramRichEditTextMenuView) {}
  
  public final void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = RichEditTextMenuView.a(this.a);
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.RichEditTextMenuView.1
 * JD-Core Version:    0.7.0.1
 */