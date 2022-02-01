package com.tencent.mobileqq.gamecenter.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;

class BubblePopupWindow$SharpView
  extends View
{
  private final Paint a;
  private final Path b;
  private int c;
  private int d;
  private int e;
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setAntiAlias(true);
    Path localPath = this.b;
    localPath.reset();
    localPath.moveTo(this.e, 0.0F);
    localPath.lineTo(0.0F, getHeight());
    localPath.lineTo(getWidth(), getHeight());
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.BubblePopupWindow.SharpView
 * JD-Core Version:    0.7.0.1
 */