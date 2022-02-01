package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IFeedsPreloadHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadHelper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/FeedsPreloadHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IFeedsPreloadHelper;", "()V", "isFeedsPreloadRequest", "", "any", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FeedsPreloadHelperImpl
  implements IFeedsPreloadHelper
{
  public boolean isFeedsPreloadRequest(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ReadInJoyRequestParams.Request0x68bParams)) {
      return FeedsPreloadHelper.b((ReadInJoyRequestParams.Request0x68bParams)paramObject);
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof ToServiceMsg)) {
      localObject = null;
    }
    return FeedsPreloadHelper.a((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.FeedsPreloadHelperImpl
 * JD-Core Version:    0.7.0.1
 */