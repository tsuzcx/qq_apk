package com.tencent.mobileqq.flashshow.personal.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.animation.interpolator.BezierInterpolator;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.IRefreshViewProvider.OnRefreshListener;
import com.tencent.biz.richframework.widget.QCircleRippleAnimView;
import com.tencent.mobileqq.flashshow.view.refresh.ChrysanthemumLoadingView;
import com.tencent.qphone.base.util.QLog;

public class FSRefreshHeaderView
  extends LinearLayout
  implements IRefreshViewProvider
{
  private FrameLayout a;
  private LinearLayout b;
  private FrameLayout c;
  private ImageView d;
  private TextView e;
  private ChrysanthemumLoadingView f;
  private TextView g;
  private int h;
  private int i;
  private float j;
  private float k;
  private IRefreshViewProvider.OnRefreshListener l;
  private boolean m;
  private boolean n;
  private String o = null;
  private Handler p;
  private final String q = getResources().getString(2131889532);
  private final String r = getResources().getString(2131889534);
  private final String s = getResources().getString(2131889536);
  private final String t = getResources().getString(2131889533);
  private long u;
  private Drawable v;
  
  public FSRefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSRefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSRefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void a(int paramInt)
  {
    IRefreshViewProvider.OnRefreshListener localOnRefreshListener = this.l;
    if (localOnRefreshListener != null) {
      this.o = localOnRefreshListener.c();
    }
    if (this.f == null) {
      return;
    }
    b(paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (this.f == null) {
        return;
      }
      int i2 = 0;
      int i1;
      if (!paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.f;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((ChrysanthemumLoadingView)localObject).setVisibility(i1);
    }
  }
  
  private boolean a(float paramFloat, boolean paramBoolean)
  {
    return (paramFloat > 0.0F) && (!paramBoolean);
  }
  
  private void b(int paramInt)
  {
    if (this.f == null) {
      return;
    }
    if ((paramInt == 2) || (paramInt == 4)) {
      this.f.a();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (this.c == null) {
        return;
      }
      int i2 = 0;
      int i1;
      if (!paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((LinearLayout)localObject).setVisibility(i1);
      localObject = this.c;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((FrameLayout)localObject).setVisibility(i1);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == getVisibleHeight()) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getVisibleHeight(), paramInt });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new FSRefreshHeaderView.3(this, paramInt));
    localValueAnimator.start();
  }
  
  private void e()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    this.a = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131624857, null));
    addView(this.a, new LinearLayout.LayoutParams(-1, 0));
    this.b = ((LinearLayout)findViewById(2131437544));
    this.c = ((FrameLayout)findViewById(2131433306));
    this.d = ((ImageView)findViewById(2131436405));
    this.e = ((TextView)findViewById(2131448699));
    this.f = ((ChrysanthemumLoadingView)findViewById(2131436446));
    this.g = ((TextView)findViewById(2131448850));
    measure(-2, -2);
    this.h = getMeasuredHeight();
    this.v = getResources().getDrawable(2130840418);
  }
  
  private void f()
  {
    if (this.c == null) {
      return;
    }
    int i1 = getWidth();
    int i2 = getHeight();
    this.g.setText(this.o);
    QCircleRippleAnimView localQCircleRippleAnimView = new QCircleRippleAnimView(getContext());
    localQCircleRippleAnimView.a(getContext().getResources().getColor(2131166091)).c(i1 / 6).b((int)(Math.sqrt(i1 * i1 + i2 * i2) / 2.0D)).a(320L).a(i1 / 2.0F, i2 / 2.0F).a(this.c).a(new BezierInterpolator(0.2F, 0.0F, 0.17F, 1.0F)).a(new FSRefreshHeaderView.2(this));
    localQCircleRippleAnimView.a();
  }
  
  private void g()
  {
    ImageView localImageView = this.d;
    if (localImageView == null) {
      return;
    }
    localImageView.setImageDrawable(this.v);
  }
  
  private void h()
  {
    ChrysanthemumLoadingView localChrysanthemumLoadingView = this.f;
    if (localChrysanthemumLoadingView == null) {
      return;
    }
    localChrysanthemumLoadingView.b();
  }
  
  private boolean k()
  {
    return getParent() != null;
  }
  
  public void a()
  {
    setState(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((getVisibleHeight() > 0) || (paramFloat1 > 0.0F))
    {
      setVisibleHeight((int)paramFloat1 + getVisibleHeight());
      if (this.i <= 1)
      {
        if (getVisibleHeight() > this.h)
        {
          b();
          return;
        }
        a();
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.j == -1.0F) {
      this.j = paramMotionEvent.getRawY();
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        this.j = -1.0F;
        if ((k()) && (!this.m) && (!this.n)) {
          c();
        }
      }
      else
      {
        float f2 = paramMotionEvent.getRawY();
        float f1 = this.j;
        f2 = (f2 - f1) / 2.0F;
        boolean bool;
        if (f1 == 0.0F) {
          bool = true;
        } else {
          bool = false;
        }
        this.j = paramMotionEvent.getRawY();
        this.k += f2;
        if ((k()) && (!this.m) && (!this.n) && (a(f2, bool)))
        {
          a(f2, this.k);
          if (getVisibleHeight() <= 0) {}
        }
      }
    }
    else
    {
      this.j = paramMotionEvent.getRawY();
      this.k = 0.0F;
    }
    super.onTouchEvent(paramMotionEvent);
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    setState(2);
    getMainHandler().postDelayed(new FSRefreshHeaderView.4(this, paramRecyclerView), 100L);
  }
  
  public void b()
  {
    setState(1);
  }
  
  public boolean c()
  {
    int i1 = getVisibleHeight();
    boolean bool;
    if ((getVisibleHeight() > this.h) && (this.i < 2))
    {
      setState(2);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.i == 2)
    {
      int i2 = this.h;
      if (i1 > i2) {
        c(i2);
      }
    }
    if (this.i != 2) {
      c(0);
    }
    i1 = this.i;
    if ((i1 == 2) || (i1 == 5)) {
      c(this.h);
    }
    return bool;
  }
  
  public void d()
  {
    QLog.d("RefreshHeaderView", 1, "refreshComplete");
    int i1;
    if (!TextUtils.isEmpty(this.o)) {
      i1 = 5;
    } else {
      i1 = 3;
    }
    if (i1 == 3)
    {
      long l1 = 1000L - this.u;
      if (l1 > 0L)
      {
        getMainHandler().postDelayed(new FSRefreshHeaderView.1(this), l1);
        return;
      }
      setState(3);
      return;
    }
    setState(5);
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  public Handler getMainHandler()
  {
    if (this.p == null) {
      this.p = new Handler(Looper.getMainLooper());
    }
    return this.p;
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getVisibleHeight()
  {
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout == null) {
      return 0;
    }
    return ((LinearLayout.LayoutParams)localFrameLayout.getLayoutParams()).height;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public void j()
  {
    if (getMainHandler() != null) {
      getMainHandler().removeCallbacksAndMessages(null);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b(this.i);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.i == 1) {
      setState(2);
    }
    g();
    h();
  }
  
  public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener paramOnRefreshListener)
  {
    this.l = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (!paramBoolean) {
      d();
    }
  }
  
  public void setState(int paramInt)
  {
    if (this.d != null)
    {
      if (this.e == null) {
        return;
      }
      if (paramInt == this.i) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt == 5)
                {
                  this.n = true;
                  b(true);
                  f();
                }
              }
              else
              {
                QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
                this.u = System.currentTimeMillis();
                a(true);
                a(paramInt);
                c(this.h);
                setRefreshing(true);
              }
            }
            else
            {
              a(true);
              c(0);
            }
          }
          else
          {
            this.u = System.currentTimeMillis();
            a(true);
            a(paramInt);
            c(this.h);
            localObject = this.l;
            if (localObject != null) {
              ((IRefreshViewProvider.OnRefreshListener)localObject).b();
            }
            this.e.setText(this.t);
          }
        }
        else
        {
          g();
          a(false);
          this.e.setText(this.r);
        }
      }
      else
      {
        b(false);
        if (this.i == 1) {
          this.d.setImageDrawable(this.v);
        }
        if (this.i == 2) {
          this.d.clearAnimation();
        }
        g();
        a(false);
        this.e.setText(this.s);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RefreshHeaderView", 1, ((StringBuilder)localObject).toString());
      this.i = paramInt;
    }
  }
  
  public void setVisibleHeight(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.height = i1;
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSRefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */