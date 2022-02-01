package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import java.util.List;

class GameRoomInviteActivity$UserGridAdapter$1
  implements View.OnClickListener
{
  GameRoomInviteActivity$UserGridAdapter$1(GameRoomInviteActivity.UserGridAdapter paramUserGridAdapter, int paramInt, WerewolvesHandler paramWerewolvesHandler) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((GameRoomInviteActivity.GameRoomUser)this.c.a.mUsers.get(this.a)).a);
      this.b.a(this.c.a.mInviteId, l, null);
      this.c.a.report("invite_page", "kick_out");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.UserGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */