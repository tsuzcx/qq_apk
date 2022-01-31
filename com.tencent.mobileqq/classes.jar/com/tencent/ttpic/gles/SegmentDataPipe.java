package com.tencent.ttpic.gles;

import com.tencent.filter.Frame;
import java.util.concurrent.atomic.AtomicInteger;

public class SegmentDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String TAG = SegmentDataPipe.class.getSimpleName();
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public Frame mMaskFrame = new Frame();
  public Frame mTexFrame = new Frame();
  public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
  public long mTimestamp;
  
  public int getTexureCurrentStatus()
  {
    return this.mTextureDataFlag.getAndAdd(0);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 16) {
      throw new IllegalArgumentException();
    }
    System.arraycopy(sMtxIdentity, 0, paramArrayOfFloat, 0, sMtxIdentity.length);
  }
  
  public boolean isBusy()
  {
    return this.mTextureDataFlag.get() == 1;
  }
  
  public boolean isReady()
  {
    return this.mTextureDataFlag.get() == 2;
  }
  
  public void makeBusy()
  {
    this.mTextureDataFlag.getAndSet(1);
  }
  
  public void makeDataReady()
  {
    this.mTextureDataFlag.getAndSet(2);
  }
  
  public void makeFree()
  {
    this.mTextureDataFlag.getAndSet(0);
  }
  
  public void release()
  {
    this.mTexFrame.clear();
    this.mMaskFrame.clear();
  }
  
  public static abstract interface OnFrameAvailableListener
  {
    public abstract void onFrameAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.SegmentDataPipe
 * JD-Core Version:    0.7.0.1
 */