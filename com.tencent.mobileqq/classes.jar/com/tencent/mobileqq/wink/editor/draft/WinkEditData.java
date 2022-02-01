package com.tencent.mobileqq.wink.editor.draft;

import .r8.java8methods.utility.Long.hashCode.IJ;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Ljava/io/Serializable;", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "durationUs", "", "stickerModelMap", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "filterModelMap", "Lcom/tencent/videocut/model/FilterModel;", "filterMaterialMap", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "stickerExtraMap", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkStickerModelExtra;", "(Lcom/tencent/videocut/model/MediaModel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getDurationUs", "()J", "setDurationUs", "(J)V", "getFilterMaterialMap", "()Ljava/util/Map;", "setFilterMaterialMap", "(Ljava/util/Map;)V", "getFilterModelMap", "setFilterModelMap", "getMediaModel", "()Lcom/tencent/videocut/model/MediaModel;", "setMediaModel", "(Lcom/tencent/videocut/model/MediaModel;)V", "getStickerExtraMap", "setStickerExtraMap", "getStickerModelMap", "setStickerModelMap", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditData
  implements Serializable
{
  public static final WinkEditData.Companion Companion = new WinkEditData.Companion(null);
  private static final long serialVersionUID = 599093938747237758L;
  private long durationUs;
  @Nullable
  private Map<String, MetaMaterial> filterMaterialMap;
  @Nullable
  private Map<String, FilterModel> filterModelMap;
  @NotNull
  private MediaModel mediaModel;
  @Nullable
  private Map<String, WinkStickerModelExtra> stickerExtraMap;
  @Nullable
  private Map<String, WinkStickerModel> stickerModelMap;
  
  public WinkEditData(@NotNull MediaModel paramMediaModel, long paramLong, @Nullable Map<String, WinkStickerModel> paramMap, @Nullable Map<String, FilterModel> paramMap1, @Nullable Map<String, MetaMaterial> paramMap2, @Nullable Map<String, WinkStickerModelExtra> paramMap3)
  {
    this.mediaModel = paramMediaModel;
    this.durationUs = paramLong;
    this.stickerModelMap = paramMap;
    this.filterModelMap = paramMap1;
    this.filterMaterialMap = paramMap2;
    this.stickerExtraMap = paramMap3;
  }
  
  @NotNull
  public final MediaModel component1()
  {
    return this.mediaModel;
  }
  
  public final long component2()
  {
    return this.durationUs;
  }
  
  @Nullable
  public final Map<String, WinkStickerModel> component3()
  {
    return this.stickerModelMap;
  }
  
  @Nullable
  public final Map<String, FilterModel> component4()
  {
    return this.filterModelMap;
  }
  
  @Nullable
  public final Map<String, MetaMaterial> component5()
  {
    return this.filterMaterialMap;
  }
  
  @Nullable
  public final Map<String, WinkStickerModelExtra> component6()
  {
    return this.stickerExtraMap;
  }
  
  @NotNull
  public final WinkEditData copy(@NotNull MediaModel paramMediaModel, long paramLong, @Nullable Map<String, WinkStickerModel> paramMap, @Nullable Map<String, FilterModel> paramMap1, @Nullable Map<String, MetaMaterial> paramMap2, @Nullable Map<String, WinkStickerModelExtra> paramMap3)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    return new WinkEditData(paramMediaModel, paramLong, paramMap, paramMap1, paramMap2, paramMap3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WinkEditData))
      {
        paramObject = (WinkEditData)paramObject;
        if ((Intrinsics.areEqual(this.mediaModel, paramObject.mediaModel)) && (this.durationUs == paramObject.durationUs) && (Intrinsics.areEqual(this.stickerModelMap, paramObject.stickerModelMap)) && (Intrinsics.areEqual(this.filterModelMap, paramObject.filterModelMap)) && (Intrinsics.areEqual(this.filterMaterialMap, paramObject.filterMaterialMap)) && (Intrinsics.areEqual(this.stickerExtraMap, paramObject.stickerExtraMap))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getDurationUs()
  {
    return this.durationUs;
  }
  
  @Nullable
  public final Map<String, MetaMaterial> getFilterMaterialMap()
  {
    return this.filterMaterialMap;
  }
  
  @Nullable
  public final Map<String, FilterModel> getFilterModelMap()
  {
    return this.filterModelMap;
  }
  
  @NotNull
  public final MediaModel getMediaModel()
  {
    return this.mediaModel;
  }
  
  @Nullable
  public final Map<String, WinkStickerModelExtra> getStickerExtraMap()
  {
    return this.stickerExtraMap;
  }
  
  @Nullable
  public final Map<String, WinkStickerModel> getStickerModelMap()
  {
    return this.stickerModelMap;
  }
  
  public int hashCode()
  {
    Object localObject = this.mediaModel;
    int n = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.durationUs);
    localObject = this.stickerModelMap;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.filterModelMap;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.filterMaterialMap;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.stickerExtraMap;
    if (localObject != null) {
      n = localObject.hashCode();
    }
    return ((((i * 31 + i1) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void setDurationUs(long paramLong)
  {
    this.durationUs = paramLong;
  }
  
  public final void setFilterMaterialMap(@Nullable Map<String, MetaMaterial> paramMap)
  {
    this.filterMaterialMap = paramMap;
  }
  
  public final void setFilterModelMap(@Nullable Map<String, FilterModel> paramMap)
  {
    this.filterModelMap = paramMap;
  }
  
  public final void setMediaModel(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "<set-?>");
    this.mediaModel = paramMediaModel;
  }
  
  public final void setStickerExtraMap(@Nullable Map<String, WinkStickerModelExtra> paramMap)
  {
    this.stickerExtraMap = paramMap;
  }
  
  public final void setStickerModelMap(@Nullable Map<String, WinkStickerModel> paramMap)
  {
    this.stickerModelMap = paramMap;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinkEditData(mediaModel=");
    localStringBuilder.append(this.mediaModel);
    localStringBuilder.append(", durationUs=");
    localStringBuilder.append(this.durationUs);
    localStringBuilder.append(", stickerModelMap=");
    localStringBuilder.append(this.stickerModelMap);
    localStringBuilder.append(", filterModelMap=");
    localStringBuilder.append(this.filterModelMap);
    localStringBuilder.append(", filterMaterialMap=");
    localStringBuilder.append(this.filterMaterialMap);
    localStringBuilder.append(", stickerExtraMap=");
    localStringBuilder.append(this.stickerExtraMap);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.draft.WinkEditData
 * JD-Core Version:    0.7.0.1
 */