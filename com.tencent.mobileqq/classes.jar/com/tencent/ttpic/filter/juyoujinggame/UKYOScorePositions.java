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
    int i;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    else if (paramBoolean1) {
      i = 3;
    } else {
      i = 2;
    }
    if (i != 0)
    {
      int[] arrayOfInt;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          arrayOfInt = this.anchorSingleOverPoint;
          if (arrayOfInt != null)
          {
            paramStickerItem.anchorPoint = arrayOfInt;
            return;
          }
          arrayOfInt = this.anchorUKYOPoint;
          if (arrayOfInt != null)
          {
            paramStickerItem.anchorPoint = arrayOfInt;
            i = this.itemUKYOWidth;
            if (i > 0) {
              paramStickerItem.width = i;
            }
            i = this.itemUKYOHeight;
            if (i > 0) {
              paramStickerItem.height = i;
            }
          }
        }
        else
        {
          arrayOfInt = this.anchorUKYOPoint;
          if (arrayOfInt != null)
          {
            paramStickerItem.anchorPoint = arrayOfInt;
          }
          else
          {
            arrayOfInt = this.anchorPoint;
            if (arrayOfInt != null) {
              paramStickerItem.anchorPoint = arrayOfInt;
            }
          }
          i = this.itemUKYOWidth;
          if (i > 0) {
            paramStickerItem.width = i;
          }
          i = this.itemUKYOHeight;
          if (i > 0) {
            paramStickerItem.height = i;
          }
        }
      }
      else
      {
        arrayOfInt = this.anchorSinglePoint;
        if (arrayOfInt != null)
        {
          paramStickerItem.anchorPoint = arrayOfInt;
          return;
        }
        paramStickerItem.anchorPoint = this.anchorPoint;
      }
    }
    else
    {
      paramStickerItem.anchorPoint = this.anchorPoint;
      paramStickerItem.width = this.itemWidth;
      paramStickerItem.height = this.itemHeight;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScorePositions
 * JD-Core Version:    0.7.0.1
 */