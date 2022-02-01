package com.tencent.mobileqq.kandian.biz.reward.mvp;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingModel
  implements IRIJRewardTaskTimingContract.IModel
{
  public int a()
  {
    return RIJRewardTaskLocalRepo.b().a();
  }
  
  public int a(boolean paramBoolean)
  {
    return RIJRewardTaskLocalRepo.b().a(paramBoolean);
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return RIJRewardTaskLocalRepo.b().a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    RIJRewardTaskLocalRepo.b().a(paramInt, paramBoolean);
  }
  
  public void a(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.b().a(paramRIJRewardTask);
  }
  
  public void a(@NotNull String paramString)
  {
    RIJRewardTaskLocalRepo.b().a(paramString);
  }
  
  public void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJRewardTaskRemoteRepo.b().a(paramString, paramInt, new RIJRewardTaskTimingModel.1(this, paramIReportTaskProgressCallback));
  }
  
  public boolean a(@NotNull String paramString)
  {
    return RIJRewardTaskLocalRepo.b().a(paramString);
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return RIJRewardTaskLocalRepo.b().b();
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.b().b(paramRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModel
 * JD-Core Version:    0.7.0.1
 */