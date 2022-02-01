package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexDirection;
import com.tencent.viola.ui.dom.style.FlexPositionType;

public class DomObjectPage
  extends DomObject
{
  public DomObjectPage()
  {
    setPositionType(FlexPositionType.ABSOLUTE);
    setPositionLeft(0.0F);
    setPositionTop(0.0F);
    setPositionRight(0.0F);
    setPositionBottom(0.0F);
    setFlexDirection(FlexDirection.COLUMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectPage
 * JD-Core Version:    0.7.0.1
 */