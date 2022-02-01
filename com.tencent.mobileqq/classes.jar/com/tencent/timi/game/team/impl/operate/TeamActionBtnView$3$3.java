package com.tencent.timi.game.team.impl.operate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;

class TeamActionBtnView$3$3
  implements DialogInterface.OnClickListener
{
  TeamActionBtnView$3$3(TeamActionBtnView.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamActionBtnView.b(this.a.e)).b(new TeamActionBtnView.3.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.3.3
 * JD-Core Version:    0.7.0.1
 */