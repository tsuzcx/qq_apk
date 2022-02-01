package com.tencent.mobileqq.util.privacy.handler;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/handler/BusinessData;", "", "packageName", "", "business", "(Ljava/lang/String;Ljava/lang/String;)V", "getBusiness", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class BusinessData
{
  public static final BusinessData.Companion a = new BusinessData.Companion(null);
  @NotNull
  private static final BusinessData d = new BusinessData("", "");
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public BusinessData(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BusinessData))
      {
        paramObject = (BusinessData)paramObject;
        if ((Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    String str = this.b;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.c;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BusinessData(packageName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", business=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.handler.BusinessData
 * JD-Core Version:    0.7.0.1
 */