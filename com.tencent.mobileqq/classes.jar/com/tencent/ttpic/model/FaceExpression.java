package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.ExpressionItem;
import java.util.List;

public class FaceExpression
{
  public String audioID;
  public List<CanvasItem> canvasItemList;
  public int canvasResizeMode;
  public SizeI canvasSize;
  public List<ExpressionItem> expressionList;
  public int expressionNumber;
  public double frameDuration;
  public int frames;
  public String id;
  public String scoreImageID;
  public String videoID;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceExpression
 * JD-Core Version:    0.7.0.1
 */