package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameRoomTransActivity
  extends BaseActivity
{
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new GameRoomTransActivity.4(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  
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
      ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).b(i, j, new GameRoomTransActivity.2(this, i));
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
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(str, true, new GameRoomTransActivity.3(this, str, i));
  }
  
  protected void d()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(new GameRoomTransActivity.5(this, l, i, j));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
        requestPermissions(new GameRoomTransActivity.1(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
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