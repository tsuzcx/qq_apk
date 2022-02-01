package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager;
import com.tencent.mobileqq.kandian.biz.common.api.IKanDianClassProvider;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyOperationManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.dau.ReadInJoyDAUReport;
import com.tencent.mobileqq.kandian.glue.report.dau.ReadInJoyDAUStatistic;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/KanDianClassProviderImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IKanDianClassProvider;", "()V", "getKanDianDailyManagerClass", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "getKanDianMergeManagerClass", "getKandianSubscribeManagerClass", "getRIJUgcVideoPublishManagerClass", "getReadInJoyDAUReportClass", "getReadInJoyDAUStatisticClass", "getReadInJoyLogicManagerClass", "getReadInJoyManagerClass", "getReadInJoyOperationManagerClass", "getReadInJoyRefreshManagerClass", "getReadInJoySkinManagerClass", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianClassProviderImpl
  implements IKanDianClassProvider
{
  @NotNull
  public Class<? extends Manager> getKanDianDailyManagerClass()
  {
    return KandianDailyManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getKanDianMergeManagerClass()
  {
    return KandianMergeManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getKandianSubscribeManagerClass()
  {
    return KandianSubscribeManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getRIJUgcVideoPublishManagerClass()
  {
    return RIJUgcVideoPublishManager.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyDAUReportClass()
  {
    return ReadInJoyDAUReport.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoyDAUStatisticClass()
  {
    return ReadInJoyDAUStatistic.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoyLogicManagerClass()
  {
    return ReadInJoyLogicManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoyManagerClass()
  {
    return ReadInJoyManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoyOperationManagerClass()
  {
    return ReadInJoyOperationManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoyRefreshManagerClass()
  {
    return ReadInJoyRefreshManager.class;
  }
  
  @NotNull
  public Class<? extends Manager> getReadInJoySkinManagerClass()
  {
    return ReadInJoySkinManager.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.KanDianClassProviderImpl
 * JD-Core Version:    0.7.0.1
 */