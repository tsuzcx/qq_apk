package com.tencent.mobileqq.vas.adv.qzone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "", "advPos", "", "actionType", "actionValue", "feedIndex", "uin", "", "subscribeId", "", "recommendCookie", "(IIIIJLjava/lang/String;Ljava/lang/String;)V", "getActionType", "()I", "getActionValue", "getAdvPos", "getFeedIndex", "getRecommendCookie", "()Ljava/lang/String;", "getSubscribeId", "getUin", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class VasAdMetaReportParam
{
  private final int actionType;
  private final int actionValue;
  private final int advPos;
  private final int feedIndex;
  @NotNull
  private final String recommendCookie;
  @Nullable
  private final String subscribeId;
  private final long uin;
  
  public VasAdMetaReportParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, @Nullable String paramString1, @NotNull String paramString2)
  {
    this.advPos = paramInt1;
    this.actionType = paramInt2;
    this.actionValue = paramInt3;
    this.feedIndex = paramInt4;
    this.uin = paramLong;
    this.subscribeId = paramString1;
    this.recommendCookie = paramString2;
  }
  
  public final int component1()
  {
    return this.advPos;
  }
  
  public final int component2()
  {
    return this.actionType;
  }
  
  public final int component3()
  {
    return this.actionValue;
  }
  
  public final int component4()
  {
    return this.feedIndex;
  }
  
  public final long component5()
  {
    return this.uin;
  }
  
  @Nullable
  public final String component6()
  {
    return this.subscribeId;
  }
  
  @NotNull
  public final String component7()
  {
    return this.recommendCookie;
  }
  
  @NotNull
  public final VasAdMetaReportParam copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "recommendCookie");
    return new VasAdMetaReportParam(paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramString1, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasAdMetaReportParam))
      {
        paramObject = (VasAdMetaReportParam)paramObject;
        if ((this.advPos == paramObject.advPos) && (this.actionType == paramObject.actionType) && (this.actionValue == paramObject.actionValue) && (this.feedIndex == paramObject.feedIndex) && (this.uin == paramObject.uin) && (Intrinsics.areEqual(this.subscribeId, paramObject.subscribeId)) && (Intrinsics.areEqual(this.recommendCookie, paramObject.recommendCookie))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getActionType()
  {
    return this.actionType;
  }
  
  public final int getActionValue()
  {
    return this.actionValue;
  }
  
  public final int getAdvPos()
  {
    return this.advPos;
  }
  
  public final int getFeedIndex()
  {
    return this.feedIndex;
  }
  
  @NotNull
  public final String getRecommendCookie()
  {
    return this.recommendCookie;
  }
  
  @Nullable
  public final String getSubscribeId()
  {
    return this.subscribeId;
  }
  
  public final long getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    int k = this.advPos;
    int m = this.actionType;
    int n = this.actionValue;
    int i1 = this.feedIndex;
    long l = this.uin;
    int i2 = (int)(l ^ l >>> 32);
    String str = this.subscribeId;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.recommendCookie;
    if (str != null) {
      j = str.hashCode();
    }
    return (((((k * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasAdMetaReportParam(advPos=");
    localStringBuilder.append(this.advPos);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append(", actionValue=");
    localStringBuilder.append(this.actionValue);
    localStringBuilder.append(", feedIndex=");
    localStringBuilder.append(this.feedIndex);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", subscribeId=");
    localStringBuilder.append(this.subscribeId);
    localStringBuilder.append(", recommendCookie=");
    localStringBuilder.append(this.recommendCookie);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam
 * JD-Core Version:    0.7.0.1
 */