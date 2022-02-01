package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/fastweb/util/RIJCoinAnimationUtils$downloadListener$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "throwable", "", "onLoadProgressed", "i", "", "onLoadSuccessed", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCoinAnimationUtils$downloadListener$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    RIJCoinAnimationUtils.b(RIJCoinAnimationUtils.a);
    QLog.d("RIJCoinAnimationUtils", 1, "onLoadSuccessed!");
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    RIJCoinAnimationUtils.a(RIJCoinAnimationUtils.a, paramURLDrawable);
    QLog.d("RIJCoinAnimationUtils", 1, "onLoadSuccessed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils.downloadListener.1
 * JD-Core Version:    0.7.0.1
 */