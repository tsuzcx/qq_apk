package com.tencent.ttpic.videoshelf.model.edit;

import android.graphics.PointF;
import com.tencent.ttpic.videoshelf.model.template.NodeTextGroup;

public class NodeText
{
  public String alignment;
  public PointF anchor = new PointF();
  public float blurAmount;
  public String color;
  public int editType;
  public int emboss;
  public String fmtstr;
  public int fontBold;
  public int fontFit;
  public int fontItalics;
  public String fontName;
  public float fontSize;
  public int height;
  public String id;
  public int multiRow;
  public int offsetX;
  public int offsetY;
  public String outerStrokeColor;
  public float outerStrokeSize;
  public PointF relativeAnchor = new PointF();
  public String relativeID;
  public String shadowColor;
  public float shadowDx;
  public float shadowDy;
  public String strokeColor;
  public float strokeSize;
  public int vertical;
  public int width;
  public int wmtype;
  
  public void copyFrom(NodeText paramNodeText)
  {
    this.id = paramNodeText.id;
    this.relativeID = paramNodeText.relativeID;
    PointF localPointF = paramNodeText.relativeAnchor;
    if (localPointF != null) {
      this.relativeAnchor.set(localPointF);
    }
    localPointF = paramNodeText.anchor;
    if (localPointF != null) {
      this.anchor.set(localPointF);
    }
    this.offsetX = paramNodeText.offsetX;
    this.offsetY = paramNodeText.offsetY;
    this.width = paramNodeText.width;
    this.height = paramNodeText.height;
    this.editType = paramNodeText.editType;
    this.fontSize = paramNodeText.fontSize;
    this.fontFit = paramNodeText.fontFit;
    this.wmtype = paramNodeText.wmtype;
    this.fmtstr = paramNodeText.fmtstr;
    this.fontName = paramNodeText.fontName;
    this.color = paramNodeText.color;
    this.alignment = paramNodeText.alignment;
    this.shadowColor = paramNodeText.shadowColor;
    this.shadowDx = paramNodeText.shadowDx;
    this.shadowDy = paramNodeText.shadowDy;
    this.blurAmount = paramNodeText.blurAmount;
    this.vertical = paramNodeText.vertical;
    this.fontBold = paramNodeText.fontBold;
    this.fontItalics = paramNodeText.fontItalics;
    this.strokeColor = paramNodeText.strokeColor;
    this.strokeSize = paramNodeText.strokeSize;
    this.emboss = paramNodeText.emboss;
    this.outerStrokeColor = paramNodeText.outerStrokeColor;
    this.outerStrokeSize = paramNodeText.outerStrokeSize;
    this.multiRow = paramNodeText.multiRow;
  }
  
  public void copyFrom(NodeTextGroup paramNodeTextGroup)
  {
    this.id = paramNodeTextGroup.id;
    this.relativeID = paramNodeTextGroup.relativeID;
    if ((paramNodeTextGroup.relativeAnchor != null) && (paramNodeTextGroup.relativeAnchor.length == 2))
    {
      this.relativeAnchor.x = paramNodeTextGroup.relativeAnchor[0];
      this.relativeAnchor.y = paramNodeTextGroup.relativeAnchor[1];
    }
    if ((paramNodeTextGroup.anchor != null) && (paramNodeTextGroup.anchor.length == 2))
    {
      this.anchor.x = paramNodeTextGroup.anchor[0];
      this.anchor.y = paramNodeTextGroup.anchor[1];
    }
    this.offsetX = paramNodeTextGroup.offsetX;
    this.offsetY = paramNodeTextGroup.offsetY;
    this.width = paramNodeTextGroup.width;
    this.height = paramNodeTextGroup.height;
    this.editType = paramNodeTextGroup.editType;
    this.fontSize = paramNodeTextGroup.fontSize;
    this.fontFit = paramNodeTextGroup.fontFit;
    this.wmtype = paramNodeTextGroup.wmtype;
    this.fmtstr = paramNodeTextGroup.fmtstr;
    this.fontName = paramNodeTextGroup.fontName;
    this.color = paramNodeTextGroup.color;
    this.alignment = paramNodeTextGroup.alignment;
    this.shadowColor = paramNodeTextGroup.shadowColor;
    this.shadowDx = paramNodeTextGroup.shadowDx;
    this.shadowDy = paramNodeTextGroup.shadowDy;
    this.blurAmount = paramNodeTextGroup.blurAmount;
    this.vertical = paramNodeTextGroup.vertical;
    this.fontBold = paramNodeTextGroup.fontBold;
    this.fontItalics = paramNodeTextGroup.fontItalics;
    this.strokeColor = paramNodeTextGroup.strokeColor;
    this.strokeSize = paramNodeTextGroup.strokeSize;
    this.emboss = paramNodeTextGroup.emboss;
    this.outerStrokeColor = paramNodeTextGroup.outerStrokeColor;
    this.outerStrokeSize = paramNodeTextGroup.outerStrokeSize;
    this.multiRow = paramNodeTextGroup.multiRow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.edit.NodeText
 * JD-Core Version:    0.7.0.1
 */