package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class CameraGridView
  extends View
{
  private int a = 2;
  private int b = 2;
  private int c;
  private int d;
  private Paint e = null;
  
  public CameraGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.e = new Paint();
    this.e.setColor(-1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setStrokeWidth(DisplayUtil.a(getContext(), 0.5F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.c;
    int j = this.a;
    int k = 1;
    int n = i / (j + 1);
    int m = this.d / (this.b + 1);
    i = 1;
    float f;
    for (;;)
    {
      j = k;
      if (i > this.a) {
        break;
      }
      f = n * i;
      paramCanvas.drawLine(f, 0.0F, f, this.d, this.e);
      i += 1;
    }
    while (j <= this.b)
    {
      f = m * j;
      paramCanvas.drawLine(0.0F, f, this.c, f, this.e);
      j += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CameraGridView
 * JD-Core Version:    0.7.0.1
 */