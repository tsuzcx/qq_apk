package com.tencent.tkd.topicsdk.bean;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "Ljava/io/Serializable;", "id", "", "title", "", "coverUrl", "ownerIconUrlList", "", "bounce", "", "participate", "remainSubmitCount", "detailUrl", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;)V", "getBounce", "()I", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "getDetailUrl", "getId", "()J", "getOwnerIconUrlList", "()Ljava/util/List;", "getParticipate", "getRemainSubmitCount", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class InvitedManuscriptItem
  implements Serializable
{
  private final int bounce;
  @NotNull
  private String coverUrl;
  @NotNull
  private final String detailUrl;
  private final long id;
  @NotNull
  private final List<String> ownerIconUrlList;
  private final int participate;
  private final int remainSubmitCount;
  @NotNull
  private final String title;
  
  public InvitedManuscriptItem(long paramLong, @NotNull String paramString1, @NotNull String paramString2, @NotNull List<String> paramList, int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString3)
  {
    this.id = paramLong;
    this.title = paramString1;
    this.coverUrl = paramString2;
    this.ownerIconUrlList = paramList;
    this.bounce = paramInt1;
    this.participate = paramInt2;
    this.remainSubmitCount = paramInt3;
    this.detailUrl = paramString3;
  }
  
  public final long component1()
  {
    return this.id;
  }
  
  @NotNull
  public final String component2()
  {
    return this.title;
  }
  
  @NotNull
  public final String component3()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final List<String> component4()
  {
    return this.ownerIconUrlList;
  }
  
  public final int component5()
  {
    return this.bounce;
  }
  
  public final int component6()
  {
    return this.participate;
  }
  
  public final int component7()
  {
    return this.remainSubmitCount;
  }
  
  @NotNull
  public final String component8()
  {
    return this.detailUrl;
  }
  
  @NotNull
  public final InvitedManuscriptItem copy(long paramLong, @NotNull String paramString1, @NotNull String paramString2, @NotNull List<String> paramList, int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "title");
    Intrinsics.checkParameterIsNotNull(paramString2, "coverUrl");
    Intrinsics.checkParameterIsNotNull(paramList, "ownerIconUrlList");
    Intrinsics.checkParameterIsNotNull(paramString3, "detailUrl");
    return new InvitedManuscriptItem(paramLong, paramString1, paramString2, paramList, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof InvitedManuscriptItem))
      {
        paramObject = (InvitedManuscriptItem)paramObject;
        if ((this.id == paramObject.id) && (Intrinsics.areEqual(this.title, paramObject.title)) && (Intrinsics.areEqual(this.coverUrl, paramObject.coverUrl)) && (Intrinsics.areEqual(this.ownerIconUrlList, paramObject.ownerIconUrlList)) && (this.bounce == paramObject.bounce) && (this.participate == paramObject.participate) && (this.remainSubmitCount == paramObject.remainSubmitCount) && (Intrinsics.areEqual(this.detailUrl, paramObject.detailUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getBounce()
  {
    return this.bounce;
  }
  
  @NotNull
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final String getDetailUrl()
  {
    return this.detailUrl;
  }
  
  public final long getId()
  {
    return this.id;
  }
  
  @NotNull
  public final List<String> getOwnerIconUrlList()
  {
    return this.ownerIconUrlList;
  }
  
  public final int getParticipate()
  {
    return this.participate;
  }
  
  public final int getRemainSubmitCount()
  {
    return this.remainSubmitCount;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public int hashCode()
  {
    int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.id);
    Object localObject = this.title;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.coverUrl;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.ownerIconUrlList;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    int i1 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.bounce);
    int i2 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.participate);
    int i3 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.remainSubmitCount);
    localObject = this.detailUrl;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((((n * 31 + i) * 31 + j) * 31 + k) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + m;
  }
  
  public final void setCoverUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverUrl = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvitedManuscriptItem(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", coverUrl=");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append(", ownerIconUrlList=");
    localStringBuilder.append(this.ownerIconUrlList);
    localStringBuilder.append(", bounce=");
    localStringBuilder.append(this.bounce);
    localStringBuilder.append(", participate=");
    localStringBuilder.append(this.participate);
    localStringBuilder.append(", remainSubmitCount=");
    localStringBuilder.append(this.remainSubmitCount);
    localStringBuilder.append(", detailUrl=");
    localStringBuilder.append(this.detailUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.InvitedManuscriptItem
 * JD-Core Version:    0.7.0.1
 */