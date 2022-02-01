package com.tencent.mobileqq.multimsg.save;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class FileSaveProgressView
  extends TextView
{
  private Paint a;
  private RectF b = new RectF();
  private int c = 0;
  private int d = -1;
  private int e = -16725252;
  private int f = 5;
  private String g = "0%";
  private StringBuffer h;
  
  public FileSaveProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FileSaveProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    setText(this.g);
    this.h = new StringBuffer(this.g);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int k = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    int m = this.d;
    float f1;
    if (m > 0) {
      f1 = m;
    } else {
      f1 = 2.5F;
    }
    this.b.set(f1, f1, j - f1, k - f1);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.f);
    this.a.setColor(this.e);
    j = this.c * 360 / 100;
    paramCanvas.drawArc(this.b, 270.0F, j, false, this.a);
    paramCanvas.restoreToCount(i);
    super.onDraw(paramCanvas);
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0)
    {
      this.c = 0;
      return;
    }
    if (paramInt > 100)
    {
      this.c = 100;
      return;
    }
    if (paramInt < this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileSaveProgressView", 2, "progress < currentProgress, so return;");
      }
    }
    else
    {
      this.c = paramInt;
      StringBuffer localStringBuffer = this.h;
      localStringBuffer.delete(0, localStringBuffer.length());
      localStringBuffer = this.h;
      localStringBuffer.append(paramInt);
      localStringBuffer.append("%");
      this.g = localStringBuffer.toString();
      setText(this.g);
      invalidate();
    }
  }
  
  public void setRingColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveProgressView
 * JD-Core Version:    0.7.0.1
 */