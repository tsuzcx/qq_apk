package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;

@RoutePage(desc="显示错误弹窗", path="/nearby/gameroom/trans")
public class GameRoomTransActivity
  extends BaseActivity
{
  QQCustomDialog dialog = null;
  DialogInterface.OnDismissListener disMissListener = new GameRoomTransActivity.4(this);
  
  public void doEnterGame()
  {
    int i = 10;
    try
    {
      j = getIntent().getIntExtra("roomNum", 10);
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      label17:
      break label17;
    }
    j = getIntent().getIntExtra("zoneId", 0);
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).b(i, j, new GameRoomTransActivity.2(this, i));
  }
  
  public void doJoinTeam()
  {
    String str = getIntent().getStringExtra("inviteId");
    int i = getIntent().getIntExtra("roomNum", 10);
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(str, true, new GameRoomTransActivity.3(this, str, i));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
      doWork();
      return true;
    }
    doWork();
    return true;
  }
  
  protected void doStartInvite()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int j = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(new GameRoomTransActivity.5(this, l, i, j));
  }
  
  public void doWork()
  {
    int i = getIntent().getIntExtra("action", 1);
    if (i == 1)
    {
      doEnterGame();
      return;
    }
    if (i == 2)
    {
      doJoinTeam();
      return;
    }
    if (i == 3)
    {
      doStartInvite();
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity
 * JD-Core Version:    0.7.0.1
 */