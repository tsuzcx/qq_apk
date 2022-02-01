package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$initFollow$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "isFollow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAnchorProfileDialog$initFollow$1
  implements IQQLiveCheckFollowCallback
{
  public void a(int paramInt)
  {
    if (!this.a.a())
    {
      LivingAnchorProfileDialog localLivingAnchorProfileDialog = this.a;
      boolean bool;
      if (paramInt == LivingAnchorProfileDialog.b(localLivingAnchorProfileDialog)) {
        bool = true;
      } else {
        bool = false;
      }
      LivingAnchorProfileDialog.a(localLivingAnchorProfileDialog, bool);
      LivingAnchorProfileDialog.c(this.a);
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    String str = LivingAnchorProfileDialog.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IQQLiveCheckFollowCallback ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAnchorProfileDialog.initFollow.1
 * JD-Core Version:    0.7.0.1
 */