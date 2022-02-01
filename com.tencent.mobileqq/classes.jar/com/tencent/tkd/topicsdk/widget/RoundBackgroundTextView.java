package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundTextView;", "Lcom/tencent/tkd/topicsdk/widget/PressTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RoundBackgroundTextView
  extends PressTextView
{
  public RoundBackgroundTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.j);
      int i = paramContext.getColor(R.styleable.B, 0);
      int j = paramContext.getColor(R.styleable.D, 0);
      int k = paramContext.getInt(R.styleable.E, -1);
      float f = paramContext.getDimension(R.styleable.C, 0.0F);
      paramAttributeSet = new GradientDrawable();
      paramAttributeSet.setColor(i);
      paramAttributeSet.setCornerRadius(f);
      paramAttributeSet.setStroke(k, j);
      setBackground((Drawable)paramAttributeSet);
      setEnablePressEffect(paramContext.getBoolean(R.styleable.A, false));
      paramContext.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundBackgroundTextView
 * JD-Core Version:    0.7.0.1
 */