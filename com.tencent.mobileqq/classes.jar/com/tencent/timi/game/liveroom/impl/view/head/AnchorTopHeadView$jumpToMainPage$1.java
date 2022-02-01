package com.tencent.timi.game.liveroom.impl.view.head;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.timi.game.liveroom.impl.util.LivingWebUtil;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$jumpToMainPage$1", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveGetAnchorPageUrlCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "anchorPageUrl", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$jumpToMainPage$1
  implements IQQLiveGetAnchorPageUrlCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAnchorPageUrl ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramString);
    Logger.c("AnchorTopHeadView_", localStringBuilder.toString());
  }
  
  public void a(@Nullable String paramString)
  {
    Logger.a("AnchorTopHeadView_", "getAnchorPageUrl success");
    if ((!AnchorTopHeadView.c(this.a)) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      LivingWebUtil localLivingWebUtil = LivingWebUtil.a;
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localLivingWebUtil.a(localContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.jumpToMainPage.1
 * JD-Core Version:    0.7.0.1
 */