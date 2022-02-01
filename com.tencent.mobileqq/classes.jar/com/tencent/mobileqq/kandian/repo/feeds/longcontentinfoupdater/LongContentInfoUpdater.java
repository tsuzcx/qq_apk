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
  public static final LongContentInfoUpdater.Companion a;
  private static final Map<Integer, LongContentInfoUpdater> jdField_a_of_type_JavaUtilMap = (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), new LongContentInfoUpdaterArticleOnePic()), TuplesKt.to(Integer.valueOf(3), new LongContentInfoUpdaterVideoSmallPic()), TuplesKt.to(Integer.valueOf(4), new LongContentInfoUpdaterShortContent()), TuplesKt.to(Integer.valueOf(2), new LongContentInfoUpdaterVideoBigPic()), TuplesKt.to(Integer.valueOf(5), new LongContentInfoUpdaterOutsideLink()) });
  @NotNull
  protected AbsBaseArticleInfo a;
  @Nullable
  private LongContentInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo;
  @Nullable
  private PGCFeedsInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo;
  @Nullable
  private SocializeFeedsInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsLongcontentinfoupdaterLongContentInfoUpdater$Companion = new LongContentInfoUpdater.Companion(null);
  }
  
  @JvmStatic
  @Nullable
  public static final LongContentInfoUpdater a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsLongcontentinfoupdaterLongContentInfoUpdater$Companion.a(paramAbsBaseArticleInfo);
  }
  
  @NotNull
  protected final AbsBaseArticleInfo a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    return localAbsBaseArticleInfo;
  }
  
  @Nullable
  protected final LongContentInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo;
  }
  
  @Nullable
  protected final PGCFeedsInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo;
  }
  
  @Nullable
  protected final SocializeFeedsInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
  }
  
  protected abstract void a();
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
    Object localObject = null;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo = paramAbsBaseArticleInfo;
    SocializeFeedsInfo localSocializeFeedsInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
    paramAbsBaseArticleInfo = localObject;
    if (localSocializeFeedsInfo != null) {
      paramAbsBaseArticleInfo = localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo = paramAbsBaseArticleInfo;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdater
 * JD-Core Version:    0.7.0.1
 */