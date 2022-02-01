package com.tencent.tkd.topicsdk.ucrop.view;

import com.tencent.tkd.topicsdk.ucrop.callback.CropBoundsChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/ucrop/view/UCropView$setListenersToViews$1", "Lcom/tencent/tkd/topicsdk/ucrop/callback/CropBoundsChangeListener;", "onCropAspectRatioChanged", "", "cropRatio", "", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class UCropView$setListenersToViews$1
  implements CropBoundsChangeListener
{
  public void a(float paramFloat)
  {
    this.a.getOverlayView().setTargetAspectRatio(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.UCropView.setListenersToViews.1
 * JD-Core Version:    0.7.0.1
 */