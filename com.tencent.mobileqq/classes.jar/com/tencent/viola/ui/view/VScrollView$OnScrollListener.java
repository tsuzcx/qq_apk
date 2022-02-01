package com.tencent.viola.ui.view;

import android.widget.ScrollView;

public abstract interface VScrollView$OnScrollListener
{
  public static final int SCROLL_STATE_FLING = 2;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
  
  public abstract void onScroll(int paramInt1, int paramInt2);
  
  public abstract void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VScrollView.OnScrollListener
 * JD-Core Version:    0.7.0.1
 */