package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyGlobalReporter;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/ReadInJoyGlobalReporterImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyGlobalReporter;", "()V", "needReport", "", "report", "", "rsetEnterTime", "app", "Lmqq/app/AppRuntime;", "time", "", "setAPPStatus", "status", "", "stopReport", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyGlobalReporterImpl
  implements IReadInJoyGlobalReporter
{
  public boolean needReport()
  {
    return ReadInJoyGlobalReporter.f();
  }
  
  public void report()
  {
    ReadInJoyGlobalReporter localReadInJoyGlobalReporter = ReadInJoyGlobalReporter.e();
    if (localReadInJoyGlobalReporter != null) {
      localReadInJoyGlobalReporter.a();
    }
  }
  
  public void rsetEnterTime(@Nullable AppRuntime paramAppRuntime, long paramLong)
  {
    ReadInJoyGlobalReporter localReadInJoyGlobalReporter = ReadInJoyGlobalReporter.e();
    if (localReadInJoyGlobalReporter != null) {
      localReadInJoyGlobalReporter.a((QQAppInterface)paramAppRuntime, paramLong);
    }
  }
  
  public void setAPPStatus(int paramInt)
  {
    ReadInJoyGlobalReporter localReadInJoyGlobalReporter = ReadInJoyGlobalReporter.e();
    if (localReadInJoyGlobalReporter != null) {
      localReadInJoyGlobalReporter.b(paramInt);
    }
  }
  
  public void stopReport()
  {
    ReadInJoyGlobalReporter localReadInJoyGlobalReporter = ReadInJoyGlobalReporter.e();
    if (localReadInJoyGlobalReporter != null) {
      localReadInJoyGlobalReporter.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.ReadInJoyGlobalReporterImpl
 * JD-Core Version:    0.7.0.1
 */