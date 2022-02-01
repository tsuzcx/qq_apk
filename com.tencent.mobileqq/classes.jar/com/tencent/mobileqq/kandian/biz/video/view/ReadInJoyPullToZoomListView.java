package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ReadInJoyPullToZoomListView
  extends ReadInJoyBaseListView
{
  private static boolean s = false;
  private static final Interpolator t = new ReadInJoyPullToZoomListView.1();
  private ReadInJoyPullToZoomListView.ScalingRunnalable A;
  private int B;
  private int C;
  float m = -1.0F;
  float n = -1.0F;
  float o = 1.401F;
  float p = 1.235F;
  boolean q;
  protected int r = 0;
  private View u;
  private ReadInJoyPullToZoomListView.OnTopCallback v;
  private boolean w;
  private FrameLayout x;
  private TextView y;
  private TextView z;
  
  public ReadInJoyPullToZoomListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView)
  {
    if (this.x == null)
    {
      this.x = new FrameLayout(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.x.addView(paramView, localLayoutParams);
    }
    e();
    f();
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e()
  {
    if (this.y == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(-1);
      localTextView.setText(HardCodeUtil.a(2131910609));
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = DisplayUtil.a(getContext(), 52.0F);
      this.x.addView(localTextView, localLayoutParams);
      this.y = localTextView;
    }
  }
  
  private void f()
  {
    if (this.z == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(1728053247);
      localTextView.setTextSize(1, 12.0F);
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = DisplayUtil.a(getContext(), 58.0F);
      this.x.addView(localTextView, localLayoutParams);
      this.z = localTextView;
    }
  }
  
  private void g()
  {
    Object localObject = this.x;
    if ((localObject != null) && (this.u != null) && (((FrameLayout)localObject).getBottom() > 0) && (this.u.getBottom() > 0))
    {
      int i = this.x.getBottom();
      int j = this.u.getBottom();
      boolean bool;
      if (i <= j) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool != this.w)
      {
        this.w = bool;
        localObject = this.v;
        if (localObject != null)
        {
          ((ReadInJoyPullToZoomListView.OnTopCallback)localObject).a(this.w);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkIsTopFixed(): mFixed=");
            ((StringBuilder)localObject).append(this.w);
            QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if ((QLog.isColorLevel()) && (s))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIsTopFixed(): titleBarBottom=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("， headerBottom=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("， fixed = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", mTopFixed=");
        ((StringBuilder)localObject).append(this.w);
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.y;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      this.y.setVisibility(0);
      localObject = getResources().getDrawable(2130839588);
      this.y.setCompoundDrawablePadding(10);
      this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      ((Animatable)localObject).start();
    }
  }
  
  private void i()
  {
    TextView localTextView = this.y;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void j()
  {
    TextView localTextView = this.z;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void k()
  {
    this.m = -1.0F;
    this.n = -1.0F;
    this.q = false;
  }
  
  private void l()
  {
    if (this.q)
    {
      b(false);
      return;
    }
    this.A.a(300L);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    this.A = new ReadInJoyPullToZoomListView.ScalingRunnalable(this);
  }
  
  public void addHeaderView(View paramView)
  {
    a(paramView);
    super.addHeaderView(this.x);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    a(paramView);
    super.addHeaderView(this.x, paramObject, paramBoolean);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    g();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    g();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            this.m = paramMotionEvent.getY();
            if ((QLog.isColorLevel()) && (s)) {
              QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_CANCEL xxxx");
            }
          }
        }
        else
        {
          this.e = ((int)paramMotionEvent.getRawY() - this.r);
          if (this.m == -1.0F) {
            this.m = paramMotionEvent.getY();
          }
          if (this.x.getBottom() >= this.B)
          {
            localObject = this.x.getLayoutParams();
            float f1 = paramMotionEvent.getY();
            float f2 = this.m;
            float f3 = this.x.getBottom();
            i = this.B;
            f2 = (f1 - f2 + f3) / i;
            f1 = this.n;
            f2 = (f2 - f1) / 2.0F + f1;
            if ((f1 <= 1.0D) && (f2 < f1))
            {
              ((ViewGroup.LayoutParams)localObject).height = i;
              this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
              return super.onTouchEvent(paramMotionEvent);
            }
            this.n = Math.min(Math.max(f2, 1.0F), this.o);
            ((ViewGroup.LayoutParams)localObject).height = ((int)(this.B * this.n));
            if (((ViewGroup.LayoutParams)localObject).height <= this.C) {
              this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            if (this.n >= this.p)
            {
              h();
              this.q = true;
            }
            else
            {
              i();
              this.q = false;
            }
            if ((QLog.isColorLevel()) && (s))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onTouchEvent(): ACTION_MOVE, f = ");
              ((StringBuilder)localObject).append(f2);
              ((StringBuilder)localObject).append(", mLastScale=");
              ((StringBuilder)localObject).append(this.n);
              ((StringBuilder)localObject).append(", mEnterRefreshDefer=");
              ((StringBuilder)localObject).append(this.q);
              QLog.d("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
            }
            this.m = paramMotionEvent.getY();
            return true;
          }
          this.m = paramMotionEvent.getY();
        }
      }
      else
      {
        if ((QLog.isColorLevel()) && (s))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onTouchEvent(): ACTION_UP <=====  mEnterRefreshDefer=");
          ((StringBuilder)localObject).append(this.q);
          QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
        }
        l();
        k();
      }
    }
    else
    {
      this.r = ((int)paramMotionEvent.getRawY());
      if (!this.A.b) {
        this.A.a();
      }
      this.m = paramMotionEvent.getY();
      this.n = (this.x.getBottom() / this.B);
      if ((QLog.isColorLevel()) && (s))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent(): ACTION_DOWN ==>  mLastScale = ");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append("， mHeaderMaxHeight = ");
        ((StringBuilder)localObject).append(this.C);
        QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHeaderViewSize(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.x.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.B = paramInt2;
    this.C = ((int)(this.B * this.o));
  }
  
  public void setOnTopCallback(ReadInJoyPullToZoomListView.OnTopCallback paramOnTopCallback)
  {
    this.v = paramOnTopCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView
 * JD-Core Version:    0.7.0.1
 */