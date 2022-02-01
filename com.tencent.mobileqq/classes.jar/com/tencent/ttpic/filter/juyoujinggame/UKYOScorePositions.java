package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;

public class UKYOScorePositions
{
  public static final int PLAYING = 0;
  public static final int PLAY_OVER = 2;
  public static final int PLAY_OVER_SINGLE = 3;
  public static final int PLAY_SINGLE = 1;
  public final int[] anchorPoint;
  public final int[] anchorSingleOverPoint;
  public final int[] anchorSinglePoint;
  public final int[] anchorUKYOPoint;
  public final int itemHeight;
  public final int itemUKYOHeight;
  public final int itemUKYOWidth;
  public final int itemWidth;
  
  public UKYOScorePositions(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    this.itemWidth = paramInt1;
    this.itemHeight = paramInt2;
    this.itemUKYOWidth = paramInt3;
    this.itemUKYOHeight = paramInt4;
    this.anchorPoint = paramArrayOfInt1;
    this.anchorUKYOPoint = paramArrayOfInt2;
    this.anchorSinglePoint = paramArrayOfInt3;
    this.anchorSingleOverPoint = paramArrayOfInt4;
  }
  
  public void updateAnchor(StickerItem paramStickerItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 1;
      }
      switch (i)
      {
      }
    }
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          i = 3;
          break;
        }
        i = 2;
        break;
        paramStickerItem.anchorPoint = this.anchorPoint;
        paramStickerItem.width = this.itemWidth;
        paramStickerItem.height = this.itemHeight;
        return;
        if (this.anchorSinglePoint != null)
        {
          paramStickerItem.anchorPoint = this.anchorSinglePoint;
          return;
        }
        paramStickerItem.anchorPoint = this.anchorPoint;
        return;
        if (this.anchorUKYOPoint != null) {
          paramStickerItem.anchorPoint = this.anchorUKYOPoint;
        }
        for (;;)
        {
          if (this.itemUKYOWidth > 0) {
            paramStickerItem.width = this.itemUKYOWidth;
          }
          if (this.itemUKYOHeight <= 0) {
            break;
          }
          paramStickerItem.height = this.itemUKYOHeight;
          return;
          if (this.anchorPoint != null) {
            paramStickerItem.anchorPoint = this.anchorPoint;
          }
        }
        if (this.anchorSingleOverPoint != null)
        {
          paramStickerItem.anchorPoint = this.anchorSingleOverPoint;
          return;
        }
      } while (this.anchorUKYOPoint == null);
      paramStickerItem.anchorPoint = this.anchorUKYOPoint;
      if (this.itemUKYOWidth > 0) {
        paramStickerItem.width = this.itemUKYOWidth;
      }
    } while (this.itemUKYOHeight <= 0);
    paramStickerItem.height = this.itemUKYOHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScorePositions
 * JD-Core Version:    0.7.0.1
 */