package com.tencent.mobileqq.kandian.glue.pts;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJProteusDtImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/pts/RIJProteusDtFactory;", "", "()V", "create", "Lcom/tencent/mobileqq/kandian/glue/report/dt/RIJProteusDtImpl;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDtFactory
{
  public static final RIJProteusDtFactory a = new RIJProteusDtFactory();
  
  @JvmStatic
  @NotNull
  public static final RIJProteusDtImpl a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(381);
    boolean bool = true;
    if (localAladdinConfig.getIntegerFromString("allow_call_dt_report", 1) != 1) {
      bool = false;
    }
    return new RIJProteusDtImpl(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.RIJProteusDtFactory
 * JD-Core Version:    0.7.0.1
 */