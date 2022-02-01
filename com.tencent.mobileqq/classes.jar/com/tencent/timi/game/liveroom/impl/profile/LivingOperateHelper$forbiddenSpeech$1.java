package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingOperateHelper$forbiddenSpeech$1", "Lcom/tencent/mobileqq/qqlive/callback/supervision/SetBanChatCallback;", "onFailed", "", "errorCode", "", "errorMsg", "", "onSuccess", "isDisable", "", "targetUserUid", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingOperateHelper$forbiddenSpeech$1
  implements SetBanChatCallback
{
  LivingOperateHelper$forbiddenSpeech$1(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    Logger.b(LivingOperateHelper.a(LivingOperateHelper.a), "forbiddenSpeech onSuccess");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已成功将");
    localStringBuilder.append(this.a);
    localStringBuilder.append("禁言");
    CustomToastView.a(localStringBuilder.toString());
  }
  
  public void onFailed(int paramInt, @Nullable String paramString)
  {
    String str = LivingOperateHelper.a(LivingOperateHelper.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forbiddenSpeech error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
    CustomToastView.a("服务器出小差，请稍后重试～");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper.forbiddenSpeech.1
 * JD-Core Version:    0.7.0.1
 */