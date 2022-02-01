package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.viola.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.kandian.glue.viola.adapter.BaseHttpAdapter;
import com.tencent.viola.adapter.IHttpAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/BaseHttpAdapterFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IBaseHttpAdapterFactory;", "()V", "create", "Lcom/tencent/viola/adapter/IHttpAdapter;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseHttpAdapterFactoryImpl
  implements IBaseHttpAdapterFactory
{
  @NotNull
  public IHttpAdapter create()
  {
    return (IHttpAdapter)new BaseHttpAdapter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.BaseHttpAdapterFactoryImpl
 * JD-Core Version:    0.7.0.1
 */