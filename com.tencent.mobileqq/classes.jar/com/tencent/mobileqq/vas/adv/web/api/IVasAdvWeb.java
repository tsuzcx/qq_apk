package com.tencent.mobileqq.vas.adv.web.api;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/api/IVasAdvWeb;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "getWebView", "Lcom/tencent/biz/ui/TouchWebView;", "activity", "Landroid/app/Activity;", "initWebView", "", "removeWebView", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasAdvWeb
  extends QRouteApi, VasAdvWebEvent.Publisher
{
  @Nullable
  public abstract TouchWebView getWebView(@NotNull Activity paramActivity);
  
  public abstract void initWebView();
  
  public abstract void removeWebView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb
 * JD-Core Version:    0.7.0.1
 */