package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule$ReqParams;", "", "()V", "channelId", "", "getChannelId", "()J", "setChannelId", "(J)V", "followPuin", "", "getFollowPuin", "()Ljava/lang/String;", "setFollowPuin", "(Ljava/lang/String;)V", "lastClickArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getLastClickArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setLastClickArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "reqRecommendFlag", "", "getReqRecommendFlag", "()I", "setReqRecommendFlag", "(I)V", "updateTimes", "getUpdateTimes", "setUpdateTimes", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertModule$ReqParams
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  @Nullable
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 1;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", followPuin = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", updateTimes = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", reqRecommendFlag = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", lastClickArticleInfo = ");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null) {
      localObject = RIJFeedsInsertUtil.a.a((AbsBaseArticleInfo)localObject);
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(' ');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule.ReqParams
 * JD-Core Version:    0.7.0.1
 */