package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class ViewTransformer
  extends ViewGroup
  implements Animation.AnimationListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTransformer.ViewTransformerListener jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewTransformer$ViewTransformerListener = null;
  private View b;
  
  public ViewTransformer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ViewTransformer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ViewTransformer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected ViewTransformer.LayoutParams a()
  {
    return new ViewTransformer.LayoutParams(-1, -2);
  }
  
  public ViewTransformer.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ViewTransformer.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewTransformer.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewTransformer.LayoutParams(paramLayoutParams);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    if (paramAnimation != null) {
      paramAnimation.setVisibility(8);
    }
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidViewView = this.b;
    this.b = paramAnimation;
    if ((getChildCount() > 1) && (this.jdField_a_of_type_AndroidViewView != null) && (this.b != null))
    {
      removeAllViews();
      addView(this.jdField_a_of_type_AndroidViewView, 0);
      addView(this.b, 1);
      requestLayout();
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewTransformer$ViewTransformerListener;
      if (paramAnimation != null) {
        paramAnimation.a();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.b.setVisibility(0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      int j = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i = paramInt2 + localMarginLayoutParams.leftMargin;
      paramInt2 = j + i + localMarginLayoutParams.rightMargin;
      j = localMarginLayoutParams.topMargin;
      localView.layout(i, j, paramInt2, paramInt4 + j + localMarginLayoutParams.bottomMargin);
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getChildCount();
    int j = 0;
    int m = 0;
    int k;
    for (int i = 0; j < i1; i = k)
    {
      View localView = getChildAt(j);
      int n = m;
      k = i;
      if (localView.getVisibility() != 8)
      {
        try
        {
          measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        n = m + localView.getMeasuredWidth();
        k = localView.getMeasuredHeight();
        if (i > k) {
          k = i;
        }
      }
      j += 1;
      m = n;
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public void setLisenter(ViewTransformer.ViewTransformerListener paramViewTransformerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewTransformer$ViewTransformerListener = paramViewTransformerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewTransformer
 * JD-Core Version:    0.7.0.1
 */