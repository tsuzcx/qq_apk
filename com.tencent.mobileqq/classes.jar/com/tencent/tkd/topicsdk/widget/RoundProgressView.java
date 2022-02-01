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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundProgressView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "currentProgress", "getCurrentProgress", "()I", "setCurrentProgress", "(I)V", "maxProgress", "", "needNumProgress", "getNeedNumProgress", "()Z", "setNeedNumProgress", "(Z)V", "paint", "Landroid/graphics/Paint;", "progressColor", "progressWidth", "", "rectF", "Landroid/graphics/RectF;", "onAttachedToWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public final class RoundProgressView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
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
    this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.H, -16776961);
    this.jdField_a_of_type_Float = paramContext.getDimension(R.styleable.I, 4.0F);
    setCurrentProgress(paramContext.getInteger(R.styleable.F, 0));
    this.b = paramContext.getInteger(R.styleable.G, 100);
    paramContext.recycle();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2 = getWidth() / 2;
    float f3 = f2 - this.jdField_a_of_type_Float / 2;
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null)
    {
      f1 = f2 - f3;
      f2 += f3;
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1, f1, f2, f2);
    }
    float f1 = this.c * 360.0F / this.b;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if ((localRectF != null) && (paramCanvas != null)) {
      paramCanvas.drawArc(localRectF, -90.0F, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public final void setCurrentProgress(int paramInt)
  {
    this.c = paramInt;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = this.c * 100 / this.b;
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
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append('%');
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundProgressView
 * JD-Core Version:    0.7.0.1
 */