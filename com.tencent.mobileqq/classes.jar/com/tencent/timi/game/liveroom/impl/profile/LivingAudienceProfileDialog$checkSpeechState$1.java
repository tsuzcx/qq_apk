package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingAudienceProfileDialog$checkSpeechState$1", "Lcom/tencent/mobileqq/qqlive/callback/supervision/QueryIsBanedChatCallback;", "onFailed", "", "errorCode", "", "errorMsg", "", "onSuccess", "isBanChat", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAudienceProfileDialog$checkSpeechState$1
  implements QueryIsBanedChatCallback
{
  public void a(boolean paramBoolean)
  {
    String str = LivingAudienceProfileDialog.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSpeechState  onSuccess ");
    localStringBuilder.append(paramBoolean);
    Logger.a(str, localStringBuilder.toString());
    LivingAudienceProfileDialog.a(this.a, paramBoolean);
  }
  
  public void onFailed(int paramInt, @Nullable String paramString)
  {
    String str = LivingAudienceProfileDialog.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSpeechState  error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAudienceProfileDialog.checkSpeechState.1
 * JD-Core Version:    0.7.0.1
 */