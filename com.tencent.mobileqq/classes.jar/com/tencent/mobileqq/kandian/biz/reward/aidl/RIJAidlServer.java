package com.tencent.mobileqq.kandian.biz.reward.aidl;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlServer;", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterface$Stub;", "()V", "rijAidlInterfaceForRedPacket", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterfaceForRewardTask;", "getRewardTaskInterface", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlServer
  extends IRIJAidlInterface.Stub
{
  private IRIJAidlInterfaceForRewardTask a;
  
  @Nullable
  public IRIJAidlInterfaceForRewardTask a()
  {
    if (this.a == null) {
      this.a = ((IRIJAidlInterfaceForRewardTask)new RIJAidlServerRewardTaskModule());
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlServer
 * JD-Core Version:    0.7.0.1
 */