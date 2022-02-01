package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="WebView")
public class HippyWebViewController
  extends HippyViewController<HippyWebView>
{
  public static final String CLASS_NAME = "WebView";
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyWebView(paramContext);
  }
  
  public void dispatchFunction(HippyWebView paramHippyWebView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyWebView, paramString, paramHippyArray);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!paramString.equals("loadUrl")) {
        break;
      }
      i = 0;
      break;
    } while (paramHippyArray == null);
    loadUrl(paramHippyWebView, paramHippyArray.getString(0));
  }
  
  public boolean handleGestureBySelf()
  {
    return true;
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="url")
  public void loadUrl(HippyWebView paramHippyWebView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramHippyWebView.mWebView.loadUrl(paramString);
    }
  }
  
  public void onViewDestroy(HippyWebView paramHippyWebView)
  {
    paramHippyWebView.mWebView.destroy();
  }
  
  @HippyControllerProps(defaultType="map", name="source")
  public void source(HippyWebView paramHippyWebView, HippyMap paramHippyMap)
  {
    String str1 = null;
    String str2;
    String str3;
    if (paramHippyMap != null)
    {
      str2 = paramHippyMap.getString("userAgent");
      if (!TextUtils.isEmpty(str2)) {
        paramHippyWebView.mWebView.getSettings().setUserAgentString(str2);
      }
      str2 = paramHippyMap.getString("uri");
      if (TextUtils.isEmpty(str2)) {
        break label111;
      }
      if (!"POST".equalsIgnoreCase(paramHippyMap.getString("method"))) {
        break label101;
      }
      str3 = paramHippyMap.getString("body");
      paramHippyMap = paramHippyWebView.mWebView;
      if (str3 != null) {
        break label92;
      }
      paramHippyWebView = str1;
      paramHippyMap.postUrl(str2, paramHippyWebView);
    }
    label92:
    label101:
    label111:
    do
    {
      return;
      paramHippyWebView = str3.getBytes();
      break;
      paramHippyWebView.mWebView.loadUrl(str2);
      return;
      str1 = paramHippyMap.getString("html");
    } while (TextUtils.isEmpty(str1));
    paramHippyMap = paramHippyMap.getString("baseUrl");
    if (!TextUtils.isEmpty(paramHippyMap))
    {
      paramHippyWebView.mWebView.loadDataWithBaseURL(paramHippyMap, str1, "text/html; charset=utf-8", "UTF-8", null);
      return;
    }
    paramHippyWebView.mWebView.loadData(str1, "text/html; charset=utf-8", "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebViewController
 * JD-Core Version:    0.7.0.1
 */