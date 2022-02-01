package com.tencent.mobileqq.flashshow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.biz.flashshow.impl.R.styleable;
import com.tencent.image.URLImageView;

public class SquareImageView
  extends URLImageView
{
  protected int a;
  protected final RectF b = new RectF();
  protected final Path c = new Path();
  private float d = 1.0F;
  private float e = 0.0F;
  private int f = -1;
  private String g;
  private int h = 20;
  private Paint i = new Paint();
  private int j = -1;
  
  public SquareImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ek);
    this.d = paramContext.getFloat(R.styleable.ep, 1.0F);
    this.e = paramContext.getFloat(R.styleable.eq, 0.0F);
    this.f = paramContext.getColor(R.styleable.el, -1);
    this.g = paramContext.getString(R.styleable.em);
    this.h = paramContext.getDimensionPixelSize(R.styleable.en, 40);
    this.a = paramContext.getDimensionPixelSize(R.styleable.eo, 0);
    paramContext.recycle();
    setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != 0)
    {
      if (this.c.isEmpty())
      {
        Path localPath = this.c;
        RectF localRectF = this.b;
        int k = this.a;
        localPath.addRoundRect(localRectF, k, k, Path.Direction.CW);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        paramCanvas.clipPath(this.c);
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = this.j;
    if (k != -1)
    {
      this.i.setColor(k);
      this.i.setAntiAlias(false);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.i);
    }
    super.onDraw(paramCanvas);
    Paint localPaint;
    Object localObject;
    if (this.f != -1)
    {
      localPaint = new Paint();
      localPaint.setColor(this.f);
      localObject = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      k = this.a;
      paramCanvas.drawRoundRect((RectF)localObject, k, k, localPaint);
    }
    if (!TextUtils.isEmpty(this.g))
    {
      localPaint = new Paint(1);
      localPaint.setTextSize(this.h);
      localPaint.setColor(-1);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localObject = localPaint.getFontMetricsInt();
      paramCanvas.drawText(this.g, getMeasuredWidth() / 2, (getMeasuredHeight() - ((Paint.FontMetricsInt)localObject).ascent - ((Paint.FontMetricsInt)localObject).descent) / 2, localPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 1.0F / this.d + (int)this.e), 1073741824));
  }
  
  public void setCircleBgColor(int paramInt)
  {
    this.j = paramInt;
    invalidate();
  }
  
  public void setFilterColor(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setFilterText(String paramString)
  {
    this.g = paramString;
    requestLayout();
  }
  
  public void setFilterTextSize(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setImageScale(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 0.0F) {
      this.d = paramFloat1;
    }
    this.e = paramFloat2;
    requestLayout();
  }
  
  public void setRoundRect(int paramInt)
  {
    int k = paramInt;
    if (paramInt <= 0) {
      k = 0;
    }
    this.a = k;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.SquareImageView
 * JD-Core Version:    0.7.0.1
 */