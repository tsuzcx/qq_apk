package com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IBaseDataUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/impl/BaseDataUtilImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IBaseDataUtil;", "()V", "getSortWeight", "", "baseData", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseDataUtilImpl
  implements IBaseDataUtil
{
  public float getSortWeight(@Nullable BaseData paramBaseData)
  {
    return this.$$delegate_0.getSortWeight(paramBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl.BaseDataUtilImpl
 * JD-Core Version:    0.7.0.1
 */