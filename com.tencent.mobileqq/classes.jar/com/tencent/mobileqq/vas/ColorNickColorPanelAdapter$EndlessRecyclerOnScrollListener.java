package com.tencent.mobileqq.vas;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public abstract class ColorNickColorPanelAdapter$EndlessRecyclerOnScrollListener
  extends RecyclerView.OnScrollListener
{
  private boolean a = false;
  
  public abstract void a();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      paramInt = localGridLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((((ColorNickColorPanelAdapter)paramRecyclerView.getAdapter()).a(paramInt).a == 4) && (this.a)) {
        a();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.EndlessRecyclerOnScrollListener
 * JD-Core Version:    0.7.0.1
 */