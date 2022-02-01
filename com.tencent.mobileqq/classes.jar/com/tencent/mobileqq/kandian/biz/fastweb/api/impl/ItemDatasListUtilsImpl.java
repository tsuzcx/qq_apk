package com.tencent.mobileqq.kandian.biz.fastweb.api.impl;

import com.tencent.mobileqq.kandian.biz.fastweb.api.IItemDatasListUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/api/impl/ItemDatasListUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/fastweb/api/IItemDatasListUtils;", "()V", "insertForWeight", "", "datas", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "sortData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ItemDatasListUtilsImpl
  implements IItemDatasListUtils
{
  public void insertForWeight(@Nullable List<? extends BaseData> paramList, @Nullable BaseData paramBaseData)
  {
    ItemDatasListUtils.a(paramList, paramBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.api.impl.ItemDatasListUtilsImpl
 * JD-Core Version:    0.7.0.1
 */