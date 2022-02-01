package com.tencent.tkd.topicsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundProgressView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "currentProgress", "getCurrentProgress", "()I", "setCurrentProgress", "(I)V", "maxProgress", "getMaxProgress", "setMaxProgress", "", "needNumProgress", "getNeedNumProgress", "()Z", "setNeedNumProgress", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "progressColor", "getProgressColor", "setProgressColor", "progressWidth", "", "getProgressWidth", "()F", "setProgressWidth", "(F)V", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "setRectF", "(Landroid/graphics/RectF;)V", "onAttachedToWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public final class RoundProgressView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  @Nullable
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 100;
  private int c;
  
  public RoundProgressView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundProgressView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.k);
    this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.F, -16776961);
    this.jdField_a_of_type_Float = paramContext.getDimension(R.styleable.H, 4.0F);
    this.b = paramContext.getInteger(R.styleable.G, 100);
    paramContext.recycle();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    float f = i - this.jdField_a_of_type_Float / 2;
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(i - f, i - f, i + f, i + f);
    }
    f = 360.0F * this.c / this.b;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if ((localRectF != null) && (paramCanvas != null)) {
      paramCanvas.drawArc(localRectF, -90.0F, f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public final void setCurrentProgress(int paramInt)
  {
    this.c = paramInt;
    if (this.jdField_a_of_type_Boolean) {}
    for (CharSequence localCharSequence = (CharSequence)(this.c + '%');; localCharSequence = (CharSequence)"")
    {
      setText(localCharSequence);
      return;
    }
  }
  
  public final void setMaxProgress(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setNeedNumProgress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {}
    for (CharSequence localCharSequence = (CharSequence)(this.c + '%');; localCharSequence = (CharSequence)"")
    {
      setText(localCharSequence);
      return;
    }
  }
  
  public final void setProgressColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public final void setRectF(@Nullable RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundProgressView
 * JD-Core Version:    0.7.0.1
 */