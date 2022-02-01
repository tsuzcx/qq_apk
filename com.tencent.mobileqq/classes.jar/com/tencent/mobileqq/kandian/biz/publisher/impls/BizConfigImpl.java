package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/BizConfigImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;", "()V", "getIsKingCard", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BizConfigImpl
  implements IBizConfig
{
  public boolean a()
  {
    return CUKingCardHelper.a() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.BizConfigImpl
 * JD-Core Version:    0.7.0.1
 */