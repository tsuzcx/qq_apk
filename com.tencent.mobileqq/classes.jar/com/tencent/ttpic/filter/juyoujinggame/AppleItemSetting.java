package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;

public class AppleItemSetting
{
  public float audioScaleFactor = 1.0F;
  public StickerItem audioattack;
  public StickerItem audiocombo;
  public StickerItem audioend;
  public StickerItem audior;
  public StickerItem audiostart;
  public String dataPath = "";
  public ArrayList<Float> mAppleAppearTime;
  public float mDeadY = 0.9F;
  public float mDropSpeed = 0.1F;
  public double[] mFrameDuration = { 0.0D, 0.0D };
  public int[] mFrames = { 0, 0 };
  public int mHeight;
  public String[] mImages = { "", "" };
  public int mItemHeight;
  public int mItemWidth;
  public int[] mPlayCounts = { 0, 0 };
  public int mScaleFactor = 0;
  public int mWidth = 0;
  public float maxWidth = 1.0F;
  
  public String getImageID(UKYOApple.APPLE_STATUS paramAPPLE_STATUS)
  {
    return this.mImages[paramAPPLE_STATUS.getValue()];
  }
  
  public void updateItemWidth(int paramInt)
  {
    int i = this.mScaleFactor;
    float f = 1.0F;
    if (i != 0) {
      f = paramInt * 1.0F / i;
    }
    this.mItemWidth = ((int)(this.mItemWidth * f));
    this.mItemHeight = ((int)(this.mItemHeight * f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.AppleItemSetting
 * JD-Core Version:    0.7.0.1
 */