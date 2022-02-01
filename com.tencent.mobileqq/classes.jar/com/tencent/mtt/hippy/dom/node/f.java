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

public class f
  implements g.a
{
  private static final int c = ;
  private static final int d = ViewConfiguration.getTapTimeout();
  boolean a = false;
  final int b;
  private ArrayList<String> e;
  private int f = 0;
  private int g = 0;
  private int h;
  private g i;
  private Handler j;
  private HippyEngineContext k;
  private final boolean l;
  
  f(int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.l = paramBoolean;
    this.e = new ArrayList();
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.i == null) {
      this.i = new g(this);
    }
    this.h = paramView.getId();
    return this.i.a(paramMotionEvent);
  }
  
  public boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.k == null) && ((paramView.getContext() instanceof HippyInstanceContext))) {
      this.k = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
    }
    this.h = paramView.getId();
    int m = paramMotionEvent.getAction();
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if ((m == 3) || (m == 4))
          {
            paramView = this.j;
            if (paramView != null) {
              paramView.removeMessages(3);
            }
            bool1 = bool3;
            if (this.e.contains("onClick")) {
              break label410;
            }
            if (this.e.contains("onLongClick"))
            {
              bool1 = bool3;
              break label410;
            }
          }
        }
        else if (((this.e.contains("onClick")) || (this.e.contains("onLongClick"))) && (Math.abs(n - this.f) < ViewConfiguration.getTouchSlop()) && (Math.abs(i1 - this.g) < ViewConfiguration.getTouchSlop()))
        {
          bool1 = bool3;
          break label410;
        }
        bool1 = false;
      }
      else
      {
        if (!this.e.contains("onClick"))
        {
          bool1 = bool2;
          if (!this.e.contains("onLongClick")) {}
        }
        else
        {
          bool1 = bool2;
          if (Math.abs(n - this.f) < ViewConfiguration.getTouchSlop())
          {
            bool1 = bool2;
            if (Math.abs(i1 - this.g) < ViewConfiguration.getTouchSlop())
            {
              if ((this.e.contains("onLongClick")) && (this.a)) {
                NativeGestureDispatcher.handleLongClick(this.k, this.b);
              } else {
                NativeGestureDispatcher.handleClick(paramView, this.k, this.b, true);
              }
              bool1 = true;
            }
          }
        }
        paramView = this.j;
        if (paramView != null) {
          paramView.removeMessages(3);
        }
      }
    }
    else
    {
      this.a = false;
      bool1 = bool3;
      if (this.e.contains("onLongClick"))
      {
        if (this.j == null) {
          this.j = new f.a(this);
        }
        this.j.sendEmptyMessageAtTime(3, paramMotionEvent.getDownTime() + d + c);
        bool1 = bool3;
      }
    }
    label410:
    this.f = n;
    this.g = i1;
    return bool1;
  }
  
  public void handle(String paramString, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.equals(paramString, "onPressIn"))
    {
      NativeGestureDispatcher.handlePressIn(this.k, this.b);
      return;
    }
    if (TextUtils.equals(paramString, "onPressOut"))
    {
      NativeGestureDispatcher.handlePressOut(this.k, this.b);
      return;
    }
    if (TextUtils.equals(paramString, "onTouchDown"))
    {
      NativeGestureDispatcher.handleTouchDown(this.k, this.b, paramFloat1, paramFloat2, this.h);
      return;
    }
    if (TextUtils.equals(paramString, "onTouchMove"))
    {
      NativeGestureDispatcher.handleTouchMove(this.k, this.b, paramFloat1, paramFloat2, this.h);
      return;
    }
    if (TextUtils.equals(paramString, "onTouchEnd"))
    {
      NativeGestureDispatcher.handleTouchEnd(this.k, this.b, paramFloat1, paramFloat2, this.h);
      return;
    }
    if (TextUtils.equals(paramString, "onTouchCancel")) {
      NativeGestureDispatcher.handleTouchCancel(this.k, this.b, paramFloat1, paramFloat2, this.h);
    }
  }
  
  public boolean needHandle(String paramString)
  {
    ArrayList localArrayList = this.e;
    if (localArrayList != null) {
      return localArrayList.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.f
 * JD-Core Version:    0.7.0.1
 */