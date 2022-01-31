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
    if (this.mPlayMode == 0) {
      if (this.mLastTime == -1L)
      {
        this.mLastTime = paramLong;
        if (paramLong != 0L) {}
      }
    }
    label99:
    do
    {
      return true;
      return false;
      if (paramLong - this.mLastTime > 0L) {
        this.mPlayMode = 1;
      }
      for (;;)
      {
        if (this.mLastTime == 0L) {
          break label99;
        }
        this.mLastTime = paramLong;
        if (this.mPlayMode != 0) {
          break;
        }
        return false;
        if (paramLong - this.mLastTime < 0L) {
          this.mPlayMode = 2;
        } else {
          this.mPlayMode = 0;
        }
      }
      this.mLastTime = paramLong;
      return false;
      if (this.mPlayMode != 1) {
        break label151;
      }
      if (paramLong >= this.mLastTime) {
        break;
      }
      this.mLastTime = paramLong;
      this.mPlayMode = 0;
    } while (this.mLastTime == 0L);
    return false;
    this.mLastTime = paramLong;
    for (;;)
    {
      return false;
      label151:
      if (this.mPlayMode == 2)
      {
        if (paramLong > this.mLastTime)
        {
          this.mLastTime = paramLong;
          this.mPlayMode = 0;
          if (this.mLastTime == 0L) {
            break;
          }
          return false;
        }
        this.mLastTime = paramLong;
      }
    }
  }
  
  public boolean checkRandomTime(RandomTime paramRandomTime, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramRandomTime == null) {
      return false;
    }
    long l = 1L;
    if (getPlayMode() == 2) {
      l = -1L;
    }
    if (paramRandomTime.mStartPos < 0L)
    {
      paramRandomTime.mStartPos = (this.mRandom.nextLong(0L, paramLong3) * l + paramLong1);
      paramRandomTime.mEndPos = (l * paramLong2 + paramRandomTime.mStartPos);
    }
    for (;;)
    {
      return false;
      if (((l != 1L) || (paramRandomTime.mStartPos <= paramLong1)) && ((l != -1L) || (paramRandomTime.mStartPos >= paramLong1)))
      {
        if (((l == 1L) && (paramRandomTime.mEndPos > paramLong1)) || ((l == -1L) && (paramRandomTime.mEndPos < paramLong1))) {
          return true;
        }
        if (paramRandomTime.isLoop()) {
          paramRandomTime.reset();
        }
      }
    }
  }
  
  public boolean checkRandomTime(RandomTime paramRandomTime, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramRandomTime == null) {
      return false;
    }
    if (getPlayMode() == 0) {
      return false;
    }
    long l = 1L;
    if (getPlayMode() == 2) {
      l = -1L;
    }
    if (paramRandomTime.mStartPos < 0L)
    {
      paramRandomTime.mStartPos = (this.mRandom.nextLong(0L, paramLong4) * l + paramLong1);
      paramRandomTime.mEndPos = (l * this.mRandom.nextLong(paramLong2, paramLong3) + paramRandomTime.mStartPos);
    }
    for (;;)
    {
      return false;
      if (((l != 1L) || (paramRandomTime.mStartPos <= paramLong1)) && ((l != -1L) || (paramRandomTime.mStartPos >= paramLong1)))
      {
        if (((l == 1L) && (paramRandomTime.mEndPos > paramLong1)) || ((l == -1L) && (paramRandomTime.mEndPos < paramLong1))) {
          return true;
        }
        if (paramRandomTime.isLoop()) {
          paramRandomTime.reset();
        }
      }
    }
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
    SLog.d("MTVBaseFilter", "onDraw, inTexID:" + paramInt + " currentMs:" + paramLong + " musicScale:" + paramFloat + " playMode:" + this.mPlayMode + " lastTime:" + this.mLastTime);
    return false;
  }
  
  public void onDrawFrame(int paramInt, RenderBuffer paramRenderBuffer, long paramLong, float paramFloat)
  {
    if (checkReset(paramLong))
    {
      SLog.d("MTVBaseFilter", "onDrawFrame, need reset:" + paramLong);
      onReset(paramLong);
    }
    if (this.mRevert) {}
    for (float[] arrayOfFloat = this.mReversetexMatrix;; arrayOfFloat = null)
    {
      if (!onDraw(paramRenderBuffer, paramInt, paramLong, paramFloat, arrayOfFloat, null)) {
        updateRendBuffer(paramRenderBuffer, paramInt);
      }
      return;
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
    boolean bool1 = false;
    if (paramInt >= 0)
    {
      boolean bool2 = true;
      bool1 = bool2;
      if (paramInt != paramRenderBuffer.getTexId())
      {
        paramRenderBuffer.setTexId(paramInt);
        bool1 = bool2;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
 * JD-Core Version:    0.7.0.1
 */