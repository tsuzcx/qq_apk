package com.tencent.timi.game.relationship.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.relationship.impl.net.GetSessionInfoRequest;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/impl/AioChatTokenUtil;", "", "()V", "TAG", "", "acquireTkoen", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "toUin", "listener", "Lcom/tencent/timi/game/relationship/impl/AioChatTokenUtil$TokenListener;", "TokenListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AioChatTokenUtil
{
  public static final AioChatTokenUtil a = new AioChatTokenUtil();
  private static final String b = "AioChatTokenUtil";
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString, @NotNull AioChatTokenUtil.TokenListener paramTokenListener)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "toUin");
    Intrinsics.checkParameterIsNotNull(paramTokenListener, "listener");
    Logger.b(b, "acquireTkoen start");
    paramQBaseActivity = new WeakReference(paramQBaseActivity);
    paramString = StringsKt.toLongOrNull(paramString);
    long l1;
    if (paramString != null) {
      l1 = paramString.longValue();
    } else {
      l1 = 0L;
    }
    paramString = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "ServiceCenter.getService…nCoreService::class.java)");
    long l2 = ((ILoginCoreService)paramString).a();
    GetSessionInfoRequest.a.a(l2, l1, (IResultListener)new AioChatTokenUtil.acquireTkoen.1(paramTokenListener, paramQBaseActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.AioChatTokenUtil
 * JD-Core Version:    0.7.0.1
 */