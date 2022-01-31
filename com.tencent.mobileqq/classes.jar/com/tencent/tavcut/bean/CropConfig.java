package com.tencent.tavcut.bean;

public class CropConfig
{
  private float height;
  private float width;
  private float x;
  private float y;
  
  public CropConfig(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public void setHeight(float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public void setWidth(float paramFloat)
  {
    this.width = paramFloat;
  }
  
  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.bean.CropConfig
 * JD-Core Version:    0.7.0.1
 */