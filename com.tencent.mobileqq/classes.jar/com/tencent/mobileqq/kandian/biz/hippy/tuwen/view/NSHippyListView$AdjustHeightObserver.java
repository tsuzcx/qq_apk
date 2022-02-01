package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NSHippyListView$AdjustHeightObserver
  extends RecyclerViewBase.AdapterDataObserver
{
  private int maxHeight;
  private final Runnable runnable = new NSHippyListView.AdjustHeightRunnable(this);
  
  private NSHippyListView$AdjustHeightObserver(NSHippyListView paramNSHippyListView) {}
  
  private void doAdjustHeightActual(@NonNull HippyRootLayout paramHippyRootLayout, @NonNull HippyTKDListViewAdapter paramHippyTKDListViewAdapter)
  {
    int j = paramHippyTKDListViewAdapter.getListTotalHeight();
    paramHippyTKDListViewAdapter = new StringBuilder();
    paramHippyTKDListViewAdapter.append("AdjustHeightObserver#doAdjustHeightActual: itemsHeight = ");
    paramHippyTKDListViewAdapter.append(j);
    QLog.d("NSHippyListView", 1, paramHippyTKDListViewAdapter.toString());
    int k = this.maxHeight;
    int i = j;
    if (j >= k) {
      i = k;
    }
    paramHippyRootLayout.setLoadedHeight(i);
  }
  
  private void ensureParentHeight()
  {
    if (this.maxHeight == 0)
    {
      Object localObject = (View)this.this$0.hippyRootLayout.getParent();
      if (localObject != null)
      {
        QLog.d("NSHippyListView", 1, "AdjustHeightObserver#ensureParentHeight: hippyRootLayout has parent");
        this.maxHeight = ((View)localObject).getHeight();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AdjustHeightObserver#ensureParentHeight: hippyRootLayout doesn't have parent, hippyRootLayout=");
      ((StringBuilder)localObject).append(this.this$0.hippyRootLayout);
      QLog.d("NSHippyListView", 1, ((StringBuilder)localObject).toString());
      this.maxHeight = this.this$0.hippyRootLayout.getMaxHeight();
    }
  }
  
  void adjustHeight()
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#adjustHeight: begin");
    this.this$0.ensureHippyRootLayout();
    if (this.this$0.hippyRootLayout == null)
    {
      QLog.d("NSHippyListView", 1, "AdjustHeightObserver#adjustHeight: hippyRootLayout is null");
      return;
    }
    ensureParentHeight();
    if (this.maxHeight <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AdjustHeightObserver#adjustHeight: maxHeight=");
      localStringBuilder.append(this.maxHeight);
      QLog.d("NSHippyListView", 1, localStringBuilder.toString());
      return;
    }
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#adjustHeight: post");
    this.this$0.removeCallbacks(this.runnable);
    this.this$0.post(this.runnable);
  }
  
  void doAdjustHeight()
  {
    if (this.this$0.hippyRootLayout == null)
    {
      QLog.d("NSHippyListView", 1, "AdjustHeightObserver#doAdjustHeight: hippyRootLayout is null");
      return;
    }
    HippyTKDListViewAdapter localHippyTKDListViewAdapter = (HippyTKDListViewAdapter)this.this$0.getAdapter();
    if (localHippyTKDListViewAdapter == null)
    {
      QLog.d("NSHippyListView", 1, "AdjustHeightObserver#doAdjustHeight: adapter is null");
      return;
    }
    int i = localHippyTKDListViewAdapter.getItemCount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdjustHeightObserver#doAdjustHeight: adapter item count=");
    localStringBuilder.append(i);
    QLog.d("NSHippyListView", 1, localStringBuilder.toString());
    if (i > 0) {
      doAdjustHeightActual(this.this$0.hippyRootLayout, localHippyTKDListViewAdapter);
    }
  }
  
  public void onChanged()
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#onChanged");
    adjustHeight();
  }
  
  void onDetach()
  {
    this.maxHeight = 0;
    this.this$0.removeCallbacks(this.runnable);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#onItemRangeChanged");
    adjustHeight();
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#onItemRangeInserted");
    adjustHeight();
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#onItemRangeRemoved");
    adjustHeight();
  }
  
  public void onItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    QLog.d("NSHippyListView", 1, "AdjustHeightObserver#onItemsRemoved");
    adjustHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView.AdjustHeightObserver
 * JD-Core Version:    0.7.0.1
 */