package com.tencent.mobileqq.vas.adv.reward.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.reward.VasRewardAdService;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl;", "Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardAdApi;", "()V", "initDeviceInfo", "", "requestAd", "activity", "Landroid/app/Activity;", "requestAdParams", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "rewardCallback", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdApiImpl
  implements IVasRewardAdApi
{
  public void initDeviceInfo()
  {
    VasAdvSupport.a.a().a("1018ec");
  }
  
  public void requestAd(@NotNull Activity paramActivity, @NotNull VasRewardAdParams paramVasRewardAdParams, @NotNull VasRewardAdCallback paramVasRewardAdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramVasRewardAdParams, "requestAdParams");
    Intrinsics.checkParameterIsNotNull(paramVasRewardAdCallback, "rewardCallback");
    new VasRewardAdService(paramActivity, paramVasRewardAdParams, paramVasRewardAdCallback).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.api.impl.VasRewardAdApiImpl
 * JD-Core Version:    0.7.0.1
 */