package com.tencent.mobileqq.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ScrollerRunnable
  implements Runnable
{
  private static long A;
  protected ListView a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected final int f;
  protected int g;
  protected boolean h;
  protected int i;
  protected Runnable j;
  protected int k;
  protected int l;
  int m;
  protected boolean n;
  protected int o;
  protected MqqHandler p;
  protected long q;
  protected boolean r;
  protected boolean s;
  protected int t;
  HashMap<Integer, Integer> u;
  @Nullable
  private AioTips v;
  private int w;
  private boolean x;
  private View y;
  private int z;
  
  public ScrollerRunnable(ListView paramListView)
  {
    boolean bool = false;
    this.g = 0;
    this.h = true;
    this.w = 0;
    this.x = false;
    this.i = -1;
    this.k = 0;
    this.m = 0;
    this.n = false;
    this.o = -1;
    this.q = -1L;
    this.z = 0;
    this.r = false;
    this.s = false;
    this.u = new HashMap();
    this.a = paramListView;
    this.f = ViewConfiguration.get(this.a.getContext()).getScaledFadingEdgeLength();
    if (DeviceInfoUtil.a() / 1048576L > 512L) {
      bool = true;
    }
    this.h = bool;
    double d1 = this.a.getContext().getResources().getDimension(2131299920);
    Double.isNaN(d1);
    this.t = ((int)(d1 + 0.5D));
  }
  
  private int a(ScrollerRunnable.ScrollType paramScrollType)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScrollOffset, TITLE_BAR_HEIGHT = ");
      localStringBuilder.append(this.t);
      localStringBuilder.append(", animationOffset = ");
      localStringBuilder.append(this.z);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramScrollType);
      QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
    }
    if (!c()) {
      return -this.t;
    }
    return (this.t + this.z) * -1;
  }
  
  private void h()
  {
    d();
    if (i()) {
      f();
    }
  }
  
  private boolean i()
  {
    AioTips localAioTips = this.v;
    if (localAioTips != null) {
      return localAioTips.c(this.o);
    }
    return false;
  }
  
  public void a()
  {
    this.t = 0;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetExtraScrollIfNeeded==>extraType:");
        localStringBuilder.append(paramInt);
        QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
      }
      if ((paramInt == 0) && (!this.u.isEmpty()))
      {
        this.u.clear();
        this.g = 0;
        return;
      }
      if (this.u.containsKey(Integer.valueOf(paramInt))) {
        this.g -= ((Integer)this.u.remove(Integer.valueOf(paramInt))).intValue();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool = this.u.containsKey(Integer.valueOf(paramInt1));
      if (bool) {
        return;
      }
      this.g += paramInt2;
      this.u.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addExtraScroll==>extraType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" |extraDetal:");
        localStringBuilder.append(paramInt2);
        QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.o = paramInt1;
    a(paramInt2, paramInt3, paramRunnable, paramInt4, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.p = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3, boolean paramBoolean)
  {
    b();
    this.i = paramInt2;
    this.c = paramInt1;
    this.j = paramRunnable;
    if (QLog.isColorLevel())
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.c);
      paramRunnable.append(", jumpToTopDirect:");
      paramRunnable.append(paramBoolean);
      QLog.d("ScrollerRunnable", 2, new Object[] { "start, from:", Integer.valueOf(paramInt3), ", aniPos:", Integer.valueOf(paramInt2), ", mTargetPos:", paramRunnable.toString() });
    }
    this.x = paramBoolean;
    this.l = paramInt3;
    this.a.post(this);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.i = paramInt;
    this.a.postDelayed(new ScrollerRunnable.1(this), paramLong);
  }
  
  public void a(long paramLong)
  {
    this.q = paramLong;
  }
  
  protected void a(View paramView)
  {
    int i1;
    int i2;
    if (this.k == 2)
    {
      i1 = 16773091;
      i2 = -4125;
    }
    else
    {
      i1 = 11580351;
      i2 = 867218367;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofInt(paramView, "backgroundColor", new int[] { i1, i2 });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setEvaluator(new ArgbEvaluator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(paramView, "backgroundColor", new int[] { i2, i1 });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator2.setEvaluator(new ArgbEvaluator());
    localObjectAnimator1.addListener(new ScrollerRunnable.5(this, paramView, localObjectAnimator2));
    localObjectAnimator2.addListener(new ScrollerRunnable.6(this, paramView));
    localObjectAnimator1.start();
    this.q = -1L;
  }
  
  public void a(@Nullable AioTips paramAioTips)
  {
    this.v = paramAioTips;
  }
  
  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void b()
  {
    this.a.removeCallbacks(this);
    this.n = false;
    this.j = null;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAnimationOffset offset = ");
      localStringBuilder.append(paramInt);
      QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
    }
    this.z = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0, null, paramInt2, false);
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public boolean c()
  {
    return this.z != 0;
  }
  
  protected void d()
  {
    Runnable localRunnable = this.j;
    if (localRunnable != null)
    {
      localRunnable.run();
      this.j = null;
    }
    else if (this.x)
    {
      OneClickJumpUtil.b = SystemClock.uptimeMillis() - OneClickJumpUtil.b;
      OneClickJumpUtil.a();
    }
    this.a.post(new ScrollerRunnable.2(this));
  }
  
  public void e()
  {
    View localView = this.y;
    if (localView != null)
    {
      localView.setBackgroundColor(0);
      this.y = null;
    }
  }
  
  protected void f()
  {
    long l1 = System.currentTimeMillis();
    if (System.currentTimeMillis() - A < 1000L) {
      return;
    }
    if (this.i != -1) {
      A = l1;
    }
    int i2 = this.a.getFirstVisiblePosition() - this.a.getHeaderViewsCount();
    if (this.i < i2) {
      return;
    }
    if ((this.o == 5) && (this.q > 0L))
    {
      localObject1 = this.a.getAdapter();
      if ((localObject1 instanceof ChatAdapter1))
      {
        localObject1 = ((ChatAdapter1)localObject1).a();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          int i3 = ((List)localObject1).size();
          i1 = 0;
          while (i1 < i3)
          {
            if (((ChatMessage)((List)localObject1).get(i1)).uniseq == this.q)
            {
              this.i = i1;
              break;
            }
            i1 += 1;
          }
        }
      }
    }
    int i1 = this.i;
    if (i1 == -1) {
      return;
    }
    Object localObject2 = this.a.getChildAt(i1 - i2);
    Object localObject1 = localObject2;
    if (this.k == 2)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((View)localObject2).findViewById(2131434586);
      }
    }
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FlushMessageItem:");
        ((StringBuilder)localObject2).append(localObject1.hashCode());
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((View)localObject1).getParent());
        QLog.i("ScrollerRunnable", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.k == 1)
      {
        ((View)localObject1).post(new ScrollerRunnable.3(this, (View)localObject1));
        return;
      }
      ((View)localObject1).post(new ScrollerRunnable.4(this, (View)localObject1));
    }
  }
  
  public int g()
  {
    return this.o;
  }
  
  public void run()
  {
    int i1;
    if (!this.n)
    {
      this.n = true;
      this.m = 0;
      this.w = 0;
      if (this.r) {
        i1 = Math.max(0, this.a.getFirstVisiblePosition() - this.a.getHeaderViewsCount());
      } else {
        i1 = this.a.getFirstVisiblePosition();
      }
      if (this.r) {
        i2 = this.a.getChildCount() + i1 - this.a.getFooterViewsCount();
      } else {
        i2 = this.a.getChildCount() + i1;
      }
      i2 -= 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("run invoke, isNeedIgnoreHeaderView = ");
        ((StringBuilder)localObject).append(this.r);
        ((StringBuilder)localObject).append(", getFirstVisiblePosition = ");
        ((StringBuilder)localObject).append(this.a.getFirstVisiblePosition());
        ((StringBuilder)localObject).append(", getLastVisiblePosition = ");
        ((StringBuilder)localObject).append(this.a.getLastVisiblePosition());
        ((StringBuilder)localObject).append(", lastPos = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", firstPos = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", getHeaderViewsCount = ");
        ((StringBuilder)localObject).append(this.a.getHeaderViewsCount());
        ((StringBuilder)localObject).append(", getChildCount = ");
        ((StringBuilder)localObject).append(this.a.getChildCount());
        ((StringBuilder)localObject).append(", getFooterViewsCount = ");
        ((StringBuilder)localObject).append(this.a.getFooterViewsCount());
        ((StringBuilder)localObject).append(", jumpToTopDirect = ");
        ((StringBuilder)localObject).append(this.x);
        QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
      }
      i3 = this.c;
      if (i3 <= i1)
      {
        i1 = i1 - i3 + 1;
        this.b = 2;
      }
      else if (i3 >= i2)
      {
        if ((c()) && (this.c == i2))
        {
          h();
          return;
        }
        i1 = this.c - i2 + 1;
        this.b = 1;
      }
      else
      {
        if ((!c()) || (this.c - i1 > 2)) {
          break label444;
        }
        this.b = 1;
        if (QLog.isColorLevel()) {
          QLog.i("ScrollerRunnable", 2, "hit up boundary case");
        }
        i1 = 2;
      }
      if (i1 > 0) {
        this.e = (1000 / i1);
      } else {
        this.e = 1000;
      }
      this.d = -1;
      break label449;
      label444:
      h();
      return;
    }
    label449:
    int i3 = this.a.getHeight();
    if (this.r) {
      i1 = Math.max(0, this.a.getFirstVisiblePosition() - this.a.getHeaderViewsCount());
    } else {
      i1 = this.a.getFirstVisiblePosition();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("run invoke, firstPos = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(", mLastSeenPos = ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", mTargetPos = ");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
    int i2 = this.b;
    if (i2 != 1)
    {
      if (i2 != 2) {
        return;
      }
      if ((this.x) && (this.w > 4))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("jumpToTopDirect,listCount = ");
          ((StringBuilder)localObject).append(this.a.getCount());
          ((StringBuilder)localObject).append(" mTargetPos = ");
          ((StringBuilder)localObject).append(this.c);
          QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
        }
        this.a.setSelection(this.c + 1);
        this.a.smoothScrollBy(a(ScrollerRunnable.ScrollType.MOVE_UP_JUMP_DIRECT), this.e);
        d();
        this.x = false;
        return;
      }
      this.w += 1;
      if (i1 == this.d)
      {
        i1 = this.m;
        if (i1 > 10)
        {
          this.a.setSelection(this.c + 1);
          this.a.smoothScrollBy(a(ScrollerRunnable.ScrollType.MOVE_UP_EXCEED_TIMES), this.e);
          d();
          return;
        }
        this.m = (i1 + 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("run invoke, tryTimes = ");
        ((StringBuilder)localObject).append(this.m);
        QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
        this.a.post(this);
        return;
      }
      this.m = 0;
      i2 = this.c;
      if (i1 <= i2)
      {
        this.a.setSelection(i2 + 1);
        this.a.smoothScrollBy(a(ScrollerRunnable.ScrollType.MOVE_UP_OTHER), this.e);
        d();
        return;
      }
      localObject = this.a.getChildAt(0);
      if (localObject == null) {
        return;
      }
      i3 = ((View)localObject).getTop();
      if (i1 > this.c) {
        i2 = this.f;
      } else {
        i2 = this.a.getPaddingTop() + this.g;
      }
      i3 -= i2;
      if (this.h)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getScrollOffset(out), MOVE_UP_POS, distance = ");
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append(", extraScroll = ");
          ((StringBuilder)localObject).append(i2);
          QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
        }
        this.a.smoothScrollBy(i3, this.e);
      }
      else if (i1 > this.c)
      {
        this.a.setSelection(0);
      }
      this.d = i1;
      if (i1 > this.c) {
        this.a.post(this);
      }
    }
    else
    {
      if (this.s) {
        i2 = this.a.getChildCount() - 1 - this.a.getFooterViewsCount();
      } else {
        i2 = this.a.getChildCount() - 1;
      }
      int i4 = i1 + i2;
      if (i2 < 0) {
        return;
      }
      if (i4 == this.d)
      {
        if (this.m > 10)
        {
          this.a.setSelection(this.c + 1);
          if (i4 != this.c) {
            this.a.smoothScrollBy(a(ScrollerRunnable.ScrollType.MOVE_DOWN_EXCEED_TIMES), this.e);
          }
          d();
          if (this.g != 0)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getScrollOffset(out), MOVE_DOWN_POS, mlastExtraScroll = ");
              ((StringBuilder)localObject).append(this.g);
              QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
            }
            this.a.smoothScrollBy(this.g, this.e);
            a(0);
          }
          return;
        }
        this.a.post(this);
        this.m += 1;
        return;
      }
      localObject = this.a.getChildAt(i2);
      int i5 = ((View)localObject).getHeight();
      int i6 = ((View)localObject).getTop();
      int i7 = this.a.getPaddingBottom();
      if (i4 < this.a.getCount() - 1) {
        i1 = this.f;
      } else {
        i1 = this.a.getPaddingBottom();
      }
      i1 = i5 - (i3 - i7 - i6) + i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MOVE_DOWN_POS, lastPos = ");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append(", needSmoothScroll = ");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", distance = ");
        ((StringBuilder)localObject).append(i1);
        QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
      }
      if (this.h) {
        this.a.smoothScrollBy(i1, this.e);
      } else if (i4 < this.c) {
        this.a.setSelection(i2);
      }
      this.d = i4;
      if (i4 < this.c) {
        this.a.post(this);
      }
      if (i()) {
        f();
      }
      i1 = this.c;
      if (i4 >= i1)
      {
        this.a.setSelection(i1 + 1);
        if ((i4 != this.c) || (c())) {
          this.a.smoothScrollBy(a(ScrollerRunnable.ScrollType.MOVE_DOWN_OTHER), this.e);
        }
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */