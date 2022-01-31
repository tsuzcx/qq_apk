package com.tencent.mobileqq.werewolves;

import akru;
import akrv;
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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.smtt.sdk.WebView;

public class HalfScreenBrowserActivity
  extends AbsBaseWebViewActivity
{
  private static final int jdField_a_of_type_Int = Color.argb(63, 0, 0, 0);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(jdField_a_of_type_Int);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    runOnUiThread(new akrv(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new akru(this));
    paramBundle = getIntent().getStringExtra("url");
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839225));
    Object localObject = new FrameLayout.LayoutParams(AIOUtils.a(25.0F, getResources()), AIOUtils.a(25.0F, getResources()));
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
        j = AIOUtils.a(338.0F, getResources());
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
        findViewById(2131363244).setVisibility(8);
        label226:
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
        AlbumUtil.a(this, false, true);
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
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(0, 0);
    return bool;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity
 * JD-Core Version:    0.7.0.1
 */