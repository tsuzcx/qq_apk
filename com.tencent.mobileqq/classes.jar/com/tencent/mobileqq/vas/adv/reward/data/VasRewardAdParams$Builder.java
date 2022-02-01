package com.tencent.mobileqq.vas.adv.reward.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams$Builder;", "", "()V", "advPos", "", "getAdvPos", "()Ljava/lang/Integer;", "setAdvPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bizSrcId", "", "getBizSrcId", "()Ljava/lang/String;", "setBizSrcId", "(Ljava/lang/String;)V", "gdtBizId", "getGdtBizId", "setGdtBizId", "rewardItem", "getRewardItem", "setRewardItem", "rewardText", "getRewardText", "setRewardText", "rewardType", "getRewardType", "setRewardType", "uin", "", "getUin", "()Ljava/lang/Long;", "setUin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdParams$Builder
{
  @Nullable
  private Integer advPos;
  @Nullable
  private String bizSrcId;
  @Nullable
  private String gdtBizId;
  @Nullable
  private String rewardItem;
  @Nullable
  private String rewardText;
  @Nullable
  private Integer rewardType;
  @Nullable
  private Long uin;
  
  @NotNull
  public final VasRewardAdParams build()
  {
    Object localObject = this.advPos;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i = ((Integer)localObject).intValue();
    localObject = this.rewardType;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int j = ((Integer)localObject).intValue();
    String str2 = this.rewardItem;
    if (str2 == null) {
      Intrinsics.throwNpe();
    }
    String str3 = this.rewardText;
    localObject = this.uin;
    long l;
    if (localObject != null)
    {
      l = ((Long)localObject).longValue();
    }
    else
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
      l = ((AppRuntime)localObject).getLongAccountUin();
    }
    localObject = this.gdtBizId;
    if (localObject == null) {
      localObject = "1018ec";
    }
    String str1 = this.bizSrcId;
    if (str1 == null) {
      str1 = "biz_src_jc_vip";
    }
    return new VasRewardAdParams(i, j, str2, str3, l, (String)localObject, str1);
  }
  
  @Nullable
  public final Integer getAdvPos()
  {
    return this.advPos;
  }
  
  @Nullable
  public final String getBizSrcId()
  {
    return this.bizSrcId;
  }
  
  @Nullable
  public final String getGdtBizId()
  {
    return this.gdtBizId;
  }
  
  @Nullable
  public final String getRewardItem()
  {
    return this.rewardItem;
  }
  
  @Nullable
  public final String getRewardText()
  {
    return this.rewardText;
  }
  
  @Nullable
  public final Integer getRewardType()
  {
    return this.rewardType;
  }
  
  @Nullable
  public final Long getUin()
  {
    return this.uin;
  }
  
  public final void setAdvPos(@Nullable Integer paramInteger)
  {
    this.advPos = paramInteger;
  }
  
  public final void setBizSrcId(@Nullable String paramString)
  {
    this.bizSrcId = paramString;
  }
  
  public final void setGdtBizId(@Nullable String paramString)
  {
    this.gdtBizId = paramString;
  }
  
  public final void setRewardItem(@Nullable String paramString)
  {
    this.rewardItem = paramString;
  }
  
  public final void setRewardText(@Nullable String paramString)
  {
    this.rewardText = paramString;
  }
  
  public final void setRewardType(@Nullable Integer paramInteger)
  {
    this.rewardType = paramInteger;
  }
  
  public final void setUin(@Nullable Long paramLong)
  {
    this.uin = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams.Builder
 * JD-Core Version:    0.7.0.1
 */