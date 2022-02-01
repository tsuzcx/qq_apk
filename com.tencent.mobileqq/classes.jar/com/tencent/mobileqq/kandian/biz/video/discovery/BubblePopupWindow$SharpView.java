package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;

class BubblePopupWindow$SharpView
  extends View
{
  private final Paint b = new Paint(1);
  private final Path c = new Path();
  private int d;
  private int e;
  private int f = 0;
  
  public BubblePopupWindow$SharpView(BubblePopupWindow paramBubblePopupWindow, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.b.setStyle(Paint.Style.FILL_AND_STROKE);
    this.b.setAntiAlias(true);
    Path localPath = this.c;
    localPath.reset();
    localPath.moveTo(this.f, 0.0F);
    localPath.lineTo(0.0F, getHeight());
    localPath.lineTo(getWidth(), getHeight());
    localPath.close();
    paramCanvas.drawPath(localPath, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow.SharpView
 * JD-Core Version:    0.7.0.1
 */