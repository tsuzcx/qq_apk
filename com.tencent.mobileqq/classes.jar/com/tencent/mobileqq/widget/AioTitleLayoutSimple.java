package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

public class AioTitleLayoutSimple
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  
  public AioTitleLayoutSimple(Context paramContext)
  {
    super(paramContext);
  }
  
  public AioTitleLayoutSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printChildren() called child = ");
        localStringBuilder.append(getChildAt(i).toString());
        QLog.d("AioTitleLayout", 2, localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        int j = localView.getLeft() + paramInt3;
        int k = localView.getRight() + paramInt3;
        if (QLog.isColorLevel())
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("alignScreenHorizontalCenter() called with: l = [");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append("], r = [");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append("], diff = [");
          ((StringBuilder)localObject).append(paramInt3);
          ((StringBuilder)localObject).append("], i = [");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], candidateLeft = [");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append("]");
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(", candidateRight = [");
          localStringBuilder.append(k);
          localStringBuilder.append("]");
          QLog.d("AioTitleLayout", 2, new Object[] { localObject, localStringBuilder.toString() });
        }
        localView.layout(j, localView.getTop(), k, localView.getBottom());
      }
      i += 1;
    }
  }
  
  private int getContentLeft()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8) {
        return localView.getLeft();
      }
      i += 1;
    }
    return 2147483647;
  }
  
  private int getContentRight()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8) {
        return localView.getRight();
      }
      i -= 1;
    }
    return -2147483647;
  }
  
  private TextView getTitleCountTv()
  {
    if (this.a == null) {
      this.a = ((TextView)findViewById(2131431971));
    }
    return this.a;
  }
  
  private TextView getTitleTv()
  {
    if (this.b == null) {
      this.b = ((TextView)findViewById(2131447463));
    }
    return this.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QQTheme.isNowSimpleUI())
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int j = getPaddingLeft();
    int i = 0;
    while (i < getChildCount())
    {
      localObject1 = getChildAt(i);
      k = j;
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        j += ((LinearLayout.LayoutParams)localObject2).leftMargin;
        k = (getMeasuredHeight() - ((View)localObject1).getMeasuredHeight()) / 2;
        ((View)localObject1).layout(j, k, ((View)localObject1).getMeasuredWidth() + j, ((View)localObject1).getMeasuredHeight() + k);
        k = j + ((View)localObject1).getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).rightMargin;
      }
      i += 1;
      j = k;
    }
    a();
    i = getResources().getDisplayMetrics().widthPixels;
    Object localObject1 = getTitleTv();
    Object localObject2 = getTitleCountTv();
    j = i / 2;
    int k = ((TextView)localObject1).getLeft() + paramInt1;
    int m = ((TextView)localObject1).getRight();
    if (((TextView)localObject2).isShown()) {
      i = ((TextView)localObject2).getRight();
    } else {
      i = -2147483648;
    }
    i = (Math.max(m, i) - ((TextView)localObject1).getLeft()) / 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLayout() called with: textLeftOnScreenX = [");
    localStringBuilder.append(k);
    localStringBuilder.append("], titleTv.getRight() = [");
    localStringBuilder.append(((TextView)localObject1).getRight());
    localStringBuilder.append("], countTv.getRight() = [");
    localStringBuilder.append(((TextView)localObject2).getRight());
    localStringBuilder.append("], titleTv.getLeft() = [");
    localStringBuilder.append(((TextView)localObject1).getLeft());
    localStringBuilder.append("], half width = [");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.d("AioTitleLayout", 2, localStringBuilder.toString());
    k += i;
    i = j - k;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLayout() called with: changed = [");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("], l = [");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], t = [");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("], r = [");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append("], b = [");
      ((StringBuilder)localObject1).append(paramInt4);
      ((StringBuilder)localObject1).append("]");
      QLog.d("AioTitleLayout", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLayout() called with: screenCenterX = [");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("], textCenterX = [");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("], diff = [");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("]");
      QLog.d("AioTitleLayout", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0)
    {
      paramInt2 = i;
    }
    else if (i > 0)
    {
      paramInt2 = getMeasuredWidth() - getContentRight();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onLayout() called rightSpace = ");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("AioTitleLayout", 2, ((StringBuilder)localObject1).toString());
      }
      paramInt2 = Math.min(paramInt2, i);
    }
    else
    {
      paramInt2 = getContentLeft();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onLayout() called leftSpace = ");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("AioTitleLayout", 2, ((StringBuilder)localObject1).toString());
      }
      paramInt2 = Math.max(-paramInt2, i);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLayout() called diff = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("AioTitleLayout", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt2 != 0) {
      a(paramInt1, paramInt3, paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (QQTheme.isNowSimpleUI()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = 0;
    if (i == 1073741824)
    {
      int j = getPaddingLeft() + getPaddingRight();
      int k = 0;
      for (i = 0; k < getChildCount(); i = paramInt1)
      {
        localObject1 = getChildAt(k);
        paramInt2 = j;
        paramInt1 = i;
        if (((View)localObject1).getVisibility() != 8)
        {
          paramInt2 = j;
          paramInt1 = i;
          if (((View)localObject1).getId() != 2131447463)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (((LinearLayout.LayoutParams)localObject2).width == -2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else if (((LinearLayout.LayoutParams)localObject2).width == -1) {
              QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("lp.width == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
            } else {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(((LinearLayout.LayoutParams)localObject2).width, 1073741824);
            }
            paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (((LinearLayout.LayoutParams)localObject2).height == -2) {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else if (((LinearLayout.LayoutParams)localObject2).height == -1) {
              QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("lp.height == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
            } else {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(((LinearLayout.LayoutParams)localObject2).height, 1073741824);
            }
            ((View)localObject1).measure(paramInt1, paramInt2);
            paramInt2 = j + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((View)localObject1).getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).rightMargin;
            paramInt1 = Math.max(i, ((View)localObject1).getMeasuredHeight());
          }
        }
        k += 1;
        j = paramInt2;
      }
      k = m - j;
      if (m < j)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("icon totalLength = [");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("]> measuredWidth = [");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("]");
        QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException(((StringBuilder)localObject1).toString()));
      }
      Object localObject1 = getTitleTv();
      ((TextView)localObject1).setMaxWidth(k);
      paramInt2 = 0;
      do
      {
        ((TextView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(k, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
        localObject2 = ((TextView)localObject1).getLayout();
        paramInt1 = paramInt2;
        if (localObject2 != null)
        {
          paramInt1 = ((Layout)localObject2).getEllipsisStart(0);
          paramInt2 = ((Layout)localObject2).getEllipsisCount(0);
          int n = ((Layout)localObject2).getEllipsizedWidth();
          if ((paramInt2 > 0) && (paramInt1 == 0) && (n == k))
          {
            float f = ((TextView)localObject1).getTextSize() * 0.75F;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onMeasure() called with: autoResizeText from = [");
            ((StringBuilder)localObject2).append(((TextView)localObject1).getTextSize());
            ((StringBuilder)localObject2).append("], to = [");
            ((StringBuilder)localObject2).append(f);
            ((StringBuilder)localObject2).append("]");
            QLog.d("AioTitleLayout", 1, ((StringBuilder)localObject2).toString());
            ((TextView)localObject1).setTextSize(0, f);
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = 0;
          }
        }
        paramInt2 = paramInt1;
      } while (paramInt1 != 0);
      Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      paramInt1 = j + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((TextView)localObject1).getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).rightMargin;
      if (m < paramInt1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("icon totalLength = [");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("]> measuredWidth = [");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append("]");
        QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException(((StringBuilder)localObject2).toString()));
      }
      paramInt2 = Math.max(i, ((TextView)localObject1).getMeasuredHeight());
      paramInt1 = m;
    }
    else
    {
      QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("widthMeasureSpec is not support now"));
      paramInt1 = 0;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AioTitleLayoutSimple
 * JD-Core Version:    0.7.0.1
 */