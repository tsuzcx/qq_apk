package com.tencent.weseevideo.model.resource;

import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.List;

public class AudioConfigurationModel
  extends BaseMediaModel
{
  private VolumeEdgeModel endVolumeEdgeModel;
  private VolumeEdgeModel startVolumeEdgeModel;
  private float volume;
  private List<VolumeEdgeModel> volumeEdgeModels;
  
  public VolumeEdgeModel getEndVolumeEdgeModel()
  {
    return this.endVolumeEdgeModel;
  }
  
  public VolumeEdgeModel getStartVolumeEdgeModel()
  {
    return this.startVolumeEdgeModel;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public List<VolumeEdgeModel> getVolumeEdgeModels()
  {
    return this.volumeEdgeModels;
  }
  
  public void setEndVolumeEdgeModel(VolumeEdgeModel paramVolumeEdgeModel)
  {
    this.endVolumeEdgeModel = paramVolumeEdgeModel;
  }
  
  public void setStartVolumeEdgeModel(VolumeEdgeModel paramVolumeEdgeModel)
  {
    this.startVolumeEdgeModel = paramVolumeEdgeModel;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public void setVolumeEdgeModels(List<VolumeEdgeModel> paramList)
  {
    this.volumeEdgeModels = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.AudioConfigurationModel
 * JD-Core Version:    0.7.0.1
 */