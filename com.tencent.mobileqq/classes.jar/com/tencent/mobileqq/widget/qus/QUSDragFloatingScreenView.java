package com.tencent.mobileqq.widget.qus;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

public class QUSDragFloatingScreenView
  extends FrameLayout
{
  private int a = b(36);
  private int b = b(60);
  private int c;
  private float d = getContext().getResources().getDisplayMetrics().density;
  private ImageView e;
  private FrameLayout f;
  private LinearLayout g = new LinearLayout(getContext());
  private boolean h = false;
  private int i = 0;
  private QUSDragFloatController j;
  private int k;
  private float l;
  private int m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private byte n = 0;
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.topMargin = b(60);
    this.g.setLayoutParams(paramContext);
    this.g.setBackgroundResource(2130839612);
    this.g.setOrientation(1);
    addView(this.g);
    paramInt = b(36);
    this.f = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, paramInt);
    this.f.setLayoutParams(paramContext);
    this.g.addView(this.f);
    this.e = new ImageView(getContext());
    paramContext = new FrameLayout.LayoutParams(paramInt, paramInt);
    paramContext.gravity = 17;
    this.e.setImageResource(2130851762);
    this.e.setLayoutParams(paramContext);
    this.f.addView(this.e);
    setOnClickListener(new QUSDragFloatingScreenView.1(this));
  }
  
  private void a(float paramFloat)
  {
    paramFloat -= this.l;
    if (Math.abs(paramFloat) > this.m) {
      if (paramFloat > 0.0F) {
        this.n = 1;
      } else if (paramFloat < 0.0F) {
        this.n = 2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swipeDirectionJudge : mSlideStartDir -> ");
      localStringBuilder.append(this.n);
      QLog.d("QUSDragFloatingScreenView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(int paramInt)
  {
    LinearLayout localLinearLayout = this.g;
    ObjectAnimator.ofFloat(localLinearLayout, "y", new float[] { localLinearLayout.getY(), paramInt }).setDuration(250L).start();
    this.h = false;
    a(false);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    a(f1);
    f1 -= this.l;
    float f2 = this.g.getY();
    float f3 = f2 + f1;
    int i1 = this.b;
    if (f3 < i1)
    {
      this.g.offsetTopAndBottom((int)(i1 - f2));
    }
    else
    {
      i1 = this.c;
      int i2 = this.a;
      if (f3 > i1 - i2) {
        this.g.offsetTopAndBottom((int)(i1 - i2 - f2));
      } else {
        this.g.offsetTopAndBottom((int)f1);
      }
    }
    this.l = paramMotionEvent.getRawY();
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private int b(int paramInt)
  {
    return (int)(paramInt * this.d + 0.5F);
  }
  
  private void d()
  {
    float f1 = this.g.getY();
    int i1;
    if (f1 < this.c - getDefaultHeight())
    {
      i1 = this.k;
      if (i1 <= 1)
      {
        if ((f1 >= (this.c - getDefaultHeight()) / 2.0F) && (this.n != 2))
        {
          b();
          return;
        }
        a();
        return;
      }
      if (i1 == 2)
      {
        if ((f1 <= (this.c - getDefaultHeight()) / 2.0F) && (this.n != 1))
        {
          a();
          return;
        }
        b();
      }
    }
    else
    {
      i1 = this.k;
      if (i1 >= 1)
      {
        if ((f1 < this.c - this.a - (getDefaultHeight() - this.a) / 2) && (this.n != 1))
        {
          b();
          return;
        }
        c();
        return;
      }
      if (i1 == 0)
      {
        if ((f1 > this.c - this.a - (getDefaultHeight() - this.a) / 2) && (this.n != 2))
        {
          c();
          return;
        }
        b();
      }
    }
  }
  
  private int getDefaultHeight()
  {
    int i2 = this.a;
    QUSDragFloatController localQUSDragFloatController = this.j;
    int i1;
    if (localQUSDragFloatController == null) {
      i1 = i2;
    } else {
      i1 = localQUSDragFloatController.b();
    }
    return Math.max(i2, Math.min(i1, this.c - this.b));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showTotal");
    }
    this.k = 2;
    this.e.setImageResource(2130851763);
    a(this.b);
    QUSDragFloatController localQUSDragFloatController = this.j;
    if (localQUSDragFloatController != null) {
      localQUSDragFloatController.f();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showDefaultHeight");
    }
    if (this.c - getDefaultHeight() > this.b)
    {
      this.k = 1;
      this.e.setImageResource(2130851762);
      a(this.c - getDefaultHeight());
      QUSDragFloatController localQUSDragFloatController = this.j;
      if (localQUSDragFloatController != null) {
        localQUSDragFloatController.g();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showMinHeight");
    }
    this.k = 0;
    this.e.setImageResource(2130851762);
    a(this.c - this.a);
    QUSDragFloatController localQUSDragFloatController = this.j;
    if (localQUSDragFloatController != null) {
      localQUSDragFloatController.h();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent : ");
      ((StringBuilder)localObject).append(paramMotionEvent);
      QLog.d("QUSDragFloatingScreenView", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if ((i1 == 2) && (this.h))
        {
          a(paramMotionEvent);
          return true;
        }
      }
      else if (this.h) {
        d();
      }
    }
    else
    {
      this.l = paramMotionEvent.getRawY();
      localObject = new Rect();
      this.f.getGlobalVisibleRect((Rect)localObject);
      boolean bool;
      if ((!((Rect)localObject).isEmpty()) && (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = bool;
      if (this.h) {
        a(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mConsumeTouchEvent : ");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("QUSDragFloatingScreenView", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.h) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c <= 0)
    {
      this.c = getMeasuredHeight();
      Object localObject = this.j;
      if ((localObject != null) && (((QUSDragFloatController)localObject).c() > 0)) {
        this.b = Math.max(this.b, this.c - this.j.c());
      }
      paramInt2 = this.c;
      if (this.i == 0) {
        paramInt1 = getDefaultHeight();
      } else {
        paramInt1 = 0;
      }
      paramInt2 -= paramInt1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        localObject = getChildAt(paramInt1);
        ((View)localObject).layout(0, paramInt2, ((View)localObject).getMeasuredWidth(), ((View)localObject).getMeasuredHeight() + paramInt2);
        ((View)localObject).setTag("QUSDragFloatingScreenView");
        paramInt1 += 1;
      }
    }
  }
  
  public void setQUSDragFloatController(QUSDragFloatController paramQUSDragFloatController)
  {
    this.j = paramQUSDragFloatController;
    if (paramQUSDragFloatController != null)
    {
      View localView = paramQUSDragFloatController.a();
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        this.g.addView(localView);
      }
      this.i = paramQUSDragFloatController.e();
      int i1 = this.i;
      int i2 = 0;
      if (i1 == 0) {
        i1 = Math.max(this.a, paramQUSDragFloatController.d());
      } else {
        i1 = 0;
      }
      this.a = i1;
      i1 = i2;
      if (this.i == 0) {
        i1 = 1;
      }
      this.k = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView
 * JD-Core Version:    0.7.0.1
 */