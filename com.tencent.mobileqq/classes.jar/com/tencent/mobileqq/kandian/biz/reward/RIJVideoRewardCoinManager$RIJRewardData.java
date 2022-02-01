package com.tencent.mobileqq.kandian.biz.reward;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$RIJRewardData;", "", "rowkey", "", "status", "", "(Ljava/lang/String;I)V", "getRowkey", "()Ljava/lang/String;", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager$RIJRewardData
{
  @NotNull
  private final String a;
  private final int b;
  
  public RIJVideoRewardCoinManager$RIJRewardData(@NotNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJRewardData))
      {
        paramObject = (RIJRewardData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
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
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJRewardData(rowkey=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardData
 * JD-Core Version:    0.7.0.1
 */