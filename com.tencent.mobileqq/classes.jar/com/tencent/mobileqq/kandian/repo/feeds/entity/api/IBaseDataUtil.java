package com.tencent.mobileqq.kandian.repo.feeds.entity.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IBaseDataUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSortWeight", "", "baseData", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBaseDataUtil
  extends QRouteApi
{
  public abstract float getSortWeight(@Nullable BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.api.IBaseDataUtil
 * JD-Core Version:    0.7.0.1
 */