package com.tencent.mobileqq.cmshow.engine.statistic;

import com.tencent.mobileqq.cmshow.engine.action.StatusRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;", "", "onActionEnd", "", "actionId", "", "taskId", "statusRecords", "", "Lcom/tencent/mobileqq/cmshow/engine/action/StatusRecord;", "extra", "", "(IILjava/util/List;[Ljava/lang/Object;)V", "onActionStart", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IActionStatistic
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, @NotNull List<StatusRecord> paramList, @NotNull Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.statistic.IActionStatistic
 * JD-Core Version:    0.7.0.1
 */