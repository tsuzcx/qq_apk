package com.tencent.mobileqq.kandian.repo.tab;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "Ljava/io/Serializable;", "", "algorithmIds", "", "strategyIds", "folderStatus", "articleIds", "arrivedTime", "", "channelId", "", "priorityChannelId", "uin", "isBig", "", "redDotPassThroughInfo", "exposureTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJZLjava/lang/String;J)V", "getAlgorithmIds", "()Ljava/lang/String;", "getArrivedTime", "()J", "getArticleIds", "getChannelId", "()I", "getExposureTime", "setExposureTime", "(J)V", "getFolderStatus", "()Z", "getPriorityChannelId", "getRedDotPassThroughInfo", "getStrategyIds", "getUin", "compareTo", "other", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "hashCode", "toString", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabRedDotInfo
  implements Serializable, Comparable<RIJXTabRedDotInfo>
{
  public static final RIJXTabRedDotInfo.Companion Companion = new RIJXTabRedDotInfo.Companion(null);
  public static final long INVALID_TIME = -1L;
  public static final long serialVersionUID = 1L;
  @NotNull
  private final String algorithmIds;
  private final long arrivedTime;
  @NotNull
  private final String articleIds;
  private final int channelId;
  private long exposureTime;
  @NotNull
  private final String folderStatus;
  private final boolean isBig;
  private final int priorityChannelId;
  @Nullable
  private final String redDotPassThroughInfo;
  @NotNull
  private final String strategyIds;
  private final long uin;
  
  public RIJXTabRedDotInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, @Nullable String paramString5, long paramLong3)
  {
    this.algorithmIds = paramString1;
    this.strategyIds = paramString2;
    this.folderStatus = paramString3;
    this.articleIds = paramString4;
    this.arrivedTime = paramLong1;
    this.channelId = paramInt1;
    this.priorityChannelId = paramInt2;
    this.uin = paramLong2;
    this.isBig = paramBoolean;
    this.redDotPassThroughInfo = paramString5;
    this.exposureTime = paramLong3;
  }
  
  public int compareTo(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "other");
    return (int)(this.arrivedTime - paramRIJXTabRedDotInfo.arrivedTime);
  }
  
  @NotNull
  public final String component1()
  {
    return this.algorithmIds;
  }
  
  @Nullable
  public final String component10()
  {
    return this.redDotPassThroughInfo;
  }
  
  public final long component11()
  {
    return this.exposureTime;
  }
  
  @NotNull
  public final String component2()
  {
    return this.strategyIds;
  }
  
  @NotNull
  public final String component3()
  {
    return this.folderStatus;
  }
  
  @NotNull
  public final String component4()
  {
    return this.articleIds;
  }
  
  public final long component5()
  {
    return this.arrivedTime;
  }
  
  public final int component6()
  {
    return this.channelId;
  }
  
  public final int component7()
  {
    return this.priorityChannelId;
  }
  
  public final long component8()
  {
    return this.uin;
  }
  
  public final boolean component9()
  {
    return this.isBig;
  }
  
  @NotNull
  public final RIJXTabRedDotInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, @Nullable String paramString5, long paramLong3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "algorithmIds");
    Intrinsics.checkParameterIsNotNull(paramString2, "strategyIds");
    Intrinsics.checkParameterIsNotNull(paramString3, "folderStatus");
    Intrinsics.checkParameterIsNotNull(paramString4, "articleIds");
    return new RIJXTabRedDotInfo(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramInt2, paramLong2, paramBoolean, paramString5, paramLong3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJXTabRedDotInfo))
      {
        paramObject = (RIJXTabRedDotInfo)paramObject;
        if ((Intrinsics.areEqual(this.algorithmIds, paramObject.algorithmIds)) && (Intrinsics.areEqual(this.strategyIds, paramObject.strategyIds)) && (Intrinsics.areEqual(this.folderStatus, paramObject.folderStatus)) && (Intrinsics.areEqual(this.articleIds, paramObject.articleIds)) && (this.arrivedTime == paramObject.arrivedTime) && (this.channelId == paramObject.channelId) && (this.priorityChannelId == paramObject.priorityChannelId) && (this.uin == paramObject.uin) && (this.isBig == paramObject.isBig) && (Intrinsics.areEqual(this.redDotPassThroughInfo, paramObject.redDotPassThroughInfo)) && (this.exposureTime == paramObject.exposureTime)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getAlgorithmIds()
  {
    return this.algorithmIds;
  }
  
  public final long getArrivedTime()
  {
    return this.arrivedTime;
  }
  
  @NotNull
  public final String getArticleIds()
  {
    return this.articleIds;
  }
  
  public final int getChannelId()
  {
    return this.channelId;
  }
  
  public final long getExposureTime()
  {
    return this.exposureTime;
  }
  
  @NotNull
  public final String getFolderStatus()
  {
    return this.folderStatus;
  }
  
  public final int getPriorityChannelId()
  {
    return this.priorityChannelId;
  }
  
  @Nullable
  public final String getRedDotPassThroughInfo()
  {
    return this.redDotPassThroughInfo;
  }
  
  @NotNull
  public final String getStrategyIds()
  {
    return this.strategyIds;
  }
  
  public final long getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isBig()
  {
    return this.isBig;
  }
  
  public final void setExposureTime(long paramLong)
  {
    this.exposureTime = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJXTabRedDotInfo(algorithmIds=");
    localStringBuilder.append(this.algorithmIds);
    localStringBuilder.append(", strategyIds=");
    localStringBuilder.append(this.strategyIds);
    localStringBuilder.append(", folderStatus=");
    localStringBuilder.append(this.folderStatus);
    localStringBuilder.append(", articleIds=");
    localStringBuilder.append(this.articleIds);
    localStringBuilder.append(", arrivedTime=");
    localStringBuilder.append(this.arrivedTime);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append(", priorityChannelId=");
    localStringBuilder.append(this.priorityChannelId);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", isBig=");
    localStringBuilder.append(this.isBig);
    localStringBuilder.append(", redDotPassThroughInfo=");
    localStringBuilder.append(this.redDotPassThroughInfo);
    localStringBuilder.append(", exposureTime=");
    localStringBuilder.append(this.exposureTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo
 * JD-Core Version:    0.7.0.1
 */