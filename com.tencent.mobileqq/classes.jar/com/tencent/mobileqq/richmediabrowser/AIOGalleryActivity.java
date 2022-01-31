package com.tencent.mobileqq.richmediabrowser;

import agki;
import agkj;
import agkl;
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
import aofm;
import axxu;
import axxw;
import axxx;
import axxy;
import axxz;
import axya;
import axyd;
import axyg;
import axyh;
import axyq;
import bexu;
import blqh;
import bnle;
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
import yqz;

public class AIOGalleryActivity
  extends PeakActivity
{
  agki jdField_a_of_type_Agki;
  agkl jdField_a_of_type_Agkl = new axxz(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private axxw jdField_a_of_type_Axxw;
  private axyq jdField_a_of_type_Axyq;
  public String a;
  private yqz jdField_a_of_type_Yqz;
  private volatile boolean jdField_a_of_type_Boolean;
  BroadcastReceiver b = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Agki == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_Agki = agkj.a(((BinderWarpper)localObject).a);
      this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_Agkl);
      if (this.jdField_a_of_type_Axyq != null)
      {
        this.jdField_a_of_type_Axyq.a(this.jdField_a_of_type_Agki);
        localObject = new axyg();
        ((axyg)localObject).a(this.jdField_a_of_type_Agki);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if ((this.jdField_a_of_type_Agki != null) && (!axyd.a().e())) {
          this.jdField_a_of_type_Agki.a(axyd.a().b());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Agki);
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
    this.b = new axxy(this);
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
    this.jdField_a_of_type_Axxw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Axxw.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Axxw.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    bnle.a(this);
    bnle.c(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Yqz = yqz.a();
    this.jdField_a_of_type_Yqz.a();
    aghh.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(blqh.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new axyh());
      RichMediaBrowserManager.getInstance().setMvpFactory(new axxx());
      Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
      axyd.a().a(localRect);
      axxu localaxxu = new axxu();
      localaxxu.a = localRect;
      RichMediaBrowserManager.getInstance().setAnimationListener(localaxxu);
      axyd.a().a(paramBundle);
      this.jdField_a_of_type_Axxw = new axxw(this);
      new BrowserDirector(this.jdField_a_of_type_Axxw).construct(paramBundle);
      this.jdField_a_of_type_Axyq = this.jdField_a_of_type_Axxw.a();
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
    if (this.jdField_a_of_type_Axxw != null) {
      this.jdField_a_of_type_Axxw.e();
    }
    if (this.jdField_a_of_type_Agki != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_Agki.c();
        this.jdField_a_of_type_Agki.a();
        this.jdField_a_of_type_Agkl = null;
      }
      for (;;)
      {
        if ((this.b != null) && (this.jdField_a_of_type_Boolean))
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Yqz.b();
        return;
        this.jdField_a_of_type_Agki.c();
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
    if (!this.jdField_a_of_type_Axxw.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    mbt.a(BaseApplicationImpl.getContext(), false);
    bexu.a(BaseApplicationImpl.getContext(), true, 52);
    aofm.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Axxw.d();
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
    bexu.a(BaseApplicationImpl.getContext(), false, 52);
    aofm.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new axya(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Axxw.c();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Axxw.b();
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
      this.jdField_a_of_type_Axxw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */