package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundLinearLayout;", "Lcom/tencent/tkd/topicsdk/widget/PressLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "setRoundBackgroundColor", "", "color", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RoundBackgroundLinearLayout
  extends PressLinearLayout
{
  @NotNull
  private GradientDrawable a = new GradientDrawable();
  
  public RoundBackgroundLinearLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.x);
      int i = paramContext.getColor(R.styleable.z, 0);
      int j = paramContext.getColor(R.styleable.B, 0);
      int k = paramContext.getInt(R.styleable.C, -1);
      float f = paramContext.getDimension(R.styleable.A, 0.0F);
      this.a = new GradientDrawable();
      this.a.setColor(i);
      this.a.setCornerRadius(f);
      this.a.setStroke(k, j);
      setBackground((Drawable)this.a);
      setEnablePressEffect(paramContext.getBoolean(R.styleable.y, false));
      paramContext.recycle();
    }
  }
  
  @NotNull
  public final GradientDrawable getBackgroundDrawable()
  {
    return this.a;
  }
  
  public final void setBackgroundDrawable(@NotNull GradientDrawable paramGradientDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramGradientDrawable, "<set-?>");
    this.a = paramGradientDrawable;
  }
  
  public final void setRoundBackgroundColor(int paramInt)
  {
    this.a.setColor(paramInt);
    setBackground((Drawable)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundBackgroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */