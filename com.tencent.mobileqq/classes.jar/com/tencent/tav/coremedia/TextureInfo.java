package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import android.opengl.GLES20;

public class TextureInfo
{
  private int format = 6407;
  private int frameBuffer = -1;
  public final int height;
  private boolean mixAlpha = true;
  private boolean needRelease = false;
  public final int preferRotation;
  private boolean released;
  public final int textureID;
  private Matrix textureMatrix;
  public final int textureType;
  public final int width;
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.textureMatrix = null;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
  }
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, int paramInt5)
  {
    this.textureMatrix = paramMatrix;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
  }
  
  public TextureInfo clone()
  {
    TextureInfo localTextureInfo = new TextureInfo(this.textureID, this.textureType, this.width, this.height, this.textureMatrix, this.preferRotation);
    localTextureInfo.needRelease = true;
    return localTextureInfo;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public int getFrameBuffer()
  {
    return this.frameBuffer;
  }
  
  public Matrix getTextureMatrix()
  {
    return this.textureMatrix;
  }
  
  public boolean isMixAlpha()
  {
    return this.mixAlpha;
  }
  
  public boolean isNeedRelease()
  {
    return this.needRelease;
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public void release()
  {
    this.released = true;
    int i = this.frameBuffer;
    if (i != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.frameBuffer = -1;
    }
    GLES20.glDeleteTextures(1, new int[] { this.textureID }, 0);
  }
  
  public void setFormat(int paramInt)
  {
    this.format = paramInt;
  }
  
  public void setFrameBuffer(int paramInt)
  {
    this.frameBuffer = paramInt;
  }
  
  public void setMixAlpha(boolean paramBoolean)
  {
    this.mixAlpha = paramBoolean;
  }
  
  public void setTextureMatrix(Matrix paramMatrix)
  {
    this.textureMatrix = paramMatrix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureInfo{textureID=");
    localStringBuilder.append(this.textureID);
    localStringBuilder.append(", textureType=");
    localStringBuilder.append(this.textureType);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", preferRotation=");
    localStringBuilder.append(this.preferRotation);
    localStringBuilder.append(", textureMatrix=");
    localStringBuilder.append(this.textureMatrix);
    localStringBuilder.append(", frameBuffer=");
    localStringBuilder.append(this.frameBuffer);
    localStringBuilder.append(", needRelease=");
    localStringBuilder.append(this.needRelease);
    localStringBuilder.append(", mixAlpha=");
    localStringBuilder.append(this.mixAlpha);
    localStringBuilder.append(", format=");
    localStringBuilder.append(this.format);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.TextureInfo
 * JD-Core Version:    0.7.0.1
 */