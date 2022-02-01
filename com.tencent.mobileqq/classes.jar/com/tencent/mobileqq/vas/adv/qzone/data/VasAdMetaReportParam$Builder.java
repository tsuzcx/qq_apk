package com.tencent.mobileqq.vas.adv.qzone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam$Builder;", "", "()V", "actionType", "", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "actionValue", "getActionValue", "setActionValue", "advPos", "getAdvPos", "setAdvPos", "feedIndex", "getFeedIndex", "setFeedIndex", "recommendCookie", "", "getRecommendCookie", "()Ljava/lang/String;", "setRecommendCookie", "(Ljava/lang/String;)V", "subscribeId", "getSubscribeId", "setSubscribeId", "uin", "", "getUin", "()Ljava/lang/Long;", "setUin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class VasAdMetaReportParam$Builder
{
  @Nullable
  private Integer actionType;
  @Nullable
  private Integer actionValue;
  @Nullable
  private Integer advPos;
  @Nullable
  private Integer feedIndex;
  @Nullable
  private String recommendCookie;
  @Nullable
  private String subscribeId;
  @Nullable
  private Long uin;
  
  @NotNull
  public final VasAdMetaReportParam build()
  {
    Object localObject = this.advPos;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i = ((Integer)localObject).intValue();
    localObject = this.actionType;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int j = ((Integer)localObject).intValue();
    localObject = this.actionValue;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int k = ((Integer)localObject).intValue();
    localObject = this.feedIndex;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int m = ((Integer)localObject).intValue();
    localObject = this.uin;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    long l = ((Long)localObject).longValue();
    localObject = this.subscribeId;
    String str = this.recommendCookie;
    if (str == null) {
      Intrinsics.throwNpe();
    }
    return new VasAdMetaReportParam(i, j, k, m, l, (String)localObject, str);
  }
  
  @Nullable
  public final Integer getActionType()
  {
    return this.actionType;
  }
  
  @Nullable
  public final Integer getActionValue()
  {
    return this.actionValue;
  }
  
  @Nullable
  public final Integer getAdvPos()
  {
    return this.advPos;
  }
  
  @Nullable
  public final Integer getFeedIndex()
  {
    return this.feedIndex;
  }
  
  @Nullable
  public final String getRecommendCookie()
  {
    return this.recommendCookie;
  }
  
  @Nullable
  public final String getSubscribeId()
  {
    return this.subscribeId;
  }
  
  @Nullable
  public final Long getUin()
  {
    return this.uin;
  }
  
  public final void setActionType(@Nullable Integer paramInteger)
  {
    this.actionType = paramInteger;
  }
  
  public final void setActionValue(@Nullable Integer paramInteger)
  {
    this.actionValue = paramInteger;
  }
  
  public final void setAdvPos(@Nullable Integer paramInteger)
  {
    this.advPos = paramInteger;
  }
  
  public final void setFeedIndex(@Nullable Integer paramInteger)
  {
    this.feedIndex = paramInteger;
  }
  
  public final void setRecommendCookie(@Nullable String paramString)
  {
    this.recommendCookie = paramString;
  }
  
  public final void setSubscribeId(@Nullable String paramString)
  {
    this.subscribeId = paramString;
  }
  
  public final void setUin(@Nullable Long paramLong)
  {
    this.uin = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam.Builder
 * JD-Core Version:    0.7.0.1
 */