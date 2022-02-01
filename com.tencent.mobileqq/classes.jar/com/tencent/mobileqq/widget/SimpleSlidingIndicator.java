package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class SimpleSlidingIndicator
  extends AbsSlidingIndicator
{
  private static final int[] a = { 16842901, 16842904 };
  private int B = 16;
  private int C = 52;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private int b = 25;
  private int c = 6;
  private int d = 12;
  private int e = 12;
  private int f = 16;
  
  public SimpleSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources().getDisplayMetrics();
    this.C = ((int)TypedValue.applyDimension(1, this.C, (DisplayMetrics)localObject));
    this.d = ((int)TypedValue.applyDimension(1, this.d, (DisplayMetrics)localObject));
    this.e = ((int)TypedValue.applyDimension(1, this.e, (DisplayMetrics)localObject));
    this.f = ((int)TypedValue.applyDimension(1, this.f, (DisplayMetrics)localObject));
    this.B = ((int)TypedValue.applyDimension(1, this.B, (DisplayMetrics)localObject));
    this.c = ((int)TypedValue.applyDimension(1, this.c, (DisplayMetrics)localObject));
    this.o = ((int)TypedValue.applyDimension(2, this.o, (DisplayMetrics)localObject));
    this.D = ((int)TypedValue.applyDimension(1, this.D, (DisplayMetrics)localObject));
    this.E = ((int)TypedValue.applyDimension(1, this.E, (DisplayMetrics)localObject));
    this.F = ((int)TypedValue.applyDimension(1, this.F, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    this.o = ((TypedArray)localObject).getDimensionPixelSize(0, this.o);
    ((TypedArray)localObject).recycle();
    b(paramContext);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleSlidingIndicator);
      this.n = paramAttributeSet.getColor(2, this.n);
      this.b = paramAttributeSet.getInt(1, this.b);
      this.l = paramAttributeSet.getColor(0, this.l);
      this.m = paramAttributeSet.getColor(11, this.m);
      this.f = paramAttributeSet.getDimensionPixelSize(5, this.f);
      this.B = paramAttributeSet.getDimensionPixelSize(6, this.B);
      this.d = paramAttributeSet.getDimensionPixelSize(4, this.d);
      this.e = paramAttributeSet.getDimensionPixelSize(3, this.e);
      this.c = paramAttributeSet.getDimensionPixelSize(9, this.c);
      this.D = paramAttributeSet.getDimensionPixelSize(8, this.D);
      this.E = paramAttributeSet.getDimensionPixelSize(10, this.E);
      this.F = paramAttributeSet.getDimensionPixelSize(7, this.F);
      paramAttributeSet.recycle();
    }
    paramInt = this.b;
    if (paramInt > 255) {
      this.b = 255;
    } else if (paramInt < 0) {
      this.b = 0;
    }
    b();
    a(paramContext);
  }
  
  protected void a()
  {
    if (this.i != this.h)
    {
      Object localObject = this.g.getChildAt(this.i);
      View localView = this.g.getChildAt(this.h);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new SimpleSlidingIndicator.1(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.z = this.g.getChildAt(this.h).getLeft();
      invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.E = paramInt1;
    this.D = paramInt2;
    this.c = paramInt3;
    this.F = paramInt4;
    Object localObject;
    if (this.g != null)
    {
      localObject = getContainerPadding();
      this.g.setPadding(localObject[0], localObject[1], localObject[2], localObject[3]);
    }
    if ((this.g != null) && (this.k != null) && (this.k.length > 0) && (this.j != null) && (this.j.length > 0)) {
      c();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update, tabWidth[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], gap[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], plr[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], cplr[");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("], pos[");
      ((StringBuilder)localObject).append(this.h);
      QLog.i("SimpleSlidingIndicator", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    b(paramInt, paramView);
    if (this.p)
    {
      i = this.c;
      paramView.setPadding(i + 2, 0, i + 2, 0);
    }
    else
    {
      i = this.c;
      paramView.setPadding(i, 0, i, 0);
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    int i = this.D;
    if (i != 0) {
      if (paramInt == 0) {
        localLayoutParams.leftMargin = 0;
      } else {
        localLayoutParams.leftMargin = i;
      }
    }
    i = this.E;
    if (i != 0) {
      localLayoutParams.width = i;
    }
    this.g.addView(paramView, paramInt, localLayoutParams);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i = getHeight();
    View localView = this.g.getChildAt(this.h);
    this.r.set(this.z + this.c - this.e, this.d, this.z + localView.getWidth() - this.c + this.e, i - this.d);
    paramCanvas.drawRoundRect(this.r, this.f, this.B, this.q);
  }
  
  protected void b(Context paramContext)
  {
    this.o = ViewUtils.dpToPx(16.0F);
    this.F = ViewUtils.dpToPx(16.0F);
    this.D = ViewUtils.dpToPx(2.0F);
    this.c = ViewUtils.dpToPx(2.0F);
    this.n = paramContext.getResources().getColor(2131165916);
    this.b = 25;
    this.d = ViewUtils.dpToPx(12.0F);
    this.e = ViewUtils.dpToPx(2.0F);
    this.f = ViewUtils.dpToPx(16.0F);
    this.B = ViewUtils.dpToPx(16.0F);
    this.l = paramContext.getResources().getColor(2131165916);
    this.m = paramContext.getResources().getColor(2131168122);
  }
  
  protected int getAniStartX()
  {
    return this.g.getChildAt(this.h).getLeft();
  }
  
  protected int[] getContainerPadding()
  {
    int i = this.F;
    return new int[] { i, 0, i, 0 };
  }
  
  protected int getInitAniStartX()
  {
    return this.F + (this.E + this.D) * this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */