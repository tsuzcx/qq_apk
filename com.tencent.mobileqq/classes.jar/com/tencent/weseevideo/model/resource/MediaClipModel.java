package com.tencent.weseevideo.model.resource;

import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.model.extra.ExtraInfoModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/MediaClipModel;", "Ljava/io/Serializable;", "resource", "Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "(Lcom/tencent/weseevideo/model/resource/VideoResourceModel;)V", "videoConfiguration", "Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;", "audioConfiguration", "Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;", "(Lcom/tencent/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;)V", "videoConfigurationModel", "audioConfigurationModel", "extraInfoModel", "Lcom/tencent/weseevideo/model/extra/ExtraInfoModel;", "config", "Lcom/tencent/tavcut/bean/CropConfig;", "extraParams", "", "", "", "(Lcom/tencent/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;Lcom/tencent/weseevideo/model/extra/ExtraInfoModel;Lcom/tencent/tavcut/bean/CropConfig;Ljava/util/Map;)V", "getAudioConfigurationModel", "()Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;", "setAudioConfigurationModel", "(Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;)V", "getConfig", "()Lcom/tencent/tavcut/bean/CropConfig;", "setConfig", "(Lcom/tencent/tavcut/bean/CropConfig;)V", "getExtraInfoModel", "()Lcom/tencent/weseevideo/model/extra/ExtraInfoModel;", "extraParams$annotations", "()V", "getExtraParams", "()Ljava/util/Map;", "getResource", "()Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "setResource", "getVideoConfigurationModel", "()Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;", "setVideoConfigurationModel", "(Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class MediaClipModel
  implements Serializable
{
  @NotNull
  private AudioConfigurationModel audioConfigurationModel;
  @NotNull
  private CropConfig config;
  @NotNull
  private final ExtraInfoModel extraInfoModel;
  @NotNull
  private final transient Map<String, Object> extraParams;
  @NotNull
  private VideoResourceModel resource;
  @NotNull
  private VideoConfigurationModel videoConfigurationModel;
  
  public MediaClipModel()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel)
  {
    this(paramVideoResourceModel, new VideoConfigurationModel(0, null, 0.0F, 0.0F, null, null, 0, 127, null), new AudioConfigurationModel(0.0F, null, null, 7, null), new ExtraInfoModel(null, null, 3, null), null, null, 48, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    this(paramVideoResourceModel, paramVideoConfigurationModel, paramAudioConfigurationModel, new ExtraInfoModel(null, null, 3, null), null, null, 48, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel, @NotNull ExtraInfoModel paramExtraInfoModel, @NotNull CropConfig paramCropConfig, @NotNull Map<String, ? extends Object> paramMap)
  {
    this.resource = paramVideoResourceModel;
    this.videoConfigurationModel = paramVideoConfigurationModel;
    this.audioConfigurationModel = paramAudioConfigurationModel;
    this.extraInfoModel = paramExtraInfoModel;
    this.config = paramCropConfig;
    this.extraParams = paramMap;
  }
  
  @NotNull
  public final VideoResourceModel component1()
  {
    return this.resource;
  }
  
  @NotNull
  public final VideoConfigurationModel component2()
  {
    return this.videoConfigurationModel;
  }
  
  @NotNull
  public final AudioConfigurationModel component3()
  {
    return this.audioConfigurationModel;
  }
  
  @NotNull
  public final ExtraInfoModel component4()
  {
    return this.extraInfoModel;
  }
  
  @NotNull
  public final CropConfig component5()
  {
    return this.config;
  }
  
  @NotNull
  public final Map<String, Object> component6()
  {
    return this.extraParams;
  }
  
  @NotNull
  public final MediaClipModel copy(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel, @NotNull ExtraInfoModel paramExtraInfoModel, @NotNull CropConfig paramCropConfig, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "resource");
    Intrinsics.checkParameterIsNotNull(paramVideoConfigurationModel, "videoConfigurationModel");
    Intrinsics.checkParameterIsNotNull(paramAudioConfigurationModel, "audioConfigurationModel");
    Intrinsics.checkParameterIsNotNull(paramExtraInfoModel, "extraInfoModel");
    Intrinsics.checkParameterIsNotNull(paramCropConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramMap, "extraParams");
    return new MediaClipModel(paramVideoResourceModel, paramVideoConfigurationModel, paramAudioConfigurationModel, paramExtraInfoModel, paramCropConfig, paramMap);
  }
  
  @NotNull
  public final MediaClipModel deepCopy()
  {
    return new MediaClipModel(VideoResourceModel.copy$default(this.resource, null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8191, null), this.videoConfigurationModel.deepClone(), AudioConfigurationModel.copy$default(this.audioConfigurationModel, 0.0F, null, null, 7, null), ExtraInfoModel.copy$default(this.extraInfoModel, null, null, 3, null), null, null, 48, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaClipModel))
      {
        paramObject = (MediaClipModel)paramObject;
        if ((Intrinsics.areEqual(this.resource, paramObject.resource)) && (Intrinsics.areEqual(this.videoConfigurationModel, paramObject.videoConfigurationModel)) && (Intrinsics.areEqual(this.audioConfigurationModel, paramObject.audioConfigurationModel)) && (Intrinsics.areEqual(this.extraInfoModel, paramObject.extraInfoModel)) && (Intrinsics.areEqual(this.config, paramObject.config)) && (Intrinsics.areEqual(this.extraParams, paramObject.extraParams))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final AudioConfigurationModel getAudioConfigurationModel()
  {
    return this.audioConfigurationModel;
  }
  
  @NotNull
  public final CropConfig getConfig()
  {
    return this.config;
  }
  
  @NotNull
  public final ExtraInfoModel getExtraInfoModel()
  {
    return this.extraInfoModel;
  }
  
  @NotNull
  public final Map<String, Object> getExtraParams()
  {
    return this.extraParams;
  }
  
  @NotNull
  public final VideoResourceModel getResource()
  {
    return this.resource;
  }
  
  @NotNull
  public final VideoConfigurationModel getVideoConfigurationModel()
  {
    return this.videoConfigurationModel;
  }
  
  public int hashCode()
  {
    Object localObject = this.resource;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.videoConfigurationModel;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.audioConfigurationModel;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.extraInfoModel;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.config;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.extraParams;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void setAudioConfigurationModel(@NotNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioConfigurationModel, "<set-?>");
    this.audioConfigurationModel = paramAudioConfigurationModel;
  }
  
  public final void setConfig(@NotNull CropConfig paramCropConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramCropConfig, "<set-?>");
    this.config = paramCropConfig;
  }
  
  public final void setResource(@NotNull VideoResourceModel paramVideoResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "<set-?>");
    this.resource = paramVideoResourceModel;
  }
  
  public final void setVideoConfigurationModel(@NotNull VideoConfigurationModel paramVideoConfigurationModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoConfigurationModel, "<set-?>");
    this.videoConfigurationModel = paramVideoConfigurationModel;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaClipModel(resource=");
    localStringBuilder.append(this.resource);
    localStringBuilder.append(", videoConfigurationModel=");
    localStringBuilder.append(this.videoConfigurationModel);
    localStringBuilder.append(", audioConfigurationModel=");
    localStringBuilder.append(this.audioConfigurationModel);
    localStringBuilder.append(", extraInfoModel=");
    localStringBuilder.append(this.extraInfoModel);
    localStringBuilder.append(", config=");
    localStringBuilder.append(this.config);
    localStringBuilder.append(", extraParams=");
    localStringBuilder.append(this.extraParams);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.MediaClipModel
 * JD-Core Version:    0.7.0.1
 */