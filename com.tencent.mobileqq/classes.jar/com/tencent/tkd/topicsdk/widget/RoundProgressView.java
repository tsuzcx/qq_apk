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
  private final Paint a = new Paint();
  private int b;
  private float c;
  private int d = 100;
  private RectF e;
  private int f;
  private boolean g = true;
  
  public RoundProgressView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundProgressView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.P);
    this.b = paramContext.getColor(R.styleable.S, -16776961);
    this.c = paramContext.getDimension(R.styleable.T, 4.0F);
    setCurrentProgress(paramContext.getInteger(R.styleable.Q, 0));
    this.d = paramContext.getInteger(R.styleable.R, 100);
    paramContext.recycle();
  }
  
  public final int getCurrentProgress()
  {
    return this.f;
  }
  
  public final boolean getNeedNumProgress()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.setStrokeWidth(this.c);
    this.a.setColor(this.b);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2 = getWidth() / 2;
    float f3 = f2 - this.c / 2;
    if (this.e == null)
    {
      f1 = f2 - f3;
      f2 += f3;
      this.e = new RectF(f1, f1, f2, f2);
    }
    float f1 = this.f * 360.0F / this.d;
    RectF localRectF = this.e;
    if ((localRectF != null) && (paramCanvas != null)) {
      paramCanvas.drawArc(localRectF, -90.0F, f1, false, this.a);
    }
  }
  
  public final void setCurrentProgress(int paramInt)
  {
    this.f = paramInt;
    Object localObject;
    if (this.g)
    {
      paramInt = this.f * 100 / this.d;
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
    this.g = paramBoolean;
    Object localObject;
    if (this.g)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundProgressView
 * JD-Core Version:    0.7.0.1
 */