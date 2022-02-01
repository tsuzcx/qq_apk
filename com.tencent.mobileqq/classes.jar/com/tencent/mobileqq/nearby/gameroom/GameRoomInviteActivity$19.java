package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;

class GameRoomInviteActivity$19
  implements DialogInterface.OnClickListener
{
  GameRoomInviteActivity$19(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).enterNewGame(this.a, 10);
    GameRoomInviteActivity.access$401(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.19
 * JD-Core Version:    0.7.0.1
 */