package com.tencent.qcircle.weseevideo.model.resource;

import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.extra.ExtraInfoModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "Ljava/io/Serializable;", "resource", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;)V", "videoConfiguration", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "audioConfiguration", "Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;)V", "videoConfigurationModel", "audioConfigurationModel", "extraInfoModel", "Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;", "config", "Lcom/tencent/qcircle/tavcut/bean/CropConfig;", "uniqueId", "", "extraParams", "", "", "", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;Lcom/tencent/qcircle/tavcut/bean/CropConfig;JLjava/util/Map;)V", "getAudioConfigurationModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "setAudioConfigurationModel", "(Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;)V", "getConfig", "()Lcom/tencent/qcircle/tavcut/bean/CropConfig;", "setConfig", "(Lcom/tencent/qcircle/tavcut/bean/CropConfig;)V", "getExtraInfoModel", "()Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;", "extraParams$annotations", "()V", "getExtraParams", "()Ljava/util/Map;", "getResource", "()Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "setResource", "getUniqueId", "()J", "setUniqueId", "(J)V", "getVideoConfigurationModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "setVideoConfigurationModel", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
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
  private long uniqueId;
  @NotNull
  private VideoConfigurationModel videoConfigurationModel;
  
  public MediaClipModel()
  {
    this(null, null, null, null, null, 0L, null, 127, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel)
  {
    this(paramVideoResourceModel, new VideoConfigurationModel(0, null, 0.0F, 0.0F, null, null, 0, 127, null), new AudioConfigurationModel(0.0F, null, null, 7, null), new ExtraInfoModel(null, null, 3, null), null, 0L, null, 112, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    this(paramVideoResourceModel, paramVideoConfigurationModel, paramAudioConfigurationModel, new ExtraInfoModel(null, null, 3, null), null, 0L, null, 112, null);
  }
  
  public MediaClipModel(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel, @NotNull ExtraInfoModel paramExtraInfoModel, @NotNull CropConfig paramCropConfig, long paramLong, @NotNull Map<String, ? extends Object> paramMap)
  {
    this.resource = paramVideoResourceModel;
    this.videoConfigurationModel = paramVideoConfigurationModel;
    this.audioConfigurationModel = paramAudioConfigurationModel;
    this.extraInfoModel = paramExtraInfoModel;
    this.config = paramCropConfig;
    this.uniqueId = paramLong;
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
  
  public final long component6()
  {
    return this.uniqueId;
  }
  
  @NotNull
  public final Map<String, Object> component7()
  {
    return this.extraParams;
  }
  
  @NotNull
  public final MediaClipModel copy(@NotNull VideoResourceModel paramVideoResourceModel, @NotNull VideoConfigurationModel paramVideoConfigurationModel, @NotNull AudioConfigurationModel paramAudioConfigurationModel, @NotNull ExtraInfoModel paramExtraInfoModel, @NotNull CropConfig paramCropConfig, long paramLong, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "resource");
    Intrinsics.checkParameterIsNotNull(paramVideoConfigurationModel, "videoConfigurationModel");
    Intrinsics.checkParameterIsNotNull(paramAudioConfigurationModel, "audioConfigurationModel");
    Intrinsics.checkParameterIsNotNull(paramExtraInfoModel, "extraInfoModel");
    Intrinsics.checkParameterIsNotNull(paramCropConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramMap, "extraParams");
    return new MediaClipModel(paramVideoResourceModel, paramVideoConfigurationModel, paramAudioConfigurationModel, paramExtraInfoModel, paramCropConfig, paramLong, paramMap);
  }
  
  @NotNull
  public final MediaClipModel deepCopy()
  {
    return new MediaClipModel(VideoResourceModel.copy$default(this.resource, null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8191, null), this.videoConfigurationModel.deepClone(), AudioConfigurationModel.copy$default(this.audioConfigurationModel, 0.0F, null, null, 7, null), ExtraInfoModel.copy$default(this.extraInfoModel, null, null, 3, null), null, this.uniqueId, null, 80, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaClipModel))
      {
        paramObject = (MediaClipModel)paramObject;
        if ((Intrinsics.areEqual(this.resource, paramObject.resource)) && (Intrinsics.areEqual(this.videoConfigurationModel, paramObject.videoConfigurationModel)) && (Intrinsics.areEqual(this.audioConfigurationModel, paramObject.audioConfigurationModel)) && (Intrinsics.areEqual(this.extraInfoModel, paramObject.extraInfoModel)) && (Intrinsics.areEqual(this.config, paramObject.config)) && (this.uniqueId == paramObject.uniqueId) && (Intrinsics.areEqual(this.extraParams, paramObject.extraParams))) {}
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
  
  public final long getUniqueId()
  {
    return this.uniqueId;
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
    long l = this.uniqueId;
    int i2 = (int)(l ^ l >>> 32);
    localObject = this.extraParams;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i2) * 31 + i1;
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
  
  public final void setUniqueId(long paramLong)
  {
    this.uniqueId = paramLong;
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
    localStringBuilder.append(", uniqueId=");
    localStringBuilder.append(this.uniqueId);
    localStringBuilder.append(", extraParams=");
    localStringBuilder.append(this.extraParams);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.resource.MediaClipModel
 * JD-Core Version:    0.7.0.1
 */