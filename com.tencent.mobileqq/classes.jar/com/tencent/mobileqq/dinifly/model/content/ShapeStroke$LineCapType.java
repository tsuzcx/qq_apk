package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Paint.Cap;

public enum ShapeStroke$LineCapType
{
  BUTT,  ROUND,  UNKNOWN;
  
  private ShapeStroke$LineCapType() {}
  
  public Paint.Cap toPaintCap()
  {
    int i = ShapeStroke.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$ShapeStroke$LineCapType[ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return Paint.Cap.SQUARE;
      }
      return Paint.Cap.ROUND;
    }
    return Paint.Cap.BUTT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType
 * JD-Core Version:    0.7.0.1
 */