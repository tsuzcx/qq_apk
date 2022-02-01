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
      paramRecyclerView = StickyNoteShopLayout.a(this.a).getLayoutManager();
      int i = 0;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
      {
        int[] arrayOfInt = new int[((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount()];
        arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).findLastVisibleItemPositions(arrayOfInt);
        i = StickyNoteShopLayout.a(this.a, arrayOfInt);
      }
      if ((paramRecyclerView.getChildCount() > 0) && (i >= paramRecyclerView.getItemCount() - 1))
      {
        this.a.a(true);
        QLog.d("StickyNoteShopLayout", 2, " load more shop data newState:" + paramInt + " lastVisiblePosition:" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.3
 * JD-Core Version:    0.7.0.1
 */