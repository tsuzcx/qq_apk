package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingAudienceProfileDialog$cancelBanChat$1", "Lcom/tencent/mobileqq/qqlive/callback/supervision/SetBanChatCallback;", "onFailed", "", "errorCode", "", "errorMsg", "", "onSuccess", "isDisable", "", "targetUserUid", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAudienceProfileDialog$cancelBanChat$1
  implements SetBanChatCallback
{
  public void a(boolean paramBoolean, long paramLong)
  {
    Logger.a(LivingAudienceProfileDialog.a(this.a), "cancelBanChat  success");
    CustomToastView.a("取消禁言成功");
    this.a.dismiss();
  }
  
  public void onFailed(int paramInt, @Nullable String paramString)
  {
    String str = LivingAudienceProfileDialog.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelBanChat  error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
    CustomToastView.a("服务器出小差，请稍后重试～");
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAudienceProfileDialog.cancelBanChat.1
 * JD-Core Version:    0.7.0.1
 */