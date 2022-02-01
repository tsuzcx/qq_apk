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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -16777216;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private int c = 100;
  private int d;
  
  public SquareProgressView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.m);
    this.jdField_a_of_type_Float = paramContext.getDimension(R.styleable.K, 0.0F);
    this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.O, -16777216);
    this.jdField_b_of_type_Int = paramContext.getColor(R.styleable.N, 0);
    this.jdField_b_of_type_Float = paramContext.getDimension(R.styleable.P, 4.0F);
    setCurrentProgress(paramContext.getInteger(R.styleable.L, 0));
    this.c = paramContext.getInteger(R.styleable.M, 100);
    paramContext.recycle();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null)
    {
      float f1 = paramInt1;
      float f4 = this.jdField_b_of_type_Float;
      float f5 = 2;
      float f2 = f1 - f4 / f5;
      float f3 = paramInt2;
      f4 = f3 - f4 / f5;
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1 - f2, f3 - f4, f1 + f2, f3 + f4);
    }
  }
  
  private final void a(int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    int i = this.d;
    int j = this.c;
    if (i < j)
    {
      float f = i * 360.0F / j;
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localPath.moveTo(paramInt1, paramInt2);
      localPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, -90.0F, f);
      localPath.close();
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      }
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
    }
  }
  
  private final void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if ((localRectF != null) && (localRectF != null) && (paramCanvas != null))
    {
      float f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_AndroidGraphicsRectF == null)
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
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f2 - f1, f3 - f1, f2 + f1, f3 + f1);
    }
  }
  
  private final void b(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if ((localRectF != null) && (localRectF != null) && (paramCanvas != null))
    {
      float f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    localPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    localPaint.setColor(this.jdField_a_of_type_Int);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    a(i, j);
    a(paramCanvas);
    b(i, j);
    a(i, j, paramCanvas);
    b(paramCanvas);
  }
  
  public final void setCurrentProgress(int paramInt)
  {
    this.d = paramInt;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = this.d * 100 / this.c;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
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
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.SquareProgressView
 * JD-Core Version:    0.7.0.1
 */