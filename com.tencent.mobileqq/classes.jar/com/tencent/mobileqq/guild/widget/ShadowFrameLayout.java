package com.tencent.mobileqq.guild.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.impl.R.styleable;

public class ShadowFrameLayout
  extends FrameLayout
{
  private final int a = Color.parseColor("#EEEEEE");
  private float b;
  private Paint c;
  private boolean d;
  private int e;
  private float f;
  private float g;
  private float h;
  
  public ShadowFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShadowFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShadowFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = new Paint();
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAntiAlias(true);
    this.c.setColor(this.e);
    this.c.setShadowLayer(this.f, this.g, this.h, this.e);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.co);
    this.e = paramContext.getColor(R.styleable.cr, this.a);
    this.f = paramContext.getDimension(R.styleable.cu, 0.0F);
    this.g = paramContext.getDimension(R.styleable.cs, 0.0F);
    this.h = paramContext.getDimension(R.styleable.ct, 0.0F);
    this.b = paramContext.getDimension(R.styleable.cp, 0.0F);
    this.d = paramContext.getBoolean(R.styleable.cq, true);
    paramContext.recycle();
  }
  
  @TargetApi(21)
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.d)
    {
      if (getLayerType() != 1) {
        setLayerType(1, null);
      }
      Object localObject = getChildAt(0);
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getTop();
      int k = ((View)localObject).getRight();
      int m = ((View)localObject).getBottom();
      localObject = new RectF(i, j, k, m);
      float f1 = this.b;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.c);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1) {
      return;
    }
    throw new IllegalStateException("子View只能有一个");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ShadowFrameLayout
 * JD-Core Version:    0.7.0.1
 */