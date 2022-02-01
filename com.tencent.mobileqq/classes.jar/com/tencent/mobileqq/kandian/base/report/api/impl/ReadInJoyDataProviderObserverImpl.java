package com.tencent.mobileqq.kandian.base.report.api.impl;

import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver;
import com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDataProviderObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/impl/ReadInJoyDataProviderObserverImpl;", "Lcom/tencent/mobileqq/kandian/base/report/api/IReadInJoyDataProviderObserver;", "()V", "doReport", "", "subAction", "", "detail", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyDataProviderObserverImpl
  implements IReadInJoyDataProviderObserver
{
  public void doReport(@Nullable String paramString1, @Nullable String paramString2)
  {
    ReadInJoyDataProviderObserver.getInstance().doReport(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.impl.ReadInJoyDataProviderObserverImpl
 * JD-Core Version:    0.7.0.1
 */