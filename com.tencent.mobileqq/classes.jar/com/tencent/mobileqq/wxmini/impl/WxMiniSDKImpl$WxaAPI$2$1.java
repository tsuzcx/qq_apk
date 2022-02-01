package com.tencent.mobileqq.wxmini.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.luggage.wxaapi.LaunchByUsernameResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppWithShortLinkResultListener;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.luggage.wxaapi.UploadLogResultListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.WxaAppCloseEventListener;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wxmini/impl/WxMiniSDKImpl$WxaAPI$2$1", "Lcom/tencent/luggage/wxaapi/WxaApi;", "TAG", "", "addWxaAppCloseEventListener", "", "p0", "Lcom/tencent/luggage/wxaapi/WxaAppCloseEventListener;", "kotlin.jvm.PlatformType", "checkAuthState", "Lcom/tencent/luggage/wxaapi/TdiAuthCheckStateListener;", "checkIfWechatSupportWxaApi", "", "clearAuth", "closeWxaApp", "p1", "getDebugApi", "Lcom/tencent/luggage/wxaapi/DebugApi;", "getSDKVersion", "getSDKVersionInt", "", "getTdiUserId", "handleIntent", "Landroid/content/Context;", "Landroid/content/Intent;", "initDynamicPkg", "Lcom/tencent/luggage/wxaapi/InitDynamicPkgResult;", "isDynamicPkgLoaded", "launchByQRRawData", "", "p2", "", "", "", "p3", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "launchByQRScanCode", "launchByUsername", "p4", "Lcom/tencent/luggage/wxaapi/LaunchByUsernameResultListener;", "p5", "launchWxaApp", "context", "wxaAppID", "versionType", "enterPath", "listener", "launchWxaByShortLink", "Landroid/app/Activity;", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppWithShortLinkResultListener;", "preloadWxaProcessEnv", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResultListener;", "removeWxaAppCloseEventListener", "requestUploadLogFiles", "Lcom/tencent/luggage/wxaapi/UploadLogResultListener;", "sendAuth", "Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "sendCombineAuth", "Lcom/tencent/mm/opensdk/modelmsg/SendAuth$Req;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "setWxaProcessMaxCount", "updateTuringOAID", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class WxMiniSDKImpl$WxaAPI$2$1
  implements WxaApi
{
  private final String b;
  
  WxMiniSDKImpl$WxaAPI$2$1()
  {
    WxaApi localWxaApi = WxMiniSDKImpl.a(WxMiniSDKImpl.a);
    if (localWxaApi == null) {
      Intrinsics.throwNpe();
    }
    this.c = localWxaApi;
    this.b = "DemoApi.WxaAPI";
  }
  
  public void addWxaAppCloseEventListener(WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    this.c.addWxaAppCloseEventListener(paramWxaAppCloseEventListener);
  }
  
  public void checkAuthState(TdiAuthCheckStateListener paramTdiAuthCheckStateListener)
  {
    this.c.checkAuthState(paramTdiAuthCheckStateListener);
  }
  
  public boolean checkIfWechatSupportWxaApi()
  {
    return this.c.checkIfWechatSupportWxaApi();
  }
  
  public void clearAuth()
  {
    this.c.clearAuth();
  }
  
  public void closeWxaApp(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "p0");
    this.c.closeWxaApp(paramString, paramBoolean);
  }
  
  public DebugApi getDebugApi()
  {
    return this.c.getDebugApi();
  }
  
  public String getSDKVersion()
  {
    return this.c.getSDKVersion();
  }
  
  public int getSDKVersionInt()
  {
    return this.c.getSDKVersionInt();
  }
  
  public String getTdiUserId()
  {
    return this.c.getTdiUserId();
  }
  
  public boolean handleIntent(Context paramContext, Intent paramIntent)
  {
    return this.c.handleIntent(paramContext, paramIntent);
  }
  
  public InitDynamicPkgResult initDynamicPkg(String paramString)
  {
    return this.c.initDynamicPkg(paramString);
  }
  
  public boolean isDynamicPkgLoaded()
  {
    return this.c.isDynamicPkgLoaded();
  }
  
  public long launchByQRRawData(@Nullable Context paramContext, @NonNull @NotNull String paramString, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "p1");
    return this.c.launchByQRRawData(paramContext, paramString, paramMap, paramLaunchWxaAppResultListener);
  }
  
  public long launchByQRScanCode(@Nullable Context paramContext, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    return this.c.launchByQRScanCode(paramContext, paramLaunchWxaAppResultListener);
  }
  
  public long launchByQRScanCode(@Nullable Context paramContext, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    return this.c.launchByQRScanCode(paramContext, paramMap, paramLaunchWxaAppResultListener);
  }
  
  public long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p1");
    return this.c.launchByUsername(paramContext, paramString1, paramInt, paramString2, paramLaunchByUsernameResultListener);
  }
  
  public long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p1");
    return this.c.launchByUsername(paramContext, paramString1, paramInt, paramString2, paramMap, paramLaunchByUsernameResultListener);
  }
  
  public long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaAppID");
    long l = SystemClock.elapsedRealtime();
    WxaApi localWxaApi = WxMiniSDKImpl.a(WxMiniSDKImpl.a);
    if (localWxaApi == null) {
      Intrinsics.throwNpe();
    }
    return localWxaApi.launchWxaApp(paramContext, paramString1, paramInt, paramString2, (LaunchWxaAppResultListener)new WxMiniSDKImpl.WxaAPI.2.1.launchWxaApp.1(this, paramLaunchWxaAppResultListener, l));
  }
  
  public long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p1");
    return this.c.launchWxaApp(paramContext, paramString1, paramInt, paramString2, paramMap, paramLaunchWxaAppResultListener);
  }
  
  public void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "p0");
    Intrinsics.checkParameterIsNotNull(paramString, "p1");
    this.c.launchWxaByShortLink(paramActivity, paramString, paramBoolean, paramLaunchWxaAppWithShortLinkResultListener);
  }
  
  public void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable Map<String, Object> paramMap, LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "p0");
    Intrinsics.checkParameterIsNotNull(paramString, "p1");
    this.c.launchWxaByShortLink(paramActivity, paramString, paramBoolean, paramMap, paramLaunchWxaAppWithShortLinkResultListener);
  }
  
  public void preloadWxaProcessEnv(int paramInt, @Nullable PreloadWxaProcessEnvResultListener paramPreloadWxaProcessEnvResultListener)
  {
    this.c.preloadWxaProcessEnv(paramInt, paramPreloadWxaProcessEnvResultListener);
  }
  
  public void removeWxaAppCloseEventListener(WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    this.c.removeWxaAppCloseEventListener(paramWxaAppCloseEventListener);
  }
  
  public void requestUploadLogFiles(int paramInt1, int paramInt2, @Nullable UploadLogResultListener paramUploadLogResultListener)
  {
    this.c.requestUploadLogFiles(paramInt1, paramInt2, paramUploadLogResultListener);
  }
  
  public void sendAuth(TdiAuthListener paramTdiAuthListener)
  {
    this.c.sendAuth(paramTdiAuthListener);
  }
  
  public void sendCombineAuth(SendAuth.Req paramReq, IWXAPIEventHandler paramIWXAPIEventHandler, TdiAuthListener paramTdiAuthListener)
  {
    this.c.sendCombineAuth(paramReq, paramIWXAPIEventHandler, paramTdiAuthListener);
  }
  
  public void setWxaProcessMaxCount(int paramInt)
  {
    this.c.setWxaProcessMaxCount(paramInt);
  }
  
  public void updateTuringOAID(String paramString)
  {
    this.c.updateTuringOAID(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl.WxaAPI.2.1
 * JD-Core Version:    0.7.0.1
 */