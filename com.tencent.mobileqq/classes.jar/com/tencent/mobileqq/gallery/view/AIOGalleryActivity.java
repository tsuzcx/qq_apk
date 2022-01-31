package com.tencent.mobileqq.gallery.view;

import adye;
import adyf;
import adyh;
import aluq;
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
import apsf;
import apsh;
import apsm;
import apsp;
import apte;
import apua;
import apub;
import apuc;
import bbqo;
import bhfc;
import bjeh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.BinderWarpper;
import lor;
import wis;

public class AIOGalleryActivity
  extends PeakActivity
{
  adye jdField_a_of_type_Adye;
  adyh jdField_a_of_type_Adyh = new apub(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private apsf jdField_a_of_type_Apsf;
  private apte jdField_a_of_type_Apte;
  public String a;
  private wis jdField_a_of_type_Wis;
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
    this.jdField_a_of_type_Apsf.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Apsf.a()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Apsf.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ac = true;
    this.ad = false;
    bjeh.a(this);
    bjeh.c(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Wis = wis.a();
    this.jdField_a_of_type_Wis.a();
    advf.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bhfc.a());
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("extra.GROUP_UIN");
    try
    {
      this.jdField_a_of_type_Apsf = new apsf(this);
      new apsh(this.jdField_a_of_type_Apsf).a(paramBundle);
      this.jdField_a_of_type_Apte = this.jdField_a_of_type_Apsf.a();
      if (this.jdField_a_of_type_Adye == null)
      {
        paramBundle = (BinderWarpper)paramBundle.getParcelableExtra("extra.IMAGE_PROVIDER");
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Adye = adyf.a(paramBundle.a);
          this.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Adyh);
          if (this.jdField_a_of_type_Apte != null)
          {
            this.jdField_a_of_type_Apte.jdField_a_of_type_Adye = this.jdField_a_of_type_Adye;
            this.jdField_a_of_type_Apte.g();
          }
          apsm.a().a().a("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Adye);
        }
      }
      else
      {
        this.b = new apua(this);
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
        apsm.a().a().a("AIOGalleryActivity", 4, "onCreate exception = " + localException.getMessage());
        finish();
        continue;
        apsm.a().a().a("AIOGalleryActivity", 4, "binder is null!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    apsm.a().a().a("AIOGalleryActivity", 4, "onDestroy()");
    super.onDestroy();
    this.jdField_a_of_type_Apsf.h();
    if (this.jdField_a_of_type_Adye != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Adye.a();
      }
      for (;;)
      {
        if (this.b != null)
        {
          unregisterReceiver(this.b);
          this.b = null;
        }
        this.jdField_a_of_type_Wis.b();
        return;
        this.jdField_a_of_type_Adye.c();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        apsm.a().a().a("AIOGalleryActivity", 4, "onDestroy() exception = " + localException.getMessage());
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Apsf.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lor.a(BaseApplicationImpl.getContext(), false);
    bbqo.a(BaseApplicationImpl.getContext(), true, 52);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Apsf.g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        apsm.a().a().a("AIOGalleryActivity", 4, "onPause exception = " + localException.getMessage());
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    lor.a(BaseApplicationImpl.getContext(), true);
    bbqo.a(BaseApplicationImpl.getContext(), false, 52);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new apuc(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Apsf.f();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Apsf.e();
  }
  
  public void onStop()
  {
    apsm.a().a().a("AIOGalleryActivity", 4, "onStop()");
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Apsf.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */