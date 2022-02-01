package com.tencent.mobileqq.kandian.biz.reward.aidl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterfaceForRewardTask;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$rijAidlInterfaceForRewardTask$1
  extends Lambda
  implements Function0<IRIJAidlInterfaceForRewardTask>
{
  public static final 1 INSTANCE = new 1();
  
  RIJAidlClientRedPacketModule$rijAidlInterfaceForRewardTask$1()
  {
    super(0);
  }
  
  @Nullable
  public final IRIJAidlInterfaceForRewardTask invoke()
  {
    IRIJAidlInterface localIRIJAidlInterface = RIJAidlClient.a.a();
    if (localIRIJAidlInterface != null) {
      return localIRIJAidlInterface.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule.rijAidlInterfaceForRewardTask.1
 * JD-Core Version:    0.7.0.1
 */