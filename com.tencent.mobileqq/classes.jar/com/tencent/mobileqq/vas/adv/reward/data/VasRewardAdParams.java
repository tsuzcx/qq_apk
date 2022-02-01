package com.tencent.mobileqq.vas.adv.reward.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "", "advPos", "", "rewardType", "rewardItem", "", "rewardText", "uin", "", "gdtBizId", "bizSrcId", "(IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAdvPos", "()I", "getBizSrcId", "()Ljava/lang/String;", "getGdtBizId", "getRewardItem", "getRewardText", "getRewardType", "getUin", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdParams
{
  private final int advPos;
  @NotNull
  private final String bizSrcId;
  @NotNull
  private final String gdtBizId;
  @NotNull
  private final String rewardItem;
  @Nullable
  private final String rewardText;
  private final int rewardType;
  private final long uin;
  
  public VasRewardAdParams(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, long paramLong, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.advPos = paramInt1;
    this.rewardType = paramInt2;
    this.rewardItem = paramString1;
    this.rewardText = paramString2;
    this.uin = paramLong;
    this.gdtBizId = paramString3;
    this.bizSrcId = paramString4;
  }
  
  public final int component1()
  {
    return this.advPos;
  }
  
  public final int component2()
  {
    return this.rewardType;
  }
  
  @NotNull
  public final String component3()
  {
    return this.rewardItem;
  }
  
  @Nullable
  public final String component4()
  {
    return this.rewardText;
  }
  
  public final long component5()
  {
    return this.uin;
  }
  
  @NotNull
  public final String component6()
  {
    return this.gdtBizId;
  }
  
  @NotNull
  public final String component7()
  {
    return this.bizSrcId;
  }
  
  @NotNull
  public final VasRewardAdParams copy(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, long paramLong, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rewardItem");
    Intrinsics.checkParameterIsNotNull(paramString3, "gdtBizId");
    Intrinsics.checkParameterIsNotNull(paramString4, "bizSrcId");
    return new VasRewardAdParams(paramInt1, paramInt2, paramString1, paramString2, paramLong, paramString3, paramString4);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasRewardAdParams))
      {
        paramObject = (VasRewardAdParams)paramObject;
        if ((this.advPos == paramObject.advPos) && (this.rewardType == paramObject.rewardType) && (Intrinsics.areEqual(this.rewardItem, paramObject.rewardItem)) && (Intrinsics.areEqual(this.rewardText, paramObject.rewardText)) && (this.uin == paramObject.uin) && (Intrinsics.areEqual(this.gdtBizId, paramObject.gdtBizId)) && (Intrinsics.areEqual(this.bizSrcId, paramObject.bizSrcId))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getAdvPos()
  {
    return this.advPos;
  }
  
  @NotNull
  public final String getBizSrcId()
  {
    return this.bizSrcId;
  }
  
  @NotNull
  public final String getGdtBizId()
  {
    return this.gdtBizId;
  }
  
  @NotNull
  public final String getRewardItem()
  {
    return this.rewardItem;
  }
  
  @Nullable
  public final String getRewardText()
  {
    return this.rewardText;
  }
  
  public final int getRewardType()
  {
    return this.rewardType;
  }
  
  public final long getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    int n = this.advPos;
    int i1 = this.rewardType;
    String str = this.rewardItem;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.rewardText;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    long l = this.uin;
    int i2 = (int)(l ^ l >>> 32);
    str = this.gdtBizId;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.bizSrcId;
    if (str != null) {
      m = str.hashCode();
    }
    return (((((n * 31 + i1) * 31 + i) * 31 + j) * 31 + i2) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasRewardAdParams(advPos=");
    localStringBuilder.append(this.advPos);
    localStringBuilder.append(", rewardType=");
    localStringBuilder.append(this.rewardType);
    localStringBuilder.append(", rewardItem=");
    localStringBuilder.append(this.rewardItem);
    localStringBuilder.append(", rewardText=");
    localStringBuilder.append(this.rewardText);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", gdtBizId=");
    localStringBuilder.append(this.gdtBizId);
    localStringBuilder.append(", bizSrcId=");
    localStringBuilder.append(this.bizSrcId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams
 * JD-Core Version:    0.7.0.1
 */