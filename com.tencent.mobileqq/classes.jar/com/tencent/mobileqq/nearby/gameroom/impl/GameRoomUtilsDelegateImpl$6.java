package com.tencent.mobileqq.nearby.gameroom.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

class GameRoomUtilsDelegateImpl$6
  implements DialogInterface.OnClickListener
{
  GameRoomUtilsDelegateImpl$6(GameRoomUtilsDelegateImpl paramGameRoomUtilsDelegateImpl, Activity paramActivity, String paramString, int paramInt, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.b);
    paramDialogInterface.putExtra("roomNum", this.c);
    long l = this.d;
    if (l > 0L)
    {
      paramDialogInterface.putExtra("gc", l);
      paramDialogInterface.putExtra("isInviteTroop", false);
    }
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomUtilsDelegateImpl.6
 * JD-Core Version:    0.7.0.1
 */