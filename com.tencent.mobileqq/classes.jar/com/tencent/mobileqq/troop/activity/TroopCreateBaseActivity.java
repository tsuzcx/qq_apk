package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import azhy;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public abstract class TroopCreateBaseActivity
  extends AbsBaseWebViewActivity
{
  protected azhy a;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = b((ViewGroup)null);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setId(2131379397);
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
      this.leftView.setOnClickListener(new azhy(this, 0, null));
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
    if (this.jdField_a_of_type_Azhy != null)
    {
      this.jdField_a_of_type_Azhy.onClick(this.leftView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity
 * JD-Core Version:    0.7.0.1
 */