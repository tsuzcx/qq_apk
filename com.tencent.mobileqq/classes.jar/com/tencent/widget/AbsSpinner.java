package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import bhuc;
import bhuv;
import bica;

public abstract class AbsSpinner
  extends AdapterView<SpinnerAdapter>
{
  private static int jdField_a_of_type_Int = -2;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  SpinnerAdapter jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  final bhuc jdField_a_of_type_Bhuc = new bhuc(this);
  int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, true);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    if (paramBoolean)
    {
      if (jdField_a_of_type_Int == -2) {
        jdField_a_of_type_Int = getStyleableValue("AbsSpinner_entries");
      }
      paramAttributeSet = new bica(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("AbsSpinner"), paramInt, 0));
      CharSequence[] arrayOfCharSequence = paramAttributeSet.a(jdField_a_of_type_Int);
      if (arrayOfCharSequence != null)
      {
        paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
        paramContext.setDropDownViewResource(17367049);
        setAdapter(paramContext);
      }
      paramAttributeSet.a();
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (i < paramInt1)
      {
        paramInt2 = i | 0x1000000;
        continue;
        paramInt2 = i;
      }
    }
  }
  
  private void a()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_b_of_type_AndroidGraphicsRect;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.mFirstPosition + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public SpinnerAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  }
  
  protected bhuv a()
  {
    return new bhuv(this);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.mOldSelectedPosition)
    {
      this.jdField_c_of_type_Boolean = true;
      int i = this.mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      b(paramInt - i, paramBoolean);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void b()
  {
    this.mDataChanged = false;
    this.mNeedSync = false;
    removeAllViewsInLayout();
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  abstract void b(int paramInt, boolean paramBoolean);
  
  void c()
  {
    int j = getChildCount();
    bhuc localbhuc = this.jdField_a_of_type_Bhuc;
    int k = this.mFirstPosition;
    int i = 0;
    while (i < j)
    {
      localbhuc.a(k + i, getChildAt(i));
      i += 1;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0)) {
      return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    int i;
    label56:
    label84:
    label112:
    int j;
    int k;
    if (this.mPaddingLeft > this.d)
    {
      i = this.mPaddingLeft;
      ((Rect)localObject).left = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingTop <= this.e) {
        break label413;
      }
      i = this.mPaddingTop;
      ((Rect)localObject).top = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingRight <= this.f) {
        break label421;
      }
      i = this.mPaddingRight;
      ((Rect)localObject).right = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingBottom <= this.g) {
        break label429;
      }
      i = this.mPaddingBottom;
      ((Rect)localObject).bottom = i;
      if (this.mDataChanged) {
        handleDataChanged();
      }
      i = getSelectedItemPosition();
      if ((i < 0) || (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter == null) || (i >= this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount())) {
        break label437;
      }
      View localView = this.jdField_a_of_type_Bhuc.a(i);
      localObject = localView;
      if (localView == null) {
        localObject = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(i, null, this);
      }
      if (localObject != null) {
        this.jdField_a_of_type_Bhuc.a(i, (View)localObject);
      }
      if (localObject == null) {
        break label437;
      }
      if (((View)localObject).getLayoutParams() == null)
      {
        this.jdField_c_of_type_Boolean = true;
        ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
        this.jdField_c_of_type_Boolean = false;
      }
      measureChild((View)localObject, paramInt1, paramInt2);
      j = a((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      i = b((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
      k = 0;
    }
    for (;;)
    {
      int m = i;
      if (k != 0)
      {
        k = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        m = i;
        j = k;
        if (n == 0)
        {
          m = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
          j = k;
        }
      }
      i = Math.max(j, getSuggestedMinimumHeight());
      j = Math.max(m, getSuggestedMinimumWidth());
      i = a(i, paramInt2, 0);
      setMeasuredDimension(a(j, paramInt1, 0), i);
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_Int = paramInt1;
      return;
      i = this.d;
      break;
      label413:
      i = this.e;
      break label56;
      label421:
      i = this.f;
      break label84;
      label429:
      i = this.g;
      break label112;
      label437:
      k = 1;
      i = 0;
      j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.mDataChanged = true;
      this.mNeedSync = true;
      this.mSyncRowId = paramParcelable.jdField_a_of_type_Long;
      this.mSyncPosition = paramParcelable.jdField_a_of_type_Int;
      this.mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Long = getSelectedItemId();
    if (localSavedState.jdField_a_of_type_Long >= 0L)
    {
      localSavedState.jdField_a_of_type_Int = getSelectedItemPosition();
      return localSavedState;
    }
    localSavedState.jdField_a_of_type_Int = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.jdField_c_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      b();
    }
    this.jdField_a_of_type_AndroidWidgetSpinnerAdapter = paramSpinnerAdapter;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount();
      checkFocus();
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = a();
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (this.mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      checkFocus();
      b();
      checkSelectionChanged();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mFirstPosition <= paramInt) && (paramInt <= this.mFirstPosition + getChildCount() - 1)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramInt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */