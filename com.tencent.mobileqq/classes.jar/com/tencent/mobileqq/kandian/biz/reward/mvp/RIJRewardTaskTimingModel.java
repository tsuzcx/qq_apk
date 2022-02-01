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
  public int a(boolean paramBoolean)
  {
    return RIJRewardTaskLocalRepo.f().a(paramBoolean);
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return RIJRewardTaskLocalRepo.f().a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    RIJRewardTaskLocalRepo.f().a(paramInt, paramBoolean);
  }
  
  public void a(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.f().a(paramRIJRewardTask);
  }
  
  public void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJRewardTaskRemoteRepo.b().a(paramString, paramInt, new RIJRewardTaskTimingModel.1(this, paramIReportTaskProgressCallback));
  }
  
  public boolean a(@NotNull String paramString)
  {
    return RIJRewardTaskLocalRepo.f().a(paramString);
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return RIJRewardTaskLocalRepo.f().b();
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.f().b(paramRIJRewardTask);
  }
  
  public void b(@NotNull String paramString)
  {
    RIJRewardTaskLocalRepo.f().b(paramString);
  }
  
  public int c()
  {
    return RIJRewardTaskLocalRepo.f().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModel
 * JD-Core Version:    0.7.0.1
 */