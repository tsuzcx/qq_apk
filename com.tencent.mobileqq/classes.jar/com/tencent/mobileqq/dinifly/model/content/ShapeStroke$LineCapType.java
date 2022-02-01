package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Paint.Cap;

public enum ShapeStroke$LineCapType
{
  BUTT,  ROUND,  UNKNOWN;
  
  private ShapeStroke$LineCapType() {}
  
  public Paint.Cap toPaintCap()
  {
    switch (ShapeStroke.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$ShapeStroke$LineCapType[ordinal()])
    {
    default: 
      return Paint.Cap.SQUARE;
    case 1: 
      return Paint.Cap.BUTT;
    }
    return Paint.Cap.ROUND;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType
 * JD-Core Version:    0.7.0.1
 */