package com.tencent.tkd.topicsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/PressImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enablePressEffect", "", "getEnablePressEffect", "()Z", "setEnablePressEffect", "(Z)V", "mIsDarkBg", "mIsScale", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public class PressImageView
  extends ImageView
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public PressImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
      this.a = paramContext.getBoolean(R.styleable.d, false);
      this.b = paramContext.getBoolean(R.styleable.e, false);
      paramContext.recycle();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((isEnabled()) && (this.c))
      {
        PressView.a.a((View)this, this.a, this.b);
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
      if ((isEnabled()) && (this.c)) {
        PressView.a.b((View)this, this.a, this.b);
      }
    }
  }
  
  public void onVisibilityChanged(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "changedView");
    clearAnimation();
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public final void setEnablePressEffect(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.PressImageView
 * JD-Core Version:    0.7.0.1
 */