package com.tencent.mobileqq.kandian.biz.config.api.impl;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/impl/ReadInJoySearchJumpUrlConfProcessorImpl;", "Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfProcessor;", "()V", "getConfig", "Lcom/tencent/mobileqq/kandian/biz/config/IReadInJoySearchJumpUrlConfBean;", "getProcessClazz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySearchJumpUrlConfProcessorImpl
  implements IReadInJoySearchJumpUrlConfProcessor
{
  @Nullable
  public IReadInJoySearchJumpUrlConfBean getConfig()
  {
    return ReadInjoySearchJumpurlConfProcessor.a();
  }
  
  @NotNull
  public Class<? extends IQConfigProcessor<?>> getProcessClazz()
  {
    return ReadInjoySearchJumpurlConfProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.impl.ReadInJoySearchJumpUrlConfProcessorImpl
 * JD-Core Version:    0.7.0.1
 */