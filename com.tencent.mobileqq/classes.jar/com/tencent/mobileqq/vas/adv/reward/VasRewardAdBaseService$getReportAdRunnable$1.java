package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasRewardAdBaseService$getReportAdRunnable$1
  implements Runnable
{
  VasRewardAdBaseService$getReportAdRunnable$1(VasRewardAdBaseService paramVasRewardAdBaseService) {}
  
  public final void run()
  {
    if (!VasRewardAdBaseService.c(this.this$0).compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "repeating report ad, discard");
      }
      return;
    }
    if (!this.this$0.f())
    {
      VasRewardAdBaseService.c(this.this$0).set(false);
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "reportAd: early return, beforeReportAd failed");
      }
      return;
    }
    VasRewardAdBaseService.getReportAdRunnable.1.callback.1 local1 = new VasRewardAdBaseService.getReportAdRunnable.1.callback.1(this);
    VasRewardAdBaseService.b(this.this$0, (VasAdvBizCallback)local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService.getReportAdRunnable.1
 * JD-Core Version:    0.7.0.1
 */