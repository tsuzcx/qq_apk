package com.tencent.mobileqq.kandian.base.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import org.jetbrains.annotations.Nullable;

public abstract class AbsPullToRefreshViewFix
  extends LinearLayout
  implements Handler.Callback
{
  protected boolean a = false;
  protected View b;
  protected View c;
  protected int d;
  boolean e = false;
  boolean f = false;
  boolean g;
  private int h = 0;
  private Handler i;
  private int j;
  private int k;
  private int l;
  private int m = 10;
  private PullToRefreshListener n;
  private int o;
  private Drawable p;
  private float q = -1.0F;
  private float r = -1.0F;
  
  public AbsPullToRefreshViewFix(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private float a(int paramInt, float paramFloat)
  {
    int i1 = this.j;
    if (paramInt > -i1)
    {
      f1 = paramFloat;
      if (paramInt - paramFloat < -i1) {
        f1 = paramInt + i1;
      }
      return f1;
    }
    float f1 = paramFloat;
    if (paramInt < -i1)
    {
      f1 = paramFloat;
      if (paramInt - paramFloat > -i1) {
        f1 = paramInt + i1;
      }
    }
    return f1;
  }
  
  @Nullable
  private Boolean a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    if (this.e)
    {
      setVerticalScrollDisable(true);
      getParent().requestDisallowInterceptTouchEvent(true);
      return Boolean.valueOf(super.dispatchTouchEvent(paramMotionEvent));
    }
    if (Math.abs(paramFloat1) / Math.abs(paramFloat2) >= 2.0F)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (!bool)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        this.e = true;
        setVerticalScrollDisable(true);
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      return Boolean.valueOf(bool);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderTo:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",duration=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",getHeaderCurPos()=");
    ((StringBuilder)localObject).append(getHeaderCurPos());
    a(((StringBuilder)localObject).toString());
    if (paramInt1 == getHeaderCurPos()) {
      return;
    }
    this.i.removeMessages(1);
    localObject = this.i;
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramInt1, paramInt2));
  }
  
  private void a(MotionEvent paramMotionEvent, float paramFloat, int paramInt)
  {
    if ((e()) && (paramFloat < 0.0F))
    {
      c((int)paramFloat / 2);
      c(true);
      return;
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      c(true);
      return;
    }
    if (Math.abs(paramFloat) > 0.0F)
    {
      c((int)a(paramInt, paramFloat));
      c(true);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b(paramView);
    this.k = a();
    this.j = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.j);
    localLayoutParams.topMargin = (-this.j);
    super.addView(paramView, localLayoutParams);
  }
  
  private void a(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) - Math.abs(paramFloat1) <= 0.0F;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.n;
    if (localObject == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            int i1 = 100 - Math.abs((int)(getHeaderCurPos() * 1.0F / -this.j * 100.0F));
            paramInt = i1;
            if (i1 < 0) {
              paramInt = 0;
            }
            if (!this.a) {
              this.n.onNotCompleteVisable(this.b, paramInt);
            }
          }
          else if (!this.a)
          {
            ((PullToRefreshListener)localObject).onViewCompleteVisable(this.b);
          }
        }
        else
        {
          if (this.a)
          {
            ((PullToRefreshListener)localObject).onRefreshCompleted(this.b, false);
            localObject = this.i;
            ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 1000L);
          }
          this.a = false;
          this.i.removeMessages(2);
        }
      }
      else
      {
        if (this.a)
        {
          ((PullToRefreshListener)localObject).onRefreshCompleted(this.b, true);
          localObject = this.i;
          ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        }
        this.a = false;
        this.i.removeMessages(2);
      }
    }
    else if (!this.a)
    {
      this.a = true;
      ((PullToRefreshListener)localObject).onViewCompleteVisableAndReleased(this.b);
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i2 = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i1 = localLayoutParams1.height;
    if (i1 > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i2, i1);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat1) >= this.d) || (Math.abs(paramFloat2) >= this.d);
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moveHeaderSmoothlyBy dy=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    if (Math.abs(paramInt) > this.o * 2) {
      return;
    }
    d(paramInt);
  }
  
  private void c(boolean paramBoolean)
  {
    b(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderBy dy=");
    ((StringBuilder)localObject).append(paramInt);
    a(((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin -= paramInt;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    invalidate();
  }
  
  private void g()
  {
    super.setOrientation(1);
    this.h = 0;
    this.i = new Handler(Looper.getMainLooper(), this);
    this.b = c();
    this.c = d();
    this.o = UIUtils.a(getContext(), 15.0F);
    this.l = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    a(this.b);
    setWillNotDraw(false);
    this.d = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 8);
  }
  
  private int getHeaderCurPos()
  {
    return ((LinearLayout.LayoutParams)this.b.getLayoutParams()).topMargin;
  }
  
  private void h()
  {
    this.i.removeMessages(1);
    this.i.removeMessages(3);
  }
  
  private boolean i()
  {
    if (!this.e)
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    return true;
  }
  
  private void j()
  {
    int i1 = getHeaderCurPos();
    int i2 = this.k;
    int i3 = this.j;
    if (i1 > i2 - i3)
    {
      a(4);
      return;
    }
    if (i1 > -i3)
    {
      a(5);
      return;
    }
    if (i1 < -i3) {
      a(6);
    }
  }
  
  private void k()
  {
    int i1 = this.h;
    if (i1 == 4)
    {
      a(1);
      return;
    }
    if (i1 == 5)
    {
      a(0);
      return;
    }
    if (i1 == 6)
    {
      a(0);
      return;
    }
    if (getHeaderCurPos() != -this.j)
    {
      Handler localHandler = this.i;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
  
  protected int a()
  {
    return UIUtils.a(getContext(), 60.0F);
  }
  
  protected void a(int paramInt)
  {
    if ((this.h == paramInt) && (paramInt != 5)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change to state:");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    this.h = paramInt;
    paramInt = this.h;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        a(this.k - this.j, 200);
      }
    }
    else
    {
      a(-this.j, 200);
      this.i.removeMessages(2);
    }
    b(this.h);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(2);
      return;
    }
    a(3);
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void b()
  {
    Handler localHandler;
    if (e())
    {
      this.i.removeMessages(3);
      a(this.k / 2 - this.j, 100);
      localHandler = this.i;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
      return;
    }
    if (f())
    {
      this.i.removeMessages(3);
      a(-this.j - this.k, 100);
      localHandler = this.i;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
    }
  }
  
  protected abstract void b(boolean paramBoolean);
  
  protected abstract View c();
  
  protected abstract View d();
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label491;
          }
        }
        else
        {
          float f1 = this.r - paramMotionEvent.getX();
          float f2 = this.q - paramMotionEvent.getY();
          if (!this.f)
          {
            if ((Math.abs(f1) <= this.d) && (Math.abs(f2) <= this.d)) {
              return super.dispatchTouchEvent(paramMotionEvent);
            }
            this.f = true;
          }
          i1 = getHeaderCurPos();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dispatchTouchEvent: move getY=");
          ((StringBuilder)localObject).append(paramMotionEvent.getY());
          ((StringBuilder)localObject).append(",isScroll2Top()()=");
          ((StringBuilder)localObject).append(e());
          ((StringBuilder)localObject).append(",mHeaderHeight=");
          ((StringBuilder)localObject).append(this.j);
          ((StringBuilder)localObject).append(",currentHeaderPos=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(",dy=");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(",dx=");
          ((StringBuilder)localObject).append(f1);
          a(((StringBuilder)localObject).toString());
          this.r = paramMotionEvent.getX();
          this.q = paramMotionEvent.getY();
          if (!b(f1, f2)) {
            break label491;
          }
          if (a(f1, f2))
          {
            if (this.g)
            {
              localObject = a(paramMotionEvent, f1, f2);
              if (localObject != null) {
                return ((Boolean)localObject).booleanValue();
              }
            }
            else
            {
              if (!i()) {
                break label491;
              }
              return true;
            }
          }
          else if (this.e) {
            return true;
          }
          a(paramMotionEvent, f2, i1);
          j();
          break label491;
        }
      }
      this.e = false;
      setVerticalScrollDisable(false);
      this.f = false;
      this.g = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: *******up****** mState=");
      ((StringBuilder)localObject).append(this.h);
      a(((StringBuilder)localObject).toString());
      getParent().requestDisallowInterceptTouchEvent(false);
      this.q = -1.0F;
      this.r = -1.0F;
      k();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: ------down------ getY=");
      ((StringBuilder)localObject).append(paramMotionEvent.getY());
      a(((StringBuilder)localObject).toString());
      h();
      this.r = paramMotionEvent.getX();
      this.q = paramMotionEvent.getY();
      this.e = false;
      setVerticalScrollDisable(false);
      this.f = false;
      this.g = a(paramMotionEvent);
    }
    label491:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected abstract boolean e();
  
  protected abstract boolean f();
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
          a(-this.j, 100);
          this.i.removeMessages(2);
          return true;
        }
        a(3);
        return true;
      }
      i1 = paramMessage.arg1;
      int i2 = paramMessage.arg2;
      int i4 = getHeaderCurPos();
      int i3 = this.m;
      i4 = (i1 - i4) * i3 / i2;
      i2 -= i3;
      if ((i2 > 0) && ((i4 != 0) || (getHeaderCurPos() - i1 <= 0)))
      {
        d(-i4);
        paramMessage = this.i;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1, i1, i2), this.m);
        return true;
      }
      d(getHeaderCurPos() - i1);
      return true;
    }
    a(0);
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.i.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = getHeaderCurPos() + this.j;
    if (i1 > 0)
    {
      Drawable localDrawable = this.p;
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, getWidth(), i1);
        this.p.draw(paramCanvas);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setPullHeaderBgDrawable(Drawable paramDrawable)
  {
    this.p = paramDrawable;
  }
  
  protected void setPullToRefreshListener(PullToRefreshListener paramPullToRefreshListener)
  {
    this.n = paramPullToRefreshListener;
  }
  
  protected void setVerticalScrollDisable(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.AbsPullToRefreshViewFix
 * JD-Core Version:    0.7.0.1
 */