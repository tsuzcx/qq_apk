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
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("roomNum", this.jdField_a_of_type_Int);
    long l = this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      paramDialogInterface.putExtra("gc", l);
      paramDialogInterface.putExtra("isInviteTroop", false);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomUtilsDelegateImpl.6
 * JD-Core Version:    0.7.0.1
 */