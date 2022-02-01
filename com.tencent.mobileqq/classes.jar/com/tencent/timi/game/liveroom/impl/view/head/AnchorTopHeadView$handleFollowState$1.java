package com.tencent.timi.game.liveroom.impl.view.head;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$handleFollowState$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "isFollow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$handleFollowState$1
  implements IQQLiveCheckFollowCallback
{
  AnchorTopHeadView$handleFollowState$1(boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.b) {
      AnchorTopHeadView.a(this.a, bool);
    }
    if ((bool) && (AnchorTopHeadView.d(this.a))) {
      return;
    }
    AnchorTopHeadView.a(this.a, bool, false, this.b, 2, null);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    if (this.b) {
      AnchorTopHeadView.a(this.a, false);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFollowState#onFail errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    Logger.c("AnchorTopHeadView_", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.handleFollowState.1
 * JD-Core Version:    0.7.0.1
 */