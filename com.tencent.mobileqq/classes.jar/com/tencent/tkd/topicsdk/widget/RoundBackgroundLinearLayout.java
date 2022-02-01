package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundLinearLayout;", "Lcom/tencent/tkd/topicsdk/widget/PressLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RoundBackgroundLinearLayout
  extends PressLinearLayout
{
  public RoundBackgroundLinearLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.h);
      int i = paramContext.getColor(R.styleable.r, 0);
      int j = paramContext.getColor(R.styleable.t, 0);
      int k = paramContext.getInt(R.styleable.u, -1);
      float f = paramContext.getDimension(R.styleable.s, 0.0F);
      paramAttributeSet = new GradientDrawable();
      paramAttributeSet.setColor(i);
      paramAttributeSet.setCornerRadius(f);
      paramAttributeSet.setStroke(k, j);
      setBackground((Drawable)paramAttributeSet);
      setEnablePressEffect(paramContext.getBoolean(R.styleable.q, false));
      paramContext.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundBackgroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */