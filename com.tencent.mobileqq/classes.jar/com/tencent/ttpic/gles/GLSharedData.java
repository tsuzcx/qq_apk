package com.tencent.ttpic.gles;

import android.opengl.EGLContext;

public class GLSharedData
{
  private EGLContext mSharedContext;
  public TextureDataPipe[] mTexturePile;
  
  public GLSharedData(EGLContext paramEGLContext)
  {
    this.mSharedContext = paramEGLContext;
    this.mTexturePile = new TextureDataPipe[2];
    this.mTexturePile[0] = new TextureDataPipe();
    this.mTexturePile[1] = new TextureDataPipe();
  }
  
  public void clear()
  {
    TextureDataPipe[] arrayOfTextureDataPipe = this.mTexturePile;
    int j = arrayOfTextureDataPipe.length;
    int i = 0;
    while (i < j)
    {
      arrayOfTextureDataPipe[i].release();
      i += 1;
    }
  }
  
  public TextureDataPipe getCurrentTexturePile()
  {
    int i;
    int j;
    if (this.mTexturePile[0].getTexureCurrentStatus() == 2)
    {
      i = 1;
      if (this.mTexturePile[1].getTexureCurrentStatus() != 2) {
        break label72;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        if (this.mTexturePile[0].mTimestamp < this.mTexturePile[1].mTimestamp)
        {
          return this.mTexturePile[0];
          i = 0;
          break;
          label72:
          j = 0;
          continue;
        }
        return this.mTexturePile[1];
      }
    }
    if (i != 0) {
      return this.mTexturePile[0];
    }
    if (j != 0) {
      return this.mTexturePile[1];
    }
    return null;
  }
  
  public TextureDataPipe getFreeTexturePileMakeBusy()
  {
    int i = 0;
    while (i < this.mTexturePile.length)
    {
      if (this.mTexturePile[i].getTexureCurrentStatus() == 0)
      {
        TextureDataPipe localTextureDataPipe = this.mTexturePile[i];
        localTextureDataPipe.makeBusy();
        return localTextureDataPipe;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean judgeBrotherTextureIsReady(TextureDataPipe paramTextureDataPipe)
  {
    TextureDataPipe localTextureDataPipe = this.mTexturePile[0];
    if (this.mTexturePile[0] == paramTextureDataPipe) {
      localTextureDataPipe = this.mTexturePile[1];
    }
    return localTextureDataPipe.getTexureCurrentStatus() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.gles.GLSharedData
 * JD-Core Version:    0.7.0.1
 */