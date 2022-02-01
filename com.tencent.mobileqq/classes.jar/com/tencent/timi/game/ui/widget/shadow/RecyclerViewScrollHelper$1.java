package com.tencent.timi.game.ui.widget.shadow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import org.jetbrains.annotations.NotNull;

class RecyclerViewScrollHelper$1
  extends RecyclerView.OnScrollListener
{
  RecyclerViewScrollHelper$1(RecyclerViewScrollHelper paramRecyclerViewScrollHelper) {}
  
  public void onScrollStateChanged(@NotNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(@NotNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramInt1 = paramRecyclerView.getAdapter().getItemCount();
    paramRecyclerView = RecyclerViewScrollHelper.a(this.a, paramRecyclerView);
    if (paramRecyclerView == null) {
      return;
    }
    if (paramRecyclerView.findFirstCompletelyVisibleItemPosition() == 0) {
      RecyclerViewScrollHelper.a(this.a).c();
    } else {
      RecyclerViewScrollHelper.a(this.a).d();
    }
    if (paramRecyclerView.findLastCompletelyVisibleItemPosition() == paramInt1 - 1)
    {
      RecyclerViewScrollHelper.a(this.a).a();
      return;
    }
    RecyclerViewScrollHelper.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.RecyclerViewScrollHelper.1
 * JD-Core Version:    0.7.0.1
 */