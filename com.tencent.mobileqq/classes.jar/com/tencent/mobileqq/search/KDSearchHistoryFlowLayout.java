package com.tencent.mobileqq.search;

import afur;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Adapter;
import android.widget.TextView;
import bbgn;
import bbgo;
import bbgq;
import bclx;
import bkii;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.widget.AdapterView;

public class KDSearchHistoryFlowLayout
  extends AdapterView
{
  private float jdField_a_of_type_Float;
  public int a;
  private bbgo jdField_a_of_type_Bbgo;
  private bkii jdField_a_of_type_Bkii = new bbgn(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = afur.a(8.0F, getResources());
  
  public KDSearchHistoryFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KDSearchHistoryFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KDSearchHistoryFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2;
  }
  
  private View a(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  private void a()
  {
    removeAllViewsInLayout();
    if (this.jdField_a_of_type_Bbgo != null)
    {
      int j = this.jdField_a_of_type_Bbgo.getCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_Bbgo.getView(i, null, this);
        addViewInLayout(localView, i, localView.getLayoutParams());
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
    return this.jdField_a_of_type_Bbgo;
  }
  
  public View getSelectedView()
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      View localView = a(i);
      if ((localView != null) && (localView.isSelected())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int i8 = getPaddingRight();
    paramInt2 = getPaddingTop();
    paramInt4 = i;
    int j = 0;
    int k = 0;
    int m = i + i8;
    int i4 = 0;
    View localView;
    int n;
    int i1;
    int i10;
    int i11;
    int i6;
    int i5;
    int i2;
    int i3;
    label258:
    int i9;
    int i7;
    for (;;)
    {
      if (i4 < getCount())
      {
        localView = a(i4);
        ((TextView)localView.findViewById(2131367987)).setMaxWidth((int)(bclx.jdField_a_of_type_Int - 40.0F * bclx.a()) / 2);
        if (localView.getVisibility() == 8)
        {
          n = k;
          i1 = m;
          m = j;
          k = paramInt4;
          j = paramInt2;
          paramInt4 = i1;
          paramInt2 = n;
          i4 += 1;
          n = m;
          i1 = k;
          k = paramInt2;
          m = paramInt4;
          paramInt2 = j;
          paramInt4 = i1;
          j = n;
        }
        else
        {
          i10 = localView.getMeasuredWidth();
          i11 = localView.getMeasuredHeight();
          Object localObject = localView.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
            i6 = localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
            i5 = localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
            i2 = paramInt4 + localMarginLayoutParams.leftMargin;
            i1 = paramInt2 + localMarginLayoutParams.topMargin;
            i3 = localMarginLayoutParams.leftMargin + paramInt4 + i10;
            n = localMarginLayoutParams.topMargin + paramInt2 + i11;
            i9 = i6 + i10;
            i7 = i5 + i11;
            if (m + i9 <= paramInt3 - paramInt1) {
              break label553;
            }
            i1 = j + 1;
            paramInt2 += k;
            paramInt4 = i + i8;
            if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
              break label509;
            }
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            k = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            j = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            n = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramInt2 + i11;
            j = j + i + i10;
            k = paramInt2 + k;
            i2 = i + m;
            m = i;
            i5 = 0;
            i3 = paramInt4;
            paramInt4 = i5;
          }
        }
      }
    }
    for (;;)
    {
      label388:
      localView.layout(i2, k, j, n);
      if ((i1 > this.jdField_a_of_type_Int - 1) && (this.jdField_a_of_type_Boolean)) {
        localView.setVisibility(8);
      }
      for (;;)
      {
        j = paramInt4;
        if (i7 > paramInt4) {
          j = i7;
        }
        k = i3 + i9;
        paramInt4 = j;
        j = paramInt2;
        n = m + i9;
        m = i1;
        paramInt2 = paramInt4;
        paramInt4 = k;
        k = n;
        break;
        i3 = paramInt4 + i10;
        n = paramInt2 + i11;
        i5 = 0;
        i6 = 0;
        i1 = paramInt2;
        i2 = paramInt4;
        break label258;
        label509:
        j = i + i10;
        n = paramInt2 + i11;
        k = paramInt2;
        i2 = i;
        i3 = paramInt4;
        m = i;
        paramInt4 = 0;
        break label388;
        localView.setVisibility(0);
      }
      return;
      label553:
      i5 = paramInt4;
      paramInt4 = i1;
      i1 = j;
      i6 = k;
      j = i3;
      k = paramInt4;
      paramInt4 = i6;
      i3 = m;
      m = i5;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i5 = getPaddingLeft();
    int i6 = getPaddingRight();
    int m = getPaddingTop();
    int i7 = getPaddingBottom();
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int n = 0;
    int j = 0;
    int i = i5 + i6;
    View localView;
    for (int k = 0;; k = i1)
    {
      i1 = k;
      if (n >= getCount()) {
        break label281;
      }
      localView = a(n);
      ((TextView)localView.findViewById(2131367987)).setMaxWidth((int)(bclx.jdField_a_of_type_Int - 40.0F * bclx.a()) / 2);
      if (localView.getVisibility() != 8) {
        break;
      }
      i1 = k + 1;
      k = j;
      j = i1;
      n += 1;
      i1 = j;
      j = k;
    }
    int i2 = 0;
    int i1 = 0;
    Object localObject = localView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, m);
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      i1 = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      i1 = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + i1;
    }
    int i9;
    for (;;)
    {
      i9 = localView.getMeasuredWidth();
      int i10 = localView.getMeasuredHeight();
      i9 = i2 + i9;
      i2 = i1 + i10;
      if (i + i9 <= i4) {
        break label427;
      }
      i = k + 1;
      if ((i <= this.jdField_a_of_type_Int - 1) || (!this.jdField_a_of_type_Boolean)) {
        break;
      }
      i1 = i;
      label281:
      if (i8 != 1073741824) {
        break label395;
      }
      paramInt1 = i3;
      label291:
      setMeasuredDimension(i4, paramInt1);
      if ((this.jdField_a_of_type_Bbgo != null) && (this.jdField_a_of_type_Bbgo.a != null))
      {
        if (i1 < this.jdField_a_of_type_Int) {
          break label407;
        }
        this.jdField_a_of_type_Bbgo.a.a(true);
      }
      return;
      measureChild(localView, paramInt1, paramInt2);
    }
    m += j;
    i1 = i5 + i6;
    k = 0;
    j = i;
    for (;;)
    {
      if (i2 > k) {}
      for (i = i2;; i = k)
      {
        i1 = i9 + i1;
        k = i;
        i = i1;
        break;
        label395:
        paramInt1 = m + j + i7;
        break label291;
        label407:
        this.jdField_a_of_type_Bbgo.a.a(false);
        return;
      }
      label427:
      i1 = k;
      k = j;
      j = i1;
      i1 = i;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    switch (paramMotionEvent.getAction())
    {
    }
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      f3 = f2 - this.jdField_a_of_type_Float;
      f4 = f1 - this.jdField_b_of_type_Float;
    } while (f3 * f3 + f4 * f4 > this.jdField_b_of_type_Int * this.jdField_b_of_type_Int);
    int i2 = getChildCount();
    int i = 0;
    label108:
    int j = i1;
    int n;
    int m;
    int k;
    if (i < i2)
    {
      paramMotionEvent = getChildAt(i);
      if (!(paramMotionEvent.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label260;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams();
      n = localMarginLayoutParams.leftMargin;
      m = localMarginLayoutParams.rightMargin;
      k = localMarginLayoutParams.topMargin;
      j = localMarginLayoutParams.bottomMargin;
    }
    for (;;)
    {
      if ((paramMotionEvent.getLeft() - n < f1) && (m + paramMotionEvent.getRight() > f1) && (paramMotionEvent.getTop() - k < f2) && (j + paramMotionEvent.getBottom() > f2))
      {
        performItemClick(paramMotionEvent, i, i);
        j = 1;
        if (j != 0) {
          break;
        }
        performClick();
        return true;
      }
      i += 1;
      break label108;
      label260:
      j = 0;
      k = 0;
      m = 0;
      n = 0;
    }
  }
  
  public void setAdapter(Adapter paramAdapter)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(313);
    if (localAladdinConfig != null) {
      this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("SearchPage_HistoryRow", 2);
    }
    if ((this.jdField_a_of_type_Bbgo != null) && (this.jdField_a_of_type_Bkii != null)) {
      this.jdField_a_of_type_Bbgo.unregisterDataSetObserver(this.jdField_a_of_type_Bkii);
    }
    this.jdField_a_of_type_Bbgo = ((bbgo)paramAdapter);
    int i = 0;
    while (i < getCount())
    {
      ((TextView)a(i)).setMaxWidth((int)(bclx.jdField_a_of_type_Int - 40.0F * bclx.a()) / 2);
      i += 1;
    }
    if (this.jdField_a_of_type_Bbgo != null)
    {
      this.mItemCount = this.jdField_a_of_type_Bbgo.getCount();
      this.jdField_a_of_type_Bbgo.registerDataSetObserver(this.jdField_a_of_type_Bkii);
      a();
    }
  }
  
  public void setAdapter(bbgo parambbgo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setAdapter(parambbgo);
  }
  
  public void setSelection(int paramInt)
  {
    int i = getCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      a(paramInt).setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.KDSearchHistoryFlowLayout
 * JD-Core Version:    0.7.0.1
 */