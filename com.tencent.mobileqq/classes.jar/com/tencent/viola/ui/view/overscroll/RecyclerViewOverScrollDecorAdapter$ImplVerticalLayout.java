package com.tencent.viola.ui.view.overscroll;

import android.support.v7.widget.RecyclerView;

public class RecyclerViewOverScrollDecorAdapter$ImplVerticalLayout
  implements RecyclerViewOverScrollDecorAdapter.Impl
{
  protected RecyclerViewOverScrollDecorAdapter$ImplVerticalLayout(RecyclerViewOverScrollDecorAdapter paramRecyclerViewOverScrollDecorAdapter) {}
  
  public boolean isInAbsoluteEnd()
  {
    return this.this$0.mRecyclerView.canScrollVertically(1) ^ true;
  }
  
  public boolean isInAbsoluteStart()
  {
    return this.this$0.mRecyclerView.canScrollVertically(-1) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.RecyclerViewOverScrollDecorAdapter.ImplVerticalLayout
 * JD-Core Version:    0.7.0.1
 */