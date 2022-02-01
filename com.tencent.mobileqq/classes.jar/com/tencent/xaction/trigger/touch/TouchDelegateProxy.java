package com.tencent.xaction.trigger.touch;

import android.graphics.Rect;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.core.view.GestureDetectorCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/touch/TouchDelegateProxy;", "Landroid/view/TouchDelegate;", "Landroid/view/GestureDetector$OnGestureListener;", "view", "Landroid/view/View;", "originTouchDelegate", "(Landroid/view/View;Landroid/view/TouchDelegate;)V", "gestureDetectorCompat", "Landroidx/core/view/GestureDetectorCompat;", "triggerClickListener", "Landroid/view/View$OnClickListener;", "getTriggerClickListener", "()Landroid/view/View$OnClickListener;", "setTriggerClickListener", "(Landroid/view/View$OnClickListener;)V", "triggerTouchListener", "Landroid/view/View$OnTouchListener;", "getTriggerTouchListener", "()Landroid/view/View$OnTouchListener;", "setTriggerTouchListener", "(Landroid/view/View$OnTouchListener;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "event", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class TouchDelegateProxy
  extends TouchDelegate
  implements GestureDetector.OnGestureListener
{
  @Nullable
  private View.OnTouchListener a;
  @Nullable
  private View.OnClickListener b;
  private final GestureDetectorCompat c;
  private View d;
  private TouchDelegate e;
  
  public TouchDelegateProxy(@NotNull View paramView, @Nullable TouchDelegate paramTouchDelegate)
  {
    super(new Rect(), paramView);
    this.d = paramView;
    this.e = paramTouchDelegate;
    this.c = new GestureDetectorCompat(this.d.getContext(), (GestureDetector.OnGestureListener)this);
  }
  
  public final void a(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public final void a(@Nullable View.OnTouchListener paramOnTouchListener)
  {
    this.a = paramOnTouchListener;
  }
  
  public boolean onDown(@Nullable MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(@Nullable MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(@Nullable MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(@Nullable MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.b;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.onClick(this.d);
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((TouchDelegate)localObject).onTouchEvent(paramMotionEvent) == true)) {
      return true;
    }
    localObject = this.a;
    if ((localObject != null) && (((View.OnTouchListener)localObject).onTouch(this.d, paramMotionEvent) == true)) {
      return true;
    }
    return this.c.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.TouchDelegateProxy
 * JD-Core Version:    0.7.0.1
 */