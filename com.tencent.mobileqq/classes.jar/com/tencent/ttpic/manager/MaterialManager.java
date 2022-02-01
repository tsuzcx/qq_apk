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
    if ((this.material != null) && (this.material.getId() != null))
    {
      if (!this.material.getId().equals(paramVideoMaterial.getId())) {
        break label51;
      }
      RandomGroupManager.getInstance().clearCurValue();
    }
    for (;;)
    {
      this.material = paramVideoMaterial;
      return;
      label51:
      RandomGroupManager.getInstance().clearAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.manager.MaterialManager
 * JD-Core Version:    0.7.0.1
 */