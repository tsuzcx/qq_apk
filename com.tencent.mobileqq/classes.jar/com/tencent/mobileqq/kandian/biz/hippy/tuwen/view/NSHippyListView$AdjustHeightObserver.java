package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NSHippyListView$AdjustHeightObserver
  extends RecyclerViewBase.AdapterDataObserver
{
  private final Handler handler = new Handler(Looper.getMainLooper());
  private int maxHeight;
  private final Runnable runnable = new NSHippyListView.AdjustHeightRunnable(this);
  
  private NSHippyListView$AdjustHeightObserver(NSHippyListView paramNSHippyListView) {}
  
  private void adjustHeight()
  {
    this.this$0.ensureHippyRootLayout();
    if (this.this$0.hippyRootLayout == null)
    {
      QLog.d("NSHippyListView", 1, "hippyRootLayout is null");
      return;
    }
    ensureParentHeight();
    if (this.maxHeight <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("maxHeight=");
      localStringBuilder.append(this.maxHeight);
      localStringBuilder.append(", require >=0");
      QLog.d("NSHippyListView", 1, localStringBuilder.toString());
      return;
    }
    this.handler.removeCallbacks(this.runnable);
    this.handler.post(this.runnable);
  }
  
  private void ensureParentHeight()
  {
    if (this.maxHeight == 0)
    {
      View localView = (View)this.this$0.hippyRootLayout.getParent();
      if (localView != null)
      {
        this.maxHeight = localView.getHeight();
        return;
      }
      this.maxHeight = this.this$0.hippyRootLayout.getMaxHeight();
    }
  }
  
  void doAdjustHeight()
  {
    Object localObject = (HippyTKDListViewAdapter)this.this$0.getAdapter();
    if (localObject == null)
    {
      QLog.d("NSHippyListView", 1, "adapter is null");
      return;
    }
    int i = ((HippyTKDListViewAdapter)localObject).getItemCount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adapter item count=");
    localStringBuilder.append(i);
    QLog.d("NSHippyListView", 1, localStringBuilder.toString());
    if (i > 0)
    {
      int j = ((HippyTKDListViewAdapter)localObject).getListTotalHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("itemsHeight = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("NSHippyListView", 1, ((StringBuilder)localObject).toString());
      int k = this.maxHeight;
      i = j;
      if (j >= k) {
        i = k;
      }
      this.this$0.hippyRootLayout.setLoadedHeight(i);
    }
  }
  
  public void onChanged()
  {
    adjustHeight();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    adjustHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView.AdjustHeightObserver
 * JD-Core Version:    0.7.0.1
 */