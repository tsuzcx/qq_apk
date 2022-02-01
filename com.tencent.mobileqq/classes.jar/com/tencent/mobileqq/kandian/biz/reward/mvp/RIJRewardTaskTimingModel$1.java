package com.tencent.mobileqq.kandian.biz.reward.mvp;

import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import org.jetbrains.annotations.Nullable;

class RIJRewardTaskTimingModel$1
  implements RIJRewardTaskRemoteRepo.IReportTaskProgressCallback
{
  RIJRewardTaskTimingModel$1(RIJRewardTaskTimingModel paramRIJRewardTaskTimingModel, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback) {}
  
  public void a()
  {
    int i = RIJRewardTaskLocalRepo.b().a();
    RIJRewardTaskLocalRepo.b().a(i + 1);
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModel.1
 * JD-Core Version:    0.7.0.1
 */