package com.tencent.mobileqq.richmediabrowser;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.MiniCodePeakHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.util.BinderWarpper;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.List;

public class AIOGalleryActivity
  extends PeakActivity
{
  IAIOImageProvider a;
  BroadcastReceiver b = null;
  BroadcastReceiver c = null;
  public String d = null;
  IAIOImageProviderCallBack e = new AIOGalleryActivity.2(this);
  private IBrowserManager f;
  private MainBrowserPresenter g;
  private TroopMemberApiClient h;
  private volatile boolean i = false;
  
  private List<RichMediaBrowserInfo> a(Parcelable[] paramArrayOfParcelable)
  {
    if ((paramArrayOfParcelable != null) && (paramArrayOfParcelable.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (j < paramArrayOfParcelable.length)
      {
        if ((paramArrayOfParcelable[j] instanceof RichMediaBaseData))
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)paramArrayOfParcelable[j]);
          localArrayList.add(localRichMediaBrowserInfo);
        }
        j += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(PeakProcessProvider paramPeakProcessProvider)
  {
    b(paramPeakProcessProvider);
    b();
    paramPeakProcessProvider = getAppRuntime();
    if ((paramPeakProcessProvider instanceof PeakAppInterface)) {
      ((MiniCodePeakHandler)((PeakAppInterface)paramPeakProcessProvider).getBusinessHandler(PeakAppInterface.d)).a(this);
    }
  }
  
  private void b()
  {
    this.c = new AIOGalleryActivity.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      if (!this.i)
      {
        this.i = true;
        registerReceiver(this.c, localIntentFilter);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(PeakProcessProvider paramPeakProcessProvider)
  {
    if (this.a == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.a = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        localObject = this.a;
        if (localObject != null)
        {
          ((IAIOImageProvider)localObject).a(this.e);
          paramPeakProcessProvider.a(this.a);
          if ((!ParamsManager.a().l()) && (!ParamsManager.a().b())) {
            this.a.a(ParamsManager.a().m());
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryActivity", 2, "binder is null!");
        }
        finish();
      }
      if (QLog.isColorLevel())
      {
        paramPeakProcessProvider = new StringBuilder();
        paramPeakProcessProvider.append("IAIOImageProvider is ");
        paramPeakProcessProvider.append(this.a);
        QLog.d("AIOGalleryActivity", 2, paramPeakProcessProvider.toString());
      }
    }
  }
  
  public void c()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  public boolean cd_()
  {
    return false;
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
  
  public boolean o()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      return localMainBrowserPresenter.onBackEvent();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if ((localMainBrowserPresenter != null) && (!localMainBrowserPresenter.onBackEvent())) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onConfigurationChanged(paramConfiguration);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate()[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      QLog.d("AIOGalleryActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.y = true;
    this.z = false;
    LiuHaiUtils.f(this);
    LiuHaiUtils.enableNotch(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.h = TroopMemberApiClient.a();
    this.h.e();
    com.tencent.mobileqq.activity.aio.photo.AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    Intent localIntent = getIntent();
    Object localObject = localIntent.getExtras();
    if (localObject != null)
    {
      this.d = ((Bundle)localObject).getString("extra.GROUP_UIN");
      localObject = a(((Bundle)localObject).getParcelableArray("extra.EXTRA_CURRENT_IMAGE_LIST"));
    }
    else
    {
      localObject = null;
    }
    try
    {
      PeakProcessProvider localPeakProcessProvider = new PeakProcessProvider();
      this.f = ((IBrowserManager)QRoute.api(IBrowserManager.class)).launchRichMediaBrowser(this, localIntent, localPeakProcessProvider, "KEY_THUMBNAL_BOUND", (List)localObject, 0);
      this.g = this.f.getPresenter();
      a(localPeakProcessProvider);
      if (this.g != null)
      {
        this.g.onCreate(paramBundle);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCreate exception = ");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.d("AIOGalleryActivity", 2, ((StringBuilder)localObject).toString());
      }
      finish();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy()[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      QLog.d("AIOGalleryActivity", 2, ((StringBuilder)localObject).toString());
    }
    super.onDestroy();
    Object localObject = this.g;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onDestroy();
    }
    if (this.a != null) {
      try
      {
        if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
        {
          this.a.c();
          this.a.a();
          this.e = null;
        }
        else
        {
          this.a.c();
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDestroy() exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("AIOGalleryActivity", 2, localStringBuilder.toString());
        }
      }
    }
    if ((this.c != null) && (this.i))
    {
      unregisterReceiver(this.c);
      this.c = null;
    }
    this.h.f();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if ((localMainBrowserPresenter != null) && (!localMainBrowserPresenter.onKeyDown(paramInt, paramKeyEvent))) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      BroadcastReceiver localBroadcastReceiver = this.b;
      if (localBroadcastReceiver != null) {
        try
        {
          unregisterReceiver(localBroadcastReceiver);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPause exception = ");
            localStringBuilder.append(localException.getMessage());
            QLog.d("AIOGalleryActivity", 2, localStringBuilder.toString());
          }
        }
      }
    }
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.b = new AIOGalleryActivity.ScreenBroadcastReceiver(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.b, (IntentFilter)localObject);
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onStart();
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onStop()");
    }
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    MainBrowserPresenter localMainBrowserPresenter = this.g;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      MainBrowserPresenter localMainBrowserPresenter = this.g;
      if (localMainBrowserPresenter != null) {
        localMainBrowserPresenter.onWindowFocusChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */