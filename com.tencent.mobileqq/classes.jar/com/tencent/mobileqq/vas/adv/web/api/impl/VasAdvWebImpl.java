package com.tencent.mobileqq.vas.adv.web.api.impl;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vas.adv.web.VasAdvWebManager;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/api/impl/VasAdvWebImpl;", "Lcom/tencent/mobileqq/vas/adv/web/api/IVasAdvWeb;", "()V", "getWebView", "Lcom/tencent/biz/ui/TouchWebView;", "activity", "Landroid/app/Activity;", "initWebView", "", "removeWebView", "subscribe", "businessId", "", "subscriber", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "unsubscribe", "unsubscribeAll", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebImpl
  implements IVasAdvWeb
{
  @Nullable
  public TouchWebView getWebView(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return VasAdvWebManager.a.a(paramActivity);
  }
  
  public void initWebView()
  {
    VasAdvWebManager.a.b();
  }
  
  public void removeWebView()
  {
    VasAdvWebManager.a.a();
  }
  
  public void subscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramSubscriber, "subscriber");
    VasAdvWebManager.a.subscribe(paramString, paramSubscriber);
  }
  
  public void unsubscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramSubscriber, "subscriber");
    VasAdvWebManager.a.unsubscribe(paramString, paramSubscriber);
  }
  
  public void unsubscribeAll(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    VasAdvWebManager.a.unsubscribeAll(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.api.impl.VasAdvWebImpl
 * JD-Core Version:    0.7.0.1
 */