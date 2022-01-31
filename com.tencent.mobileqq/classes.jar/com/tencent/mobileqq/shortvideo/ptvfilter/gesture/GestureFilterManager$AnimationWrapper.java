package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.PointF;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;

public class GestureFilterManager$AnimationWrapper
{
  public static final int ANIMATION_PLAY = 1;
  public static final int ANIMATION_STOP = 2;
  private long deadlineTimeStamp = 0L;
  public NonFit2DFilter mFilter;
  public GestureKeyInfo mGestureInfo;
  private boolean mHasCallApplyGLSLFilter = false;
  
  public GestureFilterManager$AnimationWrapper(StickerItem paramStickerItem, String paramString, GestureKeyInfo paramGestureKeyInfo, PointF paramPointF, boolean paramBoolean)
  {
    this.mFilter = new NonFit2DFilter(paramStickerItem, paramString);
    this.mGestureInfo = paramGestureKeyInfo;
    this.mFilter.updateFilterPosition(paramPointF);
  }
  
  public static boolean compareGestureInfo(GestureKeyInfo paramGestureKeyInfo1, GestureKeyInfo paramGestureKeyInfo2, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramGestureKeyInfo1.hotPoints[0].x - paramGestureKeyInfo2.hotPoints[0].x) <= paramFloat)
    {
      bool1 = bool2;
      if (Math.abs(paramGestureKeyInfo1.hotPoints[0].y - paramGestureKeyInfo2.hotPoints[0].y) <= paramFloat) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void clearGLSLSelf()
  {
    if (SLog.isEnable()) {
      SLog.d("TimGestureLog", "mFilter.clearGLSLSelf");
    }
    this.mFilter.clearGLSLSelf();
  }
  
  public void destroyAudio()
  {
    this.mFilter.destroyAudio();
  }
  
  public int getAnimationStatus(long paramLong)
  {
    if (this.mFilter.isAnimationPlay(paramLong)) {
      return 1;
    }
    return 2;
  }
  
  public long getDeadLineTimeStamp()
  {
    return this.deadlineTimeStamp;
  }
  
  public void renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mFilter.isHasCleared())
    {
      this.mFilter.OnDrawFrameGLSL();
      this.mFilter.renderTexture(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void resetAnimationEndStatus()
  {
    this.mFilter.resetAnimationEndStatus();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mFilter.setRenderMode(paramInt);
  }
  
  public void updateDeadLineTimeStamp(long paramLong)
  {
    this.deadlineTimeStamp = paramLong;
  }
  
  public void updateFilterPostion(GestureKeyInfo paramGestureKeyInfo, PointF paramPointF)
  {
    this.mGestureInfo = paramGestureKeyInfo;
    this.mFilter.updateFilterPosition(paramPointF);
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    this.mFilter.updatePreview(paramPTDetectInfo);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (!this.mHasCallApplyGLSLFilter)
    {
      this.mFilter.ApplyGLSLFilter();
      this.mFilter.setRenderMode(1);
      this.mHasCallApplyGLSLFilter = true;
    }
    this.mFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.AnimationWrapper
 * JD-Core Version:    0.7.0.1
 */