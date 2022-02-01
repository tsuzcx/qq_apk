package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundRelativeLayout;", "Lcom/tencent/tkd/topicsdk/widget/PressRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setRoundBackgroundColor", "", "color", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RoundBackgroundRelativeLayout
  extends PressRelativeLayout
{
  private GradientDrawable a = new GradientDrawable();
  
  public RoundBackgroundRelativeLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.D);
      int i = paramContext.getColor(R.styleable.F, 0);
      int j = paramContext.getColor(R.styleable.H, 0);
      int k = paramContext.getInt(R.styleable.I, -1);
      float f = paramContext.getDimension(R.styleable.G, 0.0F);
      paramAttributeSet = new GradientDrawable();
      paramAttributeSet.setColor(i);
      paramAttributeSet.setCornerRadius(f);
      paramAttributeSet.setStroke(k, j);
      this.a = paramAttributeSet;
      setBackground((Drawable)this.a);
      setEnablePressEffect(paramContext.getBoolean(R.styleable.E, false));
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
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundBackgroundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */