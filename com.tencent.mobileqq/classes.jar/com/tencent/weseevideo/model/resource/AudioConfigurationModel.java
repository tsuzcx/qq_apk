package com.tencent.weseevideo.model.resource;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/AudioConfigurationModel;", "Ljava/io/Serializable;", "volume", "", "startVolumeEdgeModel", "Lcom/tencent/weseevideo/model/resource/VolumeEdgeModel;", "endVolumeEdgeModel", "(FLcom/tencent/weseevideo/model/resource/VolumeEdgeModel;Lcom/tencent/weseevideo/model/resource/VolumeEdgeModel;)V", "getEndVolumeEdgeModel", "()Lcom/tencent/weseevideo/model/resource/VolumeEdgeModel;", "getStartVolumeEdgeModel", "getVolume", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class AudioConfigurationModel
  implements Serializable
{
  @Nullable
  private final VolumeEdgeModel endVolumeEdgeModel;
  @Nullable
  private final VolumeEdgeModel startVolumeEdgeModel;
  private final float volume;
  
  public AudioConfigurationModel()
  {
    this(0.0F, null, null, 7, null);
  }
  
  public AudioConfigurationModel(float paramFloat, @Nullable VolumeEdgeModel paramVolumeEdgeModel1, @Nullable VolumeEdgeModel paramVolumeEdgeModel2)
  {
    this.volume = paramFloat;
    this.startVolumeEdgeModel = paramVolumeEdgeModel1;
    this.endVolumeEdgeModel = paramVolumeEdgeModel2;
  }
  
  public final float component1()
  {
    return this.volume;
  }
  
  @Nullable
  public final VolumeEdgeModel component2()
  {
    return this.startVolumeEdgeModel;
  }
  
  @Nullable
  public final VolumeEdgeModel component3()
  {
    return this.endVolumeEdgeModel;
  }
  
  @NotNull
  public final AudioConfigurationModel copy(float paramFloat, @Nullable VolumeEdgeModel paramVolumeEdgeModel1, @Nullable VolumeEdgeModel paramVolumeEdgeModel2)
  {
    return new AudioConfigurationModel(paramFloat, paramVolumeEdgeModel1, paramVolumeEdgeModel2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof AudioConfigurationModel))
      {
        paramObject = (AudioConfigurationModel)paramObject;
        if ((Float.compare(this.volume, paramObject.volume) != 0) || (!Intrinsics.areEqual(this.startVolumeEdgeModel, paramObject.startVolumeEdgeModel)) || (!Intrinsics.areEqual(this.endVolumeEdgeModel, paramObject.endVolumeEdgeModel))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final VolumeEdgeModel getEndVolumeEdgeModel()
  {
    return this.endVolumeEdgeModel;
  }
  
  @Nullable
  public final VolumeEdgeModel getStartVolumeEdgeModel()
  {
    return this.startVolumeEdgeModel;
  }
  
  public final float getVolume()
  {
    return this.volume;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = Float.floatToIntBits(this.volume);
    VolumeEdgeModel localVolumeEdgeModel = this.startVolumeEdgeModel;
    if (localVolumeEdgeModel != null) {}
    for (int i = localVolumeEdgeModel.hashCode();; i = 0)
    {
      localVolumeEdgeModel = this.endVolumeEdgeModel;
      if (localVolumeEdgeModel != null) {
        j = localVolumeEdgeModel.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "AudioConfigurationModel(volume=" + this.volume + ", startVolumeEdgeModel=" + this.startVolumeEdgeModel + ", endVolumeEdgeModel=" + this.endVolumeEdgeModel + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.AudioConfigurationModel
 * JD-Core Version:    0.7.0.1
 */