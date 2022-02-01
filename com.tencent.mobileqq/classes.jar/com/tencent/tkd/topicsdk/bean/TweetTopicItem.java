package com.tencent.tkd.topicsdk.bean;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "rowkey", "", "iconUrl", "name", "discussNum", "", "discussStr", "readingNum", "readingStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;)V", "getDiscussNum", "()J", "setDiscussNum", "(J)V", "getDiscussStr", "()Ljava/lang/String;", "setDiscussStr", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getName", "setName", "getReadingNum", "setReadingNum", "getReadingStr", "setReadingStr", "getRowkey", "setRowkey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicItem
{
  @NotNull
  private String a;
  @NotNull
  private String b;
  @NotNull
  private String c;
  private long d;
  @NotNull
  private String e;
  private long f;
  @NotNull
  private String g;
  
  public TweetTopicItem()
  {
    this(null, null, null, 0L, null, 0L, null, 127, null);
  }
  
  public TweetTopicItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong1, @NotNull String paramString4, long paramLong2, @NotNull String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramLong1;
    this.e = paramString4;
    this.f = paramLong2;
    this.g = paramString5;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.f = paramLong;
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
  
  public final long d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TweetTopicItem))
      {
        paramObject = (TweetTopicItem)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f) && (Intrinsics.areEqual(this.g, paramObject.g))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long f()
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
    String str = this.a;
    int n = 0;
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
    int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.d);
    str = this.e;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    int i2 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.f);
    str = this.g;
    if (str != null) {
      n = str.hashCode();
    }
    return (((((i * 31 + j) * 31 + k) * 31 + i1) * 31 + m) * 31 + i2) * 31 + n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TweetTopicItem(rowkey=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", discussNum=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", discussStr=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", readingNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", readingStr=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.TweetTopicItem
 * JD-Core Version:    0.7.0.1
 */