package com.tencent.mobileqq.kandian.biz.pts.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/pts/util/RIJProteusDrawableHelper$getDrawableFromNet$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDrawableHelper$getDrawableFromNet$1
  implements Drawable.Callback
{
  RIJProteusDrawableHelper$getDrawableFromNet$1(DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void invalidateDrawable(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    QLog.i("Q.readinjoy.proteus", 1, "invalidateDrawable: ");
    this.a.onCallBack(true, (Drawable)this.b);
  }
  
  public void scheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
  }
  
  public void unscheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusDrawableHelper.getDrawableFromNet.1
 * JD-Core Version:    0.7.0.1
 */