package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;

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
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.b.n);
    float f4 = Math.abs(f2 - this.b.o);
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    boolean bool2 = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 261) {
              break label332;
            }
            return false;
          }
        }
        else
        {
          if (this.a <= 1)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            bool1 = bool2;
          }
          else
          {
            if ((f3 < f4) && (Math.abs(f2 - this.b.m) > this.b.a)) {
              getParent().requestDisallowInterceptTouchEvent(false);
            } else {
              getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((f3 > f4) && (Math.abs(f1 - this.b.l) > this.b.a))
            {
              bool1 = super.dispatchTouchEvent(paramMotionEvent);
            }
            else
            {
              requestDisallowInterceptTouchEvent(false);
              bool1 = bool2;
            }
          }
          paramMotionEvent = this.b;
          paramMotionEvent.n = f1;
          paramMotionEvent.o = f2;
          return bool1;
        }
      }
      requestDisallowInterceptTouchEvent(false);
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
      if ((Math.abs(f1 - this.b.l) < this.b.a) && (Math.abs(f2 - this.b.m) < this.b.a) && (this.b.d))
      {
        requestDisallowInterceptTouchEvent(false);
        this.b.performClick();
      }
      else
      {
        bool1 = bool2;
      }
      this.b.f();
      return bool1;
    }
    label332:
    this.a = this.b.e.a();
    requestDisallowInterceptTouchEvent(true);
    AvatarWallViewPager localAvatarWallViewPager = this.b;
    localAvatarWallViewPager.n = f1;
    localAvatarWallViewPager.l = f1;
    localAvatarWallViewPager.o = f2;
    localAvatarWallViewPager.m = f2;
    localAvatarWallViewPager.g();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollViewPager
 * JD-Core Version:    0.7.0.1
 */