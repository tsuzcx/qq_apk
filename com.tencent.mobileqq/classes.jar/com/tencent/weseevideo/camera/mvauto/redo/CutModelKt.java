package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "", "uuid", "", "resource", "Lcom/tencent/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "videoConfiguration", "Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "audioConfiguration", "Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;", "(Ljava/lang/String;Lcom/tencent/weseevideo/camera/mvauto/redo/VideoResourceModelKt;Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;)V", "getAudioConfiguration", "()Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;", "getResource", "()Lcom/tencent/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "getUuid", "()Ljava/lang/String;", "getVideoConfiguration", "()Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "component1", "component2", "component3", "component4", "convert", "Lcom/tencent/weseevideo/model/resource/MediaClipModel;", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class CutModelKt
{
  @Nullable
  private final AudioConfigurationModel audioConfiguration;
  @NotNull
  private final VideoResourceModelKt resource;
  @NotNull
  private final String uuid;
  @NotNull
  private final VideoConfigurationModelKt videoConfiguration;
  
  public CutModelKt(@NotNull String paramString, @NotNull VideoResourceModelKt paramVideoResourceModelKt, @NotNull VideoConfigurationModelKt paramVideoConfigurationModelKt, @Nullable AudioConfigurationModel paramAudioConfigurationModel)
  {
    this.uuid = paramString;
    this.resource = paramVideoResourceModelKt;
    this.videoConfiguration = paramVideoConfigurationModelKt;
    this.audioConfiguration = paramAudioConfigurationModel;
  }
  
  @NotNull
  public final String component1()
  {
    return this.uuid;
  }
  
  @NotNull
  public final VideoResourceModelKt component2()
  {
    return this.resource;
  }
  
  @NotNull
  public final VideoConfigurationModelKt component3()
  {
    return this.videoConfiguration;
  }
  
  @Nullable
  public final AudioConfigurationModel component4()
  {
    return this.audioConfiguration;
  }
  
  @NotNull
  public final MediaClipModel convert()
  {
    return new MediaClipModel(this.resource.convert(), this.videoConfiguration.convert(), null, null, null, null, 60, null);
  }
  
  @NotNull
  public final CutModelKt copy(@NotNull String paramString, @NotNull VideoResourceModelKt paramVideoResourceModelKt, @NotNull VideoConfigurationModelKt paramVideoConfigurationModelKt, @Nullable AudioConfigurationModel paramAudioConfigurationModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModelKt, "resource");
    Intrinsics.checkParameterIsNotNull(paramVideoConfigurationModelKt, "videoConfiguration");
    return new CutModelKt(paramString, paramVideoResourceModelKt, paramVideoConfigurationModelKt, paramAudioConfigurationModel);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CutModelKt))
      {
        paramObject = (CutModelKt)paramObject;
        if ((Intrinsics.areEqual(this.uuid, paramObject.uuid)) && (Intrinsics.areEqual(this.resource, paramObject.resource)) && (Intrinsics.areEqual(this.videoConfiguration, paramObject.videoConfiguration)) && (Intrinsics.areEqual(this.audioConfiguration, paramObject.audioConfiguration))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final AudioConfigurationModel getAudioConfiguration()
  {
    return this.audioConfiguration;
  }
  
  @NotNull
  public final VideoResourceModelKt getResource()
  {
    return this.resource;
  }
  
  @NotNull
  public final String getUuid()
  {
    return this.uuid;
  }
  
  @NotNull
  public final VideoConfigurationModelKt getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public int hashCode()
  {
    Object localObject = this.uuid;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.resource;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.videoConfiguration;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.audioConfiguration;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CutModelKt(uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(", resource=");
    localStringBuilder.append(this.resource);
    localStringBuilder.append(", videoConfiguration=");
    localStringBuilder.append(this.videoConfiguration);
    localStringBuilder.append(", audioConfiguration=");
    localStringBuilder.append(this.audioConfiguration);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.CutModelKt
 * JD-Core Version:    0.7.0.1
 */