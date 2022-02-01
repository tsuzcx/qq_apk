package com.tencent.tkd.topicsdk.ucrop.view;

import android.graphics.RectF;
import com.tencent.tkd.topicsdk.ucrop.callback.OverlayViewChangeListener;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/ucrop/view/UCropView$setListenersToViews$2", "Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;", "onCropRectUpdated", "", "cropRect", "Landroid/graphics/RectF;", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class UCropView$setListenersToViews$2
  implements OverlayViewChangeListener
{
  public void a(@Nullable RectF paramRectF)
  {
    Object localObject = this.a.getGestureCropView();
    if (localObject != null)
    {
      localObject = ((IGestureCropView)localObject).getGestureCropHandler();
      if (localObject != null) {
        ((GestureCropHandler)localObject).a(paramRectF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.UCropView.setListenersToViews.2
 * JD-Core Version:    0.7.0.1
 */