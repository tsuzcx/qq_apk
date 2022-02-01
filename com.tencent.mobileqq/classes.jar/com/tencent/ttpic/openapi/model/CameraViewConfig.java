package com.tencent.ttpic.openapi.model;

import java.util.List;

public class CameraViewConfig
{
  private float animationTime;
  private int animationType;
  private List<Float> cameraPosition;
  private List<Float> cameraRotation;
  private int cameraViewType;
  
  public float getAnimationTime()
  {
    return this.animationTime;
  }
  
  public int getAnimationType()
  {
    return this.animationType;
  }
  
  public List<Float> getCameraPosition()
  {
    return this.cameraPosition;
  }
  
  public List<Float> getCameraRotation()
  {
    return this.cameraRotation;
  }
  
  public int getCameraViewType()
  {
    return this.cameraViewType;
  }
  
  public void setAnimationTime(float paramFloat)
  {
    this.animationTime = paramFloat;
  }
  
  public void setAnimationType(int paramInt)
  {
    this.animationType = paramInt;
  }
  
  public void setCameraPosition(List<Float> paramList)
  {
    this.cameraPosition = paramList;
  }
  
  public void setCameraRotation(List<Float> paramList)
  {
    this.cameraRotation = paramList;
  }
  
  public void setCameraViewType(int paramInt)
  {
    this.cameraViewType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CameraViewConfig
 * JD-Core Version:    0.7.0.1
 */