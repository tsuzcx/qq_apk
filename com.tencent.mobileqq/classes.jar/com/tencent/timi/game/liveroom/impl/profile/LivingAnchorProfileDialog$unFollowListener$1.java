package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$unFollowListener$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAnchorProfileDialog$unFollowListener$1
  implements IQQLiveFollowCallback
{
  public void a()
  {
    if (!this.a.a())
    {
      LivingAnchorProfileDialog.a(this.a, false);
      CustomToastView.a("取消关注成功");
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
    if (!this.a.a()) {
      CustomToastView.a("取消关注失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAnchorProfileDialog.unFollowListener.1
 * JD-Core Version:    0.7.0.1
 */