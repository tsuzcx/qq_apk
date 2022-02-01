package com.tencent.qcircle.weseevideo.model.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/resource/MediaResourceModel;", "Ljava/io/Serializable;", "()V", "videos", "", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "backupVideos", "smartType", "", "recordAudios", "backgroundMusic", "(Ljava/util/List;Ljava/util/List;ILjava/util/List;Ljava/util/List;)V", "getBackgroundMusic", "()Ljava/util/List;", "getBackupVideos", "getRecordAudios", "getSmartType", "()I", "getVideos", "setVideos", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "deepCopy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class MediaResourceModel
  implements Serializable
{
  @NotNull
  private final List<MediaClipModel> backgroundMusic;
  @Nullable
  private final List<MediaClipModel> backupVideos;
  @NotNull
  private final List<MediaClipModel> recordAudios;
  private final int smartType;
  @NotNull
  private List<MediaClipModel> videos;
  
  public MediaResourceModel()
  {
    this((List)new ArrayList(), (List)new ArrayList(), 0, (List)new ArrayList(), (List)new ArrayList());
  }
  
  public MediaResourceModel(@NotNull List<MediaClipModel> paramList1, @Nullable List<MediaClipModel> paramList2, int paramInt, @NotNull List<MediaClipModel> paramList3, @NotNull List<MediaClipModel> paramList4)
  {
    this.videos = paramList1;
    this.backupVideos = paramList2;
    this.smartType = paramInt;
    this.recordAudios = paramList3;
    this.backgroundMusic = paramList4;
  }
  
  @NotNull
  public final List<MediaClipModel> component1()
  {
    return this.videos;
  }
  
  @Nullable
  public final List<MediaClipModel> component2()
  {
    return this.backupVideos;
  }
  
  public final int component3()
  {
    return this.smartType;
  }
  
  @NotNull
  public final List<MediaClipModel> component4()
  {
    return this.recordAudios;
  }
  
  @NotNull
  public final List<MediaClipModel> component5()
  {
    return this.backgroundMusic;
  }
  
  @NotNull
  public final MediaResourceModel copy(@NotNull List<MediaClipModel> paramList1, @Nullable List<MediaClipModel> paramList2, int paramInt, @NotNull List<MediaClipModel> paramList3, @NotNull List<MediaClipModel> paramList4)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "videos");
    Intrinsics.checkParameterIsNotNull(paramList3, "recordAudios");
    Intrinsics.checkParameterIsNotNull(paramList4, "backgroundMusic");
    return new MediaResourceModel(paramList1, paramList2, paramInt, paramList3, paramList4);
  }
  
  @NotNull
  public final MediaResourceModel deepCopy()
  {
    Object localObject2 = (Iterable)this.videos;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((MediaClipModel)((Iterator)localObject2).next()).deepCopy());
    }
    localObject2 = CollectionsKt.toMutableList((Collection)localObject1);
    localObject1 = this.backupVideos;
    if (localObject1 != null)
    {
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((MediaClipModel)((Iterator)localObject3).next()).deepCopy());
      }
      localObject1 = CollectionsKt.toMutableList((Collection)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    int i = this.smartType;
    Object localObject4 = (Iterable)this.recordAudios;
    Object localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(((MediaClipModel)((Iterator)localObject4).next()).deepCopy());
    }
    localObject3 = CollectionsKt.toMutableList((Collection)localObject3);
    Object localObject5 = (Iterable)this.backgroundMusic;
    localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add(((MediaClipModel)((Iterator)localObject5).next()).deepCopy());
    }
    return new MediaResourceModel((List)localObject2, (List)localObject1, i, (List)localObject3, CollectionsKt.toMutableList((Collection)localObject4));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaResourceModel))
      {
        paramObject = (MediaResourceModel)paramObject;
        if ((Intrinsics.areEqual(this.videos, paramObject.videos)) && (Intrinsics.areEqual(this.backupVideos, paramObject.backupVideos)) && (this.smartType == paramObject.smartType) && (Intrinsics.areEqual(this.recordAudios, paramObject.recordAudios)) && (Intrinsics.areEqual(this.backgroundMusic, paramObject.backgroundMusic))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final List<MediaClipModel> getBackgroundMusic()
  {
    return this.backgroundMusic;
  }
  
  @Nullable
  public final List<MediaClipModel> getBackupVideos()
  {
    return this.backupVideos;
  }
  
  @NotNull
  public final List<MediaClipModel> getRecordAudios()
  {
    return this.recordAudios;
  }
  
  public final int getSmartType()
  {
    return this.smartType;
  }
  
  @NotNull
  public final List<MediaClipModel> getVideos()
  {
    return this.videos;
  }
  
  public int hashCode()
  {
    List localList = this.videos;
    int m = 0;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    localList = this.backupVideos;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    int n = this.smartType;
    localList = this.recordAudios;
    int k;
    if (localList != null) {
      k = localList.hashCode();
    } else {
      k = 0;
    }
    localList = this.backgroundMusic;
    if (localList != null) {
      m = localList.hashCode();
    }
    return (((i * 31 + j) * 31 + n) * 31 + k) * 31 + m;
  }
  
  public final void setVideos(@NotNull List<MediaClipModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.videos = paramList;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaResourceModel(videos=");
    localStringBuilder.append(this.videos);
    localStringBuilder.append(", backupVideos=");
    localStringBuilder.append(this.backupVideos);
    localStringBuilder.append(", smartType=");
    localStringBuilder.append(this.smartType);
    localStringBuilder.append(", recordAudios=");
    localStringBuilder.append(this.recordAudios);
    localStringBuilder.append(", backgroundMusic=");
    localStringBuilder.append(this.backgroundMusic);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel
 * JD-Core Version:    0.7.0.1
 */