package com.tencent.taveffect.core;

public class TAVRectangle
{
  public float height;
  public float width;
  public float x;
  public float y;
  
  public TAVRectangle()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public TAVRectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVRectangle{x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVRectangle
 * JD-Core Version:    0.7.0.1
 */