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
  
  public SegmentDataPipe getFreeTexturePileMakeBusy()
  {
    int i = 0;
    while (i < this.mTexturePile.length)
    {
      if (this.mTexturePile[i].getTexureCurrentStatus() == 0)
      {
        SegmentDataPipe localSegmentDataPipe = this.mTexturePile[i];
        localSegmentDataPipe.makeBusy();
        return localSegmentDataPipe;
      }
      i += 1;
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.gles.GLSegSharedData
 * JD-Core Version:    0.7.0.1
 */