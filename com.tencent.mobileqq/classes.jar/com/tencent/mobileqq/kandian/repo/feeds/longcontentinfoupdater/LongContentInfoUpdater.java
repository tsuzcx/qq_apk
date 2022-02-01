package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "", "()V", "feedsInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;", "getFeedsInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;", "setFeedsInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;)V", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "longContentInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/LongContentInfo;", "getLongContentInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/LongContentInfo;", "setLongContentInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/LongContentInfo;)V", "pgcFeedsInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/PGCFeedsInfo;", "getPgcFeedsInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/PGCFeedsInfo;", "setPgcFeedsInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/PGCFeedsInfo;)V", "process", "", "update", "articleInfo", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class LongContentInfoUpdater
{
  public static final LongContentInfoUpdater.Companion b = new LongContentInfoUpdater.Companion(null);
  private static final Map<Integer, LongContentInfoUpdater> f = (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), new LongContentInfoUpdaterArticleOnePic()), TuplesKt.to(Integer.valueOf(3), new LongContentInfoUpdaterVideoSmallPic()), TuplesKt.to(Integer.valueOf(4), new LongContentInfoUpdaterShortContent()), TuplesKt.to(Integer.valueOf(2), new LongContentInfoUpdaterVideoBigPic()), TuplesKt.to(Integer.valueOf(5), new LongContentInfoUpdaterOutsideLink()) });
  @NotNull
  protected AbsBaseArticleInfo a;
  @Nullable
  private SocializeFeedsInfo c;
  @Nullable
  private LongContentInfo d;
  @Nullable
  private PGCFeedsInfo e;
  
  @JvmStatic
  @Nullable
  public static final LongContentInfoUpdater b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return b.a(paramAbsBaseArticleInfo);
  }
  
  @NotNull
  protected final AbsBaseArticleInfo a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if (localAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    return localAbsBaseArticleInfo;
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    this.a = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.a;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    this.c = paramAbsBaseArticleInfo.mSocialFeedInfo;
    paramAbsBaseArticleInfo = this.c;
    Object localObject = null;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.L;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = this.c;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.L;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    this.d = paramAbsBaseArticleInfo;
    SocializeFeedsInfo localSocializeFeedsInfo = this.c;
    paramAbsBaseArticleInfo = localObject;
    if (localSocializeFeedsInfo != null) {
      paramAbsBaseArticleInfo = localSocializeFeedsInfo.t;
    }
    this.e = paramAbsBaseArticleInfo;
    e();
  }
  
  @Nullable
  protected final SocializeFeedsInfo b()
  {
    return this.c;
  }
  
  @Nullable
  protected final LongContentInfo c()
  {
    return this.d;
  }
  
  @Nullable
  protected final PGCFeedsInfo d()
  {
    return this.e;
  }
  
  protected abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdater
 * JD-Core Version:    0.7.0.1
 */