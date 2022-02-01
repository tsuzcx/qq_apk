package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.api.IVideoCardUIModelFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/VideoCardUIModelFactoryImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IVideoCardUIModelFactory;", "()V", "createModel", "Lcom/tencent/mobileqq/kandian/repo/video/IVideoCardUIModel;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCardUIModelFactoryImpl
  implements IVideoCardUIModelFactory
{
  @Nullable
  public IVideoCardUIModel createModel(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return this.$$delegate_0.createModel(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.VideoCardUIModelFactoryImpl
 * JD-Core Version:    0.7.0.1
 */