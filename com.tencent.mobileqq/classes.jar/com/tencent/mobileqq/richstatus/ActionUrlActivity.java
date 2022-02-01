package com.tencent.mobileqq.richstatus;

import Override;
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
import awfu;
import bbsg;
import bbsh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ProtectedWebView;
import java.io.File;

public class ActionUrlActivity
  extends IphoneTitleBarActivity
{
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private awfu jdField_a_of_type_Awfu;
  private StatusJsHandler jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler;
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  private String jdField_a_of_type_JavaLangString;
  private View b;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380515));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView = new ProtectedWebView(BaseApplicationImpl.sApplication);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetProtectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setScrollBarStyle(0);
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentWidgetProtectedWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + "QQ/5.2");
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebViewClient(new bbsh(this, null));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebChromeClient(new bbsg(this, null));
    this.jdField_a_of_type_Awfu = new awfu();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler = new StatusJsHandler(this, this.jdField_a_of_type_ComTencentWidgetProtectedWebView, null);
    this.jdField_a_of_type_Awfu.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler, "statusJsHandler");
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131380511));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131380512));
    this.jdField_a_of_type_JavaLangString = this.leftView.getText().toString();
    this.b = findViewById(2131370633);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.b.setVisibility(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      this.leftView.setText(2131719040);
      return;
    }
    this.leftView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563078);
    b();
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.loadUrl(getIntent().getStringExtra("key_params_qq"));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      }
      try
      {
        label18:
        this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
        try
        {
          label25:
          this.jdField_a_of_type_ComTencentWidgetProtectedWebView.clearView();
          try
          {
            label32:
            this.jdField_a_of_type_ComTencentWidgetProtectedWebView.destroy();
            return;
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          break label32;
        }
      }
      catch (Exception localException3)
      {
        break label25;
      }
    }
    catch (Exception localException4)
    {
      break label18;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack()) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      label17:
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.goBack();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity
 * JD-Core Version:    0.7.0.1
 */