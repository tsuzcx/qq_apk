package com.tencent.viola.ui.dom.style;

import java.util.Arrays;

public class FlexStyle
{
  public FlexAlign alignContent;
  public FlexAlign alignItems;
  public FlexAlign alignSelf;
  public StyleSpace border = new StyleSpace();
  public float[] dimensions = new float[2];
  public FlexLayoutDirection direction;
  public float flex;
  public FlexDirection flexDirection;
  public FlexWrap flexWrap;
  public FlexJustifyContent justifyContent;
  public StyleSpace margin = new StyleSpace();
  public float maxHeight = (0.0F / 0.0F);
  public float maxWidth = (0.0F / 0.0F);
  public float[] minDimensions = new float[2];
  public float minHeight = (0.0F / 0.0F);
  public float minWidth = (0.0F / 0.0F);
  public StyleSpace padding = new StyleSpace();
  public float[] position = new float[4];
  public FlexPositionType positionType;
  
  FlexStyle()
  {
    reset();
  }
  
  public void copy(FlexStyle paramFlexStyle)
  {
    this.direction = paramFlexStyle.direction;
    this.flexDirection = paramFlexStyle.flexDirection;
    this.justifyContent = paramFlexStyle.justifyContent;
    this.alignContent = paramFlexStyle.alignContent;
    this.alignItems = paramFlexStyle.alignItems;
    this.alignSelf = paramFlexStyle.alignSelf;
    this.positionType = paramFlexStyle.positionType;
    this.flexWrap = paramFlexStyle.flexWrap;
    this.flex = paramFlexStyle.flex;
    this.margin = paramFlexStyle.margin;
    this.padding = paramFlexStyle.padding;
    this.border = paramFlexStyle.border;
    float[] arrayOfFloat1 = this.position;
    float[] arrayOfFloat2 = paramFlexStyle.position;
    arrayOfFloat1[1] = arrayOfFloat2[1];
    arrayOfFloat1[3] = arrayOfFloat2[3];
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[2] = arrayOfFloat2[2];
    arrayOfFloat1 = this.dimensions;
    arrayOfFloat2 = paramFlexStyle.dimensions;
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[1] = arrayOfFloat2[1];
    this.minWidth = paramFlexStyle.minWidth;
    this.minHeight = paramFlexStyle.minHeight;
    this.maxWidth = paramFlexStyle.maxWidth;
    this.maxHeight = paramFlexStyle.maxHeight;
    this.minDimensions[1] = paramFlexStyle.minHeight;
  }
  
  public void reset()
  {
    this.direction = FlexLayoutDirection.INHERIT;
    this.flexDirection = FlexDirection.COLUMN;
    FlexJustifyContent localFlexJustifyContent = FlexJustifyContent.FLEX_END;
    this.justifyContent = FlexJustifyContent.FLEX_START;
    this.alignContent = FlexAlign.FLEX_START;
    this.alignItems = FlexAlign.STRETCH;
    this.alignSelf = FlexAlign.AUTO;
    this.positionType = FlexPositionType.RELATIVE;
    this.flexWrap = FlexWrap.NOWRAP;
    this.flex = 0.0F;
    this.margin.reset();
    this.padding.reset();
    this.border.reset();
    Arrays.fill(this.position, (0.0F / 0.0F));
    Arrays.fill(this.dimensions, (0.0F / 0.0F));
    Arrays.fill(this.minDimensions, (0.0F / 0.0F));
    this.minWidth = (0.0F / 0.0F);
    this.minHeight = (0.0F / 0.0F);
    this.maxWidth = (0.0F / 0.0F);
    this.maxHeight = (0.0F / 0.0F);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("direction =");
    localStringBuilder.append(this.direction);
    localStringBuilder.append("\nflexDirection =");
    localStringBuilder.append(this.flexDirection);
    localStringBuilder.append("\njustifyContent=");
    localStringBuilder.append(this.justifyContent);
    localStringBuilder.append("\nalignContent =");
    localStringBuilder.append(this.alignContent);
    localStringBuilder.append("\nalignItems =");
    localStringBuilder.append(this.alignItems);
    localStringBuilder.append("\nalignSelf =");
    localStringBuilder.append(this.alignSelf);
    localStringBuilder.append("\npositionType =");
    localStringBuilder.append(this.positionType);
    localStringBuilder.append("\nflexWrap =");
    localStringBuilder.append(this.flexWrap);
    localStringBuilder.append("\nflex =");
    localStringBuilder.append(this.flex);
    localStringBuilder.append("\nmargin =");
    localStringBuilder.append(this.margin);
    localStringBuilder.append("\npadding =");
    localStringBuilder.append(this.padding);
    localStringBuilder.append("\nborder =");
    localStringBuilder.append(this.border);
    localStringBuilder.append("\nposition[POSITION_TOP] =");
    localStringBuilder.append(this.position[1]);
    localStringBuilder.append("\nposition[POSITION_BOTTOM] =");
    localStringBuilder.append(this.position[3]);
    localStringBuilder.append("\nposition[POSITION_LEFT] =");
    localStringBuilder.append(this.position[0]);
    localStringBuilder.append("\nposition[POSITION_RIGHT] =");
    localStringBuilder.append(this.position[2]);
    localStringBuilder.append("\nposition[DIMENSION_WIDTH] =");
    localStringBuilder.append(this.position[0]);
    localStringBuilder.append("\nposition[DIMENSION_HEIGHT] =");
    localStringBuilder.append(this.position[1]);
    localStringBuilder.append("\nminWidth =");
    localStringBuilder.append(this.minWidth);
    localStringBuilder.append("\nminHeight =");
    localStringBuilder.append(this.minHeight);
    localStringBuilder.append("\nmaxWidth =");
    localStringBuilder.append(this.maxWidth);
    localStringBuilder.append("\nmaxHeight =");
    localStringBuilder.append(this.maxHeight);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexStyle
 * JD-Core Version:    0.7.0.1
 */