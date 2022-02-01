package com.tencent.timi.game.liveroom.impl.view.head;

import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "uid", "", "followedUid", "isFollowed", "", "roomId", "", "kotlin.jvm.PlatformType", "onFollowStateChange"}, k=3, mv={1, 1, 16})
final class AnchorTopHeadView$qqLiveFollowStateListener$1
  implements IQQLiveFollowApi.IQQLiveFollowStateListener
{
  AnchorTopHeadView$qqLiveFollowStateListener$1(AnchorTopHeadView paramAnchorTopHeadView) {}
  
  public final void onFollowStateChange(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("qqLiveFollowStateListener ");
    paramString.append(paramInt);
    paramString.append(' ');
    paramString = paramString.toString();
    boolean bool = true;
    Logger.a("AnchorTopHeadView_", 1, paramString);
    if (AnchorTopHeadView.h(this.a) == paramLong2)
    {
      paramString = this.a;
      if (paramInt != 1) {
        bool = false;
      }
      AnchorTopHeadView.a(paramString, bool, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.qqLiveFollowStateListener.1
 * JD-Core Version:    0.7.0.1
 */