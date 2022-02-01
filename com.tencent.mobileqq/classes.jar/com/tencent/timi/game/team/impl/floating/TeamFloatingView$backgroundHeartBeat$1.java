package com.tencent.timi.game.team.impl.floating;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingView$backgroundHeartBeat$1", "Ljava/lang/Runnable;", "run", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView$backgroundHeartBeat$1
  implements Runnable
{
  public void run()
  {
    if (GuardManager.sInstance != null)
    {
      GuardManager localGuardManager = GuardManager.sInstance;
      Intrinsics.checkExpressionValueIsNotNull(localGuardManager, "GuardManager.sInstance");
      if ((!localGuardManager.isApplicationForeground()) && (!QBaseActivity.mAppForground))
      {
        if (TeamFloatingView.c(this.this$0))
        {
          Logger.c("Timi_Float", "onBackground by HeartBeat!!!");
          this.this$0.e();
        }
      }
      else if (!TeamFloatingView.c(this.this$0))
      {
        Logger.c("Timi_Float", "onForground by HeartBeat!!!");
        this.this$0.f();
      }
      this.this$0.removeCallbacks((Runnable)this);
    }
    this.this$0.postDelayed((Runnable)this, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.backgroundHeartBeat.1
 * JD-Core Version:    0.7.0.1
 */