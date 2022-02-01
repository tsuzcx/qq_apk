package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
final class DynamicDrawable$doTargetDrawableBuild$1
  extends Lambda
  implements Function0<Drawable>
{
  DynamicDrawable$doTargetDrawableBuild$1(DynamicDrawable paramDynamicDrawable)
  {
    super(0);
  }
  
  @Nullable
  public final Drawable invoke()
  {
    try
    {
      Drawable localDrawable = (Drawable)this.this$0.b().invoke();
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.doTargetDrawableBuild.1
 * JD-Core Version:    0.7.0.1
 */