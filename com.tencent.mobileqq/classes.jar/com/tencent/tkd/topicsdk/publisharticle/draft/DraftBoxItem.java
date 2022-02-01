package com.tencent.tkd.topicsdk.publisharticle.draft;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftBoxItem;", "", "id", "", "timestamp", "", "key", "", "draftArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "userId", "(IJLjava/lang/String;Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;Ljava/lang/String;)V", "getDraftArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "getId", "()I", "getKey", "()Ljava/lang/String;", "getTimestamp", "()J", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftBoxItem
{
  private final int a;
  private final long b;
  @NotNull
  private final String c;
  @NotNull
  private final DraftArticleInfo d;
  @NotNull
  private final String e;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DraftBoxItem))
      {
        paramObject = (DraftBoxItem)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e))) {}
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
    int m = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a);
    int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
    Object localObject = this.c;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.d;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.e;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((m * 31 + n) * 31 + i) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DraftBoxItem(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", draftArticleInfo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", userId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.draft.DraftBoxItem
 * JD-Core Version:    0.7.0.1
 */