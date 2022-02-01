package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;

public class FaceunlockBgDrawable
  extends IdentifierDrawable
{
  private Paint d = new Paint();
  private int e = -872415232;
  private int f = 0;
  private PorterDuffXfermode g = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private float h;
  private int i;
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    int j = localRect.centerX();
    int k = this.i;
    paramCanvas.clipRect(localRect);
    paramCanvas.drawColor(this.e);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(this.f);
    this.d.setXfermode(this.g);
    paramCanvas.drawCircle(j, this.h, k, this.d);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FaceunlockBgDrawable
 * JD-Core Version:    0.7.0.1
 */