package com.tencent.mobileqq.richmediabrowser;

import Override;
import aady;
import ahtp;
import ahtq;
import ahts;
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
import aqrl;
import bboy;
import bbpa;
import bbpb;
import bbpc;
import bbpd;
import bbpe;
import bbph;
import bbpk;
import bbpl;
import bbqa;
import biwn;
import bofz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import lzr;

public class AIOGalleryActivity
  extends PeakActivity
{
  private aady jdField_a_of_type_Aady;
  ahtp jdField_a_of_type_Ahtp;
  ahts jdField_a_of_type_Ahts = new bbpd(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private bbpa jdField_a_of_type_Bbpa;
  private bbqa jdField_a_of_type_Bbqa;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean;
  BroadcastReceiver b = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Ahtp == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_Ahtp = ahtq.a(((BinderWarpper)localObject).a);
      if ((this.jdField_a_of_type_Ahtp != null) && (this.jdField_a_of_type_Bbqa != null))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Ahts);
        this.jdField_a_of_type_Bbqa.a(this.jdField_a_of_type_Ahtp);
        localObject = new bbpk();
        ((bbpk)localObject).a(this.jdField_a_of_type_Ahtp);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if (!bbph.a().e()) {
          this.jdField_a_of_type_Ahtp.a(bbph.a().b());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Ahtp);
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
    this.b = new bbpc(this);
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
    ImmersiveUtils.a(getWindow(), -16777216);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Bbpa.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Bbpa.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Bbpa.a(paramConfiguration);
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
    this.jdField_a_of_type_Aady = aady.a();
    this.jdField_a_of_type_Aady.a();
    ahqs.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(bofz.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new bbpl());
      RichMediaBrowserManager.getInstance().setMvpFactory(new bbpb());
      bboy localbboy = new bboy();
      if (localBundle != null)
      {
        Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
        bbph.a().a(localRect);
        localbboy.a = localRect;
      }
      RichMediaBrowserManager.getInstance().setAnimationListener(localbboy);
      bbph.a().a(paramBundle);
      this.jdField_a_of_type_Bbpa = new bbpa(this);
      new BrowserDirector().construct(this.jdField_a_of_type_Bbpa, paramBundle);
      this.jdField_a_of_type_Bbqa = this.jdField_a_of_type_Bbpa.a();
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
    if (this.jdField_a_of_type_Bbpa != null) {
      this.jdField_a_of_type_Bbpa.e();
    }
    if (this.jdField_a_of_type_Ahtp != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_Ahtp.c();
        this.jdField_a_of_type_Ahtp.a();
        this.jdField_a_of_type_Ahts = null;
      }
      for (;;)
      {
        if ((this.b != null) && (this.jdField_a_of_type_Boolean))
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Aady.b();
        return;
        this.jdField_a_of_type_Ahtp.c();
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
    if (!this.jdField_a_of_type_Bbpa.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lzr.a(BaseApplicationImpl.getContext(), false);
    biwn.a(BaseApplicationImpl.getContext(), true, 52);
    aqrl.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Bbpa.d();
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
    lzr.a(BaseApplicationImpl.getContext(), true);
    biwn.a(BaseApplicationImpl.getContext(), false, 52);
    aqrl.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bbpe(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Bbpa.c();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Bbpa.b();
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
      this.jdField_a_of_type_Bbpa.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */