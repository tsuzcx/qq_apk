package com.tencent.mobileqq.kandian.biz.reward.aidl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$isNowInKanDianTab$1
  extends Lambda
  implements Function0<Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  RIJAidlClientRedPacketModule$isNowInKanDianTab$1()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = RIJAidlClientRedPacketModule.a(RIJAidlClientRedPacketModule.a);
    return (localIRIJAidlInterfaceForRewardTask != null) && (localIRIJAidlInterfaceForRewardTask.e() == true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule.isNowInKanDianTab.1
 * JD-Core Version:    0.7.0.1
 */