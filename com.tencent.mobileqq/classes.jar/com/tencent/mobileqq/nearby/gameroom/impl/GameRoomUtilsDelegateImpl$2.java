package com.tencent.mobileqq.nearby.gameroom.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

class GameRoomUtilsDelegateImpl$2
  implements DialogInterface.OnClickListener
{
  GameRoomUtilsDelegateImpl$2(GameRoomUtilsDelegateImpl paramGameRoomUtilsDelegateImpl, Context paramContext, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.b);
    paramDialogInterface.putExtra("roomNum", this.c);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomUtilsDelegateImpl.2
 * JD-Core Version:    0.7.0.1
 */