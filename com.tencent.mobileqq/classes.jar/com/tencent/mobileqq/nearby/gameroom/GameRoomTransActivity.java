package com.tencent.mobileqq.nearby.gameroom;

import Override;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import axzb;
import axzc;
import axzd;
import axzg;
import axzh;
import bhpc;
import bitz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameRoomTransActivity
  extends BaseActivity
{
  public DialogInterface.OnDismissListener a;
  public bhpc a;
  
  public GameRoomTransActivity()
  {
    this.jdField_a_of_type_Bhpc = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new axzg(this);
  }
  
  public void a()
  {
    int i = getIntent().getIntExtra("action", 1);
    if (i == 1)
    {
      b();
      return;
    }
    if (i == 2)
    {
      c();
      return;
    }
    if (i == 3)
    {
      d();
      return;
    }
    finish();
  }
  
  public void b()
  {
    try
    {
      i = getIntent().getIntExtra("roomNum", 10);
      int j = getIntent().getIntExtra("zoneId", 0);
      ((bitz)this.app.a(107)).b(i, j, new axzc(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 10;
      }
    }
  }
  
  public void c()
  {
    String str = getIntent().getStringExtra("inviteId");
    int i = getIntent().getIntExtra("roomNum", 10);
    ((bitz)this.app.a(107)).a(str, true, new axzd(this, str, i));
  }
  
  protected void d()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((bitz)this.app.a(107)).a(new axzh(this, l, i, j));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
      {
        requestPermissions(new axzb(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
        return true;
      }
      a();
      return true;
    }
    a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity
 * JD-Core Version:    0.7.0.1
 */