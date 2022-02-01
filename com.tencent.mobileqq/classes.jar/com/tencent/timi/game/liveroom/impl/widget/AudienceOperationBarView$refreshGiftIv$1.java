package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$refreshGiftIv$1", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "onFailed", "", "code", "", "msg", "", "onSuccess", "canShow", "", "isSpecialAnchor", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceOperationBarView$refreshGiftIv$1
  implements OnQueryGiftIconCallback
{
  AudienceOperationBarView$refreshGiftIv$1(long paramLong, LiveAnchorInfo paramLiveAnchorInfo) {}
  
  public void onFailed(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnQueryGiftIconCallback#onFailed: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c("AudienceOperationBarView", localStringBuilder.toString());
  }
  
  public void onSuccess(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (AudienceOperationBarView.b(this.a) == this.b)
    {
      if (AudienceOperationBarView.c(this.a) != this.c.getAnchorUid()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnQueryGiftIconCallback#onSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      Logger.c("AudienceOperationBarView", ((StringBuilder)localObject).toString());
      localObject = (GiftEntranceView)this.a.a(2131434237);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "giftIv");
      int i;
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 8;
      }
      ((GiftEntranceView)localObject).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.refreshGiftIv.1
 * JD-Core Version:    0.7.0.1
 */