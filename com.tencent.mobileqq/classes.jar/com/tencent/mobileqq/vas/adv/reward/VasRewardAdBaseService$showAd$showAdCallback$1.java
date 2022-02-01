package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$showAd$showAdCallback$1", "Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$ShowAdCallback;", "onAdShowed", "", "success", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdBaseService$showAd$showAdCallback$1
  implements VasRewardAdBaseService.ShowAdCallback
{
  public void a(boolean paramBoolean)
  {
    VasRewardAdBaseService.b(this.a).set(false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show ad result: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("VasRewardAdBaseService", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService.showAd.showAdCallback.1
 * JD-Core Version:    0.7.0.1
 */