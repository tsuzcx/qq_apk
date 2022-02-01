package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "", "title", "", "subTitle", "accountId", "nickName", "headUrl", "negativeText", "positiveText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getHeadUrl", "getNegativeText", "getNickName", "getPositiveText", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BindAccountInfo
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @NotNull
  private final String g;
  
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
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof BindAccountInfo))
      {
        paramObject = (BindAccountInfo)paramObject;
        if ((!Intrinsics.areEqual(this.a, paramObject.a)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.d, paramObject.d)) || (!Intrinsics.areEqual(this.e, paramObject.e)) || (!Intrinsics.areEqual(this.f, paramObject.f)) || (!Intrinsics.areEqual(this.g, paramObject.g))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  @NotNull
  public final String g()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    String str = this.a;
    int i;
    int j;
    label37:
    int k;
    label54:
    int m;
    label72:
    int n;
    if (str != null)
    {
      i = str.hashCode();
      str = this.b;
      if (str == null) {
        break label167;
      }
      j = str.hashCode();
      str = this.c;
      if (str == null) {
        break label172;
      }
      k = str.hashCode();
      str = this.d;
      if (str == null) {
        break label177;
      }
      m = str.hashCode();
      str = this.e;
      if (str == null) {
        break label183;
      }
      n = str.hashCode();
      label90:
      str = this.f;
      if (str == null) {
        break label189;
      }
    }
    label167:
    label172:
    label177:
    label183:
    label189:
    for (int i1 = str.hashCode();; i1 = 0)
    {
      str = this.g;
      if (str != null) {
        i2 = str.hashCode();
      }
      return (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label54;
      m = 0;
      break label72;
      n = 0;
      break label90;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "BindAccountInfo(title=" + this.a + ", subTitle=" + this.b + ", accountId=" + this.c + ", nickName=" + this.d + ", headUrl=" + this.e + ", negativeText=" + this.f + ", positiveText=" + this.g + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.BindAccountInfo
 * JD-Core Version:    0.7.0.1
 */