package com.tencent.mtt.hippy.uimanager;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class g
{
  private static final int c = ;
  private static final int d = ViewConfiguration.getTouchSlop();
  boolean a = false;
  g.a b;
  private Handler e;
  private float f = 0.0F;
  private float g = 0.0F;
  
  public g(g.a parama)
  {
    this.b = parama;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
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
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            float f2;
            do
            {
              do
              {
                return bool1;
                if (this.b.needHandle("onPressIn"))
                {
                  this.a = false;
                  this.f = paramMotionEvent.getX();
                  this.g = paramMotionEvent.getY();
                  a().sendEmptyMessageDelayed(1, c);
                  bool2 = true;
                }
                for (;;)
                {
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
                  if (!this.b.needHandle("onTouchCancel")) {
                    break;
                  }
                  return true;
                  this.a = true;
                }
                bool2 = bool3;
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
              } while (this.a);
              float f1 = Math.abs(paramMotionEvent.getX() - this.f);
              f2 = Math.abs(paramMotionEvent.getY() - this.g);
              if (f1 > d) {
                break;
              }
              bool1 = bool2;
            } while (f2 <= d);
            a().removeMessages(1);
            this.a = true;
            return bool2;
            bool2 = bool4;
            if (this.b.needHandle("onTouchEnd"))
            {
              this.b.handle("onTouchEnd", paramMotionEvent.getX(), paramMotionEvent.getY());
              bool2 = true;
            }
            if ((this.a) && (this.b.needHandle("onPressOut")))
            {
              this.b.handle("onPressOut", paramMotionEvent.getX(), paramMotionEvent.getY());
              return true;
            }
            bool1 = bool2;
          } while (this.a);
          bool1 = bool2;
        } while (!this.b.needHandle("onPressOut"));
        a().sendEmptyMessageDelayed(2, c);
        return true;
        bool2 = bool5;
        if (this.b.needHandle("onTouchCancel"))
        {
          this.b.handle("onTouchCancel", paramMotionEvent.getX(), paramMotionEvent.getY());
          bool2 = true;
        }
        if ((this.a) && (this.b.needHandle("onPressOut")))
        {
          this.b.handle("onPressOut", paramMotionEvent.getX(), paramMotionEvent.getY());
          return true;
        }
        bool1 = bool2;
      } while (this.a);
      bool1 = bool2;
    } while (!this.b.needHandle("onPressOut"));
    if (a().hasMessages(1))
    {
      a().removeMessages(1);
      return bool2;
    }
    a().sendEmptyMessageDelayed(2, c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.g
 * JD-Core Version:    0.7.0.1
 */