package com.tencent.tkd.weibo.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "", "accountType", "", "avatarUrl", "", "name", "uid", "sex", "homePageUrl", "timeStamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getAccountType", "()I", "getAvatarUrl", "()Ljava/lang/String;", "getHomePageUrl", "getName", "getSex", "getTimeStamp", "()J", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
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
    if (this != paramObject)
    {
      if ((paramObject instanceof AtPersonItem))
      {
        paramObject = (AtPersonItem)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (!Intrinsics.areEqual(this.d, paramObject.d)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.jdField_b_of_type_JavaLangString;
      if (str == null) {
        break label138;
      }
      j = str.hashCode();
      label43:
      str = this.c;
      if (str == null) {
        break label143;
      }
    }
    label138:
    label143:
    for (int k = str.hashCode();; k = 0)
    {
      int i1 = this.jdField_b_of_type_Int;
      str = this.d;
      if (str != null) {
        m = str.hashCode();
      }
      long l = this.jdField_a_of_type_Long;
      return (((k + (j + (i + n * 31) * 31) * 31) * 31 + i1) * 31 + m) * 31 + (int)(l ^ l >>> 32);
      i = 0;
      break;
      j = 0;
      break label43;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "AtPersonItem(accountType=" + this.jdField_a_of_type_Int + ", avatarUrl=" + this.jdField_a_of_type_JavaLangString + ", name=" + this.jdField_b_of_type_JavaLangString + ", uid=" + this.c + ", sex=" + this.jdField_b_of_type_Int + ", homePageUrl=" + this.d + ", timeStamp=" + this.jdField_a_of_type_Long + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.AtPersonItem
 * JD-Core Version:    0.7.0.1
 */