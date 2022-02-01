package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.viola.api.IQReportModule;
import com.tencent.mobileqq.kandian.biz.viola.api.IQReportModuleFactory;
import com.tencent.mobileqq.kandian.glue.viola.modules.QReportModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/QReportModuleFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IQReportModuleFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IQReportModule;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class QReportModuleFactoryImpl
  implements IQReportModuleFactory
{
  @NotNull
  public IQReportModule create()
  {
    return (IQReportModule)new QReportModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.QReportModuleFactoryImpl
 * JD-Core Version:    0.7.0.1
 */