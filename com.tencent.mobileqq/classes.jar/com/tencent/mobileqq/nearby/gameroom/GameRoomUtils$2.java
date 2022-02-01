package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class GameRoomUtils$2
  implements DialogInterface.OnClickListener
{
  GameRoomUtils$2(Context paramContext, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("roomNum", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomUtils.2
 * JD-Core Version:    0.7.0.1
 */