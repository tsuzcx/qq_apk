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
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity;
    paramDialogInterface.mIsOwner = this.jdField_a_of_type_Boolean;
    String str = this.jdField_a_of_type_JavaLangString;
    paramDialogInterface.mInviteId = str;
    GameRoomConstants.jdField_a_of_type_JavaLangString = str;
    paramDialogInterface.init(false);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.6
 * JD-Core Version:    0.7.0.1
 */