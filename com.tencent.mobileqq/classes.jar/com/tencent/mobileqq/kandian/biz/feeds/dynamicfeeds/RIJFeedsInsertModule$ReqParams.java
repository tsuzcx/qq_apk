package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule$ReqParams;", "", "()V", "channelId", "", "getChannelId", "()J", "setChannelId", "(J)V", "followPuin", "", "getFollowPuin", "()Ljava/lang/String;", "setFollowPuin", "(Ljava/lang/String;)V", "lastClickArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getLastClickArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setLastClickArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "reqRecommendFlag", "", "getReqRecommendFlag", "()I", "setReqRecommendFlag", "(I)V", "updateTimes", "getUpdateTimes", "setUpdateTimes", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertModule$ReqParams
{
  private long a;
  @NotNull
  private String b = "";
  private int c = 1;
  private int d = 1;
  @Nullable
  private AbsBaseArticleInfo e;
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.e = paramAbsBaseArticleInfo;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  @Nullable
  public final AbsBaseArticleInfo e()
  {
    return this.e;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", followPuin = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", updateTimes = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", reqRecommendFlag = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", lastClickArticleInfo = ");
    Object localObject = this.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule.ReqParams
 * JD-Core Version:    0.7.0.1
 */