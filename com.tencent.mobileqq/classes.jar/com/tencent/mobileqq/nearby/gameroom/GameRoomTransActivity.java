package com.tencent.mobileqq.nearby.gameroom;

import aebp;
import aebq;
import aebt;
import aebu;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;

public class GameRoomTransActivity
  extends BaseActivity
{
  public DialogInterface.OnDismissListener a;
  public QQCustomDialog a;
  
  public GameRoomTransActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new aebt(this);
  }
  
  public void a()
  {
    try
    {
      i = getIntent().getIntExtra("roomNum", 10);
      int j = getIntent().getIntExtra("zoneId", 0);
      ((WerewolvesHandler)this.app.a(107)).b(i, j, new aebp(this, i));
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
  
  public void b()
  {
    String str = getIntent().getStringExtra("inviteId");
    int i = getIntent().getIntExtra("roomNum", 10);
    ((WerewolvesHandler)this.app.a(107)).a(str, true, new aebq(this, str, i));
  }
  
  protected void c()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((WerewolvesHandler)this.app.a(107)).a(new aebu(this, l, i, j));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("action", 1);
    if (i == 1)
    {
      a();
      return true;
    }
    if (i == 2)
    {
      b();
      return true;
    }
    if (i == 3)
    {
      c();
      return true;
    }
    finish();
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity
 * JD-Core Version:    0.7.0.1
 */