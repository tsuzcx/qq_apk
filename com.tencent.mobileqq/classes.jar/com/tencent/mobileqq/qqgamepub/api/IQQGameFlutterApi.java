package com.tencent.mobileqq.qqgamepub.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.qqgamepub.config.DnFlutterConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/api/IQQGameFlutterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDynamicInfo", "", "config", "Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfig;", "isAppInstalled", "", "isEngineInstalled", "preloadFlutter", "", "startFlutterPage", "context", "Landroid/content/Context;", "pageRouter", "Lcom/tencent/mobileqq/flutter/router/PageRouter;", "bundle", "Landroid/os/Bundle;", "updateDnFlutter", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IQQGameFlutterApi
  extends QRouteApi
{
  @NotNull
  public abstract String getDynamicInfo(@NotNull DnFlutterConfig paramDnFlutterConfig);
  
  public abstract boolean isAppInstalled();
  
  public abstract boolean isEngineInstalled();
  
  public abstract void preloadFlutter();
  
  public abstract void startFlutterPage(@Nullable Context paramContext, @Nullable PageRouter paramPageRouter, @Nullable Bundle paramBundle);
  
  public abstract void updateDnFlutter(@NotNull DnFlutterConfig paramDnFlutterConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi
 * JD-Core Version:    0.7.0.1
 */