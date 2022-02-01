package com.tencent.viola.ui.view.overscroll;

import android.support.v7.widget.RecyclerView;

public class RecyclerViewOverScrollDecorAdapter$ImplHorizLayout
  implements RecyclerViewOverScrollDecorAdapter.Impl
{
  protected RecyclerViewOverScrollDecorAdapter$ImplHorizLayout(RecyclerViewOverScrollDecorAdapter paramRecyclerViewOverScrollDecorAdapter) {}
  
  public boolean isInAbsoluteEnd()
  {
    return !this.this$0.mRecyclerView.canScrollHorizontally(1);
  }
  
  public boolean isInAbsoluteStart()
  {
    return !this.this$0.mRecyclerView.canScrollHorizontally(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.RecyclerViewOverScrollDecorAdapter.ImplHorizLayout
 * JD-Core Version:    0.7.0.1
 */