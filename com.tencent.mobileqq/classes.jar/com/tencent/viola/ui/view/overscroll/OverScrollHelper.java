package com.tencent.viola.ui.view.overscroll;

import android.support.v7.widget.RecyclerView;

public class OverScrollHelper
{
  public static final int ORIENTATION_HORIZONTAL = 1;
  
  public static void setUpOverScroll(RecyclerView paramRecyclerView, int paramInt, OverScrollHelper.OverScrollListener paramOverScrollListener)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    new HorizontalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(paramRecyclerView), paramOverScrollListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.OverScrollHelper
 * JD-Core Version:    0.7.0.1
 */