package com.tencent.taveffect.core;

public class TAVTextureInfo
{
  public long frameTimeUs;
  public int height;
  public int preRotation;
  public int textureID;
  public int textureType;
  public float[] transformMatrix;
  public int width;
  
  public TAVTextureInfo() {}
  
  public TAVTextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat, int paramInt5)
  {
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.transformMatrix = paramArrayOfFloat;
    this.preRotation = paramInt5;
  }
  
  public String formatSize()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.width);
    localStringBuilder.append("*");
    localStringBuilder.append(this.height);
    return localStringBuilder.toString();
  }
  
  public long getFrameTimeUs()
  {
    return this.frameTimeUs;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getPreRotation()
  {
    return this.preRotation;
  }
  
  public int getTextureID()
  {
    return this.textureID;
  }
  
  public int getTextureType()
  {
    return this.textureType;
  }
  
  public float[] getTransformMatrix()
  {
    return this.transformMatrix;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setFrameTimeUs(long paramLong)
  {
    this.frameTimeUs = paramLong;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setPreRotation(int paramInt)
  {
    this.preRotation = paramInt;
  }
  
  public void setTextureID(int paramInt)
  {
    this.textureID = paramInt;
  }
  
  public void setTextureType(int paramInt)
  {
    this.textureType = paramInt;
  }
  
  public void setTransformMatrix(float[] paramArrayOfFloat)
  {
    this.transformMatrix = paramArrayOfFloat;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVTextureInfo
 * JD-Core Version:    0.7.0.1
 */