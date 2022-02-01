package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay$handleLoadUserInfoSucceed$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "drawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "throwable", "", "onLoadProgressed", "progress", "", "onLoadSuccessed", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AvatarBadgeDisplay$handleLoadUserInfoSucceed$1
  implements URLDrawable.URLDrawableListener
{
  AvatarBadgeDisplay$handleLoadUserInfoSucceed$1(Function2 paramFunction2, String paramString) {}
  
  public void onLoadCanceled(@Nullable URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(@Nullable URLDrawable paramURLDrawable, @Nullable Throwable paramThrowable)
  {
    QLog.e("AvatarBadgeDisplay", 2, paramThrowable, new Object[] { "handleLoadUserInfoSucceed, onLoadFialed" });
    paramURLDrawable = this.a;
    long l = Long.parseLong(this.b);
    paramThrowable = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
    Intrinsics.checkExpressionValueIsNotNull(paramThrowable, "QRoute.api(IQQAvatarUtil…DefaultFaceDrawable(true)");
    paramURLDrawable.invoke(Long.valueOf(l), paramThrowable);
  }
  
  public void onLoadProgressed(@Nullable URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(@Nullable URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.a.invoke(Long.valueOf(Long.parseLong(this.b)), paramURLDrawable);
      return;
    }
    paramURLDrawable = this.a;
    long l = Long.parseLong(this.b);
    Drawable localDrawable = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "QRoute.api(IQQAvatarUtil…DefaultFaceDrawable(true)");
    paramURLDrawable.invoke(Long.valueOf(l), localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay.handleLoadUserInfoSucceed.1
 * JD-Core Version:    0.7.0.1
 */