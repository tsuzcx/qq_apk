package com.tencent.mobileqq.shortvideo.mtveffects;

import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class MTVBaseFilter
{
  public static final int PLAY_MODE_NONE = 0;
  public static final int PLAY_MODE_NORMAL = 1;
  public static final int PLAY_MODE_REVERSE = 2;
  private static final String TAG = "MTVBaseFilter";
  private int mFilterType = -1;
  private int mHeight = 0;
  private long mLastTime = -1L;
  private String mMaterialPath;
  private int mPlayMode = 0;
  protected RandomGenerator mRandom = new RandomGenerator(System.currentTimeMillis());
  private final float[] mReversetexMatrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private boolean mRevert = false;
  private int mWidth = 0;
  
  public MTVBaseFilter(int paramInt, String paramString)
  {
    this.mFilterType = paramInt;
    this.mMaterialPath = paramString;
  }
  
  private boolean checkReset(long paramLong)
  {
    int i = this.mPlayMode;
    if (i == 0)
    {
      long l = this.mLastTime;
      if (l == -1L)
      {
        this.mLastTime = paramLong;
        return paramLong == 0L;
      }
      if (paramLong - l > 0L) {
        this.mPlayMode = 1;
      } else if (paramLong - l < 0L) {
        this.mPlayMode = 2;
      } else {
        this.mPlayMode = 0;
      }
      if (this.mLastTime != 0L)
      {
        this.mLastTime = paramLong;
        return this.mPlayMode != 0;
      }
      this.mLastTime = paramLong;
      return false;
    }
    if (i == 1)
    {
      if (paramLong < this.mLastTime)
      {
        this.mLastTime = paramLong;
        this.mPlayMode = 0;
        return this.mLastTime == 0L;
      }
      this.mLastTime = paramLong;
      return false;
    }
    if (i == 2)
    {
      if (paramLong > this.mLastTime)
      {
        this.mLastTime = paramLong;
        this.mPlayMode = 0;
        return this.mLastTime == 0L;
      }
      this.mLastTime = paramLong;
    }
    return false;
  }
  
  public boolean checkRandomTime(RandomTime paramRandomTime, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramRandomTime == null) {
      return false;
    }
    long l;
    if (getPlayMode() == 2) {
      l = -1L;
    } else {
      l = 1L;
    }
    if (paramRandomTime.mStartPos < 0L)
    {
      paramRandomTime.mStartPos = (this.mRandom.nextLong(0L, paramLong3) * l + paramLong1);
      paramRandomTime.mEndPos = (l * paramLong2 + paramRandomTime.mStartPos);
      return false;
    }
    if ((l != 1L) || (paramRandomTime.mStartPos <= paramLong1))
    {
      if ((l == -1L) && (paramRandomTime.mStartPos < paramLong1)) {
        return false;
      }
      if (((l == 1L) && (paramRandomTime.mEndPos > paramLong1)) || ((l == -1L) && (paramRandomTime.mEndPos < paramLong1))) {
        return true;
      }
      if (paramRandomTime.isLoop()) {
        paramRandomTime.reset();
      }
    }
    return false;
  }
  
  public boolean checkRandomTime(RandomTime paramRandomTime, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramRandomTime == null) {
      return false;
    }
    if (getPlayMode() == 0) {
      return false;
    }
    long l;
    if (getPlayMode() == 2) {
      l = -1L;
    } else {
      l = 1L;
    }
    if (paramRandomTime.mStartPos < 0L)
    {
      paramRandomTime.mStartPos = (this.mRandom.nextLong(0L, paramLong4) * l + paramLong1);
      paramRandomTime.mEndPos = (this.mRandom.nextLong(paramLong2, paramLong3) * l + paramRandomTime.mStartPos);
      return false;
    }
    if ((l != 1L) || (paramRandomTime.mStartPos <= paramLong1))
    {
      if ((l == -1L) && (paramRandomTime.mStartPos < paramLong1)) {
        return false;
      }
      if (((l == 1L) && (paramRandomTime.mEndPos > paramLong1)) || ((l == -1L) && (paramRandomTime.mEndPos < paramLong1))) {
        return true;
      }
      if (paramRandomTime.isLoop()) {
        paramRandomTime.reset();
      }
    }
    return false;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public String getMaterialPath()
  {
    return this.mMaterialPath;
  }
  
  public int getPlayMode()
  {
    return this.mPlayMode;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean onDraw(RenderBuffer paramRenderBuffer, int paramInt, long paramLong, float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    paramRenderBuffer = new StringBuilder();
    paramRenderBuffer.append("onDraw, inTexID:");
    paramRenderBuffer.append(paramInt);
    paramRenderBuffer.append(" currentMs:");
    paramRenderBuffer.append(paramLong);
    paramRenderBuffer.append(" musicScale:");
    paramRenderBuffer.append(paramFloat);
    paramRenderBuffer.append(" playMode:");
    paramRenderBuffer.append(this.mPlayMode);
    paramRenderBuffer.append(" lastTime:");
    paramRenderBuffer.append(this.mLastTime);
    SLog.d("MTVBaseFilter", paramRenderBuffer.toString());
    return false;
  }
  
  public void onDrawFrame(int paramInt, RenderBuffer paramRenderBuffer, long paramLong, float paramFloat)
  {
    Object localObject;
    if (checkReset(paramLong))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDrawFrame, need reset:");
      ((StringBuilder)localObject).append(paramLong);
      SLog.d("MTVBaseFilter", ((StringBuilder)localObject).toString());
      onReset(paramLong);
    }
    if (this.mRevert) {
      localObject = this.mReversetexMatrix;
    } else {
      localObject = null;
    }
    if (!onDraw(paramRenderBuffer, paramInt, paramLong, paramFloat, (float[])localObject, null)) {
      updateRendBuffer(paramRenderBuffer, paramInt);
    }
  }
  
  public void onReset(long paramLong) {}
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void onSurfaceDestroy() {}
  
  public void revert(boolean paramBoolean)
  {
    this.mRevert = paramBoolean;
  }
  
  public void setSeed(long paramLong)
  {
    this.mRandom.setSeed(paramLong);
  }
  
  public boolean updateRendBuffer(RenderBuffer paramRenderBuffer, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0)
    {
      bool = true;
      if (paramInt != paramRenderBuffer.getTexId())
      {
        paramRenderBuffer.setTexId(paramInt);
        return true;
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
 * JD-Core Version:    0.7.0.1
 */