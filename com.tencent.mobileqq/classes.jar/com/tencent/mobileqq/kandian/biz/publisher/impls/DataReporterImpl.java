package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.interfaces.IDataReporter;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/DataReporterImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;", "()V", "onReport", "", "p0", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter$ACTION;", "p1", "", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataReporterImpl
  implements IDataReporter
{
  public void a(@NotNull IDataReporter.ACTION paramACTION, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramACTION, "p0");
    Intrinsics.checkParameterIsNotNull(paramMap, "p1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataReporterImpl
 * JD-Core Version:    0.7.0.1
 */