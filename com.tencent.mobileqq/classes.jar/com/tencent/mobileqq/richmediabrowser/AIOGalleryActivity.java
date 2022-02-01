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
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new AIOGalleryActivity.2(this);
  private IBrowserManager jdField_a_of_type_ComTencentMobileqqRichmediabrowserApiIBrowserManager;
  private MainBrowserPresenter jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  BroadcastReceiver b = null;
  
  public AIOGalleryActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private List<RichMediaBrowserInfo> a(Parcelable[] paramArrayOfParcelable)
  {
    if ((paramArrayOfParcelable != null) && (paramArrayOfParcelable.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayOfParcelable.length)
      {
        if ((paramArrayOfParcelable[i] instanceof RichMediaBaseData))
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)paramArrayOfParcelable[i]);
          localArrayList.add(localRichMediaBrowserInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a()
  {
    this.b = new AIOGalleryActivity.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        registerReceiver(this.b, localIntentFilter);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(PeakProcessProvider paramPeakProcessProvider)
  {
    b(paramPeakProcessProvider);
    a();
    paramPeakProcessProvider = getAppRuntime();
    if ((paramPeakProcessProvider instanceof PeakAppInterface)) {
      ((MiniCodePeakHandler)((PeakAppInterface)paramPeakProcessProvider).getBusinessHandler(PeakAppInterface.c)).a(this);
    }
  }
  
  private void b(PeakProcessProvider paramPeakProcessProvider)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
        if (localObject != null)
        {
          ((IAIOImageProvider)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
          paramPeakProcessProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
          if ((!ParamsManager.a().e()) && (!ParamsManager.a().a())) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(ParamsManager.a().b());
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
        paramPeakProcessProvider.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
        QLog.d("AIOGalleryActivity", 2, paramPeakProcessProvider.toString());
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  public boolean b()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      return localMainBrowserPresenter.onBackEvent();
    }
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (!localMainBrowserPresenter.onBackEvent())) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
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
    this.i = true;
    this.j = false;
    LiuHaiUtils.a(this);
    LiuHaiUtils.enableNotch(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    com.tencent.mobileqq.activity.aio.photo.AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    Intent localIntent = getIntent();
    Object localObject = localIntent.getExtras();
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("extra.GROUP_UIN");
      localObject = a(((Bundle)localObject).getParcelableArray("extra.EXTRA_CURRENT_IMAGE_LIST"));
    }
    else
    {
      localObject = null;
    }
    try
    {
      PeakProcessProvider localPeakProcessProvider = new PeakProcessProvider();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserApiIBrowserManager = ((IBrowserManager)QRoute.api(IBrowserManager.class)).launchRichMediaBrowser(this, localIntent, localPeakProcessProvider, "KEY_THUMBNAL_BOUND", (List)localObject, 0);
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserApiIBrowserManager.getPresenter();
      a(localPeakProcessProvider);
      if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter != null)
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter.onCreate(paramBundle);
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
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      try
      {
        if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
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
    if ((this.b != null) && (this.jdField_a_of_type_Boolean))
    {
      unregisterReceiver(this.b);
      this.b = null;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
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
      BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
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
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AIOGalleryActivity.ScreenBroadcastReceiver(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if (localObject != null) {
      ((MainBrowserPresenter)localObject).onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
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
    MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      MainBrowserPresenter localMainBrowserPresenter = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterMainBrowserPresenter;
      if (localMainBrowserPresenter != null) {
        localMainBrowserPresenter.onWindowFocusChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */