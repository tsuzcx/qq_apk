package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.d.a;
import com.tencent.tvkbeacon.core.event.UserEventModule;

final class StrategyQueryModule$1
  implements d.a
{
  StrategyQueryModule$1(StrategyQueryModule paramStrategyQueryModule, Context paramContext) {}
  
  public final void a()
  {
    if ((!this.b.isAtLeastAComQuerySuccess()) && (UserEventModule.getInstance() != null) && (StrategyQueryModule.getInstance(this.a).getCommonQueryTime() != 0) && (this.b.getCurrentQueryStep() != 2)) {
      this.b.startQuery();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.StrategyQueryModule.1
 * JD-Core Version:    0.7.0.1
 */