package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/reward/VasRewardAdService$getProfitableCallback$1", "Lcom/tencent/mobileqq/vas/adv/reward/VasProfitableCallback;", "onResult", "", "profitable", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdService$getProfitableCallback$1
  implements VasProfitableCallback
{
  VasRewardAdService$getProfitableCallback$1(VasRewardAdBaseService.ShowAdCallback paramShowAdCallback) {}
  
  public void a(boolean paramBoolean)
  {
    this.b.a(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRewardAdv onResult profitable: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("VasRewardAdService", 0, localStringBuilder.toString());
    }
    if (paramBoolean == true)
    {
      this.a.c();
      return;
    }
    if (!paramBoolean) {
      VasRewardAdService.a(this.a, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdService.getProfitableCallback.1
 * JD-Core Version:    0.7.0.1
 */