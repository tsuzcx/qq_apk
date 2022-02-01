package com.tencent.tavcut.view;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.tavcut.view.ext.OnActiveBasePicListener;
import com.tencent.tavcut.view.ext.OnViewTapListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/view/TAVCutImageView$3", "Lcom/tencent/tavcut/view/ext/OnViewTapListener;", "onViewTap", "", "view", "Landroid/view/View;", "x", "", "y", "e", "Landroid/view/MotionEvent;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$3
  implements OnViewTapListener
{
  public void a(@Nullable View paramView, float paramFloat1, float paramFloat2, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    boolean bool3 = TAVCutImageView.access$isActive$p(this.a);
    paramView = this.a;
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (TAVCutImageView.checkInside$default(paramView, localPointF, false, 2, null))
    {
      bool1 = bool2;
      if (!TAVCutImageView.access$isActive$p(this.a)) {
        bool1 = true;
      }
    }
    TAVCutImageView.access$setActive$p(paramView, bool1);
    if (bool3 != TAVCutImageView.access$isActive$p(this.a))
    {
      paramView = TAVCutImageView.access$getMActiveBasePicListener$p(this.a);
      if (paramView != null) {
        paramView.a(TAVCutImageView.access$isActive$p(this.a), paramMotionEvent);
      }
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageView.3
 * JD-Core Version:    0.7.0.1
 */