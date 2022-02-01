package com.tencent.mobileqq.picbrowser;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class PicBrowserActivity
  extends BaseActivity
{
  public GalleryManager mGalleryManager = new PicBrowserActivity.1(this);
  protected ImmersiveTitleBar2 mImmersiveTitleBar;
  protected int mIndex;
  public boolean mNeedReportVisitedPic;
  protected ArrayList<PicInfo> mPicInfos;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if (!this.mGalleryManager.i()) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    setContentView(2131627572);
    initViews();
    initData();
    this.mGalleryManager.b(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mGalleryManager.d(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.mGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void doOnPause()
  {
    AbstractVideoImage.pauseAll();
    this.mGalleryManager.j();
  }
  
  protected void doOnResume()
  {
    AbstractVideoImage.resumeAll();
    this.mGalleryManager.k();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.mGalleryManager.c(this);
    }
  }
  
  public void hideImmersTitleBar()
  {
    this.mImmersiveTitleBar.setVisibility(8);
  }
  
  protected void initData()
  {
    this.mIndex = getIntent().getIntExtra("intent_param_index", 0);
    this.mPicInfos = getIntent().getParcelableArrayListExtra("intent_param_pic_infos");
    this.mNeedReportVisitedPic = getIntent().getBooleanExtra("report_visited_pic", false);
  }
  
  protected void initViews()
  {
    this.mImmersiveTitleBar = ((ImmersiveTitleBar2)findViewById(2131447582));
    this.mImmersiveTitleBar.setVisibility(0);
    ImmersiveUtils.setStatusBarDarkMode(getWindow(), ThemeUtil.isNowThemeIsDefault(this.app, false, null));
    this.mImmersiveTitleBar.setBackgroundColor(getResources().getColor(2131165564));
  }
  
  protected boolean isWrapContent()
  {
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
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */