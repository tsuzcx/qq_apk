package com.tencent.viola.ui.dom.style;

import com.tencent.viola.ui.dom.Style;

public class DrawLayoutStyle
{
  public static final int DIMENSION_HEIGHT = 1;
  public static final int DIMENSION_WIDTH = 0;
  public static final int POSITION_BOTTOM = 3;
  public static final int POSITION_LEFT = 0;
  public static final int POSITION_RIGHT = 2;
  public static final int POSITION_TOP = 1;
  public float[] dimensions = new float[2];
  public FlexStyle flexStyle;
  public StyleSpace margin;
  public float maxHeiht = (0.0F / 0.0F);
  public float maxWidth = (0.0F / 0.0F);
  public float minHeight = (0.0F / 0.0F);
  public float minWidth = (0.0F / 0.0F);
  public StyleSpace padding;
  public float[] position = new float[4];
  
  public DrawLayoutStyle(Style paramStyle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.DrawLayoutStyle
 * JD-Core Version:    0.7.0.1
 */