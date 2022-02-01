package com.tencent.mobileqq.weather.webpage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WaterfallArk;", "", "appName", "", "appMeta", "appVersion", "appView", "pushType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppMeta", "()Ljava/lang/String;", "setAppMeta", "(Ljava/lang/String;)V", "getAppName", "getAppVersion", "getAppView", "getPushType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WaterfallArk
{
  @NotNull
  private final String a;
  @NotNull
  private String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  private final int e;
  
  public WaterfallArk(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
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
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WaterfallArk))
      {
        paramObject = (WaterfallArk)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e)) {}
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
    int m = 0;
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
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.d;
    if (str != null) {
      m = str.hashCode();
    }
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + this.e;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WaterfallArk(appName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appMeta=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appView=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", pushType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WaterfallArk
 * JD-Core Version:    0.7.0.1
 */