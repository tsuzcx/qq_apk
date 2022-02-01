package com.tencent.timi.game.team.impl.team;

import android.app.Activity;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil.Action;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FleetProfileUtil$showFleetProfileDialog$1$onAtClick$1
  implements Runnable
{
  FleetProfileUtil$showFleetProfileDialog$1$onAtClick$1(FleetProfileUtil.showFleetProfileDialog.1 param1, ProfileDialog paramProfileDialog) {}
  
  public final void run()
  {
    Object localObject = SpecialMsgUtil.a.a(this.this$0.c, (Activity)this.this$0.d);
    if (localObject != null)
    {
      localObject = ((SpecialMsgUtil.Action)localObject).a();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.FleetProfileUtil.showFleetProfileDialog.1.onAtClick.1
 * JD-Core Version:    0.7.0.1
 */