package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDragging", "", "isHandle", "lastRawX", "", "sliderListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/ISliderListener;", "touchSlop", "handleActionCancelOrUp", "", "handleActionDown", "event", "Landroid/view/MotionEvent;", "handleActionMove", "inSliderArea", "e", "init", "notifySliderDown", "rawX", "notifySliderMoveEnd", "notifySliderMoving", "moveX", "onTouchEvent", "setSliderListener", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SliderView
  extends AppCompatImageView
{
  public static final SliderView.Companion a = new SliderView.Companion(null);
  private ISliderListener b;
  private boolean c;
  private final int d;
  private float e;
  private boolean f;
  
  @JvmOverloads
  public SliderView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SliderView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SliderView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ViewConfiguration.get(getContext());
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewConfiguration.get(getContext())");
    this.d = paramContext.getScaledTouchSlop();
    a();
  }
  
  private final void a()
  {
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  private final void a(float paramFloat)
  {
    ISliderListener localISliderListener = this.b;
    if (localISliderListener != null) {
      localISliderListener.a(paramFloat);
    }
  }
  
  private final boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f1 >= 0)
    {
      bool1 = bool2;
      if (paramMotionEvent.getX() <= getWidth()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void b()
  {
    this.c = false;
    this.e = 0.0F;
    getParent().requestDisallowInterceptTouchEvent(false);
    c();
    this.f = true;
  }
  
  private final void b(float paramFloat)
  {
    ISliderListener localISliderListener = this.b;
    if (localISliderListener != null) {
      localISliderListener.b(paramFloat);
    }
  }
  
  private final void b(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent))
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      a(paramMotionEvent.getRawX());
      this.e = paramMotionEvent.getRawX();
      this.f = true;
    }
  }
  
  private final void c()
  {
    ISliderListener localISliderListener = this.b;
    if (localISliderListener != null) {
      localISliderListener.a();
    }
  }
  
  private final void c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    getParent().requestDisallowInterceptTouchEvent(true);
    this.c = true;
    if (this.c) {
      b(f1);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    this.f = false;
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label58;
          }
        }
        else
        {
          c(paramMotionEvent);
          break label58;
        }
      }
      b();
    }
    else
    {
      b(paramMotionEvent);
    }
    label58:
    return this.f;
  }
  
  public final void setSliderListener(@Nullable ISliderListener paramISliderListener)
  {
    this.b = paramISliderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */