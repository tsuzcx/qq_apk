package com.tencent.mobileqq.profile.stickynote.vas;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;

class StickyNoteShopLayout$3
  extends RecyclerView.OnScrollListener
{
  StickyNoteShopLayout$3(StickyNoteShopLayout paramStickyNoteShopLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramRecyclerView = StickyNoteShopLayout.c(this.a).getLayoutManager();
      int i = 0;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
      {
        Object localObject = (StaggeredGridLayoutManager)paramRecyclerView;
        localObject = ((StaggeredGridLayoutManager)localObject).findLastVisibleItemPositions(new int[((StaggeredGridLayoutManager)localObject).getSpanCount()]);
        i = StickyNoteShopLayout.a(this.a, (int[])localObject);
      }
      if ((paramRecyclerView.getChildCount() > 0) && (i >= paramRecyclerView.getItemCount() - 1))
      {
        this.a.a(true);
        paramRecyclerView = new StringBuilder();
        paramRecyclerView.append(" load more shop data newState:");
        paramRecyclerView.append(paramInt);
        paramRecyclerView.append(" lastVisiblePosition:");
        paramRecyclerView.append(i);
        QLog.d("StickyNoteShopLayout", 2, paramRecyclerView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.3
 * JD-Core Version:    0.7.0.1
 */