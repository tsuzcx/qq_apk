package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$RIJRewardInfo;", "", "articleID", "", "accountUin", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;)V", "getAccountUin", "()Ljava/lang/String;", "setAccountUin", "(Ljava/lang/String;)V", "getArticleID", "getVideoInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager$RIJRewardInfo
{
  @Nullable
  private final String a;
  @Nullable
  private String b;
  @Nullable
  private final VideoInfo c;
  
  public RIJVideoRewardCoinManager$RIJRewardInfo()
  {
    this(null, null, null, 7, null);
  }
  
  public RIJVideoRewardCoinManager$RIJRewardInfo(@Nullable String paramString1, @Nullable String paramString2, @Nullable VideoInfo paramVideoInfo)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramVideoInfo;
  }
  
  @Nullable
  public final String a()
  {
    return this.a;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @Nullable
  public final VideoInfo c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJRewardInfo))
      {
        paramObject = (RIJRewardInfo)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJRewardInfo(articleID=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", accountUin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", videoInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardInfo
 * JD-Core Version:    0.7.0.1
 */