package com.tencent.mobileqq.richmediabrowser;

import agft;
import agfu;
import agfw;
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
import android.view.Window;
import aobd;
import axtl;
import axtn;
import axto;
import axtp;
import axtq;
import axtr;
import axtu;
import axtx;
import axty;
import axuh;
import betl;
import bllv;
import bngs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.util.BinderWarpper;
import mbt;
import ymk;

public class AIOGalleryActivity
  extends PeakActivity
{
  agft jdField_a_of_type_Agft;
  agfw jdField_a_of_type_Agfw = new axtq(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private axtn jdField_a_of_type_Axtn;
  private axuh jdField_a_of_type_Axuh;
  public String a;
  private ymk jdField_a_of_type_Ymk;
  private volatile boolean jdField_a_of_type_Boolean;
  BroadcastReceiver b = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Agft == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_Agft = agfu.a(((BinderWarpper)localObject).a);
      this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Agfw);
      if (this.jdField_a_of_type_Axuh != null)
      {
        this.jdField_a_of_type_Axuh.a(this.jdField_a_of_type_Agft);
        localObject = new axtx();
        ((axtx)localObject).a(this.jdField_a_of_type_Agft);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if ((this.jdField_a_of_type_Agft != null) && (!axtu.a().e())) {
          this.jdField_a_of_type_Agft.a(axtu.a().b());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Agft);
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
    this.b = new axtp(this);
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
    this.jdField_a_of_type_Axtn.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Axtn.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Axtn.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    bngs.a(this);
    bngs.c(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Ymk = ymk.a();
    this.jdField_a_of_type_Ymk.a();
    agcs.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bllv.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new axty());
      RichMediaBrowserManager.getInstance().setMvpFactory(new axto());
      Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
      axtu.a().a(localRect);
      axtl localaxtl = new axtl();
      localaxtl.a = localRect;
      RichMediaBrowserManager.getInstance().setAnimationListener(localaxtl);
      axtu.a().a(paramBundle);
      this.jdField_a_of_type_Axtn = new axtn(this);
      new BrowserDirector(this.jdField_a_of_type_Axtn).construct(paramBundle);
      this.jdField_a_of_type_Axuh = this.jdField_a_of_type_Axtn.a();
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
    if (this.jdField_a_of_type_Axtn != null) {
      this.jdField_a_of_type_Axtn.e();
    }
    if (this.jdField_a_of_type_Agft != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_Agft.c();
        this.jdField_a_of_type_Agft.a();
        this.jdField_a_of_type_Agfw = null;
      }
      for (;;)
      {
        if ((this.b != null) && (this.jdField_a_of_type_Boolean))
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Ymk.b();
        return;
        this.jdField_a_of_type_Agft.c();
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
    if (!this.jdField_a_of_type_Axtn.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    mbt.a(BaseApplicationImpl.getContext(), false);
    betl.a(BaseApplicationImpl.getContext(), true, 52);
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Axtn.d();
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
    mbt.a(BaseApplicationImpl.getContext(), true);
    betl.a(BaseApplicationImpl.getContext(), false, 52);
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new axtr(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Axtn.c();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Axtn.b();
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
      this.jdField_a_of_type_Axtn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */