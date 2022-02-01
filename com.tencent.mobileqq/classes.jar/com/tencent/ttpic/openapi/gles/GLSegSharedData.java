package com.tencent.ttpic.openapi.gles;

public class GLSegSharedData
{
  public SegmentDataPipe[] mTexturePile = new SegmentDataPipe[2];
  
  public GLSegSharedData()
  {
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
  
  public SegmentDataPipe getFreeTexturePileMakeBusy()
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
        ((SegmentDataPipe)localObject).makeBusy();
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean judgeBrotherTextureIsReady(SegmentDataPipe paramSegmentDataPipe)
  {
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.mTexturePile;
    boolean bool = false;
    SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[0];
    if (arrayOfSegmentDataPipe[0] == paramSegmentDataPipe) {
      localSegmentDataPipe = arrayOfSegmentDataPipe[1];
    }
    if (localSegmentDataPipe.getTexureCurrentStatus() == 2) {
      bool = true;
    }
    return bool;
  }
  
  public void makeBrotherTextureFree(SegmentDataPipe paramSegmentDataPipe)
  {
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.mTexturePile;
    SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[0];
    if (arrayOfSegmentDataPipe[0] == paramSegmentDataPipe) {
      localSegmentDataPipe = arrayOfSegmentDataPipe[1];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.gles.GLSegSharedData
 * JD-Core Version:    0.7.0.1
 */