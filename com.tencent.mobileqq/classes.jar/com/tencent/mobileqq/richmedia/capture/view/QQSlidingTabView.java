package com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int = -7829368;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private QQSlidingTabView.IOnTabCheckListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView$IOnTabCheckListener;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -16777216;
  private int c = Color.parseColor("#E62555");
  private int d = 14;
  private int e = 0;
  private int f = 15;
  private int g = 5;
  private int h = 52;
  private int i = 0;
  private int j = 4;
  private int k = -16776961;
  private int l = 1;
  private int m = -3355444;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private int r = -1;
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  private void a()
  {
    int i1 = this.o;
    int i2 = this.n;
    if (i1 != i2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n);
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0))
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QQSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.h = ((int)TypedValue.applyDimension(1, this.h, localDisplayMetrics));
    this.j = ((int)TypedValue.applyDimension(1, this.j, localDisplayMetrics));
    this.l = ((int)TypedValue.applyDimension(1, this.l, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.d = ((int)TypedValue.applyDimension(1, this.d, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.e = paramContext.getDimensionPixelSize(4, this.e);
    this.f = paramContext.getDimensionPixelSize(3, this.f);
    this.k = paramContext.getColor(0, this.k);
    this.j = paramContext.getDimensionPixelSize(1, this.j);
    this.jdField_a_of_type_Int = paramContext.getColor(6, this.jdField_a_of_type_Int);
    this.b = paramContext.getColor(5, this.b);
    this.m = paramContext.getColor(8, this.m);
    this.l = paramContext.getDimensionPixelSize(9, this.l);
    this.d = paramContext.getDimensionPixelSize(7, this.d);
    this.g = paramContext.getDimensionPixelSize(2, this.g);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.q = ScreenUtil.dip2px(this.p);
  }
  
  private void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject1 != null) && (i1 < ((ArrayList)localObject1).size()))
      {
        localObject1 = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (i1 == paramInt)
        {
          if ((localObject1 instanceof ImageView))
          {
            localObject2 = (Bundle)((View)localObject1).getTag();
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("checked_image_bg_id", 2130846887));
            }
          }
          else if ((localObject1 instanceof RedDotTextView))
          {
            if (this.r == i1) {
              ((RedDotTextView)localObject2).setTextColor(this.c);
            } else {
              ((RedDotTextView)localObject2).setTextColor(this.b);
            }
            ((RedDotTextView)localObject2).a(false);
          }
          else if ((localObject1 instanceof TextView))
          {
            ((TextView)localObject2).setTextColor(this.b);
          }
        }
        else if ((localObject1 instanceof ImageView))
        {
          localObject2 = (Bundle)((View)localObject1).getTag();
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("normal_image_bg_id", 2130846886));
          }
        }
        else if ((localObject1 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject2).setTextColor(this.jdField_a_of_type_Int);
        }
        else if ((localObject1 instanceof TextView))
        {
          ((TextView)localObject2).setTextColor(this.jdField_a_of_type_Int);
        }
      }
      i1 += 1;
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.f * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return;
      }
      this.n = paramInt;
      b(paramInt);
      c(paramInt);
      a();
      QQSlidingTabView.IOnTabCheckListener localIOnTabCheckListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView$IOnTabCheckListener;
      if (localIOnTabCheckListener != null) {
        localIOnTabCheckListener.a(paramInt);
      }
      this.o = this.n;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = getHeight();
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.i = ((View)localObject).getLeft();
        c(this.n);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.n == 0) && (this.i < ((View)localObject).getLeft())) {
        this.i = ((View)localObject).getLeft();
      }
      if (this.r == this.n) {
        i1 = this.c;
      } else {
        i1 = this.k;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
      int i1 = this.i;
      localObject = new RectF(this.g + i1, i2 - this.j, i1 + ((View)localObject).getWidth() - this.g, i2);
      i1 = this.q;
      paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.k = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.k);
    invalidate();
  }
  
  public void setTabCheckListener(QQSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView$IOnTabCheckListener = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */