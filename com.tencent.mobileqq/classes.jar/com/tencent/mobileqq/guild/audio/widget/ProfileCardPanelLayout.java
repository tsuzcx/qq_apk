package com.tencent.mobileqq.guild.audio.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.Nullable;

public class ProfileCardPanelLayout
  extends LinearLayout
{
  private float a = -3.402824E+038F;
  private boolean b = false;
  private final Scroller c = new Scroller(getContext());
  private ProfileCardPanelLayout.ScrollListener d;
  private int e = 0;
  private boolean f = false;
  
  public ProfileCardPanelLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardPanelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileCardPanelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    Scroller localScroller = this.c;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  private int getMaxScrollDistance()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    this.e = j;
    return j / 3;
  }
  
  public float a(float paramFloat)
  {
    if ((int)(getScrollY() + paramFloat) < 0) {
      return paramFloat;
    }
    return 0.0F;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.c;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.c.getCurrX(), this.c.getCurrY());
      invalidate();
      return;
    }
    if (this.f)
    {
      this.f = false;
      localObject = this.d;
      if (localObject != null) {
        ((ProfileCardPanelLayout.ScrollListener)localObject).a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          float f2 = this.a;
          if (f2 == -3.402824E+038F)
          {
            this.a = f1;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          f2 = -(f1 - f2);
          float f3 = a(f2);
          if (f3 != 0.0F) {
            scrollBy(0, (int)f3);
          }
          if (Math.abs(f2) > 5.0F) {
            this.b = true;
          }
          paramMotionEvent = this.d;
          if (paramMotionEvent != null)
          {
            if (getScrollY() > 0) {
              bool = true;
            }
            paramMotionEvent.a(bool);
          }
          this.a = f1;
          return true;
        }
      }
      this.a = -3.402824E+038F;
      if (!this.b) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < getMaxScrollDistance()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        a(0);
        return false;
      }
      this.f = true;
      a(-this.e);
      return false;
    }
    this.b = false;
    this.a = paramMotionEvent.getY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setScrollListener(ProfileCardPanelLayout.ScrollListener paramScrollListener)
  {
    this.d = paramScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.ProfileCardPanelLayout
 * JD-Core Version:    0.7.0.1
 */