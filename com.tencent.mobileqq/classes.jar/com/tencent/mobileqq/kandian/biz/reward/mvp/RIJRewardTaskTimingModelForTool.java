package com.tencent.mobileqq.kandian.biz.reward.mvp;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingModelForTool
  implements IRIJRewardTaskTimingContract.IModel
{
  public int a(boolean paramBoolean)
  {
    return RIJAidlClientRedPacketModule.d();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return RIJAidlClientRedPacketModule.b();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    RIJAidlClientRedPacketModule.a(paramInt);
  }
  
  public void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRedPacketModule.a(paramRIJRewardTask);
  }
  
  public void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJAidlClientRedPacketModule.a(paramString, paramInt, paramIReportTaskProgressCallback);
  }
  
  public boolean a(@NotNull String paramString)
  {
    return RIJAidlClientRedPacketModule.a(paramString);
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return RIJAidlClientRedPacketModule.c();
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRedPacketModule.b(paramRIJRewardTask);
  }
  
  public void b(@NotNull String paramString)
  {
    RIJAidlClientRedPacketModule.b(paramString);
  }
  
  public int c()
  {
    return RIJAidlClientRedPacketModule.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModelForTool
 * JD-Core Version:    0.7.0.1
 */