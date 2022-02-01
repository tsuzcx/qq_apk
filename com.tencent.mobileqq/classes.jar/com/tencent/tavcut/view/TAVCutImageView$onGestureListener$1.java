package com.tencent.tavcut.view;

import android.view.ViewParent;
import com.tencent.tavcut.view.ext.OnGestureListener;
import com.tencent.tavcut.view.ext.OnRotationListener;
import com.tencent.tavcut.view.ext.OnScaleChangedListener;
import com.tencent.tavcut.view.ext.OnViewDragListener;
import com.tencent.tavcut.view.ext.TAVGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/view/TAVCutImageView$onGestureListener$1", "Lcom/tencent/tavcut/view/ext/OnGestureListener;", "onDrag", "", "dx", "", "dy", "onFling", "startX", "startY", "velocityX", "velocityY", "onRotation", "focusX", "focusY", "angle", "onScale", "scaleFactor", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$onGestureListener$1
  implements OnGestureListener
{
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = TAVCutImageView.access$getMTAVDetector$p(this.a);
    if ((localObject != null) && (((TAVGestureDetector)localObject).a() == true)) {
      return;
    }
    localObject = this.a.getParent();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "parent");
    if ((!TAVCutImageView.access$isActive$p(this.a)) && (!TAVCutImageView.access$getMBlockParentIntercept$p(this.a))) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
    } else {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
    }
    if (!TAVCutImageView.access$isActive$p(this.a)) {
      return;
    }
    localObject = TAVCutImageView.access$getMOnDragListener$p(this.a);
    if (localObject != null) {
      ((OnViewDragListener)localObject).a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!TAVCutImageView.access$isActive$p(this.a)) {
      return;
    }
    a(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (!TAVCutImageView.access$isActive$p(this.a)) {
      return;
    }
    Object localObject = TAVCutImageView.access$getMScaleChangeListener$p(this.a);
    if (localObject != null) {
      ((OnScaleChangedListener)localObject).a(paramFloat1, paramFloat2, paramFloat3);
    }
    localObject = TAVCutImageView.access$getMOnDragListener$p(this.a);
    if (localObject != null) {
      ((OnViewDragListener)localObject).a(paramFloat4, paramFloat5);
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!TAVCutImageView.access$isActive$p(this.a)) {
      return;
    }
    OnRotationListener localOnRotationListener = TAVCutImageView.access$getMOnRotationListener$p(this.a);
    if (localOnRotationListener != null) {
      localOnRotationListener.a(paramFloat1, paramFloat2, paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageView.onGestureListener.1
 * JD-Core Version:    0.7.0.1
 */