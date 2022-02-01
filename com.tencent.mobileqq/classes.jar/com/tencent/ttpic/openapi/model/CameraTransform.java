package com.tencent.ttpic.openapi.model;

import java.util.List;

public class CameraTransform
{
  private List<Float> cameraPosition;
  private List<Float> cameraRotation;
  
  public List<Float> getCameraPosition()
  {
    return this.cameraPosition;
  }
  
  public List<Float> getCameraRotation()
  {
    return this.cameraRotation;
  }
  
  public void setCameraPosition(List<Float> paramList)
  {
    this.cameraPosition = paramList;
  }
  
  public void setCameraRotation(List<Float> paramList)
  {
    this.cameraRotation = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CameraTransform
 * JD-Core Version:    0.7.0.1
 */