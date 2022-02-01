package com.tencent.mobileqq.wxmini.impl;

import android.content.Context;
import android.util.Log;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.WxaApi.Factory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/WxMiniSDKImpl;", "", "()V", "DYNAMIC_PKG_PATH", "", "DYNAMIC_PKG_TYPE", "", "WX_APPID_DEBUG", "WX_APPID_RELEASE", "WxaAPI", "Lcom/tencent/luggage/wxaapi/WxaApi;", "getWxaAPI", "()Lcom/tencent/luggage/wxaapi/WxaApi;", "WxaAPI$delegate", "Lkotlin/Lazy;", "_wxaApi", "isInit", "", "attachBaseContext", "", "context", "Landroid/content/Context;", "getHostAppId", "init", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class WxMiniSDKImpl
{
  public static final WxMiniSDKImpl a;
  private static volatile boolean b;
  private static WxaApi c;
  @NotNull
  private static final Lazy d;
  
  static
  {
    WxMiniSDKImpl localWxMiniSDKImpl = new WxMiniSDKImpl();
    a = localWxMiniSDKImpl;
    d = LazyKt.lazy((Function0)new WxMiniSDKImpl.WxaAPI.2(localWxMiniSDKImpl));
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    String str = ProcessUtils.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("attachBaseContext proName=");
    localStringBuilder.append(str);
    Log.d("DemoApi.WxaAPI", localStringBuilder.toString());
    c = WxaApi.Factory.createApi(paramContext, b(), 1);
    b = true;
  }
  
  public final boolean a()
  {
    return b;
  }
  
  @NotNull
  public final String b()
  {
    return "wxf0a80d0ac2e82aa7";
  }
  
  @NotNull
  public final WxaApi c()
  {
    return (WxaApi)d.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl
 * JD-Core Version:    0.7.0.1
 */