package com.tencent.mobileqq.gallery.view;

import aejd;
import aeje;
import aejg;
import amkg;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import aqlu;
import aqlw;
import aqmb;
import aqme;
import aqnd;
import aqoa;
import aqob;
import aqoc;
import bctn;
import bizu;
import bkur;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.BinderWarpper;
import lzj;
import wxu;

public class AIOGalleryActivity
  extends PeakActivity
{
  aejd jdField_a_of_type_Aejd;
  aejg jdField_a_of_type_Aejg = new aqob(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private aqlu jdField_a_of_type_Aqlu;
  private aqnd jdField_a_of_type_Aqnd;
  public String a;
  private wxu jdField_a_of_type_Wxu;
  BroadcastReceiver b = null;
  
  public boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Aqlu.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Aqlu.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Aqlu.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ac = true;
    this.ad = false;
    bkur.a(this);
    bkur.c(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Wxu = wxu.a();
    this.jdField_a_of_type_Wxu.a();
    aege.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bizu.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      this.jdField_a_of_type_Aqlu = new aqlu(this);
      new aqlw(this.jdField_a_of_type_Aqlu).a(paramBundle);
      this.jdField_a_of_type_Aqnd = this.jdField_a_of_type_Aqlu.a();
      if (this.jdField_a_of_type_Aejd == null)
      {
        paramBundle = (BinderWarpper)paramBundle.getParcelableExtra("extra.IMAGE_PROVIDER");
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Aejd = aeje.a(paramBundle.a);
          this.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Aejg);
          if (this.jdField_a_of_type_Aqnd != null)
          {
            this.jdField_a_of_type_Aqnd.jdField_a_of_type_Aejd = this.jdField_a_of_type_Aejd;
            this.jdField_a_of_type_Aqnd.g();
          }
          aqmb.a().a().a("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Aejd);
        }
      }
      else
      {
        this.b = new aqoa(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.StartVideoChat");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          registerReceiver(this.b, paramBundle);
          return;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        localException = localException;
        aqmb.a().a().a("AIOGalleryActivity", 4, "onCreate exception = " + localException.getMessage());
        finish();
        continue;
        aqmb.a().a().a("AIOGalleryActivity", 4, "binder is null!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    aqmb.a().a().a("AIOGalleryActivity", 4, "onDestroy()");
    super.onDestroy();
    this.jdField_a_of_type_Aqlu.h();
    if (this.jdField_a_of_type_Aejd != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Aejd.a();
      }
      for (;;)
      {
        if (this.b != null)
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Wxu.b();
        return;
        this.jdField_a_of_type_Aejd.c();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aqmb.a().a().a("AIOGalleryActivity", 4, "onDestroy() exception = " + localException.getMessage());
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Aqlu.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lzj.a(BaseApplicationImpl.getContext(), false);
    bctn.a(BaseApplicationImpl.getContext(), true, 52);
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Aqlu.g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aqmb.a().a().a("AIOGalleryActivity", 4, "onPause exception = " + localException.getMessage());
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    lzj.a(BaseApplicationImpl.getContext(), true);
    bctn.a(BaseApplicationImpl.getContext(), false, 52);
    amkg.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aqoc(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Aqlu.f();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Aqlu.e();
  }
  
  public void onStop()
  {
    aqmb.a().a().a("AIOGalleryActivity", 4, "onStop()");
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Aqlu.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */