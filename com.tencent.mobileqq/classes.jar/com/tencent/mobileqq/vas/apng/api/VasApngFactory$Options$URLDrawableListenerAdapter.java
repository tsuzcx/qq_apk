package com.tencent.mobileqq.vas.apng.api;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/VasApngFactory$Options$URLDrawableListenerAdapter;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "()V", "onLoadCanceled", "", "arg0", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "arg1", "", "onLoadProgressed", "", "onLoadSuccessed", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
final class VasApngFactory$Options$URLDrawableListenerAdapter
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "arg0");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "arg0");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "arg1");
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "arg0");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "arg0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options.URLDrawableListenerAdapter
 * JD-Core Version:    0.7.0.1
 */