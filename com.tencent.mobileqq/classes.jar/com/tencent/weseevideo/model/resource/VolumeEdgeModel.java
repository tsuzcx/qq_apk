package com.tencent.weseevideo.model.resource;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/VolumeEdgeModel;", "Ljava/io/Serializable;", "timeStart", "", "timeDuration", "startVolume", "", "endVolume", "(JJFF)V", "getEndVolume", "()F", "getStartVolume", "getTimeDuration", "()J", "getTimeStart", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VolumeEdgeModel
  implements Serializable
{
  private final float endVolume;
  private final float startVolume;
  private final long timeDuration;
  private final long timeStart;
  
  public VolumeEdgeModel()
  {
    this(0L, 0L, 0.0F, 0.0F, 15, null);
  }
  
  public VolumeEdgeModel(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2)
  {
    this.timeStart = paramLong1;
    this.timeDuration = paramLong2;
    this.startVolume = paramFloat1;
    this.endVolume = paramFloat2;
  }
  
  public final float getEndVolume()
  {
    return this.endVolume;
  }
  
  public final float getStartVolume()
  {
    return this.startVolume;
  }
  
  public final long getTimeDuration()
  {
    return this.timeDuration;
  }
  
  public final long getTimeStart()
  {
    return this.timeStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VolumeEdgeModel
 * JD-Core Version:    0.7.0.1
 */