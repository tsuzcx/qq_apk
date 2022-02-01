package com.tencent.ttpic.filter.juyoujinggame;

public class TachiSetting
{
  public int[] alignFacePoints;
  public int[] anchorPoint;
  public float audioScaleFactor = 1.0F;
  public double[] mFrameDuration = { 0.0D, 0.0D };
  public int[] mFrames = { 0, 0 };
  public int mHeight;
  public int mHittingTime = 0;
  public String[] mImages = { "", "" };
  public int mItemHeight;
  public int mItemWidth;
  public int[] mPlayCounts = { 0, 0 };
  public float mRoleSizeYFactor = 0.5F;
  public int mScaleFactor;
  public int mWidth = 0;
  
  public String getImageID(UKYOTachi.UKYOTACHISTATUS paramUKYOTACHISTATUS)
  {
    return this.mImages[paramUKYOTACHISTATUS.getValue()];
  }
  
  public void updateItemWidth(int paramInt)
  {
    float f = 1.0F;
    if (this.mScaleFactor == 0) {}
    for (;;)
    {
      this.mItemWidth = ((int)(this.mItemWidth * f));
      this.mItemHeight = ((int)(f * this.mItemHeight));
      return;
      f = 1.0F * paramInt / this.mScaleFactor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.TachiSetting
 * JD-Core Version:    0.7.0.1
 */