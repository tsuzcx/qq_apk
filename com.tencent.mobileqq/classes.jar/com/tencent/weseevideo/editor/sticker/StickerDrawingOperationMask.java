package com.tencent.weseevideo.editor.sticker;

public class StickerDrawingOperationMask
{
  public static final int DRAW_ALL = 63;
  public static final int DRAW_ALL_BTN = 15;
  public static final int DRAW_ALL_BTN_AND_BORDER = 31;
  public static final int DRAW_BORDER = 16;
  public static final int DRAW_GUIDE_LINE = 32;
  public static final int DRAW_LEFT_BOTTOM_BTN = 8;
  public static final int DRAW_LEFT_TOP_BTN = 1;
  public static final int DRAW_RIGHT_BOTTOM_BTN = 4;
  public static final int DRAW_RIGHT_TOP_BTN = 2;
  public static final int NO_DRAW_ALL_BTN_AND_BORDER = 0;
  
  public static boolean isDrawBorder(int paramInt)
  {
    return 1 == (paramInt >> 4 & 0x1);
  }
  
  public static boolean isDrawGuideLine(int paramInt)
  {
    return 1 == (paramInt >> 5 & 0x1);
  }
  
  public static boolean isDrawLeftBottom(int paramInt)
  {
    return 1 == (paramInt >> 3 & 0x1);
  }
  
  public static boolean isDrawLeftTop(int paramInt)
  {
    return 1 == (paramInt & 0x1);
  }
  
  public static boolean isDrawRightBottom(int paramInt)
  {
    return 1 == (paramInt >> 2 & 0x1);
  }
  
  public static boolean isDrawRightTop(int paramInt)
  {
    return 1 == (paramInt >> 1 & 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerDrawingOperationMask
 * JD-Core Version:    0.7.0.1
 */