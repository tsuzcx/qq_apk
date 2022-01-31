package com.tencent.qapmsdk.base.reporter;

import com.tencent.qapmsdk.base.statistics.ErrorStatistics;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class ReporterMachine$start$1$1
  implements Runnable
{
  public static final 1 INSTANCE = new 1();
  
  public final void run()
  {
    ErrorStatistics.INSTANCE.doReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ReporterMachine.start.1.1
 * JD-Core Version:    0.7.0.1
 */