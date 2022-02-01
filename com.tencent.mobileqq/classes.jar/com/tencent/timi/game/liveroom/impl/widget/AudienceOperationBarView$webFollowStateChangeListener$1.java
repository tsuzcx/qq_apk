package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "followedUid", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "kotlin.jvm.PlatformType", "onFollowStateChange"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$webFollowStateChangeListener$1
  implements IQQLiveFollowApi.IQQLiveFollowStateListener
{
  AudienceOperationBarView$webFollowStateChangeListener$1(AudienceOperationBarView paramAudienceOperationBarView) {}
  
  public final void onFollowStateChange(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    paramString = AudienceOperationBarView.d(this.a);
    if (paramString != null)
    {
      BaseAnchorInfo localBaseAnchorInfo = paramString.getAnchorInfo();
      Intrinsics.checkExpressionValueIsNotNull(localBaseAnchorInfo, "it.anchorInfo");
      if (localBaseAnchorInfo.getAnchorUid() == paramLong2) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt == 0) {
        paramString = null;
      }
      if (paramString != null) {
        AudienceOperationBarView.b(this.a, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.webFollowStateChangeListener.1
 * JD-Core Version:    0.7.0.1
 */