package com.tencent.mobileqq.troop.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public abstract class TroopCreateBaseActivity
  extends AbsBaseWebViewActivity
{
  protected Dialog a;
  CustomWebView a;
  protected TroopCreateBaseActivity.TopBarBtnClickListener a;
  
  void a()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  protected void a(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  protected void a(String paramString)
  {
    a();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new TroopCreateBaseActivity.1(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
        return;
      }
      String str = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        str = paramString2.replace("\"", "\\\"");
      }
      paramString2 = new StringBuilder();
      paramString2.append("javascript:");
      paramString2.append(paramString1);
      paramString2.append("(\"");
      paramString2.append(str);
      paramString2.append("\")");
      paramString1 = paramString2.toString();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString1);
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  protected void c() {}
  
  protected void d() {}
  
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
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = getWebView((ViewGroup)null);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setId(2131381075);
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
      this.mRulesFromUrl = Long.parseLong((String)localObject, 10);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label90:
      break label90;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopCreateBaseActivity", 4, "_wv param not found");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
    this.leftView.setOnClickListener(new TroopCreateBaseActivity.TopBarBtnClickListener(this, 0, null));
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    TroopCreateBaseActivity.TopBarBtnClickListener localTopBarBtnClickListener = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$TopBarBtnClickListener;
    if (localTopBarBtnClickListener != null)
    {
      localTopBarBtnClickListener.onClick(this.leftView);
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
  
  protected void onReceivedTitle(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity
 * JD-Core Version:    0.7.0.1
 */