package com.tencent.mobileqq.troop.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import bfke;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public abstract class TroopCreateBaseActivity
  extends AbsBaseWebViewActivity
{
  protected bfke a;
  public CustomWebView a;
  
  public void a(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  public void c() {}
  
  public void d() {}
  
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
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = b((ViewGroup)null);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setId(2131381325);
    setContentView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    paramBundle = getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    Object localObject = Uri.parse(paramBundle);
    if (((Uri)localObject).isHierarchical())
    {
      localObject = ((Uri)localObject).getQueryParameter("_wv");
      if (localObject == null) {}
    }
    try
    {
      this.b = Long.parseLong((String)localObject, 10);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
      this.leftView.setOnClickListener(new bfke(this, 0, null));
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopCreateBaseActivity", 4, "_wv param not found");
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Bfke != null)
    {
      this.jdField_a_of_type_Bfke.onClick(this.leftView);
      return true;
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity
 * JD-Core Version:    0.7.0.1
 */