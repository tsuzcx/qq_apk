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
    if (this.mTexturePile[0].getTexureCurrentStatus() == 2) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mTexturePile[1].getTexureCurrentStatus() == 2) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      if (this.mTexturePile[0].mTimestamp < this.mTexturePile[1].mTimestamp) {
        return this.mTexturePile[0];
      }
      return this.mTexturePile[1];
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
    for (;;)
    {
      Object localObject = this.mTexturePile;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].getTexureCurrentStatus() == 0)
      {
        localObject = this.mTexturePile[i];
        ((TextureDataPipe)localObject).makeBusy();
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean judgeBrotherTextureIsReady(TextureDataPipe paramTextureDataPipe)
  {
    TextureDataPipe[] arrayOfTextureDataPipe = this.mTexturePile;
    boolean bool = false;
    TextureDataPipe localTextureDataPipe = arrayOfTextureDataPipe[0];
    if (arrayOfTextureDataPipe[0] == paramTextureDataPipe) {
      localTextureDataPipe = arrayOfTextureDataPipe[1];
    }
    if (localTextureDataPipe.getTexureCurrentStatus() == 2) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.gles.GLSharedData
 * JD-Core Version:    0.7.0.1
 */