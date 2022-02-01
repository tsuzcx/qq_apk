package com.tencent.viola.ui.view.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.viola.utils.ViolaLogUtils;

class PagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onPagerDataChanged(int paramInt1, int paramInt2)
  {
    Object localObject = this.this$0;
    localObject = ((PagerSnapHelper)localObject).findCenterView(PagerSnapHelper.access$200((PagerSnapHelper)localObject));
    int i;
    if (localObject != null) {
      i = PagerSnapHelper.access$200(this.this$0).getPosition((View)localObject);
    } else {
      i = -1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPagerDataChanged: positionStart=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", itemCount=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", centerPosition=");
    ((StringBuilder)localObject).append(PagerSnapHelper.access$1200(this.this$0));
    ((StringBuilder)localObject).append(", currentPosition=");
    ((StringBuilder)localObject).append(i);
    ViolaLogUtils.d("PagerSnapHelper", ((StringBuilder)localObject).toString());
    if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
    {
      PagerSnapHelper.access$1300(this.this$0).addOnLayoutChangeListener(PagerSnapHelper.access$1900(this.this$0));
      PagerSnapHelper.access$1300(this.this$0).requestLayout();
    }
  }
  
  public void onChanged()
  {
    onPagerDataChanged(0, PagerSnapHelper.access$200(this.this$0).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$1200(this.this$0)) {
      PagerSnapHelper.access$1212(this.this$0, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == PagerSnapHelper.access$1200(this.this$0)) {
      PagerSnapHelper.access$1202(this.this$0, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$1200(this.this$0)) {
      PagerSnapHelper.access$1220(this.this$0, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */