package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.bean.Media;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$Album;", "", "name", "", "dirPath", "medias", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getDirPath", "()Ljava/lang/String;", "getMedias", "()Ljava/util/ArrayList;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RecentMediaListView$Album
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final ArrayList<Media> c;
  
  public RecentMediaListView$Album(@NotNull String paramString1, @NotNull String paramString2, @NotNull ArrayList<Media> paramArrayList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final ArrayList<Media> c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Album))
      {
        paramObject = (Album)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Album(name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", dirPath=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", medias=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.RecentMediaListView.Album
 * JD-Core Version:    0.7.0.1
 */