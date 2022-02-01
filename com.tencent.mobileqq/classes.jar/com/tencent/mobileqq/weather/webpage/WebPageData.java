package com.tencent.mobileqq.weather.webpage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WebPageData;", "", "event", "", "jsFunction", "", "jsParams", "bgUrl", "arkLoadState", "arkHeight", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getArkHeight", "()I", "getArkLoadState", "getBgUrl", "()Ljava/lang/String;", "getEvent", "getJsFunction", "getJsParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WebPageData
{
  public static final WebPageData.Companion a = new WebPageData.Companion(null);
  private final int b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  private final int f;
  private final int g;
  
  public WebPageData(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  @NotNull
  public final String b()
  {
    return this.c;
  }
  
  @NotNull
  public final String c()
  {
    return this.d;
  }
  
  @NotNull
  public final String d()
  {
    return this.e;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WebPageData))
      {
        paramObject = (WebPageData)paramObject;
        if ((this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f) && (this.g == paramObject.g)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int m = this.b;
    String str = this.c;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.d;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.e;
    if (str != null) {
      k = str.hashCode();
    }
    return ((((m * 31 + i) * 31 + j) * 31 + k) * 31 + this.f) * 31 + this.g;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebPageData(event=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jsFunction=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", jsParams=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", bgUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", arkLoadState=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", arkHeight=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WebPageData
 * JD-Core Version:    0.7.0.1
 */