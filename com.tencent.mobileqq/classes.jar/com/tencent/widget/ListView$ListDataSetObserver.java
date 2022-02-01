package com.tencent.widget;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import blgj;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;

class ListView$ListDataSetObserver
  extends AbsListView.AdapterDataSetObserver
  implements blgj
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
    while (i <= paramInt2)
    {
      localView = this.this$0.getChildAt(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt3, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.this$0.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
      i += 1;
    }
    paramInt2 += 1;
    while (paramInt2 < paramInt1)
    {
      localView = this.this$0.getChildAt(paramInt2);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt4, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.this$0.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
      paramInt2 += 1;
    }
  }
  
  private int calcNewPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    if (paramInt1 <= paramInt3) {
      return -1;
    }
    return paramInt1 - (paramInt3 - paramInt2 + 1);
  }
  
  private int calcNewPositionAdd(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    return paramInt1 + (paramInt3 - paramInt2 + 1);
  }
  
  private void offsetBottom(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      i = -1;
      if (paramInt3 < paramInt1)
      {
        localView = this.this$0.getChildAt(paramInt3);
        if (localView.getTop() + paramInt4 > paramInt2)
        {
          this.this$0.mRecycler.addScrapView(localView, this.this$0.mFirstPosition + paramInt3);
          j = i;
          if (i >= 0) {}
        }
        for (j = paramInt3;; j = i)
        {
          paramInt3 += 1;
          i = j;
          break;
          localView.offsetTopAndBottom(paramInt4);
        }
      }
      if (i >= 0) {
        ListView.access$2500(this.this$0, i, paramInt1 - i);
      }
    }
    while (paramInt4 >= 0)
    {
      int i;
      View localView;
      int j;
      return;
    }
    while (paramInt3 < paramInt1)
    {
      this.this$0.getChildAt(paramInt3).offsetTopAndBottom(paramInt4);
      paramInt3 += 1;
    }
    this.this$0.fillGap(true);
  }
  
  private void offsetTop(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 0) {}
    do
    {
      int i;
      do
      {
        return;
        if (paramInt3 <= 0) {
          break;
        }
        i = -1;
        if (paramInt2 >= 0)
        {
          localObject = this.this$0.getChildAt(paramInt2);
          if (((View)localObject).getBottom() - paramInt3 < paramInt1)
          {
            this.this$0.mRecycler.addScrapView((View)localObject, this.this$0.mFirstPosition + paramInt2);
            j = i;
            if (i >= 0) {}
          }
          for (int j = paramInt2;; j = i)
          {
            paramInt2 -= 1;
            i = j;
            break;
            ((View)localObject).offsetTopAndBottom(-paramInt3);
          }
        }
      } while (i < 0);
      ListView.access$2300(this.this$0, 0, i + 1);
      Object localObject = this.this$0;
      ((ListView)localObject).mFirstPosition = (i + 1 + ((ListView)localObject).mFirstPosition);
      return;
    } while (paramInt3 >= 0);
    this.this$0.fillGap(false);
  }
  
  private int updateAfter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i = -2147483648;
    if (paramInt3 <= paramInt4) {
      if (i <= paramInt2) {}
    }
    for (paramInt2 = paramInt3;; paramInt2 = -1)
    {
      if (paramInt2 >= 0)
      {
        paramInt3 = paramInt2;
        for (;;)
        {
          if (paramInt3 < paramInt1)
          {
            this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt3), this.this$0.mFirstPosition + paramInt3);
            paramInt3 += 1;
            continue;
            View localView = this.this$0.getChildAt(paramInt3);
            int k = i;
            if (i == -2147483648) {
              k = localView.getTop();
            }
            i = localView.getHeight();
            int m = ListView.access$2100(this.this$0, localView, this.this$0.mFirstPosition + paramInt3, k, true, this.this$0.mListPadding.left, paramInt3);
            j += m;
            i = k + (m + i + this.this$0.mDividerHeight);
            paramInt3 += 1;
            break;
          }
        }
        ListView.access$2400(this.this$0, paramInt2, paramInt1 - paramInt2);
        return 0;
      }
      return j;
    }
  }
  
  private int updateBefore(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2147483647;
    int j = 0;
    if (paramInt3 >= paramInt2) {
      if (i >= paramInt1) {}
    }
    for (;;)
    {
      if (paramInt3 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= paramInt3)
          {
            this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
            paramInt1 += 1;
            continue;
            localObject = this.this$0.getChildAt(paramInt3);
            int k = i;
            if (i == 2147483647) {
              k = ((View)localObject).getBottom();
            }
            i = ((View)localObject).getHeight();
            int m = ListView.access$2100(this.this$0, (View)localObject, this.this$0.mFirstPosition + paramInt3, k, false, this.this$0.mListPadding.left, paramInt3);
            j += m;
            i = k - (m + i + this.this$0.mDividerHeight);
            paramInt3 -= 1;
            break;
          }
        }
        ListView.access$2200(this.this$0, 0, paramInt3 + 1);
        Object localObject = this.this$0;
        ((ListView)localObject).mFirstPosition += paramInt3 + 1;
        return 0;
      }
      return j;
      paramInt3 = -1;
    }
  }
  
  public void onRowDeleted(int paramInt1, int paramInt2)
  {
    System.nanoTime();
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < 0) || (paramInt2 >= this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount())) {
      throw new IllegalArgumentException("row index out of bound");
    }
    if ((this.this$0.mNeedSync) || (this.this$0.mDataChanged)) {
      onChanged();
    }
    int n;
    int i2;
    int i1;
    int i3;
    boolean bool1;
    int m;
    int k;
    int j;
    int i;
    label469:
    label483:
    label636:
    label638:
    Object localObject;
    label548:
    label701:
    label710:
    label747:
    do
    {
      int i4;
      do
      {
        return;
        n = paramInt1 + this.this$0.getHeaderViewsCount();
        i2 = paramInt2 + this.this$0.getHeaderViewsCount();
        paramInt1 = i2 - n + 1;
        i4 = this.this$0.getChildCount();
        i1 = this.this$0.mFirstPosition;
        i3 = this.this$0.mFirstPosition + i4 - 1;
        if (this.this$0.mFastScroller != null) {
          this.this$0.mFastScroller.a(this.this$0.mItemCount, this.this$0.mItemCount - paramInt1);
        }
        this.this$0.mItemCount -= paramInt1;
        if (this.this$0.mSelectedPosition >= 0)
        {
          paramInt1 = calcNewPosition(this.this$0.mSelectedPosition, n, i2, i1, i3);
          this.this$0.setSelectedPositionInt(paramInt1);
          this.this$0.setNextSelectedPositionInt(paramInt1);
          if (this.this$0.mMotionPosition >= 0) {
            this.this$0.mMotionPosition = calcNewPosition(this.this$0.mMotionPosition, n, i2, i1, i3);
          }
          if (this.this$0.mCheckStates != null) {
            break label469;
          }
        }
        for (paramInt2 = 0;; paramInt2 = this.this$0.mCheckStates.size())
        {
          if (paramInt2 <= 0) {
            break label483;
          }
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            int i5 = this.this$0.mCheckStates.keyAt(paramInt1);
            bool1 = this.this$0.mCheckStates.valueAt(paramInt1);
            m = paramInt1;
            k = paramInt2;
            if (i5 >= n)
            {
              this.this$0.mCheckStates.delete(i5);
              j = paramInt1;
              i = paramInt2;
              if (i5 <= i2)
              {
                j = paramInt1 - 1;
                i = paramInt2 - 1;
              }
              m = j;
              k = i;
              if (i5 > i2)
              {
                this.this$0.mCheckStates.put(i5 - (i2 - n + 1), bool1);
                k = i;
                m = j;
              }
            }
            paramInt1 = m + 1;
            paramInt2 = k;
          }
          if (this.this$0.mSelectorPosition < 0) {
            break;
          }
          this.this$0.mSelectedPosition = calcNewPosition(this.this$0.mSelectorPosition, n, i2, i1, i3);
          break;
        }
        if (ListView.access$300(this.this$0) != null)
        {
          paramInt1 = 0;
          if (paramInt1 < ListView.access$300(this.this$0).length)
          {
            paramInt2 = ListView.access$300(this.this$0)[paramInt1];
            if (paramInt2 >= n)
            {
              if (paramInt2 > i2) {
                break label548;
              }
              paramInt2 = -1;
            }
            for (;;)
            {
              ListView.access$300(this.this$0)[paramInt1] = paramInt2;
              paramInt1 += 1;
              break;
              paramInt2 -= i2 - n + 1;
            }
          }
        }
      } while ((i2 < i1) || (n > i3));
      m = this.this$0.mListPadding.top;
      k = ListView.access$1100(this.this$0) - ListView.access$1200(this.this$0) - this.this$0.mListPadding.bottom;
      if (n < i1)
      {
        paramInt1 = 0;
        if (i2 <= i3) {
          break label701;
        }
        paramInt2 = i4 - 1;
        i = 0;
        if (i >= i4) {
          break label747;
        }
        localObject = this.this$0.getChildAt(i);
        if ((i < paramInt1) || (i > paramInt2)) {
          break label710;
        }
        this.this$0.mRecycler.addScrapView((View)localObject, i);
        ((View)localObject).setTag(2131230829, null);
      }
      for (;;)
      {
        i += 1;
        break label638;
        paramInt1 = n - i1;
        break;
        paramInt2 = i2 - i1;
        break label636;
        if (ListView.access$1300(this.this$0)) {
          ((View)localObject).setTag(2131230829, new Point(((View)localObject).getTop(), ((View)localObject).getBottom()));
        }
      }
      ListView.access$1400(this.this$0, paramInt1, paramInt2 - paramInt1 + 1);
    } while (this.this$0.mItemCount == 0);
    paramInt2 = this.this$0.getChildCount();
    boolean bool2 = this.this$0.shouldShowSelector();
    if (this.this$0.mSelectedPosition >= 0)
    {
      j = this.this$0.mSelectedPosition;
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "first is:" + n + ",last is:" + i2 + ",firstPosition is:" + i1 + ",lastPosition is:" + i3 + ",newSelectionPosition is:" + j + ",mStackFromBottom is:" + this.this$0.mStackFromBottom);
      }
      if ((n > i1) || (i2 < i3)) {
        break label1163;
      }
      if (this.this$0.mStackFromBottom) {
        break label1128;
      }
      paramInt1 = n;
      if (n > this.this$0.mItemCount - 1) {
        paramInt1 = this.this$0.mItemCount - 1;
      }
      ListView.access$1500(this.this$0, paramInt1, m);
      bool1 = true;
      paramInt1 = -1;
      i = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      k = this.this$0.getChildCount();
      if ((j >= 0) && (j < k) && (bool2)) {
        this.this$0.positionSelector(j, this.this$0.getChildAt(j - this.this$0.mFirstPosition));
      }
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "upItemsMaxIndex is:" + paramInt1 + ",upItemsMoveDistance is:" + paramInt2 + ",downItemsMoveDistance is:" + i);
      }
      if (ListView.access$1300(this.this$0)) {
        calcAnimation(k, paramInt1, paramInt2, i, bool1);
      }
      this.this$0.invalidate();
      return;
      if (bool2)
      {
        j = this.this$0.mSelectorPosition;
        break;
      }
      j = -1;
      break;
      label1128:
      localObject = this.this$0;
      if (n - 1 < 0) {}
      for (paramInt1 = 0;; paramInt1 = n - 1)
      {
        ListView.access$1600((ListView)localObject, paramInt1, k);
        break;
      }
      label1163:
      if (n <= i1)
      {
        if ((this.this$0.mStackFromBottom) || (j >= 0))
        {
          this.this$0.mFirstPosition = n;
          localObject = this.this$0.getChildAt(paramInt1);
          paramInt2 = ((View)localObject).getTop();
          this.this$0.fillGap(false);
          ListView.access$1000(this.this$0);
          paramInt1 = ((View)localObject).getTop();
          i = paramInt2 - paramInt1;
          if (paramInt1 - this.this$0.mDividerHeight > 0) {}
          for (paramInt1 = -paramInt1 + this.this$0.mDividerHeight;; paramInt1 = 0)
          {
            k = this.this$0.indexOfChild((View)localObject) - 1;
            paramInt2 = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.this$0.getChildAt(0);
        paramInt2 = ((View)localObject).getTop();
        this.this$0.offsetChildrenTopAndBottom(m - ((View)localObject).getTop());
        this.this$0.mFirstPosition = n;
        this.this$0.fillGap(true);
        ListView.access$1000(this.this$0);
        if (((View)localObject).getTop() - this.this$0.mDividerHeight > 0) {}
        for (paramInt1 = -((View)localObject).getTop() + this.this$0.mDividerHeight;; paramInt1 = 0)
        {
          i = paramInt2 - ((View)localObject).getTop();
          k = this.this$0.indexOfChild((View)localObject);
          paramInt2 = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      if (i2 >= i3)
      {
        if ((!this.this$0.mStackFromBottom) || (j >= 0))
        {
          localObject = this.this$0.getChildAt(paramInt2 - 1);
          paramInt2 = ((View)localObject).getBottom();
          this.this$0.fillGap(true);
          ListView.access$1000(this.this$0);
          paramInt1 = ((View)localObject).getBottom();
          paramInt2 -= paramInt1;
          if (k - paramInt1 - this.this$0.mDividerHeight > 0) {}
          for (paramInt1 = k - paramInt1 - this.this$0.mDividerHeight;; paramInt1 = 0)
          {
            k = this.this$0.indexOfChild((View)localObject);
            i = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.this$0.getChildAt(paramInt2 - 1);
        paramInt2 = ((View)localObject).getTop();
        this.this$0.offsetChildrenTopAndBottom(k - ((View)localObject).getBottom());
        this.this$0.fillGap(false);
        ListView.access$1000(this.this$0);
        if (k - ((View)localObject).getBottom() - this.this$0.mDividerHeight > 0) {}
        for (paramInt1 = k - ((View)localObject).getBottom() - this.this$0.mDividerHeight;; paramInt1 = 0)
        {
          paramInt2 -= ((View)localObject).getTop();
          k = this.this$0.indexOfChild((View)localObject);
          i = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      View localView;
      if (((j >= 0) && (j < n)) || ((j < 0) && (!this.this$0.mStackFromBottom)))
      {
        localObject = this.this$0.getChildAt(paramInt1 - 1);
        k = ((View)localObject).getTop();
        localView = this.this$0.getChildAt(paramInt1);
        i = localView.getTop();
        m = localView.getTop();
        i2 = ((View)localObject).getBottom();
        paramInt1 = n - i1;
        while (paramInt1 < paramInt2)
        {
          this.this$0.getChildAt(paramInt1).offsetTopAndBottom(-(m - i2) + this.this$0.mDividerHeight);
          paramInt1 += 1;
        }
        this.this$0.fillGap(true);
        ListView.access$1000(this.this$0);
        m = localView.getTop();
        paramInt2 = k - ((View)localObject).getTop();
        paramInt1 = this.this$0.indexOfChild((View)localObject);
        i -= m;
        bool1 = false;
      }
      else if ((j >= n) || ((j < 0) && (this.this$0.mStackFromBottom)))
      {
        localObject = this.this$0.getChildAt(paramInt1 - 1);
        paramInt2 = ((View)localObject).getTop();
        localView = this.this$0.getChildAt(paramInt1);
        i = localView.getTop();
        k = localView.getTop();
        m = this.this$0.getChildAt(paramInt1 - 1).getBottom();
        paramInt1 = 0;
        while (paramInt1 < n - i1)
        {
          this.this$0.getChildAt(paramInt1).offsetTopAndBottom(k - m - this.this$0.mDividerHeight);
          paramInt1 += 1;
        }
        this.this$0.fillGap(false);
        ListView.access$1000(this.this$0);
        k = localView.getTop();
        paramInt2 -= ((View)localObject).getTop();
        paramInt1 = this.this$0.indexOfChild((View)localObject);
        i -= k;
        bool1 = false;
      }
      else
      {
        paramInt1 = -1;
        i = 0;
        paramInt2 = 0;
        bool1 = false;
      }
    }
  }
  
  public void onRowDeleted(int... paramVarArgs)
  {
    onChanged();
  }
  
  public void onRowInserted(int paramInt1, int paramInt2)
  {
    int k;
    int n;
    int i1;
    int i;
    label279:
    int j;
    int m;
    label421:
    label459:
    label473:
    Object localObject;
    if (this.this$0.mItemCount > 0)
    {
      System.nanoTime();
      if (paramInt2 < paramInt1) {
        throw new IllegalArgumentException("lastRow must more than firstRow!");
      }
      if ((paramInt1 < 0) || (paramInt1 > this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount())) {
        throw new IllegalArgumentException("row index out of bound");
      }
      if ((this.this$0.mNeedSync) || (this.this$0.mDataChanged)) {
        onChanged();
      }
      int i2;
      label659:
      label665:
      do
      {
        do
        {
          return;
        } while (this.this$0.mItemCount == 0);
        k = paramInt1 + this.this$0.getHeaderViewsCount();
        paramInt2 += this.this$0.getHeaderViewsCount();
        n = paramInt2 - k + 1;
        int i3 = this.this$0.getChildCount();
        i1 = this.this$0.mFirstPosition;
        i2 = this.this$0.mFirstPosition + i3 - 1;
        if (k == this.this$0.mItemCount)
        {
          paramInt1 = 1;
          if (this.this$0.mFastScroller != null) {
            this.this$0.mFastScroller.a(this.this$0.mItemCount, this.this$0.mItemCount - n);
          }
          this.this$0.mItemCount += n;
          if (this.this$0.mSelectedPosition < 0) {
            break label421;
          }
          i = calcNewPositionAdd(this.this$0.mSelectedPosition, k, paramInt2, i1, i2);
          this.this$0.setSelectedPositionInt(i);
          this.this$0.setNextSelectedPositionInt(i);
          if (this.this$0.mMotionPosition >= 0) {
            this.this$0.mMotionPosition = calcNewPositionAdd(this.this$0.mMotionPosition, k, paramInt2, i1, i2);
          }
          if (this.this$0.mCheckStates != null) {
            break label459;
          }
        }
        for (i = 0;; i = this.this$0.mCheckStates.size())
        {
          if (i <= 0) {
            break label473;
          }
          j = 0;
          while (j < i)
          {
            m = this.this$0.mCheckStates.keyAt(j);
            boolean bool = this.this$0.mCheckStates.valueAt(j);
            if (m >= k)
            {
              this.this$0.mCheckStates.delete(m);
              this.this$0.mCheckStates.put(m + (paramInt2 - k + 1), bool);
            }
            j += 1;
          }
          paramInt1 = 0;
          break;
          if (this.this$0.mSelectorPosition < 0) {
            break label279;
          }
          this.this$0.mSelectedPosition = calcNewPositionAdd(this.this$0.mSelectorPosition, k, paramInt2, i1, i2);
          break label279;
        }
        if (ListView.access$300(this.this$0) != null)
        {
          i = 0;
          while (i < ListView.access$300(this.this$0).length)
          {
            j = ListView.access$300(this.this$0)[i];
            if (j >= k) {
              ListView.access$300(this.this$0)[i] = (j + (paramInt2 - k + 1));
            }
            i += 1;
          }
        }
        m = ListView.access$400(this.this$0) - ListView.access$500(this.this$0) - this.this$0.mListPadding.bottom;
        localObject = this.this$0.getChildAt(i3 - 1);
        if (localObject == null)
        {
          i = 0;
          if ((this.this$0.getTranscriptMode() != 1) || (paramInt1 == 0) || (i > m)) {
            break label659;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((k > i1) || (j != 0) || (i < m)) {
            break label665;
          }
          localObject = this.this$0;
          ((ListView)localObject).mFirstPosition += n;
          return;
          i = ((View)localObject).getBottom();
          break;
        }
      } while ((k > i2) && (j == 0) && (i >= m));
      n = this.this$0.mListPadding.top;
      if (this.this$0.mSelectedPosition >= 0)
      {
        paramInt1 = this.this$0.mSelectedPosition;
        i1 = k - i1;
        if (j == 0) {
          break label943;
        }
        paramInt1 = 0;
        i = m;
        label730:
        if (paramInt2 < k) {
          break label1653;
        }
        if (i >= n) {
          break label820;
        }
        paramInt2 += 1;
      }
    }
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= i1 - 1)
          {
            this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
            paramInt1 += 1;
            continue;
            if (this.this$0.shouldShowSelector())
            {
              paramInt1 = this.this$0.mSelectorPosition;
              break;
            }
            paramInt1 = -1;
            break;
            label820:
            localObject = this.this$0.obtainView(paramInt2, this.this$0.mIsScrap);
            ListView.access$600(this.this$0, (View)localObject, paramInt2, i, false, this.this$0.mListPadding.left, false, this.this$0.mIsScrap[0], i1);
            j = ((View)localObject).getHeight() + this.this$0.mDividerHeight;
            i -= j;
            paramInt2 -= 1;
            paramInt1 = j + paramInt1;
            break label730;
          }
        }
        ListView.access$700(this.this$0, 0, i1);
        this.this$0.mFirstPosition = paramInt2;
      }
      for (;;)
      {
        ListView.access$1000(this.this$0);
        return;
        offsetTop(n, i1 - 1, paramInt1);
        continue;
        label943:
        if (((paramInt1 < 0) || (paramInt1 >= k)) && ((paramInt1 >= 0) || (this.this$0.mStackFromBottom))) {
          break label1227;
        }
        i = 0;
        n = -1;
        if (i1 <= 0) {
          break;
        }
        paramInt1 = this.this$0.getChildAt(i1 - 1).getBottom() + this.this$0.mDividerHeight;
        j = k;
        k = paramInt1;
        for (;;)
        {
          paramInt1 = n;
          if (j <= paramInt2)
          {
            if (k > m) {
              paramInt1 = j - this.this$0.mFirstPosition;
            }
          }
          else
          {
            j = this.this$0.getChildCount();
            if (paramInt1 < 0) {
              break label1199;
            }
            paramInt2 = paramInt1;
            while (paramInt2 < j)
            {
              this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt2), this.this$0.mFirstPosition + paramInt2);
              paramInt2 += 1;
            }
          }
          localObject = this.this$0.obtainView(j, this.this$0.mIsScrap);
          ListView.access$600(this.this$0, (View)localObject, j, k, true, this.this$0.mListPadding.left, false, this.this$0.mIsScrap[0], j - this.this$0.mFirstPosition);
          paramInt1 = ((View)localObject).getHeight() + this.this$0.mDividerHeight;
          k += paramInt1;
          i += paramInt1;
          j += 1;
        }
        ListView.access$800(this.this$0, paramInt1, j - paramInt1);
        continue;
        label1199:
        offsetBottom(this.this$0.getChildCount(), m, paramInt2 - this.this$0.mFirstPosition + 1, i);
      }
      label1227:
      if (m > i) {
        this.this$0.offsetChildrenTopAndBottom(m - i);
      }
      i = this.this$0.getChildAt(i1).getTop() - this.this$0.mDividerHeight;
      paramInt1 = 0;
      if (paramInt2 >= k) {
        if (i < n) {
          paramInt2 += 1;
        }
      }
      for (;;)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 <= i1 - 1)
            {
              this.this$0.mRecycler.addScrapView(this.this$0.getChildAt(paramInt1), this.this$0.mFirstPosition + paramInt1);
              paramInt1 += 1;
              continue;
              localObject = this.this$0.obtainView(paramInt2, this.this$0.mIsScrap);
              ListView.access$600(this.this$0, (View)localObject, paramInt2, i, false, this.this$0.mListPadding.left, false, this.this$0.mIsScrap[0], i1);
              j = ((View)localObject).getHeight() + this.this$0.mDividerHeight;
              i -= j;
              paramInt2 -= 1;
              paramInt1 = j + paramInt1;
              break;
            }
          }
          ListView.access$900(this.this$0, 0, i1);
          this.this$0.mFirstPosition = paramInt2;
          break;
        }
        offsetTop(n, i1 - 1, paramInt1);
        break;
        if (ListView.access$300(this.this$0) == null)
        {
          localObject = new int[paramInt2 - paramInt1 + 1];
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          while (i <= paramInt2)
          {
            localObject[paramInt1] = i;
            i += 1;
            paramInt1 += 1;
          }
          ListView.access$302(this.this$0, (int[])localObject);
        }
        for (;;)
        {
          onChanged();
          return;
          localObject = new HashSet();
          while (paramInt1 <= paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(paramInt1));
            paramInt1 += 1;
          }
          int[] arrayOfInt = ListView.access$300(this.this$0);
          paramInt2 = arrayOfInt.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(arrayOfInt[paramInt1]));
            paramInt1 += 1;
          }
          arrayOfInt = new int[((HashSet)localObject).size()];
          localObject = ((HashSet)localObject).iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            arrayOfInt[paramInt1] = ((Integer)((Iterator)localObject).next()).intValue();
            paramInt1 += 1;
          }
          ListView.access$302(this.this$0, arrayOfInt);
        }
        paramInt2 = -1;
      }
      label1653:
      paramInt2 = -1;
    }
  }
  
  public void onRowUpdated(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < this.this$0.getHeaderViewsCount()) || (paramInt2 >= this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount())) {
      throw new IllegalArgumentException("row index out of bound. insert range: " + paramInt1 + "~" + paramInt2 + ". valid range: " + this.this$0.getHeaderViewsCount() + "~" + (this.this$0.mItemCount - this.this$0.getHeaderViewsCount() - this.this$0.getFooterViewsCount()));
    }
    if ((this.this$0.mNeedSync) || (this.this$0.mDataChanged)) {
      onChanged();
    }
    int n;
    int i1;
    int j;
    int i;
    do
    {
      do
      {
        return;
      } while (this.this$0.mItemCount == 0);
      n = paramInt1 + this.this$0.getHeaderViewsCount();
      i1 = paramInt2 + this.this$0.getHeaderViewsCount();
      j = this.this$0.getChildCount();
      paramInt1 = this.this$0.mFirstPosition;
      i = this.this$0.mFirstPosition + j - 1;
    } while ((i1 < paramInt1) || (n > i));
    int k = this.this$0.mListPadding.top;
    int m = ListView.access$1700(this.this$0) - ListView.access$1800(this.this$0) - this.this$0.mListPadding.bottom;
    if (n < paramInt1)
    {
      paramInt2 = 0;
      if (i1 <= i) {
        break label392;
      }
      i = j - 1;
      label297:
      if (this.this$0.mSelectedPosition < 0) {
        break label400;
      }
      paramInt1 = this.this$0.mSelectedPosition;
      label315:
      if (((paramInt1 < 0) || (paramInt1 > n)) && ((paramInt1 >= 0) || (this.this$0.mStackFromBottom))) {
        break label426;
      }
      paramInt1 = updateAfter(j, m, paramInt2, i);
      ListView.access$1900(this.this$0, this.this$0.getChildCount());
      offsetBottom(j, m, i + 1, paramInt1);
    }
    for (;;)
    {
      ListView.access$1000(this.this$0);
      return;
      paramInt2 = n - paramInt1;
      break;
      label392:
      i = i1 - paramInt1;
      break label297;
      label400:
      if (this.this$0.shouldShowSelector())
      {
        paramInt1 = this.this$0.mSelectorPosition;
        break label315;
      }
      paramInt1 = -1;
      break label315;
      label426:
      if ((paramInt1 >= i1) || ((paramInt1 < 0) && (this.this$0.mStackFromBottom)))
      {
        paramInt1 = updateBefore(k, paramInt2, i);
        ListView.access$2000(this.this$0, this.this$0.getChildCount());
        offsetTop(k, paramInt2 - 1, paramInt1);
      }
      else
      {
        paramInt1 -= this.this$0.mFirstPosition;
        offsetBottom(j, m, i + 1, updateAfter(j, m, paramInt1, i));
        offsetTop(k, paramInt2 - 1, updateBefore(k, paramInt2, paramInt1 - 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.ListView.ListDataSetObserver
 * JD-Core Version:    0.7.0.1
 */