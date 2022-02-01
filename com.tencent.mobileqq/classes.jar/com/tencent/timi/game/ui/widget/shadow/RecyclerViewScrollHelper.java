package com.tencent.timi.game.ui.widget.shadow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewScrollHelper
{
  private RecyclerView a;
  private RecyclerViewScrollHelper.Callback b;
  
  private LinearLayoutManager a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof LinearLayoutManager)) {
      return (LinearLayoutManager)paramRecyclerView;
    }
    return null;
  }
  
  private void a()
  {
    this.a.addOnScrollListener(new RecyclerViewScrollHelper.1(this));
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerViewScrollHelper.Callback paramCallback)
  {
    this.a = paramRecyclerView;
    this.b = paramCallback;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.RecyclerViewScrollHelper
 * JD-Core Version:    0.7.0.1
 */