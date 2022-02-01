package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;

public class UKYOScore$ScoreStatus
{
  protected int mCurIndex = -1;
  protected String mImageID;
  protected StickerItem mStickerItem;
  
  public UKYOScore$ScoreStatus(UKYOScore paramUKYOScore, StickerItem paramStickerItem)
  {
    this.mStickerItem = paramStickerItem;
  }
  
  public void updateFrameIndex()
  {
    this.mCurIndex += 1;
  }
  
  public void updateImageID(String paramString)
  {
    String str = this.mImageID;
    if ((str != null) && (paramString.equals(str))) {
      return;
    }
    this.mImageID = paramString;
    this.mCurIndex = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScore.ScoreStatus
 * JD-Core Version:    0.7.0.1
 */