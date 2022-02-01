package com.tencent.mobileqq.kandian.biz.xtab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuideViewModel$HomepageGuideData;", "", "guideText", "", "jumpUrl", "duration", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDuration", "()I", "getGuideText", "()Ljava/lang/String;", "getJumpUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeGuideViewModel$HomepageGuideData
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  private final int c;
  
  public KDXTabHomepageModeGuideViewModel$HomepageGuideData(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HomepageGuideData))
      {
        paramObject = (HomepageGuideData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c)) {}
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
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    if (str != null) {
      j = str.hashCode();
    }
    return (i * 31 + j) * 31 + this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomepageGuideData(guideText=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.KDXTabHomepageModeGuideViewModel.HomepageGuideData
 * JD-Core Version:    0.7.0.1
 */