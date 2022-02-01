package com.tencent.mobileqq.richmediabrowser;

import Override;
import aasb;
import aidz;
import aiea;
import aiec;
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
import aquy;
import bboo;
import bboq;
import bbor;
import bbos;
import bbot;
import bbou;
import bbox;
import bbpa;
import bbpb;
import bbpq;
import bjfr;
import bplg;
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
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import lzq;

public class AIOGalleryActivity
  extends PeakActivity
{
  private aasb jdField_a_of_type_Aasb;
  aidz jdField_a_of_type_Aidz;
  aiec jdField_a_of_type_Aiec = new bbot(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private bboq jdField_a_of_type_Bboq;
  private bbpq jdField_a_of_type_Bbpq;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean;
  BroadcastReceiver b = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Aidz == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_Aidz = aiea.a(((BinderWarpper)localObject).a);
      this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aiec);
      if (this.jdField_a_of_type_Bbpq != null)
      {
        this.jdField_a_of_type_Bbpq.a(this.jdField_a_of_type_Aidz);
        localObject = new bbpa();
        ((bbpa)localObject).a(this.jdField_a_of_type_Aidz);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if ((this.jdField_a_of_type_Aidz != null) && (!bbox.a().e())) {
          this.jdField_a_of_type_Aidz.a(bbox.a().b());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Aidz);
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
    this.b = new bbos(this);
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Bboq.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Bboq.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Bboq.a(paramConfiguration);
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
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
    aibb.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bplg.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new bbpb());
      RichMediaBrowserManager.getInstance().setMvpFactory(new bbor());
      Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
      bbox.a().a(localRect);
      bboo localbboo = new bboo();
      localbboo.a = localRect;
      RichMediaBrowserManager.getInstance().setAnimationListener(localbboo);
      bbox.a().a(paramBundle);
      this.jdField_a_of_type_Bboq = new bboq(this);
      new BrowserDirector().construct(this.jdField_a_of_type_Bboq, paramBundle);
      this.jdField_a_of_type_Bbpq = this.jdField_a_of_type_Bboq.a();
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
    if (this.jdField_a_of_type_Bboq != null) {
      this.jdField_a_of_type_Bboq.e();
    }
    if (this.jdField_a_of_type_Aidz != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_Aidz.c();
        this.jdField_a_of_type_Aidz.a();
        this.jdField_a_of_type_Aiec = null;
      }
      for (;;)
      {
        if ((this.b != null) && (this.jdField_a_of_type_Boolean))
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Aasb.b();
        return;
        this.jdField_a_of_type_Aidz.c();
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
    if (!this.jdField_a_of_type_Bboq.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lzq.a(BaseApplicationImpl.getContext(), false);
    bjfr.a(BaseApplicationImpl.getContext(), true, 52);
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Bboq.d();
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
    lzq.a(BaseApplicationImpl.getContext(), true);
    bjfr.a(BaseApplicationImpl.getContext(), false, 52);
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bbou(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Bboq.c();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Bboq.b();
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
      this.jdField_a_of_type_Bboq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */