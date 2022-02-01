package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingOperateHelper$doReport$1", "Lcom/tencent/mobileqq/qqlive/callback/supervision/ReportCallback;", "onFailed", "", "errorCode", "", "errorMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingOperateHelper$doReport$1
  implements ReportCallback
{
  public void a()
  {
    Logger.b(LivingOperateHelper.a(LivingOperateHelper.a), "doReport onSuccess");
    CustomToastView.a("举报成功");
  }
  
  public void onFailed(int paramInt, @Nullable String paramString)
  {
    String str = LivingOperateHelper.a(LivingOperateHelper.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doReport error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
    CustomToastView.a("举报失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper.doReport.1
 * JD-Core Version:    0.7.0.1
 */