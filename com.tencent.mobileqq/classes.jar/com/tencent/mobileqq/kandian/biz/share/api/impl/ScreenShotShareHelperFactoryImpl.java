package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelperFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ScreenShotShareHelperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IScreenShotShareHelperFactory;", "()V", "createScreenShotShareHelper", "Lcom/tencent/mobileqq/kandian/biz/share/api/IScreenShotShareHelper;", "activity", "Landroid/app/Activity;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScreenShotShareHelperFactoryImpl
  implements IScreenShotShareHelperFactory
{
  @NotNull
  public IScreenShotShareHelper createScreenShotShareHelper(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return (IScreenShotShareHelper)new ScreenShotShareHelper(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.impl.ScreenShotShareHelperFactoryImpl
 * JD-Core Version:    0.7.0.1
 */