package com.tencent.ttpic.gles;

import android.opengl.EGLContext;

public class GLSegSharedData
{
  public EGLContext mSharedContext;
  public SegmentDataPipe[] mTexturePile;
  
  public GLSegSharedData(EGLContext paramEGLContext)
  {
    this.mSharedContext = paramEGLContext;
    this.mTexturePile = new SegmentDataPipe[2];
    this.mTexturePile[0] = new SegmentDataPipe();
    this.mTexturePile[1] = new SegmentDataPipe();
  }
  
  public void clear()
  {
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegmentDataPipe[i].release();
      i += 1;
    }
  }
  
  public SegmentDataPipe getCurrentTexturePile()
  {
    SegmentDataPipe localSegmentDataPipe = null;
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
      localSegmentDataPipe = this.mTexturePile[0];
    }
    label76:
    label81:
    label88:
    do
    {
      return localSegmentDataPipe;
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
  
  public SegmentDataPipe getFreeTexturePileMakeBusy()
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
          ((SegmentDataPipe)localObject1).makeBusy();
        }
      }
      else {
        return localObject1;
      }
      i += 1;
    }
  }
  
  public boolean judgeBrotherTextureIsReady(SegmentDataPipe paramSegmentDataPipe)
  {
    SegmentDataPipe localSegmentDataPipe = this.mTexturePile[0];
    if (this.mTexturePile[0] == paramSegmentDataPipe) {
      localSegmentDataPipe = this.mTexturePile[1];
    }
    return localSegmentDataPipe.getTexureCurrentStatus() == 2;
  }
  
  public void makeBrotherTextureFree(SegmentDataPipe paramSegmentDataPipe)
  {
    SegmentDataPipe localSegmentDataPipe = this.mTexturePile[0];
    if (this.mTexturePile[0] == paramSegmentDataPipe) {
      localSegmentDataPipe = this.mTexturePile[1];
    }
    localSegmentDataPipe.makeFree();
  }
  
  public void reset()
  {
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegmentDataPipe[i].makeFree();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.GLSegSharedData
 * JD-Core Version:    0.7.0.1
 */