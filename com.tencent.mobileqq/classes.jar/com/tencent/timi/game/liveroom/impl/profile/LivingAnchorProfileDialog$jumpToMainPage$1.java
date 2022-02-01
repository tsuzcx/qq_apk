package com.tencent.timi.game.liveroom.impl.profile;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$jumpToMainPage$1", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveGetAnchorPageUrlCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "anchorPageUrl", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAnchorProfileDialog$jumpToMainPage$1
  implements IQQLiveGetAnchorPageUrlCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    String str = LivingAnchorProfileDialog.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAnchorPageUrl ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
    this.a.a();
  }
  
  public void a(@Nullable String paramString)
  {
    Logger.a(LivingAnchorProfileDialog.d(this.a), "getAnchorPageUrl success");
    if (!this.a.a())
    {
      if (!TextUtils.isEmpty((CharSequence)paramString))
      {
        this.a.dismiss();
        LivingAnchorProfileDialog.a(this.a, paramString);
        return;
      }
      Logger.c(LivingAnchorProfileDialog.d(this.a), "getAnchorPageUrl error url null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAnchorProfileDialog.jumpToMainPage.1
 * JD-Core Version:    0.7.0.1
 */