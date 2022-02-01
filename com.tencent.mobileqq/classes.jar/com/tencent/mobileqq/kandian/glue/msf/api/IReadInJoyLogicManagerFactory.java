package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManagerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createReadInJoyLogicManager", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;", "app", "Lcom/tencent/common/app/AppInterface;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyLogicManagerFactory
  extends QRouteApi
{
  @NotNull
  public abstract IReadInJoyLogicManager createReadInJoyLogicManager(@NotNull AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManagerFactory
 * JD-Core Version:    0.7.0.1
 */