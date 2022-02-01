package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class GalleryView$mAdapter$1$instantiateItem$1
  implements View.OnLongClickListener
{
  GalleryView$mAdapter$1$instantiateItem$1(GalleryView.mAdapter.1 param1, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = GalleryView.c(this.a.a);
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(Integer.valueOf(this.b));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.GalleryView.mAdapter.1.instantiateItem.1
 * JD-Core Version:    0.7.0.1
 */