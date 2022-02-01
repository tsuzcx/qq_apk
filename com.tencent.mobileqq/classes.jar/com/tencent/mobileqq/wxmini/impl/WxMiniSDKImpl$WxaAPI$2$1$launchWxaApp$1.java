package com.tencent.mobileqq.wxmini.impl;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "wxaAppID", "", "versionType", "", "timestamp", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class WxMiniSDKImpl$WxaAPI$2$1$launchWxaApp$1
  implements LaunchWxaAppResultListener
{
  WxMiniSDKImpl$WxaAPI$2$1$launchWxaApp$1(WxMiniSDKImpl.WxaAPI.2.1 param1, LaunchWxaAppResultListener paramLaunchWxaAppResultListener, long paramLong) {}
  
  public final void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((LaunchWxaAppResultListener)localObject).onLaunchResult(paramString, paramInt, paramLong, paramLaunchWxaAppResult);
    }
    localObject = WxMiniSDKImpl.WxaAPI.2.1.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchWxaApp, onLaunchResult(wxaAppID:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append("versionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", timestamp:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", result:");
    localStringBuilder.append(paramLaunchWxaAppResult);
    localStringBuilder.append("), ");
    localStringBuilder.append("cost:");
    localStringBuilder.append(SystemClock.elapsedRealtime() - this.c);
    localStringBuilder.append("ms");
    Log.i((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl.WxaAPI.2.1.launchWxaApp.1
 * JD-Core Version:    0.7.0.1
 */