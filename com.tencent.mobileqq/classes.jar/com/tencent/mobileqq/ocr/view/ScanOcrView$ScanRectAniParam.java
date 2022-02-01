package com.tencent.mobileqq.ocr.view;

import android.graphics.Rect;

class ScanOcrView$ScanRectAniParam
{
  Rect a = new Rect();
  Rect b = new Rect();
  int c;
  int d;
  int e;
  int f;
  Rect g = new Rect();
  int h;
  int i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currAlpha = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n");
    localStringBuilder.append("currRect = ");
    Object localObject = this.g;
    String str = "";
    if (localObject != null) {
      localObject = ((Rect)localObject).toShortString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("radomAreaIndex = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("radomRect = ");
    localObject = this.a;
    if (localObject != null) {
      localObject = ((Rect)localObject).toShortString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("gapDuration = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("startRect = ");
    Rect localRect = this.b;
    localObject = str;
    if (localRect != null) {
      localObject = localRect.toShortString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append("edageWidth = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.ScanRectAniParam
 * JD-Core Version:    0.7.0.1
 */