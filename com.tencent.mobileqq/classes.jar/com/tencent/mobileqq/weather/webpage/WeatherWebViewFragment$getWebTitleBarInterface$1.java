package com.tencent.mobileqq.weather.webpage;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/webpage/WeatherWebViewFragment$getWebTitleBarInterface$1", "Lcom/tencent/mobileqq/webview/swift/proxy/WebTitleBarProxy;", "setRightButton", "", "isHidden", "", "callback", "", "text", "color", "iconID", "", "cornerID", "onClickListener", "Landroid/view/View$OnClickListener;", "apiCallback", "Lcom/tencent/mobileqq/Doraemon/APICallback;", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebViewFragment$getWebTitleBarInterface$1
  extends WebTitleBarProxy
{
  WeatherWebViewFragment$getWebTitleBarInterface$1(WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    super(localWebTitleBarInterface);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable APICallback paramAPICallback)
  {
    super.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramAPICallback);
    this.a.a();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewFragment.getWebTitleBarInterface.1
 * JD-Core Version:    0.7.0.1
 */