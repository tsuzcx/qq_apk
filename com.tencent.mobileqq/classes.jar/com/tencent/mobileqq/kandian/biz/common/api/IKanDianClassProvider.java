package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IKanDianClassProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getKanDianDailyManagerClass", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "getKanDianMergeManagerClass", "getKandianSubscribeManagerClass", "getRIJUgcVideoPublishManagerClass", "getReadInJoyDAUReportClass", "getReadInJoyDAUStatisticClass", "getReadInJoyLogicManagerClass", "getReadInJoyManagerClass", "getReadInJoyOperationManagerClass", "getReadInJoyRefreshManagerClass", "getReadInJoySkinManagerClass", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianClassProvider
  extends QRouteApi
{
  @NotNull
  public abstract Class<? extends Manager> getKanDianDailyManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getKanDianMergeManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getKandianSubscribeManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getRIJUgcVideoPublishManagerClass();
  
  @NotNull
  public abstract Class<?> getReadInJoyDAUReportClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoyDAUStatisticClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoyLogicManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoyManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoyOperationManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoyRefreshManagerClass();
  
  @NotNull
  public abstract Class<? extends Manager> getReadInJoySkinManagerClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IKanDianClassProvider
 * JD-Core Version:    0.7.0.1
 */