package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.api.IRIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/RIJStudyModeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJStudyModeUtils;", "()V", "getUserMode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJStudyModeUtilsImpl
  implements IRIJStudyModeUtils
{
  public int getUserMode()
  {
    return RIJStudyModeUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.RIJStudyModeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */