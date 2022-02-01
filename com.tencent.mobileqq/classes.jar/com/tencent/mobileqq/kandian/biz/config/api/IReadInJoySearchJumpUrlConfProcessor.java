package com.tencent.mobileqq.kandian.biz.config.api;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfProcessor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getConfig", "Lcom/tencent/mobileqq/kandian/biz/config/IReadInJoySearchJumpUrlConfBean;", "getProcessClazz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySearchJumpUrlConfProcessor
  extends QRouteApi
{
  public static final int CONFIG_ID = 292;
  public static final IReadInJoySearchJumpUrlConfProcessor.Companion Companion = IReadInJoySearchJumpUrlConfProcessor.Companion.a;
  
  @Nullable
  public abstract IReadInJoySearchJumpUrlConfBean getConfig();
  
  @NotNull
  public abstract Class<? extends IQConfigProcessor<?>> getProcessClazz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor
 * JD-Core Version:    0.7.0.1
 */