package com.tencent.mobileqq.nearby.gameroom;

import java.util.List;

class GameRoomInviteActivity$21$1
  implements WerewolvesDataManager.GetInviteUserCallback
{
  GameRoomInviteActivity$21$1(GameRoomInviteActivity.21 param21) {}
  
  public void a(List<InviteUser> paramList, boolean paramBoolean)
  {
    this.a.a.mInviteUsers = paramList;
    this.a.a.hasMore = paramBoolean;
    this.a.a.runOnUiThread(new GameRoomInviteActivity.21.1.1(this, paramList, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21.1
 * JD-Core Version:    0.7.0.1
 */