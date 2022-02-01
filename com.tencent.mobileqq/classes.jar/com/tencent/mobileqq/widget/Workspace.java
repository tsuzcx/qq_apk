package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import java.util.ArrayList;

public class Workspace
  extends FrameLayout
{
  protected static final double a = Math.tan(Math.toRadians(30.0D));
  protected int b = 0;
  protected int c;
  protected int d;
  protected int e = -1;
  protected Scroller f;
  protected float g;
  protected float h;
  protected int i = 0;
  protected boolean j;
  protected int k;
  final Rect l = new Rect();
  final Rect m = new Rect();
  private Paint n;
  private int o;
  private float p;
  private boolean q = true;
  private VelocityTracker r;
  private View.OnLongClickListener s;
  private int[] t = new int[2];
  private boolean u = true;
  private boolean v;
  private Rect w = new Rect();
  private Workspace.OnScreenChangeListener x;
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
    setDrawingCacheEnabled(true);
    setAlwaysDrawnWithCacheEnabled(true);
    setBackgroundDrawable(getResources().getDrawable(2130838958));
  }
  
  private void c()
  {
    this.f = new Scroller(getContext());
    this.c = this.b;
    this.n = new Paint();
    this.n.setDither(false);
    this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void d()
  {
    int i1 = getWidth();
    a((getScrollX() + i1 / 2) / i1);
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a();
    int i1 = Math.min(paramInt, getChildCount() - 1);
    paramInt = 0;
    i1 = Math.max(0, i1);
    if (i1 != this.c) {
      paramInt = 1;
    }
    if (this.d != i1)
    {
      this.d = i1;
      localObject = this.x;
      if (localObject != null) {
        ((Workspace.OnScreenChangeListener)localObject).a(i1);
      }
    }
    this.e = i1;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.c))) {
      ((View)localObject).clearFocus();
    }
    paramInt = i1 * getWidth() - getScrollX();
    this.f.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt));
    invalidate();
  }
  
  protected boolean a(View paramView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      while (i1 < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i1);
        if ((localView instanceof Workspace))
        {
          Workspace localWorkspace = (Workspace)localView;
          localWorkspace.getGlobalVisibleRect(this.w);
          if (localWorkspace.isShown())
          {
            if (!this.w.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
              return false;
            }
            int i2;
            if (paramBoolean)
            {
              if (localWorkspace.getCurrentScreen() <= 0)
              {
                if (getCurrentScreen() == 0) {
                  return true;
                }
                i2 = localWorkspace.d;
                if (i2 != this.c) {
                  localWorkspace.setCurrentScreen(i2);
                }
              }
              else
              {
                return true;
              }
            }
            else if (localWorkspace.getCurrentScreen() >= localWorkspace.getChildCount() - 1)
            {
              if (getCurrentScreen() == getChildCount() - 1) {
                return true;
              }
              i2 = localWorkspace.d;
              if (i2 != this.c) {
                localWorkspace.setCurrentScreen(i2);
              }
            }
            else
            {
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramBoolean, paramMotionEvent))) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt)
  {
    getChildAt(this.c).addFocusables(paramArrayList, paramInt);
    if (paramInt == 17)
    {
      int i1 = this.c;
      if (i1 > 0) {
        getChildAt(i1 - 1).addFocusables(paramArrayList, paramInt);
      }
    }
    else if ((paramInt == 66) && (this.c < getChildCount() - 1))
    {
      getChildAt(this.c + 1).addFocusables(paramArrayList, paramInt);
    }
  }
  
  void b() {}
  
  public void computeScroll()
  {
    if (this.f.computeScrollOffset())
    {
      scrollTo(this.f.getCurrX(), this.f.getCurrY());
      postInvalidate();
      return;
    }
    int i1 = this.e;
    if (i1 != -1)
    {
      int i2 = this.c;
      this.c = Math.max(0, Math.min(i1, getChildCount() - 1));
      this.d = this.c;
      this.e = -1;
      b();
      Workspace.OnScreenChangeListener localOnScreenChangeListener = this.x;
      if (localOnScreenChangeListener != null) {
        localOnScreenChangeListener.b(this.c);
      }
    }
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (getCurrentScreen() > 0)
      {
        a(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      a(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.c;
  }
  
  public int getDesScreen()
  {
    return this.d;
  }
  
  public Workspace.OnScreenChangeListener getOnScreenChangeListener()
  {
    return this.x;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool2 = false;
    if (i1 == 2)
    {
      if (paramMotionEvent.getX() - this.g > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (a(getChildAt(this.d), bool1, paramMotionEvent)) {
        return false;
      }
    }
    i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.i != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label336;
          }
        }
        else
        {
          int i3 = (int)Math.abs(f1 - this.g);
          int i4 = (int)Math.abs(f2 - this.h);
          int i2 = this.k;
          if (i3 > i2) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i4 > i2) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          double d1 = i4;
          double d2 = i3;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if (((i1 == 0) && (i2 == 0)) || (d1 >= a)) {
            break label336;
          }
          if (i1 != 0)
          {
            localObject = getParent();
            if (localObject != null) {
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            }
            this.i = 1;
            this.g = f1;
            a();
          }
          if (!this.j) {
            break label336;
          }
          this.j = false;
          getChildAt(this.c).cancelLongPress();
          break label336;
        }
      }
      b();
      this.i = 0;
      this.j = false;
    }
    else
    {
      this.g = f1;
      this.h = f2;
      this.j = true;
      this.i = (this.f.isFinished() ^ true);
    }
    label336:
    Object localObject = getChildAt(this.d);
    boolean bool1 = bool2;
    if (this.i != 0)
    {
      bool1 = bool2;
      if (!a((View)localObject, true, paramMotionEvent))
      {
        bool1 = bool2;
        if (!a((View)localObject, false, paramMotionEvent)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        if ((!this.v) || (paramInt1 == this.c)) {
          localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        }
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    this.v = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      getChildAt(i1).measure(paramInt1, paramInt2);
      i1 += 1;
    }
    paramInt1 = this.o;
    float f1;
    if (paramInt1 > i2) {
      f1 = (i3 * i2 - paramInt1) / ((i3 - 1) * i2);
    } else {
      f1 = 1.0F;
    }
    this.p = f1;
    if (this.q)
    {
      scrollTo(this.c * i2, 0);
      this.q = false;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = this.e;
    if (i1 == -1) {
      i1 = this.c;
    }
    int i2 = i1;
    if (i1 >= getChildCount()) {
      i2 = getChildCount() - 1;
    }
    if (getChildAt(i2) != null) {
      getChildAt(i2).requestFocus(paramInt, paramRect);
    }
    return false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Workspace.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.currentScreen != -1) {
      this.c = paramParcelable.currentScreen;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Workspace.SavedState localSavedState = new Workspace.SavedState(super.onSaveInstanceState());
    localSavedState.currentScreen = this.c;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.v = true;
    } else {
      this.v = false;
    }
    if (!this.f.isFinished()) {
      this.f.forceFinished(true);
    }
    scrollTo(paramInt1 * this.d, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() < 0) {
      return true;
    }
    if (this.r == null) {
      this.r = VelocityTracker.obtain();
    }
    this.r.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    if (i1 != 0)
    {
      int i2;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
          this.i = 0;
          return true;
        }
        if (this.i == 1)
        {
          i1 = (int)(this.g - f1);
          if ((i1 > 0) && (!this.u) && (this.c == getChildCount() - 1))
          {
            this.x.b(getChildCount());
            return true;
          }
          this.g = f1;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          if (i1 < 0)
          {
            if (getScrollX() > 0)
            {
              scrollBy(Math.max(-getScrollX(), i1), 0);
              return true;
            }
            if (this.u)
            {
              scrollBy(i1 / 3, 0);
              return true;
            }
          }
          else if (i1 > 0)
          {
            i2 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
            if (i2 > 0)
            {
              scrollBy(Math.min(i2, i1), 0);
              return true;
            }
            if (this.u)
            {
              scrollBy(i1 / 3, 0);
              return true;
            }
          }
        }
      }
      else
      {
        if (this.i == 1)
        {
          paramMotionEvent = this.r;
          paramMotionEvent.computeCurrentVelocity(1000);
          i1 = (int)paramMotionEvent.getXVelocity();
          if (i1 > 350)
          {
            i2 = this.c;
            if (i2 > 0)
            {
              a(i2 - 1);
              break label345;
            }
          }
          if ((i1 < -350) && (this.c < getChildCount() - 1)) {
            a(this.c + 1);
          } else {
            d();
          }
          label345:
          paramMotionEvent = this.r;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.recycle();
            this.r = null;
          }
        }
        this.i = 0;
        return true;
      }
    }
    else
    {
      if (!this.f.isFinished()) {
        this.f.abortAnimation();
      }
      paramMotionEvent = getParent();
      if (paramMotionEvent != null) {
        paramMotionEvent.requestDisallowInterceptTouchEvent(true);
      }
      this.g = f1;
    }
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i1 = indexOfChild(paramView);
    if ((i1 == this.c) && (this.f.isFinished())) {
      return false;
    }
    a(i1);
    return true;
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setAlloweffect(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    this.c = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    paramInt = this.c;
    this.d = paramInt;
    scrollTo(paramInt * getWidth(), 0);
  }
  
  public void setDefaultScreen(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.s = paramOnLongClickListener;
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).setOnLongClickListener(paramOnLongClickListener);
      i1 += 1;
    }
  }
  
  public void setOnScreenChangeListener(Workspace.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.x = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Workspace
 * JD-Core Version:    0.7.0.1
 */