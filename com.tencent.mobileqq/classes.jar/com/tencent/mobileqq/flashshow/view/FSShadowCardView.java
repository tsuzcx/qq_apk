package com.tencent.mobileqq.flashshow.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.flashshow.impl.R.styleable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class FSShadowCardView
  extends FrameLayout
{
  private static final int a = 2131166088;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public FSShadowCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSShadowCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSShadowCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      int m = getResources().getColor(a);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bl);
      this.b = paramContext.getDimensionPixelSize(R.styleable.bu, 0);
      this.c = paramContext.getResourceId(R.styleable.br, m);
      this.d = paramContext.getResourceId(R.styleable.bo, -1);
      this.h = paramContext.getDimensionPixelSize(R.styleable.bv, 5);
      this.j = paramContext.getDimensionPixelSize(R.styleable.bt, 5);
      this.i = paramContext.getDimensionPixelSize(R.styleable.bs, 5);
      this.k = paramContext.getDimensionPixelSize(R.styleable.bn, 5);
      this.f = paramContext.getDimensionPixelSize(R.styleable.bq, 0);
      this.g = paramContext.getDimensionPixelSize(R.styleable.bp, 0);
      this.e = paramContext.getDimensionPixelSize(R.styleable.bm, 10);
      paramContext.recycle();
    }
    catch (Exception paramContext)
    {
      label148:
      break label148;
    }
    QLog.e("FSShadowCardView", 1, "init ShadowCardView catch exception");
    setPadding(this.i, this.h, this.j, this.k);
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int i1 = getWidth();
    int i2 = getPaddingRight();
    int i3 = getHeight();
    int i4 = getPaddingBottom();
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setColor(QCircleSkinHelper.getInstance().getColor(this.d));
    localPaint.setShadowLayer(this.e, this.g, this.f, QCircleSkinHelper.getInstance().getColor(this.c));
    RectF localRectF = new RectF(m, n, i1 - i2, i3 - i4);
    m = this.b;
    paramCanvas.drawRoundRect(localRectF, m, m, localPaint);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.FSShadowCardView
 * JD-Core Version:    0.7.0.1
 */