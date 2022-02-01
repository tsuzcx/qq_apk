package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class AbsAsyncDrawable$updateDrawableState$1
  extends Lambda
  implements Function0<Unit>
{
  AbsAsyncDrawable$updateDrawableState$1(AbsAsyncDrawable paramAbsAsyncDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Drawable localDrawable = this.this$0.e();
    if (localDrawable != null)
    {
      AbsAsyncDrawable.b(this.this$0, localDrawable);
      this.this$0.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncDrawable.updateDrawableState.1
 * JD-Core Version:    0.7.0.1
 */