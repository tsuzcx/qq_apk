package com.tencent.timi.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.timi_game.impl.R.styleable;

public class RoundProgressBar
  extends View
{
  private Paint a = new Paint();
  private int b;
  private int c;
  private float d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private RectF k;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cP);
    this.b = paramContext.getColor(R.styleable.cS, -65536);
    this.c = paramContext.getColor(R.styleable.cT, -16711936);
    this.d = paramContext.getDimension(R.styleable.cU, 3.0F);
    this.e = paramContext.getInteger(R.styleable.cQ, 100);
    this.f = paramContext.getInteger(R.styleable.cR, 0);
    this.g = paramContext.getInt(R.styleable.cW, 0);
    this.j = paramContext.getInteger(R.styleable.cV, 0);
    paramContext.recycle();
    this.k = new RectF();
  }
  
  public int getCircleColor()
  {
    return this.b;
  }
  
  public int getCircleProgressColor()
  {
    return this.c;
  }
  
  public int getMax()
  {
    return this.e;
  }
  
  public int getProgress()
  {
    return this.f;
  }
  
  public float getRoundWidth()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m;
    int n;
    if (this.g == 2)
    {
      this.a.setAntiAlias(true);
      this.a.setStrokeWidth(this.d);
      this.a.setColor(this.b);
      this.a.setStyle(Paint.Style.FILL_AND_STROKE);
      m = this.f;
      if (m != 0)
      {
        n = this.e;
        if (n > 0)
        {
          RectF localRectF = this.k;
          float f1 = this.j;
          paramCanvas.drawArc(localRectF, m * 360 / n + f1, 360.0F - m * 360 / n, true, this.a);
        }
      }
    }
    else
    {
      this.a.setColor(this.b);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setStrokeWidth(this.d);
      this.a.setAntiAlias(true);
      m = this.h;
      paramCanvas.drawCircle(m, m, this.i, this.a);
      this.a.setStrokeWidth(this.d);
      this.a.setColor(this.c);
      m = this.g;
      if (m != 0)
      {
        if (m != 1) {
          return;
        }
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f != 0)
        {
          m = this.e;
          if (m > 0) {
            paramCanvas.drawArc(this.k, this.j, 360 / m, true, this.a);
          }
        }
      }
      else
      {
        this.a.setStyle(Paint.Style.STROKE);
        m = this.f;
        if (m != 0)
        {
          n = this.e;
          if (n > 0) {
            paramCanvas.drawArc(this.k, this.j, m * 360 / n, false, this.a);
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (getWidth() / 2);
    paramInt1 = this.h;
    this.i = ((int)(paramInt1 - this.d / 2.0F));
    RectF localRectF = this.k;
    paramInt2 = this.i;
    localRectF.left = (paramInt1 - paramInt2);
    localRectF.top = (paramInt1 - paramInt2);
    localRectF.right = (paramInt1 + paramInt2);
    localRectF.bottom = (paramInt1 + paramInt2);
  }
  
  public void setCircleColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    int m = paramInt;
    if (paramInt < 0) {
      m = 1;
    }
    this.e = m;
  }
  
  public void setProgress(int paramInt)
  {
    int m = paramInt;
    if (paramInt < 0) {
      m = 0;
    }
    int n = this.e;
    paramInt = m;
    if (m > n) {
      paramInt = n;
    }
    this.f = paramInt;
    invalidate();
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.widget.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */