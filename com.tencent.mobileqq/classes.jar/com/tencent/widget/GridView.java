package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.GridLayoutAnimationController.AnimationParameters;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

public class GridView
  extends AbsListView
{
  public static final int AUTO_FIT = -1;
  public static final int NO_STRETCH = 0;
  public static final int STRETCH_COLUMN_WIDTH = 2;
  public static final int STRETCH_SPACING = 1;
  public static final int STRETCH_SPACING_UNIFORM = 3;
  private int mColumnWidth;
  private int mGravity = 3;
  private int mHorizontalSpacing = 0;
  public boolean mIsOnMeasure = false;
  private int mNumColumns = -1;
  private View mReferenceView = null;
  private View mReferenceViewInSelectedRow = null;
  private int mRequestedColumnWidth;
  private int mRequestedHorizontalSpacing;
  private int mRequestedNumColumns;
  private int mStretchMode = 2;
  private final Rect mTempRect = new Rect();
  private int mVerticalSpacing = 0;
  
  public GridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setEdgeEffectEnabled(false);
    this.mOverscrollDistance = 2147483647;
  }
  
  private void adjustForBottomFadingEdge(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getBottom() > paramInt2) {
      offsetChildrenTopAndBottomWrap(-Math.min(paramView.getTop() - paramInt1, paramView.getBottom() - paramInt2));
    }
  }
  
  private void adjustForTopFadingEdge(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getTop() < paramInt1) {
      offsetChildrenTopAndBottomWrap(Math.min(paramInt1 - paramView.getTop(), paramInt2 - paramView.getBottom()));
    }
  }
  
  private void adjustViewsUpOrDown()
  {
    int m = getChildCount();
    if (m > 0)
    {
      boolean bool = this.mStackFromBottom;
      int j = 0;
      int k;
      int i;
      if (!bool)
      {
        k = getChildAt(0).getTop() - this.mListPadding.top;
        i = k;
        if (this.mFirstPosition != 0) {
          i = k - this.mVerticalSpacing;
        }
        if (i < 0) {
          i = j;
        }
      }
      else
      {
        k = getChildAt(m - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
        i = k;
        if (this.mFirstPosition + m < this.mItemCount) {
          i = k + this.mVerticalSpacing;
        }
        if (i > 0) {
          i = j;
        }
      }
      if (i != 0) {
        offsetChildrenTopAndBottomWrap(-i);
      }
    }
  }
  
  @TargetApi(11)
  private boolean commonKey(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.mAdapter == null) {
      return false;
    }
    if (this.mDataChanged) {
      layoutChildren();
    }
    int i = paramKeyEvent.getAction();
    if (i != 1)
    {
      if (paramInt1 != 62) {
        if (paramInt1 != 66)
        {
          if (paramInt1 != 92) {
            if (paramInt1 != 93) {
              if (paramInt1 != 122) {
                if (paramInt1 == 123) {}
              }
            }
          }
          switch (paramInt1)
          {
          default: 
            break;
          case 22: 
            if (!paramKeyEvent.hasNoModifiers()) {
              break label553;
            }
            if (resurrectSelectionIfNeeded()) {
              break;
            }
            if (!arrowScroll(66)) {
              break label553;
            }
            break;
          case 21: 
            if (!paramKeyEvent.hasNoModifiers()) {
              break label553;
            }
            if (resurrectSelectionIfNeeded()) {
              break;
            }
            if (!arrowScroll(17)) {
              break label553;
            }
            break;
          case 20: 
            if (paramKeyEvent.hasNoModifiers())
            {
              if (!resurrectSelectionIfNeeded()) {
                if (!arrowScroll(130)) {
                  break label553;
                }
              }
            }
            else
            {
              if (!paramKeyEvent.hasModifiers(2)) {
                break label553;
              }
              if (!resurrectSelectionIfNeeded()) {
                if (!fullScroll(130)) {
                  break label553;
                }
              }
            }
            break;
          case 19: 
            if (paramKeyEvent.hasNoModifiers())
            {
              if (!resurrectSelectionIfNeeded()) {
                if (!arrowScroll(33)) {
                  break label553;
                }
              }
            }
            else
            {
              if (!paramKeyEvent.hasModifiers(2)) {
                break label553;
              }
              if (!resurrectSelectionIfNeeded())
              {
                if (!fullScroll(33)) {
                  break label553;
                }
                break;
                if (!paramKeyEvent.hasNoModifiers()) {
                  break label553;
                }
                if (!resurrectSelectionIfNeeded())
                {
                  if (!fullScroll(130)) {
                    break label553;
                  }
                  break;
                  if (!paramKeyEvent.hasNoModifiers()) {
                    break label553;
                  }
                  if (!resurrectSelectionIfNeeded())
                  {
                    if (!fullScroll(33)) {
                      break label553;
                    }
                    break;
                    if (paramKeyEvent.hasNoModifiers())
                    {
                      if (!resurrectSelectionIfNeeded()) {
                        if (!pageScroll(130)) {
                          break label553;
                        }
                      }
                    }
                    else
                    {
                      if (!paramKeyEvent.hasModifiers(2)) {
                        break label553;
                      }
                      if (!resurrectSelectionIfNeeded())
                      {
                        if (!fullScroll(130)) {
                          break label553;
                        }
                        break;
                        if (paramKeyEvent.hasNoModifiers())
                        {
                          if (!resurrectSelectionIfNeeded()) {
                            if (!pageScroll(33)) {
                              break label553;
                            }
                          }
                        }
                        else
                        {
                          if (!paramKeyEvent.hasModifiers(2)) {
                            break label553;
                          }
                          if (!resurrectSelectionIfNeeded()) {
                            if (!fullScroll(33)) {
                              break label553;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        else
        {
          if (!paramKeyEvent.hasNoModifiers()) {
            break label553;
          }
          bool2 = resurrectSelectionIfNeeded();
          bool1 = bool2;
          if (bool2) {
            break label556;
          }
          bool1 = bool2;
          if (paramKeyEvent.getRepeatCount() != 0) {
            break label556;
          }
          bool1 = bool2;
          if (getChildCount() <= 0) {
            break label556;
          }
          keyPressed();
        }
      }
      while (((this.mPopup == null) || (!this.mPopup.isShowing())) && (paramKeyEvent.hasNoModifiers() ? (resurrectSelectionIfNeeded()) && (pageScroll(130)) : (paramKeyEvent.hasModifiers(1)) && ((resurrectSelectionIfNeeded()) || (pageScroll(33)))))
      {
        boolean bool2;
        bool1 = true;
        break;
      }
    }
    label553:
    boolean bool1 = false;
    label556:
    if (bool1) {
      return true;
    }
    if (sendToTextFilter(paramInt1, paramInt2, paramKeyEvent)) {
      return true;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      }
      return super.onKeyUp(paramInt1, paramKeyEvent);
    }
    return super.onKeyDown(paramInt1, paramKeyEvent);
  }
  
  private void correctTooHigh(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mFirstPosition + paramInt3 - 1 == this.mItemCount - 1) && (paramInt3 > 0))
    {
      paramInt3 = getChildAt(paramInt3 - 1).getBottom();
      int i = getBottom() - getTop() - this.mListPadding.bottom - paramInt3;
      View localView = getChildAt(0);
      int j = localView.getTop();
      if ((i > 0) && ((this.mFirstPosition > 0) || (j < this.mListPadding.top)))
      {
        paramInt3 = i;
        if (this.mFirstPosition == 0) {
          paramInt3 = Math.min(i, this.mListPadding.top - j);
        }
        offsetChildrenTopAndBottomWrap(paramInt3);
        if (this.mFirstPosition > 0)
        {
          paramInt3 = this.mFirstPosition;
          if (this.mStackFromBottom) {
            paramInt1 = 1;
          }
          fillUp(paramInt3 - paramInt1, localView.getTop() - paramInt2);
          adjustViewsUpOrDown();
        }
      }
    }
  }
  
  private void correctTooLow(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mFirstPosition == 0) && (paramInt3 > 0))
    {
      int i = getChildAt(0).getTop();
      int k = this.mListPadding.top;
      int j = getBottom() - getTop() - this.mListPadding.bottom;
      i -= k;
      View localView = getChildAt(paramInt3 - 1);
      int m = localView.getBottom();
      k = this.mFirstPosition + paramInt3 - 1;
      if ((i > 0) && ((k < this.mItemCount - 1) || (m > j)))
      {
        paramInt3 = i;
        if (k == this.mItemCount - 1) {
          paramInt3 = Math.min(i, m - j);
        }
        offsetChildrenTopAndBottomWrap(-paramInt3);
        if (k < this.mItemCount - 1)
        {
          if (!this.mStackFromBottom) {
            paramInt1 = 1;
          }
          fillDown(k + paramInt1, localView.getBottom() + paramInt2);
          adjustViewsUpOrDown();
        }
      }
    }
  }
  
  private boolean determineColumns(int paramInt)
  {
    int i = this.mRequestedHorizontalSpacing;
    int j = this.mStretchMode;
    int k = this.mRequestedColumnWidth;
    int m = this.mRequestedNumColumns;
    if (m == -1)
    {
      if (k > 0) {
        this.mNumColumns = ((paramInt + i) / (k + i));
      } else {
        this.mNumColumns = 2;
      }
    }
    else {
      this.mNumColumns = m;
    }
    if (this.mNumColumns <= 0) {
      this.mNumColumns = 1;
    }
    boolean bool = false;
    if (j != 0)
    {
      m = this.mNumColumns;
      paramInt = paramInt - m * k - (m - 1) * i;
      if (paramInt < 0) {
        bool = true;
      }
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return bool;
          }
          this.mColumnWidth = k;
          j = this.mNumColumns;
          if (j > 1)
          {
            this.mHorizontalSpacing = (i + paramInt / (j + 1));
            return bool;
          }
          this.mHorizontalSpacing = (i + paramInt);
          return bool;
        }
        this.mColumnWidth = (k + paramInt / this.mNumColumns);
        this.mHorizontalSpacing = i;
        return bool;
      }
      this.mColumnWidth = k;
      j = this.mNumColumns;
      if (j > 1)
      {
        this.mHorizontalSpacing = (i + paramInt / (j - 1));
        return bool;
      }
      this.mHorizontalSpacing = (i + paramInt);
      return bool;
    }
    this.mColumnWidth = k;
    this.mHorizontalSpacing = i;
    return false;
  }
  
  private View fillDown(int paramInt1, int paramInt2)
  {
    int m = getBottom() - getTop();
    int n = getQQGroupFlag();
    View localView2 = null;
    int i = m;
    View localView1 = localView2;
    int j = paramInt1;
    int k = paramInt2;
    if ((n & 0x22) == 34)
    {
      i = m - this.mListPadding.bottom;
      k = paramInt2;
      j = paramInt1;
      localView1 = localView2;
    }
    while ((k < i) && (j < this.mItemCount))
    {
      localView2 = makeRow(j, k, true);
      if (localView2 != null) {
        localView1 = localView2;
      }
      k = this.mReferenceView.getBottom() + this.mVerticalSpacing;
      j += this.mNumColumns;
    }
    return localView1;
  }
  
  private View fillFromBottom(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(Math.max(paramInt1, this.mSelectedPosition), this.mItemCount - 1);
    paramInt1 = this.mItemCount - 1 - paramInt1;
    return fillUp(this.mItemCount - 1 - (paramInt1 - paramInt1 % this.mNumColumns), paramInt2);
  }
  
  private View fillFromSelection(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = getVerticalFadingEdgeLength();
    int i = this.mSelectedPosition;
    int k = this.mNumColumns;
    int m = this.mVerticalSpacing;
    int j;
    if (!this.mStackFromBottom)
    {
      i -= i % k;
      j = -1;
    }
    else
    {
      i = this.mItemCount - 1 - i;
      j = this.mItemCount - 1 - (i - i % k);
      i = Math.max(0, j - k + 1);
    }
    int i1 = getTopSelectionPixel(paramInt2, n, i);
    paramInt3 = getBottomSelectionPixel(paramInt3, n, k, i);
    if (this.mStackFromBottom) {
      paramInt2 = j;
    } else {
      paramInt2 = i;
    }
    View localView1 = makeRow(paramInt2, paramInt1, true);
    this.mFirstPosition = i;
    View localView2 = this.mReferenceView;
    adjustForTopFadingEdge(localView2, i1, paramInt3);
    adjustForBottomFadingEdge(localView2, i1, paramInt3);
    if (!this.mStackFromBottom)
    {
      fillUp(i - k, localView2.getTop() - m);
      adjustViewsUpOrDown();
      fillDown(i + k, localView2.getBottom() + m);
      return localView1;
    }
    fillDown(j + k, localView2.getBottom() + m);
    adjustViewsUpOrDown();
    fillUp(i - 1, localView2.getTop() - m);
    return localView1;
  }
  
  private View fillFromTop(int paramInt)
  {
    this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
    this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
    if (this.mFirstPosition < 0) {
      this.mFirstPosition = 0;
    }
    this.mFirstPosition -= this.mFirstPosition % this.mNumColumns;
    return fillDown(this.mFirstPosition, paramInt);
  }
  
  private View fillSelection(int paramInt1, int paramInt2)
  {
    int i = reconcileSelectedPosition();
    int m = this.mNumColumns;
    int n = this.mVerticalSpacing;
    int j;
    if (!this.mStackFromBottom)
    {
      i -= i % m;
      j = -1;
    }
    else
    {
      i = this.mItemCount - 1 - i;
      j = this.mItemCount - 1 - (i - i % m);
      i = Math.max(0, j - m + 1);
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getTopSelectionPixel(paramInt1, i1, i);
    int k;
    if (this.mStackFromBottom) {
      k = j;
    } else {
      k = i;
    }
    View localView1 = makeRow(k, i2, true);
    this.mFirstPosition = i;
    View localView2 = this.mReferenceView;
    if (!this.mStackFromBottom)
    {
      fillDown(i + m, localView2.getBottom() + n);
      pinToBottom(paramInt2);
      fillUp(i - m, localView2.getTop() - n);
      adjustViewsUpOrDown();
      return localView1;
    }
    offsetChildrenTopAndBottomWrap(getBottomSelectionPixel(paramInt2, i1, m, i) - localView2.getBottom());
    fillUp(i - 1, localView2.getTop() - n);
    pinToTop(paramInt1);
    fillDown(j + m, localView2.getBottom() + n);
    adjustViewsUpOrDown();
    return localView1;
  }
  
  private View fillSpecific(int paramInt1, int paramInt2)
  {
    int k = this.mNumColumns;
    int i;
    if (!this.mStackFromBottom)
    {
      i = paramInt1 - paramInt1 % k;
      paramInt1 = -1;
    }
    else
    {
      paramInt1 = this.mItemCount - 1 - paramInt1;
      paramInt1 = this.mItemCount - 1 - (paramInt1 - paramInt1 % k);
      i = Math.max(0, paramInt1 - k + 1);
    }
    int j;
    if (this.mStackFromBottom) {
      j = paramInt1;
    } else {
      j = i;
    }
    View localView3 = makeRow(j, paramInt2, true);
    this.mFirstPosition = i;
    Object localObject1 = this.mReferenceView;
    if (localObject1 == null) {
      return null;
    }
    paramInt2 = this.mVerticalSpacing;
    Object localObject2;
    if (!this.mStackFromBottom)
    {
      localObject2 = fillUp(i - k, ((View)localObject1).getTop() - paramInt2);
      adjustViewsUpOrDown();
      localObject1 = fillDown(i + k, ((View)localObject1).getBottom() + paramInt2);
      paramInt1 = getChildCount();
      if (paramInt1 > 0) {
        correctTooHigh(k, paramInt2, paramInt1);
      }
    }
    else
    {
      View localView1 = fillDown(paramInt1 + k, ((View)localObject1).getBottom() + paramInt2);
      adjustViewsUpOrDown();
      View localView2 = fillUp(i - 1, ((View)localObject1).getTop() - paramInt2);
      paramInt1 = getChildCount();
      localObject1 = localView1;
      localObject2 = localView2;
      if (paramInt1 > 0)
      {
        correctTooLow(k, paramInt2, paramInt1);
        localObject2 = localView2;
        localObject1 = localView1;
      }
    }
    if (localView3 != null) {
      return localView3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  private View fillUp(int paramInt1, int paramInt2)
  {
    int i = getQQGroupFlag();
    Object localObject = null;
    if ((i & 0x22) == 34) {
      i = this.mListPadding.top;
    } else {
      i = 0;
    }
    while ((paramInt2 > i) && (paramInt1 >= 0))
    {
      View localView = makeRow(paramInt1, paramInt2, false);
      if (localView != null) {
        localObject = localView;
      }
      paramInt2 = this.mReferenceView.getTop() - this.mVerticalSpacing;
      this.mFirstPosition = paramInt1;
      paramInt1 -= this.mNumColumns;
    }
    if (this.mStackFromBottom) {
      this.mFirstPosition = Math.max(0, paramInt1 + 1);
    }
    return localObject;
  }
  
  private int getBottomSelectionPixel(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    if (paramInt4 + paramInt3 - 1 < this.mItemCount - 1) {
      i = paramInt1 - paramInt2;
    }
    return i;
  }
  
  private int getTopSelectionPixel(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt3 > 0) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  private boolean isCandidateSelection(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int k = i - 1;
    int j = k - paramInt1;
    boolean bool7 = this.mStackFromBottom;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    int m;
    if (!bool7)
    {
      m = this.mNumColumns;
      j = paramInt1 - paramInt1 % m;
      i = Math.max(m + j - 1, i);
    }
    else
    {
      m = this.mNumColumns;
      i = k - (j - j % m);
      j = Math.max(0, i - m + 1);
    }
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 17)
        {
          if (paramInt2 != 33)
          {
            if (paramInt2 != 66)
            {
              if (paramInt2 == 130)
              {
                if (j == 0) {
                  bool1 = true;
                }
                return bool1;
              }
              throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            bool1 = bool4;
            if (paramInt1 == j) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool5;
          if (i == k) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool6;
        if (paramInt1 == i) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (paramInt1 == j)
      {
        bool1 = bool2;
        if (j == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    bool1 = bool3;
    if (paramInt1 == i)
    {
      bool1 = bool3;
      if (i == k) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.getActiveView(paramInt1);
      if (localView != null)
      {
        setupChild(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true, paramInt4);
        return localView;
      }
    }
    View localView = obtainView(paramInt1, this.mIsScrap);
    setupChild(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.mIsScrap[0], paramInt4);
    return localView;
  }
  
  private View makeRow(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = this.mColumnWidth;
    int i1 = this.mHorizontalSpacing;
    int j = this.mListPadding.left;
    int i;
    if (this.mStretchMode == 3) {
      i = i1;
    } else {
      i = 0;
    }
    j += i;
    int n;
    if (!this.mStackFromBottom)
    {
      k = Math.min(paramInt1 + this.mNumColumns, this.mItemCount);
      i = j;
      j = k;
    }
    else
    {
      k = paramInt1 + 1;
      paramInt1 = Math.max(0, paramInt1 - this.mNumColumns + 1);
      m = k - paramInt1;
      n = this.mNumColumns;
      i = j;
      if (m < n) {
        i = j + (n - m) * (i2 + i1);
      }
      j = k;
    }
    boolean bool2 = shouldShowSelector();
    boolean bool3 = touchModeDrawsInPressedState();
    int k = this.mSelectedPosition;
    View localView = null;
    Object localObject1 = null;
    int m = paramInt1;
    while (m < j)
    {
      boolean bool1;
      if (m == k) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramBoolean) {
        n = -1;
      } else {
        n = m - paramInt1;
      }
      localView = makeAndAddView(m, paramInt2, paramBoolean, i, bool1, n);
      n = i + i2;
      i = n;
      if (m < j - 1) {
        i = n + i1;
      }
      Object localObject2 = localObject1;
      if (bool1) {
        if (!bool2)
        {
          localObject2 = localObject1;
          if (!bool3) {}
        }
        else
        {
          localObject2 = localView;
        }
      }
      m += 1;
      localObject1 = localObject2;
    }
    this.mReferenceView = localView;
    if (localObject1 != null) {
      this.mReferenceViewInSelectedRow = this.mReferenceView;
    }
    return localObject1;
  }
  
  private View moveSelection(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = getVerticalFadingEdgeLength();
    int n = this.mSelectedPosition;
    int i1 = this.mNumColumns;
    int i2 = this.mVerticalSpacing;
    boolean bool = this.mStackFromBottom;
    int m = 0;
    int k = 0;
    int i;
    if (!bool)
    {
      paramInt1 = n - paramInt1;
      j = paramInt1 - paramInt1 % i1;
      paramInt1 = n - n % i1;
      i = -1;
    }
    else
    {
      i = this.mItemCount - 1 - n;
      i = this.mItemCount - 1 - (i - i % i1);
      j = Math.max(0, i - i1 + 1);
      paramInt1 = this.mItemCount - 1 - (n - paramInt1);
      n = Math.max(0, this.mItemCount - 1 - (paramInt1 - paramInt1 % i1) - i1 + 1);
      paramInt1 = j;
      j = n;
    }
    int i4 = paramInt1 - j;
    int j = getTopSelectionPixel(paramInt2, i3, paramInt1);
    n = getBottomSelectionPixel(paramInt3, i3, i1, paramInt1);
    this.mFirstPosition = paramInt1;
    View localView1;
    View localView2;
    if (i4 > 0)
    {
      localView1 = this.mReferenceViewInSelectedRow;
      if (localView1 == null) {
        paramInt2 = k;
      } else {
        paramInt2 = localView1.getBottom();
      }
      if (this.mStackFromBottom) {
        paramInt3 = i;
      } else {
        paramInt3 = paramInt1;
      }
      localView2 = makeRow(paramInt3, paramInt2 + i2, true);
      localView1 = this.mReferenceView;
      adjustForBottomFadingEdge(localView1, j, n);
    }
    else if (i4 < 0)
    {
      localView1 = this.mReferenceViewInSelectedRow;
      if (localView1 == null) {
        paramInt2 = 0;
      } else {
        paramInt2 = localView1.getTop();
      }
      if (this.mStackFromBottom) {
        paramInt3 = i;
      } else {
        paramInt3 = paramInt1;
      }
      localView2 = makeRow(paramInt3, paramInt2 - i2, false);
      localView1 = this.mReferenceView;
      adjustForTopFadingEdge(localView1, j, n);
    }
    else
    {
      localView1 = this.mReferenceViewInSelectedRow;
      if (localView1 == null) {
        paramInt2 = m;
      } else {
        paramInt2 = localView1.getTop();
      }
      if (this.mStackFromBottom) {
        paramInt3 = i;
      } else {
        paramInt3 = paramInt1;
      }
      localView2 = makeRow(paramInt3, paramInt2, true);
      localView1 = this.mReferenceView;
    }
    if (!this.mStackFromBottom)
    {
      fillUp(paramInt1 - i1, localView1.getTop() - i2);
      adjustViewsUpOrDown();
      fillDown(paramInt1 + i1, localView1.getBottom() + i2);
      return localView2;
    }
    fillDown(i + i1, localView1.getBottom() + i2);
    adjustViewsUpOrDown();
    fillUp(paramInt1 - 1, localView1.getTop() - i2);
    return localView2;
  }
  
  private void pinToBottom(int paramInt)
  {
    int i = getChildCount();
    if (this.mFirstPosition + i == this.mItemCount)
    {
      paramInt -= getChildAt(i - 1).getBottom();
      if (paramInt > 0) {
        offsetChildrenTopAndBottomWrap(paramInt);
      }
    }
  }
  
  private void pinToTop(int paramInt)
  {
    if (this.mFirstPosition == 0)
    {
      paramInt -= getChildAt(0).getTop();
      if (paramInt < 0) {
        offsetChildrenTopAndBottomWrap(paramInt);
      }
    }
  }
  
  @TargetApi(11)
  private void setupChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    if ((paramBoolean2) && (shouldShowSelector())) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    if (paramBoolean2 != paramView.isSelected()) {
      j = 1;
    } else {
      j = 0;
    }
    int i = this.mTouchMode;
    boolean bool;
    if ((i > 0) && (i < 3) && (this.mMotionPosition == paramInt1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != paramView.isPressed()) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramBoolean3) && (j == 0) && (!paramView.isLayoutRequested())) {
      i = 0;
    } else {
      i = 1;
    }
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (AbsListView.LayoutParams)generateDefaultLayoutParams();
    }
    localLayoutParams1.viewType = this.mAdapter.getItemViewType(paramInt1);
    if ((paramBoolean3) && (!localLayoutParams1.forceAdd))
    {
      attachViewToParent(paramView, paramInt4, localLayoutParams1);
    }
    else
    {
      localLayoutParams1.forceAdd = false;
      addViewInLayout(paramView, paramInt4, localLayoutParams1, true);
    }
    if (j != 0)
    {
      paramView.setSelected(paramBoolean2);
      if (paramBoolean2) {
        requestFocus();
      }
    }
    if (k != 0) {
      paramView.setPressed(bool);
    }
    if ((this.mChoiceMode != 0) && (this.mCheckStates != null)) {
      if ((paramView instanceof Checkable)) {
        ((Checkable)paramView).setChecked(this.mCheckStates.get(paramInt1));
      } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
        paramView.setActivated(this.mCheckStates.get(paramInt1));
      }
    }
    if (i != 0)
    {
      paramInt4 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams1.height);
      paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, localLayoutParams1.width), paramInt4);
    }
    else
    {
      cleanupLayoutState(paramView);
    }
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    if (paramBoolean1) {
      paramInt4 = paramInt2;
    } else {
      paramInt4 = paramInt2 - k;
    }
    paramInt2 = this.mGravity & 0x7;
    if (paramInt2 != 1)
    {
      if ((paramInt2 != 3) && (paramInt2 == 5)) {
        paramInt2 = paramInt3 + this.mColumnWidth - j;
      } else {
        paramInt2 = paramInt3;
      }
    }
    else {
      paramInt2 = paramInt3 + (this.mColumnWidth - j) / 2;
    }
    if (i != 0)
    {
      paramView.layout(paramInt2, paramInt4, j + paramInt2, k + paramInt4);
    }
    else
    {
      paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
      paramView.offsetTopAndBottom(paramInt4 - paramView.getTop());
    }
    if (this.mCachingStarted) {
      paramView.setDrawingCacheEnabled(true);
    }
    if ((paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).scrappedFromPosition != paramInt1)) {
      paramView.jumpDrawablesToCurrentState();
    }
  }
  
  boolean arrowScroll(int paramInt)
  {
    int k = this.mSelectedPosition;
    int m = this.mNumColumns;
    boolean bool2 = this.mStackFromBottom;
    boolean bool1 = true;
    int i;
    int j;
    if (!bool2)
    {
      i = k / m * m;
      j = Math.min(i + m - 1, this.mItemCount - 1);
    }
    else
    {
      i = this.mItemCount;
      j = this.mItemCount - 1 - (i - 1 - k) / m * m;
      i = Math.max(0, j - m + 1);
    }
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if ((paramInt == 130) && (j < this.mItemCount - 1))
          {
            this.mLayoutMode = 6;
            setSelectionInt(Math.min(k + m, this.mItemCount - 1));
            break label243;
          }
        }
        else if (k < j)
        {
          this.mLayoutMode = 6;
          setSelectionInt(Math.min(k + 1, this.mItemCount - 1));
          break label243;
        }
      }
      else if (i > 0)
      {
        this.mLayoutMode = 6;
        setSelectionInt(Math.max(0, k - m));
        break label243;
      }
    }
    else if (k > i)
    {
      this.mLayoutMode = 6;
      setSelectionInt(Math.max(0, k - 1));
      break label243;
    }
    bool1 = false;
    label243:
    if (bool1)
    {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      invokeOnItemScrollListener();
    }
    if (bool1) {
      awakenScrollBars();
    }
    return bool1;
  }
  
  protected void attachLayoutAnimationParameters(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    GridLayoutAnimationController.AnimationParameters localAnimationParameters = (GridLayoutAnimationController.AnimationParameters)paramLayoutParams.layoutAnimationParameters;
    paramView = localAnimationParameters;
    if (localAnimationParameters == null)
    {
      paramView = new GridLayoutAnimationController.AnimationParameters();
      paramLayoutParams.layoutAnimationParameters = paramView;
    }
    paramView.count = paramInt2;
    paramView.index = paramInt1;
    int i = this.mNumColumns;
    paramView.columnsCount = i;
    paramView.rowsCount = (paramInt2 / i);
    if (!this.mStackFromBottom)
    {
      paramInt2 = this.mNumColumns;
      paramView.column = (paramInt1 % paramInt2);
      paramView.row = (paramInt1 / paramInt2);
      return;
    }
    paramInt1 = paramInt2 - 1 - paramInt1;
    paramInt2 = this.mNumColumns;
    paramView.column = (paramInt2 - 1 - paramInt1 % paramInt2);
    paramView.row = (paramView.rowsCount - 1 - paramInt1 / this.mNumColumns);
  }
  
  protected int computeVerticalScrollExtent()
  {
    int k = getChildCount();
    if (k > 0)
    {
      int i = this.mNumColumns;
      int j = (k + i - 1) / i * 100;
      View localView = getChildAt(0);
      int m = localView.getTop();
      int n = localView.getHeight();
      i = j;
      if (n > 0) {
        i = j + m * 100 / n;
      }
      localView = getChildAt(k - 1);
      k = localView.getBottom();
      m = localView.getHeight();
      j = i;
      if (m > 0) {
        j = i - (k - getHeight()) * 100 / m;
      }
      return j;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    if ((this.mFirstPosition >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i = localView.getTop();
      int j = localView.getHeight();
      if (j > 0)
      {
        int m = this.mNumColumns;
        int k = this.mFirstPosition / m;
        m = (this.mItemCount + m - 1) / m;
        return Math.max(k * 100 - i * 100 / j + (int)(getScrollY() / getHeight() * m * 100.0F), 0);
      }
    }
    return 0;
  }
  
  protected int computeVerticalScrollRange()
  {
    int i = this.mNumColumns;
    int k = (this.mItemCount + i - 1) / i;
    int j = Math.max(k * 100, 0);
    i = j;
    if (getScrollY() != 0) {
      i = j + Math.abs((int)(getScrollY() / getHeight() * k * 100.0F));
    }
    return i;
  }
  
  void fillGap(boolean paramBoolean)
  {
    int m = this.mNumColumns;
    int n = this.mVerticalSpacing;
    int j = getChildCount();
    int i = 0;
    if (paramBoolean)
    {
      if ((getQQGroupFlag() & 0x22) == 34) {
        i = getListPaddingTop();
      }
      if (j > 0) {
        i = getChildAt(j - 1).getBottom() + n;
      }
      int k = this.mFirstPosition + j;
      j = k;
      if (this.mStackFromBottom) {
        j = k + (m - 1);
      }
      fillDown(j, i);
      correctTooHigh(m, n, getChildCount());
      return;
    }
    if ((getQQGroupFlag() & 0x22) == 34) {
      i = getListPaddingBottom();
    } else {
      i = 0;
    }
    if (j > 0) {
      i = getChildAt(0).getTop() - n;
    } else {
      i = getHeight() - i;
    }
    j = this.mFirstPosition;
    if (!this.mStackFromBottom) {
      j -= m;
    } else {
      j -= 1;
    }
    fillUp(j, i);
    correctTooLow(m, n, getChildCount());
  }
  
  int findMotionRow(int paramInt)
  {
    int k = getChildCount();
    if (k > 0)
    {
      int j = this.mNumColumns;
      if (!this.mStackFromBottom)
      {
        i = 0;
        while (i < k)
        {
          if (paramInt <= getChildAt(i).getBottom()) {
            return this.mFirstPosition + i;
          }
          i += j;
        }
      }
      int i = k - 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getTop()) {
          return this.mFirstPosition + i;
        }
        i -= j;
      }
    }
    return -1;
  }
  
  boolean fullScroll(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 33)
    {
      this.mLayoutMode = 2;
      setSelectionInt(0);
      invokeOnItemScrollListener();
    }
    else if (paramInt == 130)
    {
      this.mLayoutMode = 2;
      setSelectionInt(this.mItemCount - 1);
      invokeOnItemScrollListener();
    }
    else
    {
      bool = false;
    }
    if (bool) {
      awakenScrollBars();
    }
    return bool;
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getColumnWidth()
  {
    return this.mColumnWidth;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public int getHorizontalSpacing()
  {
    return this.mHorizontalSpacing;
  }
  
  @ViewDebug.ExportedProperty
  public int getNumColumns()
  {
    return this.mNumColumns;
  }
  
  public int getRequestedColumnWidth()
  {
    return this.mRequestedColumnWidth;
  }
  
  public int getRequestedHorizontalSpacing()
  {
    return this.mRequestedHorizontalSpacing;
  }
  
  public int getStretchMode()
  {
    return this.mStretchMode;
  }
  
  public int getVerticalSpacing()
  {
    return this.mVerticalSpacing;
  }
  
  protected void layoutChildren()
  {
    bool1 = this.mBlockLayoutRequests;
    if (!bool1) {
      this.mBlockLayoutRequests = true;
    }
    try
    {
      super.layoutChildren();
      invalidate();
      if (this.mAdapter == null)
      {
        resetList();
        invokeOnItemScrollListener();
        if (!bool1) {
          this.mBlockLayoutRequests = false;
        }
        return;
      }
      i = this.mListPadding.top;
      m = getBottom() - getTop() - this.mListPadding.bottom;
      n = getChildCount();
      j = this.mLayoutMode;
      localObject5 = null;
      localObject6 = null;
      switch (j)
      {
      }
    }
    finally
    {
      for (;;)
      {
        int m;
        int n;
        Object localObject5;
        Object localObject6;
        Object localObject1;
        label253:
        boolean bool2;
        int i1;
        int k;
        label714:
        if (!bool1) {
          this.mBlockLayoutRequests = false;
        }
        for (;;)
        {
          throw localObject2;
        }
        continue;
        Object localObject3 = null;
        Object localObject4 = localObject3;
        int j = 0;
        continue;
        localObject3 = null;
        continue;
        continue;
        j = 0;
        continue;
        j = -1;
        continue;
        int i = j;
        continue;
        i = -1;
      }
    }
    j = this.mSelectedPosition;
    if (this.mNextSelectedPosition >= 0)
    {
      j = this.mNextSelectedPosition - this.mSelectedPosition;
      localObject1 = null;
      localObject4 = localObject1;
      localObject5 = localObject6;
      break label253;
      j = this.mNextSelectedPosition - this.mFirstPosition;
      if ((j >= 0) && (j < n))
      {
        localObject5 = getChildAt(j);
        localObject1 = null;
        localObject4 = localObject1;
        break label887;
        j -= this.mFirstPosition;
        if ((j < 0) || (j >= n)) {
          break label892;
        }
        localObject1 = getChildAt(j);
        localObject6 = getChildAt(0);
        localObject4 = localObject1;
        localObject1 = localObject6;
        break label887;
        bool2 = this.mDataChanged;
        if (bool2) {
          handleDataChanged();
        }
        if (this.mItemCount == 0)
        {
          resetList();
          invokeOnItemScrollListener();
          if (!bool1) {
            this.mBlockLayoutRequests = false;
          }
          return;
        }
        setSelectedPositionInt(this.mNextSelectedPosition);
        i1 = this.mFirstPosition;
        localObject6 = this.mRecycler;
        if (bool2)
        {
          k = 0;
          while (k < n)
          {
            ((AbsListView.RecycleBin)localObject6).addScrapView(getChildAt(k), i1 + k);
            k += 1;
          }
        }
        ((AbsListView.RecycleBin)localObject6).fillActiveViews(n, i1);
        detachAllViewsFromParent();
        switch (this.mLayoutMode)
        {
        case 6: 
          if (n == 0)
          {
            bool2 = this.mStackFromBottom;
            break;
            localObject1 = moveSelection(j, i, m);
          }
          break;
        case 5: 
          localObject1 = fillSpecific(this.mSyncPosition, this.mSpecificTop);
          break;
        case 4: 
          localObject1 = fillSpecific(this.mSelectedPosition, this.mSpecificTop);
          break;
        case 3: 
          localObject1 = fillUp(this.mItemCount - 1, m);
          adjustViewsUpOrDown();
          break;
        case 2: 
          if (localObject5 != null) {
            localObject1 = fillFromSelection(((View)localObject5).getTop(), i, m);
          } else {
            localObject1 = fillSelection(i, m);
          }
          break;
        case 1: 
          this.mFirstPosition = 0;
          localObject1 = fillFromTop(i);
          adjustViewsUpOrDown();
          break label714;
          if (!bool2)
          {
            if (this.mAdapter == null) {
              break label906;
            }
            if (!isInTouchMode()) {
              break label901;
            }
            break label906;
            setSelectedPositionInt(j);
            localObject1 = fillFromTop(i);
          }
          else
          {
            j = this.mItemCount - 1;
            if (this.mAdapter == null) {
              break label916;
            }
            if (!isInTouchMode()) {
              break label911;
            }
            break label916;
            setSelectedPositionInt(i);
            localObject1 = fillFromBottom(j, m);
            break label714;
            if ((this.mSelectedPosition >= 0) && (this.mSelectedPosition < this.mItemCount))
            {
              j = this.mSelectedPosition;
              if (localObject4 != null) {
                i = localObject4.getTop();
              }
              localObject1 = fillSpecific(j, i);
            }
            else if (this.mFirstPosition < this.mItemCount)
            {
              j = this.mFirstPosition;
              if (localObject1 != null) {
                i = ((View)localObject1).getTop();
              }
              localObject1 = fillSpecific(j, i);
            }
            else
            {
              localObject1 = fillSpecific(0, i);
            }
          }
          ((AbsListView.RecycleBin)localObject6).scrapActiveViews();
          if (localObject1 != null)
          {
            positionSelector(-1, (View)localObject1);
            this.mSelectedTop = ((View)localObject1).getTop();
          }
          else if ((this.mTouchMode > 0) && (this.mTouchMode < 3))
          {
            localObject1 = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (localObject1 != null) {
              positionSelector(this.mMotionPosition, (View)localObject1);
            }
          }
          else
          {
            this.mSelectedTop = 0;
            this.mSelectorRect.setEmpty();
          }
          this.mLayoutMode = 0;
          this.mDataChanged = false;
          this.mNeedSync = false;
          setNextSelectedPositionInt(this.mSelectedPosition);
          updateScrollIndicators();
          if (this.mItemCount > 0) {
            checkSelectionChanged();
          }
          invokeOnItemScrollListener();
          if (!bool1) {
            this.mBlockLayoutRequests = false;
          }
          return;
        }
      }
    }
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    if (this.mAdapter != null)
    {
      if (isInTouchMode()) {
        return -1;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= this.mItemCount) {
          return -1;
        }
        return paramInt;
      }
    }
    return -1;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    int j = -1;
    int m = j;
    if (paramBoolean)
    {
      m = j;
      if (paramRect != null)
      {
        paramRect.offset(getScrollX(), getScrollY());
        Rect localRect = this.mTempRect;
        int k = 2147483647;
        int i1 = getChildCount();
        int i = 0;
        for (;;)
        {
          m = j;
          if (i >= i1) {
            break;
          }
          if (!isCandidateSelection(i, paramInt))
          {
            m = k;
          }
          else
          {
            View localView = getChildAt(i);
            localView.getDrawingRect(localRect);
            offsetDescendantRectToMyCoords(localView, localRect);
            int n = getDistance(paramRect, localRect, paramInt);
            m = k;
            if (n < k)
            {
              j = i;
              m = n;
            }
          }
          i += 1;
          k = m;
        }
      }
    }
    if (m >= 0)
    {
      setSelection(m + this.mFirstPosition);
      return;
    }
    requestLayout();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(GridView.class.getName());
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(GridView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt, 1, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt, 1, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mIsOnMeasure = true;
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = i;
    if (i1 == 0)
    {
      paramInt2 = this.mColumnWidth;
      if (paramInt2 > 0)
      {
        paramInt2 += this.mListPadding.left;
        i = this.mListPadding.right;
      }
      else
      {
        paramInt2 = this.mListPadding.left;
        i = this.mListPadding.right;
      }
      paramInt2 = paramInt2 + i + getVerticalScrollbarWidth();
    }
    boolean bool = determineColumns(paramInt2 - this.mListPadding.left - this.mListPadding.right);
    if (this.mAdapter == null) {
      i = 0;
    } else {
      i = this.mAdapter.getCount();
    }
    this.mItemCount = i;
    int i2 = this.mItemCount;
    int m;
    if (i2 > 0)
    {
      View localView = obtainView(0, this.mIsScrap);
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)localView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = (AbsListView.LayoutParams)generateDefaultLayoutParams();
        localView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.viewType = this.mAdapter.getItemViewType(0);
      localLayoutParams1.forceAdd = true;
      i = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams1.height);
      localView.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, localLayoutParams1.width), i);
      i = localView.getMeasuredHeight();
      m = i;
      if (this.mRecycler.shouldRecycleViewType(localLayoutParams1.viewType))
      {
        this.mRecycler.addScrapView(localView, -1);
        m = i;
      }
    }
    else
    {
      m = 0;
    }
    i = j;
    if (k == 0) {
      i = this.mListPadding.top + this.mListPadding.bottom + m + getVerticalFadingEdgeLength() * 2;
    }
    j = i;
    if (k == -2147483648)
    {
      j = this.mListPadding.top;
      k = this.mListPadding.bottom;
      int i3 = this.mNumColumns;
      k = j + k;
      int n = 0;
      while (n < i2)
      {
        k += m;
        n += i3;
        j = k;
        if (n < i2) {
          j = k + this.mVerticalSpacing;
        }
        k = j;
        if (j >= i)
        {
          j = i;
          break label447;
        }
      }
      j = k;
    }
    label447:
    i = paramInt2;
    if (i1 == -2147483648)
    {
      k = this.mRequestedNumColumns;
      i = paramInt2;
      if (k != -1) {
        if (this.mColumnWidth * k + (k - 1) * this.mHorizontalSpacing + this.mListPadding.left + this.mListPadding.right <= paramInt2)
        {
          i = paramInt2;
          if (!bool) {}
        }
        else
        {
          i = paramInt2 | 0x1000000;
        }
      }
    }
    setMeasuredDimension(i, j);
    this.mWidthMeasureSpec = paramInt1;
    this.mIsOnMeasure = false;
  }
  
  boolean pageScroll(int paramInt)
  {
    if (paramInt == 33) {
      paramInt = Math.max(0, this.mSelectedPosition - getChildCount());
    } else if (paramInt == 130) {
      paramInt = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount());
    } else {
      paramInt = -1;
    }
    if (paramInt >= 0)
    {
      setSelectionInt(paramInt);
      invokeOnItemScrollListener();
      awakenScrollBars();
      return true;
    }
    return false;
  }
  
  boolean sequenceScroll(int paramInt)
  {
    int m = this.mSelectedPosition;
    int i1 = this.mNumColumns;
    int n = this.mItemCount;
    boolean bool1 = this.mStackFromBottom;
    int k = 0;
    boolean bool2 = true;
    int i;
    int j;
    if (!bool1)
    {
      i = m / i1 * i1;
      j = Math.min(i1 + i - 1, n - 1);
    }
    else
    {
      i = n - 1;
      j = i - (i - m) / i1 * i1;
      i = Math.max(0, j - i1 + 1);
    }
    if (paramInt != 1)
    {
      if ((paramInt == 2) && (m < n - 1))
      {
        this.mLayoutMode = 6;
        setSelectionInt(m + 1);
        bool1 = bool2;
        if (m != j) {
          break label181;
        }
      }
    }
    else {
      for (;;)
      {
        k = 1;
        bool1 = bool2;
        break label181;
        if (m <= 0) {
          break;
        }
        this.mLayoutMode = 6;
        setSelectionInt(m - 1);
        bool1 = bool2;
        if (m != i) {
          break label181;
        }
      }
    }
    bool1 = false;
    label181:
    if (bool1)
    {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      invokeOnItemScrollListener();
    }
    if (k != 0) {
      awakenScrollBars();
    }
    return bool1;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.mAdapter != null) && (this.mDataSetObserver != null)) {
      this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
    }
    resetList();
    this.mRecycler.clear();
    this.mAdapter = paramListAdapter;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    super.setAdapter(paramListAdapter);
    if (this.mAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      this.mDataChanged = true;
      checkFocus();
      this.mDataSetObserver = new AbsListView.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
      int i;
      if (this.mStackFromBottom) {
        i = lookForSelectablePosition(this.mItemCount - 1, false);
      } else {
        i = lookForSelectablePosition(0, true);
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
    }
    else
    {
      checkFocus();
      checkSelectionChanged();
    }
    requestLayout();
  }
  
  public void setColumnWidth(int paramInt)
  {
    if (paramInt != this.mRequestedColumnWidth)
    {
      this.mRequestedColumnWidth = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    if (paramInt != this.mRequestedHorizontalSpacing)
    {
      this.mRequestedHorizontalSpacing = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.mRequestedNumColumns)
    {
      this.mRequestedNumColumns = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void setSelection(int paramInt)
  {
    if (!isInTouchMode()) {
      setNextSelectedPositionInt(paramInt);
    } else {
      this.mResurrectToPosition = paramInt;
    }
    this.mLayoutMode = 2;
    if (this.mPositionScroller != null) {
      this.mPositionScroller.stop();
    }
    requestLayout();
  }
  
  void setSelectionInt(int paramInt)
  {
    int j = this.mNextSelectedPosition;
    if (this.mPositionScroller != null) {
      this.mPositionScroller.stop();
    }
    setNextSelectedPositionInt(paramInt);
    layoutChildren();
    if (this.mStackFromBottom) {
      paramInt = this.mItemCount - 1 - this.mNextSelectedPosition;
    } else {
      paramInt = this.mNextSelectedPosition;
    }
    int i = j;
    if (this.mStackFromBottom) {
      i = this.mItemCount - 1 - j;
    }
    j = this.mNumColumns;
    if (paramInt / j != i / j) {
      awakenScrollBars();
    }
  }
  
  public void setStretchMode(int paramInt)
  {
    if (paramInt != this.mStretchMode)
    {
      this.mStretchMode = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    if (paramInt != this.mVerticalSpacing)
    {
      this.mVerticalSpacing = paramInt;
      requestLayoutIfNecessary();
    }
  }
  
  public void smoothScrollByOffset(int paramInt)
  {
    super.smoothScrollByOffset(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    super.smoothScrollToPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.GridView
 * JD-Core Version:    0.7.0.1
 */