package com.tencent.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;

class AbsListView$PositionScroller
  implements Runnable
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;
  private int g;
  
  AbsListView$PositionScroller(AbsListView paramAbsListView)
  {
    this.f = ViewConfiguration.get(paramAbsListView.getContext()).getScaledFadingEdgeLength();
  }
  
  void a()
  {
    this.this$0.removeCallbacks(this);
    if (AbsListView.access$1900(this.this$0) != null) {
      AbsListView.access$1900(this.this$0).b();
    }
  }
  
  void a(int paramInt)
  {
    a();
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount() + i - 1;
    if (paramInt <= i)
    {
      i = i - paramInt + 1;
      this.a = 2;
      if (i <= 0) {
        break label126;
      }
    }
    label126:
    for (this.e = (400 / i);; this.e = 400)
    {
      this.b = paramInt;
      this.c = -1;
      this.d = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label136;
      }
      this.this$0.postOnAnimation(this);
      do
      {
        return;
        if (paramInt >= j)
        {
          i = paramInt - j + 1;
          this.a = 1;
          break;
        }
      } while (!AbsListView.access$3000(this.this$0));
      i = paramInt - i;
      this.a = 1;
      break;
    }
    label136:
    this.this$0.post(this);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a();
    if (paramInt2 == -1) {
      a(paramInt1);
    }
    int j;
    do
    {
      return;
      i = this.this$0.mFirstPosition;
      j = this.this$0.getChildCount() + i - 1;
      if (paramInt1 > i) {
        break;
      }
      j -= paramInt2;
    } while (j < 1);
    int i = i - paramInt1 + 1;
    j -= 1;
    if (j < i)
    {
      this.a = 4;
      i = j;
      label79:
      if (i <= 0) {
        break label187;
      }
    }
    label185:
    label187:
    for (this.e = (400 / i);; this.e = 400)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label197;
      }
      this.this$0.postOnAnimation(this);
      return;
      for (this.a = 2;; this.a = 1)
      {
        break label79;
        if (paramInt1 < j) {
          break label185;
        }
        int k = paramInt2 - i;
        if (k < 1) {
          break;
        }
        i = paramInt1 - j + 1;
        j = k - 1;
        if (j < i)
        {
          this.a = 3;
          i = j;
          break label79;
        }
      }
      break;
    }
    label197:
    this.this$0.post(this);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.b = paramInt1;
    this.g = paramInt2;
    this.c = -1;
    this.d = -1;
    this.a = 5;
    int j = this.this$0.mFirstPosition;
    int i = this.this$0.getChildCount();
    int k = j + i - 1;
    if (paramInt1 < j) {
      paramInt1 = j - paramInt1;
    }
    for (;;)
    {
      float f1 = paramInt1 / i;
      this.e = ((int)(paramInt3 / f1));
      this.d = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label148;
      }
      this.this$0.postOnAnimation(this);
      return;
      if (paramInt1 <= k) {
        break;
      }
      paramInt1 -= k;
    }
    paramInt1 = this.this$0.getChildAt(paramInt1 - j).getTop();
    this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
    return;
    label148:
    this.this$0.post(this);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 400);
  }
  
  public void run()
  {
    int i = 0;
    int j = 0;
    int m = this.this$0.getHeight();
    int k = this.this$0.mFirstPosition;
    switch (this.a)
    {
    default: 
    case 1: 
    case 3: 
    case 2: 
    case 4: 
      label944:
      do
      {
        do
        {
          do
          {
            int i1;
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
                      do
                      {
                        return;
                        i = this.this$0.getChildCount() - 1;
                        n = k + i;
                      } while (i < 0);
                      if ((!AbsListView.access$3000(this.this$0)) && (n == this.d))
                      {
                        if (Build.VERSION.SDK_INT >= 16)
                        {
                          this.this$0.postOnAnimation(this);
                          return;
                        }
                        this.this$0.post(this);
                        return;
                      }
                      if ((!AbsListView.access$3000(this.this$0)) || (n < this.b) || (k > this.b)) {
                        break;
                      }
                      i = this.b;
                      i = this.this$0.getChildAt(i - k).getTop();
                      this.this$0.smoothScrollBy(i, 200);
                    } while (!QLog.isColorLevel());
                    QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.b);
                    return;
                    localView = this.this$0.getChildAt(i);
                    k = localView.getHeight();
                    i1 = localView.getTop();
                    int i2 = this.this$0.mListPadding.bottom;
                    i = j;
                    if (n < this.b)
                    {
                      i = j;
                      if (n < this.this$0.mItemCount - 1) {
                        i = this.f;
                      }
                    }
                    this.this$0.smoothScrollBy(i + (k - (m - i1 - i2)), this.e);
                    this.d = n;
                  } while (n >= this.b);
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                  i = this.this$0.getChildCount();
                } while ((k == this.c) || (i <= 1) || (i + k >= this.this$0.mItemCount));
                i = k + 1;
                if (i == this.d)
                {
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                }
                localView = this.this$0.getChildAt(1);
                j = localView.getHeight();
                k = localView.getTop();
                m = this.f;
                if (i < this.c)
                {
                  this.this$0.smoothScrollBy(Math.max(0, k + j - m), this.e);
                  this.d = i;
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                }
              } while (k <= m);
              this.this$0.smoothScrollBy(k - m, this.e);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("XListView", 2, new Object[] { " MOVE_UP_POS:firstPos=", Integer.valueOf(k), " mLastSeenPos=", Integer.valueOf(this.d), " mTargetPos", Integer.valueOf(this.b) });
              }
            } while ((k == this.d) && (k <= this.b));
            if ((AbsListView.access$3000(this.this$0)) && (this.b == 0))
            {
              m = this.this$0.getChildCount();
              if ((this.this$0.mItemCount > 30) && (k + m - 1 > m * 3 - 1))
              {
                j = this.e * m / 2;
                i = j;
                if (j < 30) {
                  i = 30;
                }
                j = this.this$0.getHeight();
                n = this.this$0.mListPadding.top;
                i1 = this.this$0.mListPadding.bottom;
                this.this$0.smoothScrollBy(-(j - n - i1), i);
                if (QLog.isColorLevel()) {
                  QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.b + ",duration = " + i + ",childCount " + m);
                }
                this.d = k;
                if (Build.VERSION.SDK_INT >= 16)
                {
                  this.this$0.postOnAnimation(this);
                  return;
                }
                this.this$0.post(this);
                return;
              }
            }
            localView = this.this$0.getChildAt(0);
          } while (localView == null);
          j = localView.getTop();
          if (k > 0) {}
          for (i = this.f;; i = this.this$0.mListPadding.top)
          {
            this.this$0.smoothScrollBy(j - i, this.e);
            this.d = k;
            if (k <= this.b) {
              break;
            }
            if (Build.VERSION.SDK_INT < 16) {
              break label944;
            }
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
          j = this.this$0.getChildCount() - 2;
        } while (j < 0);
        i = k + j;
        if (i == this.d)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
        }
        View localView = this.this$0.getChildAt(j);
        j = localView.getHeight();
        k = localView.getTop();
        this.d = i;
        if (i > this.c)
        {
          this.this$0.smoothScrollBy(-(m - k - this.f), this.e);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
        }
        i = m - this.f;
        j = k + j;
      } while (i <= j);
      this.this$0.smoothScrollBy(-(i - j), this.e);
      return;
    }
    if (this.d == k)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.d = k;
    j = this.this$0.getChildCount();
    m = this.b;
    int n = k + j - 1;
    if (m < k) {
      i = k - m + 1;
    }
    float f1;
    for (;;)
    {
      f1 = Math.min(Math.abs(i / j), 1.0F);
      if (m >= k) {
        break label1292;
      }
      this.this$0.smoothScrollBy((int)(f1 * -this.this$0.getHeight()), this.e);
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
      if (m > n) {
        i = m - n;
      }
    }
    this.this$0.post(this);
    return;
    label1292:
    if (m > n)
    {
      this.this$0.smoothScrollBy((int)(f1 * this.this$0.getHeight()), this.e);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    i = this.this$0.getChildAt(m - k).getTop() - this.g;
    j = Math.abs((int)(this.e * (i / this.this$0.getHeight())));
    this.this$0.smoothScrollBy(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */