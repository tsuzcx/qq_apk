package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/ui/AbsAsyncDrawable$callbackProxy$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "time", "", "unscheduleDrawable", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class AbsAsyncDrawable$callbackProxy$1
  implements Drawable.Callback
{
  public void invalidateDrawable(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    paramDrawable = this.a.getCallback();
    if (paramDrawable != null)
    {
      paramDrawable.invalidateDrawable((Drawable)this.a);
      if ((paramDrawable instanceof View))
      {
        paramDrawable = (View)paramDrawable;
        if ((paramDrawable.getLayoutParams().width == -2) || (paramDrawable.getLayoutParams().height == -2)) {
          paramDrawable.requestLayout();
        }
      }
    }
  }
  
  public void scheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
    paramDrawable = this.a.getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable((Drawable)this.a, paramRunnable, paramLong);
    }
  }
  
  public void unscheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
    paramDrawable = this.a.getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable((Drawable)this.a, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncDrawable.callbackProxy.1
 * JD-Core Version:    0.7.0.1
 */