package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import bhpv;
import bhqn;
import bhqq;
import bhxx;
import bhxy;
import bhxz;
import com.tencent.mobileqq.R.styleable;

public class VerticalGallery
  extends VerticalAbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private bhqn jdField_a_of_type_Bhqn;
  private bhxx jdField_a_of_type_Bhxx;
  private bhxy jdField_a_of_type_Bhxy;
  private bhxz jdField_a_of_type_Bhxz;
  private VerticalGallery.FlingRunnable jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable = new VerticalGallery.FlingRunnable(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new VerticalGallery.1(this);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private boolean d = true;
  private boolean e;
  private boolean f;
  private boolean g;
  private int jdField_h_of_type_Int = 400;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int m;
  private int n;
  private int o = 5;
  private int p = 1;
  
  public VerticalGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035108);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Vertical_Gallery, paramInt, 0);
    paramInt = paramAttributeSet.getInt(0, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramAttributeSet.getInt(1, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.getDimensionPixelOffset(2, 0));
    setUnselectedAlpha(paramAttributeSet.getFloat(3, 0.5F));
    paramAttributeSet.recycle();
    setChildrenDrawingOrderEnabled(true);
    setStaticTransformationsEnabled(true);
    this.o = ViewConfiguration.get(paramContext).getScaledScrollBarSize();
    if (a())
    {
      this.jdField_k_of_type_Int = 1;
      return;
    }
    this.jdField_k_of_type_Int = 16;
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = getMeasuredHeight();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i2 = paramView.getMeasuredHeight();; i2 = paramView.getHeight()) {
      switch (this.jdField_k_of_type_Int)
      {
      default: 
        return 0;
        i1 = getHeight();
        break label9;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    return (i1 - i3 - i4 - i2) / 2 + i5;
    return i1 - this.jdField_a_of_type_AndroidGraphicsRect.bottom - i2;
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.jdField_a_of_type_Bhpv.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        this.jdField_j_of_type_Int = Math.max(this.jdField_j_of_type_Int, localView.getMeasuredWidth() + paramInt1);
        this.jdField_i_of_type_Int = Math.min(this.jdField_i_of_type_Int, paramInt1);
        a(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
    a(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    VerticalGallery.LayoutParams localLayoutParams = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      if (paramBoolean)
      {
        i1 = -1;
        addViewInLayout(paramView, i1, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right, localLayoutParams.width), paramInt1);
        i1 = a(paramView, true);
        i2 = paramView.getMeasuredHeight();
        i3 = paramView.getMeasuredWidth();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = i3 + paramInt2;
      }
      for (;;)
      {
        paramView.layout(paramInt1, i1, paramInt2, i1 + i2);
        return;
        i1 = 0;
        break;
        label169:
        paramInt1 = paramInt2 - i3;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 0;
    int i5 = 0;
    int i6 = getChildCount();
    int i4 = this.mFirstPosition;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingLeft();
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        if (i2 < i6)
        {
          localView = getChildAt(i2);
          if (localView.getRight() < i3) {}
        }
        else
        {
          i3 = i1;
          i4 = i5;
          if (i1 == i6)
          {
            i3 = i1 - 1;
            i4 = i5;
          }
          detachViewsFromParent(i4, i3);
          if (paramBoolean)
          {
            this.mFirstPosition = (i3 + this.mFirstPosition);
            if (f()) {
              this.mFirstPosition %= this.mItemCount;
            }
          }
          return;
        }
        this.jdField_a_of_type_Bhpv.a(i4 + i2, localView);
        i2 += 1;
        i1 += 1;
      }
    }
    i5 = getWidth();
    int i7 = getPaddingRight();
    int i3 = i6 - 1;
    int i1 = 0;
    for (;;)
    {
      if (i3 >= 0)
      {
        localView = getChildAt(i3);
        if (localView.getLeft() > i5 - i7) {}
      }
      else
      {
        i3 = i1;
        i4 = i2;
        if (i2 != 0) {
          break;
        }
        i4 = i2 + 1;
        i3 = i1;
        break;
      }
      this.jdField_a_of_type_Bhpv.a(i4 + i3, localView);
      i1 += 1;
      i2 = i3;
      i3 -= 1;
    }
  }
  
  private boolean a()
  {
    return this.p == 2;
  }
  
  private boolean a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = b();
      int i1 = c(localView);
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.b(paramInt - i1);
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool1 = this.mOnItemLongClickListener.a(this, this.jdField_b_of_type_AndroidViewView, this.jdField_l_of_type_Int, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_Bhqn = new bhqn(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  private int b(View paramView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = getMeasuredWidth();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i2 = paramView.getMeasuredWidth();; i2 = paramView.getWidth()) {
      switch (this.jdField_k_of_type_Int)
      {
      case 2: 
      case 4: 
      default: 
        return 0;
        i1 = getWidth();
        break label9;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    return (i1 - i3 - i4 - i2) / 2 + i5;
    return i1 - this.jdField_a_of_type_AndroidGraphicsRect.right - i2;
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.jdField_a_of_type_Bhpv.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getTop();
        this.jdField_j_of_type_Int = Math.max(this.jdField_j_of_type_Int, localView.getMeasuredHeight() + paramInt1);
        this.jdField_i_of_type_Int = Math.min(this.jdField_i_of_type_Int, paramInt1);
        b(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
    b(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    VerticalGallery.LayoutParams localLayoutParams = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      if (paramBoolean)
      {
        i1 = -1;
        addViewInLayout(paramView, i1, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right, localLayoutParams.width), paramInt1);
        i1 = b(paramView, true);
        i2 = paramView.getMeasuredWidth();
        i3 = paramView.getMeasuredHeight();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = i3 + paramInt2;
      }
      for (;;)
      {
        paramView.layout(i1, paramInt1, i1 + i2, paramInt2);
        return;
        i1 = 0;
        break;
        label169:
        paramInt1 = paramInt2 - i3;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 0;
    int i5 = 0;
    int i6 = getChildCount();
    int i4 = this.mFirstPosition;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingTop();
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        if (i2 < i6)
        {
          localView = getChildAt(i2);
          if (localView.getBottom() < i3) {}
        }
        else
        {
          i3 = i1;
          i4 = i5;
          if (i1 == i6)
          {
            i3 = i1 - 1;
            i4 = i5;
          }
          detachViewsFromParent(i4, i3);
          if (paramBoolean)
          {
            this.mFirstPosition = (i3 + this.mFirstPosition);
            if (f()) {
              this.mFirstPosition %= this.mItemCount;
            }
          }
          return;
        }
        this.jdField_a_of_type_Bhpv.a(i4 + i2, localView);
        i2 += 1;
        i1 += 1;
      }
    }
    i5 = getHeight();
    int i7 = getPaddingBottom();
    int i3 = i6 - 1;
    int i1 = 0;
    for (;;)
    {
      if (i3 >= 0)
      {
        localView = getChildAt(i3);
        if (localView.getTop() > i5 - i7) {}
      }
      else
      {
        i3 = i1;
        i4 = i2;
        if (i2 != 0) {
          break;
        }
        i4 = i2 + 1;
        i3 = i1;
        break;
      }
      this.jdField_a_of_type_Bhpv.a(i4 + i3, localView);
      i1 += 1;
      i2 = i3;
      i3 -= 1;
    }
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt != this.mSelectedPosition)
    {
      setSelectedPositionInt(paramInt);
      setNextSelectedPositionInt(paramInt);
      checkSelectionChanged();
      return true;
    }
    return false;
  }
  
  private float c()
  {
    if (a()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) * a() + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) * a() + getPaddingLeft();
  }
  
  private int c(View paramView)
  {
    if (a()) {
      return paramView.getTop() + paramView.getHeight() / 2;
    }
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private void h()
  {
    int i2 = 0;
    if (d()) {
      if ((getChildCount() != 0) && (this.jdField_c_of_type_AndroidViewView != null)) {}
    }
    int i1;
    while (getChildCount() == 0)
    {
      return;
      i1 = c(this.jdField_c_of_type_AndroidViewView);
      i1 = b() - i1;
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.b(i1);
        return;
      }
      i();
      return;
    }
    View localView1;
    if (this.mFirstPosition == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getTop() >= 0) {
        i1 = getPaddingTop() - localView1.getTop();
      }
    }
    while (i1 != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.b(i1);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getBottom() - localView1.getTop() < getBottom() - getPaddingBottom())
      {
        i1 = getPaddingLeft() - this.m;
      }
      else
      {
        i1 = i2;
        if (localView2.getBottom() < getBottom() - getPaddingBottom())
        {
          i1 = getHeight() - getPaddingBottom() - localView2.getBottom();
          continue;
          i1 = i2;
          if (this.mFirstPosition + getChildCount() == this.mItemCount)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i1 = i2;
            if (localView1.getBottom() < getBottom() - getPaddingBottom()) {
              i1 = getHeight() - getPaddingBottom() - localView1.getBottom();
            }
          }
        }
      }
    }
    i();
  }
  
  private void i()
  {
    if (this.e)
    {
      this.e = false;
      super.selectionChanged();
    }
    invalidate();
    if (this.jdField_a_of_type_Bhxy != null) {
      this.jdField_a_of_type_Bhxy.a(this);
    }
  }
  
  private void j()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    int i5;
    do
    {
      return;
      i5 = b();
    } while ((localView.getLeft() <= i5) && (localView.getRight() >= i5));
    int i3 = 2147483647;
    int i2 = 0;
    int i1 = getChildCount() - 1;
    if (i1 >= 0)
    {
      localView = getChildAt(i1);
      if ((localView.getLeft() > i5) || (localView.getRight() < i5)) {}
    }
    for (;;)
    {
      i2 = this.mFirstPosition + i1;
      i1 = i2;
      if (f()) {
        i1 = i2 % this.mItemCount;
      }
      if (i1 == this.mSelectedPosition) {
        break;
      }
      setSelectedPositionInt(i1);
      setNextSelectedPositionInt(i1);
      checkSelectionChanged();
      return;
      int i4 = Math.min(Math.abs(localView.getLeft() - i5), Math.abs(localView.getRight() - i5));
      if (i4 < i3) {
        i3 = i1;
      }
      for (i2 = i4;; i2 = i4)
      {
        i1 -= 1;
        i4 = i2;
        i2 = i3;
        i3 = i4;
        break;
        i4 = i3;
        i3 = i2;
      }
      i1 = i2;
    }
  }
  
  private void k()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    int i5;
    do
    {
      return;
      i5 = b();
    } while ((localView != null) && (localView.getTop() <= i5) && (localView.getBottom() >= i5));
    int i3 = 2147483647;
    int i2 = 0;
    int i1 = getChildCount() - 1;
    if (i1 >= 0)
    {
      localView = getChildAt(i1);
      if ((localView.getTop() > i5) || (localView.getBottom() < i5)) {}
    }
    for (;;)
    {
      i2 = this.mFirstPosition + i1;
      i1 = i2;
      if (f()) {
        i1 = i2 % this.mItemCount;
      }
      if (i1 == this.mSelectedPosition) {
        break;
      }
      setSelectedPositionInt(i1);
      setNextSelectedPositionInt(i1);
      checkSelectionChanged();
      return;
      int i4 = Math.min(Math.abs(localView.getTop() - i5), Math.abs(localView.getBottom() - i5));
      if (i4 < i3) {
        i3 = i1;
      }
      for (i2 = i4;; i2 = i4)
      {
        i1 -= 1;
        i4 = i2;
        i2 = i3;
        i3 = i4;
        break;
        i4 = i3;
        i3 = i2;
      }
      i1 = i2;
    }
  }
  
  private void l()
  {
    if (f()) {
      q();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getPaddingLeft();
      View localView = getChildAt(0);
      int i2;
      int i1;
      if (localView != null)
      {
        i2 = this.mFirstPosition - 1;
        i1 = localView.getLeft() - i3;
      }
      while ((i1 > i4) && (i2 >= 0))
      {
        localView = a(i2, i2 - this.mSelectedPosition, i1, false);
        this.mFirstPosition = i2;
        i1 = localView.getLeft() - i3;
        i2 -= 1;
        continue;
        i1 = getRight() - getLeft() - getPaddingRight();
        this.jdField_a_of_type_Boolean = true;
        i2 = 0;
      }
    }
  }
  
  private void m()
  {
    if (f()) {
      r();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getPaddingTop();
      View localView = getChildAt(0);
      int i2;
      int i1;
      if (localView != null)
      {
        i2 = this.mFirstPosition - 1;
        i1 = localView.getTop() - i3;
      }
      while ((i1 > i4) && (i2 >= 0))
      {
        localView = b(i2, i2 - this.mSelectedPosition, i1, false);
        this.mFirstPosition = i2;
        i1 = localView.getTop() - i3;
        i2 -= 1;
        continue;
        i1 = getBottom() - getTop() - getPaddingBottom();
        this.jdField_a_of_type_Boolean = true;
        i2 = 0;
      }
    }
  }
  
  private void n()
  {
    if (f()) {
      s();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getRight();
      int i5 = getLeft();
      int i6 = getPaddingRight();
      int i1 = getChildCount();
      int i7 = this.mItemCount;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i2 = this.mFirstPosition + i1;
        i1 = localView.getRight() + i3;
      }
      while ((i1 < i4 - i5 - i6) && (i2 < i7))
      {
        i1 = a(i2, i2 - this.mSelectedPosition, i1, true).getRight() + i3;
        i2 += 1;
        continue;
        i2 = this.mItemCount - 1;
        this.mFirstPosition = i2;
        i1 = getPaddingLeft();
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void o()
  {
    if (f()) {
      t();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getBottom();
      int i5 = getTop();
      int i6 = getPaddingRight();
      int i1 = getChildCount();
      int i7 = this.mItemCount;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i2 = this.mFirstPosition + i1;
        i1 = localView.getBottom() + i3;
      }
      while ((i1 < i4 - i5 - i6) && (i2 < i7))
      {
        i1 = b(i2, i2 - this.mSelectedPosition, i1, true).getBottom() + i3;
        i2 += 1;
        continue;
        i2 = this.mItemCount - 1;
        this.mFirstPosition = i2;
        i1 = getPaddingTop();
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void p()
  {
    View localView1 = this.jdField_c_of_type_AndroidViewView;
    int i2 = this.mSelectedPosition - this.mFirstPosition;
    int i1 = i2;
    if (f())
    {
      i1 = i2;
      if (this.mFirstPosition > this.mSelectedPosition) {
        i1 = this.mItemCount - this.mFirstPosition + this.mSelectedPosition;
      }
    }
    View localView2 = getChildAt(i1);
    this.jdField_c_of_type_AndroidViewView = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
      if (this.jdField_a_of_type_Bhxz != null) {
        this.jdField_a_of_type_Bhxz.a(localView2, i1);
      }
    } while ((localView1 == null) || (localView1 == this.jdField_c_of_type_AndroidViewView));
    localView1.setSelected(false);
  }
  
  private void q()
  {
    int i3 = this.jdField_a_of_type_Int;
    int i4 = getPaddingLeft();
    View localView = getChildAt(0);
    int i1;
    if (localView != null)
    {
      i2 = this.mFirstPosition - 1;
      i1 = localView.getLeft() - i3;
    }
    while ((i1 > i4) && (i2 >= 0))
    {
      localView = a(i2, i2 - this.mSelectedPosition, i1, false);
      this.mFirstPosition = i2;
      i1 = localView.getLeft() - i3;
      i2 -= 1;
      continue;
      i1 = getRight() - getLeft() - getPaddingRight();
      this.jdField_a_of_type_Boolean = true;
      i2 = 0;
    }
    int i2 = this.mItemCount - 1;
    while ((i1 > i4) && (getChildCount() < this.mItemCount))
    {
      localView = a(i2, i2 - this.mSelectedPosition, i1, false);
      this.mFirstPosition = i2;
      i1 = localView.getLeft() - i3;
      i2 -= 1;
    }
  }
  
  private void r()
  {
    int i3 = this.jdField_a_of_type_Int;
    int i4 = getPaddingTop();
    View localView = getChildAt(0);
    int i1;
    if (localView != null)
    {
      i2 = this.mFirstPosition - 1;
      i1 = localView.getTop() - i3;
    }
    while ((i1 > i4) && (i2 >= 0))
    {
      localView = b(i2, i2 - this.mSelectedPosition, i1, false);
      this.mFirstPosition = i2;
      i1 = localView.getTop() - i3;
      i2 -= 1;
      continue;
      i1 = getBottom() - getTop() - getPaddingBottom();
      this.jdField_a_of_type_Boolean = true;
      i2 = 0;
    }
    int i2 = this.mItemCount - 1;
    while ((i1 > i4) && (getChildCount() < this.mItemCount))
    {
      localView = b(i2, i2 - this.mSelectedPosition, i1, false);
      this.mFirstPosition = i2;
      i1 = localView.getTop() - i3;
      i2 -= 1;
    }
  }
  
  private void s()
  {
    int i3 = this.jdField_a_of_type_Int;
    int i4 = getRight() - getLeft() - getPaddingRight();
    int i1 = getChildCount();
    int i5 = this.mItemCount;
    View localView = getChildAt(i1 - 1);
    int i2;
    if (localView != null)
    {
      i2 = this.mFirstPosition + i1;
      i1 = localView.getRight() + i3;
    }
    while ((i1 < i4) && (i2 < i5))
    {
      i1 = a(i2, i2 - this.mSelectedPosition, i1, true).getRight() + i3;
      i2 += 1;
      continue;
      i2 = this.mItemCount - 1;
      this.mFirstPosition = i2;
      i1 = getPaddingLeft();
      this.jdField_a_of_type_Boolean = true;
    }
    i2 %= i5;
    while ((i1 <= i4) && (getChildCount() < this.mItemCount))
    {
      i1 = a(i2, i2 - this.mSelectedPosition, i1, true).getRight() + i3;
      i2 += 1;
    }
  }
  
  private void t()
  {
    int i3 = this.jdField_a_of_type_Int;
    int i4 = getBottom() - getTop() - getPaddingBottom();
    int i1 = getChildCount();
    int i5 = this.mItemCount;
    View localView = getChildAt(i1 - 1);
    int i2;
    if (localView != null)
    {
      i2 = this.mFirstPosition + i1;
      i1 = localView.getBottom() + i3;
    }
    while ((i1 < i4) && (i2 < i5))
    {
      i1 = b(i2, i2 - this.mSelectedPosition, i1, true).getBottom() + i3;
      i2 += 1;
      continue;
      i2 = this.mItemCount - 1;
      this.mFirstPosition = i2;
      i1 = getPaddingTop();
      this.jdField_a_of_type_Boolean = true;
    }
    i2 %= i5;
    while ((i1 <= i4) && (getChildCount() < this.mItemCount))
    {
      i1 = b(i2, i2 - this.mSelectedPosition, i1, true).getBottom() + i3;
      i2 += 1;
    }
  }
  
  protected float a()
  {
    return 0.0F;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int a(boolean paramBoolean, int paramInt)
  {
    int i2 = 0;
    View localView;
    if (paramBoolean)
    {
      i1 = this.mItemCount - 1;
      localView = getChildAt(i1 - this.mFirstPosition);
      if (localView != null) {
        break label40;
      }
      i1 = paramInt;
    }
    label40:
    int i3;
    int i4;
    do
    {
      return i1;
      i1 = 0;
      break;
      i3 = c(localView);
      i4 = b();
      if (!paramBoolean) {
        break label86;
      }
      i1 = i2;
    } while (i3 <= i4);
    int i1 = i4 - i3;
    if (paramBoolean) {}
    for (paramInt = Math.max(i1, paramInt);; paramInt = Math.min(i1, paramInt))
    {
      return paramInt;
      label86:
      if (i3 < i4) {
        break;
      }
      return 0;
    }
  }
  
  public void a()
  {
    int i2 = 0;
    if (a()) {
      h();
    }
    int i1;
    do
    {
      do
      {
        return;
        if (!d()) {
          break;
        }
      } while ((getChildCount() == 0) || (this.jdField_c_of_type_AndroidViewView == null));
      i1 = c(this.jdField_c_of_type_AndroidViewView);
      i1 = b() - i1;
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.b(i1);
        return;
      }
      i();
      return;
    } while (getChildCount() == 0);
    View localView1;
    if (this.mFirstPosition == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getLeft() >= 0) {
        i1 = getPaddingLeft() - localView1.getLeft();
      }
    }
    while (i1 != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.b(i1);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getRight() - localView1.getLeft() < getRight() - getPaddingRight())
      {
        i1 = getPaddingLeft() - this.m;
      }
      else
      {
        i1 = i2;
        if (localView2.getRight() < getRight() - getPaddingRight())
        {
          i1 = getWidth() - getPaddingRight() - localView2.getRight();
          continue;
          i1 = i2;
          if (this.mFirstPosition + getChildCount() == this.mItemCount)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i1 = i2;
            if (localView1.getRight() < getRight() - getPaddingRight()) {
              i1 = getWidth() - getPaddingRight() - localView1.getRight();
            }
          }
        }
      }
    }
    i();
  }
  
  void a(int paramInt)
  {
    int i1 = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!d()) {
        break label109;
      }
      if (((!f()) || (getChildCount() >= this.mItemCount)) && (a(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable, false);
        i();
      }
      c(paramInt);
      a(bool);
      if (!bool) {
        break label102;
      }
      n();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpv.a();
      j();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      l();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= c())) {
        break label263;
      }
      paramInt = i1;
      if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a(false);
        paramInt = i1;
      }
    }
    label263:
    for (;;)
    {
      c(paramInt);
      a(bool);
      if (bool) {
        n();
      }
      for (;;)
      {
        this.jdField_a_of_type_Bhpv.a();
        j();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - c())) {
          break label263;
        }
        paramInt = i1;
        if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a(false);
        paramInt = i1;
        break;
        l();
      }
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  protected int b()
  {
    if (a()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  void b(int paramInt)
  {
    int i1 = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!d()) {
        break label109;
      }
      if (((!f()) || (getChildCount() >= this.mItemCount)) && (a(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable, false);
        i();
      }
      d(paramInt);
      b(bool);
      if (!bool) {
        break label102;
      }
      o();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpv.a();
      k();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      m();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= c())) {
        break label263;
      }
      paramInt = i1;
      if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a(false);
        paramInt = i1;
      }
    }
    label263:
    for (;;)
    {
      d(paramInt);
      b(bool);
      if (bool) {
        o();
      }
      for (;;)
      {
        this.jdField_a_of_type_Bhpv.a();
        j();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - c())) {
          break label263;
        }
        paramInt = i1;
        if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a(false);
        paramInt = i1;
        break;
        m();
      }
    }
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    if (a())
    {
      c(paramInt, paramBoolean);
      return;
    }
    paramInt = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i1 = this.m + paramInt;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      b();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    c();
    detachAllViewsFromParent();
    this.jdField_j_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = a(this.mFirstPosition, 0, 0, true);
    paramInt = this.jdField_a_of_type_Int + i1;
    if (d()) {
      paramInt = (getRight() - getLeft() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right) / 2 + i1 - localView.getWidth() / 2;
    }
    localView.offsetLeftAndRight(paramInt);
    n();
    l();
    this.jdField_a_of_type_Bhpv.a();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    p();
    if (getChildCount() < this.mItemCount) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean b()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition > 0);
  }
  
  public void c(int paramInt)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).offsetLeftAndRight(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i1).invalidate();
      }
      i1 -= 1;
    }
  }
  
  void c(int paramInt, boolean paramBoolean)
  {
    paramInt = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i1 = this.m + paramInt;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      b();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    c();
    detachAllViewsFromParent();
    this.jdField_j_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = b(this.mFirstPosition, 0, 0, true);
    paramInt = this.jdField_a_of_type_Int + i1;
    if (d()) {
      paramInt = (getBottom() - getTop() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / 2 + i1 - localView.getHeight() / 2;
    }
    localView.offsetTopAndBottom(paramInt);
    o();
    m();
    this.jdField_a_of_type_Bhpv.a();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    p();
    if (getChildCount() < this.mItemCount) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean c()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition < this.mItemCount - 1);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof VerticalGallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    int i3 = 0;
    int i4 = getChildCount();
    if (i4 > 0)
    {
      int i2 = i4 * 100;
      View localView = getChildAt(0);
      int i5 = localView.getLeft();
      int i6 = localView.getWidth();
      int i1 = i2;
      if (i6 > 0) {
        if (this.mFirstPosition != 0) {
          break label160;
        }
      }
      label160:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          i1 = i2;
          if (i5 > 0) {}
        }
        else
        {
          i1 = i2 + i5 * 100 / i6;
        }
        localView = getChildAt(i4 - 1);
        i5 = localView.getRight();
        i6 = localView.getWidth();
        i2 = i1;
        if (i6 > 0)
        {
          i2 = i3;
          if (i4 + this.mFirstPosition == this.mItemCount) {
            i2 = 1;
          }
          if (i2 != 0)
          {
            i2 = i1;
            if (i5 < getWidth()) {}
          }
          else
          {
            i2 = i1 - (i5 - getWidth()) * 100 / i6;
          }
        }
        return i2;
      }
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if ((this.mFirstPosition >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i1 = localView.getLeft();
      int i2 = localView.getWidth();
      if (i2 > 0) {
        return Math.max(this.mFirstPosition / 1 * 100 - i1 * 100 / i2, 0);
      }
    }
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return Math.max((this.mItemCount + 1 - 1) / 1 * 100, 0);
  }
  
  protected void d()
  {
    if (VerticalGallery.FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable).isFinished()) {
      a();
    }
    f();
  }
  
  public void d(int paramInt)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).offsetTopAndBottom(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i1).invalidate();
      }
      i1 -= 1;
    }
  }
  
  public boolean d()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  void e()
  {
    d();
  }
  
  protected boolean e()
  {
    if ((!this.jdField_h_of_type_Boolean) || (getChildCount() < this.mItemCount)) {}
    View localView;
    do
    {
      do
      {
        return false;
        localView = getChildAt(0);
      } while ((localView != null) && (localView.getLeft() < getLeft()));
      localView = getChildAt(getChildCount() - 1);
    } while ((localView != null) && (localView.getRight() > getRight()));
    return true;
  }
  
  protected void f()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).setPressed(false);
      i1 -= 1;
    }
    setPressed(false);
  }
  
  public boolean f()
  {
    return (this.jdField_j_of_type_Boolean) && (this.jdField_k_of_type_Boolean);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Bhxx != null) {
      this.jdField_a_of_type_Bhxx.b(this);
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalGallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalGallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new VerticalGallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.mSelectedPosition - this.mFirstPosition;
    if (i1 < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i1;
      }
    } while (paramInt2 < i1);
    return paramInt2 + 1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    if (paramView == this.jdField_c_of_type_AndroidViewView) {}
    for (float f1 = 1.0F;; f1 = this.jdField_a_of_type_Float)
    {
      paramTransformation.setAlpha(f1);
      return true;
    }
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_Bhqn;
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.invalidate(paramInt1, paramInt2 - (this.o + this.n), paramInt3, paramInt4);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((1 == paramMotionEvent.getAction()) && (this.jdField_l_of_type_Int >= 0))
    {
      if ((!this.d) && (this.jdField_l_of_type_Int == this.mSelectedPosition)) {}
      return true;
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a(false);
    this.jdField_l_of_type_Int = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (this.jdField_l_of_type_Int >= 0)
    {
      this.jdField_b_of_type_AndroidViewView = getChildAt(this.jdField_l_of_type_Int - this.mFirstPosition);
      this.jdField_b_of_type_AndroidViewView.setPressed(true);
    }
    this.g = true;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (e()) {
      return true;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.e) {
        this.e = true;
      }
    }
    if (a())
    {
      paramFloat1 = b();
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a((int)-(paramFloat1 * paramFloat2));
      return true;
    }
    paramFloat2 = b();
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.a((int)-(paramFloat2 * paramFloat1));
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.requestFocus(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!b());
        playSoundEffect(1);
        return true;
      } while (!c());
      playSoundEffect(3);
      return true;
      this.f = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.f) && (this.mItemCount > 0))
    {
      a(this.jdField_c_of_type_AndroidViewView);
      postDelayed(new VerticalGallery.2(this), ViewConfiguration.getPressedStateDuration());
      performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.mSelectedPosition));
    }
    this.f = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    b(0, false);
    this.mInLayout = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_l_of_type_Int < 0) {
      return;
    }
    performHapticFeedback(0);
    long l1 = getItemIdAtPosition(this.jdField_l_of_type_Int);
    a(this.jdField_b_of_type_AndroidViewView, this.jdField_l_of_type_Int, l1);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (e()) {
      return true;
    }
    this.jdField_i_of_type_Boolean = true;
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.g)
      {
        if (!this.e) {
          this.e = true;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
      }
      if (!a()) {
        break label100;
      }
      b((int)paramFloat2 * -1);
    }
    for (;;)
    {
      this.g = false;
      return true;
      if (!this.e) {
        break;
      }
      this.e = false;
      break;
      label100:
      a((int)paramFloat1 * -1);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.jdField_l_of_type_Int >= 0)
    {
      if (f()) {
        this.jdField_l_of_type_Int %= getCount();
      }
      if (d()) {
        a(this.jdField_l_of_type_Int - this.mFirstPosition);
      }
      b(this.jdField_l_of_type_Int);
      if ((this.d) || (this.jdField_l_of_type_Int == this.mSelectedPosition)) {
        performItemClick(this.jdField_b_of_type_AndroidViewView, this.jdField_l_of_type_Int, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.jdField_l_of_type_Int));
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 == 1) {
      d();
    }
    while (i1 != 3) {
      return bool;
    }
    e();
    return bool;
  }
  
  protected void selectionChanged()
  {
    if (!this.e) {
      super.selectionChanged();
    }
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setFirstChildOffset(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setFirstPosition(int paramInt)
  {
    this.mFirstPosition = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_k_of_type_Int != paramInt)
    {
      this.jdField_k_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setOnEndFlingListener(bhxx parambhxx)
  {
    this.jdField_a_of_type_Bhxx = parambhxx;
  }
  
  public void setOnEndMovementListener(bhxy parambhxy)
  {
    this.jdField_a_of_type_Bhxy = parambhxy;
  }
  
  public void setOnSelectViewDataUpdateListener(bhxz parambhxz)
  {
    this.jdField_a_of_type_Bhxz = parambhxz;
  }
  
  public void setOrientation(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setScrollBarBottomMargin(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setScrollBarSize(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setScrollCycle(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  protected void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    p();
  }
  
  public void setSlotInCenter(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setVelocityRatio(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    if (this.jdField_b_of_type_Float < 0.5F) {
      this.jdField_b_of_type_Float = 0.5F;
    }
    while (this.jdField_b_of_type_Float <= 1.5F) {
      return;
    }
    this.jdField_b_of_type_Float = 1.5F;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.mSelectedPosition >= 0)) {
      return a(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i1 = getPositionForView(paramView);
    if (i1 < 0) {
      return false;
    }
    return a(paramView, i1, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery
 * JD-Core Version:    0.7.0.1
 */