package com.tencent.mobileqq.gallery.view;

import aejb;
import aejc;
import aeje;
import amkf;
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
import aqlw;
import aqly;
import aqmd;
import aqmg;
import aqnf;
import aqoc;
import aqod;
import aqoe;
import bcuc;
import bjal;
import bkvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.BinderWarpper;
import lze;
import wxr;

public class AIOGalleryActivity
  extends PeakActivity
{
  aejb jdField_a_of_type_Aejb;
  aeje jdField_a_of_type_Aeje = new aqod(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private aqlw jdField_a_of_type_Aqlw;
  private aqnf jdField_a_of_type_Aqnf;
  public String a;
  private wxr jdField_a_of_type_Wxr;
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
    this.jdField_a_of_type_Aqlw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Aqlw.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Aqlw.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ac = true;
    this.ad = false;
    bkvi.a(this);
    bkvi.c(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
    aegc.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bjal.a());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      this.jdField_a_of_type_Aqlw = new aqlw(this);
      new aqly(this.jdField_a_of_type_Aqlw).a(paramBundle);
      this.jdField_a_of_type_Aqnf = this.jdField_a_of_type_Aqlw.a();
      if (this.jdField_a_of_type_Aejb == null)
      {
        paramBundle = (BinderWarpper)paramBundle.getParcelableExtra("extra.IMAGE_PROVIDER");
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Aejb = aejc.a(paramBundle.a);
          this.jdField_a_of_type_Aejb.a(this.jdField_a_of_type_Aeje);
          if (this.jdField_a_of_type_Aqnf != null)
          {
            this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aejb = this.jdField_a_of_type_Aejb;
            this.jdField_a_of_type_Aqnf.g();
          }
          aqmd.a().a().a("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Aejb);
        }
      }
      else
      {
        this.b = new aqoc(this);
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
        aqmd.a().a().a("AIOGalleryActivity", 4, "onCreate exception = " + localException.getMessage());
        finish();
        continue;
        aqmd.a().a().a("AIOGalleryActivity", 4, "binder is null!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    aqmd.a().a().a("AIOGalleryActivity", 4, "onDestroy()");
    super.onDestroy();
    this.jdField_a_of_type_Aqlw.h();
    if (this.jdField_a_of_type_Aejb != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Aejb.a();
      }
      for (;;)
      {
        if (this.b != null)
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Wxr.b();
        return;
        this.jdField_a_of_type_Aejb.c();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aqmd.a().a().a("AIOGalleryActivity", 4, "onDestroy() exception = " + localException.getMessage());
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Aqlw.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lze.a(BaseApplicationImpl.getContext(), false);
    bcuc.a(BaseApplicationImpl.getContext(), true, 52);
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Aqlw.g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aqmd.a().a().a("AIOGalleryActivity", 4, "onPause exception = " + localException.getMessage());
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    lze.a(BaseApplicationImpl.getContext(), true);
    bcuc.a(BaseApplicationImpl.getContext(), false, 52);
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aqoe(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Aqlw.f();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Aqlw.e();
  }
  
  public void onStop()
  {
    aqmd.a().a().a("AIOGalleryActivity", 4, "onStop()");
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Aqlw.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */