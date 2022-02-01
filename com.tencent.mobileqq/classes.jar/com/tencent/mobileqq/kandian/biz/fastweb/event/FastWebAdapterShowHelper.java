package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;

public class FastWebAdapterShowHelper
{
  private int a = -1;
  private int b = -1;
  
  public FastWebAdapterShowHelper(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    a(paramAbsListView, paramInt1, new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, Pair<Integer, Integer> paramPair)
  {
    paramInt = ((Integer)paramPair.first).intValue() - paramInt;
    int i = ((Integer)paramPair.second).intValue() - ((Integer)paramPair.first).intValue() + paramInt;
    if (i > paramAbsListView.getChildCount()) {
      return;
    }
    while (paramInt <= i)
    {
      paramPair = paramAbsListView.getChildAt(paramInt);
      if ((paramPair != null) && ((paramPair.getTag() instanceof BaseItemViewHolder))) {
        ((BaseItemViewHolder)paramPair.getTag()).b();
      }
      paramInt += 1;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 + paramInt1 - 1;
    if ((paramInt1 >= this.a) && (paramInt2 <= this.b)) {
      return;
    }
    int i = this.a;
    Object localObject3 = null;
    Object localObject2;
    if (paramInt1 < i)
    {
      if (paramInt2 >= this.b)
      {
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(i - 1));
      }
      else
      {
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.a = paramInt1;
      }
      this.b = paramInt2;
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = null;
    }
    i = this.b;
    Object localObject1 = localObject3;
    if (paramInt2 > i)
    {
      if (paramInt1 <= this.a)
      {
        localObject1 = new Pair(Integer.valueOf(i + 1), Integer.valueOf(paramInt2));
      }
      else
      {
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.a = paramInt1;
      }
      this.b = paramInt2;
    }
    if (paramAbsListView == null) {
      return;
    }
    if (localObject2 != null) {
      a(paramAbsListView, paramInt1, localObject2);
    }
    if (localObject1 != null) {
      a(paramAbsListView, paramInt1, (Pair)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.FastWebAdapterShowHelper
 * JD-Core Version:    0.7.0.1
 */