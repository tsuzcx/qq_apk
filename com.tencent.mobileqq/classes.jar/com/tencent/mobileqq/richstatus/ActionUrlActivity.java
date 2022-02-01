package com.tencent.mobileqq.richstatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ProtectedWebView;
import java.io.File;

public class ActionUrlActivity
  extends IphoneTitleBarActivity
{
  private ProtectedWebView a;
  private View b;
  private ProgressBar c;
  private JsBridge d;
  private StatusJsHandler e;
  private String f = null;
  private RelativeLayout g;
  private View h;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void b()
  {
    this.g = ((RelativeLayout)findViewById(2131449203));
    this.a = new ProtectedWebView(BaseApplicationImpl.sApplication);
    this.g.addView(this.a, 0, new RelativeLayout.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 11) {
      this.a.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.a.setScrollBarStyle(0);
    WebSettings localWebSettings = this.a.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localWebSettings.getUserAgentString());
    localStringBuilder.append(" ");
    localStringBuilder.append("QQ/5.2");
    localWebSettings.setUserAgentString(localStringBuilder.toString());
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    this.a.setWebViewClient(new ActionUrlActivity.UrlActionWebViewClient(this, null));
    this.a.setWebChromeClient(new ActionUrlActivity.UrlActionWebChromeClient(this, null));
    this.d = new JsBridge();
    this.e = new StatusJsHandler(this, this.a, null);
    this.d.a(this.e, "statusJsHandler");
    this.b = ((LinearLayout)findViewById(2131449199));
    this.b.setVisibility(0);
    this.c = ((ProgressBar)findViewById(2131449200));
    this.f = this.leftView.getText().toString();
    this.h = findViewById(2131437976);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.h.setVisibility(0);
    }
  }
  
  void a()
  {
    if (this.a.canGoBack())
    {
      this.leftView.setText(2131917687);
      return;
    }
    this.leftView.setText(this.f);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131629621);
    b();
    this.a.loadUrl(getIntent().getStringExtra("key_params_qq"));
    this.c.setVisibility(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.g != null) {
        this.g.removeAllViews();
      }
    }
    catch (Exception localException2)
    {
      try
      {
        this.a.stopLoading();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.a.clearView();
            try
            {
              label32:
              this.a.destroy();
              return;
            }
            catch (Exception localException4) {}
            localException1 = localException1;
            continue;
            localException2 = localException2;
          }
        }
        catch (Exception localException3)
        {
          break label32;
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.a.canGoBack()) {}
    try
    {
      this.a.stopLoading();
      label17:
      this.a.goBack();
      return true;
      return super.onBackEvent();
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity
 * JD-Core Version:    0.7.0.1
 */