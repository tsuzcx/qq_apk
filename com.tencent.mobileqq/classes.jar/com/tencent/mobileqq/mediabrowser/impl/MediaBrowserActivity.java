package com.tencent.mobileqq.mediabrowser.impl;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProvider;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.util.LiuHaiUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MediaBrowserActivity
  extends QBaseActivity
{
  MainBrowserPresenter a;
  IMediaBrowserService.BrowserInfo b;
  BroadcastReceiver c = null;
  BroadcastReceiver d = null;
  private IBrowserManager e;
  private final IMediaBrowserProviderCallBack f = new MediaBrowserActivity.2(this);
  
  private void a()
  {
    this.d = new MediaBrowserActivity.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.d, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = getIntent();
    int i = ((Intent)localObject1).getIntExtra("browseId", 0);
    if (i == 0) {
      finish();
    }
    this.b = ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).getBrowserInfo(i);
    Object localObject2 = this.b;
    if (localObject2 == null)
    {
      finish();
      return;
    }
    localObject2 = ((IMediaBrowserService.BrowserInfo)localObject2).b();
    if ((localObject2 != null) && (((List)localObject2).size() != 0))
    {
      IMediaBrowserProvider localIMediaBrowserProvider = this.b.a();
      if (localIMediaBrowserProvider == null)
      {
        finish();
        return;
      }
      localIMediaBrowserProvider.a(this.f);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      ((Intent)localObject1).putExtra("extra.OCR", ((IOCRService)localAppRuntime.getRuntimeService(IOCRService.class, "")).isSupportOcr(localAppRuntime.getAccount(), 1));
      ((Intent)localObject1).putExtra("KEY_THUMBNAL_BOUND", this.b.d());
      ((Intent)localObject1).putExtra("extra.EXTRA_ENTRANCE", 6);
      ((Intent)localObject1).putExtra("extra.EXTRA_CURRENT_IMAGE", ((RichMediaBrowserInfo)((List)localObject2).get(this.b.c())).baseData);
      this.e = ((IBrowserManager)QRoute.api(IBrowserManager.class)).launchRichMediaBrowser(this, (Intent)localObject1, localIMediaBrowserProvider, "KEY_THUMBNAL_BOUND", (List)localObject2, this.b.c());
      this.a = this.e.getPresenter();
      a();
      localObject1 = this.a;
      if (localObject1 != null) {
        ((MainBrowserPresenter)localObject1).onCreate(paramBundle);
      }
      return;
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if ((localMainBrowserPresenter != null) && (!localMainBrowserPresenter.onBackEvent())) {
      super.doOnBackPressed();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.f(this);
    LiuHaiUtils.enableNotch(this);
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    a(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy()[");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("]");
    ((IBrowserLog)localObject).d("MediaBrowserActivity", 4, localStringBuilder.toString());
    super.doOnDestroy();
    localObject = this.a;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onDestroy();
    }
    localObject = this.d;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.d = null;
    }
    localObject = this.b.a();
    if (localObject != null) {
      ((IMediaBrowserProvider)localObject).b();
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if ((localMainBrowserPresenter != null) && (!localMainBrowserPresenter.onKeyDown(paramInt, paramKeyEvent))) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void doOnPause()
  {
    SmallScreenUtils.a(BaseApplication.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.doOnPause();
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      BroadcastReceiver localBroadcastReceiver = this.c;
      if (localBroadcastReceiver != null) {
        try
        {
          unregisterReceiver(localBroadcastReceiver);
        }
        catch (Exception localException)
        {
          IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPause exception = ");
          localStringBuilder.append(localException.getMessage());
          localIBrowserLog.d("MediaBrowserActivity", 4, localStringBuilder.toString());
        }
      }
    }
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SmallScreenUtils.a(BaseApplication.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.c = new MediaBrowserActivity.ScreenBroadcastReceiver(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.c, (IntentFilter)localObject);
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onStart();
    }
  }
  
  public void doOnStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("MediaBrowserActivity", 4, "onStop()");
    super.doOnStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onStop();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      MainBrowserPresenter localMainBrowserPresenter = this.a;
      if (localMainBrowserPresenter != null) {
        localMainBrowserPresenter.onWindowFocusChanged();
      }
    }
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
  
  public boolean onBackEvent()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.a;
    if (localMainBrowserPresenter != null) {
      return localMainBrowserPresenter.onBackEvent();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity
 * JD-Core Version:    0.7.0.1
 */