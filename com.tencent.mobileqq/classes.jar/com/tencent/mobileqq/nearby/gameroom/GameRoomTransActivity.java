package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import ashl;
import ashm;
import ashn;
import ashq;
import ashr;
import bafb;
import bbfc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GameRoomTransActivity
  extends BaseActivity
{
  public DialogInterface.OnDismissListener a;
  public bafb a;
  
  public GameRoomTransActivity()
  {
    this.jdField_a_of_type_Bafb = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ashq(this);
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
      ((bbfc)this.app.a(107)).b(i, j, new ashm(this, i));
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
    ((bbfc)this.app.a(107)).a(str, true, new ashn(this, str, i));
  }
  
  protected void d()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((bbfc)this.app.a(107)).a(new ashr(this, l, i, j));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
      {
        requestPermissions(new ashl(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
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