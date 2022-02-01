package com.tencent.mobileqq.weather.webpage;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/webpage/WeatherWebViewFragment$getWebViewKernelCallBack$1", "Lcom/tencent/mobileqq/webview/swift/proxy/WebKernelCallBackProxy;", "interceptStartLoadUrl", "", "loadUrlFinish", "", "onFinalState", "extraData", "Landroid/os/Bundle;", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebViewFragment$getWebViewKernelCallBack$1
  extends WebKernelCallBackProxy
{
  WeatherWebViewFragment$getWebViewKernelCallBack$1(WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(localWebViewKernelCallBack);
  }
  
  public boolean interceptStartLoadUrl()
  {
    if (!WeatherWebViewFragment.j(this.a))
    {
      WeatherWebViewFragment localWeatherWebViewFragment = this.a;
      WeatherWebViewFragment.a(localWeatherWebViewFragment, URLUtil.a(WeatherWebViewFragment.k(localWeatherWebViewFragment), "start_click_time", String.valueOf(WeatherWebViewFragment.l(this.a))));
    }
    return super.interceptStartLoadUrl();
  }
  
  public void loadUrlFinish()
  {
    if (!WeatherWebViewFragment.j(this.a))
    {
      WeatherWebViewFragment localWeatherWebViewFragment = this.a;
      WeatherWebViewFragment.a(localWeatherWebViewFragment, URLUtil.a(WeatherWebViewFragment.k(localWeatherWebViewFragment), "start_click_time"));
    }
    WeatherWebViewFragment.c(this.a, true);
  }
  
  public void onFinalState(@Nullable Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    QLog.i("WeatherWebViewFragment", 1, "doCreateLoopStep_Final");
    WeatherWebViewFragment.h(this.a);
    WeatherWebViewFragment.i(this.a);
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    WeatherWebViewFragment.a(this.a, true);
    paramWebView = WeatherWebViewFragment.e(this.a);
    if (paramWebView != null) {
      WeatherWebViewFragment.a(this.a, paramWebView);
    }
    long l = System.currentTimeMillis() - WeatherWebViewFragment.d(this.a);
    WeatherDCReportHelper.a().a(null, "new_webview_loading_times", Long.valueOf(l));
    paramWebView = new StringBuilder();
    paramWebView.append("time = ");
    paramWebView.append(l);
    WeatherPreloadHelper.a(6, paramWebView.toString());
    if (!WeatherWebViewFragment.f(this.a))
    {
      WeatherWebViewFragment.b(this.a, true);
      WeatherWebViewFragment.g(this.a);
    }
  }
  
  public void onPageStarted(@Nullable WebView paramWebView, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    WeatherPreloadHelper.a(5, "");
    WeatherWebViewFragment.a(this.a, false);
    WeatherWebViewFragment.a(this.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewFragment.getWebViewKernelCallBack.1
 * JD-Core Version:    0.7.0.1
 */