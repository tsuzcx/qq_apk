package com.tencent.widget.pull2refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.a;
    localObject = ((PagerSnapHelper)localObject).a(PagerSnapHelper.a((PagerSnapHelper)localObject));
    int i;
    if (localObject != null) {
      i = PagerSnapHelper.a(this.a).getPosition((View)localObject);
    } else {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPagerDataChanged: positionStart=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", itemCount=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", centerPosition=");
      ((StringBuilder)localObject).append(PagerSnapHelper.c(this.a));
      ((StringBuilder)localObject).append(", currentPosition=");
      ((StringBuilder)localObject).append(i);
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
    {
      PagerSnapHelper.OnLayoutChangedListenerImpl.a(PagerSnapHelper.a(this.a), paramBoolean);
      PagerSnapHelper.a(this.a).addOnLayoutChangeListener(PagerSnapHelper.a(this.a));
      PagerSnapHelper.a(this.a).requestLayout();
    }
  }
  
  public void onChanged()
  {
    a(0, PagerSnapHelper.a(this.a).getItemCount(), true);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.c(this.a))
    {
      PagerSnapHelper localPagerSnapHelper = this.a;
      PagerSnapHelper.c(localPagerSnapHelper, PagerSnapHelper.c(localPagerSnapHelper) + paramInt2);
    }
    a(paramInt1, paramInt2, false);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == PagerSnapHelper.c(this.a)) {
      PagerSnapHelper.c(this.a, paramInt2);
    }
    a(paramInt1, paramInt3, false);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.c(this.a))
    {
      PagerSnapHelper localPagerSnapHelper = this.a;
      PagerSnapHelper.c(localPagerSnapHelper, PagerSnapHelper.c(localPagerSnapHelper) - paramInt2);
    }
    a(paramInt1, paramInt2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */