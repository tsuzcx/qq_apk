package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class UnderlineIndicator
  extends AbsSlidingIndicator
{
  public UnderlineIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UnderlineIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnderlineIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.l = paramContext.getResources().getColor(2131168072);
    this.m = paramContext.getResources().getColor(2131168060);
    this.v = 10;
    this.o = ViewUtils.dpToPx(16.0F);
    b();
    a(paramContext);
  }
  
  protected void a()
  {
    if (this.i != this.h)
    {
      int i = f(this.i)[0];
      int j = f(this.h)[0];
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new UnderlineIndicator.1(this, j));
      localValueAnimator.start();
      this.t = true;
      return;
    }
    this.z = f(this.h)[0];
    invalidate();
  }
  
  protected void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    b(paramInt, paramView);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    int i;
    int j;
    if (paramInt > 0)
    {
      i = getTabMargin();
      j = this.v * 2;
    }
    else
    {
      i = getTabMargin();
      j = this.v;
    }
    localLayoutParams.leftMargin = (i - j);
    this.g.addView(paramView, paramInt, localLayoutParams);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int[] arrayOfInt = f(this.h);
    int i = arrayOfInt[2];
    int j = arrayOfInt[0];
    int k = this.z;
    int m = arrayOfInt[1];
    int n = arrayOfInt[3];
    int i1 = getResources().getColor(2131168072);
    this.q.setColor(i1);
    this.r.set(k, m, i - j + k, n);
    paramCanvas.drawRoundRect(this.r, 0.0F, 0.0F, this.q);
  }
  
  protected int[] f(int paramInt)
  {
    View localView = this.g.getChildAt(paramInt);
    int j = localView.getWidth();
    int i = getHeight();
    float f = this.q.measureText(this.j[paramInt]);
    paramInt = localView.getLeft();
    j = (int)(j - f) / 2;
    int k = localView.getRight();
    i = i / 2 + this.o / 2 + ViewUtils.dpToPx(5.0F);
    return new int[] { paramInt + j, i, k - j, ViewUtils.dpToPx(2.0F) + i };
  }
  
  protected int getAniStartX()
  {
    return f(this.h)[0];
  }
  
  protected int[] getContainerPadding()
  {
    return new int[] { 0, 0, 0, 0 };
  }
  
  protected int getInitAniStartX()
  {
    return getInitUnderLineStartX();
  }
  
  protected int getInitUnderLineStartX()
  {
    int i = 0;
    int j = 0;
    while (i < this.h)
    {
      j = (int)(j + this.q.measureText(this.j[i]));
      i += 1;
    }
    return j + getTabMargin() * (this.h + 1);
  }
  
  protected int getTabMargin()
  {
    if (this.j == null) {
      return 42;
    }
    Object localObject = this.j;
    int k = localObject.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      String str = localObject[i];
      j = (int)(j + this.q.measureText(str));
      i += 1;
    }
    i = (ViewUtils.getScreenWidth() - j) / (this.j.length + 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("margin is ");
    ((StringBuilder)localObject).append(i);
    QLog.d("UnderlineIndicator", 1, ((StringBuilder)localObject).toString());
    if (i >= 42) {
      return i;
    }
    return 42;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnderlineIndicator
 * JD-Core Version:    0.7.0.1
 */