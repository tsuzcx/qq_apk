package com.tencent.mtt.hippy.uimanager;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class g
{
  private static final int c = ;
  private static final int d = ViewConfiguration.getTouchSlop();
  boolean a = false;
  final g.a b;
  private Handler e;
  private float f = 0.0F;
  private float g = 0.0F;
  
  public g(g.a parama)
  {
    this.b = parama;
  }
  
  private g.a b()
  {
    return this.b;
  }
  
  public Handler a()
  {
    if (this.e == null) {
      this.e = new g.b(this);
    }
    return this.e;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return false;
          }
          if (this.b.needHandle("onTouchCancel"))
          {
            this.b.handle("onTouchCancel", paramMotionEvent.getX(), paramMotionEvent.getY());
            bool2 = true;
          }
          if ((!this.a) || (!this.b.needHandle("onPressOut")))
          {
            bool1 = bool2;
            if (this.a) {
              break label658;
            }
            bool1 = bool2;
            if (!this.b.needHandle("onPressOut")) {
              break label658;
            }
            if (!a().hasMessages(1)) {
              break label453;
            }
            a().removeMessages(1);
            return bool2;
          }
        }
        else
        {
          bool2 = bool1;
          if (this.b.needHandle("onTouchMove"))
          {
            this.b.handle("onTouchMove", paramMotionEvent.getX(), paramMotionEvent.getY());
            bool2 = true;
          }
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if (this.b.needHandle("onTouchEnd")) {
              bool1 = true;
            }
          }
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (this.b.needHandle("onTouchCancel")) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (this.a) {
            break label658;
          }
          float f1 = Math.abs(paramMotionEvent.getX() - this.f);
          float f2 = Math.abs(paramMotionEvent.getY() - this.g);
          i = d;
          if (f1 <= i)
          {
            bool1 = bool2;
            if (f2 <= i) {
              break label658;
            }
          }
          a().removeMessages(1);
          this.a = true;
          return bool2;
        }
      }
      else
      {
        bool2 = bool3;
        if (this.b.needHandle("onTouchEnd"))
        {
          this.b.handle("onTouchEnd", paramMotionEvent.getX(), paramMotionEvent.getY());
          bool2 = true;
        }
        if ((!this.a) || (!this.b.needHandle("onPressOut"))) {
          break label424;
        }
      }
      this.b.handle("onPressOut", paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    label424:
    label453:
    do
    {
      for (;;)
      {
        return true;
        bool1 = bool2;
        if (this.a) {
          break;
        }
        bool1 = bool2;
        if (!this.b.needHandle("onPressOut")) {
          break;
        }
        a().sendEmptyMessageDelayed(2, c);
      }
      if (this.b.needHandle("onPressIn"))
      {
        this.a = false;
        this.f = paramMotionEvent.getX();
        this.g = paramMotionEvent.getY();
        a().sendEmptyMessageDelayed(1, c);
        bool2 = true;
      }
      else
      {
        this.a = true;
        bool2 = bool4;
      }
      if (this.b.needHandle("onTouchDown"))
      {
        this.b.handle("onTouchDown", paramMotionEvent.getX(), paramMotionEvent.getY());
        bool2 = true;
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (this.b.needHandle("onTouchMove")) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (this.b.needHandle("onTouchEnd")) {
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (bool2) {
        break;
      }
      bool1 = bool2;
    } while (this.b.needHandle("onTouchCancel"));
    label658:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.g
 * JD-Core Version:    0.7.0.1
 */