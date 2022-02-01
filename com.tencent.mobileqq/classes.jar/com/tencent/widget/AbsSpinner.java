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

public abstract class AbsSpinner
  extends AdapterView<SpinnerAdapter>
{
  private static int ABSSPINNER_ENTRIES = -2;
  SpinnerAdapter mAdapter;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  final AbsSpinner.RecycleBin mRecycler = new AbsSpinner.RecycleBin(this);
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
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
    initAbsSpinner();
    if (paramBoolean)
    {
      if (ABSSPINNER_ENTRIES == -2) {
        ABSSPINNER_ENTRIES = getStyleableValue("AbsSpinner_entries");
      }
      paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("AbsSpinner"), paramInt, 0));
      CharSequence[] arrayOfCharSequence = paramAttributeSet.getTextArray(ABSSPINNER_ENTRIES);
      if (arrayOfCharSequence != null)
      {
        paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
        paramContext.setDropDownViewResource(17367049);
        setAdapter(paramContext);
      }
      paramAttributeSet.recycle();
    }
  }
  
  public static int doResolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j != -2147483648)
    {
      paramInt2 = paramInt1;
      if (j != 0) {
        if (j != 1073741824) {
          paramInt2 = paramInt1;
        } else {
          paramInt2 = i;
        }
      }
    }
    else
    {
      paramInt2 = paramInt1;
      if (i < paramInt1) {
        paramInt2 = 0x1000000 | i;
      }
    }
    return paramInt2 | 0xFF000000 & paramInt3;
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected AdapterView.AdapterDataSetObserver createObserver()
  {
    return new AdapterView.AdapterDataSetObserver(this);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int getChildWidth(View paramView)
  {
    return paramView.getMeasuredWidth();
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
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    Object localObject = this.mSpinnerPadding;
    int k = getPaddingLeft();
    int j = this.mSelectionLeftPadding;
    int i = j;
    if (k > j) {
      i = getPaddingLeft();
    }
    ((Rect)localObject).left = i;
    localObject = this.mSpinnerPadding;
    k = getPaddingTop();
    j = this.mSelectionTopPadding;
    i = j;
    if (k > j) {
      i = getPaddingTop();
    }
    ((Rect)localObject).top = i;
    localObject = this.mSpinnerPadding;
    k = getPaddingRight();
    j = this.mSelectionRightPadding;
    i = j;
    if (k > j) {
      i = getPaddingRight();
    }
    ((Rect)localObject).right = i;
    localObject = this.mSpinnerPadding;
    k = getPaddingBottom();
    j = this.mSelectionBottomPadding;
    i = j;
    if (k > j) {
      i = getPaddingBottom();
    }
    ((Rect)localObject).bottom = i;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    i = getSelectedItemPosition();
    k = 1;
    if (i >= 0)
    {
      localObject = this.mAdapter;
      if ((localObject != null) && (i < ((SpinnerAdapter)localObject).getCount()))
      {
        View localView = this.mRecycler.get(i);
        localObject = localView;
        if (localView == null) {
          localObject = this.mAdapter.getView(i, null, this);
        }
        if (localObject != null) {
          this.mRecycler.put(i, (View)localObject);
        }
        if (localObject != null)
        {
          if (((View)localObject).getLayoutParams() == null)
          {
            this.mBlockLayoutRequests = true;
            ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
            this.mBlockLayoutRequests = false;
          }
          measureChild((View)localObject, paramInt1, paramInt2);
          j = getChildHeight((View)localObject);
          int i1 = this.mSpinnerPadding.top;
          int i2 = this.mSpinnerPadding.bottom;
          i = getChildWidth((View)localObject);
          k = this.mSpinnerPadding.left;
          m = this.mSpinnerPadding.right;
          j = j + i1 + i2;
          i = i + k + m;
          k = 0;
          break label375;
        }
      }
    }
    i = 0;
    j = 0;
    label375:
    int m = i;
    if (k != 0)
    {
      j = this.mSpinnerPadding.top;
      k = this.mSpinnerPadding.bottom + j;
      m = i;
      j = k;
      if (n == 0)
      {
        i = this.mSpinnerPadding.left;
        m = this.mSpinnerPadding.right + i;
        j = k;
      }
    }
    i = Math.max(j, getSuggestedMinimumHeight());
    j = Math.max(m, getSuggestedMinimumWidth());
    i = doResolveSizeAndState(i, paramInt2, 0);
    setMeasuredDimension(doResolveSizeAndState(j, paramInt1, 0), i);
    this.mHeightMeasureSpec = paramInt2;
    this.mWidthMeasureSpec = paramInt1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.selectedId >= 0L)
    {
      this.mDataChanged = true;
      this.mNeedSync = true;
      this.mSyncRowId = paramParcelable.selectedId;
      this.mSyncPosition = paramParcelable.position;
      this.mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.selectedId = getSelectedItemId();
    if (localSavedState.selectedId >= 0L)
    {
      localSavedState.position = getSelectedItemPosition();
      return localSavedState;
    }
    localSavedState.position = -1;
    return localSavedState;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mTouchFrame;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.mTouchFrame = new Rect();
      localObject1 = this.mTouchFrame;
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
  
  void recycleAllViews()
  {
    int j = getChildCount();
    AbsSpinner.RecycleBin localRecycleBin = this.mRecycler;
    int k = this.mFirstPosition;
    int i = 0;
    while (i < j)
    {
      localRecycleBin.put(k + i, getChildAt(i));
      i += 1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  void resetList()
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
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter != null)
    {
      localSpinnerAdapter.unregisterDataSetObserver(this.mDataSetObserver);
      resetList();
    }
    this.mAdapter = paramSpinnerAdapter;
    int i = -1;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.mAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = createObserver();
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      if (this.mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    else
    {
      checkFocus();
      resetList();
      checkSelectionChanged();
    }
    requestLayout();
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.mFirstPosition <= paramInt) && (paramInt <= this.mFirstPosition + getChildCount() - 1)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    setSelectionInt(paramInt, paramBoolean);
  }
  
  void setSelectionInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.mOldSelectedPosition)
    {
      this.mBlockLayoutRequests = true;
      int i = this.mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      layout(paramInt - i, paramBoolean);
      this.mBlockLayoutRequests = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */