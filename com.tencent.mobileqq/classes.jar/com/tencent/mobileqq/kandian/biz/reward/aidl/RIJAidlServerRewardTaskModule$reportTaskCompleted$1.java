package com.tencent.mobileqq.kandian.biz.reward.aidl;

import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlServerRewardTaskModule$reportTaskCompleted$1", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo$IReportTaskProgressCallback;", "onReportFailed", "", "errorCode", "", "errorMsg", "", "onReportSucceed", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlServerRewardTaskModule$reportTaskCompleted$1
  implements RIJRewardTaskRemoteRepo.IReportTaskProgressCallback
{
  RIJAidlServerRewardTaskModule$reportTaskCompleted$1(IReportTaskProgressCallback paramIReportTaskProgressCallback) {}
  
  public void a()
  {
    IReportTaskProgressCallback localIReportTaskProgressCallback = this.a;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    IReportTaskProgressCallback localIReportTaskProgressCallback = this.a;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlServerRewardTaskModule.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */