package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DynamicDrawable$updateDrawableState$1
  implements Runnable
{
  DynamicDrawable$updateDrawableState$1(DynamicDrawable paramDynamicDrawable) {}
  
  public final void run()
  {
    Drawable localDrawable = this.this$0.a();
    if (localDrawable != null)
    {
      DynamicDrawable.b(this.this$0, localDrawable);
      if (GLDrawableProxy.a(localDrawable)) {
        DynamicDrawable.c(this.this$0, localDrawable);
      }
      this.this$0.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.updateDrawableState.1
 * JD-Core Version:    0.7.0.1
 */