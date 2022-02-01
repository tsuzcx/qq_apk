package com.tencent.mobileqq.vas.treasurecard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "", "orderUrl", "", "mageUrl", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMageUrl", "()Ljava/lang/String;", "getMessage", "getOrderUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasFtCard
{
  @Nullable
  private final String a;
  @Nullable
  private final String b;
  @Nullable
  private final String c;
  
  public VasFtCard(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasFtCard))
      {
        paramObject = (VasFtCard)paramObject;
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
    String str = this.a;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.c;
    if (str != null) {
      k = str.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasFtCard(orderUrl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mageUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.VasFtCard
 * JD-Core Version:    0.7.0.1
 */