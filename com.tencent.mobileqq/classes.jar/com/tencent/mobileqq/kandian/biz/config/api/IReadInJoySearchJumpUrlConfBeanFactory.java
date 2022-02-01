package com.tencent.mobileqq.kandian.biz.config.api;

import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfBeanFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createConfBean", "Lcom/tencent/mobileqq/kandian/biz/config/IReadInJoySearchJumpUrlConfBean;", "parse", "json", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySearchJumpUrlConfBeanFactory
  extends QRouteApi
{
  @Nullable
  public abstract IReadInJoySearchJumpUrlConfBean createConfBean();
  
  @Nullable
  public abstract IReadInJoySearchJumpUrlConfBean parse(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfBeanFactory
 * JD-Core Version:    0.7.0.1
 */