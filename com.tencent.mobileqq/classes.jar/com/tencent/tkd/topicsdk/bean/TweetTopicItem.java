package com.tencent.tkd.topicsdk.bean;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "rowkey", "", "iconUrl", "name", "discussNum", "", "discussStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDiscussNum", "()J", "setDiscussNum", "(J)V", "getDiscussStr", "()Ljava/lang/String;", "setDiscussStr", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getName", "setName", "getRowkey", "setRowkey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicItem
{
  private long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private String b;
  @NotNull
  private String c;
  @NotNull
  private String d;
  
  public TweetTopicItem()
  {
    this(null, null, null, 0L, null, 31, null);
  }
  
  public TweetTopicItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong, @NotNull String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TweetTopicItem))
      {
        paramObject = (TweetTopicItem)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    String str = this.jdField_a_of_type_JavaLangString;
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
    int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.jdField_a_of_type_Long);
    str = this.d;
    if (str != null) {
      m = str.hashCode();
    }
    return (((i * 31 + j) * 31 + k) * 31 + n) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TweetTopicItem(rowkey=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", discussNum=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", discussStr=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.TweetTopicItem
 * JD-Core Version:    0.7.0.1
 */