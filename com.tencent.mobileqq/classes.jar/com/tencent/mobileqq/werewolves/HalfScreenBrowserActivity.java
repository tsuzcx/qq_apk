package com.tencent.mobileqq.werewolves;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public class HalfScreenBrowserActivity
  extends AbsBaseWebViewActivity
{
  private static final int a = Color.argb(63, 0, 0, 0);
  private RelativeLayout b;
  private ProgressBar c;
  private CustomWebView d;
  
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
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    this.b = new RelativeLayout(this);
    this.b.setOnClickListener(new HalfScreenBrowserActivity.1(this));
    paramBundle = getIntent().getStringExtra("url");
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.c = new ProgressBar(this);
    this.c.setIndeterminateDrawable(getResources().getDrawable(2130841248));
    Object localObject = new FrameLayout.LayoutParams(AIOUtils.b(25.0F, getResources()), AIOUtils.b(25.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localFrameLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
    int i;
    if (paramBundle.indexOf("https://nearby.qq.com/werewolf/gift.html") >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = AIOUtils.b(338.0F, getResources());
    } else {
      j = -1;
    }
    localObject = new RelativeLayout.LayoutParams(-1, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.b.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
    this.d = getWebView(localFrameLayout);
    this.d.setVisibility(4);
    setContentView(this.b);
    if (i != 0) {}
    try
    {
      findViewById(2131444897).setVisibility(8);
      label236:
      this.d.loadUrl(paramBundle);
      AlbumUtil.anim(this, false, true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label236;
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.d.setVisibility(0);
    this.c.setVisibility(8);
    runOnUiThread(new HalfScreenBrowserActivity.2(this));
  }
  
  protected void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.b.setBackgroundColor(a);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity
 * JD-Core Version:    0.7.0.1
 */