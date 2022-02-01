package com.tencent.qcircle.tavcut.view;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qcircle.tavcut.view.ext.OnActiveBasePicListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewTapListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qcircle/tavcut/view/TAVCutImageView$3", "Lcom/tencent/qcircle/tavcut/view/ext/OnViewTapListener;", "onViewTap", "", "view", "Landroid/view/View;", "x", "", "y", "e", "Landroid/view/MotionEvent;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$3
  implements OnViewTapListener
{
  public void onViewTap(@Nullable View paramView, float paramFloat1, float paramFloat2, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    boolean bool3 = TAVCutImageView.access$isActive$p(this.this$0);
    paramView = this.this$0;
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (TAVCutImageView.checkInside$default(paramView, localPointF, false, 2, null))
    {
      bool1 = bool2;
      if (!TAVCutImageView.access$isActive$p(this.this$0)) {
        bool1 = true;
      }
    }
    TAVCutImageView.access$setActive$p(paramView, bool1);
    if (bool3 != TAVCutImageView.access$isActive$p(this.this$0))
    {
      paramView = TAVCutImageView.access$getMActiveBasePicListener$p(this.this$0);
      if (paramView != null) {
        paramView.OnActiveBasePic(TAVCutImageView.access$isActive$p(this.this$0), paramMotionEvent);
      }
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView.3
 * JD-Core Version:    0.7.0.1
 */