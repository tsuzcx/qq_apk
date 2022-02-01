package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import bibn;
import bibw;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class DynamicDrawable$updateDrawableState$1
  implements Runnable
{
  public DynamicDrawable$updateDrawableState$1(bibn parambibn) {}
  
  public final void run()
  {
    Drawable localDrawable = this.this$0.a();
    if (localDrawable != null)
    {
      bibn.b(this.this$0, localDrawable);
      if (bibw.a(localDrawable)) {
        bibn.c(this.this$0, localDrawable);
      }
      this.this$0.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.updateDrawableState.1
 * JD-Core Version:    0.7.0.1
 */