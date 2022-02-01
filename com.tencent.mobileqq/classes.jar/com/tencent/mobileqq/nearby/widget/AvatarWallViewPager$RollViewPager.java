package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

public class AvatarWallViewPager$RollViewPager
  extends ViewPager
{
  int a;
  
  public AvatarWallViewPager$RollViewPager(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext)
  {
    this(paramAvatarWallViewPager, paramContext, null);
  }
  
  public AvatarWallViewPager$RollViewPager(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.b.f;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.b.s);
    float f4 = Math.abs(f2 - this.b.t);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5) {
              break label436;
            }
            if (i != 6) {
              return false;
            }
          }
        }
        else
        {
          if (this.a <= 1)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
          else
          {
            if ((f3 < f4) && (Math.abs(f2 - this.b.r) > this.b.b)) {
              getParent().requestDisallowInterceptTouchEvent(false);
            } else {
              getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((f3 > f4) && (Math.abs(f1 - this.b.q) > this.b.b)) {
              try
              {
                bool2 = super.dispatchTouchEvent(paramMotionEvent);
                bool1 = bool2;
              }
              catch (Exception paramMotionEvent)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("MotionEvent.ACTION_MOVE,e=");
                ((StringBuilder)localObject).append(paramMotionEvent.toString());
                QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
              }
            } else {
              requestDisallowInterceptTouchEvent(false);
            }
          }
          paramMotionEvent = this.b;
          paramMotionEvent.s = f1;
          paramMotionEvent.t = f2;
          return bool1;
        }
      }
      requestDisallowInterceptTouchEvent(false);
      try
      {
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
      }
      catch (Exception paramMotionEvent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MotionEvent.ACTION_UP|MotionEvent.ACTION_POINTER_UP|MotionEvent.ACTION_CANCEL,e=");
        ((StringBuilder)localObject).append(paramMotionEvent.toString());
        QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
        bool1 = false;
      }
      if ((Math.abs(f1 - this.b.q) < this.b.b) && (Math.abs(f2 - this.b.r) < this.b.b) && (this.b.e))
      {
        requestDisallowInterceptTouchEvent(false);
        this.b.performClick();
        bool1 = bool2;
      }
      this.b.a();
      return bool1;
    }
    label436:
    this.a = this.b.f.c();
    requestDisallowInterceptTouchEvent(true);
    localObject = this.b;
    ((AvatarWallViewPager)localObject).s = f1;
    ((AvatarWallViewPager)localObject).q = f1;
    ((AvatarWallViewPager)localObject).t = f2;
    ((AvatarWallViewPager)localObject).r = f2;
    ((AvatarWallViewPager)localObject).b();
    try
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MotionEvent.ACTION_DOWN|MotionEvent.ACTION_POINTER_DOWN,e=");
      ((StringBuilder)localObject).append(paramMotionEvent.toString());
      QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollViewPager
 * JD-Core Version:    0.7.0.1
 */