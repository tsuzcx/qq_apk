package com.tencent.mobileqq.vas.adv.base.service;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "", "uin", "", "posIdList", "", "", "count", "", "deepLinkVersion", "publicId", "articleId", "tribeTag", "tribeIdTag", "sourceFrom", "shareRate", "cookie", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCookie", "()Ljava/lang/String;", "getCount", "()I", "getDeepLinkVersion", "getPosIdList", "()Ljava/util/Set;", "getPublicId", "getShareRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceFrom", "getTribeIdTag", "getTribeTag", "getUin", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "equals", "", "other", "hashCode", "toString", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasGdtService$GdtParams
{
  private final long a;
  @NotNull
  private final Set<String> b;
  private final int c;
  private final int d;
  @Nullable
  private final Long e;
  @Nullable
  private final Long f;
  @Nullable
  private final Integer g;
  @Nullable
  private final Integer h;
  @Nullable
  private final Integer i;
  @Nullable
  private final Integer j;
  @Nullable
  private final String k;
  
  public VasGdtService$GdtParams(long paramLong, @NotNull Set<String> paramSet, int paramInt1, int paramInt2, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable String paramString)
  {
    this.a = paramLong;
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramInteger1;
    this.h = paramInteger2;
    this.i = paramInteger3;
    this.j = paramInteger4;
    this.k = paramString;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  @NotNull
  public final Set<String> b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  @Nullable
  public final Long e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GdtParams))
      {
        paramObject = (GdtParams)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (Intrinsics.areEqual(this.j, paramObject.j)) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final Long f()
  {
    return this.f;
  }
  
  @Nullable
  public final Integer g()
  {
    return this.h;
  }
  
  @Nullable
  public final Integer h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i7 = (int)(l ^ l >>> 32);
    Object localObject = this.b;
    int i6 = 0;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    int i8 = this.c;
    int i9 = this.d;
    localObject = this.e;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.f;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.g;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.h;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.i;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.j;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.k;
    if (localObject != null) {
      i6 = localObject.hashCode();
    }
    return (((((((((i7 * 31 + m) * 31 + i8) * 31 + i9) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
  }
  
  @Nullable
  public final Integer i()
  {
    return this.j;
  }
  
  @Nullable
  public final String j()
  {
    return this.k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GdtParams(uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", posIdList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", deepLinkVersion=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", publicId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", articleId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", tribeTag=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", tribeIdTag=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", sourceFrom=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", shareRate=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", cookie=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtParams
 * JD-Core Version:    0.7.0.1
 */