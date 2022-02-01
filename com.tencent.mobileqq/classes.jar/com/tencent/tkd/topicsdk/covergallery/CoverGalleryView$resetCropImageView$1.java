package com.tencent.tkd.topicsdk.covergallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class CoverGalleryView$resetCropImageView$1
  implements View.OnTouchListener
{
  CoverGalleryView$resetCropImageView$1(CoverGalleryView paramCoverGalleryView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.performClick();
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
      CoverGalleryView.f(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.resetCropImageView.1
 * JD-Core Version:    0.7.0.1
 */