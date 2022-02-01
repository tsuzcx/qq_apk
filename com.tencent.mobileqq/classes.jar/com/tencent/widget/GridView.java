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
import com.tencent.util.VersionUtils;

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
  private int mHorizontalSpacing;
  public boolean mIsOnMeasure;
  private int mNumColumns = -1;
  private View mReferenceView;
  private View mReferenceViewInSelectedRow;
  private int mRequestedColumnWidth;
  private int mRequestedHorizontalSpacing;
  private int mRequestedNumColumns;
  private int mStretchMode = 2;
  private final Rect mTempRect = new Rect();
  private int mVerticalSpacing;
  
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
      offsetChildrenTopAndBottom(-Math.min(paramView.getTop() - paramInt1, paramView.getBottom() - paramInt2));
    }
  }
  
  private void adjustForTopFadingEdge(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getTop() < paramInt1) {
      offsetChildrenTopAndBottom(Math.min(paramInt1 - paramView.getTop(), paramInt2 - paramView.getBottom()));
    }
  }
  
  private void adjustViewsUpOrDown()
  {
    int k = 0;
    int m = getChildCount();
    int j;
    int i;
    if (m > 0)
    {
      if (this.mStackFromBottom) {
        break label72;
      }
      j = getChildAt(0).getTop() - this.mListPadding.top;
      i = j;
      if (this.mFirstPosition != 0) {
        i = j - this.mVerticalSpacing;
      }
      j = i;
      if (i >= 0) {
        break label128;
      }
      j = k;
    }
    label128:
    for (;;)
    {
      if (j != 0) {
        offsetChildrenTopAndBottom(-j);
      }
      return;
      label72:
      j = getChildAt(m - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
      i = j;
      if (m + this.mFirstPosition < this.mItemCount) {
        i = j + this.mVerticalSpacing;
      }
      j = k;
      if (i <= 0) {
        j = i;
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
    if (i != 1) {}
    int j;
    switch (paramInt1)
    {
    default: 
      j = 0;
    }
    for (;;)
    {
      if (j == 0) {
        break label804;
      }
      return true;
      if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
        break;
      }
      if ((resurrectSelectionIfNeeded()) || (arrowScroll(17)))
      {
        j = 1;
      }
      else
      {
        j = 0;
        continue;
        if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
          break;
        }
        if ((resurrectSelectionIfNeeded()) || (arrowScroll(66)))
        {
          j = 1;
        }
        else
        {
          j = 0;
          continue;
          if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
          {
            if ((resurrectSelectionIfNeeded()) || (arrowScroll(33))) {
              j = 1;
            } else {
              j = 0;
            }
          }
          else
          {
            if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
              break;
            }
            if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
            {
              j = 1;
            }
            else
            {
              j = 0;
              continue;
              if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
              {
                if ((resurrectSelectionIfNeeded()) || (arrowScroll(130))) {
                  j = 1;
                } else {
                  j = 0;
                }
              }
              else
              {
                if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                  break;
                }
                if ((resurrectSelectionIfNeeded()) || (fullScroll(130)))
                {
                  j = 1;
                }
                else
                {
                  j = 0;
                  continue;
                  if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                    break;
                  }
                  boolean bool = resurrectSelectionIfNeeded();
                  j = bool;
                  if (!bool)
                  {
                    j = bool;
                    if (paramKeyEvent.getRepeatCount() == 0)
                    {
                      j = bool;
                      if (getChildCount() > 0)
                      {
                        keyPressed();
                        j = 1;
                        continue;
                        if ((this.mPopup != null) && (this.mPopup.isShowing())) {
                          break;
                        }
                        if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
                        {
                          if ((resurrectSelectionIfNeeded()) || (pageScroll(130))) {
                            j = 1;
                          } else {
                            j = 0;
                          }
                        }
                        else
                        {
                          if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(1))) {
                            break;
                          }
                          if ((resurrectSelectionIfNeeded()) || (pageScroll(33)))
                          {
                            j = 1;
                          }
                          else
                          {
                            j = 0;
                            continue;
                            if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
                            {
                              if ((resurrectSelectionIfNeeded()) || (pageScroll(33))) {
                                j = 1;
                              } else {
                                j = 0;
                              }
                            }
                            else
                            {
                              if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                                break;
                              }
                              if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
                              {
                                j = 1;
                              }
                              else
                              {
                                j = 0;
                                continue;
                                if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
                                {
                                  if ((resurrectSelectionIfNeeded()) || (pageScroll(130))) {
                                    j = 1;
                                  } else {
                                    j = 0;
                                  }
                                }
                                else
                                {
                                  if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                                    break;
                                  }
                                  if ((resurrectSelectionIfNeeded()) || (fullScroll(130)))
                                  {
                                    j = 1;
                                  }
                                  else
                                  {
                                    j = 0;
                                    continue;
                                    if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                                      break;
                                    }
                                    if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
                                    {
                                      j = 1;
                                    }
                                    else
                                    {
                                      j = 0;
                                      continue;
                                      if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                                        break;
                                      }
                                      if ((resurrectSelectionIfNeeded()) || (fullScroll(130))) {
                                        j = 1;
                                      } else {
                                        j = 0;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label804:
    if (sendToTextFilter(paramInt1, paramInt2, paramKeyEvent)) {
      return true;
    }
    switch (i)
    {
    default: 
      return false;
    case 0: 
      return super.onKeyDown(paramInt1, paramKeyEvent);
    case 1: 
      return super.onKeyUp(paramInt1, paramKeyEvent);
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  private void correctTooHigh(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mFirstPosition + paramInt3 - 1 == this.mItemCount - 1) && (paramInt3 > 0))
    {
      paramInt3 = getChildAt(paramInt3 - 1).getBottom();
      int i = this.mBottom - this.mTop - this.mListPadding.bottom - paramInt3;
      View localView = getChildAt(0);
      int j = localView.getTop();
      if ((i > 0) && ((this.mFirstPosition > 0) || (j < this.mListPadding.top)))
      {
        paramInt3 = i;
        if (this.mFirstPosition == 0) {
          paramInt3 = Math.min(i, this.mListPadding.top - j);
        }
        offsetChildrenTopAndBottom(paramInt3);
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
      int j = this.mBottom - this.mTop - this.mListPadding.bottom;
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
        offsetChildrenTopAndBottom(-paramInt3);
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
    boolean bool = false;
    if (this.mRequestedNumColumns == -1) {
      if (k > 0) {
        this.mNumColumns = ((paramInt + i) / (k + i));
      }
    }
    for (;;)
    {
      if (this.mNumColumns <= 0) {
        this.mNumColumns = 1;
      }
      switch (j)
      {
      default: 
        paramInt = paramInt - this.mNumColumns * k - (this.mNumColumns - 1) * i;
        if (paramInt < 0) {
          bool = true;
        }
        switch (j)
        {
        default: 
          return bool;
          this.mNumColumns = 2;
          continue;
          this.mNumColumns = this.mRequestedNumColumns;
        }
        break;
      }
    }
    this.mColumnWidth = k;
    this.mHorizontalSpacing = i;
    return false;
    this.mColumnWidth = (paramInt / this.mNumColumns + k);
    this.mHorizontalSpacing = i;
    return bool;
    this.mColumnWidth = k;
    if (this.mNumColumns > 1)
    {
      this.mHorizontalSpacing = (paramInt / (this.mNumColumns - 1) + i);
      return bool;
    }
    this.mHorizontalSpacing = (i + paramInt);
    return bool;
    this.mColumnWidth = k;
    if (this.mNumColumns > 1)
    {
      this.mHorizontalSpacing = (paramInt / (this.mNumColumns + 1) + i);
      return bool;
    }
    this.mHorizontalSpacing = (i + paramInt);
    return bool;
  }
  
  private View fillDown(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i = this.mBottom - this.mTop;
    if ((this.mGroupFlags & 0x22) == 34) {
      i -= this.mListPadding.bottom;
    }
    for (;;)
    {
      if ((paramInt2 < i) && (paramInt1 < this.mItemCount))
      {
        View localView = makeRow(paramInt1, paramInt2, true);
        if (localView == null) {
          break label92;
        }
        localObject = localView;
      }
      label92:
      for (;;)
      {
        paramInt2 = this.mReferenceView.getBottom() + this.mVerticalSpacing;
        paramInt1 += this.mNumColumns;
        break;
        return localObject;
      }
    }
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
    int j = this.mSelectedPosition;
    int k = this.mNumColumns;
    int m = this.mVerticalSpacing;
    int i = -1;
    int i1;
    if (!this.mStackFromBottom)
    {
      j -= j % k;
      i1 = getTopSelectionPixel(paramInt2, n, j);
      paramInt3 = getBottomSelectionPixel(paramInt3, n, k, j);
      if (!this.mStackFromBottom) {
        break label210;
      }
    }
    View localView1;
    View localView2;
    label210:
    for (paramInt2 = i;; paramInt2 = j)
    {
      localView1 = makeRow(paramInt2, paramInt1, true);
      this.mFirstPosition = j;
      localView2 = this.mReferenceView;
      adjustForTopFadingEdge(localView2, i1, paramInt3);
      adjustForBottomFadingEdge(localView2, i1, paramInt3);
      if (this.mStackFromBottom) {
        break label216;
      }
      fillUp(j - k, localView2.getTop() - m);
      adjustViewsUpOrDown();
      fillDown(j + k, localView2.getBottom() + m);
      return localView1;
      i = this.mItemCount - 1 - j;
      i = this.mItemCount - 1 - (i - i % k);
      j = Math.max(0, i - k + 1);
      break;
    }
    label216:
    fillDown(i + k, localView2.getBottom() + m);
    adjustViewsUpOrDown();
    fillUp(j - 1, localView2.getTop() - m);
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
    int j = reconcileSelectedPosition();
    int m = this.mNumColumns;
    int n = this.mVerticalSpacing;
    int i = -1;
    int i1;
    int i2;
    if (!this.mStackFromBottom)
    {
      j -= j % m;
      i1 = getVerticalFadingEdgeLength();
      i2 = getTopSelectionPixel(paramInt1, i1, j);
      if (!this.mStackFromBottom) {
        break label181;
      }
    }
    View localView1;
    View localView2;
    label181:
    for (int k = i;; k = j)
    {
      localView1 = makeRow(k, i2, true);
      this.mFirstPosition = j;
      localView2 = this.mReferenceView;
      if (this.mStackFromBottom) {
        break label188;
      }
      fillDown(j + m, localView2.getBottom() + n);
      pinToBottom(paramInt2);
      fillUp(j - m, localView2.getTop() - n);
      adjustViewsUpOrDown();
      return localView1;
      i = this.mItemCount - 1 - j;
      i = this.mItemCount - 1 - (i - i % m);
      j = Math.max(0, i - m + 1);
      break;
    }
    label188:
    offsetChildrenTopAndBottom(getBottomSelectionPixel(paramInt2, i1, m, j) - localView2.getBottom());
    fillUp(j - 1, localView2.getTop() - n);
    pinToTop(paramInt1);
    fillDown(i + m, localView2.getBottom() + n);
    adjustViewsUpOrDown();
    return localView1;
  }
  
  private View fillSpecific(int paramInt1, int paramInt2)
  {
    int k = this.mNumColumns;
    int j = -1;
    int i;
    label36:
    View localView3;
    Object localObject1;
    Object localObject2;
    if (!this.mStackFromBottom)
    {
      i = paramInt1 - paramInt1 % k;
      paramInt1 = j;
      if (!this.mStackFromBottom) {
        break label105;
      }
      j = paramInt1;
      localView3 = makeRow(j, paramInt2, true);
      this.mFirstPosition = i;
      localObject1 = this.mReferenceView;
      if (localObject1 != null) {
        break label111;
      }
      localObject2 = null;
    }
    label105:
    label111:
    View localView1;
    do
    {
      return localObject2;
      paramInt1 = this.mItemCount - 1 - paramInt1;
      paramInt1 = this.mItemCount - 1 - (paramInt1 - paramInt1 % k);
      i = Math.max(0, paramInt1 - k + 1);
      break;
      j = i;
      break label36;
      paramInt2 = this.mVerticalSpacing;
      if (!this.mStackFromBottom)
      {
        localObject2 = fillUp(i - k, ((View)localObject1).getTop() - paramInt2);
        adjustViewsUpOrDown();
        View localView2 = fillDown(i + k, ((View)localObject1).getBottom() + paramInt2);
        paramInt1 = getChildCount();
        localObject1 = localObject2;
        localView1 = localView2;
        if (paramInt1 > 0)
        {
          correctTooHigh(k, paramInt2, paramInt1);
          localView1 = localView2;
          localObject1 = localObject2;
        }
      }
      while (localView3 != null)
      {
        return localView3;
        localView1 = fillDown(paramInt1 + k, ((View)localObject1).getBottom() + paramInt2);
        adjustViewsUpOrDown();
        localObject1 = fillUp(i - 1, ((View)localObject1).getTop() - paramInt2);
        paramInt1 = getChildCount();
        if (paramInt1 > 0) {
          correctTooLow(k, paramInt2, paramInt1);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return localView1;
  }
  
  private View fillUp(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i;
    if ((this.mGroupFlags & 0x22) == 34) {
      i = this.mListPadding.top;
    }
    for (;;)
    {
      if ((paramInt2 > i) && (paramInt1 >= 0))
      {
        View localView = makeRow(paramInt1, paramInt2, false);
        if (localView == null) {
          break label99;
        }
        localObject = localView;
      }
      label99:
      for (;;)
      {
        paramInt2 = this.mReferenceView.getTop() - this.mVerticalSpacing;
        this.mFirstPosition = paramInt1;
        paramInt1 -= this.mNumColumns;
        break;
        if (this.mStackFromBottom) {
          this.mFirstPosition = Math.max(0, paramInt1 + 1);
        }
        return localObject;
      }
      i = 0;
    }
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
    int k = getChildCount();
    int i = k - 1 - paramInt1;
    int j;
    if (!this.mStackFromBottom)
    {
      j = paramInt1 - paramInt1 % this.mNumColumns;
      i = Math.max(this.mNumColumns + j - 1, k);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        i = k - 1 - (i - i % this.mNumColumns);
        j = Math.max(0, i - this.mNumColumns + 1);
      }
    }
    if (paramInt1 == j) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              return false;
            } while (j == 0);
            return false;
          } while (paramInt1 == i);
          return false;
        } while (i == k - 1);
        return false;
      } while ((paramInt1 == j) && (j == 0));
      return false;
    } while ((paramInt1 == i) && (i == k - 1));
    return false;
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
    int i1 = this.mColumnWidth;
    int n = this.mHorizontalSpacing;
    int j = this.mListPadding.left;
    int i;
    int k;
    if (this.mStretchMode == 3)
    {
      i = n;
      j = i + j;
      if (this.mStackFromBottom) {
        break label191;
      }
      k = Math.min(this.mNumColumns + paramInt1, this.mItemCount);
      i = paramInt1;
      paramInt1 = k;
    }
    for (;;)
    {
      label68:
      Object localObject = null;
      boolean bool2 = shouldShowSelector();
      boolean bool3 = touchModeDrawsInPressedState();
      int i2 = this.mSelectedPosition;
      View localView = null;
      k = i;
      label96:
      boolean bool1;
      label112:
      int m;
      if (k < paramInt1) {
        if (k == i2)
        {
          bool1 = true;
          if (!paramBoolean) {
            break label259;
          }
          m = -1;
          label119:
          localView = makeAndAddView(k, paramInt2, paramBoolean, j, bool1, m);
          j += i1;
          if (k >= paramInt1 - 1) {
            break label294;
          }
          j += n;
        }
      }
      label259:
      label294:
      for (;;)
      {
        if ((bool1) && ((bool2) || (bool3))) {
          localObject = localView;
        }
        for (;;)
        {
          k += 1;
          break label96;
          i = 0;
          break;
          label191:
          i = paramInt1 + 1;
          k = Math.max(0, paramInt1 - this.mNumColumns + 1);
          if (i - k >= this.mNumColumns) {
            break label297;
          }
          j += (this.mNumColumns - (i - k)) * (i1 + n);
          paramInt1 = i;
          i = k;
          break label68;
          bool1 = false;
          break label112;
          m = k - i;
          break label119;
          this.mReferenceView = localView;
          if (localObject != null) {
            this.mReferenceViewInSelectedRow = this.mReferenceView;
          }
          return localObject;
        }
      }
      label297:
      paramInt1 = i;
      i = k;
    }
  }
  
  private View moveSelection(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int i2 = getVerticalFadingEdgeLength();
    int i3 = this.mSelectedPosition;
    int n = this.mNumColumns;
    int i1 = this.mVerticalSpacing;
    int m = -1;
    int j;
    int i;
    if (!this.mStackFromBottom)
    {
      j = i3 - paramInt1 - (i3 - paramInt1) % n;
      i = i3 - i3 % n;
      paramInt1 = m;
      i3 = i - j;
      j = getTopSelectionPixel(paramInt2, i2, i);
      m = getBottomSelectionPixel(paramInt3, i2, n, i);
      this.mFirstPosition = i;
      if (i3 <= 0) {
        break label306;
      }
      if (this.mReferenceViewInSelectedRow != null) {
        break label289;
      }
      paramInt2 = 0;
      label115:
      if (!this.mStackFromBottom) {
        break label300;
      }
    }
    View localView2;
    View localView1;
    label289:
    label300:
    for (paramInt3 = paramInt1;; paramInt3 = i)
    {
      localView2 = makeRow(paramInt3, paramInt2 + i1, true);
      localView1 = this.mReferenceView;
      adjustForBottomFadingEdge(localView1, j, m);
      if (this.mStackFromBottom) {
        break label431;
      }
      fillUp(i - n, localView1.getTop() - i1);
      adjustViewsUpOrDown();
      fillDown(i + n, localView1.getBottom() + i1);
      return localView2;
      i = this.mItemCount - 1 - i3;
      j = this.mItemCount - 1 - (i - i % n);
      i = Math.max(0, j - n + 1);
      paramInt1 = this.mItemCount - 1 - (i3 - paramInt1);
      m = Math.max(0, this.mItemCount - 1 - (paramInt1 - paramInt1 % n) - n + 1);
      paramInt1 = j;
      j = m;
      break;
      paramInt2 = this.mReferenceViewInSelectedRow.getBottom();
      break label115;
    }
    label306:
    if (i3 < 0)
    {
      if (this.mReferenceViewInSelectedRow == null)
      {
        paramInt2 = 0;
        label320:
        if (!this.mStackFromBottom) {
          break label371;
        }
      }
      label371:
      for (paramInt3 = paramInt1;; paramInt3 = i)
      {
        localView2 = makeRow(paramInt3, paramInt2 - i1, false);
        localView1 = this.mReferenceView;
        adjustForTopFadingEdge(localView1, j, m);
        break;
        paramInt2 = this.mReferenceViewInSelectedRow.getTop();
        break label320;
      }
    }
    if (this.mReferenceViewInSelectedRow == null)
    {
      paramInt2 = k;
      label387:
      if (!this.mStackFromBottom) {
        break label425;
      }
    }
    label425:
    for (paramInt3 = paramInt1;; paramInt3 = i)
    {
      localView2 = makeRow(paramInt3, paramInt2, true);
      localView1 = this.mReferenceView;
      break;
      paramInt2 = this.mReferenceViewInSelectedRow.getTop();
      break label387;
    }
    label431:
    fillDown(paramInt1 + n, localView1.getBottom() + i1);
    adjustViewsUpOrDown();
    fillUp(i - 1, localView1.getTop() - i1);
    return localView2;
  }
  
  private void pinToBottom(int paramInt)
  {
    int i = getChildCount();
    if (this.mFirstPosition + i == this.mItemCount)
    {
      paramInt -= getChildAt(i - 1).getBottom();
      if (paramInt > 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  private void pinToTop(int paramInt)
  {
    if (this.mFirstPosition == 0)
    {
      paramInt -= getChildAt(0).getTop();
      if (paramInt < 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  @TargetApi(11)
  private void setupChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    int j;
    label27:
    int i;
    boolean bool;
    label55:
    int k;
    label67:
    label87:
    AbsListView.LayoutParams localLayoutParams;
    if ((paramBoolean2) && (shouldShowSelector()))
    {
      paramBoolean2 = true;
      if (paramBoolean2 == paramView.isSelected()) {
        break label400;
      }
      j = 1;
      i = this.mTouchMode;
      if ((i <= 0) || (i >= 3) || (this.mMotionPosition != paramInt1)) {
        break label406;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label412;
      }
      k = 1;
      if ((paramBoolean3) && (j == 0) && (!paramView.isLayoutRequested())) {
        break label418;
      }
      i = 1;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label545;
      }
      localLayoutParams = (AbsListView.LayoutParams)generateDefaultLayoutParams();
    }
    label147:
    label283:
    label412:
    label545:
    for (;;)
    {
      localLayoutParams.viewType = this.mAdapter.getItemViewType(paramInt1);
      if ((paramBoolean3) && (!localLayoutParams.forceAdd))
      {
        attachViewToParent(paramView, paramInt4, localLayoutParams);
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
        if ((this.mChoiceMode != 0) && (this.mCheckStates != null))
        {
          if (!(paramView instanceof Checkable)) {
            break label444;
          }
          ((Checkable)paramView).setChecked(this.mCheckStates.get(paramInt1));
        }
        label217:
        if (i == 0) {
          break label474;
        }
        paramInt4 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, localLayoutParams.width), paramInt4);
        j = paramView.getMeasuredWidth();
        k = paramView.getMeasuredHeight();
        if (!paramBoolean1) {
          break label482;
        }
        paramInt4 = paramInt2;
        paramInt2 = paramInt3;
        switch (this.mGravity & 0x7)
        {
        default: 
          paramInt2 = paramInt3;
        case 2: 
        case 3: 
        case 4: 
          label331:
          if (i != 0) {
            paramView.layout(paramInt2, paramInt4, j + paramInt2, k + paramInt4);
          }
          break;
        }
      }
      for (;;)
      {
        if (this.mCachingStarted) {
          paramView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.isHoneycomb()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).scrappedFromPosition != paramInt1)) {
          paramView.jumpDrawablesToCurrentState();
        }
        return;
        paramBoolean2 = false;
        break;
        j = 0;
        break label27;
        bool = false;
        break label55;
        k = 0;
        break label67;
        label418:
        i = 0;
        break label87;
        localLayoutParams.forceAdd = false;
        addViewInLayout(paramView, paramInt4, localLayoutParams, true);
        break label147;
        label444:
        if (getContext().getApplicationInfo().targetSdkVersion < 11) {
          break label217;
        }
        paramView.setActivated(this.mCheckStates.get(paramInt1));
        break label217;
        label474:
        cleanupLayoutState(paramView);
        break label263;
        label482:
        paramInt4 = paramInt2 - k;
        break label283;
        paramInt2 = paramInt3 + (this.mColumnWidth - j) / 2;
        break label331;
        paramInt2 = this.mColumnWidth + paramInt3 - j;
        break label331;
        paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt4 - paramView.getTop());
      }
    }
  }
  
  boolean arrowScroll(int paramInt)
  {
    boolean bool = true;
    int k = this.mSelectedPosition;
    int m = this.mNumColumns;
    int j;
    int i;
    if (!this.mStackFromBottom)
    {
      j = k / m * m;
      i = Math.min(j + m - 1, this.mItemCount - 1);
      switch (paramInt)
      {
      default: 
        label92:
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        invokeOnItemScrollListener();
      }
      if (bool) {
        awakenScrollBars();
      }
      return bool;
      i = this.mItemCount;
      i = this.mItemCount - 1 - (i - 1 - k) / m * m;
      j = Math.max(0, i - m + 1);
      break;
      if (j <= 0) {
        break label92;
      }
      this.mLayoutMode = 6;
      setSelectionInt(Math.max(0, k - m));
      continue;
      if (i >= this.mItemCount - 1) {
        break label92;
      }
      this.mLayoutMode = 6;
      setSelectionInt(Math.min(k + m, this.mItemCount - 1));
      continue;
      if (k <= j) {
        break label92;
      }
      this.mLayoutMode = 6;
      setSelectionInt(Math.max(0, k - 1));
      continue;
      if (k >= i) {
        break label92;
      }
      this.mLayoutMode = 6;
      setSelectionInt(Math.min(k + 1, this.mItemCount - 1));
    }
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
    paramView.columnsCount = this.mNumColumns;
    paramView.rowsCount = (paramInt2 / this.mNumColumns);
    if (!this.mStackFromBottom)
    {
      paramView.column = (paramInt1 % this.mNumColumns);
      paramView.row = (paramInt1 / this.mNumColumns);
      return;
    }
    paramInt1 = paramInt2 - 1 - paramInt1;
    paramView.column = (this.mNumColumns - 1 - paramInt1 % this.mNumColumns);
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
    int j = 0;
    int i = j;
    if (this.mFirstPosition >= 0)
    {
      i = j;
      if (getChildCount() > 0)
      {
        View localView = getChildAt(0);
        int k = localView.getTop();
        int m = localView.getHeight();
        i = j;
        if (m > 0)
        {
          j = this.mNumColumns;
          i = this.mFirstPosition / j;
          j = (this.mItemCount + j - 1) / j;
          i = Math.max(i * 100 - k * 100 / m + (int)(this.mScrollY / getHeight() * j * 100.0F), 0);
        }
      }
    }
    return i;
  }
  
  protected int computeVerticalScrollRange()
  {
    int i = this.mNumColumns;
    int k = (this.mItemCount + i - 1) / i;
    int j = Math.max(k * 100, 0);
    i = j;
    if (this.mScrollY != 0)
    {
      float f = this.mScrollY / getHeight();
      i = j + Math.abs((int)(k * f * 100.0F));
    }
    return i;
  }
  
  void fillGap(boolean paramBoolean)
  {
    int m = this.mNumColumns;
    int n = this.mVerticalSpacing;
    int j = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label194;
      }
    }
    label182:
    label194:
    for (int i = getListPaddingTop();; i = 0)
    {
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
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (i = getListPaddingBottom();; i = 0)
      {
        if (j > 0)
        {
          i = getChildAt(0).getTop() - n;
          j = this.mFirstPosition;
          if (this.mStackFromBottom) {
            break label182;
          }
          j -= m;
        }
        for (;;)
        {
          fillUp(j, i);
          correctTooLow(m, n, getChildCount());
          return;
          i = getHeight() - i;
          break;
          j -= 1;
        }
      }
    }
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
            return i + this.mFirstPosition;
          }
          i += j;
        }
      }
      int i = k - 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getTop()) {
          return i + this.mFirstPosition;
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
    for (;;)
    {
      if (bool) {
        awakenScrollBars();
      }
      return bool;
      if (paramInt == 130)
      {
        this.mLayoutMode = 2;
        setSelectionInt(this.mItemCount - 1);
        invokeOnItemScrollListener();
      }
      else
      {
        bool = false;
      }
    }
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
    AbsListView.RecycleBin localRecycleBin = null;
    int m = -1;
    boolean bool1 = this.mBlockLayoutRequests;
    if (!bool1) {
      this.mBlockLayoutRequests = true;
    }
    int n;
    int i;
    label159:
    Object localObject4;
    Object localObject3;
    label180:
    label448:
    label474:
    View localView;
    for (;;)
    {
      try
      {
        super.layoutChildren();
        invalidate();
        if (this.mAdapter == null)
        {
          resetList();
          invokeOnItemScrollListener();
          return;
        }
        j = this.mListPadding.top;
        n = this.mBottom - this.mTop - this.mListPadding.bottom;
        int i1 = getChildCount();
        boolean bool2;
        switch (this.mLayoutMode)
        {
        case 2: 
          i = this.mSelectedPosition - this.mFirstPosition;
          if ((i < 0) || (i >= i1)) {
            break label867;
          }
          localObject1 = getChildAt(i);
          localObject4 = getChildAt(0);
          i = 0;
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localRecycleBin;
          bool2 = this.mDataChanged;
          if (bool2) {
            handleDataChanged();
          }
          if (this.mItemCount == 0)
          {
            resetList();
            invokeOnItemScrollListener();
            return;
            i = this.mNextSelectedPosition - this.mFirstPosition;
            if ((i < 0) || (i >= i1)) {
              break label873;
            }
            localObject4 = getChildAt(i);
            localObject1 = null;
            localObject3 = null;
            i = 0;
          }
          break;
        case 6: 
          if (this.mNextSelectedPosition < 0) {
            break label873;
          }
          i = this.mNextSelectedPosition;
          int k = this.mSelectedPosition;
          localObject1 = null;
          localObject3 = null;
          i -= k;
          localObject4 = localRecycleBin;
          continue;
          setSelectedPositionInt(this.mNextSelectedPosition);
          int i2 = this.mFirstPosition;
          localRecycleBin = this.mRecycler;
          if (bool2)
          {
            k = 0;
            if (k < i1)
            {
              localRecycleBin.addScrapView(getChildAt(k), i2 + k);
              k += 1;
              continue;
            }
          }
          else
          {
            localRecycleBin.fillActiveViews(i1, i2);
          }
          detachAllViewsFromParent();
          switch (this.mLayoutMode)
          {
          case 2: 
            label404:
            if (i1 != 0) {
              break label704;
            }
            if (this.mStackFromBottom) {
              break label663;
            }
            i = m;
            if (this.mAdapter != null)
            {
              if (!isInTouchMode()) {
                break label909;
              }
              i = m;
            }
            label436:
            setSelectedPositionInt(i);
            localObject1 = fillFromTop(j);
            localRecycleBin.scrapActiveViews();
            if (localObject1 == null) {
              break label804;
            }
            positionSelector(-1, (View)localObject1);
            this.mSelectedTop = ((View)localObject1).getTop();
            this.mLayoutMode = 0;
            this.mDataChanged = false;
            this.mNeedSync = false;
            setNextSelectedPositionInt(this.mSelectedPosition);
            updateScrollIndicators();
            if (this.mItemCount > 0) {
              checkSelectionChanged();
            }
            invokeOnItemScrollListener();
            return;
          }
          break;
        }
      }
      finally
      {
        Object localObject1;
        if (bool1) {
          continue;
        }
        this.mBlockLayoutRequests = false;
      }
      if (localObject4 != null)
      {
        localObject1 = fillFromSelection(((View)localObject4).getTop(), j, n);
      }
      else
      {
        localObject1 = fillSelection(j, n);
        continue;
        this.mFirstPosition = 0;
        localObject1 = fillFromTop(j);
        adjustViewsUpOrDown();
        continue;
        localView = fillUp(this.mItemCount - 1, n);
        adjustViewsUpOrDown();
        continue;
        localView = fillSpecific(this.mSelectedPosition, this.mSpecificTop);
        continue;
        localView = fillSpecific(this.mSyncPosition, this.mSpecificTop);
        continue;
        localView = moveSelection(i, j, n);
      }
    }
    label663:
    int j = this.mItemCount - 1;
    if (this.mAdapter != null) {
      if (!isInTouchMode()) {
        break label919;
      }
    }
    for (;;)
    {
      setSelectedPositionInt(i);
      localView = fillFromBottom(j, n);
      break label448;
      label704:
      if ((this.mSelectedPosition >= 0) && (this.mSelectedPosition < this.mItemCount))
      {
        i = this.mSelectedPosition;
        if (localObject3 == null) {}
        for (;;)
        {
          localView = fillSpecific(i, j);
          break;
          j = localObject3.getTop();
        }
      }
      if (this.mFirstPosition < this.mItemCount)
      {
        i = this.mFirstPosition;
        if (localView == null) {}
        for (;;)
        {
          localView = fillSpecific(i, j);
          break;
          j = localView.getTop();
        }
      }
      localView = fillSpecific(0, j);
      break label448;
      label804:
      if ((this.mTouchMode > 0) && (this.mTouchMode < 3))
      {
        localView = getChildAt(this.mMotionPosition - this.mFirstPosition);
        if (localView == null) {
          break label474;
        }
        positionSelector(this.mMotionPosition, localView);
        break label474;
      }
      this.mSelectedTop = 0;
      this.mSelectorRect.setEmpty();
      break label474;
      label867:
      localView = null;
      break label159;
      label873:
      localView = null;
      localObject3 = null;
      i = 0;
      localObject4 = localRecycleBin;
      break label180;
      break;
      localView = null;
      localObject3 = null;
      i = 0;
      localObject4 = localRecycleBin;
      break label180;
      break label404;
      label909:
      i = 0;
      break label436;
      i = -1;
      continue;
      label919:
      i = j;
    }
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((this.mAdapter == null) || (isInTouchMode())) {
      i = -1;
    }
    do
    {
      return i;
      if (paramInt < 0) {
        break;
      }
      i = paramInt;
    } while (paramInt < this.mItemCount);
    return -1;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    int i = -1;
    int m = i;
    Rect localRect;
    int k;
    int j;
    if (paramBoolean)
    {
      m = i;
      if (paramRect != null)
      {
        paramRect.offset(this.mScrollX, this.mScrollY);
        localRect = this.mTempRect;
        k = 2147483647;
        int n = getChildCount();
        j = 0;
        m = i;
        if (j < n) {
          if (isCandidateSelection(j, paramInt)) {}
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      View localView = getChildAt(j);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      m = getDistance(paramRect, localRect, paramInt);
      if (m < k)
      {
        k = m;
        i = j;
        continue;
        if (m >= 0)
        {
          setSelection(this.mFirstPosition + m);
          return;
        }
        requestLayout();
        return;
      }
    }
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
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 0) {
      if (this.mColumnWidth > 0)
      {
        paramInt2 = this.mColumnWidth + this.mListPadding.left + this.mListPadding.right;
        paramInt2 += getVerticalScrollbarWidth();
      }
    }
    for (;;)
    {
      boolean bool = determineColumns(paramInt2 - this.mListPadding.left - this.mListPadding.right);
      int k = 0;
      label109:
      int i2;
      if (this.mAdapter == null)
      {
        i = 0;
        this.mItemCount = i;
        i2 = this.mItemCount;
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
          k = i;
          if (this.mRecycler.shouldRecycleViewType(localLayoutParams1.viewType))
          {
            this.mRecycler.addScrapView(localView, -1);
            k = i;
          }
        }
        if (m != 0) {
          break label528;
        }
      }
      label515:
      label525:
      label528:
      for (i = this.mListPadding.top + this.mListPadding.bottom + k + getVerticalFadingEdgeLength() * 2;; i = j)
      {
        j = i;
        int i3;
        if (m == -2147483648)
        {
          j = this.mListPadding.top;
          m = this.mListPadding.bottom;
          i3 = this.mNumColumns;
          j = m + j;
          m = 0;
          label345:
          if (m >= i2) {
            break label525;
          }
          int n = j + k;
          j = n;
          if (m + i3 < i2) {
            j = n + this.mVerticalSpacing;
          }
          if (j < i) {
            break label515;
          }
          j = i;
        }
        for (;;)
        {
          i = paramInt2;
          if (i1 == -2147483648)
          {
            i = paramInt2;
            if (this.mRequestedNumColumns != -1) {
              if (this.mRequestedNumColumns * this.mColumnWidth + (this.mRequestedNumColumns - 1) * this.mHorizontalSpacing + this.mListPadding.left + this.mListPadding.right <= paramInt2)
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
          return;
          paramInt2 = this.mListPadding.left + this.mListPadding.right;
          break;
          i = this.mAdapter.getCount();
          break label109;
          m += i3;
          break label345;
        }
      }
      paramInt2 = i;
    }
  }
  
  boolean pageScroll(int paramInt)
  {
    boolean bool = false;
    int i = -1;
    if (paramInt == 33) {
      i = Math.max(0, this.mSelectedPosition - getChildCount());
    }
    for (;;)
    {
      if (i >= 0)
      {
        setSelectionInt(i);
        invokeOnItemScrollListener();
        awakenScrollBars();
        bool = true;
      }
      return bool;
      if (paramInt == 130) {
        i = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount());
      }
    }
  }
  
  boolean sequenceScroll(int paramInt)
  {
    boolean bool2 = true;
    int i = 0;
    int m = this.mSelectedPosition;
    int i1 = this.mNumColumns;
    int n = this.mItemCount;
    int k;
    int j;
    label80:
    boolean bool1;
    if (!this.mStackFromBottom)
    {
      k = m / i1 * i1;
      j = Math.min(k + i1 - 1, n - 1);
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        invokeOnItemScrollListener();
      }
      if (i != 0) {
        awakenScrollBars();
      }
      return bool1;
      j = n - 1 - (n - 1 - m) / i1 * i1;
      k = Math.max(0, j - i1 + 1);
      break;
      if (m >= n - 1) {
        break label80;
      }
      this.mLayoutMode = 6;
      setSelectionInt(m + 1);
      bool1 = bool2;
      if (m == j)
      {
        i = 1;
        bool1 = bool2;
        continue;
        if (m <= 0) {
          break label80;
        }
        this.mLayoutMode = 6;
        setSelectionInt(m - 1);
        bool1 = bool2;
        if (m == k)
        {
          i = 1;
          bool1 = bool2;
        }
      }
    }
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
    int i;
    if (this.mAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      this.mDataChanged = true;
      checkFocus();
      this.mDataSetObserver = new AbsListView.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
      if (this.mStackFromBottom)
      {
        i = lookForSelectablePosition(this.mItemCount - 1, false);
        setSelectedPositionInt(i);
        setNextSelectedPositionInt(i);
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      i = lookForSelectablePosition(0, true);
      break;
      checkFocus();
      checkSelectionChanged();
    }
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
    }
    for (;;)
    {
      this.mLayoutMode = 2;
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
      requestLayout();
      return;
      this.mResurrectToPosition = paramInt;
    }
  }
  
  void setSelectionInt(int paramInt)
  {
    int j = this.mNextSelectedPosition;
    if (this.mPositionScroller != null) {
      this.mPositionScroller.stop();
    }
    setNextSelectedPositionInt(paramInt);
    layoutChildren();
    if (this.mStackFromBottom) {}
    for (paramInt = this.mItemCount - 1 - this.mNextSelectedPosition;; paramInt = this.mNextSelectedPosition)
    {
      int i = j;
      if (this.mStackFromBottom) {
        i = this.mItemCount - 1 - j;
      }
      if (paramInt / this.mNumColumns != i / this.mNumColumns) {
        awakenScrollBars();
      }
      return;
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