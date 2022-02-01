package com.tencent.mobileqq.kandian.biz.config.api.impl;

import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfBeanFactory;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfBean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/impl/ReadInJoySearchJumpUrlConfBeanFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfBeanFactory;", "()V", "createConfBean", "Lcom/tencent/mobileqq/kandian/biz/config/IReadInJoySearchJumpUrlConfBean;", "parse", "json", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySearchJumpUrlConfBeanFactoryImpl
  implements IReadInJoySearchJumpUrlConfBeanFactory
{
  @Nullable
  public IReadInJoySearchJumpUrlConfBean createConfBean()
  {
    return (IReadInJoySearchJumpUrlConfBean)new ReadInjoySearchJumpurlConfBean();
  }
  
  @Nullable
  public IReadInJoySearchJumpUrlConfBean parse(@Nullable String paramString)
  {
    return new ReadInjoySearchJumpurlConfBean().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.impl.ReadInJoySearchJumpUrlConfBeanFactoryImpl
 * JD-Core Version:    0.7.0.1
 */