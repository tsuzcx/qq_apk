package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater$Companion;", "", "()V", "mapping", "", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "getUpdater", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdater$Companion
{
  @JvmStatic
  @Nullable
  public final LongContentInfoUpdater a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Map localMap = LongContentInfoUpdater.f();
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.L;
      if (paramAbsBaseArticleInfo != null)
      {
        paramAbsBaseArticleInfo = Integer.valueOf(paramAbsBaseArticleInfo.a);
        break label41;
      }
    }
    paramAbsBaseArticleInfo = null;
    label41:
    return (LongContentInfoUpdater)localMap.get(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdater.Companion
 * JD-Core Version:    0.7.0.1
 */