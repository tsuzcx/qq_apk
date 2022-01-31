package com.tencent.mobileqq.microapp.webview;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

public class BaseAppBrandWebview
  extends WebView
{
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  public static int PAGE_WEBVIEW_ID_FACTORY = 0;
  private static final String TAG = BaseAppBrandWebview.class.getSimpleName();
  public f apkgInfo;
  public int htmlId;
  public int pageWebviewId;
  
  public BaseAppBrandWebview(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BaseAppBrandWebview(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.htmlId = paramInt;
    this.pageWebviewId = generatedWebViewId();
    paramContext = getSettings();
    paramContext.setSupportZoom(false);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setCacheMode(2);
    paramContext.setUserAgent(paramContext.getUserAgentString() + "QQ/MicroApp");
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    if (getSettingsExtension() != null) {
      getSettingsExtension().setFirstScreenDetect(false);
    }
  }
  
  public BaseAppBrandWebview(Context paramContext, f paramf)
  {
    this(paramContext, 0);
    this.apkgInfo = paramf;
  }
  
  public static int generatedWebViewId()
  {
    int i = PAGE_WEBVIEW_ID_FACTORY + 1;
    PAGE_WEBVIEW_ID_FACTORY = i;
    return i;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    evaluateCallbackJs(paramInt, paramString, null);
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString, ValueCallback paramValueCallback)
  {
    paramString = String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString });
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[evaluateCallbackJs] callbackStr=" + paramString);
    }
    evaluteJs(paramString, paramValueCallback);
  }
  
  public void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mobileqq.microapp.appbrand.utils.a.a(new a(this, paramString1, paramString2, paramInt));
  }
  
  public void evaluateSubcribeJSInService(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mobileqq.microapp.appbrand.utils.a.a(new b(this, paramString1, paramString2, paramInt));
  }
  
  public void evaluteJs(String paramString)
  {
    evaluteJs(paramString, null);
  }
  
  public void evaluteJs(String paramString, ValueCallback paramValueCallback)
  {
    com.tencent.mobileqq.microapp.appbrand.utils.a.a(new c(this, paramString, paramValueCallback));
  }
  
  public void initJSGlobalConfig()
  {
    evaluteJs(String.format("var __wxConfig = {};__wxConfig = JSON.parse('%1$s');__wxConfig.platform='android';", new Object[] { this.apkgInfo.a }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview
 * JD-Core Version:    0.7.0.1
 */