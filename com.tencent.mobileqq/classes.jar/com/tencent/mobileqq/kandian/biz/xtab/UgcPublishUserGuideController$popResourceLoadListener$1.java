package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/UgcPublishUserGuideController$popResourceLoadListener$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "throwable", "", "onLoadProgressed", "progress", "", "onLoadSuccessed", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UgcPublishUserGuideController$popResourceLoadListener$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(@Nullable URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(@Nullable URLDrawable paramURLDrawable, @Nullable Throwable paramThrowable)
  {
    QLog.e("UgcPublishUserGuideController", 1, "onLoadFailed", paramThrowable);
  }
  
  public void onLoadProgressed(@Nullable URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(@Nullable URLDrawable paramURLDrawable)
  {
    QLog.e("UgcPublishUserGuideController", 1, "pop Resource loadSuccess");
    UgcPublishUserGuideController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.UgcPublishUserGuideController.popResourceLoadListener.1
 * JD-Core Version:    0.7.0.1
 */