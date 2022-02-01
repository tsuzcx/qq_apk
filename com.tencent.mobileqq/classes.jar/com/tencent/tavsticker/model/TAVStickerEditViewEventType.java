package com.tencent.tavsticker.model;

public class TAVStickerEditViewEventType
{
  public static final int EVENT_TYPE_ALL = 15;
  public static final int EVENT_TYPE_CLICK = 8;
  public static final int EVENT_TYPE_DOUBLE_ZOOM_ROTATE = 2;
  public static final int EVENT_TYPE_DRAG = 1;
  public static final int EVENT_TYPE_NONE = 0;
  public static final int EVENT_TYPE_SINGLE_ZOOM_ROTATE = 4;
  
  public static boolean isHandleClick(int paramInt)
  {
    return 1 == (paramInt >> 3 & 0x1);
  }
  
  public static boolean isHandleDoubleZoomRotate(int paramInt)
  {
    return 1 == (paramInt >> 1 & 0x1);
  }
  
  public static boolean isHandleDrag(int paramInt)
  {
    return 1 == (paramInt & 0x1);
  }
  
  public static boolean isHandleSingleZoomRotate(int paramInt)
  {
    return 1 == (paramInt >> 2 & 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerEditViewEventType
 * JD-Core Version:    0.7.0.1
 */