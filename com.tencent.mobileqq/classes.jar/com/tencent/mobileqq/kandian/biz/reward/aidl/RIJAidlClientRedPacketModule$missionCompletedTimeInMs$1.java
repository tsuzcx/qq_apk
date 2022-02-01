package com.tencent.mobileqq.kandian.biz.reward.aidl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$missionCompletedTimeInMs$1
  extends Lambda
  implements Function0<Integer>
{
  public static final 1 INSTANCE = new 1();
  
  RIJAidlClientRedPacketModule$missionCompletedTimeInMs$1()
  {
    super(0);
  }
  
  public final int invoke()
  {
    IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = RIJAidlClientRedPacketModule.a(RIJAidlClientRedPacketModule.a);
    if (localIRIJAidlInterfaceForRewardTask != null) {
      return localIRIJAidlInterfaceForRewardTask.g();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule.missionCompletedTimeInMs.1
 * JD-Core Version:    0.7.0.1
 */