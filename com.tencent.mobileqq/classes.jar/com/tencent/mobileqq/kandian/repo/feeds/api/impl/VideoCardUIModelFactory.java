package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.api.IVideoCardUIModelFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.CommonVideoCardUIModel;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import com.tencent.mobileqq.kandian.repo.video.UGCVideoCardUIModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/VideoCardUIModelFactory;", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IVideoCardUIModelFactory;", "()V", "COMMON", "", "UGC_TO_PGC", "createModel", "Lcom/tencent/mobileqq/kandian/repo/video/IVideoCardUIModel;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getModelByType", "modelType", "isToCompatPgcVideo", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCardUIModelFactory
  implements IVideoCardUIModelFactory
{
  private static final int COMMON = 0;
  public static final VideoCardUIModelFactory INSTANCE = new VideoCardUIModelFactory();
  private static final int UGC_TO_PGC = 1;
  
  private final IVideoCardUIModel getModelByType(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    IVideoCardUIModel localIVideoCardUIModel = (IVideoCardUIModel)null;
    if (paramInt == COMMON) {
      return (IVideoCardUIModel)new CommonVideoCardUIModel(paramAbsBaseArticleInfo);
    }
    if (paramInt == UGC_TO_PGC) {
      localIVideoCardUIModel = (IVideoCardUIModel)new UGCVideoCardUIModel(paramAbsBaseArticleInfo);
    }
    return localIVideoCardUIModel;
  }
  
  private final boolean isToCompatPgcVideo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo));
  }
  
  @Nullable
  public IVideoCardUIModel createModel(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (isToCompatPgcVideo(paramAbsBaseArticleInfo)) {
      return getModelByType(UGC_TO_PGC, paramAbsBaseArticleInfo);
    }
    return getModelByType(COMMON, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.VideoCardUIModelFactory
 * JD-Core Version:    0.7.0.1
 */