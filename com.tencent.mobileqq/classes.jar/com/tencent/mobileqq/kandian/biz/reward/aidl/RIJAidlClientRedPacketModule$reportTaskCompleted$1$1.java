package com.tencent.mobileqq.kandian.biz.reward.aidl;

import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlClientRedPacketModule$reportTaskCompleted$1$1", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IReportTaskProgressCallback$Stub;", "onReportFailed", "", "errorCode", "", "errorMsg", "", "onReportSucceed", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClientRedPacketModule$reportTaskCompleted$1$1
  extends IReportTaskProgressCallback.Stub
{
  public void a()
  {
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.a.$callback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.a.$callback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1.1
 * JD-Core Version:    0.7.0.1
 */