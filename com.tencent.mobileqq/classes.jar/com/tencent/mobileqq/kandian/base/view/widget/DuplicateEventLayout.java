package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;

public class DuplicateEventLayout
  extends FrameLayout
{
  ViewGroup a;
  ClipDianDianTouchAreaLayout b;
  int c;
  boolean d = false;
  boolean e;
  Rect f = new Rect();
  
  public DuplicateEventLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DuplicateEventLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.a.getLeft();
    int j = getScrollY() - this.a.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.a.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.b.getLeft();
    int j = getScrollY() - this.b.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.b.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.b != null))
    {
      int i = paramMotionEvent.getAction();
      if (i == 0)
      {
        this.b.getHitRect(this.f);
        i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if (this.f.contains(i, j))
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          this.e = bool;
        }
        else
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          this.e = false;
        }
        this.d = false;
        return bool;
      }
      MotionEvent localMotionEvent1 = MotionEvent.obtain(paramMotionEvent);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((this.e) && ((!bool) || ((bool) && (this.b.a))))
      {
        if (!this.d)
        {
          MotionEvent localMotionEvent2 = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent2.setAction(0);
          a(localMotionEvent2);
          this.d = true;
          localMotionEvent2.recycle();
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setAction(3);
          b(paramMotionEvent);
        }
        a(localMotionEvent1);
      }
      localMotionEvent1.recycle();
      if (((i == 1) || (i == 3)) && (QLog.isColorLevel()))
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("action = ");
        paramMotionEvent.append(i);
        QLog.d("DuplicateEventLayout", 0, paramMotionEvent.toString());
      }
      return bool;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setViews(ViewGroup paramViewGroup, ClipDianDianTouchAreaLayout paramClipDianDianTouchAreaLayout)
  {
    this.a = paramViewGroup;
    this.b = paramClipDianDianTouchAreaLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.DuplicateEventLayout
 * JD-Core Version:    0.7.0.1
 */