package com.tencent.mobileqq.kandian.biz.reward.aidl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$setRead$1
  extends Lambda
  implements Function0<Unit>
{
  RIJAidlClientRedPacketModule$setRead$1(String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = RIJAidlClientRedPacketModule.a(RIJAidlClientRedPacketModule.a);
    if (localIRIJAidlInterfaceForRewardTask != null) {
      localIRIJAidlInterfaceForRewardTask.a(this.$rowKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule.setRead.1
 * JD-Core Version:    0.7.0.1
 */