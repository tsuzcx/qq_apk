package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/ITweetTopicEntranceShouldShowActionUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doShowEntranceReport", "", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITweetTopicEntranceShouldShowActionUtil
  extends QRouteApi
{
  public static final ITweetTopicEntranceShouldShowActionUtil.Companion Companion = ITweetTopicEntranceShouldShowActionUtil.Companion.a;
  public static final int HIDE_TOPIC_ENTRANCE = 2;
  public static final int SHOW_TOPIC_ENTRANCE = 1;
  
  public abstract void doShowEntranceReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.ITweetTopicEntranceShouldShowActionUtil
 * JD-Core Version:    0.7.0.1
 */