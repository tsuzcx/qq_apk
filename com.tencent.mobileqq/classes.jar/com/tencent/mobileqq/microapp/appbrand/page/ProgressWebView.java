package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;

public class ProgressWebView
  extends TouchWebView
{
  public int htmlId;
  public WebViewDirector mWebViewDirector;
  
  public ProgressWebView(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localWebSettings.getUserAgentString());
    localStringBuilder.append("QQ/MicroApp/H5");
    localWebSettings.setUserAgent(localStringBuilder.toString());
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    try
    {
      requestFocus();
      label122:
      init(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label122;
    }
  }
  
  private void init(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof MutableContextWrapper)) {
        localBaseActivity = (BaseActivity)((MutableContextWrapper)paramContext).getBaseContext();
      }
    }
    catch (Throwable localThrowable)
    {
      BaseActivity localBaseActivity;
      label21:
      break label21;
    }
    localBaseActivity = null;
    if (localBaseActivity != null)
    {
      this.mWebViewDirector = new WebViewDirector(new ProgressWebView.MiniAppWebviewBuilder(paramContext, localBaseActivity, localBaseActivity.getAppInterface(), this));
      this.mWebViewDirector.construct(null, localBaseActivity.app, localBaseActivity.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView
 * JD-Core Version:    0.7.0.1
 */