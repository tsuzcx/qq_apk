package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import bhqs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
public final class DynamicDrawable$doFailedDrawableBuild$1
  extends Lambda
  implements Function0<Drawable>
{
  public DynamicDrawable$doFailedDrawableBuild$1(bhqs parambhqs)
  {
    super(0);
  }
  
  @Nullable
  public final Drawable invoke()
  {
    try
    {
      Object localObject = this.this$0.a();
      if (localObject != null)
      {
        localObject = (Drawable)((Function0)localObject).invoke();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.doFailedDrawableBuild.1
 * JD-Core Version:    0.7.0.1
 */