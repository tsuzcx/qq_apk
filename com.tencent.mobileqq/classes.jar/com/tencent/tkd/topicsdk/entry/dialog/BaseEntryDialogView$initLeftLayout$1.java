package com.tencent.tkd.topicsdk.entry.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseEntryDialogView$initLeftLayout$1
  implements View.OnClickListener
{
  BaseEntryDialogView$initLeftLayout$1(BaseEntryDialogView paramBaseEntryDialogView) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.getLeftClickListener();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView.initLeftLayout.1
 * JD-Core Version:    0.7.0.1
 */