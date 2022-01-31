package com.tencent.mobileqq.werewolves;

import aciy;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import baaf;
import bbez;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.smtt.sdk.WebView;

public class HalfScreenBrowserActivity
  extends AbsBaseWebViewActivity
{
  private static final int jdField_a_of_type_Int = Color.argb(63, 0, 0, 0);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(jdField_a_of_type_Int);
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    runOnUiThread(new HalfScreenBrowserActivity.2(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bbez(this));
    paramBundle = getIntent().getStringExtra("url");
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130840058));
    Object localObject = new FrameLayout.LayoutParams(aciy.a(25.0F, getResources()), aciy.a(25.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject);
    int i;
    if (paramBundle.indexOf("https://nearby.qq.com/werewolf/gift.html") >= 0) {
      i = 1;
    }
    for (;;)
    {
      int j;
      if (i != 0)
      {
        j = aciy.a(338.0F, getResources());
        localObject = new RelativeLayout.LayoutParams(-1, j);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = b(localFrameLayout);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setVisibility(4);
        setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        if (i == 0) {}
      }
      try
      {
        findViewById(2131309578).setVisibility(8);
        label226:
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
        baaf.a(this, false, true);
        return true;
        i = 0;
        continue;
        j = -1;
      }
      catch (Throwable localThrowable)
      {
        break label226;
      }
    }
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(0, 0);
    return bool;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity
 * JD-Core Version:    0.7.0.1
 */