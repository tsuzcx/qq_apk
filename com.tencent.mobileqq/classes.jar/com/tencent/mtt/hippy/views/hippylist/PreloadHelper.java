package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class PreloadHelper
  extends RecyclerView.OnScrollListener
{
  protected HippyRecyclerView hippyRecyclerView;
  protected boolean isPreloading;
  protected int preloadItemNumber;
  
  public PreloadHelper(HippyRecyclerView paramHippyRecyclerView)
  {
    this.hippyRecyclerView = paramHippyRecyclerView;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramInt1 = paramRecyclerView.getAdapter().getItemCount();
    if (this.isPreloading) {
      return;
    }
    if ((this.hippyRecyclerView.getAdapter().getRenderNodeCount() > 0) && (paramRecyclerView.getChildAdapterPosition(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1)) + this.preloadItemNumber >= paramInt1))
    {
      this.isPreloading = true;
      sendReachEndEvent(paramRecyclerView);
    }
  }
  
  public void reset()
  {
    this.isPreloading = false;
  }
  
  public void sendReachEndEvent(RecyclerView paramRecyclerView)
  {
    new HippyViewEvent("onLoadMore").send((View)paramRecyclerView.getParent(), null);
  }
  
  public void setPreloadItemNumber(int paramInt)
  {
    this.preloadItemNumber = paramInt;
    this.hippyRecyclerView.removeOnScrollListener(this);
    if (paramInt > 0) {
      this.hippyRecyclerView.addOnScrollListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.PreloadHelper
 * JD-Core Version:    0.7.0.1
 */