package com.tencent.mobileqq.nearby.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;

class GameRoomInviteActivity$6
  implements DialogInterface.OnClickListener
{
  GameRoomInviteActivity$6(GameRoomInviteActivity paramGameRoomInviteActivity, boolean paramBoolean, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.c;
    paramDialogInterface.mIsOwner = this.a;
    String str = this.b;
    paramDialogInterface.mInviteId = str;
    GameRoomConstants.a = str;
    paramDialogInterface.init(false);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.6
 * JD-Core Version:    0.7.0.1
 */