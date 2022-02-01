package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IBaseVideoItemDelegateProxyFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegateProxy;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/BaseVideoItemDelegateProxyFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IBaseVideoItemDelegateProxyFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsItemUIDelegate;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseVideoItemDelegateProxyFactoryImpl
  implements IBaseVideoItemDelegateProxyFactory
{
  @NotNull
  public IVideoFeedsItemUIDelegate create(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "videoHolder");
    Intrinsics.checkParameterIsNotNull(paramIVideoFeedsRecommendPresenter, "presenter");
    Intrinsics.checkParameterIsNotNull(paramIVideoFeedsAdapter, "adapter");
    return (IVideoFeedsItemUIDelegate)new BaseVideoItemDelegateProxy(paramBaseVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl.BaseVideoItemDelegateProxyFactoryImpl
 * JD-Core Version:    0.7.0.1
 */