package com.tencent.mobileqq.kandian.biz.fastweb.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/api/IItemDatasListUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "insertForWeight", "", "datas", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "sortData", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IItemDatasListUtils
  extends QRouteApi
{
  public abstract void insertForWeight(@Nullable List<? extends BaseData> paramList, @Nullable BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.api.IItemDatasListUtils
 * JD-Core Version:    0.7.0.1
 */