package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class ColorSelectView
  extends View
{
  private int a;
  private boolean b;
  private int c;
  private Paint d;
  private float e;
  
  public ColorSelectView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = DisplayUtil.a(getContext(), 5.0F);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.e = getResources().getDisplayMetrics().density;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredWidth();
    this.d.setColor(this.a);
    this.d.setStyle(Paint.Style.FILL);
    float f = i / 2;
    paramCanvas.drawCircle(f, f, (i - this.c) / 2, this.d);
    if (this.b)
    {
      this.d.setColor(-15550475);
      this.d.setStyle(Paint.Style.STROKE);
      this.d.setStrokeWidth(this.e);
      paramCanvas.drawCircle(f, f, f - this.e, this.d);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorSelectView
 * JD-Core Version:    0.7.0.1
 */