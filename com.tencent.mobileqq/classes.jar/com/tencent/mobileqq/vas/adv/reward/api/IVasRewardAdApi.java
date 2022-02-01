package com.tencent.mobileqq.vas.adv.reward.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardAdApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initDeviceInfo", "", "requestAd", "activity", "Landroid/app/Activity;", "requestAdParams", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "rewardCallback", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasRewardAdApi
  extends QRouteApi
{
  public abstract void initDeviceInfo();
  
  public abstract void requestAd(@NotNull Activity paramActivity, @NotNull VasRewardAdParams paramVasRewardAdParams, @NotNull VasRewardAdCallback paramVasRewardAdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
 * JD-Core Version:    0.7.0.1
 */