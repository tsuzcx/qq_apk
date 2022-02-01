package com.tencent.mobileqq.kandian.biz.common.baseui.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/ReadInJoyLockScreenJumpDelegateImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IReadInJoyLockScreenJumpDelegate;", "()V", "getJumpDailyFragmentIntent", "Landroid/content/Intent;", "ctx", "Landroid/content/Context;", "launchFrom", "", "redDotInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyLockScreenJumpDelegateImpl
  implements IReadInJoyLockScreenJumpDelegate
{
  @NotNull
  public Intent getJumpDailyFragmentIntent(@Nullable Context paramContext, int paramInt, @Nullable KandianRedDotInfo paramKandianRedDotInfo)
  {
    paramContext = ReadInJoyLockScreenJumpDelegate.a(paramContext, paramInt, paramKandianRedDotInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ReadInJoyLockScreenJumpD…, launchFrom, redDotInfo)");
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.impl.ReadInJoyLockScreenJumpDelegateImpl
 * JD-Core Version:    0.7.0.1
 */