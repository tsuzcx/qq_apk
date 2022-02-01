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
  private TouchDelegate jdField_a_of_type_AndroidViewTouchDelegate;
  @Nullable
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  @Nullable
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private View jdField_a_of_type_AndroidViewView;
  private final GestureDetectorCompat jdField_a_of_type_AndroidxCoreViewGestureDetectorCompat;
  
  public TouchDelegateProxy(@NotNull View paramView, @Nullable TouchDelegate paramTouchDelegate)
  {
    super(new Rect(), paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewTouchDelegate = paramTouchDelegate;
    this.jdField_a_of_type_AndroidxCoreViewGestureDetectorCompat = new GestureDetectorCompat(this.jdField_a_of_type_AndroidViewView.getContext(), (GestureDetector.OnGestureListener)this);
  }
  
  public final void a(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public final void a(@Nullable View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
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
    paramMotionEvent = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.onClick(this.jdField_a_of_type_AndroidViewView);
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewTouchDelegate;
    if ((localObject != null) && (((TouchDelegate)localObject).onTouchEvent(paramMotionEvent) == true)) {
      return true;
    }
    localObject = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
    if ((localObject != null) && (((View.OnTouchListener)localObject).onTouch(this.jdField_a_of_type_AndroidViewView, paramMotionEvent) == true)) {
      return true;
    }
    return this.jdField_a_of_type_AndroidxCoreViewGestureDetectorCompat.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.TouchDelegateProxy
 * JD-Core Version:    0.7.0.1
 */