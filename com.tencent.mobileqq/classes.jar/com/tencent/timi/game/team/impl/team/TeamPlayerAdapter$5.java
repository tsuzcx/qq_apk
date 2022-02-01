package com.tencent.timi.game.team.impl.team;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;

class TeamPlayerAdapter$5
  implements DialogInterface.OnClickListener
{
  TeamPlayerAdapter$5(TeamPlayerAdapter paramTeamPlayerAdapter, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamPlayerAdapter.b(this.b)).a(false, this.a, new TeamPlayerAdapter.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerAdapter.5
 * JD-Core Version:    0.7.0.1
 */