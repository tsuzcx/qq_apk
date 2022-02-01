package com.tencent.ttpic.openapi;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class PTSkyAttr
{
  private Bitmap maskBitmap;
  private Frame maskFrame;
  private long nextSurfaceTime;
  private float[] rotationMatrix;
  private long surfaceTime;
  
  public Bitmap getMaskBitmap()
  {
    return this.maskBitmap;
  }
  
  public Frame getMaskFrame()
  {
    return this.maskFrame;
  }
  
  public long getNextSurfaceTime()
  {
    return this.nextSurfaceTime;
  }
  
  public float[] getRotationMatrix()
  {
    return this.rotationMatrix;
  }
  
  public long getSurfaceTime()
  {
    return this.surfaceTime;
  }
  
  public boolean isReady()
  {
    return BitmapUtils.isLegal(this.maskBitmap);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    this.maskBitmap = paramBitmap;
  }
  
  public void setMaskFrame(Frame paramFrame)
  {
    this.maskFrame = paramFrame;
  }
  
  public void setNextSurfaceTime(long paramLong)
  {
    this.nextSurfaceTime = paramLong;
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    this.rotationMatrix = paramArrayOfFloat;
  }
  
  public void setSurfaceTime(long paramLong)
  {
    this.surfaceTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTSkyAttr
 * JD-Core Version:    0.7.0.1
 */