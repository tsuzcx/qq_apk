package com.tencent.tkd.topicsdk.bean;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "", "accountType", "", "avatarUrl", "", "name", "uid", "sex", "homePageUrl", "timeStamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getAccountType", "()I", "getAvatarUrl", "()Ljava/lang/String;", "getHomePageUrl", "getName", "getSex", "getTimeStamp", "()J", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class AtPersonItem
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
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
      if ((paramObject instanceof AtPersonItem))
      {
        paramObject = (AtPersonItem)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long)) {}
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
    int n = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.jdField_a_of_type_Int);
    String str = this.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.jdField_b_of_type_JavaLangString;
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
    int i1 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.jdField_b_of_type_Int);
    str = this.d;
    if (str != null) {
      m = str.hashCode();
    }
    return (((((n * 31 + i) * 31 + j) * 31 + k) * 31 + i1) * 31 + m) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.jdField_a_of_type_Long);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AtPersonItem(accountType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", avatarUrl=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sex=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", homePageUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.AtPersonItem
 * JD-Core Version:    0.7.0.1
 */