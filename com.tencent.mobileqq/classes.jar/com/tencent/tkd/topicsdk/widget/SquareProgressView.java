package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/SquareProgressView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clipRectF", "Landroid/graphics/RectF;", "cornerRadius", "", "value", "", "currentProgress", "getCurrentProgress", "()I", "setCurrentProgress", "(I)V", "maxProgress", "", "needNumProgress", "getNeedNumProgress", "()Z", "setNeedNumProgress", "(Z)V", "path", "Landroid/graphics/Path;", "progressBgColor", "progressColor", "getProgressColor", "setProgressColor", "progressWidth", "rectF", "strokePaint", "Landroid/graphics/Paint;", "clipCanvasForProgress", "", "viewCenterX", "viewCenterY", "canvas", "Landroid/graphics/Canvas;", "drawProgressBackground", "drawProgressForeground", "initClipRectF", "initRectF", "onAttachedToWindow", "onDraw", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class SquareProgressView
  extends TextView
{
  private float a;
  private int b = -16777216;
  private int c;
  private float d;
  private int e = 100;
  private final Paint f = new Paint();
  private Path g = new Path();
  private RectF h;
  private RectF i;
  private int j;
  private boolean k;
  
  public SquareProgressView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.W);
    this.a = paramContext.getDimension(R.styleable.X, 0.0F);
    this.b = paramContext.getColor(R.styleable.ab, -16777216);
    this.c = paramContext.getColor(R.styleable.aa, 0);
    this.d = paramContext.getDimension(R.styleable.ac, 4.0F);
    setCurrentProgress(paramContext.getInteger(R.styleable.Y, 0));
    this.e = paramContext.getInteger(R.styleable.Z, 100);
    paramContext.recycle();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (this.h == null)
    {
      float f1 = paramInt1;
      float f4 = this.d;
      float f5 = 2;
      float f2 = f1 - f4 / f5;
      float f3 = paramInt2;
      f4 = f3 - f4 / f5;
      this.h = new RectF(f1 - f2, f3 - f4, f1 + f2, f3 + f4);
    }
  }
  
  private final void a(int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    int m = this.j;
    int n = this.e;
    if (m < n)
    {
      float f1 = m * 360.0F / n;
      Path localPath = this.g;
      localPath.moveTo(paramInt1, paramInt2);
      localPath.arcTo(this.i, -90.0F, f1);
      localPath.close();
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.g);
      }
      this.g.reset();
    }
  }
  
  private final void a(Canvas paramCanvas)
  {
    this.f.setColor(this.c);
    RectF localRectF = this.h;
    if ((localRectF != null) && (localRectF != null) && (paramCanvas != null))
    {
      float f1 = this.a;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.f);
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    if (this.i == null)
    {
      double d2 = getWidth();
      double d1 = 2;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d2 = Math.pow(d2 / d1, 2.0D);
      double d3 = getHeight();
      Double.isNaN(d3);
      Double.isNaN(d1);
      float f1 = (float)Math.sqrt(d2 + Math.pow(d3 / d1, 2.0D));
      float f2 = paramInt1;
      float f3 = paramInt2;
      this.i = new RectF(f2 - f1, f3 - f1, f2 + f1, f3 + f1);
    }
  }
  
  private final void b(Canvas paramCanvas)
  {
    this.f.setColor(this.b);
    RectF localRectF = this.h;
    if ((localRectF != null) && (localRectF != null) && (paramCanvas != null))
    {
      float f1 = this.a;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.f);
    }
  }
  
  public final int getCurrentProgress()
  {
    return this.j;
  }
  
  public final boolean getNeedNumProgress()
  {
    return this.k;
  }
  
  public final int getProgressColor()
  {
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Paint localPaint = this.f;
    localPaint.setStrokeWidth(this.d);
    localPaint.setColor(this.b);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getWidth() / 2;
    int n = getHeight() / 2;
    a(m, n);
    a(paramCanvas);
    b(m, n);
    a(m, n, paramCanvas);
    b(paramCanvas);
  }
  
  public final void setCurrentProgress(int paramInt)
  {
    this.j = paramInt;
    Object localObject;
    if (this.k)
    {
      paramInt = this.j * 100 / this.e;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append('%');
      localObject = (CharSequence)((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = (CharSequence)"";
    }
    setText((CharSequence)localObject);
  }
  
  public final void setNeedNumProgress(boolean paramBoolean)
  {
    this.k = paramBoolean;
    Object localObject;
    if (this.k)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append('%');
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    setText((CharSequence)localObject);
  }
  
  public final void setProgressColor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.SquareProgressView
 * JD-Core Version:    0.7.0.1
 */