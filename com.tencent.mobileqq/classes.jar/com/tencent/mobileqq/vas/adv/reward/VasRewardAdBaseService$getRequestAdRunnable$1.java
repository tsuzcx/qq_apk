package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasRewardAdBaseService$getRequestAdRunnable$1
  implements Runnable
{
  VasRewardAdBaseService$getRequestAdRunnable$1(VasRewardAdBaseService paramVasRewardAdBaseService) {}
  
  public final void run()
  {
    if (!VasRewardAdBaseService.a(this.this$0).compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "repeating request ad, discard");
      }
      return;
    }
    if (!this.this$0.a())
    {
      VasRewardAdBaseService.a(this.this$0).set(false);
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "requestAd: early return, beforeRequestAd failed");
      }
      return;
    }
    VasRewardAdBaseService.getRequestAdRunnable.1.callback.1 local1 = new VasRewardAdBaseService.getRequestAdRunnable.1.callback.1(this);
    VasRewardAdBaseService.a(this.this$0, (VasAdvBizCallback)local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService.getRequestAdRunnable.1
 * JD-Core Version:    0.7.0.1
 */