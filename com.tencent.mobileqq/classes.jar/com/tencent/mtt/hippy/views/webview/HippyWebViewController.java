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
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyWebView(paramContext);
  }
  
  public void dispatchFunction(HippyWebView paramHippyWebView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyWebView, paramString, paramHippyArray);
    int i;
    if ((paramString.hashCode() == 336631465) && (paramString.equals("loadUrl"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      return;
    }
    if (paramHippyArray != null) {
      loadUrl(paramHippyWebView, paramHippyArray.getString(0));
    }
  }
  
  protected boolean handleGestureBySelf()
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
    if (paramHippyMap != null)
    {
      String str1 = paramHippyMap.getString("userAgent");
      if (!TextUtils.isEmpty(str1)) {
        paramHippyWebView.mWebView.getSettings().setUserAgentString(str1);
      }
      str1 = paramHippyMap.getString("uri");
      if (!TextUtils.isEmpty(str1))
      {
        if ("POST".equalsIgnoreCase(paramHippyMap.getString("method")))
        {
          String str2 = paramHippyMap.getString("body");
          paramHippyMap = paramHippyWebView.mWebView;
          if (str2 == null) {
            paramHippyWebView = null;
          } else {
            paramHippyWebView = str2.getBytes();
          }
          paramHippyMap.postUrl(str1, paramHippyWebView);
          return;
        }
        paramHippyWebView.mWebView.loadUrl(str1);
        return;
      }
      str1 = paramHippyMap.getString("html");
      if (!TextUtils.isEmpty(str1))
      {
        paramHippyMap = paramHippyMap.getString("baseUrl");
        if (!TextUtils.isEmpty(paramHippyMap))
        {
          paramHippyWebView.mWebView.loadDataWithBaseURL(paramHippyMap, str1, "text/html; charset=utf-8", "UTF-8", null);
          return;
        }
        paramHippyWebView.mWebView.loadData(str1, "text/html; charset=utf-8", "UTF-8");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebViewController
 * JD-Core Version:    0.7.0.1
 */