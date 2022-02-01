package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundTextView;", "Lcom/tencent/tkd/topicsdk/widget/PressTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setRoundBackgroundColor", "", "color", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RoundBackgroundTextView
  extends PressTextView
{
  private GradientDrawable a = new GradientDrawable();
  
  public RoundBackgroundTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.J);
      int i = paramContext.getColor(R.styleable.L, 0);
      int j = paramContext.getColor(R.styleable.N, 0);
      int k = paramContext.getInt(R.styleable.O, -1);
      float f = paramContext.getDimension(R.styleable.M, 0.0F);
      this.a.setColor(i);
      this.a.setCornerRadius(f);
      this.a.setStroke(k, j);
      setBackground((Drawable)this.a);
      setEnablePressEffect(paramContext.getBoolean(R.styleable.K, false));
      paramContext.recycle();
    }
  }
  
  public final void setRoundBackgroundColor(int paramInt)
  {
    this.a.setColor(paramInt);
    setBackground((Drawable)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundBackgroundTextView
 * JD-Core Version:    0.7.0.1
 */