package com.tencent.mtt.hippy.dom.node;

import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.g;
import com.tencent.mtt.hippy.uimanager.g.a;
import java.util.ArrayList;

public class e
  implements g.a
{
  private static final int c = ;
  private static final int d = ViewConfiguration.getTapTimeout();
  boolean a = false;
  int b;
  private ArrayList<String> e = null;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j;
  private g k;
  private Handler l;
  private HippyEngineContext m;
  private boolean n;
  
  e(int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.n = paramBoolean;
    this.e = new ArrayList();
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  public boolean a()
  {
    return this.n;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.k == null) {
      this.k = new g(this);
    }
    this.j = paramView.getId();
    return this.k.a(paramMotionEvent);
  }
  
  public boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((this.m == null) && ((paramView.getContext() instanceof HippyInstanceContext))) {
      this.m = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
    }
    this.j = paramView.getId();
    int i1 = paramMotionEvent.getAction();
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      this.h = i2;
      this.i = i3;
      return bool1;
      this.f = i2;
      this.g = i3;
      this.a = false;
      if (this.e.contains("onLongClick"))
      {
        if (this.l == null) {
          this.l = new e.a(this);
        }
        this.l.sendEmptyMessageAtTime(3, paramMotionEvent.getDownTime() + d + c);
        bool1 = true;
        continue;
        if (!this.e.contains("onClick"))
        {
          bool1 = bool2;
          if (!this.e.contains("onLongClick")) {}
        }
        else
        {
          bool1 = bool2;
          if (Math.abs(i2 - this.h) < ViewConfiguration.getTouchSlop())
          {
            bool1 = bool2;
            if (Math.abs(i3 - this.i) < ViewConfiguration.getTouchSlop())
            {
              bool1 = true;
              continue;
              if (((this.e.contains("onClick")) || (this.e.contains("onLongClick"))) && (Math.abs(i2 - this.h) < ViewConfiguration.getTouchSlop()) && (Math.abs(i3 - this.i) < ViewConfiguration.getTouchSlop())) {
                if ((this.e.contains("onLongClick")) && (this.a))
                {
                  NativeGestureDispatcher.handleLongClick(this.m, this.b);
                  bool1 = true;
                }
              }
              for (;;)
              {
                if (this.l != null)
                {
                  this.l.removeMessages(3);
                  break;
                  NativeGestureDispatcher.handleClick(this.m, this.b);
                  bool1 = true;
                  continue;
                  if (this.l != null) {
                    this.l.removeMessages(3);
                  }
                  if (!this.e.contains("onClick"))
                  {
                    bool1 = bool2;
                    if (!this.e.contains("onLongClick")) {
                      break;
                    }
                  }
                  bool1 = true;
                  break;
                }
                break;
                bool1 = false;
              }
            }
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public void handle(String paramString, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.equals(paramString, "onPressIn")) {
      NativeGestureDispatcher.handlePressIn(this.m, this.b);
    }
    do
    {
      return;
      if (TextUtils.equals(paramString, "onPressOut"))
      {
        NativeGestureDispatcher.handlePressOut(this.m, this.b);
        return;
      }
      if (TextUtils.equals(paramString, "onTouchDown"))
      {
        NativeGestureDispatcher.handleTouchDown(this.m, this.b, paramFloat1, paramFloat2, this.j);
        return;
      }
      if (TextUtils.equals(paramString, "onTouchMove"))
      {
        NativeGestureDispatcher.handleTouchMove(this.m, this.b, paramFloat1, paramFloat2, this.j);
        return;
      }
      if (TextUtils.equals(paramString, "onTouchEnd"))
      {
        NativeGestureDispatcher.handleTouchEnd(this.m, this.b, paramFloat1, paramFloat2, this.j);
        return;
      }
    } while (!TextUtils.equals(paramString, "onTouchCancel"));
    NativeGestureDispatcher.handleTouchCancel(this.m, this.b, paramFloat1, paramFloat2, this.j);
  }
  
  public boolean needHandle(String paramString)
  {
    if (this.e != null) {
      return this.e.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.e
 * JD-Core Version:    0.7.0.1
 */