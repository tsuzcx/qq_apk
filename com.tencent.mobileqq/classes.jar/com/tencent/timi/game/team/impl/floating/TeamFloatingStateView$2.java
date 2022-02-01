package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import com.tencent.timi.game.utils.Logger;

class TeamFloatingStateView$2
  implements OnPAGLibraryLoadedListener
{
  TeamFloatingStateView$2(TeamFloatingStateView paramTeamFloatingStateView) {}
  
  public void a()
  {
    Logger.a("Timi_Float", "pag is loaded with init,just play anim");
    TeamFloatingStateView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingStateView.2
 * JD-Core Version:    0.7.0.1
 */