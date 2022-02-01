package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameRoomInviteActivity$UserGridAdapter$1
  implements View.OnClickListener
{
  GameRoomInviteActivity$UserGridAdapter$1(GameRoomInviteActivity.UserGridAdapter paramUserGridAdapter, int paramInt, WerewolvesHandler paramWerewolvesHandler) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((GameRoomInviteActivity.GameRoomUser)this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter.a.a.get(this.jdField_a_of_type_Int)).a);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter.a.b, l, null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter.a.a("invite_page", "kick_out");
      label62:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.UserGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */