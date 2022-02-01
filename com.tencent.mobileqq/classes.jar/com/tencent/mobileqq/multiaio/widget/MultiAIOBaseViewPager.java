package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiAIOBaseViewPager
  extends ViewGroup
{
  static final int[] a = { 16842931 };
  private static final Comparator<MultiAIOBaseViewPager.ItemInfo> k = new MultiAIOBaseViewPager.1();
  private static final Interpolator l = new MultiAIOBaseViewPager.2();
  private float A = 3.4028235E+38F;
  private int B;
  private int C;
  private boolean D;
  private boolean E;
  private boolean F;
  private int G = 1;
  private boolean H;
  private boolean I;
  private int J;
  private int K;
  private int L;
  private float M;
  private float N;
  private float O;
  private float P;
  private int Q = -1;
  private VelocityTracker R;
  private int S;
  private int T;
  private int U;
  private boolean V;
  private long W;
  private EdgeEffect Z;
  private EdgeEffect aa;
  private boolean ab = true;
  private boolean ac = false;
  private boolean ad;
  private int ae;
  private List<MultiAIOBaseViewPager.OnPageChangeListener> af;
  private MultiAIOBaseViewPager.OnPageChangeListener ag;
  private MultiAIOBaseViewPager.OnPageChangeListener ah;
  private List<MultiAIOBaseViewPager.OnAdapterChangeListener> ai;
  private MultiAIOBaseViewPager.PageTransformer aj;
  private int ak;
  private int al;
  private ArrayList<View> am;
  private final MultiAIOBaseViewPager.ViewPositionComparator an = new MultiAIOBaseViewPager.MultiAIOViewPositionComparator(this);
  private final Runnable ao = new MultiAIOBaseViewPager.3(this);
  private int ap = 0;
  protected int b;
  PagerAdapter c;
  int d;
  protected int e;
  private int f = 0;
  private int g;
  private Scroller h;
  private boolean i = true;
  private MultiAIOBaseViewPager.FlingListener j;
  private final ArrayList<MultiAIOBaseViewPager.ItemInfo> m = new ArrayList();
  private final MultiAIOBaseViewPager.ItemInfo n = new MultiAIOBaseViewPager.ItemInfo();
  private final Rect o = new Rect();
  private int p = -1;
  private Parcelable q = null;
  private ClassLoader r = null;
  private Scroller s;
  private boolean t;
  private MultiAIOBaseViewPager.PagerObserver u;
  private int v;
  private Drawable w;
  private int x;
  private int y;
  private float z = -3.402824E+038F;
  
  public MultiAIOBaseViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MultiAIOBaseViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.m.isEmpty()))
    {
      if (!this.s.isFinished())
      {
        this.s.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3)), getScrollY());
      return;
    }
    MultiAIOBaseViewPager.ItemInfo localItemInfo = b(this.d);
    float f1;
    if (localItemInfo != null) {
      f1 = Math.min(localItemInfo.e, this.A);
    } else {
      f1 = 0.0F;
    }
    paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX())
    {
      a(false);
      scrollTo(paramInt1, getScrollY());
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = b(paramInt1);
    int i1;
    if (localObject != null) {
      i1 = (int)(getClientWidth() * Math.max(this.z, Math.min(((MultiAIOBaseViewPager.ItemInfo)localObject).e, this.A)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(i1, 0, paramInt2);
      if (paramBoolean2) {
        f(paramInt1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollToItem() called with: item = [");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("], smoothScroll = [");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append("], velocity = [");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("], dispatchSelected = [");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append("]");
        QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (paramBoolean2) {
        f(paramInt1);
      }
      a(false);
      scrollTo(i1, 0);
      c(i1);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.Q)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.M = paramMotionEvent.getX(i1);
      this.Q = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.R;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  static void a(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    try
    {
      Method localMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[] { DataSetObserver.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramPagerAdapter, new Object[] { paramDataSetObserver });
      return;
    }
    catch (Exception paramPagerAdapter)
    {
      paramPagerAdapter.printStackTrace();
    }
  }
  
  private void a(MultiAIOBaseViewPager.ItemInfo paramItemInfo1, int paramInt, MultiAIOBaseViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.c.getCount();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0) {
      f2 = this.v / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.b;
      if (i1 < paramItemInfo1.b)
      {
        f1 = paramItemInfo2.e + paramItemInfo2.d + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.b) && (i2 < this.m.size()))
        {
          for (paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);; paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 <= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 >= this.m.size() - 1) {
              break;
            }
            i2 += 1;
          }
          while (i3 < paramItemInfo2.b)
          {
            f3 += this.c.getPageWidth(i3) + f2;
            i3 += 1;
          }
          paramItemInfo2.e = f3;
          f1 = f3 + (paramItemInfo2.d + f2);
          i1 = i3 + 1;
        }
      }
      if (i1 > paramItemInfo1.b)
      {
        i2 = this.m.size() - 1;
        f1 = paramItemInfo2.e;
        i1 -= 1;
        while ((i1 >= paramItemInfo1.b) && (i2 >= 0))
        {
          for (paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);; paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 >= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 <= 0) {
              break;
            }
            i2 -= 1;
          }
          while (i3 > paramItemInfo2.b)
          {
            f3 -= this.c.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.d + f2);
          paramItemInfo2.e = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.m.size();
    float f3 = paramItemInfo1.e;
    i1 = paramItemInfo1.b - 1;
    if (paramItemInfo1.b == 0) {
      f1 = paramItemInfo1.e;
    } else {
      f1 = -3.402824E+038F;
    }
    this.z = f1;
    int i2 = paramItemInfo1.b;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.A = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);
      while (i1 > paramItemInfo2.b)
      {
        f1 -= this.c.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.d + f2;
      paramItemInfo2.e = f1;
      if (paramItemInfo2.b == 0) {
        this.z = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.e + paramItemInfo1.d + f2;
    i2 = paramItemInfo1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
      while (paramInt < paramItemInfo1.b)
      {
        f1 += this.c.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.b == i4) {
        this.A = (paramItemInfo1.d + f1 - 1.0F);
      }
      paramItemInfo1.e = f1;
      f1 += paramItemInfo1.d + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.ac = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.ap == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      setScrollingCacheEnabled(false);
      if ((this.s.isFinished() ^ true))
      {
        this.s.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.s.getCurrX();
        int i5 = this.s.getCurrY();
        if ((i2 != i4) || (i3 != i5))
        {
          scrollTo(i4, i5);
          if (i4 != i2) {
            c(i4);
          }
        }
      }
    }
    this.F = false;
    int i3 = 0;
    int i2 = i1;
    int i1 = i3;
    while (i1 < this.m.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
      if (localItemInfo.c)
      {
        localItemInfo.c = false;
        i2 = 1;
      }
      i1 += 1;
    }
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, this.ao);
        return;
      }
      this.ao.run();
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.K) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.K) && (paramFloat2 < 0.0F));
  }
  
  private void b(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.ag;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.af;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.af.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    localObject = this.ah;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      int i2;
      if (paramBoolean) {
        i2 = this.ak;
      } else {
        i2 = 0;
      }
      getChildAt(i1).setLayerType(i2, null);
      i1 += 1;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean c(float paramFloat)
  {
    float f1 = this.M;
    this.M = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = this.z * f3;
    f1 = this.A * f3;
    Object localObject1 = this.m;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject1).get(0);
    Object localObject2 = this.m;
    localObject2 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((MultiAIOBaseViewPager.ItemInfo)localObject1).b != 0)
    {
      paramFloat = ((MultiAIOBaseViewPager.ItemInfo)localObject1).e * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    int i2;
    if (((MultiAIOBaseViewPager.ItemInfo)localObject2).b != this.c.getCount() - 1)
    {
      f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject2).e * f3;
      i2 = 0;
    }
    else
    {
      i2 = 1;
    }
    if (f2 < paramFloat)
    {
      if (i1 != 0)
      {
        this.Z.onPull(Math.abs(paramFloat - f2) / f3);
        bool1 = true;
      }
    }
    else
    {
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (i2 != 0)
        {
          this.aa.onPull(Math.abs(f2 - f1) / f3);
          bool1 = true;
        }
        paramFloat = f1;
      }
    }
    f1 = this.M;
    int i1 = (int)paramFloat;
    this.M = (f1 + (paramFloat - i1));
    scrollTo(i1, getScrollY());
    c(i1);
    return bool1;
  }
  
  private static boolean c(View paramView)
  {
    return paramView.getClass().getAnnotation(MultiAIOBaseViewPager.DecorView.class) != null;
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.ag;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
    localObject = this.af;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.af.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
        }
        i1 += 1;
      }
    }
    localObject = this.ah;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.ag;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.af;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.af.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
        }
        i1 += 1;
      }
    }
    localObject = this.ah;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void m()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((MultiAIOBaseViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private boolean n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "resetTouch() called");
    }
    this.Q = -1;
    p();
    this.Z.onRelease();
    this.aa.onRelease();
    return (this.Z.isFinished()) || (this.aa.isFinished());
  }
  
  private MultiAIOBaseViewPager.ItemInfo o()
  {
    int i1 = getClientWidth();
    float f1;
    if (i1 > 0) {
      f1 = getScrollX() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.v / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.m.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
      int i4 = i1;
      MultiAIOBaseViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.b;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.n;
          localItemInfo1.e = (f3 + f4 + f2);
          localItemInfo1.b = i3;
          localItemInfo1.d = this.c.getPageWidth(localItemInfo1.b);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.e;
      f4 = localItemInfo1.d;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.m.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.b;
        f4 = localItemInfo1.d;
        i1 = i4 + 1;
        i2 = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endDrag() called");
    }
    this.H = false;
    this.I = false;
    VelocityTracker localVelocityTracker = this.R;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.R = null;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  protected int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.T) && (Math.abs(paramInt2) > this.S))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f1;
      if (paramInt1 >= this.d) {
        f1 = 0.4F;
      } else {
        f1 = 0.6F;
      }
      paramInt1 += (int)(paramFloat + f1);
    }
    paramInt2 = paramInt1;
    if (this.m.size() > 0)
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.m.get(0);
      Object localObject = this.m;
      localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.b, Math.min(paramInt1, ((MultiAIOBaseViewPager.ItemInfo)localObject).b));
    }
    return paramInt2;
  }
  
  MultiAIOBaseViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    MultiAIOBaseViewPager.ItemInfo localItemInfo = new MultiAIOBaseViewPager.ItemInfo();
    localItemInfo.b = paramInt1;
    localItemInfo.a = this.c.instantiateItem(this, paramInt1);
    localItemInfo.d = this.c.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.m.size()))
    {
      this.m.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.m.add(localItemInfo);
    return localItemInfo;
  }
  
  MultiAIOBaseViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.m.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
      if (this.c.isViewFromObject(paramView, localItemInfo.a)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.s = new Scroller(localContext, l);
    this.h = new Scroller(getContext());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.L = localViewConfiguration.getScaledPagingTouchSlop();
    this.S = ((int)(400.0F * f1));
    this.e = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.b = VelocityUtil.a(getContext(), this.e);
    this.e = this.b;
    this.Z = new EdgeEffect(localContext);
    this.aa = new EdgeEffect(localContext);
    this.T = ((int)(25.0F * f1));
    this.U = ((int)(2.0F * f1));
    this.J = ((int)(f1 * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new MultiAIOBaseViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new MultiAIOBaseViewPager.4(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("populate() called with: newCurrentItem = [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.d;
    if (i1 != paramInt)
    {
      localObject2 = b(i1);
      this.d = paramInt;
    }
    else
    {
      localObject2 = null;
    }
    if (this.c == null)
    {
      d();
      return;
    }
    if (this.F)
    {
      d();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.c.startUpdate(this);
    paramInt = this.G;
    int i7 = Math.max(0, this.d - paramInt);
    int i5 = this.c.getCount();
    int i6 = Math.min(i5 - 1, this.d + paramInt);
    if (i5 == this.g)
    {
      paramInt = 0;
      while (paramInt < this.m.size())
      {
        localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(paramInt);
        if (((MultiAIOBaseViewPager.ItemInfo)localObject1).b >= this.d)
        {
          if (((MultiAIOBaseViewPager.ItemInfo)localObject1).b != this.d) {
            break;
          }
          break label236;
        }
        paramInt += 1;
      }
      localObject1 = null;
      label236:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (i5 > 0) {
          localObject3 = a(this.d, paramInt);
        }
      }
      if (localObject3 != null)
      {
        i1 = paramInt - 1;
        if (i1 >= 0) {
          localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
        } else {
          localObject1 = null;
        }
        int i8 = getClientWidth();
        float f3;
        float f1;
        if (i8 <= 0)
        {
          f3 = 0.0F;
        }
        else
        {
          f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject3).d;
          f3 = getPaddingLeft() / i8 + (2.0F - f1);
        }
        int i4 = this.d - 1;
        float f2 = 0.0F;
        int i3;
        Object localObject4;
        while (i4 >= 0)
        {
          if ((f2 >= f3) && (i4 < i7))
          {
            if (localObject1 == null) {
              break;
            }
            f1 = f2;
            i3 = paramInt;
            localObject4 = localObject1;
            i2 = i1;
            if (i4 != ((MultiAIOBaseViewPager.ItemInfo)localObject1).b) {
              break label623;
            }
            f1 = f2;
            i3 = paramInt;
            localObject4 = localObject1;
            i2 = i1;
            if (((MultiAIOBaseViewPager.ItemInfo)localObject1).c) {
              break label623;
            }
            this.m.remove(i1);
            this.c.destroyItem(this, i4, ((MultiAIOBaseViewPager.ItemInfo)localObject1).a);
            i1 -= 1;
            paramInt -= 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
              f1 = f2;
              break label612;
            }
          }
          else if ((localObject1 != null) && (i4 == ((MultiAIOBaseViewPager.ItemInfo)localObject1).b))
          {
            f2 += ((MultiAIOBaseViewPager.ItemInfo)localObject1).d;
            i1 -= 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
              f1 = f2;
              break label612;
            }
          }
          else
          {
            f2 += a(i4, i1 + 1).d;
            paramInt += 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
              f1 = f2;
              break label612;
            }
          }
          localObject1 = null;
          i1 = i3;
          paramInt = i2;
          label612:
          i2 = i1;
          localObject4 = localObject1;
          i3 = paramInt;
          label623:
          i4 -= 1;
          f2 = f1;
          paramInt = i3;
          localObject1 = localObject4;
          i1 = i2;
        }
        f2 = ((MultiAIOBaseViewPager.ItemInfo)localObject3).d;
        int i2 = paramInt + 1;
        if (f2 < 2.0F)
        {
          if (i2 < this.m.size()) {
            localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);
          } else {
            localObject1 = null;
          }
          if (i8 <= 0) {
            f3 = 0.0F;
          } else {
            f3 = getPaddingRight() / i8 + 2.0F;
          }
          i1 = this.d;
          localObject4 = localObject1;
          for (;;)
          {
            i3 = i1 + 1;
            if (i3 >= i5) {
              break;
            }
            if ((f2 >= f3) && (i3 > i6))
            {
              if (localObject4 == null) {
                break;
              }
              f1 = f2;
              i1 = i2;
              localObject1 = localObject4;
              if (i3 != localObject4.b) {
                break label1005;
              }
              f1 = f2;
              i1 = i2;
              localObject1 = localObject4;
              if (localObject4.c) {
                break label1005;
              }
              this.m.remove(i2);
              this.c.destroyItem(this, i3, localObject4.a);
              f1 = f2;
              i1 = i2;
              if (i2 < this.m.size())
              {
                localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);
                f1 = f2;
                i1 = i2;
                break label1005;
              }
            }
            do
            {
              do
              {
                localObject1 = null;
                break label1005;
                if ((localObject4 == null) || (i3 != localObject4.b)) {
                  break;
                }
                f2 += localObject4.d;
                i2 += 1;
                f1 = f2;
                i1 = i2;
              } while (i2 >= this.m.size());
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);
              f1 = f2;
              i1 = i2;
              break;
              localObject1 = a(i3, i2);
              i2 += 1;
              f2 += ((MultiAIOBaseViewPager.ItemInfo)localObject1).d;
              f1 = f2;
              i1 = i2;
            } while (i2 >= this.m.size());
            localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i2);
            i1 = i2;
            f1 = f2;
            label1005:
            f2 = f1;
            i2 = i1;
            localObject4 = localObject1;
            i1 = i3;
          }
        }
        a((MultiAIOBaseViewPager.ItemInfo)localObject3, paramInt, (MultiAIOBaseViewPager.ItemInfo)localObject2);
        this.c.setPrimaryItem(this, this.d, ((MultiAIOBaseViewPager.ItemInfo)localObject3).a);
      }
      this.c.finishUpdate(this);
      i1 = getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject2 = getChildAt(paramInt);
        localObject1 = (MultiAIOBaseViewPager.LayoutParams)((View)localObject2).getLayoutParams();
        ((MultiAIOBaseViewPager.LayoutParams)localObject1).f = paramInt;
        if ((!((MultiAIOBaseViewPager.LayoutParams)localObject1).a) && (((MultiAIOBaseViewPager.LayoutParams)localObject1).c == 0.0F))
        {
          localObject2 = a((View)localObject2);
          if (localObject2 != null)
          {
            ((MultiAIOBaseViewPager.LayoutParams)localObject1).c = ((MultiAIOBaseViewPager.ItemInfo)localObject2).d;
            ((MultiAIOBaseViewPager.LayoutParams)localObject1).e = ((MultiAIOBaseViewPager.ItemInfo)localObject2).b;
          }
        }
        paramInt += 1;
      }
      d();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = b((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((MultiAIOBaseViewPager.ItemInfo)localObject1).b != this.d))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = a((View)localObject1);
            if ((localObject2 != null) && (((MultiAIOBaseViewPager.ItemInfo)localObject2).b == this.d) && (((View)localObject1).requestFocus(2))) {
              return;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1280:
      break label1280;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i5);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.c.getClass());
    localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.ae;
    int i6 = 0;
    View localView;
    if (i1 > 0)
    {
      int i7 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i8 = getWidth();
      int i9 = getChildCount();
      int i4 = 0;
      while (i4 < i9)
      {
        localView = getChildAt(i4);
        MultiAIOBaseViewPager.LayoutParams localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.a)
        {
          int i3 = localLayoutParams.b & 0x7;
          if (i3 != 1)
          {
            int i5;
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i5 = i1;
                i3 = i1;
                i1 = i5;
              }
              else
              {
                i3 = i8 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
              }
            }
            else
            {
              i5 = localView.getWidth() + i1;
              i3 = i1;
              i1 = i5;
            }
          }
          else
          {
            i3 = Math.max((i8 - localView.getMeasuredWidth()) / 2, i1);
          }
          i3 = i3 + i7 - localView.getLeft();
          if (i3 != 0) {
            localView.offsetLeftAndRight(i3);
          }
        }
        i4 += 1;
      }
    }
    b(paramInt1, paramFloat, paramInt2);
    if (this.aj != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (!((MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams()).a)
        {
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.aj.a(localView, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.ad = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    Scroller localScroller = this.s;
    int i1;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (this.t) {
        i1 = this.s.getCurrX();
      } else {
        i1 = this.s.getStartX();
      }
      this.s.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    else
    {
      i1 = getScrollX();
    }
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i4 = paramInt1 / 2;
    float f2 = Math.abs(i3);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = i4;
    f3 = a(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    }
    else
    {
      f2 = this.c.getPageWidth(this.d);
      paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.v) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    this.t = false;
    this.s.startScroll(i1, i2, i3, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    PagerAdapter localPagerAdapter = this.c;
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      if ((!paramBoolean2) && (this.f == paramInt1) && (this.m.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      paramBoolean2 = true;
      int i1;
      if (paramInt1 < 0)
      {
        i1 = 0;
      }
      else
      {
        i1 = paramInt1;
        if (paramInt1 >= this.c.getCount()) {
          i1 = this.c.getCount() - 1;
        }
      }
      paramInt1 = this.G;
      int i2 = this.d;
      if ((i1 > i2 + paramInt1) || (i1 < i2 - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.m.size())
        {
          ((MultiAIOBaseViewPager.ItemInfo)this.m.get(paramInt1)).c = true;
          paramInt1 += 1;
        }
      }
      if (this.f == i1) {
        paramBoolean2 = false;
      }
      if (this.ab)
      {
        this.d = i1;
        this.f = this.d;
        if (paramBoolean2) {
          f(i1);
        }
        requestLayout();
        return;
      }
      a(i1);
      this.f = this.d;
      a(i1, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  public void a(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.af == null) {
      this.af = new ArrayList();
    }
    this.af.add(paramOnPageChangeListener);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i1 = paramKeyEvent.getKeyCode();
      if (i1 != 21)
      {
        if (i1 != 22)
        {
          if (i1 == 61)
          {
            if (paramKeyEvent.hasNoModifiers()) {
              return d(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
              return d(1);
            }
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2)) {
            return i();
          }
          return d(66);
        }
      }
      else
      {
        if (paramKeyEvent.hasModifiers(2)) {
          return h();
        }
        return d(17);
      }
    }
    return false;
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = localViewGroup.getChildAt(i1);
        int i4 = paramInt2 + i2;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i3;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
            return true;
          }
        }
        i1 -= 1;
      }
    }
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
          if ((localItemInfo != null) && (localItemInfo.b == this.d)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if ((i3 != 262144) || (i2 == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.d)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.a |= c(paramView);
    if (this.D)
    {
      if (!paramLayoutParams.a)
      {
        paramLayoutParams.d = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  MultiAIOBaseViewPager.ItemInfo b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.m.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
      if (localItemInfo.b == paramInt) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  MultiAIOBaseViewPager.ItemInfo b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return a(paramView);
  }
  
  void b()
  {
    int i9 = this.c.getCount();
    this.g = i9;
    if ((this.m.size() < this.G * 2 + 1) && (this.m.size() < i9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = this.d;
    int i6 = i1;
    int i1 = i2;
    int i3 = 0;
    i2 = 0;
    Object localObject;
    while (i3 < this.m.size())
    {
      localObject = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i3);
      int i8 = this.c.getItemPosition(((MultiAIOBaseViewPager.ItemInfo)localObject).a);
      int i4;
      int i5;
      int i7;
      if (i8 == -1)
      {
        i4 = i3;
        i5 = i2;
        i7 = i1;
      }
      else
      {
        if (i8 == -2)
        {
          this.m.remove(i3);
          i5 = i3 - 1;
          i4 = i2;
          if (i2 == 0)
          {
            this.c.startUpdate(this);
            i4 = 1;
          }
          this.c.destroyItem(this, ((MultiAIOBaseViewPager.ItemInfo)localObject).b, ((MultiAIOBaseViewPager.ItemInfo)localObject).a);
          i3 = i5;
          i2 = i4;
          if (this.d == ((MultiAIOBaseViewPager.ItemInfo)localObject).b)
          {
            i1 = Math.max(0, Math.min(this.d, i9 - 1));
            i2 = i4;
            i3 = i5;
          }
        }
        for (;;)
        {
          i6 = 1;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          break;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          if (((MultiAIOBaseViewPager.ItemInfo)localObject).b == i8) {
            break;
          }
          if (((MultiAIOBaseViewPager.ItemInfo)localObject).b == this.d) {
            i1 = i8;
          }
          ((MultiAIOBaseViewPager.ItemInfo)localObject).b = i8;
        }
      }
      i3 = i4 + 1;
      i2 = i5;
      i1 = i7;
    }
    if (i2 != 0) {
      this.c.finishUpdate(this);
    }
    Collections.sort(this.m, k);
    if (i6 != 0)
    {
      i3 = getChildCount();
      i2 = 0;
      while (i2 < i3)
      {
        localObject = (MultiAIOBaseViewPager.LayoutParams)getChildAt(i2).getLayoutParams();
        if (!((MultiAIOBaseViewPager.LayoutParams)localObject).a) {
          ((MultiAIOBaseViewPager.LayoutParams)localObject).c = 0.0F;
        }
        i2 += 1;
      }
      a(i1, false, true);
      requestLayout();
    }
  }
  
  public void b(float paramFloat)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fakeDragBy() called with: xOffset = [");
      ((StringBuilder)localObject1).append(paramFloat);
      ((StringBuilder)localObject1).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.V)
    {
      if (this.c == null) {
        return;
      }
      this.M += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = getClientWidth();
      paramFloat = this.z * f3;
      float f1 = this.A * f3;
      localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.m.get(0);
      Object localObject2 = this.m;
      localObject2 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((MultiAIOBaseViewPager.ItemInfo)localObject1).b != 0) {
        paramFloat = ((MultiAIOBaseViewPager.ItemInfo)localObject1).e * f3;
      }
      if (((MultiAIOBaseViewPager.ItemInfo)localObject2).b != this.c.getCount() - 1) {
        f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject2).e * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = this.M;
      int i1 = (int)paramFloat;
      this.M = (f1 + (paramFloat - i1));
      scrollTo(i1, getScrollY());
      c(i1);
      long l1 = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.W, l1, 2, this.M, 0.0F, 0);
      if (this.R == null) {
        this.R = VelocityTracker.obtain();
      }
      this.R.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public void b(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.af;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  void c()
  {
    a(this.d);
  }
  
  boolean c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pageScrolled() called with: xpos = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.m.size() == 0)
    {
      if (this.ab) {
        return false;
      }
      this.ad = false;
      a(0, 0.0F, 0);
      if (this.ad) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    Object localObject = o();
    if (localObject == null) {
      return false;
    }
    int i2 = getClientWidth();
    int i3 = this.v;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).b;
    f1 = (paramInt / f1 - ((MultiAIOBaseViewPager.ItemInfo)localObject).e) / (((MultiAIOBaseViewPager.ItemInfo)localObject).d + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.ad = false;
    a(i1, f1, paramInt);
    if (this.ad) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    PagerAdapter localPagerAdapter = this.c;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    int i1 = getClientWidth();
    int i2 = getScrollX();
    if (paramInt < 0)
    {
      if (i2 > (int)(i1 * this.z)) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (i2 < (int)(i1 * this.A)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof MultiAIOBaseViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.t = true;
    if ((!this.s.isFinished()) && (this.s.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.s.getCurrX();
      int i4 = this.s.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!c(i3))
        {
          this.s.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    a(true);
  }
  
  protected void d()
  {
    if (this.al != 0)
    {
      Object localObject = this.am;
      if (localObject == null) {
        this.am = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.am.add(localObject);
        i1 += 1;
      }
      Collections.sort(this.am, this.an);
    }
  }
  
  public boolean d(int paramInt)
  {
    View localView2 = findFocus();
    boolean bool = false;
    View localView1 = null;
    Object localObject;
    int i1;
    if (localView2 == this)
    {
      localObject = localView1;
    }
    else
    {
      if (localView2 != null)
      {
        for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
          if (localObject == this)
          {
            i1 = 1;
            break label70;
          }
        }
        i1 = 0;
        label70:
        if (i1 == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView2.getClass().getSimpleName());
          for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject.getClass().getSimpleName());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          Log.e("MultiAIOBaseViewPager", ((StringBuilder)localObject).toString());
          localObject = localView1;
          break label199;
        }
      }
      localObject = localView2;
    }
    label199:
    localView1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    int i2;
    if ((localView1 != null) && (localView1 != localObject)) {
      if (paramInt == 17)
      {
        i1 = a(this.o, localView1).left;
        i2 = a(this.o, (View)localObject).left;
        if ((localObject != null) && (i1 >= i2)) {
          bool = h();
        } else {
          bool = localView1.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i1 = a(this.o, localView1).left;
        i2 = a(this.o, (View)localObject).left;
        if ((localObject != null) && (i1 <= i2))
        {
          bool = i();
        }
        else
        {
          bool = localView1.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = i();
            }
          }
          else {
            bool = h();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.d) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i4 = getOverScrollMode();
    int i3 = 0;
    int i1 = 0;
    if (i4 != 0) {
      if (i4 == 1)
      {
        PagerAdapter localPagerAdapter = this.c;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.Z.finish();
        this.aa.finish();
        break label256;
      }
    }
    int i2;
    if (!this.Z.isFinished())
    {
      i3 = paramCanvas.save();
      i1 = getHeight() - getPaddingTop() - getPaddingBottom();
      i4 = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i1 + getPaddingTop(), this.z * i4);
      this.Z.setSize(i1, i4);
      i2 = false | this.Z.draw(paramCanvas);
      paramCanvas.restoreToCount(i3);
    }
    i3 = i2;
    boolean bool;
    if (!this.aa.isFinished())
    {
      i4 = paramCanvas.save();
      i3 = getWidth();
      int i5 = getHeight();
      int i6 = getPaddingTop();
      int i7 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.A + 1.0F) * i3);
      this.aa.setSize(i5 - i6 - i7, i3);
      bool = i2 | this.aa.draw(paramCanvas);
      paramCanvas.restoreToCount(i4);
    }
    label256:
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.w;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void e(int paramInt)
  {
    this.F = true;
    int i1 = getClientWidth();
    int i2 = getScrollX();
    MultiAIOBaseViewPager.ItemInfo localItemInfo = o();
    if (localItemInfo == null) {
      return;
    }
    a(a(localItemInfo.b, (i2 / i1 - localItemInfo.e) / localItemInfo.d, paramInt, this.T - 1), true, true, paramInt);
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "beginFakeDrag() called");
    }
    if (this.H) {
      return false;
    }
    this.V = true;
    setScrollState(1);
    this.M = 0.0F;
    this.O = 0.0F;
    Object localObject = this.R;
    if (localObject == null) {
      this.R = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l1 = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
    this.R.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    this.W = l1;
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endFakeDrag() called");
    }
    if (this.V)
    {
      if (this.c != null)
      {
        if (this.R == null) {
          this.R = VelocityTracker.obtain();
        }
        Object localObject = this.R;
        ((VelocityTracker)localObject).clear();
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.e);
        int i1 = (int)((VelocityTracker)localObject).getXVelocity(this.Q);
        this.F = true;
        int i2 = getClientWidth();
        int i3 = getScrollX();
        localObject = o();
        if (localObject == null) {
          return;
        }
        a(((MultiAIOBaseViewPager.ItemInfo)localObject).b, (i3 / i2 - ((MultiAIOBaseViewPager.ItemInfo)localObject).e) / ((MultiAIOBaseViewPager.ItemInfo)localObject).d, i1, (int)(this.M - this.O));
      }
      p();
      this.V = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean g()
  {
    return this.V;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new MultiAIOBaseViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new MultiAIOBaseViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.c;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.al == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((MultiAIOBaseViewPager.LayoutParams)((View)this.am.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.d;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.G;
  }
  
  public int getPageMargin()
  {
    return this.v;
  }
  
  public int getScrollState()
  {
    return this.ap;
  }
  
  boolean h()
  {
    int i1 = this.d;
    if (i1 > 0)
    {
      setCurrentItem(i1 - 1, true);
      return true;
    }
    return false;
  }
  
  boolean i()
  {
    PagerAdapter localPagerAdapter = this.c;
    if ((localPagerAdapter != null) && (this.d < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.d + 1, true);
      return true;
    }
    return false;
  }
  
  protected boolean j()
  {
    return this.ab;
  }
  
  public boolean k()
  {
    Scroller localScroller = this.s;
    if (localScroller != null) {
      return localScroller.isFinished();
    }
    return true;
  }
  
  public void l()
  {
    Scroller localScroller = this.s;
    if (localScroller != null) {
      localScroller.abortAnimation();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.ab = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ao);
    Scroller localScroller = this.s;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      this.s.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.v > 0) && (this.w != null) && (this.m.size() > 0) && (this.c != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f1 = this.v;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.m;
      int i2 = 0;
      localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).e;
      int i5 = this.m.size();
      int i1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).b;
      int i6 = ((MultiAIOBaseViewPager.ItemInfo)this.m.get(i5 - 1)).b;
      while (i1 < i6)
      {
        while ((i1 > ((MultiAIOBaseViewPager.ItemInfo)localObject).b) && (i2 < i5))
        {
          localObject = this.m;
          i2 += 1;
          localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((MultiAIOBaseViewPager.ItemInfo)localObject).b)
        {
          f3 = (((MultiAIOBaseViewPager.ItemInfo)localObject).e + ((MultiAIOBaseViewPager.ItemInfo)localObject).d) * f5;
          f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).e + ((MultiAIOBaseViewPager.ItemInfo)localObject).d + f2;
        }
        else
        {
          float f4 = this.c.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        if (this.v + f3 > i3)
        {
          this.w.setBounds(Math.round(f3), this.x, Math.round(this.v + f3), this.y);
          this.w.draw(paramCanvas);
        }
        if (f3 > i3 + i4) {
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 != 0)
      {
        if (this.H) {
          return true;
        }
        if (this.I) {
          return false;
        }
      }
      float f1;
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 == 6) {
            a(paramMotionEvent);
          }
        }
        else
        {
          i1 = this.Q;
          if (i1 != -1)
          {
            i1 = paramMotionEvent.findPointerIndex(i1);
            if ((i1 >= 0) && (i1 <= paramMotionEvent.getPointerCount() - 1))
            {
              f1 = this.M;
              try
              {
                f2 = paramMotionEvent.getX(i1);
                f1 = f2;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException1);
                }
              }
              float f4 = f1 - this.M;
              float f5 = Math.abs(f4);
              float f2 = this.N;
              try
              {
                f3 = paramMotionEvent.getY(i1);
                f2 = f3;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException2);
                }
              }
              float f3 = Math.abs(f2 - this.P);
              if ((f4 != 0.0F) && (!a(this.M, f4)) && (a(this, false, (int)f4, (int)f1, (int)f2)))
              {
                this.M = f1;
                this.N = f2;
                this.I = true;
                return false;
              }
              if ((f5 > this.L) && (f5 * 0.5F > f3))
              {
                this.H = true;
                c(true);
                setScrollState(1);
                if (f4 > 0.0F) {
                  f3 = this.O + this.L;
                } else {
                  f3 = this.O - this.L;
                }
                this.M = f3;
                this.N = f2;
                setScrollingCacheEnabled(true);
              }
              else if (f3 > this.L)
              {
                this.I = true;
              }
              if ((this.H) && (c(f1))) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.O = f1;
        this.M = f1;
        f1 = paramMotionEvent.getY();
        this.P = f1;
        this.N = f1;
        this.Q = paramMotionEvent.getPointerId(0);
        this.I = false;
        this.t = true;
        this.s.computeScrollOffset();
        if ((this.ap == 2) && (Math.abs(this.s.getFinalX() - this.s.getCurrX()) > this.U)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        MultiAIOBaseViewPager.FlingListener localFlingListener = this.j;
        boolean bool;
        if (localFlingListener != null) {
          bool = localFlingListener.a() ^ true;
        }
        if (bool)
        {
          this.s.abortAnimation();
          localFlingListener = this.j;
          if (localFlingListener != null) {
            localFlingListener.b();
          }
          this.F = false;
          c();
          this.H = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.H = false;
        }
      }
      if (this.R == null) {
        this.R = VelocityTracker.obtain();
      }
      this.R.addMovement(paramMotionEvent);
      return this.H;
    }
    n();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i8 = getChildCount();
    int i9 = paramInt3 - paramInt1;
    int i10 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i2 = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i11 = getScrollX();
    int i3 = 0;
    int i4 = 0;
    View localView;
    int i1;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    while (i4 < i8)
    {
      localView = getChildAt(i4);
      i1 = paramInt2;
      int i7 = i2;
      int i6 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt2;
        i7 = i2;
        i6 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i3;
        if (localLayoutParams.a)
        {
          paramInt3 = localLayoutParams.b & 0x7;
          i5 = localLayoutParams.b & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i1 = paramInt2;
              }
              else
              {
                paramInt3 = i9 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
                i1 = paramInt2;
              }
            }
            else
            {
              i1 = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i1 += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
            i1 = paramInt2;
          }
          if (i5 != 16)
          {
            if (i5 != 48)
            {
              if (i5 != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i10 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i5 = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i11;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = i3 + 1;
          i5 = paramInt4;
          i6 = paramInt1;
          i7 = i2;
        }
      }
      i4 += 1;
      paramInt2 = i1;
      i2 = i7;
      paramInt1 = i6;
      paramInt4 = i5;
      i3 = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i8)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.a)
        {
          MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i9 - paramInt2 - i2;
            i1 = (int)(localItemInfo.e * f1) + paramInt2;
            if (localLayoutParams.d)
            {
              localLayoutParams.d = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i1, paramInt1, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.x = paramInt1;
    this.y = (i10 - paramInt4);
    this.ae = i3;
    if (this.ab) {
      a(this.d, false, 0, false);
    }
    this.ab = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.K = Math.min(paramInt1 / 10, this.J);
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i9 = getChildCount();
    paramInt2 = paramInt2 - i3 - i4;
    paramInt1 = paramInt1 - i1 - i2;
    i3 = 0;
    View localView;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      int i6 = 1;
      int i8 = 1073741824;
      if (i3 >= i9) {
        break;
      }
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i2 = localLayoutParams.b & 0x70;
            int i5;
            if ((i2 != 48) && (i2 != 80)) {
              i5 = 0;
            } else {
              i5 = 1;
            }
            i4 = i6;
            if (i1 != 3) {
              if (i1 == 5) {
                i4 = i6;
              } else {
                i4 = 0;
              }
            }
            i1 = -2147483648;
            if (i5 != 0)
            {
              i2 = 1073741824;
            }
            else
            {
              i2 = i1;
              if (i4 != 0)
              {
                i6 = 1073741824;
                i2 = i1;
                i1 = i6;
                break label282;
              }
            }
            i1 = -2147483648;
            label282:
            int i7;
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1) {
                i2 = localLayoutParams.width;
              } else {
                i2 = paramInt1;
              }
              i6 = 1073741824;
              i7 = i2;
            }
            else
            {
              i7 = paramInt1;
              i6 = i2;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i1 = localLayoutParams.height;
              } else {
                i1 = paramInt2;
              }
            }
            else
            {
              i2 = paramInt2;
              i8 = i1;
              i1 = i2;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), View.MeasureSpec.makeMeasureSpec(i1, i8));
            if (i5 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      i3 += 1;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    this.B = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.C = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.D = true;
    c();
    paramInt2 = 0;
    this.D = false;
    i1 = getChildCount();
    while (paramInt2 < i1)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.a))
        {
          float f1 = 0.0F;
          if (localLayoutParams != null) {
            f1 = localLayoutParams.c;
          }
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * f1), 1073741824), this.C);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = getChildCount();
    int i3 = -1;
    int i2;
    if ((paramInt & 0x2) != 0)
    {
      i3 = i1;
      i1 = 0;
      i2 = 1;
    }
    else
    {
      i1 -= 1;
      i2 = -1;
    }
    while (i1 != i3)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.d) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i1 += i2;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof MultiAIOBaseViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MultiAIOBaseViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    PagerAdapter localPagerAdapter = this.c;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.p = paramParcelable.a;
    this.q = paramParcelable.b;
    this.r = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    MultiAIOBaseViewPager.SavedState localSavedState = new MultiAIOBaseViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.d;
    PagerAdapter localPagerAdapter = this.c;
    if (localPagerAdapter != null) {
      localSavedState.b = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.v;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.V) {
      return true;
    }
    int i2 = paramMotionEvent.getAction();
    boolean bool2 = false;
    int i1 = 0;
    if ((i2 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (this.R == null) {
        this.R = VelocityTracker.obtain();
      }
      this.R.addMovement(paramMotionEvent);
      i2 = paramMotionEvent.getAction() & 0xFF;
      boolean bool1;
      float f1;
      if (i2 != 0)
      {
        float f2;
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 5)
              {
                if (i2 != 6)
                {
                  bool1 = bool2;
                }
                else
                {
                  a(paramMotionEvent);
                  i1 = paramMotionEvent.findPointerIndex(this.Q);
                  try
                  {
                    this.M = paramMotionEvent.getX(i1);
                    bool1 = bool2;
                  }
                  catch (Exception paramMotionEvent)
                  {
                    QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
                    bool1 = bool2;
                  }
                }
              }
              else
              {
                i1 = paramMotionEvent.getActionIndex();
                try
                {
                  this.M = paramMotionEvent.getX(i1);
                  this.Q = paramMotionEvent.getPointerId(i1);
                  bool1 = bool2;
                }
                catch (Exception paramMotionEvent)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
                  bool1 = bool2;
                }
              }
            }
            else
            {
              bool1 = bool2;
              if (this.H)
              {
                a(this.d, true, 0, false);
                bool1 = n();
              }
            }
          }
          else
          {
            if (!this.H)
            {
              i1 = paramMotionEvent.findPointerIndex(this.Q);
              if (i1 == -1)
              {
                bool1 = n();
                break label776;
              }
              f1 = paramMotionEvent.getX(i1);
              float f3 = Math.abs(f1 - this.M);
              f2 = paramMotionEvent.getY(i1);
              float f4 = Math.abs(f2 - this.N);
              if ((f3 > this.L) && (f3 > f4))
              {
                this.H = true;
                c(true);
                f3 = this.O;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.L;
                } else {
                  f1 = f3 - this.L;
                }
                this.M = f1;
                this.N = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            bool1 = bool2;
            if (this.H)
            {
              i1 = paramMotionEvent.findPointerIndex(this.Q);
              bool1 = bool2;
              if (i1 != -1) {
                bool1 = false | c(paramMotionEvent.getX(i1));
              }
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (this.H)
          {
            localObject = this.R;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.e);
            i2 = (int)((VelocityTracker)localObject).getXVelocity(this.Q);
            this.F = true;
            int i3 = getClientWidth();
            int i4 = getScrollX();
            localObject = o();
            if (localObject == null) {
              return false;
            }
            f2 = this.v;
            f1 = i3;
            f2 /= f1;
            i3 = ((MultiAIOBaseViewPager.ItemInfo)localObject).b;
            f2 = (i4 / f1 - ((MultiAIOBaseViewPager.ItemInfo)localObject).e) / (((MultiAIOBaseViewPager.ItemInfo)localObject).d + f2);
            i4 = paramMotionEvent.findPointerIndex(this.Q);
            f1 = this.M;
            if (i4 != -1) {
              f1 = paramMotionEvent.getX(i4);
            }
            i4 = (int)(f1 - this.O);
            if ((Math.abs(i4) > this.T * 4) && (Math.abs(i2) > this.S)) {
              i1 = 1;
            } else {
              a(a(i3, f2, i2, i4), true, true, i2);
            }
            bool1 = n();
            if (i1 != 0)
            {
              paramMotionEvent = this.j;
              if (paramMotionEvent != null) {
                paramMotionEvent.a(i2);
              }
            }
          }
        }
      }
      else
      {
        this.s.abortAnimation();
        this.F = false;
        c();
        f1 = paramMotionEvent.getX();
        this.O = f1;
        this.M = f1;
        f1 = paramMotionEvent.getY();
        this.P = f1;
        this.N = f1;
        this.Q = paramMotionEvent.getPointerId(0);
        bool1 = bool2;
      }
      label776:
      if (bool1) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  public void removeView(View paramView)
  {
    if (this.D)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    Object localObject = this.c;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      a((PagerAdapter)localObject, null);
      this.c.startUpdate(this);
      i1 = 0;
      while (i1 < this.m.size())
      {
        localObject = (MultiAIOBaseViewPager.ItemInfo)this.m.get(i1);
        this.c.destroyItem(this, ((MultiAIOBaseViewPager.ItemInfo)localObject).b, ((MultiAIOBaseViewPager.ItemInfo)localObject).a);
        i1 += 1;
      }
      this.c.finishUpdate(this);
      this.m.clear();
      m();
      this.d = 0;
      this.f = 0;
      scrollTo(0, 0);
    }
    localObject = this.c;
    this.c = paramPagerAdapter;
    this.g = 0;
    if (this.c != null)
    {
      if (this.u == null) {
        this.u = new MultiAIOBaseViewPager.PagerObserver(this);
      }
      a(this.c, this.u);
      this.F = false;
      boolean bool = this.ab;
      this.ab = true;
      this.g = this.c.getCount();
      if (this.p >= 0)
      {
        this.c.restoreState(this.q, this.r);
        a(this.p, false, true);
        this.p = -1;
        this.q = null;
        this.r = null;
      }
      else if (!bool)
      {
        c();
      }
      else
      {
        requestLayout();
      }
    }
    List localList = this.ai;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i3 = this.ai.size();
      i1 = i2;
      while (i1 < i3)
      {
        ((MultiAIOBaseViewPager.OnAdapterChangeListener)this.ai.get(i1)).a(this, (PagerAdapter)localObject, paramPagerAdapter);
        i1 += 1;
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.F = false;
    a(paramInt, this.ab ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    setCurrentItem(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.F = false;
    a(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setFlingListener(MultiAIOBaseViewPager.FlingListener paramFlingListener)
  {
    this.j = paramFlingListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("MultiAIOBaseViewPager", localStringBuilder.toString());
      i1 = 1;
    }
    if (i1 != this.G)
    {
      this.G = i1;
      c();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.ag = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.v;
    this.v = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.w = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, MultiAIOBaseViewPager.PageTransformer paramPageTransformer)
  {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, MultiAIOBaseViewPager.PageTransformer paramPageTransformer, int paramInt)
  {
    int i2 = 1;
    boolean bool1;
    if (paramPageTransformer != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.aj != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i1;
    if (bool1 != bool2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.aj = paramPageTransformer;
    setChildrenDrawingOrderEnabled(bool1);
    if (bool1)
    {
      if (paramBoolean) {
        i2 = 2;
      }
      this.al = i2;
      this.ak = paramInt;
    }
    else
    {
      this.al = 0;
    }
    if (i1 != 0) {
      c();
    }
  }
  
  void setScrollState(int paramInt)
  {
    if (this.ap == paramInt) {
      return;
    }
    this.ap = paramInt;
    if (this.aj != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      b(bool);
    }
    g(paramInt);
  }
  
  void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.E != paramBoolean) {
      this.E = paramBoolean;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager
 * JD-Core Version:    0.7.0.1
 */