package com.tencent.tkd.topicsdk.entry.dialog;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class BaseEntryDialogView$initLeftLayout$2
  implements View.OnLongClickListener
{
  BaseEntryDialogView$initLeftLayout$2(BaseEntryDialogView paramBaseEntryDialogView) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = this.a.b();
    if (paramView != null)
    {
      paramView = (Boolean)paramView.invoke();
      if (paramView != null) {
        return paramView.booleanValue();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView.initLeftLayout.2
 * JD-Core Version:    0.7.0.1
 */