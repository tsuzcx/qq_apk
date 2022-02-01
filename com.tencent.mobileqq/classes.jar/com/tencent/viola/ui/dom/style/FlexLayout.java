package com.tencent.viola.ui.dom.style;

import java.util.Arrays;

public class FlexLayout
{
  public static final int DIMENSION_HEIGHT = 1;
  public static final int DIMENSION_WIDTH = 0;
  public static final int POSITION_BOTTOM = 3;
  public static final int POSITION_LEFT = 0;
  public static final int POSITION_RIGHT = 2;
  public static final int POSITION_TOP = 1;
  public float[] dimensions = new float[2];
  public FlexLayoutDirection direction = FlexLayoutDirection.LTR;
  public float[] position = new float[4];
  
  public void copy(FlexLayout paramFlexLayout)
  {
    this.position[0] = paramFlexLayout.position[0];
    this.position[1] = paramFlexLayout.position[1];
    this.position[2] = paramFlexLayout.position[2];
    this.position[3] = paramFlexLayout.position[3];
    this.dimensions[0] = paramFlexLayout.dimensions[0];
    this.dimensions[1] = paramFlexLayout.dimensions[1];
    this.direction = paramFlexLayout.direction;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof FlexLayout)) {
        break;
      }
      paramObject = (FlexLayout)paramObject;
    } while ((FloatUtils.floatsEqual(paramObject.position[0], this.position[0])) && (FloatUtils.floatsEqual(paramObject.position[1], this.position[1])) && (FloatUtils.floatsEqual(paramObject.position[2], this.position[2])) && (FloatUtils.floatsEqual(paramObject.position[3], this.position[3])) && (FloatUtils.floatsEqual(paramObject.dimensions[1], this.dimensions[1])) && (FloatUtils.floatsEqual(paramObject.dimensions[0], this.dimensions[0])));
    return false;
    return false;
  }
  
  public void resetResult()
  {
    Arrays.fill(this.position, 0.0F);
    Arrays.fill(this.dimensions, (0.0F / 0.0F));
    this.direction = FlexLayoutDirection.LTR;
  }
  
  public String toString()
  {
    return "layout: {left: " + this.position[0] + ", top: " + this.position[1] + ", width: " + this.dimensions[0] + ", height: " + this.dimensions[1] + ", direction: " + this.direction + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexLayout
 * JD-Core Version:    0.7.0.1
 */