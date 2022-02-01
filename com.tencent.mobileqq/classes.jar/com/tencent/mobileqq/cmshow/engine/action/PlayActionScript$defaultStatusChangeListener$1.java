package com.tencent.mobileqq.cmshow.engine.action;

import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.mobileqq.cmshow.engine.statistic.IActionStatistic;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "newValue", "invoke"}, k=3, mv={1, 1, 16})
final class PlayActionScript$defaultStatusChangeListener$1
  extends Lambda
  implements Function2<ActionStatus, ActionStatus, Unit>
{
  PlayActionScript$defaultStatusChangeListener$1(PlayActionScript paramPlayActionScript)
  {
    super(2);
  }
  
  public final void invoke(@NotNull ActionStatus paramActionStatus1, @NotNull ActionStatus paramActionStatus2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus1, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramActionStatus2, "newValue");
    if (Intrinsics.areEqual(paramActionStatus2, START.a))
    {
      paramActionStatus1 = this.this$0.d().i().a();
      if (paramActionStatus1 != null) {
        paramActionStatus1.a(this.this$0.f().c(), this.this$0.f().m());
      }
    }
    if (paramActionStatus2.b())
    {
      paramActionStatus1 = this.this$0.c();
      PlayActionScript.h();
      QLog.i("[cmshow][PlayActionScript]", 1, this.this$0.a(paramActionStatus1));
      paramActionStatus2 = this.this$0.d().i().a();
      if (paramActionStatus2 != null) {
        paramActionStatus2.a(this.this$0.f().c(), this.this$0.f().m(), paramActionStatus1, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.PlayActionScript.defaultStatusChangeListener.1
 * JD-Core Version:    0.7.0.1
 */