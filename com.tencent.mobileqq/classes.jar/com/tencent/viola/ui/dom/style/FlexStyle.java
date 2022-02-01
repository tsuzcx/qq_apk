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
    this.position[1] = paramFlexStyle.position[1];
    this.position[3] = paramFlexStyle.position[3];
    this.position[0] = paramFlexStyle.position[0];
    this.position[2] = paramFlexStyle.position[2];
    this.dimensions[0] = paramFlexStyle.dimensions[0];
    this.dimensions[1] = paramFlexStyle.dimensions[1];
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
    return "direction =" + this.direction + "\nflexDirection =" + this.flexDirection + "\njustifyContent=" + this.justifyContent + "\nalignContent =" + this.alignContent + "\nalignItems =" + this.alignItems + "\nalignSelf =" + this.alignSelf + "\npositionType =" + this.positionType + "\nflexWrap =" + this.flexWrap + "\nflex =" + this.flex + "\nmargin =" + this.margin + "\npadding =" + this.padding + "\nborder =" + this.border + "\nposition[POSITION_TOP] =" + this.position[1] + "\nposition[POSITION_BOTTOM] =" + this.position[3] + "\nposition[POSITION_LEFT] =" + this.position[0] + "\nposition[POSITION_RIGHT] =" + this.position[2] + "\nposition[DIMENSION_WIDTH] =" + this.position[0] + "\nposition[DIMENSION_HEIGHT] =" + this.position[1] + "\nminWidth =" + this.minWidth + "\nminHeight =" + this.minHeight + "\nmaxWidth =" + this.maxWidth + "\nmaxHeight =" + this.maxHeight + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexStyle
 * JD-Core Version:    0.7.0.1
 */