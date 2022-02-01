package com.tencent.mobileqq.mini.common.ui;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LoadLayout$bindEvents$1
  implements View.OnClickListener
{
  LoadLayout$bindEvents$1(LoadLayout paramLoadLayout) {}
  
  public final void onClick(View paramView)
  {
    paramView = LoadLayout.access$getMOnLoadMoreClickAction$p(this.this$0);
    if (paramView != null) {
      paramView.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadLayout.bindEvents.1
 * JD-Core Version:    0.7.0.1
 */