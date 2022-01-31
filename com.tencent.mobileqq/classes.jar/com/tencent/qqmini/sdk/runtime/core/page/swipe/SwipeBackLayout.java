package com.tencent.qqmini.sdk.runtime.core.page.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import bhgh;
import bhgi;
import bhgj;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class SwipeBackLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  private bhgi jdField_a_of_type_Bhgi;
  private bhgj jdField_a_of_type_Bhgj;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1728053248;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public SwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bhgj = bhgj.a(this, 1.0F, new bhgh(this));
    this.jdField_a_of_type_Bhgj.a(1);
    this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840951);
  }
  
  private void a(Canvas paramCanvas, View paramView)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  private void b(Canvas paramCanvas, View paramView)
  {
    int i = (int)(((this.jdField_b_of_type_Int & 0xFF000000) >>> 24) * this.jdField_a_of_type_Float);
    int j = this.jdField_b_of_type_Int;
    paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.jdField_a_of_type_Float = (1.0F - this.jdField_b_of_type_Float);
    if ((this.jdField_a_of_type_Bhgj != null) && (this.jdField_a_of_type_Bhgj.a(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_Bhgj.a() != 0))
    {
      a(paramCanvas, paramView);
      b(paramCanvas, paramView);
    }
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() == 1)
    {
      this.jdField_a_of_type_AndroidViewView = getChildAt(0);
      return;
    }
    throw new IllegalStateException("SwipeBackLayout can host only one direct child");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      this.e = j;
      this.f = k;
      if (i == 0) {
        break;
      }
      if (this.jdField_a_of_type_Bhgj == null) {
        break label157;
      }
      return this.jdField_a_of_type_Bhgj.a(paramMotionEvent);
      if (Math.abs(j) >= DisplayUtil.getDensity(getContext()) * 30.0F)
      {
        i = 0;
        continue;
        int m = this.e;
        int n = this.f;
        if (Math.abs(j - m) <= Math.abs(k - n))
        {
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    label157:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Bhgj != null)
    {
      this.jdField_a_of_type_Bhgj.a(paramMotionEvent);
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setSwipeBackCallback(bhgi parambhgi)
  {
    this.jdField_a_of_type_Bhgi = parambhgi;
  }
  
  public void setSwipeBackEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.swipe.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */