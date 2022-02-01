package com.tencent.mobileqq.kandian.biz.push.component;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/component/RIJPushComponentExtData;", "", "articleIds", "", "foldStatus", "algorithmId", "strategyId", "subscripts", "pushExtData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushComponentExtData
{
  @JvmField
  @NotNull
  public String a;
  @JvmField
  @NotNull
  public byte[] a;
  @JvmField
  @NotNull
  public String b;
  @JvmField
  @NotNull
  public String c;
  @JvmField
  @NotNull
  public String d;
  @JvmField
  @NotNull
  public String e;
  
  public RIJPushComponentExtData()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public RIJPushComponentExtData(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((RIJPushComponentExtData)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (RIJPushComponentExtData)paramObject;
      if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString) ^ true)) {
        return false;
      }
      if ((Intrinsics.areEqual(this.b, paramObject.b) ^ true)) {
        return false;
      }
      if ((Intrinsics.areEqual(this.c, paramObject.c) ^ true)) {
        return false;
      }
      if ((Intrinsics.areEqual(this.d, paramObject.d) ^ true)) {
        return false;
      }
      if ((Intrinsics.areEqual(this.e, paramObject.e) ^ true)) {
        return false;
      }
      return Arrays.equals(this.jdField_a_of_type_ArrayOfByte, paramObject.jdField_a_of_type_ArrayOfByte);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtData");
  }
  
  public int hashCode()
  {
    return ((((this.jdField_a_of_type_JavaLangString.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + Arrays.hashCode(this.jdField_a_of_type_ArrayOfByte);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJPushComponentExtData(articleIds=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", foldStatus=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", algorithmId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", strategyId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", subscripts=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", pushExtData=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtData
 * JD-Core Version:    0.7.0.1
 */