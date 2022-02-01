package com.tencent.mobileqq.cmshow.engine.statistic;

import com.tencent.mobileqq.cmshow.engine.EngineContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/statistic/StatisticService;", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "actionStatistic", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;", "getActionStatistic", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;", "setActionStatistic", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IActionStatistic;)V", "scriptStatistic", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;", "getScriptStatistic", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;", "setScriptStatistic", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class StatisticService
  implements IStatisticService
{
  @Nullable
  private IActionStatistic a;
  @Nullable
  private IScriptStatistic b;
  
  public StatisticService(@NotNull EngineContext paramEngineContext)
  {
    paramEngineContext.a((IStatisticService)this);
  }
  
  @Nullable
  public IActionStatistic a()
  {
    return this.a;
  }
  
  public void a(@Nullable IScriptStatistic paramIScriptStatistic)
  {
    this.b = paramIScriptStatistic;
  }
  
  @Nullable
  public IScriptStatistic b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.statistic.StatisticService
 * JD-Core Version:    0.7.0.1
 */