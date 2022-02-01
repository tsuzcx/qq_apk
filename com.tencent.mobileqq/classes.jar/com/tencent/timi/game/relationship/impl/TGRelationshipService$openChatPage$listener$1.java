package com.tencent.timi.game.relationship.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/relationship/impl/TGRelationshipService$openChatPage$listener$1", "Lcom/tencent/timi/game/relationship/impl/AioChatTokenUtil$TokenListener;", "onError", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "onSuccess", "token", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGRelationshipService$openChatPage$listener$1
  implements AioChatTokenUtil.TokenListener
{
  TGRelationshipService$openChatPage$listener$1(String paramString, int paramInt) {}
  
  public void a(@Nullable QBaseActivity paramQBaseActivity)
  {
    Logger.c(TGRelationshipService.a(this.a), "openChatPage onError");
    if (TGRelationshipService.a(this.a, paramQBaseActivity))
    {
      Context localContext = (Context)paramQBaseActivity;
      QQToast.makeText(localContext, (CharSequence)"信息获取失败", 0).show();
      LoadingUtils localLoadingUtils = LoadingUtils.a;
      if (paramQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      localLoadingUtils.b(localContext);
    }
  }
  
  public void a(@Nullable QBaseActivity paramQBaseActivity, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "token");
    if (TGRelationshipService.a(this.a, paramQBaseActivity))
    {
      TGRelationshipService localTGRelationshipService = this.a;
      if (paramQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      TGRelationshipService.a(localTGRelationshipService, paramQBaseActivity, this.b, this.c, paramArrayOfByte);
      LoadingUtils.a.b((Context)paramQBaseActivity);
      return;
    }
    Logger.c(TGRelationshipService.a(this.a), "openChatPage activity is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.TGRelationshipService.openChatPage.listener.1
 * JD-Core Version:    0.7.0.1
 */