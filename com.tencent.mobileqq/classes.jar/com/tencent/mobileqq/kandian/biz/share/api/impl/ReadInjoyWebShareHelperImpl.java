package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareInMainProgressHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper.CallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ReadInjoyWebShareHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper;", "()V", "showShareActionSheet", "", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "data", "Landroid/os/Bundle;", "callBack", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$CallBack;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInjoyWebShareHelperImpl
  implements IReadInjoyWebShareHelper
{
  public void showShareActionSheet(@NotNull Activity paramActivity, @NotNull AppInterface paramAppInterface, @NotNull Bundle paramBundle, @NotNull IReadInjoyWebShareHelper.CallBack paramCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Intrinsics.checkParameterIsNotNull(paramCallBack, "callBack");
    new ReadInjoyWebShareInMainProgressHelper(paramActivity, paramAppInterface, paramCallBack).a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.impl.ReadInjoyWebShareHelperImpl
 * JD-Core Version:    0.7.0.1
 */