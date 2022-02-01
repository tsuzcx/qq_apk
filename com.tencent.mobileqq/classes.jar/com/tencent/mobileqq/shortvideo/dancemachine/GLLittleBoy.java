package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class GLLittleBoy
  extends GLFrameImage
{
  public boolean isReadyMatch = false;
  int mCurrMatchTimes = 0;
  private RectF mCurrentCacheRegion = new RectF();
  int mCurrentCenterY;
  BoyDataReport.BoyItem mDataReport = new BoyDataReport.BoyItem();
  private boolean mEnableFrameAnimation = true;
  public int mIndex;
  boolean mIsValidBoy;
  boolean mMatched;
  int mMatchedStatus;
  int mMaxMatchTimes = 1;
  boolean mMissed;
  boolean mNeedContinuousMatch = true;
  boolean mNeedMatch;
  private ResourceManager.DancePosture mPrivateDanceData;
  
  public GLLittleBoy(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    resetValidBoyStatus();
    this.mIsValidBoy = true;
    this.mEnableFrameAnimation = true;
    this.mIsBoyFilterPrivateRes = true;
  }
  
  public void clearStatus()
  {
    super.clearStatus();
    resetValidBoyStatus();
  }
  
  public void draw()
  {
    if ((this.mVisible) && (this.mEnableFrameAnimation))
    {
      startFrameAnimation();
      setCurrentImage(getAnimationCurrentIndex());
    }
    super.draw();
  }
  
  public ResourceManager.DancePosture getDanceData()
  {
    return this.mPrivateDanceData;
  }
  
  public RectF getSaveMatchedPointRegion()
  {
    return this.mCurrentCacheRegion;
  }
  
  public boolean isMatched()
  {
    return this.mMatched;
  }
  
  public boolean needDoMatch()
  {
    return this.mNeedMatch;
  }
  
  public void resetValidBoyStatus()
  {
    this.mNeedMatch = true;
    this.mMissed = false;
    this.mMatched = false;
    this.mMatchedStatus = -1;
  }
  
  public void saveMatchedPointRegion()
  {
    RectF localRectF = getCurrentDrawRegionSize();
    this.mCurrentCacheRegion.set(localRectF);
  }
  
  public void setFilterPrivateImage(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = GLFrameImage.getImageByPath(paramString, paramBoolean1, paramBoolean2);
    DanceLog.printFrameQueue("GLFrameImage", "GLLittleBoy:getImageByPath");
    this.mCurrentTexture = paramString.getTexture();
    this.mEnableFrameAnimation = false;
  }
  
  public void setFrameAnimationParams(ResourceManager.DancePosture paramDancePosture)
  {
    this.mPrivateDanceData = paramDancePosture;
  }
  
  public void setImageRes(String paramString)
  {
    setFilterPrivateImage(paramString, false, false);
  }
  
  public void setMatch(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.mCurrMatchTimes + 1;
      this.mCurrMatchTimes = i;
      if (i >= this.mMaxMatchTimes)
      {
        this.mMatched = paramBoolean;
        this.mCurrMatchTimes = 0;
      }
    }
    do
    {
      return;
      this.mMatched = paramBoolean;
    } while (!this.mNeedContinuousMatch);
    this.mCurrMatchTimes = 0;
  }
  
  public void setMaxMatchTimes(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {}
    for (this.mMaxMatchTimes = 1;; this.mMaxMatchTimes = paramInt)
    {
      this.mNeedContinuousMatch = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy
 * JD-Core Version:    0.7.0.1
 */