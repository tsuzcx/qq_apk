package com.tencent.mobileqq.wxmini.impl.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$WxaInfo;", "", "appId", "", "appNickname", "iconUrl", "versionType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getAppNickname", "getIconUrl", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DemoWxaListActivity$WxaInfo
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @Nullable
  private final String c;
  private final int d;
  
  public DemoWxaListActivity$WxaInfo(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt;
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
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WxaInfo))
      {
        paramObject = (WxaInfo)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d)) {}
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
    return ((i * 31 + j) * 31 + k) * 31 + this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaInfo(appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appNickname=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.WxaInfo
 * JD-Core Version:    0.7.0.1
 */