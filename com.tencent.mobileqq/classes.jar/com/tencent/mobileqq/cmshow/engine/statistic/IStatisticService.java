package com.tencent.mobileqq.cmshow.engine.statistic;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "", "actionStatistic", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;", "getActionStatistic", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;", "setActionStatistic", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;)V", "scriptStatistic", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;", "getScriptStatistic", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;", "setScriptStatistic", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IStatisticService
{
  @Nullable
  public abstract IActionStatistic a();
  
  public abstract void a(@Nullable IScriptStatistic paramIScriptStatistic);
  
  @Nullable
  public abstract IScriptStatistic b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService
 * JD-Core Version:    0.7.0.1
 */