package com.tencent.mobileqq.cmshow.engine.script;

import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.statistic.IScriptStatistic;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "", "scriptContent", "", "(Ljava/lang/String;)V", "TAG", "evaluateEndTimestamp", "", "evaluateStartTimestamp", "initTimestamp", "getScriptContent", "()Ljava/lang/String;", "scriptId", "", "getScriptId", "()I", "setScriptId", "(I)V", "statisticService", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "getStatisticService$cmshow_impl_release", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "setStatisticService$cmshow_impl_release", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;)V", "evaluateCostTime", "evaluateDelayTime", "evaluateEnd", "", "evaluateStart", "toString", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class Script
{
  private final String a;
  private int b;
  @Nullable
  private IStatisticService c;
  private final long d;
  private long e;
  private long f;
  @NotNull
  private final String g;
  
  public Script(@NotNull String paramString)
  {
    this.g = paramString;
    this.a = "[cmshow][Script]";
    this.d = System.currentTimeMillis();
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@Nullable IStatisticService paramIStatisticService)
  {
    this.c = paramIStatisticService;
  }
  
  public void b()
  {
    this.e = System.currentTimeMillis();
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((IStatisticService)localObject).b();
      if (localObject != null) {
        ((IScriptStatistic)localObject).a(this);
      }
    }
  }
  
  @NotNull
  public String e()
  {
    return this.g;
  }
  
  public final int i()
  {
    return this.b;
  }
  
  public void j()
  {
    this.f = System.currentTimeMillis();
    Object localObject = EngineHelper.a;
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((IStatisticService)localObject).b();
      if (localObject != null) {
        ((IScriptStatistic)localObject).b(this);
      }
    }
  }
  
  public final long k()
  {
    return this.f - this.e;
  }
  
  public final long l()
  {
    return this.e - this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Script[scriptContent:");
    localStringBuilder.append(e());
    localStringBuilder.append(", scriptId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.Script
 * JD-Core Version:    0.7.0.1
 */