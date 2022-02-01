package com.tencent.qcircle.tavcut.view;

import android.view.ViewParent;
import com.tencent.qcircle.tavcut.view.ext.OnGestureListener;
import com.tencent.qcircle.tavcut.view.ext.OnRotationListener;
import com.tencent.qcircle.tavcut.view.ext.OnScaleChangedListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewDragListener;
import com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qcircle/tavcut/view/TAVCutImageView$onGestureListener$1", "Lcom/tencent/qcircle/tavcut/view/ext/OnGestureListener;", "onDrag", "", "dx", "", "dy", "onFling", "startX", "startY", "velocityX", "velocityY", "onRotation", "focusX", "focusY", "angle", "onScale", "scaleFactor", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$onGestureListener$1
  implements OnGestureListener
{
  public void onDrag(float paramFloat1, float paramFloat2)
  {
    Object localObject = TAVCutImageView.access$getMTAVDetector$p(this.this$0);
    if ((localObject != null) && (((TAVGestureDetector)localObject).isScaling() == true)) {
      return;
    }
    localObject = this.this$0.getParent();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "parent");
    if ((!TAVCutImageView.access$isActive$p(this.this$0)) && (!TAVCutImageView.access$getMBlockParentIntercept$p(this.this$0))) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
    } else {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
    }
    if (!TAVCutImageView.access$isActive$p(this.this$0)) {
      return;
    }
    localObject = TAVCutImageView.access$getMOnDragListener$p(this.this$0);
    if (localObject != null) {
      ((OnViewDragListener)localObject).onDrag(paramFloat1, paramFloat2);
    }
  }
  
  public void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!TAVCutImageView.access$isActive$p(this.this$0)) {
      return;
    }
    OnRotationListener localOnRotationListener = TAVCutImageView.access$getMOnRotationListener$p(this.this$0);
    if (localOnRotationListener != null) {
      localOnRotationListener.onRotation(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!TAVCutImageView.access$isActive$p(this.this$0)) {
      return;
    }
    onScale(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F);
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (!TAVCutImageView.access$isActive$p(this.this$0)) {
      return;
    }
    Object localObject = TAVCutImageView.access$getMScaleChangeListener$p(this.this$0);
    if (localObject != null) {
      ((OnScaleChangedListener)localObject).onScaleChange(paramFloat1, paramFloat2, paramFloat3);
    }
    localObject = TAVCutImageView.access$getMOnDragListener$p(this.this$0);
    if (localObject != null) {
      ((OnViewDragListener)localObject).onDrag(paramFloat4, paramFloat5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView.onGestureListener.1
 * JD-Core Version:    0.7.0.1
 */