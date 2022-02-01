package com.tencent.mobileqq.vas.adv.reward.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "", "onReward", "", "retCode", "", "requestBizBuff", "", "reportBizBuff", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasRewardAdCallback
{
  public abstract void onReward(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback
 * JD-Core Version:    0.7.0.1
 */