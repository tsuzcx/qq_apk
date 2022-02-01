package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

public class BasePageWebview
  extends WebView
{
  public static volatile int PAGE_WEBVIEW_ID_FACTORY = 0;
  private static final String TAG = BasePageWebview.class.getSimpleName();
  private AppBrandPageContainer mAppBrandPageContainer;
  protected PageEventListener mPageEventListener;
  protected int mPageWebviewId;
  
  public BasePageWebview(Context paramContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(paramContext);
    this.mAppBrandPageContainer = paramAppBrandPageContainer;
    this.mPageWebviewId = generatedWebViewId();
    paramContext = getSettings();
    paramContext.setSupportZoom(false);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setCacheMode(2);
    setWebContentsDebuggingEnabled(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setMixedContentMode(0);
    }
    paramContext.setUserAgent(paramContext.getUserAgentString() + "QQ/MiniApp");
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    try
    {
      if (getSettingsExtension() != null) {
        getSettingsExtension().setFirstScreenDetect(false);
      }
      if (this.mAppBrandPageContainer != null)
      {
        paramContext = this.mAppBrandPageContainer;
        paramContext.aliveWebViewCount += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e(TAG, "BasePageWebview init exception!", paramContext);
      }
    }
  }
  
  public static int generatedWebViewId()
  {
    int i = PAGE_WEBVIEW_ID_FACTORY + 1;
    PAGE_WEBVIEW_ID_FACTORY = i;
    return i;
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mAppBrandPageContainer != null)
    {
      AppBrandPageContainer localAppBrandPageContainer = this.mAppBrandPageContainer;
      localAppBrandPageContainer.aliveWebViewCount -= 1;
    }
  }
  
  public int getPageWebViewId()
  {
    return this.mPageWebviewId;
  }
  
  public void setPageEventListener(PageEventListener paramPageEventListener)
  {
    this.mPageEventListener = paramPageEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BasePageWebview
 * JD-Core Version:    0.7.0.1
 */