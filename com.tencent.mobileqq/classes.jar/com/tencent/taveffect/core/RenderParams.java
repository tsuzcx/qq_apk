package com.tencent.taveffect.core;

import android.graphics.Matrix;

public class RenderParams
{
  private float opacity = 1.0F;
  private TAVRectangle rectangle;
  private int renderHeight;
  private int renderWidth;
  private Matrix textureMatrix;
  private Matrix vertexMatrix;
  
  public float getOpacity()
  {
    return this.opacity;
  }
  
  public TAVRectangle getRectangle()
  {
    return this.rectangle;
  }
  
  public int getRenderHeight()
  {
    return this.renderHeight;
  }
  
  public int getRenderWidth()
  {
    return this.renderWidth;
  }
  
  public Matrix getTextureMatrix()
  {
    return this.textureMatrix;
  }
  
  public Matrix getVertexMatrix()
  {
    return this.vertexMatrix;
  }
  
  public void setOpacity(float paramFloat)
  {
    this.opacity = paramFloat;
  }
  
  public void setRectangle(TAVRectangle paramTAVRectangle)
  {
    this.rectangle = paramTAVRectangle;
  }
  
  public void setRenderHeight(int paramInt)
  {
    this.renderHeight = paramInt;
  }
  
  public void setRenderWidth(int paramInt)
  {
    this.renderWidth = paramInt;
  }
  
  public void setTextureMatrix(Matrix paramMatrix)
  {
    this.textureMatrix = paramMatrix;
  }
  
  public void setVertexMatrix(Matrix paramMatrix)
  {
    this.vertexMatrix = paramMatrix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderParams{renderWidth=");
    localStringBuilder.append(this.renderWidth);
    localStringBuilder.append(", renderHeight=");
    localStringBuilder.append(this.renderHeight);
    localStringBuilder.append(", vertexMatrix=");
    localStringBuilder.append(this.vertexMatrix);
    localStringBuilder.append(", textureMatrix=");
    localStringBuilder.append(this.textureMatrix);
    localStringBuilder.append(", rectangle=");
    localStringBuilder.append(this.rectangle);
    localStringBuilder.append(", opacity=");
    localStringBuilder.append(this.opacity);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.RenderParams
 * JD-Core Version:    0.7.0.1
 */