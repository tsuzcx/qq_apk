package com.tencent.mobileqq.flashshow.widgets.comment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.ScrollerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.flashshow.impl.R.styleable;
import com.tencent.biz.qqcircle.utils.QCircleLiuHaiUtils;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.utils.FSDisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class FSSlidBottomView
  extends FrameLayout
  implements NestedScrollingParent
{
  private ObjectAnimator A;
  private ObjectAnimator B;
  private ObjectAnimator C;
  private ObjectAnimator D;
  private ObjectAnimator E;
  private boolean F;
  private boolean G;
  private boolean H;
  protected Interpolator a = new FSSlidBottomView.OpenInterpolator(this, 1.0D);
  protected Interpolator b = new AccelerateInterpolator();
  private final int c = ViewUtils.dip2px(50.0F);
  private final int d = ViewUtils.dip2px(5.0F);
  private final NestedScrollingParentHelper e;
  private final int f;
  private final int g;
  private final int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = -2;
  private int r;
  private int s;
  private int t;
  private int u;
  private View v;
  private boolean w;
  private FSSlidBottomView.IStatusListener x;
  private Interpolator y = new FSSlidBottomView.1(this);
  private ScrollerCompat z = ScrollerCompat.create(getContext(), this.y);
  
  public FSSlidBottomView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.r = FSDisplayUtils.a(paramContext);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.f = localViewConfiguration.getScaledTouchSlop();
    this.g = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.h = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bw);
    float f1 = paramAttributeSet.getFloat(R.styleable.bA, 0.5F);
    this.n = ((int)(this.r * f1));
    this.m = ((int)paramAttributeSet.getDimension(R.styleable.bB, this.c));
    this.o = ((this.r - Math.max(this.l, this.s)) / 6);
    this.p = ((int)paramAttributeSet.getDimension(R.styleable.by, ViewUtils.dip2px(30.0F)));
    this.i = ((int)paramAttributeSet.getDimension(R.styleable.bx, 0.0F));
    this.w = paramAttributeSet.getBoolean(R.styleable.bz, false);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.l = (ImmersiveUtils.getStatusBarHeight(paramContext) - 1);
    }
    paramContext = (Activity)paramContext;
    if (QCircleLiuHaiUtils.d(paramContext))
    {
      QCircleLiuHaiUtils.e(paramContext);
      this.s = QCircleLiuHaiUtils.a();
    }
    paramAttributeSet.recycle();
    int i1 = this.r;
    if (this.w) {
      paramInt = this.o;
    } else {
      paramInt = this.m;
    }
    this.u = (i1 - paramInt - Math.max(this.l, this.s));
    if (this.w)
    {
      paramInt = this.r / 2;
      i1 = this.o;
    }
    else
    {
      paramInt = this.n;
      i1 = this.m;
    }
    this.k = (paramInt - i1);
    paramContext = new StringBuilder();
    paramContext.append("isFix = ");
    paramContext.append(this.w);
    QLog.d("FSSlidBottomView", 4, paramContext.toString());
    this.e = new NestedScrollingParentHelper(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (Math.abs(paramInt2) < this.g) {
      i1 = 0;
    }
    if ((paramInt1 == 0) && (i1 == 0)) {
      return;
    }
    g();
    paramInt2 = this.h;
    paramInt1 = Math.max(-paramInt2, Math.min(paramInt1, paramInt2));
    paramInt2 = this.h;
    paramInt2 = Math.max(-paramInt2, Math.min(i1, paramInt2));
    if (Math.abs(paramInt2) > Math.abs(paramInt1))
    {
      this.z.abortAnimation();
      this.z.fling(0, getScrollY(), paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      if (this.z.computeScrollOffset())
      {
        paramInt1 = this.z.getCurrY();
        paramInt2 = this.z.getFinalY();
        i1 = paramInt2 - paramInt1;
        if (i1 > 0)
        {
          if ((b()) && (i1 > this.r / 2)) {
            d();
          }
        }
        else if (i1 < 0) {
          if (b())
          {
            if (Math.abs(i1) > this.r / 2) {
              e();
            }
          }
          else if (Math.abs(i1) > this.r * 2.0F / 3.0F) {
            e();
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fling start y:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("   end y:");
        localStringBuilder.append(paramInt2);
        QLog.d("FSSlidBottomView", 4, localStringBuilder.toString());
      }
    }
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    if (c()) {
      if (paramInt >= 0) {
        return this.G;
      }
    }
    for (boolean bool = paramRecyclerView.canScrollVertically(-1);; bool = paramRecyclerView.canScrollVertically(-1))
    {
      return true ^ bool;
      if (b())
      {
        if (a(paramRecyclerView)) {
          return true;
        }
        return paramInt <= 0;
      }
      if (paramInt >= 0) {
        return this.G;
      }
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRecyclerView != null)
    {
      bool1 = bool2;
      if ((paramRecyclerView.getAdapter() instanceof BlockMerger))
      {
        bool1 = bool2;
        if (((BlockMerger)paramRecyclerView.getAdapter()).d() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f()
  {
    this.D = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), 0 }).setDuration(200L);
    this.D.start();
    this.q = 0;
    FSSlidBottomView.IStatusListener localIStatusListener = this.x;
    if (localIStatusListener != null) {
      localIStatusListener.a(this.q);
    }
  }
  
  private void g()
  {
    ObjectAnimator localObjectAnimator = this.A;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.B;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.D;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.C;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.E;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  protected void a()
  {
    int i1 = getScrollY();
    i1 = this.t - i1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onend:");
    localStringBuilder.append(this.t);
    QLog.d("FSSlidBottomView", 4, localStringBuilder.toString());
    if (c())
    {
      if (i1 > 0)
      {
        if (Math.abs(i1) > this.u / 6.0F)
        {
          e();
          return;
        }
        d();
        return;
      }
      d();
      return;
    }
    if (b())
    {
      if (i1 > 0)
      {
        if (Math.abs(i1) > this.u / 6.0F)
        {
          e();
          return;
        }
        f();
        return;
      }
      if (Math.abs(i1) > this.u / 8.0F)
      {
        d();
        return;
      }
      f();
      return;
    }
    if (i1 > 0)
    {
      if (Math.abs(i1) > this.u / 2.0F)
      {
        e();
        return;
      }
      if (Math.abs(i1) > this.u / 6.0F)
      {
        f();
        return;
      }
      d();
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.H)
    {
      this.i += paramInt;
      requestLayout();
      this.H = true;
    }
  }
  
  public void a(View paramView)
  {
    if ((FSDisplayUtils.b(paramView.getContext())) && (FSDisplayUtils.e(paramView.getContext())) && (FSDisplayUtils.a((Activity)paramView.getContext()))) {
      this.j = FSDisplayUtils.c(paramView.getContext());
    } else {
      this.j = 0;
    }
    if ((this.q == 0) && (!this.w)) {
      return;
    }
    if (this.w)
    {
      this.q = 2;
      this.A = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.u / 2, this.r / 2 - this.o }).setDuration(1500L);
      QLog.d("FSSlidBottomView", 4, "STATE_FIX");
    }
    else
    {
      this.q = 0;
      this.A = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.u / 2, 0 }).setDuration(1500L);
      QLog.d("FSSlidBottomView", 4, "STATE_HALF");
    }
    this.v = paramView;
    setVisibility(0);
    this.A.addListener(new FSSlidBottomView.2(this));
    this.A.setInterpolator(this.a);
    this.A.start();
  }
  
  public boolean b()
  {
    return this.q == 0;
  }
  
  public boolean c()
  {
    return this.q == 2;
  }
  
  public void d()
  {
    int i2 = getScrollY();
    int i1 = 2;
    this.B = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i2, this.k }).setDuration(1500L);
    this.B.setInterpolator(this.a);
    this.B.start();
    if (!this.w) {
      i1 = 1;
    }
    this.q = i1;
    Object localObject = (FrameLayout.LayoutParams)this.v.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = (this.u + this.d);
    this.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.x;
    if (localObject != null) {
      ((FSSlidBottomView.IStatusListener)localObject).a(this.q);
    }
  }
  
  public void e()
  {
    int i1 = getScrollY();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentY:");
    localStringBuilder.append(i1);
    QLog.d("FSSlidBottomView", 4, localStringBuilder.toString());
    this.C = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i1, -this.u / 2 }).setDuration(200L);
    this.C.setInterpolator(this.b);
    this.C.addListener(new FSSlidBottomView.3(this));
    this.C.start();
    this.q = -1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.e.getNestedScrollAxes();
  }
  
  public int getPanelHeight()
  {
    return this.u;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt3 = this.n;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        localView.setPadding(0, 0, 0, this.i + this.j + this.d);
      }
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3 + this.j + this.d);
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof NestScrollRecyclerView))
    {
      int i1 = (int)paramFloat2;
      if (a(i1, (NestScrollRecyclerView)paramView))
      {
        a((int)paramFloat1, i1);
        paramView = new StringBuilder();
        paramView.append("fling:");
        paramView.append(paramFloat1);
        paramView.append(" ");
        paramView.append(paramFloat2);
        QLog.d("FSSlidBottomView", 4, paramView.toString());
        return true;
      }
    }
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      this.G = true;
      if ((getScrollY() + paramInt2 > this.k) && (paramInt2 > 0))
      {
        paramArrayOfInt[1] = paramInt2;
        return;
      }
      g();
      paramInt1 = this.f;
      if (paramInt2 > paramInt1 * 2) {
        scrollBy(0, paramInt1 * 2);
      } else if (paramInt2 < paramInt1 * -2) {
        scrollBy(0, paramInt1 * -2);
      } else {
        scrollBy(0, paramInt2);
      }
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.e.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.t = getScrollY();
    paramView1 = new StringBuilder();
    paramView1.append("onstart:");
    paramView1.append(this.t);
    QLog.d("FSSlidBottomView", 4, paramView1.toString());
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.e.onStopNestedScroll(paramView);
    if (!this.F) {
      a();
    }
    this.G = false;
  }
  
  public void setStatusListener(FSSlidBottomView.IStatusListener paramIStatusListener)
  {
    this.x = paramIStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView
 * JD-Core Version:    0.7.0.1
 */