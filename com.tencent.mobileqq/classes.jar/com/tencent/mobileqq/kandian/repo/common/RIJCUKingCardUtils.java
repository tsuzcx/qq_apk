package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.vip.CUKingCardUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/common/RIJCUKingCardUtils;", "", "()V", "getSimCardTypeForRecommend", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCUKingCardUtils
{
  public static final RIJCUKingCardUtils a = new RIJCUKingCardUtils();
  
  @JvmStatic
  public static final int a()
  {
    if (CUKingCardUtils.a() == 1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils
 * JD-Core Version:    0.7.0.1
 */