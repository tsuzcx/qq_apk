package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import atdp;
import atdq;
import atdr;
import atdu;
import atdv;
import bbgg;
import bcic;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GameRoomTransActivity
  extends BaseActivity
{
  public DialogInterface.OnDismissListener a;
  public bbgg a;
  
  public GameRoomTransActivity()
  {
    this.jdField_a_of_type_Bbgg = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new atdu(this);
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
      ((bcic)this.app.a(107)).b(i, j, new atdq(this, i));
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
    ((bcic)this.app.a(107)).a(str, true, new atdr(this, str, i));
  }
  
  protected void d()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((bcic)this.app.a(107)).a(new atdv(this, l, i, j));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
      {
        requestPermissions(new atdp(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
        return true;
      }
      a();
      return true;
    }
    a();
    return true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity
 * JD-Core Version:    0.7.0.1
 */