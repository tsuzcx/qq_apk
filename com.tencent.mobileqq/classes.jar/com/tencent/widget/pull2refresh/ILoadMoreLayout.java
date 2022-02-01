package com.tencent.widget.pull2refresh;

import android.view.View.OnClickListener;

public abstract interface ILoadMoreLayout
{
  public abstract boolean checkState(int paramInt);
  
  public abstract int getState();
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract boolean setState(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.ILoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */