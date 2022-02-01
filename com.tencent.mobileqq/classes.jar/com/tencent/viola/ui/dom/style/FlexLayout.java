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
    float[] arrayOfFloat1 = this.position;
    float[] arrayOfFloat2 = paramFlexLayout.position;
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[1] = arrayOfFloat2[1];
    arrayOfFloat1[2] = arrayOfFloat2[2];
    arrayOfFloat1[3] = arrayOfFloat2[3];
    arrayOfFloat1 = this.dimensions;
    arrayOfFloat2 = paramFlexLayout.dimensions;
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[1] = arrayOfFloat2[1];
    this.direction = paramFlexLayout.direction;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof FlexLayout))
    {
      paramObject = (FlexLayout)paramObject;
      return (FloatUtils.floatsEqual(paramObject.position[0], this.position[0])) && (FloatUtils.floatsEqual(paramObject.position[1], this.position[1])) && (FloatUtils.floatsEqual(paramObject.position[2], this.position[2])) && (FloatUtils.floatsEqual(paramObject.position[3], this.position[3])) && (FloatUtils.floatsEqual(paramObject.dimensions[1], this.dimensions[1])) && (FloatUtils.floatsEqual(paramObject.dimensions[0], this.dimensions[0]));
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("layout: {left: ");
    localStringBuilder.append(this.position[0]);
    localStringBuilder.append(", top: ");
    localStringBuilder.append(this.position[1]);
    localStringBuilder.append(", width: ");
    localStringBuilder.append(this.dimensions[0]);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(this.dimensions[1]);
    localStringBuilder.append(", direction: ");
    localStringBuilder.append(this.direction);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexLayout
 * JD-Core Version:    0.7.0.1
 */