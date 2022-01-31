package com.tencent.viola.ui.view.overscroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class RecyclerViewOverScrollDecorAdapter
  implements AbsOverScrollDecorator.IOverScrollDecoratorAdapter
{
  protected final RecyclerViewOverScrollDecorAdapter.Impl mImpl;
  protected boolean mIsItemTouchInEffect = false;
  protected final RecyclerView mRecyclerView;
  
  public RecyclerViewOverScrollDecorAdapter(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (((paramRecyclerView instanceof LinearLayoutManager)) || ((paramRecyclerView instanceof StaggeredGridLayoutManager)))
    {
      if ((paramRecyclerView instanceof LinearLayoutManager)) {}
      for (int i = ((LinearLayoutManager)paramRecyclerView).getOrientation(); i == 0; i = ((StaggeredGridLayoutManager)paramRecyclerView).getOrientation())
      {
        this.mImpl = new RecyclerViewOverScrollDecorAdapter.ImplHorizLayout(this);
        return;
      }
      this.mImpl = new RecyclerViewOverScrollDecorAdapter.ImplVerticalLayout(this);
      return;
    }
    throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
  }
  
  public View getView()
  {
    return this.mRecyclerView;
  }
  
  public boolean isInAbsoluteEnd()
  {
    return (!this.mIsItemTouchInEffect) && (this.mImpl.isInAbsoluteEnd());
  }
  
  public boolean isInAbsoluteStart()
  {
    return this.mImpl.isInAbsoluteStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.RecyclerViewOverScrollDecorAdapter
 * JD-Core Version:    0.7.0.1
 */