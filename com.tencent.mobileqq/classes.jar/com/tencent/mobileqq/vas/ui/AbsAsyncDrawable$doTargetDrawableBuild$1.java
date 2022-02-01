package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
final class AbsAsyncDrawable$doTargetDrawableBuild$1
  extends Lambda
  implements Function0<Drawable>
{
  AbsAsyncDrawable$doTargetDrawableBuild$1(AbsAsyncDrawable paramAbsAsyncDrawable)
  {
    super(0);
  }
  
  @Nullable
  public final Drawable invoke()
  {
    try
    {
      Drawable localDrawable = (Drawable)this.this$0.d().invoke();
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AbsAsyncDrawable", 1, "error", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncDrawable.doTargetDrawableBuild.1
 * JD-Core Version:    0.7.0.1
 */