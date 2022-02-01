package com.tencent.mobileqq.richmediabrowser;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.raft.raftframework.RAApplicationContext;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.util.BinderWarpper;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.capture.CaptureContext;

public class AIOGalleryActivity
  extends PeakActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new AIOGalleryActivity.3(this);
  private AIOBrowserBuilder jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder;
  private AIOBrowserPresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  BroadcastReceiver b = null;
  
  public AIOGalleryActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
        localObject = new PeakProcessProvider();
        ((PeakProcessProvider)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if (!ParamsManager.a().e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(ParamsManager.a().b());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
      return;
      label157:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "binder is null!");
      finish();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    a();
    b();
  }
  
  private void b()
  {
    this.b = new AIOGalleryActivity.2(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        registerReceiver(this.b, localIntentFilter);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.a(this);
    LiuHaiUtils.enableNotch(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    com.tencent.mobileqq.activity.aio.photo.AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(CaptureContext.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new QQBrowserLog());
      RichMediaBrowserManager.getInstance().setMvpFactory(new AIOBrowserMvpFactory());
      Object localObject = new AIOBrowserAnimation();
      if (localBundle != null)
      {
        Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
        ParamsManager.a().a(localRect);
        ((AIOBrowserAnimation)localObject).a = localRect;
      }
      RichMediaBrowserManager.getInstance().setAnimationListener((IBrowserAnimationListener)localObject);
      ParamsManager.a().a(paramBundle);
      localObject = RAApplicationContext.getGlobalContext();
      if (!((RAApplicationContext)localObject).hasStartUp()) {
        ((RAApplicationContext)localObject).startup(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder = ((AIOBrowserBuilder)((RAApplicationContext)localObject).getService(IBrowserBuilder.class, new AIOGalleryActivity.1(this)));
      new BrowserDirector().construct(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a();
      a(localBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onCreate exception = " + paramBundle.getMessage());
      finish();
    }
  }
  
  public void onDestroy()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onDestroy()");
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
      }
      for (;;)
      {
        if ((this.b != null) && (this.jdField_a_of_type_Boolean))
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onDestroy() exception = " + localException.getMessage());
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 52);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.d();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onPause exception = " + localException.getMessage());
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 52);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AIOGalleryActivity.ScreenBroadcastReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.c();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.b();
  }
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onStop()");
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBuilder.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */