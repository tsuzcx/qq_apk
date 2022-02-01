package com.tencent.mobileqq.cmshow.engine.statistic;

import com.tencent.mobileqq.cmshow.engine.script.Script;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/statistic/IScriptStatistic;", "", "onScriptEnd", "", "script", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "onScriptStart", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IScriptStatistic
{
  public abstract void a(@NotNull Script paramScript);
  
  public abstract void b(@NotNull Script paramScript);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.statistic.IScriptStatistic
 * JD-Core Version:    0.7.0.1
 */