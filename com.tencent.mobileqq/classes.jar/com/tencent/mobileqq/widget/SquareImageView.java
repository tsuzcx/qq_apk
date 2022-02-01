package com.tencent.mobileqq.widget;

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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqui.R.styleable;

public class SquareImageView
  extends URLImageView
{
  public static final String d = "SquareImageView";
  private float a = 1.0F;
  private float b = 0.0F;
  private int c = -1;
  protected int e;
  protected final RectF f = new RectF();
  protected final Path g = new Path();
  private String h;
  private int i = 20;
  private Paint j = new Paint();
  private int k = -1;
  
  public SquareImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ee);
    this.a = paramContext.getFloat(R.styleable.ej, 1.0F);
    this.b = paramContext.getFloat(R.styleable.ek, 0.0F);
    this.c = paramContext.getColor(R.styleable.ef, -1);
    this.h = paramContext.getString(R.styleable.eg);
    this.i = paramContext.getDimensionPixelSize(R.styleable.eh, 40);
    this.e = paramContext.getDimensionPixelSize(R.styleable.ei, 0);
    paramContext.recycle();
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.e != 0)
    {
      if (this.g.isEmpty())
      {
        Path localPath = this.g;
        RectF localRectF = this.f;
        int m = this.e;
        localPath.addRoundRect(localRectF, m, m, Path.Direction.CW);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        paramCanvas.clipPath(this.g);
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = this.k;
    if (m != -1)
    {
      this.j.setColor(m);
      this.j.setAntiAlias(false);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.j);
    }
    super.onDraw(paramCanvas);
    Paint localPaint;
    Object localObject;
    if (this.c != -1)
    {
      localPaint = new Paint();
      localPaint.setColor(this.c);
      localObject = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      m = this.e;
      paramCanvas.drawRoundRect((RectF)localObject, m, m, localPaint);
    }
    if (!TextUtils.isEmpty(this.h))
    {
      localPaint = new Paint(1);
      localPaint.setTextSize(this.i);
      localPaint.setColor(-1);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localObject = localPaint.getFontMetricsInt();
      paramCanvas.drawText(this.h, getMeasuredWidth() / 2, (getMeasuredHeight() - ((Paint.FontMetricsInt)localObject).ascent - ((Paint.FontMetricsInt)localObject).descent) / 2, localPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 1.0F / this.a + (int)this.b), 1073741824));
  }
  
  public void setCircleBgColor(int paramInt)
  {
    this.k = paramInt;
    invalidate();
  }
  
  public void setFilterColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setFilterText(String paramString)
  {
    this.h = paramString;
    requestLayout();
  }
  
  public void setFilterTextSize(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setImageScale(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 0.0F) {
      this.a = paramFloat1;
    }
    this.b = paramFloat2;
    requestLayout();
  }
  
  public void setRoundRect(int paramInt)
  {
    int m = paramInt;
    if (paramInt <= 0) {
      m = 0;
    }
    this.e = m;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SquareImageView
 * JD-Core Version:    0.7.0.1
 */