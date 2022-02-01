package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TextureDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String TAG = "TextureDataPipe";
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public List<List<PointF>> mPoints = new ArrayList();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.gles.TextureDataPipe
 * JD-Core Version:    0.7.0.1
 */