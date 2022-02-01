package com.tencent.tkd.topicsdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MediaDisplayLayout$MediaDisplayGridAdapter$getView$2
  implements View.OnClickListener
{
  MediaDisplayLayout$MediaDisplayGridAdapter$getView$2(MediaDisplayLayout.MediaDisplayGridAdapter paramMediaDisplayGridAdapter, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.setLastClickPosition(this.b);
    paramView = this.a.a.getOnCoverSelectListener();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(Integer.valueOf(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.MediaDisplayGridAdapter.getView.2
 * JD-Core Version:    0.7.0.1
 */