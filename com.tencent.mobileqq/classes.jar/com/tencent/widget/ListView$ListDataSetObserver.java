package com.tencent.widget;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;

class ListView$ListDataSetObserver
  extends AbsListView.AdapterDataSetObserver
  implements XBaseAdapter.ListDataSetListener
{
  ListView$ListDataSetObserver(ListView paramListView)
  {
    super(paramListView);
  }
  
  private void calcAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      paramInt2 = j;
      while (paramInt2 < paramInt1)
      {
        localView = this.this$0.getChildAt(paramInt2);
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(this.this$0.getDelAnimationDuration());
        localView.setAnimation((Animation)localObject);
        paramInt2 += 1;
      }
    }
    for (;;)
    {
      j = paramInt2;
      if (i > paramInt2) {
        break;
      }
      localView = this.this$0.getChildAt(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt3, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.this$0.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
      i += 1;
    }
    for (;;)
    {
      j += 1;
      if (j >= paramInt1) {
        break;
      }
      localView = this.this$0.getChildAt(j);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt4, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.this$0.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
    }
  }
  
  private int calcNewPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 <= paramInt5)
    {
      if (paramInt1 < paramInt4) {
        return -1;
      }
      paramInt4 = paramInt1;
      if (paramInt1 >= paramInt2)
      {
        if (paramInt1 <= paramInt3) {
          return -1;
        }
        paramInt4 = paramInt1 - (paramInt3 - paramInt2 + 1);
      }
      return paramInt4;
    }
    return -1;
  }
  
  private int calcNewPositionAdd(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 <= paramInt5) && (paramInt1 >= paramInt4))
    {
      paramInt4 = paramInt1;
      if (paramInt1 >= paramInt2) {
        paramInt4 = paramInt1 + (paramInt3 - paramInt2 + 1);
      }
      return paramInt4;
    }
    return -1;
  }
  
  private void offsetBottom(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      int j;
      for (int i = -1; paramInt3 < paramInt1; i = j)
      {
        View localView = this.this$0.getChildAt(paramInt3);
        if (localView.getTop() + paramInt4 > paramInt2)
        {
          this.this$0.mRecycler.addScrapView(localView, this.this$0.mFirstPosition + paramInt3);
          j = i;
          if (i < 0) {
            j = paramInt3;
          }
        }
        else
        {
          localView.offsetTopAndBottom(paramInt4);
          j = i;
        }
        paramInt3 += 1;
      }
      if (i >= 0) {
        ListView.access$1900(this.this$0, i, paramInt1 - i);
      }
    }
    else if (paramInt4 < 0)
    {
      while (paramInt3 < paramInt1)
      {
        this.this$0.getChildAt(paramInt3).offsetTopAndBottom(paramInt4);
        paramInt3 += 1;
      }
      this.this$0.fillGap(true);
    }
  }
  
  private void offsetTop(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 0) {
      return;
    }
    if (paramInt3 > 0)
    {
      Object localObject;
      int j;
      for (int i = -1; paramInt2 >= 0; i = j)
      {
        localObject = this.this$0.getChildAt(paramInt2);
        if (((View)localObject).getBottom() - paramInt3 < paramInt1)
        {
          this.this$0.mRecycler.addScrapView((View)localObject, this.this$0.mFirstPosition + paramInt2);
          j = i;
          if (i < 0) {
            j = paramInt2;
          }
        }
        else
        {
          ((View)localObject).offsetTopAndBottom(-paramInt3);
          j = i;
        }
        paramInt2 -= 1;
      }
      if (i >= 0)
      {
        localObject = this.this$0;
        paramInt1 = i + 1;
        ListView.access$1700((ListView)localObject, 0, paramInt1);
        localObject = this.this$0;
        ((ListView)localObject).mFirstPosition += paramInt1;
      }
    }
    else if (paramInt3 < 0)
    {
      this.this$0.fillGap(false);
    }
  }
  
  private int updateAfter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = -2147483648;
    int j = 0;
    while (paramInt3 <= paramInt4)
    {
      if (i > paramInt2) {
        break label127;
      }
      View localView = this.this$0.getChildAt(paramInt3);
      int k = i;
      if (i == -2147483648) {
        k = localView.getTop();
      }
      i = localView.getHeight();
      ListView localListView = this.this$0;
      int m = ListView.access$1500(localListView, localView, localListView.mFirstPosition + paramInt3, k, true, this.this$0.mListPadding.left, paramInt3);
      j += m;
      i = k + (i + m + this.this$0.mDividerHeight);
      paramInt3 += 1;
    }
    paramInt3 = -1;
    label127:
    if (paramInt3 >= 0)
    {
      paramInt2 = paramInt3;
      while (paramInt2 < paramInt1)
      {
        this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt2), this.this$0.mFirstPosition + paramInt2);
        paramInt2 += 1;
      }
      ListView.access$1800(this.this$0, paramInt3, paramInt1 - paramInt3);
      return 0;
    }
    return j;
  }
  
  private int updateBefore(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2147483647;
    int j = 0;
    Object localObject;
    while (paramInt3 >= paramInt2)
    {
      if (i < paramInt1) {
        break label126;
      }
      localObject = this.this$0.getChildAt(paramInt3);
      int k = i;
      if (i == 2147483647) {
        k = ((View)localObject).getBottom();
      }
      i = ((View)localObject).getHeight();
      ListView localListView = this.this$0;
      int m = ListView.access$1500(localListView, (View)localObject, localListView.mFirstPosition + paramInt3, k, false, this.this$0.mListPadding.left, paramInt3);
      j += m;
      i = k - (i + m + this.this$0.mDividerHeight);
      paramInt3 -= 1;
    }
    paramInt3 = -1;
    label126:
    if (paramInt3 >= 0)
    {
      paramInt1 = 0;
      while (paramInt1 <= paramInt3)
      {
        this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
        paramInt1 += 1;
      }
      localObject = this.this$0;
      paramInt1 = paramInt3 + 1;
      ListView.access$1600((ListView)localObject, 0, paramInt1);
      localObject = this.this$0;
      ((ListView)localObject).mFirstPosition += paramInt1;
      return 0;
    }
    return j;
  }
  
  public void onRowDeleted(int paramInt1, int paramInt2)
  {
    System.nanoTime();
    if (paramInt2 >= paramInt1)
    {
      if ((paramInt1 >= 0) && (paramInt2 < this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount()))
      {
        if ((!this.this$0.mNeedSync) && (!this.this$0.mDataChanged))
        {
          int n = paramInt1 + this.this$0.getHeaderViewsCount();
          int i2 = paramInt2 + this.this$0.getHeaderViewsCount();
          int i5 = i2 - n + 1;
          int i4 = this.this$0.getChildCount();
          int i1 = this.this$0.mFirstPosition;
          int i3 = this.this$0.mFirstPosition + i4 - 1;
          if (this.this$0.mFastScroller != null) {
            this.this$0.mFastScroller.onItemCountChanged(this.this$0.mItemCount, this.this$0.mItemCount - i5);
          }
          localObject1 = this.this$0;
          ((ListView)localObject1).mItemCount -= i5;
          if (this.this$0.mSelectedPosition >= 0)
          {
            paramInt1 = calcNewPosition(this.this$0.mSelectedPosition, n, i2, i1, i3);
            this.this$0.setSelectedPositionInt(paramInt1);
            this.this$0.setNextSelectedPositionInt(paramInt1);
          }
          else if (this.this$0.mSelectorPosition >= 0)
          {
            localObject1 = this.this$0;
            ((ListView)localObject1).mSelectedPosition = calcNewPosition(((ListView)localObject1).mSelectorPosition, n, i2, i1, i3);
          }
          if (this.this$0.mMotionPosition >= 0)
          {
            localObject1 = this.this$0;
            ((ListView)localObject1).mMotionPosition = calcNewPosition(((ListView)localObject1).mMotionPosition, n, i2, i1, i3);
          }
          if (this.this$0.mCheckStates == null) {
            paramInt1 = 0;
          } else {
            paramInt1 = this.this$0.mCheckStates.size();
          }
          int i;
          boolean bool1;
          int m;
          int k;
          int j;
          if (paramInt1 > 0)
          {
            i = 0;
            paramInt2 = paramInt1;
            paramInt1 = i;
            while (paramInt1 < paramInt2)
            {
              int i6 = this.this$0.mCheckStates.keyAt(paramInt1);
              bool1 = this.this$0.mCheckStates.valueAt(paramInt1);
              m = paramInt1;
              k = paramInt2;
              if (i6 >= n)
              {
                this.this$0.mCheckStates.delete(i6);
                j = paramInt1;
                i = paramInt2;
                if (i6 <= i2)
                {
                  j = paramInt1 - 1;
                  i = paramInt2 - 1;
                }
                m = j;
                k = i;
                if (i6 > i2)
                {
                  this.this$0.mCheckStates.put(i6 - i5, bool1);
                  k = i;
                  m = j;
                }
              }
              paramInt1 = m + 1;
              paramInt2 = k;
            }
          }
          if (ListView.access$300(this.this$0) != null)
          {
            paramInt1 = 0;
            while (paramInt1 < ListView.access$300(this.this$0).length)
            {
              paramInt2 = ListView.access$300(this.this$0)[paramInt1];
              if (paramInt2 >= n)
              {
                if (paramInt2 <= i2) {
                  paramInt2 = -1;
                } else {
                  paramInt2 -= i5;
                }
                ListView.access$300(this.this$0)[paramInt1] = paramInt2;
              }
              paramInt1 += 1;
            }
          }
          if (i2 >= i1)
          {
            if (n > i3) {
              return;
            }
            m = this.this$0.mListPadding.top;
            k = this.this$0.getBottom() - this.this$0.getTop() - this.this$0.mListPadding.bottom;
            if (n < i1) {
              paramInt1 = 0;
            } else {
              paramInt1 = n - i1;
            }
            if (i2 > i3) {
              paramInt2 = i4 - 1;
            } else {
              paramInt2 = i2 - i1;
            }
            i = 0;
            while (i < i4)
            {
              localObject1 = this.this$0.getChildAt(i);
              if ((i >= paramInt1) && (i <= paramInt2))
              {
                this.this$0.mRecycler.addScrapView((View)localObject1, i);
                ((View)localObject1).setTag(2131230829, null);
              }
              else if (ListView.access$900(this.this$0))
              {
                ((View)localObject1).setTag(2131230829, new Point(((View)localObject1).getTop(), ((View)localObject1).getBottom()));
              }
              i += 1;
            }
            ListView.access$1000(this.this$0, paramInt1, paramInt2 - paramInt1 + 1);
            if (this.this$0.mItemCount == 0) {
              return;
            }
            paramInt2 = this.this$0.getChildCount();
            boolean bool2 = this.this$0.shouldShowSelector();
            if (this.this$0.mSelectedPosition >= 0) {
              j = this.this$0.mSelectedPosition;
            } else if (bool2) {
              j = this.this$0.mSelectorPosition;
            } else {
              j = -1;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("first is:");
              ((StringBuilder)localObject1).append(n);
              ((StringBuilder)localObject1).append(",last is:");
              ((StringBuilder)localObject1).append(i2);
              ((StringBuilder)localObject1).append(",firstPosition is:");
              ((StringBuilder)localObject1).append(i1);
              ((StringBuilder)localObject1).append(",lastPosition is:");
              ((StringBuilder)localObject1).append(i3);
              ((StringBuilder)localObject1).append(",newSelectionPosition is:");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append(",mStackFromBottom is:");
              ((StringBuilder)localObject1).append(this.this$0.mStackFromBottom);
              QLog.d("XListView", 2, ((StringBuilder)localObject1).toString());
            }
            if ((n <= i1) && (i2 >= i3))
            {
              if (!this.this$0.mStackFromBottom)
              {
                paramInt1 = n;
                if (n > this.this$0.mItemCount - 1) {
                  paramInt1 = this.this$0.mItemCount - 1;
                }
                ListView.access$1100(this.this$0, paramInt1, m);
              }
              else
              {
                localObject1 = this.this$0;
                paramInt2 = n - 1;
                paramInt1 = paramInt2;
                if (paramInt2 < 0) {
                  paramInt1 = 0;
                }
                ListView.access$1200((ListView)localObject1, paramInt1, k);
              }
              paramInt1 = 0;
              paramInt2 = 0;
              i = -1;
              bool1 = true;
            }
            else
            {
              Object localObject2;
              if (n <= i1)
              {
                if ((!this.this$0.mStackFromBottom) && (j < 0))
                {
                  localObject1 = this.this$0.getChildAt(0);
                  paramInt2 = ((View)localObject1).getTop();
                  this.this$0.offsetChildrenTopAndBottomWrap(m - ((View)localObject1).getTop());
                  localObject2 = this.this$0;
                  ((ListView)localObject2).mFirstPosition = n;
                  ((ListView)localObject2).fillGap(true);
                  ListView.access$800(this.this$0);
                  if (((View)localObject1).getTop() - this.this$0.mDividerHeight > 0) {
                    paramInt1 = -((View)localObject1).getTop() + this.this$0.mDividerHeight;
                  } else {
                    paramInt1 = 0;
                  }
                  k = ((View)localObject1).getTop();
                  i = this.this$0.indexOfChild((View)localObject1);
                  paramInt2 -= k;
                  bool1 = false;
                }
                else
                {
                  localObject1 = this.this$0;
                  ((ListView)localObject1).mFirstPosition = n;
                  localObject1 = ((ListView)localObject1).getChildAt(paramInt1);
                  paramInt2 = ((View)localObject1).getTop();
                  this.this$0.fillGap(false);
                  ListView.access$800(this.this$0);
                  k = ((View)localObject1).getTop();
                  if (k - this.this$0.mDividerHeight > 0) {
                    paramInt1 = -k + this.this$0.mDividerHeight;
                  } else {
                    paramInt1 = 0;
                  }
                  i = this.this$0.indexOfChild((View)localObject1) - 1;
                  paramInt2 -= k;
                  bool1 = false;
                }
              }
              else if (i2 >= i3)
              {
                if ((this.this$0.mStackFromBottom) && (j < 0))
                {
                  localObject1 = this.this$0.getChildAt(paramInt2 - 1);
                  paramInt1 = ((View)localObject1).getTop();
                  this.this$0.offsetChildrenTopAndBottomWrap(k - ((View)localObject1).getBottom());
                  this.this$0.fillGap(false);
                  ListView.access$800(this.this$0);
                  if (k - ((View)localObject1).getBottom() - this.this$0.mDividerHeight > 0) {
                    paramInt2 = k - ((View)localObject1).getBottom() - this.this$0.mDividerHeight;
                  } else {
                    paramInt2 = 0;
                  }
                  paramInt1 -= ((View)localObject1).getTop();
                  i = this.this$0.indexOfChild((View)localObject1);
                }
                else
                {
                  localObject1 = this.this$0.getChildAt(paramInt2 - 1);
                  paramInt1 = ((View)localObject1).getBottom();
                  this.this$0.fillGap(true);
                  ListView.access$800(this.this$0);
                  paramInt2 = ((View)localObject1).getBottom();
                  paramInt1 -= paramInt2;
                  paramInt2 = k - paramInt2;
                  if (paramInt2 - this.this$0.mDividerHeight > 0) {
                    paramInt2 -= this.this$0.mDividerHeight;
                  } else {
                    paramInt2 = 0;
                  }
                  i = this.this$0.indexOfChild((View)localObject1);
                }
                bool1 = false;
              }
              else
              {
                if (((j >= 0) && (j < n)) || ((j < 0) && (!this.this$0.mStackFromBottom)))
                {
                  localObject1 = this.this$0.getChildAt(paramInt1 - 1);
                  i = ((View)localObject1).getTop();
                  localObject2 = this.this$0.getChildAt(paramInt1);
                  k = ((View)localObject2).getTop();
                  m = ((View)localObject2).getTop();
                  i2 = ((View)localObject1).getBottom();
                  paramInt1 = n - i1;
                  while (paramInt1 < paramInt2)
                  {
                    this.this$0.getChildAt(paramInt1).offsetTopAndBottom(-(m - i2) + this.this$0.mDividerHeight);
                    paramInt1 += 1;
                  }
                  this.this$0.fillGap(true);
                  ListView.access$800(this.this$0);
                  paramInt2 = k - ((View)localObject2).getTop();
                  paramInt1 = i - ((View)localObject1).getTop();
                }
                for (i = this.this$0.indexOfChild((View)localObject1);; i = this.this$0.indexOfChild((View)localObject1))
                {
                  break;
                  if ((j < n) && ((j >= 0) || (!this.this$0.mStackFromBottom)))
                  {
                    paramInt1 = 0;
                    paramInt2 = 0;
                    i = -1;
                    break;
                  }
                  localObject1 = this.this$0;
                  m = paramInt1 - 1;
                  localObject1 = ((ListView)localObject1).getChildAt(m);
                  i = ((View)localObject1).getTop();
                  localObject2 = this.this$0.getChildAt(paramInt1);
                  paramInt2 = ((View)localObject2).getTop();
                  k = ((View)localObject2).getTop();
                  m = this.this$0.getChildAt(m).getBottom();
                  paramInt1 = 0;
                  while (paramInt1 < n - i1)
                  {
                    this.this$0.getChildAt(paramInt1).offsetTopAndBottom(k - m - this.this$0.mDividerHeight);
                    paramInt1 += 1;
                  }
                  this.this$0.fillGap(false);
                  ListView.access$800(this.this$0);
                  paramInt2 -= ((View)localObject2).getTop();
                  paramInt1 = i - ((View)localObject1).getTop();
                }
              }
            }
            k = this.this$0.getChildCount();
            if ((j >= 0) && (j < k) && (bool2))
            {
              localObject1 = this.this$0;
              ((ListView)localObject1).positionSelector(j, ((ListView)localObject1).getChildAt(j - ((ListView)localObject1).mFirstPosition));
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("upItemsMaxIndex is:");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(",upItemsMoveDistance is:");
              ((StringBuilder)localObject1).append(paramInt1);
              ((StringBuilder)localObject1).append(",downItemsMoveDistance is:");
              ((StringBuilder)localObject1).append(paramInt2);
              QLog.d("XListView", 2, ((StringBuilder)localObject1).toString());
            }
            if (ListView.access$900(this.this$0)) {
              calcAnimation(k, i, paramInt1, paramInt2, bool1);
            }
            this.this$0.invalidate();
          }
          return;
        }
        onChanged();
        return;
      }
      throw new IllegalArgumentException("row index out of bound");
    }
    Object localObject1 = new IllegalArgumentException("lastRow must more than firstRow!");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void onRowDeleted(int... paramVarArgs)
  {
    onChanged();
  }
  
  public void onRowInserted(int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    if (this.this$0.mItemCount > 0)
    {
      System.nanoTime();
      if (paramInt2 >= paramInt1)
      {
        if ((paramInt1 >= 0) && (paramInt1 <= this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount()))
        {
          if ((!this.this$0.mNeedSync) && (!this.this$0.mDataChanged))
          {
            if (this.this$0.mItemCount == 0) {
              return;
            }
            int m = paramInt1 + this.this$0.getHeaderViewsCount();
            i = paramInt2 + this.this$0.getHeaderViewsCount();
            int i2 = i - m + 1;
            int k = this.this$0.getChildCount();
            int i1 = this.this$0.mFirstPosition;
            int i3 = this.this$0.mFirstPosition + k - 1;
            if (m == this.this$0.mItemCount) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (this.this$0.mFastScroller != null) {
              this.this$0.mFastScroller.onItemCountChanged(this.this$0.mItemCount, this.this$0.mItemCount - i2);
            }
            localObject1 = this.this$0;
            ((ListView)localObject1).mItemCount += i2;
            if (this.this$0.mSelectedPosition >= 0)
            {
              paramInt2 = calcNewPositionAdd(this.this$0.mSelectedPosition, m, i, i1, i3);
              this.this$0.setSelectedPositionInt(paramInt2);
              this.this$0.setNextSelectedPositionInt(paramInt2);
            }
            else if (this.this$0.mSelectorPosition >= 0)
            {
              localObject1 = this.this$0;
              ((ListView)localObject1).mSelectedPosition = calcNewPositionAdd(((ListView)localObject1).mSelectorPosition, m, i, i1, i3);
            }
            if (this.this$0.mMotionPosition >= 0)
            {
              localObject1 = this.this$0;
              ((ListView)localObject1).mMotionPosition = calcNewPositionAdd(((ListView)localObject1).mMotionPosition, m, i, i1, i3);
            }
            if (this.this$0.mCheckStates == null) {
              paramInt2 = 0;
            } else {
              paramInt2 = this.this$0.mCheckStates.size();
            }
            if (paramInt2 > 0)
            {
              j = 0;
              while (j < paramInt2)
              {
                n = this.this$0.mCheckStates.keyAt(j);
                boolean bool = this.this$0.mCheckStates.valueAt(j);
                if (n >= m)
                {
                  this.this$0.mCheckStates.delete(n);
                  this.this$0.mCheckStates.put(n + i2, bool);
                }
                j += 1;
              }
            }
            if (ListView.access$300(this.this$0) != null)
            {
              paramInt2 = 0;
              while (paramInt2 < ListView.access$300(this.this$0).length)
              {
                j = ListView.access$300(this.this$0)[paramInt2];
                if (j >= m) {
                  ListView.access$300(this.this$0)[paramInt2] = (j + i2);
                }
                paramInt2 += 1;
              }
            }
            int n = this.this$0.getBottom() - this.this$0.getTop() - this.this$0.mListPadding.bottom;
            localObject1 = this.this$0.getChildAt(k - 1);
            if (localObject1 == null) {
              j = 0;
            } else {
              j = ((View)localObject1).getBottom();
            }
            if ((this.this$0.getTranscriptMode() == 1) && (paramInt1 != 0) && (j <= n)) {
              k = 1;
            } else {
              k = 0;
            }
            if ((m <= i1) && (k == 0) && (j >= n))
            {
              localObject1 = this.this$0;
              ((ListView)localObject1).mFirstPosition += i2;
              return;
            }
            if ((m > i3) && (k == 0) && (j >= n)) {
              return;
            }
            i2 = this.this$0.mListPadding.top;
            paramInt2 = this.this$0.mSelectedPosition;
            paramInt1 = -1;
            if (paramInt2 >= 0) {
              paramInt2 = this.this$0.mSelectedPosition;
            } else if (this.this$0.shouldShowSelector()) {
              paramInt2 = this.this$0.mSelectorPosition;
            } else {
              paramInt2 = -1;
            }
            i1 = m - i1;
            if (k != 0)
            {
              paramInt2 = 0;
              j = n;
              for (;;)
              {
                k = paramInt1;
                if (i < m) {
                  break;
                }
                if (j < i2)
                {
                  k = i + 1;
                  break;
                }
                localObject1 = this.this$0;
                localObject1 = ((ListView)localObject1).obtainView(i, ((ListView)localObject1).mIsScrap);
                localObject2 = this.this$0;
                ListView.access$400((ListView)localObject2, (View)localObject1, i, j, false, ((ListView)localObject2).mListPadding.left, false, this.this$0.mIsScrap[0], i1);
                k = ((View)localObject1).getHeight() + this.this$0.mDividerHeight;
                j -= k;
                paramInt2 += k;
                i -= 1;
              }
              if (k >= 0)
              {
                paramInt1 = 0;
                while (paramInt1 <= i1 - 1)
                {
                  this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
                  paramInt1 += 1;
                }
                ListView.access$500(this.this$0, 0, i1);
                this.this$0.mFirstPosition = k;
              }
              else
              {
                offsetTop(i2, i1 - 1, paramInt2);
              }
            }
            else if (((paramInt2 >= 0) && (paramInt2 < m)) || ((paramInt2 < 0) && (!this.this$0.mStackFromBottom)))
            {
              if (i1 > 0)
              {
                paramInt2 = this.this$0.getChildAt(i1 - 1).getBottom() + this.this$0.mDividerHeight;
                j = 0;
                k = m;
                m = paramInt2;
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (k > i) {
                    break;
                  }
                  if (m > n)
                  {
                    paramInt2 = k - this.this$0.mFirstPosition;
                    break;
                  }
                  localObject1 = this.this$0;
                  localObject1 = ((ListView)localObject1).obtainView(k, ((ListView)localObject1).mIsScrap);
                  localObject2 = this.this$0;
                  ListView.access$400((ListView)localObject2, (View)localObject1, k, m, true, ((ListView)localObject2).mListPadding.left, false, this.this$0.mIsScrap[0], k - this.this$0.mFirstPosition);
                  paramInt2 = ((View)localObject1).getHeight() + this.this$0.mDividerHeight;
                  m += paramInt2;
                  j += paramInt2;
                  k += 1;
                }
                k = this.this$0.getChildCount();
                if (paramInt2 >= 0)
                {
                  paramInt1 = paramInt2;
                  while (paramInt1 < k)
                  {
                    this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
                    paramInt1 += 1;
                  }
                  ListView.access$600(this.this$0, paramInt2, k - paramInt2);
                }
                else
                {
                  offsetBottom(this.this$0.getChildCount(), n, i - this.this$0.mFirstPosition + 1, j);
                }
              }
            }
            else
            {
              if (n > j) {
                this.this$0.offsetChildrenTopAndBottomWrap(n - j);
              }
              j = this.this$0.getChildAt(i1).getTop() - this.this$0.mDividerHeight;
              paramInt2 = 0;
              for (;;)
              {
                k = paramInt1;
                if (i < m) {
                  break;
                }
                if (j < i2)
                {
                  k = i + 1;
                  break;
                }
                localObject1 = this.this$0;
                localObject1 = ((ListView)localObject1).obtainView(i, ((ListView)localObject1).mIsScrap);
                localObject2 = this.this$0;
                ListView.access$400((ListView)localObject2, (View)localObject1, i, j, false, ((ListView)localObject2).mListPadding.left, false, this.this$0.mIsScrap[0], i1);
                k = ((View)localObject1).getHeight() + this.this$0.mDividerHeight;
                j -= k;
                paramInt2 += k;
                i -= 1;
              }
              if (k >= 0)
              {
                paramInt1 = 0;
                while (paramInt1 <= i1 - 1)
                {
                  this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
                  paramInt1 += 1;
                }
                ListView.access$700(this.this$0, 0, i1);
                this.this$0.mFirstPosition = k;
              }
              else
              {
                offsetTop(i2, i1 - 1, paramInt2);
              }
            }
            ListView.access$800(this.this$0);
            return;
          }
          onChanged();
          return;
        }
        throw new IllegalArgumentException("row index out of bound");
      }
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    int i = 0;
    int j = 0;
    if (ListView.access$300(this.this$0) == null)
    {
      localObject1 = new int[paramInt2 - paramInt1 + 1];
      i = j;
      while (paramInt1 <= paramInt2)
      {
        localObject1[i] = paramInt1;
        paramInt1 += 1;
        i += 1;
      }
      ListView.access$302(this.this$0, (int[])localObject1);
    }
    else
    {
      localObject1 = new HashSet();
      while (paramInt1 <= paramInt2)
      {
        ((HashSet)localObject1).add(Integer.valueOf(paramInt1));
        paramInt1 += 1;
      }
      localObject2 = ListView.access$300(this.this$0);
      paramInt2 = localObject2.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((HashSet)localObject1).add(Integer.valueOf(localObject2[paramInt1]));
        paramInt1 += 1;
      }
      localObject2 = new int[((HashSet)localObject1).size()];
      localObject1 = ((HashSet)localObject1).iterator();
      paramInt1 = i;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2[paramInt1] = ((Integer)((Iterator)localObject1).next()).intValue();
        paramInt1 += 1;
      }
      ListView.access$302(this.this$0, (int[])localObject2);
    }
    onChanged();
  }
  
  public void onRowUpdated(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= paramInt1)
    {
      if ((paramInt1 >= this.this$0.getHeaderViewsCount()) && (paramInt2 < this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount()))
      {
        if ((!this.this$0.mNeedSync) && (!this.this$0.mDataChanged))
        {
          if (this.this$0.mItemCount == 0) {
            return;
          }
          int n = paramInt1 + this.this$0.getHeaderViewsCount();
          int i1 = paramInt2 + this.this$0.getHeaderViewsCount();
          int j = this.this$0.getChildCount();
          paramInt1 = this.this$0.mFirstPosition;
          int i = this.this$0.mFirstPosition + j - 1;
          if (i1 >= paramInt1)
          {
            if (n > i) {
              return;
            }
            int k = this.this$0.mListPadding.top;
            int m = this.this$0.getBottom() - this.this$0.getTop() - this.this$0.mListPadding.bottom;
            if (n < paramInt1) {
              paramInt2 = 0;
            } else {
              paramInt2 = n - paramInt1;
            }
            if (i1 > i) {
              i = j - 1;
            } else {
              i = i1 - paramInt1;
            }
            if (this.this$0.mSelectedPosition >= 0) {
              paramInt1 = this.this$0.mSelectedPosition;
            } else if (this.this$0.shouldShowSelector()) {
              paramInt1 = this.this$0.mSelectorPosition;
            } else {
              paramInt1 = -1;
            }
            if (((paramInt1 >= 0) && (paramInt1 <= n)) || ((paramInt1 < 0) && (!this.this$0.mStackFromBottom)))
            {
              paramInt1 = updateAfter(j, m, paramInt2, i);
              localObject = this.this$0;
              ListView.access$1300((ListView)localObject, ((ListView)localObject).getChildCount());
              offsetBottom(j, m, i + 1, paramInt1);
            }
            else if ((paramInt1 < i1) && ((paramInt1 >= 0) || (!this.this$0.mStackFromBottom)))
            {
              paramInt1 -= this.this$0.mFirstPosition;
              offsetBottom(j, m, i + 1, updateAfter(j, m, paramInt1, i));
              offsetTop(k, paramInt2 - 1, updateBefore(k, paramInt2, paramInt1 - 1));
            }
            else
            {
              paramInt1 = updateBefore(k, paramInt2, i);
              localObject = this.this$0;
              ListView.access$1400((ListView)localObject, ((ListView)localObject).getChildCount());
              offsetTop(k, paramInt2 - 1, paramInt1);
            }
            ListView.access$800(this.this$0);
          }
          return;
        }
        onChanged();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("row index out of bound. insert range: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("~");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(". valid range: ");
      ((StringBuilder)localObject).append(this.this$0.getHeaderViewsCount());
      ((StringBuilder)localObject).append("~");
      ((StringBuilder)localObject).append(this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("lastRow must more than firstRow!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ListView.ListDataSetObserver
 * JD-Core Version:    0.7.0.1
 */