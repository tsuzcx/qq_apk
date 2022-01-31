package com.tencent.ttpic.gles;

import android.opengl.EGLContext;

public class GLSharedData
{
  public EGLContext mSharedContext;
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
    TextureDataPipe localTextureDataPipe = null;
    int i;
    int j;
    if (this.mTexturePile[0].getTexureCurrentStatus() == 2)
    {
      i = 1;
      if (this.mTexturePile[1].getTexureCurrentStatus() != 2) {
        break label76;
      }
      j = 1;
      label32:
      if ((i == 0) || (j == 0)) {
        break label88;
      }
      if (this.mTexturePile[0].mTimestamp >= this.mTexturePile[1].mTimestamp) {
        break label81;
      }
      localTextureDataPipe = this.mTexturePile[0];
    }
    label76:
    label81:
    label88:
    do
    {
      return localTextureDataPipe;
      i = 0;
      break;
      j = 0;
      break label32;
      return this.mTexturePile[1];
      if (i != 0) {
        return this.mTexturePile[0];
      }
    } while (j == 0);
    return this.mTexturePile[1];
  }
  
  public TextureDataPipe getFreeTexturePileMakeBusy()
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < this.mTexturePile.length)
      {
        if (this.mTexturePile[i].getTexureCurrentStatus() == 0)
        {
          localObject1 = this.mTexturePile[i];
          ((TextureDataPipe)localObject1).makeBusy();
        }
      }
      else {
        return localObject1;
      }
      i += 1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.GLSharedData
 * JD-Core Version:    0.7.0.1
 */