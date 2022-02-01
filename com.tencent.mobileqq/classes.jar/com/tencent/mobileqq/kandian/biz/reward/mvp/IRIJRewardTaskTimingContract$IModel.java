package com.tencent.mobileqq.kandian.biz.reward.mvp;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import org.jetbrains.annotations.NotNull;

public abstract interface IRIJRewardTaskTimingContract$IModel
{
  public abstract int a();
  
  public abstract int a(boolean paramBoolean);
  
  @Nullable
  public abstract RIJRewardTask a();
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(@Nullable RIJRewardTask paramRIJRewardTask);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback);
  
  public abstract boolean a(@NotNull String paramString);
  
  @Nullable
  public abstract RIJRewardTask b();
  
  public abstract void b(RIJRewardTask paramRIJRewardTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.IRIJRewardTaskTimingContract.IModel
 * JD-Core Version:    0.7.0.1
 */