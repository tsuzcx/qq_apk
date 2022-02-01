package com.tencent.mobileqq.kandian.base.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;

public class ReadInJoyFlowLayout
  extends AdapterView
{
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int = AIOUtils.b(8.0F, getResources());
  private Adapter jdField_a_of_type_AndroidWidgetAdapter;
  private AdapterView.AdapterDataSetObserver jdField_a_of_type_ComTencentWidgetAdapterView$AdapterDataSetObserver = new ReadInJoyFlowLayout.1(this);
  private float b = 0.0F;
  
  public ReadInJoyFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private View a(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  private void a()
  {
    removeAllViewsInLayout();
    Object localObject = this.jdField_a_of_type_AndroidWidgetAdapter;
    if (localObject != null)
    {
      int j = ((Adapter)localObject).getCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAdapter.getView(i, null, this);
        addViewInLayout((View)localObject, i, ((View)localObject).getLayoutParams());
        i += 1;
      }
    }
    invalidate();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(super.generateDefaultLayoutParams());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  public Adapter getAdapter()
  {
    return this.jdField_a_of_type_AndroidWidgetAdapter;
  }
  
  public View getSelectedView()
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      View localView = a(i);
      if (localView.isSelected()) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    paramInt4 = getPaddingRight();
    paramInt2 = getPaddingTop();
    int j = paramInt4 + i;
    paramInt4 = i;
    int m = j;
    int i4 = 0;
    int k = 0;
    while (i4 < getCount())
    {
      View localView = a(i4);
      if (localView.getVisibility() != 8)
      {
        int i10 = localView.getMeasuredWidth();
        int i9 = localView.getMeasuredHeight();
        Object localObject = localView.getLayoutParams();
        paramBoolean = localObject instanceof ViewGroup.MarginLayoutParams;
        int n;
        int i1;
        int i6;
        int i3;
        int i2;
        int i7;
        if (paramBoolean)
        {
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
          n = localMarginLayoutParams.leftMargin;
          i5 = localMarginLayoutParams.rightMargin;
          i1 = localMarginLayoutParams.topMargin;
          i6 = localMarginLayoutParams.bottomMargin + i1;
          i8 = localMarginLayoutParams.leftMargin;
          i3 = localMarginLayoutParams.topMargin;
          i2 = localMarginLayoutParams.leftMargin;
          i1 = localMarginLayoutParams.topMargin;
          i3 += paramInt2;
          i2 = i2 + paramInt4 + i10;
          i1 = i1 + paramInt2 + i9;
          i7 = n + i5;
          n = i8 + paramInt4;
        }
        else
        {
          i2 = paramInt4 + i10;
          i3 = paramInt2;
          i1 = paramInt2 + i9;
          i7 = 0;
          i6 = 0;
          n = paramInt4;
        }
        int i5 = j;
        int i8 = i7 + i10;
        i6 += i9;
        if (m + i8 > paramInt3 - paramInt1)
        {
          n = paramInt2 + k;
          if (paramBoolean)
          {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            m = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            k = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + i + i10;
            paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + n + i9;
            paramInt2 += i;
            m = n + m;
          }
          else
          {
            k = i + i10;
            paramInt4 = n + i9;
            paramInt2 = i;
            m = n;
          }
          i3 = m;
          m = i5;
          i1 = n;
          n = i;
          i7 = 0;
          i2 = k;
          i5 = paramInt4;
          k = i7;
          paramInt4 = i1;
        }
        else
        {
          i5 = paramInt4;
          paramInt4 = paramInt2;
          paramInt2 = n;
          n = i5;
          i5 = i1;
        }
        localView.layout(paramInt2, i3, i2, i5);
        if (i6 > k) {
          paramInt2 = i6;
        } else {
          paramInt2 = k;
        }
        n += i8;
        m += i8;
        k = paramInt2;
        paramInt2 = paramInt4;
        paramInt4 = n;
      }
      i4 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingTop();
    int i7 = getPaddingBottom();
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i1 = i + j;
    i = i1;
    int i2 = 0;
    j = 0;
    while (i2 < getCount())
    {
      View localView = a(i2);
      int n;
      if (localView.getVisibility() == 8)
      {
        n = i;
      }
      else
      {
        Object localObject = localView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          measureChildWithMargins(localView, paramInt1, 0, paramInt2, k);
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          n = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          i5 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
          m = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          n += i5;
          m += i3;
        }
        else
        {
          measureChild(localView, paramInt1, paramInt2);
          n = 0;
          m = 0;
        }
        int i5 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        int i9 = n + i5;
        i5 = m + i3;
        int m = k;
        n = j;
        i3 = i;
        if (i + i9 > i6)
        {
          m = k + j;
          i3 = i1;
          n = 0;
        }
        i = n;
        if (i5 > n) {
          i = i5;
        }
        n = i3 + i9;
        j = i;
        k = m;
      }
      i2 += 1;
      i = n;
    }
    if (i8 == 1073741824) {
      paramInt1 = i4;
    } else {
      paramInt1 = k + j + i7;
    }
    setMeasuredDimension(i6, paramInt1);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f2 - this.jdField_a_of_type_Float;
      float f4 = f1 - this.b;
      i = this.jdField_a_of_type_Int;
      if (f4 * f4 + f3 * f3 <= i * i)
      {
        int i2 = getChildCount();
        int i1 = 0;
        i = 0;
        int j;
        for (;;)
        {
          j = i1;
          if (i >= i2) {
            break;
          }
          paramMotionEvent = getChildAt(i);
          int k;
          int m;
          int n;
          if ((paramMotionEvent.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams();
            k = localMarginLayoutParams.leftMargin;
            m = localMarginLayoutParams.rightMargin;
            n = localMarginLayoutParams.topMargin;
            j = localMarginLayoutParams.bottomMargin;
          }
          else
          {
            j = 0;
            k = 0;
            m = 0;
            n = 0;
          }
          if ((paramMotionEvent.getLeft() - k < f1) && (paramMotionEvent.getRight() + m > f1) && (paramMotionEvent.getTop() - n < f2) && (paramMotionEvent.getBottom() + j > f2))
          {
            performItemClick(paramMotionEvent, i, i);
            j = 1;
            break;
          }
          i += 1;
        }
        if (j == 0)
        {
          performClick();
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.b = paramMotionEvent.getX();
    }
    return true;
  }
  
  public void setAdapter(Adapter paramAdapter)
  {
    Adapter localAdapter = this.jdField_a_of_type_AndroidWidgetAdapter;
    if (localAdapter != null)
    {
      AdapterView.AdapterDataSetObserver localAdapterDataSetObserver = this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterDataSetObserver;
      if (localAdapterDataSetObserver != null) {
        localAdapter.unregisterDataSetObserver(localAdapterDataSetObserver);
      }
    }
    this.jdField_a_of_type_AndroidWidgetAdapter = paramAdapter;
    paramAdapter = this.jdField_a_of_type_AndroidWidgetAdapter;
    if (paramAdapter != null)
    {
      this.mItemCount = paramAdapter.getCount();
      this.jdField_a_of_type_AndroidWidgetAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterDataSetObserver);
      a();
    }
  }
  
  public void setRangeSelection(int paramInt1, int paramInt2)
  {
    int i = getCount();
    if ((paramInt1 >= 0) && (paramInt2 <= i))
    {
      while (paramInt1 < paramInt2)
      {
        a(paramInt1).setSelected(true);
        paramInt1 += 1;
      }
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid begin or end index");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void setSelection(int paramInt)
  {
    int i = getCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      a(paramInt).setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyFlowLayout
 * JD-Core Version:    0.7.0.1
 */