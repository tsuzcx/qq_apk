package com.tencent.tkd.weibo.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "", "rowkey", "", "iconUrl", "name", "discussNum", "", "discussStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDiscussNum", "()J", "setDiscussNum", "(J)V", "getDiscussStr", "()Ljava/lang/String;", "setDiscussStr", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getName", "setName", "getRowkey", "setRowkey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
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
    if (this != paramObject)
    {
      if ((paramObject instanceof TweetTopicItem))
      {
        paramObject = (TweetTopicItem)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (!Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.b;
      if (str == null) {
        break label118;
      }
      j = str.hashCode();
      label37:
      str = this.c;
      if (str == null) {
        break label123;
      }
    }
    label118:
    label123:
    for (int k = str.hashCode();; k = 0)
    {
      long l = this.jdField_a_of_type_Long;
      int n = (int)(l ^ l >>> 32);
      str = this.d;
      if (str != null) {
        m = str.hashCode();
      }
      return ((k + (j + i * 31) * 31) * 31 + n) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TweetTopicItem(rowkey=" + this.jdField_a_of_type_JavaLangString + ", iconUrl=" + this.b + ", name=" + this.c + ", discussNum=" + this.jdField_a_of_type_Long + ", discussStr=" + this.d + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.TweetTopicItem
 * JD-Core Version:    0.7.0.1
 */