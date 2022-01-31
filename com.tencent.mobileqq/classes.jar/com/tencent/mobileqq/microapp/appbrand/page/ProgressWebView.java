package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import bcbu;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;

public class ProgressWebView
  extends TouchWebView
{
  public int htmlId;
  public bcbu mWebViewDirector;
  
  public ProgressWebView(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setUserAgent(localWebSettings.getUserAgentString() + "QQ/MicroApp/H5");
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
      label116:
      init(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  private void init(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof MutableContextWrapper))
      {
        BaseActivity localBaseActivity = (BaseActivity)((MutableContextWrapper)paramContext).getBaseContext();
        if (localBaseActivity != null)
        {
          this.mWebViewDirector = new bcbu(new ProgressWebView.MiniAppWebviewBuilder(paramContext, localBaseActivity, localBaseActivity.getAppInterface(), this));
          this.mWebViewDirector.a(null, localBaseActivity.app, localBaseActivity.getIntent());
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView
 * JD-Core Version:    0.7.0.1
 */