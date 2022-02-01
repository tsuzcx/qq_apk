package com.tencent.mobileqq.vas.adv.base.service;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "", "uin", "", "posIdList", "", "", "count", "", "deepLinkVersion", "publicId", "articleId", "tribeTag", "tribeIdTag", "sourceFrom", "shareRate", "cookie", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCookie", "()Ljava/lang/String;", "getCount", "()I", "getDeepLinkVersion", "getPosIdList", "()Ljava/util/Set;", "getPublicId", "getShareRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceFrom", "getTribeIdTag", "getTribeTag", "getUin", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "equals", "", "other", "hashCode", "toString", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasGdtService$GdtParams
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @Nullable
  private final Integer jdField_a_of_type_JavaLangInteger;
  @Nullable
  private final Long jdField_a_of_type_JavaLangLong;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Set<String> jdField_a_of_type_JavaUtilSet;
  private final int jdField_b_of_type_Int;
  @Nullable
  private final Integer jdField_b_of_type_JavaLangInteger;
  @Nullable
  private final Long jdField_b_of_type_JavaLangLong;
  @Nullable
  private final Integer c;
  @Nullable
  private final Integer d;
  
  public VasGdtService$GdtParams(long paramLong, @NotNull Set<String> paramSet, int paramInt1, int paramInt2, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangLong = paramLong1;
    this.jdField_b_of_type_JavaLangLong = paramLong2;
    this.jdField_a_of_type_JavaLangInteger = paramInteger1;
    this.jdField_b_of_type_JavaLangInteger = paramInteger2;
    this.c = paramInteger3;
    this.d = paramInteger4;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final Integer a()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  @Nullable
  public final Long a()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Set<String> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final Integer b()
  {
    return this.c;
  }
  
  @Nullable
  public final Long b()
  {
    return this.jdField_b_of_type_JavaLangLong;
  }
  
  @Nullable
  public final Integer c()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GdtParams))
      {
        paramObject = (GdtParams)paramObject;
        if ((this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilSet, paramObject.jdField_a_of_type_JavaUtilSet)) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangLong, paramObject.jdField_a_of_type_JavaLangLong)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangLong, paramObject.jdField_b_of_type_JavaLangLong)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangInteger, paramObject.jdField_a_of_type_JavaLangInteger)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangInteger, paramObject.jdField_b_of_type_JavaLangInteger)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString))) {}
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
    long l = this.jdField_a_of_type_Long;
    int i4 = (int)(l ^ l >>> 32);
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    int i3 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int i5 = this.jdField_a_of_type_Int;
    int i6 = this.jdField_b_of_type_Int;
    localObject = this.jdField_a_of_type_JavaLangLong;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.jdField_b_of_type_JavaLangLong;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.jdField_a_of_type_JavaLangInteger;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.jdField_b_of_type_JavaLangInteger;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.c;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.d;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      i3 = localObject.hashCode();
    }
    return (((((((((i4 * 31 + i) * 31 + i5) * 31 + i6) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GdtParams(uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", posIdList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", deepLinkVersion=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", publicId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    localStringBuilder.append(", articleId=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangLong);
    localStringBuilder.append(", tribeTag=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangInteger);
    localStringBuilder.append(", tribeIdTag=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangInteger);
    localStringBuilder.append(", sourceFrom=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", shareRate=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", cookie=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtParams
 * JD-Core Version:    0.7.0.1
 */