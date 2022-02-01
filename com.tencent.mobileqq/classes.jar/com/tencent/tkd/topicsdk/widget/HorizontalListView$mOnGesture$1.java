package com.tencent.tkd.topicsdk.widget;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/HorizontalListView$mOnGesture$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "isEventWithinView", "", "motionEvent", "Landroid/view/MotionEvent;", "child", "Landroid/view/View;", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "e", "onScroll", "distanceX", "distanceY", "onSingleTapConfirmed", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class HorizontalListView$mOnGesture$1
  extends GestureDetector.SimpleOnGestureListener
{
  private final boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    localRect.set(i, k, j + i, paramView.getHeight() + k);
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  public boolean onDown(@Nullable MotionEvent paramMotionEvent)
  {
    return HorizontalListView.e(this.a);
  }
  
  public boolean onFling(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return HorizontalListView.a(this.a, paramFloat1);
  }
  
  public void onLongPress(@Nullable MotionEvent paramMotionEvent)
  {
    ListAdapter localListAdapter = HorizontalListView.a(this.a);
    if (localListAdapter != null)
    {
      if (paramMotionEvent != null)
      {
        int j = this.a.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.a.getChildAt(i);
          Intrinsics.checkExpressionValueIsNotNull(localView, "child");
          if (a(paramMotionEvent, localView))
          {
            if (HorizontalListView.b(this.a) == null) {
              break;
            }
            paramMotionEvent = HorizontalListView.b(this.a);
            if (paramMotionEvent == null) {
              break;
            }
            HorizontalListView localHorizontalListView = this.a;
            paramMotionEvent.onItemLongClick((AdapterView)localHorizontalListView, localView, HorizontalListView.c(localHorizontalListView) + 1 + i, localListAdapter.getItemId(HorizontalListView.c(this.a) + 1 + i));
            return;
          }
          i += 1;
        }
        return;
      }
      super.onLongPress(paramMotionEvent);
    }
  }
  
  public boolean onScroll(@Nullable MotionEvent arg1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      paramMotionEvent2 = this.a;
      HorizontalListView.a(paramMotionEvent2, HorizontalListView.d(paramMotionEvent2) + (int)paramFloat1);
      paramMotionEvent2 = Unit.INSTANCE;
      this.a.requestLayout();
      return true;
    }
  }
  
  public boolean onSingleTapConfirmed(@Nullable MotionEvent paramMotionEvent)
  {
    ListAdapter localListAdapter = HorizontalListView.a(this.a);
    int i = 0;
    if (localListAdapter != null)
    {
      if (paramMotionEvent != null)
      {
        int j = this.a.getChildCount();
        while (i < j)
        {
          View localView = this.a.getChildAt(i);
          Intrinsics.checkExpressionValueIsNotNull(localView, "child");
          if (a(paramMotionEvent, localView))
          {
            if (HorizontalListView.f(this.a) != null)
            {
              paramMotionEvent = HorizontalListView.f(this.a);
              if (paramMotionEvent != null)
              {
                localHorizontalListView = this.a;
                paramMotionEvent.onItemClick((AdapterView)localHorizontalListView, localView, HorizontalListView.c(localHorizontalListView) + 1 + i, localListAdapter.getItemId(HorizontalListView.c(this.a) + 1 + i));
              }
            }
            if (HorizontalListView.g(this.a) == null) {
              break;
            }
            paramMotionEvent = HorizontalListView.g(this.a);
            if (paramMotionEvent == null) {
              break;
            }
            HorizontalListView localHorizontalListView = this.a;
            paramMotionEvent.onItemSelected((AdapterView)localHorizontalListView, localView, HorizontalListView.c(localHorizontalListView) + 1 + i, localListAdapter.getItemId(HorizontalListView.c(this.a) + 1 + i));
            return true;
          }
          i += 1;
        }
        return true;
      }
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.HorizontalListView.mOnGesture.1
 * JD-Core Version:    0.7.0.1
 */