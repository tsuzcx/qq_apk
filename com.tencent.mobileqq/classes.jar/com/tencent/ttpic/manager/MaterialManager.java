package com.tencent.ttpic.manager;

import com.tencent.ttpic.openapi.model.VideoMaterial;

public enum MaterialManager
{
  INSTANCE;
  
  private VideoMaterial material;
  
  private MaterialManager() {}
  
  public static MaterialManager getInstance()
  {
    return INSTANCE;
  }
  
  public VideoMaterial getCurrentMaterial()
  {
    return this.material;
  }
  
  public void setCurrentMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return;
    }
    VideoMaterial localVideoMaterial = this.material;
    if ((localVideoMaterial != null) && (localVideoMaterial.getId() != null)) {
      if (this.material.getId().equals(paramVideoMaterial.getId())) {
        RandomGroupManager.getInstance().clearCurValue();
      } else {
        RandomGroupManager.getInstance().clearAll();
      }
    }
    this.material = paramVideoMaterial;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.manager.MaterialManager
 * JD-Core Version:    0.7.0.1
 */