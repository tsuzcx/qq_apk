package com.tencent.mobileqq.kandian.biz.reward;

import cooperation.liveroom.LiveRoomGiftCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "args", "", "onCall"}, k=3, mv={1, 1, 16})
final class RIJRewardVideoTipsManager$onRewardSuccess$1
  implements LiveRoomGiftCallback
{
  RIJRewardVideoTipsManager$onRewardSuccess$1(RIJRewardVideoTipsManager paramRIJRewardVideoTipsManager) {}
  
  public final void onCall(int paramInt, @Nullable String paramString)
  {
    if (paramInt == 7)
    {
      RIJRewardVideoTipsManager.a(this.a);
      RIJRewardVideoTipsManager.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager.onRewardSuccess.1
 * JD-Core Version:    0.7.0.1
 */