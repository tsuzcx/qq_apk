package com.tencent.widget.pull2refresh;

public abstract interface XRecyclerView$RefreshCallback
{
  public abstract void endOfRefresh();
  
  public abstract void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt);
  
  public abstract void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
 * JD-Core Version:    0.7.0.1
 */